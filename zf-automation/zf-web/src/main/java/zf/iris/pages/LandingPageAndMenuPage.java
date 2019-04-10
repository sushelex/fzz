package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class LandingPageAndMenuPage extends ElementManager{
	JsonReader jsonData=new JsonReader();

	private static By USER_ICON   	 	                 =By.xpath("//span[contains(text(),'Users')]");
	private static By USER_ACTIVE_ICON   	 	         =By.xpath("//div[contains(text(),'Users')]");
	private static By OPENMATICS_CLIENT					 =By.xpath("//span[contains(text(),'Openmatics 1')]");
	private static By OPENMATIC2						 =By.xpath("//div[contains(text(),'Openmatics 2')]");
	private static By OPENMATIC1						 =By.xpath("//div[contains(text(),'Openmatics 1')]");
	private static By OPENMATIC_CLIENT_TITLE			 =By.xpath("//div[@class='app-name ng-binding']");
	private static By FLEET_ICON						 =By.xpath("//div[contains(text(),'Fleets')]");
	private static By VEHICLE_ICON						 =By.xpath("//div[contains(text(),'Vehicles')]");
	private static By GATEWAY_ICON						 =By.xpath("//div[contains(text(),'Gateway')]");
	private static By CLIENTS_ICON						 =By.xpath("//div[contains(text(),'Clients')]");
	private static By OPENMATIC_APPS					 =By.xpath("(//div[@class='panel-heading'])[1]");
	private static By PORTAL_DASHBOARD_BT              	 =By.xpath("//div[text()='DASHBOARD']");
	private static By PORTAL_DETAGTIVE_BT              	 =By.xpath("//div[text()='DETAGTIVE']");
	private static By PORTAL_MAINTENANCE_BT              	 =By.xpath("//div[text()='MAINTENANCE']");
	private static By PORTAL_REPORTS_BT              	 =By.xpath("//div[text()='REPORTS']");
	private static By PORTAL_TRIPS_BT              	 =By.xpath("//div[text()='TRIPS']");
	private static By PORTAL_WINTERSERVICE_BT              	 =By.xpath("//div[text()='WINTERSERVICE']");
	private static By PORTAL_ZF_ESYNC_BT              	 =By.xpath("//div[text()='TRIPS']");
	private static By PORTAL_ASSET_DEVICE_MANAGEMENT_BT              	 =By.xpath("//div[text()='ASSET & DEVICE MANAGEMENT']");
	private static By PORTAL_BACKOFFICE_BT              	 =By.xpath("//div[text()='BACKOFFICE']");
	private static By PORTAL_HELP_BT              	 =By.xpath("//div[text()='HELP']");
	private static By PORTAL_NONAME_BT              	 =By.xpath("(//div[@class='app-box-container'])[11]");
	private static By DASHBOARD_ICON						=By.xpath("(//div[text()='Dashboard'])[2]");
	private static By HOME_ICON								=By.xpath("//div[contains(text(),'Home')]");
	private static By MAINTANANCE_ICON						=By.xpath("//i[@class='menu-icon om-icon-maintenance ng-star-inserted']");
	private static By HOME_ICON1							=By.xpath("//span[contains(text(),'Home')]");
	private static By TRIPS_ICON							=By.xpath("(//div[contains(text(),'Trips')])[2]");
	private static By ASSEST_ICON							=By.xpath("//a[@title='Assets']");
	private static By HELP_ICON								=By.xpath("//i[@class='menu-icon om-icon-help ng-star-inserted']");


	public void LoginWithMoreThanOneClient()
	{
		JsonReader.getJsonObject("OpenmaticClients");
		navigateToUrl();
		sleep(10000);
		waitElementToBeVisible(OPENMATIC_APPS,300);
		if(compareValue(elementGetText(OPENMATIC_APPS), jsonData.getJsonData("Openmatic1"))){
			elementAvailability(PORTAL_DASHBOARD_BT);
			elementAvailability(PORTAL_DETAGTIVE_BT);
			elementAvailability(PORTAL_MAINTENANCE_BT);
			elementAvailability(PORTAL_REPORTS_BT);
			elementAvailability(PORTAL_TRIPS_BT);
			elementAvailability(PORTAL_WINTERSERVICE_BT);
			elementAvailability(PORTAL_ZF_ESYNC_BT);
			elementAvailability(PORTAL_ASSET_DEVICE_MANAGEMENT_BT);
			elementAvailability(PORTAL_BACKOFFICE_BT);
			elementAvailability(PORTAL_HELP_BT);
			elementAvailability(PORTAL_NONAME_BT);
		}
		openmaticAppsGlobalMenuVerification();
	}	

	public void BothClientsGlobalMenu() 
	{
		JsonReader.getJsonObject("OpenmaticClients");
		try {
			sleep(5000);
			waitElementVisibleClick(USER_ICON,300);
			sleep(7000);
			if(!elementGetText(OPENMATIC_CLIENT_TITLE).contentEquals(jsonData.getJsonData("Openmatic1"))) {
				elementClick(OPENMATICS_CLIENT);
				elementClick(OPENMATIC1);
			}
			compareValue(elementGetText(OPENMATIC_CLIENT_TITLE),jsonData.getJsonData("Openmatic1"));
			elementAvailability(FLEET_ICON,"FLEET_ICON");
			elementAvailability(VEHICLE_ICON,"VEHICLE_ICON");
			elementAvailability(USER_ACTIVE_ICON,"USER_ACTIVE_ICON");
			elementAvailability(GATEWAY_ICON,"GATEWAY_ICON");
			elementAvailability(CLIENTS_ICON,"CLIENTS_ICON");
			waitElementVisibleClick(OPENMATICS_CLIENT, 300);
			waitElementVisibleClick(OPENMATIC2,300);
			if(!elementGetText(OPENMATIC_CLIENT_TITLE).contentEquals(jsonData.getJsonData("Openmatic2"))) {
				elementClick(OPENMATICS_CLIENT);
				elementClick(OPENMATIC2);
			}
			compareValue(elementGetText(OPENMATIC_CLIENT_TITLE),jsonData.getJsonData("Openmatic2"));
			elementAvailability(FLEET_ICON,"FLEET_ICON");
			elementAvailability(VEHICLE_ICON,"VEHICLE_ICON");
			elementAvailability(USER_ACTIVE_ICON,"USER_ACTIVE_ICON");
			elementAvailability(GATEWAY_ICON,"GATEWAY_ICON");
			elementAvailability(CLIENTS_ICON,"CLIENTS_ICON");

		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	private void openmaticAppsGlobalMenuVerification()
	{
		try {
			elementClick(PORTAL_DASHBOARD_BT);
			waitElementToBeVisible(DASHBOARD_ICON,300);
			elementClick(HOME_ICON);

			waitElementVisibleClick(PORTAL_MAINTENANCE_BT, 300);
			waitElementToBeVisible(MAINTANANCE_ICON,300);
			elementClick(HOME_ICON1);

			waitElementVisibleClick(PORTAL_TRIPS_BT, 300);
			waitElementToBeVisible(TRIPS_ICON,300);
			elementClick(HOME_ICON);

			waitElementVisibleClick(PORTAL_ASSET_DEVICE_MANAGEMENT_BT, 300);
			waitElementToBeVisible(ASSEST_ICON,300);
			elementClick(HOME_ICON1);

			waitElementVisibleClick(PORTAL_BACKOFFICE_BT, 300);
			waitElementToBeVisible(ASSEST_ICON,300);
			elementClick(HOME_ICON);

			waitElementVisibleClick(PORTAL_HELP_BT, 300);
			waitElementToBeVisible(HELP_ICON,300);
			elementClick(HOME_ICON);

		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
}