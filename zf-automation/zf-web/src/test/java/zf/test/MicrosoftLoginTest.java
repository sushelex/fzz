package zf.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.pages.MicrosoftLoginPage;

public class MicrosoftLoginTest extends MicrosoftLoginPage{
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
	}

	@Test
	public void Tc01Login() throws InterruptedException {
		microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		validatePageTitle();
	}
	

	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}
}
