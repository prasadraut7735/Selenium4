package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.intiDriver("Chrome");
		brUtil.launchBrURL("https://plm-3dpassport-int01.internal.ericsson.com/3dpassport");
		Thread.sleep(4000);
		By userName = By.xpath("//input[@id='username']");
		By password = By.xpath("//input[@id='password']");
		By loginBtn = By.xpath("//input[@type='submit']");
		
		
		
		ElementUtil elUtil = new ElementUtil(driver);
		elUtil.doSendkeys(userName, "testlftgatekeeper01");
		elUtil.doSendkeys(password, "Passport1");
//		elUtil.doClickElement(loginBtn);

		System.out.println(brUtil.getTitle());
		System.out.println(brUtil.getCurrentURL());

		flash(driver.findElement(userName));

//		brUtil.quiteBrowser();

	}

	public static void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element);
			changeColor(bgcolor, element);
		}
	}

	public static void changeColor(String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {

		}
	}
}
