package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generic.webdriverutility.WebDriverUtility;



public class CreatingNewCampaignPage {

	WebDriver driver;
	
	public CreatingNewCampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campnameEdit;
	
	@FindBy(name = "assigned_user_id")
	private WebElement assignedToDd;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	public WebElement getCampnameEdit() {
		return campnameEdit;
	}

	public WebElement getAssignedToDd() {
		return assignedToDd;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getClosingdateEdit() {
		return closingdateEdit;
	}
	
	

	@FindBy(name = "closingdate")
	private WebElement closingdateEdit;
	
	public void createCampaign(String campaignName,String closingdate,WebDriverUtility wu)
	{
		campnameEdit.sendKeys(campaignName);
		wu.select(getAssignedToDd(), " Administrator");
		closingdateEdit.sendKeys(closingdate);
		saveBtn.click();
		
	}
}
