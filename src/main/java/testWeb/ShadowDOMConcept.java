package testWeb;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMConcept {

	public static void main(String[] args) throws InterruptedException {
		// Shadow DOM should be (Open)

		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(6000);
		String jspath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";

//		driver.switchTo().frame("pact1");
//		String jspath = "document.querySelector(\"#userName\").shadowRoot.querySelector(\"#glaf\")";
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement pizza = (WebElement) js.executeScript(jspath);
		pizza.sendKeys("Test");
		driver.quit();
		
		
		
//		SVG Special xpath 
		//parent SVG: local-name()
		//child SVG: local-name()
	}

}
