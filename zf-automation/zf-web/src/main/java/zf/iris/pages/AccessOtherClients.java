package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;

public class AccessOtherClients extends ElementManager{
	JsonReader jsonData=new JsonReader();
	private static  By PORTAL_DASHBOARD_BT              	 =By.xpath("//div[text()='DASHBOARD']");
	private static  By PORTAL_DETAGTIVE_BT              	 =By.xpath("//div[text()='DETAGTIVE']");
	private static  By PORTAL_MAINTENANCE_BT              	 =By.xpath("//div[text()='MAINTENANCE']");
	private static  By PORTAL_REPORTS_BT              	 =By.xpath("//div[text()='REPORTS']");
	private static  By PORTAL_TRIPS_BT              	 =By.xpath("//div[text()='TRIPS']");
	private static  By PORTAL_WINTERSERVICE_BT              	 =By.xpath("//div[text()='WINTERSERVICE']");
	private static  By PORTAL_ZF_ESYNC_BT              	 =By.xpath("//div[text()='TRIPS']");
	private static  By PORTAL_ASSET_DEVICE_MANAGEMENT_BT              	 =By.xpath("//div[text()='WINTERSERVICE']");
	
	private static  By PORTAL_BACKOFFICE_BT              	 =By.xpath("//div[text()='BACKOFFICE']");
	private static  By PORTAL_HELP_BT              	 =By.xpath("//div[text()='HELP']");
	private static  By PORTAL_NONAME_BT              	 =By.xpath("(//div[@class='app-box-container'])[11]");
	
	private static  By PORTAL_RESTRICTION_TXT              	 =By.xpath("//div[@class='text-header ng-scope']");
	
	
	
	public void checkDashboardOfUserwithOneClientAccess() {
	
		navigateToUrl();
		sleep(9000);
		if(waitElementToBeVisible(PORTAL_DASHBOARD_BT,300)) {
		elementAvailability(PORTAL_DASHBOARD_BT, "PORTAL_DASHBOARD_BT");
		elementAvailability(PORTAL_DETAGTIVE_BT, "PORTAL_DETAGTIVE_BT");
		elementAvailability(PORTAL_MAINTENANCE_BT, "PORTAL_MAINTENANCE_BT");
		elementAvailability(PORTAL_REPORTS_BT, "PORTAL_REPORTS_BT");
		elementAvailability(PORTAL_TRIPS_BT, "PORTAL_TRIPS_BT");
		elementAvailability(PORTAL_WINTERSERVICE_BT, "PORTAL_WINTERSERVICE_BT");
		elementAvailability(PORTAL_ZF_ESYNC_BT, "PORTAL_ZF_ESYNC_BT");
		elementAvailability(PORTAL_ASSET_DEVICE_MANAGEMENT_BT, "PORTAL_ASSET_DEVICE_MANAGEMENT_BT");
		
		elementAvailability(PORTAL_BACKOFFICE_BT, "PORTAL_BACKOFFICE_BT");
		elementAvailability(PORTAL_HELP_BT, "PORTAL_HELP_BT");
		elementAvailability(PORTAL_NONAME_BT, "PORTAL_NONAME_BT");
	}else {
		testFailed("Page is notloaded properly");
	}}
	public void CheckDashboardOfAnotherClientAndUserWithNoAccess() {
		navigateToOtherClientUrl();
		JsonReader.getJsonObject("checkDashboardOfUserwithOneClientAccess");
		compareText(jsonData.getJsonData("ToasterMessageFailed"),elementGetText(PORTAL_RESTRICTION_TXT));
	
	}
	
}
