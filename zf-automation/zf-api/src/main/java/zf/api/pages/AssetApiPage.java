package zf.api.pages;

import java.util.List;

import org.testng.Assert;

import framework.DatabaseUtility;
import framework.EnvironmentManager;
import framework.ExtentReport;
import framework.JsonReader;
import framework.RestApiUtility;

public class AssetApiPage extends ExtentReport{
	//JsonReader jsonObj=new JsonReader();
	JsonReader jsonData=new JsonReader();
	RestApiUtility restapiutility=new RestApiUtility();
	DatabaseUtility databaseutility=new DatabaseUtility();
	List<String> SelectQueryResult = null;
	String assetResponse = null;
	boolean assetDelete = false;

	public String createAsset() {
		String assetID = null;
		try {
			assetID = restapiutility.CreateAssets("CreateAsset");

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return assetID;

	}

	public void validateNewAssetusingGetAPI(String assetID) {
		try {
			if(assetID==null) {
				ExtentReport.testFailed("Assetid is ="+assetID +"not able to validate using get API");	
			}else {
			assetResponse = restapiutility.GetAsset(assetID);
			if(assetResponse!= null) {
				ExtentReport.testPassed("Value from GetAPI "+assetResponse.toString()+" contains the AssetID : "+assetID );
			}else {
				ExtentReport.testFailed("Value from GetAPI "+assetResponse.toString()+" contains the AssetID : "+assetID );
			}
			}
		}catch(Exception e) {
			ExtentReport.testFailed("Assetid "+assetID +"is not deleted from DB");
		}
	}

	public void deleteAssetInDB(String assetID) {
		try {
			JsonReader.getJsonObject(EnvironmentManager.getSqlServer().trim());
			String SelectQuery = jsonData.getJsonData("SelectAssetQueryUsingAssetId");
			SelectQuery = SelectQuery.replaceFirst("tempValue", assetID);
			assetDelete = restapiutility.DeleteAsset(assetID);
			if(assetDelete) {
				ExtentReport.testPassed("Assetid "+assetID +"is deleted from DB");
			}else {
				ExtentReport.testFailed("Assetid "+assetID +"is not deleted from DB");
			}
			
			SelectQueryResult = databaseutility.getSelectQueryResult(databaseutility.getConnection(EnvironmentManager.getSqlServer()),SelectQuery);
			if(!DatabaseUtility.selectQueryComparision(SelectQueryResult,assetID)){
				ExtentReport.testPassed("Unable to find the Asset with id :"+assetID +" deleted sucessfully in DB" );
			}else {
				ExtentReport.testFailed("Able to find the Asset with id :"+assetID +" in DB" );
			}
			assetResponse = restapiutility.GetAsset(assetID);
			Assert.assertNull(assetResponse, "Unable to find the Asset with id :"+assetID +" deleted sucessfully Checking using Get Assest API");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public void validateNewAssetInDB(String assetID) {
		try {
			JsonReader.getJsonObject(EnvironmentManager.getSqlServer().trim());
			String SelectQuery = jsonData.getJsonData("SelectAssetQueryUsingAssetId");	
			SelectQuery = SelectQuery.replaceFirst("tempValue", assetID);
			SelectQueryResult = databaseutility.getSelectQueryResult(databaseutility.getConnection(EnvironmentManager.getSqlServer()),SelectQuery);
			if(DatabaseUtility.selectQueryComparision(SelectQueryResult,assetID)){
				ExtentReport.testPassed("Value from DB "+SelectQueryResult.toString()+" contains the AssetID : "+assetID+ " in the database" );
			}else {
				ExtentReport.testFailed("Value from DB "+SelectQueryResult.toString()+" don't the AssetID : "+assetID+ " in the database" );
			}
		}catch(Exception e) {
			ExtentReport.testFailed("Value from DB "+SelectQueryResult.toString()+" don't the AssetID : "+assetID+ " in the database" );
		}
	}
}
