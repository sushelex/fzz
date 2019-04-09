package zf.iris.pages;

import java.util.Random;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class BackofficePage extends ElementManager {
	JsonReader jsonData=new JsonReader();
	public String FleetName;

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

	private static  By USER_ICON   	 	             				 =By.xpath("//a[@title='Users']");
	private static  By ADDUSER_ADDUSER_BT                			 =By.xpath("//button[@class='button create-btn button-secondary']");
	private static  By ADDUSER_NAME_EB             		   			 =By.xpath("(//input[@type='text'])[2]");
	private static  By ADDUSER_EMAIL_EB    							 =By.xpath("(//input[@type='text'])[4]");
	private static  By ADDUSER_SURNAME_EB   						 =By.xpath("(//input[@type='text'])[3]");
	private static  By ADDUSER_USERROLES_EB 						 =By.xpath("//input[@type='search']");
	private static  By ADDUSER_SAVE_BT     							 =By.xpath("//span[text()='Save']");
	private static  By ADDUSER_TOASTER_DT  				 			 =By.xpath("//div[@id='toast-container']/div[@ng-repeat='toaster in toasters']");

	private static By ADDUSER_FILTER_ST  			  				 =By.xpath("//span[@class='filter-label ng-binding']");
	private static By ADDUSER_SEARCH_EB  			  				 =By.xpath("//input[@class='filter-input ng-pristine ng-untouched ng-valid ng-empty']");
	private static By ADDUSER_SEARCHFIRSTVALUE_DT  	  				 =By.xpath("(//div[@class='item-content'])[1]");
	private static By ADDUSER_EDITUSER_BT   		  				 =By.xpath("//button[@class='button button-primary edit-button']");

	private static By VEHICLE_ICON									 = By.xpath("//a[@title='Vehicles']//i[@class='menu-icon om-icon-vehicle-list ng-star-inserted']");
	private static By VEHICLE_SERACH_EB							     = By.xpath("//input[@placeholder='Search']");
	private static By VEHICLE_FLEET_DB								 = By.xpath("//span[@class='icon dropdown-icon']");
	private static By VEHICLE_DEFAULT_FLEET							 = By.xpath("//a[contains(text(),'Default fleet')]");
	private static By VEHICLE_EDIT_DATA_BT							 = By.xpath("//button[@type='button']");
	private static By VEHICLE_TYPE_LABEL							 = By.xpath("//label[contains(text(),'Vehicle Type')]");
	private static By VEHICLE_TYPE_SELECT							 = By.xpath("//a[contains(text(),'VEHICLE_TYPE_BUS')]");
	private static By VEHICLE_SAVE_CHANGES_BT						 = By.xpath("//span[contains(text(),'Save Changes')]");
	private static By VEHICLE_SAVED_TOASTER_MSG						 = By.xpath("//div[@class='ng-binding ng-scope']");
	private static By VEHICLE_SELECT								 = By.xpath("//div[@class='item-content']");
	private static By VEHICLE_NAME_TITLE							 = By.xpath("//div[@class='name ng-binding']");
	private static By OPENMATICS_TITLE_LABLE						 = By.xpath("//span[@class='group-name ng-binding']");


	public void CreateFleetAndAddSomeVehicle()
	{
		JsonReader.getJsonObject("Fleet");
		try {
			waitElementVisibleClick(FLEETTAB_BT,500);
			sleep(5000);
			waitElementToBeVisible(OPENMATICS_TITLE_LABLE,300);
			waitElementVisibleClick(CREATENEWFLEETBUTTON_BT, 300);

			/*Fleet Basic Data*/
			FleetName=jsonData.getJsonData("fleetname")+generateRandomNumber();
			waitElementToBeVisibleSendValue(BASICDATAFLEETNAME_EB,300, FleetName);
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
			waitElementToBeVisibleSendValue(FILTERSERACH_EB,300,FleetName);
			String elementtext=elementGetText(FLEETELEMENTLIST_LT);
			compareValue(elementtext, jsonData.getJsonData("fleetnamenew"));

		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void BackofficeCreateNewUser()
	{
		JsonReader.getJsonObject("Tc01addUser");
		try {
			waitElementVisibleClick(USER_ICON,300);
			waitElementVisibleClick(ADDUSER_ADDUSER_BT,300);
			waitElementToBeVisibleSendValue(ADDUSER_NAME_EB,300, jsonData.getJsonData("Name"));
			elementSendKeys(ADDUSER_EMAIL_EB, jsonData.getJsonData("Email"));
			elementSendKeys(ADDUSER_SURNAME_EB, jsonData.getJsonData("SureName"));
			elementSendKeys(ADDUSER_USERROLES_EB, jsonData.getJsonData("Role"));
			elementClick(ADDUSER_SAVE_BT);

			verifyUserCreated();
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void verifyUserCreated()
	{
		try {
			String Sucessmsg = waitElementVisibleGetText(ADDUSER_TOASTER_DT,300);
			String[] Sucess= Sucessmsg.split("User");
			compareText(jsonData.getJsonData("ToasterMsgSuccess"), Sucess[0].replaceAll("\\s+",""));
			compareText(jsonData.getJsonData("ToasterMsgSuccessCreated"), Sucess[1]);
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void BackofficeEditSomeRole() {
		JsonReader.getJsonObject("Tc02EditUser");
		try {
			waitElementVisibleClick(USER_ICON,300);
			waitElementVisibleClick(ADDUSER_FILTER_ST,300);
			elementSendKeys(ADDUSER_SEARCH_EB, jsonData.getJsonData("Name"));
			elementClick(ADDUSER_SEARCHFIRSTVALUE_DT);
			elementClick(ADDUSER_EDITUSER_BT);
			elementSendKeys(ADDUSER_USERROLES_EB, jsonData.getJsonData("EditRole"));
			elementClick(ADDUSER_SAVE_BT);

		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

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
	public int generateRandomNumber() {
		Random rnd = new Random();
		int randomNum = (int) (rnd.nextInt(9999));
		return randomNum;
	}
}