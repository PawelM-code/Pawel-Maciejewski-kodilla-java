package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CrudAppTestingApp {
    private static final String XPATH_INPUT = "//html/body/main/section/form/fieldset[1]/input";
    private static final String XPATH_TEXTAREA = "//html/body/main/section/form/fieldset[2]/textarea";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://pawelm-code.github.io/");

        WebElement taskNameField = driver.findElement(By.xpath(XPATH_INPUT));
        taskNameField.sendKeys("New robotic task");

        WebElement taskContentField = driver.findElement(By.xpath(XPATH_TEXTAREA));
        taskContentField.sendKeys("The robotic content");
    }
}
