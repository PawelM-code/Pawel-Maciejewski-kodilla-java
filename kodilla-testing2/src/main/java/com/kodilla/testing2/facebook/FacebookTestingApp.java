package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    private static final String XPATH_SELECT_DAY = "//div[contains(@class, \"5k_5\")]/span/span/select[1]";
    private static final String XPATH_SELECT_MONTH = "//div[contains(@class, \"5k_5\")]/span/span/select[2]";
    private static final String XPATH_SELECT_YEAR = "//div[contains(@class, \"5k_5\")]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select select1 = new Select(selectDay);
        select1.selectByIndex(8);

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select select2 = new Select(selectMonth);
        select2.selectByIndex(3);

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select select3 = new Select(selectYear);
        select3.selectByIndex(21);
    }
}
