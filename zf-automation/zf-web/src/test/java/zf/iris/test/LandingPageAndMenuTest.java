package zf.iris.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.iris.pages.LandingPageAndMenuPage;
import zf.pages.MicrosoftLoginPage;

public class LandingPageAndMenuTest extends LandingPageAndMenuPage{

	MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();

	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
		
	}
	
	@Test
	public void TC01LoginWithMoreThanOneClient()
	{
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		LoginWithMoreThanOneClient();
	}
	
	@Test
	public void TC02BothClientsGlobalMenu()
	{
		microsoftlogin.microsoftLogin(EnvironmentManager.getPrivilegeMultiClientsUserName(),EnvironmentManager.getPrivilegeMultiClientsPassword());
		BothClientsGlobalMenu();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}
}