package zf.pages;

import org.openqa.selenium.By;
import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class ZFAddMultipleGatewayPage extends ElementManager {

	JsonReader jsonData=new JsonReader();
	ZFGatewayHomePage zfgatewayhomepage=new ZFGatewayHomePage();

	private static  By ADDMULTIPLEGATEWAY_RB						        =By.xpath("(//div[contains(@class,'ui-radiobutton-box ui-widget ui-state-default')])[2]");
	private static  By ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_TXT 	            =By.xpath("//span[text()='ENROLLMENT GROUP']");
	private static  By ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_TXT        =By.xpath("//div[@class='input-content-wrapper hw fl ng-star-inserted']");
	private static  By ADDMULTIPLEGATEWAY_UPLOAD_CA_TXT                     =By.xpath("//span[@class='upload-span']");
	private static  By ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_TXT        =By.xpath("//div[@class='fr gateway-details-file']");
	private static  By ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_NEW_RB 	        =By.xpath("(//div[@class='radio-wrapper']//span[contains(@class,'ui-radiobutton-icon ui-clickable')])[1]");
	private static  By ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_EXISTING_RB       =By.xpath("(//div[@class='radio-wrapper']//span[contains(@class,'ui-radiobutton-icon ui-clickable')])[2]");
	private static  By ADDMULTIPLEGATEWAY_UPLOAD_CA_ROOT_RB                 =By.xpath("//p-radiobutton[@label='Root']//div[contains(@class,'ui-radiobutton-box ui-widget ui-state-default')]");
	private static  By ADDMULTIPLEGATEWAY_UPLOAD_CA_INTERMEDIATE_RB         =By.xpath("//p-radiobutton[@label='Intermediate']//div[contains(@class,'ui-radiobutton-box ui-widget ui-state-default')]");
	private static  By ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_EB         =By.xpath("//input[@class='fw ng-untouched ng-pristine ng-invalid']");
	private static  By ADDMULTIPLEGATEWAY_UPLOADCA_ROOT_CERTIFICATE_BT      =By.xpath("//div[@class='fr upload-icon sprite'][1]");
	private static  By ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_BT         =By.xpath("//input[@accept='.xls, .xlsx']");
	private static  By ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_BT                 =By.xpath("//button[@class='zf-button upload-btn fr']");
	private static  By ADDMULTIPLEGATEWAY_SUBMIT_BT					        =By.xpath("//button[@class='zf-button next fr primary ng-star-inserted']");
	private static  By ADDMULTIPLEGATWAY_TOASTER_DT					        =By.xpath("//div[@class='toast-title']");
	private static  By ADDMULTIPLEGATEWAY_CA_FILENAME_TXT			     	=By.xpath("//div[@class='cert-name fl']");
	private static  By ADDMULTIPLEGATEWAY_SELECT_ENROLLMENTGROUP_DD         =By.xpath("//span[@class='ui-dropdown-trigger-icon ui-clickable fa fa-chevron-down']");
	private static  By ADDMULTIPLEGATEWAY_DOWNLOAD_TEMPLATE_BT              =By.xpath("//button[text()='Download Template']");
	private static  By ADDMULTIPLEGATEWAY_SELECT_ENROLLMENTGROUP_TXT        =By.xpath("//label[text()='Select Enrollment Group']");
	private static String ADDMULTIPLEGATEWAY_SELECT_ENROLLGROUP_LIST	    ="//span[text()='{}']";

	public void validatUserInterface() {
		try {
			zfgatewayhomepage.clickAddGateway();
			waitElementVisibleClick(ADDMULTIPLEGATEWAY_RB,500);
			elementAvailability(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_TXT);
			elementAvailability(ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_TXT);
			elementAvailability(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_NEW_RB);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_CA_TXT);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_TXT);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_CA_ROOT_RB);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_CA_INTERMEDIATE_RB );
			elementAvailability(ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_EB);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOADCA_ROOT_CERTIFICATE_BT);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_BT);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_BT );
			elementAvailability(ADDMULTIPLEGATEWAY_DOWNLOAD_TEMPLATE_BT );
			elementAvailability(ADDMULTIPLEGATEWAY_SUBMIT_BT );
			elementClickRadioButton(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_EXISTING_RB);
			elementAvailability(ADDMULTIPLEGATEWAY_SELECT_ENROLLMENTGROUP_DD );
			elementAvailability(ADDMULTIPLEGATEWAY_SELECT_ENROLLMENTGROUP_TXT );

		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}}

	public void validateLookAndFeelMultipleGateway() {
		try {
			zfgatewayhomepage.clickAddGateway();
			waitElementVisibleClick(ADDMULTIPLEGATEWAY_RB,500);
			elementAvailability(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_TXT);
			elementAvailability(ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_TXT);
			elementAvailability(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_NEW_RB);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_CA_TXT);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_TXT);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_CA_ROOT_RB);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_CA_INTERMEDIATE_RB );
			elementAvailability(ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_EB);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOADCA_ROOT_CERTIFICATE_BT);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_BT);
			elementAvailability(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_BT );
			elementAvailability(ADDMULTIPLEGATEWAY_DOWNLOAD_TEMPLATE_BT );
			elementAvailability(ADDMULTIPLEGATEWAY_SUBMIT_BT );
			elementClickRadioButton(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_EXISTING_RB);
			elementAvailability(ADDMULTIPLEGATEWAY_SELECT_ENROLLMENTGROUP_DD );
			elementAvailability(ADDMULTIPLEGATEWAY_SELECT_ENROLLMENTGROUP_TXT );

		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}}
	public void addMultipleGatewayNewRoot() {
		try {
			zfgatewayhomepage.clickAddGateway();
			elementClickRadioButton(ADDMULTIPLEGATEWAY_RB);
			JsonReader.getJsonObject("AddMultipleGatewayNewRoot");
			elementClickRadioButton(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_NEW_RB);
			elementSendKeys(ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_EB,jsonData.getJsonData("CreateEnrollmentGroup"));
			elementClickRadioButton(ADDMULTIPLEGATEWAY_UPLOAD_CA_ROOT_RB);
			elementClick(ADDMULTIPLEGATEWAY_UPLOADCA_ROOT_CERTIFICATE_BT);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadCA"));
			waitElementVisibleClick(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_BT,100);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadGatewayDeatils"));
			waitElementEnabledClick(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_BT,300);
			verifyToastermessage("ToasterMessageSuccess");
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}


	public void addMultipleGatewayWithInvalid() {
		try {
			JsonReader.getJsonObject("AddMultipleGatewayWithInvalid");
			zfgatewayhomepage.clickAddGateway();
			sleep(3000);
			elementClickRadioButton(ADDMULTIPLEGATEWAY_RB);
			elementClickRadioButton(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_NEW_RB);
			elementSendKeys(ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_EB,jsonData.getJsonData("CreateEnrollmentGroup"));
			elementClickRadioButton(ADDMULTIPLEGATEWAY_UPLOAD_CA_ROOT_RB);
			elementClick(ADDMULTIPLEGATEWAY_UPLOADCA_ROOT_CERTIFICATE_BT);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadCA"));
			waitElementVisibleClick(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_BT,100);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadGatewayDeatils"));
			waitElementEnabledClick(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_BT,300);

			verifyToastermessage("ToasterMessageFailed");
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void addMultipleGatewayNewIntermediate() {
		try {
			JsonReader.getJsonObject("AddMultipleGatewayNewIntermediate");
			zfgatewayhomepage.clickAddGateway();
			elementClickRadioButton(ADDMULTIPLEGATEWAY_RB);
			elementClickRadioButton(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_NEW_RB);
			elementSendKeys(ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_EB,jsonData.getJsonData("CreateEnrollmentGroup"));
			elementClickRadioButton(ADDMULTIPLEGATEWAY_UPLOAD_CA_INTERMEDIATE_RB);
			elementClick(ADDMULTIPLEGATEWAY_UPLOADCA_ROOT_CERTIFICATE_BT);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadCA"));
			elementClick(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_BT);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadGatewayDeatils"));
			waitElementVisibleClick(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_BT,100);
			verifyToastermessage("ToasterMessageSuccess");
			waitElementEnabledClick(ADDMULTIPLEGATEWAY_SUBMIT_BT,300);
			
			verifyToastermessage("ToasterMessageSuccess");
		}catch(Exception e) {

		}
	}

	public void addMultipleGatewayExisting() {

		try {
			JsonReader.getJsonObject("AddMultipleGatewayExisting");
			zfgatewayhomepage.clickAddGateway();
			elementClickRadioButton(ADDMULTIPLEGATEWAY_RB);
			elementClickRadioButton(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_EXISTING_RB);
			elementClick(ADDMULTIPLEGATEWAY_SELECT_ENROLLMENTGROUP_DD);
			elementClick(By.xpath(dynamicXpath(ADDMULTIPLEGATEWAY_SELECT_ENROLLGROUP_LIST,"SelectEnrollmentGroup")));
			if(compareValue(elementGetText(ADDMULTIPLEGATEWAY_CA_FILENAME_TXT),jsonData.getJsonData("CAfilename"))){
				elementClick(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_BT);
				uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadGatewayDetails"));
				waitElementVisibleClick(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_BT,100);
				verifyToastermessage("ToasterMessageSuccess");
				waitElementEnabledClick(ADDMULTIPLEGATEWAY_SUBMIT_BT,300);
				verifyToastermessage("ToasterMessageSuccess");

			}else {
				testFailed("CA file name get from webpage is not same as given"+jsonData.getJsonData("CAfilename"));
			}

		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}




	public void addMultipleGatewayWithoutMandatoryFields() {

		try {
			JsonReader.getJsonObject("addMultipleGatewayWithoutMandatoryFields");
			zfgatewayhomepage.clickAddGateway();
			waitElementVisibleClick(ADDMULTIPLEGATEWAY_RB,300);
			elementClickRadioButton(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_NEW_RB);

			addMultipleGatewayWithoutGatewayDetails();
			addMultipleGatewayWithoutCertificate();
			addMultipleGatewayWithoutEnrollmentGroupName();

		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void addMultipleGatewayWithoutGatewayDetails() {

		try {					
			elementSendKeys(ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_EB,jsonData.getJsonData("CreateEnrollmentGroup"));
			elementClick(ADDMULTIPLEGATEWAY_UPLOADCA_ROOT_CERTIFICATE_BT);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadCA"));
			submitButtonVisibility("when certificate and Group is added without gateway details");

		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void addMultipleGatewayWithoutEnrollmentGroupName() {

		try {
			refreashPage();
			waitElementVisibleClick(ADDMULTIPLEGATEWAY_RB,500);
			elementClickRadioButton(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_NEW_RB);

			elementClear(ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_EB);
			elementClick(ADDMULTIPLEGATEWAY_UPLOADCA_ROOT_CERTIFICATE_BT);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadCA"));
			elementClick(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_BT);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadGatewayDeatils"));
			submitButtonVisibility("when Gateway details and Group is added without certificate");

		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void addMultipleGatewayWithoutCertificate() {

		try {
			refreashPage();

			waitElementVisibleClick(ADDMULTIPLEGATEWAY_RB,500);
			elementClickRadioButton(ADDMULTIPLEGATEWAY_ENROLLMENTGROUP_NEW_RB);

			waitElementToBeVisibleSendValue(ADDMULTIPLEGATEWAY_CREATE_ENROLLMENTGROUP_EB,300,jsonData.getJsonData("CreateEnrollmentGroup"));

			elementClick(ADDMULTIPLEGATEWAY_UPLOAD_GATEWAY_DETAILS_BT);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadGatewayDeatils"));
			submitButtonVisibility("when Gateway details and certificate are added without Group name");

		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void submitButtonVisibility(String message) {
		try {

			if(elementGetValue(ADDMULTIPLEGATEWAY_SUBMIT_BT,"disabled")!=null) {
				testPassed("SUBMIT button is disabled "+message);

			}
			else {
				testFailed("Message failed");
			}
		}
		catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}


	public	String dynamicXpath(String xpath, String Jsonvalue) {
		return updateXpath(xpath,jsonData.getJsonData(Jsonvalue));
	}

	public void verifyToastermessage(String Jsondata) {
		try {

			String toasterText = waitElementVisibleGetText(ADDMULTIPLEGATWAY_TOASTER_DT,200);
			compareText(jsonData.getJsonData(Jsondata),toasterText);
		}
		catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

}
