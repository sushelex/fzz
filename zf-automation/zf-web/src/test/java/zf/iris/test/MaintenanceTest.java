package zf.iris.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.iris.pages.MaintenancePage;
import zf.pages.MicrosoftLoginPage;

public class MaintenanceTest extends MaintenancePage{
MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();
	
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
	}

	@Test
	public void TcverifyMainteneceEditSavechange()  {
		microsoftlogin.microsoftLogin(EnvironmentManager.getPrivilegeWithThresholdUserName(),EnvironmentManager.getPrivilegeWithThresholdPassword());
		verifyMainteneceEditSavechange();
	}


	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}

}
