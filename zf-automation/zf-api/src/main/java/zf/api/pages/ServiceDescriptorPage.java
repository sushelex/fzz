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
		String getService = restapiutility.GetService("servicedescriptorservice");
		
	}
	public void assignServiceDescriptorToCLientWithoutAppId() {
		String assignServiceToClientWithoutAppid = restapiutility.GetService("ServiceDescriptorWithAppId");
		System.out.println(assignServiceToClientWithoutAppid);
	}
	public void getSagaStatusCLientWithoutAppId() {
		String getSagaService = restapiutility.GetService("sagastatusfail");
		System.out.println(getSagaService);
	
	}
	
	public String AssigningServiceDescriptorWithAppidToTheClient() {
		String ServiceDescriptorRequestID = null;
		try {
			ServiceDescriptorRequestID = restapiutility.ServiceDescriptorWithAppidToTheClient("ServiceDescriptorWithAppId");

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ServiceDescriptorRequestID;
}
	
	public void getSagaStatusCLientWithAppId(String SagaStatus) {
		String getSagaService = restapiutility.SagaEntity(SagaStatus);
		System.out.println(getSagaService);
	
	}
}
