package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/drag-and-drop");
		WebElement source = driver.findElement(By.id("column-a"));
		WebElement target = driver.findElement(By.id("column-b"));

		Actions act = new Actions(driver);
//		act.clickAndHold(source).moveToElement(target).release().build().perform();
		
		act.dragAndDrop(source, target).perform();

	}

}
