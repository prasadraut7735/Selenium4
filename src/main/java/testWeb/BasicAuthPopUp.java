package testWeb;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthPopUp {

	public static void main(String[] args) throws InterruptedException {
		// Basic Authentication pop-up: When the login page/or the page behind the
		// pop-up is not loading in that case it is call as Authentication pop-up

//		Auth pop-up are not js pop-up no need to switch
		/**
		 * Basic Authentication pop-up: When the login page/or the page behind the
		 * pop-up is not loading in that case it is called as Authentication pop-up Auth
		 * pop-up are not js pop-up no need to switch Repeat use of @ is not allowed Can
		 * not cancel the pop-up
		 */

		String username = "admin";
		String password = "admin";

		WebDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		// Selenium 4.x: HasAuthenticated

		((HasAuthentication) driver).register(() -> new UsernameAndPassword(username, password));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		Thread.sleep(3000);

		driver.quit();
	}

}
