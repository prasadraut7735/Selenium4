package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("#imageTemplateContainer img")).click();
		Thread.sleep(8000);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id*='frame-one']")));
		driver.findElement(By.cssSelector("input.text_field#RESULT_TextField-1")).sendKeys("Test");
		WebElement download = driver.findElement(By.cssSelector("#RESULT_FileUpload-6"));
		download.sendKeys("C:\\Users\\prasadr\\OneDrive - SteepGraph Systems Pvt Ltd\\Desktop\\TestEmail.txt");
		// driver.switchTo().defaultContent();
//		String text = driver.findElement(By.cssSelector(" h3.details__form-preview-title")).getText();
//		System.out.println(text);
		// driver.quit();
	}

}
