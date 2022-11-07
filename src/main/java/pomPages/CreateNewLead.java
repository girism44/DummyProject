package pomPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.ExcelUtility;
import genericLibraries.JavaUtility;
import genericLibraries.WebDriverUtility;

public class CreateNewLead {
	
	@FindBy(name="salutationtype")
	private WebElement firstnamesal;
	
	@FindBy(name="firstname")
	private WebElement firstNametf;
	
	@FindBy(name="lastname")
	private WebElement lastNametf;
	
	@FindBy(name="company")
	private WebElement companytf;
	
	@FindBy(xpath="(//input[@value='  Save  '])[2]")
	private WebElement savebtn; 
	
	public CreateNewLead(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	
	public String addLeadDetalis(ExcelUtility excelutility,JavaUtility javautility,WebDriverUtility webdriverutility)
	{
		Map<String,String> map=excelutility.fetchMultipleDataBasedOnKeyFromExcel("Sheet1","Edit Lead" );
		//webdriverutility.dropDown(firstnamesal, map.get("First Name Salution"));
		String newLeadName=map.get("Lastname")+javautility.generateRandomNumber(100);
		lastNametf.sendKeys(newLeadName);
		firstNametf.sendKeys(map.get("First Name"));
		companytf.sendKeys(map.get("Company"));
		savebtn.click();
		return newLeadName;
				
	}
	public String addDuplicateLeadDetalis(ExcelUtility excelutility,JavaUtility javautility,WebDriverUtility webdriverutility)
	{
		Map<String,String> map=excelutility.fetchMultipleDataBasedOnKeyFromExcel("Sheet1","Edit Lead" );
		//webdriverutility.dropDown(firstnamesal, map.get("First Name Salution"));
		//String newLeadName=map.get("Lastname")+javautility.generateRandomNumber(100);
		String newDuplicatelastname=map.get("duplicate last name");
		lastNametf.sendKeys(newDuplicatelastname);
		//lastNametf.sendKeys(newLeadName);
		//firstNametf.sendKeys(map.get("First Name"));
		//companytf.sendKeys(map.get("Company"));
		savebtn.click();
		return newDuplicatelastname;
				
	}
	
	
	
	
	
	
	

}
