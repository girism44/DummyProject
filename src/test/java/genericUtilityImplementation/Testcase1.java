package genericUtilityImplementation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertyFileutility;
import genericLibraries.TabNames;
import genericLibraries.WebDriverUtility;
import pomPages.CreateOrganization;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.NewOrgnizationInfoPage;
import pomPages.OrganizationsPage;

public class Testcase1 {

	public static void main(String[] args) throws IOException, InterruptedException  {
		//launch chrome browser
		WebDriverUtility webdriver = new WebDriverUtility();
		JavaUtility javautility = new JavaUtility();
		PropertyFileutility property = new PropertyFileutility();
		property.propertyFileInitialization(IConstantPath.PROPERTY_FILE_PATH);
		ExcelUtility excel = new ExcelUtility();
		excel.excelFileInitialization(IConstantPath.EXCEL_FILE_PATH);
		
		String browser =property.getDataFromPropertyFile("browser");
		String username =property.getDataFromPropertyFile("username");
		String password =property.getDataFromPropertyFile("password");
		String url =property.getDataFromPropertyFile("url");
		long time=Long.parseLong(property.getDataFromPropertyFile("time"));
		WebDriver driver=webdriver.openBrowserAndApplication(browser, url, time);
		
		//Login with valid credentials
		//driver.findElement(By.name("user_name")).sendKeys(username);
		//driver.findElement(By.name("user_password")).sendKeys(password);
		//driver.findElement(By.id("submitButton")).click();
		LoginPage login = new LoginPage(driver);
		HomePage home=new HomePage(driver);
		CreateOrganization corg= new CreateOrganization(driver);
		OrganizationsPage org = new OrganizationsPage(driver);
		NewOrgnizationInfoPage info = new NewOrgnizationInfoPage(driver);
		login.loginToAction(username, password);
		

		//Click on organization module
		//homepage.orgnizationClick();
		home.clickRequiredTab(webdriver, TabNames.ORGANNIZATIONS);
		
		//driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		//info.clickOrganization();
		//Click on create new organization button
		org.plusBtn();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//Enter the mandatory fields  
		
		String infoorgnizatio=corg.createOrgnization(webdriver, javautility, excel);
		System.out.println(infoorgnizatio);
	//	Map<String,String> map=excel.fetchMultipleDataBasedOnKeyFromExcel("Sheet1", "Create Organization");
		
		//String newOrgnizationName=map.get("Organization Name")+javautility.generateRandomNumber(100);
		//driver.findElement(By.name("accountname")).sendKeys(newOrgnizationName);
		//driver.findElement(By.id("phone")).sendKeys("888888888");
		//WebElement indtype = driver.findElement(By.name("industry"));
		//Select s = new Select(indtype);
		//s.selectByValue("Apparel");
		//webdriver.dropDown(indtype, map.get("Industry"));
		
		//driver.findElement(By.xpath("//input[@value='T']")).click();
		//Click on the save button
		//driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
	
		//Click on the organization module
		//homepage.orgnizationClick();
		//homepage.clickRequiredTab(webdriver, TabNames.ORGANNIZATIONS);
		info.clickOrganization();
		Thread.sleep(3000);
		//WebElement btn=driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']"));
		//btn.click();
		
		//WebElement orgnizationName = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[3]/a")).getText();
		//System.out.println(orgnizationName);
		if(home.getCheck().equalsIgnoreCase(infoorgnizatio))
		{
			System.out.println("Test case is passed");
			excel.writeDataIntoExcel("Sheet1", "pass", IConstantPath.EXCEL_FILE_PATH, "Create Organization");
		}
		//else
		{
			System.out.println("Test case is failed");
			excel.writeDataIntoExcel("Sheet1", "fail", IConstantPath.EXCEL_FILE_PATH, "Create Organization");
		}
		//Logout from application
		home.mouseHoverToLogoutImage(webdriver);
		
		
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
		//close the browser
		webdriver.closeBrowser();
		excel.closeExcel();
		}

}
