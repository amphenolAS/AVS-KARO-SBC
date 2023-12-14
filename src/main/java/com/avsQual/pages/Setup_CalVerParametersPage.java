package com.avsQual.pages;


import java.io.IOException;
import java.sql.Driver;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avsQual.base.BaseClass;
import com.avsQual.utility.TestUtilities;

public class Setup_CalVerParametersPage extends BaseClass{
	
	
	 WebElement Next_btn = null;
	 WebElement calvertitle = null;
	 WebElement previos_btn = null;
	 WebElement setupName = null;
	 WebElement calTemp = null;
	 WebElement verTemp =null;
	 WebElement devCriteria = null;
	 WebElement stabCriteria = null;
	 WebElement lowCHKBOX = null;
	 WebElement highCHKBox = null;
	 WebElement chkBoxTxtBox = null;
	 WebElement calChkBox = null;
	 WebElement verLowChkBox = null;
	 WebElement verHighChkBox = null;
	 WebElement verChkPoint = null;
	 WebElement LowVerChkBox = null;
	 WebElement HighVerChkBox = null;
	 WebElement VerChkBox = null;
	 WebElement Celsius = null;
	 WebElement IRTDBox = null;
	 WebElement IRTDMinutes = null;
	 WebElement uncalbrate = null;
	 WebElement CalibrateSens = null;
	 WebElement leftCalSensMin = null;
	 WebElement sensortemp = null;
	 WebElement sensorTempTime = null;
	 WebElement verCalSens = null;
	 WebElement verCalSensMin = null;
	 WebElement Back_btn = null;
	 
	private void initializeEelements() {
		Next_btn = driver.findElementByAccessibilityId("NextButton");
		calvertitle = driver.findElementByAccessibilityId("CurrentTextBlock");
		previos_btn = driver.findElementByAccessibilityId("PreviuosButton");
		setupName = driver.findElementByAccessibilityId("SetupHeaderTextBlock");
		calTemp =driver.findElementByName("Calibration Temperature Setpoints");
		verTemp = driver.findElementByName("Verification Temperature Setpoints");
		devCriteria = driver.findElementByName("Deviation Criteria");
		stabCriteria = driver.findElementByName("Stability Criteria");
		lowCHKBOX = driver.findElementByAccessibilityId("LowTextBox");
		highCHKBox = driver.findElementByAccessibilityId("HighTextBox");
		chkBoxTxtBox = driver.findElementByAccessibilityId("CheckTextBox");
		calChkBox = driver.findElementByAccessibilityId("CheckCalibrationCheckBox");
		verLowChkBox = driver.findElementByAccessibilityId("VerLowTextBox");
		verHighChkBox = driver.findElementByAccessibilityId("VerHighTextBox");
		verChkPoint = driver.findElementByAccessibilityId("VerCheckTextBox");
		LowVerChkBox = driver.findElementByAccessibilityId("LowVerificationCheckBox");
		HighVerChkBox = driver.findElementByAccessibilityId("HighVerificationCheckBox");
		VerChkBox = driver.findElementByAccessibilityId("CheckVerificationCheckBox");
		Celsius = driver.findElementByName("°C");
		IRTDBox = driver.findElementByAccessibilityId("IRTDTextBox");
		IRTDMinutes = driver.findElementByAccessibilityId("IRTDMinutesTextBox");
		uncalbrate = driver.findElementByAccessibilityId("UncalibratedSensorTextBox");
		CalibrateSens = driver.findElementByAccessibilityId("CalibratedSensorTextBox");
		leftCalSensMin = driver.findElementByAccessibilityId("DeviationMinutesTextBox");
		sensortemp = driver.findElementByAccessibilityId("SensorsTextBox");
		sensorTempTime = driver.findElementByAccessibilityId("SensorsMinutesTextBox");
		verCalSens = driver.findElementByAccessibilityId("VerCalibratedSensorTextBox");
		verCalSensMin = driver.findElementByAccessibilityId("VerDeviationMinutesTextBox");
		Back_btn = driver.findElementByAccessibilityId("ArrowGlyph");
	}
	Setup_CalVerParametersPage() throws IOException {
		super();
		initializeEelements();
	}	
	TestUtilities tu = new TestUtilities();
		// Release memory
		public void resetWebElements() {
			Next_btn = null;
			calvertitle = null;
			previos_btn = null;
			setupName =null;
			calTemp = null;
			verTemp =null;
			devCriteria = null;
			stabCriteria = null;
			lowCHKBOX =null;
			highCHKBox =null;
			chkBoxTxtBox =null;
			calChkBox =null;
			verLowChkBox = null;
			verHighChkBox = null;
			verChkPoint = null;
			LowVerChkBox = null;
			HighVerChkBox = null;
			VerChkBox =null;
			IRTDBox = null;
			IRTDMinutes = null;
			uncalbrate = null;
			CalibrateSens = null;
			leftCalSensMin = null;
			sensortemp = null;
			sensorTempTime = null;
			verCalSens = null;
			verCalSensMin = null;
			Back_btn = null;
		}
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Qual parameters Page methods
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//page title
		public boolean is_CalVerParametersPagestate()
		{
			return IsElementVisibleStatus(calvertitle);
		}
		//Calibration Temperatire exists or nt
		public boolean is_CalTempVisible()
		{
			return IsElementVisibleStatus(calTemp);
		}
		//Verification Temperature exists or not
		public boolean is_VerTempVisible()
		{
			return IsElementVisibleStatus(verTemp);
		}
		//Deviation Criteria is exists or not
		public boolean is_DevCriteriaVisible()
		{
			return IsElementVisibleStatus(devCriteria);
		}
		//Stability Criteria is visible or not
		public boolean is_StabCriteriaVisible()
		{
			return IsElementVisibleStatus(stabCriteria);
		}
		//Verification Low Check Point
		public boolean is_LowVerChkPointVisible()
		{
			return IsElementVisibleStatus(LowVerChkBox);
		}
		//degree celsius units
		public String get_TempUits()
		{
			return FetchText(Celsius);
		}
		//degree celsius units
		public String get_VerTempUits()
		{
			List<WebElement>Celsius = driver.findElementsByName("°C");
			
			return FetchText(Celsius.get(7));
		}
		public void click_VerTempUits()
		{
			List<WebElement>Celsius = driver.findElementsByName("°C");
			
			clickOn(Celsius.get(7));
		}
		public void click_Celsius()
		{
			clickOn(Celsius);
		}
		//Clickig on the Verification Low check point
		public void click_VerLowChkPoint()
		{
			clickOn(LowVerChkBox);
		}
		//Clicking on the Verfication High Check point
		public void click_VerHighChkPoint()
		{
			clickOn(HighVerChkBox);
		}
		//click on the verification Check Point
		public void click_VerChck()
		{
			clickOn(VerChkBox);
		}
		//Verification High Check Point
		public boolean is_HighVerChkPointVisible()
		{
			return IsElementVisibleStatus(HighVerChkBox);
		}
		//Verification Check Point
		public boolean is_VerChkPntVisible()
		{
			return IsElementVisibleStatus(VerChkBox);
		}
		//Verification Low check point visible or not
		public boolean is_VerLowChkBoxVisible()
		{
			return IsElementVisibleStatus(verLowChkBox);
		}
		public String get_TextFromLowVerPoint()
		{
			return FetchText(verLowChkBox);
		}
		public void enter_TxtIntoLowVerPoint(String val)
		{
			clickOn(verLowChkBox);
			ClearText(verLowChkBox);
			enterText(Celsius, val);
		}
		//Verification High Check Point visible or not
		public boolean is_VerHighChkBoxVisible()
		{
			return IsElementVisibleStatus(verHighChkBox);
		}
		public boolean is_VerHichSetPointEnabled()
		{
			return IsElementEnabledStatus(verHighChkBox);
		}
		//fetch text from High verification set point
		public String get_TextFromHighVerPoint()
		{
			return FetchText(verHighChkBox);
		}
		public void enter_TxtIntoHighVerPoint(String val)
		{
			clickOn(verHighChkBox);
			ClearText(verHighChkBox);
			enterText(verHighChkBox, val);
		}
		//Verification Check Point visible or not
		public boolean is_VerChkBoxVisible()
		{
			return IsElementVisibleStatus(verChkPoint);
		}
		//fetch text from temperature verification set point
		public String get_TextFromVerChkPoint()
		{
			return FetchText(verChkPoint);
		}
		//High Check Box Text Box visible or not
		public boolean is_HighChkBoxVisible()
		{
			return IsElementVisibleStatus(highCHKBox);
		}
		//enter Text into High Check Box Text Field
		public void enter_TextintoHighTxtBox(String val)
		{
			clickOn(highCHKBox);
			ClearText(highCHKBox);
			enterText(highCHKBox, val);
		}
		//get Text from High Check Box Text Box
		public String get_TextFromHighTxtBox()
		{
			return FetchText(highCHKBox);
		}
		//Low Check Box Text Box Visible or not
		public boolean is_LowChkBoxVisible()
		{
			return IsElementVisibleStatus(lowCHKBOX);
		}
		//enter text into low check box
		public void enter_TextintoLowTxtBox(String val)
		{
			clickOn(lowCHKBOX);
			ClearText(lowCHKBOX);
			enterText(lowCHKBOX, val);
		}
		//get text from low check box
		public String get_TextFroLowTxtBox()
		{
			return FetchText(lowCHKBOX);
		}
		//Check Box Text Box Visible or Not
		public boolean is_ChkBoxtxtBoxVisible()
		{
			return IsElementVisibleStatus(chkBoxTxtBox);
		}
		public boolean is_CalChkBoxEditable() {
			return IsElementEnabledStatus(chkBoxTxtBox);
		}
		
		//enter value into check point field
		public void enter_TxtintoCheckPoint(String val)
		{
			clickOn(chkBoxTxtBox);
			ClearText(chkBoxTxtBox);
			enterText(chkBoxTxtBox, val);
		}
		//click on back button
		public void click_BackBtn()
		{
			clickOn(Back_btn);
		}
		//click back with yes button
		public assetDetailsPage Click_BackBtnWithYes() throws IOException {
			//clickOn(Back_btn);
			WebElement Yesbtn = driver.findElementByName("Yes");
			clickOn(Yesbtn);
			return new assetDetailsPage();
		}
		//get text from check point
		public String get_TextFromChckPoint()
		{
			return FetchText(chkBoxTxtBox);
		}
		
		//Caliberation Check box is visible
		public boolean is_CalChkBoxVisible()
		{
			return IsElementVisibleStatus(calChkBox);
		}
		//click to next page
		public Setup_QualParamPage click_NextPage() throws IOException
		{
			clickOn(Next_btn);
			return new Setup_QualParamPage();
		}
		//clicking on next page with pop up
		public void click_NextPageWithPopUp()
		{
			clickOn(Next_btn);
		}
		//click to previous page
		public Setup_CalculationsPage click_PreviousPage() throws IOException
		{
			clickOn(previos_btn);
			return new Setup_CalculationsPage();
		}
		//get name of setup
		public String get_SetupName()
		{
			return FetchText(setupName);
		}
		//getting IRTD text
		public String get_IRTDText()
		{
			return FetchText(IRTDBox);
		}
		//IRTD box is enabled or not
		public boolean is_IRTDenabled()
		{
			return IsElementEnabledStatus(IRTDBox) && IRTDBox.getAttribute("AutomationId")==null;
		}
		public void click_OnIRTDCheckBox()
		{
		clickOn(IRTDBox);
		}
		public void enter_TextIntoIRTD(String val)
		{
			clickOn(IRTDBox);
			ClearText(IRTDBox);
			enterText(IRTDBox, val);
		}
		public String getAtt()
		{
			return IRTDBox.getAttribute("AutomationId");
		}
		public boolean is_DeletBtnVisible()
		{
			WebElement deleteBtn = driver.findElementByAccessibilityId("DeleteButton");
			return IsElementVisibleStatus(deleteBtn);
		}
		public void enter_textIntoIRTDMinBox(String text)
		{
			clickOn(IRTDMinutes);
			ClearText(IRTDMinutes);
			enterText(IRTDMinutes, text);
		}
		public String get_IRTDMinTextBox()
		{
			return FetchText(IRTDMinutes);
		}
		public void enter_TextintoUncalibrate(String text)
		{
			clickOn(uncalbrate);
			ClearText(uncalbrate);
			enterText(uncalbrate, text);
		}
		public String get_TextFromUnCalibrate()
		{
			return FetchText(uncalbrate);
		}
		public void enter_TextCalbrateSensLeft(String text)
		{
			clickOn(CalibrateSens);
			ClearText(CalibrateSens);
			enterText(CalibrateSens, text);
		}
		public String get_TextCalSensLeft()
		{
			return FetchText(CalibrateSens);
		}
		public void enter_TextIntoleftCalSensMin(String text) {
			clickOn(leftCalSensMin);
			ClearText(leftCalSensMin);
			enterText(leftCalSensMin, text);
		}
		public String get_TextFromleftCalSensMin() {
			return FetchText(leftCalSensMin);
		}
		public void enter_TempintoSensBox(String text) {
			clickOn(sensortemp);
			ClearText(sensortemp);
			enterText(sensortemp, text);
		}
		public String get_TempFromSensBox() {
			return FetchText(sensortemp);
		}
		public void enter_TextinsensorTempTimeBox(String text) {
			clickOn(sensorTempTime);
			ClearText(sensorTempTime);
			enterText(sensorTempTime, text);
		}
		public String get_TextFromSensorTempTimeBox() {
			return FetchText(sensorTempTime);
		}
		public String get_TextFromVerCalSensBox()
		{
			return FetchText(verCalSens);
		}
		public void enter_VerCalSensBox(String val) {
			clickOn(verCalSens);
			ClearText(verCalSens);
			enterText(verCalSens, val);
		}
		public String get_TextFromVerCalSensMin() {
			return FetchText(verCalSensMin);
		}
		public void enter_TextIntoVerCalSensMin(String val)
		{
			clickOn(verCalSensMin);
			ClearText(verCalSensMin);
			enterText(verCalSensMin, val);
		}
		public boolean is_AllTxtVisibleonPage()
		{
			List<WebElement> item = driver.findElementsByClassName("TextBlock");
			for(WebElement txt: item)
			{
				IsElementVisibleStatus(txt);
			}
			return true;
		}
		//context click
//		public void context_Click() throws InterruptedException
//		{
//			Actions act = new Actions(driver);
//			act.contextClick().build().perform();
//					
//			WebElement cntxt_Ele = driver.findElementByAccessibilityId("HelpAppBarButton");
//			tu.waitForElementToBeVisible(cntxt_Ele);
//			clickOn(cntxt_Ele);
//			
//		}	
		public String help_Text()
		{
			WebElement helpButton = driver.findElementByAccessibilityId("helpRichTextBlock");// helpFlyout
			return FetchText(helpButton);
		}
}
