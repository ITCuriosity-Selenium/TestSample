package SeleniumTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Test009_Waits {
	
	WebDriver driver;
	
	@Before
	public void BeforeTest() {
		
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\MyWorkSpace\\Curiosity\\Tools\\Drivers\\chromedriver.exe");
		
		//Step1: Web Driver Opening Chrome Browser 
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void Test001_Login() throws InterruptedException {
		// Declaration of Explicit Wait 
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		//Step2: Navigating to the Web Application
		driver.get("https://www.carsguide.com.au/");
		Thread.sleep(2000);
		
		//Step3: Going to the Sign In Page			
		WebElement signInLink = driver.findElement(By.cssSelector("span.uhf-logged-out-show.uhf-user-label"));
		
		//Implementation of explicit wait by Locator 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.uhf-logged-out-show.uhf-user-label")));
		signInLink.click();		
		
		//Step4: Click on Sign In Tab		
		WebElement signInTab = driver.findElement(By.linkText("SIGN IN"));		
		//Implementation of explicit wait by WebElement
		wait.until(ExpectedConditions.elementToBeClickable(signInTab));
		signInTab.click();
				
		//Step5: Entering Username		
		WebElement userName =driver.findElement(By.xpath("//input[@name='email']"));
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.clear();
		userName.sendKeys("ITCuriosity.selenium@gmail.com");		
		
		//Step6: Entering Password	
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys("Test12345");			
		
		//Step7: Clicking Submit Button		
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='auth0-lock-submit']"));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		submitButton.click();
		Thread.sleep(6000);
				
		//Step8: Verify the Account Name using Asserts		
		WebElement Account = driver.findElement(By.cssSelector("Span.uhf-logged-in-show.uhf-user-label"));
	    wait.until(ExpectedConditions.textToBePresentInElement(Account, "John"));
		String accountName = Account.getText();
		System.out.println("Actual value from Application::"+accountName );	
		Assert.assertEquals("John",accountName);		
		
		
	}
	
	@After
	public void AfterTest() {
		
		driver.quit();
		
	}
	

}
