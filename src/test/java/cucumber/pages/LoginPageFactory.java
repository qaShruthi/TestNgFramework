package cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageFactory {
	
	WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement txt_userName;
	
	/*
	@FindBy(name ="username")
	WebElement txt_NamesuserName;
	 
	 OR
	 
	@FindBy(how = How.NAME , using = "username")
	WebElement txt_HowuserName;
	
	*/
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txt_password;

	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement login_Button;

	@FindBy(partialLinkText="Shruthi")
	List<WebElement> MyLinks;
	
	
	public LoginPageFactory(WebDriver driver)
	{
		this.driver = driver;
		// In Ajax application to handle load time for element 30 seconds
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		//can pass this or LoginPageFactory.class
		//PageFactory.initElements(driver, LoginPageFactory.class);
		PageFactory.initElements(factory, this);
	}
	
	public void enterUserName(String userName) {
		txt_userName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLoginButton() {
		login_Button.click();
	}

}
