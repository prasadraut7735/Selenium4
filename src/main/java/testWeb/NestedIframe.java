package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframe {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-scenario/");
		Thread.sleep(2000);
		driver.switchTo().frame("pact1");
		driver.findElement(By.cssSelector("#inp_val")).sendKeys("111Prasad");
		driver.switchTo().frame("pact2");
		driver.findElement(By.cssSelector("input[placeholder='Current Crush Name']")).sendKeys("222Prasad");
		driver.switchTo().frame("pact3");
		driver.findElement(By.cssSelector("input[placeholder='Destiny']")).sendKeys("333Prasad");
		driver.quit();
	}
}
