package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagePOM {
	WebDriver driver;
	By txt_userName = By.name("username");
	By txt_password = By.name("password");
	By login_button = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

	public LoginPagePOM(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String userName) {
		driver.findElement(txt_userName).sendKeys(userName);
	}

	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}

	public void clickButton() {
		driver.findElement(login_button).click();;
	}

}
