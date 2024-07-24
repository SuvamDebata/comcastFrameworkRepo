package v_TigerWithUtilityAndDDT;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreateNewProductsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class TestScript_Integration_1 {
	@Test
	public void  testScript_Functional() throws IOException
	//public static void main(String[] args) throws Throwable 
	{
		ExcelUtility xlib= new ExcelUtility("C:\\Users\\suvam\\OneDrive\\Desktop\\GU_Automatication.xlsx");
		FileUtility flib= new FileUtility("C:\\Users\\suvam\\eclipse-workspace\\ComcastCRMGUIFramework\\configAppData\\commondata.properties");
		WebDriverUtility wdu=new WebDriverUtility();
		
		WebDriver driver=wdu.openBrowser(flib.getDataFromPropertiesFile("Browser"));
		driver.get(flib.getDataFromPropertiesFile("url"));
		
	//Login 
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(flib.getDataFromPropertiesFile("username"), flib.getDataFromPropertiesFile("password"));
			
	//Products module
		HomePage hp=new HomePage(driver);
		hp.getProductslink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateNewProdButton().click();
		
		CreateNewProductsPage cpp= new CreateNewProductsPage(driver);
		String productName=xlib.getDataFromExcel("org", 10, 2);
		cpp.getproductNameEdt().sendKeys(productName);
		String qntt=xlib.getNumDataFromExcel("org", 10, 3);
		cpp.getqtyPerUnitEdt().sendKeys(qntt);
		cpp.getsaveButton().click();
		 
	//Search product by qntt
		hp.getProductslink().click();
		pp.getSearchtextEdit().sendKeys(qntt);
		wdu.select(pp.getSearchDropDown(), "Qty/Unit");
		pp.getsearchBtn().click();
		 
	//Logout
		hp.logout();
		  
		driver.quit();
		
	}

}
