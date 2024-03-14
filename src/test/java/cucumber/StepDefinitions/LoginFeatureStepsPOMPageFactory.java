package cucumber.StepDefinitions;

import java.time.Duration;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import cucumber.pages.LoginPageFactory;
import cucumber.pages.LoginPagePOM;

public class LoginFeatureStepsPOMPageFactory {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Given("user is on HRMLogin page {string}")
	public void loginTest(String url) {
		driver.get(url);
	}

	@When("User enters username as {string} and password as {string}")
	public void goToHomePage(String userName, String passWord) {

		/* Normal 
		 * driver.findElement(By.name("username")).sendKeys(userName);
		 * driver.findElement(By.name("password")).sendKeys(passWord);
		 * driver.findElement(By.xpath(
		 * "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).
		 * click();
		 */
		/*
		 * Page Object Model login to keep pages and objects separate 
		 * LoginPagePOM loginPOM = new LoginPagePOM(driver);
		 * loginPOM.enterUserName(userName); 
		 * loginPOM.enterPassword(passWord);
		 * loginPOM.clickButton();
		 */

		 LoginPageFactory loginPF = new LoginPageFactory(driver);
		 loginPF.enterUserName(userName); 
		 loginPF.enterPassword(passWord);
		 loginPF.clickLoginButton();
		

	}

	@Then("User should be able to login sucessfully and new page open")
	public void verifyLogin() {

		String homePageHeading = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();

		// Verify new page - HomePage
		Assert.assertEquals(homePageHeading, "Dashboard");

	}

	@Then("^User should be able to see error message (.*)$")
	public void verifyErrorMessage(String expectedErrorMessage) {

		String actualErrorMessage = driver
				.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"))
				.getText();

		// Verify Error Message
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@After
	public void teardown() {

		driver.quit();
	}
}
