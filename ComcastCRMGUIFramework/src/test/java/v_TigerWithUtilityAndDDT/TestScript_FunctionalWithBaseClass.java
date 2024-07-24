package v_TigerWithUtilityAndDDT;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewLeadsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;

public class TestScript_FunctionalWithBaseClass extends BaseClass {
	@Test
	public void  testScript_Functional() throws IOException
	{
		
		  //Leads module
		  HomePage hp=new HomePage(driver);
		  hp.getLeadslink().click();
		  LeadsPage lep=new LeadsPage(driver);
		  lep.getCreateNewLeadsButton().click();
		  
		  //CreateNewLeadButton Module
		  CreatingNewLeadsPage clp=new CreatingNewLeadsPage(driver);
		  clp.getSaveBtn().click();
		  
		  //Alert Handled with passion
		  System.out.println("Warning!!! *Mandatory Field "+wdu.switchToAlertAndGetText(driver));
		  wdu.switchToAlertAndAccept(driver);
		  
	}
}
