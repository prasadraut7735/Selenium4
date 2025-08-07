package testWeb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		// wait(I)---->FluentWait(C):until(){} + Individual Methods ---->WebDriverWait(C): No Methods

		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		By name = By.cssSelector("#Form_getForm_Name");

//		wait for fluent wait feature
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class)
//				.withMessage("======= Unable to find the element =======" + name);
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys("Naveen");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2))
		.ignoring(NoSuchElementException.class)
		.withMessage("=======NoSuchElementException=======");
	}

}
