package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class RealTimeDataPage extends ElementManager{
	JsonReader jsonData=new JsonReader();
	private static By PORTAL_DASHBOARD_ICON              =By.xpath("//div[text()='DASHBOARD']");
	private static By GLOBAL_SETTINGS_ICON               =By.xpath("//div[text()='Settings']");
	private static By SETTING_KPISETTING_LK              =By.xpath("//span[text()='KPI Settings']");
	private static By AMOUNT_OF_ACTIVE_VEHICLES_CB   	 =By.xpath("(//div[@class='item input ng-scope'])[5]");
	private static By Dashboard_ICON                     =By.xpath("//div[@class='text ng-scope ng-binding'][text()='Dashboard']");
	private static By ACTIVE_VIHICLE_TXT                 =By.xpath("//div[text()='Active vehicles']");
	private static By ACTIVE_VIHICLE_NUMBER              =By.xpath("//div[text()='Active vehicles']/preceding-sibling::div[@class='value']/span[@class='ng-binding']");
	private static By NO_OF_ACTIVE_VIHICLE_COUNT         =By.xpath("//div[@class='vehicle-name']");
	private static By VEHICLE_DETAILS_ARROW				 =By.xpath("(//div[@class='active-icon'])[1]");
	private static By VEHICLE_SETTINGS_TAB				 =By.xpath("//button[text()='Vehicle settings']");
	private static By EDIT_DATA_BT						 =By.xpath("//div/div/div/div/button");
	private static By VEHICLETYPE_DROPDOWN				 =By.xpath("//div[1]/div[1]/om-dropdown/div/div/div/span");
	private static By VEHICLETYPE_DROPDOWN_OPTION2		 =By.xpath("//div[1]/div[1]/om-dropdown/div/ul/li[2]");
	private static By EDITVEHICLES_SAVE_BT		 =By.xpath("//button[@disabled='disabled']");
	private static By ACTIVE_VEHICLES_SECONDROW			 =By.xpath("(//div[@class='vehicle-name']/span)[2]");
	private static By VEHICLE_DETAILS_ARROW_ROW2		=By.xpath("(//div[@class='active-icon'])[2]");
	private static By DASHBOARD_VEHICLE_SPEED_METER		=By.xpath("(//*[@id='text'])[1]");
	private static By ACTIVE_VEHICLES					 =By.xpath("//div[text()='Active vehicles']");
	public void verifyActiveVehiclesDisplay()
	{
		try {
			navigateToUrl();
			waitElementVisibleClick(PORTAL_DASHBOARD_ICON,300);
			waitElementVisibleClick(GLOBAL_SETTINGS_ICON,300);
			waitElementVisibleClick(SETTING_KPISETTING_LK,300);	
			checkActiveVehicleCheckbox( AMOUNT_OF_ACTIVE_VEHICLES_CB);
			waitElementVisibleClick(Dashboard_ICON,300);
			waitElementVisibleClick(ACTIVE_VIHICLE_TXT,300);
			String str=elementGetText(ACTIVE_VIHICLE_NUMBER);
			String[] numbers = str.split("/");
			System.out.println(numbers[0]);
			int countOfactiveVihicle= elementCount(NO_OF_ACTIVE_VIHICLE_COUNT);	
			String ActiveVihiclecount=String.valueOf(countOfactiveVihicle);		   
			compareText(numbers[0],ActiveVihiclecount);	
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	
	public void clickEditVehicleAndEdit() {
		try {
			
			navigateToUrl();
			waitElementVisibleClick(PORTAL_DASHBOARD_ICON,300);
			waitElementVisibleClick(ACTIVE_VEHICLES,300);
			waitElementVisibleClick(VEHICLE_DETAILS_ARROW,300);
			switchToWindow();
			waitElementVisibleClick(VEHICLE_SETTINGS_TAB,300);
			waitElementVisibleClick(EDIT_DATA_BT,300);
			if(elementAvailability(EDITVEHICLES_SAVE_BT)) {
				info("Save button is disabled before editing ");
				waitElementVisibleClick(VEHICLETYPE_DROPDOWN,300);
				waitElementVisibleClick(VEHICLETYPE_DROPDOWN_OPTION2,300);
				if(!elementAvailability(EDITVEHICLES_SAVE_BT)) {
					testPassed("Save button is enabled after editing the value ");
				}
			}else {
				testFailed("Save button is enabled before editing ");
			}
		} 
		catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
		
	}
	public void vehicleSpeedCheck()
	{
		try {
			navigateToUrl();
			waitElementVisibleClick(PORTAL_DASHBOARD_ICON,300);
			waitElementVisibleClick(ACTIVE_VEHICLES,300);
			String SecondRowVehicleName=elementGetText(ACTIVE_VEHICLES_SECONDROW);
			waitElementVisibleClick(VEHICLE_DETAILS_ARROW_ROW2,300);
			switchToWindow();
			String vehicleDataBefore=elementGetText(DASHBOARD_VEHICLE_SPEED_METER);
			System.out.println("VehicleDataBefore : "+ vehicleDataBefore);
			Thread.sleep(15000);
			String vehicleDataAfter=elementGetText(DASHBOARD_VEHICLE_SPEED_METER);
			System.out.println("VehicleDataAfter : "+ vehicleDataAfter);
			if(vehicleDataBefore.equals(vehicleDataAfter))
			{
			testFailed("");
		
		}else {
			testPassed("");
		}
			}
		catch (Exception e) {
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

}
