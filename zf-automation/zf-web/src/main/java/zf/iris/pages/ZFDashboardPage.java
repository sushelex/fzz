package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class ZFDashboardPage extends ElementManager {
	JsonReader jsonData=new JsonReader();
	private static By DASHBOARD_ICON                     =By.xpath("//div[text()='DASHBOARD']");
	private static By SETTINGS_ICON                      =By.xpath("//div[text()='Settings']");
	private static By SETTING_THRESHOILD_TXT             =By.xpath("//span[text()='Thresholds']");
	private static By THRESHOILDSETTING_SAVECHANGES_BT   =By.xpath("(//button[@class='button button-primary ng-scope'])[2]");
	private static By THRESHOILDSETTING_TOASTER_MSG		 =By.xpath("//div[text()='Success']");
	private static By THRESHOILDSETTING_TOASTER_MSG_TXT  =By.xpath("//div[text()='Thresholds Settings were updated successfully']");
	private static By THRESHOILD_SETTING_PB              =By.xpath("(//div[@class='noUi-connects'])[2]");
	
	
	public void privilegeToChangeThresholds() {
		try {
			JsonReader.getJsonObject("privilegeToChangeThresholds");
			navigateToUrl();
		waitElementVisibleClick(DASHBOARD_ICON,300);
		waitElementVisibleClick(SETTINGS_ICON,300);
		waitElementVisibleClick(SETTING_THRESHOILD_TXT,300);		
		waitElementVisibleClick(THRESHOILD_SETTING_PB,300);
		waitElementVisibleClick(THRESHOILDSETTING_SAVECHANGES_BT,300);
		verifyToastermessage(THRESHOILDSETTING_TOASTER_MSG,"ToasterMsgSuccess",THRESHOILDSETTING_TOASTER_MSG_TXT,"ToasterMsgSuccessReason");
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	
	
	
	public void verifyToastermessage(By ByType, String Jsondata,By ByType1, String Jsondata1) {
		try {
		
		String toasterText = waitElementVisibleGetText(ByType,300);
		String toasterText1 = waitElementVisibleGetText(ByType1,300);
		compareText(jsonData.getJsonData(Jsondata),toasterText);
		compareText(jsonData.getJsonData(Jsondata1),toasterText1);
		}catch (Exception e) {
		TestLogger.appInfo(e.getMessage());
	}}
	public void noPrivilegeToChangeThresholds() {
		try {
			JsonReader.getJsonObject("noPrivilegeToChangeThresholds");
			navigateToUrl();
		waitElementVisibleClick(DASHBOARD_ICON,300);
		waitElementVisibleClick(SETTINGS_ICON,300);
		if(!(elementDisplayed(SETTING_THRESHOILD_TXT))){
			testPassed("User has no permission to change threshold");
		}else {
			testFailed("User has permission to change threshold");
		}
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
}
