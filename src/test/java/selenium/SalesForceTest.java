package selenium;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SalesForceTest extends SeleniumCommonMethods{

	public static void main(String[] args) throws IOException {
		try {
			invokeBrowser("Chrome");
			driver.get("https://login.salesforce.com/");
			
			WebElement uName= driver.findElement(By.xpath("//input[@id='username']"));
			uName.sendKeys("");
			WebElement pswd= driver.findElement(By.cssSelector("input[id='password']"));
			pswd.sendKeys("");
			takeScreenShot();
			//driver.findElement(By.id("username")).sendKeys("shdskhds");
			//driver.findElement(By.id("password")).sendKeys("shdskhds");
			driver.findElement(By.name("Login")).click();
			
			String errText = driver.findElement(By.id("error")).getText();
			if(errText.equals("Please check your username and password. If you still can't log in, contact your Salesforce administrator."))
			{
				System.out.print("TC2: Error Message printed is correct" +  '\n');
			}
			else
			{
				System.out.print("TC2: Error Message printed is Wrong/failed " + '\n');
			}
			
			takeScreenShot();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
