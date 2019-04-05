package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class BackofficeEditVechileTypeInSomeVehiclePage extends ElementManager {

	JsonReader jsonData=new JsonReader();

	private static By VEHICLE_ICON						= By.xpath("//a[@title='Vehicles']//i[@class='menu-icon om-icon-vehicle-list ng-star-inserted']");
	private static By VEHICLE_SERACH_EB					= By.xpath("//input[@placeholder='Search']");
	private static By VEHICLE_FLEET_DB					= By.xpath("//span[@class='icon dropdown-icon']");
	private static By VEHICLE_DEFAULT_FLEET				= By.xpath("//a[contains(text(),'Default fleet')]");
	private static By VEHICLE_EDIT_DATA_BT				= By.xpath("//button[@type='button']");
	private static By VEHICLE_TYPE_LABEL				= By.xpath("//label[contains(text(),'Vehicle Type')]");
	private static By VEHICLE_TYPE_SELECT				= By.xpath("//a[contains(text(),'VEHICLE_TYPE_BUS')]");
	private static By VEHICLE_SAVE_CHANGES_BT			= By.xpath("//span[contains(text(),'Save Changes')]");
	private static By VEHICLE_SAVED_TOASTER_MSG			= By.xpath("//div[@class='ng-binding ng-scope']");
	private static By VEHICLE_SELECT					= By.xpath("//div[@class='item-content']");
	private static By VEHICLE_NAME_TITLE				= By.xpath("//div[@class='name ng-binding']");

	public void BackofficeEditVechileTypeInSomeVehicle()
	{
		JsonReader.getJsonObject("Vehicles");		
		try {
			waitElementVisibleClick(VEHICLE_ICON, 300);
			sleep(10000);
			waitElementVisibleClick(VEHICLE_FLEET_DB,300);
			waitElementVisibleClick(VEHICLE_DEFAULT_FLEET,300);
			elementSendKeys(VEHICLE_SERACH_EB, jsonData.getJsonData("Vehicle"));
			elementClick(VEHICLE_SELECT);
			compareValue(elementGetText(VEHICLE_NAME_TITLE), jsonData.getJsonData("Vehicle"));
			waitElementVisibleClick(VEHICLE_EDIT_DATA_BT,300);
			elementClick(VEHICLE_TYPE_LABEL);
			elementClick(VEHICLE_TYPE_SELECT);
			elementClick(VEHICLE_SAVE_CHANGES_BT);
			verifyToastermessage("VehicleToasterMessage");

		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}

	}
	public void verifyToastermessage(String Jsondata) {
		String toasterText;
		try {
			toasterText = waitElementVisibleGetText(VEHICLE_SAVED_TOASTER_MSG,300);
			compareText(jsonData.getJsonData(Jsondata),toasterText);
		} catch (InterruptedException e) {

			TestLogger.appInfo(e.getMessage());
		}
	}
}