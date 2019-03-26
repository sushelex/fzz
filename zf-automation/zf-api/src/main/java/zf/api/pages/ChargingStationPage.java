package zf.api.pages;

import java.util.List;

import org.testng.Assert;

import framework.DatabaseUtility;
import framework.EnvironmentManager;
import framework.ExtentReport;
import framework.JsonReader;
import framework.RestApiUtility;

public class ChargingStationPage extends ExtentReport {
	String chargingStationID = null;	
	DatabaseUtility databaseutility=new DatabaseUtility();
	RestApiUtility restapiutility=new RestApiUtility();
	JsonReader jsonData=new JsonReader();
	List<String> SelectQueryResult = null;
	String vehicleResponse = null;
	boolean vehicleDelete = false;	
	String chargingStationResponse = null;
	boolean chargingStationDelete = false;	
	
	
	public String createChargingStation() {
		
		try {
			JsonReader.getJsonObject(EnvironmentManager.getSqlServer().trim());
			chargingStationID = restapiutility.CreateChargingStation("CreateChargingStationData");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return chargingStationID;
	}
	
	public void validateNewChargingStationusingGetAPI(String chargingStationID) {
		try {
			chargingStationResponse = restapiutility.GetChargingStation(chargingStationID);
			
			if(chargingStationResponse!= null) {
				ExtentReport.testPassed("Value from GetAPI "+chargingStationResponse.toString()+" contains the chargingStationID : "+chargingStationID );
			}else {
				ExtentReport.testFailed("Value from GetAPI "+chargingStationResponse.toString()+" contains the chargingStationID : "+chargingStationID );
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void ValidatenewlycreatedChargingStationInDB(String chargingStationID) {
		try {
			JsonReader.getJsonObject(EnvironmentManager.getSqlServer().trim());
			String SelectQuery = jsonData.getJsonData("SelectAssetQueryUsingChargingStationId");	
			SelectQuery = SelectQuery.replaceFirst("tempValue", chargingStationID);
			SelectQueryResult = databaseutility.getSelectQueryResult(databaseutility.getConnection(EnvironmentManager.getSqlServer()),SelectQuery);
			if(DatabaseUtility.selectQueryComparision(SelectQueryResult,chargingStationID)){
				ExtentReport.testPassed("Value from DB "+SelectQueryResult.toString()+" contains the chargingStationID : "+chargingStationID+ " in the database" );
			}else {
				ExtentReport.testFailed("Value from DB "+SelectQueryResult.toString()+" don't the chargingStationID : "+chargingStationID+ " in the database" );
			}
		}catch(Exception e) {
			ExtentReport.testFailed("Value from DB "+SelectQueryResult.toString()+" don't the chargingStationID : "+chargingStationID+ " in the database" );
		}
	}
	
	public void deleteChargingStationInDB(String chargingStationID) {
		try {
			
			JsonReader.getJsonObject(EnvironmentManager.getSqlServer().trim());
			String SelectQuery = jsonData.getJsonData("SelectAssetQueryUsingChargingStationId");
			chargingStationDelete = restapiutility.DeleteChargingStation(chargingStationID);
			
			if(chargingStationDelete) {
				ExtentReport.testPassed("chargingStationID "+chargingStationID +"is deleted from DB");
			}else {
				ExtentReport.testFailed("chargingStationID "+chargingStationID +"is not deleted from DB");
			}
			SelectQueryResult = databaseutility.getSelectQueryResult(databaseutility.getConnection(EnvironmentManager.getSqlServer()),SelectQuery);
			
			if(!DatabaseUtility.selectQueryComparision(SelectQueryResult,chargingStationID)){
				ExtentReport.testPassed("Unable to find the charging Station with id :"+chargingStationID +" deleted sucessfully in DB" );
			}else {
				ExtentReport.testFailed("Able to find the charging Station with id :"+chargingStationID +" in DB" );
			}
			chargingStationResponse = restapiutility.GetChargingStation(chargingStationID);
			Assert.assertNull(vehicleResponse, "Unable to find the charging Station with id :"+chargingStationID +" deleted sucessfully Checking using Get charging Station API");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
