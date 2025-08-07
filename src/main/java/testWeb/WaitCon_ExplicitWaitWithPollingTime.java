package testWeb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCon_ExplicitWaitWithPollingTime {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Explicit wait
		// 1 WebDriver wait
		// 2 Fluent wait

		// Wait(I) until(Abstract Method); --- Implements -->FluentWait(C)
		// until(Individual Method)--> Extends-->WebDriverWait(C) - No Method

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By email = By.xpath("//input[@id='input-email']");
		By password = By.xpath("//input[@id='input-password']");
		By loginBtn = By.xpath("//input[@value='Login' and @class='btn btn-primary']");
		By Link = By.linkText("Terms & Conditions");
		/**
		 * // default polling interval time is 500 milliseconds
		 */
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys("Test");

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2), Duration.ofMillis(300));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys("ABC");
		wait1.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("ABC");
		
		ElementUtil util = new ElementUtil(driver);
		util.waitForElementAndClick(loginBtn, 2);
		util.waitForElementAndClick(Link, 2);
	}

}
