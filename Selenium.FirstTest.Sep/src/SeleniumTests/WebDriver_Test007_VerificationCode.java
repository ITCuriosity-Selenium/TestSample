package SeleniumTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver_Test007_VerificationCode {
	
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
		driver.findElement(By.cssSelector("span.uhf-logged-out-show.uhf-user-label")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("SIGN IN")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ITCuriosity.selenium@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test12345");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='auth0-lock-submit']")).click();
		Thread.sleep(6000);
		String accountName = driver.findElement(By.cssSelector("Span.uhf-logged-in-show.uhf-user-label")).getText();
		System.out.println("Actual value from Application::"+accountName );		
		
		//Step4: Verify the Account Name using Asserts
		Assert.assertEquals("John",accountName);
		
		//Other Assert
		//Assert.assertEquals(true, true);
		//Assert.assertEquals(25, 25);
		
	}
	
	@After
	public void AfterTest() {
		
		driver.quit();
		
	}
	

}
