package com.avsQual.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.avsQual.base.BaseClass;

public class HardwarePage extends BaseClass{

	//HardWare Page WebElements
//	WebElement setBathTempBox = null;
//	WebElement setBathTempBtn = null;
	WebElement backBtn = null;
	
	//Initializing Webelements
	public void initialization()
	{
	//	setBathTempBox = driver.findElementByAccessibilityId("txtSetBathTemp");
	//	setBathTempBtn = driver.findElementByAccessibilityId("btnSetBathTemp");
		backBtn = driver.findElementByAccessibilityId("ArrowGlyph");
	}
	public HardwarePage() throws IOException
	{
		super();
		initialization();
	}
	
	public void resetWebElements()
	{
//		setBathTempBox = null;
//		setBathTempBtn = null;
		backBtn = null;
	}	
	
	public void enterBathTemp(String temp)
	{
		WebElement setBathTempBox = driver.findElementByAccessibilityId("txtSetBathTemp");
		
		clickOn(setBathTempBox);
		ClearText(setBathTempBox);
		enterText(setBathTempBox, temp);
	}
	
	public void click_SetBathTempBtn() throws InterruptedException
	{
		WebElement setBathTempBtn = driver.findElementByAccessibilityId("btnSetBathTemp");
		Thread.sleep(1000);
		clickOn(setBathTempBtn);
	}
	public void click_DltBtn()
	{
		WebElement dltBtn = driver.findElementByAccessibilityId("btnDelete");
		try
		{
			Thread.sleep(1000);
			clickOn(dltBtn);
		}
		catch (Exception e) {
			e.getMessage();
		}	
	}
	
	public QualificationStudyPage click_BackBtn() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		clickOn(backBtn);
		return new QualificationStudyPage();
	}
}
