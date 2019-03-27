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
	public void TC01OperatorHasNoAccessToAddGateway() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		operatorHasNoAccessToAddGateway();
	}
	@Test
	public void TC02OperatorNoAccessToEdit() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		verifyOperatorHasNoAccessToEditGateway();
	}
	@Test
	public void TC03OperatorNoAccessToDisable() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		verifyOperatorHasNoAccessToDisableGateway();
	}
	@Test
	public void TC04OperatorNoAccessToDecommission() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		verifyOperatorHasNoAccessToDecommissionGateway();
	}

@Test
	public void TC05ManageSoftwareInterface() {
			microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
			verifyManageSoftwareInterface();
		}
	@Test
	public void TC06DisableAndEnableGateway() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		disableAndEnableGateway();
	}

	@Test
	public void TC07OperatorHasAccessToViewGateway()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		operatorHasAccessToViewGateway();
	}
	@Test
	public void TC08UserInterfaceOfAddSoftware()
	{
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		verifyUserInterfaceOfGatewayAddSoftware();
	}
	@Test
	public void TC09UserWithNoPrivilegeCannotAccessGatewayPage()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getNoPrivilegeUserName(),EnvironmentManager.getNoPrivilegePassword());
		UserWithNoPrivilegeCannotAccessGatewayPage();
	}
	

	@Test
	public void TC10ManageSoftwareUploadAndInstallInvalidSoftwareName()
	{
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		ManageSoftwareUploadAndInstallInvalidSoftwareName();
	}
	
@Test
	public void TC11ManageSoftwareUploadAndInstallInvalidSoftwarePackage()
	{
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		ManageSoftwareUploadAndInstallInvalidSoftwarePackage();
	}
	
@Test
    public void TC12ManageSoftwareAddSoftwareUploadInstallValidUserInputs()
    {
           microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
           ManageSoftwareAddSoftwareUploadInstallValidUserInputs();
    }

	@Test
	public void TC13ValidateCommissionedGatewayStatus()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		validateCommissionedGatewayStatus();
	}
	@Test
	public void TC14ValidateDecommissionedGatewayStatus()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		validateDecommissionedGatewayStatus();
	}

	@Test
	public void TC15ValidatePrecommissionedGatewayStatus()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		validatePreCommissionedGatewayStatus();
	}
	 @Test
		  public void TC16verifyDefaultGatewayStatus()
		  {
			  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
			  verifyDefaultGatewayStatus();
		  }
	
	 @Test
	  public void TC17VerifyClearSelectedOptionsInGatewayStatusSearchDropdown()
	  {
		  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		  verifyClearSelectedOptionsInGatewayStatusSearchDropdown();
	  }
	 @Test
	  public void TC18VerifySelectAllOptionInGatewayStatusSearchDropdown()
	  {
		  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		  verifySelectAllOptionInGatewayStatusSearchDropdown();
	  }
	 @Test
	  public void TC19VerifyClearDatesFromDatePicker()
	  {
		  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		  verifyClearDatesFromDatePicker();
	  }
		
	 @Test
	  public void TC20VerifySearchOptionsSearchDropdown()
	  {
		  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		  verifySearchOptionsSearchDropdown();
	  }

	 
	  @Test
		public void TC21verifySearchGatewayDateRange()
		{
		  microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		  zfaddsinglegateway.addSingleGatewayWithAllValidInputs();
			verifySearchGatewayDateRange();
		}
	 /***** TC02EditSingleGateway : editDetailsOfAnAlreadyAddedGateway *****/
     @Test
     public void TC22EditSingleGateway() {
    	 microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
    	// zfaddsinglegateway.addSingleGatewayWithAllValidInputs();
    	 editSingleGateway();
     }
     
     /***** TC03DropdownGateway : verifySearchUsingAParticularSearchCategoryFromDropdown *****/
    @Test
     public void TC23DropdownGateway() {
    	 microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
    	 showDropDownGateway();//need to write a script for this 
     }
     
     /***** TC04GatewaySorTCatagory : verifySortUsingAParticularSorTCategory *****/
    @Test
     public void TC24GatewaySortCatagory() {
    	 microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
    	 getSortCategories();
     }
     
     /***** TC05VerifyGatewayColumn :  Validate the column names of gateway list section *****/
     @Test
     public void TC25VerifyGatewayColumn() {
    	 microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
        verifyGatewayColumn();
     }
     
     /***** TC06VerifyGatewayLifeCycle :  Validate the Gateway life cycle in the gateway landing page *****/
    // @Test(priority=6)
     public void TC26VerifyGatewayLifeCycle() {   	
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
