package zf.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class ZFFleetHomePage extends ElementManager {

	JsonReader jsonReader=new JsonReader();

	private static By fleetTab_BT                                                                      = By.xpath("//a[@title='Fleets']");
	private static By createNewFleetButton_BT                        = By.xpath("//button[@class='button create-btn button-secondary']");
	private static By basicDataFleetName_EB                                             = By.xpath("//input[@name='newFleetName']");
	private static By basicDataInfoText_EB                                   = By.xpath("//textarea[@name='newFleetDescription']");
	//            private static By basicDataCancel_BT                       = By.xpath("//button[contains(text(),'Cancel')]");
	private static By nextStep_BT                                                                     = By.xpath("//button[@class='button button-primary ng-binding ng-scope']");
	private static By assignVehiclesSearch_EB                            = By.xpath("//input[contains(@placeholder,'Search for vehicle of')]");
	private static By assignVehicleLoader_BT                              = By.xpath("//div[@class='drag-item item-available-fleet vehicle-icon ng-scope']//img[@class='change-btn']");
	private static By createFleet_BT                                                                = By.xpath("//button[@type='submit']");
	private static By filterExpandRow_BT                                      = By.xpath("//div[@class='toogle-btn is-folded']");
	private static By filterSerach_EB                                                                = By.xpath("//input[@placeholder='Search']");
	private static By fleetElementList_LT                                       = By.xpath("//span[@class='name ng-binding']");
	private static By fleetEditData_BT                                                             = By.xpath("//button[@class='button button-primary edit-button ng-binding']");
	private static By newFleetName_EB                                                        = By.xpath("//input[@name='newFleetName']");
	private static By newFleetDescription_EB                             = By.xpath("//textarea[@name='newFleetDescription']");
	private static By deleteFleet_BT                                                                = By.xpath("//button[@class='button button-primary ng-binding']");
	private static By clickYes_BT                                                                        = By.xpath("//button[contains(text(),'Yes')]");



	/*
	 * Method to click Fleet Tab
	 */
	public void clikcOnFleetTab() throws InterruptedException
	{
		waitElementVisibleClick(fleetTab_BT,20000);
	}

	/* 
	 * Method to use for clicking Create New Fleet Button
	 */

	public void createNewFleet() throws InterruptedException
	{
		waitElementVisibleClick(createNewFleetButton_BT, 20000);
	}

	/*
	 * Adding a New Fleet 
	 */

	public void addNewFleet()
	{
		// To Read the Fleet Data From Json File
		JsonReader.getJsonObject("Fleet");
		try {


			/*
			 *  Fleet Basic Data
			 */
			elementSendKeys(basicDataFleetName_EB, jsonReader.getJsonData("fleetname"));
			elementSendKeys(basicDataInfoText_EB, jsonReader.getJsonData("infotext"));
			elementClick(nextStep_BT);

			/*
			 * For Assigning The Vehicles
			 */
			elementSendKeys(assignVehiclesSearch_EB, jsonReader.getJsonData("vehicle"));
			waitElementVisibleClick(assignVehicleLoader_BT,10000);
			elementSendKeys(assignVehiclesSearch_EB, jsonReader.getJsonData("vehicle1"));
			waitElementVisibleClick(assignVehicleLoader_BT,1000);
			elementClick(nextStep_BT);
			/*
			 * For Creating Fleet 
			 */
			elementClick(createFleet_BT);

		}catch(Exception e)
		{
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void editNewFleet()
	{
		try {
			elementClick(filterExpandRow_BT);
			waitElementToBeVisibleSendValue(filterSerach_EB, 10000, jsonReader.getJsonData("fleetname"));

			String elementtext=elementGetText(fleetElementList_LT);
			if(elementtext.equals(jsonReader.getJsonData("fleetname")))
			{
				elementClick(fleetElementList_LT);
				elementClick(fleetEditData_BT);
				elementSendKeys(newFleetName_EB, jsonReader.getJsonData("fleetnamenew"));
				elementSendKeys(newFleetDescription_EB, jsonReader.getJsonData("infotextnew"));
				elementClick(nextStep_BT);
				elementSendKey(assignVehiclesSearch_EB, jsonReader.getJsonData("vehiclenew"));
				elementClick(assignVehicleLoader_BT);

				elementSendKeys(assignVehiclesSearch_EB, jsonReader.getJsonData("vehiclenew1"));
				waitElementVisibleClick(assignVehicleLoader_BT,10000);
				elementClick(nextStep_BT);
				elementClick(createFleet_BT);
			}
		}catch(Exception e) {

			TestLogger.appInfo(e.getMessage());
		}
	}


	public void deleteFleet()
	{

		elementClick(filterExpandRow_BT);
		elementSendKeys(filterSerach_EB, jsonReader.getJsonData("fleetnamenew"));
		String elementtext=elementGetText(fleetElementList_LT);
		if(elementtext.equals(jsonReader.getJsonData("fleetnamenew")))
		{
			elementClick(deleteFleet_BT);
			elementClick(clickYes_BT);
		}
	}

}