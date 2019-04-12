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

	private static  By ASSETS_HOMEPAGE_lK   	 	                 =By.xpath("//a[@title='Assets']");	
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
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_ASSETTYPE_DD    	         =By.xpath("//label[@class='ng-tns-c13-11 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']");
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_BASICASSETTYPEVALUE_ST    =By.xpath("//span[text()=\"BASIC_ASSET_TYPE\"]");
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_BRAND_DD    	        	 =By.xpath("//label[@class='ng-tns-c13-12 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']");
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_BRANDVALUE_ST    		 =By.xpath("//span[text()=\"TRW\"]");
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_MANUFACTURER_DD    	     =By.xpath("//label[@class='ng-tns-c13-13 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']");
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_MANUFACTURERVALUE_ST    	 =By.xpath("//span[text()=\"Ford\"]");
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_DATEFROM_EB    	 		 =By.xpath("//input[@name='minDate']");
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_DATEFROM_DT    	 		 =By.xpath("//div[contains(@class,'datepicker')][1]//td[contains(@class,'ui-datepicker-today')]/preceding-sibling::td[1]/a");
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_DATETO_EB    			 =By.xpath("//input[@name='maxDate']");
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_DATETO_DT    	 		 =By.xpath("//div[contains(@class,'datepicker')][1]//td[contains(@class,'ui-datepicker-today')]/a");
	private static  By ASSETS_ADVANCEDSEARCHPOPUP_APPLY_BT    	 		 	 =By.xpath("//button[@class='fr primary apply-btn zf-button ']");
	private static  By ASSETS_COUNTRYVALUE_DT   	 	             =By.xpath("//div[@title='Czech Republic']");
	private static  By ASSETS_AREAVALUE_DT   	 	                 =By.xpath("//div[@title='Brno']");
	private static  By ASSETS_NOASSETSFOUND_DT   	 	             =By.xpath("//div[text()=\"No assets found.\"]");
	private static  By ASSETS_CREATEASSETS_ASSET_COUNTRY_DD   	 	             =By.xpath("//p-dropdown[@name='country']");
	private static  By ASSETS_CREATEASSETS_ASSET_AREA_DD   	 	                 =By.xpath("//p-dropdown[@name='area']");
	private static  By ASSETS_CREATEASSET_LOCATION_ADDRESS_RB   	 	     =By.xpath("(//span[contains(@class,'ui-radiobutton-icon ui-clickable')])[1]");
	private static  By ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB          =By.xpath("//textarea[@name='address']");
	private static  By ASSETS_CREATEASSETS_ASSET_CUSTOMER_DD   	 	             =By.xpath("//p-dropdown[@name='customer']");
	private static  By ASSETS_CREATEASSET_BUSINESSUNIT_DD                  =By.xpath("//p-dropdown[@name='business']");
	private static  By ASSETS_CREATEASSET_NEXT_BT                          =By.xpath("(//button[@class='zf-button primary fr'])[1]");
	private static  By ASSETS_CREATEASSET_ASSETNAME_EB   	 	             =By.xpath("//input[@name='name']");
	private static  By ASSETS_CREATEASSET_ASSETTYPE_DD                     =By.xpath("//p-dropdown[@name='type']");
	private static  By ASSETS_CREATEASSETS_ASSET_MANUFACTURER_DD                  =By.xpath("//p-dropdown[@name='manufacturer']");
	private static  By ASSETS_CREATEASSET_MODEL_DD   	 	                 =By.xpath("//p-dropdown[@name='model']");
	private static  By ASSETS_CREATEASSETS_ASSET_BRAND_DD                         =By.xpath("//p-dropdown[@name='brand']");
	private static  By ASSETS_CREATEASSET_SERIALNUMBER_EB                  =By.xpath("//input[@name='serialNo']");
	private static  By ASSETS_CREATEASSET_SENSORID_EB                      =By.xpath("//input[@name='sensorId']");
//	private static  By ASSETS_CREATEASSET_MAPTOGATEWAY_EB                  =By.xpath("//input[@name='mappedGateway']");
	private static  By ASSETS_CREATEASSET_DETAILS_NEXT_BT                  =By.xpath("(//button[@class='zf-button primary fr'])[2]");
	private static  By ASSETS_CREATEASSET_MAPTOGATEWAY_BT                  =By.xpath("//button[@class='zf-button primary map-gateway-btn']");
	private static  By ASSETS_CREATEASSET_MAPTOGATEWAY_FIRSTRAW_LT         =By.xpath("//div[@class='main-details fw']");
	private static  By ASSETS_CREATEASSET_MAPTOGATEWAY_MAP_BT              =By.xpath("//button[@class='zf-button fr map-btn ng-star-inserted']");
	private static  By ASSETS_CREATEASSET_DESCRIPTION_EB                   =By.xpath("//textarea[@name='description']");
	private static  By ASSETS_CREATEASSET_SUBMIT_BT                        =By.xpath("(//button[@class='zf-button primary fr'])[3]");
	private static  By ASSETS_CREATEASSET_LICENSEPLATE_VALUE_EB            =By.xpath("//input[@class='fw value_0 ng-untouched ng-pristine ng-star-inserted ng-invalid']");
	private static  By ASSETS_CREATEASSET_PROPULSIONTYPE_VALUE_EB          =By.xpath("//input[@class='fw value_1 ng-untouched ng-pristine ng-star-inserted ng-invalid']");
	private static  By ASSETS_CREATEASSET_VEHICLETYPE_VALUE_EB             =By.xpath("//input[@class='fw value_2 ng-untouched ng-pristine ng-star-inserted ng-invalid']");
	private static  By ASSETS_CREATEASSET_VIN_VALUE_EB                     =By.xpath("//input[@class='fw value_3 ng-untouched ng-pristine ng-star-inserted ng-invalid']");
	private static  By ASSETS_CREATEASSET_MANUFACTURER_VALUE_EB            =By.xpath("//input[@class='fw value_4 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static  By ASSETS_CREATEASSET_MODEL_VALUE_EB                   =By.xpath("//input[@class='fw value_5 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static  By ASSETS_CREATEASSET_PRODUCER_VALUE_EB                =By.xpath("//input[@class='fw value_6 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static  By ASSETS_CREATEASSET_UPDATEDVIN_VALUE_EB              =By.xpath("//input[@class='fw value_3 ng-star-inserted ng-dirty ng-valid ng-touched']");
	private static  By ASSETS_CREATEASSET_TOASTER_MSG			   			 =By.xpath("//div[@class='toast-title']");
	private static  By ASSETS_CREATEASSET_TOASTER_MSG_TXT					 =By.xpath("//div[@class='ng-star-inserted']");
	private static By ASSETS_ASSETSDETAILS_BASICDETAILS_EDIT_BT             =By.xpath("(//div[@class='fl edit-icon sprite'])[1]");
	private static By ASSETS_LIST_FIRST_VALUE                        =By.xpath("(//span[@class='uppercase'])[1]");
	private static By ASSETS_LIST_FIRST_EXPANDARROW_BT               =By.xpath("(//div[@class='go-to-icon sprite'])[1]");
	private static By ASSETS_ACTION_BT                               =By.xpath("//button[@class='zf-button primary action ng-star-inserted']");
	private static By ASSETS_ACTION_EDIT_BT                          =By.xpath("//div[@class='edit-icon sprite fl']");

	private static By ASSETS_ACTION_RESETALL_BT                      =By.xpath("//button[@class='zf-button fl']");
	private static By ASSETS_ACTION_APPLY_BT                         =By.xpath("//button[@class='zf-button fr']");
	private static By ASSETS_CREATEASSET_SETACTIONS_BT               		 =By.xpath("//button[text()=\" Set Actions \"]");
	private static By ASSETS_CREATEASSET_SETACTIONS_DEACTIVATE_CB          =By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]");
	private static By ASSETS_CREATEASSET_SETACTIONS_ACTIVATE_CB            =By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[2]");
	private static By ASSETS_CREATEASSET_SETACTIONS_APPLY_BT           	 =By.xpath("//button[text()=\"Apply\"]");
	private static By ASSETS_ASSETOPERATOR_TOASTERMESSAGE				 =By.xpath("//div[@class='ng-star-inserted']");
	private static String ASSETS_DROPDOWNLIST							     ="//span[text()='{}']";
	private static By ASSETS_ASSETSDETAILS_ADDCHILDASSET_BT                 =By.xpath("//i[@class='fa fa-plus']");
	private static By ASSETS_ASSETSDETAILS_ADDEDASSET_BT                    =By.xpath( "//span[@class='ui-treenode-icon default root ng-star-inserted']");
	private static By ASSETS_ASSETSORTBY_DD								 =By.xpath("//p-dropdown[@optionlabel='category']/div[contains(@class,'ui-dropdown')]");
	private static By ASSETS_ASSET_AREA_DD								     =By.xpath("//p-dropdown/descendant::span[text()='Area']");
	private static By ASSETS_ASSET_BRAND_DD								     =By.xpath("//p-dropdown/descendant::span[text()='Brand']");
	private static By ASSETS_ASSET_BUSINESSUNIT_DD							 =By.xpath("//p-dropdown/descendant::span[text()='Business Unit']");
	private static By ASSETS_ASSET_COUNTRY_DD									 =By.xpath("//p-dropdown/descendant::span[text()='Country']");
	private static By ASSETS_ASSET_CUSTOMER_DD								 =By.xpath("//p-dropdown/descendant::span[text()='Customer']");
	private static By ASSETS_ASSET_MANUFACTURER_DD							 =By.xpath("//p-dropdown/descendant::span[text()='Manufacturer']");
	private static By ASSETS_ASSET_TYPE_DD									 =By.xpath("//p-dropdown/descendant::span[text()='Type']");
	private static By LOADER_SYMBOL									 =By.xpath("//div[contains(@class,'overlay-wrapper')]/div[contains(@class,'loader')]");

	private static By ASSETS_ASSET_LICENSEPLATEKEY_EB						 =By.xpath("//input[@class='no-drop cell key_0 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static By ASSETS_ASSET_PROPULSIONTYPEKEY_EB					 =By.xpath("//input[@class='no-drop cell key_1 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static By ASSETS_ASSET_VEHICLEKEY_EB							 =By.xpath("//input[@class='no-drop cell key_2 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static By ASSETS_ASSET_VINKEY_EB								 =By.xpath("//input[@class='no-drop cell key_3 ng-untouched ng-pristine ng-valid ng-star-inserted']");
	private static By ASSETS_ASSET_AREA_EB									 =By.xpath("//input[@name='area']");

	public void clickCreateAssets() {

		try {
			waitElementVisibleClick(ASSETS_HOMEPAGE_lK,500); 
			sleep(15000);
			waitElementVisibleClick(ASSETS_CREATEASSET_BT,800);
			sleep(5000);
		} catch (InterruptedException e) {
			TestLogger.fileInfo(e.getMessage());
		}

	}


	public void assetPageValidation() {
		try {

			//TestRail#C48965 - Verify the UI of Search section in Asset landing Page"
			waitElementVisibleClick(ASSETS_HOMEPAGE_lK,600); 
			
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
			waitElementVisibleClick(ASSETS_HOMEPAGE_lK,600); 
		
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
			waitElementVisibleClick(ASSETS_HOMEPAGE_lK,500);
			
			waitElementVisibleClick(ASSETS_ADVANCEDSEARCH_BT,800);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_ASSETTYPE_DD);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_BASICASSETTYPEVALUE_ST);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_BRAND_DD);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_BRANDVALUE_ST);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_MANUFACTURER_DD);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_MANUFACTURERVALUE_ST);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_DATEFROM_EB);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_DATEFROM_DT);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_DATETO_EB);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_DATETO_DT);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_APPLY_BT);
			compareText(jsonData.getJsonData("BasicAssestType"), elementGetText(ASSETS_ADVANCEDSEARCHPOPUP_BASICASSETTYPEVALUE_ST));
			compareText(jsonData.getJsonData("Brand"), elementGetText(ASSETS_ADVANCEDSEARCHPOPUP_BRANDVALUE_ST));
			compareText(jsonData.getJsonData("Manufacturer"), elementGetText(ASSETS_ADVANCEDSEARCHPOPUP_MANUFACTURERVALUE_ST));

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}


	public void clearAllFilter() {
		try {
			JsonReader.getJsonObject("TCO4clearAllFilter");
			waitElementVisibleClick(ASSETS_HOMEPAGE_lK,600); 
	
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
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_ASSETTYPE_DD);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_BASICASSETTYPEVALUE_ST);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_BRAND_DD);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_BRANDVALUE_ST);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_MANUFACTURER_DD);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_MANUFACTURERVALUE_ST);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_DATEFROM_EB);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_DATEFROM_DT);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_DATETO_EB);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_DATETO_DT);
			elementClick(ASSETS_ADVANCEDSEARCHPOPUP_APPLY_BT);
			elementClick(ASSETS_CLEARALL_LK);
			checkfiltercleared(ASSETS_AREAVALUE_DT);
			checkfiltercleared(ASSETS_COUNTRYVALUE_DT);
			checkfiltercleared(ASSETS_ADVANCEDSEARCHPOPUP_BASICASSETTYPEVALUE_ST);
			checkfiltercleared(ASSETS_ADVANCEDSEARCHPOPUP_BRANDVALUE_ST);
			checkfiltercleared(ASSETS_ADVANCEDSEARCHPOPUP_MANUFACTURERVALUE_ST);

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}


	public void assetSearchWithInvalidKey() {
		try {
			JsonReader.getJsonObject("TCO5AssetSearchWithInvalidKey");
			waitElementVisibleClick(ASSETS_HOMEPAGE_lK,600); 
			
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
			waitElementVisibleClick(ASSETS_CREATEASSETS_ASSET_COUNTRY_DD,600); 
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Country")));
			elementClick(ASSETS_CREATEASSETS_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Area")));
			elementClickRadioButton(ASSETS_CREATEASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(ASSETS_CREATEASSETS_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Customer")));
			elementClick(ASSETS_CREATEASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"BusinessUnit")));
			elementClick(ASSETS_CREATEASSET_NEXT_BT);

			elementSendKeys(ASSETS_CREATEASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(ASSETS_CREATEASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"AssetType")));
			elementClick(ASSETS_CREATEASSETS_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Manufacturer")));
			elementClick(ASSETS_CREATEASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Model")));
			elementClick(ASSETS_CREATEASSETS_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Brand")));
			elementSendKeys(ASSETS_CREATEASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(ASSETS_CREATEASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_BT);
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_FIRSTRAW_LT);
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_MAP_BT);
			elementClick(ASSETS_CREATEASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(ASSETS_CREATEASSET_DESCRIPTION_EB,300,jsonData.getJsonData("Description"));
			//			elementSendKeys(ASSETS_CREATEASSET_LICENSEPLATE_VALUE_EB,jsonData.getJsonData("MetaDatalicensePlate"));
			//			elementSendKeys(ASSETS_CREATEASSET_PROPULSIONTYPE_VALUE_EB,jsonData.getJsonData("MetaDataPropulsionType"));
			//			elementSendKeys(ASSETS_CREATEASSET_VEHICLETYPE_VALUE_EB,jsonData.getJsonData("MetaDatavehicleType"));
			//			elementSendKeys(ASSETS_CREATEASSET_VIN_VALUE_EB,jsonData.getJsonData("MetaDatavin"));
			elementClick(ASSETS_CREATEASSET_SUBMIT_BT);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageSuccess",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}
	public void createAssetstWithAllAutopopulatedMetadataKeys() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("createAssetstWithAllAutopopulatedMetadataKeys");
			waitElementVisibleClick(ASSETS_CREATEASSETS_ASSET_COUNTRY_DD,600); 
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Country")));
			elementClick(ASSETS_CREATEASSETS_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Area")));
			elementClickRadioButton(ASSETS_CREATEASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(ASSETS_CREATEASSETS_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Customer")));
			elementClick(ASSETS_CREATEASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"BusinessUnit")));
			elementClick(ASSETS_CREATEASSET_NEXT_BT);

			elementSendKeys(ASSETS_CREATEASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(ASSETS_CREATEASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"AssetType")));
			elementClick(ASSETS_CREATEASSETS_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Manufacturer")));
			elementClick(ASSETS_CREATEASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Model")));
			elementClick(ASSETS_CREATEASSETS_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Brand")));
			elementSendKeys(ASSETS_CREATEASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(ASSETS_CREATEASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));

			elementClick(ASSETS_CREATEASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(ASSETS_CREATEASSET_DESCRIPTION_EB,300,(jsonData.getJsonData("Description")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_LICENSEPLATE_VALUE_EB,(jsonData.getJsonData("MetaDatalicensePlate")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_PROPULSIONTYPE_VALUE_EB,(jsonData.getJsonData("MetaDataPropulsionType")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_VEHICLETYPE_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleType")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_VIN_VALUE_EB,(jsonData.getJsonData("MetaDatavin")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_MANUFACTURER_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleManufacturer")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_MODEL_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleModel")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_PRODUCER_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleProducer")+generateRandomNumber()));
			elementClick(ASSETS_CREATEASSET_SUBMIT_BT);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageSuccess",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}

	public void createAssetstWithMandatoryAutopopulatedMetadataKeys() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("createAssetstWithMandatoryAutopopulatedMetadataKeys");
			waitElementVisibleClick(ASSETS_CREATEASSETS_ASSET_COUNTRY_DD,600); 
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Country")));
			elementClick(ASSETS_CREATEASSETS_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Area")));
			elementClickRadioButton(ASSETS_CREATEASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(ASSETS_CREATEASSETS_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Customer")));
			elementClick(ASSETS_CREATEASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"BusinessUnit")));
			elementClick(ASSETS_CREATEASSET_NEXT_BT);

			elementSendKeys(ASSETS_CREATEASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(ASSETS_CREATEASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"AssetType")));
			elementClick(ASSETS_CREATEASSETS_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Manufacturer")));
			elementClick(ASSETS_CREATEASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Model")));
			elementClick(ASSETS_CREATEASSETS_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Brand")));
			elementSendKeys(ASSETS_CREATEASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(ASSETS_CREATEASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));

			elementClick(ASSETS_CREATEASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(ASSETS_CREATEASSET_DESCRIPTION_EB,500,(jsonData.getJsonData("Description")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_LICENSEPLATE_VALUE_EB,(jsonData.getJsonData("MetaDatalicensePlate")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_PROPULSIONTYPE_VALUE_EB,(jsonData.getJsonData("MetaDataPropulsionType")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_VEHICLETYPE_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleType")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_VIN_VALUE_EB,(jsonData.getJsonData("MetaDatavin")+generateRandomNumber()));
			elementClick(ASSETS_CREATEASSET_SUBMIT_BT);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageSuccess",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}



	public void verifyVehicleAssetstWithMandatoryAutopopulatedMetadataKeys() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("verifyVehicleAssetstWithMandatoryAutopopulatedMetadataKeys");
			waitElementVisibleClick(ASSETS_CREATEASSETS_ASSET_COUNTRY_DD,600); 
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Country")));
			elementClick(ASSETS_CREATEASSETS_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Area")));
			elementClickRadioButton(ASSETS_CREATEASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(ASSETS_CREATEASSET_NEXT_BT);
			waitElementVisibleClick(ASSETS_CREATEASSET_ASSETTYPE_DD,500);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"AssetType")));
		
			
			elementSendKeys(ASSETS_CREATEASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(ASSETS_CREATEASSET_DETAILS_NEXT_BT);
			compareText(elementGetValue(ASSETS_ASSET_LICENSEPLATEKEY_EB,"value"),jsonData.getJsonData("MetaDatalicensePlate"));
			compareText(elementGetValue(ASSETS_ASSET_PROPULSIONTYPEKEY_EB,"value"),jsonData.getJsonData("MetaDataPropulsionType"));
			compareText(elementGetValue(ASSETS_ASSET_VEHICLEKEY_EB,"value"),jsonData.getJsonData("MetaDatavehicleType"));
			compareText(elementGetValue(ASSETS_ASSET_VINKEY_EB,"value"),jsonData.getJsonData("MetaDatavin"));


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}

	public void fieldValidationsMandatoryFieldVin() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("fieldValidationsMandatoryFieldVin");
			waitElementVisibleClick(ASSETS_CREATEASSETS_ASSET_COUNTRY_DD,500); 
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Country")));
			elementClick(ASSETS_CREATEASSETS_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Area")));
			elementClickRadioButton(ASSETS_CREATEASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(ASSETS_CREATEASSETS_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Customer")));
			elementClick(ASSETS_CREATEASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"BusinessUnit")));
			elementClick(ASSETS_CREATEASSET_NEXT_BT);

			elementSendKeys(ASSETS_CREATEASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(ASSETS_CREATEASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"AssetType")));
			elementClick(ASSETS_CREATEASSETS_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Manufacturer")));
			elementClick(ASSETS_CREATEASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Model")));
			elementClick(ASSETS_CREATEASSETS_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Brand")));
			elementSendKeys(ASSETS_CREATEASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(ASSETS_CREATEASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));
			elementClick(ASSETS_CREATEASSET_DETAILS_NEXT_BT);
			waitElementToBeVisibleSendValue(ASSETS_CREATEASSET_DESCRIPTION_EB,300,(jsonData.getJsonData("Description")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_LICENSEPLATE_VALUE_EB,(jsonData.getJsonData("MetaDatalicensePlate")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_PROPULSIONTYPE_VALUE_EB,(jsonData.getJsonData("MetaDataPropulsionType")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_VEHICLETYPE_VALUE_EB,(jsonData.getJsonData("MetaDatavehicleType")+generateRandomNumber()));
			elementSendKeys(ASSETS_CREATEASSET_VIN_VALUE_EB,(jsonData.getJsonData("MetaDatavin")+generateRandomNumber()));
			elementClick(ASSETS_CREATEASSET_SUBMIT_BT);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageFailed",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
			sleep(3000);
			elementSendKeys(ASSETS_CREATEASSET_UPDATEDVIN_VALUE_EB,(jsonData.getJsonData("MetaDatavin1")+generateRandomNumber()));
			elementClick(ASSETS_CREATEASSET_SUBMIT_BT);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageFailed",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageFailedReason");
			sleep(3000);
			elementSendKeys(ASSETS_CREATEASSET_UPDATEDVIN_VALUE_EB,(jsonData.getJsonData("MetaDatavin2")+generateRandomNumber()));
			elementClick(ASSETS_CREATEASSET_SUBMIT_BT);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageSuccess",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}
	public void createAssetWithoutMandatoryInput() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("createAssetWithoutMandatoryInput");
			submitButtonVisibility(ASSETS_CREATEASSET_NEXT_BT," when Address in not entered");
			waitElementToBeVisibleSendValue(ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB,300,jsonData.getJsonData("LocationAddress"));
			waitElementVisibleClick(ASSETS_CREATEASSET_NEXT_BT,300);
			submitButtonVisibility(ASSETS_CREATEASSET_DETAILS_NEXT_BT,"when Name in not entered");
			waitElementToBeVisibleSendValue(ASSETS_CREATEASSET_ASSETNAME_EB,300,jsonData.getJsonData("AssetName"));
			elementClick(ASSETS_CREATEASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"AssetType")));
			elementClick(ASSETS_CREATEASSET_DETAILS_NEXT_BT);

			submitButtonVisibility(ASSETS_CREATEASSET_SUBMIT_BT,"when license plate, Propulsion type, Vehicle type, VIN are not entered");
			waitElementToBeVisibleSendValue(ASSETS_CREATEASSET_LICENSEPLATE_VALUE_EB,300,jsonData.getJsonData("MetaDatalicensePlate"));
			submitButtonVisibility(ASSETS_CREATEASSET_SUBMIT_BT,"when Propulsion type, Vehicle type, VIN are not entered");
			elementSendKeys(ASSETS_CREATEASSET_PROPULSIONTYPE_VALUE_EB,jsonData.getJsonData("MetaDataPropulsionType"));
			submitButtonVisibility(ASSETS_CREATEASSET_SUBMIT_BT,"when Vehicle type and VIN value are not entered");
			elementSendKeys(ASSETS_CREATEASSET_VEHICLETYPE_VALUE_EB,jsonData.getJsonData("MetaDatavehicleType"));
			submitButtonVisibility(ASSETS_CREATEASSET_SUBMIT_BT,"when VIN value is not entered");


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
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageSuccess",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


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
			elementClick(ASSETS_CREATEASSET_SETACTIONS_ACTIVATE_CB);
			waitElementVisibleClick(ASSETS_ACTION_APPLY_BT,500);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageSuccess",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


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
			waitElementVisibleClick(ASSETS_CREATEASSETS_ASSET_COUNTRY_DD,500); 
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Country")));
			elementClick(ASSETS_CREATEASSETS_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Area")));
			elementClickRadioButton(ASSETS_CREATEASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(ASSETS_CREATEASSETS_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Customer")));
			elementClick(ASSETS_CREATEASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"BusinessUnit")));
			//Set Actions 
			elementClick(ASSETS_CREATEASSET_SETACTIONS_BT);
			setActions(jsonData.getJsonData("Action"));// Actions functionality has not been implemented
			elementClick(ASSETS_CREATEASSET_NEXT_BT);

			elementSendKeys(ASSETS_CREATEASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(ASSETS_CREATEASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"AssetType")));
			elementClick(ASSETS_CREATEASSETS_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Manufacturer")));
			elementClick(ASSETS_CREATEASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Model")));
			elementClick(ASSETS_CREATEASSETS_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Brand")));
			elementSendKeys(ASSETS_CREATEASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(ASSETS_CREATEASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_BT);
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_FIRSTRAW_LT);
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_MAP_BT);
			elementClick(ASSETS_CREATEASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(ASSETS_CREATEASSET_DESCRIPTION_EB,500,jsonData.getJsonData("Description"));
			elementSendKeys(ASSETS_CREATEASSET_LICENSEPLATE_VALUE_EB,jsonData.getJsonData("MetaDatalicensePlate")+generateRandomNumber());
			elementSendKeys(ASSETS_CREATEASSET_PROPULSIONTYPE_VALUE_EB,jsonData.getJsonData("MetaDataPropulsionType")+generateRandomNumber());
			elementSendKeys(ASSETS_CREATEASSET_VEHICLETYPE_VALUE_EB,jsonData.getJsonData("MetaDatavehicleType")+generateRandomNumber());
			elementSendKeys(ASSETS_CREATEASSET_VIN_VALUE_EB,jsonData.getJsonData("MetaDatavin")+generateRandomNumber());
			elementClick(ASSETS_CREATEASSET_SUBMIT_BT);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageSuccess",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}

	public void editAssetstActions() {
		try {
			clickCreateAssets();
			JsonReader.getJsonObject("TCO9EditAssetstActions");
			waitElementVisibleClick(ASSETS_CREATEASSETS_ASSET_COUNTRY_DD,600); 
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Country")));
			elementClick(ASSETS_CREATEASSETS_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Area")));
			elementClickRadioButton(ASSETS_CREATEASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(ASSETS_CREATEASSETS_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Customer")));
			elementClick(ASSETS_CREATEASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"BusinessUnit")));
			//Set Actions 
			elementClick(ASSETS_CREATEASSET_SETACTIONS_BT);
			setActions(jsonData.getJsonData("Action")); // Actions functionality has not been implemented 
			elementClick(ASSETS_CREATEASSET_NEXT_BT);

			elementSendKeys(ASSETS_CREATEASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(ASSETS_CREATEASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"AssetType")));
			elementClick(ASSETS_CREATEASSETS_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Manufacturer")));
			elementClick(ASSETS_CREATEASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Model")));
			elementClick(ASSETS_CREATEASSETS_ASSET_BRAND_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Brand")));
			elementSendKeys(ASSETS_CREATEASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(ASSETS_CREATEASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_BT);
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_FIRSTRAW_LT);
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_MAP_BT);
			elementClick(ASSETS_CREATEASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(ASSETS_CREATEASSET_DESCRIPTION_EB,300,jsonData.getJsonData("Description"));
			elementSendKeys(ASSETS_CREATEASSET_LICENSEPLATE_VALUE_EB,jsonData.getJsonData("MetaDatalicensePlate")+generateRandomNumber());
			elementSendKeys(ASSETS_CREATEASSET_PROPULSIONTYPE_VALUE_EB,jsonData.getJsonData("MetaDataPropulsionType")+generateRandomNumber());
			elementSendKeys(ASSETS_CREATEASSET_VEHICLETYPE_VALUE_EB,jsonData.getJsonData("MetaDatavehicleType")+generateRandomNumber());
			elementSendKeys(ASSETS_CREATEASSET_VIN_VALUE_EB,jsonData.getJsonData("MetaDatavin")+generateRandomNumber());
			elementClick(ASSETS_CREATEASSET_SUBMIT_BT);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageSuccess",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");


		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}

	public void editExistAssetDetails() {
		try {
			JsonReader.getJsonObject("TCO8editExistAssetDetails");
			selectAssetDetails("editExistAssetDetails");
			waitElementVisibleClick(ASSETS_ASSETSDETAILS_BASICDETAILS_EDIT_BT,600);
			sleep(6000);
			elementClick(ASSETS_CREATEASSETS_ASSET_COUNTRY_DD); 
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Country")));
			elementClick(ASSETS_CREATEASSETS_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Area")));
			elementClickRadioButton(ASSETS_CREATEASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(ASSETS_CREATEASSET_NEXT_BT);
			elementClick(ASSETS_CREATEASSET_DETAILS_NEXT_BT);
			elementClick(ASSETS_CREATEASSET_SUBMIT_BT);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageSuccess",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");
		}catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}


	public void createChildAssetWithAllFeilds() {
		try {
			createAssetstWithAllFeilds();
			JsonReader.getJsonObject("CreateChildAssettWithAllFeilds");
			elementClick(ASSETS_ASSETSDETAILS_ADDEDASSET_BT);
			waitElementVisibleClick(ASSETS_ASSETSDETAILS_ADDCHILDASSET_BT,600);
			waitElementVisibleClick(ASSETS_CREATEASSETS_ASSET_COUNTRY_DD,300); 
			waitElementVisibleClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Country")),500);
			elementClick(ASSETS_CREATEASSETS_ASSET_AREA_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Area")));
			elementClickRadioButton(ASSETS_CREATEASSET_LOCATION_ADDRESS_RB);
			elementSendKeys(ASSETS_CREATEASSET_LOCATION_DESCRIPTION_EB,jsonData.getJsonData("LocationAddress"));
			elementClick(ASSETS_CREATEASSETS_ASSET_CUSTOMER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Customer")));
			elementClick(ASSETS_CREATEASSET_BUSINESSUNIT_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"BusinessUnit")));
			elementClick(ASSETS_CREATEASSET_NEXT_BT);

			elementSendKeys(ASSETS_CREATEASSET_ASSETNAME_EB,jsonData.getJsonData("AssetName"));
			elementClick(ASSETS_CREATEASSET_ASSETTYPE_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"AssetType")));
			elementClick(ASSETS_CREATEASSETS_ASSET_MANUFACTURER_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Manufacturer")));
			elementClick(ASSETS_CREATEASSET_MODEL_DD);
			elementClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Model")));
			elementClick(ASSETS_CREATEASSETS_ASSET_BRAND_DD);
			waitElementVisibleClick(By.xpath(dynamicXpath(ASSETS_DROPDOWNLIST,"Brand")),300);
			elementSendKeys(ASSETS_CREATEASSET_SERIALNUMBER_EB,jsonData.getJsonData("SerialNumber"));
			elementSendKeys(ASSETS_CREATEASSET_SENSORID_EB,jsonData.getJsonData("SensorID"));
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_BT);
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_FIRSTRAW_LT);
			elementClick(ASSETS_CREATEASSET_MAPTOGATEWAY_MAP_BT);
			elementClick(ASSETS_CREATEASSET_DETAILS_NEXT_BT);

			waitElementToBeVisibleSendValue(ASSETS_CREATEASSET_DESCRIPTION_EB,300,jsonData.getJsonData("Description"));
			//			elementSendKeys(ASSETS_CREATEASSET_LICENSEPLATE_VALUE_EB,jsonData.getJsonData("MetaDatalicensePlate"));
			//			elementSendKeys(ASSETS_CREATEASSET_PROPULSIONTYPE_VALUE_EB,jsonData.getJsonData("MetaDataPropulsionType"));
			//			elementSendKeys(ASSETS_CREATEASSET_VEHICLETYPE_VALUE_EB,jsonData.getJsonData("MetaDatavehicleType"));
			//			elementSendKeys(ASSETS_CREATEASSET_VIN_VALUE_EB,jsonData.getJsonData("MetaDatavin"));
			elementClick(ASSETS_CREATEASSET_SUBMIT_BT);
			verifyToastermessage(ASSETS_CREATEASSET_TOASTER_MSG,"ToasterMessageSuccess",ASSETS_CREATEASSET_TOASTER_MSG_TXT,"ToasterMessageSuccessReason");

		}catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}



	public void verifyAssetActionsUI() {
		try {
			clickCreateAssets();
			elementAvailability(ASSETS_CREATEASSET_SETACTIONS_BT);
			elementClick(ASSETS_CREATEASSET_SETACTIONS_BT);
			elementAvailability(ASSETS_CREATEASSET_SETACTIONS_DEACTIVATE_CB);
			elementAvailability(ASSETS_CREATEASSET_SETACTIONS_ACTIVATE_CB);
			elementAvailability(ASSETS_CREATEASSET_SETACTIONS_APPLY_BT);

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
			
			String toasterMessage = waitElementVisibleGetText(ByType1,50);
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
			waitElementVisibleClick(ASSETS_HOMEPAGE_lK,600); 
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

				waitElementVisibleClick(ASSETS_CREATEASSET_SETACTIONS_DEACTIVATE_CB,600);
			}else {
				waitElementVisibleClick(ASSETS_CREATEASSET_SETACTIONS_ACTIVATE_CB,600);
			}
			elementClick(ASSETS_CREATEASSET_SETACTIONS_APPLY_BT);

		}catch(Exception e) {
			TestLogger.fileInfo(e.getMessage());
		}
	}


	public void operatorHasNoAccessToCreateAsset()
	{
		JsonReader.getJsonObject("OperatorHasNoAccessToAddGateway");
		try {
			waitElementVisibleClick(ASSETS_HOMEPAGE_lK,500); 
			waitElementVisibleClick(ASSETS_CREATEASSET_BT,1000);
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
			waitElementVisibleClick(ASSETS_HOMEPAGE_lK,700);
			//elementAvailability(LOADER_SYMBOL);
			sleep(10000);
			assetSortingDropDownNavigation(ASSETS_ASSET_BRAND_DD);
			assetSortingDropDownNavigation(ASSETS_ASSET_BUSINESSUNIT_DD);
			assetSortingDropDownNavigation(ASSETS_ASSET_COUNTRY_DD);
			assetSortingDropDownNavigation(ASSETS_ASSET_CUSTOMER_DD);
			assetSortingDropDownNavigation(ASSETS_ASSET_MANUFACTURER_DD);
			assetSortingDropDownNavigation(ASSETS_ASSET_TYPE_DD);
			assetSortingDropDownNavigation(ASSETS_ASSET_AREA_DD);
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void assetSortingDropDownNavigation(By Dropdownvalue)
	{
		try {
			waitElementVisibleClick(ASSETS_ASSETSORTBY_DD,300);
			waitElementVisibleClick(Dropdownvalue,100);
			sleep(10000);
		} catch (Exception e) {
			TestLogger.appInfo(e.getMessage());
		}
	}
	public void verifyToastermessage(String Jsondata) {
		
		String toasterText;
		try {
			toasterText = waitElementVisibleGetText(ASSETS_ASSETOPERATOR_TOASTERMESSAGE,100);
			compareText(toasterText,jsonData.getJsonData(Jsondata));
		} catch (InterruptedException e) {
			TestLogger.appInfo(e.getMessage());
		}
		
	}
}
