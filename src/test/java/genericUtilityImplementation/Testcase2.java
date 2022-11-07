package genericUtilityImplementation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertyFileutility;
import genericLibraries.TabNames;
import genericLibraries.WebDriverUtility;
import pomPages.CreateNewContacts;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.contactsInfo;
import pomPages.contactsListPage;

public class Testcase2 {
	public static void main(String[] args) throws IOException {
		
	
	WebDriverUtility webdriver= new WebDriverUtility();
	JavaUtility javautility = new JavaUtility();
	PropertyFileutility property = new PropertyFileutility();
	property.propertyFileInitialization(IConstantPath.PROPERTY_FILE_PATH);
	ExcelUtility excel = new ExcelUtility();
	excel.excelFileInitialization(IConstantPath.EXCEL_FILE_PATH);
	
	String browser=property.getDataFromPropertyFile("browser");
	String url=property.getDataFromPropertyFile("url");
	String username=property.getDataFromPropertyFile("username");
	String password=property.getDataFromPropertyFile("password");
	Long time=Long.parseLong(property.getDataFromPropertyFile("time"));
	
	WebDriver driver = webdriver.openBrowserAndApplication(browser, url, time);
	LoginPage login = new LoginPage(driver);
	HomePage home = new HomePage(driver);
	contactsListPage list= new contactsListPage(driver);
	CreateNewContacts contacts= new CreateNewContacts(driver);
	contactsInfo info = new contactsInfo(driver);
	
	login.loginToAction(username, password);
	home.clickRequiredTab(webdriver, TabNames.CONTACTS);
	//home.contactsClick();
	list.plusbtn();
	String newContacts=contacts.createContacts(excel, javautility, webdriver);
	home.clickRequiredTab(webdriver, TabNames.CONTACTS);
	//info.clickRequiredTab(webdriver, TabNames.CONTACTS);
	System.out.println(newContacts);
	//String name=home.getCheck();
	
	if(home.getCheck().equalsIgnoreCase(newContacts))
	//if(contactsName.equals(newContacts))
	{
		System.out.println("Test case is passed");
		excel.writeDataIntoExcel("Sheet1", "pass", IConstantPath.EXCEL_FILE_PATH, "New Contact");
	}
	else
	{
		System.out.println("Test case is failed");
		excel.writeDataIntoExcel("Sheet1", "fail", IConstantPath.EXCEL_FILE_PATH, "New Contact");
	}
	
	
	webdriver.closeBrowser();
	excel.closeExcel();
	
	
	
	
	
	
	}

}
