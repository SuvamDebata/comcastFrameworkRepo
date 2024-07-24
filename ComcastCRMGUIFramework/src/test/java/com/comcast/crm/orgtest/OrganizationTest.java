package com.comcast.crm.orgtest;

import org.testng.annotations.Test;

import com.comcast.crm.contacttest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;



public class OrganizationTest extends BaseClass{
	
	@Test

	public void createOrganizationTest() throws Exception {
		// Navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// Click on "Create Organization" Button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgButton().click();

		// Enter all the details and create new organization
		String orgName = xlib.getDataFromExcel("org", 1, 2) + wdu.getRandomNumber(1000);
		CreatingNewOrganizationsPage cnop = new CreatingNewOrganizationsPage(driver);
		cnop.getOrgNameEdit().sendKeys(orgName);
		cnop.getSaveBtn().click();

		// Verify header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		if (oip.getHeaderMsg().getText().contains(orgName))
			System.out.println(orgName + " is created==PASS");
		else
			System.out.println(orgName + " is not created==FAIL");
		// Verify Header orgName info expected result
		if (oip.getOrgName().getText().equals(orgName))
			System.out.println(orgName + " is created==PASS");
		else
			System.out.println(orgName + " is not created==FAIL");

	}
	
	@Test

	public void reateOrganizationWithIndustries() throws Exception {
		// readtestscripts from excel
			String orgName = xlib.getDataFromExcel("org", 4, 2)+ wdu.getRandomNumber(1000);
			String industry = xlib.getDataFromExcel("org", 4, 3).toString();
			String type = xlib.getDataFromExcel("org", 4, 4).toString();
			
			
			// Navigate to Organization module
			HomePage hp = new HomePage(driver);
			hp.getOrglink().click();

			// Click on "Create Organization" Button
			OrganizationsPage op = new OrganizationsPage(driver);
			op.getCreateNewOrgButton().click();

			// Enter all the details and create new organization
			CreatingNewOrganizationsPage cnop = new CreatingNewOrganizationsPage(driver);
			cnop.getOrgNameEdit().sendKeys(orgName);
			
			//selecting the industry dropdown
			wdu.select(cnop.getIndustrydpd(), industry);
		
			//selecting the type
			wdu.select(cnop.getType(), type);
			
			cnop.getSaveBtn().click();
			
			//Verify the industry and type info
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			if (oip.getIndustry().getText().equals(industry)) 
				System.out.println(industry + " info is verified==PASS");
			else 
				System.out.println(industry + " info is not verified==FAIL");
				
			if (oip.getType().getText().equals(type)) 
				System.out.println(type + " info is verified==PASS");
			else 
				System.out.println(type + " info is not verified==FAIL");
	}

	@Test
	public void CreateOrganizationWithPhoneNo() throws Exception {
		// readtestscripts from excel
		String orgName = xlib.getDataFromExcel("org", 7, 2) + wdu.getRandomNumber(1000);
		String phno = xlib.getDataFromExcel("org", 7, 3);

		// Navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// Click on "Create Organization" Button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgButton().click();

		// Enter all the details and create new organization
		CreatingNewOrganizationsPage cnop = new CreatingNewOrganizationsPage(driver);
		cnop.getOrgNameEdit().sendKeys(orgName);
		cnop.getPhonetextEdit().sendKeys(phno);
		cnop.getSaveBtn().click();

		// Verify header phno info Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		if (oip.getphone().getText().equals(phno))
			System.out.println(phno + " info is created==PASS");
		else
			System.out.println(phno + " info is not created==FAIL");
	}
}
