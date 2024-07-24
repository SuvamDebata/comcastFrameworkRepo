package com.comcast.crm.homepagetest;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.comcast.crm.listenerutility.ListenerImpliClass.class)
public class HomePageVerificationTest extends com.comcast.crm.baseclass.BaseClass{

	@Test
	public void homePageTest() {
		String expectedTitle = "Homes";
		String acttitle = driver.getTitle();
		/*
		 * if (acttitle.equalsIgnoreCase(expectedTitle))
		 * System.out.println("===Tescase PASS==="); else
		 * System.out.println("===Tescase FAIL===");
		 */
		
		//Hard assert
		Assert.assertEquals(acttitle, expectedTitle);
	}

	@Test

	public void verifyLogoHomePageTest() {
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
		//Hard assert
		//Assert.assertEquals(true, status);
		Assert.assertTrue(status);
	}

}
