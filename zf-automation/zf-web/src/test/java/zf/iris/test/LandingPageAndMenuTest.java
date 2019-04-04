package zf.iris.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.iris.pages.ClientHomePage;
import zf.pages.MicrosoftLoginPage;

public class LandingPageAndMenuTest extends ClientHomePage{

	MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();

	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
		microsoftlogin.microsoftLogin(EnvironmentManager.getPrivilegeMultiClientsUserName(),EnvironmentManager.getPrivilegeMultiClientsPassword());
	}
	
	@Test
	public void TC01LoginWithMoreThanOneClient()
	{
		LoginWithMoreThanOneClient();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}
}