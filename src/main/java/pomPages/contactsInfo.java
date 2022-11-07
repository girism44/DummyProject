package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.TabNames;
import genericLibraries.WebDriverUtility;

public class contactsInfo {

	//@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	//WebElement contactsinfo;
	
	//private String dynamicPath="//a[.='%s']";
	
	public contactsInfo(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	//public void clickContact()
	//{
		//contactsinfo.click();
	//}
//	public void clickRequiredTab(WebDriverUtility webdriver, TabNames tabName)
//	{
//		
//		webdriver.convertStringToDynamicXpath(dynamicPath, tabName.getTabName()).click();
//		
//		
//	}
	
}
