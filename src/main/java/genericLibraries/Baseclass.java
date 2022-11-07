package genericLibraries;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pomPages.CreateNewContacts;
import pomPages.CreateOrganization;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.NewOrgnizationInfoPage;
import pomPages.OrganizationsPage;
import pomPages.contactsInfo;
import pomPages.contactsListPage;

public class Baseclass {
	protected WebDriverUtility webdriver;
	protected JavaUtility javautility;
	protected PropertyFileutility property;
	protected ExcelUtility excel;
	protected LoginPage login;
	protected HomePage home;
	protected OrganizationsPage org;
	protected CreateOrganization corg;
	protected NewOrgnizationInfoPage info;
	protected WebDriver driver;
	protected contactsInfo cinfo;
	protected CreateNewContacts contacts;
	protected contactsListPage list;
	public static WebDriver sdriver;
	public static JavaUtility sjavautility;

	// @BeforeSuite
	@BeforeTest
	public void testSetup() {
		webdriver = new WebDriverUtility();
		javautility = new JavaUtility();
		property = new PropertyFileutility();
		excel = new ExcelUtility();

	}

	@BeforeClass
	public void classSetUp() throws IOException {
		property.propertyFileInitialization(IConstantPath.PROPERTY_FILE_PATH);
		excel.excelFileInitialization(IConstantPath.EXCEL_FILE_PATH);
		String browser = property.getDataFromPropertyFile("browser");
		String url = property.getDataFromPropertyFile("url");
		long time = Long.parseLong(property.getDataFromPropertyFile("time"));
		driver = webdriver.openBrowserAndApplication(browser, url, time);
		sdriver=driver;
		sjavautility=javautility;
		login = new LoginPage(driver);

	}

	@BeforeMethod
	public void methodSetUp() throws IOException {
		home = new HomePage(driver);
		corg = new CreateOrganization(driver);
		org = new OrganizationsPage(driver);
		info = new NewOrgnizationInfoPage(driver);
		list = new contactsListPage(driver);
		contacts = new CreateNewContacts(driver);
		cinfo = new contactsInfo(driver);
		String username = property.getDataFromPropertyFile("username");
		String password = property.getDataFromPropertyFile("password");
		login.loginToAction(username, password);
	}

	@AfterMethod
	public void methodTearDown() {

		home.clickAdmin(webdriver);
		// home.mouseHoverToLogoutImage(webdriver);
		home.clickRequiredTab(webdriver, TabNames.SIGNOUT);

	}

	@AfterClass
	public void classTearDown() {
		webdriver.closeBrowser();
	}

	@AfterTest
	public void testTearDown() {
		excel.closeExcel();
	}
	// @AfterSuite

}
