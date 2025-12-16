
package com.cb.selenium_cb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgatePage {
    private WebDriver driver;

    // Locators
    private By emailField = By.id("exampleInputEmail1");  // adjust locator if different
    private By submitButton = By.xpath("//div[contains(@class,'card-footer')]//button");
    private By successMessage = By.xpath("//*[@id=\"root\"]/div/div/div[1]");
    private By errorMessage = By.xpath("//*[@id=\"root\"]/div/div/div[2]");

    // Constructor
    public ForgatePage(WebDriver driver) {
        this.driver = driver;
    }

    // Enter email
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    // Click submit
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    // Perform full forgot password flow
    public void resetPassword(String email) {
        enterEmail(email);
        clickSubmit();
    }

    // Capture success message
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    // Capture error message
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
