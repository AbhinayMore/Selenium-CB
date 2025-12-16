
package com.cb.selenium_cb.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.cb.selenium_cb.base.TestBase;
import com.cb.selenium_cb.pages.ForgatePage;

public class ForgateTest extends TestBase {

    @Test
    public void validEmailForgotPasswordTest() {
        driver.get("https://nell.nellinfotech.com/auth/recoverpw?token=nell");  // adjust URL if different

        ForgatePage forgotPage = new ForgatePage(driver);

        // Use a valid registered email
        forgotPage.resetPassword("nikambharati06@gmail.com");

        forgotPage.clickSubmit();
        // Assert success message
        String success = forgotPage.getSuccessMessage();
        Assertions.assertTrue(
            success.contains("Success!"),
            "Success message not displayed correctly!"
        );
    }

    @Test
    public void invalidEmailForgotPasswordTest() {
        driver.get("https://nell.nellinfotech.com/auth/recoverpw?token=nell");  // adjust URL if different

        ForgatePage forgotPage = new ForgatePage(driver);

        // Use an invalid email
        forgotPage.resetPassword("wrongEmail@test.com");

        // Assert error message
        String error = forgotPage.getErrorMessage();
        Assertions.assertTrue(
            error.contains("Error!"),
            "Error message not displayed correctly!"
        );
    }
}
