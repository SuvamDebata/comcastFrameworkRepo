package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOpportunityPage {

	WebDriver driver;
	public CreateNewOpportunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "potentialname")
	private WebElement oppNameEdit;
	
	@FindBy(xpath  = "(//input[@value='  Save  '])[1]")
	private WebElement saveBtn;
	
	@FindBy(name  = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchtextEdit;
	
	@FindBy(id  = "related_to_type")
	private WebElement relatedToDd;
	
	@FindBy(name="assigned_user_id")
	private WebElement assignedDd;
	
	@FindBy(name="closingdate")
	private WebElement closedateEdit;
	
	@FindBy(xpath = "//select[@name='sales_stage']")
	private WebElement salesstageDd;

	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement selectBtn;
	
	public WebElement getOppNameEdit() {
		return oppNameEdit;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getRelatedToDd() {
		return relatedToDd;
	}

	public WebElement getAssignedDd() {
		return assignedDd;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchtextEdit() {
		return searchtextEdit;
	}

	public WebElement getClosedateEdit() {
		return closedateEdit;
	}

	public WebElement getSalesstageDd() {
		return salesstageDd;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
