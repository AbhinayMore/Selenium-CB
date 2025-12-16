package com.cb.selenium_cb.tests;

import com.cb.selenium_cb.base.TestBase;
import com.cb.selenium_cb.pages.SignupPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignupTest extends TestBase {

    @Test
    public void testUserCanSignup() {
    	driver.get("https://cb.nellinfotech.com/auth/sign-up");
        // pass the WebDriver from TestBase
        SignupPage signup = new SignupPage(driver);

        // fill out the form
        signup.enterName("Sachin");
        signup.enterLastName("Tendulkar");
        signup.enterEmail("sachin" + System.currentTimeMillis() + "@example.com");
        signup.enterContactNumber("9290853419");
        signup.enterNoOfYearsInBusiness("5");
//      signup.enterConfirmPassword("Password123");
        // signup.acceptTerms();

        // submit
        signup.clickSignup();

        // assert success
        Assertions.assertTrue(
                signup.getSuccessMessage().contains("Sign up successful!!"),
                "Expected success message not found!"
        );
        
        System.out.println(" Test executed successfully — Sign up successful!!");
    }
}
