package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class ClientHomePage extends ElementManager{
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

	public void LoginWithMoreThanOneClient() {
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
}