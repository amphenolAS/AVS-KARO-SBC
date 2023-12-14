package com.avsQual.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avsQual.base.BaseClass;
import com.avsQual.utility.TestUtilities;

public class Setup_CalculationsPage extends BaseClass {

	// Calculation page element variable declaration definition
	WebElement CalculationPageTitle = null;

	WebElement SetupHeaderTextBlock = null;
	WebElement NxtBtn = null;
	WebElement leth_Btn = null;
	WebElement Statistical_Calculation = null;
	WebElement SatTP_btn = null;
	WebElement PreviousButton = null;
	WebElement BTemp_textfield = null;
	WebElement Dvalue_textfield = null;
	WebElement Zvalue_textfield = null;
	WebElement Cleth_DrpDwn = null;
	WebElement BT_UnitsTextBlock = null;
	WebElement Back_btn = null;

	WebElement SaveSetupButton = null;

	private void initializeEelements() {
		CalculationPageTitle = driver.findElementByName("Calculations");
		SetupHeaderTextBlock = driver.findElementByAccessibilityId("SetupHeaderTextBlock");
		PreviousButton = driver.findElementByAccessibilityId("PreviuosButton");
		NxtBtn = driver.findElementByAccessibilityId("NextButton");
		Back_btn = driver.findElementByAccessibilityId("ArrowGlyph");
		leth_Btn = driver.findElementByName("Lethality Calculation");
		Statistical_Calculation = driver.findElementByName("Statistical Calculation");
		SatTP_btn = driver.findElementByName("Saturation P/T Calculation");
//		BTemp_textfield = driver.findElementByAccessibilityId("BaseTemperatureTextBox");
//		Dvalue_textfield = driver.findElementByAccessibilityId("DValueTexBox");
//		Zvalue_textfield = driver.findElementByAccessibilityId("ZValueTextBox");
//		Cleth_DrpDwn = driver.findElementByAccessibilityId("CalculateLethalityComboBox");
//		BT_UnitsTextBlock = driver.findElementByAccessibilityId("BaseTempUnitsTextBlock");

	}

	Setup_CalculationsPage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		CalculationPageTitle = null;
		PreviousButton = null;
		NxtBtn = null;
		SetupHeaderTextBlock = null;
		leth_Btn = null;
		Statistical_Calculation = null;
		SatTP_btn = null;
		BTemp_textfield = null;
		Dvalue_textfield = null;
		Zvalue_textfield = null;
		Cleth_DrpDwn = null;
		BT_UnitsTextBlock = null;
		Back_btn = null;

	}
	TestUtilities tu = new TestUtilities();
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// Setup_Calculations Page methods
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// Check the presence of Calculation page
	public boolean CalculationPage_state() {
		return IsElementVisibleStatus(CalculationPageTitle);
	}

	// Check the presence of leth_Btn state
	public boolean leth_Btnstate() {
		return IsElementVisibleStatus(leth_Btn);
	}

	// click on click on leth_Btn
	public void click_leth_Btn() {
		clickOn(leth_Btn);
	}

	// Check the presence of Statistical_CalculationBtn state
	public boolean Statistical_CalculationBtn_state() {
		return IsElementVisibleStatus(Statistical_Calculation);
	}

	// Check the presence of Saturation_CalculationBtn state
	public boolean Saturation_CalculationBtn_state() {
		return IsElementVisibleStatus(SatTP_btn);
	}

	// Check the presence of BaseTemperature TextBox
	public boolean BTemp_textfield_state() {
		return IsElementVisibleStatus(BTemp_textfield);
	}

	// Check the presence of Dvalue TextBox
	public boolean Dvalue_textfield_state() {
		return IsElementVisibleStatus(Dvalue_textfield);
	}

	// Check the presence of Zvalue TextBox
	public boolean Zvalue_textfield_state() {
		return IsElementVisibleStatus(Zvalue_textfield);
	}

	// Check the presence of Cleth_DrpDwn
	public boolean Cleth_DrpDwn_state() {
		return IsElementVisibleStatus(Cleth_DrpDwn);
	}
	
	// Get the Cleth_DrpDwn title text
	public String getText_From_ClethBox() {
		return FetchText(Cleth_DrpDwn);
	}

	// Get the Calculation page title text
	public String get_CalculationPage_titletext() {
		return FetchText(CalculationPageTitle);
	}

	// Get the SetupHeader title text
	public String get_Setup_titletext() {
		return FetchText(SetupHeaderTextBlock);
	}

	// Verify that degrees centigrade is displayed beside Base temperature field
	public String get_BaseTempUnit_text() {
		WebElement BT_UnitsTextBlock = driver.findElementByAccessibilityId("BaseTempUnitsTextBlock");
		return FetchText(BT_UnitsTextBlock);
	}

	// click on Calculation leth_DrpDwn
	public void Click_Cleth_DrpDwn() {
		clickOn(Cleth_DrpDwn);

	}
	//calculations list items
	public String calculation_Items(int num)
	{
		List<WebElement> item = driver.findElementByAccessibilityId("CalculationTypesListBox")
				.findElements(By.className("TextBlock"));
		return FetchText(item.get(num));
	}
	//click on calculations items
	public void click_calculationItem(int num)
	{
		List<WebElement> item = driver.findElementByAccessibilityId("CalculationTypesListBox")
				.findElements(By.className("TextBlock"));
		waitForElementLoad(item.get(num), 100);
		clickOn(item.get(num));
	}
	//context click
	public void context_Click() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.contextClick().build().perform();
				
		WebElement cntxt_Ele = driver.findElementByAccessibilityId("HelpAppBarButton");
		Thread.sleep(500);
		clickOn(cntxt_Ele);
	}	
	public boolean help_Text()
	{
		WebElement helpButton = driver.findElementByAccessibilityId("helpRichTextBlock");// helpFlyout
		return IsElementVisibleStatus(helpButton);
	}
	public String notepadReader(String path) throws UnsupportedFlavorException, IOException, AWTException
	{
		FileReader reader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = "";
		String notepadContent = "";
		while ((line = bufferedReader.readLine()) != null) {
		    notepadContent += line;
		}
		bufferedReader.close();
		return notepadContent;
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
	public void enter_CondValue(String val)
	{
		WebElement cond = driver.findElementByAccessibilityId("ConditionTextBox");
		enterText(cond, val);
	}
	public void click_Add()
	{
		WebElement add = driver.findElementByAccessibilityId("AddButton");
		clickOn(add);
	}
	public boolean is_PreviousDataAvailale()
	{
		WebElement prev = driver.findElementByAccessibilityId("PART_ScrollViewer");
		return IsElementVisibleStatus(prev);
	}
	public boolean is_LithCalenabled()
	{
		List<WebElement> item = driver.findElementByAccessibilityId("CalculationTypesListBox")
				.findElements(By.className("ListBoxItem"));
		return IsElementEnabledStatus(item.get(1));
	}
	//verify max value
	public boolean is_MaxValueVisible()
	{
		WebElement maxValue = driver.findElementByAccessibilityId("MaxValue");
		return IsElementVisibleStatus(maxValue);
	}
	//verify max value
	public boolean is_MinValueVisible()
	{
		WebElement minValue = driver.findElementByAccessibilityId("MinValue");
		return IsElementVisibleStatus(minValue);
	}
	//Avg and Standard deviation
	public boolean is_AvgStdDevVisible()
	{
		WebElement avgDev = driver.findElementByAccessibilityId("AvgValueStdDev");
		return IsElementVisibleStatus(avgDev);
	}
	//Location Max and Min  
	public boolean is_MaxMinLocVisible()
	{
		WebElement maxMin = driver.findElementByAccessibilityId("LocMaxMin");
		return IsElementVisibleStatus(maxMin);
	}
	//Dif bw Max and Min
	public boolean is_MaxMinDifVisible()
	{
		WebElement maxMindiff = driver.findElementByAccessibilityId("DiffMaxMin");
		return IsElementVisibleStatus(maxMindiff);
	}
	//Diff bw max and avg
	public boolean is_MaxAvgDifVisible()
	{
		WebElement maxavddiff = driver.findElementByAccessibilityId("DiffMaxAvg");
		return IsElementVisibleStatus(maxavddiff);
	}
	//Diff bw Min and Avg
	public boolean is_MinAvgDifVisible()
	{
		WebElement minavddiff = driver.findElementByAccessibilityId("DiffAvgMin");
		return IsElementVisibleStatus(minavddiff);
	}
	//verifying check boxes are selected
	public boolean is_CheckBoxSlctd(int num)
	{
		List<WebElement> chkbx = driver.findElementsByClassName("CheckBox");
		return checkboxSelectStatus(chkbx.get(num));
	}
	//Verifying check boxes are disabled mode
	public boolean is_CheckBoxEnbld(int num)
	{
		List<WebElement> chkbx = driver.findElementsByClassName("CheckBox");
		return IsElementEnabledStatus(chkbx.get(num));
	}
	//Base Temp text box
	public boolean is_BaseTempTxtBoxVsbl()
	{
		WebElement basetemp = driver.findElementByAccessibilityId("BaseTemperatureTextBox");
		return IsElementVisibleStatus(basetemp);
	}
	public void enter_ValBaseTemp(String val)
	{
		WebElement basetemp = driver.findElementByAccessibilityId("BaseTemperatureTextBox");
		clickOn(basetemp);
		ClearText(basetemp);
		enterText(basetemp, val);
	}
	public String get_BaseTempValue()
	{
		WebElement basetemp = driver.findElementByAccessibilityId("BaseTemperatureTextBox");
		basetemp.getAttribute("AutomationId");
		return FetchText(basetemp);
	}
	//D Value Text Box
	public boolean is_DValueTxtBoxVisible()
	{
		WebElement DValue = driver.findElementByAccessibilityId("DValueTexBox");
		return IsElementVisibleStatus(DValue);
	}
	//Z Value text box
	public boolean is_ZValueTxtBoxVisible()
	{
		WebElement zvalue = driver.findElementByAccessibilityId("ZValueTextBox");
		return IsElementVisibleStatus(zvalue);
	}
	public void enterZValue(String val)
	{
		WebElement zvalue = driver.findElementByAccessibilityId("ZValueTextBox");
		clickOn(zvalue);
		ClearText(zvalue);
		enterText(zvalue, val);
	}
	public String get_ZValue()
	{
		WebElement zvalue = driver.findElementByAccessibilityId("ZValueTextBox");
		zvalue.getAttribute("AutomationId");
		return FetchText(zvalue);
	}
	//Lithelity Combo box
	public boolean is_CalLithComboBoxVisible()
	{
		WebElement callith = driver.findElementByAccessibilityId("CalculateLethalityComboBox");
		return IsElementVisibleStatus(callith);
	}
	//click on lithelity combo box
	public void clcik_CalLithComboBox()
	{
		WebElement callith = driver.findElementByAccessibilityId("CalculateLethalityComboBox");
		waitForElementLoad(callith, 100);
		clickOn(callith);
	}
	public String get_TxtCalethCmbBx()
	{
		WebElement callith = driver.findElementByAccessibilityId("CalculateLethalityComboBox");
		return FetchText(callith);
	}
	//click on while min temp
	public void click_MinTemp()
	{
		WebElement temp = driver.findElementByName("While Min Temp");
		clickOn(temp);
	}
	public boolean is_MinTempvisible()
	{
		WebElement temp = driver.findElementByName("While Min Temp");
		return IsElementVisibleStatus(temp);
	}
	public boolean is_MaxTempvisible()
	{
		WebElement temp = driver.findElementByName("While Max Temp");
		return IsElementVisibleStatus(temp);
	}
	public void click_MaxTemp()
	{
		WebElement temp = driver.findElementByName("While Max Temp");
		clickOn(temp);
	}
	public boolean is_DuringEntireStudyvisible()
	{
		WebElement temp = driver.findElementByName("During Entire Study");
		return IsElementVisibleStatus(temp);
	}
	public boolean is_DuringExploCycevisible()
	{
		WebElement temp = driver.findElementByName("During Exposure Cycle");
		return IsElementVisibleStatus(temp);
	}
	//condition box
	public boolean is_LithCondBoxVisible()
	{
		WebElement lethbox = driver.findElementByAccessibilityId("CalConditionComparerComboBox");
		return IsElementVisibleStatus(lethbox);
	}
	//condition value
	public boolean is_LithCondValueVisible()
	{
		WebElement lethval = driver.findElementByAccessibilityId("LethalityCondtionValueTextBox");
		return IsElementVisibleStatus(lethval);
	}
	
	// message box in events
	public boolean is_MsgBxVisible()
	{
		WebElement msg = driver.findElementByAccessibilityId("MessageTextBox");
		return IsElementVisibleStatus(msg);
	}
	//Enter Text into Message Comb Box
	public void entertxt_MsgComboBox(String value)
	{
		WebElement msg = driver.findElementByAccessibilityId("MessageTextBox");
		clickOn(msg);
		ClearText(msg);
		enterText(msg, value);
	}
	//get Text from Message Combo Box
	public String get_TxtMsgComboBox()
	{
		WebElement msg = driver.findElementByAccessibilityId("MessageTextBox");
		return FetchText(msg);
	}
	//when Combo box in events
	public boolean is_WhenCmboBox()
	{
		WebElement when_Combo = driver.findElementByAccessibilityId("WhenComboBox");
		return IsElementVisibleStatus(when_Combo);
	}
	//when Combo box in events
	public void click_WhenCmboBox()
	{
		WebElement when_Combo = driver.findElementByAccessibilityId("WhenComboBox");
		clickOn(when_Combo);
	}
	public String when_ComboOptions(int num)
	{
		List<WebElement> combo = driver.findElementsByClassName("ComboBoxItem");
		return FetchText(combo.get(num));
	}
	//Label Box
	public boolean is_LabelBoxVisible()
	{
		WebElement label = driver.findElementByAccessibilityId("LabelTextBox");
		return IsElementVisibleStatus(label);
	}
	//Enter THe Text into Label Field
	public void enterTxt_LableComboBox(String value)
	{
		WebElement label = driver.findElementByAccessibilityId("LabelTextBox");
		clickOn(label);
		ClearText(label);
		enterText(label, value);
	}
	//get text from Label Combo Box
	public String gettxt_LabelBox()
	{
		WebElement label = driver.findElementByAccessibilityId("LabelTextBox");
		return FetchText(label);
	}
	//Event COndition Combo Box
	public boolean is_EventComboBox()
	{
		WebElement event_Combo = driver.findElementByAccessibilityId("EventConditionComboBox");
		return IsElementVisibleStatus(event_Combo);
	}
	//click on condition box
	public void click_ConditionBox()
	{
		WebElement event_Combo = driver.findElementByAccessibilityId("EventConditionComboBox");
		clickOn(event_Combo);
	}
	public String is_ConditionBoxItem(int num)
	{
		List<WebElement> items = driver.findElementsByClassName("ComboBoxItem");
		return FetchText(items.get(num));
	}
	public void click_ConditionBoxItem(int num)
	{
		List<WebElement> items = driver.findElementsByClassName("ComboBoxItem");
		clickOn(items.get(num));
	}
	public void click_CompareComboBox()
	{
		WebElement com = driver.findElementByAccessibilityId("EventsConditionComparerComboBox");
		clickOn(com);
	}
	//click on condition
	public void click_ConditionalOperators(int number)
	{
		List<WebElement> operator = driver.findElementByAccessibilityId("EventsConditionComparerComboBox")
				.findElements(By.className("ComboBoxItem"));
		
		clickOn(operator.get(number));
	}
	public void click_LithelityCondition(String name, int val)
	{
		List<WebElement> condition = driver.findElementByAccessibilityId("CalculateLethalityComboBox").findElements(By.name(name));
		
		String uservalue = "";
		for(WebElement cond : condition)
		{
			if(FetchText(cond).equalsIgnoreCase(name))
			{
				click_On(cond);
				break;
			}
		}	
			// uservalue = FetchText(cond);
			if(get_TxtCalethCmbBx().equalsIgnoreCase("While Min Temp")||get_TxtCalethCmbBx().equalsIgnoreCase("While Max Temp"))
			{
				try
				{
				WebElement condition_Value = driver.findElementByAccessibilityId("LethalityCondtionValueTextBox");
				waitForElementLoad(condition_Value, 100);
				String valu = Integer.toString(val);
				enterText(condition_Value, valu);
				}
				catch (Exception e) {
					e.getMessage();
				}
			}
			}
//		if(uservalue.equalsIgnoreCase("Undefined"))
//		{
//			WebElement undefined = driver.findElementByName("Undefined");
//			click_On(undefined);
//		}
//		else if(uservalue.equalsIgnoreCase("While Min Temp"))
//		{
//			WebElement minTep = driver.findElementByXPath("//*[normalize-space(.='While Min Temp')]");
//			waitForElementLoad(minTep, 100);
//			click_On(minTep);
//			try
//			{
//			WebElement condition_Value = driver.findElementByAccessibilityId("LethalityCondtionValueTextBox");
//			waitForElementLoad(condition_Value, 100);
//			String valu = Integer.toString(val);
//			enterText(condition_Value, valu);
//			}
//			catch (Exception e) {
//				e.getMessage();
//			}
//		}
//		else if(uservalue.equalsIgnoreCase("While Max Temp"))
//		{
//			WebElement maxTep = driver.findElementByXPath("//*[normalize-space(.='While Max Temp')]");
//			waitForElementLoad(maxTep, 100);
//			click_On(maxTep);
//			try
//			{
//			WebElement condition_Value1 = driver.findElementByAccessibilityId("LethalityCondtionValueTextBox");
//			waitForElementLoad(condition_Value1, 100);
//			String valu1 = Integer.toString(val);
//			enterText(condition_Value1, valu1);
//			}
//			catch (Exception e) {
//				e.getMessage();
//			}
//		}
//		else if(uservalue.equalsIgnoreCase("During Exposure Cycle"))
//		{
//			WebElement expoCyc = driver.findElementByXPath("//*[normalize-space(.='During Exposure Cycle')]");
//			click_On(expoCyc);
//		}
//		else if(uservalue.equalsIgnoreCase("During Exposure Cycle"))
//		{
//			WebElement expoCyc = driver.findElementByXPath("//*[normalize-space(.='During Exposure Cycle')]");
//			click_On(expoCyc);
//		}
//		
		
//		switch(uservalue)
//		{
//		case "Undefined":
//			WebElement undefined = driver.findElementByName("Undefined");
//			click_On(undefined);
//			break;
//			
//		case "While Min Temp":
//			WebElement minTep = driver.findElementByXPath("//*[normalize-space(.='While Min Temp')]");
//			waitForElementLoad(minTep, 100);
//			click_On(minTep);
//			WebElement condition_Value = driver.findElementByAccessibilityId("LethalityCondtionValueTextBox");
//			waitForElementLoad(condition_Value, 100);
//			String valu = Integer.toString(val);
//			enterText(condition_Value, valu);
//			break;
//			
//		case "While Max Temp":
//			WebElement maxTep = driver.findElementByXPath("//*[normalize-space(.='While Max Temp')]");
//			waitForElementLoad(maxTep, 100);
//			click_On(maxTep);
//			WebElement condition_Value1 = driver.findElementByAccessibilityId("LethalityCondtionValueTextBox");
//			waitForElementLoad(condition_Value1, 100);
//			String valu1 = Integer.toString(val);
//			enterText(condition_Value1, valu1);
//			break;
//			
//		case "During Exposure Cycle":
//			WebElement expoCyc = driver.findElementByXPath("//*[normalize-space(.='During Exposure Cycle')]");
//			click_On(expoCyc);
//			break;
//			
//		default: 
//			System.out.println("Please Enter Matching Condition");
//			break;
//		
//		}
	
//	public void click_ReqCond(String val)
//	{
//		WebElement eq1 = driver.findElementByName("=");
//		WebElement eq2 = driver.findElementByName("<");
//		WebElement eq3 = driver.findElementByName(">=");
//		WebElement eq4 = driver.findElementByName("<=");
//		WebElement eq5 = driver.findElementByName(">");
//		
//		if(val.equals(FetchText(eq1)))
//		{
//			clickOn(eq1);
//		}
//		else if(val.equals(FetchText(eq2)))
//		{
//			clickOn(eq2);
//		}
//		else if(val.equals(FetchText(eq3)))
//		{
//			clickOn(eq3);
//		}
//		else if(val.equals(FetchText(eq4)))
//		{
//			clickOn(eq4);
//		}
//		else if(val.equals(FetchText(eq5)))
//		{
//			clickOn(eq5);
//		}
//		
//	}
	public String isConditionalOperatorsVisible(int number) throws InterruptedException
	{
		List<WebElement> operator = driver.findElementByAccessibilityId("EventsConditionComparerComboBox")
				.findElements(By.className("ComboBoxItem"));
		Thread.sleep(500);
		return FetchText(operator.get(number));
	}
	
//	public boolean is_EqualOperatorVisible()
//	{
//		WebElement eq = driver.findElementByName("=");
//			return IsElementVisibleStatus(eq);
//	}
//	public boolean is_LessThanOperatorVisible()
//	{
//		WebElement eq = driver.findElementByName("<");
//			return IsElementVisibleStatus(eq);
//	}
//	public boolean is_LessThanEqualOPeratorVisible()
//	{
//		WebElement eq = driver.findElementByName("<=");
//			return IsElementVisibleStatus(eq);
//	}
//	public boolean is_GrtrEqualOperatorVisible()
//	{
//		WebElement eq = driver.findElementByName(">=");
//			return IsElementVisibleStatus(eq);
//	}
//	public boolean is_GrtrThanVisible()
//	{
//		WebElement eq = driver.findElementByName(">");
//			return IsElementVisibleStatus(eq);
//	}
	public void entertxt_LithCondValue(String val)
	{
		WebElement lethval = driver.findElementByAccessibilityId("LethalityCondtionValueTextBox");
		clickOn(lethval);
		ClearText(lethval);
		enterText(lethval, val);
	}
	public String get_LithCondValue()
	{
		WebElement lethval = driver.findElementByAccessibilityId("LethalityCondtionValueTextBox");
		lethval.getAttribute("AutomationId");
		return FetchText(lethval);
	}
	
	// Select Aleth condition
	public void select_AlethCondition(String ALethCond) throws InterruptedException {
		clickOn(Cleth_DrpDwn);
		Thread.sleep(1000);
		WebElement ALeth_Undefined = driver.findElementByName("Undefined");
		WebElement ALeth_entireStudy = driver.findElementByName("During Entire Study");
		WebElement ALeth_Exposure = driver.findElementByName("During Exposure Cycle");

		if (ALethCond.contains("Entire Study")) {
			clickOn(ALeth_entireStudy);
			Thread.sleep(500);
		} else if (ALethCond.contains("Exposure Cycle")) {
			clickOn(ALeth_Exposure);
			Thread.sleep(500);
		} else {
			clickOn(ALeth_Undefined);
			Thread.sleep(500);
		}

	}

	// Click Dvalue_textfield
	public void click_Dvalue_textfield() {
		clickOn(Dvalue_textfield);
	}

	// Enter D-Value
	public void Enter_Dvalue_textfield(String Dval) {
		clickOn(Dvalue_textfield);
		ClearText(Dvalue_textfield);
		enterText(Dvalue_textfield, Dval);

	}

	// Click the Sat TP button in left pane
	public void click_SatTP_btn() {
		clickOn(SatTP_btn);
		// clickOn(SatTP_btn);
	}

	// fetch text from PressureSensorsComboBox
	public String FetchTxt_PressureSensorsComboBox() {
		WebElement SatP_TempDrpDwnBox = driver.findElementByAccessibilityId("PressureSensorsComboBox");
		return FetchText(SatP_TempDrpDwnBox);
	}

//click on PressureSensorsComboBox

	public void clickon_PressureSensorsComboBox() {
		WebElement SatP_TempDrpDwnBox = driver.findElementByAccessibilityId("PressureSensorsComboBox");
		clickOn(SatP_TempDrpDwnBox);

	}

//select sensor
	public void selectSensor_SaturationPressureOfSteam_DD(int index) throws InterruptedException {
		clickon_PressureSensorsComboBox();
		List<WebElement> senrList = driver.findElements(By.className("ComboBoxItem"));
		clickOn(senrList.get(index));
	}

	// get the sensor text from Pressure Sensors ComboBox
	public String getSensorTxt_SaturationPressureOfSteam(int index) throws InterruptedException {

		List<WebElement> senrList = driver.findElementByAccessibilityId("PressureSensorsComboBox")
				.findElements(By.className("ComboBoxItem"));
		// System.out.println(senrList.size());
		return senrList.get(index).getText();
		// return FetchText(senrList.get(index));
	}

	// verify is PressureSensorsComboBox enable
	public boolean PressureSensorsComboBox_IsEnable() {
		WebElement SatP_TempDrpDwnBox = driver.findElementByAccessibilityId("PressureSensorsComboBox");
		return IsElementEnabledStatus(SatP_TempDrpDwnBox);
	}

	// Get the default value displayed in Base Temperature field
	public String BTemp_text() {
		return FetchText(BTemp_textfield);
	}

	// Get the default value displayed in D Value field

	public String get_DValueField_text() {
		return FetchText(Dvalue_textfield);
	}

	// click on Btemp
	public void click_BTemp() {
		clickOn(BTemp_textfield);
	}

	// Enter ALeth Base Temp data
	public void enter_bTemp(String bTemp) {
		clickOn(BTemp_textfield);
		ClearText(BTemp_textfield);
		enterText(BTemp_textfield, bTemp);
	}

	// Zvalue_textfield
	public String ZValueField_text() {
		return FetchText(Zvalue_textfield);
	}

	// Enter Z Value
	public void enter_Zval(String zval) {
		clickOn(Zvalue_textfield);
		ClearText(Zvalue_textfield);
		enterText(Zvalue_textfield, zval);
	}

	// selectSensorFrom SaturationTemperatureOfSteam_DD

	public void selectSensor_SaturationTemperatureOfSteam_DD(int index) throws InterruptedException {
		WebElement SatP_PsrDrpDwnBox = driver.findElementByAccessibilityId("TemperatureSenosrsComboBox");
		clickOn(SatP_PsrDrpDwnBox);
		List<WebElement> senrList = driver.findElements(By.className("ComboBoxItem"));
		clickOn(senrList.get(index));
	}

//get text Temperature Sensors ComboBox
	public void Clickon_TemperatureSenosrsComboBox() throws InterruptedException {
		WebElement SatP_PrDrpDwnBox = driver.findElementByAccessibilityId("TemperatureSenosrsComboBox");
		clickOn(SatP_PrDrpDwnBox);

	}

	// fetch text from TemperatureSenosrsComboBox
	public String FetchTxt_TempSensorsComboBox() {
		WebElement SatP_PsrDrpDwnBox = driver.findElementByAccessibilityId("TemperatureSenosrsComboBox");
		return FetchText(SatP_PsrDrpDwnBox);
	}

	// get Sensor Txt from SaturationTemperatureOfSteam

	public String getSensorTxt_SaturationTemperatureOfSteam(int index) throws InterruptedException {

		List<WebElement> senrList = driver.findElementByAccessibilityId("TemperatureSenosrsComboBox")
				.findElements(By.className("ComboBoxItem"));

		return senrList.get(index).getText();
		// return FetchText(senrList.get(index));
	}

	// verify is TemperatureSenosrsComboBox enable
	public boolean Temp_SensorsComboBox_IsEnable() {
		WebElement SatP_TempDrpDwnBox = driver.findElementByAccessibilityId("TemperatureSenosrsComboBox");
		return SatP_TempDrpDwnBox.isEnabled();
	}

	// Check the presence of NxtBtn
	public boolean Is_QualificationParameters_Visible() {
		return IsElementVisibleStatus(NxtBtn);
	}

	// Is_GroupSensors_Visible
	public boolean Is_GroupSensors_Visible() {
		return IsElementVisibleStatus(PreviousButton);
	}

	// click on group sensor btn
	public Setup_GroupSensorsPage click_groupsensorTab() throws IOException {
		clickOn(PreviousButton);
		return new Setup_GroupSensorsPage();
	}

	// Click the Next button to move to Setup Qualification page
	public Setup_CalVerParametersPage Click_NxtBtn() throws IOException, InterruptedException {
		waitForElementLoad(NxtBtn, 100);
		clickOn(NxtBtn);
		return new Setup_CalVerParametersPage();
	}

	// For alert msg
	public void NxtBtn_alert() throws IOException, InterruptedException {
		clickOn(NxtBtn);
	}

	// Fetch alert msg
	public String AlertMsg() {
		WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return FetchText(Msg);
	}

	public boolean cal_Lethality_options() {
		WebElement ALeth_Undefined = driver.findElementByName("Undefined");
		ALeth_Undefined.isDisplayed();

		WebElement ALeth_entireStudy = driver.findElementByName("During Entire Study");
		ALeth_entireStudy.isDisplayed();
		WebElement ALeth_Exposure = driver.findElementByName("During Exposure Cycle");
		ALeth_Exposure.isDisplayed();
		return true;
	}

	// Is Saturation pressure of steam displayed
	public boolean Is_TempSensorDD_AgainstSATp_displayed() {
		WebElement satrnprsrofstm = driver.findElementByName("Saturation pressure of steam");
		return satrnprsrofstm.isDisplayed();

	}

	// Is Saturation temp of steam displayed
	public boolean Is_PsrSensorDD_AgainstSATp_displayed() {
		WebElement satrntmprofstm = driver.findElementByName("Saturation temperature of steam");
		return satrntmprofstm.isDisplayed();

	}

//click back
	public assetDetailsPage Click_BackBtnWithYes() throws IOException, InterruptedException {
		clickOn(Back_btn);

		tu.click_YesBtn_popup();
		Thread.sleep(1000);
		return new assetDetailsPage();
	}
	public void click_BackBtn()
	{
		clickOn(Back_btn);
	}
	
	// Verify the D Field is not editable
	public boolean IsDvalue_Readonly() {
		WebElement readOnly = driver.findElementByAccessibilityId("DValueTexBox");
		return readOnly.getAttribute("Value.IsReadOnly").equals("True");

	}
	public void click_DValueBox()
	{
		WebElement readOnly = driver.findElementByAccessibilityId("DValueTexBox");
		clickOn(readOnly);
	}
	public void click_Randomly()
	{
		WebElement ele = driver.findElementByAccessibilityId("BaseTemperatureTextBox");
		clickOn(ele);
	}
	public void entertext_DValueBox(String val)
	{
		WebElement readOnly = driver.findElementByAccessibilityId("DValueTexBox");
		clickOn(readOnly);
		ClearText(readOnly);
		enterText(readOnly, val);
	}
	public String get_Dvalue() {
		WebElement readOnly = driver.findElementByAccessibilityId("DValueTexBox");
		readOnly.getAttribute("AutomationId");
		return FetchText(readOnly);
	}
	//context click
	public MainHubPage contextClick() throws IOException
	{
		Actions act =new Actions(driver);
		act.contextClick().build().perform();
			
		WebElement homeBtn = driver.findElementByAccessibilityId("HomeAppBarButton");
		clickOn(homeBtn);
		return new MainHubPage();
	}
	
	public boolean is_UndefinedVisible() 
	{
		WebElement ele = driver.findElementByName("Undefined");
		 return IsElementVisibleStatus(ele);
	}


}

