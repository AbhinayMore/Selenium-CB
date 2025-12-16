package com.cb.selenium_cb.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignupPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By nameInput = By.id("fname");
    private By lastNameInput = By.id("lname");
    private By emailInput = By.id("email");
    private By contactNumber = By.id("ccno");
    private By noOfYears = By.id("no_of_years_in_business");
    private By submitButton = By.xpath("//*[@id='root']/div/div/section/div[2]/div/div[2]/div/div[3]/a[2]");

    // ✅ existing success message locator
    private By successMessage = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]");

    // ✅ new error message locator (adjust to your real markup)
    // e.g. if your page shows: <div class="error">…</div>
 // Replace the generic CSS with your actual XPath
    private By errorMessage = By.xpath("//*[@id=\"root\"]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]");


    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterName(String name) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        el.clear();
        el.sendKeys(name);
    }

    public void enterLastName(String lname) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        el.clear();
        el.sendKeys(lname);
    }

    public void enterEmail(String email) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        el.clear();
        el.sendKeys(email);
    }

    public void enterContactNumber(String number) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(contactNumber));
        el.clear();
        el.sendKeys(number);
    }

    public void enterNoOfYearsInBusiness(String years) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(noOfYears));
        el.clear();
        el.sendKeys(years);
    }

    public void clickSignup() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getSuccessMessage() {
        try {
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return el.getText();
        } catch (TimeoutException e) {
            return ""; // no success message visible
        }
    }

    /** ✅ new method for negative tests */
    public String getErrorMessage() {
        try {
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return el.getText();
        } catch (TimeoutException e) {
            return ""; // no error message visible
        }
    }
}
