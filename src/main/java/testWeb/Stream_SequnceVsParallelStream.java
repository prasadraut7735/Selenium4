package testWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stream_SequnceVsParallelStream {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		List<WebElement> ele = driver.findElements(By.tagName("a"));
		long stTime = System.currentTimeMillis();
		ele.stream().forEach(e -> System.out.println(e.getText()));
		long endTime = System.currentTimeMillis();
		System.out.println("timeTaken: " + (endTime - stTime));// 9604

		long st1Time = System.currentTimeMillis();
		ele.parallelStream().forEach(e -> System.out.println(e.getText()));
		long end1Time = System.currentTimeMillis();
		System.out.println("timeTaken: " + (end1Time - st1Time));// 3329
	}

}
