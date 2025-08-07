package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		Thread.sleep(3000);

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String title = js.executeScript("return document.title").toString();
//		System.out.println(title);
//
//		String url = js.executeScript("return document.URL").toString();
//		System.out.println(url);
		JavaScriptUtil js = new JavaScriptUtil(driver);
//		String title = js.getPageTitle();
//		System.out.println(title);
//
//		String url = js.getPageUrl();
//		System.out.println(url);
//		generateJsAlert("Hello");
//		String text = getJsPageText();
//		System.out.println(text);
//		goBackward();
//		Thread.sleep(3000);
//		goForward();
//		Thread.sleep(3000);
//		goRefresh();

//		zoomInAndOut("300.0%");
//		zoomInAndOut("100.0%");

//		scrollPageDown();
//		scrollPageDown("500");
		WebElement element = driver.findElement(By.xpath("//h3[text()='Companies & Contacts']"));
		scrollIntoView(element);
		drawBorder(element);
		flash(element);

//		try {
//
//		} finally {
//			driver.quit();
//		}
	}

	public static String getPageTitle() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title").toString();
	}

	public static String getPageUrl() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.URL").toString();
	}

	public static void generateJsAlert(String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}

	public static String getJsPageText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(" return document.documentElement.innerText").toString();
	}

	public static void goBackward() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(-1)");
	}

	public static void goForward() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(1)");
	}

	public static void goRefresh() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	public static void zoomInAndOut(String pixles) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("document.body.style.zoom = '" + pixles + "'");
	}

	public static void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public static void scrollPageDown(String height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0," + height + ")");
	}

	public static void scrollPageUp(String height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(" + height + ",0)");
	}

	public static void scrollIntoView(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public static void drawBorder(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}

	public static void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++) {
			changeColor("rgb(0,200,0)", element);
			changeColor(bgcolor, element);
		}
	}

	public static void changeColor(String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {

		}
	}
}
