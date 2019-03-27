package zf.pages;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.ElementManager;
import framework.JsonReader;
import framework.TestLogger;

public class ZFGatewayHomePage extends ElementManager{

	JsonReader jsonData=new JsonReader();
	private static By GATEWAY_ADDGATEWAY_BT                         =By.xpath("//button[contains(text(),'Add Gateway')]");
	private static By GATEWAY_ICON                                  =By.xpath("//a[@title='Gateway']");
	private static By GATEWAY_TOASTER_MSG		   	            	=By.xpath("//div[@class='toast-title']");
	private static By GATEWAY_TOASTER_MSG_TXT		        	=By.xpath("//div[@class='ng-star-inserted']");
	private static By GATEWAY_SEARCH_EB		                	=By.xpath("//input[@class='fh fl ng-untouched ng-pristine ng-valid']");
	private static By GATEWAY_SEARCH_ICON		            	=By.xpath("//div[@class='search-icon sprite']");
	private static By GATEWAY_TABLE		                    	=By.xpath("//div[@class='gateway-dtls-table zf-table fw ng-star-inserted']");
	private static By GATEWAY_TABLE_MOREINFO_DD                	=By.xpath("(//div[@class='main-details fw'])[1]/div[@class='fl fh col-heading cell ellipses more']");
	private static By GATEWAY_ENABLE_BT                     	=By.xpath("//button[@class='zf-button fl enable ng-star-inserted']");
	private static By GATEWAY_DISABLE_BT                    	=By.xpath("//button[@class='zf-button fl disable ng-star-inserted']");
	private static By GATEWAY_STATUS_CM                     	=By.xpath("//div[@class='fl fh col-heading cell ellipses status']");
	private static By GATEWAYGENERICROW		                    =By.xpath("//div[@class='fw gateway ng-star-inserted']");
	private static By GATEWAY_SEARCH_DD                    =By.xpath("//label[contains(@class,'ui-multiselect-label ui-corner-all')]");
	private static By GATEWAYSEARCH_BT		                    =By.xpath("//div[contains(@class,'search-icon sprite')]");
	private static By GATEWAYSEARCHSELECTIONCHECK               =By.xpath("//div[@class='ng-tns-c14-4 ui-multiselect ui-widget ui-state-default ui-corner-all']//div[@title='Commissioned']");
	private static By GATEWAYMOREINFO	                    	=By.xpath("//div[contains(@class,'expander sprite')]");
	private static By GATEWAYNAME			                    =By.xpath("(//div[@class='fl fh col-heading cell ellipses gatewayName']//span[1])");
	private static By GATEWATMANAGESOFTWARE_BT	                =By.xpath("//button[contains(text(),'Manage Software')]");
	private static By GATEWAYMANAGESOFTWARENAME                 =By.xpath("//div[@class='gateway-name fl ']//span[1]");
	private static By GATEWAY_PRECOMMISION_CB	                    =By.xpath("//label[@class='ng-tns-c14-4 ng-star-inserted'][(text()='Pre-Commissioned')]");
	private static By GATEWAY_COMMISION_CB	                    =By.xpath("//label[@class='ng-tns-c14-4 ng-star-inserted'][(text()='Commissioned')]");
	private static By GATEWAY_DECOMMISION_CB	                    =By.xpath("//label[@class='ng-tns-c14-4 ng-star-inserted'][(text()='Decommissioned')]");
	private static By GATEWAYEDIT_BT		                    =By.xpath("//div[@class='expanded-details-wrapper fw open']//button[@type='button'][contains(text(),'Edit')]");
	private static By GATEWAYOPERATORTOASTMESSAGE               =By.xpath("//div[@class='ng-star-inserted']");
	private static By GATEWAYOPERATORDISABLE_BT	                =By.xpath("//div[@class='expanded-details-wrapper fw open']//button[@type='button'][contains(text(),'Disable')]");
	private static By GATEWAYOPERATORDECOMISSION_BT             =By.xpath("//div[@class='expanded-details-wrapper fw open']//button[@type='button'][contains(text(),'Decommission')]");
	private static By GATEWAY_NOGATEWAY_TXT                     =By.xpath("//div[text()=' No gateways. ']");
	private static By GATEWAYADDSOFTWARE_BT				       =By.xpath("//button[@type='button']");
	private static By GATEWAYINSTALLEDSOTWARELIST 		=By.xpath("//div[contains(@class,'software-details-table')]");
	private static By LABELSOFTWARENAME					=By.xpath("(//span[@class='fw'][contains(text(),'Software Name')])");
	private static By LABELVERSION						=By.xpath("(//span[@class='fw'][contains(text(),'Version')])");
	private static By LABELUPLOADPACKAGE				=By.xpath("(//span[@class='fw'][contains(text(),'Upload Package')])");
	private static By LABELSCHEDULEDINSTALLATION		=By.xpath("//span[contains(text(),'Schedule Installation')]");
	private static By GATEWAYDETAILS_LABEL				=By.xpath("//div[@class='expanded-details-wrapper fw open']//span[contains(text(),'Gateway Details')]");
	private static By GATEWAYDETAILS_MODEL_LABEL		=By.xpath("(//div[@class='expanded-details-wrapper fw open']//label[contains(text(),'Model')])");
	private static By GATEWAYDETAILS_MACID_LABEL		=By.xpath("//div[@class='expanded-details-wrapper fw open']//label[contains(text(),'MAC ID')]");
	private static By GATEWAYDETAILS_SIMNUMBER_LABEL	=By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//label[contains(text(),'Sim Number')])");
	private static By GATEWAYDETAILS_SERIALNUMBER_LABEL	=By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//label[contains(text(),'Serial Number')])");
	private static By GATEWAYDETAILS_CERTIFICATE_LABEL		=By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//label[contains(text(),'Gateway Certificate')])");
	private static By GATEWAYDETAILS_ENROLLMENTGROUP_LABEL	=By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//label[contains(text(),'Enrollment Group')])");
	private static By CUSTOMERDETAILS_LABEL					=By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//span[contains(text(),'Customer Details')])");
	private static By CUSTOMERDETAILS_BUSINESSUNIT_LABEL	=By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//label[contains(text(),'Business Unit')])");
	private static By CUSTOMERDETAILS_OPERATOR_LABEL		=By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//label[contains(text(),'Operator')])");
	private static By ADDITIONALDETAILS_LABEL				=By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//span[contains(text(),'Additional Details')])");
	private static By ADDITIONALDETAILS_DESCRIPTION_LABEL	=By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//label[contains(text(),'Description')])");
	private static By ADDITIONALDETAILS_METADATA_LABEL		         =By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//label[contains(text(),'Metadata')])");
	private static By GATEWAYLIFECYCLE_LABEL				               =By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//span[contains(text(),'Gateway Lifecycle')])");
	private static By GATEWAYLIFECYCLE_PRECOMMISSIONED_LABEL                =By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//span[contains(text(),'Pre-Commissioned')])");
	private static By GATEWAYLIFECYCLE_COMMISSIONED_LABEL	                =By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//div[contains(@class,'fl fh status commissioned completed')]//div[contains(@class,'status-name')])");
	private static By GATEWAYLIFECYCLE_DECOMMISSIONED_LABEL             	=By.xpath("(//div[contains(@class,'expanded-details-wrapper fw open')]//span[contains(text(),'Decommissioned')])");

	private static  By ADDSINGLEGATWAY_GATEWAYNAME_EB						=By.xpath("//input[@name='gatewayName']");
	private static  By ADDSINGLEGATWAY_TYPE_DD								=By.xpath("//p-dropdown[@optionlabel='gatewayType']");
	private static  By ADDSINGLEGATWAY_MODEL_DD								=By.xpath("//p-dropdown[@optionlabel='gatewayModel']");
	private static  By ADDSINGLEGATWAY_MACID_EB								=By.xpath("//input[@name='gatewayMacId']");
	private static  By ADDSINGLEGATWAYSERIALNUMBER_EB						=By.xpath("//input[@name='gatewaysNo']");
	private static  By ADDSINGLEGATWAY_SIMNUMBER_EB							=By.xpath("//input[@name='gatewaysimNo']");
	private static  By ADDSINGLEGATWAY_UPLOADGATEWAYCERTIFICATE				=By.id("file-input");
	private static  By ADDSINGLEGATWAY_NEXT_BT								=By.xpath("//button[@class='zf-button next fr primary ng-star-inserted' and text()='Next']");
	private static  By ADDSINGLEGATWAY_CUSTOMERNAME_ED						=By.xpath("//input[@name='customer']");
	private static  By ADDSINGLEGATWAY_CUSTOMERCOUNTRY_DD					=By.xpath("//p-dropdown[@name='selectCountry']");
	private static  By ADDSINGLEGATWAY_CUSTOMERAREA_DD						=By.xpath("//p-dropdown[@name='selectedCity']");
	private static  By ADDSINGLEGATWAY_BUSINESSUNIT_EB						=By.xpath("//input[@name='businessLine']");
	private static  By ADDSINGLEGATWAY_OPERATOR_EB							=By.xpath("//input[@name='operator']");
	private static  By ADDSINGLEGATWAY_CUSTOMERDETAIL_NEXT_BT				=By.xpath("//button[@class='zf-button next fr primary' and text()='Next']");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_DESCRIPTION_EB		=By.xpath("//textarea[@name='description']");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_ICON		=By.xpath("//div[@class='add-icon']");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_KEY_EB1    =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[1]/td[1]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_VALUE_EB1  =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[1]/td[2]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_KEY_EB2    =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[2]/td[1]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_VALUE_EB2  =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[2]/td[2]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_KEY_EB3    =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[3]/td[1]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_VALUE_EB3  =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[3]/td[2]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_KEY_EB4    =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[4]/td[1]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_VALUE_EB4  =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[4]/td[2]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_KEY_EB5    =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[5]/td[1]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_VALUE_EB5  =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[5]/td[2]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_KEY_EB6    =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[6]/td[1]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_VALUE_EB6  =By.xpath("//single-gateway-details/div/form[3]/div[1]/div[2]/table/tbody/tr[6]/td[2]/input");
	private static  By ADDSINGLEGATWAY_ADDITIONALDETAIL_FINISH_BT			=By.xpath("//button[text()='Finish']");
	private static  By ADDSINGLEGATWAY_TOASTER_DT							=By.xpath("//div[@class='toast-title']");
	private static String TYPEDROPDOWNLIST									="//span[text()='{}']";
	private static By SHOW_GATEWAY_PRECOMM									=By.xpath("//li[1]/label[contains(text(),'Pre-Commissioned')]");
	private static By SHOW_GATEWAY_COMM										=By.xpath("//li[2]/label[contains(text(),'Commissioned')]");
	private static By SHOW_GATEWAY_DECOMM									=By.xpath("//li[3]/label[contains(text(),'Decommissioned')]");
	private static By SHOW_ALL												=By.xpath("//app-gateways-list/div/div[1]/div[3]/div[3]/p-multiselect/div/div[4]/div[1]/div[1]/div[2]");
	private static By STATUS_COMM    										=By.xpath("//app-gateways-list/div/div[2]/div[2]/div[2]/div[1]/div[1]/div[7]/span");
	private static By VERIFY_GATEWAY_CATAGORIES    							=By.xpath("//app-gateways-list/div/div[1]/div[3]/div[3]/p-multiselect/div/div[2]/label");
	private static By STATUS_C0LUMN											=By.xpath("//span[contains(text(),'Status')]");
	private static By SORT_GATEWAY											=By.xpath("//li[1]/span[contains(text(),'Gateway')]");
	private static By SORT_CUSTOMER											=By.xpath("//li[2]/span[contains(text(),'Customer')]");
	private static By SORT_TYPE												=By.xpath("//li[3]/span[contains(text(),'Type')]");
	private static By SORT_COUNTRY											=By.xpath("//li[4]/span[contains(text(),'Country')]");
	private static By SORT_AREA												=By.xpath("//li[5]/span[contains(text(),'Area')]");
	private static By SORT_STATUS											=By.xpath("//li[6]/span[contains(text(),'Status')]");
	private static String COLUMN_GATEWAY_NAME								="//app-gateways-list/div/div[2]/div[2]/div[1]/div/span[contains(text(), 'Gateway N')]";
	private static String COLUMN_CUSTOMER									="//app-gateways-list/div/div[2]/div[2]/div[1]/div/span[contains(text(), 'Customer')]";
	private static String COLUMN_TYPE										="//app-gateways-list/div/div[2]/div[2]/div[1]/div/span[contains(text(), 'Type')]";
	private static String COLUMN_COUNTRY									="//app-gateways-list/div/div[2]/div[2]/div[1]/div/span[contains(text(), 'Country')]";
	private static String COLUMN_AREA										="//app-gateways-list/div/div[2]/div[2]/div[1]/div/span[contains(text(), 'Area')]";
	private static String COLUMN_LAST_UPDATED								="//app-gateways-list/div/div[2]/div[2]/div[1]/div/span[contains(text(), 'Last Updated')]";
	private static String COLUMN_STATUS										="//app-gateways-list/div/div[2]/div[2]/div[1]/div/span[contains(text(), 'Status')]";
	private static String COLUMN_CONNECTIVITY								="//app-gateways-list/div/div[2]/div[2]/div[1]/div/span[contains(text(), 'Connectivity')]";
	private static String COLUMN_MORE_INFO									="//app-gateways-list/div/div[2]/div[2]/div[1]/div/span[contains(text(), 'More Info')]";
	private static By GATEWAY_ALL_COLUMN									=By.xpath("//app-gateways-list/div/div[2]/div[2]/div[1]/div/span");
	private  static By MORE_INFO			                                =By.xpath("(//div[@class='main-details fw'])[1]/div[@class='fl fh col-heading cell ellipses more']");
	private  static By EDIT_GATEWAY			                                =By.xpath("//app-gateways-list/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[5]/button[3]");
	private  static By GATEWAY_DROPDOWN		                                =By.xpath("//div/div[1]/div[3]/div[3]/p-multiselect/div/div[3]");
	private  static By GATEWAY_CATERGORY_DD	                                =By.xpath("//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']");
	private  static By GATEWAY_GATEWAYNAMESORT_ICON	                         =By.xpath("(//div[@class='sort-icon-wrap fl'])[1]");
	private  static By GATEWAY_GATEWAYNAMESORTED_LT	                         =By.xpath("//div[@class='main-details fw']/div[1]");
	private static By ADDSOFTWARE_SOFTWARENAME_EB							=By.xpath("//input[@name='newSoftwareSoftwareName']");
	private static By ADDSOFTWARE_UPLOADPACKAGE_EB							=By.xpath("//input[@name='newSoftwareFileName']");
	private static By ADDSOFTWARE_UPLOADICON_BT								=By.xpath("//div[@class='upload-icon']");
	private static By ADDSOFTWARE_UPLOADINSTALL_BT							=By.xpath("//button[@class='schedule-button fl zf-button']");
	private static By ADDSOFTWARE_TOASTER									=By.xpath("//div[contains(text(),'is blank')]");
	private static By ADDSOFTWARE_UPLOADPACKAGE_BOX							=By.xpath("//input[@name='newSoftwareFileName']");
	private static By GATEWAY_STATUS_DD			                   			=By.xpath("//label[@class='ui-multiselect-label ui-corner-all']");
	private static By GATEWAYMANAGESOFTWARE_BT	               				=By.xpath("//button[contains(text(),'Manage Software')]");
	private static By CLICK_ON_SEARCH_BUTTON			   					=By.xpath("//gateway/app-gateways-list/div/div[1]/div[1]/div");
	private static By STATUS_COLUMN_COMM_VERIFICATION   					=By.xpath("//app-gateways-list/div//span[contains(text(), 'Status')] ");
	private static By VERIFICATION_STATUS_TYPE								=By.xpath("//app-gateways-list/div/div[2]/div[2]/div[2]/div/div[1]/div[7]/span");
	private static By VERIFICATION_DECOMM_DATA								=By.xpath("//app-gateways-list/div/div[2]/div[2]");
	private static By CLICK_DROPDOWN_SORT									=By.xpath("//app-gateways-list/div/div[1]/div[2]/div[2]/p-dropdown/div/div[3]");
	private static By TODATE 												=By.xpath("//input[@placeholder=\"To\"]"); 
	private static By CLEARDATE 											=By.xpath("//div[@class=\"fr close-btn sprite\"]"); 
	private static By FROMDATE 												=By.xpath("//input[@placeholder=\"From\"]");  
	private static By GATEWAY_SHOW_TXT		                   			=By.xpath("//div[@class='fl fh info']");
	private static By GATEWAY_CUSTOMERCOLUMN_TXT		                   			=By.xpath("//div[@class='fl fh col-heading cell ellipses customerName']");
	private static By GATEWAY_TYPECOLUMN_TXT		                   			=By.xpath("//div[@class='fl fh col-heading cell ellipses gatewayType']");
	private static By GATEWAY_AREACOLUMN_TXT		                   			=By.xpath("//div[@class='fl fh col-heading cell ellipses customerName']");
	private static By GATEWAY_STATUSCOLUMN_TXT		                   			=By.xpath("//div[@class='fl fh col-heading cell ellipses status']");
	private static By GATEWAY_COUNTRYCOLUMN_TXT		                   			=By.xpath("//div[@class='fl fh col-heading cell ellipses country']");
	
	private static By GATEWAY_FROMDATE 												=By.xpath("//input[@placeholder=\"From\"]");
    private static By GATEWAY_TODATE 												=By.xpath("//input[@placeholder=\"To\"]");
    private static By GATEWAY_CLEARDATE 											=By.xpath("//div[@class=\"fr close-btn sprite\"]");
    private static By GATEWAY_TESTDATE1												=By.xpath("//div[contains(@class,'datepicker')][1]//td[contains(@class,'ui-datepicker-today')]/preceding-sibling::td[1]/a");
    private static By GATEWAY_TESTDATE2												=By.xpath("//div[contains(@class,'datepicker')][1]//td[contains(@class,'ui-datepicker-today')]");
    private static By GATEWAY_LASTUPDATED_DT								=By.xpath( "(//div[@class=\"fl fh col-heading cell ellipses lastUpdatedTime\"])[1]");
    
    
  //  private static By GATEWAY_NOGATEWAY_TXT								    =By.xpath("//div[text()=\" No gateways. \"]");
 //   private static By GATEWAY_STATUS_CM										=By.xpath("//div[@class=\"fl fh col-heading cell ellipses lastUpdatedTime\"]");
    private static By GATEWAY_ALL_RECS										=By.xpath("//div[@class=\"fl fh col-heading cell ellipses lastUpdatedTime\"]");
    
	public void clickAddGateway() {

		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			waitElementVisibleClick(GATEWAY_ADDGATEWAY_BT,1300);
			sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void verifyManageSoftwareInterface()
	{
		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			waitElementVisibleClick(GATEWAY_SEARCH_DD,2000);
			waitElementVisibleClick(GATEWAY_PRECOMMISION_CB,1000);
			elementClick(GATEWAYSEARCH_BT);
			if(elementAvailability(GATEWAYSEARCHSELECTIONCHECK))
			{
				if(elementCount(GATEWAYGENERICROW)>0)
				{
					String gatewaytext=elementGetText(GATEWAYNAME);
					elementClick(GATEWAYMOREINFO);
					waitElementVisibleClick(GATEWATMANAGESOFTWARE_BT,2000);
					compareText(elementGetText(GATEWAYMANAGESOFTWARENAME),"Gateway : "+gatewaytext);
				}
			}
		} catch (InterruptedException e) {		
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void verifyOperatorHasNoAccessToEditGateway()
	{
		JsonReader.getJsonObject("OperatorHasNoAccessToAddGateway");
		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			if(elementCount(GATEWAYGENERICROW)>0)
			{
				elementClick(GATEWAYMOREINFO);
				elementClick(GATEWAYEDIT_BT);
				verifyToastermessage(GATEWAYOPERATORTOASTMESSAGE,"ToadterOperatorMessage");

			}
		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}


	public void verifyOperatorHasNoAccessToDisableGateway()
	{		
		JsonReader.getJsonObject("OperatorHasNoAccessToAddGateway");
		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			if(elementCount(GATEWAYGENERICROW)>0)
			{
				elementClick(GATEWAYMOREINFO);
				elementClick(GATEWAYOPERATORDISABLE_BT);
				verifyToastermessage(GATEWAYOPERATORTOASTMESSAGE,"ToadterOperatorMessage");
			}
		}catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());

		}
	}

	public void verifyOperatorHasNoAccessToDecommissionGateway()
	{
		try {JsonReader.getJsonObject("OperatorHasNoAccessToAddGateway");
		waitElementVisibleClick(GATEWAY_ICON,300);
		waitElementVisibleClick(GATEWAY_SEARCH_DD,2000);
		waitElementVisibleClick(GATEWAY_PRECOMMISION_CB,1000);
		elementClick(GATEWAYSEARCH_BT);
		if(elementAvailability(GATEWAYSEARCHSELECTIONCHECK))
		{
			if(elementCount(GATEWAYGENERICROW)>0)
			{
				elementClick(GATEWAYMOREINFO);
				elementClick(GATEWAYOPERATORDECOMISSION_BT);
				verifyToastermessage(GATEWAYOPERATORTOASTMESSAGE,"ToadterOperatorMessage");
			}
		}
		} catch (InterruptedException e) {		
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void operatorHasNoAccessToAddGateway() {

		try {
			JsonReader.getJsonObject("OperatorHasNoAccessToAddGateway");
			elementClick(GATEWAY_ICON);
			waitElementVisibleClick(GATEWAY_ADDGATEWAY_BT,1300);
			verifyToastermessage(GATEWAY_TOASTER_MSG,"ToasterMessageFailed");
			elementClick(GATEWAY_ADDGATEWAY_BT);
			verifyToastermessage(GATEWAY_TOASTER_MSG_TXT,"ToasterMessageFailedReason");

		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void disableAndEnableGateway() {

		try {
			JsonReader.getJsonObject("DisableAndEnableGateway");
			waitElementVisibleClick(GATEWAY_ICON,300);

			elementSendKeys(GATEWAY_SEARCH_EB,jsonData.getJsonData("SearchItem"));
			elementClick(GATEWAY_SEARCH_ICON);
			elementAvailability(GATEWAY_TABLE);

			elementClick(GATEWAY_TABLE_MOREINFO_DD);

			if(elementDisplayed(GATEWAY_ENABLE_BT)) {
				elementClick(GATEWAY_ENABLE_BT);
				sleep(300);
				verifyToastermessage(GATEWAY_TOASTER_MSG_TXT,"ToasterMessageEnabled");
				elementClick(GATEWAY_DISABLE_BT);
				sleep(300);
				verifyToastermessage(GATEWAY_TOASTER_MSG_TXT,"ToasterMessageDisabled");

			}else if(elementDisplayed(GATEWAY_DISABLE_BT)) {
				elementClick(GATEWAY_DISABLE_BT);
				sleep(3000);
				verifyToastermessage(GATEWAY_TOASTER_MSG_TXT,"ToasterMessageDisabled");
				elementClick(GATEWAY_ENABLE_BT);
				sleep(3000);
				verifyToastermessage(GATEWAY_TOASTER_MSG_TXT,"ToasterMessageEnabled");
			}else {

				testFailed("Enable /Disable button is not displayed");
			}
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void verifyUserInterfaceOfGatewayAddSoftware()
	{
		try {
			verifyCommissionedFilterSearch();
			if(elementAvailability(GATEWAYSEARCHSELECTIONCHECK))
			{
				if(elementCount(GATEWAYGENERICROW)>0)
				{
					elementClick(GATEWAYMOREINFO);
					waitElementVisibleClick(GATEWATMANAGESOFTWARE_BT,2000);
					elementClick(GATEWAYADDSOFTWARE_BT);
					elementAvailability(LABELSOFTWARENAME);
					elementAvailability(LABELVERSION);
					elementAvailability(LABELUPLOADPACKAGE);
					elementAvailability(LABELSCHEDULEDINSTALLATION);
				}
			}
		} catch (InterruptedException e) {		
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void operatorHasAccessToViewGateway()
	{
		JsonReader.getJsonObject("GatewayDetails");
		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			if(elementCount(GATEWAYGENERICROW)>0)
			{
				elementClick(GATEWAYMOREINFO);
				compareText(elementGetText(GATEWAYDETAILS_LABEL), jsonData.getJsonData("GatewayDetails"));
				compareText(elementGetText(GATEWAYDETAILS_MODEL_LABEL), jsonData.getJsonData("Model"));
				compareText(elementGetText(GATEWAYDETAILS_MACID_LABEL), jsonData.getJsonData("MACID"));
				compareText(elementGetText(GATEWAYDETAILS_SIMNUMBER_LABEL), jsonData.getJsonData("SimNumber"));
				compareText(elementGetText(GATEWAYDETAILS_SERIALNUMBER_LABEL), jsonData.getJsonData("SerialNumber"));
				compareText(elementGetText(GATEWAYDETAILS_CERTIFICATE_LABEL), jsonData.getJsonData("GatewayCertificate"));
				compareText(elementGetText(GATEWAYDETAILS_ENROLLMENTGROUP_LABEL), jsonData.getJsonData("EnrollmentGroup"));
				compareText(elementGetText(CUSTOMERDETAILS_LABEL), jsonData.getJsonData("CustomerDetails"));
				compareText(elementGetText(CUSTOMERDETAILS_BUSINESSUNIT_LABEL), jsonData.getJsonData("BusinessUnit"));
				compareText(elementGetText(CUSTOMERDETAILS_OPERATOR_LABEL), jsonData.getJsonData("Operator"));
				compareText(elementGetText(ADDITIONALDETAILS_LABEL), jsonData.getJsonData("AdditionalDetails"));
				compareText(elementGetText(ADDITIONALDETAILS_DESCRIPTION_LABEL), jsonData.getJsonData("Description"));
				compareText(elementGetText(ADDITIONALDETAILS_METADATA_LABEL), jsonData.getJsonData("Metadata"));
				compareText(elementGetText(GATEWAYLIFECYCLE_LABEL), jsonData.getJsonData("GatewayLifecycle"));
				compareText(elementGetText(GATEWAYLIFECYCLE_PRECOMMISSIONED_LABEL), jsonData.getJsonData("PreCommissioned"));
				compareText(elementGetText(GATEWAYLIFECYCLE_COMMISSIONED_LABEL), jsonData.getJsonData("Commissioned"));
				compareText(elementGetText(GATEWAYLIFECYCLE_DECOMMISSIONED_LABEL), jsonData.getJsonData("Decommissioned"));

			}
		}catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}		

	}

	public void UserWithNoPrivilegeCannotAccessGatewayPage()
	{
		JsonReader.getJsonObject("TCO3OperatorHasNoAccess");
		verifyToastermessage(GATEWAY_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
	}
	public void verifyDefaultGatewayStatus()
	{ 
		try {
		JsonReader.getJsonObject("VerifyDefaultGatewayStatus");	
		waitElementVisibleClick(GATEWAY_ICON,300);
//		compareText(elementGetText(GATEWAYDEFAULT),jsonData.getJsonData("GatewayDefaultActual"));
		compareText(elementGetText(GATEWAY_STATUS_DD),jsonData.getJsonData("ShowSearchValue"));
	      }
	catch (InterruptedException e) {
		TestLogger.appInfo(e.getMessage());
	}
}

	public void verifyCommissionedFilterSearch()
	{
		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			waitElementVisibleClick(GATEWAY_SEARCH_DD,2000);
			waitElementVisibleClick(GATEWAY_PRECOMMISION_CB,1000);
			elementClick(GATEWAYSEARCH_BT);
			sleep(3000);
		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void validatePreCommissionedGatewayStatus()
	{
		try {
			JsonReader.getJsonObject("validatePreCommissionedGatewayStatus"); 
			waitElementVisibleClick(GATEWAY_ICON,300);
			elementClick(GATEWAY_SEARCH_DD);
			elementClick(GATEWAY_PRECOMMISION_CB);	
			elementClick(GATEWAY_COMMISION_CB);	
			elementClick(GATEWAY_SEARCH_DD);
			compareText(elementGetText(GATEWAY_STATUS_DD),jsonData.getJsonData("SearchValue"));	
			elementClick(GATEWAY_SEARCH_DD);
			elementClick(GATEWAY_PRECOMMISION_CB);	
			compareText(elementGetText(GATEWAY_STATUS_DD),jsonData.getJsonData("SearchValueAfterPrecommisionselect"));
			waitElementVisibleClick(GATEWAY_SEARCH_ICON, 300);
			sleep(3000);
			validateCoumns(GATEWAY_STATUS_CM, "ShowSearchValueAfterPrecommisionselect");

		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	/*
	 * *
	 */
	public void validateCommissionedGatewayStatus()
	{
		try {
			JsonReader.getJsonObject("validateCommissionedGatewayStatus");
			waitElementVisibleClick(GATEWAY_ICON,300);
			waitElementVisibleClick(GATEWAY_SEARCH_DD,2000);
			waitElementVisibleClick(GATEWAY_PRECOMMISION_CB,1000);
			elementClick(GATEWAY_COMMISION_CB);	
			elementClick(GATEWAY_SEARCH_DD);
			compareText(elementGetText(GATEWAY_STATUS_DD),jsonData.getJsonData("SearchValue"));	
			elementClick(GATEWAY_SEARCH_DD);
			elementClick(GATEWAY_COMMISION_CB);	
			compareText(elementGetText(GATEWAY_STATUS_DD),jsonData.getJsonData("SearchValueAfterCommisionselect"));
			elementClick(GATEWAYSEARCH_BT);
			sleep(3000);
			validateCoumns(GATEWAY_STATUS_CM, "SearchValueAfterCommisionselect");
		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void validateDecommissionedGatewayStatus()
	{
		try {
			JsonReader.getJsonObject("validateDecommissionedGatewayStatus");
			waitElementVisibleClick(GATEWAY_ICON,300);
			elementClick(GATEWAY_SEARCH_DD);
			elementClick(GATEWAY_PRECOMMISION_CB);	
			elementClick(GATEWAY_COMMISION_CB);	
			compareText(elementGetText(GATEWAY_STATUS_DD),jsonData.getJsonData("SearchValue"));	
			elementClick(GATEWAY_DECOMMISION_CB);
			compareText(elementGetText(GATEWAY_STATUS_DD),jsonData.getJsonData("SearchValueAfterDecommisionselect"));
			waitElementVisibleClick(GATEWAY_SEARCH_ICON, 300);
			sleep(3000);
			validateCoumns(GATEWAY_NOGATEWAY_TXT, "ShowSearchValueAfterDecommisionselect");

		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void validateCoumns(By ByType, String Jsondata) {
		try {
			if(elementDisplayed(GATEWAY_NOGATEWAY_TXT)) {
				testPassed("No Gateway record present");
			}else {
				List<WebElement> elementList = elementListReturn(GATEWAY_STATUS_CM);	
				for(int i=0;i<elementList.size();i++) {
					compareText(getElementValue(elementList.get(i),"title"),jsonData.getJsonData(Jsondata));
				}
			}
		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void verifyClearSelectedOptionsInGatewayStatusSearchDropdown()
	{
		try {				

			JsonReader.getJsonObject("verifyClearSelectedOptionsInGatewayStatusSearchDropdown"); 
			waitElementVisibleClick(GATEWAY_ICON,300);
			elementClick(GATEWAY_SEARCH_DD);
			elementClick(GATEWAY_PRECOMMISION_CB);	
			elementClick(GATEWAY_COMMISION_CB);		
			elementClick(GATEWAY_SEARCH_DD);			
			compareText(elementGetText(GATEWAY_STATUS_DD),jsonData.getJsonData("SearchValue"));		

		}catch (InterruptedException e) {

			TestLogger.appInfo(e.getMessage());
		}
	}



	public void verifySelectAllOptionInGatewayStatusSearchDropdown()
	{
		try {

			JsonReader.getJsonObject("verifySelectAllOptionInGatewayStatusSearchDropdown"); 
			waitElementVisibleClick(GATEWAY_ICON,300);
			elementClick(GATEWAY_SEARCH_DD);
			elementClick(GATEWAY_PRECOMMISION_CB);	
			elementClick(GATEWAY_COMMISION_CB);	
			elementClick(GATEWAY_SEARCH_DD);
			compareText(elementGetText(GATEWAY_STATUS_DD),jsonData.getJsonData("SearchValue1"));	
			elementClick(GATEWAY_SEARCH_DD);
			elementClick(GATEWAY_PRECOMMISION_CB);	
			elementClick(GATEWAY_COMMISION_CB);	
			elementClick(GATEWAY_DECOMMISION_CB);
			compareText(elementGetText(GATEWAY_STATUS_DD),jsonData.getJsonData("SearchValueAfterSearch"));	
		} 
		catch(InterruptedException e) {

			TestLogger.appInfo(e.getMessage());
		}
	}


	public void verifyClearDatesFromDatePicker(){
		try {                             
			waitElementVisibleClick(GATEWAY_ICON,300);
			elementClick(GATEWAY_FROMDATE);
			 elementClick(GATEWAY_TESTDATE1);
			elementClick(GATEWAY_TODATE);
			  elementClick(GATEWAY_TESTDATE2);
			elementClick(CLEARDATE);  
		}
		catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}}





	public void verifySearchOptionsSearchDropdown(){
		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			waitElementVisibleClick(GATEWAY_CATERGORY_DD,300);
			JsonReader.getJsonObject("verifySearchOptionsSearchDropdown");
			compareText(elementGetText(SORT_GATEWAY),jsonData.getJsonData("GatewayActual1"));
			compareText(elementGetText(SORT_CUSTOMER),jsonData.getJsonData("GatewayActual2"));
			compareText(elementGetText(SORT_TYPE),jsonData.getJsonData("GatewayActual3"));
			compareText(elementGetText(SORT_COUNTRY),jsonData.getJsonData("GatewayActual4"));
			compareText(elementGetText(SORT_AREA),jsonData.getJsonData("GatewayActual5"));
			compareText(elementGetText(SORT_STATUS),jsonData.getJsonData("GatewayActual6"));
		} 
		catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}}

	public void	ManageSoftwareUploadAndInstallInvalidSoftwareName()
	{
		JsonReader.getJsonObject("AddSoftware");

		try {
			verifyCommissionedFilterSearch();
			sleep(3000);
			if(elementCount(GATEWAYGENERICROW)>0)
			{
				elementClick(GATEWAYMOREINFO);
				waitElementVisibleClick(GATEWAYMANAGESOFTWARE_BT,2000);
				waitElementVisibleClick(GATEWAYADDSOFTWARE_BT,3000);
				elementSendKey(ADDSOFTWARE_SOFTWARENAME_EB, jsonData.getJsonData("SoftwareNameInvalid"));
				elementClick(ADDSOFTWARE_UPLOADICON_BT);
				uploadFile(jsonData.getJsonData("UploadPackagePath"));
				elementClick(ADDSOFTWARE_UPLOADINSTALL_BT);
				verifyToastermessage(ADDSOFTWARE_TOASTER,"UploadErrorMsg");
			}

		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void ManageSoftwareUploadAndInstallInvalidSoftwarePackage()
	{
		JsonReader.getJsonObject("AddSoftware");

		try {
			verifyCommissionedFilterSearch();
			sleep(3000);
			if(elementCount(GATEWAYGENERICROW)>0)
			{
				elementClick(GATEWAYMOREINFO);
				waitElementVisibleClick(GATEWAYMANAGESOFTWARE_BT,2000);
				waitElementVisibleClick(GATEWAYADDSOFTWARE_BT,3000);
				elementSendKey(ADDSOFTWARE_SOFTWARENAME_EB, jsonData.getJsonData("SoftwareNameInvalid"));
				elementClick(ADDSOFTWARE_UPLOADICON_BT);
				uploadFile(jsonData.getJsonData("UploadInvalidPackagePath"));
				if(elementGetText(ADDSOFTWARE_UPLOADPACKAGE_BOX).contentEquals(jsonData.getJsonData("PackageName")))
				{
					TestLogger.appInfo("Uploaded Files is Valid");
				}
				else
				{
					TestLogger.appInfo("Uploaded File is InValid");
				}
			}

		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}

	}

	public void ManageSoftwareAddSoftwareUploadInstallValidUserInputs()
	{
		JsonReader.getJsonObject("AddSoftware");
		try {
			verifyCommissionedFilterSearch();
			if(elementCount(GATEWAYGENERICROW)>0)
			{
				elementClick(GATEWAYMOREINFO);
				waitElementVisibleClick(GATEWAYMANAGESOFTWARE_BT,2000);
				waitElementVisibleClick(GATEWAYADDSOFTWARE_BT,3000);
				elementSendKey(ADDSOFTWARE_SOFTWARENAME_EB, jsonData.getJsonData("SoftwareName"));
				elementClick(ADDSOFTWARE_UPLOADICON_BT);
				uploadFile(jsonData.getJsonData("UploadPackagePath"));
				elementClick(ADDSOFTWARE_UPLOADINSTALL_BT);
				verifyToastermessage(GATEWAY_TOASTER_MSG_TXT,jsonData.getJsonData("UploadDeviceNotFoundError"));
			}
		}catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}


	public void verifyToastermessage(By ByType, String Jsondata) {
		try {
			waitForMessage(ByType,2);
			String toasterText = elementGetText(ByType);
			compareText(jsonData.getJsonData(Jsondata),toasterText);

		}catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}}

	public void verifySearchGatewayDateRange() {
		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			
			elementClick(GATEWAY_FROMDATE);
			String fromDate = elementGetText(GATEWAY_TESTDATE1);
			elementClick(GATEWAY_TESTDATE1);
			
			elementClick(GATEWAY_TODATE);
			String ToDate = elementGetText(GATEWAY_TESTDATE2);
			elementClick(GATEWAY_TESTDATE2);
			
			elementClick(GATEWAY_SEARCH_ICON);
			
			String lastupdatevalue = elementGetText(GATEWAY_LASTUPDATED_DT);
			String lastupdatedate = lastupdatevalue.substring(2, 4);
			
			if(fromDate.equals(lastupdatedate) ||  (ToDate.equals(lastupdatedate))) {
				testPassed("Expected date value from  "+fromDate +" and "+ToDate+"      Actual date value is : "+lastupdatevalue);
				}
			else {
				testFailed("Expected date value from  "+fromDate +" and "+ToDate+"      Actual date value is : "+lastupdatevalue);
			}
		}
		catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	//For edit existing gate-way value
	/***** Tc02EditSingleGateway : editDetailsOfAnAlreadyAddedGateway *****/
	public void editSingleGateway() {

		try {
			JsonReader.getJsonObject("EditSingleGateway");
			clickEditGateway();
			elementSendKeys(ADDSINGLEGATWAY_GATEWAYNAME_EB,jsonData.getJsonData("GatewayName"));
			waitElementVisibleClick(ADDSINGLEGATWAY_TYPE_DD,300);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"GatewayType")));
			elementClick(ADDSINGLEGATWAY_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"Model")));
			waitElementVisibleClick(ADDSINGLEGATWAYSERIALNUMBER_EB, 300);
			elementSendKeys(ADDSINGLEGATWAYSERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(ADDSINGLEGATWAY_SIMNUMBER_EB,jsonData.getJsonData("SIMNumber"));
			elementClick(ADDSINGLEGATWAY_NEXT_BT);


			//Enter Client Details
			elementSendKeys(ADDSINGLEGATWAY_CUSTOMERNAME_ED,jsonData.getJsonData("CustomerName"));
			elementClick(ADDSINGLEGATWAY_CUSTOMERCOUNTRY_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"CustomerCountry")));
			elementClick(ADDSINGLEGATWAY_CUSTOMERAREA_DD);
			elementClick(By.xpath(dynamicXpath(TYPEDROPDOWNLIST,"CustomerArea")));
			elementSendKeys(ADDSINGLEGATWAY_BUSINESSUNIT_EB,jsonData.getJsonData("BusinessUnit"));
			elementSendKeys(ADDSINGLEGATWAY_OPERATOR_EB,jsonData.getJsonData("Operator"));
			elementClick(ADDSINGLEGATWAY_CUSTOMERDETAIL_NEXT_BT);


			//Additional
			//elementClick(ADDSINGLEGATWAY_ADDITIONALDETAIL_DESCRIPTION_ED);
			elementSendKey(ADDSINGLEGATWAY_ADDITIONALDETAIL_DESCRIPTION_EB,jsonData.getJsonData("Description"));
			elementClick(ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_ICON);
			elementSendKeys(ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_KEY_EB1,jsonData.getJsonData("MetaDatakey1"));
			elementSendKeys(ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_VALUE_EB1,jsonData.getJsonData("MetaDatavalue1"));
			elementSendKeys(ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_KEY_EB2,jsonData.getJsonData("MetaDatakey1"));
			elementSendKeys(ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_VALUE_EB2,jsonData.getJsonData("MetaDatavalue1"));
			elementSendKeys(ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_KEY_EB3,jsonData.getJsonData("MetaDatakey1"));
			elementSendKeys(ADDSINGLEGATWAY_ADDITIONALDETAIL_METADATA_VALUE_EB3, jsonData.getJsonData("MetaDatavalue1"));
			waitElementVisibleClick(ADDSINGLEGATWAY_ADDITIONALDETAIL_FINISH_BT, 300);
			elementClick(ADDSINGLEGATWAY_ADDITIONALDETAIL_FINISH_BT);
			verifyToastermessage("ToasterMsgSuccess");
			verifyToastermessage("ToasterMsgSuccesUpdated");

			//Validating the edited values 
			waitElementVisibleClick(GATEWAY_ICON,300);
			elementSendKeys(GATEWAY_SEARCH_EB,jsonData.getJsonData("GatewayName"));
			elementClick(GATEWAY_SEARCH_ICON);
			if(compareValue(elementGetText(GATEWAYNAME), jsonData.getJsonData("GatewayName"))) {
				waitElementVisibleClick(MORE_INFO,300);
				waitElementVisibleClick(EDIT_GATEWAY,300);
				testPassed("Edit Gateway functionality is validated"+jsonData.getJsonData("GatewayName"));
			}else {
				testFailed("Edit Gateway functionality is not validated"+jsonData.getJsonData("GatewayName"));
			}

		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	//Click on Gateway Show dropdown
	/***** Tc03DropdownGateway : verifySearchUsingAParticularSearchCategoryFromDropdown *****/
	public void showDropDownGateway() {

		try {
			JsonReader.getJsonObject("ShowDropdownGateway");
			searchItemWithGatewayCategory(SORT_CUSTOMER,"CustomerName");
			List<String> customerName = elementsGetText(GATEWAY_CUSTOMERCOLUMN_TXT);
			for(int i=0;i<customerName.size();i++) {
				compareTextIgnoreCase(customerName.get(i), jsonData.getJsonData("CustomerName"));
			}
			searchItemWithGatewayCategory(SORT_TYPE,"GatewayType");	
			List<String> customerType = elementsGetText(GATEWAY_TYPECOLUMN_TXT);
			for(int i=0;i<customerType.size();i++) {
				compareTextIgnoreCase(customerType.get(i), jsonData.getJsonData("CustomerType"));
			}
			searchItemWithGatewayCategory(SORT_AREA,"CustomerArea");	
			List<String> customerArea = elementsGetText(GATEWAY_AREACOLUMN_TXT);
			for(int i=0;i<customerArea.size();i++) {
				compareTextIgnoreCase(customerArea.get(i), jsonData.getJsonData("CustomerArea"));
			}
			searchItemWithGatewayCategory(SORT_COUNTRY,"CustomerCountry");	
			List<String> customerCountry = elementsGetText(GATEWAY_COUNTRYCOLUMN_TXT);
			for(int i=0;i<customerCountry.size();i++) {
				compareTextIgnoreCase(customerCountry.get(i), jsonData.getJsonData("CustomerCountry"));
			}
			searchItemWithGatewayCategory(SORT_STATUS,"status");	
			List<String> customerStatus = elementsGetText(GATEWAY_STATUSCOLUMN_TXT);
			for(int i=0;i<customerStatus.size();i++) {
				compareTextIgnoreCase(customerStatus.get(i), jsonData.getJsonData("status"));
			}
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	//Sort gateway Categories
	/***** Tc04GatewaySortCatagory : verifySortUsingAParticularSortCategory *****/
	public void getSortCategories() {

		try {
			List<String> beforeSort = getSortCategory();
			List<String> afterSort = elementsGetText(GATEWAY_GATEWAYNAMESORTED_LT);
			Collections.sort(beforeSort);
			beforeSort.forEach(x->{
				afterSort.forEach(y -> {
				if(x.equals(y) )
					compareTextIgnoreCase(x,y);		
				});
				});
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	//Geteway column Verification
	/***** Tc05VerifyGatewayColumn :  Validate the column names of gateway list section *****/
	public void verifyGatewayColumn() {

		try {
			JsonReader.getJsonObject("ColumnVerification");
			
			getColumnVerification();
			List<String> ColumnName = elementsGetText(GATEWAY_ALL_COLUMN);
			List<String> expected=new ArrayList<String>();
			for(int i=0;i<ColumnName.size();i++) {
			String listvaue = jsonData.getJsonData("GatewayColumn"+i);
			expected.add(listvaue);
			compareTextIgnoreCase(ColumnName.get(i),expected.get(i));
			
			}
						
			elementAvailability(GATEWAY_SEARCH_EB,"GATEWAY_SEARCH_EB");
			elementAvailability(GATEWAY_SEARCH_DD,"GATEWAY_SEARCH_DD");
			waitElementVisibleClick(GATEWAY_SEARCH_DD,300);
			elementAvailability(GATEWAY_DECOMMISION_CB,"GATEWAY_DECOMMISION_CB");
			elementAvailability(GATEWAY_COMMISION_CB,"GATEWAY_COMMISION_CB");
			elementAvailability(GATEWAY_PRECOMMISION_CB,"GATEWAY_PRECOMMISION_CB");
			elementAvailability(GATEWAYSEARCH_BT,"GATEWAYSEARCH_BT");
			elementAvailability(GATEWAY_CATERGORY_DD);
			elementAvailability(GATEWAY_ADDGATEWAY_BT,"GATEWAY_ADDGATEWAY_BT");
			elementAvailability(GATEWAY_SHOW_TXT,"GATEWAY_SHOW_TXT");
				
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	//Verify Show Textbox as per selected Checkbox
	/***** Tc06VerifyGatewayLifeCycle :  Validate the Gateway life cycle in the gateway landing page *****/
	public void verifyGatewayLifeCycle() {

		try {
			sleep(2000);
			clickGatewayLifeCycle();
			JsonReader.getJsonObject("GatewayLifeCycle");

			elementClick(SHOW_GATEWAY_COMM);
			elementClick(CLICK_ON_SEARCH_BUTTON);
			String ActualTextComm = elementGetText(VERIFY_GATEWAY_CATAGORIES);
			compareText(ActualTextComm, jsonData.getJsonData("ShowGateway1"));
			sleep(2000);

			//Unselect PRE-COMMISSIONED checkbox and select COMMISSIONED checkbox
			clickGatewayLifeCycle();
			elementClick(SHOW_GATEWAY_COMM);
			elementClick(SHOW_GATEWAY_PRECOMM);
			elementClick(CLICK_ON_SEARCH_BUTTON);
			String ActualTextComm1 = elementGetText(VERIFY_GATEWAY_CATAGORIES);
			compareText(ActualTextComm1, jsonData.getJsonData("ShowGateway2"));

			//Unselect COMMISSIONED checkbox and select DECOMMISSIONED checkbox
			clickGatewayLifeCycle();
			elementClick(SHOW_GATEWAY_COMM);
			elementClick(SHOW_GATEWAY_DECOMM);
			elementClick(CLICK_ON_SEARCH_BUTTON);
			String ActualTextComm2 = elementGetText(VERIFY_GATEWAY_CATAGORIES);
			compareText(ActualTextComm2, jsonData.getJsonData("ShowGateway3"));

		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}	

	/***** Tc02EditSingleGateway : editDetailsOfAnAlreadyAddedGateway *****/
	public ZFAddSingleGatewayPage clickEditGateway() {

		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			elementSendKeys(GATEWAY_SEARCH_EB,jsonData.getJsonData("EditGatewayName"));
			elementClick(GATEWAY_SEARCH_ICON);
			if(compareValue(elementGetText(GATEWAYNAME), jsonData.getJsonData("EditGatewayName"))) {
				waitElementVisibleClick(MORE_INFO,300);
				waitElementVisibleClick(EDIT_GATEWAY,300);
			}else {
				testFailed("Gateway search value is not displayed "+jsonData.getJsonData("EditGatewayName"));
			}

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return new ZFAddSingleGatewayPage();
	}

	/***** Tc03DropdownGateway : verifySearchUsingAParticularSearchCategoryFromDropdown *****/
	public ZFAddSingleGatewayPage searchItemWithGatewayCategory(By byType, String testdata) {

		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			waitElementVisibleClick(GATEWAY_CATERGORY_DD,3);
			elementClick(byType);
			elementSendKeys(GATEWAY_SEARCH_EB,jsonData.getJsonData(testdata));
			waitElementVisibleClick(GATEWAY_SEARCH_ICON,300);
			sleep(3000);
		} catch (InterruptedException e) {

			TestLogger.appInfo(e.getMessage());
		}
		return new ZFAddSingleGatewayPage();
	}

	/***** Tc04GatewaySortCatagory : verifySortUsingAParticularSortCategory *****/
	public List<String> getSortCategory()
	{
		List<String> beforesort = null;
		try {			
			waitElementVisibleClick(GATEWAY_ICON,300);
			beforesort = elementsGetText(GATEWAY_GATEWAYNAMESORTED_LT);
			waitElementVisibleClick(GATEWAY_GATEWAYNAMESORT_ICON,300);
			elementClick(GATEWAY_GATEWAYNAMESORT_ICON);

		} catch (InterruptedException e) {

			TestLogger.appInfo(e.getMessage());
		}
		return beforesort;
	}

	/***** Tc06VerifyGatewayLifeCycle :  Validate the Gateway life cycle in the gateway landing page *****/
	public ZFAddSingleGatewayPage clickGatewayLifeCycle() {

		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			sleep(2500);
			waitElementVisibleClick(GATEWAY_DROPDOWN,1300);

		} catch (InterruptedException e) {

			TestLogger.appInfo(e.getMessage());
		}
		return new ZFAddSingleGatewayPage();
	}

	/***** Tc05VerifyGatewayColumn :  Validate the column names of gateway list section *****/
	public ZFAddSingleGatewayPage getColumnVerification() {

		try {
			waitElementVisibleClick(GATEWAY_ICON,300);
			sleep(2500);
			waitElementVisibleClick(GATEWAY_DROPDOWN,300);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return new ZFAddSingleGatewayPage();
	}

	public	String dynamicXpath(String xpath, String Jsonvalue) {
		return updateXpath(xpath,jsonData.getJsonData(Jsonvalue));
	}


	public void verifyToastermessage(String Jsondata) {
		String toasterText;
		try {
			toasterText = waitElementVisibleGetText(ADDSINGLEGATWAY_TOASTER_DT,300);
			compareText(jsonData.getJsonData(Jsondata),toasterText);
		} catch (InterruptedException e) {
			
			TestLogger.appInfo(e.getMessage());
		}
		
	}


}
