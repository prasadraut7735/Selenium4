package testWeb;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserMultipleWindowHandlingCase2 {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * 
		 */

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		Thread.sleep(3000);

		WebElement newsArticles = driver.findElement(By.xpath("//footer//a[contains(text(),'News Articles')]"));
		WebElement pressReleases = driver.findElement(By.xpath("//footer//a[contains(text(),'Press Releases')]"));
		WebElement ourPartners = driver.findElement(By.xpath("//footer//a[contains(text(),'Our Partners')]"));
		WebElement testimonials = driver.findElement(By.xpath("//footer//a[contains(text(),'Testimonials')]"));

		Actions act = new Actions(driver);
		act.click(newsArticles).perform();
		act.click(pressReleases).perform();
		act.click(ourPartners).perform();
		act.click(testimonials).perform();

//		1. Fetch window ID's
		
		Set<String> listofID = driver.getWindowHandles();
		Iterator<String> it = listofID.iterator();

		String parentID = it.next();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String text = driver.getTitle();
			System.out.println(text);
			if (!(windowID.equals(parentID))) {
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
//		driver.quit();
	}

}
