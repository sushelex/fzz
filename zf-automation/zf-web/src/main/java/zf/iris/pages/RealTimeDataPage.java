package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class RealTimeDataPage extends ElementManager{
	JsonReader jsonData=new JsonReader();
	private static By PORTAL_DASHBOARD_ICON                             =By.xpath("//div[text()='DASHBOARD']");
	private static By GLOBAL_SETTINGS_ICON                              =By.xpath("//div[text()='Settings']");
	private static By SETTING_KPISETTING_LK                             =By.xpath("//span[text()='KPI Settings']");
	private static By SETTING_KPISETTING_AMOUNTOFACTIVEVEHICLES_CB   	 =By.xpath("(//div[@class='item input ng-scope'])[5]");
	private static By DASHBOARD_ICON                                     =By.xpath("//div[@class='text ng-scope ng-binding'][text()='Dashboard']");
	private static By DASHBOARD_ACTIVEVIHICLE_TXT                 =By.xpath("//div[text()='Active vehicles']");
	private static By DASHBOARD_ACTIVEVIHICLE_NUMBER              =By.xpath("//div[text()='Active vehicles']/preceding-sibling::div[@class='value']/span[@class='ng-binding']");
	private static By DASHBOARD_NOOFACTIVEVIHICLE_COUNT         =By.xpath("//div[@class='vehicle-name']");
	private static By DASHBOARD_VEHICLE_DETAILS_ARROW				 =By.xpath("(//div[@class='active-icon'])[1]");
	private static By DASHBOARD_VEHICLEDETAILSARROW_VEHICLESETTINGS_BT				 =By.xpath("//button[text()='Vehicle settings']");
	private static By DASHBOARD_VEHICLESETTINGS_EDITDATA_BT						 =By.xpath("//div/div/div/div/button");
	private static By DASHBOARD_VEHICLESETTINGS_VEHICLETYPE_DD				 =By.xpath("//div[1]/div[1]/om-dropdown/div/div/div/span");
	private static By DASHBOARD_VEHICLESETTINGS_VEHICLETYPE_DD2		 =By.xpath("//div[1]/div[1]/om-dropdown/div/ul/li[2]");
	private static By DASHBOARD__EDITVEHICLES_SAVE_BT		         =By.xpath("//button[@disabled='disabled']");
	private static By DASHBOARD_ACTIVEVEHICLES_SECONDROW			 =By.xpath("(//div[@class='vehicle-name']/span)[2]");
	private static By DASHBOARD_VEHICLEDETAILSARROW_ROW2		=By.xpath("(//div[@class='active-icon'])[2]");
	private static By DASHBOARD_VEHICLE_SPEED_METER		=By.xpath("(//*[@id='text'])[1]");
	private static By DASHBOARD__ACTIVE_VEHICLES					 =By.xpath("//div[text()='Active vehicles']");
	
	public void verifyActiveVehiclesDisplay()
	{
		try {
			navigateToPortalUrl();
			waitElementVisibleClick(PORTAL_DASHBOARD_ICON,300);
			waitElementVisibleClick(GLOBAL_SETTINGS_ICON,300);
			waitElementVisibleClick(SETTING_KPISETTING_LK,300);	
			checkActiveVehicleCheckbox( SETTING_KPISETTING_AMOUNTOFACTIVEVEHICLES_CB);
			waitElementVisibleClick(DASHBOARD_ICON,300);
			waitElementVisibleClick(DASHBOARD_ACTIVEVIHICLE_TXT,300);
			String str=elementGetText(DASHBOARD_ACTIVEVIHICLE_NUMBER);
			String[] numbers = str.split("/");
			System.out.println(numbers[0]);
			int countOfactiveVihicle= elementCount(DASHBOARD_NOOFACTIVEVIHICLE_COUNT);	
			String ActiveVihiclecount=String.valueOf(countOfactiveVihicle);		   
			compareText(numbers[0],ActiveVihiclecount);	
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	
	public void clickEditVehicleAndEdit() {
		try {
			
			navigateToPortalUrl();
			waitElementVisibleClick(PORTAL_DASHBOARD_ICON,300);
			waitElementVisibleClick(DASHBOARD__ACTIVE_VEHICLES,300);
			waitElementVisibleClick(DASHBOARD_VEHICLE_DETAILS_ARROW,300);
			switchToWindow();
			waitElementVisibleClick(DASHBOARD_VEHICLEDETAILSARROW_VEHICLESETTINGS_BT,300);
			waitElementVisibleClick(DASHBOARD_VEHICLESETTINGS_EDITDATA_BT,300);
			if(elementAvailability(DASHBOARD__EDITVEHICLES_SAVE_BT)) {
				info("Save button is disabled before editing ");
				waitElementVisibleClick(DASHBOARD_VEHICLESETTINGS_VEHICLETYPE_DD,300);
				waitElementVisibleClick(DASHBOARD_VEHICLESETTINGS_VEHICLETYPE_DD2,300);
				if(!elementDisplayed(DASHBOARD__EDITVEHICLES_SAVE_BT)) {
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
			navigateToPortalUrl();
			waitElementVisibleClick(PORTAL_DASHBOARD_ICON,300);
			waitElementVisibleClick(DASHBOARD__ACTIVE_VEHICLES,300);
			String SecondRowVehicleName=elementGetText(DASHBOARD_ACTIVEVEHICLES_SECONDROW);
			waitElementVisibleClick(DASHBOARD_VEHICLEDETAILSARROW_ROW2,300);
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
		String toasterText1 = elementGetText(ByType1);
		compareText(jsonData.getJsonData(Jsondata),toasterText);
		compareText(jsonData.getJsonData(Jsondata1),toasterText1);
		}catch (Exception e) {
		TestLogger.appInfo(e.getMessage());
	}}

}
