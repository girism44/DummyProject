package pomPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.ExcelUtility;
import genericLibraries.JavaUtility;
import genericLibraries.WebDriverUtility;

public class CreateOrganization {
	@FindBy(name="accountname")
	private WebElement orgnizationNametf;
	
	@FindBy(name="industry")
	private WebElement industrydd;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupRadio;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignedToGroupdd;
	
	@FindBy(xpath = "//input[contains(@value,'Save')]")
	private WebElement saveButton;
	
	public CreateOrganization(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	public String createOrgnization(WebDriverUtility webdriver,JavaUtility javautility,ExcelUtility excelutility)
	{
		Map<String,String> map=excelutility.fetchMultipleDataBasedOnKeyFromExcel("Sheet1", "Create Organization");
		String neworgnizationName= map.get("Organization Name")+javautility.generateRandomNumber(100);
		orgnizationNametf.sendKeys(neworgnizationName);
		webdriver.dropDown(industrydd, map.get("Industry"));
		groupRadio.click();
		//webdriver.dropDown(assignedToGroupdd, map.get("Group"));
		saveButton.click();
	
		return neworgnizationName;
		
	}

}
