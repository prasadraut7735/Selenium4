																																																									package testWeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomX_PATH {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// XPATH: XML Path,HTML

//		1. Absolute xpath
//		2.Relative xpath

//		starts-with
//		(starts-with(@ID,'VALUE'));
//		(starts-with(text(),'VALUE'));
		
//		index: last()
//		(last())
//		(last()-1)
//		(last()-2)
//		(last()-n)

//		index: (position())
//		(position()=1)
//		(position()=2)
//		(position()=n)
//		(position()=last())
		
		
//		xpath-Axes

//		Backward traversing
		// input[@id='username']/../../../../
		// input[@id='username']/parent::div = For immediate parent

		// input[@id='username']/ancestor::form = to any parent

		// a[text()='Jasmine.Morgan']/parent::td/preceding-sibling::td/input

		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/ipl-2025-1449924/kolkata-knight-riders-vs-chennai-super-kings-57th-match-1473494/full-scorecard");
		Thread.sleep(3000);

//		driver.findElement(By.xpath("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input")).click();
//		selectUserCheckbox("Jasmine.Morgan");

//		List<WebElement> eleList = 
//				driver.findElements(By.xpath("//a[text()='Joe.Root']/parent::td/following-sibling::td"));
//		List<String> allEle = new ArrayList<String>();
//
//		for (WebElement e : eleList) {
//			String text = e.getText();
//			System.out.println(text);
//			allEle.add(text);
//		}

		// span[text()='Angkrish Raghuvanshi']/ancestor::td/following-sibling::td//span

		String text = driver
				.findElement(By.xpath("//span[text()='Angkrish Raghuvanshi']/ancestor::td/following-sibling::td//span"))
				.getText();
		System.out.println(text);
	}

	public static void selectUserCheckbox(String username) {
		driver.findElement(By.xpath("//a[text()='" + username + "']/parent::td/preceding-sibling::td/input")).click();
	}

	public static List<String> selectText(String username) {
		List<WebElement> eleList = driver
				.findElements(By.xpath("//a[text()='" + username + "']/parent::td/following-sibling::td"));
		List<String> allEle = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			allEle.add(text);
		}
		return allEle;
	}

}


// CSS Selector


/**
 * No Rule No Restriction: Only the TagName should be written first
 * Sequence or count of the class does not matters if multiple classes comes under same class
 * 
 * 
 *   CSS Selector is a locator
 *   1. ID ==     #id                     ex. #input-email
 *                tagName#id              input#input-email
 *   
 *   2. CLASS==   .classname              .form-control
 *                 tagName.classname       input.form-control 
 *                .c1.c2.c3..cn           .form-control.private-form_control.login-email
 *                 tagname.c1.c2.c3...cn   input.form-control.private-form_control.login-email
 *                 tagname.c1.c3           input.form-control.login-email
 *            
 *    3. ID and CLASS
 *    			
 *              	#id.classname          #username.login-email
 *                  .classname#id          .login-email#username
 *              
 *    4. TagName.CLASSNAME#ID
 *       TagName#ID.CLASSNAME
 *       TagName.C1#ID.C3,C2
 *       
 *    5. For AnyAttribute in CSS Selector
 *    
 *   				TagName[attr='value']
 *   				TagName[attr='value']#ID.CLASSNAME
 *   				TagName[attr='value'].CLASSNAME#ID
 *   				[attr='value']
 *   				[attr1='value'][attr2='value']
 *   				#ID[attr='value']
 *   				.CLASSNAME[attr='value']
 *   				.CLASSNAME[attr='value']#ID
 *   				#ID[attr='value'].CLASSNAME
 *   
 *   6. Text not supported in the CSS Selector
 *   
 *   7.CONTAINS
 *   			
 *         			TagName[attr *='Value']
 *         
 *   8. starts-with
 *   			
 *   				TagName[attr ^='Value']
 *   
 *   9. ends-with
 *                
 *                  TagName[attr $='Value']
 *
 *   10. Parent and Child
 *   
 *                  parentTagName ChildTagName      === Direct + Indirect* child
 *                  parentTagName > ChildTagName    === Direct child
 *
 *
 *	11. Child to Parent: NA  Backward Traversing is not applicable 
 *
 *	12. Sibling in CSS: Only following-sibling is allowed
 *					TagName + Following TagName
 *					label[for='input-email'] + input                                      ===immediate following sibling
 *					select#Form_getForm_Country > option[value='Afghanistan']~ option     ===All following sibling
 *					
 *
 *
 *
 *	13. Index in CSS Selector
 *
 *	select#Form_getForm_Country > option: nth-of-type(2)    ==2nd Index
 *	select#Form_getForm_Country > option: nth-of-type(n)	==All Index
 *	select#Form_getForm_Country > option: first-child
 *	select#Form_getForm_Country > option: last-child
 *	select#Form_getForm_Country > option: nth-child(5)
 *	select#Form_getForm_Country > option: nth-last-child(5)
 *	select#Form_getForm_Country > option: nth-last-child(n)
 *	select#Form_getForm_Country > option: nth-child(odd)
 *  select#Form_getForm_Country > option: nth-child(even)
 *	select#Form_getForm_Country > option: nth-child(n+4)    ==start the counting from 4 (Print value after 4)
 *	select#Form_getForm_Country > option: nth-child(4n)		==4*8*12 (Printing by multiplication)
 *
 *
 *
 *	## xpath ODD/EVEN
 *	//select[@id='Form_getForm_Country']/option[position() mod 2=1]       ==Odd	indexing value printing	
 *	//select[@id='Form_getForm_Country']/option[position() mod 2=0]       ==Even	indexing value printing
 *
 *
 *	14. Comma in CSS: Used for the elements present on the page or not with FE's
 *     input#username, input#password, button#loginBtn
 *
 *	15. not in CSS:
 *		input.form-control:not(input[name='search'])
 *		input.form-control:not(input[name='search']):not(#input-password)
 *
 */


