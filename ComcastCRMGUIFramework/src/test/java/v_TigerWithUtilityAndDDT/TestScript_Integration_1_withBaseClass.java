package v_TigerWithUtilityAndDDT;

import java.io.IOException;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreateNewProductsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;
import com.comcast.crm.baseclass.BaseClass;

public class TestScript_Integration_1_withBaseClass extends BaseClass {
	@Test
	public void  testScript_Functional() throws IOException
	{
			
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
	}

}
