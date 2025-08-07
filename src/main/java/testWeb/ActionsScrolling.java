package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		Thread.sleep(3000);

		// Partial Scrolling
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		act.sendKeys(Keys.PAGE_UP).perform();

		// Scroll to bottom of the page
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();

		// Scroll to top of the page
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();

		// Scroll up to specific element
		act.scrollToElement(
				driver.findElement(By.xpath("//div[text()='Company']/parent::div//a/span[text()='Careers ']")))
				.pause(2000).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Company']/parent::div//a/span[text()='Investors ']")).click();
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
