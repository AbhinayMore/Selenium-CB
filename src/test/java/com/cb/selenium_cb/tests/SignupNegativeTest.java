package com.cb.selenium_cb.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cb.selenium_cb.base.TestBase;
import com.cb.selenium_cb.pages.SignupPage;

public class SignupNegativeTest extends TestBase{
	
	  @Test
	    public void testUserCannotSignupWithInvalidEmail() {
	        driver.get("https://cb.nellinfotech.com/auth/sign-up");
	        SignupPage signup = new SignupPage(driver);

	        // fill form with invalid email
	        signup.enterName("Rahul");
	        signup.enterLastName("Dravid");
	        signup.enterEmail("invalid-email"); // ❌ invalid format
	        signup.enterContactNumber("9876543214");
	        signup.enterNoOfYearsInBusiness("3");
//	      signup.enterConfirmPassword("Password123");
//	      signup.acceptTerms();

	        // submit form
	        signup.clickSignup();

	        // verify error message
	        Assertions.assertTrue(
	                signup.getErrorMessage().contains("Please enter a valid email"),
	                "Expected email validation error not found!"
	        );

	        System.out.println("Negative Test executed successfully — Invalid email validation displayed.");
	    }
 
//	    @Test
//	    public void testUserCannotSignupWithoutRequiredFields() throws InterruptedException {
//	        driver.get("https://cb.nellinfotech.com/auth/sign-up");
//	        SignupPage signup = new SignupPage(driver);
//
//	        // Only fill some fields (missing last name and email)
//	        signup.enterName("Virat");
//	        signup.enterContactNumber("9988776655");
//	        
//	        Thread.sleep(2000);
//
//	        signup.clickSignup();
//
//	        // verify error message
//	        Assertions.assertTrue(
//	                signup.getErrorMessage().contains("required"),
//	                "Expected required field validation not found!"
//	        );
//
//	        System.out.println("Negative Test executed successfully — Required fields validation displayed.");
//	    }

}
