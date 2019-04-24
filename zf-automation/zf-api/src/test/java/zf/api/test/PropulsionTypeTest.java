package zf.api.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zf.api.pages.PropulsionTypePage;

public class PropulsionTypeTest extends PropulsionTypePage {

	
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
	}
	
	@Test(priority=0,enabled = true)
	public void CreatePropulsionType() throws InterruptedException {
		createPropulsionType();
	}
	@Test(priority=1,enabled = true)
	public void TC01DeletePropulsionType() throws InterruptedException {
		DeletePropulsionType();
	}
	@Test(priority=2,enabled = true)
	public void TC02GetSpecificPropulsionTypeDetails(){
		getSpecificPropulsionTypeDetails();
	}
	@Test(priority=3,enabled = true)
	public void TC03GetPropulsionTypeDetails() {
		getPropulsionTypeDetails();
	}
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
	}
}