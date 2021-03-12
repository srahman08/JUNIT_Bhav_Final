package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Page {
//	WebDriver driver;
//	
//	public Base_Page(WebDriver driver) {
//		this.driver=driver;
//	}
		public void takeScreenshot(WebDriver driver)  {
			try {
			TakesScreenshot ts = ((TakesScreenshot) driver);
			SimpleDateFormat dateformat= new SimpleDateFormat("MMddyy_HHmmss");//check this out
			Date date= new Date();
			String label = dateformat.format(date);
			File filesource= ts.getScreenshotAs(OutputType.FILE);
			String currentDir=System.getProperty("user-dir");
			FileUtils.copyFile(filesource, new File(currentDir+"/newScreenshots/" + label + ".png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
						
		}
		public void dropDownMenu(WebElement element, String selectByVisibleText) {
			Select sel = new Select(element);
			sel.selectByVisibleText(selectByVisibleText);
		}
		public void waitforWebElement(WebDriver driver, int timeInSeconds, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.visibilityOf(element));
	}
		public  int randNumber  (int ranbound) {
			Random rndm= new Random();
				int randomN= rndm.nextInt(ranbound);
				return randomN;
			}

}
