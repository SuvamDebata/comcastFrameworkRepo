package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorsPage {
	
WebDriver driver;
	
	public CreateNewVendorsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "vendorname")
	private WebElement vendorNameEdit;
	
	@FindBy(id = "phone")
	private WebElement phoneNoEdit;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	public WebElement getsaveBtn() {
		return saveBtn;
	}

	public WebElement getphoneNoEdit() {
		return phoneNoEdit;
	}

	public WebElement getvendorNameEdit() {
		return vendorNameEdit;
	}

}
