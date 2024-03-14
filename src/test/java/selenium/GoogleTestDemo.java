package selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleTestDemo extends SeleniumCommonMethods {

	static List<WebElement> suggestions = null;
	static WebElement googleSearchBar = null;

	/**
	 * This method is used to search google search bar with a searchName
	 * 
	 * @param searchName
	 * @return this returns list of suggestions
	 * @throws InterruptedException
	 */
	public static List<WebElement> searchGoogleContent(String searchName) throws InterruptedException {
		By id = By.id("APjFqb");
		googleSearchBar = driver.findElement(id);
		googleSearchBar.sendKeys("training");
		Thread.sleep(3000);
		suggestions = driver.findElements(By.xpath("//span[contains(text(),'" + searchName + "')]"));
		return suggestions;
	}

	/**
	 * This method prints the suggestion list based of search name entered in google
	 * search bar
	 * 
	 * @throws InterruptedException
	 */

	public static void printSuggestionList() throws InterruptedException {

		if (suggestions.size() >= 0) {
			Thread.sleep(3000);
			for (int i = 0; i < suggestions.size(); i++) {
				System.out.println(suggestions.get(i).getText());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		invokeBrowser("Chrome");
		// driver.get("https://www.facebook.com");
		driver.get("https://www.google.com");
		// driver.navigate().back();
		// driver.navigate().forward();

//        webElem.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		searchGoogleContent("training");
		Thread.sleep(3000);

		printSuggestionList();



	}

}
