package zf.iris.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.iris.pages.AccessOtherClients;
import zf.pages.MicrosoftLoginPage;

public class AccessOtherClientsTest extends AccessOtherClients {

	
MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();
	
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
	}

	@Test
	public void Tc01CheckDashboardOfUserwithOneClientAccess()  {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		checkDashboardOfUserwithOneClientAccess();
	}
	
	@Test
	public void Tc02CheckDashboardOfAnotherClientAndUserWithNoAccess()  {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		CheckDashboardOfAnotherClientAndUserWithNoAccess();
		
	
	}

	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}
}
