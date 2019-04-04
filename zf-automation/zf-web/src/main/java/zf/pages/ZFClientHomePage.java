package zf.pages;

import org.openqa.selenium.By;
import framework.ElementManager;
import framework.EnvironmentManager;
import framework.JsonReader;
import framework.TestLogger;

public class ZFClientHomePage extends ElementManager{

	ZFAddClientPage AddSub = new ZFAddClientPage();
	JsonReader jsonData=new JsonReader();

	private static By MANAGECLIENTHEADER          =By.xpath("//div[@class='manage-client-header fw']/div[@class='fl title']");
	private static By CLIENTDETAILEXPANDARROW     =By.xpath("(//div[@class='client-table-row-wrapper']/div[contains(@class,'client-table-row')]/div[contains(@class,'row no-gutter')]/div[contains(@class,'width-4')]/div/span[contains(@class,'arrow')])[1]");
	private static By ADDSUBCLIENTBUTTON          =By.xpath("//div[@class='fw table-row-additioanl-details open']/descendant::span[contains(text(),'Add Sub-Client')]/parent::button");
	private static By MOREDETAILS_BT			  =By.xpath("//div[@class='fw table-row-additioanl-details open']/descendant::span[contains(text(),'More Details')]/parent::button");
	private static By CLIENTS_BT			      =By.xpath("//a[@title='Clients']");
	private static By CLIENTROWGENERIC			  =By.xpath("//div[@class='client-table-row-wrapper']/div[contains(@class,'client-table-row')]");
	private static By CLIENT				      = By.xpath("//div[@class='title-client']");
	private static By AREA					 	  = By.xpath("//div[contains(text(),'Area')]");
	private static By COUNTRY				 	  = By.xpath("//div[contains(text(),'Country')]");
	private static By TELEPHONE					  = By.xpath("//div[contains(text(),'Telephone')]");
	private static By CREATEDDATETIME	  	      = By.xpath("//div[contains(text(),'Created Date & Time')]");
	private static By CLIENTSTATUS  	  		  = By.xpath("//div[contains(text(),'Client Status')]");
	private static By CLIENTNAME				  = By.xpath("(//more-details-popup/descendant::div[@class='content-wrapper']/div[@class='content']/p)[1]");
	private static By CLIENTEMAIL				  = By.xpath("(//more-details-popup/descendant::div[@class='content-wrapper']/div[@class='content']/p)[2]");
	private static By CLIENTTELEPHONE			  = By.xpath("(//more-details-popup/descendant::div[@class='content-wrapper']/div[@class='content']/p)[3]");
	private static By CLIENTSTREET				  = By.xpath("(//more-details-popup/descendant::div[@class='content-wrapper']/div[@class='content']/p)[4]");
	private static By CLIENTSTREETNUMBER		  = By.xpath("(//more-details-popup/descendant::div[@class='content-wrapper']/div[@class='content']/p)[5]");
	private static By CLIENTCOUNTRY				  = By.xpath("(//more-details-popup/descendant::div[@class='content-wrapper']/div[@class='content']/p)[6]");
	private static By CLIENTFAX				 	  = By.xpath("(//more-details-popup/descendant::div[@class='content-wrapper']/div[@class='content']/p)[7]");
	private static By CLIENTWEBSITE				  = By.xpath("(//more-details-popup/descendant::div[@class='content-wrapper']/div[@class='content']/p)[8]");
	private static By CANCEL_BT				      = By.xpath("//button[@class='but2 secondary-type2']");

	private static By ZFLOGO					  = By.xpath("//div[@class='zf-logo']");
	private static By ZFPAGEHEADER				  = By.xpath("//span[text()='ZF IoT Platform']");
	private static By ZFUSERIMAGE				  = By.xpath("//div[contains(@class,'user-picture')]");
	private static By ZFUSEREMAIL				  = By.xpath("//div[contains(@class,'user-name')]");
	private static By ZFNOTIFICATIONICON		  = By.xpath("//i[contains(@class,'notification-icon')]");
	private static By EDITCLIENT_BT				  = By.xpath("//span[contains(text(),'Edit Client')]");
	private static By CONTACTDETAILS_LABEL		  = By.xpath("//div[contains(text(),'Contact details')]");
	private static By ADDRESS_LABEL				  = By.xpath("//div[contains(text(),'Address')]");
	private static By OTHER_LABEL				  = By.xpath("//div[contains(text(),'Other')]");
	private static By CONTACTDETAILSBOX			  = By.xpath("(//div[@class='fw table-row-additioanl-details open']/descendant::div[@class='details-box-title' and contains(text(),'Contact details')]/parent::div/div[@class='details-box'])");
	private static By ADDRESSBOX				  = By.xpath("(//div[@class='fw table-row-additioanl-details open']/descendant::div[@class='details-box-title' and contains(text(),'Address')]/parent::div/div[@class='details-box'])");
	private static By OTHERBOX					  = By.xpath("(//div[@class='fw table-row-additioanl-details open']/descendant::div[@class='details-box-title' and contains(text(),'Other')]/parent::div/div[@class='details-box'])");




	public void addSubClientWithMandatoryDetails()
	{
		navigateToClientPage();
		AddSub.addClientWithMandatoryInputs();
	}
	public void AddSubClient() throws InterruptedException {
		navigateToClientPage();
		AddSub.addSubClient();
	}

	public void manageCleitntsStaticValidation()
	{
		//			waitElementVisibleClick(MANAGECLIENTS_HEADER_ST, 300);
		JsonReader.getJsonObject("ManageClientHeader");
		try {
			waitElementVisibleClick(CLIENTS_BT, 300);

			jsonData.getJsonData("title").equals(elementGetText(MANAGECLIENTHEADER));
			sleep(5000);
			if(elementCount(CLIENTROWGENERIC)>0)
			{
				//				elementAvailability(CLIENT); // TODO Replace the new element availability function
				//				elementAvailability(COUNTRY);
				//				elementAvailability(AREA);
				//				elementAvailability(TELEPHONE);
				//				elementAvailability(CREATEDDATETIME);
				//				elementAvailability(CLIENTSTATUS);
				compareText(elementGetText(CLIENT),jsonData.getJsonData("Client"));
				compareText(elementGetText(AREA),jsonData.getJsonData("Area"));
				compareText(elementGetText(COUNTRY),jsonData.getJsonData("Country"));
				compareText(elementGetText(TELEPHONE),jsonData.getJsonData("Telephone"));
				compareText(elementGetText(CREATEDDATETIME),jsonData.getJsonData("CreatedDateTime"));
				compareText(elementGetText(CLIENTSTATUS),jsonData.getJsonData("ClientStatus"));
			}
		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void clientMoreDetailsStaticValidation()
	{
		JsonReader.getJsonObject("ClientMoreDetails");
		try {
			waitElementVisibleClick(CLIENTS_BT, 300);
			waitElementVisibleClick(CLIENTDETAILEXPANDARROW, 300);
			waitElementVisibleClick(MOREDETAILS_BT, 300);
			compareText(elementGetText(CLIENTNAME), jsonData.getJsonData("clientName"));
			compareText(elementGetText(CLIENTEMAIL), jsonData.getJsonData("email"));
		//	compareText(elementGetText(CLIENTTELEPHONE), jsonData.getJsonData("telephone"));
			compareText(elementGetText(CLIENTSTREET), jsonData.getJsonData("street"));
			compareText(elementGetText(CLIENTSTREETNUMBER), jsonData.getJsonData("streetNumber"));
			compareText(elementGetText(CLIENTCOUNTRY), jsonData.getJsonData("country"));
			compareText(elementGetText(CLIENTFAX), jsonData.getJsonData("fax"));
			compareText(elementGetText(CLIENTWEBSITE), jsonData.getJsonData("WebSite"));
			waitElementVisibleClick(CANCEL_BT, 300);
		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}


	public void verifyAdminUserAbleToViewClientManagementPage()
	{
		JsonReader.getJsonObject("ManageClientHeader");
		try {
			waitElementVisibleClick(CLIENTS_BT, 300);
			elementAvailability(ZFLOGO);
			elementAvailability(ZFPAGEHEADER);
			elementAvailability(ZFUSERIMAGE);
			compareText(elementGetText(ZFUSEREMAIL),EnvironmentManager.getAdminUserName());
			elementAvailability(ZFNOTIFICATIONICON);
			jsonData.getJsonData("title").equals(elementGetText(MANAGECLIENTHEADER));
		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}


	public void  verifyUserInterfaceOfClientDetailsInManageClientpage()
	{
		JsonReader.getJsonObject("ManageClientHeader");

		try {
			waitElementVisibleClick(CLIENTS_BT, 300);
			waitElementVisibleClick(CLIENTDETAILEXPANDARROW, 300);
			elementAvailability(ADDSUBCLIENTBUTTON);
			elementAvailability(EDITCLIENT_BT);
			elementAvailability(MOREDETAILS_BT);
			compareText(elementGetText(CONTACTDETAILS_LABEL), jsonData.getJsonData("Contactdetails"));
			compareText(elementGetText(ADDRESS_LABEL), jsonData.getJsonData("Address"));
			compareText(elementGetText(OTHER_LABEL), jsonData.getJsonData("Other"));
			elementAvailability(CONTACTDETAILSBOX);
			elementAvailability(ADDRESSBOX);
			elementAvailability(OTHERBOX);

		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	
	public void verifyCreateNewSubClientValidation()
	{
		navigateToClientPage();
		AddSub.createNewSubClientNameValidation();
	}

	public void verifyCreateNewSubClientEmailValidation()
	{
		navigateToClientPage();
		AddSub.createNewSubClientEmailValidation();
	}

	
	public void verifyCreateNewSubClientWithWrongTelephoneFormat()
	{
		navigateToClientPage();
		AddSub.CreateNewSubClientWithWrongTelephoneFormat();
	}
	public void navigateToClientPage() {
		try {
			waitElementVisibleClick(CLIENTS_BT, 300);
			sleep(3000);
			waitElementVisibleClick(CLIENTDETAILEXPANDARROW, 300);
			waitElementVisibleClick(ADDSUBCLIENTBUTTON, 300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}