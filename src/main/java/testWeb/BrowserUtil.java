package testWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {

	WebDriver driver;

	public WebDriver intiDriver(String browserName) {
		System.out.println("Enter the browser name: " + browserName);

		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "fireFox":
			driver = new FirefoxDriver();
			break;

		case "Safari":
			driver = new SafariDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			throw new BrowserException("===INVALID BROWSER NAME===");
		}
		return driver;
	}

	public void launchBrURL(String url) {
		if (url.indexOf("http") != 0 || url.length() == 0) {
			throw new BrowserException("===http is missing in the url===");
		}
		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void quiteBrowser() {
		driver.quit();
	}

}
