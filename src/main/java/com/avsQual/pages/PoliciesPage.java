package com.avsQual.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.avsQual.pages.LoginPage;
import com.avsQual.pages.MainHubPage;
import com.avsQual.pages.PreferencesPage;
import com.avsQual.pages.UserManagementPage;
import com.avsQual.base.BaseClass;

public class PoliciesPage extends BaseClass{
	// Page element variable declaration definition
		WebElement UMHeaderText = null;
		WebElement PoliciesHeaderText = null;
		WebElement PreferencesHeaderText = null;
		WebElement HWMaintenanceHeaderText = null;
		WebElement pwdcombobox = null;
		WebElement SaveBtn = null;
		WebElement Passwords = null;
		WebElement UserManagement_TAB = null;
		WebElement ExpirePasswordComboBox = null;
		WebElement LoginFailuresComboBox = null;
		WebElement DisplayUserIdEntryCheckBox = null;
		WebElement DisablePasswordSystemCheckBox = null;
		WebElement PasswordAplhaNumericSystemCheckBox = null;
		WebElement InstrumentCalibWarningCheckBox = null;
		WebElement AutoSyncOutCheckBox = null;
		WebElement BackButton = null;
		WebElement pwdcheckbox = null;
		WebElement ExpirePasswordCheckBox = null;
		WebElement DisableUserafterAttemptsCheckBox = null;
		WebElement Preferences_TAB = null;
		WebElement InstrumentCalibWarningComboBox = null;
		WebElement CancelButton = null;
		WebElement ReqMinLngthPswd=null;
		// Page element Initialize method
		private void initElements() {
			UMHeaderText = driver.findElementByName("User Management");
			PoliciesHeaderText = driver.findElementByAccessibilityId("PoliciesButton");
			PreferencesHeaderText = driver.findElementByAccessibilityId("PreferencesButton");		
			//pwdcombobox = driver.findElementByAccessibilityId("RequireMinLengthPassword_A_ID1");
			pwdcheckbox = driver.findElementByAccessibilityId("RequireMinLengthPasswordCheckBox");
			ExpirePasswordComboBox = driver.findElementByAccessibilityId("ExpirePasswordComboBox");
			ExpirePasswordCheckBox = driver.findElementByAccessibilityId("ExpirePasswordCheckBox");
			SaveBtn = driver.findElementByAccessibilityId("SaveButton");
			//Passwords = driver.findElementByName("Passwords");
			UserManagement_TAB = driver.findElementByAccessibilityId("UserManagementButton");
			Preferences_TAB = driver.findElementByAccessibilityId("PreferencesButton");
			LoginFailuresComboBox = driver.findElementByAccessibilityId("LoginFailuresComboBox");
			DisplayUserIdEntryCheckBox = driver.findElementByName("Display user id during entry");
			//DisablePasswordSystemCheckBox = driver.findElementByAccessibilityId("DisablePasswordSystemCheckBox");
			PasswordAplhaNumericSystemCheckBox = driver.findElementByAccessibilityId("PasswordAplhaNumericSystemCheckBox");
			ReqMinLngthPswd = driver.findElementByAccessibilityId("RequireMinLengthPasswordComboBox");
			//InstrumentCalibWarningCheckBox = driver.findElementByAccessibilityId("InstrumentCalibWarningCheckBox");
			AutoSyncOutCheckBox = driver.findElementByAccessibilityId("AutoSyncOutCheckBox");
			//BackButton = driver.findElementByAccessibilityId("ArrowGlyph");
			DisableUserafterAttemptsCheckBox = driver.findElementByAccessibilityId("DisableUserafterAttemptsCheckBox");
			//InstrumentCalibWarningComboBox = driver.findElementByAccessibilityId("InstrumentCalibWarning_A_ID3");
			CancelButton = driver.findElementByAccessibilityId("CancelButton");
			
		}

		// Constructor for initializing the page elements
		PoliciesPage() throws IOException {
			super();
			initElements();
		}

		// Release memory
		public void resetWebElements() {
			UMHeaderText = null;
			PoliciesHeaderText = null;
			PreferencesHeaderText = null;
			pwdcheckbox = null;
			ExpirePasswordCheckBox = null;
			DisableUserafterAttemptsCheckBox = null;
			Preferences_TAB = null;
			InstrumentCalibWarningComboBox = null;
			CancelButton = null;
			Passwords = null;
			UserManagement_TAB = null;
			ReqMinLngthPswd=null;
		}

		/*----------------------
		Methods of Policies Page
		------------------------*/
		
		// Check if UserManagement header tab is displayed & enabled
		public boolean IsUMHeaderTabEnabled() {
			return IsElementEnabledStatus(UMHeaderText);
		}
		
		// Check if Policies page is displayed
		public boolean IsPolicies_screenDisplayed() {

			//WebElement welcomeMessage = driver.findElement(By.xpath("//div[@class='welcome-message']"));
			return UMHeaderText.isDisplayed();
		}
		
		// Check if Preferences tab is Enabled
		public boolean IsPreferenceTab_Enabled() {
			return IsElementEnabledStatus(PreferencesHeaderText);
		}

		// Check if Preferences tab is Enabled
		public boolean IsHWMaintenanceTab_Enabled() {
			return IsElementEnabledStatus(HWMaintenanceHeaderText);
		}
		
		//Required Min Len Pass field is present
		public boolean is_ReqMinLenPswdSelected()
		{
			return checkboxSelectStatus(pwdcheckbox);
		}
		public boolean is_saveBtnEnabled()
		{
			return IsElementEnabledStatus(SaveBtn);
		}
		
		//Navigate to UM page
		public UserManagementPage click_UMHeader() throws IOException, InterruptedException {
			clickOn(UserManagement_TAB);
			Thread.sleep(1000);
			return new UserManagementPage();
		}
		
		// click on clickOn(pwdcombobox);
		public void PWDLengthBox_Click() throws InterruptedException {
			clickOn(ReqMinLngthPswd);
		}

		// FetchText from pwd char combobox
		public String pwdLengthcombobox_text() {
			
			return FetchText(ReqMinLngthPswd.findElement(By.className("TextBlock")));
		}

		// click on InstrumentCalibWarningComboBox
		public void Click_InstrumentCalibWarningComboBox() throws InterruptedException {
			clickOn(InstrumentCalibWarningComboBox);
		}

		// fetch text from InstrumentCalibWarningComboBox
		public String InstrumentCalibWarningComboBox_text() {
			return FetchText(InstrumentCalibWarningComboBox);

		}
		

		public void ICW_9Months() throws InterruptedException {
			Click_InstrumentCalibWarningComboBox();
			WebElement option1 = driver.findElementByName("9 Months");
			clickOn(option1);
		}

		// Select any minimum length pwd
		public void SelectAny_Option_FromPWDLengthBox(String CharLength) throws InterruptedException {
			String ch1 = pwdLengthcombobox_text();
			// System.out.println(ch1);
			String SPart = ch1.split(" ")[0];
			// System.out.println(SPart);

			PWDLengthBox_Click();
			PWDLengthBox_Click();
			Actions ac = new Actions(driver);

			if (CharLength.equals("6")) {
				Thread.sleep(1000);
				ClickSaveButton();
			} else {
				for (int i = 0; i <= 11; i++) {
					ac.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(1000);
					String ch2 = pwdLengthcombobox_text().split(" ")[0];
					// System.out.println(ch2);
					if (ch2.equals(CharLength)) {
						Thread.sleep(1000);
						break;
					}
				}
				Thread.sleep(1000);
				ClickSaveButton();
			}

		}
		
		public void SelectAny_OptionToTop_FromPWDLengthBox(String CharLength) throws InterruptedException {
			String ch1 = pwdLengthcombobox_text();
			// System.out.println(ch1);
			String SPart = ch1.split(" ")[0];
			// System.out.println(SPart);

			PWDLengthBox_Click();
			PWDLengthBox_Click();
			Actions ac = new Actions(driver);

			if (CharLength.equals("32")) {
				Thread.sleep(1000);
				ClickSaveButton();
			} else {
				for (int i = 0; i <= 11; i++) {
					ac.sendKeys(Keys.ARROW_UP).build().perform();
					Thread.sleep(1000);
					String ch2 = pwdLengthcombobox_text().split(" ")[0];
					// System.out.println(ch2);
					if (ch2.equals(CharLength)) {
						Thread.sleep(1000);
						break;
					}
				}
				Thread.sleep(1000);
				ClickSaveButton();
			}

		}

		// Is password combobox visible
		public boolean IspwdcomboboxVisible() {
			return IsElementVisibleStatus(pwdcombobox);
		}
		//default value for combobox
		public boolean is_DefaultPassLenDisplayed()
		{
			WebElement ele = driver.findElementByAccessibilityId("RequireMinLengthPasswordComboBox");
			return IsElementEnabledStatus(ele);
		}

		// Is LoginFailuresComboBox enable
		public boolean IsLoginFailuresComboBox_Enable() {
			return IsElementEnabledStatus(LoginFailuresComboBox);
		}

		// DisplayUserIdEntryCheckBox
		public boolean IsUserIdEntryCheckBoxVisible() {
			return IsElementEnabledStatus(DisplayUserIdEntryCheckBox);
		}

		public boolean IsUserIdEntryCheckBox_Enabled() {
			return checkboxSelectStatus(DisplayUserIdEntryCheckBox);
		}
		
		//AD Connceted status
		public boolean is_ADConnctStatusEnabled()
		{
			WebElement ele = driver.findElementByAccessibilityId("textblockConnStatus");
			return IsElementVisibleStatus(ele);
		}
		
		//Allow Guest Login Disabled
		public boolean guestLoginStatusEnabled()
		{
			WebElement ele = driver.findElementByAccessibilityId("AllowGuestloginCheckBox");
			return IsElementEnabledStatus(ele);
		}
		
		//User type disabled status
		public boolean is_UserisEnabled()
		{
			WebElement ele = driver.findElementByAccessibilityId("UserTypeComboBox");
			return IsElementEnabledStatus(ele);
		}
		
		//Syncin Policies, Audit and Active Directory User- Enabled
		public boolean is_SyncinPoliciesAdtADEnabled()
		{
			WebElement ele = driver.findElementByName("Browse");
			return IsElementEnabledStatus(ele);
		}
		
		//Sync in Button Eanabled status
		public boolean is_SyncInBtnEnabled()
		{
			WebElement ele = driver.findElementByName("SyncIn");
			return IsElementEnabledStatus(ele);
		}

//		public void UserIdEntryCheckBox_Status() throws InterruptedException {
//			if (checkboxSelectStatus(DisplayUserIdEntryCheckBox) == true) {
//				System.out.println("DisplayUserIdEntryCheckBox is selected");
//			} else {
//				clickOn(AllowDValueEditingCheckBox);
//				ClickSaveButton();
//			}
//		}

		// DisablePasswordSystemCheckBox
		public boolean IsPwdsystemcheckBoxVisible() {
			return IsElementEnabledStatus(DisablePasswordSystemCheckBox);
		}

		// PasswordAplhaNumericSystemCheckBox
		public boolean IsSpecialCharCheckBoxVisible() {

			return IsElementEnabledStatus(PasswordAplhaNumericSystemCheckBox);
		}
		
		public void deSelect_RequireSpecialCharacters() {
			clickOn(PasswordAplhaNumericSystemCheckBox);
		}

		// click PasswordAplhaNumericSystemCheckBox
		public void click_RequireSpecialCharacters() {
			//clickOn(PasswordAplhaNumericSystemCheckBox);
			if ( !PasswordAplhaNumericSystemCheckBox.isSelected() )
			{
				PasswordAplhaNumericSystemCheckBox.click();
			}
		}

		// InstrumentCalibWarningCheckBox
		public boolean IsInstrumentCalibWarningCheckBoxVisible() {
			return IsElementEnabledStatus(InstrumentCalibWarningCheckBox);
		}

		// ExpirePasswordComboBox is visible
		public boolean IsExpirePasswordComboBoxVisible() {
			return IsElementEnabledStatus(ExpirePasswordComboBox);
		}

		// AutoSyncOutCheckBox
		public boolean IsAutoSyncOutCheckBoxVisible() {
			return IsElementEnabledStatus(AutoSyncOutCheckBox);
		}
		//is cancel button is enabled
		public boolean is_CancelBttnEnabled()
		{
			return IsElementEnabledStatus(CancelButton);
		}

		public void EnterUID(String UN, String PW) {
			WebElement LgInUID = driver.findElementByAccessibilityId("UserIdTextBox");
			WebElement LgInPW = driver.findElementByAccessibilityId("PasswordTextBox");
			LgInUID.sendKeys(UN);
			LgInPW.sendKeys(PW);
		}

		// Click Save button
		public void ClickSaveButton() throws InterruptedException {
			Thread.sleep(1000);
			clickOn(SaveBtn);
		}

		// Click Cancel Button
		public void ClickCancelButton() throws InterruptedException {
			Thread.sleep(1000);
			
			clickOn(CancelButton);
		}

		// Click on um tab
		public UserManagementPage ClickUserManagement_TAB() throws InterruptedException, IOException {
			clickOn(UserManagement_TAB);
			return new UserManagementPage();
		}

		// Click on preference tab
		public PreferencesPage Clickpreference_TAB() throws InterruptedException, IOException {
			clickOn(Preferences_TAB);
			return new PreferencesPage();
		}
		
		public boolean is_DefaultReqMinLenPswd()
		{
			WebElement ele = driver.findElementByName("6 Characters");
			return IsElementVisibleStatus(ele);
		}
		
		public boolean UserLoginPopupVisible() throws InterruptedException {
			WebElement LgInPopup = driver.findElementByName("Enter User Credentials");
			return IsElementVisibleStatus(LgInPopup);
		}

		// click on BackButton
		public MainHubPage click_BackBtn() throws InterruptedException, IOException {
			BackButton = driver.findElementByAccessibilityId("ArrowGlyph");
			clickOn(BackButton);
			Thread.sleep(1000);
			return new MainHubPage();
		}

		// click on pwdcombobox for check/Uncheck combo box
		public void clickOn_PWDcheckbox() throws InterruptedException {
			if(!pwdcheckbox.isSelected())
			{
				pwdcheckbox.click();
			//clickOn(pwdcheckbox);
			Thread.sleep(1000);
			}
			//ClickSaveButton();
		}
		
		// click on pwdcombobox for check/Uncheck combo box
			public void deSelect_PWDcheckbox() throws InterruptedException {
				clickOn(pwdcheckbox);
				Thread.sleep(1000);
				
				//ClickSaveButton();
			}

		public void Enable_Editing_PWDcheckbox() throws InterruptedException {
			if (checkboxSelectStatus(pwdcheckbox) == true) {
				System.out.println("Min Length Password CheckBox is selected");
			} else {
				clickOn(pwdcheckbox);
				ClickSaveButton();
			}
		}

		public void Select_PWDcheckbox() throws InterruptedException {
			clickOn(pwdcheckbox);

		}
		
		//change value of required min length password
			public void change_ReqMinLenPswd() throws InterruptedException
			{
				//WebElement ele = driver.findElementByAccessibilityId("RequireMinLengthPasswordComboBox");
				clickOn(ReqMinLngthPswd);
				Thread.sleep(5000);
				WebElement ele = driver.findElementByName("7 Characters");
				clickOn(ele);
			}
			public void ClickOnReqMinLenPswd() throws InterruptedException
			{
				//WebElement ele = driver.findElementByAccessibilityId("RequireMinLengthPasswordComboBox");
				clickOn(ReqMinLngthPswd);
				Thread.sleep(500);
			}
			public void clickOnDefalutMinLenPas() throws InterruptedException
			{
				WebElement ele = driver.findElementByName("6 Characters");
			
				clickOn(ele);
			}

	//Get text of the Delete Alert message
		public String get_text_from_Alertpopup() {
			WebElement deleteAsset_popup = driver.findElementByAccessibilityId("Content_String");
			return deleteAsset_popup.getAttribute("Name");
		}

	//Fetch the  Alert message
		public String AlertMsg() {
			WebElement Msg = driver.findElementByAccessibilityId("displayMessageTextBlock");
			return FetchText(Msg);
		}

	//fetch text
		public String fetch_expirepwd_Defaulttext() {
			return ExpirePasswordComboBox.findElement(By.className("TextBlock")).getText();
		}

		public void SelectAny_Value_fromExpirePwd_DD(int index) throws InterruptedException {
			List<WebElement> options = driver.findElementByAccessibilityId("ExpirePasswordComboBox")
					.findElements(By.className("ComboBoxItem"));
			options.get(index).click();
			Thread.sleep(1000);
		//	ClickSaveButton();
		}

		public String FetchTxt_from_ExpirePwdDD(int index) throws InterruptedException {
			List<WebElement> options = driver.findElementByAccessibilityId("ExpirePasswordComboBox")
					.findElements(By.className("ComboBoxItem")); // TextBlock  UM.GE.NGV.DataObjects.DataContracts.ExpiredPasswordDaysMaster1

			return FetchText(options.get(index));
		}
		
	/*	public String getValue_from_ExpirePwDD()
		{
			List<WebElement> opt = driver.findElementByAccessibilityId("ExpirePasswordComboBox")
		  
		 				.findElements(By.className("ComboBoxItem"));  
			
			Select sel = new Select(driver.findElementByClassName("ComboBoxItem"));
			
			List list = new ArrayList();
			
			for(WebElement ele:sel.getOptions())
			{
				list.add(ele.getText());
			}  
			List list1 = new ArrayList();
			list1.add("1 Day");
			list1.add("90 Days");
			list1.add("180 Days");
			list1.add("366 Days");
			list1.add("730 Days");
			list1.add("1000 Days");
			
			for(int i = 0;i < )
			
		}   */

	//click On ExpirePasswordCheckBox
		public void click_ExpirePasswordCheckBox() throws InterruptedException {

			clickOn(ExpirePasswordCheckBox);
		}
		
		//Expire password is visible
		public boolean is_ExpirePswdCheckBoxVisible()
		{
			return IsElementVisibleStatus(ExpirePasswordCheckBox);
		}
		//Is default value from expire password is displayed 
		public boolean is_expirePswdDefaultValueDisplyed()
		{
			WebElement ele=driver.findElementByName("180 Days");
			return IsElementVisibleStatus(ele);
		}

		// DisableUserafterAttemptsCheckBox
		public void click_DisableUserafterAttemptsCheckBox() throws InterruptedException {

			clickOn(DisableUserafterAttemptsCheckBox);
		}

		//
		public void Select_From_LoginFailuresDD(int index) throws InterruptedException {

			clickOn(LoginFailuresComboBox);
			List<WebElement> options = driver.findElementByAccessibilityId("LoginFailuresComboBox")
					.findElements(By.className("ComboBoxItem"));
			options.get(index).click();
			Thread.sleep(1000);
			ClickSaveButton();
		}

		// Verify the Asset ID Field is enable or not

		public String UseID_Masked() {
			WebElement Idfield = driver.findElementByAccessibilityId("UserIdAsetrik");
			return Idfield.getAttribute("Value.Value");

		}

		public String Fetch_UseID() {
			WebElement Idfield = driver.findElementByAccessibilityId("UserIdTextBox");
			return Idfield.getAttribute("Value.Value");

		}

		// click on DisplayUserIdEntryCheckBox

		public void click_DisplayUserIdEntryCheckBox() {
			clickOn(DisplayUserIdEntryCheckBox);
		}

		// click on DisablePasswordSystemCheckBox

		public void click_DisablePasswordSystemCheckBox() {
			clickOn(DisablePasswordSystemCheckBox);
		}

		// click on yes or No btn in the alert message
		public LoginPage alertOptionYES() throws IOException {

			WebElement Yes_Alert_btn = driver.findElementByName("Yes");
			clickOn(Yes_Alert_btn);
			return new LoginPage();
		}

		public void clickalertYes() throws IOException {
			WebElement Yes_Alert_btn = driver.findElementByName("Yes");
			clickOn(Yes_Alert_btn);

		}

		// click on ExpirePasswordComboBox

		public void click_ExpirePasswordComboBox() {
			clickOn(ExpirePasswordComboBox);

		}
		
		//Active directory present status
		public boolean is_ADInfoPresent()
		{
			WebElement ele = driver.findElementByAccessibilityId("tgbLDAPUser");
			return IsElementVisibleStatus(ele);	
		}
		
		//Policy text present status
		public boolean is_PolicyInfoPresent()
		{
			WebElement ele=driver.findElementByName("Policies");
			return IsElementVisibleStatus(ele);
		}

		// Select Expire Password
		public void selectExpirePassword(String pw) throws InterruptedException {

			String pw1 = fetch_expirepwd_Defaulttext();
			String SPart = pw1.split(" ")[0];
			int val = Integer.parseInt(SPart);
			// System.out.println("ActPW: "+val);

			// String firstPart = pw.split(" ")[0];
			int val1 = Integer.parseInt(pw);
			// System.out.println("SetPW: "+val1);

			click_ExpirePasswordComboBox();
			click_ExpirePasswordComboBox();
			Actions ac = new Actions(driver);

			if (val1 < val) {
				for (int i = 0; i <= val; i++) {
					ac.sendKeys(Keys.ARROW_UP).build().perform();
					if (fetch_expirepwd_Defaulttext().split(" ")[0].equals(pw)) {
						Thread.sleep(1000);
						break;
					}
				}

			} else if (val1 > val) {
				for (int i = 0; i <= (368 - val); i++) {
					ac.sendKeys(Keys.ARROW_DOWN).build().perform();
					if (fetch_expirepwd_Defaulttext().split(" ")[0].equals(pw)) {
						Thread.sleep(1000);
						break;
					}
				}

			}
		}
		
		// Enable the  Instrument Calibration warning by clicking on Click_InstrumentCalibWarningCheckBox
		public void Enable_InstrumentCalibWarningCheckBox() throws InterruptedException {
			String InstruCalCheckBx_State =  InstrumentCalibWarningCheckBox.getAttribute("Toggle.ToggleState");
			//System.out.println(InstruCalCheckBx_State);
			//For enabling the Instru. Cal warning feature enter Yes as parameter
			if (InstruCalCheckBx_State.equals("0")) {
				clickOn(InstrumentCalibWarningCheckBox);
				ClickSaveButton();
				UserLoginPopup(getUID("adminFull"), getPW("adminFull"));
			}
			
		}
		
		// Disable the  Instrument Calibration warning by clicking on Click_InstrumentCalibWarningCheckBox
		public void Disable_InstrumentCalibWarningCheckBox() throws InterruptedException {
			String InstruCalCheckBx_State =  InstrumentCalibWarningCheckBox.getAttribute("Toggle.ToggleState");
			//System.out.println(InstruCalCheckBx_State);
			//For enabling the Instru. Cal warning feature enter Yes as parameter
			if (InstruCalCheckBx_State.equals("1")) {
				clickOn(InstrumentCalibWarningCheckBox);
				ClickSaveButton();
				UserLoginPopup(getUID("adminFull"), getPW("adminFull"));
			}
			
		}

}
