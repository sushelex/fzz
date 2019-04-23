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
	
	@Test
	public void CreateNewVehicle() throws InterruptedException {
		createVehicleType();
	}
	
	@Test
	public void ValidateAllAvailableVehicleTypes() throws InterruptedException {
		validateVehicleTypeGetAPI();
	}
	
	@Test
	public void ValidateDetailsOfSpecificVehicleType() throws InterruptedException {
		String vehicleTypeID = createVehicleType();
		validateNewVehicleusingGetAPI(vehicleTypeID);
	}
	
		
	@Test(priority=1,enabled = true)
	public void DeleteVehicleInDB() {
		String VehicleID = createVehicleType();
		deleteVehicleInDB(VehicleID);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
	}

}
