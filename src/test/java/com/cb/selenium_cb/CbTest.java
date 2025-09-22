package com.cb.selenium_cb;

import com.cb.selenium_cb.base.TestBase;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CbTest {
=======
>>>>>>> 28dfc5e1ed605cd10e74cefa514a786ef43fd412

public class CbTest extends TestBase {

//    @Test
//<<<<<<< HEAD
//    public void openGoogle() {
//        // Set ChromeDriver path
//        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://cb.nellinfotech.com");
//
//        System.out.println("Page Title is: " + driver.getTitle());
//
//        driver.quit();
//        
//       
//    }
    @Test
    public void testForgotPassword() {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open forgot password page (replace with correct URL if different)
        driver.get("https://nell.nellinfotech.com/auth/recoverpw?token=nell");

        // Locate elements and perform actions
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("adujagtap1399@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div[2]/div/div[2]/div/div[3]/button")).click();

        // Capture and print confirmation message
        String msg = driver.findElement(By.cssSelector(".message")).getText();
        System.out.println("Forgot Password Message: " + msg);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(ok).click().build().perform();
        Thread.sleep(2000);
       
        driver.quit();
=======
    public void verifyTitle() {
        System.out.println("✅ Page Title is: " + driver.getTitle());
>>>>>>> 28dfc5e1ed605cd10e74cefa514a786ef43fd412
    }
}
    

