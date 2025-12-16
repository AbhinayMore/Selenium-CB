package com.cb.selenium_cb.base;

import com.cb.selenium_cb.utils.ConfigReader;
import com.cb.selenium_cb.utils.logins;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    protected WebDriver driver;


    @BeforeEach
    public void setUp() {
        // Read from config.properties
        String chromeDriverPath = ConfigReader.getProperty("chromedriver.path");
        String baseUrl = ConfigReader.getProperty("base.url");

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open application
        driver.get(baseUrl);
    }

    protected void login(String key) {
    	logins l=new logins(key);
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
