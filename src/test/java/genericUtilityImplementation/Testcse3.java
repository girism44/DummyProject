package genericUtilityImplementation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertyFileutility;
import genericLibraries.TabNames;
import genericLibraries.WebDriverUtility;
import pomPages.CreateNewLead;
import pomPages.DuplicateLeadPage;
import pomPages.HomePage;
import pomPages.LeadInfoPage;
import pomPages.LeadListPage;
import pomPages.LoginPage;

public class Testcse3 {

	public static void main(String[] args) throws IOException, InterruptedException {

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
		LeadListPage list = new LeadListPage(driver);
		CreateNewLead lead= new CreateNewLead(driver);
		LeadInfoPage info = new LeadInfoPage(driver);
		DuplicateLeadPage duplicate = new DuplicateLeadPage(driver);
		
		login.loginToAction(username, password);
		home.clickRequiredTab(webdriver, TabNames.LEADS);
		//home.leadClick();
		list.leadPlus();
		String newLead=lead.addLeadDetalis(excel, javautility, webdriver);
		System.out.println(newLead);
		info.duplicateClick();
		String newDuplicateLead=lead.addDuplicateLeadDetalis(excel, javautility, webdriver);
		System.out.println(newDuplicateLead);
		info.leadClick();
		
		
	if(home.getCheck().equalsIgnoreCase(home.getlastCheck()))
			{
				System.out.println("Test case is passed");
				excel.writeDataIntoExcel("Sheet1", "pass", IConstantPath.EXCEL_FILE_PATH, "Edit Lead");
			}
			else
			{
				System.out.println("Test case is failed");
				excel.writeDataIntoExcel("Sheet1", "fail", IConstantPath.EXCEL_FILE_PATH, "Edit Lead");
			}
			
			

		webdriver.closeBrowser();
		excel.closeExcel();
				
	}
}
