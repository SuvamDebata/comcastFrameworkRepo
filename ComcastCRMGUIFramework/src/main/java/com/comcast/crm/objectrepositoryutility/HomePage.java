package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(linkText="Organizations")
//	private WebElement orglink;
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignlink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadslink;
	
	@FindBy(linkText = "Products")
	private WebElement productslink;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorslink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']//parent::td")
	private WebElement adminButton;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(xpath="(//a[text()='Opportunities'])[1]")
	private WebElement opportunitylink;
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getOpportunitylink() {
		return opportunitylink;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getLeadslink() {
		return leadslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getVendorslink() {
		return vendorslink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public void navigateToCampaignPage()
	{
		Actions action=new Actions(driver);
		action.moveToElement(morelink).perform();;
		campaignlink.click();
	}
	
	public void navigateToVendorPage()
	{
		Actions action=new Actions(driver);
		action.moveToElement(morelink).perform();;
		vendorslink.click();
	}
	
	public void logout()
	{
		Actions action=new Actions(driver);
		action.moveToElement(adminButton).perform();
		signOutLink.click();
	}
}
