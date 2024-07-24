package com.comcast.crm.orgtest;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

import com.comcast.crm.baseclass.BaseClass;

public class CreateOrganizationWithIndustriesTest2 extends BaseClass {
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
}
