package cucumber.StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	WebDriver driver = null;
	WebElement searchBox = null;
	@Given("browser is open")
	public void browser_is_open() {
		driver = new ChromeDriver();
	   
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		 driver.get("https://www.google.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
		 searchBox= driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		 Thread.sleep(3000);
		 searchBox.sendKeys("Automation Step by Step");
		 Thread.sleep(3000);
	}

	@And("hits enter")
	public void hits_enter() {
		searchBox.sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() throws InterruptedException {
		Thread.sleep(3000);
		 driver.getPageSource().contains("Online Courses");
		 driver.close();
		 driver.quit();
	}

}
