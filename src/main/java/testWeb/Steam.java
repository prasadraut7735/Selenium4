package testWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steam {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		List<WebElement> ele = driver.findElements(By.tagName("a"));
//		ele.stream().forEach(e -> System.out.println(e.getText()));

//		ele.stream()
//			.filter(e -> !e.getText().isEmpty())
//				.filter(e-> e.getText().contains("Shoes"))
//					.forEach(e-> System.out.println(e.getText()));
//		driver.quit();

		List<String> list = new ArrayList<String>();

		ele.stream()
			.filter(e -> !e.getText().isEmpty()).filter(e -> e.getText().startsWith("Flipkart"))
				.forEach(e -> list.add(e.getText()));

		System.out.println(list);
		driver.quit();
	}

}
