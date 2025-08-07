package testWeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownAllOptions {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		Thread.sleep(3000);
		By countryElement = By.id("Form_getForm_Country");

//		Select select = new Select(driver.findElement(countryElement));
//		List<WebElement> eleList = select.getOptions();
//
//		for (WebElement e : eleList) {
//			String text = e.getText();
//			System.out.println(text);
//		}

		// Self Approach
//		List<WebElement> eleList = driver.findElements(countryElement);
//		List<String> textList = new ArrayList<String>();
//
//		for (WebElement e : eleList) {
//			String text = e.getText();
//			if (text != null) {
//				textList.add(text);
//			}
//		}
//		System.out.println(textList);

		// Single Country approach
		if (getDropDownOptionsTextList(countryElement).contains("India")) {
			System.out.println("Pass");
		}

		// Multiple Countries approach
		List<String> expectedList = Arrays.asList("India", "Brazil", "Austria");
		if (getDropDownOptionsTextList(countryElement).containsAll(expectedList)) {
			System.out.println("Pass");
		}
		driver.quit();
	}

	public static List<String> getDropDownOptionsTextList(By loctor) {
		Select select = new Select(driver.findElement(loctor));
		List<WebElement> eleList = select.getOptions();
		List<String> textList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			textList.add(text);
		}
		return textList;
	}
	

}
