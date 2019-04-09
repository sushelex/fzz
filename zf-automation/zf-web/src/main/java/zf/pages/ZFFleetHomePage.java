package zf.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class ZFFleetHomePage extends ElementManager {

	JsonReader jsonReader=new JsonReader();

	private static By FLEETTAB_BT                                    = By.xpath("//a[@title='Fleets']");
	private static By CREATENEWFLEETBUTTON_BT                        = By.xpath("//button[@class='button create-btn button-secondary']");
	private static By BASICDATAFLEETNAME_EB                          = By.xpath("//input[@name='newFleetName']");
	private static By BASICDATAINFOTEXT_EB                           = By.xpath("//textarea[@name='newFleetDescription']");
	//	private static By BASICDATACANCEL_BT                             = By.xpath("//button[contains(text(),'Cancel')]");
	private static By NEXTSTEP_BT                                    = By.xpath("//button[@class='button button-primary ng-binding ng-scope']");
	private static By ASSIGNVEHICLESSEARCH_EB                        = By.xpath("//input[contains(@placeholder,'Search for vehicle of')]");
	private static By ASSIGNVEHICLELOADER_BT                         = By.xpath("//div[@class='drag-item item-available-fleet vehicle-icon ng-scope']//img[@class='change-btn']");
	private static By CREATEFLEET_BT                                 = By.xpath("//button[@type='submit']");
	private static By FILTEREXPANDROW_BT                             = By.xpath("//div[@class='toogle-btn is-folded']");
	private static By FILTERSERACH_EB                                = By.xpath("//input[@placeholder='Search']");
	private static By FLEETELEMENTLIST_LT                            = By.xpath("//span[@class='name ng-binding']");
	private static By FLEETEDITDATA_BT                               = By.xpath("//button[@class='button button-primary edit-button ng-binding']");
	private static By NEWFLEETNAME_EB                                = By.xpath("//input[@name='newFleetName']");
	private static By NEWFLEETDESCRIPTION_EB                         = By.xpath("//textarea[@name='newFleetDescription']");
	private static By DELETEFLEET_BT                                 = By.xpath("//button[@class='button button-primary ng-binding']");
	private static By CLICKYES_BT                                    = By.xpath("//button[contains(text(),'Yes')]");



	/*
	 * Method to click Fleet Tab
	 */
	public void clikcOnFleetTab() throws InterruptedException
	{
		waitElementVisibleClick(FLEETTAB_BT,300);
	}

	/* 
	 * Method to use for clicking Create New Fleet Button
	 */

	public void createNewFleet() throws InterruptedException
	{
		waitElementVisibleClick(CREATENEWFLEETBUTTON_BT, 300);
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
			elementSendKeys(BASICDATAFLEETNAME_EB, jsonReader.getJsonData("fleetname"));
			elementSendKeys(BASICDATAINFOTEXT_EB, jsonReader.getJsonData("infotext"));
			elementClick(NEXTSTEP_BT);

			/*
			 * For Assigning The Vehicles
			 */
			elementSendKeys(ASSIGNVEHICLESSEARCH_EB, jsonReader.getJsonData("vehicle"));
			waitElementVisibleClick(ASSIGNVEHICLELOADER_BT,300);
			elementSendKeys(ASSIGNVEHICLESSEARCH_EB, jsonReader.getJsonData("vehicle1"));
			waitElementVisibleClick(ASSIGNVEHICLELOADER_BT,300);
			elementClick(NEXTSTEP_BT);
			/*
			 * For Creating Fleet 
			 */
			elementClick(CREATEFLEET_BT);

		}catch(Exception e)
		{
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void editNewFleet()
	{
		try {
			elementClick(FILTEREXPANDROW_BT);
			waitElementToBeVisibleSendValue(FILTERSERACH_EB, 300, jsonReader.getJsonData("fleetname"));

			String elementtext=elementGetText(FLEETELEMENTLIST_LT);
			if(elementtext.equals(jsonReader.getJsonData("fleetname")))
			{
				elementClick(FLEETELEMENTLIST_LT);
				elementClick(FLEETEDITDATA_BT);
				elementSendKeys(NEWFLEETNAME_EB, jsonReader.getJsonData("fleetnamenew"));
				elementSendKeys(NEWFLEETDESCRIPTION_EB, jsonReader.getJsonData("infotextnew"));
				elementClick(NEXTSTEP_BT);
				elementSendKeyWithActions(ASSIGNVEHICLESSEARCH_EB, jsonReader.getJsonData("vehiclenew"));
				elementClick(ASSIGNVEHICLELOADER_BT);

				elementSendKeys(ASSIGNVEHICLESSEARCH_EB, jsonReader.getJsonData("vehiclenew1"));
				waitElementVisibleClick(ASSIGNVEHICLELOADER_BT,300);
				elementClick(NEXTSTEP_BT);
				elementClick(CREATEFLEET_BT);
			}
		}catch(Exception e) {

			TestLogger.appInfo(e.getMessage());
		}
	}


	public void deleteFleet()
	{

		elementClick(FILTEREXPANDROW_BT);
		elementSendKeys(FILTERSERACH_EB, jsonReader.getJsonData("fleetnamenew"));
		String elementtext=elementGetText(FLEETELEMENTLIST_LT);
		if(elementtext.equals(jsonReader.getJsonData("fleetnamenew")))
		{
			elementClick(DELETEFLEET_BT);
			elementClick(CLICKYES_BT);
		}
	}

}