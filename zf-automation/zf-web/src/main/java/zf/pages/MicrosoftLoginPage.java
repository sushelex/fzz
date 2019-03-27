package zf.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.EnvironmentManager;
import framework.JsonReader;
import framework.TestLogger;

public class MicrosoftLoginPage extends ElementManager{
	JsonReader jsonReader=new JsonReader();
	
	private static By SIGNWITHEMAIL            =By.xpath("//input[@type='email']");
	private static By SIGNWITHPASSWORD         =By.id("i0118");
	private static By NEXTBUTTON               =By.id("idSIButton9");
	private static By STAYSINGINBUTTON         =By.xpath("//input[@id='idBtn_Back']");

	public ZFGatewayHomePage microsoftLogin(String userName, String password) {
		try {
			
			elementSendKeys(SIGNWITHEMAIL,userName);
			elementClick(NEXTBUTTON);
			elementSendKeys(SIGNWITHPASSWORD,passwordDecript(password));
			elementClick(NEXTBUTTON);
			elementClick(STAYSINGINBUTTON);
		
			sleep(6000);
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
		return new ZFGatewayHomePage();
	}
}

