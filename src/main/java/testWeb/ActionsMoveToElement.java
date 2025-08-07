package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
//		By addOns = By.xpath("//div[text()='Add-ons']");
//		By visaServices = By.xpath("//div[text()='Visa Services']");
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(addOns)).perform();
//		driver.findElement(visaServices).click();

//		parentChildMenu("Add-ons", "Visa Services");
//		parentChildMenu("SpiceClub", "Use Points");

		By parentMenu = By.xpath("//div[text()='Add-ons']");
		By childMenu = By.xpath("//div[text()='Visa Services']");
		parentChildMenu(parentMenu, childMenu);
		driver.quit();
	}

	public static void parentChildMenu(String parent, String child) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(By.xpath("//div[text()='" + parent + "']"))).perform();
		Thread.sleep(2000);
		getElement(By.xpath("//div[text()='" + child + "']")).click();
	}

	public static void parentChildMenu(By parent, By child) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parent)).perform();
		Thread.sleep(2000);
		getElement(child).click();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}
