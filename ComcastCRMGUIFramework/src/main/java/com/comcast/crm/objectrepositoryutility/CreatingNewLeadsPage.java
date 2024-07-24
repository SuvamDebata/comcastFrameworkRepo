package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generic.webdriverutility.WebDriverUtility;



public class CreatingNewLeadsPage {
	
WebDriver driver;
	
	public CreatingNewLeadsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdit;
	
	@FindBy(name = "company")
	private WebElement companynameEdit;
	
	@FindBy(name = "assigned_user_id")
	private WebElement assignedToDd;
	
	@FindBy(xpath  = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	public WebElement getLastnameEdit() {
		return lastnameEdit;
	}

	public WebElement getCompanynameEdit() {
		return companynameEdit;
	}

	public WebElement getAssignedToDd() {
		return assignedToDd;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createLeads(String leadsName,String companyname,WebDriverUtility wu)
	{
		lastnameEdit.sendKeys(leadsName);
		wu.select(getAssignedToDd(), " Administrator");
		companynameEdit.sendKeys(companyname);
		saveBtn.click();
		
	}
	

}
