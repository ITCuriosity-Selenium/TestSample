package SeleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriver_Test005_SimpleTest {
	
	//Creating Selenium WebDriver
	WebDriver driver;
	
	@Before
	public void BeforeTest() {
		
		//Launching Firefox Brower
		//driver = new FirefoxDriver();
		
		//Launching Chrome Brower
		System.setProperty("webdriver.chrome.driver", 
				"C:\\MyWorkSpace\\Curiosity\\Tools\\Drivers\\chromedriver.exe");
		driver =new ChromeDriver();			
		
		
		
	}
	
	@Test
	public void TestMethod01() {		
		
		//WebDriver Navigating to WebSite
				driver.get("https://www.carsguide.com.au/");		
	}
	
	@After
    public void AfterTest() {
		
		driver.quit();
		
	}
	

}
