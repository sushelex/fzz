package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class MaintenancePage extends ElementManager{
	JsonReader jsonData=new JsonReader();
	private static By MAINTENANCE_ICON                   =By.xpath("//div[text()='MAINTENANCE']");
	private static By FIRST_DEFAULT_FLEET_VEHICLE        =By.xpath("(//div[@class='vehicle-row flex-wrapper'])[1]");
	private static By EDIT_INTERVEL_BT                   =By.xpath("//button[text()='Edit intervals ']");
	private static By MAINTENANCE_INTERVAL_TIME_EDIT_TXT =By.xpath("//input[@placeholder='Maintenance interval time']");
	private static By MAINTENANCE_INTERVAL_KM_EDIT_TXT   =By.xpath("//input[@placeholder='Maintenance interval km']");
	private static By OIL_CHANGE_INTERVAL_TIME_EDIT_TXT  =By.xpath("//input[@placeholder='Oil change interval time']");
	private static By OIL_CHANGE_INTERVAL_KM_EDIT_TXT    =By.xpath("//input[@placeholder='Oil change interval km']");
	private static By MOT_INTERVAL_TIME_EDIT_TXT         =By.xpath("//input[@placeholder='MOT interval time']");		
	private static By SAVE_DATA_BT                       =By.xpath("//button[text()=' Save Data ']");
	private static By SAVE_MAINTENANCE_SUCCESS_TXT       =By.xpath("//div[text()='Save maintenance info success']");
	private static By ACTIVE_VEHICLES					 =By.xpath("//div[text()='Active vehicles']");
	private static By ACTIVE_VEHICLES_ALLROWS			 =By.xpath("//div[@class='vehicle-row flex-wrapper']");
	private static By BACKOFFICE						 =By.xpath("//div[text()='BACKOFFICE']");
	private static By ACTIVE_VEHICLES_FIRSTROW			 =By.xpath("(//div[@class='vehicle-name']/span)[1]");
	private static By VEHICLE_ICON						 =By.xpath("//div/main-menu/nav/ul/menu-item[2]/li/a/div/img");
	private static By VEHICLE_SEARCH_TB					 =By.xpath("//input[@placeholder='Search']");
	private static By VEHICLE_SEARCHED_ROW1				 =By.xpath("(//div[@class='item-content'])[1]");
	private static By FUEL_TANK_VOLUME_TB				 =By.xpath("//div/vehicle-basic-info-edit/form/div[1]/div[3]/input");
	private static By SAVE_CHANGES_BT					 =By.xpath("//span[text()='Save Changes']");
	private static By CANCEL_BT							 =By.xpath("//div/div/div/div/button[2]/span");
	
	
	public void verifyMainteneceEditSavechange()
	{
		try {
			JsonReader.getJsonObject("mainteneceEditSavechange");
			navigateToUrl();
			waitElementVisibleClick(MAINTENANCE_ICON,300);		
			waitElementVisibleClick(FIRST_DEFAULT_FLEET_VEHICLE,300);
			waitElementVisibleClick(EDIT_INTERVEL_BT,300);	
			String intervalTime = elementGetValue(MAINTENANCE_INTERVAL_TIME_EDIT_TXT, "value");
			String intervalKm = elementGetValue(MAINTENANCE_INTERVAL_KM_EDIT_TXT, "value");
			String oilIntervalTime = elementGetValue(OIL_CHANGE_INTERVAL_TIME_EDIT_TXT, "value");
			String oilIntervalKm = elementGetValue(OIL_CHANGE_INTERVAL_KM_EDIT_TXT, "value");
			String motIntervalTime = elementGetValue(MOT_INTERVAL_TIME_EDIT_TXT, "value");
			elementSendKeys(MAINTENANCE_INTERVAL_TIME_EDIT_TXT, jsonData.getJsonData("Maintenance_interval_time"));
			elementSendKeys(MAINTENANCE_INTERVAL_KM_EDIT_TXT, jsonData.getJsonData("Maintenance_interval_km"));
			elementSendKeys(OIL_CHANGE_INTERVAL_TIME_EDIT_TXT, jsonData.getJsonData("Oil_change_interval_time"));
			elementSendKeys(OIL_CHANGE_INTERVAL_KM_EDIT_TXT, jsonData.getJsonData("Oil_change_interval_km"));
			elementSendKeys(MOT_INTERVAL_TIME_EDIT_TXT, jsonData.getJsonData("Inspection_interval_time"));
			waitElementVisibleClick(SAVE_DATA_BT,300);
			compareText(elementGetText(SAVE_MAINTENANCE_SUCCESS_TXT), jsonData.getJsonData("Save_maintenance_success"));
			
			//Reverting the values 
			waitElementVisibleClick(EDIT_INTERVEL_BT,300);	
			elementSendKeys(MAINTENANCE_INTERVAL_TIME_EDIT_TXT,intervalTime);
			elementSendKeys(MAINTENANCE_INTERVAL_KM_EDIT_TXT,intervalKm);
			elementSendKeys(OIL_CHANGE_INTERVAL_TIME_EDIT_TXT,oilIntervalTime);
			elementSendKeys(OIL_CHANGE_INTERVAL_KM_EDIT_TXT, oilIntervalKm);
			elementSendKeys(MOT_INTERVAL_TIME_EDIT_TXT, motIntervalTime);
			waitElementVisibleClick(SAVE_DATA_BT,300);
			compareText(elementGetText(SAVE_MAINTENANCE_SUCCESS_TXT), jsonData.getJsonData("Save_maintenance_success"));
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
}
