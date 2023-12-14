package com.avsQual.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.avsQual.base.BaseClass;
import com.avsQual.utility.TestUtilities;

public class FM_ArchiveSelectionPage extends BaseClass{

	TestUtilities tu = new TestUtilities();
    //Page element variable declaration definition
    WebElement ArchivePopupDate = null;
    WebElement setupChkBx = null;
    WebElement studyFileCheckBx = null;
    WebElement reporterChkBx = null;
   
    //Page element Initialize method
    private void initElements()
    {
    				ArchivePopupDate = driver.findElementByAccessibilityId("AssestPopupDateHeaderLabels");
                    setupChkBx = driver.findElementByAccessibilityId("ArchSetupsCheckBox");
                    studyFileCheckBx = driver.findElementByAccessibilityId("ArchStudyCheckBox");
                    reporterChkBx = driver.findElementByAccessibilityId("ArchReportCheckBox");
    }
    
    //Constructor for initializing the page elements
    FM_ArchiveSelectionPage() throws IOException
    {
                    super();
                    initElements();
    }
    
    //Release memory
    public void resetWebElements()
    {
    	ArchivePopupDate = null;
    			setupChkBx = null;
    			studyFileCheckBx = null;               
    			reporterChkBx = null; 
    }
    
    //Verifying AssestPopupDate visibility
    public boolean is_ArchivePopupDateVisible()
    {
    	return IsElementVisibleStatus(ArchivePopupDate);
    }
    //Verifying setup Check Box visibility
    public boolean is_SetupChkBxVisible()
    {
    	return IsElementVisibleStatus(setupChkBx);
    }
    public boolean is_SetupChkBoxSelected()
    {
    	return checkboxSelectStatus(setupChkBx);
    }
    //Verifying study Files Check Box
    public boolean is_StudyFileCheckBxVisible()
    {
    	return IsElementVisibleStatus(studyFileCheckBx);
    }
    public boolean is_StudyFileCheckBxSelected()
    {
    	return checkboxSelectStatus(studyFileCheckBx);
    }
    //Verifying Reporter Check Box Visibility
    public boolean is_ReporterChkBxVisible()
    {
    	return IsElementVisibleStatus(reporterChkBx);
    }
    public boolean is_ReporterChkBxSelected()
    {
    	return checkboxSelectStatus(reporterChkBx);
    }
    //Get date from Archive Selection Page
    public String getDate_ArchiveSlctionWindow()
    {
    	return FetchText(ArchivePopupDate);
    }
    public void select_SetupsChkBox()
    {
    	if(!checkboxSelectStatus(setupChkBx))
    	{
    		clickOn(setupChkBx);
    	}
    }
    public void unSelect_SetupsChkBox()
    {
    	if(checkboxSelectStatus(setupChkBx))
    	{
    		clickOn(setupChkBx);
    	}
    }
    public void select_StudyFileChkBox()
    {
    	if(!checkboxSelectStatus(studyFileCheckBx))
    	{
    		clickOn(studyFileCheckBx);
    	}
    }
    public void unSelect_StudyFileChkBox()
    {
    	if(checkboxSelectStatus(studyFileCheckBx))
    	{
    		clickOn(studyFileCheckBx);
    	}
    }
    public void select_ReoprtChkBox()
    {
    	if(!checkboxSelectStatus(reporterChkBx))
    	{
    		clickOn(reporterChkBx);
    	}
    }
    public void unSelect_ReportChkBox()
    {
    	if(checkboxSelectStatus(reporterChkBx))
    	{
    		clickOn(reporterChkBx);
    	}
    }
    public String get_DateOnAssets(int num)
    {
    	List<WebElement> dateList = driver.findElementsByAccessibilityId("LastActivityDetailsTextBlock");
    	
    	return FetchText(dateList.get(num));
    }
	//Verify wether SyncIn pop up window is displayed or not
		public boolean is_ArchiveSelectionWindowDisplyed()
		{
			boolean status = false;
			try
			{
				WebElement ArchivePopUp = driver.findElementByXPath("//*[normalize-space(.='Light Dismiss')]");
				if(IsElementVisibleStatus(ArchivePopUp))
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
			return status;
		}
		
		 //check assets are not selected or not
      	public boolean is_AllAssetsVisible()
      	{
      		List<WebElement> assetOnPopUp = driver.findElementsByClassName("GridViewItem");
      		boolean status = false;
      		for(WebElement assetcnt:assetOnPopUp)
      		{
      			if(IsElementVisibleStatus(assetcnt))
      			{
      				status = true;
      			}
      		}
      		return status;
      	}
      	public boolean is_AssetsSelectedState()
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
      	public int count_AssetsList()
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
      	
    	public void click_Asset(String aName)
      	{
      		List<WebElement> assetName = driver.findElementsByAccessibilityId("AssetSearchNameTextBlock");
      		for(WebElement name: assetName)
      		{
      			if(FetchText(name).equalsIgnoreCase(aName))
      			{
      				clickOn(name);
      				break;
      			}
      		}
      	}
    	public void click_SelectAllBtn()
    	{
    		WebElement selectAll = driver.findElementByAccessibilityId("ArchiveSelectAllButton");
    		clickOn(selectAll);
    	}
      	public boolean is_OkBtnVisible()
    	{
    		WebElement okBtn = driver.findElementByAccessibilityId("ArchiveAssetPopup").findElement(By.name("OK"));
    		return IsElementVisibleStatus(okBtn);
    	}
      	public boolean is_OkBtnEnabled()
    	{
    		WebElement okBtn = driver.findElementByAccessibilityId("ArchiveAssetPopup").findElement(By.name("OK"));
    		return IsElementEnabledStatus(okBtn);
    	}
      	 //select ok Button on Archive selection window
        public void click_Ok_ArhiveSelectionPopUp() throws InterruptedException
        {
        	WebElement okBtn = driver.findElementByAccessibilityId("ArchiveAssetPopup").findElement(By.name("OK"));
        	Thread.sleep(1000);
        	clickOn(okBtn);
        }
      	public boolean is_CancelBtnVisible()
      	{
      		WebElement cancelBtn = driver.findElementByAccessibilityId("ArchiveAssetPopup").findElement(By.name("Cancel"));
      		return IsElementVisibleStatus(cancelBtn);		
      	}
      	public FM_ArchivePage click_CancelBtn() throws IOException
      	{
      		WebElement cancelBtn = driver.findElementByAccessibilityId("ArchiveAssetPopup").findElement(By.name("Cancel"));
      		clickOn(cancelBtn);
      		return new FM_ArchivePage();		
      	}
      	 //click on X Button
		public FM_ArchivePage click_XBtn() throws IOException
		{
			List<WebElement> xBtn = driver.findElementByAccessibilityId("ArchiveAssetPopup").findElements(By.className("Button"));
			clickOn(xBtn.get(0));
			return new FM_ArchivePage();
		}
    	//close button visibility
       	public boolean is_CloseBtnVisible()
       	{
       		WebElement close = driver.findElementByXPath("//*[normalize-space(.='Close Advanced Validation System')]");
       		return IsElementVisibleStatus(close);
       	}
    
    
}
