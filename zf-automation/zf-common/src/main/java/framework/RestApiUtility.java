package framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minidev.json.JSONObject;
import framework.EnvironmentManager;
import framework.JsonReader;
import framework.TestLogger;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import framework.ExtentReport;


public class RestApiUtility extends ExtentReport{
	public JsonReader jsonData=new JsonReader();
	public static JsonReader jsonObj = null;
	
	public RestApiUtility (){
		jsonObj = new JsonReader();
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
	}
		
	
	/*
	 * ****************************************************************************** 
	 * Name : getAssettoken 
	 * Parameters : authorizationURL (service authorization url) ,serviceName(service name)
	 * Purpose : To get the Authorization token of the Asset service
	 * ******************************************************************************
	*/	
	
	
	
 public String getAssettoken(String authorizationURL,String serviceName) {		
				
		String strToken = null;
		Map<String,String> form = null;
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile().trim());
		
		try {
			form = new HashMap<String,String>();
			TestLogger.appInfo(" Populating form parameters of AssetAuthorization Token ");
			form.put("auth_url", authorizationURL);
			form.put("grant_type", jsonData.getJsonData("GRANT_TYPE"));
			form.put("client_id", jsonData.getJsonData("ASSET_ADD_ID"));
			form.put("client_secret", jsonData.getJsonData("ASSET_ADD_SECRET"));
			form.put("resource", jsonData.getJsonData("ASSET_RESOURCE"));
			form.put("Content-Type", jsonData.getJsonData("AUTHORIZATION_CONTENT_TYPE"));				
			strToken = getToken(form,serviceName);
			ExtentReport.info("Token genereated successfuly "+strToken);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while populating form parameters of AssetAuthorization Token "+e.getMessage());
		}
		return strToken;
		
	}
	
	
	
	 public String getVehicletoken(String authorizationURL,String serviceName) {
		
		return getAssettoken(authorizationURL,serviceName);
		
	}
	
	 public String getChargingStationtoken(String authorizationURL,String serviceName) {
		
		return getAssettoken(authorizationURL,serviceName);
		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : getCreateServicetoken 
	 * Parameters : authorizationURL (service authorization url) ,serviceName(service name)
	 * Purpose : To get the Authorization token of the CreateService
	 * ******************************************************************************
	*/	
	
	public String getCreateServicetoken(String authorizationURL,String serviceName) {		
		
		String strToken = null;
		Map<String,String> form = null;
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		try {
			form = new HashMap<String,String>();
			TestLogger.appInfo(" Populating form parameters of CreateService Authorization Token ");
			form.put("auth_url", authorizationURL);
			form.put("grant_type", jsonData.getJsonData("GRANT_TYPE"));
			form.put("client_id", jsonData.getJsonData("INITS_AAD_ID"));
			form.put("client_secret", jsonData.getJsonData("INITS_AAD_SECRET"));
			form.put("resource", jsonData.getJsonData("INITIATION_RESOURCE"));
			form.put("Content-Type", jsonData.getJsonData("AUTHORIZATION_CONTENT_TYPE"));
			strToken = getToken(form,serviceName);	
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while populating form parameters of ClientAuthorization Token "+e.getMessage());
		}
		return strToken;
		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : getClientServicetoken 
	 * Parameters : authorizationURL (service authorization url) ,serviceName(service name)
	 * Purpose : To get the Authorization token of the ClientService
	 * ******************************************************************************
	*/
	public String getClientServicetoken(String authorizationURL,String serviceName) {		
		
		String strToken = null;
		Map<String,String> form = null;
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		
		try {
			form = new HashMap<String,String>();
			TestLogger.appInfo(" Populating form parameters of ClientService Authorization Token ");
			form.put("auth_url", authorizationURL);
			form.put("grant_type", jsonData.getJsonData("GRANT_TYPE"));
			form.put("client_id", jsonData.getJsonData("SMS_ADD_ID"));
			form.put("client_secret", jsonData.getJsonData("SMS_ADD_SECRET"));
			form.put("resource", jsonData.getJsonData("SMS_ADD_ID"));
			form.put("Content-Type", jsonData.getJsonData("AUTHORIZATION_CONTENT_TYPE"));
			strToken = getToken(form,serviceName);	
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while populating form parameters of ClientAuthorization Token "+e.getMessage());
		}
		return strToken;
		
	}
	
	
	/*
	 * ****************************************************************************** 
	 * Name : getDevicetoken 
	 * Parameters : authorizationURL (service authorization url) ,serviceName(service name)
	 * Purpose : To get the Authorization token of the Device service
	 * ******************************************************************************
	*/
	
	public String getDevicetoken(String authorizationURL,String serviceName) {
		
		String strToken = null;
		Map<String,String> form = null;
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		try {
		
			form = new HashMap<String,String>();
			TestLogger.appInfo(" Populating form parameters of DeviceAuthorization Token ");
			form.put("auth_url", authorizationURL);
			form.put("grant_type", jsonData.getJsonData("GRANT_TYPE"));
			form.put("client_id", jsonData.getJsonData("DEVICE_ADD_ID"));
			form.put("client_secret", jsonData.getJsonData("DEVICE_ADD_SECRET"));
			form.put("resource", jsonData.getJsonData("DEVICE_RESOURCE"));
			form.put("Content-Type", jsonData.getJsonData("AUTHORIZATION_CONTENT_TYPE"));	
			strToken = getToken(form,serviceName);	
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while populating form parameters of DeviceAuthorization Token "+e.getMessage());
		}
		return strToken;		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : getClienttoken 
	 * Parameters : authorizationURL (service authorization url) ,serviceName(service name)
	 * Purpose : To get the Authorization token of the Client service
	 * ******************************************************************************
	*/
	
	public String getClienttoken(String authorizationURL,String serviceName) {	
		String strToken = null;
		Map<String,String> form = null;
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		
		try {
			form = new HashMap<String,String>();
			TestLogger.appInfo(" Populating form parameters of ClientAuthorization Token ");
			form.put("auth_url", authorizationURL);
			form.put("grant_type", jsonData.getJsonData("GRANT_TYPE"));
			form.put("client_id", jsonData.getJsonData("CLIENT_AAD_ID"));
			form.put("client_secret", jsonData.getJsonData("CLIENT_AAD_SERCET"));
			form.put("resource", jsonData.getJsonData("CLIENT_RESOURCE"));
			form.put("Content-Type", jsonData.getJsonData("AUTHORIZATION_CONTENT_TYPE"));
			strToken = getToken(form,serviceName);	
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while populating form parameters of ClientAuthorization Token "+e.getMessage());
		}
		return strToken;
		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : getUsertoken 
	 * Parameters : authorizationURL (service authorization url) ,serviceName(service name)
	 * Purpose : To get the Authorization token of the User service
	 * ******************************************************************************
	*/	
	public String getUsertoken(String authorizationURL,String serviceName) {		
		
		String strToken = null;
		Map<String,String> form = null;
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		try {
			form = new HashMap<String,String>();
			TestLogger.appInfo(" Populating form parameters of UserAuthorization Token ");
			form.put("auth_url", authorizationURL);
			form.put("grant_type", jsonData.getJsonData("GRANT_TYPE"));
			form.put("client_id", jsonData.getJsonData("CLIENT_AAD_ID"));
			form.put("client_secret", jsonData.getJsonData("CLIENT_AAD_SERCET"));
			form.put("resource", jsonData.getJsonData("CLIENT_RESOURCE"));
			form.put("Content-Type", jsonData.getJsonData("AUTHORIZATION_CONTENT_TYPE"));
			strToken = getToken(form,serviceName);	
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while populating form parameters of UserAuthorization Token "+e.getMessage());
		}
		return strToken;
		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : setFormParameters 
	 * Parameters : httpRequest (RequestSpecification instance) ,form(form key value pairs)
	 * Purpose : Setting the form parameters required for token generation
	 * ******************************************************************************
	*/
	static public RequestSpecification setFormParameters(RequestSpecification httpRequest,Map<String,String> form) {
		try {
			TestLogger.appInfo(" Populating form parameters of form ");
			httpRequest.formParam("grant_type",form.get("grant_type"));
			httpRequest.formParam("client_id",form.get("client_id"));
			httpRequest.formParam("client_secret",form.get("client_secret"));
			httpRequest.formParam("resource",form.get("resource"));
			httpRequest.header("Content-Type", form.get("Content-Type"));
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while populating form parameters of form parameters of Token "+e.getMessage());
		}
		
		return httpRequest;
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : getToken 
	 * Parameters : form (form key, value pairs ) ,serviceName(service name)
	 * Purpose : Creating the token of specified service by using form key value pairs
	 * ******************************************************************************
	*/
	
	static public String getToken(Map<String,String> form,String servicename) {
		Response response = null;
		String access_token = null;
		RequestSpecification httpRequest = null;
		try {
			RestAssured.baseURI = form.get("auth_url");
			httpRequest = RestAssured.given();
			
			switch(servicename) {
			case "device":
				setFormParameters(httpRequest,form);
				break;	
			case "asset":
				setFormParameters(httpRequest,form);
				break;
			case "vehicle":
				setFormParameters(httpRequest,form);
				break;
			case "chargingstation":
				setFormParameters(httpRequest,form);
				break;
			case "client":
				setFormParameters(httpRequest,form);
				break;		
			case "user":
				setFormParameters(httpRequest,form);
				break;					
			case "createservice":
				setFormParameters(httpRequest,form);
				break;	
			case "clientservice":
				setFormParameters(httpRequest,form);
				break;
			case "createversion":
				setFormParameters(httpRequest,form);
				break;
			case "servicedescriptorservice":
				setFormParameters(httpRequest,form);
				break;
			
			}
		
			response = httpRequest.request(Method.POST);	
			TestLogger.appInfo(" The response of "+servicename+" getToken is : "+response.body().asString());
			
			access_token = response.jsonPath().getJsonObject("access_token");	
			TestLogger.appInfo(" The generated access token for "+servicename+" is : "+access_token);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating access token for service "+servicename+" : "+e.getMessage());
		}
		return access_token;
		
	}	
	
	/*
	 * ****************************************************************************** 
	 * Name : getAuthorizationToken 
	 * Parameters : serviceName(service name)
	 * Purpose : Creating the Authorization token of specified service 
	 * ******************************************************************************
	*/
	public String getAuthorizationToken(String serviceName) {
		String base_url = null;
		String aad_tenant = null;
		String tauri_authorization_url = null;
		String token = null; 
		
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		base_url = jsonData.getJsonData("LOGIN_MICROSOFT");
		aad_tenant = jsonData.getJsonData("AAD_TENANT");
		tauri_authorization_url = "https://"+base_url+"/"+aad_tenant+"/oauth2/token";
		
		try {
		
		
			switch(serviceName) {
			case "asset":			
				token = getAssettoken(tauri_authorization_url,serviceName);
				break;
			case "vehicle":			
				token = getVehicletoken(tauri_authorization_url,serviceName);
				break;
			case "chargingstation":			
				token = getChargingStationtoken(tauri_authorization_url,serviceName);
				break;
			case "client":			
				token = getClienttoken(tauri_authorization_url,serviceName);
				break;
			case "device":
				token = getDevicetoken(tauri_authorization_url,serviceName);
				break;
			case "user":
				token = getUsertoken(tauri_authorization_url,serviceName);
				break;
			case "createservice":
				token = getCreateServicetoken(tauri_authorization_url,serviceName);
				break;
			case "clientservice":
				token = getClientServicetoken(tauri_authorization_url,serviceName);
				break;
			case "createversion":
				token = getCreateServicetoken(tauri_authorization_url,serviceName);
				break;
			case "servicedescriptorservice":
				token = getClientServicetoken(tauri_authorization_url,serviceName);
				break;
		}
			TestLogger.appInfo("The "+serviceName+" Authorization Token is : "+token);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating Authorization access token for service "+serviceName+" : "+e.getMessage());
		}
		
		//return token.jsonPath().getJsonObject("access_token");
		return token;
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : Get 
	 * Parameters : url(the complete url of the resource), token(the authorization token generated)
	 * Purpose : Getting the Jsonpath of the Get Requests Response 
	 * ******************************************************************************
	*/
	static public Response Get(String url,String token) {
		
		Response jsonResponse = null;
		RequestSpecification httpRequest = null;
		Response getResponse = null;
		try {
		
			RestAssured.baseURI = url;
			httpRequest = RestAssured.given();
			
			//***************************************************************************
			httpRequest.header("authorization", "Bearer "+token);
			getResponse = httpRequest.request(Method.GET);
			//jsonPath = getResponse.jsonPath();
			jsonResponse = getResponse;
			TestLogger.appInfo("The generated JsonPath for Get Request is : "+token);
			
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating JSONPath for Get request : "+e.getMessage());
		}
		
		return jsonResponse;
			
		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : CreateAsset 
	 * Parameters : payloadTemplate(The Json structure of the asset payload),payLoadValues(Data Values for the payloadTemplate)
	 * Purpose : Creating the Payload for Asset Create Post request
	 * ******************************************************************************
	*/	
	
	@SuppressWarnings("static-access")
	static public JSONObject CreateAsset(String payloadTemplate,String payLoadValues)	{
		
		JSONObject CreateAssetTemplate = null;
		JSONObject CreateAssetData = null;
		List<String> temp = null;
		String updatedListVal = null;
		
		
		try {
			//JsonReader.getJsonObject("Tc01addUser");
			CreateAssetTemplate = JsonReader.getJsonObject(payloadTemplate);		
			CreateAssetData = JsonReader.getJsonObject(payLoadValues);		
			CreateAssetTemplate.put("name",CreateAssetData.get("name").toString() + getRandomNumber());
			CreateAssetTemplate.put("description",CreateAssetData.get("description").toString() + getRandomNumber());		
			temp = (List<String>) CreateAssetTemplate.get("clientIdList");
			
			updatedListVal = (String) CreateAssetData.get("clientIdList");
			
			temp.set(0, updatedListVal);
			CreateAssetTemplate.put("clientIdList",temp );	
			
			TestLogger.appInfo("The Generated Payload for Post Asset Create request is : "+CreateAssetTemplate.toJSONString());
		
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating Payload for Post Asset Create request : "+e.getMessage());
		}
		return CreateAssetTemplate;
	}
	
	
	/*
	 * ****************************************************************************** 
	 * Name : CreateUser 
	 * Parameters : payloadTemplate(The Json structure of the User payload),payLoadValues(Data Values for the payloadTemplate)
	 * Purpose : Creating the Payload for User Create Post request
	 * ******************************************************************************
	*/
	
	
	static public JSONObject CreateUser(String payloadTemplate,String payLoadValues)	{
		
		JSONObject CreateUserTemplate = null;
		JSONObject CreateUserData = null;
		try {
			CreateUserTemplate = JsonReader.getJsonObject(payloadTemplate);
			CreateUserData = JsonReader.getJsonObject(payLoadValues);	
			CreateUserTemplate.put("displayName",CreateUserData.get("displayName").toString() + getRandomNumber());
			TestLogger.appInfo("The Generated Payload for Post User Create request is : "+CreateUserTemplate.toJSONString());
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating Payload for Post User Create request : "+e.getMessage());
		}
		return CreateUserTemplate;
	}	
	
	
	/*
	 * ****************************************************************************** 
	 * Name : CreateDevice 
	 * Parameters : payloadTemplate(The Json structure of the device payload),payLoadValues(Data Values for the payloadTemplate)
	 * Purpose : Creating the Payload for User Create Post request
	 * ******************************************************************************
	*/
	
	
	static public JSONObject CreateDevice(String payloadTemplate,String payloadValues)	{
		
		JSONObject CreateDeviceTemplate = null;
		JSONObject CreateDeviceData = null;
		try {
			CreateDeviceTemplate = JsonReader.getJsonObject(payloadTemplate);
			CreateDeviceData = JsonReader.getJsonObject(payloadTemplate);	
			CreateDeviceTemplate.put("assetId",payloadValues);
			CreateDeviceTemplate.put("id",CreateDeviceData.get("id").toString() + getRandomNumber());
			TestLogger.appInfo("The Generated Payload for Post User Create request is : "+CreateDeviceTemplate.toJSONString());
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating Payload for Post User Create request : "+e.getMessage());
		}
		return CreateDeviceTemplate;
	}
	

	
	/*
	 * ****************************************************************************** 
	 * Name : CreateService 
	 * Parameters : payloadTemplate(The Json structure of the CreateService payload),payLoadValues(Data Values for the payloadTemplate)
	 * Purpose : Creating the Payload for CreateService Post request
	 * ******************************************************************************
	*/
	static public JSONObject CreateService(String payloadTemplate,String payloadValues)	{
		
		JSONObject CreateServiceTemplate = null;
		JSONObject CreateServiceData = null;
		try {
			CreateServiceTemplate = JsonReader.getJsonObject(payloadTemplate);
			CreateServiceData = JsonReader.getJsonObject(payloadValues);
			CreateServiceTemplate.put("artifactId",CreateServiceData.get("artifactId").toString() + getRandomNumber());
			TestLogger.appInfo("The Generated Payload for Post CreateService request is : "+CreateServiceTemplate.toJSONString());
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating Payload for Post CreateService request : "+e.getMessage());
		}
		return CreateServiceTemplate;
	}
	
	
	/*
	 * ****************************************************************************** 
	 * Name : getRandomNumber 
	 * Parameters : None
	 * Purpose : Generating Random Number
	 * ******************************************************************************
	*/
	static public long getRandomNumber() {
		Random r = new Random();
		int low = 10000;
		int high = 1000000;
		int result = r.nextInt(high-low) + low;
		TestLogger.appInfo("The Generated Payload for Post User Create request is : "+result);
		return result;
		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : getRandomNumber 
	 * Parameters : low(lowest number),high(maximum number)
	 * Purpose : Generating Random Number
	 * ******************************************************************************
	*/
	static public long getRandomNumber(int low,int high) {
		Random r = new Random();
		int result = r.nextInt(high-low) + low;
		TestLogger.appInfo("The Generated Payload for Post User Create request is : "+result);
		return result;
		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : Post 
	 * Parameters : url(The complete URL of the service),Token(generated Authorization Token),ServiceName(name of the service),payloadTemplate(Structure of the json payload),payloadValues(values of the JsonObject keys)
	 * Purpose : generating a post request for specified service using generated token
	 * ******************************************************************************
	*/
	static public Response Post(String url,String token,String servicename,String payloadTemplate, String payloadValues) {
		
		RequestSpecification httpRequest = null;
		JSONObject JsonService = null;
		Response getResponse = null;
		Response postresponse = null;
		
		try {
			RestAssured.baseURI = url;
			httpRequest = RestAssured.given();
			JsonService = new JSONObject();
			//*****************************************************************************
			switch(servicename) {
			case "asset":				
				JsonService = CreateAsset(payloadTemplate,payloadValues);
				break;
			case "user":
				JsonService = CreateUser(payloadTemplate,payloadValues);
				break;
			case "createservice":				
				JsonService = CreateService(payloadTemplate,payloadValues);
				break;
			case "device":
				JsonService = CreateDevice(payloadTemplate,payloadValues);
				break;	
				
			}		
			//*****************************************************************************
			httpRequest.header("authorization", "Bearer "+token);
			httpRequest.header("Content-Type", "application/json");		
			httpRequest.body(JsonService.toJSONString());	
			getResponse = httpRequest.request(Method.POST);
			//postresponse = getResponse.body().asString();	
			postresponse = getResponse;
			TestLogger.appInfo("The response for post request for th service "+ servicename  +" : "+postresponse);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating Post request for Service "+servicename+" : "+e.getMessage());
		}
		return postresponse;
		
		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : Post 
	 * Parameters : url(The complete URL of the service),Token(generated Authorization Token),ServiceName(name of the service),payloadValues(Key,value pairs of payload)
	 * Purpose : generating a post request for specified service 
	 * ******************************************************************************
	*/
	static public Response Post(String url,String token,String servicename, JSONObject payloadValues) {
		
		RequestSpecification httpRequest = null;
		JSONObject JsonService = null;
		Response getResponse = null;
		Response postresponse = null;
		
		try {
			RestAssured.baseURI = url;
			httpRequest = RestAssured.given();
			JsonService = new JSONObject();
			//*****************************************************************************
			switch(servicename) {
			
			case "device":
				JsonService = (payloadValues);
				break;	
			case "user":
				JsonService = (payloadValues);
				break;	
			case "createservice":
				JsonService = (payloadValues);
				break;
			case "createversion":
				JsonService = (payloadValues);
				break;	
			case "asset":
				JsonService = (payloadValues);
				break;	
			case "vehicle":
				JsonService = (payloadValues);
				break;	
			case "chargingstation":
				JsonService = (payloadValues);
				break;
			}		
			//*****************************************************************************
			httpRequest.header("authorization", "Bearer "+token);
			httpRequest.header("Content-Type", "application/json");		
			httpRequest.body(JsonService.toJSONString());	
			
			ExtentReport.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% "+ JsonService.toJSONString());
			getResponse = httpRequest.request(Method.POST);
			//postresponse = getResponse.body().asString();	
			postresponse = getResponse;
			TestLogger.appInfo("The response for post request for th service "+ servicename  +" : "+postresponse);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating Post request for Service "+servicename+" : "+e.getMessage());
		}
		return postresponse;
		
		
	}

	
	/*
	 * ****************************************************************************** 
	 * Name : Put 
	 * Parameters : url(The complete URL of the service),Token(generated Authorization Token),ServiceName(name of the service),payload(payload for the request)
	 * Purpose : generating a Put request for specified service using generated token
	 * ******************************************************************************
	*/
	static public Response Put(String url,String token,String servicename,String payload) {
		
		RequestSpecification httpRequest = null;
		Response getResponse = null;
		Response putresponse = null;
		
		try {			
			
			//*****************************************************************************
			switch(servicename) {
			case "clientservice":
				RestAssured.baseURI = url+payload;
				httpRequest = RestAssured.given();
				break;
			}		
			//*****************************************************************************
			httpRequest.header("authorization", "Bearer "+token);
				
			getResponse = httpRequest.request(Method.PUT);
			//putresponse = getResponse.jsonPath();
			putresponse = getResponse;
			TestLogger.appInfo("The response for put request for the service "+ servicename  +" : "+putresponse);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating Put request for Service "+servicename+" : "+e.getMessage());
		}
		return putresponse;
		
	}
	
	
	/*
	 * ****************************************************************************** 
	 * Name : PostJson 
	 * Parameters : url(The complete URL of the service),Token(generated Authorization Token),ServiceName(name of the service),payloadTemplate(Structure of the json payload),payloadValues(values of the JsonObject keys)
	 * Purpose : generating a post request for specified service using generated token
	 * ******************************************************************************
	*/
	static public Response PostJson(String url,String token,String servicename,String payloadTemplate,String payloadValues) {
		
		RequestSpecification httpRequest = null;
		JSONObject JsonService = null;
		Response getResponse = null;
		Response postresponse = null;
		
		try {
			RestAssured.baseURI = url;
			httpRequest = RestAssured.given();
			JsonService = new JSONObject();
			//*****************************************************************************
			switch(servicename) {
			case "createservice":
				
				JsonService = CreateService(payloadTemplate,payloadValues);
				break;
			case "device":
				JsonService = CreateDevice(payloadTemplate,payloadValues);
				break;
			}		
			//*****************************************************************************
			httpRequest.header("authorization", "Bearer "+token);
			httpRequest.header("Content-Type", "application/json");		
			httpRequest.body(JsonService.toJSONString());	
			getResponse = httpRequest.request(Method.POST);
			postresponse = getResponse;
			TestLogger.appInfo("The response for post request for th service "+ servicename  +" : "+postresponse);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating Post request for Service "+servicename+" : "+e.getMessage());
		}
		return postresponse;
		
		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : Delete 
	 * Parameters : url(The complete URL of the service),Token(generated Authorization Token)
	 * Purpose : generating a delete request using generated token
	 * ******************************************************************************
	*/
	
	static public Response Delete(String url,String token) {
			RequestSpecification httpRequest = null;
			Response getResponse = null;
			try { 
				RestAssured.baseURI = url;
				httpRequest = RestAssured.given();
				httpRequest.header("authorization", "Bearer "+token);
				httpRequest.header("Content-Type", "application/json");		
				getResponse = httpRequest.request(Method.DELETE);
				TestLogger.appInfo("The delete message body is : "+getResponse.getBody().asString());
				TestLogger.appInfo("The delete message is : "+getResponse.getStatusLine() +" **** "+getResponse.statusCode());			
				//deleteMessage = "The deleted service name is "+getResponse.jsonPath().get("name") +" and the id is " + getResponse.jsonPath().get("id");	
				//TestLogger.appInfo(deleteMessage);
			}catch(Exception e) {
				TestLogger.errorMessage("An exception has occured while generating delete request using URL "+url+" : "+e.getMessage());
			}
			return getResponse;
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : PutServices 
	 * Parameters : servicename(name of the service),payload(payload required for the request)
	 * Purpose : For getting the list of specified service as json
	 * ******************************************************************************
	*/
public Response PutServices(String servicename,JSONObject payload) {
		Response ServiceManagementService = null;
		String base_url = null;
		String token = null;
		
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		
		base_url = jsonData.getJsonData("BASE_URL");
		token = getAuthorizationToken(servicename);
		try {
			switch(servicename) {
			case "clientservice":
				String ClientServiceId = (String)payload.get("clientserviceid");
				String ServiceId = (String)payload.get("serviceid");
				String ServiceManagementClient = jsonData.getJsonData("SERVICE_MANAGEMENT_SERVICE_MULTICLIENT");				 
				String Clients = jsonData.getJsonData("CLIENT");
				String urlInitiateService = base_url +"/"+ServiceManagementClient+"/"+Clients+"/"+ClientServiceId+"/service/";
				ExtentReport.info("The InitiateService url is :"+urlInitiateService);
				ServiceManagementService =  Put(urlInitiateService,token,servicename,ServiceId);
				break;
		}
			TestLogger.appInfo("The PutService response is  "+ servicename +" is "+ServiceManagementService);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating PutSeServiceIdrvices request for the service "+servicename+" : "+e.getMessage());
		}
		
		return ServiceManagementService;		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : GetServices 
	 * Parameters : servicename(name of the service)
	 * Purpose : For getting the list of specified service as json
	 * ******************************************************************************
	*/
	
 public Response GetServices(String servicename ) {
		
		String base_url = null;
		String token = null;
		
		Response getJSON = null;
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		base_url = jsonData.getJsonData("BASE_URL");
		token = getAuthorizationToken(servicename);
		try {
		
		switch(servicename) {
			case "device":
				String DevicesUrl = jsonData.getJsonData("DEVICE_URL");
				String Devices = jsonData.getJsonData("DEVICES");
				String urlDevice = base_url +"/"+DevicesUrl+"/"+Devices+"/";
				getJSON = Get(urlDevice,token);
				break;
			case "asset":
				String AssetsUrl = jsonData.getJsonData("ASSET_URL");
				String Assets = jsonData.getJsonData("ASSETS");
				String urlAsset = base_url +"/"+AssetsUrl+"/"+Assets+"/";
				ExtentReport.info("The asset url is :"+urlAsset);
				getJSON = Get(urlAsset,token);
				break;
			case "client":
				String ClientsUrl = jsonData.getJsonData("CLIENT_URL");
				String Clients = jsonData.getJsonData("CLIENTS");;
				String urlClient = base_url +"/"+ClientsUrl+"/"+Clients;
				ExtentReport.info("The asset url is :"+urlClient);
				getJSON = Get(urlClient,token);
				break;	
			case "clientservice":
				String ServiceManagementClient = jsonData.getJsonData("SERVICE_MANAGEMENT_SERVICE_MULTICLIENT");				 
				String Client = jsonData.getJsonData("CLIENT");
				String urlInitiateService = base_url +"/"+ServiceManagementClient+"/"+Client;
				ExtentReport.info("The InitiateService url is :"+urlInitiateService);
				getJSON = Get(urlInitiateService,token);
				break;
			case "servicedescriptorservice":
				String ServiceManagementMultiClient = jsonData.getJsonData("SERVICE_MANAGEMENT_SERVICE_MULTICLIENT");				 
				String Services = jsonData.getJsonData("SERVICES");
				String urlServiceDescriptorService = base_url +"/"+ServiceManagementMultiClient+"/"+Services;
				ExtentReport.info("The InitiateService url is :"+urlServiceDescriptorService);
				getJSON = Get(urlServiceDescriptorService,token);
				
		}
			TestLogger.appInfo("The getservices jsonpath for specified service "+ servicename +" is "+getJSON.toString());
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating GetServices request for the service "+servicename+" : "+e.getMessage());
		}
		
		return getJSON;
	}
	
	
	/*
	 * ****************************************************************************** 
	 * Name : GetServices 
	 * Parameters : servicename(name of the service),serviceId(service id)
	 * Purpose : For getting the list of specified service as json
	 * ******************************************************************************
	*/
	
	 public Response GetServices(String servicename ,String serviceId) {
		
		String base_url = null;
		String token = null;
		
		Response getJSON = null;
		jsonObj = new JsonReader();
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		base_url = jsonData.getJsonData("BASE_URL");
		token = getAuthorizationToken(servicename);
		try {
		
		switch(servicename) {
			case "device":
				String DevicesUrl = jsonData.getJsonData("DEVICE_URL");
				String Devices = jsonData.getJsonData("DEVICES");
				String urlDevice = base_url +"/"+DevicesUrl+"/"+Devices+"/"+serviceId;
				getJSON = Get(urlDevice,token);
				break;
			case "asset":
				String AssetsUrl = jsonData.getJsonData("ASSET_URL");
				String Assets = jsonData.getJsonData("ASSETS");
				String urlAsset = base_url +"/"+AssetsUrl+"/"+Assets+"/"+serviceId;
				ExtentReport.info("The asset url is :"+urlAsset);
				getJSON = Get(urlAsset,token);
				break;
			case "chargingstation":
				String ChargingStationUrl = jsonData.getJsonData("ASSET_URL");
				String ChargingStation = jsonData.getJsonData("CHARGINGSTATIONS");
				String urlChargingStation = base_url +"/"+ChargingStationUrl+"/"+ChargingStation+"/"+serviceId;
				ExtentReport.info("The Charging Station url is :"+urlChargingStation);
				getJSON = Get(urlChargingStation,token);
				break;
			case "vehicle":
				String VehiclesUrl = jsonData.getJsonData("VEHICLE_URL");
				String Vehicles = jsonData.getJsonData("VEHICLES");
				String urlVehicle = base_url +"/"+VehiclesUrl+"/"+Vehicles+"/"+serviceId;
				ExtentReport.info("The vehicle url is :"+urlVehicle);
				getJSON = Get(urlVehicle,token);
				break;
			case "client":
				String ClientsUrl = jsonData.getJsonData("CLIENT_URL");
				String Clients = jsonData.getJsonData("CLIENTS");;
				String urlClient = base_url +"/"+ClientsUrl+"/"+Clients+"/"+serviceId;
				ExtentReport.info("The asset url is :"+urlClient);
				getJSON = Get(urlClient,token);
				break;	
			case "user":
				String ClientUrl = jsonData.getJsonData("CLIENT_URL");
				String Users = jsonData.getJsonData("USERS");
				String urlUser = base_url +"/"+ClientUrl+"/"+Users+"/"+serviceId;
				ExtentReport.info("The Users url is :"+urlUser);
				getJSON =  Get(urlUser,token);
				break;
			case "clientservice":
				String ClientServiceUrl = jsonData.getJsonData("SERVICE_MANAGEMENT_SERVICE_MULTICLIENT");
				String urlClientService = base_url +"/"+ClientServiceUrl+serviceId;
				ExtentReport.info("The Users url is :"+urlClientService);
				getJSON =  Get(urlClientService,token);
				break;
				
		}
			TestLogger.appInfo("The getservices jsonpath for specified service "+ servicename +" is "+getJSON.toString());
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating GetServices request for the service "+servicename+" : "+e.getMessage());
		}
		
		return getJSON;
	}
	

	
	
	/*
	 * ****************************************************************************** 
	 * Name : CreateServicesJson 
	 * Parameters : servicename(name of the service),payloadTemplate(Structure of the json payload),payloadValues(values of the JsonObject keys)
	 * Purpose : For Creating Specified Service
	 * ******************************************************************************
	*/
public Response CreateServicesJson(String servicename,String payloadtemplate,String payloadValues) {
		Response CreateServiceString = null;
		String base_url = null;
		String token = null;
		
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		base_url = jsonData.getJsonData("BASE_URL");
		token = getAuthorizationToken(servicename);
		try {
			switch(servicename) {
			case "createservice":
				String CreateServiceUrl = EnvironmentManager.getCreateServiceUrl();
				String InitiateService = EnvironmentManager.getInitiateService();
				String urlInitiateService = base_url +"/"+CreateServiceUrl+"/"+InitiateService+"/";
				ExtentReport.info("The InitiateService url is :"+urlInitiateService);
				CreateServiceString =  PostJson(urlInitiateService,token,servicename,payloadtemplate,payloadValues);
				break;
			case "device":
				String DeviceUrl = EnvironmentManager.getDeviceUrl();
				String Devices = EnvironmentManager.getDevices();
				String urlDevice = base_url +"/"+DeviceUrl+"/"+Devices+"/";
				ExtentReport.info("The Users url is :"+urlDevice);
				CreateServiceString =  PostJson(urlDevice,token,servicename,payloadtemplate,payloadValues);
		}
			TestLogger.appInfo("The Createservice response is  "+ servicename +" is "+CreateServiceString);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating CreateServices request for the service "+servicename+" : "+e.getMessage());
		}
		
		return CreateServiceString;
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : DeleteServices 
	 * Parameters : servicename(name of the service),id(service id)
	 * Purpose : For Deleting Specified Service
	 * ******************************************************************************
	*/
	public Response DeleteServices(String servicename,String id) {
		Response DeleteServiceString = null;
		String base_url = null;
		String token = null;
		jsonObj = new JsonReader();
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		base_url = jsonData.getJsonData("BASE_URL");
		token = getAuthorizationToken(servicename);
			try {
				switch(servicename) {
				case "asset":
					String AssetsUrl = jsonData.getJsonData("ASSET_URL");
					String Assets = jsonData.getJsonData("ASSETS");
					String urlAssetDelete = base_url +"/"+AssetsUrl+"/"+Assets+"/"+id;
					ExtentReport.info("The asset url is :"+urlAssetDelete);
					DeleteServiceString =  Delete(urlAssetDelete,token);
					break;
				case "vehicle":
					String VehiclesUrl = jsonData.getJsonData("VEHICLE_URL");
					String Vehicles = jsonData.getJsonData("VEHICLES");
					String urlVehicleDelete = base_url +"/"+VehiclesUrl+"/"+Vehicles+"/"+id;
					ExtentReport.info("The vehicle url is :"+urlVehicleDelete);
					DeleteServiceString =  Delete(urlVehicleDelete,token);
					break;
				case "user":
					String UsersUrl = jsonData.getJsonData("CLIENT_URL");
					String Users = jsonData.getJsonData("USERS");
					String urlUserDelete = base_url +"/"+UsersUrl+"/"+Users+"/"+id;
					ExtentReport.info("The User url is :"+urlUserDelete);
					DeleteServiceString =  Delete(urlUserDelete,token);
					break;
				case "chargingstation":
					String ChargingStationUrl = jsonData.getJsonData("ASSET_URL");
					String ChargingStation = jsonData.getJsonData("CHARGINGSTATIONS");
					String urlChargingStation = base_url +"/"+ChargingStationUrl+"/"+ChargingStation+"/"+id;
					ExtentReport.info("The Charging Station url is :"+urlChargingStation);
					DeleteServiceString = Delete(urlChargingStation,token);
					break;
				case "device":
					String DeviceUrl = jsonData.getJsonData("DEVICE_URL");
					String Devices = jsonData.getJsonData("DEVICES");
					String urlDeviceDelete = base_url +"/"+DeviceUrl+"/"+Devices+"/"+id;
					ExtentReport.info("The Device url is :"+urlDeviceDelete);
					DeleteServiceString =  Delete(urlDeviceDelete,token);
					break;
					
			}
			TestLogger.appInfo("The response after deleting the service  "+ servicename +" is "+DeleteServiceString.getBody().asString());
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while deleting the service "+servicename+" : "+e.getMessage());
		}
		return DeleteServiceString;
	}
	
	
	/*
	 * ****************************************************************************** 
	 * Name : CreateServices 
	 * Parameters : servicename(name of the service),payloadTemplate(Structure of the json payload),payloadValues(values of the JsonObject keys)
	 * Purpose : For Creating Specified Service
	 * ******************************************************************************
	*/
public Response CreateServices(String servicename,String payloadTemplate,String payloadValues) {
		Response CreateServiceString = null;
		String base_url = null;
		String token = null;
		
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		base_url = jsonData.getJsonData("BASE_URL");
		token = getAuthorizationToken(servicename);
		try {
			switch(servicename) {
			case "asset":
				String AssetsUrl = jsonData.getJsonData("ASSET_URL");
				String Assets = jsonData.getJsonData("ASSETS");
				String urlAsset = base_url +"/"+AssetsUrl+"/"+Assets;
				ExtentReport.info("The asset url is :"+urlAsset);
				CreateServiceString =  Post(urlAsset,token,servicename,payloadTemplate,payloadValues);
				break;
			case "user":
				String ClientUrl = jsonData.getJsonData("CLIENT_URL");
				String Users = jsonData.getJsonData("USERS");
				String urlUser = base_url +"/"+ClientUrl+"/"+Users+"/";
				ExtentReport.info("The Users url is :"+urlUser);
				CreateServiceString =  Post(urlUser,token,servicename,payloadTemplate,payloadValues);
				break;
			case "createservice":
				String CreateServiceUrl = jsonData.getJsonData("CREATESERVICE_URL");
				String InitiateService = jsonData.getJsonData("INITIATE_SERVICE");
				String urlInitiateService = base_url +"/"+CreateServiceUrl+"/"+InitiateService+"/";
				ExtentReport.info("The InitiateService url is :"+urlInitiateService);
				CreateServiceString =  Post(urlInitiateService,token,servicename,payloadTemplate,payloadValues);
				break;
			case "device":
				String DeviceUrl = jsonData.getJsonData("DEVICE_URL");
				String Devices = jsonData.getJsonData("DEVICES");
				String urlDevice = base_url +"/"+DeviceUrl+"/"+Devices+"/";
				ExtentReport.info("The Users url is :"+urlDevice);
				CreateServiceString =  Post(urlDevice,token,servicename,payloadTemplate,payloadValues);
			
				
		}
			TestLogger.appInfo("The Createservice response is  "+ servicename +" is "+CreateServiceString);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating CreateServices request for the service "+servicename+" : "+e.getMessage());
		}
		
		return CreateServiceString;
	}
	
	
		
	/*
	 * ****************************************************************************** 
	 * Name : CreateServices 
	 * Parameters : servicename(name of the service),payloadValues(values of the JsonObject keys)
	 * Purpose : For Creating Specified Service
	 * ******************************************************************************
	*/
	
	public Response CreateServices(String servicename,JSONObject payloadValues) {
		Response CreateServiceString = null;
		String base_url = null;
		String token = null;
		
		JsonReader.getJsonObject(EnvironmentManager.getEnvironmentFile());
		base_url = jsonData.getJsonData("BASE_URL");
		token = getAuthorizationToken(servicename);
		try {
			switch(servicename) {			
			
			case "device":
				String DeviceUrl = jsonData.getJsonData("DEVICE_URL");
				String Devices = jsonData.getJsonData("DEVICES");
				String urlDevice = base_url +"/"+DeviceUrl+"/"+Devices+"/";
				ExtentReport.info("The Users url is :"+urlDevice);
				CreateServiceString =  Post(urlDevice,token,servicename,payloadValues);
			case "user":
				String ClientUrl = jsonData.getJsonData("CLIENT_URL");
				String Users = jsonData.getJsonData("USERS");
				String urlUser = base_url +"/"+ClientUrl+"/"+Users+"/";
				ExtentReport.info("The Users url is :"+urlUser);
				CreateServiceString =  Post(urlUser,token,servicename,payloadValues);
				break;	
			case "createservice":
				String CreateServiceUrl = jsonData.getJsonData("CREATESERVICE_URL");
				String InitiateService = jsonData.getJsonData("INITIATE_SERVICE");
				String urlInitiateService = base_url +"/"+CreateServiceUrl+"/"+InitiateService+"/";
				
				ExtentReport.info("The InitiateService url is :"+urlInitiateService);
				CreateServiceString =  Post(urlInitiateService,token,servicename,payloadValues);
				break;
			case "createversion":
				String CreateversionUrl = jsonData.getJsonData("CREATESERVICE_URL");
				String InitiateServiceVer = jsonData.getJsonData("INITIATE_SERVICE");
				String ServiceName = (String)payloadValues.get("servicename");
				payloadValues.remove("servicename");				
				String urlInitiateServicever = base_url +"/"+CreateversionUrl+"/"+InitiateServiceVer+"/"+ServiceName+"/versions";
				ExtentReport.info("The InitiateService url is :"+urlInitiateServicever);
				CreateServiceString =  Post(urlInitiateServicever,token,servicename,payloadValues);
				break;
			case "asset":
				String AssetsUrl = jsonData.getJsonData("ASSET_URL");
				String Assets = jsonData.getJsonData("ASSETS");
				String urlAsset = base_url +"/"+AssetsUrl+"/"+Assets;
				ExtentReport.info("The asset url is :"+urlAsset);
				CreateServiceString =  Post(urlAsset,token,servicename,payloadValues);
				break;
			case "vehicle":
				String VehicleUrl = jsonData.getJsonData("VEHICLE_URL");
				String Vehicles = jsonData.getJsonData("VEHICLES");
				String urlVehicle = base_url +"/"+VehicleUrl+"/"+Vehicles;
				ExtentReport.info("The vehicles url is :"+urlVehicle);
				CreateServiceString =  Post(urlVehicle,token,servicename,payloadValues);
				break;
			case "chargingstation":
				String ChargingStationsUrl = jsonData.getJsonData("ASSET_URL");
				String ChargingStations = jsonData.getJsonData("CHARGINGSTATIONS");
				String urlChargingStations = base_url +"/"+ChargingStationsUrl+"/"+ChargingStations;
				ExtentReport.info("The Charging Station url is :"+urlChargingStations);
				CreateServiceString =  Post(urlChargingStations,token,servicename,payloadValues);
			
			
				
		}
			TestLogger.appInfo("The Createservice response is  "+ servicename +" is "+CreateServiceString);
		}catch(Exception e) {
			TestLogger.errorMessage("An exception has occured while generating CreateServices request for the service "+servicename+" : "+e.getMessage());
		}
		
		return CreateServiceString;
	}
	

	/*
	 * ****************************************************************************** 
	 * Name : CreateUser 
	 * Parameters : payLoad(JsonObject Payload)	 * 
	 * Purpose : For Creating User
	 * ******************************************************************************
	*/
	 public String CreateUser(String payLoad) {
		
		Response userCreated = null;
		String createUserID = null;	
		JSONObject CreateUserJson = null;
		
		try {
			CreateUserJson = JsonReader.getJsonObject(payLoad);			
			String displayName = CreateUserJson.get("displayName").toString() + RestApiUtility.getRandomNumber();
			CreateUserJson.put("displayName",displayName);
			ExtentReport.info("Created UserData payload is "+CreateUserJson.toJSONString());			
			userCreated = CreateServices("user",CreateUserJson);				
			if( userCreated!=null && userCreated.getStatusCode()==200) {
				ExtentReport.info("The created User response status code is : "+userCreated.getStatusCode());
				ExtentReport.info("The created User response is : "+userCreated.getBody().asString());
				createUserID = userCreated.getBody().asString();	
				ExtentReport.info("The created User id is : "+createUserID);
			}
			else {
				ExtentReport.info("An exception has occured while Creating User payload: "+userCreated.getStatusCode());
			}
		}catch(Exception e) {
			
		}
		
		
		return createUserID;
	}

	/*
	 * ****************************************************************************** 
	 * Name : CreateAssets 
	 * Parameters : payLoad(JsonObject Payload)	 * 
	 * Purpose : For Creating Asset
	 * ******************************************************************************
	*/
	 public String CreateAssets(String payLoad) {
		
		JSONObject CreateAssetJson = null;
		String AssetId = null;
		Response AssetResponse = null;
		
		try {
			CreateAssetJson = JsonReader.getJsonObject(payLoad);			
			CreateAssetJson.put("name",CreateAssetJson.get("name").toString() + getRandomNumber());
			CreateAssetJson.put("description",CreateAssetJson.get("description").toString() + getRandomNumber());	
			
			ExtentReport.info("Creating asset with:"+CreateAssetJson.toJSONString());
			AssetResponse = CreateServices("asset",CreateAssetJson);	
			
			if( AssetResponse!=null && AssetResponse.getStatusCode()==200) {
				ExtentReport.info("The created Asset response status code is : "+AssetResponse.getStatusCode());
				AssetId = AssetResponse.getBody().asString();	
				ExtentReport.info("The created Asset id is : "+AssetId);
			}
			else {
				ExtentReport.info("The created Asset response status code is : "+AssetResponse.getStatusCode());
				
			}
			
		
		}catch(Exception e) {
			ExtentReport.info("An exception has occured while Creating Asset payload: "+payLoad);
			AssetId = null;
		}		
		
		return AssetId;
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : CreateChargingStation 
	 * Parameters : payLoad(JsonObject Payload)	 * 
	 * Purpose : For Creating Charging Station
	 * ******************************************************************************
	*/
	public String CreateChargingStation(String payLoad) {
		
		JSONObject CreateChargingStationJson = null;
		String ChargingStationId = null;
		Response ChargingStationResponse = null;
		
		try {
			CreateChargingStationJson = JsonReader.getJsonObject(payLoad);			
			CreateChargingStationJson.put("name",CreateChargingStationJson.get("name").toString() + getRandomNumber());
			
			ExtentReport.info("Executing Post Request against ChargingStation using payload : "+CreateChargingStationJson.toJSONString());
			//ExtentReport.info("Created ChargingStationData payload is "+CreateChargingStationJson.toJSONString());
			ChargingStationResponse = CreateServices("chargingstation",CreateChargingStationJson);	
			
			if( ChargingStationResponse!=null && ChargingStationResponse.getStatusCode()==200) {
				ExtentReport.info("The created ChargingStation response status code is : "+ChargingStationResponse.getStatusCode());
				ExtentReport.info("The created ChargingStation response is : "+ChargingStationResponse.getBody().asString());
				ChargingStationId = ChargingStationResponse.getBody().asString();	
				ExtentReport.info("The created ChargingStation id is : "+ChargingStationId);
			}
			else {
				ExtentReport.info("The created Charging station response status code is : "+ChargingStationResponse.getStatusCode());
			}
			
		
		}catch(Exception e) {
			ExtentReport.info("An exception has occured while Creating ChargingStation payload: "+payLoad);
			ChargingStationId = null;
		}		
		
		return ChargingStationId;
	}

	/*
	 * ****************************************************************************** 
	 * Name : CreateVehicle 
	 * Parameters : payLoad(JsonObject Payload)	
	 * Purpose : For Creating Vehicle
	 * ******************************************************************************
	*/
	public String CreateVehicle(String payLoad) {
		JSONObject CreateVehicleJson = null;
		String vehicleId = null;
		Response VehicleResponse = null;
		
		try {
			CreateVehicleJson = JsonReader.getJsonObject(payLoad);			
			CreateVehicleJson.put("name",CreateVehicleJson.get("name").toString() + getRandomNumber());
			CreateVehicleJson.put("description",CreateVehicleJson.get("description").toString() + getRandomNumber());
			CreateVehicleJson.put("licensePlate",CreateVehicleJson.get("licensePlate").toString() + getRandomNumber());
			CreateVehicleJson.put("vin",CreateVehicleJson.get("vin").toString() + getRandomNumber(10,100));
			
			ExtentReport.info("Executing Post Request against Vehicle using payload : "+CreateVehicleJson.toJSONString());
			
			//ExtentReport.info("Created VehicleData payload is "+CreateVehicleJson.toJSONString());
			VehicleResponse = CreateServices("vehicle",CreateVehicleJson);	
			
			if( VehicleResponse!=null && VehicleResponse.getStatusCode()==200) {
				ExtentReport.info("The created vehicle response status code is : "+VehicleResponse.getStatusCode());
				ExtentReport.info("The created vehicle response is : "+VehicleResponse.getBody().asString());
				vehicleId = VehicleResponse.getBody().asString();	
				ExtentReport.info("The created vehicle id is : "+vehicleId);
			}
			else {
				ExtentReport.info("The created vehicle response status code is : "+VehicleResponse.getStatusCode());
			}
			
		
		}catch(Exception e) {
			ExtentReport.info("An exception has occured while Creating vehicle payload: "+payLoad);
			vehicleId = null;
		}		
		
		return vehicleId;
	}

	/*
	 * ****************************************************************************** 
	 * Name : GetUser 
	 * Parameters : createUserID(id of the user)	 * 
	 * Purpose : For retrieving the specific user
	 * ******************************************************************************
	*/
	public String GetUser(String createUserID) {
		Response userJson = null;			
		String userId = null;
				
		try {
			userId = (String)JsonReader.getJsonObject(createUserID).get("id");
		}catch(Exception e) {
			//ExtentReport.info(createUserID +" dictionary is not found in the data file hence using it as user Id string ");
			userId = createUserID;
		}		
		userJson = GetServices("user",userId);
		if(userJson.getStatusCode()==200) {
			ExtentReport.info("User with UserId "+userId +" is present in the available Users");
			ExtentReport.info("User with UserId "+userId +" is present in the available Users and its response body is : "+ userJson.getBody().asString());			
			return userJson.getBody().asString();
		}else {
			ExtentReport.info("User with UserId "+userId +" is not present in the available Users");
			return null;
		}
		
	}
	
	/*
	 * ****************************************************************************** 
	 * Name : GetAsset 
	 * Parameters : createAssetID(id of the Asset)	 * 
	 * Purpose : For retrieving the specific Asset
	 * ******************************************************************************
	*/
	public String GetAsset(String createAssetID) {
		Response assetJson = null;			
		String assetId = null;
		String assetResponse = null;
				
		try {
			assetId = (String)JsonReader.getJsonObject(createAssetID).get("id");
		}catch(Exception e) {
			assetId = createAssetID;
		}	
		ExtentReport.info("Getting Asset details using assetId : "+assetId);
		
		try {
			assetJson = GetServices("asset",assetId);
			if(assetJson.getStatusCode()==200) {
				assetResponse = assetJson.getBody().asString();
				ExtentReport.info("AssetId : "+assetId +" is present in the available Assets");
			}else {
				ExtentReport.info("Asset with AssetId "+assetId +" is not present in the available Assets and the response message is : "+assetJson.getBody().jsonPath().getString("message"));
				assetResponse = null;
			}	
		}catch(Exception e) {
			ExtentReport.info("An execption has generated while working with getAsset and the message is : "+e.getMessage());
		}
		return assetResponse;		
	}
	
	
	/*
	 * ****************************************************************************** 
	 * Name : GetVehicle 
	 * Parameters : createVehicleID(id of the vehicle)	 * 
	 * Purpose : For retrieving the specific Vehicle
	 * ******************************************************************************
	*/
	public String GetVehicle(String createVehicleID) {
		Response vehicleJson = null;			
		String vehicleId = null;
		String vehicleResponse = null;
				
		try {
			vehicleId = (String)JsonReader.getJsonObject(createVehicleID).get("id");
		}catch(Exception e) {
			//ExtentReport.info(createVehicleID +" dictionary is not found in the data file hence using it as Vehicle Id string ");
			vehicleId = createVehicleID;
		}	
		ExtentReport.info("Executing Get Request against Vehicle using vehicleId : "+vehicleId);
		try {
			vehicleJson = GetServices("vehicle",vehicleId);
			if(vehicleJson.getStatusCode()==200) {
				ExtentReport.info("Vehicle with vehicleId "+vehicleId +" is present in the available Vehicles");
				ExtentReport.info("Vehicle with vehicleId "+vehicleId +" is present in the available Vehicles and its response body is : "+ vehicleJson.getBody().asString());			
				vehicleResponse = vehicleJson.getBody().asString();
			}else {
				ExtentReport.info("Vehicle with vehicleId "+vehicleId +" is not present in the available Vehicles");
				vehicleResponse = null;
			}	
		}catch(Exception e) {
			ExtentReport.info("An execption has generated while working with getvehicle and the message is : "+e.getMessage());
		}
		return vehicleResponse;
		
	}
	
	
	/*
	 * ****************************************************************************** 
	 * Name : GetChargingStation 
	 * Parameters : createChargingStationID(id of the Charging Station)	 * 
	 * Purpose : For retrieving the specific Charging Station
	 * ******************************************************************************
	*/
	 public String GetChargingStation(String createChargingStationID) {
		Response ChargingStationJson = null;			
		String ChargingStationId = null;
		String ChargingStationResponse = null;
				
		try {
			ChargingStationId = (String)JsonReader.getJsonObject(createChargingStationID).get("id");
		}catch(Exception e) {
			//ExtentReport.info(ChargingStationId +" dictionary is not found in the data file hence using it as ChargingStation Id string ");
			ChargingStationId = createChargingStationID;
		}	
		
		ExtentReport.info("Executing Get Request against ChargingStation using chargingStationId : "+ChargingStationId);
		
		try {
			ChargingStationJson = GetServices("chargingstation",ChargingStationId);
			if(ChargingStationJson.getStatusCode()==200) {
				ExtentReport.info("Charging Station with ChargingStationId "+ChargingStationId +" is present in the available Charging Stations");
				ExtentReport.info("Charging Station with ChargingStationId "+ChargingStationId +" is present in the available Charging Stations and its response body is : "+ ChargingStationJson.getBody().asString());			
				ChargingStationResponse = ChargingStationJson.getBody().asString();
			}else {
				ExtentReport.info("Charging Station with ChargingStationId "+ChargingStationId +" is not present in the available Charging Stations");
				ChargingStationResponse = null;
			}	
		}catch(Exception e) {
			ExtentReport.info("An execption has generated while working with getChargingStation and the message is : "+e.getMessage());
		}
		return ChargingStationResponse;		
	}
	
	
	/*
	 * ****************************************************************************** 
	 * Name : DeleteAsset 
	 * Parameters : createAssetID(id of the Asset)	 * 
	 * Purpose : For deleting the specific Asset using Asset Id
	 * ******************************************************************************
	*/
	public boolean DeleteAsset(String createAssetID) {
		
		Response deleteAssetResponse = null;		
		boolean result = false;
		String assetId = null;
		
		try {
			assetId = (String)JsonReader.getJsonObject(createAssetID).get("id");
		}catch(Exception e) {
			//ExtentReport.info(createAssetID +" dictionary is not found in the data file hence using it as asset Id string ");
			assetId = createAssetID;
		}
		
		ExtentReport.info("Deleting the Asset using assetId : "+assetId);
		
		try {
			deleteAssetResponse = DeleteServices("asset",assetId);
			
			if( deleteAssetResponse!=null && deleteAssetResponse.getStatusCode()==200) {
				ExtentReport.info("The deleteted Asset id "+assetId+" status code is "+deleteAssetResponse.getStatusCode());
				ExtentReport.info("The Asset id "+assetId+" is deleted successfully");
				result = true;
			}
			else {
				ExtentReport.info("The deleteted Asset "+assetId+" status code is "+deleteAssetResponse.getStatusCode());
				ExtentReport.info("The deleteted Asset "+assetId+" status code is "+deleteAssetResponse.getBody().jsonPath().getString("message"));
				ExtentReport.info("The Asset id "+assetId+" is not deleted successfully");
				result = false;
			}
		}catch(Exception e) {
			ExtentReport.info("An execption has generated while working with deleteAsset and the message is : "+e.getMessage());
		}
		
		return result;
	}

	/*
	 * ****************************************************************************** 
	 * Name : DeleteVehicle 
	 * Parameters : createVehicleID(id of the vehicle)	 * 
	 * Purpose : For deleting the specific Vehicle using vehicle Id
	 * ******************************************************************************
	*/
	public boolean DeleteVehicle(String createVehicleID) {
		
		Response deleteVehicleResponse = null;		
		boolean result = false;
		String vehicleId = null;
		
		try {
			vehicleId = (String)JsonReader.getJsonObject(createVehicleID).get("id");
		}catch(Exception e) {
			//ExtentReport.info(vehicleId +" dictionary is not found in the data file hence using it as vehicle Id string ");
			vehicleId = createVehicleID;
		}
		
		ExtentReport.info("Executing Delete Request against vehicle using vehicleId : "+vehicleId);
		
		try {
			deleteVehicleResponse = DeleteServices("vehicle",vehicleId);
			
			if( deleteVehicleResponse!=null && deleteVehicleResponse.getStatusCode()==204) {
				ExtentReport.info("The deleteted Vehicle id "+vehicleId+" status code is "+deleteVehicleResponse.getStatusCode());
				ExtentReport.info("The deleteted Vehicle id "+vehicleId+" response is "+deleteVehicleResponse.getBody().asString());
				ExtentReport.info("The Vehicle id "+vehicleId+" is deleted successfully");
				result = true;
			}
			else {
				ExtentReport.info("The deleteted vehicle "+vehicleId+" status code is "+deleteVehicleResponse.getStatusCode());
				ExtentReport.info("The Vehicle id "+vehicleId+" is not deleted successfully");
				result = false;
			}
		}catch(Exception e) {
			ExtentReport.info("An execption has generated while working with deleteVehicle and the message is : "+e.getMessage());
		}
		
		return result;
	}

	/*
	 * ****************************************************************************** 
	 * Name : DeleteChargingStation 
	 * Parameters : createChargingStationID(id of the ChargingStation)	 * 
	 * Purpose : For deleting the specific Charging Station using ChargingStation Id
	 * ******************************************************************************
	*/
	public boolean DeleteChargingStation(String createChargingStationID) {
		
		Response deleteChargingStationResponse = null;		
		boolean result = false;
		String ChargingStationId = null;
		
		try {
			ChargingStationId = (String)JsonReader.getJsonObject(createChargingStationID).get("id");
		}catch(Exception e) {
			//ExtentReport.info(createChargingStationID +" dictionary is not found in the data file hence using it as ChargingStation Id string ");
			ChargingStationId = createChargingStationID;
		}
		
		ExtentReport.info("Executing Delete Request against ChargingStation using ChargingStationId : "+ChargingStationId);
		
		try {
			deleteChargingStationResponse = DeleteServices("chargingstation",ChargingStationId);
			
			if( deleteChargingStationResponse!=null && deleteChargingStationResponse.getStatusCode()==204) {
				ExtentReport.info("The deleteted ChargingStation id "+ChargingStationId+" status code is "+deleteChargingStationResponse.getStatusCode());
				ExtentReport.info("The deleteted ChargingStation id "+ChargingStationId+" response is "+deleteChargingStationResponse.getBody().asString());
				ExtentReport.info("The ChargingStation id "+ChargingStationId+" is deleted successfully");
				result = true;
			}
			else {
				ExtentReport.info("The deleteted ChargingStation "+ChargingStationId+" status code is "+deleteChargingStationResponse.getStatusCode());
				ExtentReport.info("The deleteted ChargingStation "+ChargingStationId+" status code is "+deleteChargingStationResponse.getBody().jsonPath().getString("message"));
				ExtentReport.info("The ChargingStation id "+ChargingStationId+" is not deleted successfully");
				result = false;
			}
		}catch(Exception e) {
			ExtentReport.info("An execption has generated while working with deleteChargingStation and the message is : "+e.getMessage());
		}
		return result;
	}

	
	/*
	 * ****************************************************************************** 
	 * Name : DeleteUser 
	 * Parameters : createUserID(id of the User)	 
	 * Purpose : For deleting the specific user using User Id
	 * ******************************************************************************
	*/
	public boolean DeleteUser(String createUserID) {
		
		Response deleteUserResponse = null;		
		boolean result = false;
		String userId = null;
		
		try {
			userId = (String)JsonReader.getJsonObject(createUserID).get("id");
		}catch(Exception e) {
			//ExtentReport.info(createUserID +" dictionary is not found in the data file hence using it as user Id string ");
			userId = createUserID;
		}
		
		ExtentReport.info("Executing Delete Request against User using userId : "+userId);
		
		deleteUserResponse = DeleteServices("user",userId);
		
		if( deleteUserResponse!=null && deleteUserResponse.getStatusCode()==204) {
			ExtentReport.info("The deleteted user id "+userId+" status code is "+deleteUserResponse.getStatusCode());
			ExtentReport.info("The deleteted user id "+userId+" response is "+deleteUserResponse.getBody().asString());
			ExtentReport.info("The user with userid "+userId+" is deleted successfully");
			result = true;
		}
		else {
			ExtentReport.info("The deleteted user "+userId+" status code is "+deleteUserResponse.getStatusCode());
			ExtentReport.info("The deleteted user "+userId+" status code is "+deleteUserResponse.getBody().jsonPath().getString("message"));
			ExtentReport.info("The user with userid "+userId+" is not deleted successfully");
			result = false;
		}
		
		return result;
	}
	
	
}
