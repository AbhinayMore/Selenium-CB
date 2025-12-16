package com.cb.selenium_cb.base;

import com.cb.selenium_cb.utils.ConfigReader;
import com.cb.selenium_cb.utils.logins;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait; // ✅ added wait object


    @BeforeEach
    public void setUp() {
        // Read from config.properties
        String chromeDriverPath = ConfigReader.getProperty("chromedriver.path");
        String baseUrl = ConfigReader.getProperty("base.url");

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ✅ Initialize explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
