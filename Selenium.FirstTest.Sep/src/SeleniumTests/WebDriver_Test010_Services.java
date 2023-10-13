package SeleniumTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Test010_Services {
	
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
	public void Test_Select() throws InterruptedException {
		
		// Declaration of Explicit Wait 
		WebDriverWait wait = new WebDriverWait(driver,10);
				
		//Step2: Navigating to the Web Application
		driver.get("https://www.carsguide.com.au/");
		Thread.sleep(2000);
		
		WebElement carMakes = driver.findElement(By.id("makes"));
		wait.until(ExpectedConditions.elementToBeClickable(carMakes));
		
		Select carMakesDropDownList = new Select(carMakes);
		carMakesDropDownList.selectByVisibleText("BMW");
		Thread.sleep(2000);
		
		WebElement carModels = driver.findElement(By.id("models"));
		wait.until(ExpectedConditions.elementToBeClickable(carModels));		
		
		Select carModelsDropDownList = new Select(carModels);
		carModelsDropDownList.selectByValue("M135i");
		
		WebElement submitButton = driver.findElement(By.id("search-submit"));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		submitButton.click();
	}
	
	@After
	public void AfterTest() {
		
		driver.quit();
		
		}

}
