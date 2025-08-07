package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckElementPresent {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://3dpassport-uat01.plm.ericsson.net/3dpassport/");
		By logo = By.className("panel-logo");
		Thread.sleep(3000);
		int count = driver.findElements(logo).size();
		if (count == 1) {
			System.out.println("Logo is present");
		} else {
			System.out.println("Logo is not present");
		}
		driver.quit();
	}

}
