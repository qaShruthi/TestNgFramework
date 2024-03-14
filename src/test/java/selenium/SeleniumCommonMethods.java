package selenium;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class SeleniumCommonMethods {

	public static WebDriver driver;
	
	/**
	 * This method is used to initialize the driver based on browser name
	 * @param browserName
	 * @return this returns specific browser driver
	 * @throws InterruptedException
	 */

	public static WebDriver invokeBrowser(String browserName) throws InterruptedException {

		String allCapsBrowserName = browserName.toUpperCase().trim();
		switch (allCapsBrowserName) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		case "Edge":
			driver = new EdgeDriver();
			break;
		case "SAFARI":
			driver = new SafariDriver();
			break;
		case "INTERNETEXPLORER":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Please pass the right browser name" + allCapsBrowserName);

		}
		 // to maximize the window
        //driver.manage().window().maximize();
        
        // to delete all cookies
        //driver.manage().deleteAllCookies();
        
		return driver;
	}	

	public static void closeBrowser() {
		driver.close();
	}
	
	public static void getUrl(String url)
	{
		driver.get(url);
	}
	
	public static void takeScreenShot() throws IOException 
	{
		File src = null;
		src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./Screenshots/" + "scr-"+ System.currentTimeMillis() + ".png"));
		System.out.println("ScreenShot Taken-Refresh to find the new screenshot");
		
		
	}

}
