package zf.iris.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.EnvironmentManager;
import zf.iris.pages.ZFDashboardPage;
import zf.iris.pages.ZFUserHomePage;
import zf.pages.MicrosoftLoginPage;

public class RBAC extends ZFDashboardPage{
	MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();
	ZFUserHomePage zfuserhomepage=new ZFUserHomePage();
	
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
	}

//	@Test
	public void Tc01PrivilegeToChangeThresholds()  {
		microsoftlogin.microsoftLogin(EnvironmentManager.getPrivilegeWithThresholdUserName(),EnvironmentManager.getPrivilegeWithThresholdPassword());
		privilegeToChangeThresholds();
	}
		

//	@Test
	public void Tc01NoPrivilegeToEditUser()  {
		microsoftlogin.microsoftLogin(EnvironmentManager.getNoUseEditPrivilegeUserName(),EnvironmentManager.getNoUseEditPrivilegePassword());
		zfuserhomepage.noPrivilegeToEditUser();
	}
	
//	@Test
	public void Tc02NoPrivilegeToEditUserRole()  {
		microsoftlogin.microsoftLogin(EnvironmentManager.getNoUseEditPrivilegeUserName(),EnvironmentManager.getNoUseEditPrivilegePassword());
		zfuserhomepage.noPrivilegeToEditUser();
	}
	
	@Test
	public void Tc02NoPrivilegeToChangeThresholds()  {
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
		zfuserhomepage.editUserWithNoRole();
		DriverManager.closeAllBrowser();
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
		microsoftlogin.microsoftLogin(EnvironmentManager.getNoPrivilegeUserName(),EnvironmentManager.getNoPrivilegePassword());
		noPrivilegeToChangeThresholds();
	}
	
	

	@Test
	public void Tc03NoPrivilegeToEditAssets()  {
		microsoftlogin.microsoftLogin(EnvironmentManager.getOperatorUserName(),EnvironmentManager.getOperatorPassword());
		zfuserhomepage.noPrivilegeToEditAssets();
	}
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}
}
