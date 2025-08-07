package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariOptions;

public class HeadlessConcept {

	/**
	 * Headless: No browser activity Visibility: No browser visible Testing is
	 * happening behind the scene Faster Cloud: Linux Machine/ Jenkins Server(Linux)
	 * Browser installation is not needed,
	 * 
	 * Actually blocking the visibility of the browser: browser is there!
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {

		// Chrome
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
//		WebDriver driver = new ChromeDriver(co);

		// Firefox
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
//		WebDriver driver = new FirefoxDriver(fo);

		// Edge
		EdgeOptions eo = new EdgeOptions();
		eo.addArguments("--headless");
		WebDriver driver = new EdgeDriver(eo);

		// Safari: (limited or no support for headless as of now)
		SafariOptions so = new SafariOptions();

		driver.get("https://plm-3dpassport-sit01.internal.ericsson.com/3dpassport");
		System.out.println("Login page title: " + driver.getTitle());
		Thread.sleep(4000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		System.out.println("Forget password link title: " + driver.getTitle());
		driver.quit();

	}

}
