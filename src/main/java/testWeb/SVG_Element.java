package testWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVG_Element {

	public static void main(String[] args) throws InterruptedException {
		// SVG: Scaler Vector Graphs

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Macbook");
		driver.findElement(By.xpath("//form[contains(@class,'header-form-search')]//*[local-name()='svg']")).click();

		System.out.println("============================");

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id*='map-instance']")));
		List<WebElement> list = driver.findElements(By.xpath(
				"//*[local-name()='svg' and @id='map-svg']//*[local-name()='g' and @id='regions']//*[name()='g' and @class='region']//*[name()='path']"));
		System.out.println(list.size());

		Actions act = new Actions(driver);
		for (WebElement e : list) {
			act.moveToElement(e).perform();
			String text = e.getDomAttribute("name");
			System.out.println(text);
			if (text.contains("Iowa")) {
				act.click(e).perform();
				break;
			}
			Thread.sleep(1000);
		}

		Thread.sleep(3000);
		driver.quit();

	}

}
