package zf.pages;

import java.util.Random;

import org.openqa.selenium.By;
import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class ZFAddSingleGatewayPage extends ElementManager{
	JsonReader jsonData=new JsonReader();
	ZFGatewayHomePage zfgatewayhomepage=new ZFGatewayHomePage();

	private static  By SINGLEGATEWAY_RB										=By.xpath("(//div[contains(@class,'ui-radiobutton-box ui-widget ui-state-default')])[1]");
	private static  By ADDSINGLEGATEWAY_GATEWAYNAME_EB						=By.xpath("//input[@name='gatewayName']");
	private static  By ADDSINGLEGATEWAY_TYPE_DD								=By.xpath("//p-dropdown[@optionlabel='gatewayType']");
	private static  By ADDSINGLEGATEWAY_MODEL_DD							=By.xpath("//p-dropdown[@optionlabel='gatewayModel']");
	private static  By ADDSINGLEGATEWAY_MACID_EB							=By.xpath("//input[@name='gatewayMacId']");
	private static  By ADDSINGLEGATEWAYSERIALNUMBER_EB						=By.xpath("//input[@name='gatewaysNo']");
	private static  By ADDSINGLEGATEWAY_SIMNUMBER_EB						=By.xpath("//input[@name='gatewaysimNo']");
	private static  By ADDSINGLEGATEWAY_UPLOADGATEWAYCERTIFICATE			=By.id("file-input");
	private static  By ADDSINGLEGATEWAY_NEXT_BT								=By.xpath("//button[@class='zf-button next fr primary ng-star-inserted' and text()='Next']");
	private static  By ADDSINGLEGATEWAY_CUSTOMERNAME_EB						=By.xpath("//input[@name='customer']");
	private static  By ADDSINGLEGATEWAY_CUSTOMERCOUNTRY_DD					=By.xpath("//p-dropdown[@name='selectCountry']");
	private static  By ADDSINGLEGATEWAY_CUSTOMERAREA_DD						=By.xpath("//p-dropdown[@name='selectedCity']");
	private static  By ADDSINGLEGATEWAY_BUSINESSUNIT_EB						=By.xpath("//input[@name='businessLine']");
	private static  By ADDSINGLEGATEWAY_OPERATOR_EB							=By.xpath("//input[@name='operator']");
	private static  By ADDSINGLEGATEWAY_CUSTOMERDETAIL_NEXT_BT				=By.xpath("//button[@class='zf-button next fr primary' and text()='Next']");
	private static  By ADDSINGLEGATEWAY_ADDITIONALDETAIL_DESCRIPTION_EB		=By.xpath("//textarea[@name='description']");
	private static  By ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_ICON		=By.xpath("//div[@class='add-icon']");
	private static  By ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_KEY_EB    =By.xpath("//table[@class='meta-wh meta-data-table']//tr[@class='ng-star-inserted']/td[1]");
	private static  By ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_VALUE_EB  =By.xpath("//table[@class='meta-wh meta-data-table']//tr[@class='ng-star-inserted']/td[2]");
	private static  By ADDSINGLEGATEWAY_ADDITIONALDETAIL_FINISH_BT			=By.xpath("//button[text()='Finish']");
	private static  By ADDSINGLEGATEWAY_TOASTER_MSG							=By.xpath("//div[@class='toast-title']");
	private static  By ADDSINGLEGATEWAY_TOASTER_MSG_TXT						=By.xpath("//div[@class='ng-star-inserted']");
	private static String TYPEDROPDOWNLIST									="//span[text()='{}']";


	
	public void addSingleGatewayWithAllValidInputs() {

		try {
			sleep(2000);
			zfgatewayhomepage.clickAddGateway();
			JsonReader.getJsonObject("addSingleGatewayWithAllValidInputs");
			elementClickRadioButton(SINGLEGATEWAY_RB);
			elementSendKeys(ADDSINGLEGATEWAY_GATEWAYNAME_EB,jsonData.getJsonData("GatewayName"));
			waitElementVisibleClick(ADDSINGLEGATEWAY_TYPE_DD,500);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"GatewayType")));
			elementClick(ADDSINGLEGATEWAY_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"Model")));
			elementSendKeys(ADDSINGLEGATEWAY_MACID_EB,jsonData.getJsonData("MACID")+generateRandomNumber());
			elementSendKeys(ADDSINGLEGATEWAYSERIALNUMBER_EB,jsonData.getJsonData("SerialNumber")+generateRandomNumber());
			elementSendKeys(ADDSINGLEGATEWAY_SIMNUMBER_EB,jsonData.getJsonData("SIMNumber"));
			elementClick(ADDSINGLEGATEWAY_UPLOADGATEWAYCERTIFICATE);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadCertificate"));
			elementClick(ADDSINGLEGATEWAY_NEXT_BT);

			//Enter Client Details
			elementSendKeys(ADDSINGLEGATEWAY_CUSTOMERNAME_EB,jsonData.getJsonData("CustomerName"));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERCOUNTRY_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"CustomerCountry")));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERAREA_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"CustomerArea")));
			elementSendKeys(ADDSINGLEGATEWAY_BUSINESSUNIT_EB,jsonData.getJsonData("BusinessUnit"));
			elementSendKeys(ADDSINGLEGATEWAY_OPERATOR_EB,jsonData.getJsonData("Operator"));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERDETAIL_NEXT_BT);

			//Additional
			elementSendKeyWithActions(ADDSINGLEGATEWAY_ADDITIONALDETAIL_DESCRIPTION_EB,jsonData.getJsonData("Description"));
			elementClick(ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_ICON);
			elementSendKeyWithActions(ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_KEY_EB,jsonData.getJsonData("MetaDatakey"));
			elementSendKeyWithActions(ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_VALUE_EB,jsonData.getJsonData("MetaDatavalue"));
			elementClick(ADDSINGLEGATEWAY_ADDITIONALDETAIL_FINISH_BT);
			verifyToastermessage(ADDSINGLEGATEWAY_TOASTER_MSG,"ToasterMessageSuccess",ADDSINGLEGATEWAY_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");
		
		} catch (Exception e) {

			TestLogger.appInfo(e.getMessage());
		}
	}

	public void addSingleGatewayWithMacIDAlreadyExists() {

		try {
			
			zfgatewayhomepage.clickAddGateway();
			JsonReader.getJsonObject("addSingleGatewayWithMacIDAlreadyExists");
			elementClickRadioButton(SINGLEGATEWAY_RB);
			elementSendKeys(ADDSINGLEGATEWAY_GATEWAYNAME_EB,jsonData.getJsonData("GatewayName"));
			waitElementVisibleClick(ADDSINGLEGATEWAY_TYPE_DD,500);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"GatewayType")));
			elementClick(ADDSINGLEGATEWAY_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"Model")));
			elementSendKeys(ADDSINGLEGATEWAY_MACID_EB,jsonData.getJsonData("MACID"));
			elementSendKeys(ADDSINGLEGATEWAYSERIALNUMBER_EB,jsonData.getJsonData("SerialNumber")+generateRandomNumber());
			elementSendKeys(ADDSINGLEGATEWAY_SIMNUMBER_EB,jsonData.getJsonData("SIMNumber"));
			elementClick(ADDSINGLEGATEWAY_UPLOADGATEWAYCERTIFICATE);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadCertificate"));
			elementClick(ADDSINGLEGATEWAY_NEXT_BT);

			//Enter Client Details
			elementSendKeys(ADDSINGLEGATEWAY_CUSTOMERNAME_EB,jsonData.getJsonData("CustomerName"));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERCOUNTRY_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"CustomerCountry")));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERAREA_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"CustomerArea")));
			elementSendKeys(ADDSINGLEGATEWAY_BUSINESSUNIT_EB,jsonData.getJsonData("BusinessUnit"));
			elementSendKeys(ADDSINGLEGATEWAY_OPERATOR_EB,jsonData.getJsonData("Operator"));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERDETAIL_NEXT_BT);

			//Additional
			elementSendKeyWithActions(ADDSINGLEGATEWAY_ADDITIONALDETAIL_DESCRIPTION_EB,jsonData.getJsonData("Description"));
			elementClick(ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_ICON);
			elementSendKeyWithActions(ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_KEY_EB,jsonData.getJsonData("MetaDatakey"));
			elementSendKeyWithActions(ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_VALUE_EB,jsonData.getJsonData("MetaDatavalue"));
			elementClick(ADDSINGLEGATEWAY_ADDITIONALDETAIL_FINISH_BT);
			verifyToastermessage(ADDSINGLEGATEWAY_TOASTER_MSG,"ToasterMessageFailed",ADDSINGLEGATEWAY_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
			
		} catch (Exception e) {

			TestLogger.appInfo(e.getMessage());
		}
	}


	//Validate adding Single Gateway with already existing MACID.
	public void addSingleGatewayWithCertificateAlreadyExists() {

		try {
			sleep(2000);
			zfgatewayhomepage.clickAddGateway();
			JsonReader.getJsonObject("addSingleGatewayWithCertificateAlreadyExists");
			elementClickRadioButton(SINGLEGATEWAY_RB);
			elementSendKeys(ADDSINGLEGATEWAY_GATEWAYNAME_EB,jsonData.getJsonData("GatewayName"));
			waitElementVisibleClick(ADDSINGLEGATEWAY_TYPE_DD,500);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"GatewayType")));
			elementClick(ADDSINGLEGATEWAY_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"Model")));
			elementSendKeys(ADDSINGLEGATEWAY_MACID_EB,jsonData.getJsonData("MACID")+generateRandomNumber());
			elementSendKeys(ADDSINGLEGATEWAYSERIALNUMBER_EB,jsonData.getJsonData("SerialNumber")+generateRandomNumber());
			elementSendKeys(ADDSINGLEGATEWAY_SIMNUMBER_EB,jsonData.getJsonData("SIMNumber"));
			elementClick(ADDSINGLEGATEWAY_UPLOADGATEWAYCERTIFICATE);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadCertificate"));
			elementClick(ADDSINGLEGATEWAY_NEXT_BT);

			//Enter Client Details
			elementSendKeys(ADDSINGLEGATEWAY_CUSTOMERNAME_EB,jsonData.getJsonData("CustomerName"));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERCOUNTRY_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"CustomerCountry")));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERAREA_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"CustomerArea")));
			elementSendKeys(ADDSINGLEGATEWAY_BUSINESSUNIT_EB,jsonData.getJsonData("BusinessUnit"));
			elementSendKeys(ADDSINGLEGATEWAY_OPERATOR_EB,jsonData.getJsonData("Operator"));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERDETAIL_NEXT_BT);

			//Additional
			elementSendKeyWithActions(ADDSINGLEGATEWAY_ADDITIONALDETAIL_DESCRIPTION_EB,jsonData.getJsonData("Description"));
			elementClick(ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_ICON);
			elementSendKeyWithActions(ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_KEY_EB,jsonData.getJsonData("MetaDatakey"));
			elementSendKeyWithActions(ADDSINGLEGATEWAY_ADDITIONALDETAIL_METADATA_VALUE_EB,jsonData.getJsonData("MetaDatavalue"));
			elementClick(ADDSINGLEGATEWAY_ADDITIONALDETAIL_FINISH_BT);
			verifyToastermessage(ADDSINGLEGATEWAY_TOASTER_MSG,"ToasterMessageFailed",ADDSINGLEGATEWAY_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
			
		} catch (Exception e) {

			TestLogger.appInfo(e.getMessage());
		}
	}

	public void addSingleGatewayWithMandatoryFields() {

		try {
			sleep(2000);
			zfgatewayhomepage.clickAddGateway();
			JsonReader.getJsonObject("addSingleGatewayWithMandatoryFields");
			elementClickRadioButton(SINGLEGATEWAY_RB);
			elementSendKeys(ADDSINGLEGATEWAY_GATEWAYNAME_EB,jsonData.getJsonData("GatewayName"));
			waitElementVisibleClick(ADDSINGLEGATEWAY_TYPE_DD,500);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"GatewayType")));
			elementClick(ADDSINGLEGATEWAY_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"Model")));
			elementSendKeys(ADDSINGLEGATEWAY_MACID_EB,jsonData.getJsonData("MACID")+generateRandomNumber());
			elementClick(ADDSINGLEGATEWAY_UPLOADGATEWAYCERTIFICATE);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadCertificate"));
			elementClick(ADDSINGLEGATEWAY_NEXT_BT);

			//Enter Client Details
			elementSendKeys(ADDSINGLEGATEWAY_CUSTOMERNAME_EB,jsonData.getJsonData("CustomerName"));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERCOUNTRY_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"CustomerCountry")));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERAREA_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"CustomerArea")));
			elementClick(ADDSINGLEGATEWAY_CUSTOMERDETAIL_NEXT_BT);

			//Additional
			elementClick(ADDSINGLEGATEWAY_ADDITIONALDETAIL_FINISH_BT);
			verifyToastermessage(ADDSINGLEGATEWAY_TOASTER_MSG,"ToasterMessageSuccess",ADDSINGLEGATEWAY_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");
			
		} catch (Exception e) {

			TestLogger.appInfo(e.getMessage());
		}
	}

	public void addSingleGatewayWithOutMandatoryFields() {
		try {
			sleep(2000);
			zfgatewayhomepage.clickAddGateway();
			JsonReader.getJsonObject("addSingleGatewayWithOutMandatoryFields");
			elementClickRadioButton(SINGLEGATEWAY_RB);
			//	elementSendKeys(ADDSINGLEGATEWAY_GATEWAYNAME_EB,jsonData.getJsonData("GatewayName"));
			nextButtonVisibility(ADDSINGLEGATEWAY_NEXT_BT, "without GatewayName , MAC ID and Certificate details");
			elementSendKeys(ADDSINGLEGATEWAY_GATEWAYNAME_EB,jsonData.getJsonData("GatewayName"));
			nextButtonVisibility(ADDSINGLEGATEWAY_NEXT_BT, "without MAC ID and Certificate details");
			elementSendKeys(ADDSINGLEGATEWAY_MACID_EB,jsonData.getJsonData("MACID"));
			elementSendKeys(ADDSINGLEGATEWAYSERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(ADDSINGLEGATEWAY_SIMNUMBER_EB,jsonData.getJsonData("SIMNumber"));
			nextButtonVisibility(ADDSINGLEGATEWAY_NEXT_BT, "without Certificate details");
			elementClick(ADDSINGLEGATEWAY_UPLOADGATEWAYCERTIFICATE);
			uploadFile(System.getProperty("user.dir")+jsonData.getJsonData("UploadCertificate"));
			elementClick(ADDSINGLEGATEWAY_NEXT_BT);

			//Enter Client Details
			nextButtonVisibility(ADDSINGLEGATEWAY_CUSTOMERDETAIL_NEXT_BT, "without customerName  details");
			elementSendKeys(ADDSINGLEGATEWAY_BUSINESSUNIT_EB,jsonData.getJsonData("BusinessUnit"));
			elementSendKeys(ADDSINGLEGATEWAY_OPERATOR_EB,jsonData.getJsonData("Operator"));
			nextButtonVisibility(ADDSINGLEGATEWAY_CUSTOMERDETAIL_NEXT_BT, "without customerName  details");


		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}


	public	String dynamicXpath(String xpath, String Jsonvalue) {
		return updateXpath(xpath,jsonData.getJsonData(Jsonvalue));
	}


	public void verifyToastermessage(By ByType, String Jsondata,By ByType1, String Jsondata1) {
		try {
		String toasterText = waitElementVisibleGetText(ByType,250);
		compareText(jsonData.getJsonData(Jsondata),toasterText);
		String toasterText1 = elementGetText(ByType1);
		compareText(jsonData.getJsonData(Jsondata1),toasterText1);
	} catch (InterruptedException e) {
				TestLogger.appInfo(e.getMessage());
	}
	}
	
	public void nextButtonVisibility(By ByType,String message) {
		try {
			if(elementGetValue(ByType,"disabled")!=null) {
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
	public int generateRandomNumber() {
		Random rnd = new Random();
		int randomNum = (int) (rnd.nextInt(999));
		return randomNum;
	}
}
