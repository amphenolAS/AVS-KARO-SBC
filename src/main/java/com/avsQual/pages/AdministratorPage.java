package com.avsQual.pages;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebElement;

import com.avsQual.base.BaseClass;

public class AdministratorPage extends BaseClass {

	// Main Login Page Element definition
	WebElement Preferences = null;
	WebElement Policies = null;
	WebElement Administrator = null;
	WebElement AVSFIrmwareUpgrade = null;
	WebElement BackButton = null;

	private void initElements() {
		// LoginPage Page Element definition

		Preferences = driver.findElementByAccessibilityId("PreferencesButton");
		Policies = driver.findElementByAccessibilityId("PoliciesButton");
		Administrator = driver.findElementByAccessibilityId("UserManagementButton");
		AVSFIrmwareUpgrade = driver.findElementByAccessibilityId("FWUpgradeButton");
		BackButton = driver.findElementByAccessibilityId("ArrowGlyph");

	}

	public AdministratorPage() throws IOException {
		super();
		initElements();
	}

	// Release memory
	public void resetWebElements() 
	{

		Preferences = null;
		Policies = null;
		Administrator = null;
		AVSFIrmwareUpgrade = null;
		BackButton = null;
	}

	/*----------------------
	Methods of Main Login Page
	------------------------*/
	// click on usermanagemnt tile in usermanagement page
	public UserManagementPage click_UserMngmntTile() throws InterruptedException, IOException {
		clickOn(Administrator);
		Thread.sleep(500);
		return new UserManagementPage();
	}
	
	// Click on PoliciesHeaderText
	public PoliciesPage Click_Policy() throws IOException {
		clickOn(Policies);
		return new PoliciesPage();
	}
	
	public UserManagementPage ClickUserManagement_TAB() throws InterruptedException, IOException {
		clickOn(Administrator);
		return new UserManagementPage();
	}
	
}

