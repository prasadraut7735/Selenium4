package testWeb;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlert {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alt.getText());
		alt.accept();
	}

	public static Alert waitForAlertAndSwitch(int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String getAlertText(int timeInSecond) {
		return waitForAlertAndSwitch(timeInSecond).getText();
	}

	public static void acceptAlert(int timeInSecond) {
		waitForAlertAndSwitch(timeInSecond).accept();
	}

	public static void dismissAlert(int timeInSecond) {
		waitForAlertAndSwitch(timeInSecond).dismiss();
	}

	public static void enterValueOnAlert(int timeInSecond, String value) {
		waitForAlertAndSwitch(timeInSecond).sendKeys(value);
	}
	
}
