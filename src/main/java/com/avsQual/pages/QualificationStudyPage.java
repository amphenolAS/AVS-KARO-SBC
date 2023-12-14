package com.avsQual.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avsQual.base.BaseClass;

public class QualificationStudyPage extends BaseClass{
	
	//Qualification study Page WebElements
	WebElement pageTitle = null;
//	WebElement startQual = null;
	WebElement startExposure = null;
	WebElement stopExposure = null;
	WebElement saveStudy = null;
	WebElement hardWareBtn = null;
	WebElement setupBtn = null;
	WebElement quitQualBtn = null;
	WebElement graphViewBtn = null;
	WebElement listViewBtn = null;
	WebElement backBtn = null;
	
	//Initializing Webelements
	public void initialization()
	{
	pageTitle = driver.findElementByAccessibilityId("LiveDataHeaderTextBlock");
//	startQual = driver.findElementByAccessibilityId("btnQSStartQualificaton");
	startExposure = driver.findElementByAccessibilityId("btnStartExposure");
	stopExposure = driver.findElementByAccessibilityId("btnStopExposure");
	saveStudy = driver.findElementByAccessibilityId("btnSaveStudyFile");
	hardWareBtn = driver.findElementByAccessibilityId("btnHardware");
	setupBtn = driver.findElementByAccessibilityId("btnCriteria");
	quitQualBtn = driver.findElementByAccessibilityId("btnQuitQual");
	graphViewBtn = driver.findElementByAccessibilityId("btnGraphView");
	listViewBtn = driver.findElementByAccessibilityId("btnListView");
	backBtn = driver.findElementByAccessibilityId("ArrowGlyph");
	
	
	}
	public QualificationStudyPage() throws IOException
	{
		super();
		initialization();
	}
	
	public void resetWebElements()
	{
		pageTitle = null;
//		startQual = null;
		startExposure = null;
		stopExposure = null;
		saveStudy = null;
		hardWareBtn = null;
		setupBtn = null;
		quitQualBtn = null;
		graphViewBtn = null;
		listViewBtn = null;
		backBtn = null;
	}
	
	//click on Start Qualification study
	public void click_StartQualBtn()
	{
		WebElement startQual = driver.findElementByAccessibilityId("btnQSStartQualificaton");
		waitForElementLoad(startQual, 2000);
		clickOn(startQual);
	}
	public void click_YesBtn() throws InterruptedException
    {
    	WebElement yesBtn =  driver.findElementByClassName("MenuFlyout").findElement(By.name("Yes"));
    	Thread.sleep(1000);
    	clickOn(yesBtn);
    }
    
    public void stop_QualStudy(int time)
    {
    	WebElement stopQual = driver.findElementByAccessibilityId("btnQSStopQualificaton");
    	waitTime(stopQual, time);
    	waitForElementLoad(stopQual, 100);
    	clickOn(stopQual);
    }
    public void click_StopQualStudy() throws InterruptedException
    {
    	WebElement stopQual = driver.findElementByAccessibilityId("btnQSStopQualificaton");
    	Thread.sleep(1000);
    	clickOn(stopQual);
    }
    public HardwarePage click_HardWareBtn() throws InterruptedException, IOException
    {
    	Thread.sleep(1000);
    	clickOn(hardWareBtn);
    	return new HardwarePage();
    }
    //Verify the page title
    public boolean is_LiveDataScreenVisible()
    {
    	return IsElementVisibleStatus(pageTitle);
    }
    public void waitForEleLoad() throws InterruptedException
    {
    	WebElement element = null;
        long maxWaitMinutes = 60; // Maximum wait time in minutes

        for (int i = 0; i < maxWaitMinutes; i++) {
            try {
                // Use WebDriverWait to wait for the element with a timeout of 1 minute
                WebDriverWait wait = new WebDriverWait(driver, 60);
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnQSStopQualificaton")));

                // If the element is found, break out of the loop
                if (element != null) {
                    // Perform the desired action on the element
                    element.click();
                    break;
                }
            } catch (org.openqa.selenium.TimeoutException e) {
                // Element not found within 1 minute, continue waiting
                System.out.println("Element not found, continuing to wait...");
            }

            // Sleep for 1 minute before checking again
            TimeUnit.MINUTES.sleep(1);
}
       
}
    public void click_DeleteBtn() throws InterruptedException
    {
    	try
    	{
    		WebElement deleteBtn = driver.findElementByAccessibilityId("btnDelete");
    	Thread.sleep(2000);
   // 	waitForElementInVisible(deleteBtn);
    	clickOn(deleteBtn);
    	}
    	catch (Exception e) {
			e.getMessage();
		}
    }
    public boolean is_DltBtnVisible()
    {
    	WebElement deleteBtn = driver.findElementByAccessibilityId("btnDelete");
    	boolean status = false;
    	try
    	{
    		IsElementVisibleStatus(deleteBtn);
    		status = true;
    	}
    	catch (Exception e) {
			status = false;
		}
    	return status;
    	
    }
    public void click_SaveBtn() throws InterruptedException
    {
    	WebElement saveBtn = driver.findElementByAccessibilityId("btnSaveStudyFile");
    try
    {
    	waitForElementLoad(saveBtn, 100);
    	Thread.sleep(3000);
    	clickOn(saveBtn);
    }
    catch (Exception e) {
    	saveBtn = driver.findElementByAccessibilityId("btnSaveStudyFile");
    	waitForElementLoad(saveBtn, 100);
    	Thread.sleep(3000);
    	clickOn(saveBtn);
	}
    	
    }
    public void click_OkPopup2() throws InterruptedException
    {
    	//StopQualifCalibStudyFileNameTextBox
    	//StopQualifCalibCommentsTextBox
    	//StopQualifCalibPopupCLoseButton
    	WebElement okBtn = driver.findElementByAccessibilityId("StopQualifCalibOKButton");
    	Thread.sleep(2000);
    	clickOn(okBtn);
    }
    public void click_OkPopup1()
    {
    	WebElement okPopUp = driver.findElementByAccessibilityId("QualFileratePopupOKButton");
    	waitForElementLoad(okPopUp, 1000);
    	clickOn(okPopUp);
    }
    public MainHubPage click_BackBtn() throws IOException, InterruptedException
    {
    	Thread.sleep(2000);
    	clickOn(backBtn);
    	return new MainHubPage();
    }
    
    public boolean is_QualStopBtnEnabled()
    {
    	boolean status = false;
    	
    	try
    	{
    		if(IsElementEnabledStatus(quitQualBtn)) 
    		{
    		status = true;
    		}
    	}
    	catch (Exception e) {
    		status = false;
		}
    	return status;
    }
    public String consoleMeaasgeisDisplayed()
    {
    	List<WebElement> messageBox = driver.findElementsByAccessibilityId("PART_ScrollViewer");//.findElements(By.className("TextBlock"));
    	String val = "";
    	try
    	{
    	List<WebElement> text = messageBox.get(0).findElements(By.className("TextBlock"));
/*    	boolean status = false;
    	try
    	{
    		IsElementVisibleStatus(text.get(1));
    			status = true;
    		}
    		catch (Exception e) {
				status = false;
			}
    	return status;*/
    	waitForElementVisible(text.get(1));
    	val = FetchText(text.get(1));
    	}
    	catch (Exception e) {
			e.getMessage();
		}
		return val;
    	}
    
    public void waitForStopBtnDisabled() throws InterruptedException
    {
    	while(is_QualStopBtnEnabled() == false)
    	{
    	if(is_QualStopBtnEnabled() == true)
    	{
    		break;
    	}
    	}
//    	Thread.sleep(1000);
//    	click_DeleteBtn(); 
 //   	waitForElementInVisible(quitQualBtn);
    	
    }
    public void waitForSaveBtnEabled() throws InterruptedException
    {
  /*  	while(is_SaveBtnEnabled() == true)
    	{
    	waitForElementEnabled(saveStudy);
    	if(is_SaveBtnEnabled() == false)
    	{
    		break;
    	}
    	} */
    	try
    	{
    	waitForElementEnabled(saveStudy);
    	}
    	catch (Exception e) {
			e.getMessage();
		}
    }
    public void waitForStartExpoBtnEabled() throws InterruptedException
    {
    	try
    	{
    	waitForElementEnabled(startExposure);
    	}
    	catch (Exception e) {
			e.getMessage();
		}
    }
    public void waitForStopQualBtnVisible()
    {
    	
    	try
    	{
    		WebElement stopQual = driver.findElementByAccessibilityId("btnQSStopQualificaton");
    		waitForElementVisible(stopQual);
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    }
    public boolean is_SaveBtnEnabled()
    {
    	WebElement saveBtn = driver.findElementByAccessibilityId("btnSaveStudyFile");
    	boolean status = false;
    	
    	try
    	{
    		IsElementEnabledStatus(saveBtn);
    		status = true;
    	}
    	catch (Exception e) {
			status = false;
		}
    	return status;
    }
    public void waitForStopBtnEnabled() throws InterruptedException
    {
    	
    	while(is_QualStopBtnEnabled() == true)
    	{
 //   	waitForElementEnabled(quitQualBtn);
    	if(is_QualStopBtnEnabled() == false)
    	{
    		break;
    	}
    	}
    	
    }
    
    
    public void click_OnCloseBtn()
    {
    	WebElement clocseBtn = driver.findElementByAccessibilityId("QualParameterPopup").findElement(By.className("Button"));// QualParameterPopupClose
    //	waitForElementLoad(clocseBtn, 100);
    	click_On(clocseBtn);
    }
    
    public void click_SetupPara()
    {
    	WebElement cal = driver.findElementByAccessibilityId("QualParameterPopup").findElement(By.name("Calculations"));//
    	//WebElement cal = driver.findElementByAccessibilityId("PART_ScrollViewer");
    	Actions act = new Actions(driver);
    	act.moveToElement(cal).build().perform();
    }
    
    public void click_SetupBtn()
    {
    	waitForElementLoad(setupBtn, 100);
    	click_On(setupBtn);
    }
    
    public void click_VrtclSmlIncrs()
    {
    	List<WebElement> arrow = driver.findElementByAccessibilityId("QualParameterPopup").findElements(By.className("RepeatButton"));
    	Actions act = new Actions(driver);
    	for(int i=0;i<=18;i++)
    	{
    		act.click(arrow.get(3)).build().perform();
    	}
    	
    }
    
    public String get_StartQualVal()
    {
    	WebElement QualVal = driver.findElementByAccessibilityId("StartQualificationTextBlock");
   // 	WebElement QualVal = driver.findElementByXPath("//*[id='QualParameterPopup']/*[id='StartQualificationTextBlock']");
  //  	WebElement QualVal = driver.findElementByAccessibilityId("QualParameterPopup").findElement(By.id("StartQualificationTextBlock"));
    //	waitForElement(QualVal, 100);
    	return FetchText(QualVal);
    }
    
    public String get_StartExpoVal()
    {
    	WebElement startExpo = driver.findElementByAccessibilityId("StartExposureTextBlock");
    //	waitForElementLoad(startExpo, 100);
    	return FetchText(startExpo);
    }
    public void click_StartExpo()
    {
    	//WebElement startExpo = driver.findElementByAccessibilityId("StartExposureTextBlock");
    	
    	waitForElementLoad(startExposure, 100);
    	clickOn(startExposure);
    }
  
    public String get_StopExpoVal()
    {
    	WebElement stopExpo = driver.findElementByAccessibilityId("StopExposureTextBlock");
    //	waitForElementLoad(stopExpo, 100);
    	return FetchText(stopExpo);
    }
    public void click_StopExpo()
    {
    	waitForElementLoad(stopExposure, 100);
    	clickOn(stopExposure);
    }
    
    public String get_StopQual()
    {
    	WebElement stopQual = driver.findElementByAccessibilityId("StopQualificationTextBlock");
    //	waitForElementLoad(stopQual, 100);
    	return FetchText(stopQual);
    }
    
    public String get_SetupName()
    {
    	//WebElement text = driver.findElementByClassName("TextBlock").findElement(By.name(name));
    //	WebElement text = driver.findElementByXPath("//*[normalize-space(.='Setup Name : setup071')]");
    	List<WebElement> text = driver.findElementsByClassName("TextBlock");
    	return FetchText(text.get(2));
  /*  	String val = "";
    	for(WebElement txt: text)
		{
			val = FetchText(txt);
    		if(val.equalsIgnoreCase(name));
    		{
    			break;
    		}
		}
		return val;   */
    	
//    	text.getAttribute("Name");
//    	return FetchText(text);
    }
}


