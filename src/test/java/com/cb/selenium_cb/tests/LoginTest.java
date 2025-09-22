package com.cb.selenium_cb.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.cb.selenium_cb.base.TestBase;
import com.cb.selenium_cb.pages.LoginPage;

public class LoginTest extends TestBase {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("nikambharati06@gmail.com", "SuperAdmin1");  // sample data

        // ✅ Example assertion: Check page title after login
        Assertions.assertTrue(
        	    driver.getCurrentUrl().contains("/superAdminDashboard"),
        	    "Login did not redirect to dashboard!"
        	);
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrongUser", "wrongPass");

        Assertions.assertFalse(
                driver.getCurrentUrl().contains("/superAdminDashboard"),
                "User should not be redirected to dashboard on invalid login!"
            );
    }
}
