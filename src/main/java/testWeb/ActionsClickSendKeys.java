package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickSendKeys {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://plm-3dpassport-int01.internal.ericsson.com/3dpassport");
		Thread.sleep(3000);
		By userName = By.xpath("//input[@id='username']");
		By password = By.xpath("//input[@id='password']");
		By loginBtn = By.xpath("//input[@type='submit']");

		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.sendKeys(driver.findElement(userName), "ABS").perform();
		act.click(driver.findElement(loginBtn)).perform();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(driver.findElement(locator)).perform();
	}

	public static void doActionsSendkeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(locator), value).perform();
	}

//	Two ways to perform send-keys and click
//	WE.Sendkeys           WE.Click
//	Ac.sendkeys           Ac.Click

//	build returns ===> Action
//	Difference between Action and Actions===?
//	Actions==>Class==> Used to perform multiple actions in the sequence
//	Action==>Interface==> Can be used later to perform 

}
