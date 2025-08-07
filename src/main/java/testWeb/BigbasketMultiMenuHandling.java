package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigbasketMultiMenuHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(3000);

		By click1 = By.xpath("(//span[text()='Shop by'])[2]");
		By level1 = By.linkText("Snacks & Branded Foods");
		By level2 = By.linkText("Chocolates & Candies");
		By click2 = By.linkText("Toffee, Candy & Lollypop");

//		Actions act = new Actions(driver);
//		driver.findElement(click1).click();
//		Thread.sleep(2000);
//		act.moveToElement(driver.findElement(level1)).perform();
//		Thread.sleep(1000);
//		act.moveToElement(driver.findElement(level2)).perform();
//		Thread.sleep(1000);
//		driver.findElement(click2).click();

		parentChildMenu(click1, level1, level2, click2);
		driver.quit();
	}

	public static void parentChildMenu(By click1, By level1, By level2, By click2) throws InterruptedException {
		Actions act = new Actions(driver);
		getElement(click1).click();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(level1)).perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(level2)).perform();
		Thread.sleep(1000);
		getElement(click2).click();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}
