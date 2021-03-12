package testJunit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage_tf101;
import util.Browser_Factory;

public class TestPage {
	static WebDriver driver;
	HomePage_tf101 hp_101;
	@BeforeClass
	public static void startChrome() {
		driver = Browser_Factory.launchBrowser();
	}
	
	@Test
	public void TestHomePage() {
	//	driver = Browser_Factory.launchBrowser();
		hp_101=PageFactory.initElements(driver, HomePage_tf101.class);
		//hp_101.inputCategory();
		hp_101.inputAndEnterMultipleTODOCategory();
	hp_101.checkToogle();
	hp_101.validateToogleAll();
//	hp_101.deleteOneTODO();
//	hp_101.validateOne();
//	hp_101.deleteAllTODO();
//	hp_101.validateDeleteAll();		
			
	}

}
