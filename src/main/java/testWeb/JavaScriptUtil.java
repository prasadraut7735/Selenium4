package testWeb;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	private WebDriver driver;
	private JavascriptExecutor js;

	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public String getPageTitle() {
		return js.executeScript("return document.title").toString();
	}

	public String getPageUrl() {
		return js.executeScript("return document.URL").toString();
	}

	public void generateJsAlert(String message) {
		js.executeScript("alert('" + message + "')");
	}

	public String getJsPageText() {
		return js.executeScript(" return document.documentElement.innerText").toString();
	}

	public void goBackward() {
		js.executeScript("history.go(-1)");
	}

	public void goForward() {
		js.executeScript("history.go(1)");
	}

	public void goRefresh() {
		js.executeScript("history.go(0)");
	}

	public void zoomInAndOut(String pixles) {
		js.executeAsyncScript("document.body.style.zoom = '" + pixles + "'");
	}

	public void zoomFirefox(String zoomPercentage) {
		js.executeAsyncScript("document.body.style.MozTransform = 'scale(" + zoomPercentage + ")'");
	}

	public void scrollPageDown() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollMiddleOfPage() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight/2)");
	}

	public void scrollPageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public void scrollPageDown(String height) {
		js.executeScript("window.scrollTo(0," + height + ")");
	}

	public void scrollPageUp(String height) {
		js.executeScript("window.scrollTo(" + height + ",0)");
	}

	public void scrollIntoView(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public void drawBorder(WebElement element) {
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}

	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element);
			changeColor(bgcolor, element);
		}
	}

	public void changeColor(String color, WebElement element) {
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {

		}
	}
}
