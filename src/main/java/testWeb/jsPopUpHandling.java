package testWeb;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jsPopUpHandling {

	public static void main(String[] args) throws InterruptedException {
		// Alerts
//		1. JS Alert
//		2. Confirmation pop up
//		3. Prompt

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(3000);
		// 1.JS Alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(1000);
		Alert alt = driver.switchTo().alert();
		String text = alt.getText();
		System.out.println(text);
		alt.accept();
		Thread.sleep(2000);

		// 2.Confirmation pop up
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(1000);
		String text1 = alt.getText();
		System.out.println(text1);
		alt.accept();
		Thread.sleep(2000);

		// 3.Prompt : //only one text field
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(1000);
		String text2 = alt.getText();
		System.out.println(text2);
		alt.sendKeys("Test");
		alt.accept();
		Thread.sleep(3000);

		driver.quit();
	}

}
