package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;


public class CreateContactTest extends BaseClass {

	@Test
	public void createContact() throws Exception {
		// Naviagte to Contact module
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// "Create Contact" Button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactButton().click();

		// Enter all the details and create new contact
		String lastname = xlib.getDataFromExcel("contact", 4, 2) + wdu.getRandomNumber(1000);
		;
		CreatingNewContactsPage ccp = new CreatingNewContactsPage(driver);
		ccp.getLastnametextEdit().sendKeys(lastname);
		ccp.getSaveBtn().click();

		// verify header msg Expected Result
		String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actlastname.equals(lastname))
			System.out.println(lastname + " is created==PASS");
		else
			System.err.println(lastname + " is not created==FAIL");
	}
}
