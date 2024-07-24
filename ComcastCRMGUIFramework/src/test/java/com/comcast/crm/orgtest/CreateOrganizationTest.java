package com.comcast.crm.orgtest;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

import com.comcast.crm.baseclass.BaseClass;

public class CreateOrganizationTest extends BaseClass {
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
}
