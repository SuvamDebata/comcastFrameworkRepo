package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductsPage {

WebDriver driver;
	
	public CreateNewProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productNameEdt;
	
	@FindBy(name="qty_per_unit")
	private WebElement qtyPerUnitEdt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getsaveButton() {
		return saveButton;
	}

	public WebElement getqtyPerUnitEdt() {
		return qtyPerUnitEdt;
	}

	public WebElement getproductNameEdt() {
		return productNameEdt;
	}
}
