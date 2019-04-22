package zf.api.pages;

import java.util.List;

import framework.DatabaseUtility;
import framework.ExtentReport;
import framework.JsonReader;
import framework.RestApiUtility;

public class PropulsionTypePage extends ExtentReport {
	
	JsonReader jsonData=new JsonReader();
	RestApiUtility restapiutility=new RestApiUtility();
	DatabaseUtility databaseutility=new DatabaseUtility();
	List<String> SelectQueryResult = null;

	public boolean DeletePropulsionType() {
		boolean DeletePropulsionRequestID = false;
		try {
			DeletePropulsionRequestID = restapiutility.DeletePropulsionType("propulsionType");

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DeletePropulsionRequestID;
	}
	
	public void getSpecificPropulsionTypeDetails() {
	
		String getService = restapiutility.GetService("getSpecificPropulsionTypeDetails");
	}
	public void getPropulsionTypeDetails() {
		 String getService = restapiutility.GetService("getPropulsionTypeDetails");
			System.out.println(getService);
	}
}