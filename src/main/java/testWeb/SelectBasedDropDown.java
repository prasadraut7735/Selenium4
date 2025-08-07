package testWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectBasedDropDown {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		By countryElement = By.id("Form_getForm_Country");
		WebElement element = driver.findElement(countryElement);
		Thread.sleep(3000);
		Select select = new Select(element);

		List<WebElement> getOptionsList = select.getOptions();
		System.out.println(getOptionsList.size());
//		select.selectByVisibleText("");
//		select.selectByIndex(5);
//		select.selectByValue("");
//		selectByVisbleText(countryElement, "India");
//		selectByIndex(countryElement, 5);
//		selectByValue(countryElement, "India");
	}

	public int getDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void selectByVisbleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public static void selectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public static void selectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
}
