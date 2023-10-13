package SeleniumTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver_Test008_WebElements {
	
	WebDriver driver;
	
	@Before
	public void BeforeTest() {
		
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\MyWorkSpace\\Curiosity\\Tools\\Drivers\\chromedriver.exe");
		
		//Step1: Web Driver Opening Chrome Browser 
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	
	@Test
	public void Test001_Login() throws InterruptedException {
		
		//Step2: Navigating to the Web Application
		driver.get("https://www.carsguide.com.au/");
		Thread.sleep(2000);
		
		//Step3: Going to the Sign In Page
		//driver.findElement(By.cssSelector("span.uhf-logged-out-show.uhf-user-label")).click();
		WebElement signInLink = driver.findElement(By.cssSelector("span.uhf-logged-out-show.uhf-user-label"));
		signInLink.click();
		Thread.sleep(2000);
		
		//Step4: Click on Sign In Tab
		//driver.findElement(By.linkText("SIGN IN")).click();
		WebElement signInTab = driver.findElement(By.linkText("SIGN IN"));
		signInTab.click();
		Thread.sleep(2000);
		
		//Step5: Entering Username
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ITCuriosity.selenium@gmail.com");
		WebElement userName =driver.findElement(By.xpath("//input[@name='email']"));
		userName.clear();
		userName.sendKeys("ITCuriosity.selenium@gmail.com");
		Thread.sleep(2000);
		
		//Step6: Entering Password
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test12345");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("Test12345");			
		Thread.sleep(2000);
		
		//Step7: Clicking Submit Button
		//driver.findElement(By.xpath("//button[@class='auth0-lock-submit']")).click();
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='auth0-lock-submit']"));
		submitButton.click();
		Thread.sleep(6000);
		
		//Step8: Verify the Account Name using Asserts		
		//String accountName = driver.findElement(By.cssSelector("Span.uhf-logged-in-show.uhf-user-label")).getText();
		WebElement Account = driver.findElement(By.cssSelector("Span.uhf-logged-in-show.uhf-user-label"));
	    String accountName = Account.getText();
		System.out.println("Actual value from Application::"+accountName );	
		Assert.assertEquals("John",accountName);		
		
		
	}
	
	@After
	public void AfterTest() {
		
		driver.quit();
		
	}
	

}
