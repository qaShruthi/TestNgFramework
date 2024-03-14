package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	/**
	 * Priority execution is very important otherwise it executes alphabetically 
	 * and might end up in error
	 */
	@Test(priority=0)
	public void loginGetTitle()
	{
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}
	
	@Test(priority = 1)
	public void loginGetCurrentUrl()
	{
		String actualUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(actualUrl.contains("login"));
	}
	/**
	 * Login page where it gets the username and password from the config.properties
	 */
	@Test(priority = 3)
	public void doLoginPostiveTest()
	{
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
	}
	
	@Test(priority = 2)
	public void loginButtonExistsTest()
	{
		loginPage.loginButtonExists();
		
	}
	

}
