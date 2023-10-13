package SeleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriver_Test006_ElementIdentificationLocators {
	
	//Creating Selenium WebDriver
	WebDriver driver;
	
	@Before
	public void BeforeTest() {
				
		//Launching Chrome Brower
		System.setProperty("webdriver.chrome.driver", 
				"C:\\MyWorkSpace\\Curiosity\\Tools\\Drivers\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		//WebDriver Navigating to WebSite
		driver.get("https://www.carsguide.com.au/");
		
	}
	
	@Test
	public void TestMethod01() throws InterruptedException {
		
		//****Identifying WebElement using Id locator
		//driver.findElement(By.id("search-submit")).click();
		//Thread.sleep(5000);
		
		//***Identify Webelement using LinkText
		//driver.findElement(By.linkText("More Filters")).click();
		//Thread.sleep(2000);
		
		//**** Identify Webelement using CSS Selector		
		driver.findElement(By.cssSelector("span.uhf-logged-out-show.uhf-user-label")).click();
		Thread.sleep(5000);
		
		//*** Identify Webelement by Name Locator
		driver.findElement(By.name("email")).sendKeys("ITCuriosity.selenium@gmail.com");
		Thread.sleep(1000);
		
		//**** identify Webelement by Class Locator
		//driver.findElement(By.className("auth0-lock-input-block.auth0-lock-input-password")).sendKeys("test1234");
		//Thread.sleep(2000);
		
		//*** Identify Webelement by Name Locator
		driver.findElement(By.name("password")).sendKeys("$Test12345");		
		Thread.sleep(2000);
		
		//******* Identify webelement by Xpath Locator
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("$Test12345");
		
		driver.findElement(By.name("given_name")).sendKeys("Jimmy");
		Thread.sleep(2000);
		
		driver.findElement(By.name("family_name")).sendKeys("Smith");
		Thread.sleep(2000);
		
		//******* Identify webelement by Xpath Locator
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(6000);
	}
	
	@After
    public void AfterTest() {
		
		driver.quit();
		
	}
	

}
