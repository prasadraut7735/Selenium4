package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * 'Type= file'= is mandatory, should be there then and then the below way will
		 * work
		 */

		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/upload");

		WebElement choosefile = driver.findElement(By.name("file"));
		choosefile.sendKeys("C:\\Users\\prasadr\\OneDrive - SteepGraph Systems Pvt Ltd\\Desktop\\TestEMail.txt");

	}

}
