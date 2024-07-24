package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	WebDriver driver;
	public ContactInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameInfo;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement actOrgName;
	
	
	
	public WebElement getlastNameInfo() {
		return lastNameInfo;
	}

	public WebElement getactOrgName() {
		return actOrgName;
	}
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDate;
	
	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	
}
