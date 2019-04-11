package zf.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class ZFFleetHomePage extends ElementManager {

	JsonReader jsonReader=new JsonReader();

	private static By FLEETTAB_ICON                                    = By.xpath("//a[@title='Fleets']");
	private static By FLEET_CREATENEWFLEETBUTTON_BT                    = By.xpath("//button[@class='button create-btn button-secondary']");
	private static By FLEET_BASICDATAFLEETNAME_EB                      = By.xpath("//input[@name='newFleetName']");
	private static By FLEET_BASICDATAINFOTEXT_EB                       = By.xpath("//textarea[@name='newFleetDescription']");
	//	private static By BASICDATACANCEL_BT                             = By.xpath("//button[contains(text(),'Cancel')]");
	private static By FLEET_NEXTSTEP_BT                                = By.xpath("//button[@class='button button-primary ng-binding ng-scope']");
	private static By FLEET_ASSIGNVEHICLESSEARCH_EB                    = By.xpath("//input[contains(@placeholder,'Search for vehicle of')]");
	private static By FLEET_ASSIGNVEHICLELOADER_BT                     = By.xpath("//div[@class='drag-item item-available-fleet vehicle-icon ng-scope']//img[@class='change-btn']");
	private static By FLEET_CREATEFLEET_BT                             = By.xpath("//button[@type='submit']");
	private static By FLEET_FILTEREXPANDROW_BT                         = By.xpath("//div[@class='toogle-btn is-folded']");
	private static By FLEET_FILTERSEARCH_EB                            = By.xpath("//input[@placeholder='Search']");
	private static By FLEET_FLEETELEMENTLIST_LT                        = By.xpath("//span[@class='name ng-binding']");
	private static By FLEET_FLEETEDITDATA_BT                           = By.xpath("//button[@class='button button-primary edit-button ng-binding']");
	private static By FLEET_NEWFLEETNAME_EB                            = By.xpath("//input[@name='newFleetName']");
	private static By FLEET_NEWFLEETDESCRIPTION_EB                     = By.xpath("//textarea[@name='newFleetDescription']");
	private static By FLEET_DELETEFLEET_BT                             = By.xpath("//button[@class='button button-primary ng-binding']");
	private static By FLEET_CLICKYES_BT                                = By.xpath("//button[contains(text(),'Yes')]");

	/*
	 * Method to click Fleet Tab
	 */
	public void clikcOnFleetTab() throws InterruptedException
	{
		waitElementVisibleClick(FLEETTAB_ICON,300);
	}

	/* 
	 * Method to use for clicking Create New Fleet Button
	 */

	public void createNewFleet() throws InterruptedException
	{
		waitElementVisibleClick(FLEET_CREATENEWFLEETBUTTON_BT, 300);
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
			elementSendKeys(FLEET_BASICDATAFLEETNAME_EB, jsonReader.getJsonData("fleetname"));
			elementSendKeys(FLEET_BASICDATAINFOTEXT_EB, jsonReader.getJsonData("infotext"));
			elementClick(FLEET_NEXTSTEP_BT);

			/*
			 * For Assigning The Vehicles
			 */
			elementSendKeys(FLEET_ASSIGNVEHICLESSEARCH_EB, jsonReader.getJsonData("vehicle"));
			waitElementVisibleClick(FLEET_ASSIGNVEHICLELOADER_BT,300);
			elementSendKeys(FLEET_ASSIGNVEHICLESSEARCH_EB, jsonReader.getJsonData("vehicle1"));
			waitElementVisibleClick(FLEET_ASSIGNVEHICLELOADER_BT,300);
			elementClick(FLEET_NEXTSTEP_BT);
			/*
			 * For Creating Fleet 
			 */
			elementClick(FLEET_CREATEFLEET_BT);

		}catch(Exception e)
		{
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void editNewFleet()
	{
		try {
			elementClick(FLEET_FILTEREXPANDROW_BT);
			waitElementToBeVisibleSendValue(FLEET_FILTERSEARCH_EB, 300, jsonReader.getJsonData("fleetname"));

			String elementtext=elementGetText(FLEET_FLEETELEMENTLIST_LT);
			if(elementtext.equals(jsonReader.getJsonData("fleetname")))
			{
				elementClick(FLEET_FLEETELEMENTLIST_LT);
				elementClick(FLEET_FLEETEDITDATA_BT);
				elementSendKeys(FLEET_NEWFLEETNAME_EB, jsonReader.getJsonData("fleetnamenew"));
				elementSendKeys(FLEET_NEWFLEETDESCRIPTION_EB, jsonReader.getJsonData("infotextnew"));
				elementClick(FLEET_NEXTSTEP_BT);
				elementSendKeyWithActions(FLEET_ASSIGNVEHICLESSEARCH_EB, jsonReader.getJsonData("vehiclenew"));
				elementClick(FLEET_ASSIGNVEHICLELOADER_BT);

				elementSendKeys(FLEET_ASSIGNVEHICLESSEARCH_EB, jsonReader.getJsonData("vehiclenew1"));
				waitElementVisibleClick(FLEET_ASSIGNVEHICLELOADER_BT,300);
				elementClick(FLEET_NEXTSTEP_BT);
				elementClick(FLEET_CREATEFLEET_BT);
			}
		}catch(Exception e) {

			TestLogger.appInfo(e.getMessage());
		}
	}

	public void deleteFleet()
	{

		elementClick(FLEET_FILTEREXPANDROW_BT);
		elementSendKeys(FLEET_FILTERSEARCH_EB, jsonReader.getJsonData("fleetnamenew"));
		String elementtext=elementGetText(FLEET_FLEETELEMENTLIST_LT);
		if(elementtext.equals(jsonReader.getJsonData("fleetnamenew")))
		{
			elementClick(FLEET_DELETEFLEET_BT);
			elementClick(FLEET_CLICKYES_BT);
		}
	}

}