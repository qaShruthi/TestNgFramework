package com.qa.opencart.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;


	// 1. by private locators

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPswdLink = By.linkText("Forgotten Password");
	private By search = By.name("search");
	
   //2. page const
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page actions
	/**
	 * 
	 * @param eID
	 * @param pswd
	 * @return Accounts page : this is called page chaining, where Login accounts returns the next page 
	 * ie Accounts Page
	 */
	public AccountsPage doLogin(String eID, String pswd) {
		driver.findElement(emailId).sendKeys(eID);
		driver.findElement(password).sendKeys(pswd);
		driver.findElement(loginBtn).click();
		return new AccountsPage(driver);
	}

	public String getLoginPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Account Login"));
		String title = driver.getTitle();
		return title;
	}
	
	public String getLoginPageUrl() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("route=account/login"));
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public boolean forgotPasswordLinkDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement forgotPsdLink=  
				wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPswdLink));
		
		return forgotPsdLink.isDisplayed();
	}

	public boolean searchExits() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchButton=  
				wait.until(ExpectedConditions.visibilityOfElementLocated(search));
		
		return searchButton.isDisplayed();
	}

	public boolean loginButtonExists() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement loginButton=  
				wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
		
		return loginButton.isDisplayed();
	}

	public void getRightSideTextOfThePage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> webElements = driver.findElements(By.xpath("////div[@class='list-group']"));
		for (int i = 0; i < webElements.size(); i++) {
			System.out.println(webElements.get(i));
		}
	}
}
