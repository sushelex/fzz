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
	
	
	public boolean AssigningServiceDescriptorWithAppidToTheClient() {
		boolean ServiceDescriptorRequestID = false;
		try {
			ServiceDescriptorRequestID = restapiutility.ServiceDescriptorWithAppidToTheClient("ServiceDescriptorWithAppId");

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ServiceDescriptorRequestID;
	}
}
