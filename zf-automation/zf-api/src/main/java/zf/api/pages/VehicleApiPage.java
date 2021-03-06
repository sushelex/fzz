package zf.api.pages;

import java.util.List;

import org.testng.Assert;

import framework.DatabaseUtility;
import framework.EnvironmentManager;
import framework.ExtentReport;
import framework.JsonReader;
import framework.RestApiUtility;

public class VehicleApiPage extends ExtentReport {
	String vehicleID = null;	
	DatabaseUtility databaseutility=new DatabaseUtility();
	RestApiUtility restapiutility=new RestApiUtility();
	JsonReader jsonData=new JsonReader();
	List<String> SelectQueryResult = null;
	String vehicleResponse = null;
	boolean vehicleDelete = false;	
	
	
	public String createVehicleType() {
		String vehicleTypeID = null;
		try {
			vehicleTypeID = restapiutility.CreateVehicleType("CreateVehicleTypeData");

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return vehicleTypeID;

	}
	
	public void validateNewVehicleusingGetAPI(String vehicleID) {
		try {
			vehicleResponse = restapiutility.GetVehicle(vehicleID);
			
			if(vehicleResponse!= null) {
				ExtentReport.testPassed("Value from GetAPI "+vehicleResponse.toString()+" contains the vehicleID : "+vehicleID );
			}else {
				ExtentReport.testFailed("Value from GetAPI "+vehicleResponse.toString()+" contains the vehicleID : "+vehicleID );
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void validateNewVehicleInDB(String vehicleID) {
		try {
			JsonReader.getJsonObject(EnvironmentManager.getSqlServer().trim());
			String SelectQuery = jsonData.getJsonData("SelectAssetQueryUsingVehicleId");	
			SelectQuery = SelectQuery.replaceFirst("tempValue", vehicleID);
			SelectQueryResult = databaseutility.getSelectQueryResult(databaseutility.getConnection(EnvironmentManager.getSqlServer()),SelectQuery);
			if(DatabaseUtility.selectQueryComparision(SelectQueryResult,vehicleID)){
				ExtentReport.testPassed("Value from DB "+SelectQueryResult.toString()+" contains the VehicleId : "+vehicleID+ " in the database" );
			}else {
				ExtentReport.testFailed("Value from DB "+SelectQueryResult.toString()+" don't the VehicleId : "+vehicleID+ " in the database" );
			}
		}catch(Exception e) {
			ExtentReport.testFailed("Value from DB "+SelectQueryResult.toString()+" don't the VehicleId : "+vehicleID+ " in the database" );
		}
	}
	
	public void deleteVehicleInDB(String vehicleID) {
		try {
			
			JsonReader.getJsonObject(EnvironmentManager.getSqlServer().trim());
			String SelectQuery = jsonData.getJsonData("SelectAssetQueryUsingVehicleId");
			vehicleDelete = restapiutility.DeleteVehicle(vehicleID);
			
			if(vehicleDelete) {
				ExtentReport.testPassed("vehicleID "+vehicleID +"is deleted from DB");
			}else {
				ExtentReport.testFailed("vehicleID "+vehicleID +"is not deleted from DB");
			}
			SelectQueryResult = databaseutility.getSelectQueryResult(databaseutility.getConnection(EnvironmentManager.getSqlServer()),SelectQuery);
			
			if(!DatabaseUtility.selectQueryComparision(SelectQueryResult,vehicleID)){
				ExtentReport.testPassed("Unable to find the vehicle with id :"+vehicleID +" deleted sucessfully in DB" );
			}else {
				ExtentReport.testFailed("Able to find the vehicle with id :"+vehicleID +" in DB" );
			}
			vehicleResponse = restapiutility.GetVehicle(vehicleID);
			Assert.assertNull(vehicleResponse, "Unable to find the vehicle with id :"+vehicleID +" deleted sucessfully Checking using Get vehicle API");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void validateVehicleTypeGetAPI() {
		try {
			 String getVehicleTypeDetails = restapiutility.getVehicleTypeDetails();
//			 String getVehicleTypeDetails = restapiutility.GetVehicleTypeDetails();
			System.out.println(getVehicleTypeDetails);
			if(getVehicleTypeDetails!= null) {
				ExtentReport.testPassed("Value from GetAPI "+getVehicleTypeDetails.toString()+" ");
			}else {
				testFailed("GetAPI does not containsvehicle details" );
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean DeleteTheSpecifiedVehicleType(String VehicleID)
	{
			boolean DeleteVehicleTypeRequestID = false;
			try {
				DeleteVehicleTypeRequestID = restapiutility.DeleteVehicle(VehicleID);

			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return DeleteVehicleTypeRequestID;
		}
	
	

}
