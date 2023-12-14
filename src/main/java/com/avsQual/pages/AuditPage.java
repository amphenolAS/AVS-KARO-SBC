package com.avsQual.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avsQual.base.BaseClass;

public class AuditPage extends BaseClass {

	// FileManagementPage Element definition
	WebElement Audit_HeadTitle = null;
	WebElement ActionFilter_Icon = null;
	WebElement BackBtn_AuditPg = null;
	WebElement GenerateReport_Btn = null;
	WebElement Get_Data_Btn = null;

	void initElements() {
		Audit_HeadTitle = driver.findElementByName("Audit Trail");
		ActionFilter_Icon = driver.findElementByAccessibilityId("PART_FilterButton");
		BackBtn_AuditPg = driver.findElementByAccessibilityId("ArrowGlyph");
		GenerateReport_Btn = driver.findElementByAccessibilityId("GenerateReportButton");
		Get_Data_Btn = driver.findElementByAccessibilityId("GetAuditData");
	}

	AuditPage() throws IOException {
		super();
		initElements();

	}

	// Release memory
	public void resetWebElements() {
		Audit_HeadTitle = null;
		ActionFilter_Icon = null;		
		ActionFilter_Icon = null;
		GenerateReport_Btn = null;
		Get_Data_Btn = null;
	}

	// Audit TextBox is Visible
	public boolean AuditHeadTitleVisible() throws InterruptedException {
		return IsElementVisibleStatus(Audit_HeadTitle);
	}

	// Fetch the alert message when a user does not have privilege to access
	public String AlertMsg() {
		WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
		return FetchText(Msg);
	}
	
	//Click on Action filter icon to open the filter
	public void Click_ActionFilter_Icon() {

		List<WebElement> filtericon = driver.findElementsByAccessibilityId("PART_FilterButton");
		System.out.println(filtericon.size());
		filtericon.get(3).click();
	}

	// Click on Action Filter (ok)Btn to get the filter result
	public void click_Action_FilterBtn() throws IOException, InterruptedException {
		// List<WebElement> filterBtn =
		// driver.findElementsByAccessibilityId("PART_FilterButton");
		List<WebElement> filterBtn = driver.findElementsByName("Filter");
		// System.out.println(filterBtn.size());

		filterBtn.get(1).click();
		// WebElement msg = driver.findElementByName(");

	}
	//Select from Date
	public void click_FromDate()
	{
		List<WebElement> fromDate = driver.findElementsByAccessibilityId("PART_PickerButton");
		clickOn(fromDate.get(0));
	}
	//Select To Date
	public void click_ToDate()
	{
		List<WebElement> toDate = driver.findElementsByAccessibilityId("PART_PickerButton");
		
		clickOn(toDate.get(1));
	}
	//select the Ok Button on date selection pop up
	public void click_Ok_DateSelectionPopUp() throws InterruptedException
	{
		WebElement okSymbol = driver.findElementByAccessibilityId("PART_SelectorOKButton");
		Thread.sleep(1000);
		clickOn(okSymbol);
	}
	//Select the Requred date
	public  void selectReqDate(String mon, String yr) throws InterruptedException
	{
		//PART_Popup    TextBlock  
		Actions act = new Actions(driver);
		for(int i=0; i<12;i++)
		{
			try
			{
				//WebElement month = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name("October"));
				WebElement month = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name(mon));
				if(IsElementVisibleStatus(month))
				{
					clickOn(month);
					break;
				}
			}
			catch (Exception e) {
				act.sendKeys(Keys.ARROW_UP).build().perform();
			}
		}
//		act.sendKeys(Keys.ARROW_RIGHT).build().perform();
//		for(int i=0; i<31;i++)
//		{
//			try
//			{
//				//WebElement date = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name("13"));
//				WebElement date = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name(dt));
//				if(IsElementVisibleStatus(date))
//				{
//					clickOn(date);
//					break;
//				}
//			}
//			catch (Exception e) {
//				act.sendKeys(Keys.ARROW_UP).build().perform();
//			}
//		}
		act.sendKeys(Keys.ARROW_RIGHT).build().perform();
		for(int i=0; i<31;i++)
		{
			try
			{
				//WebElement year = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name("2020"));
				WebElement year = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name(yr));
				if(IsElementVisibleStatus(year))
				{
					clickOn(year);
					break;
				}
			}
			catch (Exception e) {
				act.sendKeys(Keys.ARROW_UP).build().perform();
			}
		}
	}


	// Enter value into Action filter text box
	public void EnterTxt_ActionFilter(String val) {
		WebElement ActionFltr_ValueBox = driver.findElementByAccessibilityId("PART_ValueBox");
		clickOn(ActionFltr_ValueBox);
		ClearText(ActionFltr_ValueBox);
		enterText(ActionFltr_ValueBox, val);
	}

	// Verify that the below details is displaying when user filter the particular action
	public String get_auditEvent_text() {
		List<WebElement> Act_Txt = driver.findElementByAccessibilityId("PART_ScrollViewer")
				.findElements(By.className("TextBlock"));
		return FetchText(Act_Txt.get(3));
	}
	public String get_ReqauditEvent_Time(int index) {
		List<WebElement> Act_Txt = driver.findElementByAccessibilityId("PART_ScrollViewer")
				.findElements(By.className("TextBlock"));
		return FetchText(Act_Txt.get(index));
	}
	public boolean is_ReqauditEventDisplayed(int index) {
		List<WebElement> Act_Txt = driver.findElementByAccessibilityId("PART_ScrollViewer")
				.findElements(By.className("TextBlock"));
		return IsElementVisibleStatus(Act_Txt.get(index));
	}
	
	//CLick Back button to navigate to Main Hub page
	public MainHubPage Click_BackBtn() throws IOException {
		clickOn(BackBtn_AuditPg);		
		return new MainHubPage();
	}
	//click on Get Audit Data Button
	public void click_GetData() throws InterruptedException
	{
		Thread.sleep(1000);
		clickOn(Get_Data_Btn);
	}
	
	//CLick Generate button to print Audit report
	public void Click_GenerateReport_Btn() throws InterruptedException {
		clickOn(GenerateReport_Btn);
		Thread.sleep(1000);
	}

}
