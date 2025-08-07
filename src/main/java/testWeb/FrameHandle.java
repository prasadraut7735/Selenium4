package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");

//		driver.switchTo().frame(2);
//		driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']")));
//		driver.switchTo().parentFrame();
		WebElement ele = driver.findElement(By.tagName("h2"));
		String title = ele.getText();
		System.out.println(title);
		driver.quit();
	}

}
