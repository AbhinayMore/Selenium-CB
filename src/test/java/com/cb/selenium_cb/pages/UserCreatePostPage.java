package com.cb.selenium_cb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class UserCreatePostPage {

    private WebDriver driver;

    // Locators (example - update based on your actual form)
    private By titleField = By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/form/textarea");  
//    private By uploadFileInput = By.xpath("/html/body/div[3]/div/div/div[2]/ul/li/div");  
    
    private By uploadFileInput = By.xpath("//input[@type='file']");

    private By descriptionField = By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/h6/textarea");
    private By submitButton = By.xpath("/html/body/div[3]/div/div/div[2]/button");  
//    private By successMessage = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]");
    
    private By successMessage = By.xpath("//*[contains(text(),'Success')]");


    public UserCreatePostPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadFileInput).sendKeys(filePath);
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void createPost(String title, String filePath, String description) {
        enterTitle(title);
        uploadFile(filePath);
        enterDescription(description);
        clickSubmit();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
