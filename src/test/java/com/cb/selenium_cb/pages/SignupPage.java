package com.cb.selenium_cb.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignupPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators (fixed)
    private By signupbtn        = By.xpath ("//*[@id=\"root\"]/div/section/div[2]/div/div[2]/div/div[2]/form/div[4]/span/a");
    private By nameInput        = By.id("fname");
    private By lastNameInput    = By.id("lname");
    private By emailInput       = By.id("email");
    private By contactNumber    = By.id("ccno");
    private By noOfYears        = By.id("no_of_years_in_business");
//    private By confirmPassword  = By.id("confirm_password"); // adjust to real id
    private By signupButton     = By.xpath("//*[@id='root']/div/div/section/div[2]/div/div[2]/div/div[3]/a[2]");
    private By successMessage   = By.xpath("//*[@id='root']/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).sendKeys(name);
    }

    public void enterLastName(String lname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)).sendKeys(lname);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public void enterContactNumber(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactNumber)).sendKeys(number);
    }

    public void enterNoOfYearsInBusiness(String years) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(noOfYears)).sendKeys(years);
    }

//    public void enterConfirmPassword(String password) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword)).sendKeys(password);
//    }

    public void clickSignup() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }
}
