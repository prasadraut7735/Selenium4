package testWeb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By footer = By.cssSelector("footer a");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> ele_list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
		System.out.println(ele_list.size());
	}

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeInSeconds
	 */
	public static List<WebElement> waitForListOfWebElements(By locator, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}
