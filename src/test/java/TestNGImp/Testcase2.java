package TestNGImp;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.Baseclass;
import genericLibraries.IConstantPath;
import genericLibraries.TabNames;
//@Listeners(genericLibraries.ListenerImplementation.class)
public class Testcase2 extends Baseclass{
	@Test
	public void tc2()
	{
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
		
		
	}

}
