package zf.api.pages;

import java.util.List;

import framework.DatabaseUtility;
import framework.EnvironmentManager;
import framework.ExtentReport;
import framework.JsonReader;
import framework.RestApiUtility;

public class RegistrationRequestApiPage extends ExtentReport {
	JsonReader jsonData=new JsonReader();
	RestApiUtility restapiutility=new RestApiUtility();
	DatabaseUtility databaseutility=new DatabaseUtility();
	List<String> SelectQueryResult = null;
	/*String assetResponse = null;
	boolean assetDelete = false;*/
	  String RegistrationRequestID=null;
	public String acceptRegistrationRequest() {
		String acceptRegistrationRequestID = null;
		try {
			acceptRegistrationRequestID = restapiutility.AcceptRegistrationRequest("AcceptRegistrationRequest");

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return acceptRegistrationRequestID;
	}
	public String createRegistrationRequestUsedEmail() {
		String createRegistrationRequestUsedEmailID = null;
		try {
			createRegistrationRequestUsedEmailID = restapiutility.createRegistrationRequestUsedEmail("RegistrationRequestWithAlreadyUsedEmail");

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return createRegistrationRequestUsedEmailID;
	}
	public String createRegistrationRequest()

	{

		try {
			JsonReader.getJsonObject(EnvironmentManager.getSqlServer().trim());
			
			RegistrationRequestID = restapiutility.CreateRegistrationRequests("CreatingRegistrationData");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return RegistrationRequestID;
	 }



			public String rejectRegistrationRequest()
			{
				String RejectRegistrationID=null;
			  try {
				  
				  RejectRegistrationID = restapiutility.rejectRegistrationRequests("RejectRegistrationData");  
				  
			  }catch(Exception e) {
					System.out.println(e.getMessage());
				}
			  return RejectRegistrationID;
			}
			
}
