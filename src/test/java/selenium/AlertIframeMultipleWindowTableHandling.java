package selenium;

import java.util.Iterator;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.SeleniumCommonMethods;

public class AlertIframeMultipleWindowTableHandling extends SeleniumCommonMethods {

	public static void main(String[] args) throws InterruptedException {
		invokeBrowser("Chrome");
		/*
		 * getUrl("https://rahulshettyacademy.com/AutomationPractice/");
		 * 
		 * //alert
		 * 
		 * driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Shruthi");
		 * Thread.sleep(2000); WebElement alertbtn =
		 * driver.findElement(By.xpath("//input[@id='alertbtn']")); alertbtn.click();
		 * System.out.println(driver.switchTo().alert().getText());
		 * driver.switchTo().alert().accept(); Thread.sleep(2000); WebElement confirmbtn
		 * = driver.findElement(By.xpath("//input[@id='confirmbtn']"));
		 * confirmbtn.click(); driver.switchTo().alert().dismiss();
		 * 
		 * 
		 * //iframe handling driver.get("file:///C:/Users/Shruthi/Desktop/test.html");
		 * driver.findElement(By.id("t1")).sendKeys("Automation"); Thread.sleep(2000);
		 * driver.switchTo().frame(0);//frame index
		 * driver.findElement(By.id("t2")).sendKeys("test123"); Thread.sleep(2000);
		 * driver.findElement(By.id("t3")).sendKeys("T3:test123");
		 * driver.switchTo().parentFrame(); // go back to main parent frame
		 */
		// Multiple Window HAndle
		/*
		 * driver.get(
		 * "https://accounts.google.com/v3/signin/identifier?dsh=S285893491%3A1689014556867169&authuser=0&continue=https%3A%2F%2Fmail.google.com&ec=GAlAFw&hl=en&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession"
		 * );
		 * 
		 * driver.findElement(By.linkText("Help")).click();
		 * 
		 * driver.findElement(By.linkText("Privacy")).click();
		 * 
		 * // Iterator Set<String> winhandles = driver.getWindowHandles();
		 * Iterator<String> winhandle = winhandles.iterator();
		 * 
		 * String parent = winhandle.next();
		 * 
		 * String child1 = winhandle.next(); String child2 = winhandle.next();
		 * 
		 * driver.switchTo().window(child1); Thread.sleep(2000);
		 * System.out.println(driver.getTitle());
		 * 
		 * driver.switchTo().window(child2); Thread.sleep(2000);
		 * System.out.println(driver.getTitle());
		 * 
		 * driver.switchTo().window(parent); Thread.sleep(2000);
		 * System.out.println(driver.getTitle());
		 */
		
		/*
		 * //Table driver.get("https://demo.guru99.com/test/web-table-element.php");
		 * List<WebElement> columns =driver.findElements(By.
		 * xpath("//div[@class= 'leftcontainer']/table[@class='dataTable']/thead/tr/th")
		 * ); for(WebElement header: columns) { System.out.println(header.getText()); }
		 * WebElement row = driver.findElement(By.
		 * xpath("//div[@class= 'leftcontainer']/table[@class='dataTable']/tbody/tr[7]/td[3]"
		 * ));
		 * 
		 * System.out.println(row.getText());
		 */
       
       driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
       
	}

}
