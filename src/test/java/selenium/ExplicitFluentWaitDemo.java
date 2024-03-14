package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExplicitFluentWaitDemo extends SeleniumCommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		invokeBrowser("Chrome");
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		WebElement btn = driver.findElement(By.xpath("//button[text()='Click me to start timer']"));
		btn.click();
		System.out.println("Yay I clicked");
		//Static Wait
		Thread.sleep(15000);
		
        WebElement dplyMessage = driver.findElement(By.xpath("//p[@id='demo']"));
        System.out.println(dplyMessage.getText());
	}

}
