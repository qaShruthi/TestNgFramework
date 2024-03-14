package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import selenium.SeleniumCommonMethods;

public class ActionClassMethods extends SeleniumCommonMethods {

	public static void main(String[] args) throws InterruptedException, AWTException {
		//right click - contextClick
		invokeBrowser("Chrome");
		/*
		 * driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html"); 
		 * 
		 * right click
		 * Actions actions = new Actions(driver); 
		 * WebElement rightClickbtn =
		 * driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		 * actions.contextClick(rightClickbtn).perform(); Thread.sleep(3000);
		 * driver.findElement(By.xpath("//span[text()='Copy']")).click();
		 * Thread.sleep(3000); System.out.println(driver.switchTo().alert().getText());
		 * driver.switchTo().alert().accept();
		 * 
		 * //Drag and Drop 
		 * 
		 * driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		 * 
		 * @SuppressWarnings("unchecked") JavascriptExecutor js = (JavascriptExecutor)
		 * driver; ((org.openqa.selenium.JavascriptExecutor)
		 * js).executeScript("window.scrollBy(0,350)", "");
		 * 
		 * Actions act = new Actions(driver); driver.switchTo().frame(0); WebElement src
		 * = driver.findElement(By.xpath("//span[normalize-space()='James Johns']"));
		 * WebElement dest = driver.findElement(By.
		 * xpath("//ul[@aria-label='Listbox , count of options = 2.']"));
		 * Thread.sleep(3000); act.dragAndDrop(src, dest).perform();
		 */
		
		//
		
		driver.navigate().to("https://ui.vision/demo/webtest/frames/");
		//Frame-1
		driver.switchTo().frame(0);
		driver.findElement(By.name("mytext1")).sendKeys("123");
		Thread.sleep(2000);
		System.out.println("We are in Frame 1 window" );
		
		driver.switchTo().parentFrame();//Back to previous Frame(Frameset-1)
		//driver.switchTo().defaultContent(); //Back to default window-This is also works
		//Frame-2
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset//frameset//frame[1]")));
		driver.findElement(By.name("mytext2")).sendKeys("Great");
		Thread.sleep(2000);
		System.out.println("We are in Frame 2 window" );
		driver.switchTo().parentFrame();//Back to previous Frame(Frameset-2)
		//Frame-3
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset//frameset//frame[2]")));
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Awesome");
		Thread.sleep(2000);
		System.out.println("We are in Frame 3 window" );
		driver.switchTo().parentFrame();//Back to previous Frame(Frameset-2)
		//Frame-4
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='frame_4.html']")));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Very Good");
		Thread.sleep(2000);
		System.out.println("We are in Frame 4 window" );
		driver.switchTo().defaultContent();

		//Frame-5
		driver.switchTo().frame(driver.findElement(By.xpath("/html[1]/frameset[1]/frame[2]")));
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("here you go");
		Thread.sleep(2000);
		System.out.println("we are in frame�5�window");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
		
		// Mouse over
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		
		WebElement ele = driver.findElement(By.xpath("//button[text()='Automation Tools']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	
		List<WebElement> link = driver.findElements(By.xpath("//div[@class ='dropdown-content']//a"));
		
		int total_count = link.size();
		for(int i=0; i<total_count;i++)
		{
			String element = link.get(i).getText();
			//String text = element.getAttribute("innerHTML");
			
			
			System.out.println("Link name is "+ element);
			
			if(element.equalsIgnoreCase("Appium"))
			{
				link.get(i).click();
			}
		}
	}

}
