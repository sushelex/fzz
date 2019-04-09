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
	private static By STAYSINGINBUTTON         =By.xpath("//input[@id='idBtn_Back");


	public void microsoftLogin(String userName, String password) {
		try {

			elementSendKeys(SIGNWITHEMAIL,userName);
			elementClick(NEXTBUTTON);
			if(elementDisplayed(SIGNWITHPASSWORD)) {
				elementSendKeyWithActions(SIGNWITHPASSWORD,passwordDecript(password));
				waitElementVisibleClick(NEXTBUTTON,100);
				elementClick(STAYSINGINBUTTON);
			}
			sleep(6000);
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
		//	return new ZFGatewayHomePage();
	}
	public void validatePageTitle() {
		String titile = getTitile();
		TestLogger.appInfo("Page title : "+titile);
	}
}

