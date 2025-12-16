package com.cb.selenium_cb.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;

import com.cb.selenium_cb.base.TestBase;
import com.cb.selenium_cb.pages.LoginPage;

public class LoginTest extends TestBase {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("nikambharati06@gmail.com", "SuperAdmin1"); 
        
        // Wait for redirect or dashboard element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/superAdminDashboard"));
        
        Assertions.assertTrue(
        	    driver.getCurrentUrl().contains("/superAdminDashboard"),
        	    "Login did not redirect to dashboard!"
        	);
        System.out.println("Valid login test passed successfully!");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrongUser@gmail.com", "wrongPass");

        Assertions.assertFalse(
                driver.getCurrentUrl().contains("/superAdminDashboard"),
                "User should not be redirected to dashboard on invalid login!"
            );
        System.out.println("Invalid login test passed successfully!");
    }
    
    @Test
    public void emptyCredentialsTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");   // both blank

        Thread.sleep(1000); // wait for error

        String errorText = driver.findElement(loginPage.getErrorMessageLocator()).getText();
        Assertions.assertEquals(
                "Enter email and password",
                errorText,
                "Error message not shown for empty credentials!"
        );
        System.out.println("✅ Empty credentials test passed successfully!");
    }

    @Test
    public void invalidEmailTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrongEmail", "SuperAdmin1");

        Thread.sleep(1000); // wait for error

        String errorText = driver.findElement(loginPage.getErrorMessageLocator()).getText();
        Assertions.assertEquals(
                "No user found with this email",
                errorText,
                "Error message not shown for invalid email!"
        );
        System.out.println("✅ Invalid email test passed successfully!");
    }

    @Test
    public void invalidPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nikambharati06@gmail.com", "wrongPassword");

        Thread.sleep(1000); // wait for error

        String errorText = driver.findElement(loginPage.getErrorMessageLocator()).getText();
        Assertions.assertEquals(
                "Wrong email or password",
                errorText,
                "Error message not shown for invalid password!"
        );
        System.out.println("✅ Invalid password test passed successfully!");
    }
}