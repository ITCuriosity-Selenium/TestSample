package SeleniumTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class WebDriver_Test011_HoverAction2 {
	
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
	public void  Test_Hover() throws InterruptedException {
		
		// Declaration of Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Step2: Navigating to the Web Application
		driver.get("https://www.carsguide.com.au/");
		Thread.sleep(2000);	
		
		WebElement guides = driver.findElement(By.linkText("guides"));
		wait.until(ExpectedConditions.elementToBeClickable(guides));
		
		Actions hover = new Actions(driver);
		hover.moveToElement(guides).build().perform();
		Thread.sleep(2000);
		
		WebElement AdventureGuide = driver.findElement(By.linkText("adventureguide"));
		wait.until(ExpectedConditions.elementToBeClickable(AdventureGuide));
		AdventureGuide.click();
		Thread.sleep(2000);
		
		Assert.assertEquals("https://www.carsguide.com.au/adventure", driver.getCurrentUrl());
	
		
	}
	
	
	@After
	public void AfterTest() {
		
		driver.quit();
		
		}

}
