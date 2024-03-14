package apachepoi.xmlread.propertyfileread;

import selenium.SeleniumCommonMethods;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersFromXMLReadingSpiceJetDemo extends SeleniumCommonMethods{
	
	static WebDriver driver;
	@Parameters({"browser","url"})
	@Test
	public static void invokespicejetBrowser(String browser, String url) throws InterruptedException
	{
		browser= browser.toLowerCase();
		invokeBrowser(browser); 
		getUrl(url);
	}
	}

	
	

