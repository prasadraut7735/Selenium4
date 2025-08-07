package testWeb;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserWindowHandlingConcept {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * Browser window pop-up is nothing but : window(Child window) or tab handling
		 */

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		Thread.sleep(3000);

		WebElement executiveProfile = driver.findElement(By.xpath("//footer//a[contains(text(),'Executive Profile')]"));
//		executiveProfile.click();
		Actions act = new Actions(driver);
		act.click(executiveProfile).perform();

		Set<String> getWindows = driver.getWindowHandles();
		Iterator<String> it = getWindows.iterator();

		String parentID = it.next();
		System.out.println("Parent ID :" + parentID);

		String childID = it.next();
		System.out.println("Child ID :" + childID);

		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());

		driver.close();

		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
