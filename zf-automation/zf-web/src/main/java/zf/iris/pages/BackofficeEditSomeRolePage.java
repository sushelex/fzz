package zf.iris.pages;

import org.openqa.selenium.By;
import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class BackofficeEditSomeRolePage extends ElementManager{

	JsonReader jsonData=new JsonReader();

	private static By USER_ICON   	 	               =By.xpath("//a[@title='Users']");
	private static By ADDUSER_FILTER_ST  			   =By.xpath("//span[@class='filter-label ng-binding']");
	private static By ADDUSER_SEARCH_EB  			   =By.xpath("//input[@class='filter-input ng-pristine ng-untouched ng-valid ng-empty']");
	private static By ADDUSER_SEARCHFIRSTVALUE_DT  	   =By.xpath("(//div[@class='item-content'])[1]");
	private static By ADDUSER_USERROLES_EB 			   =By.xpath("//input[@type='search']");
	private static By ADDUSER_EDITUSER_BT   		   =By.xpath("//button[@class='button button-primary edit-button']");
	private static By ADDUSER_SAVE_BT     			   =By.xpath("//span[text()='Save']");

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
}