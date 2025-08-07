package testWeb;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stream_CRMPRO {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("http://classic.crmpro.com/");

//		List<WebElement> headerList = driver.findElements(By.cssSelector("section#details h3"));
//		headerList.stream().forEach(e -> System.out.println(e.getText()));
//		driver.quit();

		By header = By.cssSelector("section#details h3");
//		printHeaderList(header);
		if (getHeaderList(header).contains("Reports")) {
			System.out.println("Pass");
		}
		driver.quit();
	}

	public static List<String> getHeaderList(By locator) {
		List<WebElement> headers = driver.findElements(locator);
		return headers.stream().map(e -> e.getText()).collect(Collectors.toList());
	}

	public static void printHeaderList(By locator) {
		List<WebElement> headerList = driver.findElements(locator);
		headerList.stream().forEach(e -> System.out.println(e.getText()));
	}
}
