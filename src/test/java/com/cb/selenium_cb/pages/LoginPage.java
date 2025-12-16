package com.cb.selenium_cb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By emailField = By.id("exampleInputEmail1");
    private By passwordField = By.id("exampleInputPassword1");
    private By loginButton = By.xpath("//*[@id='root']//button");
    private By errorMessage = By.xpath("/html/body/div/div/div[1]/section/div[2]/div/div[2]/div/div[2]/form/div[3]");  

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public By getErrorMessageLocator() {
        return errorMessage;
    }
}
