package zf.api.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zf.api.pages.VehicleApiPage;

public class VehicleApiTest extends VehicleApiPage{
	
	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
	}
	
	@Test(priority=1,enabled = true)
	public void CreateVehicle() throws InterruptedException {
		createVehicle();
	}
	
	@Test(priority=1,enabled = true)
	public void ValidatenewlycreatedVehicleInDB() throws InterruptedException {
		String VehicleID = createVehicle();
		validateNewVehicleInDB(VehicleID);
	}
	
	@Test(priority=1,enabled = true)
	public void ValidatenewlycreatedVehicleUsingApi() {
		String VehicleID = createVehicle();
		validateNewVehicleusingGetAPI(VehicleID);
	}
	
	@Test(priority=1,enabled = true)
	public void DeleteVehicleInDB() {
		String VehicleID = createVehicle();
		deleteVehicleInDB(VehicleID);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
	}

}
