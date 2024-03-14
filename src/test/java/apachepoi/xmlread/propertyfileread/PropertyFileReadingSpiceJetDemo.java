package apachepoi.xmlread.propertyfileread;

import selenium.SeleniumCommonMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.testng.annotations.Test;


public class PropertyFileReadingSpiceJetDemo extends SeleniumCommonMethods {
	
	@Test(enabled=false)
	public static void file() throws IOException, InterruptedException
	{
		
		 invokeBrowser("chrome");
		//fetch the details from property file through Resource Bundle class
		 ResourceBundle bundle = ResourceBundle.getBundle("MavenDemo.config");
		  System.out.println(bundle.getString("browser"));  
		  System.out.println(bundle.getString("url"));  
			
		//fetch the details from property file through FileInputStream or FileReader class
		//FileInputStream reader=new FileInputStream("C:\\Users\\Shruthi\\eclipse-testingWorkspace\\2023Selenium.Batch12\\spicejet.properties");
		//FileReader reader=new FileReader("C:\\Users\\Shruthi\\eclipse-testingWorkspace\\2023Selenium.Batch12\\spicejet.properties");
		//Properties prop = new Properties();
		//prop.load(reader);
		//System.out.println(prop.getProperty("browser"));
		//System.out.println(prop.getProperty("url"));;
		
		}
	
	@Test
	public void createPropertyFile() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Shruthi\\eclipse-testingWorkspace\\2023Selenium.Batch12\\spicejet.properties");
		Properties prop = new Properties();
		//enters key password first due to alphabetical order
		prop.put("message", "Welcome to Learning");
		prop.put("user", "shruthi");
		prop.put("password", "asdfghhh");
		prop.store(fos, "This is a sample properties file");
		
	}
	}
	


