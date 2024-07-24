package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsLinkOrgPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.webdriverutility.UtilityClassObject;


@Listeners(com.comcast.crm.listenerutility.ListenerImpliClass.class)
public class ContactTest extends BaseClass{

	@Test
	public void createContact() throws Exception {
		// Navigate to Contact module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Contact module");
		HomePage hp = new HomePage(driver);
		assertobj.assertEquals(hp.getContactlink().isEnabled(), true);
		hp.getContactlink().click();
		

		// "Create Contact" Button
		UtilityClassObject.getTest().log(Status.INFO, "Create Contact");
		ContactsPage cp = new ContactsPage(driver);
		assertobj.assertEquals(cp.getCreateNewContactButton().isEnabled(), true);
		cp.getCreateNewContactButton().click();

		// Enter all the details and create new contact
		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new Contact");
		String lastname = xlib.getDataFromExcel("contact", 4, 2) + wdu.getRandomNumber(1000);
		CreatingNewContactsPage ccp = new CreatingNewContactsPage(driver);
		assertobj.assertEquals(ccp.getLastnametextEdit().isEnabled(), true);
		ccp.getLastnametextEdit().sendKeys(lastname);
		ccp.getSaveBtn().click();

		// verify header msg Expected Result
		UtilityClassObject.getTest().log(Status.INFO, "verify header msg Expected Result");
		String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		assertobj.assertEquals(actlastname, lastname);
		assertobj.assertAll();
	}
	
	@Test
	public void createContactWithOrg() throws Exception {
		String orgName = xlib.getDataFromExcel("contact", 7, 2)+ wdu.getRandomNumber(1000);
		String lastname =xlib.getDataFromExcel("contact", 7, 3)+ wdu.getRandomNumber(1000);

		//naviagte to Organization module
		UtilityClassObject.getTest().log(Status.INFO, "Naviagte to Organization module");
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();

		//click on "Create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "Create Organization");
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateNewOrgButton().click();

		//Enter all the details and create new organization
		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new Organization");
		CreatingNewOrganizationsPage cnop=new CreatingNewOrganizationsPage(driver);
		cnop.getOrgNameEdit().sendKeys(orgName);
		cnop.getSaveBtn().click();

		//verify header msg Expected Result
		UtilityClassObject.getTest().log(Status.INFO, " Verify header msg Expected Result");
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String headerinfo = oip.getHeaderMsg().getText();
		Boolean status=headerinfo.contains(orgName);
		assertobj.assertEquals(status, true);
		
		// Verify Header orgName info expected result
		UtilityClassObject.getTest().log(Status.INFO, " Verify Header orgName info Expected Result");
		String actOrg = oip.getOrgName().getText();
		assertobj.assertEquals(actOrg, orgName);

		//Navigate to contact 
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact ");
		hp.getContactlink().click();

		//click on "Create Contact" Button
		UtilityClassObject.getTest().log(Status.INFO, "Create Contact");
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewContactButton().click();

		//Enter all the details and create new contact
		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new contact");
		CreatingNewContactsPage ccp=new CreatingNewContactsPage(driver);
		ccp.getLastnametextEdit().sendKeys(lastname);
		String parentwindow = driver.getWindowHandle();

		// Step 8 : Enter all the details and create new contact
		UtilityClassObject.getTest().log(Status.INFO, " Enter all the details and create new contact");
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
		UtilityClassObject.getTest().log(Status.INFO, " Verify header msg Expected Result");
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actlastname = cip.getlastNameInfo().getText();
		assertobj.assertEquals(actlastname, lastname);

		//verify header orgname
		UtilityClassObject.getTest().log(Status.INFO, "Verify header orgname");
		String actOrgName =cip.getactOrgName().getText();
		System.out.println(actOrgName);
		Boolean status2=actOrgName.trim().equals(orgName);
		assertobj.assertEquals(status2, true);

	}
	
	@Test

	public void createContactWithSupportDateTest() throws Exception {
			//navigate to Organization module
			UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organization module");
			HomePage hp=new HomePage(driver);
			hp.getContactlink().click();

			//click on "Create Organization" Button
			UtilityClassObject.getTest().log(Status.INFO, "Create Organization");
			ContactsPage cp=new ContactsPage(driver);
			cp.getCreateNewContactButton().click();

			//Enter all the details and create new organization
			UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new organization");
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
			UtilityClassObject.getTest().log(Status.INFO, "verify header msg Expected Result");
			ContactInfoPage cip= new ContactInfoPage(driver);
			String actlastname = cip.getlastNameInfo().getText();
			assertobj.assertEquals(actlastname, lastname);
				
			//verify the date
			UtilityClassObject.getTest().log(Status.INFO, "Verify the date");
			String actdate = cip.getStartDate().getText();
			assertobj.assertEquals(actdate, startdate);
			
			String rtenddt = cip.getEndDate().getText();
			assertobj.assertEquals(rtenddt, enddate);
	}
}
