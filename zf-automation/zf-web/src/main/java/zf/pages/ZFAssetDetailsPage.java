package zf.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class ZFAssetDetailsPage extends ElementManager{
	
	ZFAssetPage zfAssetPage=new ZFAssetPage();
	JsonReader jsonData=new JsonReader();
	
	private static By ASSETSDETAILS_BASICDETAILS_EDIT_BT            =By.xpath("(//div[@class='fl edit-icon sprite'])[1]");
	private static By ASSETSDETAILS_ASSETDETAILS_EDIT_BT            =By.xpath("(//div[@class='fl edit-icon sprite'])[2]");
	private static By ASSETSDETAILS_ADDCHILDASSET_BT                =By.xpath("//i[@class='fa fa-plus']");
	private static By ASSETSDETAILS_TOASTER_MSG		   	        	=By.xpath("//div[@class='toast-title']");
	private static By ASSETSDETAILS_TOASTER_MSG_TXT		        	=By.xpath("//div[@class='ng-star-inserted']");
	private static By ASSETSDETAILS_ACTIONS_BT		         	    =By.xpath("//button[@class='zf-button primary action ng-star-inserted']");
	private static By ASSETSDETAILS_ACTIONS_EDIT_BT                 =By.xpath("//div[@class='edit-icon sprite fl']");
	private static By ASSETSDETAILS_BASICDETAILSLABEL_TXT			=By.xpath("//span[contains(text(),'Basic Details')]");
	private static By ASSETSDETAILS_ASSETDETAILLABEL_TXT			=By.xpath("(//span[@class='fl'][contains(text(),'Asset Details')])");
	private static By ASSETSDETAILS_NAME							=By.xpath("//span[@class='ui-treenode-label ui-corner-all ui-state-highlight']");
	private static By ASSETSDETAILS_ADDEDASSET_BT                   =By.xpath( "//span[@class='ui-treenode-icon default root ng-star-inserted']");
	private static  By CREATE_ASSET_COUNTRY_DD   	 	            =By.xpath("//p-dropdown[@name='country']");
	private static  By CREATE_ASSET_AREA_DD   	 	                =By.xpath("//p-dropdown[@name='area']");
	private static  By CREATE_ASSET_CUSTOMER_DD   	 	            =By.xpath("//p-dropdown[@name='customer']");
	private static  By CREATE_ASSET_BUSINESSUNIT_DD                 =By.xpath("//p-dropdown[@name='business']");
	private static  By CREATE_ASSET_NEXT_BT                         =By.xpath("(//button[@class='zf-button primary fr'])[1]");
	private static  By CREATE_ASSET_ASSETTYPE_DD                    =By.xpath("//p-dropdown[@name='type']");
	private static  By CREATE_ASSET_MANUFACTURER_DD                 =By.xpath("//p-dropdown[@name='manufacturer']");
	private static  By CREATE_ASSET_MODEL_DD   	 	                =By.xpath("//p-dropdown[@name='model']");
	private static  By CREATE_ASSET_BRAND_DD                        =By.xpath("//p-dropdown[@name='brand']");

	public void OperatorHasNoAccessToEditAssetDetails() {
		try {
		JsonReader.getJsonObject("TCO3OperatorHasNoAccess");
		zfAssetPage.selectAssetDetails("TCO3OperatorHasNoAccess");
		waitElementVisibleClick(ASSETSDETAILS_BASICDETAILS_EDIT_BT,300);
		verifyToastermessage(ASSETSDETAILS_TOASTER_MSG,"ToasterMessageFailed",ASSETSDETAILS_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
		
		elementClick(ASSETSDETAILS_ASSETDETAILS_EDIT_BT);
		verifyToastermessage(ASSETSDETAILS_TOASTER_MSG,"ToasterMessageFailed",ASSETSDETAILS_TOASTER_MSG_TXT,"ToasterMessageFailedReason");

	}catch(Exception e){
		TestLogger.appInfo(e.getMessage());
	}
	}
	
	public void OperatorHasNoAccessToCreateChildAssets() {
		try {
		JsonReader.getJsonObject("TCO3OperatorHasNoAccess");
		zfAssetPage.selectAssetDetails("TCO3OperatorHasNoAccess");
		waitElementVisibleClick(ASSETSDETAILS_ADDCHILDASSET_BT,600);
		verifyToastermessage(ASSETSDETAILS_TOASTER_MSG,"ToasterMessageFailed",ASSETSDETAILS_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
		//elementClick(ASSETSDETAILS_ADDCHILDASSET_BT);
		//verifyToastermessage(ASSETSDETAILS_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
		
	}catch(Exception e){
		TestLogger.appInfo(e.getMessage());
	}
	}
	
	public void OperatorHasNoAccessToEditActions() {
		try {
		JsonReader.getJsonObject("TCO3OperatorHasNoAccess");
		zfAssetPage.selectAssetDetails("TCO3OperatorHasNoAccess");
		elementClick(ASSETSDETAILS_ACTIONS_BT);
		elementClick(ASSETSDETAILS_ACTIONS_EDIT_BT);
		verifyToastermessage(ASSETSDETAILS_TOASTER_MSG,"ToasterMessageFailed",ASSETSDETAILS_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
	
		
	}catch(Exception e){
		TestLogger.appInfo(e.getMessage());
	}
	}
	
	public void operatorAccessToViewAssetDetails()
	{
		try {
		
		JsonReader.getJsonObject("TCO3OperatorHasNoAccess");
		zfAssetPage.selectAssetDetails("TCO3OperatorHasNoAccess");
		compareTextIgnoreCase(elementGetText(ASSETSDETAILS_NAME),jsonData.getJsonData("AssetName"));
		elementAvailability(ASSETSDETAILS_BASICDETAILSLABEL_TXT);
		elementAvailability(ASSETSDETAILS_ASSETDETAILLABEL_TXT);
	}catch(Exception e){
		TestLogger.appInfo(e.getMessage());
	}
	}
	
	
	public void viewExistingAssetDetails() {
		try {
			zfAssetPage.createAssetstWithAllFeilds();
			JsonReader.getJsonObject("TCO6CreateAssetstWithAllFeilds");
	//		zfAssetPage.selectAssetDetails("TCO6CreateAssetstWithAllFeilds");
			waitElementVisibleClick(ASSETSDETAILS_ADDEDASSET_BT,600);
			waitElementVisibleClick(ASSETSDETAILS_BASICDETAILS_EDIT_BT,600);
			sleep(5000);
			compareText(elementGetText(CREATE_ASSET_COUNTRY_DD),jsonData.getJsonData("Country"));
			compareText(elementGetText(CREATE_ASSET_AREA_DD),jsonData.getJsonData("Area"));
		
			compareText(elementGetText(CREATE_ASSET_CUSTOMER_DD),jsonData.getJsonData("Customer"));
			compareText(elementGetText(CREATE_ASSET_BUSINESSUNIT_DD),jsonData.getJsonData("BusinessUnit"));
			elementClick(CREATE_ASSET_NEXT_BT);
			//compareText(elementGetText(CREATE_ASSET_ASSETNAME_EB),jsonData.getJsonData("AssetName"));
			compareText(elementGetText(CREATE_ASSET_ASSETTYPE_DD),jsonData.getJsonData("AssetType"));
			compareText(elementGetText(CREATE_ASSET_MANUFACTURER_DD),jsonData.getJsonData("Manufacturer"));
			compareText(elementGetText(CREATE_ASSET_MODEL_DD),jsonData.getJsonData("Model"));
			compareText(elementGetText(CREATE_ASSET_BRAND_DD),jsonData.getJsonData("Brand"));
			//compareText(elementGetText(CREATE_ASSET_SERIALNUMBER_EB),jsonData.getJsonData("SerialNumber"));
			//compareText(elementGetText(CREATE_ASSET_SENSORID_EB),jsonData.getJsonData("SensorID"));
			
		}catch(Exception e){
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void verifyToastermessage(By ByType, String Jsondata,By ByType1, String Jsondata1) {
		try {
		
		String toasterText = waitElementVisibleGetText(ByType,600);
		compareText(jsonData.getJsonData(Jsondata),toasterText);
		String toasterText1 = waitElementVisibleGetText(ByType1,600);
		compareText(jsonData.getJsonData(Jsondata1),toasterText1);
		}catch (Exception e) {
		TestLogger.appInfo(e.getMessage());
	}}

}
