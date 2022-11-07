package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.TabNames;
import genericLibraries.WebDriverUtility;

public class NewOrgnizationInfoPage {

	@FindBy(xpath="//a[@href='index.php?module=Home&action=index&parenttab=My Home Page']")
	private WebElement orginfo;
	//private String dynamicPath="//a[.='%s']";
	//@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	//private WebElement organizationsLink;
	//a[@href='index.php?module=Accounts&action=index']
public NewOrgnizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This Method is used to click on the required tab in homepage
	 * @param webdriver
	 * @param tabName
	 */
	//public void clickRequiredTab(WebDriverUtility webdriver, TabNames tabName)
	//{
	//	webdriver.convertStringToDynamicXpath(dynamicPath, tabName.getTabName()).click();
	//}
	public void orgclick()
	{
		orginfo.click();
	}
		
	public void clickOrganization() {
	//	organizationsLink.click();
	}
}
