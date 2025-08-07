package testWeb;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PsuedoElementHandle {

	public static void main(String[] args) throws InterruptedException {
		// :: before
		// :: after
		// :: has

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String jspath = "return window.getComputedStyle(document.querySelector('label[for=\"input-firstname\"]'),'::before').getPropertyValue('content');";
		String executeScript = js.executeScript(jspath).toString();
		System.out.println(executeScript);
	}

}
