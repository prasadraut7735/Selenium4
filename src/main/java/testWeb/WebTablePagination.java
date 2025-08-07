package testWeb;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(8000);
		driver.manage().window().maximize();

		// multiple selection

		/*
		 * while (true) { if
		 * (driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {
		 * selectSameMultipleCountry("India"); } WebElement next =
		 * driver.findElement(By.xpath("//button[@class='dt-paging-button next']")); if
		 * (next.getDomAttribute("class").contains("disabled")) { break; } next.click();
		 * Thread.sleep(1000); }
		 */
		// multiple same selection
		/*
		 * while (true) { if
		 * (driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {
		 * selectSameMultipleCountry("India",); } WebElement next =
		 * driver.findElement(By.xpath("//button[@class='dt-paging-button next']")); if
		 * (next.getDomAttribute("class").contains("disabled")) { break; } next.click();
		 * Thread.sleep(1000); }
		 */
		// single selection

		/*
		 * while (true) { if
		 * (driver.findElements(By.xpath("//td[text()='prasad']")).size() > 0) {
		 * selectCountry("prasad"); break; } else {
		 * 
		 * WebElement next =
		 * driver.findElement(By.xpath("//button[@class='dt-paging-button next']")); if
		 * (next.getAttribute("class").contains("disabled")) {
		 * System.out.println("no such country..."); } next.click(); Thread.sleep(1000);
		 * } }
		 */

	}

	public static void selectMultipleCountries(List<String> countries) {
		for (String country : countries) {
			selectSameMultipleCountry(country);
		}
	}

	public static void selectSameMultipleCountry(String country) {
		List<WebElement> ele = driver
				.findElements(By.xpath("//td[text()='" + country + "']/preceding-sibling::td/input[@type='checkbox']"));
		for (WebElement e : ele) {
			e.click();
		}
	}

	public static void selectCountry(String country) {
		driver.findElement(By.xpath("//td[text()='" + country + "']/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

}
