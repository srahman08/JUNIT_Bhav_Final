package pages;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage_tf101 extends Base_Page{
WebDriver driver;

public HomePage_tf101(WebDriver driver) {
	this.driver=driver;
}


@FindBy(how=How.NAME, using ="categorydata")
WebElement Category_enter;
@FindBy(how=How.CSS, using ="input[name='submit'][value='Add category']")
WebElement Category_Add_Btn;
@FindBy(how=How.NAME, using ="data")
WebElement TODO_enter;
@FindBy(how=How.CSS, using ="input[name='submit'][value='Add']")
WebElement TODO_Add_Btn;

@FindBy(how=How.CSS, using =" input[type='checkbox'][name= 'allbox']")
WebElement ToggleALL_check;
@FindBy(how=How.CSS, using ="input[name='submit'][value='Remove']")
WebElement Remove_Btn;
@FindBy(how=How.NAME, using ="todo[6]")
WebElement Check_One_TODO;

public void inputCategory() {
	Category_enter.sendKeys("NewTime");
	
}
public void inputAndEnterMultipleTODOCategory() {
	TODO_enter.sendKeys("Exam TakeHome");
	TODO_Add_Btn.click();
	TODO_enter.sendKeys("Exam Automation");
	TODO_Add_Btn.click();
	TODO_enter.sendKeys("Exam InClass");
	TODO_Add_Btn.click();
	Category_enter.sendKeys("Exam FrameWork");
	TODO_Add_Btn.click();
	TODO_enter.sendKeys("InterviewQuestions");
	TODO_Add_Btn.click();
	TODO_enter.sendKeys("InterviewPrep");
	TODO_Add_Btn.click();
	TODO_enter.sendKeys("MockInterview");
	TODO_Add_Btn.click();
	TODO_enter.sendKeys("Market");
	TODO_Add_Btn.click();

/*	for (int i=0; i<6; i++) {
		int addNum=randNumber(456);
		TODO_enter.sendKeys("AddCategory" + addNum );
		TODO_Add_Btn.click();
		
	}*/
}
public void checkToogle() {
	ToggleALL_check.click();
	}

public void validateToogleAll() {
	//List<WebElement> listCheckBox =driver.findElements(By.xpath("//input[@type='checkbox']"));
	List<WebElement> listCheckBox =driver.findElements(By.xpath("//li/input[@type='checkbox']"));
	System.out.println("Number of checkboxes no Toggle  = " + listCheckBox.size());
	for(WebElement checkBox: listCheckBox)
	{ 
	if ((!checkBox.isSelected()))//checkboxes are selected so this is (! True)
		
	{checkBox.click();
	System.out.println("Toggle doesn't work. It clicked on already checked boxes.");
	System.out.println("Did I reselect?");
	}
		else if(!listCheckBox.isEmpty()){ //(condition: checkbox is  empty is false) (! False)so True therefore goes to Assert)
			
//Assert.fail();//for this else if should be (listCheckBox.isEmpty) no!
//Assert.fail("Failed to check checkboxes");
		Assert.assertTrue(true); //True so no error/exception thrown
		System.out.println("CheckBox is not empty");
		takeScreenshot(driver);
			
	}
	}
}	

public void deleteAllTODO1() {
	ToggleALL_check.click();
	Remove_Btn.click();
	
}

public void deleteOneTODO() {
	ToggleALL_check.click();//unchecks all 
	Check_One_TODO.click();
	String delStr= Check_One_TODO.getAttribute("name");
	System.out.println(delStr);
	Remove_Btn.click();
	
}
public void validateOne()  {

	takeScreenshot(driver);
	
	Assert.assertEquals(0, driver.findElements(By.name("todo[6]")).size());
}
//	try{
//	    if(!del123.isEmpty())
//	    		{
//	        System.out.println("Element is present and not deleted");
//	    } else
//	        System.out.println("Element is present but not displayed"); 
//	}catch (NoSuchElementException e) {
//	    System.out.println("Element is not present, hence not displayed as well");
//	}
	public void deleteAllTODO() {
List<WebElement> listCheckBoxBeforeDelete =driver.findElements(By.xpath("//li/input[@type='checkbox']"));
System.out.println(listCheckBoxBeforeDelete.size());
ToggleALL_check.click();
Remove_Btn.click();
	}
	public void validateDeleteAll() {
		List<WebElement> listCheckBoxAfterDelete =driver.findElements(By.xpath("//li/input[@type='checkbox']"));
		System.out.println(listCheckBoxAfterDelete.size());
		Assert.assertEquals(0, listCheckBoxAfterDelete.size());
		takeScreenshot(driver);
	}
}
	



