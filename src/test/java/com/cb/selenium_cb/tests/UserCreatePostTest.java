package com.cb.selenium_cb.tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;

import com.cb.selenium_cb.base.TestBase;
import com.cb.selenium_cb.pages.LoginPage;
import com.cb.selenium_cb.pages.UserCreatePostPage;
	


public class UserCreatePostTest extends TestBase {

    @Test
    public void createPostValidDataTest() throws InterruptedException {
    	   // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("abhim87687@gmail.con", "abhinay123");

       
        Thread.sleep(3000); // wait for redirect

        // Step 2: Navigate to Create Post
        driver.findElement(By.xpath("//*[@id=\"content-page\"]/div/div/div/div[1]/div/div/h4")).click();

        Thread.sleep(2000); // wait for form to open

        // Step 3: Fill the form
        UserCreatePostPage postPage = new UserCreatePostPage(driver);
        String testFilePath = "D:/nell.png";

        postPage.createPost(
                "Automation Post", 
                testFilePath, 
                "This post is created via Selenium automation."
        );

        Thread.sleep(3000); // wait for submit

        // Step 4: Assert success message
        String successMsg = postPage.getSuccessMessage();
        Assertions.assertEquals("Success!", successMsg, "❌ Post was not created!");
        System.out.println("✅ Create post after login test passed successfully!");
    }

//
//	@Test
//    public void createPostWithInvalidFileTest() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("abhim87687@gmail.con", "abhinay123");
//        Thread.sleep(3000);
//
//        driver.findElement(By.xpath("//*[@id=\"content-page\"]/div/div/div/div[1]/div/div/h4")).click();
//        Thread.sleep(2000);
//
//        UserCreatePostPage postPage = new UserCreatePostPage(driver);
//        postPage.createPost("Invalid File Post", "D:/Email_format.txt", "Trying with a text file");
//
//        Thread.sleep(2000);
//
////        String errorMsg = postPage.getErrorMessage();
////        Assertions.assertEquals("Invalid file type", errorMsg, "❌ File validation did not work!");
//        System.out.println("✅ Invalid file upload test passed successfully!");
//    }
//
//    
}
