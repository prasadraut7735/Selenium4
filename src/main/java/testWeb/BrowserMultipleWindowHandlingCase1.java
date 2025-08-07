package testWeb;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserMultipleWindowHandlingCase1 {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		Thread.sleep(3000);

		Set<String> listofID = driver.getWindowHandles();
		Iterator<String> it = listofID.iterator();

		String parentID = it.next();

//		WebElement newsArticles = driver.findElement(By.xpath("//footer//a[contains(text(),'News Articles')]"));
//		Actions act = new Actions(driver);
//		act.click(newsArticles).perform();

//		Set<String> iD = driver.getWindowHandles();
//		Iterator<String> it = iD.iterator();
//		String parentID = it.next();
//		driver.switchTo().window(parentID);
//		System.out.println(driver.getTitle());
//
//		String childID = it.next();
//		driver.switchTo().window(childID);
//		System.out.println(driver.getTitle());
//		driver.close();
//
//		driver.switchTo().window(parentID);
//		System.out.println(driver.getTitle());
//		// 2,
//		WebElement pressReleases = driver.findElement(By.xpath("//footer//a[contains(text(),'Press Releases')]"));
//		act.click(pressReleases).perform();
//		Thread.sleep(8000);
//		String newChild = it.next();
//		driver.switchTo().window(newChild);
//		System.out.println(driver.getTitle());
//		driver.close();
//
//		driver.switchTo().window(parentID);

		switchForGetTitle("Press Releases");
		switchForGetTitle("News Articles");
	}

	public static void switchForGetTitle(String enterURL) {
		driver.findElement(By.xpath("//footer//a[contains(text(),'" + enterURL + "')]"));
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("//footer//a[contains(text(),'" + enterURL + "')]"))).perform();
		Set<String> listofID = driver.getWindowHandles();
		Iterator<String> it = listofID.iterator();

		String parentID = it.next();

		while (it.hasNext()) {
			String windowID = it.next();

			if (!(windowID.equals(parentID))) {
				driver.switchTo().window(windowID);
				System.out.println(driver.getTitle());
				driver.close();
				driver.switchTo().window(parentID);
			}
		}
	}
}
