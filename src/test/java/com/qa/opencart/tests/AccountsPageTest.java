package com.qa.opencart.tests;

import java.util.List;

//import org.apache.log4j.Logger;
//import org.apache.log4j.MDC;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;


public class AccountsPageTest extends BaseTest {
	
    AccountsPage accPage;
    
	@BeforeClass
	public void accPageSetup() throws InterruptedException {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Thread.sleep(10);
	}

	@Test(priority = 0)
	public void accPageTitleTest() {
       
		String actTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, "My Account");
	}

	

	@Test(priority = 1)
	public void isLogoutLinkExistTest() {
      

		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

	@Test(priority = 2)
	public void accPageHeadersCountTest() {
       

		List<String> actualAccPageHeadersList = accPage.getAccountsPageHeadersList();
		System.out.println("Acc Page Headers List: " + actualAccPageHeadersList);
		Assert.assertEquals(actualAccPageHeadersList.size(), 4);
		
	}

	/*

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "Macbook" }, 
			{ "iMac" }};
//			{ "Apple" }, 
//			{ "Samsung" } };
	}

	@Test(dataProvider = "getProductData")
	public void searchProductCountTest(String searchKey) {
        //MDC.put("testClassName", this.getClass().getSimpleName());
        //logger.info("This is a log message from searchProductCountTest");

		searchPage = accPage.performSearch(searchKey);
		Assert.assertTrue(searchPage.getSearchProductsCount() > 0);
	}

	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] { { "Macbook", "MacBook Pro" }};
//			{ "Macbook", "MacBook Air" }, { "iMac", "iMac" },
//		
//				{ "Apple", "Apple Cinema 30\"" }, { "Samsung", "Samsung SyncMaster 941BW" },
//				{ "Samsung", "Samsung Galaxy Tab 10.1" }, };
	}

	@Test(dataProvider = "getProductTestData")
	public void searchProductTest(String searchKey, String productName) {
        //MDC.put("testClassName", this.getClass().getSimpleName());
        //logger.info("This is a log message from searchProductTest");

//		searchPage = accPage.performSearch(searchKey);
//		if (searchPage.getSearchProductsCount() > 0) {
//			productInfoPage = searchPage.selectProduct(productName);
//			String actProductHeader = productInfoPage.getProductHeaderValue();
//			Assert.assertEquals(actProductHeader, productName);
//		}
	}
	
	*/

}
