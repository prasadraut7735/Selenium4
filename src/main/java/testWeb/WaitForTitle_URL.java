package testWeb;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitle_URL {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		boolean flag = false;
//		try {
//			flag = wait.until(
//					ExpectedConditions.titleIs("Free CRM software for customer  management, sales, and support."));
//			flag = true;
//		} catch (TimeoutException e) {
////			throw new BrowserException("====TITLE IS NOT MATCHED====");
//			System.out.println("====TITLE IS NOT MATCHED====");
//		}
//		if (flag) {
//			System.out.println("PASS");
//		} else {
//			System.out.println("FALSE");
//		}
//		waitForTitle("Free CRM software for customer relationship management, sales, and support.", 10);
		String title = getTitleIs("Free  software for customer relationship management, sales, and support.", 10);
		System.out.println(title);
	}

	public static String getTitleIs(String expectedTitle, int timeInSecond) {
		if (waitForTitleIs(expectedTitle, timeInSecond)) {
			return driver.getTitle();
		} else {
			throw new BrowserException("====TITLE IS NOT MATCHED====");
		}
	}

	public static String getTitleContains(String fractionTitle, int timeInSecond) {
		if (waitForTitleContains(fractionTitle, timeInSecond)) {
			return driver.getTitle();
		} else {
			throw new BrowserException("====TITLE IS NOT MATCHED====");
		}
	}

	public static boolean waitForTitleIs(String expectedTitle, int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		boolean flag = false;
		try {
			return wait.until(ExpectedConditions.titleIs(expectedTitle));
		} catch (TimeoutException e) {
			System.out.println("====TITLE IS NOT MATCHED====");
			return flag;
		}
	}

	public static boolean waitForTitleContains(String fractionTitle, int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		boolean flag = false;
		try {
			return wait.until(ExpectedConditions.titleContains(fractionTitle));
		} catch (TimeoutException e) {
			System.out.println("====TITLE IS NOT MATCHED====");
			return flag;
		}
	}
}
