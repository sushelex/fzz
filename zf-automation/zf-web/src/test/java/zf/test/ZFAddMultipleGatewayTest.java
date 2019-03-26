package zf.test;

import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import framework.DriverManager;
import framework.EnvironmentManager;
import zf.pages.MicrosoftLoginPage;
import zf.pages.ZFAddMultipleGatewayPage;

public class ZFAddMultipleGatewayTest extends ZFAddMultipleGatewayPage {
	MicrosoftLoginPage microsoftlogin=new MicrosoftLoginPage();

	@BeforeMethod
	public void beforeMethod(Method testName) {
		startTest(testName.getName());
		DriverManager.getDriver(EnvironmentManager.getBrowserName());
		microsoftlogin.microsoftLogin(EnvironmentManager.getAdminUserName(),EnvironmentManager.getAdminPassword());
	}

		@Test
	public void Tc01AddMultipleGatewayWithNewEnrollmentGroupWithRootUploadCertificate() {
			addMultipleGatewayNewRoot();
	}

	@Test
	public void Tc02AddMultipleGatewayWithExistingEnrollmentGroup() {
		addMultipleGatewayExisting();
	}
	@Test
	public void Tc03AddMultipleGatewayWithNewEnrollmentGroupWithIntermediateUploadCertificate() {
		addMultipleGatewayNewIntermediate();

	}
	@Test
	public void Tc04AddMultipleGatewayWithNewEnrollmentGroupWithoutMandatoryFields() {
		addMultipleGatewayWithoutMandatoryFields();

	}

	@Test
	public void Tc05AddMultipleGatewayWithInvalidDetails() {
		addMultipleGatewayWithInvalid();

	}

	@Test
	public void Tc06AddMultipleGatewayWithUserInterfaceValidation() {

		validatUserInterface();
	}
	@Test
	public void Tc06AddMultipleGatewayWithLookAndFeelValidation() {

		validateLookAndFeelMultipleGateway();
	}
	@AfterMethod
	public void afterMethod(ITestResult result,Method testName)
	{
		getResult(result,testName.getName());
		DriverManager.closeAllBrowser();
	}

}
