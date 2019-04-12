package zf.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.pages.MicrosoftLoginPage;
import zf.pages.ZFAssetDetailsPage;

public class ZFAssetDetailsTest extends ZFAssetDetailsPage {

	MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
		
	}
	
	
	@Test
	public void TC01OperatorHasNoAccessToEditAssetDetails() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		OperatorHasNoAccessToEditAssetDetails();
	}
	
	@Test
	public void TC02OperatorHasNoAccessToCreateChildAssets() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		OperatorHasNoAccessToCreateChildAssets();
	}
	
	@Test
	public void TC03OperatorHasNoAccessToEditActions() {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		OperatorHasNoAccessToEditActions();
	}
	
	@Test
	public void TC04operatorAccessToViewAssetDetails()
	{
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		operatorAccessToViewAssetDetails();
	}
	@Test
	public void TC05ViewExistingAssetDetails(){
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		viewExistingAssetDetails();
	}

	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}
}
