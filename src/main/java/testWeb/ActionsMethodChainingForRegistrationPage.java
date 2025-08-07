package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMethodChainingForRegistrationPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id("input-firstname"));

		Actions act = new Actions(driver);
		act.scrollByAmount(0, 500);

		act.sendKeys(element, "Prasad");
		act.sendKeys(Keys.TAB);
		act.sendKeys("Raut");
		act.sendKeys(Keys.TAB);
		act.sendKeys("test@test.com");
		act.sendKeys(Keys.TAB);
		act.build().perform();

		driver.quit();

	}

}
