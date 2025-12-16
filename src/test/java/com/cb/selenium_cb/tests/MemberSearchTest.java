package com.cb.selenium_cb.tests;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cb.selenium_cb.base.TestBase;
import com.cb.selenium_cb.pages.LoginPage;
import com.cb.selenium_cb.pages.MemberSearchPage;

public class MemberSearchTest extends TestBase {

	@Test
	public void testSearchValidMember() throws InterruptedException {
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login("abhim8768@gmail.com", "abhinay123");

	 // Wait for and click the first dashboard link
	    WebElement dashboardLink = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//*[@id='root']/div/div[1]/div/div/div/a[1]")
	    ));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dashboardLink);
	    dashboardLink.click();

	    // Wait for and click the 'Members' menu item
	    WebElement memberMenu = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//*[@id='sidebar-menu']/li[3]/a")
	    ));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", memberMenu);
	    memberMenu.click();
;

	    MemberSearchPage searchPage = new MemberSearchPage(driver);

	    searchPage.enterSearchKeyword("abhi more");
	    searchPage.clickApplyFilter();

	    Assertions.assertTrue(searchPage.isMemberFound("abhi more"),
	            "Expected member not found in search results!");

	    System.out.println("✅ Test executed successfully — Member found in search results.");
	}
}
