package testWeb;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stream_SauceLabsStreams {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");

		WebElement username = driver.findElement(By.cssSelector("#user-name"));
		WebElement password = driver.findElement(By.cssSelector("#password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("#login-button"));
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginBtn.click();

		List<WebElement> pricesList = driver.findElements(By.cssSelector("div.inventory_item_price"));
//		pricesList.stream().forEach(e -> System.out.println(e.getText()));

		List<Double> price = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1)))
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		System.out.println(price);	
		System.out.println(price.get(0));
		System.out.println(price.get(price.size() - 1));
		System.out.println("======================");
		Double price1 = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1))).findFirst().get();
		System.out.println(price1);
		Double maxprice = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1)))
				.max(Double::compareTo).get();
		System.out.println(maxprice);
		Double minprice = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1)))
				.min(Double::compareTo).get();
		System.out.println(minprice);

	}

}
