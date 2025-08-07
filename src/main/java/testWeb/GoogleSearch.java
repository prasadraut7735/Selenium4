package testWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		By searchField = By.name("q");
		By suggestion = By.xpath("//ul/li//div[@class='wM6W7d']/span");
		doSearchMethod(searchField, suggestion, "Selenium", "java");
		driver.quit();
	}

	public static boolean doSearchMethod(By searchField, By suggestion, String searchKey, String matchValue)
			throws InterruptedException {

		boolean flag = false;

		driver.findElement(searchField).sendKeys(searchKey);
		Thread.sleep(3000);

		List<WebElement> suggestionList = driver.findElements(suggestion);
		System.out.println(suggestionList.size());
		int totalSuggestion = suggestionList.size();
		if (totalSuggestion == 0) {
			throw new BrowserException("===NO SUGGESTION FOUND===");
		}
		for (WebElement e : suggestionList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(matchValue)) {
				e.click();
				flag = true;
			}

		}
		if (flag) {
			System.out.println("Match Value is found");
			return true;
		}
		System.out.println("Match Value is not found");
		return false;
	}

}
