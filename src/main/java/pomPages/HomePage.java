package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.TabNames;
import genericLibraries.WebDriverUtility;

public class HomePage {
	
//	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
//	private WebElement Orgnizationbtn;
//	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
//	private WebElement Contacts;
    @FindBy(xpath="//table[@class='lvt small']/tbody/tr[last()]/td[3]/a")
	private WebElement check;
    @FindBy(xpath="//table[@class='lvt small']/tbody/tr[last()-1]/td[4]/a")
    private WebElement lastcheck;
//	@FindBy(xpath="//a[@href='index.php?module=Leads&action=index']")
//	private WebElement lead;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutimg;
	
	private String dynamicPath="//a[.='%s']";
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	/**
	 * This Method is used to click on the required tab in homepage
	 * @param webdriver
	 * @param tabName
	 */
	public void clickRequiredTab(WebDriverUtility webdriver, TabNames tabName)
	{
	
		webdriver.convertStringToDynamicXpath(dynamicPath, tabName.getTabName()).click();
	
	}
	public String getCheck() {
		return check.getText();
	}
	public String getlastCheck() {
		return lastcheck.getText();
	}


	public void clickAdmin(WebDriverUtility webdriver)
	{
		logoutimg.click();
	}

	public void mouseHoverToLogoutImage(WebDriverUtility webdriver) {
		webdriver.mouseHoverToElement(logoutimg);
		//webdriver.mouseHoverToElement(logoutimg);
	}
//	public void orgnizationClick()
//	{
//		Orgnizationbtn.click();
//	}
//	public void contactsClick()
//	{
//		Contacts.click();
//	}
//	public void leadClick()
//	{
//		lead.click();
//	}

}
