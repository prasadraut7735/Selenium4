package testWeb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCon_ExplicitWait {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Explicit wait
		// 1 WebDriver wait
		// 2 Fluent wait

		// Wait(I) until(Abstract Method); --- Implements -->FluentWait(C)
		// until(Individual Method)--> Extends-->WebDriverWait(C) - No Method

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		By email = By.xpath("//input[@id='input-email']");
		By password = By.xpath("//input[@id='input-password']");
		By loginBtn = By.xpath("//input[@value='Login' and @class='btn btn-primary']");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement ele_wait = wait.until(ExpectedConditions.presenceOfElementLocated(email));
//		ele_wait.sendKeys("Test");

//		waitUntilPresenceOfElementLocated(email, 10).sendKeys("Test");
//		doSendKeysWithPresenceOfLocator(email, "Test", 10);

		doSendKeysWithVisibilityOfLocator(email, 10, "Test");

	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 *
	 * @param locator used to find the element
	 * @return the WebElement once it is located
	 */
	public static WebElement waitForElementPresence(By locator, int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void doSendKeysWithPresenceOfLocator(By locator, int timeInSecond, String value) {
		waitForElementPresence(locator, timeInSecond).sendKeys(value);
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 *
	 * @param locator used to find the element
	 * @return the WebElement once it is located and visible
	 */
	public static WebElement waitForElementVisibility(By locator, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void doSendKeysWithVisibilityOfLocator(By locator, int timeInSecond, String value) {
		waitForElementVisibility(locator, timeInSecond).sendKeys(value);
	}

}
