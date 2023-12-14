package com.avsQual.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.avsQual.base.BaseClass;
import com.avsQual.utility.TestUtilities;

public class SelectAVSPage extends BaseClass{
	
	//Select AVS Page Elements
	WebElement SlctAVSTitle = null;
	WebElement discoverAVS = null;
	WebElement conFigWifi = null;
	WebElement ipTxtBox = null;
	WebElement addBtn = null;
	WebElement removeBtn = null;
	WebElement conctBtn = null;
	
	TestUtilities tu = new TestUtilities();
	public void initialization()
	{
		SlctAVSTitle = driver.findElementByAccessibilityId("tbSeSelectIO");
		discoverAVS = driver.findElementByAccessibilityId("DiscoverIOBoxButton");
		conFigWifi = driver.findElementByAccessibilityId("ConfigureWifi");
		ipTxtBox = driver.findElementByAccessibilityId("txtIOBox");
		addBtn = driver.findElementByAccessibilityId("btnIOIPconnect");
		removeBtn = driver.findElementByAccessibilityId("btnRemoveIP");
		conctBtn = driver.findElementByAccessibilityId("btnConnect");
	}
	

	public SelectAVSPage() throws IOException {
		super();
		initialization();
	}
	
	//Release Memory
	public void resetWebElements()
	{
		SlctAVSTitle = null;
		discoverAVS = null;
		conFigWifi = null;
		ipTxtBox = null;
		addBtn = null;
		removeBtn = null;
		conctBtn = null;
	}
	
	//enter text into IP Text Box
	public void enterTxt_IntoIpTxtBox(String ipadd)
	{
//		clickOn(ipTxtBox);
//		ClearText(ipTxtBox);
		enterText(ipTxtBox, ipadd);
	} 
	public void clickt_IntoIpTxtBox()
	{
		clickOn(ipTxtBox);
	} 
	//Get Text from AVS IP TxtBox
	
	public String getTxt_AVSIPBox()
	{
		return FetchText(ipTxtBox);
	}
	//click on Add Button
	public void click_AddBtn()
	{
		clickOn(addBtn);
	}
	public String alertMsg_IPAddField()
	{
		WebElement alertMsg = driver.findElementByAccessibilityId("tbIPvalidate");
		return FetchText(alertMsg); 
	}
	//Verify Add Button is Enabled or not
	public boolean is_AddBtnEnabled()
	{
		return IsElementEnabledStatus(addBtn);
	}
	//Click on Remove button
	public void click_RemoveBtn()
	{
		clickOn(removeBtn);
	}
	//verify Discover AVS Btn enabled or not
	public boolean is_DiscoverAVSBtn_Enabled()
	{
		return IsElementEnabledStatus(discoverAVS);
	}
	//verify Configure WIFI Btn enabled or not
	public boolean is_ConfWifiBtn_Enabled()
	{
		return IsElementEnabledStatus(conFigWifi);
	}
	public void click_DiscoverAVSBtn()
	{
		clickOn(discoverAVS);
	}
	public boolean is_AVSUnitsDisplayed()
	{
		List<WebElement> AVS = driver.findElementByAccessibilityId("Set1TextTileLandingGrid").findElements(By.className("GridViewItem"));
		boolean status = false; 
		for(WebElement avs :AVS)
		{
			status = IsElementVisibleStatus(avs);
		}
		return status;
	}
	public String getTxt_SingleAVSTitle()
	{
		WebElement singleAVS = driver.findElementByAccessibilityId("textUsbIp");
		return FetchText(singleAVS);
	}
	public void click_SingleAVSTitle()
	{
		WebElement singleAVS = driver.findElementByAccessibilityId("textUsbIp");
		click_On(singleAVS);
	}
	//Click on Configure WiFi
	public void click_ConfgWiFi()
	{
		click_On(conFigWifi);
	}
	public boolean is_NetWorkFieldVisible()
	{
		List<WebElement> netWork = driver.findElementsByAccessibilityId("EditableCombo");
		return IsElementVisibleStatus(netWork.get(0));
	}
	public boolean is_SecurityTypeVisible()
	{
		List<WebElement> securityField = driver.findElementsByAccessibilityId("EditableCombo");
		return IsElementVisibleStatus(securityField.get(1));
	}
	public boolean is_EncryptionTypeVisible()
	{
		List<WebElement> encryptionField = driver.findElementsByAccessibilityId("EditableCombo");
		return IsElementVisibleStatus(encryptionField.get(2));
	}
	public boolean is_NetWorkSecurityTypeVisible()
	{
		WebElement netWorkSecurityType = driver.findElementByAccessibilityId("WiFiNetworkSecurityKeyTextBox");
		return IsElementVisibleStatus(netWorkSecurityType);
	}
	public boolean is_IPDrpDwnVisible()
	{
		WebElement ipDrpDwn = driver.findElementByAccessibilityId("EditableCombo");
		return IsElementVisibleStatus(ipDrpDwn);
	}
	public boolean is_OKBtnVisible()
	{
		WebElement okBtn = driver.findElementByAccessibilityId("OKButton");
		return IsElementVisibleStatus(okBtn);
	}
	public boolean is_CancelBtnVisible()
	{
		WebElement cancelBtn = driver.findElementByAccessibilityId("CancelWifiConfigureButton");
		return IsElementVisibleStatus(cancelBtn);
	}
	//Getting message text from connect button
	public String getTxt_ConnctBtn() throws InterruptedException
	{
		WebElement errMsg = driver.findElementByAccessibilityId("tbMessage");
	//	WebElement errMsg = driver.findElementByName("Unable to connect AVS");
		Thread.sleep(50000);
		
		return FetchText(errMsg);
	}
	//Checking the Select AVS Screen displayed or not
	public boolean isSelectAVSScrn_Dispayed()
	{
		return IsElementVisibleStatus(SlctAVSTitle);
	}
	//Verify Connect Button Enabled State
	public boolean is_ConctBtnEnabled()
	{
		return IsElementEnabledStatus(conctBtn);
	}
	//Click Connect Button without navigating AVS Qual Screen
	public void click_CnnctBtn()
	{
		click_On(conctBtn);
	}
	//Click on connect Button
	public QualificationStudyPage click_ConnectBtn() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		clickOn(conctBtn);
		
		
		try
		{
			//WebElement yesBtn = driver.findElementByAccessibilityId("Popup Window").findElement(By.name("Yes"));
			WebElement yesBtn = driver.findElementByAccessibilityId("Button1");
			waitForElementLoad(yesBtn, 10000);
			Thread.sleep(1000);
			click_On(yesBtn);
			//tu.click_YesBtn_popup();
		}
		catch (Exception e) {
			//WebElement yesBtn = driver.findElementByAccessibilityId("Button1");
			WebElement yesBtn = driver.findElementByAccessibilityId("Popup Window").findElement(By.name("Yes"));
			waitForElementLoad(yesBtn, 10000);
			Thread.sleep(1000);
			click_On(yesBtn);
		}
		 
		try
		{
			WebElement ethernet = driver.findElementByAccessibilityId("ConnectEthernetOption");
			waitForElementLoad(ethernet, 100);
			click_On(ethernet);
		}
		catch (Exception e) {
			e.getMessage();
		}
		
		Thread.sleep(15000);
		int explicitWaitTimeout = 200000; 
        driver.manage().timeouts().implicitlyWait(explicitWaitTimeout, TimeUnit.SECONDS);

		return new QualificationStudyPage();
	}
	public String fetchTxt_FromAVSUnit(String ip)
	{
		List<WebElement> ipAdd = driver.findElementsByAccessibilityId("textBlockIpAddress");
		
		String value="";
		for(WebElement AVSIP:ipAdd)
		{
			value = FetchText(AVSIP);
			if(value.equals(ip))
			{
				waitForElementLoad(AVSIP, 1000);
				break;
			}
		}
		return value;
	}
	public boolean is_AVSUnitDispayed(String ip)
	{
		List<WebElement> ipAdd = driver.findElementsByAccessibilityId("textBlockIpAddress");
		
		boolean status = false;
	try
	{
		for(WebElement AVSIP:ipAdd)
		{
			waitForElementLoad(AVSIP, 1000);
			FetchText(AVSIP).contains(ip);
			status = true;
				break;
		}
	}
	catch (Exception e) {
		status = false;
	}
		return status;
	}
	//Select Required AVS
	public void select_AVS(String ip) throws InterruptedException
	{
		List<WebElement> ipAdd = driver.findElementsByAccessibilityId("textBlockIpAddress");
		
		for(WebElement AVSIP:ipAdd)
		{
			if(ip.equals(FetchText(AVSIP)))
			{
				waitForElementLoad(AVSIP, 1000);
				clickOn(AVSIP);
				break;
			}
			
		}
	}
	public boolean isAVS_Selected(String ip) throws InterruptedException
	{
		List<WebElement> ipAdd = driver.findElementsByAccessibilityId("textBlockIpAddress");
		
		boolean status = false;
		for(WebElement AVSIP:ipAdd)
		{
			Thread.sleep(2000);
			String text = FetchText(AVSIP);
			status = checkboxSelectStatus(AVSIP);
			if(text.contains(ip))
			{
				status = true;
				break;
			}
			
		}
		return status;
	}
	//Get AVS IP Address
	public String get_AVSIP(String ip) throws InterruptedException
	{
		List<WebElement> ipAdd = driver.findElementsByAccessibilityId("textBlockIpAddress");
		
		String avsIP = "";
		for(WebElement AVSIP:ipAdd)
		{
			avsIP = FetchText(AVSIP);
			if(avsIP.contains(ip))
			{
				waitForElementLoad(AVSIP, 1000);
				break;
			}
		}
		return avsIP;
	}
	
}
