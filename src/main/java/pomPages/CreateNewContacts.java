package pomPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.ExcelUtility;
import genericLibraries.JavaUtility;
import genericLibraries.WebDriverUtility;

public class CreateNewContacts {
	@FindBy(name="firstname")
	private WebElement firstNametf;
	
	@FindBy(xpath="(//select[@class='small'])[2]")
	private WebElement namedd;
	
	@FindBy(name="lastname")
	private WebElement lastNametf;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement img;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement orgplus;
	
	@FindBy(xpath="//a[.='ONE13']")
	private WebElement orgname;
	
	@FindBy(xpath="(//input[@type='submit'])[2]")
	private WebElement savebtn;
	
	public CreateNewContacts(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	public String createContacts(ExcelUtility excelutility, JavaUtility javautility, WebDriverUtility webdriver)
	{
		
		Map<String,String> map=excelutility.fetchMultipleDataBasedOnKeyFromExcel("Sheet1", "New Contact");
		//webdriver.dropDown(namedd, map.get("First Name Salution"));
		//String newContactsName= map.get("First Name one")+javautility.generateRandomNumber(100);
		firstNametf.sendKeys(map.get("First Name"));
		String newLastName= map.get("Lastname")+javautility.generateRandomNumber(100);
		lastNametf.sendKeys(map.get("Lastname"));
		//orgplus.click();
	  //  webdriver.handleChildBrowserPopup(orgname);
	   // orgname.click();
	   // webdriver.getParentWindow();
		img.sendKeys(map.get("Contact Image"));
	
		//webdriver.dropDown(assignedToGroupdd, map.get("Group"));
		savebtn.click();
	
		return newLastName;		
	}
	//public String createduplicateContacts(ExcelUtility excelutility, JavaUtility javautility, WebDriverUtility webdriver)
	//{
		
		//Map<String,String> map=excelutility.fetchMultipleDataBasedOnKeyFromExcel("Sheet1", "New Contact");
		//webdriver.dropDown(namedd, map.get("First Name Salution"));
		//String newContactsName= map.get("First Name one")+javautility.generateRandomNumber(100);
		//firstNametf.sendKeys(newContactsName);
		//String newLastName= map.get("duplicate last name")+javautility.generateRandomNumber(100);
		//lastNametf.sendKeys(map.get("Lastname"));
		//orgplus.click();
	  //  webdriver.handleChildBrowserPopup(orgname);
	   // orgname.click();
	   // webdriver.getParentWindow();
		//img.sendKeys(map.get("Contact Image"));
	
		//webdriver.dropDown(assignedToGroupdd, map.get("Group"));
		//savebtn.click();
	
		//return newLastName;		
	//}
	

}
