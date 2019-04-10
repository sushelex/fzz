package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;
import zf.pages.ZFAssetPage;

public class ZFRBACPage extends ElementManager {
	JsonReader jsonData=new JsonReader();
	ZFAssetPage zfAssetPage=new ZFAssetPage();
	private static By PORTAL_DASHBOARD_ICON                     =By.xpath("//div[text()='DASHBOARD']");
	private static By SETTINGS_ICON                             =By.xpath("//div[text()='Settings']");
	private static By SETTING_THRESHOILD_LK                     =By.xpath("//span[text()='Thresholds']");
	private static By THRESHOILDSETTING_SAVECHANGES_BT          =By.xpath("(//button[@class='button button-primary ng-scope'])[2]");
	private static By THRESHOILDSETTING_TOASTER_MSG		        =By.xpath("//div[text()='Success']");
	private static By THRESHOILDSETTING_TOASTER_MSG_TXT         =By.xpath("//div[text()='Thresholds Settings were updated successfully']");
	private static By THRESHOILD_SETTING_PB                     =By.xpath("(//div[@class='noUi-connects'])[2]");
	private static  By USER_ICON   	 	                        =By.xpath("//a[@title='Users']");
	private static  By USER_FILTER_ST  				            =By.xpath("//span[@class='filter-label ng-binding']");
	private static  By USER_SEARCH_EB  				            =By.xpath("//input[@class='filter-input ng-pristine ng-untouched ng-valid ng-empty']");
	private static  By USER_SEARCHFIRSTVALUE_DT  	            =By.xpath("(//div[@class='item-content'])[1]");
	private static  By USER_EDITUSER_BT   			            =By.xpath("//button[@class='button button-primary edit-button']");
	private static  By USER_VEHICLEEDIT_RIGHTS_CB	            =By.xpath("(//label[@class='checkbox-desc ng-binding'])[1]");
	private static  By USER_SAVE_BT             	            =By.xpath("//span[text()='Save']");
	private static  By USER_TOASTER_MSG             	        =By.xpath("//div[@class='ng-binding toast-title']");
	private static  By USER_TOASTER_MSG_TXT             	    =By.xpath("//div[@class='ng-binding ng-scope']");
	private static  By USER_ROLE_EB              	            =By.xpath("//div[@title='User roles']");

	private static  By USER_ROLE_DELETE_EB                      =By.xpath("//span[@class='close ui-select-match-close']");
	private static By USER_SAVE_DISABLE_BT              	    =By.xpath("(//button[@disabled='disabled'])[2]");
	private static By ASSETSDETAILS_BASICDETAILS_EDIT_BT        =By.xpath("(//div[@class='fl edit-icon sprite'])[1]");
	private static By ASSETSDETAILS_TOASTER_MSG		   	      	=By.xpath("//div[@class='toast-title']");
	private static By ASSETSDETAILS_TOASTER_MSG_TXT		       	=By.xpath("//div[@class='ng-star-inserted']");
	private static By ASSETSDETAILS_ASSETDETAILS_EDIT_BT        =By.xpath("(//div[@class='fl edit-icon sprite'])[2]");
	private static By THRESHOILDSETTING_DISABLE_SAVE_BT          =By.xpath("//button[@disabled='disabled']");
	
	public void privilegeToChangeThresholds() {
		try {
			JsonReader.getJsonObject("privilegeToChangeThresholds");
			navigateToUrl();
		waitElementVisibleClick(PORTAL_DASHBOARD_ICON,300);
		waitElementVisibleClick(SETTINGS_ICON,300);
		waitElementVisibleClick(SETTING_THRESHOILD_LK,300);		
		if(elementAvailability(THRESHOILDSETTING_DISABLE_SAVE_BT)) {
		waitElementVisibleClick(THRESHOILD_SETTING_PB,500);
		if(elementDisplayed(THRESHOILDSETTING_SAVECHANGES_BT)) {
			testPassed("Save button is enabled after editing ");
		
		}else {
			testFailed("Save button is enabled before editing ");
		}
		}}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void noPrivilegeToEditUser() {
		try {
			JsonReader.getJsonObject("noPrivilegeToEditUser");
			waitElementVisibleClick(USER_ICON,300);
			waitElementVisibleClick(USER_FILTER_ST,300);
			elementSendKeys(USER_SEARCH_EB, jsonData.getJsonData("Name"));
			elementClick(USER_SEARCHFIRSTVALUE_DT);
			elementClick(USER_EDITUSER_BT);
			elementClick(USER_VEHICLEEDIT_RIGHTS_CB);
			elementClick(USER_SAVE_BT);
			verifyToastermessage(USER_TOASTER_MSG,"ToasterMsgFailed",USER_TOASTER_MSG_TXT,"ToasterMsgFailedReason");
		}catch(Exception e) {

		}}

	public void noPrivilegeToEditUserRole() {
		try {
			JsonReader.getJsonObject("noPrivilegeToEditUserRole");
			waitElementVisibleClick(USER_ICON,300);
			waitElementVisibleClick(USER_FILTER_ST,300);
			elementSendKeys(USER_SEARCH_EB, jsonData.getJsonData("Name"));
			elementClick(USER_SEARCHFIRSTVALUE_DT);
			elementClick(USER_EDITUSER_BT);
			elementClick(USER_ROLE_EB);
			elementSendKeys(USER_ROLE_EB, jsonData.getJsonData("UserRole"));
			elementClick(USER_SAVE_BT);
			verifyToastermessage(USER_TOASTER_MSG,"ToasterMsgFailed",USER_TOASTER_MSG_TXT,"ToasterMsgFailedReason");
		}catch(Exception e) {

		}}


	public void editUserWithNoRole() {
		try {
			JsonReader.getJsonObject("noPrivilegeToChangeThresholds");
			waitElementVisibleClick(USER_ICON,300);
			waitElementVisibleClick(USER_FILTER_ST,300);
			elementSendKeys(USER_SEARCH_EB, jsonData.getJsonData("Name"));
			elementClick(USER_SEARCHFIRSTVALUE_DT);
			elementClick(USER_EDITUSER_BT);

			//elementClear(USER_ROLE_EB);
			if(elementDisplayed(USER_ROLE_DELETE_EB)){
				elementClick(USER_ROLE_DELETE_EB);
				elementClick(USER_SAVE_BT);
			}
		}catch(Exception e) {

		}

	}

	public void noPrivilegeToEditAssets() {
		JsonReader.getJsonObject("noPrivilegeToEditAssets");
		zfAssetPage.selectAssetDetails("noPrivilegeToEditAssets");
		elementClick(ASSETSDETAILS_BASICDETAILS_EDIT_BT);
		verifyToastermessage(ASSETSDETAILS_TOASTER_MSG,"ToasterMessageFailed",ASSETSDETAILS_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
	
		}
	public void noPrivilegeToChangeThresholds() {
		try {
			JsonReader.getJsonObject("noPrivilegeToChangeThresholds");
			navigateToUrl();
		waitElementVisibleClick(PORTAL_DASHBOARD_ICON,300);
		waitElementVisibleClick(SETTINGS_ICON,300);
		if(!(elementDisplayed(SETTING_THRESHOILD_LK))){
			testPassed("User has no permission to change threshold");
		}else {
			testFailed("User has permission to change threshold");
		}
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}}
	
	public void verifyToastermessage(By ByType, String Jsondata,By ByType1, String Jsondata1) {
		try {
		
		String toasterText = waitElementVisibleGetText(ByType,100);
		String toasterText1 = elementGetText(ByType1);
		compareText(jsonData.getJsonData(Jsondata),toasterText);
		compareText(jsonData.getJsonData(Jsondata1),toasterText1);
		}catch (Exception e) {
		TestLogger.appInfo(e.getMessage());
	}}
	
	
}
