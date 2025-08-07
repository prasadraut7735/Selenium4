package testWeb;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandling {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#datepicker")).click();
//		driver.findElement(By.xpath("//a[text()='28']")).click();

//		String actMonYr = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
//
//		while (!actMonYr.equalsIgnoreCase("November 2026")) {
//			driver.findElement(By.xpath("//a[@title='Next']")).click();
//			actMonYr = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
//		}
//		selectDay("28");

		selecteFutureDate("April 2026", 31);
//		selectePastDate("March 1998", 26);

	}

	public static void selectDay(int day) {
		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
	}

	public static void selecteFutureDate(String ExpectedMonYr, int day) {
		List<String> extraDayMonth = Arrays.asList("April", "June", "September", "November");

		for (String month : extraDayMonth) {
			if (ExpectedMonYr.contains(month) && day > 30) {
				throw new IllegalArgumentException("=======MENTIONED MONTH DOES NOT HAVE A DAY AS 31 =======");
			}
		}

		if (ExpectedMonYr.contains("February") && day > 29) {
			throw new IllegalArgumentException("=======WRONG DAY IS PASS FOR FEB MONTH=======");
		}

		if (day > 31 || day < 1) {
			throw new IllegalArgumentException("=======DAY SHOULD BE IN BETWEEN 1 To 31=======");
		}
		String actMonYr = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();

		while (!actMonYr.equalsIgnoreCase(ExpectedMonYr)) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			actMonYr = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		}
		selectDay(day);
	}

	public static void selectePastDate(String ExpectedMonYr, int day) {
		if (day > 31 || day < 1) {
			throw new IllegalArgumentException("=======PLEASE PASS THE CORRECT DATE=======");
		}
		String actMonYr = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();

		while (!actMonYr.equalsIgnoreCase(ExpectedMonYr)) {
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
			actMonYr = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		}
		selectDay(day);
	}
}
