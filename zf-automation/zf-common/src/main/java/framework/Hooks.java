package framework;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks {
	SendMailSSL mail = new SendMailSSL();
	ExtentReport extentReport=new ExtentReport();
	@BeforeTest
	public void beforeTest() {
		ExtentReport.configureReport();
		}
	
		
	@AfterTest
	public void afterTest()
	{
		ExtentReport.reportClose();
		String ReportPath = ExtentReport.zipAutomationReport();
		mail.AutomationReport(ReportPath);

}}
