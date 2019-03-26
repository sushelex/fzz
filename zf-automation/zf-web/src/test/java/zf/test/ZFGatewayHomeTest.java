package zf.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.pages.MicrosoftLoginPage;
import zf.pages.ZFGatewayHomePage;

public class ZFGatewayHomeTest extends ZFGatewayHomePage
{
	MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();
	ZFAddSingleGatewayTest zfaddsinglegateway=new ZFAddSingleGatewayTest();
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
		
	}
	
	@Test
	public void Tc01OperatorHasNoAccessToAddGateway() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		operatorHasNoAccessToAddGateway();
	}
	@Test
	public void Tc02OperatorNoAccessToEdit() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		verifyOperatorHasNoAccessToEditGateway();
	}
	@Test
	public void Tc03OperatorNoAccessToDisable() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		verifyOperatorHasNoAccessToDisableGateway();
	}
	@Test
	public void Tc04OperatorNoAccessToDecommission() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		verifyOperatorHasNoAccessToDecommissionGateway();
	}

@Test
	public void Tc05ManageSoftwareInterface() {
			microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
			verifyManageSoftwareInterface();
		}
//	@Test
	public void Tc06DisableAndEnableGateway() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		disableAndEnableGateway();
	}

//	@Test
	public void Tc07OperatorHasAccessToViewGateway()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		operatorHasAccessToViewGateway();
	}
//	@Test
	public void Tc08UserInterfaceOfAddSoftware()
	{
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		verifyUserInterfaceOfGatewayAddSoftware();
	}
//	@Test
	public void Tc09UserWithNoPrivilegeCannotAccessGatewayPage()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getNoPrivilegeUserName(),EnvironmentManager.getNoPrivilegePassword());
		UserWithNoPrivilegeCannotAccessGatewayPage();
	}
	

//	@Test
	public void TC10ManageSoftwareUploadAndInstallInvalidSoftwareName()
	{
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		ManageSoftwareUploadAndInstallInvalidSoftwareName();
	}
	
//	@Test
	public void TC11ManageSoftwareUploadAndInstallInvalidSoftwarePackage()
	{
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		ManageSoftwareUploadAndInstallInvalidSoftwarePackage();
	}
	
	//@Test
    public void TC12ManageSoftwareAddSoftwareUploadInstallValidUserInputs()
    {
           microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
           ManageSoftwareAddSoftwareUploadInstallValidUserInputs();
    }

//	@Test
	public void Tc09ValidateCommissionedGatewayStatus()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		validateCommissionedGatewayStatus();
	}
//	@Test
	public void Tc09ValidateDecommissionedGatewayStatus()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		validateDecommissionedGatewayStatus();
	}

//	@Test
	public void Tc09ValidatePrecommissionedGatewayStatus()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		validatePreCommissionedGatewayStatus();
	}
	 @Test
		  public void Tc54verifyDefaultGatewayStatus()
		  {
			  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
			  verifyDefaultGatewayStatus();
		  }
	
	// @Test
	  public void Tc54verifyClearSelectedOptionsInGatewayStatusSearchDropdown()
	  {
		  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		  verifyClearSelectedOptionsInGatewayStatusSearchDropdown();
	  }
	// @Test
	  public void Tc54VerifySelectAllOptionInGatewayStatusSearchDropdown()
	  {
		  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		  verifySelectAllOptionInGatewayStatusSearchDropdown();
	  }
	// @Test
	  public void Tc54VerifyClearDatesFromDatePicker()
	  {
		  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		  verifyClearDatesFromDatePicker();
	  }
		
	// @Test
	  public void Tc54VerifySearchOptionsSearchDropdown()
	  {
		  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		  verifySearchOptionsSearchDropdown();
	  }

	 
	  @Test
		public void TC47verifySearchGatewayDateRange()
		{
		  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		  zfaddsinglegateway.addSingleGatewayWithAllValidInputs();
			verifySearchGatewayDateRange();
		}
	 /***** Tc02EditSingleGateway : editDetailsOfAnAlreadyAddedGateway *****/
     @Test
     public void Tc02EditSingleGateway() {
    	 microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
    	// zfaddsinglegateway.addSingleGatewayWithAllValidInputs();
    	 editSingleGateway();
     }
     
     /***** Tc03DropdownGateway : verifySearchUsingAParticularSearchCategoryFromDropdown *****/
    @Test
     public void Tc03DropdownGateway() {
    	 microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
    	 showDropDownGateway();//need to write a script for this 
     }
     
     /***** Tc04GatewaySortCatagory : verifySortUsingAParticularSortCategory *****/
    @Test
     public void Tc04GatewaySortCatagory() {
    	 microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
    	 getSortCategories();
     }
     
     /***** Tc05VerifyGatewayColumn :  Validate the column names of gateway list section *****/
     @Test
     public void Tc05VerifyGatewayColumn() {
    	 microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
        verifyGatewayColumn();
     }
     
     /***** Tc06VerifyGatewayLifeCycle :  Validate the Gateway life cycle in the gateway landing page *****/
    // @Test(priority=6)
     public void Tc06VerifyGatewayLifeCycle() {   	
    	 microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
    	 verifyGatewayLifeCycle();    	
     } 
     
    

	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}

}
