package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.TestLogger;

public class ZFDashboardPage extends ElementManager {
	
	private static By DASHBOARD_ICON  =By.xpath("//div[text()='DASHBOARD']");
	private static By SETTINGS_ICON =By.xpath("//div[text()='Settings']");
	private static By SETTING_THRESHOILD_TXT= By.xpath("//span[text()='Thresholds']");
	private static By KPISETTING_FUEL_CONSUMPTION_CB  =By.xpath("//label[@for='AVG_FUEL_CONSUMPTION']");
	private static By KPISETTING_SAVECHANGES_BT  =By.xpath("(//button[@class='button button-primary ng-scope'])[2]']");
	private static By KPISETTING_TOASTER_MSG		   	        	=By.xpath("//div[@class='toast-title']");
	private static By KPISETTING_TOASTER_MSG_TXT		        	=By.xpath("//div[@class='ng-star-inserted']");
	private static By SETTING_THRESHOILD_PB=By.xpath("");
	
	
	public void noPrivilegeToChangeThresholds() {
		try {
			navigateToUrl();
		waitElementVisibleClick(DASHBOARD_ICON,300);
		elementClick(SETTINGS_ICON);
		elementClick(SETTING_THRESHOILD_TXT);		
		elementClick(SETTING_THRESHOILD_PB);
		elementClick(KPISETTING_SAVECHANGES_BT);
		verifyToastermessage(KPISETTING_TOASTER_MSG,"Success");
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	
	public void verifyToastermessage(By ByType, String Jsondata) {
		try {
		
		String toasterText = waitElementVisibleGetText(ByType,300);
	//	compareText(jsonData.getJsonData(Jsondata),toasterText);
		compareText(Jsondata,toasterText);
		}catch (Exception e) {
		TestLogger.appInfo(e.getMessage());
	}}
}
