package zf.api.pages;

import framework.DatabaseUtility;
import framework.ExtentReport;
import framework.JsonReader;
import framework.RestApiUtility;

public class ServiceDescriptorPage extends ExtentReport{

	JsonReader jsonData=new JsonReader();
	RestApiUtility restapiutility=new RestApiUtility();
	DatabaseUtility databaseutility=new DatabaseUtility();
	
	public void getServiceDescriptor() {
		restapiutility.GetService("servicedescriptorservice");
	}
}
