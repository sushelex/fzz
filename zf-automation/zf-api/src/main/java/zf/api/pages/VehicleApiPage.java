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
	
	JsonReader jsonData=new JsonReader();
	List<String> SelectQueryResult = null;
	String vehicleResponse = null;
	boolean vehicleDelete = false;	
	
	
	public String createVehicle() {
		
		try {
			JsonReader.getJsonObject(EnvironmentManager.getSqlServer().trim());
			 vehicleID = RestApiUtility.CreateVehicle("CreateVehicleData");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return vehicleID;
	}
	
	public void validateNewVehicleusingGetAPI(String vehicleID) {
		try {
			vehicleResponse = RestApiUtility.GetVehicle(vehicleID);
			
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
			SelectQueryResult = DatabaseUtility.getSelectQueryResult(DatabaseUtility.getConnection(EnvironmentManager.getSqlServer()),SelectQuery);
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
			vehicleDelete = RestApiUtility.DeleteVehicle(vehicleID);
			
			if(vehicleDelete) {
				ExtentReport.testPassed("vehicleID "+vehicleID +"is deleted from DB");
			}else {
				ExtentReport.testFailed("vehicleID "+vehicleID +"is not deleted from DB");
			}
			SelectQueryResult = DatabaseUtility.getSelectQueryResult(DatabaseUtility.getConnection(EnvironmentManager.getSqlServer()),SelectQuery);
			
			if(!DatabaseUtility.selectQueryComparision(SelectQueryResult,vehicleID)){
				ExtentReport.testPassed("Unable to find the vehicle with id :"+vehicleID +" deleted sucessfully in DB" );
			}else {
				ExtentReport.testFailed("Able to find the vehicle with id :"+vehicleID +" in DB" );
			}
			vehicleResponse = RestApiUtility.GetVehicle(vehicleID);
			Assert.assertNull(vehicleResponse, "Unable to find the vehicle with id :"+vehicleID +" deleted sucessfully Checking using Get vehicle API");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
