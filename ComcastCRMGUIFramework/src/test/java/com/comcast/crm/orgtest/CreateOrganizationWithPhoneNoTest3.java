package com.comcast.crm.orgtest;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

import com.comcast.crm.baseclass.BaseClass;

public class CreateOrganizationWithPhoneNoTest3 extends BaseClass {

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
