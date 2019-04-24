package zf.api.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zf.api.pages.ServiceDescriptorPage;

public class ServiceDescriptorTest extends ServiceDescriptorPage{

	public String SagaStatus;
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
	}
	
	@Test(priority=1,enabled = true)
	public void GetServiceDescriptor() throws InterruptedException {
		getServiceDescriptor();
			}
	
	@Test(priority=1,enabled = true)
	public void AssignServiceDescriptorToCLientWithoutAppId() throws InterruptedException {
		assignServiceDescriptorToCLientWithoutAppId();
			}
	@Test(priority=1,enabled = true)
	public void GetSagaStatusCLientWithoutAppId() throws InterruptedException {
		getSagaStatusCLientWithoutAppId();
			}
	
	@Test(priority=1,enabled = true)
	public void TCAssigningServiceDescriptorWithAppidToTheClient()
	{
		SagaStatus=AssigningServiceDescriptorWithAppidToTheClient();
		System.out.println(SagaStatus);
	}
	
	@Test(priority=2,enabled = true)
	public void GetSagaStatusCLientWithAppId() throws InterruptedException {
		getSagaStatusCLientWithAppId(SagaStatus);
			}
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
	}
}