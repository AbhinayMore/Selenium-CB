package com.cb.selenium_cb;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CbTest {


    @Test
    public void openGoogle() {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://cb.nellinfotech.com");

        System.out.println("Page Title is: " + driver.getTitle());

        driver.quit();
    }
}
