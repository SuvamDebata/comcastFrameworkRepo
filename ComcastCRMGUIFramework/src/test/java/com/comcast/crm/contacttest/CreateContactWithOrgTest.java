package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsLinkOrgPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

import com.comcast.crm.baseclass.BaseClass;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void createContactWithOrg() throws Exception {
		String orgName = xlib.getDataFromExcel("contact", 7, 2)+ wdu.getRandomNumber(1000);
		String lastname =xlib.getDataFromExcel("contact", 7, 3)+ wdu.getRandomNumber(1000);

		//naviagte to Organization module
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();

		//click on "Create Organization" Button
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateNewOrgButton().click();

		//Enter all the details and create new organization
		CreatingNewOrganizationsPage cnop=new CreatingNewOrganizationsPage(driver);
		cnop.getOrgNameEdit().sendKeys(orgName);
		cnop.getSaveBtn().click();

		//verify header msg Expected Result
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String headerinfo = oip.getHeaderMsg().getText();
		if (headerinfo.contains(orgName)) 
			System.out.println(orgName + " is created==PASS");
		else 
			System.out.println(orgName + " is not created==FAIL");

		// Verify Header orgName info expected result
		String actOrg = oip.getOrgName().getText();
		if (actOrg.equals(orgName))
			System.out.println(orgName + " is created==PASS");
		else 
			System.out.println(orgName + " is not created==FAIL");

		//navigate to contact 							
		hp.getContactlink().click();

		//click on "Create Contact" Button
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewContactButton().click();

		//Enter all the details and create new contact
		CreatingNewContactsPage ccp=new CreatingNewContactsPage(driver);
		ccp.getLastnametextEdit().sendKeys(lastname);
		String parentwindow = driver.getWindowHandle();

		// Step 8 : Enter all the details and create new contact
		ccp.getSelectOrgBtn().click();

		//Switch to child window
		wdu.switchToTabOnUrl(driver, "Accounts&action=");

		ContactsLinkOrgPage clop=new ContactsLinkOrgPage(driver);
		clop.getsearchEdt().sendKeys(orgName);
		clop.getsearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();

		//Switch to parent window
		driver.switchTo().window(parentwindow);
		ccp.getSaveBtn().click();

		// Step 9 : verify header msg Expected Result
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actlastname = cip.getlastNameInfo().getText();
		if (actlastname.equals(lastname)) 
			System.out.println(lastname + " is created==PASS");
		else
			System.out.println(lastname + " is not created==FAIL");

		//verify header orgname 
		String actOrgName =cip.getactOrgName().getText();
		System.out.println(actOrgName);
		if (actOrgName.trim().equals(orgName)) 
			System.out.println(orgName + " info is verified==PASS");
		else
			System.out.println(orgName + " info is not verified==FAIL");

	}
}
