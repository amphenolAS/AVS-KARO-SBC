package com.KaroSBC.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.avsQual.base.BaseClass;
import com.avsQual.pages.FM_SyncInPage;
import com.avsQual.pages.FileManagementPage;
import com.avsQual.pages.HardwarePage;
import com.avsQual.pages.LoginPage;
import com.avsQual.pages.MainHubPage;
import com.avsQual.pages.QualificationPage;
import com.avsQual.pages.QualificationStudyPage;
import com.avsQual.pages.RW_FileSelctionPage;
import com.avsQual.pages.SelectAVSPage;
import com.avsQual.pages.Setup_CalVerParametersPage;
import com.avsQual.pages.Setup_CalculationsPage;
import com.avsQual.pages.Setup_GroupSensorsPage;
import com.avsQual.pages.Setup_QualParamPage;
import com.avsQual.pages.Setup_ReviewPage;
import com.avsQual.pages.Setup_SensorConfigPage;
import com.avsQual.pages.Setup_defineSetupPage;
import com.avsQual.pages.SyncInAssetListPage;
import com.avsQual.pages.UserManagementPage;
import com.avsQual.pages.assetCreationPage;
import com.avsQual.pages.assetDetailsPage;
import com.avsQual.pages.assetDetailsPage2;
import com.avsQual.pages.assetHubPage;
import com.avsQual.pages.PoliciesPage;
import com.avsQual.pages.AdministratorPage;
import com.avsQual.utility.QualificationUtility;
import com.avsQual.utility.TestUtilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Qual_InitiationTest extends BaseClass{
	
	public Qual_InitiationTest() throws IOException
	{
		super();
	}
	
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	// Initialization of the Pages
		LoginPage LoginPage;
		MainHubPage MainHubPage;
		UserManagementPage UserManagementPage;
		assetHubPage assetHubPage;
		assetCreationPage assetCreationPage;
		assetDetailsPage2 assetDetailsPage2;
		Setup_defineSetupPage Setup_defineSetupPage;
		Setup_SensorConfigPage Setup_SensorConfigPage;
		Setup_GroupSensorsPage Setup_GroupSensorsPage;
		Setup_CalculationsPage Setup_CalculationsPage;
		Setup_CalVerParametersPage Setup_CalVerParametersPage;
		Setup_QualParamPage Setup_QualParamPage;
		Setup_ReviewPage Setup_ReviewPage;
		assetDetailsPage assetDetailsPage;
		SelectAVSPage SelectAVSPage;
		QualificationStudyPage QualificationStudyPage;
		QualificationPage QualificationPage;
		RW_FileSelctionPage RWFileSelctionPage;
		TestUtilities tu = new TestUtilities();
		FileManagementPage FileManagementPage;
		FM_SyncInPage FM_SyncInPage;
		SyncInAssetListPage SyncInAssetListPage;
		HardwarePage HardwarePage; 
		PoliciesPage PoliciesPage;
		AdministratorPage AdministratorPage;
		
		@BeforeClass
		public void PreSetup() throws InterruptedException, IOException, ParseException, AWTException {

			extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ER_" + "Qual_InitiationTest" + ".html", true);
			extent.addSystemInfo("TestSuiteName", "Qual_InitiationTest");
			extent.addSystemInfo("AVS Version", prop.getProperty("AVS_Version"));
			extent.addSystemInfo("User Name", prop.getProperty("User_Name"));
			System.out.println("Qualification START Test is in Progress..");
			

			// Rename the AVS Data Files folder if exists in order to make the system
			// default
	/*		renameFile("C:\\Program Files (x86)\\Kaye\\Kaye AVS Service", "DataFiles");
			// Copy the Default DataFIles folder from Test Data to the App service location.
			String SrcLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\DataFiles";
			String DestLocation = "C:\\Program Files (x86)\\Kaye\\Kaye AVS Service\\DataFiles";
			tu.Copy_FolderFromOneDirectoryToANother(SrcLocation, DestLocation);
			System.out.println("Application is Launching..");

			LaunchApp("Kaye.NextGenValidator_tdxctrh6k91jc!App");
			LoginPage = new LoginPage();
			extent.addSystemInfo("AVS Version", LoginPage.get_SWVersion_About_Text());
			AppClose();
			Thread.sleep(2000);   
			
			LaunchApp("Kaye.NextGenValidator_tdxctrh6k91jc!App");
			Thread.sleep(500);
			LoginPage = new LoginPage();
			PoliciesPage = LoginPage.DefaultLogin();
			UserManagementPage = PoliciesPage.click_UMHeader();
			LoginPage = UserManagementPage.FirstUserCreation("User1", getUID("adminFull"), getPW("adminFull"),
					getPW("adminFull"), "FullAdmin", "12345678", "abc@gmail.com");
			MainHubPage = LoginPage.Login(getUID("adminFull"), getPW("adminFull"));

			AdministratorPage = MainHubPage.ClickAdminTile_Adminpage();
			UserManagementPage = AdministratorPage.ClickUserManagement_TAB();
			UserManagementPage.clickAnyUserinUserList("User1");
			UserManagementPage.Click_Create_AssetCheckBox();
			UserManagementPage.click_CreatSetupPriv();
			UserManagementPage.clickPrivRunQual();
			UserManagementPage.click_EditSetupPriv();
			UserManagementPage.Click_EditAssetCheckBox();

			UserManagementPage.ClickNewUserSaveButton();
			UserLoginPopup(getUID("adminFull"), getPW("adminFull"));
			tu.click_OK_popup();

			MainHubPage = UserManagementPage.ClickBackButn();
	//User need to re login after giving user privileges
			LoginPage = MainHubPage.UserSignOut();
			MainHubPage = LoginPage.Login(getUID("adminFull"), getPW("adminFull"));

			assetHubPage = MainHubPage.Click_AssetTile();
			assetCreationPage = assetHubPage.ClickAddAssetBtn();
			assetCreationPage.assetCreation_WithoutSave("Arabindo", "123", "HeatBath", "Kaye", "Hyd");
			assetCreationPage.clickSaveBtn();
			UserLoginPopup(getUID("adminFull"), getPW("adminFull"));
			Thread.sleep(3000);
			assetHubPage = assetCreationPage.clickBackBtn();
			
			AppClose();
			Thread.sleep(2000);    */

		}
		// @AfterClass-All the tests are conducted
		@AfterClass
		public void endReport_releaseMomory() {
			extent.flush();
			extent.close();
		}

		// Before Method(Test) method
		@BeforeMethod(alwaysRun = true)
		public void Setup() throws InterruptedException, IOException {
			Thread.sleep(1000);
			LaunchApp("Kaye.NextGenValidator_tdxctrh6k91jc!App");
			Thread.sleep(500);
			LoginPage = new LoginPage();
			MainHubPage = LoginPage.Login(getUID("adminFull"), getPW("adminFull"));
			assetHubPage = MainHubPage.Click_AssetTile2();
		}

		// @AfterMethod TearDown of the App
		@AfterMethod(alwaysRun = true)
		public void Teardown(ITestResult result) throws IOException {
			if (result.getStatus() == ITestResult.FAILURE) {
				// to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS # " + result.getName() + " #");
				// to add error/exception in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS # " + result.getThrowable() + " #");
				// to add screenshot in extent report
				String screenshotPath1 = TestUtilities.getFailedTCScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath1));
				// to add screencast/video in extent report
				// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));

			} else if (result.getStatus() == ITestResult.SKIP) {
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS # " + result.getName() + " #");

			}
			extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report
			driver.quit();
		} 
		
		@Test()
		
		public void Qual001() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual001_If a setup file is not created already then, Create a setup file by traversing through the"
					+ " wizard and select the Initiate Qualification' button from the Qualification tab under Asset details page and Verify if the"
					+ " software displays the SOP/Protocol & Run# window followed by Select AVS screen Page..");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			
			Setup_defineSetupPage = assetDetailsPage.click_NewStupCreateBtn();
			Setup_SensorConfigPage = Setup_defineSetupPage.enter_MandatoryFieldsindefineSetupconfigPage("Setup01", "4");
			Setup_SensorConfigPage.Click_SelectSen_Expanderbtn();
			Setup_SensorConfigPage.select_FromSim(1);
			Setup_SensorConfigPage.SelectAny_Option_FomSelectSensor("Sensor 1");
			Setup_SensorConfigPage.select_ToSim(1);
			Setup_SensorConfigPage.SelectAny_Option_ToSelectSensor("Sensor 4");
			Setup_SensorConfigPage.Click_Configurationsensors_Expanderbtn();
			Setup_SensorConfigPage.select_Sensortype();
			Setup_SensorConfigPage.Enter_SensorLabel("Temp");
			Setup_SensorConfigPage.click_AutoNumber();
			Setup_SensorConfigPage.Click_assignBtn();
			Setup_GroupSensorsPage = Setup_SensorConfigPage.Click_nextbtn(); 
			Setup_GroupSensorsPage.click_DfltGrp_Btn();
			Setup_CalculationsPage = Setup_GroupSensorsPage.Click_CalculationsTab(); 
			Setup_CalVerParametersPage = Setup_CalculationsPage.Click_NxtBtn();
			Setup_QualParamPage = Setup_CalVerParametersPage.click_NextPage();
			Setup_ReviewPage = Setup_QualParamPage.Click_NxtBtn();
			Setup_ReviewPage.clickSaveBtn();
			UserLoginPopup(getUID("adminFull"), getPW("adminFull"));
			Thread.sleep(3000);
			assetDetailsPage = Setup_ReviewPage.click_backBtn();
			
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			
			sa.assertTrue(assetDetailsPage.isSOPPopUp_Displayed(), "Fail: SOP/Protocol popup is not displayed");
			
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			
			sa.assertTrue(SelectAVSPage.isSelectAVSScrn_Dispayed(), "Fail: Select AVS Screen is not displayed");
			
			sa.assertAll();
		}
		
		@Test()
		
		public void Qual002() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual002_If a setup file is created already  then perform the above tests ");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			
			sa.assertTrue(assetDetailsPage.isSOPPopUp_Displayed(), "Fail: SOP/Protocol popup is not displayed");
			
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			
			sa.assertTrue(SelectAVSPage.isSelectAVSScrn_Dispayed(), "Fail: Select AVS Screen is not displayed");
			
			sa.assertAll();
		}
		
		@Test()
		
		public void Qual003() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual003_Verify that Initiate Qualification page can be navigated through Main Hub -> Assets -> "
					+ "Assets Details -> Qualifications");
			SoftAssert sa = new SoftAssert();
			
			sa.assertTrue(assetHubPage.Is_assetHubPageTitle_Visible(), "Fail: Asset Hub Page is not be Displayed");
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			sa.assertTrue(assetDetailsPage.assetDetailPageTitle_Visible(), "Fail: Asset Details Page is not be Displayed");
			
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			
			sa.assertTrue(SelectAVSPage.isSelectAVSScrn_Dispayed(), "Fail: Select AVS Screen is not displayed");
			
			sa.assertAll();
		}	
		
		@Test()
		
		public void Qual004() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual004_Verify that the Initiate Qualification button is enable after selecting any setup file."); 
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			sa.assertTrue(assetDetailsPage.InitiateQualBtn_state(), "Fail: Inition Button is in disabled mode");
			
			sa.assertAll();
		}
		
		@Test()
		
		public void Qual005() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual005_Verify if a window pops up with SOP/Protocol & Run Number details to be edited. ");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			
			//Check SOP/Protocol Number field is edited
			sa.assertTrue(assetDetailsPage.IsSOPNumberField_Editable(), "Fail: SOP/Protocol Number field is in disabled mode");
			
			//Check Run Number field is edited 
			sa.assertTrue(assetDetailsPage.IsRunNumberField_Editable(), "Fail: Run Number field is in disabled mode");
			
			sa.assertAll();
		}
		
		@Test()
		
		public void Qual006() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual006_Verify if the SOP Protocol Number field can be set to maximum 50 alpha numerical and special"
					+ " characters like -, _ and slash (forward and backward)");
			SoftAssert sa = new SoftAssert();

			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			
			//Enter more than 50 Alpha numeric and special characters
			assetDetailsPage.Enter_SOPNum("ABCDefghIJKLmnopQRSTuvwxYZ01234567890123-_/ 45678910anbcv");
			
			//Verify SOP Protocol Number field accept only 50 Alpha Numeric characters
			sa.assertEquals(assetDetailsPage.GetSOPNumText().length(), 50, "Fail: SOP Protocol Number accepts more than 50 alpha numeric characters");
			
			sa.assertAll();
		}
		
		@Test()
		
		public void Qual007() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual007_Verify if alert message is displayed to user for entering invalid characters to the SOP"
					+ " Protocol Number field");
			SoftAssert sa = new SoftAssert();
			

			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			
			//Enter Invalid special characters
			assetDetailsPage.Enter_SOPNum("!@#$%^&*");
			assetDetailsPage.click_StartQual_OKButton();
			sa.assertEquals(tu.get_AlertMsg_text(), "SOP Protocol Number accepts alpha numeric and special characters like -,_ ,slash (forward and backward).", 
					"Fail: Application accepts invalid characters too");
			
			sa.assertAll();
			
		}	
		
		@Test()
		
		public void Qual008() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual008_Verify if the Run Number field can be set to value between 1 to 9999");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			
			// Test values with Minimum, within range and Maximum value
			int numbers[] = {1,1000, 3000, 5000, 9999};
			
			for(int value: numbers)
			{
				String num = Integer.toString(value); 
				
				assetDetailsPage.Enter_RunNumber(num);
				
				sa.assertEquals(assetDetailsPage.GetRunNumText(), num, "Fail: RUN Number field can't be set value between 1 to 9999");
			}
			
			sa.assertAll();		 
		}	
		
		@Test()
		
		public void Qual009() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual009_Verify if Run number field cannot be left blank in order to initiate a qualification run, "
					+ "If existing Run number is deleted then default “1” is taken as run number.");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			
			//Clear the Run Number Field
			assetDetailsPage.clear_RunNumber();
			assetDetailsPage.click_SOPNum();
			
			//Verify Run Field can run with blank or not
			sa.assertNotNull(assetDetailsPage.GetRunNumText(), "Fail: Run Number field can run with balnk");
			
			//Verify Run Number Default vlaue is 1 or not
			sa.assertEquals(assetDetailsPage.GetRunNumText(), "1", "Fail: Run Number field Default can not taken as 1");
			
			sa.assertAll();
		}
		
		@Test()
		
		public void Qual010() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Verify if the Select AVS screen is launched after acknowledging the SOP/Protocol & Run Number pop.");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			
			//Verify AVS Screen is launched or not
			sa.assertTrue(SelectAVSPage.isSelectAVSScrn_Dispayed(), "Fail: Select AVS Screen is not displayed");
			
			sa.assertAll();
		}

		@Test()
		
		public void Qual011() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Verify if the Select AVS screen has got the below content by default when launched for the 1st time;"
					+ "1.Discover AVS button in enabled state, 2.Configure Wifi button in enabled state, 3.Only a single AVS tile (Orange color) displayed as USB/Docking with IP address-192.168.1.2 label on it in the AVS list box,"
					+ "4.Connect button in disabled state, 5.AVS IP address field with blank data, 6.Add button in enabled state corresponding to the AVS IP address field");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			
			//1.Discover AVS button in enabled state
			sa.assertTrue(SelectAVSPage.is_DiscoverAVSBtn_Enabled(), "Fail: Discover AVS Button is in disabled mode");
			
			//2.Configure Wifi button in enabled state
			sa.assertTrue(SelectAVSPage.is_ConfWifiBtn_Enabled(), "Fail: Configure Wifi button is in disabled mode");
			
			//3.Only a single AVS tile (Orange color) displayed as USB/Docking with IP address-192.168.1.2 label on it in the AVS list box
			sa.assertEquals(SelectAVSPage.getTxt_SingleAVSTitle(), "IP 192.168.1.2", "Fail: Single AVS with IP 192.168.1.2 is not displayed");
			
			//4.Connect button in disabled state
			sa.assertFalse(SelectAVSPage.is_ConctBtnEnabled(), "Fail: COnnect Button is on Enabled state");
			
			//5.AVS IP address field with blank data
			sa.assertEquals(SelectAVSPage.getTxt_AVSIPBox(),"", "Fail: AVS IP address field is not blank");
			
			//6.Add button in enabled state corresponding to the AVS IP address field
			sa.assertTrue(SelectAVSPage.is_AddBtnEnabled(), "Fail: Add Button is not Enabled");
			
			sa.assertAll();
		}
		
		@Test()
		
		public void Qual012() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual012_Verify on clicking either the default AVS unit (USB-Docking) tile or any other available AVS "
					+ "unit tile in the list box, the Connect button becomes enable");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			
			//Verify before clicking on SingleAVSTitle the Connect button Enable status
			sa.assertFalse(SelectAVSPage.is_ConctBtnEnabled(), "Fail: COnnect Button is on Enabled state");
			
			//Verify after clicking on SingleAVSTitle the Connect button Enable status
			SelectAVSPage.click_SingleAVSTitle();
			sa.assertTrue(SelectAVSPage.is_ConctBtnEnabled(), "Fail: COnnect Button is on Enabled state");
			
			sa.assertAll();
		}	
		
		@Test()
		
		public void Qual013() throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Verify if without the HMI being docked or not connected to the AVS unit via USB cable, if the default AVS"
					+ " unit tile (with USB/Docking label) is selected and Connect button is clicked then valid alert message should be displayed"
					+ " to User like “Unable to connect AVS”");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			SelectAVSPage.click_SingleAVSTitle();
			
			//Click on Connect Button for validating error message
			SelectAVSPage.click_CnnctBtn();
			
			sa.assertEquals(SelectAVSPage.getTxt_ConnctBtn(), "Unable to connect AVS", "Fail: Alert message is not displaying");
			sa.assertAll();
		}
		
		@Test(dataProvider = "Qual014", dataProviderClass = QualificationUtility.class)
		
		public void Qual014(String AVS_IP, String SelectAVS) throws IOException, InterruptedException
		
		{
			extentTest = extent.startTest("Qual014_Verify if the HMI being docked or connected to the AVS unit via USB cable, the default AVS unit"
					+ " tile (with USB/Docking label) is selected and Connect button is clicked then Qualification screen should be displayed");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			SelectAVSPage.enterTxt_IntoIpTxtBox(AVS_IP);
			SelectAVSPage.click_AddBtn();
				
			SelectAVSPage.select_AVS(SelectAVS);
			QualificationStudyPage = SelectAVSPage.click_ConnectBtn();
			
			//Verify Qualification screen visible
			sa.assertTrue(QualificationStudyPage.is_LiveDataScreenVisible(), "Fail: Qualification screen is not displaying");
			sa.assertAll();
		}
		
		@Test()
		
		public void Qual015() throws IOException, InterruptedException
		
		{
			extentTest = extent.startTest("Qual015_Verify if the AVS IP address field does not accept invalid characters and should display"
					+ " alert message on doing so saying “IP Address should be of 4 octets, separated by decimals”");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			SelectAVSPage.enterTxt_IntoIpTxtBox("!123$^&^");
			SelectAVSPage.click_AddBtn();
			
			String alertMsg = "IP Address should be four octets, seperated by decimals.";
			
			sa.assertEquals(SelectAVSPage.alertMsg_IPAddField(), alertMsg, 
					"Fail: AVS IP address field accepts invalid characters and will not display any alert message");
			
			sa.assertAll();
		}
		
		@Test(dataProvider = "Qual016", dataProviderClass = QualificationUtility.class)
		
		public void Qual016(String AVS_IP) throws IOException, InterruptedException
		
		{
			extentTest = extent.startTest("Qual016_Verify if on entering valid IP address of a desired AVS unit in network to the AVS IP address"
					+ " field and clicking Add button display the respective AVS unit tile in blue color in the AVS list box with the AVS serial"
					+ " number, Ethernet IP address and Wifi data (if available) as label ");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			SelectAVSPage.enterTxt_IntoIpTxtBox(AVS_IP);
			String IPtext = SelectAVSPage.getTxt_AVSIPBox();
			SelectAVSPage.click_AddBtn();
			
			sa.assertTrue(SelectAVSPage.get_AVSIP(AVS_IP).contains(IPtext), "Fail: Entered AVS is not displaying");
			
			sa.assertAll();
		}
		
		@Test()
		
		public void Qual017() throws IOException, InterruptedException
		
		{
			extentTest = extent.startTest("Qual017_Verify if on clicking the Configure Wifi button pops up the Wifi settings window with the below field contents"
					+ "1.Network field, 2.Security Type field, 3.Encryption Type field, 4.Network Security Type field, 	5.IP address dropdown list,"
					+ " 6.OK & Cancel button");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			SelectAVSPage.click_ConfgWiFi();
			
			//1.Network field
			sa.assertTrue(SelectAVSPage.is_NetWorkFieldVisible(), "Fail: NetWork Field is not Displaed");
			
			//2.Security Type field
			sa.assertTrue(SelectAVSPage.is_SecurityTypeVisible(), "Fail: Security Type Field is not Displyed");
			
			//3.Encryption Type field
			sa.assertTrue(SelectAVSPage.is_EncryptionTypeVisible(), "Fail: Encryption Type Field is not Displyed");
			
			//4.Network Security Type field
			sa.assertTrue(SelectAVSPage.is_NetWorkSecurityTypeVisible(), "Fail: NetWork Security Type Field is not Displyed");
			
			//5.IP address dropdown list
			sa.assertTrue(SelectAVSPage.is_IPDrpDwnVisible(), "Fail: IP Drop Dwon Field is not Displyed");
			
			//OK & Cancel button
			sa.assertTrue(SelectAVSPage.is_OKBtnVisible(), "Fail: OK Button is not Displyed");
			sa.assertTrue(SelectAVSPage.is_CancelBtnVisible(), "Fail: Cancel Button is not Displyed");
			
			sa.assertAll();
		}	
		
		@Test()
		
		public void Qual018() throws IOException, InterruptedException
		
		{
			extentTest = extent.startTest("Qual018_Verify if list of all AVS units that are available in network are displayed after clicking "
					+ "Discover AVS button with the corresponding AVS serial number, Ethernet IP address and Wifi data (if available) as label.");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			SelectAVSPage.click_DiscoverAVSBtn();
			
			//Verify AVS Instruments displayed or not
			sa.assertTrue(SelectAVSPage.is_AVSUnitsDisplayed(), "Fail: AVS units are not displayed");
			sa.assertAll();
		}	
		
		@Test(dataProvider = "Qual019", dataProviderClass = QualificationUtility.class)
		
		public void Qual019(String AVS_IP) throws IOException, InterruptedException
		
		{
			extentTest = extent.startTest("Qual019_Verify that the AVS select screen by default highlights the AVS unit which was used last time"
					+ " along with the HMI.");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			SelectAVSPage.click_DiscoverAVSBtn();
			
			SelectAVSPage.enterTxt_IntoIpTxtBox(AVS_IP);
			String IPtext = SelectAVSPage.getTxt_AVSIPBox();
			SelectAVSPage.click_AddBtn();
			
			sa.assertTrue(SelectAVSPage.isAVS_Selected(IPtext), "Fail: AVS unit doesn't highlights");
			
			sa.assertAll();
		}	
		
		@Test(dataProvider = "Qual020", dataProviderClass = QualificationUtility.class)
		
		public void Qual020(String AVS_IP) throws IOException, InterruptedException
		{
			extentTest = extent.startTest("Qual020_Verify if selecting any of the available AVS units and clicking the Remove button removes the"
					+ " corresponding unit from the AVS list box ");
			SoftAssert sa = new SoftAssert();
			
			assetDetailsPage = assetHubPage.click_assetTile2("Arabindo");
			assetDetailsPage.select_Setup("Setup01");
			assetDetailsPage.click_InitiateQualBtn();
			SelectAVSPage = assetDetailsPage.StartQual_OKButton();
			SelectAVSPage.enterTxt_IntoIpTxtBox(AVS_IP);
			String IPtext = SelectAVSPage.getTxt_AVSIPBox();
			SelectAVSPage.click_AddBtn();
			
			//Verify selected AVS unit is highlighted
			sa.assertTrue(SelectAVSPage.is_AVSUnitDispayed(IPtext), "Fail: AVS unit doesn't highlights");
			
			//click On Remove Button for required validation
			Thread.sleep(3000);
			SelectAVSPage.click_RemoveBtn();
			
			sa.assertFalse(SelectAVSPage.is_AVSUnitDispayed(IPtext), "Fail: AVS unit still visible in the list");
			
			sa.assertAll();
		}	
}
