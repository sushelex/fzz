package zf.pages;

import org.openqa.selenium.By;

import framework.ElementManager;
import framework.EnvironmentManager;
import framework.JsonReader;
import framework.TestLogger;

public class MicrosoftLoginPage extends ElementManager{
	JsonReader jsonReader=new JsonReader();


	private static By MICROSOFTLOGINPAGE_EMAILUSERNAME_EB       =By.xpath("//input[@type='email']");	
	private static By MICROSOFTLOGINPAGE_EMAILPASSWORD_EB       =By.id("i0118");
	private static By MICROSOFTLOGINPAGE_NEXT_BT                =By.id("idSIButton9");
	private static By MICROSOFTLOGINPAGE_STAYSIGNIN_BT          =By.xpath("//input[@id='idBtn_Back']");


	public void microsoftLogin(String userName, String password) {
		try {

			elementSendKeys(MICROSOFTLOGINPAGE_EMAILUSERNAME_EB,userName);
			elementClick(MICROSOFTLOGINPAGE_NEXT_BT);
			if(elementDisplayed(MICROSOFTLOGINPAGE_EMAILPASSWORD_EB)) {
				elementSendKeyWithActions(MICROSOFTLOGINPAGE_EMAILPASSWORD_EB,passwordDecript(password));
				waitElementVisibleClick(MICROSOFTLOGINPAGE_NEXT_BT,100);
				elementClick(MICROSOFTLOGINPAGE_STAYSIGNIN_BT);
			}
			sleep(6000);
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
		//	return new ZFGatewayHomePage();
	}
	public void validatePageTitle() {
		String title = getTitile();
		compareText("test", title);
		TestLogger.appInfo("Page title : "+title);
	}
}

