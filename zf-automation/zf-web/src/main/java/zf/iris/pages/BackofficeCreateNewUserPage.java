package zf.iris.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class BackofficeCreateNewUserPage extends ElementManager{
	JsonReader jsonData=new JsonReader();

	private static  By USER_ICON   	 	                 =By.xpath("//a[@title='Users']");
	private static  By ADDUSER_ADDUSER_BT                =By.xpath("//button[@class='button create-btn button-secondary']");
	private static  By ADDUSER_NAME_EB             		 =By.xpath("(//input[@type='text'])[2]");
	private static  By ADDUSER_EMAIL_EB    				 =By.xpath("(//input[@type='text'])[4]");
	private static  By ADDUSER_SURNAME_EB   			 =By.xpath("(//input[@type='text'])[3]");
	private static  By ADDUSER_USERROLES_EB 			 =By.xpath("//input[@type='search']");
	private static  By ADDUSER_SAVE_BT     				 =By.xpath("//span[text()='Save']");
	private static  By ADDUSER_TOASTER_DT  				 =By.xpath("//div[@id='toast-container']/div[@ng-repeat='toaster in toasters']");

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
	
	public void verifyUserCreated() {
		waitForMessage(ADDUSER_TOASTER_DT,10);
		String Sucessmsg = elementGetText(ADDUSER_TOASTER_DT);
		String[] Sucess= Sucessmsg.split("User");
		compareText(jsonData.getJsonData("ToasterMsgSuccess"), Sucess[0].replaceAll("\\s+",""));
		compareText(jsonData.getJsonData("ToasterMsgSuccessCreated"), Sucess[1]);
	}
}