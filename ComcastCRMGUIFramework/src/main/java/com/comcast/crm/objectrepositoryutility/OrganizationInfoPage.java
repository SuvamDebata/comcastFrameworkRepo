package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

   WebDriver driver;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className ="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement OrgName;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industry;
	
	@FindBy(id="dtlview_Type")
	private WebElement type;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phone;

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	public WebElement getphone() {
		return phone;
	}
}
