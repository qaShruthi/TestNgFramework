package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	WebDriver driver;
	DriverFactory driveFactory;
	protected LoginPage loginPage;
	protected Properties prop;
	
	@BeforeTest
	public void setUp()
	{
		driveFactory = new DriverFactory();
		prop = driveFactory.init_properties();
		driver = driveFactory.initDriver(prop);
		
		loginPage = new LoginPage(driver);
		//lPage.doLogin("reachqashruthi@gmail.com", "hulu1511");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
