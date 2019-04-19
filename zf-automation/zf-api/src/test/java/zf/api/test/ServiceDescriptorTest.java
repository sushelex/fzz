package zf.api.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zf.api.pages.ServiceDescriptorPage;

public class ServiceDescriptorTest extends ServiceDescriptorPage{

	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
	}
	
	
//	@Test(priority=1,enabled = true)
	public void GetServiceDescriptor() throws InterruptedException {
		getServiceDescriptor();
			}
	
	@Test
	public void TCAssigningServiceDescriptorWithAppidToTheClient()
	{
		AssigningServiceDescriptorWithAppidToTheClient();
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
	}

}
