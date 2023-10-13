package SeleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WebDriver_Test004_JunitTestRunner {
	
	@Before
	public void BeforeTest() {
		System.out.println(" Running Before Test :: Open Browser");
		
	}
	
	@Test
    public void Test001() {    	
    	System.out.println("Run Test001");
		
	}
    
	@Test
    public void Test002() {    	
    	System.out.println("Run Test002");
		
	}
    
	@After
    public void AfterTest() {    	
    	System.out.println("Running After Test :: Close Browser");
		
	}
}
