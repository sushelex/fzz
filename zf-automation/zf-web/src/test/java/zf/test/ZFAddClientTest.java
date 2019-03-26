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

public class ZFAddClientTest extends ZFClientHomePage{
	MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();

	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
	}

	@Test
	public void Tc01AddSubClientWithAllFeilds() throws InterruptedException {
		AddSubClient();
	}
	
	@Test
	public void Tc02AddSubClientWithMandatoryDetails() throws InterruptedException {
		addSubClientWithMandatoryDetails();
	}
	
	@Test
	public void Tc03CreateNewSubClientValidation()
	{
		verifyCreateNewSubClientValidation();
	}
	
	@Test
	public void Tc04CreateNewSubClientEamilValidation()
	{
		verifyCreateNewSubClientEmailValidation();
	}

	@Test
	public void Tc05CreateNewSubClientWithWrongTelephoneFormat()
	{
		verifyCreateNewSubClientWithWrongTelephoneFormat();
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}
}