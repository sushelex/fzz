package zf.pages;
import org.openqa.selenium.By;
import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class ZFAddClientPage extends ElementManager {

	JsonReader jsonData=new JsonReader();

	String COMMONXPATH										= "//input[@name='{}']";
	private static By CONTINUEBUTTONCLIENTDETAILSSECTION_BT = By.xpath("//div[@class='tab1-content']//span[contains(text(),'Continue')]");
	private static By INVITEBUTTON_BT						= By.xpath("//div[@role='dialog']/descendant::div[@class='tab2-content']/descendant::button[contains(text(),'Invite')]");
	private static By CONTINUEBUTTONASSIGNADMIN_BT			= By.xpath("//div[@class='tab2-content']//span[contains(text(),'Continue')]");
	private static By EMAILINPUTASSIGNADMIN_EB 				= By.xpath("//input[@placeholder='Enter E-mail ID']");
	private static By CREATEBUTTONPREVIEWSECTION_BT 		= By.xpath("//div[@role='dialog']/descendant::div[@class='tab3-content']/descendant::button/descendant::span[contains(text(),'Create')]");
	private static By PREVIEWCLIENTNAME						= By.xpath("//p[@class='bold-text']");
	private static By PREVIEWCLIENTEMAIL					= By.xpath("(//div[@class='content-wrapper'])[1]/div[@class='content']/p[2]");
	private static By PREVIEWCLIENTTELEPHONE				= By.xpath("(//div[@class='content-wrapper'])[1]/div[@class='content']/p[3]");
	private static By PREVIEWCLIENTSTREETNUMBER				= By.xpath("(//div[@class='content-wrapper'])[2]/div[@class='content']/p[1]");
	private static By PREVIEWCLIENTSTREET					= By.xpath("(//div[@class='content-wrapper'])[2]/div[@class='content']/p[2]");
	private static By PREVIEWCLIENTCOUNTRY					= By.xpath("(//div[@class='content-wrapper'])[2]/div[@class='content']/p[3]");
	private static By PREVIEWCLIENTPOSTCODE					= By.xpath("(//div[@class='content-wrapper'])[2]/div[@class='content']/p[4]");
	private static By CREATECLIENTCREATETOASTER				= By.xpath("//div[text()='Unauthorized user']");
	private static By ADDSUBCLIENT_CLIENTNAME_EB			= By.xpath("//input[@name='clientName']");
	private static By ADDSUBCLIENT_CLIENTEMAIL_EB			= By.xpath("//input[@name='clientEmail']");
	private static By ADDSUBCLIENT_CLIENTSTREET_EB			= By.xpath("//input[@name='clientStreet']");
	private static By ADDSUBCLIENT_CLIENTSTREETNUMBER_EB	= By.xpath("//input[@name='clientStreetNumber']");
	private static By ADDSUBCLIENT_CLIENTTELEPHONE_EB		= By.xpath("//input[@name='telephone']");
	private static By ADDSUBCLIENT_CLIENTINFORMATION_EB		= By.xpath("//*[@id='clientFurtherInfo']");
	private static By ADDSUBCLIENT_CLIENTPOSTCODE_EB		= By.xpath("//input[@name='clientPostcode']");
	private static By ADDSUBCLIENT_CLIENTWEBSITE_EB			= By.xpath("//input[@name='website']");
	private static By ADDSUBCLIENT_CLIENTCOUNTRY_EB			= By.xpath("//input[@name='clientCountry']");
	private static By ADDSUBCLIENT_CLIENTFAX_EB				= By.xpath("//input[@name='fax']");

	private static By CLIENT_NAME_ERROR_MSG_LT				= By.xpath("//div[contains(@class,'client-name-wrapper')]/descendant::span[contains(@class,'error')]");
	private static By ADDSUBCLIENT_CANCEL_BT				= By.xpath("//span[contains(text(),'Cancel')]");
	private static By CLIENT_EMAIL_ERROR_MSG_LT 			= By.xpath("//div[contains(@class,'email-wrapper')]/descendant::span[contains(@class,'error')]");



	public void addSubClient()
	{
		try {
			JsonReader.getJsonObject("ClientDetails");
			waitElementToBeVisibleSendValue(ADDSUBCLIENT_CLIENTNAME_EB,300,jsonData.getJsonData("clientName"));
			elementSendKeys(ADDSUBCLIENT_CLIENTEMAIL_EB,jsonData.getJsonData("email"));
			elementSendKeys(ADDSUBCLIENT_CLIENTSTREET_EB,jsonData.getJsonData("street"));
			elementSendKeys(ADDSUBCLIENT_CLIENTSTREETNUMBER_EB,jsonData.getJsonData("streetNumber"));
			elementSendKeys(ADDSUBCLIENT_CLIENTTELEPHONE_EB,jsonData.getJsonData("telephone"));
			elementSendKeys(ADDSUBCLIENT_CLIENTINFORMATION_EB,jsonData.getJsonData("information"));
			elementSendKeys(ADDSUBCLIENT_CLIENTPOSTCODE_EB,jsonData.getJsonData("postCode"));
			elementSendKeys(ADDSUBCLIENT_CLIENTWEBSITE_EB,jsonData.getJsonData("webSite"));
			elementSendKeys(ADDSUBCLIENT_CLIENTCOUNTRY_EB,jsonData.getJsonData("country"));
			elementSendKeys(ADDSUBCLIENT_CLIENTFAX_EB,jsonData.getJsonData("fax"));
			elementClick(CONTINUEBUTTONCLIENTDETAILSSECTION_BT);
			waitElementToBeVisibleSendValue(EMAILINPUTASSIGNADMIN_EB, 300, jsonData.getJsonData("email"));
			elementClick(INVITEBUTTON_BT);
			elementClick(CONTINUEBUTTONASSIGNADMIN_BT);
			compareText(elementGetText(PREVIEWCLIENTNAME), jsonData.getJsonData("clientName"));
			compareText(elementGetText(PREVIEWCLIENTEMAIL), jsonData.getJsonData("email"));
			compareText(elementGetText(PREVIEWCLIENTSTREETNUMBER), jsonData.getJsonData("streetNumber"));
			compareText(elementGetText(PREVIEWCLIENTSTREET), jsonData.getJsonData("street"));
			compareText(elementGetText(PREVIEWCLIENTCOUNTRY), jsonData.getJsonData("country"));
			compareText(elementGetText(PREVIEWCLIENTPOSTCODE), jsonData.getJsonData("postCode"));
			elementClick(CREATEBUTTONPREVIEWSECTION_BT);
			verifyToastermessage(jsonData.getJsonData("ToasterMsg"));
		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}

	public void addClientWithMandatoryInputs()
	{
		try {
			JsonReader.getJsonObject("ClientDetails");
			waitElementToBeVisibleSendValue(ADDSUBCLIENT_CLIENTNAME_EB,300,jsonData.getJsonData("clientName"));
			elementClick(CONTINUEBUTTONCLIENTDETAILSSECTION_BT);
			waitElementToBeVisibleSendValue(EMAILINPUTASSIGNADMIN_EB, 300, jsonData.getJsonData("email"));
			elementClick(INVITEBUTTON_BT);
			elementClick(CONTINUEBUTTONASSIGNADMIN_BT);
			compareText(elementGetText(PREVIEWCLIENTNAME), jsonData.getJsonData("clientName"));
			elementClick(CREATEBUTTONPREVIEWSECTION_BT);
			verifyToastermessage(jsonData.getJsonData("ToasterMsg"));
		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void createNewSubClientNameValidation()
	{
		JsonReader.getJsonObject("ClientDetails");
		try {
			elementSendKeys(ADDSUBCLIENT_CLIENTNAME_EB, jsonData.getJsonData("clientNameEmpty"));
			compareText(elementGetText(CLIENT_NAME_ERROR_MSG_LT), jsonData.getJsonData("clientNameErrorMsg"));
			elementSendKeys(ADDSUBCLIENT_CLIENTNAME_EB,jsonData.getJsonData("clientNameSpecialChar"));
			compareText(elementGetText(CLIENT_NAME_ERROR_MSG_LT), jsonData.getJsonData("clientNameErrorMsg"));
			elementSendKeys(ADDSUBCLIENT_CLIENTNAME_EB,jsonData.getJsonData("clientNameWithAbove32Char"));
			elementClick(ADDSUBCLIENT_CANCEL_BT);
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void createNewSubClientEmailValidation()
	{
		JsonReader.getJsonObject("ClientDetails");
		elementSendKeys(ADDSUBCLIENT_CLIENTEMAIL_EB,jsonData.getJsonData("clientEmptyEmail"));
		compareText(elementGetText(CLIENT_EMAIL_ERROR_MSG_LT), jsonData.getJsonData("clientEmailErrorMsg"));
		elementSendKeys(ADDSUBCLIENT_CLIENTEMAIL_EB,jsonData.getJsonData("clientInvalidEmail"));
		compareText(elementGetText(CLIENT_EMAIL_ERROR_MSG_LT), jsonData.getJsonData("clientEmailErrorMsg"));
		elementClick(ADDSUBCLIENT_CANCEL_BT);
	}

	public void CreateNewSubClientWithWrongTelephoneFormat()
	{
		JsonReader.getJsonObject("ClientDetails");
		elementSendKeys(ADDSUBCLIENT_CLIENTTELEPHONE_EB,jsonData.getJsonData("clientTelephoneEmpty"));
		compareText(elementGetText(ADDSUBCLIENT_CLIENTTELEPHONE_EB), jsonData.getJsonData("clientTelephoneEmpty"));
		elementSendKeys(ADDSUBCLIENT_CLIENTTELEPHONE_EB,jsonData.getJsonData("clientTelephoneSpecialChar"));
		compareText(elementGetText(ADDSUBCLIENT_CLIENTTELEPHONE_EB), jsonData.getJsonData("clientTelephoneEmpty"));
		elementClick(ADDSUBCLIENT_CANCEL_BT);
	}

	public void verifyToastermessage(String Jsondata) {
		try {
			String toasterText = waitElementVisibleGetText(CREATECLIENTCREATETOASTER,300);
			compareText(jsonData.getJsonData(Jsondata),toasterText);
		} catch (InterruptedException e) {

			TestLogger.appInfo(e.getMessage());
		}
	}
}