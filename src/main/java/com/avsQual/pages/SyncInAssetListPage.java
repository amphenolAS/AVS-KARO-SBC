package com.avsQual.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avsQual.base.BaseClass;
import com.avsQual.utility.TestUtilities;

public class SyncInAssetListPage  extends BaseClass{
	TestUtilities tu = new TestUtilities();
	//Page element variable declaration definition
	WebElement SyncInUsr_chkbx = null;
	WebElement SyncInAudit_chkbx = null;
	WebElement SyncInEqp_chkbx = null;
//	WebElement SyncInSelectAll_Btn = null;
	WebElement OKbtn = null;
	WebElement SyncIn_Cancelbtn = null;
	WebElement SyncInTmplt_chkbx = null;
//	WebElement SyncInDeSelectAll_Btn = null;
	List<WebElement> buttons = null;
	
	
	//Page element Initialize method
	private void initElements()
	{
		SyncInUsr_chkbx = driver.findElementByAccessibilityId("SyncInUserCheckBox");
		SyncInAudit_chkbx = driver.findElementByAccessibilityId("SyncInAuditCheckBox");
		SyncInEqp_chkbx = driver.findElementByAccessibilityId("SyncInEquipmentCheckBox");
		SyncInTmplt_chkbx = driver.findElementByAccessibilityId("SyncInPFTemplateCheckBox");
//		SyncInSelectAll_Btn = driver.findElementByAccessibilityId("SyncInSelectAllButton");
//		SyncInDeSelectAll_Btn = driver.findElementByAccessibilityId("SyncInDeSelectAllButton");
		buttons = driver.findElementsByClassName("TextBlock");
		OKbtn = driver.findElementByName("OK");
		SyncIn_Cancelbtn = driver.findElementByName("Cancel");
	}
	
	//Constructor for initializing the page elements
	public SyncInAssetListPage() throws IOException {
		super();
		initElements();
	}
	
	//Release memory
	public void resetWebElements()
	{
		SyncInUsr_chkbx = null;
		SyncInAudit_chkbx = null;
		SyncInEqp_chkbx = null;		
	//	SyncInSelectAll_Btn = null;
		buttons = null;
		OKbtn = null;
		SyncIn_Cancelbtn = null;
		SyncInTmplt_chkbx = null;
	//	SyncInDeSelectAll_Btn = null;
	}
	

	/*----------------------
	Methods of SyncIn AssetList Page
	------------------------*/
	
	//Click the SelectAll button
	public void click_SelectAllBtn() throws InterruptedException {
		WebElement SyncInSelectAll_Btn = driver.findElementByAccessibilityId("SyncInSelectAllButton");
		clickOn(SyncInSelectAll_Btn);
		Thread.sleep(1000);
	}
	// click on SyncInEquipmentCheckBox
		public void click_EquipmentCheckBox() {
			WebElement SyncIn_EquipmentCheckBox = driver.findElementByAccessibilityId("SyncInEquipmentCheckBox");
			clickOn(SyncIn_EquipmentCheckBox);
		}
	//click on X Button
		public FM_SyncInPage click_XBtn() throws IOException
		{
			List<WebElement> xBtn = driver.findElementByAccessibilityId("SyncInAssetsPopup").findElements(By.className("Button"));
			clickOn(xBtn.get(0));
			return new FM_SyncInPage();
		}
		
	//Verify wether SyncIn pop up window is displayed or not
		public boolean is_SyncInPopUpWindowDisplyed()
		{
			boolean status = false;
			try
			{
				WebElement syncInPopup = driver.findElementByAccessibilityId("SyncInAssetsPopup");
				if(IsElementVisibleStatus(syncInPopup))
				{
					status = true;
				}
				else
				{
					status = false;
				}
			}
			catch (Exception e) {
				e.getMessage();
			}
		//	return IsElementVisibleStatus(syncInPopup);
			return status;
		}
		//Users check box visibility
		public boolean is_UsersChkBoxVisible()
		{
			return IsElementVisibleStatus(SyncInUsr_chkbx);
		}
		public void select_UsersChkBox()
		{
			if(!checkboxSelectStatus(SyncInUsr_chkbx))
			{
			clickOn(SyncInUsr_chkbx);
			}
		}
		public boolean is_UsersChkBoxEnabled()
		{
			return IsElementEnabledStatus(SyncInUsr_chkbx);
		}	
		public void unSelect_UsersChkBox()
		{
			if(checkboxSelectStatus(SyncInUsr_chkbx))
			{
			clickOn(SyncInUsr_chkbx);
			}
		}	
			
		//Audit check box visibilty checking
		public boolean is_AuditChkBoxVisible()
		{
			return IsElementVisibleStatus(SyncInAudit_chkbx);
		}
		public void select_AuditChkBx()
		{
			if(!checkboxSelectStatus(SyncInAudit_chkbx))
			{
			clickOn(SyncInAudit_chkbx);
			}
		}
		public void unSelect_AuditChkBx()
		{
			if(checkboxSelectStatus(SyncInAudit_chkbx))
			{
			clickOn(SyncInAudit_chkbx);
			}
		}
		public boolean is_AuditChkBxEnabled()
		{
		   return checkboxSelectStatus(SyncInAudit_chkbx);
		}
		//Equipment check box visibility checking
		public boolean is_EqpmntChkBoxVisible()
		{
			return IsElementVisibleStatus(SyncInEqp_chkbx);
		}
		public void select_EquipmentChkBx()
		{
			if(!checkboxSelectStatus(SyncInEqp_chkbx))
			{
			clickOn(SyncInEqp_chkbx);
			}
		}
		public void unSelect_EquipmentChkBx()
		{
			if(checkboxSelectStatus(SyncInEqp_chkbx))
			{
			clickOn(SyncInEqp_chkbx);
			}
		}
		public boolean is_EquipmentChkBxEnabled()
		{
			return checkboxSelectStatus(SyncInEqp_chkbx);
		}	
		//Template check visiblity checking
		public boolean is_TmpltChkBxVisible()
		{
			return IsElementVisibleStatus(SyncInTmplt_chkbx);
		}
		public void unSelect_TmpltChkBxVisible()
		{
			if(checkboxSelectStatus(SyncInTmplt_chkbx))
			{
				clickOn(SyncInTmplt_chkbx);
			}
		}
		public boolean is_TmpltChkBxEnabled()
		{
			return checkboxSelectStatus(SyncInTmplt_chkbx);
		}
		//Select All Button visibility checking
		public boolean is_SlctAllBtnVisible()
		{
			WebElement SyncInSelectAll_Btn = driver.findElementByAccessibilityId("SyncInSelectAllButton");
			return IsElementVisibleStatus(SyncInSelectAll_Btn);
		}
		//Select All Button is selected or not
		public boolean is_SlctAllBtnSelected()
		{
			WebElement SyncInSelectAll_Btn = driver.findElementByAccessibilityId("SyncInSelectAllButton");
			return checkboxSelectStatus(SyncInSelectAll_Btn);
		}
		//DeSelect All Button Visiblity checking
		public boolean is_DeSlctAllVisible()
		{
			WebElement SyncInDeSelectAll_Btn = driver.findElementByAccessibilityId("SyncInDeSelectAllButton");
			return IsElementVisibleStatus(SyncInDeSelectAll_Btn);
		}	
		public boolean is_DeSlctAllBtnSelected()
		{
			WebElement SyncInDeSelectAll_Btn = driver.findElementByAccessibilityId("SyncInDeSelectAllButton");
			return checkboxSelectStatus(SyncInDeSelectAll_Btn);
		}	
		
		public void click_DeSelectBtn()
		{
			WebElement SyncInDeSelectAll_Btn = driver.findElementByAccessibilityId("SyncInDeSelectAllButton");
			clickOn(SyncInDeSelectAll_Btn);
		}
		public boolean is_AssetNameDisplayed()
		{
			List<WebElement> assetName = driver.findElementsByAccessibilityId("AssetSearchNameTextBlock");
			boolean status = false;
			for(WebElement name:assetName)
			{
				if(IsElementVisibleStatus(name))
					status = true;
			}
			return status;
		}
		public boolean is_AssetIdDisplayed()
		{
			List<WebElement> assetId = driver.findElementsByAccessibilityId("AssetIdTextBlock");
			boolean status = false;
			for(WebElement id:assetId)
			{
				if(IsElementVisibleStatus(id))
					status = true;
			}
			return status;
		}
		public boolean is_AssetModifiedDateDisplayed()
		{
			List<WebElement> assetDate = driver.findElementsByAccessibilityId("LastActivityDetailsTextBlock");
			
			boolean status = false;
			for(WebElement date:assetDate)
			{
				if(IsElementVisibleStatus(date))
					status = true;
			}
			return status;
		}
	//Click the Ok button
	public void click_OkBtn() throws InterruptedException {
		
		//clickOn(SyncIn_Cancelbtn);
		//clickOn(OKbtn);	
//		for (WebElement btn : buttons) {
//			if (btn.getText().contains("OK")) {
//				clickOn(btn);
//			}
		List<WebElement> okBtn = driver.findElementsByName("OK");
		clickOn(okBtn.get(0));
			
		
		
		//clickOn(buttons.get(5));
		
		//clickOn(SyncIn_Cancelbtn);	
		Thread.sleep(1000);
	}
	public FM_SyncInPage click_CancelBtn() throws InterruptedException, IOException
	{
		WebElement cancel = driver.findElementByName("Cancel");
		Thread.sleep(1000);
		clickOn(cancel);
		
		return new FM_SyncInPage();
	}
	
	//Click the Yes button of Confirm alert mssg
	public void click_AlrtYesBtn() {
		WebElement alrtMeg_YesBtn = driver.findElementByAccessibilityId("Button1");
		
		try {
			checkingElementClickable(alrtMeg_YesBtn, 10).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//verify wether the Assets present or not on Asset pop up
	public boolean is_AssetsPresentOnAssetPopUp()
	{
		List<WebElement> assetOnPopUp = driver.findElementsByClassName("GridViewItem");
		
		boolean status = false;
		
		for(WebElement asset: assetOnPopUp)
		{
			status = IsElementVisibleStatus(asset);
			break;
		}
		return status;
	}
	//Count of displyed Assets list on AssetList Popup
	public int count_AssetsOnAssetPopUp()
	{
		List<WebElement> assetOnPopUp = driver.findElementsByClassName("GridViewItem");
		int count = 0;
		for(WebElement assetcnt:assetOnPopUp)
		{
			if(IsElementVisibleStatus(assetcnt))
			{
				count++;
			}
		}
		return count;
	}
	//check assets are not selected or not
	public boolean is_AllAssetsSelected()
	{
		List<WebElement> assetOnPopUp = driver.findElementsByClassName("GridViewItem");
		boolean status = false;
		for(WebElement assetcnt:assetOnPopUp)
		{
			if(checkboxSelectStatus(assetcnt))
			{
				status = true;
			}
		}
		return status;
	}
	//All Asset path visibility checking
	public boolean assets_PathVisible()
	{
		List<WebElement> assetPath = driver.findElementsByAccessibilityId("AssetIdTextBlock");
		
		boolean status = false;
		for(WebElement asstPth : assetPath)
		{
			status = IsElementVisibleStatus(asstPth);
		}
		return status;
	}
	//All Asset path visibility checking
	public boolean assets_DateVisible()
	{
		List<WebElement> assetPath = driver.findElementsByAccessibilityId("LastActivityDetailsTextBlock");
		
		boolean status = false;
		for(WebElement asstPth : assetPath)
		{
			status = IsElementVisibleStatus(asstPth);
		}
		return status;
	}
	
	//Click the OK button of Successful alert mssg
	public void click_Success_alrtMeg_OkBtn() {		
		WebElement Success_alrtMeg_OkBtn = driver.findElementByAccessibilityId("Button0");
		try {
			checkingElementClickable(Success_alrtMeg_OkBtn, 20).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void click_OkOnSyncInSelections()
	{
		WebElement okBtn = driver.findElementByAccessibilityId("SyncInAssetsPopup").findElement(By.name("OK"));
		clickOn(okBtn);
	}
	public void click_YesBtn_popup() throws InterruptedException {
		WebElement Yes_Btn = driver.findElementByAccessibilityId("Button1");
		
		try
		{
			waitForElementLoad(Yes_Btn, 5000);
			Thread.sleep(2000);
			click_On(Yes_Btn);
		}
		catch (Exception e) {
			Yes_Btn = driver.findElementByAccessibilityId("Button1");
			waitForElementLoad(Yes_Btn, 5000);
			Thread.sleep(2000);
			click_On(Yes_Btn);
		}
		
	}
	public void click_OK_popup() throws InterruptedException {
			WebElement Ok_Btn = driver.findElementByAccessibilityId("Popup Window").findElement(By.name("OK"));
			//Thread.sleep(1000);
			//clickOn(Ok_Btn);

				  try{
					  waitForElementVisible(Ok_Btn);
					  Thread.sleep(2000);
					  click_On(Ok_Btn);
				    
				  }
				  catch(Exception e){
			//	WebElement Ok_Btn1 = driver.findElementByAccessibilityId("Button0");  
					  WebElement Ok_Btn1 = driver.findElementByAccessibilityId("Popup Window").findElement(By.name("OK"));
					  waitForElementVisible(Ok_Btn1);
					  Thread.sleep(2000);
				 click_On(Ok_Btn1);
				  }
				  
		}	
			  	
	public boolean is_OkOnSyncInEnabled()
	{
		WebElement okBtn = driver.findElementByAccessibilityId("SyncInAssetsPopup").findElement(By.name("OK"));
		return IsElementEnabledStatus(okBtn);
	}
	
	public boolean is_OkBtnVisible()
	{
		WebElement okBtn = driver.findElementByAccessibilityId("SyncInAssetsPopup").findElement(By.name("OK"));
		return IsElementVisibleStatus(okBtn);
	}
	public boolean is_OkBtnEnabled()
	{
		WebElement okBtn = driver.findElementByAccessibilityId("SyncInAssetsPopup").findElement(By.name("OK"));
		return IsElementEnabledStatus(okBtn);
	}
	public boolean is_CancelBtnVisible()
	{
		return IsElementVisibleStatus(SyncIn_Cancelbtn);
	}
	

}
