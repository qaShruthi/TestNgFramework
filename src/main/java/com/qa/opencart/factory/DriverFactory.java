package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.aspectj.util.FileUtil;

import java.io.File;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager opm;
	public static String highlight;

	public static ThreadLocal<WebDriver> tdlDriver = new ThreadLocal<WebDriver>();

	/**
	 * 
	 * @param browserName
	 * @return WebDriver Initialize the driver which calls the browser
	 */
	public WebDriver initDriver(Properties prop) {
		opm = new OptionsManager(prop);
		String browserName = prop.getProperty("browser").trim().toLowerCase();
		highlight = prop.getProperty("highlight").trim();

		if (browserName.equals("chrome")) {
			// driver = new ChromeDriver(opm.getChromeOptions());
			tdlDriver.set(new ChromeDriver(opm.getChromeOptions()));
		} else if (browserName.equals("firefox")) {
			// driver = new FirefoxDriver(opm.getFirefoxOptions());
			tdlDriver.set(new FirefoxDriver(opm.getFirefoxOptions()));
		} else if (browserName.equals("safari")) {
			// driver = new SafariDriver();
			tdlDriver.set(new SafariDriver());
		} else if (browserName.equals("edge")) {
			// driver = new EdgeDriver(opm.getEdgeOptions());
			tdlDriver.set(new EdgeDriver(opm.getEdgeOptions()));
		} else {
			System.out.println("Enter the correct browser name" + browserName);
		}

		String urlName = prop.getProperty("url").trim();
//		driver.get(urlName);
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		return driver;

		getThreadLocalDriver().get(urlName);
		getThreadLocalDriver().manage().deleteAllCookies();
		getThreadLocalDriver().manage().window().maximize();
		return getThreadLocalDriver();
	}

	/**
	 * this is a thread local get method to return drivers which are set in the
	 * initDriver() get the thread local copy of the driver synchronized so that we
	 * will not face the dead lock condition so that they get different thread copy
	 * 
	 * @return webdriver
	 */
	public synchronized static WebDriver getThreadLocalDriver() {
		return tdlDriver.get();
	}

	/**
	 * reads the config property file
	 * 
	 * @return Property file
	 * @throws  
	 * @throws FileNotFoundException
	 */
	public Properties init_properties() {
		// mvn clean install -Denv="stage"
		// can read env varibles by using System.getProperty()

		prop = new Properties();
		FileInputStream fs = null;
		
		String envName = System.getProperty("env");
		try {
			
		if (envName == null) {
			System.out.println("Env data is not passed so running test cases on QA Env");
			fs = new FileInputStream("./src/test/resources/config/qa.config.properties");
		} else {
			switch (envName.toLowerCase().trim()) {
			case "qa":
				fs = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "dev":
				fs = new FileInputStream("./src/test/resources/config/dev.config.properties");
				break;
			case "prod":
				fs = new FileInputStream("./src/test/resources/config/config.properties");
				break;
			case "stage":
				fs = new FileInputStream("./src/test/resources/config/stage.config.properties");
				break;
			default:
				System.out.println("Wrong env infomation passed");
				break;
			}
		}
		
		
		
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 * Takes the screenshot when called
	 * just checking to see the difference in git hub
	 * @throws IOException
	 */

	public static String takeScreenShot() {
		File srcFile = ((TakesScreenshot) getThreadLocalDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtil.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

}
