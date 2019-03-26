package zf.test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.RestApiUtility;
import framework.DriverManager;
import framework.EnvironmentManager;
import framework.ExcelReader;
import framework.ExtentReport;
import framework.JsonReader;
import framework.TestLogger;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.ParseException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import framework.ExtentReport;
//import DatabaseUtility;

public class ApiTesting {

	ExtentReport extentReport=new ExtentReport(); 
	JsonReader jsonObj=new JsonReader();

	
	@BeforeMethod
	public void beforeMethod(Method testName) {
		
		extentReport.startTest(testName.getName());
	}

	@Test(priority=1,enabled = false)
	public void testAuthorizationToken() {
		String ClientAuthorizationToken = null;
		String AssetAuthorizationToken = null;
		String DeviceAuthorizationToken = null;
		
		
		ExtentReport.info("Getting Authorization token of Client service");
		ClientAuthorizationToken = RestApiUtility.getAuthorizationToken("client");
		ExtentReport.info("ClientAuthorizationToken is : "+ClientAuthorizationToken);
		if(ClientAuthorizationToken==null) {
			Assert.fail("Creating Client Authorization Token failed");
		}
		
		ExtentReport.info("Getting Authorization token of Asset service");
		AssetAuthorizationToken = RestApiUtility.getAuthorizationToken("asset");
		ExtentReport.info("AssetAuthorizationToken is : "+AssetAuthorizationToken);
		if(AssetAuthorizationToken==null) {
			Assert.fail("Creating Asset Authorization Token failed");
		}
		
		ExtentReport.info("Getting Authorization token of Device service");
		DeviceAuthorizationToken = RestApiUtility.getAuthorizationToken("device");
		ExtentReport.info("DeviceAuthorizationToken is : "+DeviceAuthorizationToken);
		if(DeviceAuthorizationToken==null) {
			Assert.fail("Creating Device Authorization Token failed");
		}			
	}
	
	@Test(priority=2,enabled = false)
	public void testGetServices() {
		/*
		 * Response deviceJson = null; JsonPath assetJson = null; JsonPath clientJson =
		 * null; List<String> deviceDescriptionList = null; List<String> clientNameList
		 * = null; List<String> assetNameList = null;
		 * 
		 * String val = "Vario 826"; String clientValue = "Openmatics 2"; String
		 * assetName = "Uber Auto Action";
		 * //**************************************************************
		 * ExtentReport.info("Generating Get request aginst Device Service"); deviceJson
		 * = RestApiUtility.GetServices("device"); deviceDescriptionList =
		 * deviceJson.getList("description"); if(deviceDescriptionList.contains(val)) {
		 * ExtentReport.info(val +" is present in the available Devices"); }else {
		 * Assert.fail(val +" is not present in the available Devices"); }
		 * 
		 * //**************************************************************
		 * ExtentReport.info("Generating Get request aginst Client Service"); clientJson
		 * = RestApiUtility.GetServices("client"); clientNameList =
		 * clientJson.getList("name");
		 * ExtentReport.info("Available Client List are : "); for(String client
		 * :clientNameList) { ExtentReport.info("Available Client are : " +client); }
		 * if(clientNameList.contains(clientValue)) { ExtentReport.info(clientValue
		 * +" is present in the available Clients"); }else { Assert.fail(clientValue
		 * +" is not present in the available Clients"); }
		 * //**************************************************************
		 * ExtentReport.info("Generating Get request aginst Asset Service"); assetJson =
		 * RestApiUtility.GetServices("asset"); assetNameList =
		 * assetJson.getList("name"); ExtentReport.info("Available Asset List are : ");
		 * for(String asset :assetNameList) { ExtentReport.info("Available Asset are : "
		 * +asset); } if(assetNameList.contains(assetName)) {
		 * ExtentReport.info(assetName +" is present in the available Assets"); }else {
		 * Assert.fail(assetName +" is not present in the available Assets"); }
		 * //**************************************************************
		 */			
	}
	
	
	@Test(priority=3,enabled = false)
	public void testCreateGetAndDeleteAsset() {
		Response assetCreated = null;
		Response assetJson = null;
		String deleteAssetMsg = null;
		String createdAssetID = null;
		String createdAssetName = null;
		Response deleteAssetResponse = null;
		
		List<String> assetIdList = null;
		List<String> assetNameList = null;
		
				
		//************************************************************
		ExtentReport.info("Creating Asset");
		assetCreated = RestApiUtility.CreateServices("asset","CreateAssetTemplate","CreateAssetData");
		
		
		if( assetCreated!=null) {
			ExtentReport.info("The created asset response status code is : "+assetCreated.getStatusCode());
			ExtentReport.info("The created asset response is : "+assetCreated.getBody().asString());
			createdAssetID = assetCreated.getBody().asString();
			//ExtentReport.info("The created asset id is : "+assetCreated.jsonPath().getString("id")+" and name is "+assetCreated.jsonPath().getString("name"));
			//createdAssetName = assetCreated.jsonPath().getString("name");
		}
		else {
			ExtentReport.info("The created asset response status code is : "+assetCreated.getStatusCode());
			Assert.fail("Failed to create the Asset");
		}
		//************************************************************
		assetJson = RestApiUtility.GetServices("asset",createdAssetID);
		createdAssetName = assetJson.getBody().jsonPath().getString("name");
		 
		//************************************************************
		ExtentReport.info("Verifying "+createdAssetID +" is present in the available Assets");
		//assetIdList = assetJson.jsonPath().getList("id");
		if(assetJson!=null && assetJson.getStatusCode()==200) {
			ExtentReport.info(createdAssetID +" is present in the available Assets");
		}else {
			Assert.fail(createdAssetID +" is not present in the available Assets");
		}
		//**************************************************************
		ExtentReport.info("Deleting the created Asset "+ createdAssetName +" by using Delete service request against assets and veriying the same");
		deleteAssetResponse = RestApiUtility.DeleteServices("asset",createdAssetID);
		
		if( deleteAssetResponse!=null && deleteAssetResponse.getStatusCode()==200) {
			ExtentReport.info("The deleteted asset "+createdAssetName+" status code is "+deleteAssetResponse.getStatusCode());
			ExtentReport.info("The deleteted asset "+createdAssetName+" response is "+deleteAssetResponse.getBody().asString());
		}
		else {
			ExtentReport.info("The deleteted asset "+createdAssetName+" status code is "+deleteAssetResponse.getStatusCode());
			Assert.fail("Failed to delete the Asset "+createdAssetName);
		}
		
		//**************************************************************	
		ExtentReport.info("Verifying "+createdAssetID +" is not present in the available Assets");
		//assetIdList = assetJson.jsonPath().getList("id");
		assetJson = RestApiUtility.GetServices("asset");
		assetIdList = assetJson.jsonPath().getList("id");
		if(!assetIdList.contains(createdAssetID)) {
			ExtentReport.info(createdAssetID +" is not present in the available Assets");
		}else {
			Assert.fail(createdAssetID +" is  present in the available Assets");
		}
		//**************************************************************
		
	}
	

	@Test(priority=3,enabled = false)
	public void testCreateGetAndDeleteUser() {
		Response userCreated = null;
		Response userJson = null;
		String deleteAssetMsg = null;
		String createUserID = null;
		String createdUserName = null;
		Response deleteUserResponse = null;
		
		List<String> assetIdList = null;
		List<String> assetNameList = null;
		
		//************************************************************
		JSONObject CreateUserJson = JsonReader.getJsonObject("CreateUserData");
		String displayName = CreateUserJson.get("displayName").toString() + RestApiUtility.getRandomNumber();
		CreateUserJson.put("displayName",displayName);
		ExtentReport.info("Created UserData payload is "+CreateUserJson.toJSONString());
				
		//************************************************************
		ExtentReport.info("Creating User");
		userCreated = RestApiUtility.CreateServices("user",CreateUserJson);		
		
		if( userCreated!=null && userCreated.getStatusCode()==200) {
			ExtentReport.info("The created User response status code is : "+userCreated.getStatusCode());
			ExtentReport.info("The created User response is : "+userCreated.getBody().asString());
			createUserID = userCreated.getBody().asString();			
		}
		else {
			ExtentReport.info("The created user response status code is : "+userCreated.getStatusCode());
			//Assert.fail("Failed to create the user");
		}
		//************************************************************
		userJson = RestApiUtility.GetServices("user",createUserID);
		ExtentReport.info("Created User is "+userJson.getBody().asString());
		createdUserName = userJson.getBody().jsonPath().getString("displayName");	
		
		 
		//************************************************************
		ExtentReport.info("Verifying "+createUserID +" is present in the available Users");
		if(userJson.getStatusCode()==200) {
			ExtentReport.info(createUserID +" is present in the available Users");
		}else {
			Assert.fail(createUserID +" is not present in the available Users");
		}
		//**************************************************************
		ExtentReport.info("Deleting the created User "+ createUserID +" by using Delete service request against Users and veriying the same");
		deleteUserResponse = RestApiUtility.DeleteServices("user",createUserID);
		
		if( deleteUserResponse!=null && deleteUserResponse.getStatusCode()==204) {
			ExtentReport.info("The deleteted user "+createdUserName+" status code is "+deleteUserResponse.getStatusCode());
			ExtentReport.info("The deleteted user "+createdUserName+" response is "+deleteUserResponse.getBody().asString());
		}
		else {
			ExtentReport.info("The deleteted user "+createdUserName+" status code is "+deleteUserResponse.getStatusCode());
			ExtentReport.info("The deleteted user "+createdUserName+" status code is "+deleteUserResponse.getBody().jsonPath().getString("message"));
			Assert.fail("Failed to delete the user "+createdUserName);
		}
		
		//**************************************************************	
		
		
	}
	

	
	
	@Test(priority=3,enabled = false)
	public void testCreateGetAndDeleteDevice() {
		Response deviceCreatedResponse = null;
		Response deviceGetResponse = null;
		Response deviceDeleteddResponse = null;
		String createdDeviceID = null;
		String deviceAssetId = null;
		Response assetCreated = null;
		Response assetJson = null;
		String deleteAssetMsg = null;
		String createdAssetID = null;
		String createdAssetName = null;
		Response deleteAssetResponse = null;
		
		List<String> assetIdList = null;
		List<String> assetNameList = null;
		
				
		//************************************************************
		//Creating Asset
		ExtentReport.info("Creating Asset");
		assetCreated = RestApiUtility.CreateServices("asset","CreateAssetTemplate","CreateAssetData");
		
		
		if( assetCreated!=null) {
			ExtentReport.info("The created asset response status code is : "+assetCreated.getStatusCode());
			ExtentReport.info("The created asset response is : "+assetCreated.getBody().asString());
			createdAssetID = assetCreated.getBody().asString();			
		}
		else {
			ExtentReport.info("The created asset response status code is : "+assetCreated.getStatusCode());
			Assert.fail("Failed to create the Asset");
		}
		//************************************************************
		JSONObject CreateDeviceJson = JsonReader.getJsonObject("CreateDeviceData");
		String id = CreateDeviceJson.get("id").toString() + RestApiUtility.getRandomNumber();
		CreateDeviceJson.put("assetId",createdAssetID);
		CreateDeviceJson.put("id",id);
		ExtentReport.info("Creating DeviceData payload is "+CreateDeviceJson.toJSONString());
		
		
		//************************************************************
		//Creating Device
		ExtentReport.info("Creating Device");
		deviceCreatedResponse = RestApiUtility.CreateServices("device","CreateDeviceTemplate",createdAssetID);
		if( deviceCreatedResponse!=null && deviceCreatedResponse.getStatusCode()==200) {
			ExtentReport.info("The created device response status code is : "+deviceCreatedResponse.getStatusCode());
			ExtentReport.info("The created device response is : "+deviceCreatedResponse.getBody().asString());
			createdDeviceID = deviceCreatedResponse.getBody().jsonPath().getString("id");	
			deviceAssetId = deviceCreatedResponse.getBody().jsonPath().getString("assetId");
			ExtentReport.info("The created device id is : "+createdDeviceID);
			ExtentReport.info("The created device asset id is : "+deviceAssetId);
			//Validating created asset and device associated asset are same
			if(deviceAssetId.equalsIgnoreCase(createdAssetID)) {
				ExtentReport.info("The created asset id and device associated device id are : "+deviceAssetId);
			}else {
				Assert.fail("The created asset id and device associated device id are not same" );
			}
			
		}
		else {
			ExtentReport.info("The created asset response status code is : "+assetCreated.getStatusCode());
			Assert.fail("Failed to create the Asset");
		}
		//************************************************************
		//Deleting device
		ExtentReport.info("Deleting Device");
		deviceDeleteddResponse = RestApiUtility.DeleteServices("device",createdDeviceID);
		System.out.println(deviceDeleteddResponse.getStatusCode());
		if(deviceDeleteddResponse.getStatusCode()==204) {
			ExtentReport.info("The device is deleted successfully");
		}else {
			ExtentReport.info("The device is not deleted successfully");
			Assert.fail("The device is not deleted successfully");
		}
		//************************************************************
		//Verifying device is not listed in the devices list
		ExtentReport.info("Verifying device is not listed in the devices list");
		deviceGetResponse = RestApiUtility.GetServices("device",createdDeviceID);
		if(deviceGetResponse.getStatusCode()==500) {
			ExtentReport.info("The device is not available in the list of available devices");
		}else {
			ExtentReport.info("The device is available in the list of available devices");
			Assert.fail("The device is not deleted successfully");
		}
		//************************************************************
		
		createdAssetName = RestApiUtility.GetServices("asset" ,createdAssetID).getBody().jsonPath().getString("name");
		//Deleting asset associated with device
		ExtentReport.info("Deleting the created Asset "+ createdAssetName +" by using Delete service request against assets and veriying the same");
		deleteAssetResponse = RestApiUtility.DeleteServices("asset",createdAssetID);
		
		if( deleteAssetResponse!=null) {
			ExtentReport.info("The deleteted asset "+createdAssetName+" status code is "+deleteAssetResponse.getStatusCode());
			ExtentReport.info("The deleteted asset "+createdAssetName+" response is "+deleteAssetResponse.getBody().asString());
		}
		else {
			ExtentReport.info("The deleteted asset "+createdAssetName+" status code is "+deleteAssetResponse.getStatusCode());
			Assert.fail("Failed to delete the Asset "+createdAssetName);
		}
		
		//**************************************************************	
		ExtentReport.info("Verifying "+createdAssetID +" is not present in the available Assets");
		//assetIdList = assetJson.jsonPath().getList("id");
		assetJson = RestApiUtility.GetServices("asset");
		assetIdList = assetJson.jsonPath().getList("id");
		if(!assetIdList.contains(createdAssetID)) {
			ExtentReport.info(createdAssetID +" is not present in the available Assets");
		}else {
			Assert.fail(createdAssetID +" is  present in the available Assets");
		}
		//**************************************************************
		
		
		
		
	}
	
	@Test(priority=1,enabled = true)
	public void testAssociatingServiceDescriptorWithClient() {
		
		
		Response createService = null;
		Response allClientServices = null;
		String createServicerequestId = null;
		String artifactId = null;
		JSONObject CreateServiceJson = null;
		JSONObject CreateVersionJson = null;
		String name = null;
		Response createVersion = null;
		String createVersionrequestId = null;
		Response SagaResponse = null;
		Response allServiceDescriptorServices = null;
		List<String> serviceIds = null;
		List<String> serviceArtifacts = null;
		String serviceID = null;
		String ClientServiceId = null;
		String statusSaga = null;
		Response SagaEventsResponse = null;
  
		ExtentReport.info("Generating Create CreateService Request"); 
		
		//************************************************************
		//Creating Create service payload
		CreateServiceJson = JsonReader.getJsonObject("CreateService");
		artifactId = CreateServiceJson.get("artifactId").toString() + RestApiUtility.getRandomNumber();
		CreateServiceJson.put("artifactId",artifactId);
		ExtentReport.info("Creating CreateService payload is "+CreateServiceJson.toJSONString());			
			
		//************************************************************
		//Creating Service
		ExtentReport.info("Creating CreateService Request");
		createService = RestApiUtility.CreateServices("createservice",CreateServiceJson);	
		if( createService!=null && createService.getStatusCode()==200) {
			ExtentReport.info("Create Service Request created successfully");
		}else {
			ExtentReport.info("Unable to Create CreateService Request !!"+createService.getBody().jsonPath().getString("message"));
			Assert.fail("Unable to Create CreateService Request");
		}
		
		ExtentReport.info("Created Service Response is : "+createService.getBody().asString());
		
		//************************************************************
		
		createServicerequestId = createService.getBody().jsonPath().getString("requestId");
		
		System.out.println("Create Service Request id is :"+createServicerequestId);
		
		//************************************************************
		//Creating Createversion payload
		CreateVersionJson = JsonReader.getJsonObject("CreateVersion");
		name = CreateVersionJson.get("name").toString() + RestApiUtility.getRandomNumber();
		CreateVersionJson.put("name",name);
		ExtentReport.info("Creating CreateVersion payload is "+CreateServiceJson.toJSONString());
		CreateVersionJson.put("servicename",artifactId);					
			
		//************************************************************
		//Creating Version
		createVersion = RestApiUtility.CreateServices("createversion",CreateVersionJson);	
		if( createVersion!=null && createVersion.getStatusCode()==200) {
			ExtentReport.info("Create Version Request created successfully");
		}else {
			ExtentReport.info("Unable to Create CreateVersion Request !!"+createVersion.getBody().jsonPath().getString("message"));
			Assert.fail("Unable to Create CreateVersion Request");
		}
		
		ExtentReport.info("Created Version Response is : "+createVersion.getBody().asString());
		//************************************************************
		createVersionrequestId = createVersion.getBody().jsonPath().getString("requestId");
		
		System.out.println("Create Vesrion request id is "+createVersionrequestId);
		
		//************************************************************
		//Getting all the Servicedescriptors
		ExtentReport.info("Getting all the Servicedescriptors");		
		allServiceDescriptorServices = RestApiUtility.GetServices("servicedescriptorservice");
		if( allServiceDescriptorServices!=null && allServiceDescriptorServices.getStatusCode()==200) {
			ExtentReport.info("Able to get the list of all the service descriptors");
			serviceIds = allServiceDescriptorServices.getBody().jsonPath().getList("id");
			serviceArtifacts = allServiceDescriptorServices.getBody().jsonPath().getList("artifactId");
		}else {
			ExtentReport.info("Unable to get the list of all the service descriptors "+ allServiceDescriptorServices.getStatusLine());
			Assert.fail(allServiceDescriptorServices.getStatusLine());
		}
		
		//************************************************************	
		//Getting the Service Descriptor id of the created service
		ExtentReport.info("Getting the Service Descriptor id of the created service with artifactid :"+artifactId);
		int artifactIdIndex = serviceArtifacts.indexOf(artifactId);		
		serviceID = serviceIds.get(artifactIdIndex);
		ExtentReport.info("Service descriptor service id is "+serviceID);
		//************************************************************
		//Getting the List of all client services
		allClientServices = RestApiUtility.GetServices("clientservice");
		
		if( allClientServices!=null && allClientServices.getStatusCode()==200) {
			ExtentReport.info("Able to get the list of all the Client Services "+allClientServices.getBody().asString());
			ClientServiceId = (String)allClientServices.getBody().jsonPath().getList("id").get(0);
			ExtentReport.info("Selected Client service id is :"+ClientServiceId);
			
		}else {
			ExtentReport.info("Unable to get the list of all Client Services "+ allClientServices.getStatusLine());
			Assert.fail(allClientServices.getStatusLine());
		}
		
		//*************************************************************
		JSONObject obj = new JSONObject();
		obj.put("clientserviceid", ClientServiceId);
		obj.put("serviceid",serviceID);
		//*************************************************************
		//Generating Put request against Client service...
		ExtentReport.info("Generating Put request against Client service...");
		SagaResponse = RestApiUtility.PutServices("clientservice", obj);
		System.out.println("status code put "+SagaResponse.getStatusCode());
		if(SagaResponse!=null && SagaResponse.getStatusCode()==202) {
			ExtentReport.info("Successfully generated Put against the create service :"+SagaResponse.getBody().asString());	
			statusSaga = (String)SagaResponse.getBody().jsonPath().getString("status");
			ExtentReport.info("Saga status is :"+statusSaga);
		}else {
			ExtentReport.info("Unable to generate Put against the create service :"+SagaResponse.getStatusCode());
			Assert.fail("Unable to generate Put against the create service");
		}
		
		//*************************************************************
		//Generating saga events response...
		ExtentReport.info("Generating saga events response...");
		SagaEventsResponse = RestApiUtility.GetServices("clientservice", statusSaga);
		if( SagaEventsResponse!=null && SagaEventsResponse.getStatusCode()==200) {
			ExtentReport.info("Able to generate Saga Event response "+SagaEventsResponse.getBody().asString());			
			
		}else {
			ExtentReport.info("Unable to get Saga Event response "+ SagaEventsResponse.getBody().asString());
			Assert.fail(SagaEventsResponse.getStatusLine());
		}
		//*************************************************************
		
		JsonPath jpath = SagaEventsResponse.getBody().jsonPath();
		ExtentReport.info("The status of operation "+jpath.getString("operation") + " of type "+jpath.getString("type") + " is "+ jpath.getString("status")); 
		
				
	}
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		extentReport.getResult(result,testName.getName());

	}

	
	
	


}
