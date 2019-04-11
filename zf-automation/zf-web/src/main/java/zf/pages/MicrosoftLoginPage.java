package zf.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.EnvironmentManager;
import framework.JsonReader;
import framework.TestLogger;

public class MicrosoftLoginPage extends ElementManager{
	JsonReader jsonData=new JsonReader();
	JsonReader jsonReader=new JsonReader();


	private static By MICROSOFTLOGIN_EMAILUSERNAME_EB         =By.xpath("//input[@type='email']");	
	private static By MICROSOFTLOGIN_EMAILPASSWORD_EB         =By.id("i0118");
	private static By MICROSOFTLOGIN_NEXT_BT                  =By.id("idSIButton9");
	private static By MICROSOFTLOGIN_STAYSIGNIN_BT            =By.xpath("//input[@id='idBtn_Back']");


	public void microsoftLogin(String userName, String password) {
		try {

			elementSendKeys(MICROSOFTLOGIN_EMAILUSERNAME_EB,userName);
			elementClick(MICROSOFTLOGIN_NEXT_BT);
			if(elementDisplayed(MICROSOFTLOGIN_EMAILPASSWORD_EB)) {
				elementSendKeyWithActions(MICROSOFTLOGIN_EMAILPASSWORD_EB,passwordDecript(password));
				waitElementVisibleClick(MICROSOFTLOGIN_NEXT_BT,100);
				elementClick(MICROSOFTLOGIN_STAYSIGNIN_BT);
			}
			sleep(6000);
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void validatePageTitle() {
		JsonReader.getJsonObject("validatePageTitle");
		String title = getTitile();
		compareText(jsonData.getJsonData("GatewayPageTitle"), title);
		TestLogger.appInfo("Page title : "+title);
	}
}

