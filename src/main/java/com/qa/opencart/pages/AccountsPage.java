package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	//private ElementUtil eleUtil;

	// 1. by private locators
	private By logoutLink = By.linkText("Logout");
	private By accsHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	//private By searchIcon = By.cssSelector("#search button");
	
	//2. page const
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		
	}

	// 3. Page actions
	public String getAccPageTitle() {
		
		String title = driver.getTitle();
				//eleUtil.waitForTitleIsAndFetch(5, "My Account");
		System.out.println("Acc page title is : " + title);
		return title;
	}

	public String getAccPageURL() {
		String url = driver.getCurrentUrl();
				//eleUtil.waitForURLContainsAndFetch(5, "route=account/account");
		System.out.println("Acc page url : " + url);
		return url;
	}

	public boolean isLogoutLinkExist() {
		return driver.findElement(logoutLink).isDisplayed();
				
		//return eleUtil.waitForElementVisible(logoutLink, 10).isDisplayed();
	}

	public boolean isSearchExist() {
		return driver.findElement(search).isDisplayed();
		//return eleUtil.waitForElementVisible(search, 10).isDisplayed();
	}

	public List<String> getAccountsPageHeadersList() {
		List<WebElement> accHeadersList = driver.findElements(accsHeaders);
				//eleUtil.waitForElementsVisible(accsHeaders, 10);		
		List<String> accHeadersValList = new ArrayList<String>();
		for (WebElement e : accHeadersList) {
			String text = e.getText();
			accHeadersValList.add(text);
		}
		return accHeadersValList;
	}
	
	
	
	
	

}
