package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
	
	@FindBy(xpath="//a[@href='index.php?module=Leads&action=index']")
	private WebElement leadbtn;
	
	@FindBy(xpath="(//input[@title='Edit [Alt+E]'])[2]")
	private WebElement editbtn;
	
	@FindBy(xpath="(//input[@title='Duplicate [Alt+U]'])[2]")
	private WebElement duplicatebtn;
	
	public LeadInfoPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	public void leadClick()
	{
		leadbtn.click();
	}
	public void editClick()
	{
		editbtn.click();
	}
	public void duplicateClick()
	{
		duplicatebtn.click();
	}

}
