package zf.api.pages;

import framework.DatabaseUtility;
import framework.ExtentReport;
import framework.JsonReader;
import framework.RestApiUtility;

public class PropulsionTypesPage extends ExtentReport {

	DatabaseUtility databaseutility=new DatabaseUtility();
	RestApiUtility restapiutility=new RestApiUtility();
	JsonReader jsonData=new JsonReader();
	
	public void createNewPropulsionType(){
		restapiutility.CreateServices(servicename, payloadValues)
	}
}
