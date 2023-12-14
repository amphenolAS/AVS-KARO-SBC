package com.avsQual.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.avsQual.base.BaseClass;

public class EquipmentHubPage extends BaseClass {
                // IRTDHubPage IRTDHubPage;
                // EquipmentHubPage Element definition
                WebElement AddButton = null;
                WebElement IOBox = null;
                WebElement eqpmntTitle = null;
                WebElement Back_btn = null;
                WebElement filterBtn = null;
                WebElement searchEqpmnt = null;

                private void initElements() {
                                AddButton = driver.findElementByAccessibilityId("AddEquipmentsButton");
                                eqpmntTitle = driver.findElementByAccessibilityId("EquipmentsHeaderTextBlock");
                                filterBtn = driver.findElementByAccessibilityId("FilterEquipmentsButton");
                                Back_btn = driver.findElementByAccessibilityId("ArrowGlyph");
                             //   IOBox = driver.findElementByClassName("GridViewItem");
                                searchEqpmnt = driver.findElementByAccessibilityId("SearchEquipmentsButton");
                }

                EquipmentHubPage() throws IOException {
                                super();
                                initElements();

                }

                // Release memory
                public void resetWebElements() {
                                AddButton = null;
                                IOBox = null;
                                eqpmntTitle = null;
                                Back_btn = null;
                                filterBtn = null;
                                searchEqpmnt = null;
                }
                //check visibility of Equipment page title
                public boolean is_EquipmentTitleVisible()
                {
                	return IsElementVisibleStatus(eqpmntTitle);
                }
                //fetch page title
                public String get_EquipmentPageTitle()
                {
                	return FetchText(eqpmntTitle);
                }
                //Equipement items
                public Equipment_IOBoxPage select_EqupmentItem(String name) throws IOException
                 {
                	List<WebElement> eqpItem = driver.findElementsByClassName("GridViewItem");
                			
                	
                	for(WebElement item: eqpItem)
                	{
                		if(FetchText(item).equalsIgnoreCase(name))
                		{
                			clickOn(item);
                			break;
                		}
                	}
                	return new Equipment_IOBoxPage();
                }
 //count of cali Due date Equipments
 public int count_CaliDueDate()
 {
	 List<WebElement> equipmentDate = driver.findElementsByAccessibilityId("LastActivityDetailsTextBlock");
	 int count = 0;
	 for(WebElement dateEqpmts:equipmentDate)
	 {
		 IsElementVisibleStatus(dateEqpmts);
		 count++;
	 }
	 return count;
	 
 }
                //fetch text from Equipment Tile
   public boolean is_DateDispOnEqupment(int num) throws IOException
     {
//		boolean flag = false;
//	   WebElement equipmentDate = driver.findElementByAccessibilityId("LastActivityDetailsTextBlock");
//	  try
//	  {
//	    if(IsElementVisibleStatus(equipmentDate))
//	    {
//	    	flag = true;
//	    }
//	    
//	    else
//	    {
//	    	flag = false;
//	    }
//	  }
//	  catch (Exception e) {
//		  e.getMessage();
//	}
//	  return flag;
                		
                	boolean flag = false;
                		
                					
                	List<WebElement> equipmentDate = driver.findElementsByAccessibilityId("LastActivityDetailsTextBlock");

                	try
                	{
                    if(IsElementVisibleStatus(equipmentDate.get(num)))
                	{
                	flag = true;
               		}
               		else
                	{
                	flag = false;
                	}
               }
                	catch (Exception e) {
					e.getMessage();
					}
                						
         			return flag; 
          			
                }  
                //check visiblity of Equipements
                public boolean is_ReqEpuipmentVisible(String name)
                {
                	List<WebElement> eqpItem = driver.findElementsByClassName("GridViewItem");
                			
                	boolean flag = false;
                	for(WebElement item: eqpItem)
                	{
                		if(FetchText(item).equalsIgnoreCase(name))
                		{
                			IsElementVisibleStatus(item);
                			flag = true;
                			break;
                		}
                }
                	return flag;
                	
                }
                public int EpuipmentCountOnEquipmentHubPage()
                {
                	List<WebElement> eqpItem = driver.findElementsByClassName("GridViewItem");
                			
                	int count = 0;
                	for(WebElement item: eqpItem)
                	{
                		if(IsElementVisibleStatus(item))
                		{
                			count++;
                		}
                }
                	return count;
                	
                }
                //check visibility of Filter button
                public boolean is_FilterBtnVisible()
                {
                	return IsElementVisibleStatus(filterBtn);
                }
                //click on filter button
                public void click_FilterBtn()
                {
                	clickOn(filterBtn);
                }
                //check visibility of print option
                public boolean is_PrintOptionVisible()
                {
                	WebElement printOption = driver.findElementByAccessibilityId("PrintButton");
                	return IsElementVisibleStatus(printOption);
                }
                //check visibility of add button
                public boolean is_AddBtnVisible()
                {
                	return IsElementVisibleStatus(AddButton);
                }
                //check visibility of search button
                public boolean is_SearchBtnVisible()
                {
                	return IsElementVisibleStatus(searchEqpmnt);
                }
                //click on search button
                public void click_SearchBtn()
                {
                	clickOn(searchEqpmnt);
                }
                //enter text on search text box
                public void enter_SearchTextBox(String text)
                {
                	WebElement searchBox = driver.findElementByAccessibilityId("SearchTextBox");
                	clickOn(searchBox);
                	ClearText(searchBox);
                	enterText(searchBox, text);
                }
                // Click AddButton
                public NewEquipmentCreation_Page ClickAddButton() throws InterruptedException, IOException {
                                clickOn(AddButton);
                                // Thread.sleep(1000);
                                return new NewEquipmentCreation_Page();
                }

                // IRTD
                // Click on IRTD List box of Equipment page
                public Equipment_IOBoxPage click_IOTile() throws IOException, InterruptedException {
                                
                                clickOn(IOBox);
                                Thread.sleep(1000);
                                return new Equipment_IOBoxPage();
                }

                // Is IRTD Tile visible

                public boolean Is_IRTDTileVisible() throws IOException {
                                WebElement irtdbox = driver.findElementByName("IRTD");
                                return IsElementVisibleStatus(irtdbox);
                }


                

                

                // Click AddButton to get Alert message when supervisor does not have default
                // privilege
                public void Alert_ClickAddBtn() throws InterruptedException {
                                clickOn(AddButton);
                                Thread.sleep(1000);
                }
                //Check visibility of back button
                public boolean is_BackBtnAvail()
                {
                	return IsElementVisibleStatus(Back_btn);
                }

                // Click on back button
                public MainHubPage ClickBackBtn() throws IOException {
                                clickOn(Back_btn);
                                return new MainHubPage();
                }

                // click Initiate Verification Tab
                public void ClickInitiateVerification() throws IOException {
                                WebElement InitiateVerificationTab = driver.findElementByAccessibilityId("SaveButton1");
                                clickOn(InitiateVerificationTab);
                }

                
                // is InitiateVerification button visible

                // Fetch EquipmentDueCalibration_Count and IRTD Equipment type text

                public String FetchTxt_DueCalibrationCount_IRTDtype(int j) throws InterruptedException, IOException {
                                List<WebElement> Listcounts = driver.findElementByName("IRTD").findElements(By.className("TextBlock"));
                                return Listcounts.get(j).getText();

                }

                // Fetch EquipmentDueCalibration_Count and IRTD Equipment type text

                public String FetchTxt_DueCalibrationCount_VRTLoggertype(int j) throws InterruptedException, IOException {
                                List<WebElement> Listcounts = driver.findElementByName("VRTLogger").findElements(By.className("TextBlock"));
                                // System.out.println(Listcounts.size());
                                return Listcounts.get(j).getText();

                }
}

