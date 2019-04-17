package zf.api.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zf.api.pages.RegistrationRequestApiPage;

public class RegistrationRequestApiTest extends RegistrationRequestApiPage{
	
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
	}
	
	@Test(priority=1,enabled = true)
	public void AcceptRegistrationRequest() throws InterruptedException {
		acceptRegistrationRequest();
	}
	
	@Test(priority=1,enabled = true)
	public void RejectRegistrationRequest() throws InterruptedException {
		rejectRegistrationRequest();
		
	}
	@Test(priority=1,enabled = true)
	public void CreateRegistrationRequest() throws InterruptedException {
		createRegistrationRequestUsedEmail();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
	}
}
