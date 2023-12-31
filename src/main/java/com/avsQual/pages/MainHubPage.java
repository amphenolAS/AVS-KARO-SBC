package com.avsQual.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avsQual.base.BaseClass;

public class MainHubPage extends BaseClass {

	// Main Hub Page Element definition
	WebElement MainUILoggedinUserTitle = null;
	WebElement MainUILoggedinUserName = null;
	WebElement MainUIAdminTile = null;
	WebElement AssetCountInfoInAsstTile = null;
	WebElement MainUIPageTitle = null;
	WebElement MainUIEquipmentTitle = null;
	WebElement FileManagementTitle = null;
	WebElement AuditTitle = null;

	private void initElements() {
		// Main Hub Page Page Element definition
		MainUILoggedinUserTitle = driver.findElementByAccessibilityId("UserDesignationTextBlock");
		MainUILoggedinUserName = driver.findElementByAccessibilityId("UserNameTextBlock");
		MainUIAdminTile = driver.findElementByName("Admin");
		AssetCountInfoInAsstTile = driver.findElementByAccessibilityId("TitleCountTextBlock");
		MainUIPageTitle = driver.findElementByName("Advanced Validation System");
		MainUIEquipmentTitle = driver.findElementByName("Equipment");
		FileManagementTitle = driver.findElementByName("File Management");
		AuditTitle = driver.findElementByName("Audit");
		// Discover

	}

	public MainHubPage() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() {
		MainUILoggedinUserTitle = null;
		MainUILoggedinUserName = null;
		MainUIAdminTile = null;
		AssetCountInfoInAsstTile = null;
		MainUIPageTitle = null;
		MainUIEquipmentTitle = null;
		FileManagementTitle = null;
		AuditTitle = null;

		// System.out.println("Login Page elements memory released");
	}

// click on discover tile
//	public SelectBaseStationPage clickonDiscoverTile() throws InterruptedException, IOException {
//		WebElement DiscoverTile = driver.findElementByName("Discover");
//		clickOn(DiscoverTile);
//		return new SelectBaseStationPage();
//	}

	// Verify the Main Hub Page title name
	public boolean Is_mainHubPageTitle_Visible() {
		return IsElementVisibleStatus(MainUIPageTitle);
	}

	// Is UserDesignation text Block Presence
	public boolean IsUserDesigBlockPresence() {
		WebElement UserDesigTextBlock = driver.findElementByAccessibilityId("UserDesignationTextBlock");
		return IsElementEnabledStatus(UserDesigTextBlock);
	}

	// Verify the Logged in User credentials
	public String LoggedinUserName() {
		return FetchText(MainUILoggedinUserName);
	}

	//
	public String UserNameText() {
		WebElement UserNameText = driver.findElementByAccessibilityId("UserNameTextBlock");
		return FetchText(UserNameText);
	}

	// Sign out Operation
	public LoginPage UserSignOut() throws InterruptedException, IOException {
		clickOn(MainUILoggedinUserName);
		Thread.sleep(500);
		//WebElement MainUISignOut = driver.findElementByName("Sign out");
		WebElement MainUISignOut = driver.findElementByClassName("UIContextMenuButton");
	//	Thread.sleep(1000);
	//	clickOn(MainUISignOut);
		Thread.sleep(500);
		
		try{
			MainUISignOut.click();
			return new LoginPage();
		  }
		  catch(StaleElementReferenceException e){
			  MainUISignOut = driver.findElementByClassName("UIContextMenuButton"); 
			  MainUISignOut.click();
			  return new LoginPage();
		  }
			
		//return new LoginPage();
	}

	// Click the Admin Tile to navigate UserManagementPage
	public UserManagementPage ClickAdminTile_UMpage() throws InterruptedException, IOException {
		clickOn(MainUIAdminTile);
		Thread.sleep(500);
		return new UserManagementPage();
	}
	public AdministratorPage ClickAdminTile_Adminpage() throws InterruptedException, IOException {
        clickOn(MainUIAdminTile);
        Thread.sleep(500);
        return new AdministratorPage();
}

	// Click the Admin Tile to navigate PreferencesPage
	public PreferencesPage ClickAdminTile_Prefpage() throws InterruptedException, IOException {
		clickOn(MainUIAdminTile);
		Thread.sleep(1000);
		return new PreferencesPage();
	}
	
	// Click the Admin Tile to navigate PreferencesPage
	public PoliciesPage ClickAdminTile_Polpage() throws InterruptedException, IOException {
		clickOn(MainUIAdminTile);
		Thread.sleep(1000);
		return new PoliciesPage();
	}

	// Click the Admin Tile when SuperVisor does not have default access privilege
	public void ClickAdminTile() throws InterruptedException {
		clickOn(MainUIAdminTile);
		Thread.sleep(500);
	}

	// Click the Asset Tile
	public assetHubPage Click_AssetTile() throws InterruptedException, IOException {
		WebElement MainUIAssetTile = driver.findElementByName("Assets");
//		List<WebElement> assetList = driver.findElementsByAccessibilityId("TitleTextBlock");
//		
//		for(WebElement ass:assetList)
//		{
//			if(FetchText(ass).equalsIgnoreCase("Assets"))
//			{
//				Thread.sleep(2000);
//				clickOn(ass);
//				break;
//			}
//		}
		//.findElement(By.name("Assets"));
//		try
//		{
//			Thread.sleep(2000);
//			clickOn(MainUIAssetTile);
//		}
//		catch (Exception e) {
//			MainUIAssetTile = driver.findElementByName("Assets");
//			Thread.sleep(2000);
//			clickOn(MainUIAssetTile);
//		}
		Thread.sleep(2000);
		clickOn(MainUIAssetTile);
		return new assetHubPage();
	}

	// Click the Asset Tile
	public assetHubPage Click_AssetTile2() throws InterruptedException, IOException {
		WebElement MainUIAssetTile = driver.findElementByName("Assets");
		clickOn(MainUIAssetTile);
		Thread.sleep(500);
		return new assetHubPage();
	}

	// Fetch the Asset count data in the Asset Tile
	public String AssetCountInAssetTileOfMainHubPage() throws InterruptedException {
		String AstCnt = FetchText(AssetCountInfoInAsstTile);
		// System.out.println("AstCnt in Main Hub Page: "+AstCnt);
		return AstCnt;
	}
	//Fetch Text Equipment count From Equipement Tile
	public String EquipmentCntInEquipmentTileOfMainHubPage() throws InterruptedException {
		List<WebElement> eqpCoucnt = driver.findElementsByAccessibilityId("TitleCountTextBlock");
		return FetchText(eqpCoucnt.get(2));
	}
	
	// is MainUIEquipmentTitle visible
	public boolean IsEquipmentTile_Visible() {
		return IsElementVisibleStatus(MainUIEquipmentTitle);

	}

	// Click the Equipment Tile
	public EquipmentHubPage ClickEquipmentTile() throws InterruptedException, IOException {
		clickOn(MainUIEquipmentTitle);
		Thread.sleep(500);
		return new EquipmentHubPage();
	}
	
	// Fetch EquipmentDueCalibration_Count
	public String FetchTxt_EquipmentDueCalibration_Count(int j) throws InterruptedException, IOException {
		List<WebElement> Listcounts = driver.findElementByName("Equipment").findElements(By.className("TextBlock"));

		return Listcounts.get(j).getText();

	}


	// Click the Equipment Tile
	public FileManagementPage ClickFileManagementTitle() throws InterruptedException, IOException {
		clickOn(FileManagementTitle);
		
		return new FileManagementPage();
	}

	// Click the Audit Title
	public AuditPage ClickAuditTitle() throws InterruptedException, IOException {
		clickOn(AuditTitle);
		Thread.sleep(1000);
		return new AuditPage();
	}

	// Click the Audit Title
	public void Alert_AuditTitle() throws InterruptedException {
		clickOn(AuditTitle);
		Thread.sleep(500);
	}

	// click on connection btn
	public void click_connectBtn() {
		WebElement btnConnect = driver.findElementByAccessibilityId("btnConnect");
		waitForElementLoad(btnConnect, 100);
		clickOn(btnConnect);
	}
	
    public LoginPage signOut() throws InterruptedException, IOException
    {
                   WebElement ClickonSignout=driver.findElementByAccessibilityId("LoggedInUserButton");
                   clickOn(ClickonSignout);
                   Thread.sleep(5000);
                   
                   WebElement ele=driver.findElementByName("Sign out");
                   clickOn(ele);
                   return new LoginPage();
                   
    }



}
