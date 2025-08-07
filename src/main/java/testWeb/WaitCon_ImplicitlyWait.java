package testWeb;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitCon_ImplicitlyWait {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 4.x
		
		
		ElementUtil ele = new ElementUtil(driver);
		// Global Wait: It will be applied on all the WebElement by default.
		// It can not be applied for specific WebElement
		// It can not be applied for non-webElement : Title, URL, Window, JS pop-up
	}

}
