package testWeb;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;
	private Actions act;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}
 
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doSendkeys(By locator, int timeInSecond, String value) {
		waitForElementVisibility(locator, timeInSecond).sendKeys(value);
	}

	public void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClickElement(By locator, int timeInSecond) {
		waitForElementVisibility(locator, 0);
	}

	public void doClickElement(By locator) {
		getElement(locator).click();
	}

	public String getElementText(By locator) {
		String eleText = getElement(locator).getText();
		if (eleText != null) {
			return eleText;
		} else {
			System.out.println("===TEXT IS NULL===: " + eleText);
			return null;
		}
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("=====ELEMENT IS NOT DISPLAYED=====" + locator);
			return false;
		}
	}

	public boolean isElementSelected(By locator) {
		return getElement(locator).isSelected();
	}

	public boolean isElementEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

	public String doElementGetText(By locator) {
		String eleText = getElement(locator).getText();
		if (eleText != null) {
			return eleText;
		} else {
			System.out.println("===Element is Null====" + eleText);
			return null;
		}
	}

	public String doElementGetAttribute(By locator, String attributeValue) {
		return getElement(locator).getDomAttribute(attributeValue);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getElementCount(By locator) {
		return getElements(locator).size();
	}

	public List<String> getElementTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> testList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			if (eleList != null) {
				testList.add(text);
			}
		}
		return testList;
	}

	public void printElementTestList(By locator) {
		List<String> eleTextList = getElementTextList(locator);
		for (String e : eleTextList) {
			System.out.println(e);
		}
	}

	public boolean doSearchMethod(By searchField, By suggestion, String searchKey, String matchValue)
			throws InterruptedException {
		boolean flag = false;

		doSendkeys(searchField, searchKey);
		Thread.sleep(3000);

		List<WebElement> suggestionList = getElements(suggestion);

		System.out.println(suggestionList.size());
		int totalSuggestion = suggestionList.size();
		if (totalSuggestion == 0) {
			throw new BrowserException("===NO SUGGESTION FOUND===");
		}

		for (WebElement e : suggestionList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(matchValue)) {
				e.click();
				flag = true;
			}

		}
		if (flag) {
			System.out.println("Match Value is found");
			return true;
		}
		System.out.println("Match Value is not found");
		return false;
	}

	public boolean isElementPresent(By locator) {
		if (getElementCount(locator) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementPresent(By locator, int expectedElementCount) {
		if (getElementCount(locator) == expectedElementCount) {
			return true;
		} else {
			return false;
		}
	}

	/** ================ Select drop-down list =================== */

	private Select getSelect(By locator) {
		return new Select(getElement(locator));
	}

	public int getDropDownOptions(By locator) {
		return getSelect(locator).getOptions().size();
	}

	public void selectByVisbleText(By locator, String text) {
		getSelect(locator).selectByVisibleText(text);
	}

	public void selectByIndex(By locator, int index) {
		getSelect(locator).selectByIndex(index);
	}

	public void selectByValue(By locator, String value) {
		getSelect(locator).selectByValue(value);
	}

	public List<String> getDropDownOptionsTextList(By loctor) {
		Select select = getSelect(loctor);
		List<WebElement> eleList = select.getOptions();
		List<String> textList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			textList.add(text);
		}
		return textList;
	}

	public void selectDropDownValueUsingSelectClass(By loctor, String value) {
		List<WebElement> eleList = getSelect(loctor).getOptions();
		selectDropDown(eleList, value);
	}

	public void selectDropDownValueWithoutSelectClass(By locator, String value) {
		List<WebElement> eleList = getElements(locator);
		selectDropDown(eleList, value);
	}

	private void selectDropDown(List<WebElement> eleList, String value) {
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	// =================ACTIONS UTIL===========================//

	public void parentChildMenu(String parent, String child) throws InterruptedException {
		act.moveToElement(getElement(By.xpath("//div[text()='" + parent + "']"))).perform();
		Thread.sleep(2000);
		doClickElement(By.xpath("//div[text()='" + child + "']"));
	}

	public void parentChildMenu(By parent, By child) throws InterruptedException {
		act.moveToElement(getElement(parent)).perform();
		Thread.sleep(2000);
		doClickElement(child);
		;
	}

	/**
	 * Multilevel handling
	 * 
	 * @param click1
	 * @param level1
	 * @param level2
	 * @param click2
	 * @throws InterruptedException
	 */
	public void parentChildMenu(By click1, By level1, By level2, By click2) throws InterruptedException {
		doClickElement(click1);
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(level1)).perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(level2)).perform();
		Thread.sleep(1000);
		doClickElement(click2);
	}

	public void doActionsClick(By locator) {
		act.click(driver.findElement(locator)).perform();
	}

	public void doActionsSendkeys(By locator, String value) {
		act.sendKeys(driver.findElement(locator), value).perform();
	}

	public void doSendkeysWithPause(By locator, String inputValue, long pauseTime) {
		char ch[] = inputValue.toCharArray();
		for (char e : ch) {
			act.sendKeys(getElement(locator), String.valueOf(e)).pause(pauseTime).perform();
		}
	}
	// ==================================== Wait Util ======================================//

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 *
	 * @param locator used to find the element
	 * @return the WebElement once it is located
	 */
	public WebElement waitForElementPresence(By locator, int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0. Default polling time is 500
	 * milliseconds
	 * 
	 * @param locator used to find the element
	 * @return the WebElement once it is located and visible
	 */
	public WebElement waitForElementVisibility(By locator, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Customize polling interval time
	 * 
	 * @param locator
	 * @param timeInSeconds
	 * @param pollingInterval
	 * @return WebElement
	 */

	public WebElement waitForElementVisibility(By locator, int timeInSeconds, int pollingInterval) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds),
				Duration.ofMillis(pollingInterval));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * wait for the element to be visible and enabled such that you can click on it
	 * 
	 * @param locator
	 * @param timeInSeconds
	 */
	public void waitForElementAndClick(By locator, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeInSeconds
	 */
	public List<WebElement> waitForElementsVisible(By locator, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking that there is at least one element present on a
	 * web page.
	 * 
	 * @param locator
	 * @param timeInSeconds
	 * @return
	 */
	public List<WebElement> waitForElementsPresence(By locator, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public String getTitleIs(String expectedTitle, int timeInSecond) {
		if (waitForTitleIs(expectedTitle, timeInSecond)) {
			return driver.getTitle();
		} else {
			throw new BrowserException("====TITLE IS NOT MATCHED====");
		}
	}

	public String getTitleContains(String fractionTitle, int timeInSecond) {
		if (waitForTitleContains(fractionTitle, timeInSecond)) {
			return driver.getTitle();
		} else {
			throw new BrowserException("====TITLE IS NOT MATCHED====");
		}
	}

	public boolean waitForTitleIs(String expectedTitle, int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		boolean flag = false;
		try {
			return wait.until(ExpectedConditions.titleIs(expectedTitle));
		} catch (TimeoutException e) {
			System.out.println("====TITLE IS NOT MATCHED====");
			return flag;
		}
	}

	public boolean waitForTitleContains(String fractionTitle, int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		boolean flag = false;
		try {
			return wait.until(ExpectedConditions.titleContains(fractionTitle));
		} catch (TimeoutException e) {
			System.out.println("====TITLE IS NOT MATCHED====");
			return flag;
		}
	}

	public String getURLIs(String expectedURL, int timeInSecond) {
		if (waitForTitleIs(expectedURL, timeInSecond)) {
			return driver.getCurrentUrl();
		} else {
			throw new BrowserException("====URL IS NOT MATCHED====");
		}
	}

	public String getURLContains(String fractionURL, int timeInSecond) {
		if (waitForTitleContains(fractionURL, timeInSecond)) {
			return driver.getCurrentUrl();
		} else {
			throw new BrowserException("====URL IS NOT MATCHED====");
		}
	}

	public boolean waitForURL(String expectedURL, int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		boolean flag = false;
		try {
			return wait.until(ExpectedConditions.urlMatches(expectedURL));
		} catch (TimeoutException e) {
			System.out.println("====URL IS NOT MATCHED====");
			return flag;
		}
	}

	public boolean waitForURLContains(String fractionURL, int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		boolean flag = false;
		try {
			return wait.until(ExpectedConditions.urlContains(fractionURL));
		} catch (TimeoutException e) {
			System.out.println("====URL IS NOT MATCHED====");
			return flag;
		}
	}

	// ========================= Wait for Alerts=============================
	public Alert waitForAlertAndSwitch(int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String getAlertText(int timeInSecond) {
		return waitForAlertAndSwitch(timeInSecond).getText();
	}

	public void acceptAlert(int timeInSecond) {
		waitForAlertAndSwitch(timeInSecond).accept();
	}

	public void dismissAlert(int timeInSecond) {
		waitForAlertAndSwitch(timeInSecond).dismiss();
	}

	public void enterValueOnAlert(int timeInSecond, String value) {
		waitForAlertAndSwitch(timeInSecond).sendKeys(value);
	}

	// ======================== Wait for Frames =============================
	public void waitForFrameUsingLocatorAndSwitchToIt(By locator, int timeInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void waitForFrameUsingLocatorAndSwitchToIt(int timeInSecond, int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameUsingLocatorAndSwitchToIt(int timeInSecond, String nameOrID) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
	}

	public void waitForFrameUsingLocatorAndSwitchToIt(int timeInSecond, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	// ========================= Wait for Window/Tab============================

	public boolean waitForNewWindowOrTab(int timeInSeconds, int expectedNumberOfWindows) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		try {
			if (wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows))) {
				return true;
			}
		} catch (TimeoutException e) {
			System.out.println("======Number Of Window is not Matched======");
		}
		return false;
	}
}
