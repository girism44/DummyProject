package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactsListPage {
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contactsPlus;
	
	public contactsListPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	public void plusbtn()
	{
		contactsPlus.click();
	}

}
