package testWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightContextClick {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
//		driver.findElement(By.xpath("//span[text()='Paste']")).click();

		List<WebElement> optionList = driver.findElements(By.cssSelector("ul.context-menu-list span"));
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("Cut")) {
				e.click();
				break;
			}
		}

	}

	public static void doActionsContextClick() {
		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		driver.findElement(By.xpath("//span[text()='Paste']")).click();
	}
	

}
