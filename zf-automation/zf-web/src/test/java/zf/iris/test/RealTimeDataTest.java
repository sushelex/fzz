package zf.iris.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.iris.pages.RealTimeDataPage;
import zf.pages.MicrosoftLoginPage;

public class RealTimeDataTest extends RealTimeDataPage {

MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();
	
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
	}


//	@Test
	public void TcDashboard()  {
		microsoftlogin.microsoftLogin(EnvironmentManager.getPrivilegeWithThresholdUserName(),EnvironmentManager.getPrivilegeWithThresholdPassword());
		verifyActiveVehiclesDisplay();
	}

	@Test
	public void TcclickEditVehicleAndEdit()  {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword()); 
		clickEditVehicleAndEdit();
	}
//	@Test
	public void TCVehicleSpeedCheck()
	{
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword()); 
		vehicleSpeedCheck();
	}
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}

}
