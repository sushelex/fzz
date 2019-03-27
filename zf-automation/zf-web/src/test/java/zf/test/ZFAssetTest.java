package zf.test;

import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import framework.DriverManager;
import framework.EnvironmentManager;
import zf.pages.MicrosoftLoginPage;
import zf.pages.ZFAssetPage;

public class ZFAssetTest extends ZFAssetPage{
	MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();
	
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
		
	}
	@Test
	public void TC01assetPageValidation() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		assetPageValidation();
	}
	@Test
	public void TC02assetSearch() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		assetSearch();
	}
	@Test
	public void TC03assetAdvancedSearch() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		assetAdvancedSearch();
	}
	@Test
	public void TC04clearAllFilter() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		clearAllFilter();
	}
	@Test
	public void TC05clearAllFilter() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		assetSearchWithInvalidKey();
	}
	@Test
	public void TC06CreateAssetstWithAllFeilds() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		createAssetstWithAllFeilds();
	}

	
	@Test
	public void TC07CreateAssetstWithActions() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		CreateAssetstWithActions();
	}
	@Test
	public void TC08editExistAssetDetails() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		editExistAssetDetails();
	}
	
	@Test
	public void TC09CreateChildAssettWithAllFeilds(){
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		createChildAssetWithAllFeilds();
	}
	
	@Test
	public void TC10CreateAssetstWithAllAutopopulatedMetadataKeys(){
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		createAssetstWithAllAutopopulatedMetadataKeys();
	}
	
	@Test
	public void TC11CreateAssetstWithMandatoryAutopopulatedMetadataKeys(){
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		createAssetstWithMandatoryAutopopulatedMetadataKeys();
	}
	
	@Test
		public void TC12FieldValidationsMandatoryFieldVin(){
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
			fieldValidationsMandatoryFieldVin();
		}
		@Test
		public void TC13VerifyVehicleAssetstWithMandatoryAutopopulatedMetadataKeys(){
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		verifyVehicleAssetstWithMandatoryAutopopulatedMetadataKeys();
		}
		
		@Test
			public void TC14CreateAssetWithoutMandatoryInput(){
			microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
			createAssetWithoutMandatoryInput();
			}
			
		@Test
		public void TC15ExecuteActionWithoutParamater(){
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		executeActionWithoutParamater();
		}
		@Test
		public void TC16ExecuteActionWithParamater(){
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		executeActionWithParamater();
		}
		@Test
	public void TC17EditAssetstActions() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		editAssetstActions();
	}
		@Test
	public void TC18VerifyAssetActionsUI() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		verifyAssetActionsUI();
	}

	@Test
	public void TC19OperatorHasNoAccessToCreateAsset()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		operatorHasNoAccessToCreateAsset();
	}
	
	@Test
	public void TC20UserWithNoPrivilegeCannotAccessAssetsPage()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getNoPrivilegeUserName(),EnvironmentManager.getNoPrivilegePassword());
		userWithNoPrivilegeCannotAccessAssetsPage();
	}

	@Test
	public void TC21SortAssetsInAssetsHomepage()
	{		
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		SortAssetsInAssetsHomepage();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}
}
