package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitForFrame {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");

		By name = By.name("main");
		WebElement ele = driver.findElement(By.xpath("//frame[@name='main']"));

		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.waitForFrameUsingLocatorAndSwitchToIt(name, 10); FirstMethod:ByLocator
//		eleUtil.waitForFrameUsingLocatorAndSwitchToIt(5, 2); SecondMethod:FrameIndex
//		eleUtil.waitForFrameUsingLocatorAndSwitchToIt(5, "main"); ThirdMethod:FrameNameOrID
//		eleUtil.waitForFrameUsingLocatorAndSwitchToIt(5, ele); FourthMethod:UsingWebElement

		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);

	}

}
