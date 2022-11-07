package TestNGImp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.Baseclass;
import genericLibraries.IConstantPath;
import genericLibraries.TabNames;

//@Listeners(genericLibraries.ListenerImplementation.class)
public class Testcase1 extends Baseclass {
	@Test
	public void tc1()
	{

	home.clickRequiredTab(webdriver, TabNames.ORGANNIZATIONS);
	org.plusBtn();
	String infoorgnizatio=corg.createOrgnization(webdriver, javautility, excel);
	//home.clickRequiredTab(webdriver, TabNames.ORGANNIZATIONS);
	info.orgclick();
	
	WebElement orgnizationName = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[3]/a"));
	System.out.println(orgnizationName);
	if(orgnizationName.equals(infoorgnizatio))
	{
		System.out.println("Test case is passed");
		excel.writeDataIntoExcel("Sheet1", "pass", IConstantPath.EXCEL_FILE_PATH, "Create Organization");
	}
	else
	{
		System.out.println("Test case is failed");
		excel.writeDataIntoExcel("Sheet1", "fail", IConstantPath.EXCEL_FILE_PATH, "Create Organization");
	}
	
    }
}
