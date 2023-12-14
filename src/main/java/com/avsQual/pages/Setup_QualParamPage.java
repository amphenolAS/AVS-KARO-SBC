package com.avsQual.pages;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Highlighter.Highlight;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avsQual.utility.TestUtilities;

import com.avsQual.base.BaseClass;

public class Setup_QualParamPage extends BaseClass {
	TestUtilities tu = new TestUtilities();

// Qualification Parameters page element variable declaration definition
	WebElement QualParamsPageTitle = null;
	WebElement QStart_text = null;
	WebElement QStart_DrpDwn = null;
	WebElement QStop_text = null;
	WebElement QStop_DrpDwn = null;
	WebElement SR_text = null;
	WebElement SR_DrpDwn = null;
	WebElement TR_text = null;
	WebElement TR_DrpDwn = null;
	WebElement RFT_DrpDwn = null;
	WebElement RFT_text = null;
	WebElement NxtBtn = null;
	WebElement PreviousButton = null;
	WebElement BackButton = null;
	WebElement SetupHeaderTextBlock = null;
	WebElement sub_header = null;
	WebElement start_Stopcond = null;
	WebElement Data_Storage = null;
	WebElement RF_Transmit = null;
	WebElement StartQualificationTextBlock = null;
	WebElement StopQualificationTextBlock = null;
	WebElement relay = null;
	WebElement start_Exposure = null;
	WebElement stop_Exposure = null;
	WebElement start_ExpComboBox = null;
	WebElement stop_ExpoComboBox = null;

	private void initializeEelements() {
		QualParamsPageTitle = driver.findElementByName("Qualification Parameters");
		SetupHeaderTextBlock = driver.findElementByAccessibilityId("SetupHeaderTextBlock");
		QStart_text = driver.findElementByAccessibilityId("StartQualificationTextBlock");
		QStart_DrpDwn = driver.findElementByAccessibilityId("StartQualificationComboBox");
		QStop_text = driver.findElementByAccessibilityId("StopQualificationTextBlock");
		QStop_DrpDwn = driver.findElementByAccessibilityId("StopQualificationComboBox");
		SR_text = driver.findElementByName("Sampling Rate");
		SR_DrpDwn = driver.findElementByAccessibilityId("FileRateComboBox");
//		TR_text = driver.findElementByName("Transmission Rate");
//		TR_DrpDwn = driver.findElementByAccessibilityId("DisplayRate");
//		RFT_text = driver.findElementByName("RF Transmit Threshold");
//		RFT_DrpDwn = driver.findElementByAccessibilityId("_rfCommToggleThresholdSettingsComboBox");
		NxtBtn = driver.findElementByAccessibilityId("NextButton");
		PreviousButton = driver.findElementByAccessibilityId("PreviuosButton");
		relay = driver.findElementByName("Relay");
		BackButton = driver.findElementByAccessibilityId("ArrowGlyph");
		start_Stopcond = driver.findElementByName("Start Stop Conditions:");
		Data_Storage = driver.findElementByName("Data Storage");
//		RF_Transmit = driver.findElementByName("RF Transmit Threshold");
//		sub_header = driver.findElementByName("Define The Qualification Details");
		start_Exposure = driver.findElementByAccessibilityId("StartExposureTextBlock");
		start_ExpComboBox = driver.findElementByAccessibilityId("StartExposureComboBox");
		stop_Exposure = driver.findElementByAccessibilityId("StopExposureTextBlock");
		stop_ExpoComboBox = driver.findElementByAccessibilityId("StopExposureComboBox");

	}

	Setup_QualParamPage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		QualParamsPageTitle = null;
		QStart_text = null;
		QStart_DrpDwn = null;
		QStop_text = null;
		QStop_DrpDwn = null;
		SR_text = null;
		SR_DrpDwn = null;
		TR_text = null;
		TR_DrpDwn = null;
		RFT_DrpDwn = null;
		RFT_text = null;
		NxtBtn = null;
		BackButton = null;
		SetupHeaderTextBlock = null;
		sub_header = null;
		start_Stopcond = null;
		Data_Storage = null;
		RF_Transmit = null;
		StartQualificationTextBlock = null;
		StopQualificationTextBlock = null;
		relay = null;
		start_Exposure = null;
		stop_Exposure = null;
		start_ExpComboBox = null;
		stop_ExpoComboBox = null;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// Qual parameters Page methods
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// Check the presence of Qualification Parameters page
	public boolean QualParamsPage_state() {
		return IsElementVisibleStatus(QualParamsPageTitle);
	}

	// check the presence of start_Stopcond
	public boolean start_Stopcond_state() {
		return IsElementVisibleStatus(start_Stopcond);
	}

	// check the presence of start_Stopcond
	public boolean Data_Storage_state() {
		return IsElementVisibleStatus(Data_Storage);
	}

	// RF Transmit Threshold

	public boolean RF_Transmit_state() {
		return IsElementVisibleStatus(RF_Transmit);
	}

	// check presence of QStart_text

	public boolean QStart_text_state() {
		return IsElementVisibleStatus(QStart_text);
	}

	//Relay presence
	public boolean relay_VisibleState() {
		return IsElementVisibleStatus(relay);
	}
	// check presence of QStop_text

	public boolean QStop_Visiblestate() {
		return IsElementVisibleStatus(QStop_text);
	}

	//start_Exposure
	public boolean is_start_ExposureVisible() {
		return IsElementVisibleStatus(start_Exposure);
	}
	//stop_Exposure
	public boolean is_stop_ExposureVisible() {
		return IsElementVisibleStatus(stop_Exposure);
	}
	// verify next btn state
	public boolean IsReviewTab_Visisble() {
		return IsElementVisibleStatus(NxtBtn);
	}

	// verify Previous Button state
	public boolean IsCalculationTab_Visible() {
		return IsElementVisibleStatus(PreviousButton);
	}

	// Get the SetupHeader title text
	public String get_Setup_titletext() {
		return FetchText(SetupHeaderTextBlock);
	}

	// Get the Subheader title text
	public String get_SubHeader_titletext() {
		return FetchText(sub_header);
	}

	// Get the Qualification Parameters page title text

	public String get_QualParamsPage_titletext() {
		return FetchText(QualParamsPageTitle);
	}

	// Click the Qual Start dropdown box
	public void click_Qstart_DrpDwnBox() {
		clickOn(QStart_DrpDwn);
	}
	public void click_OnDate()
    {
    	WebElement date = driver.findElementByAccessibilityId("DropDownGlyph").findElement(By.name("")); //PART_PickerButton
    	waitForElementLoad(date, 100);
    	click_On(date);
    }
	//Select Value from Start Qualification Drop Down
	public void select_DropDownOptionFromStrtQual(String val, String mon, String dt, String yr, String hr, String min, String sec, String cond, String qualTemp) throws InterruptedException
	{
		click_Qstart_DrpDwnBox();
/*		click_Qstart_DrpDwnBox();
		
		Actions act = new Actions(driver);
		for(int i = 0; i <= 50; i++)
		{
		if(get_Txt_QStartDrpDwn().equalsIgnoreCase(val))
		{
			Thread.sleep(1000);
			break;
		}
		else
		{
			act.sendKeys(Keys.ARROW_DOWN).build().perform();
		}
		} */
		List<WebElement> comboBoxItem = driver.findElementByAccessibilityId("StartQualificationComboBox").findElements(By.name(val));
		for(WebElement comboItem: comboBoxItem)
		{
			if(IsElementVisibleStatus(comboItem))
			{
				clickOn(comboItem);
				break;
			}
		}
		
		
		List<WebElement> startQualVal = driver.findElementsByAccessibilityId("StartQualificationComboBox");
		
		for(WebElement Qval:startQualVal)
		{
		if(FetchText(Qval).equalsIgnoreCase("Time Of Day"))
		{
			
			click_OnDate();
			Actions act = new Actions(driver);
    		for(int i=0; i<12;i++)
    		{
    			try
    			{
    				//WebElement month = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name("October"));
    				WebElement month = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name(mon));
    				if(IsElementVisibleStatus(month))
    				{
    					waitForElementLoad(month, 100);
    					clickOn(month);
    					break;
    				}
    			}
    			catch (Exception e) {
    				act.sendKeys(Keys.ARROW_DOWN).build().perform();
    			}
    		}
    		act.sendKeys(Keys.ARROW_RIGHT).build().perform();
    		for(int i=0; i<31;i++)
    		{
    			try
    			{
    				//WebElement date = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name("13"));
    				WebElement date = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name(dt));
    				if(IsElementVisibleStatus(date))
    				{
    					waitForElementLoad(date, 100);
    					clickOn(date);
    					break;
    				}
    			}
    			catch (Exception e) {
    				act.sendKeys(Keys.ARROW_DOWN).build().perform();
    			}
    		}
    		act.sendKeys(Keys.ARROW_RIGHT).build().perform();
    		for(int i=0; i<31;i++)
    		{
    			try
    			{
    				//WebElement year = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name("2020"));
    				WebElement year = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name(yr));
    				if(IsElementVisibleStatus(year))
    				{
    					waitForElementLoad(year, 100);
    					clickOn(year);
    					break;
    				}
    			}
    			catch (Exception e) {
    				act.sendKeys(Keys.ARROW_DOWN).build().perform();
    			}
    		}
    		WebElement okBtn = driver.findElementByAccessibilityId("PART_SelectorOKButton");
    		waitForElementLoad(okBtn, 100);
    		click_On(okBtn);
			
			WebElement hour= driver.findElementByAccessibilityId("Hours");
			WebElement minu= driver.findElementByAccessibilityId("Min");
			WebElement secunds= driver.findElementByAccessibilityId("Sec");
			waitForElementLoad(hour, 100);
			click_On(hour);
			ClearText(hour);
			enterText(hour, hr);
			
			waitForElementLoad(minu, 100);
			click_On(minu);
			ClearText(minu);
			enterText(minu, min);
			
			waitForElementLoad(secunds, 100);
			click_On(secunds);
			ClearText(secunds);
			enterText(secunds, sec);
		}
		
		else if(FetchText(Qval).equalsIgnoreCase("Temp1")||FetchText(Qval).equalsIgnoreCase("Temp2")||FetchText(Qval).equalsIgnoreCase("Temp48"))
		{
			WebElement compareComboBox = driver.findElementByAccessibilityId("StartQualificationComparerComboBox");
			waitForElementLoad(compareComboBox, 100);
			click_On(compareComboBox);
		
			WebElement item = compareComboBox.findElement(By.name(cond));
			waitForElementLoad(item, 100);
			click_On(item);
			
			WebElement QualTxtBox = driver.findElementByAccessibilityId("StartQualificationTextBox");
			waitForElementLoad(QualTxtBox, 100);
			click_On(QualTxtBox);
			ClearText(QualTxtBox);
			enterText(QualTxtBox, qualTemp);
		}
		}
		
	}
	
	public void select_DropDownOptionFromStrtExpo(String val, String hr, String min, String sec, String cond, String qualTemp) throws InterruptedException
	{
		click_StartExpo();

		List<WebElement> comboBoxItem = driver.findElementByAccessibilityId("StartExposureComboBox").findElements(By.name(val));
		for(WebElement comboItem: comboBoxItem)
		{
			if(IsElementVisibleStatus(comboItem))
			{
				clickOn(comboItem);
				break;
			}
		}
		
		if(fetch_DfltTxtFromStartExpoCombo().equalsIgnoreCase("Cycle Time"))
		{
			WebElement hour= driver.findElementByAccessibilityId("HoursStartExposure");
			WebElement minu= driver.findElementByAccessibilityId("MinStartExposure");
			WebElement secunds= driver.findElementByAccessibilityId("SecStartExposure");
			waitForElementLoad(hour, 100);
			click_On(hour);
			ClearText(hour);
			enterText(hour, hr);
			
			waitForElementLoad(minu, 100);
			click_On(minu);
			ClearText(minu);
			enterText(minu, min);
			
			waitForElementLoad(secunds, 100);
			click_On(secunds);
			ClearText(secunds);
			enterText(secunds, sec);
		}
		
		else if(fetch_DfltTxtFromStartExpoCombo().equalsIgnoreCase("Min Temp")||fetch_DfltTxtFromStartExpoCombo().equalsIgnoreCase("Max Temp")||
				fetch_DfltTxtFromStartExpoCombo().equalsIgnoreCase("Temp1"))
		{
			WebElement compareComboBox = driver.findElementByAccessibilityId("StartExposureComparerComboBox");
			waitForElementLoad(compareComboBox, 100);
			click_On(compareComboBox);
		
			WebElement item = compareComboBox.findElement(By.name(cond));
			waitForElementLoad(item, 100);
			click_On(item);
			
			WebElement QualTxtBox = driver.findElementByAccessibilityId("StartExposureTextBox");
			waitForElementLoad(QualTxtBox, 100);
			click_On(QualTxtBox);
			ClearText(QualTxtBox);
			enterText(QualTxtBox, qualTemp);
		}
		
	}
	
	public void select_DropDownOptionFromStopExpo(String val, String hr, String min, String sec, String cond, String qualTemp) throws InterruptedException
	{
		click_StopExpo();

		List<WebElement> comboBoxItem = driver.findElementByAccessibilityId("StopExposureComboBox").findElements(By.name(val));
		for(WebElement comboItem: comboBoxItem)
		{
			if(IsElementVisibleStatus(comboItem))
			{
				clickOn(comboItem);
				break;
			}
		}
		
		if(fetch_TextFromStopExpoCombo().equalsIgnoreCase("Cycle Time")||fetch_TextFromStopExpoCombo().equalsIgnoreCase("ExpTime"))
		{
			WebElement hour= driver.findElementByAccessibilityId("HoursStopExposure");
			WebElement minu= driver.findElementByAccessibilityId("MinStopExposure");
			WebElement secunds= driver.findElementByAccessibilityId("SecStopExposure");
			waitForElementLoad(hour, 100);
			click_On(hour);
			ClearText(hour);
			enterText(hour, hr);
			
			waitForElementLoad(minu, 100);
			click_On(minu);
			ClearText(minu);
			enterText(minu, min);
			
			waitForElementLoad(secunds, 100);
			click_On(secunds);
			ClearText(secunds);
			enterText(secunds, sec);
		}
		
		else if(fetch_DfltTxtFromStartExpoCombo().equalsIgnoreCase("Min Temp")||fetch_DfltTxtFromStartExpoCombo().equalsIgnoreCase("Max Temp")||
				fetch_DfltTxtFromStartExpoCombo().equalsIgnoreCase("Min Accum Leth")||fetch_DfltTxtFromStartExpoCombo().equalsIgnoreCase("Temp1"))
		{
			WebElement compareComboBox = driver.findElementByAccessibilityId("StopExposureComparerComboBox");
			waitForElementLoad(compareComboBox, 100);
			click_On(compareComboBox);
		
			WebElement item = compareComboBox.findElement(By.name(cond));
			waitForElementLoad(item, 100);
			click_On(item);
			
			WebElement QualTxtBox = driver.findElementByAccessibilityId("StopExposureTextBox");
			waitForElementLoad(QualTxtBox, 100);
			click_On(QualTxtBox);
			ClearText(QualTxtBox);
			enterText(QualTxtBox, qualTemp);
		}
		
	}
	public void select_DropDownOptionFromStopQual(String val, String hr, String min, String sec, String cond, String qualTemp) throws InterruptedException
	{
		click_Qstop_DrpDwnBox();

		List<WebElement> comboBoxItem = driver.findElementByAccessibilityId("StopQualificationComboBox").findElements(By.name(val));
		for(WebElement comboItem: comboBoxItem)
		{
			if(IsElementVisibleStatus(comboItem))
			{
				clickOn(comboItem);
				break;
			}
		}
		
		if(getTxt_of_QstopDrpDwn().equalsIgnoreCase("Cycle Time"))
		{
			WebElement hour= driver.findElementByAccessibilityId("HoursStopQualification");
			WebElement minu= driver.findElementByAccessibilityId("MinStopQualification");
			WebElement secunds= driver.findElementByAccessibilityId("SecStopQualification");
			waitForElementLoad(hour, 100);
			click_On(hour);
			ClearText(hour);
			enterText(hour, hr);
			
			waitForElementLoad(minu, 100);
			click_On(minu);
			ClearText(minu);
			enterText(minu, min);
			
			waitForElementLoad(secunds, 100);
			click_On(secunds);
			ClearText(secunds);
			enterText(secunds, sec);
		}
		
		else if(getTxt_of_QstopDrpDwn().equalsIgnoreCase("Temp1")||getTxt_of_QstopDrpDwn().equalsIgnoreCase("Temp2")||getTxt_of_QstopDrpDwn().equalsIgnoreCase("Min Accum Leth"))
		{
			WebElement compareComboBox = driver.findElementByAccessibilityId("StopQualificationComparerComboBox");
			waitForElementLoad(compareComboBox, 100);
			click_On(compareComboBox);
		
			WebElement item = compareComboBox.findElement(By.name(cond));
			waitForElementLoad(item, 100);
			click_On(item);
			
			WebElement QualTxtBox = driver.findElementByAccessibilityId("StopQualificationTextBox");
			waitForElementLoad(QualTxtBox, 100);
			click_On(QualTxtBox);
			ClearText(QualTxtBox);
			enterText(QualTxtBox, qualTemp);
		}
		
	}
	//click on required value on QStartDropDown
	public void click_ReqQStartDrpDwnValue(int index) throws InterruptedException
	{
		click_Qstart_DrpDwnBox();
		List<WebElement> listitem = QStart_DrpDwn.findElements(By.className("ComboBoxItem"));
//		for(WebElement item:listitem)
//		{
//			Thread.sleep(1000);
//			if(FetchText(item).equalsIgnoreCase(val))
//			{
//				clickOn(item);
//				break;
//			}
//		}
		clickOn(listitem.get(index));
		Thread.sleep(1000);
	}

	// Is QStart_DrpDwn visible
	public boolean IsQstart_DrpDwnBoxVisible() {
		return IsElementVisibleStatus(QStart_DrpDwn);

	}
	//visibility of required string
	public boolean IsQstart_ReqDrpDwnValue(int index) {
		List<WebElement> listitem = QStart_DrpDwn.findElements(By.className("ComboBoxItem"));
		return IsElementVisibleStatus(listitem.get(index));
//		return IsElementVisibleStatus(QStart_DrpDwn);

	}
	public boolean is_QStartConditioBoxVisible()
	{
		WebElement ele = driver.findElementByAccessibilityId("StartQualificationComparerComboBox");
		return IsElementVisibleStatus(ele);
	}
	//get text from QStart condition box
	public String getText_QStartcComparatorCondtnBox()
	{
		WebElement ele = driver.findElementByAccessibilityId("StartQualificationComparerComboBox");
		return FetchText(ele);
	}

	// is QStop_DrpDwn visible
	public boolean IsQstop_DrpDwnBoxVisible() {
		return IsElementVisibleStatus(QStop_DrpDwn);

	}

	// fetch text
	public String get_Txt_QStartDrpDwn() {
		return FetchText(QStart_DrpDwn);
	}
	
	public String getText_Hours() {
		WebElement ele = driver.findElementByAccessibilityId("Hours");
		return FetchText(ele);
	}
	//

	// Verify that first option as "Manual" displayed in Start Qualification drop
	// down
	public String Fetchoptions_From_QStartDrpDwn(int index) {
		List<WebElement> itemlist = driver.findElements(By.className("ComboBoxItem"));
		return FetchText(itemlist.get(index));
	}

	// click on manual from start qualification drop down

	public void selectOptions_From_QStartDrpDwn(int index) {
		List<WebElement> itemlist = driver.findElements(By.className("ComboBoxItem"));
		itemlist.get(index).click();
	}

	// Select TOD Qual Start parameter with how much Date/time ahead one wants to
	// set to start Qual
	// If one wants to add 1 to yr/Mnth/Dt/Hr/Mnt/Sec, then enter the parameters
	// like
	// Time of the Day, 1,1,1,1,1,1,1
	public void select_QualStart_condition(String QStart, int dt, int mnth, int Yr, int hr, int mnt, int sec)
			throws InterruptedException, ParseException {
		Actions ac = new Actions(driver);
		if (QStart.equals("Time Of Day")) {
			click_Qstart_DrpDwnBox();
			Thread.sleep(1000);
			WebElement QSt_TOD = driver.findElementByName("Time Of Day");
			clickOn(QSt_TOD);
			Thread.sleep(500);
			enter_TOD_QualStart(dt, mnth, Yr, hr, mnt, sec);
		}
	}
	//verify start qualification parameters
	
	  public String get_QStartPara(int index) {
		  
		  List<WebElement> ele = QStart_DrpDwn
				  .findElements(By.className("ComboBoxItem"));
		  
//		  String s=""; 
//		 for(int i=0;i<ele.size();i++)
//		 {			
//			s =  FetchText(ele.get(i));			
//		 }
		  return FetchText(ele.get(index));
		
	   }
	  //fetch default text from start_ExpComboBox
	  public String fetch_DfltTxtFromStartExpoCombo()
	  {
		  return FetchText(start_ExpComboBox);
	  }
	  public void click_StartExpo()
	  {
		  clickOn(start_ExpComboBox);
	  }
	  //fetch text from start exposure condition box
	  public String getTxt_StrtExpoComparatorComboBox()
	  {
		  WebElement compCombobox = driver.findElementByAccessibilityId("StartExposureComparerComboBox");
		  return FetchText(compCombobox);
	  }
	  public boolean is_StrtExpoCompCmbBoxVisible()
	  {
		  WebElement compCombobox = driver.findElementByAccessibilityId("StartExposureComparerComboBox");
		  return IsElementVisibleStatus(compCombobox);
	  }
	  //clicking start exposure drop down for required values
	  public void click_ReqStartExpoDrpDwnValue(int index) throws InterruptedException
	  {
		  click_StartExpo();
		  List<WebElement> ele = start_ExpComboBox
				  .findElements(By.className("ComboBoxItem"));
//		  for(WebElement item:ele)
//		  {
//			  Thread.sleep(1000);
//			  if(FetchText(item).equalsIgnoreCase(val))
//			  {
//				  clickOn(item);
//				  break;
//			  }
//			 
//		  }
		  clickOn(ele.get(index));
		  Thread.sleep(1000);
	  }
	  //get text from StopExposureTextBox
	  public String getTxt_StpExpoTxtBox()
	  {
		  WebElement stpExpoTxt = driver.findElementByAccessibilityId("StopExposureTextBox");
		  stpExpoTxt.getAttribute("AutomationId");
		  return FetchText(stpExpoTxt);
	  }
	  //enter text into StopExposureTextBox
	  public void enterTxt_StpExpoTxtBx(String text)
	  {
		  WebElement stpExpoTxt = driver.findElementByAccessibilityId("StopExposureTextBox");
		  clickOn(stpExpoTxt);
		  ClearText(stpExpoTxt);
		  enterText(stpExpoTxt, text);
	  }
	  //visibility of StopExposureTextBox
	  public boolean is_StpExpoTextBoxVsible()
	  {
		  WebElement stpExpoTxt = driver.findElementByAccessibilityId("StopExposureTextBox");
		  return IsElementVisibleStatus(stpExpoTxt);
	  }
	  //fetch text from start_ExpComboBox
	  public String fetch_TxtFromStartExpoCombo(int index)
	  {
		  List<WebElement> ele = start_ExpComboBox
				  .findElements(By.className("ComboBoxItem"));
		  return FetchText(ele.get(index));
	  }
	  //fetch the stop exposure default value
	  public String fetch_TextFromStopExpoCombo()
	  {
		  return FetchText(stop_ExpoComboBox);
	  }
	  //click on stop exposure
	  public void  click_StopExpo()
	  {
		  clickOn(stop_ExpoComboBox);
	  }
	  //click on stop exposure based on required option
	  public void click_RerStpExpoDrpDwnOption(int index) throws InterruptedException
	  {
		  click_StopExpo();
		  List<WebElement> stpExpcombo = stop_ExpoComboBox.findElements(By.className("ComboBoxItem"));
//		  for(WebElement item:stpExpcombo)
//		  {
//			  Thread.sleep(1000);
//			  if(FetchText(item).equalsIgnoreCase(val))
//			  {
//				  clickOn(item);
//				  break;
//			  }
//		  }
		  clickOn(stpExpcombo.get(index));
		  Thread.sleep(1000);
	  }
	 //fetch stop exposure drop down values
	  public String fetch_DropDownValueFromStopExpoCombo(int index)
	  {
		  List<WebElement> ele = stop_ExpoComboBox.findElements(By.className("ComboBoxItem"));
		  return FetchText(ele.get(index));
	  }
	  
	// fetch date from Time Of The Day window

	public String fetch_Date() {
		WebElement date = driver.findElementByAccessibilityId("PART_PickerButton");
		return FetchText(date);
	}

	// is date field visible
	public boolean Is_DateField_Visible() {
		WebElement date = driver.findElementByAccessibilityId("PART_PickerButton");
		return date.isDisplayed();
	}

	// Select Date
	public boolean Is_SelectDate_Visible() {
		WebElement datefield = driver.findElementByAccessibilityId("PART_PickerButton");
		clickOn(datefield);
		WebElement Selectdate = driver.findElementByName("Select Date");
		return Selectdate.isDisplayed();
	}

	// fetch Minute from Time Of The Day window

	public String fetch_Min() {
		WebElement Mn = driver.findElementByAccessibilityId("Min");
		return FetchText(Mn);
	}

	// fetch Second from Time Of The Day window

	public String fetch_Sec() {
		WebElement Sc = driver.findElementByAccessibilityId("Sec");
		return FetchText(Sc);
	}

	// Enter hr to text fild

	public void enter_Hour(String hr) {
		WebElement Hr_textfield = driver.findElementByAccessibilityId("Hours");

		clickOn(Hr_textfield);
		ClearText(Hr_textfield);
		enterText(Hr_textfield, hr);
	}
	//enter hours from 0 to 23
//	public void enter_From0To23()
//	{
//		for(int i=0;i<=23;i++)
//		{
//			String val = Integer.toString(i);
//			enter_Hour(val);
//		}
//	}

	// Enter sec to text fild

	public void enter_Sec(String sc) {
		WebElement Sec_textfield = driver.findElementByAccessibilityId("Sec");

		clickOn(Sec_textfield);
		ClearText(Sec_textfield);
		enterText(Sec_textfield, sc);
	}

	// Enter min to text fild

	public void enter_Min(String min) {
		WebElement Mn_textfield = driver.findElementByAccessibilityId("Min");

		clickOn(Mn_textfield);
		ClearText(Mn_textfield);
		enterText(Mn_textfield, min);
	}

	// click on MM
	public void click_Min() {
		WebElement Mn_textfield = driver.findElementByAccessibilityId("Min");

		clickOn(Mn_textfield);
	}

	// click on ss
	public void click_Sec() {
		WebElement Sec_textfield = driver.findElementByAccessibilityId("Sec");

		clickOn(Sec_textfield);
	}

	// Is_Hours_visible
	public boolean Is_Hours_visible() {
		WebElement Hr = driver.findElementByAccessibilityId("Hours");
		return Hr.isDisplayed();
	}

	// Is_Min_visible
	public boolean Is_Min_visible() {
		WebElement Mn = driver.findElementByAccessibilityId("Min");
		return Mn.isDisplayed();
	}

	// Is_Sec_visible
	public boolean Is_Sec_visible() {
		WebElement Sc = driver.findElementByAccessibilityId("Sec");
		return Sc.isDisplayed();
	}

	// Enter default time of the day by adding 1 Hr to QStart parameter
	public void enter_TOD_QualStart(int dt, int mnth, int Yr, int hr, int mnt, int sec)
			throws InterruptedException, ParseException {

		WebElement TOD_Hr = driver.findElementByAccessibilityId("Hours");
		WebElement TOD_Mnt = driver.findElementByAccessibilityId("Min");
		WebElement TOD_Sec = driver.findElementByAccessibilityId("Sec");

		Actions ac = new Actions(driver);
		WebElement TOD_DtPkr = driver.findElementByAccessibilityId("PART_PickerButton");
		String TOD_DtTxt11 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
		//// System.out.println("TOD_DtTxt11: " + TOD_DtTxt11);
		String TOD_dd1 = TOD_DtTxt11.split("-")[0];
		//// System.out.println("TOD_dd1: " + TOD_dd1);
		String TOD_mm1 = TOD_DtTxt11.split("-")[1];
		//// System.out.println("TOD_mm1: " + TOD_mm1);

		if (TOD_dd1.equals("31") && TOD_mm1.equals("12")) {
			clickOn(TOD_DtPkr);
			Thread.sleep(500);
			ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN)
					.build().perform();
			clickOn(TOD_DtPkr);
			ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			Thread.sleep(500);

			String TOD_DtTxt22 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
			//// System.out.println("TOD_DtTxt22:" + TOD_DtTxt22);
			String TOD_dd2 = TOD_DtTxt22.split("-")[0];
			// System.out.println("TOD_dd2:" + TOD_dd2);
			String TOD_mm2 = TOD_DtTxt22.split("-")[1];
			// System.out.println("TOD_mm2: " + TOD_mm2);

			// System.out.println("Is TOD_dd1 = TOD_dd2: " + TOD_dd1.equals(TOD_dd2));

			if (!TOD_dd1.equals(TOD_dd2) && TOD_mm2.equals(TOD_mm1)) {
				clickOn(TOD_DtPkr);
				Thread.sleep(500);
				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
				clickOn(TOD_DtPkr);
				ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN)
						.build().perform();
				Thread.sleep(500);

				String TOD_DtTxt33 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
				// System.out.println("TOD_DtTxt33: " + TOD_DtTxt33);
				String TOD_dd3 = TOD_DtTxt33.split("-")[0];
				// System.out.println("TOD_dd3: " + TOD_dd3);
				String TOD_mm3 = TOD_DtTxt33.split("-")[1];
				// System.out.println("TOD_mm3: " + TOD_mm3);
				String TOD_yy3 = TOD_DtTxt33.split("-")[2];
				// System.out.println("TOD_yy3: " + TOD_yy3);

				String newDtTime = tu.add_to_Crrnt_DateandTimeStamp(dt, mnth, Yr, hr, mnt, sec);
				// System.out.println("Expected newDtTime: " + newDtTime);
				String[] newDtTime1 = newDtTime.split(":");
				// System.out.println("New Day: " + newDtTime1[0]);
				// System.out.println("New Mnth: " + newDtTime1[1]);
				// System.out.println("New Yr: " + newDtTime1[2]);
				String final_dd = TOD_dd3;
				String final_mm = TOD_mm3;
				String final_yy = TOD_yy3;

				// Change the Year
				while (!newDtTime1[2].equals(final_yy)) {
					clickOn(TOD_DtPkr);
					ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN)
							.sendKeys(Keys.RETURN).build().perform();
					Thread.sleep(500);
					String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
					final_yy = f_TOD_DtTxt.split("-")[2];
					// System.out.println("final_yy: " + final_yy);
				}
				// Change the Month
				for (int i = 1; i <= 12; i++) {
					if (newDtTime1[1].equals(final_mm)) {
						break;
					} else {
						clickOn(TOD_DtPkr);
						ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						Thread.sleep(500);
						String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
						final_mm = f_TOD_DtTxt.split("-")[1];
						// System.out.println("final_mm: " + final_mm);
					}
				}
				// Change the Date
				for (int j = 1; j <= 31; j++) {
					if (newDtTime1[0].equals(final_dd)) {
						break;
					} else {
						clickOn(TOD_DtPkr);
						ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						Thread.sleep(500);
						String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
						final_dd = f_TOD_DtTxt.split("-")[0];
						// System.out.println("final_dd: " + final_dd);
					}
				}

				// Change the Hour
				clickOn(TOD_Hr);
				ClearText(TOD_Hr);
				enterText(TOD_Hr, newDtTime1[3]);
				// Change the Minute
				clickOn(TOD_Mnt);
				ClearText(TOD_Mnt);
				enterText(TOD_Mnt, newDtTime1[4]);
				// Change the Sec
				clickOn(TOD_Sec);
				ClearText(TOD_Sec);
				enterText(TOD_Sec, newDtTime1[5]);
				Thread.sleep(1000);
				String TOD_DtTxt4 = TOD_DtPkr.getText();
				String TOD_DtTxt44 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtTxt4);
				// System.out.println("Final TOD selection:" + TOD_DtTxt44 + ":" +
				// TOD_Hr.getText() + ":"
				// + TOD_Mnt.getText() + ":" + TOD_Sec.getText());
				clickOn(QStart_text);

			} else {
				// System.out.println("else H1 TOD_DtPkr:" + TOD_DtPkr.getText());
				clickOn(TOD_DtPkr);
				Thread.sleep(500);
				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
				clickOn(TOD_DtPkr);
				ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN)
						.build().perform();
				Thread.sleep(500);

				String TOD_DtTxt3 = TOD_DtPkr.getText();
				String TOD_DtTxt33 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtTxt3);
				// System.out.println(TOD_DtTxt33);
				String TOD_dd3 = TOD_DtTxt33.split("-")[0];
				// System.out.println(TOD_dd3);
				String TOD_mm3 = TOD_DtTxt33.split("-")[1];
				// System.out.println(TOD_mm3);
				String TOD_yy3 = TOD_DtTxt33.split("-")[2];
				// System.out.println(TOD_yy3);

				String newDtTime = tu.add_to_Crrnt_DateandTimeStamp(dt, mnth, Yr, hr, mnt, sec);
				// System.out.println("Expected newDtTime: " + newDtTime);
				String[] newDtTime1 = newDtTime.split(":");
				// System.out.println("New Day: " + newDtTime1[0]);
				// System.out.println("New Mnth: " + newDtTime1[1]);
				// System.out.println("New Yr: " + newDtTime1[2]);
				String final_dd = TOD_dd3;
				String final_mm = TOD_mm3;
				String final_yy = TOD_yy3;

				// Change the Year
				while (!newDtTime1[2].equals(final_yy)) {
					clickOn(TOD_DtPkr);
					ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN)
							.sendKeys(Keys.RETURN).build().perform();
					Thread.sleep(500);
					String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
					final_yy = f_TOD_DtTxt.split("-")[2];
					// System.out.println(final_yy);
				}
				// Change the Month
				for (int i = 1; i <= 12; i++) {
					if (newDtTime1[1].equals(final_mm)) {
						break;
					} else {
						clickOn(TOD_DtPkr);
						ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						Thread.sleep(500);
						String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
						final_mm = f_TOD_DtTxt.split("-")[1];
						// System.out.println(final_mm);
					}
				}
				// Change the Date
				for (int j = 1; j <= 31; j++) {
					if (newDtTime1[0].equals(final_dd)) {
						break;
					} else {
						clickOn(TOD_DtPkr);
						ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						Thread.sleep(500);
						String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
						final_dd = f_TOD_DtTxt.split("-")[0];
						// System.out.println(final_dd);
					}
				}

				// Change the Hour
				clickOn(TOD_Hr);
				ClearText(TOD_Hr);
				enterText(TOD_Hr, newDtTime1[3]);
				// Change the Minute
				clickOn(TOD_Mnt);
				ClearText(TOD_Mnt);
				enterText(TOD_Mnt, newDtTime1[4]);
				// Change the Sec
				clickOn(TOD_Sec);
				ClearText(TOD_Sec);
				enterText(TOD_Sec, newDtTime1[5]);
				Thread.sleep(1000);
				String TOD_DtTxt4 = TOD_DtPkr.getText();
				String TOD_DtTxt44 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtTxt4);
				// System.out.println("Final TOD selection:" + TOD_DtTxt44 + ":" +
				// TOD_Hr.getText() + ":"
				// + TOD_Mnt.getText() + ":" + TOD_Sec.getText());
				clickOn(QStart_text);
			}

		} else {
			// Verifying If the DtPkr 1st item is same as the items reflected in the DtPkt
			// txt box
			// And if not accordingly selecting the DD/MM.
			// This code will work where the Host system has got difference in the 1st Item
			// of DtPckr
			clickOn(TOD_DtPkr);
			Thread.sleep(500);
			ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			Thread.sleep(500);

			String TOD_DtTxt22 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
			// System.out.println("TOD_DtTxt22:" + TOD_DtTxt22);
			String TOD_dd2 = TOD_DtTxt22.split("-")[0];
			// System.out.println("TOD_dd2:" + TOD_dd2);
			String TOD_mm2 = TOD_DtTxt22.split("-")[1];
			// System.out.println("TOD_mm2: " + TOD_mm2);

			// System.out.println("Is TOD_dd1 = TOD_dd2: " + TOD_dd1.equals(TOD_dd2));

			if (!TOD_dd1.equals(TOD_dd2) && TOD_mm2.equals(TOD_mm1)) {
				clickOn(TOD_DtPkr);
				Thread.sleep(500);
				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
				Thread.sleep(500);

				String TOD_DtTxt33 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
				// System.out.println("TOD_DtTxt33: " + TOD_DtTxt33);
				String TOD_dd3 = TOD_DtTxt33.split("-")[0];
				// System.out.println("TOD_dd3: " + TOD_dd3);
				String TOD_mm3 = TOD_DtTxt33.split("-")[1];
				// System.out.println("TOD_mm3: " + TOD_mm3);
				String TOD_yy3 = TOD_DtTxt33.split("-")[2];
				// System.out.println("TOD_yy3: " + TOD_yy3);

				String newDtTime = tu.add_to_Crrnt_DateandTimeStamp(dt, mnth, Yr, hr, mnt, sec);
				// System.out.println("Expected newDtTime: " + newDtTime);
				String[] newDtTime1 = newDtTime.split(":");
				// System.out.println("New Day: " + newDtTime1[0]);
				// System.out.println("New Mnth: " + newDtTime1[1]);
				// System.out.println("New Yr: " + newDtTime1[2]);
				String final_dd = TOD_dd3;
				String final_mm = TOD_mm3;
				String final_yy = TOD_yy3;

				// Change the Year
				while (!newDtTime1[2].equals(final_yy)) {
					clickOn(TOD_DtPkr);
					ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN)
							.sendKeys(Keys.RETURN).build().perform();
					Thread.sleep(500);
					String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
					final_yy = f_TOD_DtTxt.split("-")[2];
					// System.out.println(final_yy);
				}
				// Change the Month
				for (int i = 1; i <= 12; i++) {
					if (newDtTime1[1].equals(final_mm)) {
						break;
					} else {
						clickOn(TOD_DtPkr);
						ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						Thread.sleep(500);
						String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
						final_mm = f_TOD_DtTxt.split("-")[1];
						// System.out.println(final_mm);
					}
				}
				// Change the Date
				for (int j = 1; j <= 31; j++) {
					if (newDtTime1[0].equals(final_dd)) {
						break;
					} else {
						clickOn(TOD_DtPkr);
						ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						Thread.sleep(500);
						String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
						final_dd = f_TOD_DtTxt.split("-")[0];
						// System.out.println(final_dd);
					}
				}

				// Change the Hour
				clickOn(TOD_Hr);
				ClearText(TOD_Hr);
				enterText(TOD_Hr, newDtTime1[3]);
				// Change the Minute
				clickOn(TOD_Mnt);
				ClearText(TOD_Mnt);
				enterText(TOD_Mnt, newDtTime1[4]);
				// Change the Sec
				clickOn(TOD_Sec);
				ClearText(TOD_Sec);
				enterText(TOD_Sec, newDtTime1[5]);
				Thread.sleep(1000);
				String TOD_DtTxt4 = TOD_DtPkr.getText();
				String TOD_DtTxt44 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtTxt4);
				// System.out.println("Final TOD selection:" + TOD_DtTxt44 + ":" +
				// TOD_Hr.getText() + ":"
				// + TOD_Mnt.getText() + ":" + TOD_Sec.getText());
				clickOn(QStart_text);
			} else {
				// System.out.println("else part-TOD_DtPkr:" + TOD_DtPkr.getText());
				clickOn(TOD_DtPkr);
				Thread.sleep(500);
				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
				Thread.sleep(500);

				String TOD_DtTxt3 = TOD_DtPkr.getText();
				String TOD_DtTxt33 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtTxt3);
				// System.out.println(TOD_DtTxt33);
				String TOD_dd3 = TOD_DtTxt33.split("-")[0];
				// System.out.println(TOD_dd3);
				String TOD_mm3 = TOD_DtTxt33.split("-")[1];
				// System.out.println(TOD_mm3);
				String TOD_yy3 = TOD_DtTxt33.split("-")[2];
				// System.out.println(TOD_yy3);

				String newDtTime = tu.add_to_Crrnt_DateandTimeStamp(dt, mnth, Yr, hr, mnt, sec);
				// System.out.println("Expected newDtTime: " + newDtTime);
				String[] newDtTime1 = newDtTime.split(":");
				// System.out.println("New Day: " + newDtTime1[0]);
				// System.out.println("New Mnth: " + newDtTime1[1]);
				// System.out.println("New Yr: " + newDtTime1[2]);
				String final_dd = TOD_dd3;
				String final_mm = TOD_mm3;
				String final_yy = TOD_yy3;

				// Change the Year
				while (!newDtTime1[2].equals(final_yy)) {
					clickOn(TOD_DtPkr);
					ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN)
							.sendKeys(Keys.RETURN).build().perform();
					Thread.sleep(500);
					String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
					final_yy = f_TOD_DtTxt.split("-")[2];
					// System.out.println(final_yy);
				}
				// Change the Month
				for (int i = 1; i <= 12; i++) {
					if (newDtTime1[1].equals(final_mm)) {
						break;
					} else {
						clickOn(TOD_DtPkr);
						ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						Thread.sleep(500);
						String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
						final_mm = f_TOD_DtTxt.split("-")[1];
						// System.out.println(final_mm);
					}
				}
				// Change the Date
				for (int j = 1; j <= 31; j++) {
					if (newDtTime1[0].equals(final_dd)) {
						break;
					} else {
						clickOn(TOD_DtPkr);
						ac.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						Thread.sleep(500);
						String f_TOD_DtTxt = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtPkr.getText());
						final_dd = f_TOD_DtTxt.split("-")[0];
						// System.out.println(final_dd);
					}
				}

				// Change the Hour
				clickOn(TOD_Hr);
				ClearText(TOD_Hr);
				enterText(TOD_Hr, newDtTime1[3]);
				// Change the Minute
				clickOn(TOD_Mnt);
				ClearText(TOD_Mnt);
				enterText(TOD_Mnt, newDtTime1[4]);
				// Change the Sec
				clickOn(TOD_Sec);
				ClearText(TOD_Sec);
				enterText(TOD_Sec, newDtTime1[5]);
				Thread.sleep(1000);
				String TOD_DtTxt4 = TOD_DtPkr.getText();
				String TOD_DtTxt44 = tu.convert_StringDate_to_ActualDate_inCertainFormat3(TOD_DtTxt4);
				// System.out.println("Final TOD selection:" + TOD_DtTxt44 + ":" +
				// TOD_Hr.getText() + ":"
				// + TOD_Mnt.getText() + ":" + TOD_Sec.getText());
				clickOn(QStart_text);
			}
		}
	}

	// Select Qual Stop parameter
	public void select_QualStop_condition(String QStop, String Hrs, String Mnts, String Secs)
			throws InterruptedException {
		Actions ac = new Actions(driver);
		if (QStop.equals("Cycle Time")) {
			click_Qstop_DrpDwnBox();
			// click_Qstop_DrpDwnBox();
			Thread.sleep(500);

			// WebElement QSt_Manual = driver.findElementByName("Manual");
			WebElement QStp_CT = driver.findElementByName("Cycle Time");
			clickOn(QStp_CT);
			Thread.sleep(500);
			enter_CT_QualStop(Hrs, Mnts, Secs);
			Thread.sleep(1000);
		}
	}

	// Enter Cycle Time Hr/Mnts/Secs data to Qual Stop CT parameter
	public void enter_CT_QualStop(String Hrs, String Mnts, String Secs) {
		WebElement CT_Hr = driver.findElementByAccessibilityId("HoursStopQualification");
		WebElement CT_Mnt = driver.findElementByAccessibilityId("MinStopQualification");
		WebElement CT_Sec = driver.findElementByAccessibilityId("SecStopQualification");

		// Change the Hour
		clickOn(CT_Hr);
		ClearText(CT_Hr);
		enterText(CT_Hr, Hrs);
		// Change the Minute
		clickOn(CT_Mnt);
		ClearText(CT_Mnt);
		enterText(CT_Mnt, Mnts);
		// Change the Sec
		clickOn(CT_Sec);
		ClearText(CT_Sec);
		enterText(CT_Sec, Secs);
		// System.out.println("Final CT selection: " + CT_Hr.getText() + ":" +
		// CT_Mnt.getText() + ":" + CT_Sec.getText());
		clickOn(QStop_text);
	}

	// Click the Sampling Rate dropdown box
	public void click_SR_DrpDwnBox() {
		clickOn(SR_DrpDwn);
	}
	public List<String> get_OptionsFromSamplingRateDrpDwn() throws InterruptedException
	{
		List<WebElement> options = SR_DrpDwn.findElements(By.className("ComboBoxItem"));
				click_SR_DrpDwnBox();		
				//click_SR_DrpDwnBox();
				Actions act = new Actions(driver);
				List<String> getAllOptions = new ArrayList();
				for(int j=0;j<=3;j++)
				{
					act.sendKeys(Keys.ARROW_UP).build().perform();
					Thread.sleep(500);
				}
				for(int i=0;i<=20;i++)
				{
					getAllOptions.add(fetch_DefaultTxt_SR());
					act.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(500);
				}
				return getAllOptions;
		
		/*		for(WebElement item:options)
				{
					FetchText(item);
				}
				
				List<String> optionTexts = new ArrayList<>();
				optionTexts.add(item);
				return optionTexts; */
	}

	// fetch default text from sample rate dropdown

	public String fetch_DefaultTxt_SR() {
		return FetchText(SR_DrpDwn);

	}

	// fetch text of options from sample rate dropdown

	public String Fetch_optnTxt_SRDD(int index) {
		List<WebElement> itemlist = driver.findElements(By.className("ComboBoxItem"));
		return FetchText(itemlist.get(index));
	}

	// Fetch Transmission Rate text fr

	public String Fetch_TR_Values(int index) {
		List<WebElement> TR_options = driver.findElementByAccessibilityId("DisplayRate")
				.findElements(By.className("ComboBoxItem"));
		return FetchText(TR_options.get(index));
	}

	// Select Sampling Rate
	public void select_SR(String SR) throws InterruptedException {

		Actions ac = new Actions(driver);

		if (SR.equals("1 Second") || SR.equals("2 Seconds") || SR.equals("3 Seconds") || SR.equals("5 Seconds")) {
			click_SR_DrpDwnBox();
			click_SR_DrpDwnBox();
			for (int i = 0; i <= 4; i++) {
				if (fetch_DefaultTxt_SR().contains(SR)) {
					//clickOn(SR_text);
					break;
				}
				else
				{
					ac.sendKeys(Keys.ARROW_UP).build().perform();
				}
			}
		} 
		
		else {
			click_SR_DrpDwnBox();
			click_SR_DrpDwnBox();
			for (int i = 0; i <= 16; i++) {
				
				if (fetch_DefaultTxt_SR().contains(SR)) {
					//clickOn(SR_text);
					break;
				}
				else
				{
					ac.sendKeys(Keys.ARROW_DOWN).build().perform();
				}
			}
		}
	}

	//Select Required Sampling Rate from DropDown
	public void select_ReqSamplingRate(String sampRate) throws InterruptedException
	{
		/*String samRate = sampRate.split(" ")[0];
		int sRate = Integer.parseInt(samRate);
		
		waitForElementLoad(SR_DrpDwn, 100);
		click_SR_DrpDwnBox();
		click_SR_DrpDwnBox();
		Thread.sleep(1000);
		
		String sampValue = fetch_DefaultTxt_SR().split(" ")[0];
		int svalue = Integer.parseInt(sampValue);
		
		Actions act = new Actions(driver);
		
		if(sRate<svalue)
		{
			for(int i=0;i<=4;i++)
			{
			if(fetch_DefaultTxt_SR().equalsIgnoreCase(sampRate))
			{
				Thread.sleep(1000);
				break;
			}
				else
				{
					act.sendKeys(Keys.ARROW_UP).build().perform();
				}
			}
			
		}
		
		else if(sRate>svalue)
		{
			for(int i=0; i<=16;i++)
			{
				if(fetch_DefaultTxt_SR().equalsIgnoreCase(sampRate))
				{
					Thread.sleep(1000);
					break;
				}
				else
				{
					act.sendKeys(Keys.ARROW_DOWN).build().perform();
				}
			}
		} */
		
		waitForElementLoad(SR_DrpDwn, 100);
		click_SR_DrpDwnBox();
		click_SR_DrpDwnBox();
		Thread.sleep(1000);
		
		Actions act = new Actions(driver);
//		if(sampRate.equalsIgnoreCase("5 Seconds")||sampRate.equalsIgnoreCase("3 Seconds")||sampRate.equalsIgnoreCase("2 Seconds")
//				||sampRate.equalsIgnoreCase("1 Seconds"))
		if(!fetch_DefaultTxt_SR().equalsIgnoreCase("5 Seconds")||!fetch_DefaultTxt_SR().equalsIgnoreCase("3 Seconds")
				||!fetch_DefaultTxt_SR().equalsIgnoreCase("2 Seconds")||!fetch_DefaultTxt_SR().equalsIgnoreCase("1 Seconds"))
		{
			for(int i=0; i<=4; i++)
			{
				act.sendKeys(Keys.ARROW_UP).build().perform();
				if(fetch_DefaultTxt_SR().equalsIgnoreCase(sampRate))
				{
					Thread.sleep(1000);
					break;
				}
			}
		}
		else
		{
			for(int i=0; i<=16;i++)
			{
				act.sendKeys(Keys.ARROW_DOWN).build().perform();
				if(fetch_DefaultTxt_SR().equalsIgnoreCase(sampRate))
				{
					Thread.sleep(1000);
					break;
				}
			}	
		}
		
	}
	// Click the Transmission Rate dropdown box
	public void click_TR_DrpDwnBox() {
		clickOn(TR_DrpDwn);
	}

	// fetch default tet ftom TR dropdown

	public String FetchDfltTxt_TR_DrpDwnBox() {
		return FetchText(TR_DrpDwn);
	}

	// Fetch text from RFT_DrpDwn
	public String FetchTxt_RFT_DrpDwn() {
		return FetchText(RFT_DrpDwn);
	}

	// Select Transmission Rate based on Sampling Rate selction
//	public void select_TR(String SR, String TR) throws InterruptedException {
//		// System.out.println("SR excel data: " + SR);
//		// System.out.println("tr excel data: " + TR);
//		// System.out.println("TRField default data: " + TR_DrpDwn.getText());
//		Actions ac = new Actions(driver);
//
//		if (SR.equals("1 Second")) {
//			switch (TR) {
//			case "3 Seconds":
//				click_TR_DrpDwnBox();
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(1000);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "5 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(1000);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("2 Seconds")) {
//			// System.out.println("In SR 2 sec & TR selection");
//			switch (TR) {
//			case "6 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(1000);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "10 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(1000);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("3 Seconds")) {
//			// System.out.println("In SR 3 sec & TR selection");
//			switch (TR) {
//			case "6 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "12 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("5 Seconds")) {
//			// System.out.println("In SR 5 sec & TR selection");
//			switch (TR) {
//			case "5 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(1000);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "20 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("10 Seconds")) {
//			// System.out.println("In SR 10 sec & TR selection");
//			switch (TR) {
//			case "20 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "30 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("20 Seconds")) {
//			// System.out.println("In SR 20 sec & TR selection");
//			switch (TR) {
//			case "20 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "30 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("30 Seconds")) {
//			// System.out.println("In SR 30 sec & TR selection");
//			switch (TR) {
//			case "20 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "30 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("1 Minute")) {
//			// System.out.println("In SR 1 mnt & TR selection");
//			switch (TR) {
//			case "10 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "30 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("2 Minutes")) {
//			// System.out.println("In SR 2 mnt & TR selection");
//			switch (TR) {
//			case "10 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "30 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("3 Minutes")) {
//			// System.out.println("In SR 3 mnt & TR selection");
//			switch (TR) {
//			case "10 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "30 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("5 Minutes")) {
//			// System.out.println("In SR 5 mnt & TR selection");
//			switch (TR) {
//			case "10 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "30 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else if (SR.equals("10 Minutes")) {
//			switch (TR) {
//			case "10 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			case "30 Seconds":
//				clickOn(TR_DrpDwn);
//				Thread.sleep(500);
//				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
//				Thread.sleep(500);
//				// System.out.println("TR Field selected data: " + FetchText(TR_DrpDwn));
//				clickOn(TR_text);
//				break;
//			default:
//				break;
//			}
//		} else {
//			System.out.println("Incorrect TR input in excel");
//		}
//
//	}

	// Select RF Threshold
	public void select_RFT(String RFT) throws InterruptedException {
		int rft = Integer.parseInt(RFT.split(",")[0]);
		// System.out.println("rft excel data: " + rft);
		int RFTField = Integer.parseInt(RFT_DrpDwn.getText().split(",")[0]);
		// System.out.println("RFTField default data: " + RFTField);
		Actions ac = new Actions(driver);

		if (rft > RFTField) {
			click_RFT_DrpDwnBox();
			Thread.sleep(500);
			ac.sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();
			clickOn(RFT_text);
			Thread.sleep(500);
			// System.out.println("RFT Field selected data: " + FetchText(RFT_DrpDwn));

		} else if (rft < RFTField) {
			for (int i = 0; i <= 2; i++) {
				clickOn(RFT_DrpDwn);
				Thread.sleep(500);
				ac.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
				Thread.sleep(500);
				// System.out.println("RFT Field selected data: " + FetchText(RFT_DrpDwn));
				if (FetchText(RFT_DrpDwn).contains(RFT)) {
					clickOn(RFT_text);
					break;
				}
			}
		}
	}

	// Click the Next button to move to Setup Review page
	public Setup_ReviewPage Click_NxtBtn() throws IOException, InterruptedException {
		clickOn(NxtBtn);
		return new Setup_ReviewPage();
	}

	// click net btn to get alert msg
	public void Click_NxtBtn_Alert() throws IOException, InterruptedException {
		Thread.sleep(1000);
		clickOn(NxtBtn);
	}

	// Click on back btn

	public Setup_CalVerParametersPage click_Backbtn() throws IOException {
		clickOn(PreviousButton);
		return new Setup_CalVerParametersPage();
	}
	//get text from StartQualificationTextBox
	public String getTxt_QStartTxtBox()
	{
		WebElement QStartTxtBox = driver.findElementByAccessibilityId("StartQualificationTextBox");
		QStartTxtBox.getAttribute("AutomationId");
		return FetchText(QStartTxtBox);
	}
	
	//enter text into StartQualificationTextBox
	public void enterTxt_QStartTxtBox(String text)
	{
		WebElement QStartTxtBox = driver.findElementByAccessibilityId("StartQualificationTextBox");
		clickOn(QStartTxtBox);
		ClearText(QStartTxtBox);
		enterText(QStartTxtBox, text);
	}
	public boolean is_StartQualTxtBxVisible()
	{
		WebElement QStartTxtBox = driver.findElementByAccessibilityId("StartQualificationTextBox");
		return IsElementVisibleStatus(QStartTxtBox);
	}

	// click back btn to navigate Asset Details Page

	public assetDetailsPage Click_BackBtnWithAlertAccess() throws IOException {
		clickOn(BackButton);
		WebElement Yesbtn = driver.findElementByName("Yes");
		clickOn(Yesbtn);
		return new assetDetailsPage();
	}
	public void click_BackBtn()
	{
		clickOn(BackButton);
	}
	//click on sensor units
	public void click_SensTxtBxUnit()
	{
		WebElement SensTxtUnit = driver.findElementByAccessibilityId("StartQualificationUnitTextBlock");
		clickOn(SensTxtUnit);
	}
	// Alert msg
	public String AlertMsg() {
		WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return FetchText(Msg);
	}

	// Click the Qual Stop dropdown box
	public void click_Qstop_DrpDwnBox() {
		clickOn(QStop_DrpDwn);
	}

	// fetch default text
	public String getTxt_of_QstopDrpDwn() {
		return FetchText(QStop_DrpDwn);
	}
	//click the QStop drop down values as per requirement
	public void click_QStopDrpDwnReqValue(int index) throws InterruptedException
	{
		click_Qstop_DrpDwnBox();
		List<WebElement> QStopdrpdown = QStop_DrpDwn.findElements(By.className("ComboBoxItem"));
//		for(WebElement item: QStopdrpdown)
//		{
//			Thread.sleep(1000);
//			if(FetchText(item).equalsIgnoreCase(val))
//			{
//				clickOn(item);
//				break;
//			}
//		}
		 clickOn(QStopdrpdown.get(index));
		 Thread.sleep(1000);
	}
	//fetch drop down values
	public String get_ValueOfQStopDrpDwn(int index)
	{
		List<WebElement> ele = QStop_DrpDwn.findElements(By.className("ComboBoxItem"));
		return FetchText(ele.get(index));
	}
	
	// Fetch text of options from Stop Qualification drop
	// down
	public String Fetchoptions_From_QStopDrpDwn(int index) {
		List<WebElement> itemlist = driver.findElements(By.className("ComboBoxItem"));
		return FetchText(itemlist.get(index));
	}

	// click on any options from stop qualification drop down

	public void selectOptions_From_QStopDrpDwn(int index) {
		List<WebElement> itemlist = driver.findElements(By.className("ComboBoxItem"));
		itemlist.get(index).click();
	}

	// Verify that Hours time fields for Cycle time Qualstop

	public boolean HoursStopQual_State() {
		WebElement hrs = driver.findElementByAccessibilityId("HoursStopQualification");
		return hrs.isDisplayed();

	}
	//fetch text from Stop Qualification sensor condition box
	public String getTxt_QStpComparerComboBox()
	{
		WebElement QStopComp = driver.findElementByAccessibilityId("StopQualificationComparerComboBox");
		return FetchText(QStopComp);
	}
	public boolean is_QStpCompCmbBoxVisible()
	{
		WebElement QStopComp = driver.findElementByAccessibilityId("StopQualificationComparerComboBox");
		return IsElementVisibleStatus(QStopComp);
	}

	// verify that Min time fields for Cycle time Qualstop
	public boolean MinStopQual_State() {
		WebElement min = driver.findElementByAccessibilityId("MinStopQualification");
		return min.isDisplayed();

	}

	// verify that Sec time fields for Cycle time Qualstop
	public boolean SecStopQual_State() {
		WebElement sec = driver.findElementByAccessibilityId("SecStopQualification");
		return sec.isDisplayed();

	}
	//get text from stop exposure comparator operator
	public String getTxt_StpExpoComparerCmbBox()
	{
		WebElement StopExpocompcombo = driver.findElementByAccessibilityId("StopExposureComparerComboBox");
		return FetchText(StopExpocompcombo);
	}
	public boolean is_StpExpoCompCmbBoxVisible()
	{
		WebElement StopExpocompcombo = driver.findElementByAccessibilityId("StopExposureComparerComboBox");
		return IsElementVisibleStatus(StopExpocompcombo);
	}

	// verify that the HHMMSS_text is displaying

	public boolean HHMMSS_text_State() {
		WebElement HHMMSS_text = driver.findElementByName("HH:MM:SS");
		return IsElementVisibleStatus(HHMMSS_text);

	}

	// Verify that default value 00 is displaying in HH fields for Cycle time
	// Qualstop

	public String FetchTxt_HH_Stopqual() {
		WebElement hrs = driver.findElementByAccessibilityId("HoursStopQualification");
		return FetchText(hrs);

	}
	//enter text into start exposure text box
	public void enterTxt_StrtExpTxtBox(String text)
	{
		WebElement strtExpoTxtBox = driver.findElementByAccessibilityId("StartExposureTextBox");
		clickOn(strtExpoTxtBox);
		ClearText(strtExpoTxtBox);
		enterText(strtExpoTxtBox, text);
	}
	//fetch text from start exposure text box
	public String getTxt_StrtExpoBox()
	{
		WebElement strtExpoTxtBox = driver.findElementByAccessibilityId("StartExposureTextBox");
		strtExpoTxtBox.getAttribute("AutomationId");
		return FetchText(strtExpoTxtBox);
	}
	//visiblity of StartExposureTextBox
	public boolean is_StartExpoTxtBxVisible()
	{
		WebElement strtExpoTxtBox = driver.findElementByAccessibilityId("StartExposureTextBox");
		return IsElementVisibleStatus(strtExpoTxtBox);
	}
	//click on degree celcius
	public void click_DegCel()
	{
		WebElement degCel = driver.findElementByName("°C");
		clickOn(degCel);
	}
	//getting text from StopQualificationTextBox
	public String getTxt_QStopTxtBox()
	{
		WebElement QStpTxtBx = driver.findElementByAccessibilityId("StopQualificationTextBox");
		QStpTxtBx.getAttribute("AutomationId");
		return FetchText(QStpTxtBx);
	}
	//enter text text into StopQualificationTextBox
	public void enterTxt_QStopTxtBox(String text)
	{
		WebElement QStpTxtBx = driver.findElementByAccessibilityId("StopQualificationTextBox");
		clickOn(QStpTxtBx);
		ClearText(QStpTxtBx);
		enterText(QStpTxtBx, text);
	}
	//visibility of StopQualificationTextBox
	public boolean is_StpQualTextBoxVisible()
	{
		WebElement QStpTxtBx = driver.findElementByAccessibilityId("StopQualificationTextBox");
		return IsElementVisibleStatus(QStpTxtBx);
	}
	//visibility of degree celsius
	public boolean is_DegCelUnitsVisibility()
	{
		WebElement degCel = driver.findElementByName("°C");
		return IsElementVisibleStatus(degCel);
	}

//Fetch text from  MM field for Cycle time Qualstop 

	public String FetchTxt_MM_Stopqual() {
		WebElement min = driver.findElementByAccessibilityId("MinStopQualification");
		return FetchText(min);

	}

//Fetch text from  SS field for Cycle time Qualstop 

	public String FetchTxt_SS_Stopqual() {
		WebElement sec = driver.findElementByAccessibilityId("SecStopQualification");
		return FetchText(sec);

	}
	//fetching text from HoursStopExposure
	public String fetchTxt_HrsStpExpo()
	{
		WebElement HrsStpExpo = driver.findElementByAccessibilityId("HoursStopExposure");
		return FetchText(HrsStpExpo);
	}
	//enter text into 

	// Enter HH to text fildHoursStopExposure
	public void enterTxt_HrsStpExpo(String text)
	{
		WebElement HrsStpExpo = driver.findElementByAccessibilityId("HoursStopExposure");
		clickOn(HrsStpExpo);
		ClearText(HrsStpExpo);
		enterText(HrsStpExpo, text);
	}

	public void enterTxt_HHQStp(String HH) {
		WebElement HH_textfield = driver.findElementByAccessibilityId("HoursStopQualification");
		clickOn(HH_textfield);
		ClearText(HH_textfield);
		enterText(HH_textfield, HH);
	}
// Enter MM to text fild

	public void enterTxt_MM(String MM) {
		WebElement MM_textfield = driver.findElementByAccessibilityId("MinStopQualification");
		clickOn(MM_textfield);
		ClearText(MM_textfield);
		enterText(MM_textfield, MM);
	}
// Enter SS to text fild

	public void enterTxt_SS(String SS) {
		WebElement SS_textfield = driver.findElementByAccessibilityId("SecStopQualification");
		clickOn(SS_textfield);
		ClearText(SS_textfield);
		enterText(SS_textfield, SS);
	}

	// Click on HH field
	public void click_HH() {
		WebElement HH_textfield = driver.findElementByAccessibilityId("HoursStopQualification");
		clickOn(HH_textfield);
	}

	// Click on MM field
	public void click_MM() {
		WebElement MM_textfield = driver.findElementByAccessibilityId("MinStopQualification");
		clickOn(MM_textfield);
	}

	// click on SS field
	public void click_SS() {
		WebElement SS_textfield = driver.findElementByAccessibilityId("SecStopQualification");
		clickOn(SS_textfield);
	}
	//fetch text from Hours Start Exposure
	public String getTxt_HoursStartExposure()
	{
		WebElement strtExpHrsField = driver.findElementByAccessibilityId("HoursStartExposure");
		return FetchText(strtExpHrsField);
	}
	//enter text into Hours start exposure
	public void enter_HoursStartExposure(String text)
	{
		WebElement strtExpHrsField = driver.findElementByAccessibilityId("HoursStartExposure");
		clickOn(strtExpHrsField);
		ClearText(strtExpHrsField);
		enterText(strtExpHrsField, text);
	}

	// Click the RFT dropdown box
	public void click_RFT_DrpDwnBox() {
		clickOn(RFT_DrpDwn);
	}

	// fetchtext option from RFT_DrpDwnBox

	public String Fetch_RFT_Values(int index) {
		List<WebElement> RFT_options = driver.findElementByAccessibilityId("_rfCommToggleThresholdSettingsComboBox")
				.findElements(By.className("ComboBoxItem"));
		return FetchText(RFT_options.get(index));
	}
	//Check visibility of Open text
	public boolean is_OpenOptionVisible(int index)
	{
		List<WebElement> open = driver.findElementsByName("Open");
		return IsElementVisibleStatus(open.get(index));
	}
	public void click_SwitchThumb(int index)
	{
		List<WebElement> swtchThmb = driver.findElementsByAccessibilityId("SwitchThumb");
		clickOn(swtchThmb.get(index));
	}
	public boolean is_CloseOptionVisible(int index)
	{
		List<WebElement> close = driver.findElementsByName("Close");
		return IsElementVisibleStatus(close.get(index));
	}
	public WebElement highlight(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border = '2px solid red'", ele);
		return ele;
	}
//	public void highlight(WebElement ele)
//	{
//
//		driver.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
//	}
	//Output Relay1 DropDown text 
	public String getTxt_OPRelay1()
	{
		WebElement Relay1 = driver.findElementByAccessibilityId("OutputRealy1ComboBox");
		return FetchText(Relay1);
	}
	//Output Relay2 DropDown text
	public String getTxt_OPRelay2()
	{
		WebElement Relay2 = driver.findElementByAccessibilityId("OutputRealy2ComboBox");
		return FetchText(Relay2);
	}
	//click on the OutPut Relay1
	public void click_OPRelay1()
	{
		WebElement Relay1 = driver.findElementByAccessibilityId("OutputRealy1ComboBox");
		clickOn(Relay1);
	}
	public String getTxt_ORelay1DrpDwn(int index)
	{
		List<WebElement> drpDownVal= driver.findElementByAccessibilityId("OutputRealy1ComboBox")
				.findElements(By.className("ComboBoxItem"));
				
		return FetchText(drpDownVal.get(index));
	}
//	public List<String> getTxt_ORelay1DrpDwn(String val)
//	{
//		List<WebElement> drpDownVal= driver.findElementByAccessibilityId("OutputRealy1ComboBox")
//				.findElements(By.className("ComboBoxItem"));
//		
//		ArrayList<String> alloptions = new ArrayList<>();
//		for(WebElement ele:drpDownVal)
//		{
//			alloptions.add(FetchText(ele));
//		}
//		return alloptions;
//			
//	}
	//click on the OutPut Relay2
	public void click_OPRelay2()
	{
		WebElement Relay2 = driver.findElementByAccessibilityId("OutputRealy2ComboBox");
		clickOn(Relay2);
	}
	public String getTxt_ORelay2DrpDwn(int index)
	{
		List<WebElement> drpDownVal= driver.findElementByAccessibilityId("OutputRealy2ComboBox")
				.findElements(By.className("ComboBoxItem"));
				
		return FetchText(drpDownVal.get(index));
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
//	public void context_Click() throws InterruptedException
//	{
//		Actions act = new Actions(driver);
//		act.contextClick().build().perform();
//				
//		WebElement cntxt_Ele = driver.findElementByAccessibilityId("HelpAppBarButton");
//		tu.waitForElementToBeVisible(cntxt_Ele);
//		clickOn(cntxt_Ele);
//	}	
	public String help_Text()
	{
		WebElement helpButton = driver.findElementByAccessibilityId("helpRichTextBlock");// helpFlyout
		return FetchText(helpButton);
	}
	
	
	
	// fetch Hour from Time Of The Day window

		public String fetch_Hour() {
			WebElement Hr = driver.findElementByAccessibilityId("Hours");
			return FetchText(Hr);
		}
}
