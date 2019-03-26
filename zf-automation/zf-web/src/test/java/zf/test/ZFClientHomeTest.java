package zf.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.pages.MicrosoftLoginPage;
import zf.pages.ZFClientHomePage;

public class ZFClientHomeTest extends ZFClientHomePage{

	MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();

	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
	}

	/*
	 * Verifying the User Interface of Manage client page
	 */
	@Test
	public void TC01UserInterfaceOfMangeClientPage() {
		
		manageCleitntsStaticValidation();
	}

	/*
	 * Verify the User Interface of Client Details More Details Pop-up
	 */
	@Test
	public void TC02UserInterfaceOfMoreDetails() {
		
		clientMoreDetailsStaticValidation();
	}
	
	@Test
	public void TC03VerifyAdminUserAbleToViewClientManagementPage()
	{
		verifyAdminUserAbleToViewClientManagementPage();
	}
	
	
	@Test
	public void TC04verifyUserInterfaceOfClientDetailsInManageClientpage()
	{
		verifyUserInterfaceOfClientDetailsInManageClientpage();
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}
}