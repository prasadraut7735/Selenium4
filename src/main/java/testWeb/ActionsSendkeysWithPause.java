package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendkeysWithPause {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();

		driver.get("https://plm-3dpassport-int01.internal.ericsson.com/3dpassport");
		Thread.sleep(3000);

		By userName = By.xpath("//input[@id='username']");
		By password = By.xpath("//input[@id='password']");
//	Scenario is to input the value in the text field: enter character one by one

//		Actions act = new Actions(driver);
//		String name = "Gatekeeper01";
//		char ch[] = name.toCharArray();
//
//		for (char e : ch) {
//			act.sendKeys(driver.findElement(userName), String.valueOf(e)).pause(3000).perform();
//		}

		doSendkeysWithPause(password, "Passport01", 3000);
		driver.quit();
	}

	public static void doSendkeysWithPause(By locator, String inputValue, long pauseTime) {
		Actions act = new Actions(driver);
		char ch[] = inputValue.toCharArray();
		for (char e : ch) {
			act.sendKeys(driver.findElement(locator), String.valueOf(e)).pause(pauseTime).perform();
		}

	}

}
