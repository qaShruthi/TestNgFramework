package selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class DropdownOptionsButtonSelHandling extends SeleniumCommonMethods{

	public static void main(String[] args) throws InterruptedException {
	invokeBrowser("Chrome");
	getUrl("https://rahulshettyacademy.com/AutomationPractice/");
	WebElement radioButton = driver.findElement(By.xpath("//input[@value='radio1']"));
	radioButton.click();
	if(radioButton.isSelected())
	{
		System.out.println("Yay radio button is selected");
	}
	Thread.sleep(3000);
	//Select DropDown
	WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
	dropDown.click();
	//SelectByValue, SelectByIndex, SelectByVisibleText
	Select dropDownOptions = new Select(dropDown);
	List<WebElement> dropDownItems = dropDownOptions.getOptions();
	for(int i=0;i<dropDownItems.size(); i++)
	{
		System.out.println(dropDownItems.get(i).getText());
		
	}
	 dropDownOptions.selectByIndex(1);
	 Thread.sleep(3000);
	 dropDownOptions.selectByValue("option2");
	 Thread.sleep(3000);
	 dropDownOptions.selectByVisibleText("Option3");
	 
	 
	 //CheckBox 
	 
	 WebElement checkboxItem = driver.findElement(By.cssSelector("input[id='checkBoxOption1'"));
	 checkboxItem.click();
	 
	}

}
