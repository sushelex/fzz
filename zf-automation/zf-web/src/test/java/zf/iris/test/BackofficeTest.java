package zf.iris.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.iris.pages.BackofficePage;
import zf.pages.MicrosoftLoginPage;

public class BackofficeTest extends BackofficePage{
	MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();

	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
	}

	@Test
	public void TC01CreateFleetAndAddSomeVehicle()
	{
		CreateFleetAndAddSomeVehicle();
	}
	@Test
	public void TC02BackofficeCreateNewUser()
	{
		BackofficeCreateNewUser();
	}
	@Test
	public void TC03BackofficeEditVechileTypeInSomeVehicle()
	{
		BackofficeEditVechileTypeInSomeVehicle();
	}
	@Test
	public void TC04BackofficeEditSomeRole()
	{
		BackofficeEditSomeRole();
	}

	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}
}