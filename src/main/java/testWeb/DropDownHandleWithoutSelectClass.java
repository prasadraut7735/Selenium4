package testWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownHandleWithoutSelectClass {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		Thread.sleep(3000);
		By countryElement = By.xpath("//select[@id='Form_getForm_Country']/option");

		List<WebElement> eleList = driver.findElements(countryElement);
//
//		for (WebElement e : eleList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
		selectDropDownValueWithoutSelectClass(countryElement, "Brazil");
		Thread.sleep(3000);
		driver.quit();
	}

	public static void selectDropDownValueWithoutSelectClass(By locator, String value) {
		List<WebElement> eleList = driver.findElements(locator);

		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
}
