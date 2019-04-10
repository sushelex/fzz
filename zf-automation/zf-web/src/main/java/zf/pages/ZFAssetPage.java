package zf.pages;

import java.util.Random;

import org.openqa.selenium.By;

import framework.DriverManager;
import framework.ElementManager;
import framework.ExtentReport;
import framework.JsonReader;
import framework.TestLogger;

public class ZFAssetPage extends ElementManager{
	JsonReader jsonData=new JsonReader();

	private static  By HOMEPAGE_ASSETS_lK   	 	                 =By.xpath("//a[@title='Assets']");	
	private static  By ASSETS_ZFLOGO_IMG   	 	                 	 =By.xpath("//div[@class='zf-logo']");
	private static  By ASSETS_SEARCH_EB   	 	                 	 =By.xpath("//input[@class='fh fl ng-untouched ng-pristine ng-valid']");
	private static  By ASSETS_SEARCH_BT   	 	                 	 =By.xpath("//div[@class='search-icon sprite']");
	private static  By ASSETS_COUNTRY_ST   	 	                 	 =By.xpath("(//span[@class='fl'])[1]");
	private static  By ASSETS_COUNTRY_DD   	 	                 	 =By.xpath("//div[@class='ng-tns-c14-6 ui-multiselect-trigger ui-state-default ui-corner-right']");
	private static  By ASSETS_CZECHREPUBLIC_CB   	 	             =By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[2]");
	private static  By ASSETS_AREA_ST   	 	                 	 =By.xpath("(//span[@class='fl'])[2]");
	private static  By ASSETS_AREA_DD   	 	                 	 =By.xpath("//div[@class='ng-tns-c14-7 ui-multiselect-trigger ui-state-default ui-corner-right']");
	private static  By ASSETS_BRNO_CB   	 	                 	 =By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[2]");
	private static  By ASSETS_CUSTOMER_ST   	 	                 =By.xpath("(//span[@class='fl'])[3]");
	private static  By ASSETS_CUSTOMER_DD   	 	                 =By.xpath("//div[@class='ng-tns-c14-8 ui-multiselect-trigger ui-state-default ui-corner-right']");
	private static  By ASSETS_ZF_CB   	 	                 		 =By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[3]");
	private static  By ASSETS_BUSSINESSUNIT_ST   	 	             =By.xpath("(//span[@class='fl'])[4]");
	private static  By ASSETS_BUSSINESSUNIT_DD   	 	             =By.xpath("//div[@class='ng-tns-c14-9 ui-multiselect-trigger ui-state-default ui-corner-right']");
	private static  By ASSETS_FACTORY_CB   	 	            		 =By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[2]");
	private static  By ASSETS_SORTBY_ST   	 	            		 =By.xpath("(//span[@class='fl'])[4]");
	private static  By ASSETS_ASSETTYPE_ST   	 	            	 =By.xpath("//div[@class='fl fh info-assettype info']");
	private static  By ASSETS_MANUFACTURER_ST    	            	 =By.xpath("//div[@class='fl fh info-manufacturer info']");
	private static  By ASSETS_BRAND_ST    	            	 		 =By.xpath("//div[@class='fl fh info-brand info']");
	private static  By ASSETS_DATE_ST    	            			 =By.xpath("//div[@class='fl fh info-date info']");
	private static  By ASSETS_CLEARALL_LK    	            		 =By.xpath("//span[@class='reset-all-link fr fh']");
	private static  By ASSETS_CREATEASSET_BT    	                 =By.xpath("//button[@class='fr primary zf-button']");
	private static  By ASSETS_SEARCHVALUE_DT    	                 =By.xpath("//span[text()=\"michal test \"]");
	private static  By ASSETS_ADVANCEDSEARCH_BT    	                 =By.xpath("//div[@class='filter-icon sprite']");
	private static  By ADVANCEDSEARCHPOPUP_ASSETTYPE_DD    	         =By.xpath("//label[@class='ng-tns-c13-11 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']");
	private static  By ADVANCEDSEARCHPOPUP_BASICASSETTYPEVALUE_ST    =By.xpath("//span[text()=\"BASIC_ASSET_TYPE\"]");
	private static  By ADVANCEDSEARCHPOPUP_BRAND_DD    	        	 =By.xpath("//label[@class='ng-tns-c13-12 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']");
	private static  By ADVANCEDSEARCHPOPUP_BRANDVALUE_ST    		 =By.xpath("//span[text()=\"TRW\"]");
	private static  By ADVANCEDSEARCHPOPUP_MANUFACTURER_DD    	     =By.xpath("//label[@class='ng-tns-c13-13 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']");
	private static  By ADVANCEDSEARCHPOPUP_MANUFACTURERVALUE_ST    	 =By.xpath("//span[text()=\"Ford\"]");
	private static  By ADVANCEDSEARCHPOPUP_DATEFROM_EB    	 		 =By.xpath("//input[@name='minDate']");
	private static  By ADVANCEDSEARCHPOPUP_DATEFROM_DT    	 		 =By.xpath("//div[contains(@class,'datepicker')][1]//td[contains(@class,'ui-datepicker-today')]/preceding-sibling::td[1]/a");
	private static  By ADVANCEDSEARCHPOPUP_DATETO_EB    			 =By.xpath("//input[@name='maxDate']");
	private static  By ADVANCEDSEARCHPOPUP_DATETO_DT    	 		 =By.xpath("//div[contains(@class,'datepicker')][1]//td[contains(@class,'ui-datepicker-today')]/a");
	private static  By ADVANCEDSEARCHPOPUP_APPLY_BT    	 		 	 =By.xpath("//button[@class='fr primary apply-btn zf-button ']");
	private static  By ASSETS_COUNTRYVALUE_DT   	 	             =By.xpath("//div[@title='Czech Republic']");
	private static  By ASSETS_AREAVALUE_DT   	 	                 =By.xpath("//div[@title='Brno']");
	private static  By ASSETS_NOASSETSFOUND_DT   	 	             =By.xpath("//div[text()=\"No assets found.\"]");
	private static  By CREATE_ASSET_COUNTRY_DD   	 	             =By.xpath("//p-dropdown[@name='country']");
	private static  By CREATE_ASSET_AREA_DD   	 	                 =By.xpath("//p-dropdown[@name='area']");
	private static  By CREATE_ASSET_LOCATION_ADDRESS_RB   	 	     =By.xpath("(//span[contains(@class,'ui-radiobutton-icon ui-clickable')])[1]");
	private static  By CREATE_ASSET_LOCATION_DESCRIPTION_EB          =By.xpath("//textarea[@name='address']");
	private static  By CREATE_ASSET_CUSTOMER_DD   	 	             =By.xpath("//p-dropdown[@name='customer']");
	private static  By CREATE_ASSET_BUSINESSUNIT_DD                  =By.xpath("//p-dropdown[@name='business']");
	private static  By CREATE_ASSET_NEXT_BT                          =By.xpath("(//button[@class='zf-button primary fr'])[1]");
	private static  By CREATE_ASSET_ASSETNAME_EB   	 	             =By.xpath("//input[@name='name']");
	private static  By CREATE_ASSET_ASSETTYPE_DD                     =By.xpath("//p-dropdown[@name='type']");
	private static  By CREATE_ASSET_MANUFACTURER_DD                  =By.xpath("//p-dropdown[@name='manufacturer']");
	private static  By CREATE_ASSET_MODEL_DD   	 	                 =By.xpath("//p-dropdown[@name='model']");
	private static  By CREATE_ASSET_BRAND_DD                         =By.xpath("//p-dropdown[@name='brand']");
	private static  By CREATE_ASSET_SERIALNUMBER_EB                  =By.xpath("//input[@name='serialNo']");
	private static  By CREATE_ASSET_SENSORID_EB                      =By.xpath("//input[@name='sensorId']");
	private static  By CREATE_ASSET_MAPTOGATEWAY_EB                  =By.xpath("//input[@name='mappedGateway']");
	private static  By CREATE_ASSET_DETAILS_NEXT_BT                  =By.xpath("(//button[@class='zf-button primary fr'])[2]");
	private static  By CREATE_ASSET_MAPTOGATEWAY_BT                  =By.xpath("//button[@class='zf-button primary map-gateway-btn']");
	private static  By CREATE_ASSET_MAPTOGATEWAY_FIRSTRAW_LT         =By.xpath("//div[@class='main-details fw']");
	private static  By CREATE_ASSET_MAPTOGATEWAY_MAP_BT              =By.xpath("//button[@class='zf-button fr map-btn ng-star-inserted']");
	private static  By CREATE_ASSET_DESCRIPTION_EB                   =By.xpath("//textarea[@name='description']");
	private static  By CREATE_ASSET_SUBMIT_BT                        =By.xpath("(//button[@class='zf-button primary fr'])[3]");
	private static  By CREATE_ASSET_LICENSEPLATE_VALUE_EB            =By.xpath("//input[@class='fw value_0 ng-untouched ng-pristine ng-star-inserted ng-invalid']");
	private static  By CREATE_ASSET_PROPULSIONTYPE_VALUE_EB          =By.xpath("//input[@class='fw value_1 ng-untouched ng-pristine ng-star-inserted ng-invalid']");
	private static  By CREATE_ASSET_VEHICLETYPE_VALUE_EB             =By.xpath("//input[@class='fw value_2 ng-untouched ng-pristine ng-star-inserted ng-invalid']");
	private static  By CREATE_ASSET_VIN_VALUE_EB                     =By.xpath("//input[@class='fw value_3 ng-untouched ng-pristine ng-star-inserted ng-invalid']");
	private static  By CREATE_ASSET_MANUFACTURER_VALUE_EB            =By.xpath("//input[@class='fw value_4 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static  By CREATE_ASSET_MODEL_VALUE_EB                   =By.xpath("//input[@class='fw value_5 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static  By CREATE_ASSET_PRODUCER_VALUE_EB                =By.xpath("//input[@class='fw value_6 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static  By CREATE_ASSET_UPDATEDVIN_VALUE_EB              =By.xpath("//input[@class='fw value_3 ng-star-inserted ng-dirty ng-valid ng-touched']");
	private static  By CREATE_ASSET_TOASTER_MSG			   			 =By.xpath("//div[@class='toast-title']");
	private static  By CREATE_ASSET_TOASTER_MSG_TXT					 =By.xpath("//div[@class='ng-star-inserted']");
	private static By ASSETSDETAILS_BASICDETAILS_EDIT_BT             =By.xpath("(//div[@class='fl edit-icon sprite'])[1]");
	private static By ASSETS_LIST_FIRST_VALUE                        =By.xpath("(//span[@class='uppercase'])[1]");
	private static By ASSETS_LIST_FIRST_EXPANDARROW_BT               =By.xpath("(//div[@class='go-to-icon sprite'])[1]");
	private static By ASSETS_ACTION_BT                               =By.xpath("//button[@class='zf-button primary action ng-star-inserted']");
	private static By ASSETS_ACTION_EDIT_BT                          =By.xpath("//div[@class='edit-icon sprite fl']");

	private static By ASSETS_ACTION_RESETALL_BT                      =By.xpath("//button[@class='zf-button fl']");
	private static By ASSETS_ACTION_APPLY_BT                         =By.xpath("//button[@class='zf-button fr']");
	private static By CREATE_ASSET_SETACTIONS_BT               		 =By.xpath("//button[text()=\" Set Actions \"]");
	private static By CREATE_ASSET_SETACTIONS_DEACTIVATE_CB          =By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]");
	private static By CREATE_ASSET_SETACTIONS_ACTIVATE_CB            =By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[2]");
	private static By CREATE_ASSET_SETACTIONS_APPLY_BT           	 =By.xpath("//button[text()=\"Apply\"]");
	private static  By ASSET_OPERATOR_TOASTERMESSAGE				 =By.xpath("//div[@class='ng-star-inserted']");
	private static String DROPDOWNLIST							     ="//span[text()='{}']";
	private static By ASSETSDETAILS_ADDCHILDASSET_BT                 =By.xpath("//i[@class='fa fa-plus']");
	private static By ASSETSDETAILS_ADDEDASSET_BT                    =By.xpath( "//span[@class='ui-treenode-icon default root ng-star-inserted']");
	private static By ASSET_SORT_BY_DD								 =By.xpath("//p-dropdown[@optionlabel='category']/div[contains(@class,'ui-dropdown')]");
	private static By ASSET_AREA								     =By.xpath("//p-dropdown/descendant::span[text()='Area']");
	private static By ASSET_BRAND								     =By.xpath("//p-dropdown/descendant::span[text()='Brand']");
	private static By ASSET_BUSINESS_UNIT							 =By.xpath("//p-dropdown/descendant::span[text()='Business Unit']");
	private static By ASSET_COUNTRY									 =By.xpath("//p-dropdown/descendant::span[text()='Country']");
	private static By ASSET_CUSTOMER								 =By.xpath("//p-dropdown/descendant::span[text()='Customer']");
	private static By ASSET_MANUFACTURER							 =By.xpath("//p-dropdown/descendant::span[text()='Manufacturer']");
	private static By ASSET_TYPE									 =By.xpath("//p-dropdown/descendant::span[text()='Type']");
	private static By LOADER_SYMBOL									 =By.xpath("//div[contains(@class,'overlay-wrapper')]/div[contains(@class,'loader')]");

	private static By ASSET_LICENSEPLATE_KEY_EB						 =By.xpath("//input[@class='no-drop cell key_0 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static By ASSET_PROPULSIONTYPE_KEY_EB					 =By.xpath("//input[@class='no-drop cell key_1 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static By ASSET_VEHICLE_KEY_EB							 =By.xpath("//input[@class='no-drop cell key_2 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static By ASSET_VIN_KEY_EB								 =By.xpath("//input[@class='no-drop cell key_3 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static By ASSET_AREA_EB									 =By.xpath("//input[@name='area']");

	public void clickCreateAssets() {

		try {
			waitElementVisibleClick(HOMEPAGE_ASSETS_lK,500); 
			sleep(10000);
			waitElementVisibleClick(ASSETS_CREATEASSET_BT,800);
			sleep(5000);
		} catch (InterruptedException e) {
			TestLogger.fileInfo(e.getMessage());
		}

	}


	public void assetPageValidation() {
		try {

			//TestRail#C48965 - Verify the UI of Search section in Asset landing Page"
			waitElementVisibleClick(HOMEPAGE_ASSETS_lK,600); 
			
			//TestRail#C48954 - Navigate to Assets Page
			elementAvailability(ASSETS_ZFLOGO_IMG);

			//TestRail#C48965 - Verify the UI of Search section in Asset landing Page"
			elementAvailability(ASSETS_SEARCH_EB);
			elementAvailability(ASSETS_SEARCH_BT);

			//TestRail#C48955 - Verify the UI of Assets landing page
			elementAvailability(ASSETS_COUNTRY_ST);
			elementAvailability(ASSETS_AREA_ST);
			elementAvailability(ASSETS_CUSTOMER_ST);
			elementAvailability(ASSETS_BUSSINESSUNIT_ST);
			elementAvailability(ASSETS_SORTBY_ST);
			elementAvailability(ASSETS_ASSETTYPE_ST);
			elementAvailability(ASSETS_MANUFACTURER_ST);
			elementAvailability(ASSETS_BRAND_ST);
			elementAvailability(ASSETS_DATE_ST);
			elementAvailability(ASSETS_CLEARALL_LK);
			elementAvailability(ASSETS_CREATEASSET_BT);

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}


	public void assetSearch() {
		try {
			JsonReader.getJsonObject("TCO2AssetSearch");
			waitElementVisibleClick(HOMEPAGE_ASSETS_lK,600); 
		
			waitElementToBeVisibleSendValue(ASSETS_SEARCH_EB,800, jsonData.getJsonData("AssetName"));
			elementClick(ASSETS_COUNTRY_DD);
			elementClick(ASSETS_CZECHREPUBLIC_CB);
			elementClick(ASSETS_AREA_DD);
			elementClick(ASSETS_BRNO_CB);
			elementClick(ASSETS_CUSTOMER_DD);
			elementClick(ASSETS_ZF_CB);
			elementClick(ASSETS_BUSSINESSUNIT_DD);
			elementClick(ASSETS_FACTORY_CB);
			elementClick(ASSETS_SEARCH_BT);
			compareText(jsonData.getJsonData("AssetName"), elementGetText(ASSETS_SEARCHVALUE_DT));

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}


	public void assetAdvancedSearch() {
		try {
			JsonReader.getJsonObject("TCO3AssetAdvacnedSearch");
			waitElementVisibleClick(HOMEPAGE_ASSETS_lK,500);
			
			waitElementVisibleClick(ASSETS_ADVANCEDSEARCH_BT,800);
			elementClick(ADVANCEDSEARCHPOPUP_ASSETTYPE_DD);
			elementClick(ADVANCEDSEARCHPOPUP_BASICASSETTYPEVALUE_ST);
			elementClick(ADVANCEDSEARCHPOPUP_BRAND_DD);
			elementClick(ADVANCEDSEARCHPOPUP_BRANDVALUE_ST);
			elementClick(ADVANCEDSEARCHPOPUP_MANUFACTURER_DD);
			elementClick(ADVANCEDSEARCHPOPUP_MANUFACTURERVALUE_ST);
			elementClick(ADVANCEDSEARCHPOPUP_DATEFROM_EB);
			elementClick(ADVANCEDSEARCHPOPUP_DATEFROM_DT);
			elementClick(ADVANCEDSEARCHPOPUP_DATETO_EB);
			elementClick(ADVANCEDSEARCHPOPUP_DATETO_DT);
			elementClick(ADVANCEDSEARCHPOPUP_APPLY_BT);
			compareText(jsonData.getJsonData("BasicAssestType"), elementGetText(ADVANCEDSEARCHPOPUP_BASICASSETTYPEVALUE_ST));
			compareText(jsonData.getJsonData("Brand"), elementGetText(ADVANCEDSEARCHPOPUP_BRANDVALUE_ST));
			compareText(jsonData.getJsonData("Manufacturer"), elementGetText(ADVANCEDSEARCHPOPUP_MANUFACTURERVALUE_ST));

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}


	public void clearAllFilter() {
		try {
			JsonReader.getJsonObject("TCO4clearAllFilter");
			waitElementVisibleClick(HOMEPAGE_ASSETS_lK,600); 
	
			waitElementToBeVisibleSendValue(ASSETS_SEARCH_EB,800, jsonData.getJsonData("AssetName"));
			waitElementVisibleClick(ASSETS_COUNTRY_DD,500);
			elementClick(ASSETS_CZECHREPUBLIC_CB);
			elementClick(ASSETS_AREA_DD);
			elementClick(ASSETS_BRNO_CB);
			elementClick(ASSETS_CUSTOMER_DD);
			elementClick(ASSETS_ZF_CB);
			elementClick(ASSETS_BUSSINESSUNIT_DD);
			elementClick(ASSETS_FACTORY_CB);
			waitElementVisibleClick(ASSETS_ADVANCEDSEARCH_BT,500);
			elementClick(ADVANCEDSEARCHPOPUP_ASSETTYPE_DD);
			elementClick(ADVANCEDSEARCHPOPUP_BASICASSETTYPEVALUE_ST);
			elementClick(ADVANCEDSEARCHPOPUP_BRAND_DD);
			elementClick(ADVANCEDSEARCHPOPUP_BRANDVALUE_ST);
			elementClick(ADVANCEDSEARCHPOPUP_MANUFACTURER_DD);
			elementClick(ADVANCEDSEARCHPOPUP_MANUFACTURERVALUE_ST);
			elementClick(ADVANCEDSEARCHPOPUP_DATEFROM_EB);
			elementClick(ADVANCEDSEARCHPOPUP_DATEFROM_DT);
			elementClick(ADVANCEDSEARCHPOPUP_DATETO_EB);
			elementClick(ADVANCEDSEARCHPOPUP_DATETO_DT);
			elementClick(ADVANCEDSEARCHPOPUP_APPLY_BT);
			elementClick(ASSETS_CLEARALL_LK);
			checkfiltercleared(ASSETS_AREAVALUE_DT);
			checkfiltercleared(ASSETS_COUNTRYVALUE_DT);
			checkfiltercleared(ADVANCEDSEARCHPOPUP_BASICASSETTYPEVALUE_ST);
			checkfiltercleared(ADVANCEDSEARCHPOPUP_BRANDVALUE_ST);
			checkfiltercleared(ADVANCEDSEARCHPOPUP_MANUFACTURERVALUE_ST);

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}


	public void assetSearchWithInvalidKey() {
		try {
			JsonReader.getJsonObject("TCO5AssetSearchWithInvalidKey");
			waitElementVisibleClick(HOMEPAGE_ASSETS_lK,600); 
			
			waitElementToBeVisibleSendValue(ASSETS_SEARCH_EB,600, jsonData.getJsonData("AssetName"));
			waitElementVisibleClick(ASSETS_COUNTRY_DD,300);
			elementClick(ASSETS_CZECHREPUBLIC_CB);
			elementClick(ASSETS_AREA_DD);
			elementClick(ASSETS_BRNO_CB);
			elementClick(ASSETS_CUSTOMER_DD);
			elementClick(ASSETS_ZF_CB);
			elementClick(ASSETS_BUSSINESSUNIT_DD);
			elementClick(ASSETS_FACTORY_CB);
			waitElementVisibleClick(ASSETS_SEARCH_BT,600);
			compareText(jsonData.getJsonData("Noresultvalue"), elementGetText(ASSETS_NOASSETSFOUND_DT));

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}

	public void checkfiltercleared(By byType) {
		try {
			if(DriverManager.getDriverInstance().findElement(byType).isDisplayed())
			{
				ExtentReport.testFailed("Element is  diaplayed after the clicking clear all "+byType.toString());
			} 

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}finally{
			ExtentReport.testPassed("Element is not diaplayed after the clicking clear all "+byType.toString());
		}

	}

	public void createAssetstWithAllFeilds() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("TCO6CreateAssetstWithAllFeilds");
			waitElementVisibleClick(CREATE_ASSET_COUNTRY_DD,600); 
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Country")));
			elementClick(CREATE_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Area")));
			elementClickRadioButton(CREATE_ASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(CREATE_ASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(CREATE_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Customer")));
			elementClick(CREATE_ASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"BusinessUnit")));
			elementClick(CREATE_ASSET_NEXT_BT);

			elementSendKeys(CREATE_ASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(CREATE_ASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"AssetType")));
			elementClick(CREATE_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Manufacturer")));
			elementClick(CREATE_ASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Model")));
			elementClick(CREATE_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Brand")));
			elementSendKeys(CREATE_ASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(CREATE_ASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));
			elementClick(CREATE_ASSET_MAPTOGATEWAY_BT);
			elementClick(CREATE_ASSET_MAPTOGATEWAY_FIRSTRAW_LT);
			elementClick(CREATE_ASSET_MAPTOGATEWAY_MAP_BT);
			elementClick(CREATE_ASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(CREATE_ASSET_DESCRIPTION_EB,300,jsonData.getJsonData("Description"));
			//			elementSendKeys(CREATE_ASSET_LICENSEPLATE_VALUE_EB,jsonData.getJsonData("MetaDatalicensePlate"));
			//			elementSendKeys(CREATE_ASSET_PROPULSIONTYPE_VALUE_EB,jsonData.getJsonData("MetaDataPropulsionType"));
			//			elementSendKeys(CREATE_ASSET_VEHICLETYPE_VALUE_EB,jsonData.getJsonData("MetaDatavehicleType"));
			//			elementSendKeys(CREATE_ASSET_VIN_VALUE_EB,jsonData.getJsonData("MetaDatavin"));
			elementClick(CREATE_ASSET_SUBMIT_BT);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageSuccess",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}
	public void createAssetstWithAllAutopopulatedMetadataKeys() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("createAssetstWithAllAutopopulatedMetadataKeys");
			waitElementVisibleClick(CREATE_ASSET_COUNTRY_DD,600); 
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Country")));
			elementClick(CREATE_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Area")));
			elementClickRadioButton(CREATE_ASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(CREATE_ASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(CREATE_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Customer")));
			elementClick(CREATE_ASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"BusinessUnit")));
			elementClick(CREATE_ASSET_NEXT_BT);

			elementSendKeys(CREATE_ASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(CREATE_ASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"AssetType")));
			elementClick(CREATE_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Manufacturer")));
			elementClick(CREATE_ASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Model")));
			elementClick(CREATE_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Brand")));
			elementSendKeys(CREATE_ASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(CREATE_ASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));

			elementClick(CREATE_ASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(CREATE_ASSET_DESCRIPTION_EB,300,(jsonData.getJsonData("Description")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_LICENSEPLATE_VALUE_EB,(jsonData.getJsonData("MetaDatalicensePlate")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_PROPULSIONTYPE_VALUE_EB,(jsonData.getJsonData("MetaDataPropulsionType")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_VEHICLETYPE_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleType")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_VIN_VALUE_EB,(jsonData.getJsonData("MetaDatavin")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_MANUFACTURER_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleManufacturer")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_MODEL_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleModel")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_PRODUCER_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleProducer")+generateRandomNumber()));
			elementClick(CREATE_ASSET_SUBMIT_BT);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageSuccess",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}

	public void createAssetstWithMandatoryAutopopulatedMetadataKeys() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("createAssetstWithMandatoryAutopopulatedMetadataKeys");
			waitElementVisibleClick(CREATE_ASSET_COUNTRY_DD,600); 
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Country")));
			elementClick(CREATE_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Area")));
			elementClickRadioButton(CREATE_ASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(CREATE_ASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(CREATE_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Customer")));
			elementClick(CREATE_ASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"BusinessUnit")));
			elementClick(CREATE_ASSET_NEXT_BT);

			elementSendKeys(CREATE_ASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(CREATE_ASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"AssetType")));
			elementClick(CREATE_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Manufacturer")));
			elementClick(CREATE_ASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Model")));
			elementClick(CREATE_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Brand")));
			elementSendKeys(CREATE_ASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(CREATE_ASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));

			elementClick(CREATE_ASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(CREATE_ASSET_DESCRIPTION_EB,500,(jsonData.getJsonData("Description")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_LICENSEPLATE_VALUE_EB,(jsonData.getJsonData("MetaDatalicensePlate")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_PROPULSIONTYPE_VALUE_EB,(jsonData.getJsonData("MetaDataPropulsionType")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_VEHICLETYPE_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleType")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_VIN_VALUE_EB,(jsonData.getJsonData("MetaDatavin")+generateRandomNumber()));
			elementClick(CREATE_ASSET_SUBMIT_BT);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageSuccess",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}



	public void verifyVehicleAssetstWithMandatoryAutopopulatedMetadataKeys() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("verifyVehicleAssetstWithMandatoryAutopopulatedMetadataKeys");
			waitElementVisibleClick(CREATE_ASSET_COUNTRY_DD,600); 
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Country")));
			elementClick(CREATE_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Area")));
			elementClickRadioButton(CREATE_ASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(CREATE_ASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(CREATE_ASSET_NEXT_BT);
			waitElementVisibleClick(CREATE_ASSET_ASSETTYPE_DD,500);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"AssetType")));
		
			
			elementSendKeys(CREATE_ASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(CREATE_ASSET_DETAILS_NEXT_BT);
			compareText(elementGetValue(ASSET_LICENSEPLATE_KEY_EB,"value"),jsonData.getJsonData("MetaDatalicensePlate"));
			compareText(elementGetValue(ASSET_PROPULSIONTYPE_KEY_EB,"value"),jsonData.getJsonData("MetaDataPropulsionType"));
			compareText(elementGetValue(ASSET_VEHICLE_KEY_EB,"value"),jsonData.getJsonData("MetaDatavehicleType"));
			compareText(elementGetValue(ASSET_VIN_KEY_EB,"value"),jsonData.getJsonData("MetaDatavin"));


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}

	public void fieldValidationsMandatoryFieldVin() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("fieldValidationsMandatoryFieldVin");
			waitElementVisibleClick(CREATE_ASSET_COUNTRY_DD,500); 
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Country")));
			elementClick(CREATE_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Area")));
			elementClickRadioButton(CREATE_ASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(CREATE_ASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(CREATE_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Customer")));
			elementClick(CREATE_ASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"BusinessUnit")));
			elementClick(CREATE_ASSET_NEXT_BT);

			elementSendKeys(CREATE_ASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(CREATE_ASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"AssetType")));
			elementClick(CREATE_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Manufacturer")));
			elementClick(CREATE_ASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Model")));
			elementClick(CREATE_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Brand")));
			elementSendKeys(CREATE_ASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(CREATE_ASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));
			elementClick(CREATE_ASSET_DETAILS_NEXT_BT);
			waitElementToBeVisibleSendValue(CREATE_ASSET_DESCRIPTION_EB,300,(jsonData.getJsonData("Description")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_LICENSEPLATE_VALUE_EB,(jsonData.getJsonData("MetaDatalicensePlate")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_PROPULSIONTYPE_VALUE_EB,(jsonData.getJsonData("MetaDataPropulsionType")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_VEHICLETYPE_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleType")+generateRandomNumber()));
			elementSendKeys(CREATE_ASSET_VIN_VALUE_EB,(jsonData.getJsonData("MetaDatavin")+generateRandomNumber()));
			elementClick(CREATE_ASSET_SUBMIT_BT);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageFailed",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
			sleep(3000);
			elementSendKeys(CREATE_ASSET_UPDATEDVIN_VALUE_EB,(jsonData.getJsonData("MetaDatavin1")+generateRandomNumber()));
			elementClick(CREATE_ASSET_SUBMIT_BT);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageFailed",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
			sleep(3000);
			elementSendKeys(CREATE_ASSET_UPDATEDVIN_VALUE_EB,(jsonData.getJsonData("MetaDatavin2")+generateRandomNumber()));
			elementClick(CREATE_ASSET_SUBMIT_BT);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageSuccess",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}
	public void createAssetWithoutMandatoryInput() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("createAssetWithoutMandatoryInput");
			submitButtonVisibility(CREATE_ASSET_NEXT_BT," when Address in not entered");
			waitElementToBeVisibleSendValue(CREATE_ASSET_LOCATION_DESCRIPTION_EB,300,jsonData.getJsonData("LocationAddress"));
			waitElementVisibleClick(CREATE_ASSET_NEXT_BT,300);
			submitButtonVisibility(CREATE_ASSET_DETAILS_NEXT_BT,"when Name in not entered");
			waitElementToBeVisibleSendValue(CREATE_ASSET_ASSETNAME_EB,300,jsonData.getJsonData("AssetName"));
			elementClick(CREATE_ASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"AssetType")));
			elementClick(CREATE_ASSET_DETAILS_NEXT_BT);

			submitButtonVisibility(CREATE_ASSET_SUBMIT_BT,"when license plate, Propulsion type, Vehicle type, VIN are not entered");
			waitElementToBeVisibleSendValue(CREATE_ASSET_LICENSEPLATE_VALUE_EB,300,jsonData.getJsonData("MetaDatalicensePlate"));
			submitButtonVisibility(CREATE_ASSET_SUBMIT_BT,"when Propulsion type, Vehicle type, VIN are not entered");
			elementSendKeys(CREATE_ASSET_PROPULSIONTYPE_VALUE_EB,jsonData.getJsonData("MetaDataPropulsionType"));
			submitButtonVisibility(CREATE_ASSET_SUBMIT_BT,"when Vehicle type and VIN value are not entered");
			elementSendKeys(CREATE_ASSET_VEHICLETYPE_VALUE_EB,jsonData.getJsonData("MetaDatavehicleType"));
			submitButtonVisibility(CREATE_ASSET_SUBMIT_BT,"when VIN value is not entered");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}
	public void executeActionWithoutParamater() {
		try {
			createAssetstWithAllFeilds();
			JsonReader.getJsonObject("executeActionWithoutParamater");
			selectAssetDetails("executeActionWithoutParamater");
			waitElementVisibleClick(ASSETS_ACTION_BT,500);
			elementClick(ASSETS_ACTION_EDIT_BT);
			elementClick(ASSETS_ACTION_RESETALL_BT);
			waitElementVisibleClick(ASSETS_ACTION_APPLY_BT,500);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageSuccess",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void executeActionWithParamater() {
		try {
			createAssetstWithAllFeilds();
			JsonReader.getJsonObject("executeActionWithParamater");
			selectAssetDetails("executeActionWithoutParamater");
			elementClick(ASSETS_ACTION_BT);
			elementClick(ASSETS_ACTION_EDIT_BT);
			elementClick(ASSETS_ACTION_RESETALL_BT);
			elementClick(CREATE_ASSET_SETACTIONS_ACTIVATE_CB);
			waitElementVisibleClick(ASSETS_ACTION_APPLY_BT,500);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageSuccess",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void submitButtonVisibility(By byType,String message) {
		try {

			if(elementGetValue(byType,"disabled")!=null) {
				testPassed("SUBMIT button is disabled "+message);

			}
			else {
				testFailed("Message failed");
			}
		}
		catch(Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public void CreateAssetstWithActions() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("TCO7CreateAssetstWithActions");
			waitElementVisibleClick(CREATE_ASSET_COUNTRY_DD,500); 
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Country")));
			elementClick(CREATE_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Area")));
			elementClickRadioButton(CREATE_ASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(CREATE_ASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(CREATE_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Customer")));
			elementClick(CREATE_ASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"BusinessUnit")));
			//Set Actions 
			elementClick(CREATE_ASSET_SETACTIONS_BT);
			setActions(jsonData.getJsonData("Action"));// Actions functionality has not been implemented
			elementClick(CREATE_ASSET_NEXT_BT);

			elementSendKeys(CREATE_ASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(CREATE_ASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"AssetType")));
			elementClick(CREATE_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Manufacturer")));
			elementClick(CREATE_ASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Model")));
			elementClick(CREATE_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Brand")));
			elementSendKeys(CREATE_ASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(CREATE_ASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));
			elementClick(CREATE_ASSET_MAPTOGATEWAY_BT);
			elementClick(CREATE_ASSET_MAPTOGATEWAY_FIRSTRAW_LT);
			elementClick(CREATE_ASSET_MAPTOGATEWAY_MAP_BT);
			elementClick(CREATE_ASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(CREATE_ASSET_DESCRIPTION_EB,500,jsonData.getJsonData("Description"));
			elementSendKeys(CREATE_ASSET_LICENSEPLATE_VALUE_EB,jsonData.getJsonData("MetaDatalicensePlate")+generateRandomNumber());
			elementSendKeys(CREATE_ASSET_PROPULSIONTYPE_VALUE_EB,jsonData.getJsonData("MetaDataPropulsionType")+generateRandomNumber());
			elementSendKeys(CREATE_ASSET_VEHICLETYPE_VALUE_EB,jsonData.getJsonData("MetaDatavehicleType")+generateRandomNumber());
			elementSendKeys(CREATE_ASSET_VIN_VALUE_EB,jsonData.getJsonData("MetaDatavin")+generateRandomNumber());
			elementClick(CREATE_ASSET_SUBMIT_BT);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageSuccess",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}

	public void editAssetstActions() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("TCO9EditAssetstActions");
			waitElementVisibleClick(CREATE_ASSET_COUNTRY_DD,600); 
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Country")));
			elementClick(CREATE_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Area")));
			elementClickRadioButton(CREATE_ASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(CREATE_ASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(CREATE_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Customer")));
			elementClick(CREATE_ASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"BusinessUnit")));
			//Set Actions 
			elementClick(CREATE_ASSET_SETACTIONS_BT);
			setActions(jsonData.getJsonData("Action")); // Actions functionality has not been implemented 
			elementClick(CREATE_ASSET_NEXT_BT);

			elementSendKeys(CREATE_ASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(CREATE_ASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"AssetType")));
			elementClick(CREATE_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Manufacturer")));
			elementClick(CREATE_ASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Model")));
			elementClick(CREATE_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Brand")));
			elementSendKeys(CREATE_ASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(CREATE_ASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));
			elementClick(CREATE_ASSET_MAPTOGATEWAY_BT);
			elementClick(CREATE_ASSET_MAPTOGATEWAY_FIRSTRAW_LT);
			elementClick(CREATE_ASSET_MAPTOGATEWAY_MAP_BT);
			elementClick(CREATE_ASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(CREATE_ASSET_DESCRIPTION_EB,300,jsonData.getJsonData("Description"));
			elementSendKeys(CREATE_ASSET_LICENSEPLATE_VALUE_EB,jsonData.getJsonData("MetaDatalicensePlate")+generateRandomNumber());
			elementSendKeys(CREATE_ASSET_PROPULSIONTYPE_VALUE_EB,jsonData.getJsonData("MetaDataPropulsionType")+generateRandomNumber());
			elementSendKeys(CREATE_ASSET_VEHICLETYPE_VALUE_EB,jsonData.getJsonData("MetaDatavehicleType")+generateRandomNumber());
			elementSendKeys(CREATE_ASSET_VIN_VALUE_EB,jsonData.getJsonData("MetaDatavin")+generateRandomNumber());
			elementClick(CREATE_ASSET_SUBMIT_BT);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageSuccess",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}

	public void editExistAssetDetails() {
		try {
			JsonReader.getJsonObject("TCO8editExistAssetDetails");
			selectAssetDetails("editExistAssetDetails");
			waitElementVisibleClick(ASSETSDETAILS_BASICDETAILS_EDIT_BT,600);
			elementClick(CREATE_ASSET_COUNTRY_DD); 
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Country")));
			elementClick(CREATE_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Area")));
			elementClickRadioButton(CREATE_ASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(CREATE_ASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(CREATE_ASSET_NEXT_BT);
			elementClick(CREATE_ASSET_DETAILS_NEXT_BT);
			elementClick(CREATE_ASSET_SUBMIT_BT);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageSuccess",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");
		}catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}


	public void createChildAssetWithAllFeilds() {
		try {
			createAssetstWithAllFeilds();
			JsonReader.getJsonObject("CreateChildAssettWithAllFeilds");
			elementClick(ASSETSDETAILS_ADDEDASSET_BT);
			waitElementVisibleClick(ASSETSDETAILS_ADDCHILDASSET_BT,600);
			waitElementVisibleClick(CREATE_ASSET_COUNTRY_DD,300); 
			waitElementVisibleClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Country")),500);
			elementClick(CREATE_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Area")));
			elementClickRadioButton(CREATE_ASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(CREATE_ASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(CREATE_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Customer")));
			elementClick(CREATE_ASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"BusinessUnit")));
			elementClick(CREATE_ASSET_NEXT_BT);

			elementSendKeys(CREATE_ASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(CREATE_ASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"AssetType")));
			elementClick(CREATE_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Manufacturer")));
			elementClick(CREATE_ASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Model")));
			elementClick(CREATE_ASSET_BRAND_DD);
			waitElementVisibleClick(By.xpath(dynamicXpath(DROPDOWNLIST,"Brand")),300);
			elementSendKeys(CREATE_ASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(CREATE_ASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));
			elementClick(CREATE_ASSET_MAPTOGATEWAY_BT);
			elementClick(CREATE_ASSET_MAPTOGATEWAY_FIRSTRAW_LT);
			elementClick(CREATE_ASSET_MAPTOGATEWAY_MAP_BT);
			elementClick(CREATE_ASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(CREATE_ASSET_DESCRIPTION_EB,300,jsonData.getJsonData("Description"));
			//			elementSendKeys(CREATE_ASSET_LICENSEPLATE_VALUE_EB,jsonData.getJsonData("MetaDatalicensePlate"));
			//			elementSendKeys(CREATE_ASSET_PROPULSIONTYPE_VALUE_EB,jsonData.getJsonData("MetaDataPropulsionType"));
			//			elementSendKeys(CREATE_ASSET_VEHICLETYPE_VALUE_EB,jsonData.getJsonData("MetaDatavehicleType"));
			//			elementSendKeys(CREATE_ASSET_VIN_VALUE_EB,jsonData.getJsonData("MetaDatavin"));
			elementClick(CREATE_ASSET_SUBMIT_BT);
			verifyToastermessage(CREATE_ASSET_TOASTER_MSG,"ToasterMessageSuccess",CREATE_ASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");

		}catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}



	public void verifyAssetActionsUI() {
		try {
			clickCreateAssets();
			elementAvailability(CREATE_ASSET_SETACTIONS_BT);
			elementClick(CREATE_ASSET_SETACTIONS_BT);
			elementAvailability(CREATE_ASSET_SETACTIONS_DEACTIVATE_CB);
			elementAvailability(CREATE_ASSET_SETACTIONS_ACTIVATE_CB);
			elementAvailability(CREATE_ASSET_SETACTIONS_APPLY_BT);

		}catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}

	public int generateRandomNumber() {
		Random rnd = new Random();
		int randomNum = (int) (rnd.nextInt(9999));
		return randomNum;
	}


	public void verifyToastermessage(By ByType1, String Jsondata1,By ByType2, String Jsondata2) {
		try {
			
			String toasterMessage = waitElementVisibleGetText(ByType1,300);
			compareText(jsonData.getJsonData(Jsondata1),toasterMessage);
			String toasterMessageText = elementGetText(ByType2);
			compareText(jsonData.getJsonData(Jsondata2),toasterMessageText);
		}catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}}

	public	String dynamicXpath(String xpath, String Jsonvalue) {
		return updateXpath(xpath,jsonData.getJsonData(Jsonvalue));
	}

	public void selectAssetDetails(String jsonObject){

		try {
			JsonReader.getJsonObject(jsonObject);
			String jsonValue = jsonData.getJsonData("AssetName");
			waitElementVisibleClick(HOMEPAGE_ASSETS_lK,600); 
			waitElementToBeVisibleSendValue(ASSETS_SEARCH_EB,500, jsonValue);
			waitElementVisibleClick(ASSETS_SEARCH_BT,500);
			sleep(3000);
			if(waitElementVisibleGetText(ASSETS_LIST_FIRST_VALUE,500).equalsIgnoreCase(jsonValue)){
				sleep(1000);
				waitElementVisibleClick(ASSETS_LIST_FIRST_EXPANDARROW_BT,600);
				sleep(1000);
			}else {
				testFailed(jsonData.getJsonData("AssetName")+" is not displayed in search result");
			}

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}


	public void setActions(String jsonObject) {
		try {

			if(jsonObject.equalsIgnoreCase("activate")) {

				waitElementVisibleClick(CREATE_ASSET_SETACTIONS_DEACTIVATE_CB,600);
			}else {
				waitElementVisibleClick(CREATE_ASSET_SETACTIONS_ACTIVATE_CB,600);
			}
			elementClick(CREATE_ASSET_SETACTIONS_APPLY_BT);

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}


	public void operatorHasNoAccessToCreateAsset()
	{
		try {
			JsonReader.getJsonObject("OperatorHasNoAccess");
			waitElementVisibleClick(HOMEPAGE_ASSETS_lK,800); 
			waitElementVisibleClick(ASSETS_CREATEASSET_BT,300);
			verifyToastermessage("ToasterMessageFailedReason");
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		} 


	}

	public void userWithNoPrivilegeCannotAccessAssetsPage()
	{

		JsonReader.getJsonObject("TCO3OperatorHasNoAccess");
		
		verifyToastermessage("ToasterMessageFailedReason");
	
	}

	public void SortAssetsInAssetsHomepage()
	{
		try {
			waitElementVisibleClick(HOMEPAGE_ASSETS_lK,700);
			//elementAvailability(LOADER_SYMBOL);
			sleep(5000);
			assetSortingDropDownNavigation(ASSET_BRAND);
			assetSortingDropDownNavigation(ASSET_BUSINESS_UNIT);
			assetSortingDropDownNavigation(ASSET_COUNTRY);
			assetSortingDropDownNavigation(ASSET_CUSTOMER);
			assetSortingDropDownNavigation(ASSET_MANUFACTURER);
			assetSortingDropDownNavigation(ASSET_TYPE);
			assetSortingDropDownNavigation(ASSET_AREA);
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void assetSortingDropDownNavigation(By Dropdownvalue)
	{
		elementClick(ASSET_SORT_BY_DD);
		elementClick(Dropdownvalue);
		elementAvailability(LOADER_SYMBOL);


	}
	public void verifyToastermessage(String Jsondata) {
		
		String toasterText;
		try {
			toasterText = waitElementVisibleGetText(ASSET_OPERATOR_TOASTERMESSAGE,300);
			compareText(jsonData.getJsonData(Jsondata),toasterText);
		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
		
	}
}
