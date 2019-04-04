package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class BackofficeCreateFleetAndAddSomeVehiclesPage extends ElementManager {
	JsonReader jsonData=new JsonReader();

	private static By FLEETTAB_BT                                    = By.xpath("//a[@title='Fleets']");
	private static By CREATENEWFLEETBUTTON_BT                        = By.xpath("//button[@class='button create-btn button-secondary']");
	private static By BASICDATAFLEETNAME_EB                          = By.xpath("//input[@name='newFleetName']");
	private static By BASICDATAINFOTEXT_EB                           = By.xpath("//textarea[@name='newFleetDescription']");
	private static By NEXTSTEP_BT                                    = By.xpath("//button[@class='button button-primary ng-binding ng-scope']");
	private static By ASSIGNVEHICLESSEARCH_EB                        = By.xpath("//input[contains(@placeholder,'Search for vehicle of')]");
	private static By ASSIGNVEHICLELOADER_BT                         = By.xpath("//div[@class='drag-item item-available-fleet vehicle-icon ng-scope']//img[@class='change-btn']");
	private static By CREATEFLEET_BT                                 = By.xpath("//button[@type='submit']");
	private static By FILTEREXPANDROW_BT                             = By.xpath("//div[@class='toogle-btn is-folded']");
	private static By FILTERSERACH_EB                                = By.xpath("//input[@placeholder='Search']");
	private static By FLEETELEMENTLIST_LT                            = By.xpath("//span[@class='name ng-binding']");
	
	public void CreateFleetAndAddSomeVehicle()
	{
		JsonReader.getJsonObject("Fleet");
		try {
			waitElementVisibleClick(FLEETTAB_BT,500);
			sleep(5000);
			waitElementVisibleClick(CREATENEWFLEETBUTTON_BT, 1000);
			sleep(10000);


					/*Fleet Basic Data*/
			
			waitElementToBeVisibleSendValue(BASICDATAFLEETNAME_EB,300, jsonData.getJsonData("fleetname"));
			waitElementToBeVisibleSendValue(BASICDATAINFOTEXT_EB,300, jsonData.getJsonData("infotext"));
			elementClick(NEXTSTEP_BT);

					/* For Assigning The Vehicles*/
			
			elementSendKeys(ASSIGNVEHICLESSEARCH_EB, jsonData.getJsonData("vehicle"));
			waitElementVisibleClick(ASSIGNVEHICLELOADER_BT,300);
			elementSendKeys(ASSIGNVEHICLESSEARCH_EB, jsonData.getJsonData("vehicle1"));
			waitElementVisibleClick(ASSIGNVEHICLELOADER_BT,300);
			elementClick(NEXTSTEP_BT);
			
					/* For Creating Fleet*/
			
			elementClick(CREATEFLEET_BT);
					
					/* Verify that Fleet is visible and has the vehicle*/
			
			waitElementVisibleClick(FILTEREXPANDROW_BT,500);
			waitElementToBeVisibleSendValue(FILTERSERACH_EB,300,jsonData.getJsonData("fleetname"));
			String elementtext=elementGetText(FLEETELEMENTLIST_LT);
			compareValue(elementtext, jsonData.getJsonData("fleetnamenew"));
			
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	
	
	
	
}