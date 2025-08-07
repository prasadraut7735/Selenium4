package testWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowConcept {

	public static void main(String[] args) {

		/**
		 * Method is used to open anything in the new tab or new window
		 */

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		System.out.println(driver.getTitle());

		String parentWindow = driver.getWindowHandle();

//		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		System.out.println("=====================");
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
