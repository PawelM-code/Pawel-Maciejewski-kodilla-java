package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://pawelm-code.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

    public String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_TASK_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement webElementName = driver.findElement(By.xpath(XPATH_TASK_NAME));
        webElementName.sendKeys(taskName);

        WebElement webElementContent = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        webElementContent.sendKeys(taskContent);

        WebElement webElementButton = driver.findElement(By.xpath(XPATH_TASK_BUTTON));
        webElementButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTastTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement webElementSelect = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(webElementSelect);
                    select.selectByIndex(1);

                    WebElement webElementButtonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    webElementButtonCreateCard.click();
                });
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    private boolean checkTaskExistInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/";
        WebDriver webDriverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriverTrello.get(TRELLO_URL);
        boolean result;

        webDriverTrello.findElement(By.id("user")).sendKeys();
        webDriverTrello.findElement(By.id("password")).sendKeys();
        webDriverTrello.findElement(By.id("login")).submit();

        webDriverTrello.findElements(By.xpath("a[@class=\"board-title\"]")).stream()
                .filter(aHref->aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() >0)
                .forEach(WebElement::click);
        Thread.sleep(2000);

        result=webDriverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size()>0;

        webDriverTrello.close();

        return result;
    }

    private void deleteCrudAppTestTask(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement webElementButton = theForm.findElement(By.xpath(".//button[4]"));
                    webElementButton.click();
                });
        Thread.sleep(5000);
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTastTaskToTrello(taskName);
        deleteCrudAppTestTask(taskName);
        Assert.assertTrue(checkTaskExistInTrello(taskName));
    }
}
