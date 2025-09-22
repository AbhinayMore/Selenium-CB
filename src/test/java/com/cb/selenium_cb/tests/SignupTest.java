package com.cb.selenium_cb.tests;

import com.cb.selenium_cb.base.TestBase;
import com.cb.selenium_cb.pages.SignupPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignupTest extends TestBase {

    @Test
    public void testUserCanSignup() {
        // pass the WebDriver from TestBase
        SignupPage signup = new SignupPage(driver);

        // fill out the form
        signup.enterName("Mari");
        signup.enterLastName("Smith");
        signup.enterEmail("john" + System.currentTimeMillis() + "@example.com");
        signup.enterContactNumber("9876543210");
        signup.enterNoOfYearsInBusiness("5");
//        signup.enterConfirmPassword("Password123");
        // signup.acceptTerms();

        // submit
        signup.clickSignup();

        // assert success
        Assertions.assertTrue(
                signup.getSuccessMessage().contains("successfully registered"),
                "Expected success message not found!"
        );
    }
}
