package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class IncognitoConcept {

	public static void main(String[] args) throws InterruptedException {

		// Chrome
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--incognito");
//		WebDriver driver = new ChromeDriver(co);

		// Firefox
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("-private");
//		WebDriver driver = new FirefoxDriver(fo);

		// Edge
		EdgeOptions eo = new EdgeOptions();
		eo.addArguments("--headless");
		eo.addArguments("--inprivate");
		WebDriver driver = new EdgeDriver(eo);

		driver.get("https://plm-3dpassport-sit01.internal.ericsson.com/3dpassport");
		System.out.println("Login page title: " + driver.getTitle());
		Thread.sleep(4000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		System.out.println("Forget password link title: " + driver.getTitle());
		driver.quit();

	}

}
