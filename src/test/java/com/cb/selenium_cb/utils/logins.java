package com.cb.selenium_cb.utils;

import com.cb.selenium_cb.base.TestBase;
import com.cb.selenium_cb.pages.LoginPage;

public class logins extends TestBase {

	LoginPage loginPage = new LoginPage(driver);


	public logins(String key) {
		switch (key) {
		case "admin":
	        loginPage.login("nikambharati06@gmail.com", "SuperAdmin1"); 
			break;
		case "org_admin":

			break;
		case "chapter_admin":

			break;
		case "member":
	        loginPage.login("abhim87687@gmail.con", "abhinay123");
			break;
		default:
			break;
		}
	}
}
