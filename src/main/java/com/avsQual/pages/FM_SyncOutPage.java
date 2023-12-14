package com.avsQual.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebElement;

import com.avsQual.base.BaseClass;
//import com.vrt.utility.TestUtilities;

public class FM_SyncOutPage extends BaseClass {
               
               //Page element variable declaration definition
               WebElement SyncOutHeaderBtn = null;
               WebElement SyncOutBrowseBtn = null;
               WebElement SyncOutTextBox = null;
               WebElement SyncOutOKbtn = null;
               WebElement SyncOutClosebtn=null;
               WebElement SyncOutBackBtn = null;
               //WebElement SyncOutSelectAllBtn=null;
               //TestUtilities tu = new TestUtilities();
                              
               //Page element Initialize method
               private void initElements()
               {
                              SyncOutHeaderBtn = driver.findElementByAccessibilityId("SyncOutBtn");// SyncOut
                              SyncOutBrowseBtn = driver.findElementByAccessibilityId("SyncOutFolderBrowseButton");
                              SyncOutTextBox = driver.findElementByAccessibilityId("SyncOutFolderTextBox");
                              SyncOutOKbtn = driver.findElementByAccessibilityId("SyncOutFolderOKButton");
                              SyncOutBackBtn = driver.findElementByAccessibilityId("ArrowGlyph");
                              //SyncOutClosebtn = driver.findElementByAccessibilityId("Close");
                              //SyncOutSelectAllBtn= driver.findElementByAccessibilityId("SyncOutSelectAllButton");

               }
               
               //Constructor for initializing the page elements
               FM_SyncOutPage() throws IOException
               {
                              super();
                              initElements();
               }
               
               //Release memory
               public void resetWebElements()
               {
                              SyncOutHeaderBtn = null;
                              SyncOutBrowseBtn = null;
                              SyncOutTextBox = null;
                              SyncOutOKbtn = null;
                              SyncOutClosebtn=null;
                              SyncOutBackBtn = null;
                              //SyncOutSelectAllBtn=null;
                              
               }
               
               /*----------------------
               Methods of Sync out Page
               ------------------------*/

               // SyncOutTextBox is visible
               public boolean is_SyncOutHeaderVisible()
               {
            	   return IsElementVisibleStatus(SyncOutHeaderBtn);
               }
               public boolean is_SyncOutHeaderEnabled()
               {
            	   return IsElementEnabledStatus(SyncOutHeaderBtn);
               }
               public boolean Is_SyncOutBoxSelected() {
                              return checkboxSelectStatus(SyncOutTextBox);
               }
               
               public boolean Is_SyncOutFilePathVisible() {
                              return IsElementVisibleStatus(SyncOutTextBox);
               }
               
               public boolean Is_SyncOutBrowseBtnSelected() {
                              return checkboxSelectStatus(SyncOutBrowseBtn);
               }
               
               public boolean Is_SyncOutBrowseBtnVisible() {
                              return IsElementVisibleStatus(SyncOutBrowseBtn);
               }
               
               public boolean Is_SyncOutOKbtnVisible() {
                              return IsElementVisibleStatus(SyncOutOKbtn);
               }
               
               public boolean Is_SyncOutClosebtnVisible() {
                              return IsElementVisibleStatus(SyncOutClosebtn);
               }
               
               public void ClickSyncOutBrowseBtn() throws InterruptedException, IOException {
                              clickOn(SyncOutBrowseBtn);
               }
             //Verify the window expolrer button
           	public boolean is_ExplorerWinInvoked()
           	{
           		//Switch to file explorer window 
           		driver.switchTo().activeElement();
           		
           		WebElement win = driver.findElementByXPath("//*[normalize-space(.='Select Folder')]");
           		return IsElementVisibleStatus(win);
           	}
               
               public void  get_TextofFilePath()
               {
                              String act_val = SyncOutTextBox.getText();
                              System.out.println(act_val);
               }
               public String  getText_SynOutFilePath()
               {
                              return FetchText(SyncOutTextBox);
               } 
           	//close button visibility
           	public boolean is_CloseBtnVisible()
           	{
           		//WebElement close = driver.findElementByName("Close Advanced Validation System");
           		WebElement close = driver.findElementByXPath("//*[normalize-space(.='Close Advanced Validation System')]");
           		return IsElementVisibleStatus(close);
           	}
               
               public void clear_FilePath()
               {
                              SyncOutTextBox.click();
                              SyncOutTextBox.clear();
               }
               
               public  FM_SyncOutAssetListPage ClickSyncOutOkBtn1() throws InterruptedException, IOException {
                              clickOn(SyncOutOKbtn);
                              return new FM_SyncOutAssetListPage();
                              
               }
               public  FM_SyncOutwithAsset ClickSyncOutOkBtn2() throws InterruptedException, IOException {
                              clickOn(SyncOutOKbtn);
                              return new FM_SyncOutwithAsset();
                              
               }
             //send the values into the SyncIn Text Box field
           	public void enterTxt_SyncOutTextBox(String val)
           	{
           		enterText(SyncOutTextBox, val);
           	}
                              
            // Enter sync in folder path
           	public void enter_Filepath(String pathname) throws AWTException, IOException, InterruptedException{
         	   Thread.sleep(1000);

           		clickOn(SyncOutBrowseBtn);
           		Thread.sleep(2000);
           		// switch to the file upload window
           		WebElement alert = driver.switchTo().activeElement();
           		Thread.sleep(2000);
           		
           		String fp2 = System.getProperty("user.dir") +  "\\src\\test\\resources\\TestData\\" + pathname;
           		//System.out.println(fp2);
           		alert.sendKeys(fp2);
           		Thread.sleep(500);

           		//Click Select Folder button

           		WebElement SelectFolderBtn = driver.findElementByAccessibilityId("1");
           		clickOn(SelectFolderBtn);
           		
           		// switch back
           		driver.switchTo().activeElement();
           		Thread.sleep(500);
           	}

         // Enter sync in folder path
           	public void enter_NewFilepath(String pathname) throws AWTException, IOException, InterruptedException{
         	   Thread.sleep(1000);

           		clickOn(SyncOutBrowseBtn);
           		Thread.sleep(2000);
           		// switch to the file upload window
           		WebElement alert = driver.switchTo().activeElement();
           		Thread.sleep(2000);
           		
           		String fp2 = pathname;
           		//System.out.println(fp2);
           		alert.sendKeys(fp2);
           		Thread.sleep(500);

           		//Click Select Folder button

           		WebElement SelectFolderBtn = driver.findElementByAccessibilityId("1");
           		clickOn(SelectFolderBtn);
           		
           		// switch back
           		driver.switchTo().activeElement();
           		Thread.sleep(500);
           	}
               public void enter_Localdrivepath(String pathname) throws AWTException, IOException, InterruptedException{
            	   Thread.sleep(1000);
                              clickOn(SyncOutBrowseBtn);
                              Thread.sleep(500);
                              // switch to the file upload window
                              WebElement alert = driver.switchTo().activeElement();
                              Thread.sleep(1000);

                              // enter the filename
                                             String filepath1 = "C:\\";
                              //System.out.println(filepath);
                              alert.sendKeys(filepath1);
                              Thread.sleep(500);

                              // hit enter
                              Robot r = new Robot();
                              r.keyPress(KeyEvent.VK_ENTER);
                              r.keyRelease(KeyEvent.VK_ENTER);
                              
                              String fp2 = "C:\\"+ pathname;
                              //System.out.println(filepath);
                              alert.sendKeys(fp2);
                              Thread.sleep(500);
                              r.keyPress(KeyEvent.VK_ENTER);
                              r.keyRelease(KeyEvent.VK_ENTER);
                              r.keyPress(KeyEvent.VK_ENTER);
                              r.keyRelease(KeyEvent.VK_ENTER);  

                              // switch back
                              driver.switchTo().activeElement();
                              Thread.sleep(500);

               }
             //Checking wether Asset List Pop Up Visible
         		public boolean is_AssetPopUpWindowVisibe()
         		{
         			//WebElement AssetPopUp = driver.findElementByAccessibilityId("SyncInAssetsPopup");
         			boolean status = false;
         			
         			try
         			{
         				WebElement AssetPopUp = driver.findElementByAccessibilityId("SyncOutAssetsPopup");
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
         		
               
               // Click the Filter button
               /*public SyncOutInAssetListPage click_SyncInOK_btn() throws IOException {
                              clickOn(SyncOutOKbtn);
                              return new SyncInAssetListPage();
               }*/
             //Click Back button to move to File Management Page
           	public MainHubPage click_BackBtn() throws IOException {
           		clickOn(SyncOutBackBtn);
           		return new MainHubPage();
           	}
               


}

