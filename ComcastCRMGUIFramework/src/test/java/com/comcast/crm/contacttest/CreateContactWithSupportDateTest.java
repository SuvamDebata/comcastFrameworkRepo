package com.comcast.crm.contacttest;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

import com.comcast.crm.baseclass.BaseClass;

public class CreateContactWithSupportDateTest extends BaseClass{
	@Test

	public void createContactWithSupportDateTest() throws Exception {
			//naviagte to Organization module
			HomePage hp=new HomePage(driver);
			hp.getContactlink().click();

			//click on "Create Organization" Button
			ContactsPage cp=new ContactsPage(driver);
			cp.getCreateNewContactButton().click();

			//Enter all the details and create new organization
			String lastname = xlib.getDataFromExcel("contact", 4, 2)+ wdu.getRandomNumber(1000);
			CreatingNewContactsPage cncp=new CreatingNewContactsPage(driver);
			cncp.getLastnametextEdit().sendKeys(lastname);
			String startdate=wdu.getCurrentDate("yyyy-MM-dd");
			String enddate = wdu.getRequiredDate("yyyy-MM-dd", 30);
			
			cncp.getSupportStartDateEdit().clear();
			cncp.getSupportStartDateEdit().sendKeys(startdate);
			
			cncp.getSupportlastDateEdit().clear();
			cncp.getSupportlastDateEdit().sendKeys(enddate);
			
			cncp.getSaveBtn().click();
			
			
			//verify header msg Expected Result
			ContactInfoPage cip= new ContactInfoPage(driver);
			String actlastname = cip.getlastNameInfo().getText();
			if (actlastname.equals(lastname)) 
				System.out.println(lastname + " is verified==PASS");
			else 
				System.out.println(lastname + " is not verified==FAIL");
				
			//verify the date
			String actdate = cip.getStartDate().getText();
			if (actdate.equals(startdate))
				System.out.println(startdate + "  current date is displayed==PASS");
			else
				System.out.println(startdate + " current date is not displayed==FAIL");
			
			String rtenddt = cip.getEndDate().getText();
			if (rtenddt.equals(enddate))
				System.out.println(enddate + "  end date is displayed==PASS");
			else 
				System.out.println(enddate + " end date is not displayed==FAIL");
	}
}
