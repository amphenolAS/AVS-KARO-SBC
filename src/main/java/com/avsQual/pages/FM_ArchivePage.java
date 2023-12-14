package com.avsQual.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avsQual.base.BaseClass;
import com.avsQual.utility.TestUtilities;

public class FM_ArchivePage extends BaseClass{
                TestUtilities tu = new TestUtilities();
                //Page element variable declaration definition
                WebElement ArchiveHeaderBtn = null;
                WebElement ArchiveBrowseBtn = null;
                WebElement ArchiveByDtBtn = null;
                WebElement ArchiveTextBox = null;
                WebElement ArchiveOKbtn = null;
                WebElement backBtn = null;
                                
                //Page element Initialize method
                private void initElements()
                {
                                ArchiveHeaderBtn = driver.findElementByAccessibilityId("ArchiveBtn");
                                ArchiveBrowseBtn = driver.findElementByAccessibilityId("ArchFolderBrowseButton");
                                ArchiveTextBox = driver.findElementByAccessibilityId("ArchFolderTextBox");
                                ArchiveByDtBtn = driver.findElementByAccessibilityId("PART_PickerButton");
                                ArchiveOKbtn = driver.findElementByAccessibilityId("ArchFolderOKButton");
                                backBtn = driver.findElementByAccessibilityId("ArrowGlyph");
                                

                }
                
                //Constructor for initializing the page elements
                FM_ArchivePage() throws IOException
                {
                                super();
                                initElements();
                }
                
                //Release memory
                public void resetWebElements()
                {
                                ArchiveHeaderBtn = null;
                                ArchiveBrowseBtn = null;
                                ArchiveByDtBtn = null;                   
                                ArchiveTextBox = null;
                                ArchiveOKbtn = null;
                                backBtn = null;
                                
                }
                
                /*----------------------
                Methods of Archive Page
                ------------------------*/
                //select the archive date
                public boolean is_ArchiveHeaderBtnVisible() 
                {
                	return IsElementVisibleStatus(ArchiveHeaderBtn);
                }
                public boolean is_ArchiveHeaderBtnEnabled() 
                {
                	return IsElementEnabledStatus(ArchiveHeaderBtn);
                }
                public boolean Is_ArchiveBrowseBtnVisible() {
                    return IsElementVisibleStatus(ArchiveBrowseBtn);
                }
                public boolean is_ArchiveDateBtnVisible()
                {
                	return IsElementVisibleStatus(ArchiveByDtBtn);
                }
                public boolean is_ArchiveOkBtnVisible()
                {
                	return IsElementVisibleStatus(ArchiveOKbtn);
                }
                public boolean is_CloseBtnVisible()
               	{
               		WebElement close = driver.findElementByXPath("//*[normalize-space(.='Close Advanced Validation System')]");
               		return IsElementVisibleStatus(close);
               	}
                public void click_ArchiveDate()
                {
                	clickOn(ArchiveByDtBtn);
                }
                //Select the date
                public  void selectReqDate(String mon, String dt, String yr) throws InterruptedException
            	{
                	click_ArchiveDate();
            		Thread.sleep(2000);
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


                public String getTxt_ArchiveDate()
                {
                	return FetchText(ArchiveByDtBtn);
                } 
             
              //select the Ok Button on date selection pop up
            	public void click_Ok_DateSelectionPopUp() throws InterruptedException
            	{
            		WebElement okSymbol = driver.findElementByAccessibilityId("PART_SelectorOKButton");
            		Thread.sleep(1000);
            		clickOn(okSymbol);
            	}
                //select the ok Button on Date selection window
                public void click_SelectorOKBtn() throws InterruptedException
                {
                	WebElement okBtn = driver.findElementByAccessibilityId("PART_SelectorOKButton");
                	Thread.sleep(1000);
                	clickOn(okBtn);
                }
                //Select Ok Button on Archive Page
                public FM_ArchiveSelectionPage click_OkBtn() throws IOException, InterruptedException
                {
                	clickOn(ArchiveOKbtn);
                	Thread.sleep(2000);
                	return new FM_ArchiveSelectionPage();
                }
                //click on select all button
                public void click_SelectAllBtn()
                {
                	WebElement selectBtn = driver.findElementByAccessibilityId("ArchiveSelectAllButton");
                	clickOn(selectBtn);
                }
                //select ok Button on Archive selection window
                public void click_Ok_SelectionPopUp() throws InterruptedException
                {
                	WebElement okBtn = driver.findElementByAccessibilityId("ArchiveAssetPopup").findElement(By.name("OK"));
                	Thread.sleep(1000);
                	clickOn(okBtn);
                }
                //ArchiveAssetPopup
                public boolean is_AssetPopUpWindowVisibe()
            	{
            		boolean status = false;
            		
            		try
            		{
            			WebElement AssetPopUp = driver.findElementByAccessibilityId("ArchiveAssetPopup");
            		if(IsElementVisibleStatus(AssetPopUp))
            		{
            			status = true;
            		}
            		}
            		catch (Exception e) {
            			status = false;
            		}
            		return status;
            	}
                // Verify if Archive browse text box visible or not               
                public boolean ArchiveTextBoxVisible() throws InterruptedException {
                                return IsElementVisibleStatus(ArchiveTextBox);
                }
                
                // Verify if Archive browse text box visible or not               
                                public boolean IsArchiveBrowseBtnVisible() throws InterruptedException {
                                                return IsElementVisibleStatus(ArchiveBrowseBtn);
                                }
                //send the values into the SyncIn Text Box field
                public void enterTxt_ArchiveTextBox(String val)
               	{
                	enterText(ArchiveTextBox, val);
                }   
                public String  getText_ArchiveFilePath()
                {
                               return FetchText(ArchiveTextBox);
                } 
                //Verify the window expolrer button
               	public boolean is_ExplorerWinInvoked()
               	{
               		//Switch to file explorer window 
               		driver.switchTo().activeElement();
               		
               		WebElement win = driver.findElementByXPath("//*[normalize-space(.='Select Folder')]");
               		return IsElementVisibleStatus(win);
               	} 
                //Click the folder browse button
                public void Click_BrowseBtn() throws InterruptedException {
                                clickOn(ArchiveBrowseBtn);
                                Thread.sleep(2000);
                }
                
                // Enter sync in folder path
                public void enter_Filepath(String pathname) throws AWTException, IOException, InterruptedException{
                                Click_BrowseBtn();
                                // switch to the file upload window
                                WebElement alert = driver.switchTo().activeElement();
                                Thread.sleep(2000);

                                // hit enter
                                Robot r = new Robot();
                                r.keyPress(KeyEvent.VK_ENTER);
                                r.keyRelease(KeyEvent.VK_ENTER);
                                r.keyPress(KeyEvent.VK_ENTER);
                                r.keyRelease(KeyEvent.VK_ENTER);
                                
                                String fp2 = System.getProperty("user.dir") +  "\\src\\test\\resources\\TestData\\" + pathname;
                                //System.out.println(fp2);
                                alert.sendKeys(fp2);
                                Thread.sleep(500);
                                //Robot r = new Robot();
                                r.keyPress(KeyEvent.VK_TAB);
                                r.keyRelease(KeyEvent.VK_TAB);
                                r.keyPress(KeyEvent.VK_ENTER);
                                r.keyRelease(KeyEvent.VK_ENTER);

                                // switch back
                                driver.switchTo().activeElement();
                                Thread.sleep(500);
                }
              //Click Back button to move to File Management Page
               	public MainHubPage click_BackBtn() throws IOException {
               		clickOn(backBtn);
               		return new MainHubPage();
               	}
                public void enter_NewFilepath(String pathname) throws AWTException, IOException, InterruptedException{
                  //  Click_BrowseBtn();
                    // switch to the file upload window
                    WebElement alert = driver.switchTo().activeElement();
                    Thread.sleep(2000);

                    // hit enter
                    Robot r = new Robot();
                    r.keyPress(KeyEvent.VK_ENTER);
                    r.keyRelease(KeyEvent.VK_ENTER);
                    r.keyPress(KeyEvent.VK_ENTER);
                    r.keyRelease(KeyEvent.VK_ENTER);
                    
                    String fp2 = pathname;
                    //System.out.println(fp2);
                    alert.sendKeys(fp2);
                    Thread.sleep(500);
                    //Robot r = new Robot();
                    r.keyPress(KeyEvent.VK_TAB);
                    r.keyRelease(KeyEvent.VK_TAB);
                    r.keyPress(KeyEvent.VK_ENTER);
                    r.keyRelease(KeyEvent.VK_ENTER);

                    // switch back
                    driver.switchTo().activeElement();
                    Thread.sleep(500);
    }
                


}

