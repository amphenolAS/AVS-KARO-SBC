package com.avsQual.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avsQual.base.BaseClass;
import com.avsQual.utility.TestUtilities;

public class FM_SyncInPage extends BaseClass{
	TestUtilities tu = new TestUtilities();
	//Page element variable declaration definition
	WebElement SyncInHeaderBtn = null;
	WebElement SyncInBrowseBtn = null;
	WebElement FltrByDtBtn = null;
	WebElement SyncInTextBox = null;
	WebElement SyncInOKbtn = null;
	WebElement SyncInBackbtn = null;
	WebElement SyncInBack = null;
		
	//Page element Initialize method
	private void initElements()
	{
		SyncInHeaderBtn = driver.findElementByAccessibilityId("SyncInBtn");
		SyncInBrowseBtn = driver.findElementByAccessibilityId("SyncInFolderBrowseButton");
		SyncInTextBox = driver.findElementByAccessibilityId("SyncInFolderTextBox");
		FltrByDtBtn = driver.findElementByAccessibilityId("SyncInDateFilterCheckBox");
		SyncInOKbtn = driver.findElementByAccessibilityId("SyncInFolderOKButton");
		SyncInBack = driver.findElementByAccessibilityId("ArrowGlyph");
		SyncInBackbtn = driver.findElementByAccessibilityId("BackButton");
	}
	
	//Constructor for initializing the page elements
	FM_SyncInPage() throws IOException
	{
		super();
		initElements();
	}
	
	//Release memory
	public void resetWebElements()
	{
		SyncInHeaderBtn = null;
		SyncInBrowseBtn = null;
		FltrByDtBtn = null;		
		SyncInTextBox = null;
		SyncInOKbtn = null;
		SyncInBackbtn = null;
		SyncInBack = null;
		
	}
	
	/*----------------------
	Methods of Sync In Page
	------------------------*/
	//SyncIn Header is visible
	public boolean is_SyncInHeaderVisible()
	{
		return IsElementVisibleStatus(SyncInHeaderBtn);
	}
	//SyncIn Header is Enabled
	public boolean is_SyncInHeaderEnable()
	{
		return IsElementEnabledStatus(SyncInHeaderBtn);
	}
	
	// SyncInTextBox is visible
	public boolean SyncInTextBoxVisible() throws InterruptedException {
		return IsElementVisibleStatus(SyncInTextBox);
	}
	//send the values into the SyncIn Text Box field
	public void enterTxt_SyncInTextBox(String val)
	{
		enterText(SyncInTextBox, val);
	}
	//fetch text from Sync In Feild
	public String getTxt_SyncInTextBox()
	{
		return FetchText(SyncInTextBox);
	}
	
	//Browse button status
	public boolean is_SyncInTextBoxEnabled()
	{
		return IsElementEnabledStatus(SyncInTextBox);
	}
	
	//Browse Button is visible
	public boolean is_BrowseBtnVisible()
	{
		return IsElementVisibleStatus(SyncInBrowseBtn);
	}
	//check the select status for Filter Button
	public boolean is_FltrDateBtnSelected()
	{
		return checkboxSelectStatus(FltrByDtBtn);
	}
	
	//Filter By Date Button visibility
	public boolean is_FltrByDateBtnVisible()
	{
		return IsElementVisibleStatus(FltrByDtBtn);
	}
	//Checking the filter button is enabled or not
	public boolean is_FltrBtnEnable()
	{
		return IsElementEnabledStatus(FltrByDtBtn);
	}
	//OK Buton visibility
	public boolean is_OkBtnVisible()
	{
		return IsElementVisibleStatus(SyncInOKbtn);
	}
	//close button visibility
	public boolean is_CloseBtnVisible()
	{
		//WebElement close = driver.findElementByName("Close Advanced Validation System");
		WebElement close = driver.findElementByXPath("//*[normalize-space(.='Close Advanced Validation System')]");
		return IsElementVisibleStatus(close);
	}
	//From date visibility
	public boolean is_FromDateVisible()
	{
		List<WebElement> fromDate = driver.findElementsByAccessibilityId("PART_PickerButton");
		
		return IsElementVisibleStatus(fromDate.get(0));
	}
	public void click_FromDate()
	{
		List<WebElement> fromDate = driver.findElementsByAccessibilityId("PART_PickerButton");
		clickOn(fromDate.get(0));
	}
	//To date visibility
	public boolean is_ToDateVisible()
	{
		List<WebElement> toDate = driver.findElementsByAccessibilityId("PART_PickerButton");
		
		return IsElementVisibleStatus(toDate.get(1));
	}
	public void click_ToDate()
	{
		List<WebElement> toDate = driver.findElementsByAccessibilityId("PART_PickerButton");
		
		clickOn(toDate.get(1));
	}
	//click on the browse button
	public void click_BrowseBtn()
	{
		clickOn(SyncInBrowseBtn);
	}
	//select the Ok Button on date selection pop up
	public void click_Ok_DateSelectionPopUp() throws InterruptedException
	{
		WebElement okSymbol = driver.findElementByAccessibilityId("PART_SelectorOKButton");
		Thread.sleep(1000);
		clickOn(okSymbol);
	}
	//Verify the window expolrer button
	public boolean is_ExplorerWinInvoked()
	{
		//Switch to file explorer window 
		driver.switchTo().activeElement();
		
		WebElement win = driver.findElementByXPath("//*[normalize-space(.='Select Folder')]");
		return IsElementVisibleStatus(win);
	}
	
	//fetch text from calnder
	public String get_Month() throws InterruptedException
	{
		click_FromDate();
	//	List<WebElement> month = driver.findElementByAccessibilityId("PART_Popup").findElements(By.className("TextBlock"));
		WebElement month = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name("May"));
		
//		String mon = "";
//		for(WebElement m:month)
//		{
////			Thread.sleep(1000);
////			mon = FetchText(m);
////			if(val.equals(mon))
////				break;
//			FetchText(m);
//			System.out.println(m);
//		}
		return FetchText(month);
		
		
	}
	
	//select the date 
	public  void selectReqDate(String mon, String dt, String yr) throws InterruptedException
	{
		click_FromDate();
		
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
		act.sendKeys(Keys.ARROW_RIGHT).build().perform();
		for(int i=0; i<31;i++)
		{
			try
			{
				//WebElement date = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name("13"));
				WebElement date = driver.findElementByAccessibilityId("PART_Popup").findElement(By.name(dt));
				if(IsElementVisibleStatus(date))
				{
					clickOn(date);
					break;
				}
			}
			catch (Exception e) {
				act.sendKeys(Keys.ARROW_UP).build().perform();
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
					clickOn(year);
					break;
				}
			}
			catch (Exception e) {
				act.sendKeys(Keys.ARROW_UP).build().perform();
			}
		}
	}

	// Enter sync in folder path
	public void enter_Filepath(String pathname) throws AWTException, IOException, InterruptedException{
		clickOn(SyncInBrowseBtn);
		Thread.sleep(3000);
		// switch to the file upload window
		WebElement alert = driver.switchTo().activeElement();
		Thread.sleep(2000);
		
		//Below Path will be used while executing scripts from Eclipse IDE.
		String fp2 = System.getProperty("user.dir") +  "\\src\\test\\resources\\TestData\\" + pathname;
		
		//placed present in the jar.exe path location.
//		String fp2 = System.getProperty("user.dir") + "\\" + pathname;
		
		System.out.println(fp2);
		//"git\\AVS\\AVS\\src\\test\\resources\\TestData"
		Thread.sleep(2000);
		alert.sendKeys(fp2);
		Thread.sleep(500);
		System.out.println("PATH ENTERED");

		//Click Select Folder button

		WebElement SelectFolderBtn = driver.findElementByAccessibilityId("1");
		Thread.sleep(1000);

		clickOn(SelectFolderBtn);
		
		// switch back
		driver.switchTo().activeElement();
		Thread.sleep(500);
	}
	
	// Enter sync in folder path
		public void enter_NewFilepath(String pathname) throws AWTException, IOException, InterruptedException{
			clickOn(SyncInBrowseBtn);
			Thread.sleep(2000);
			// switch to the file upload window
			WebElement alert = driver.switchTo().activeElement();
			Thread.sleep(2000);
			
			String fp2 = pathname;
			System.out.println(fp2);
			//"git\\AVS\\AVS\\src\\test\\resources\\TestData"
			Thread.sleep(2000);
			alert.sendKeys(fp2);
			Thread.sleep(500);
			System.out.println("PATH ENTERED");

			//Click Select Folder button

			WebElement SelectFolderBtn = driver.findElementByAccessibilityId("1");
			Thread.sleep(1000);

			clickOn(SelectFolderBtn);
			
			// switch back
			driver.switchTo().activeElement();
			Thread.sleep(500);
		}
		
	
	//Click the Filter button
	public void click_FltrBtn() {
		clickOn(FltrByDtBtn);
	}
	
	// Click the Filter button
	public SyncInAssetListPage click_SyncInOK_btn() throws IOException, InterruptedException {
		Thread.sleep(2000);
		clickOn(SyncInOKbtn);
		
		return new SyncInAssetListPage();
	}      
	 
	public void click_OKBtn() throws IOException {
		clickOn(SyncInOKbtn);
	}
	public String gettext()
	{
		WebElement stng = driver.findElementByXPath("//*[normalize-space(.='Data saved successfully')]");
		return FetchText(stng);
	}
	public void get1()
	{
		WebElement e = driver.findElementByXPath("//*[normalize-space(.='New notification from Advanced Validation System, errCreated Successfully., . 1 of 1')]");
		clickOn(e);
	}
	
	public void click_OkOnSyncInSelections()
	{
		WebElement okBtn = driver.findElementByAccessibilityId("SyncInAssetsPopup").findElement(By.name("OK"));
		clickOn(okBtn);
	}
	
	
	//Click the SycnIn Alert confirmation message
	public void unSelect_FilterBtn()
	{
		if(checkboxSelectStatus(FltrByDtBtn))
		clickOn(FltrByDtBtn);
	}
	//Checking wether Asset List Pop Up Visible
	public boolean is_AssetPopUpWindowVisibe()
	{
		//WebElement AssetPopUp = driver.findElementByAccessibilityId("SyncInAssetsPopup");
		boolean status = false;
		
		try
		{
			WebElement AssetPopUp = driver.findElementByAccessibilityId("SyncInAssetsPopup");
		if(IsElementVisibleStatus(AssetPopUp))
		{
			status = true;
		}
		else if(!IsElementVisibleStatus(AssetPopUp))
		{
			status = false;
		}
		}
		catch (Exception e) {
			e.getMessage();
		}
		return status;
	}
	//Click Back button to move to File Management Page 
	public MainHubPage click_BackBtn() throws IOException {
		clickOn(SyncInBackbtn);
		return new MainHubPage();
	}
	public FileManagementPage click_Back() throws IOException {
		clickOn(SyncInBack);
		return new FileManagementPage();
	}
	
}

