package hardCoded;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase1 {

	public static void main(String[] args) throws InterruptedException {
		//launch chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Login with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		//Click on organization module
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		//Click on create new organization button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//Enter the mandatory fields  
		driver.findElement(By.name("accountname")).sendKeys("ver");
		driver.findElement(By.id("phone")).sendKeys("888888888");
		WebElement indtype = driver.findElement(By.name("industry"));
		Select s = new Select(indtype);
		s.selectByValue("Apparel");
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		//Click on the save button
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
		Thread.sleep(3000);
		//Click on the organization module
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		Thread.sleep(3000);
		//Logout from application
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		Thread.sleep(3000);
		//close the browser
		driver.close();
		}

}
