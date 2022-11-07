package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicateLeadPage {
	
	@FindBy(name="lastname")
	private WebElement lastnametf;
	
	public DuplicateLeadPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	public void sendLastname()
	{
		lastnametf.sendKeys("james");
	}

}
