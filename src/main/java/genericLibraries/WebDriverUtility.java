package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class gives reusable method to perform web driver actions
 * @author Hp(GirishGiri)
 *
 */
public class WebDriverUtility {
	WebDriver driver;
	/**
	 * This method is used to launch browser and maximize
	 * @param browser
	 * @return
	 */
	public WebDriver openBrowser(String browser)
	{
		switch(browser)
		{
		case"chrome":WebDriverManager.chromedriver().setup();
					driver= new ChromeDriver();
					break;
		case"firefox":WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		break;
		default:System.out.println("Invalid browsername:");break;
		}
		driver.manage().window().maximize();
		return driver;
	}
	/**
	 * This method is used to navigate to application
	 * @param url
	 */
	public void navigateToApplicatio(String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used to wait until page gets loaded
	 * @param Time
	 */
	public void waitTillPageLoad(long Time)
	{
		driver.manage().timeouts().implicitlyWait(Time, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to open the browser and navigate to application
	 * @param browser 
	 * @param url 
	 * @param time 
	 * @return 
	 */
	public WebDriver openBrowserAndApplication(String browser, String url, long time)
	{
		openBrowser(browser);
		navigateToApplicatio(url);
		waitTillPageLoad(time);
		return driver;
	}
	/**
	 * This method is used to handle move to Element
	 * @param element
	 */
	public void mouseHoverToElement(WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	/**
	 * This method is used to handle drop down
	 * @param element 
	 */
	//public void dropDown(WebElement element)
	//{
		//Select s = new Select(element);
		//s.selectByIndex(0);
	//}
	public void dropDown(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	//public void dropDown(WebElement element,int  value)
	//{
		//Select s = new Select(element);
		//s.selectByValue(null);
	//}
	/**
	 * This method is used to switch to frame
	 */
	public void switchFrame(String index )
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch back to parent frame
	 */
	public void switchBackToFrame()
	{  
		driver.switchTo().defaultContent();
		
	}
	/**
	 * This method is used scroll the webpage till the element
	 * @param element 
	 */
	public void scrollTilElement(Object element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	public void getScreenshot(JavaUtility javautility,WebDriver driver,String classname)
	{
		String currentTime = javautility.currentTime(); 
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src =  ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+classname+"_"+currentTime+".png");
		//File dest= new File("C:/projectScreenshots"+classname+"_"+currentTime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * This method is used to close browser
	 */
	public void closeBrowser()
	{
		driver.close();
	}
	/**
	 * This method is used to handle alert popup
	 */
	public void alertPopUp()
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to handel parent window
	 */
	public String getParentWindow()
	{
		return driver.getWindowHandle();
	}
	/**
	 * This method is used to switch to specified window
	 * @param windowID
	 */
	public void switchToWindow(String windowID)
	{
		driver.switchTo().window(windowID);
	}
	/**
	 * This method is used to handel child browser popup
	 * @param exceptedTitles 
	 */
	public void handleChildBrowserPopup(Object exceptedTitles)
	{
		Set<String> windowTitles = driver.getWindowHandles();
		for(String windowID:windowTitles)
		{
			driver.switchTo().window(windowID);
		String actualTitle=	driver.getTitle();
		if(actualTitle.equals(exceptedTitles));
		break;
		}
	}
	/**
	 * This method is used to convert String to dynamic xpath
	 * @param dynamicPath 
	 * @param replaceData 
	 */
	public WebElement convertStringToDynamicXpath(String dynamicPath, String replaceData)
	{
		String requiredPath = String.format(dynamicPath,replaceData); 
	     WebElement tab = driver.findElement(By.xpath(requiredPath));
		return tab;
	}
	

}
