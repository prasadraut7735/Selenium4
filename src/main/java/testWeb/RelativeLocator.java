package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//p[text()='Cape Breton']"));
		String text = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(text);

		String text1 = driver.findElement(with(By.tagName("text")).toRightOf(ele)).getText();
		System.out.println(text1);

		String text2 = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(text2);

		String text3 = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(text3);

		driver.quit();
	}

}
