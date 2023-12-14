package com.avsQual.pages;


import java.io.IOException;
import org.openqa.selenium.WebElement;
import com.avsQual.base.BaseClass;

public class FileManagementPage extends BaseClass {


               // FileManagementPage Element definition
               WebElement SyncInBtn = null;
               WebElement SyncOutBtn = null;
               WebElement ArchiveBtn = null;
               WebElement AvsConvertBtn = null;
               //WebElement OKButton=null;
               
               
               private void initElements() {
                              ArchiveBtn = driver.findElementByAccessibilityId("ArchiveBtn");
                              SyncInBtn = driver.findElementByAccessibilityId("SyncInBtn");
                              SyncOutBtn = driver.findElementByAccessibilityId("SyncOutBtn");
                              AvsConvertBtn = driver.findElementByAccessibilityId("AvsConvertBtn");
                              //OKButton=driver.findElementByName("OK");
                              
               }

               FileManagementPage() throws IOException {
                              super();
                              initElements();

               }
               
               //Release memory
               public void resetWebElements()
               {
                              ArchiveBtn = null;
                              AvsConvertBtn = null;
                              SyncInBtn = null;
                              SyncOutBtn = null;
                              //OKButton=null;
                              
                                             
               }

               /*----------------------
               Methods of SyncIn Page
               ------------------------*/


               // Check if SyncInHeaderBtn is enabled
               public boolean Is_SyncInHeaderBtnEnabled() {
                              return IsElementEnabledStatus(SyncInBtn);
               }
            // Check if SyncInHeaderBtn is displayed
               public boolean Is_SyncInHeaderBtnDisplayed() {
                   return IsElementVisibleStatus(SyncInBtn);
    }
               // Move to SynIn Page by Clicking the header SyncIn Button
               public FM_SyncInPage ClickSyncInBtn_SyncinPage(String UID, String PW) throws InterruptedException, IOException {
                              clickOn(SyncInBtn);
                              Thread.sleep(500);
                              UserLoginPopup(UID, PW);
                              return new FM_SyncInPage();
               }
               
               // Verify if login Pop is displayed by Clicking the header SyncIn Button
               public void ClickSyncInBtn(String UID, String PW) throws InterruptedException, IOException {
                              clickOn(SyncInBtn);
                              Thread.sleep(500);
                              UserLoginPopup(UID, PW);

               }
               //click on Sync In Option
               public void click_SyncIn()
               {
            	   clickOn(SyncInBtn);
               }



               /*----------------------
               Methods of Sync Out Page
               ------------------------*/
               //SynOut Button enabled or not
               public boolean Is_SyncOutHeaderBtnEnabled() {
                              return IsElementEnabledStatus(SyncOutBtn);
               }
             //SynOut Button visible or not
               public boolean Is_SyncOutHeaderBtnVisible() {
                   return IsElementVisibleStatus(SyncOutBtn);
    }
               
               public FM_SyncOutPage ClickSyncOutBtn_SyncOutPage(String UID, String PW) throws InterruptedException, IOException {
                              clickOn(SyncOutBtn);
                              Thread.sleep(500);
                              UserLoginPopup(UID, PW);
                              return new FM_SyncOutPage();
               }
               
               // Verify if login Pop is displayed by Clicking the header SyncIn Button
               public void ClickSyncOutBtn(String UID, String PW) throws InterruptedException, IOException {
                              clickOn(SyncOutBtn);
                              Thread.sleep(500);
                              UserLoginPopup(UID, PW);
               }
               public void  Click_on_SyncOutBtn() throws InterruptedException, IOException {
                              clickOn(SyncOutBtn);
                              Thread.sleep(500);
                              //UserLoginPopup(null, null);
                              //return new FileManagementPage();
               }
               
               public void Click_OKbtn_Syncout() throws InterruptedException
               {
            	   {
            	        WebElement okbtn = driver.findElementByAccessibilityId("ValidateUserOK");
            	        clickOn(SyncOutBtn);
            	        Thread.sleep(500);
            	        clickOn(okbtn);        
            	    }                 
               }
               

//            // Fetch the alert message when a user does not have privilege to access
//            public String AlertMsg() {
//                           WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
//                           return FetchText(Msg);
//            }
               
               /*----------------------
               Methods of Archive Page
               ------------------------*/
               //check ArchiveBtn is visible or not
               public boolean is_ArchiveBtnVisible()
               {
            	   return IsElementVisibleStatus(ArchiveBtn);
               }
             //check ArchiveBtn is enabled or not
               public boolean is_ArchiveBtnEnable()
               {
            	   return IsElementEnabledStatus(ArchiveBtn);
               }
               // Move to Archive Page by Clicking the header SyncIn Button
               public FM_ArchivePage Click_ArchiveTab(String UID, String PW) throws InterruptedException, IOException {
                              clickOn(ArchiveBtn);
                              Thread.sleep(500);
                              UserLoginPopup(UID, PW);
                              return new FM_ArchivePage();
               }
               
               // Alert message Move to Archive Page by Clicking the header SyncIn Button
               public void Click_ArchiveTab_Alertmsg(String UID, String PW) throws InterruptedException, IOException {
                              clickOn(ArchiveBtn);
                              Thread.sleep(500);
                              UserLoginPopup(UID, PW);
               }
               
               
               /*----------------------
               Methods of VRTConvrt Page
               ------------------------*/
               // Move to Archive Page by Clicking the header SyncIn Button
//               public FM_AvsConvert Click_AvsConvert_Btn(String UID, String PW) throws InterruptedException, IOException {
//                              clickOn(ArchiveBtn);
//                              Thread.sleep(500);
//                              UserLoginPopup(UID, PW);
//                              return new FM_AvsConvert();
//               }
               
               // Move to Archive Page by Clicking the header SyncIn Button
               public void Click_AvsConvertTab_WithAlertMsg(String UID, String PW) throws InterruptedException, IOException {
                              clickOn(ArchiveBtn);
                              Thread.sleep(500);
                              UserLoginPopup(UID, PW);
               }
               public void Click_ArchiveTab() throws InterruptedException, IOException {
                   clickOn(ArchiveBtn);
    }
               /*----------------------
               Methods of AvsConvertBtn Page
               ------------------------*/
               
               //check weather AvsConvertBtn is visible or not
               public boolean is_AvsConvertBtnVisible()
               {
            	   return IsElementVisibleStatus(AvsConvertBtn);
               }
               //check weather AvsConvertBtn is visible or not
               public boolean is_AvsConvertBtnEnabled()
               {
            	   return IsElementEnabledStatus(AvsConvertBtn);
               }
               // Move to Archive Page by Clicking the header SyncIn Button
               public FM_AvsConvertPage Click_AvsConvert_Btn(String UID, String PW) throws InterruptedException, IOException {
            	   			  clickOn(AvsConvertBtn);
                              Thread.sleep(500);
                              UserLoginPopup(UID, PW);
                              return new FM_AvsConvertPage();
               }
               public void Click_AVSConvertTab() throws InterruptedException, IOException {
                   clickOn(AvsConvertBtn);
               }
               
}

