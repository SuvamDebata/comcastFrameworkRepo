package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationsPage {

	WebDriver driver;
	public CreatingNewOrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdit;
	
	@FindBy(xpath  = "(//input[@value='  Save  '])[1]")
	private WebElement saveBtn;
	

	@FindBy(name  = "industry")
	private WebElement industrydpd;
	
	public WebElement getIndustrydpd() {
		return industrydpd;
	}

	@FindBy(id  = "phone")
	private WebElement phonetextEdit;
	
	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getPhonetextEdit() {
		return phonetextEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(name="accounttype")
	private WebElement type;

	public WebElement getType() {
	return type;
	}
}
