package zf.iris.pages;

import java.util.Random;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class BackofficePage extends ElementManager {
	
	JsonReader jsonData=new JsonReader();
	public String FleetName;

	private static By FLEETS_ICON                                    =By.xpath("//a[@title='Fleets']");
	private static By FLEETS_CREATENEWFLEET_BT                       =By.xpath("//button[@class='button create-btn button-secondary']");
	private static By FLEETS_BASICDATAFLEETNAME_EB                   =By.xpath("//input[@name='newFleetName']");
	private static By FLEETS_BASICDATAINFOTEXT_EB                    =By.xpath("//textarea[@name='newFleetDescription']");
	private static By FLEETS_NEXTSTEP_BT                             =By.xpath("//button[@class='button button-primary ng-binding ng-scope']");
	private static By FLEETS_ASSIGNVEHICLESSEARCH_EB                 =By.xpath("//input[contains(@placeholder,'Search for vehicle of')]");
	private static By FLEETS_ASSIGNVEHICLELOADER_BT                  =By.xpath("//div[@class='drag-item item-available-fleet vehicle-icon ng-scope']//img[@class='change-btn']");
	private static By FLEETS_CREATEFLEET_BT                          =By.xpath("//button[@type='submit']");
	private static By FLEETS_FILTEREXPANDROW_BT                      =By.xpath("//div[@class='toogle-btn is-folded']");
	private static By FLEETS_FILTERSEARCH_EB                         =By.xpath("//input[@placeholder='Search']");
	private static By FLEETS_FLEETELEMENTLIST_LT                     =By.xpath("//span[@class='name ng-binding']");

	private static  By USER_ICON   	 	             				 =By.xpath("//a[@title='Users']");
	private static  By USERS_ADDUSER_BT                			     =By.xpath("//button[@class='button create-btn button-secondary']");
	private static  By USERS_ADDUSER_NAME_EB             		     =By.xpath("(//input[@type='text'])[2]");
	private static  By USERS_ADDUSER_EMAIL_EB    				     =By.xpath("(//input[@type='text'])[4]");
	private static  By USERS_ADDUSER_SURNAME_EB   				     =By.xpath("(//input[@type='text'])[3]");
	private static  By USERS_ADDUSER_USERROLES_EB 					 =By.xpath("//input[@type='search']");
	private static  By USERS_ADDUSER_SAVE_BT     					 =By.xpath("//span[text()='Save']");
	private static  By USERS_ADDUSER_TOASTER_DT  				 	 =By.xpath("//div[@id='toast-container']/div[@ng-repeat='toaster in toasters']");

	private static By USERS_ADDUSER_FILTER_ST  			  			 =By.xpath("//span[@class='filter-label ng-binding']");
	private static By USERS_ADDUSER_SEARCH_EB  			  			 =By.xpath("//input[@class='filter-input ng-pristine ng-untouched ng-valid ng-empty']");
	private static By USERS_ADDUSER_SEARCHFIRSTVALUE_DT  	  		 =By.xpath("(//div[@class='item-content'])[1]");
	private static By USERS_ADDUSER_EDITUSER_BT   		  			 =By.xpath("//button[@class='button button-primary edit-button']");

	private static By VEHICLE_ICON									 =By.xpath("//a[@title='Vehicles']//i[@class='menu-icon om-icon-vehicle-list ng-star-inserted']");
	private static By VEHICLES_SEARCH_EB							 =By.xpath("//input[@placeholder='Search']");
	private static By VEHICLES_FLEET_DB								 =By.xpath("//span[@class='icon dropdown-icon']");
	private static By VEHICLES_DEFAULT_FLEET						 =By.xpath("//a[contains(text(),'Default fleet')]");
	private static By VEHICLES_EDIT_DATA_BT							 =By.xpath("//button[@type='button']");
	private static By VEHICLES_TYPE_LABEL							 =By.xpath("//label[contains(text(),'Vehicle Type')]");
	private static By VEHICLES_TYPE_SELECT							 =By.xpath("//a[contains(text(),'VEHICLE_TYPE_BUS')]");
	private static By VEHICLES_SAVE_CHANGES_BT						 =By.xpath("//span[contains(text(),'Save Changes')]");
	private static By VEHICLES_SAVED_TOASTER_MSG					 =By.xpath("//div[@class='ng-binding ng-scope']");
	private static By VEHICLES_SELECTDEFAULTFLEET_LT				 =By.xpath("//div[@class='item-content']");
	private static By VEHICLES_NAME_TITLE							 =By.xpath("//div[@class='name ng-binding']");
	private static By VEHICLES_OPENMATICS_TITLE_LABLE				 =By.xpath("//span[@class='group-name ng-binding']");


	public void CreateFleetAndAddSomeVehicle()
	{
		JsonReader.getJsonObject("Fleet");
		try {
			waitElementVisibleClick(FLEETS_ICON,600);
			sleep(7000);
			waitElementToBeVisible(VEHICLES_OPENMATICS_TITLE_LABLE,300);
			waitElementVisibleClick(FLEETS_CREATENEWFLEET_BT, 500);

			/*Fleet Basic Data*/
			FleetName=jsonData.getJsonData("fleetname")+generateRandomNumber();
			waitElementToBeVisibleSendValue(FLEETS_BASICDATAFLEETNAME_EB,500, FleetName);
			waitElementToBeVisibleSendValue(FLEETS_BASICDATAINFOTEXT_EB,500, jsonData.getJsonData("infotext"));
			elementClick(FLEETS_NEXTSTEP_BT);

			/* For Assigning The Vehicles*/

			elementSendKeys(FLEETS_ASSIGNVEHICLESSEARCH_EB, jsonData.getJsonData("vehicle"));
			waitElementVisibleClick(FLEETS_ASSIGNVEHICLELOADER_BT,300);
			elementSendKeys(FLEETS_ASSIGNVEHICLESSEARCH_EB, jsonData.getJsonData("vehicle1"));
			waitElementVisibleClick(FLEETS_ASSIGNVEHICLELOADER_BT,300);
			elementClick(FLEETS_NEXTSTEP_BT);

			/* For Creating Fleet*/

			waitElementVisibleClick(FLEETS_CREATEFLEET_BT,500);

			/* Verify that Fleet is visible and has the vehicle*/

			waitElementVisibleClick(FLEETS_FILTEREXPANDROW_BT,500);
			waitElementToBeVisibleSendValue(FLEETS_FILTERSEARCH_EB,600,FleetName);
			String elementtext=waitElementVisibleGetText(FLEETS_FLEETELEMENTLIST_LT,300);
			compareValue(elementtext, jsonData.getJsonData("fleetnamenew"));

		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void BackofficeCreateNewUser()
	{
		JsonReader.getJsonObject("Tc01addUser");
		try {
			waitElementVisibleClick(USER_ICON,600);
			waitElementVisibleClick(USERS_ADDUSER_BT,700);
			waitElementToBeVisibleSendValue(USERS_ADDUSER_NAME_EB,500, jsonData.getJsonData("Name"));
			elementSendKeys(USERS_ADDUSER_EMAIL_EB, jsonData.getJsonData("Email"));
			elementSendKeys(USERS_ADDUSER_SURNAME_EB, jsonData.getJsonData("SureName"));
			elementSendKeys(USERS_ADDUSER_USERROLES_EB, jsonData.getJsonData("Role"));
			elementClick(USERS_ADDUSER_SAVE_BT);

			verifyUserCreated();
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void verifyUserCreated()
	{
		try {
			String Sucessmsg = waitElementVisibleGetText(USERS_ADDUSER_TOASTER_DT,300);
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
			waitElementVisibleClick(USER_ICON,600);
			waitElementVisibleClick(USERS_ADDUSER_FILTER_ST,600);
			waitElementToBeVisibleSendValue(USERS_ADDUSER_SEARCH_EB,300,jsonData.getJsonData("Name"));
			waitElementVisibleClick(USERS_ADDUSER_SEARCHFIRSTVALUE_DT,300);
			waitElementVisibleClick(USERS_ADDUSER_EDITUSER_BT,300);
			elementSendKeys(USERS_ADDUSER_USERROLES_EB, jsonData.getJsonData("EditRole"));
			elementClick(USERS_ADDUSER_SAVE_BT);

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
			waitElementVisibleClick(VEHICLES_FLEET_DB,300);
			waitElementVisibleClick(VEHICLES_DEFAULT_FLEET,300);
			elementSendKeys(VEHICLES_SEARCH_EB, jsonData.getJsonData("Vehicle"));
			elementClick(VEHICLES_SELECTDEFAULTFLEET_LT);
			compareValue(elementGetText(VEHICLES_NAME_TITLE), jsonData.getJsonData("Vehicle"));
			waitElementVisibleClick(VEHICLES_EDIT_DATA_BT,300);
			elementClick(VEHICLES_TYPE_LABEL);
			elementClick(VEHICLES_TYPE_SELECT);
			elementClick(VEHICLES_SAVE_CHANGES_BT);
			verifyToastermessage("VehicleToasterMessage");

		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}

	}
	public void verifyToastermessage(String Jsondata) {
		String toasterText;
		try {
			toasterText = waitElementVisibleGetText(VEHICLES_SAVED_TOASTER_MSG,300);
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