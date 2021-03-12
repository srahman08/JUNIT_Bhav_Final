package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Factory {
	static WebDriver driver;
	static String browser=null;
	static String url=null;
	
	
	/*public static void readConfig() {
		Properties prop = new Properties();
		try {		
			InputStream iostream = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(iostream);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	
	public static WebDriver init() {//may have to make it static
	
		readConfig();
		if (browser .equalsIgnoreCase("cHrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		
		}
*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void ConfigProp() {
	Properties prop = new Properties();
	try {		
		InputStream iostream = new FileInputStream("src\\main\\java\\config\\config.properties");
		prop.load(iostream);
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
	}catch(IOException e) {
		e.printStackTrace();
	}
		
	}
	
	public static WebDriver launchBrowser ( ) {
		ConfigProp();
		//driver = new ChromeDriver();
			//String path=System.getProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		if (browser .equalsIgnoreCase("cHrome")) {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "chromedriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	public  void tearDown() {
		driver.close();
		driver.quit();
	}	
	
	

}
