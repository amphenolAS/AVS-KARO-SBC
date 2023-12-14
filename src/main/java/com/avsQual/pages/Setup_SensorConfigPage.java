package com.avsQual.pages;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.avsQual.base.BaseClass;

public class Setup_SensorConfigPage extends BaseClass {

	// Sensor Configuration page element variable declaration definition
	private WebElement SensorConfigPageTitle = null;
	private WebElement SensorConfigPageHeaderTxt = null;
	private WebElement AddSensors_btn = null;
	private WebElement ConfigureSensors_btn = null;
	private WebElement DefineSetup_btn = null;
	private WebElement GroupSensors_btn = null;
	private WebElement SelectSensor = null;
	private WebElement ConfigureSensors =null;
	private WebElement PreviuosButton =null;

	private void initializeEelements() {
		SensorConfigPageTitle = driver.findElementByName("Sensors Configuration");
		SensorConfigPageHeaderTxt = driver.findElementByAccessibilityId("SetupHeaderTextBlock");
		//AddSensors_btn = driver.findElementByName("Add Sensors");
		ConfigureSensors_btn = driver.findElementByName("Configure Sensors");
		DefineSetup_btn = driver.findElementByName("Define Setup");
		GroupSensors_btn = driver.findElementByAccessibilityId("NextButton");
		SelectSensor = driver.findElementByName("Select Sensors");
		ConfigureSensors = driver.findElementByName("Configure Sensors");
		PreviuosButton = driver.findElementByAccessibilityId("PreviuosButton");
	}

	Setup_SensorConfigPage() throws IOException {
		super();
		initializeEelements();
	}

	// Release memory
	public void resetWebElements() {
		SensorConfigPageTitle = null;
		SensorConfigPageHeaderTxt = null;
		AddSensors_btn = null;
		ConfigureSensors_btn = null;
		DefineSetup_btn = null;
		GroupSensors_btn = null;
		SelectSensor = null;
		ConfigureSensors =null;
		PreviuosButton =null;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~
	// Sensor Config Page methods
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~

	// Check the presence of Sensor Configuration page
	public boolean sensorConfigPage_state() {
		return IsElementVisibleStatus(SensorConfigPageTitle);
	}

	// Check the presence of Define Setup name
	public boolean SensorConfig_setupname_state() {
		return IsElementVisibleStatus(SensorConfigPageHeaderTxt);
	}

	// Check the presence ofAdd Sensors_btn
	public boolean AddSensors_btn_state() {
		return IsElementVisibleStatus(AddSensors_btn);
	}

	// Check the presence of Configure Sensors_btn
	public boolean ConfigureSensors_btn_state() {
		return IsElementVisibleStatus(ConfigureSensors_btn);
	}

	// Check the presence of DefineSetup_btn
	public boolean DefineSetup_btn_state() {
		return IsElementVisibleStatus(DefineSetup_btn);
	}

	// Check the presence of GroupSensors_btn
	public boolean GroupSensors_btn_state() {
		return IsElementVisibleStatus(GroupSensors_btn);
	}

	// Click on GroupSensors_btn to capture alert message for null sensors
	public void Click_GroupSensors_btn() {
		clickOn(GroupSensors_btn);
	}
	
	//get Select Sensor and Configure Sensor location
	public boolean selectSensor_Loc()
	{
		int checkbox = SelectSensor.getLocation().getX();
		int pagewidth = driver.manage().window().getSize().width;
		boolean getLoc = (checkbox > (pagewidth/2));
		return getLoc;	
	}
	
	//get Select Sensor and Configure Sensor location
	public boolean configSensor_Loc()
	{
		int checkbox = ConfigureSensors.getLocation().getX();
		int pagewidth = driver.manage().window().getSize().width;
		boolean getLoc = (checkbox > (pagewidth/2));
		return getLoc;	
	}
	//

	// click GroupSensors_btn to navigate Group Sensors page
	public Setup_GroupSensorsPage Click_nextbtn() throws IOException {
		clickOn(GroupSensors_btn);
		return new Setup_GroupSensorsPage();
	}
	
	

	// click GroupSensors_btn to navigate Group Sensors page click YES (less number
	// of sensor config)
	public Setup_GroupSensorsPage Click_nextbtn_YesPopup() throws IOException {
		clickOn(GroupSensors_btn);

		WebElement Yes_Btn = driver.findElementByAccessibilityId("Button1");
		clickOn(Yes_Btn);
		return new Setup_GroupSensorsPage();
	}
	//click on previous button
	public Setup_defineSetupPage cllick_PreviousBtn() throws IOException
	{
		clickOn(PreviuosButton);
		
		return new Setup_defineSetupPage();
	}
	// While editing setup if user edit the temp count and click on next button
	// application will display two alert message
	// Click on Yes for first alert message i.e changing the existing sensor
	// configuration
	// then click yes for second alert message i.e Less number of sensors are
	// configured than the definied

	public Setup_GroupSensorsPage Click_nxtbtn_ForChangingExistingSC() throws IOException, InterruptedException {
		clickOn(GroupSensors_btn);
		Thread.sleep(2000);
		WebElement Yesbtn = driver.findElementByName("Yes");
		clickOn(Yesbtn);
		Thread.sleep(2000);
		WebElement Yesbtn1 = driver.findElementByName("Yes");
		clickOn(Yesbtn1);
		return new Setup_GroupSensorsPage();

	}

	// Fetch the alert text message for the less number of sensor configure

	public boolean Is_lessnumberSenAlertBox_Visible() {
		clickOn(GroupSensors_btn);
		WebElement alert_text = driver.findElementByName(
				"Less number of sensors are configured than the defined/added number of sensors. Is this Intentional ?");
		return IsElementVisibleStatus(alert_text);
	}

// Get the Sensor Configuration page title text
	public String get_SensorConfigurationPage_titletext() {
		return FetchText(SensorConfigPageHeaderTxt);
	}

	// Get the Sensor Configuration page text
	public String get_SensorConfigurationPage_text() {
		return FetchText(SensorConfigPageTitle);
	}

	// ExpanderImage_btn
	public void Click_Addsensors_Expanderbtn() {
		List<WebElement> ExpandArrow = driver.findElementsByClassName("Image");
		// System.out.println(ExpandArrow.size());
		ExpandArrow.get(0).click();
	}

	//Enter Mandatory Fields in SetUp Sensor Configpage
	public Setup_GroupSensorsPage enter_MandatoryFieldsinSSConfig(String TempCount, String TCSensorLabel) throws InterruptedException, IOException
	{
	Click_Addsensors_Expanderbtn();
	Enter_TemperatureCount_textField(TempCount);
	Click_Configurationsensors_Expanderbtn();
	select_Sensortype();
	Enter_Num_To(TempCount);
	Enter_SensorLabel(TCSensorLabel);
	Click_assignBtn();
	Click_nextbtn();
	 return new Setup_GroupSensorsPage();
	}
	// Check the presence of Temperature field
	public boolean Temperature_Field_state() {
		WebElement Temperature_Field = driver.findElementByName("Temperature #");
		return IsElementVisibleStatus(Temperature_Field);
	}

	
	// Check the presence of Humidity field
	public boolean Humidity_Field_state() {
		WebElement Humidity_Field = driver.findElementByName("Humidity #");
		return IsElementVisibleStatus(Humidity_Field);
	}

	// Check the presence of Pressure field
	public boolean Pressure_Field_state() {
		WebElement Pressure_Field = driver.findElementByName("Pressure #");
		return IsElementVisibleStatus(Pressure_Field);
	}

	// Check the presence of Add-Btn field
	public boolean selectBtn_Enabled() {
		WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
		return IsElementEnabledStatus(AddBtn_Field);
	} 
	public boolean selectBtn_Visibled() {
		WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
		return IsElementVisibleStatus(AddBtn_Field);
	} 
	//click on select button
	public void click_SelectBtn()
	{
		WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
		clickOn(AddBtn_Field);
	}
	//Select button is clickable
/*	public boolean selectBtn_Clickable()
	{
		if(selectBtn_Enabled()==true) {
		WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
		clickOn(AddBtn_Field);
		}
		return true;
	}*/
	
	public boolean Is_SensorLabelDescrVisible() {
		WebElement SensorLabelNum_field = driver.findElementByAccessibilityId("SensorLabelNumberTextBox");
		return IsElementVisibleStatus(SensorLabelNum_field);
	}
	//From drop down is displayed
	public boolean from_dropdownDisplayed()
	{
		WebElement frm_Drpdwn = driver.findElementByName("From");
		return IsElementVisibleStatus(frm_Drpdwn);
	}
	//From drop down is displayed
		public boolean to_dropdownDisplayed()
		{
			WebElement to_Drpdwn = driver.findElementByName("To");
			return IsElementVisibleStatus(to_Drpdwn);
		}
		
		//
	// Get the Temperature text
	public String get_Temperature_text() {
		List<WebElement> TextFields = driver.findElementsByClassName("TextBox");
		return FetchText(TextFields.get(0));

	}

	// Click on back btn
	public Setup_defineSetupPage DefineSetup_back_btn() throws IOException {
		clickOn(DefineSetup_btn);
		return new Setup_defineSetupPage();
	}

	// Get the Humidity text
	public String get_Humidity_text() {
		List<WebElement> TextFields = driver.findElementsByClassName("TextBox");
		return FetchText(TextFields.get(1));
	}

	// Get the Pressure text
	public String get_Pressure_text() {
		List<WebElement> TextFields = driver.findElementsByClassName("TextBox");
		return FetchText(TextFields.get(2));
	}

	// Enter Temp , press, Hmd all at a time and click add button
	public void Enter_AllSensortypes(String TempCount, String HmdCount, String PrsrCount) {
		List<WebElement> TextFields = driver.findElementsByClassName("TextBox");
		TextFields.get(0).clear();
		TextFields.get(0).sendKeys(TempCount);
		TextFields.get(1).clear();
		TextFields.get(1).sendKeys(HmdCount);
		TextFields.get(2).clear();
		TextFields.get(2).sendKeys(PrsrCount);
		WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
		clickOn(AddBtn_Field);
	}

	// Enter Temperature count to add Temp sensors
	public void Enter_TemperatureCount_textField(String TempCount) throws InterruptedException {
		List<WebElement> TextFields = driver.findElementsByClassName("TextBox");
		// System.out.println(TextFields.size());

		// Enter Temperature count data
		TextFields.get(0).clear();
		TextFields.get(0).sendKeys(TempCount);

		WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
		clickOn(AddBtn_Field);
	}

	// Enter Humidity count data
	public void Enter_HumidityCount_textField(String HmdCount) {
		List<WebElement> TextFields = driver.findElementsByClassName("TextBox");

		// Enter Humidity count data
		TextFields.get(1).clear();
		TextFields.get(1).sendKeys(HmdCount);

		WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
		clickOn(AddBtn_Field);

	}

	// Enter pressure count data
	public void Enter_PressureCount_textField(String PrsrCount) {
		List<WebElement> TextFields = driver.findElementsByClassName("TextBox");
		// System.out.println(TextFields.size());

		// Enter Pressure count data
		TextFields.get(2).clear();
		TextFields.get(2).sendKeys(PrsrCount);

		WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
		clickOn(AddBtn_Field);
	}
	
	

	// Check the presence of Header of Temperature sensors
	public boolean Temperature_Sensor_Titlestate() {
		WebElement Temperature_Sensor_title = driver.findElementByName("Temperature");
		// return IsElementVisibleStatus(Temperature_Sensor_title);
		return Temperature_Sensor_title.isDisplayed();
	}

	// Check the presence of Humidity sensors
	public boolean Humidity_Sensor_Titlestate() {
		WebElement Humidity_Sensor_title = driver.findElementByName("Humidity");
		return IsElementVisibleStatus(Humidity_Sensor_title);
	}

	// Check the presence of Pressure sensors
	public boolean Pressure_Sensor_Titlestate() {
		WebElement Pressure_Sensor_title = driver.findElementByName("Pressure");
		return IsElementVisibleStatus(Pressure_Sensor_title);
	}

	// Total Sensors created
	public String[] SensorCount() {
		List<WebElement> sensorList = driver.findElementByName("ValProbe RT")
				.findElements(By.className("GridViewItem"));
		// System.out.println("Total sensors created: " + sensorList.size());
		String[] a = null;
		return a;

	}

	// Total Sensors details
	public String[] SensorDetails() {
		List<WebElement> sensorList = driver.findElementByName("ValProbe RT")
				.findElements(By.className("GridViewItem"));
		String[] a = null;

		for (int i = 0; i < sensorList.size(); i++) {
			// System.out.println("Sensor type : " + AssetList.get(i).getText());
			List<WebElement> SensorTileInfoList = sensorList.get(i).findElements(By.className("TextBlock"));
			// System.out.println(" Sensor tile count: " + SensorTileInfoList.size());

			// Fetch all the contents of the tile
			for (int j = 0; j < SensorTileInfoList.size(); j++) {
				// System.out.println("SensorTileInfo: " + SensorTileInfoList.get(j).getText());
			}
		}

		return a;
	}

	// Check the presence of VerticalScrollBar field
	public boolean IsDisplayingVerticalScrollBar() {
		WebElement Vertical_ScrollBar = driver.findElementByAccessibilityId("VerticalScrollBar");
		return IsElementVisibleStatus(Vertical_ScrollBar);
	}

	// Click on Temperature filter
	public void Clickon_Temperature() {
		WebElement btn_Temperature = driver.findElementByAccessibilityId("btnTemperature");
		clickOn(btn_Temperature);
	}

	// Is Temperature filters sensors label visible
	public boolean Temperature_filters() {
		WebElement btn_Temperature = driver.findElementByAccessibilityId("btnTemperature");
		clickOn(btn_Temperature);
		WebElement label_Temperature = driver.findElementByName("Temperature");
		return IsElementVisibleStatus(label_Temperature);
	}

	// click sensors from Temperature filter
	public void Click_Temp_sensor() {
		// WebElement temp_senr = driver.findElementByName("Sensor 1");
		List<WebElement> Tmpsenr = driver.findElementsByClassName("GridViewItem");
		Tmpsenr.get(0).click();
	}

	// Get sensor text
	public String get_sensortext() {
		List<WebElement> senrList = driver.findElementByName("VRT.DataObjects.DataContracts.VRTSensors")
				.findElements(By.className("TextBlock"));
		return FetchText(senrList.get(0));
	}

	// click 2nd sensor from Temperature filter
	public void Click_Temp_sensor2() {
		// WebElement temp_senr = driver.findElementByName("Sensor 1");
		List<WebElement> Tmpsenr = driver.findElementsByClassName("GridViewItem");
		Tmpsenr.get(1).click();
	}

	// click Multiple sensors from Temperature filter
	public void Click_Temp_sensor_Multi() {
		// WebElement temp_senr = driver.findElementByName("Sensor 1");
		List<WebElement> Tmpsenr = driver.findElementsByClassName("GridViewItem");
		Tmpsenr.get(0).click();
		Tmpsenr.get(1).click();
		Tmpsenr.get(2).click();
		Tmpsenr.get(3).click();
		Tmpsenr.get(4).click();
	}

	// Click on Humidity filters
	public void Clickon_Humidity() {
		WebElement btn_Humidity = driver.findElementByAccessibilityId("btnHumidity");
		clickOn(btn_Humidity);
	}

	// click sensors from Humidity filter
	public void Click_Hmd_sensor() {
		// WebElement temp_senr = driver.findElementByName("Sensor 1");
		List<WebElement> Hmdsenr = driver.findElementsByClassName("GridViewItem");
		Hmdsenr.get(0).click();

	}

	// click Multiple sensors from Humidity filter
	public void Click_Hmd_sensor_Multi() {
		// WebElement temp_senr = driver.findElementByName("Sensor 1");
		List<WebElement> Hmdsenr = driver.findElementsByClassName("GridViewItem");
		Hmdsenr.get(0).click();
		Hmdsenr.get(1).click();
		Hmdsenr.get(2).click();

	}
	/*
	 * //Fetch humidity sensor text public String get_Hmd_sensortext() {
	 * List<WebElement> Hmdsenr =
	 * driver.findElementByName("VRT.DataObjects.DataContracts.VRTSensors").
	 * findElements(By.className("TextBlock")); //List<WebElement> Hmdsenr =
	 * driver.findElementsByClassName("TextBlock"); Hmdsenr.get(0).click(); return
	 * FetchText(Hmdsenr.get(0)); }
	 */

	// Is Humidity filters sensors label visible
	public boolean Humidity_filters() {
		WebElement btn_Humidity = driver.findElementByAccessibilityId("btnHumidity");
		clickOn(btn_Humidity);
		WebElement label_Humidity = driver.findElementByName("Humidity");
		return IsElementVisibleStatus(label_Humidity);
	}

	// Click on Pressure

	public void Click_Pressure() {
		WebElement btn_Pressure = driver.findElementByAccessibilityId("btnPressure");
		clickOn(btn_Pressure);
	}

	// Click on Pressure filters
	public void Click_Prsr_sensor() {
		List<WebElement> Prsrsenr = driver.findElementsByClassName("GridViewItem");
		Prsrsenr.get(0).click();

	}

	// click Multiple sensors from Pressure filter
	public void Click_Psr_sensor_Multi() {
		// WebElement temp_senr = driver.findElementByName("Sensor 1");
		List<WebElement> Hmdsenr = driver.findElementsByClassName("GridViewItem");
		Hmdsenr.get(0).click();
		Hmdsenr.get(1).click();
		Hmdsenr.get(2).click();

	}

	// Is Pressure filters sensors label visible
	public boolean Pressure_filters() {
		WebElement btn_Pressure = driver.findElementByAccessibilityId("btnPressure");
		clickOn(btn_Pressure);
		WebElement label_Pressure = driver.findElementByName("Pressure");
		return IsElementVisibleStatus(label_Pressure);
	}

	// Configuration sensors Expander
	public void Click_SelectSen_Expanderbtn() {
		List<WebElement> ExpandArrow = driver.findElementsByAccessibilityId("ExpanderImage");
		// System.out.println(ExpandArrow.size());
		ExpandArrow.get(0).click();
	}
	//public void sensor To combo box
	public void from_ToSensorComboBox()
	{
		WebElement combobox = driver.findElementByAccessibilityId("ToSensorComboBox");
		clickOn(combobox);
	}
	
	//public void sensor To combo box
		public void from_fromSensorComboBox()
		{
			WebElement combobox = driver.findElementByAccessibilityId("FromSensorComboBox");
			clickOn(combobox);
		}
	
	// Configuration sensors Expander
		public void Click_Configurationsensors_Expanderbtn() {
			List<WebElement> ExpandArrow = driver.findElementsByAccessibilityId("ExpanderImage");
			// System.out.println(ExpandArrow.size());
			ExpandArrow.get(1).click();
		}
		//fetch text from select sensor
		public String SelectfromSensor_text()
		{
			WebElement AddBtn_Field = driver.findElementByAccessibilityId("FromSensorComboBox"); 
					
			return FetchText(AddBtn_Field.findElement(By.className("ComboBoxItem")));
		} 
		public boolean selectOPtionfromSensor()
		{

			List<WebElement> AddBtn_Field = driver.findElementsByClassName("ComboBoxItem");
			
			return IsElementVisibleStatus( AddBtn_Field.get(0));
			
			
			
			//AddBtn_Field.getz
		}
		
		public String SelectToSensor_text()
		{
			WebElement AddBtn_Field = driver.findElementByAccessibilityId("ToSensorComboBox");
					
			return FetchText(AddBtn_Field.findElement(By.className("ComboBoxItem")));
		}
		
	// Select Sensors i.e., To
		public void SelectAny_Option_ToSelectSensor(String CharLength) throws InterruptedException {
			String ch1 = SelectToSensor_text();
			// System.out.println(ch1);
		//	String SPart = ch1.split(" ")[1];
			// System.out.println(SPart);     

			from_ToSensorComboBox();
			from_ToSensorComboBox();
			Actions ac = new Actions(driver);

		//	if (CharLength.equals("Select")) {
			if (CharLength.equals("Sensor 1")) {
				Thread.sleep(1000);
				WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
				clickOn(AddBtn_Field);
			} else {
				for (int i = 0; i <= 11; i++) {
					ac.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(1000);
					String ch2 = SelectToSensor_text();
				//	String SPart1 = ch2.split(" ")[1];
					// System.out.println(ch2);
					if (CharLength.equals(ch2)) {
						Thread.sleep(1000);
						break;
					}
				}
				Thread.sleep(1000);
				WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
				clickOn(AddBtn_Field);
			}  		

		} 
		// Select Sensors i.e., To
				public void SelectAny_Option_FomSelectSensor(String CharLength) throws InterruptedException {
					String ch1 = SelectfromSensor_text();
					// System.out.println(ch1);
					//String SPart = ch1.split(" ")[1];
					
					// System.out.println(SPart);     

					from_fromSensorComboBox();
					from_fromSensorComboBox();
					Actions ac = new Actions(driver);

					if (CharLength.equals("Sensor 1")) {
						Thread.sleep(1000);
					//	WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
					//	clickOn(AddBtn_Field);
						System.out.println("Default Value is Select");
					} else {
						for (int i = 0; i <= 11; i++) {
						
							ac.sendKeys(Keys.ARROW_DOWN).build().perform();
							Thread.sleep(1000);
							String ch2 = SelectfromSensor_text();
						//	String SPart1 = ch2.split(" ")[1];
							// System.out.println(ch2);
							if (CharLength.equals(ch2)) {
								Thread.sleep(1000);
								break;
							}
						
						}
				//		Thread.sleep(1000);
				//		WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
				//		clickOn(AddBtn_Field);
					}
				}

		/*			from_fromSensorComboBox();
					List<WebElement> options = driver.findElementByAccessibilityId("FromSensorComboBox")
					.findElements(By.className("ComboBoxItem"));
					options.get(index).click(); */

	//if the value is select from select sensor
				public void SelectasDefault_FomSelectSensor(String CharLength) throws InterruptedException {
					String ch1 = SelectfromSensor_text();
					// System.out.println(ch1);
					//String SPart = ch1.split(" ")[1];
					
					// System.out.println(SPart);     

					from_fromSensorComboBox();
					from_fromSensorComboBox();
					Actions ac = new Actions(driver);

					if (CharLength.equals("Select")) {
						Thread.sleep(1000);
						WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
						clickOn(AddBtn_Field);
						
					} else {
					//	if(selectOPtionfromSensor()==true)
					//	{
						for (int i = 0; i <= 11; i++) {
						
							ac.sendKeys(Keys.ARROW_DOWN).build().perform();
							Thread.sleep(1000);
							String ch2 = SelectfromSensor_text();
						//	String SPart1 = ch2.split(" ")[1];
							// System.out.println(ch2);
							if (CharLength.equals(ch2)) {
								Thread.sleep(1000);
								break;
							}
						}
						
					}
				}
				
				//if the value is select from select sensor
				public void SelectasDefault_ToSelectSensor(String CharLength) throws InterruptedException {
					String ch1 = SelectfromSensor_text();
					// System.out.println(ch1);
					//String SPart = ch1.split(" ")[1];
					
					// System.out.println(SPart);     

					from_ToSensorComboBox();
					from_ToSensorComboBox();
					Actions ac = new Actions(driver);

					if (CharLength.equals("Select")) {
						Thread.sleep(1000);
					//	WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
					//	clickOn(AddBtn_Field);
						System.out.println("Default Value is Select");
					} else {
						for (int i = 0; i <= 11; i++) {
						
							ac.sendKeys(Keys.ARROW_DOWN).build().perform();
							Thread.sleep(1000);
							String ch2 = SelectToSensor_text();
						//	String SPart1 = ch2.split(" ")[1];
							// System.out.println(ch2);
							if (CharLength.equals(ch2)) {
								Thread.sleep(1000);
								break;
							}
						
						}
						Thread.sleep(1000);
						WebElement AddBtn_Field = driver.findElementByAccessibilityId("SelectButton");
						clickOn(AddBtn_Field);
					}
				}
				
				
	// Is Sensor Type visible
	public boolean IsSensortypevisible() {
		WebElement Sensortype_state = driver.findElementByName("Sensor Type");
		return IsElementVisibleStatus(Sensortype_state);
	}

	// Is SensorType field Enable
	public boolean IsSensortype_Enable() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		return IsElementEnabledStatus(Sensortype_field);
	}
	// Is SensorType field Enable
	public boolean IsSensortype_VisibleState() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		return IsElementVisibleStatus(Sensortype_field);
		}
	//Fetch Text i.e, from sim1
	public String dfltvalue_fromSim1()
	{
		WebElement ele_fromSim1 = driver.findElementByAccessibilityId("FromSimComboBox");
		return FetchText(ele_fromSim1);
	}
	
	//Click SIM i.e., From combo box
	public void click_FromSim()
	{
		WebElement ele_fromSim1 = driver.findElementByAccessibilityId("FromSimComboBox");
		clickOn(ele_fromSim1);
	}
	
	//Click SIM i.e., From combo box
		public void select_FromSim(int index)
		{
			click_FromSim();
			List<WebElement> options = driver.findElementByAccessibilityId("FromSimComboBox")
					.findElements(By.className("ComboBoxItem"));
			options.get(index).click();
		}
		
		//from SIM is enabled or not
		public boolean from_SIM_Enabaled()
		{
			WebElement ele_fromSim = driver.findElementByAccessibilityId("FromSimComboBox");
			return IsElementEnabledStatus(ele_fromSim);
		}
		public boolean from_SIM_Visibled()
		{
			WebElement ele_fromSim = driver.findElementByAccessibilityId("FromSimComboBox");
			return IsElementVisibleStatus(ele_fromSim);
		}
		//from Sensor is enabled
		public boolean from_Sensor_Enabaled()
		{
			WebElement ele_fromSensor = driver.findElementByAccessibilityId("FromSensorComboBox");
			return IsElementEnabledStatus(ele_fromSensor);
		}
		public boolean from_Sensor_Visibled()
		{
			WebElement ele_fromSensor = driver.findElementByAccessibilityId("FromSensorComboBox");
			return IsElementVisibleStatus(ele_fromSensor);
		}
		//To Sim is enabled
		public boolean to_SIM_Enabaled()
		{
			WebElement ele_ToSim = driver.findElementByAccessibilityId("ToSimComboBox");
			return IsElementEnabledStatus(ele_ToSim);
		}
		public boolean to_SIM_Visibl()
		{
			WebElement ele_ToSim = driver.findElementByAccessibilityId("ToSimComboBox");
			return IsElementVisibleStatus(ele_ToSim);
		}
		
		public boolean to_Sensor_Enabaled()
		{
			WebElement ele_ToSensor = driver.findElementByAccessibilityId("ToSensorComboBox");
			return IsElementEnabledStatus(ele_ToSensor);
		}
		public boolean to_Sensor_Visible()
		{
			WebElement ele_ToSensor = driver.findElementByAccessibilityId("ToSensorComboBox");
			return IsElementVisibleStatus(ele_ToSensor);
		}
		//Click SIM i.e., To combo box
		public void click_ToSim()
		{
			WebElement ele_toSim1 = driver.findElementByAccessibilityId("ToSimComboBox");
			clickOn(ele_toSim1);
		}
		
		//Click SIM i.e., From combo box
			public void select_ToSim(int index)
			{
				click_ToSim();
				
				List<WebElement> options = driver.findElementByAccessibilityId("ToSimComboBox")
						.findElements(By.className("ComboBoxItem"));
				options.get(index).click();
			}
	// Fetch Text i.e, from sensor1
	public String dfltvalue_fromSens1()
	{
		WebElement ele_fromSensr1 = driver.findElementByAccessibilityId("FromSensorComboBox");
		return FetchText(ele_fromSensr1);
	}
	// Fetch the sensor type text
	public String get_Sensortype_text() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		return FetchText(Sensortype_field);
	}

	// Click on sensor type field
	public void Click_Sensortype_field() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
	}

	// SIM Grid View
/*	public boolean is_SimSelected()
	{
		List<WebElement> gridView_Item = driver.findElementByAccessibilityId("Set1TextTileLandingGrid")
				.findElements(By.className("GridViewItem"));
	
		//gridView_Item.get(0);
			return checkboxSelectStatus(gridView_Item.get(0));
		
	}*/
	
	public boolean is_SimSensorSelected(int num)
	{
		List<WebElement> gridView_Item = driver.findElementByAccessibilityId("Set1TextTileLandingGrid")
				.findElements(By.className("GridViewItem"));
		
		List<WebElement> selectedCheckboxes = new ArrayList<WebElement>();

		for (WebElement checkbox : gridView_Item) {
		    if (checkboxSelectStatus(checkbox)) {
		        selectedCheckboxes.add(checkbox);
		    }
		}
		int expectedNumSelected = num; // replace with your expected number of selected checkboxes
	//	if (selectedCheckboxes.size() == expectedNumSelected) {	
	//		return true;
			
	//	}
		//return checkboxSelectStatus(selectedCheckboxes.get(num));
		return (selectedCheckboxes.size() == expectedNumSelected);
	}
	
	public int is_TotalSelectedSimS()
	{
		List<WebElement> gridView_Item = driver.findElementByAccessibilityId("Set1TextTileLandingGrid")
				.findElements(By.className("GridViewItem"));
		
		List<WebElement> selectedCheckboxes = new ArrayList<WebElement>();
		int cnt = 0;
		for (WebElement checkbox : gridView_Item) {
		    if (checkboxSelectStatus(checkbox)) {
		     cnt++;   
		    }
		}
		return cnt;
	}
	
	
	// click on already selected grid item
	
			public void click_SelectedSen()
			{
				List<WebElement> gridView_Item = driver.findElementByAccessibilityId("Set1TextTileLandingGrid")
						.findElements(By.className("GridViewItem"));
				
				for (WebElement checkbox : gridView_Item) {
				    if (checkboxSelectStatus(checkbox)) {
				    	clickOn(checkbox);
				    }
				}
			}
			
			public void click_SelectedSenBasedOnReq(int index)
			{
				List<WebElement> gridView_Item = driver.findElementByAccessibilityId("Set1TextTileLandingGrid")
						.findElements(By.className("GridViewItem"));
				
				clickOn(gridView_Item.get(index));
			/*	for (WebElement checkbox : gridView_Item) {
				    if (checkboxSelectStatus(checkbox)) {
				    	//clickOn(gridView_Item.get(index));
				    	clickOn(checkbox.getcheckbox);
				    }
				} */
			}
			
	public String get_TextfromSelectedGrisItem(int index)
	{
		List<WebElement> gridView_Item = driver.findElementByAccessibilityId("Set1TextTileLandingGrid")
				.findElements(By.className("TextBlock"));
		return FetchText(gridView_Item.get(index));
	}
	public void click_OnThermoCouple()
	{
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("TextBlock"));
		 clickOn(Thermocouple.get(1));
	}
	public void click_OnVoltage()
	{
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("TextBlock"));
		 clickOn(Thermocouple.get(3));
	}
	public void click_OnmilliAmp()
	{
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("TextBlock"));
		 clickOn(Thermocouple.get(4));
	}
	//context click
	public void context_Click() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.contextClick().build().perform();
		
		WebElement cntxt_Ele = driver.findElementByAccessibilityId("HelpAppBarButton");
		Thread.sleep(500);
		clickOn(cntxt_Ele);
	}
	public String get_TextFromHelpWindow()
	{
		WebElement HelpTxt = driver.findElementByAccessibilityId("helpRichTextBlock");
		return FetchText(HelpTxt);
	}
	public boolean help_TextVisible()
	{
		WebElement helpButton = driver.findElementByAccessibilityId("helpFlyout");
		return IsElementVisibleStatus(helpButton);
	}
	public String mA_Options(int index)
	{
		List<WebElement> voltage = driver.findElementByAccessibilityId("SubList")
				.findElements(By.className("TextBlock"));
		return FetchText(voltage.get(index));
	}
	public String voltge_Options(int index)
	{
		List<WebElement> voltage = driver.findElementByAccessibilityId("SubList")
				.findElements(By.className("TextBlock"));
		return FetchText(voltage.get(index));
	}
	public boolean sensorType_Undefined_Visible()
	{
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("TextBlock"));
		return IsElementVisibleStatus(Thermocouple.get(0));
	}
	
	public boolean sensorType_Thermocouple_Visible()
	{
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("TextBlock"));
		return IsElementVisibleStatus(Thermocouple.get(1));
	}
	
	public String thermocouple_Option(int index)
	{
	//	List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
	//			.findElements(By.className("TextBlock"));
	//	Thermocouple.get(1).click();
		List<WebElement> subList = driver.findElementByAccessibilityId("SubList")
				.findElements(By.className("TextBlock"));
		return FetchText(subList.get(index));
		
	}
	public boolean sensorType_PT100_Visible()
	{
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("TextBlock"));
		return IsElementVisibleStatus(Thermocouple.get(2));
	}
	public boolean sensorType_0to10v_Visible()
	{
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("TextBlock"));
		return IsElementVisibleStatus(Thermocouple.get(3));
	}
	public void click_sensorType_PressureV()
	{
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		
		List<WebElement> voltage_sen = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("ListBoxItem"));
		voltage_sen.get(3).click();
	
		List<WebElement> pressure = driver.findElementByAccessibilityId("SubList")
				.findElements(By.className("ListBoxItem"));
		pressure.get(1).click();

	}
	public void click_sensorType_Voltage()
	{
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		
		List<WebElement> voltage_sen = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("ListBoxItem"));
		voltage_sen.get(3).click();
	
		List<WebElement> pressure = driver.findElementByAccessibilityId("SubList")
				.findElements(By.className("ListBoxItem"));
		pressure.get(0).click();

	}
	public void click_sensorType_PressuremA()
	{
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		
		List<WebElement> voltage_sen = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("ListBoxItem"));
		voltage_sen.get(4).click();
	
		List<WebElement> pressure = driver.findElementByAccessibilityId("SubList")
				.findElements(By.className("ListBoxItem"));
		pressure.get(1).click();

	}
	public boolean min_InputEnablestate()
	{
		WebElement min_In = driver.findElementByAccessibilityId("InputMinTextBox");
		return IsElementEnabledStatus(min_In);
	}
	public boolean max_InputEnablestate()
	{
		WebElement max_In = driver.findElementByAccessibilityId("InputMaxTextBox");
		return IsElementEnabledStatus(max_In);
	}
	public boolean min_OutputEnablestate()
	{
		WebElement min_Out = driver.findElementByAccessibilityId("OutputMinTextBox");
		return IsElementEnabledStatus(min_Out);
	}
	public boolean max_OutputEnablestate()
	{
		WebElement max_Out = driver.findElementByAccessibilityId("OutputMaxTextBox");
		return IsElementEnabledStatus(max_Out);
	}
	public void enter_min_Input(String value)
	{
		WebElement min_In = driver.findElementByAccessibilityId("InputMinTextBox");
		clickOn(min_In);
		ClearText(min_In);
		enterText(min_In, value);
	}
	
	public String get_MinIpValue(String getattrval)
	{
		WebElement min_In = driver.findElementByAccessibilityId("InputMinTextBox");
		min_In.getAttribute(getattrval);
	//	System.out.println(min_In);
		return FetchText(min_In);
	}
	public String get_MinOPValue(String getattrval)
	{
		WebElement min_Out = driver.findElementByAccessibilityId("OutputMinTextBox");
		min_Out.getAttribute(getattrval);
	//	System.out.println(min_In);
		return FetchText(min_Out);
	}
	public String get_MaxIpValue(String getattrval)
	{
		WebElement max_In = driver.findElementByAccessibilityId("InputMaxTextBox");
		max_In.getAttribute(getattrval);
	//	System.out.println(min_In);
		return FetchText(max_In);
	}
	public String get_MaxOPValue(String getattrval)
	{
		WebElement max_Out = driver.findElementByAccessibilityId("OutputMaxTextBox");
		max_Out.getAttribute(getattrval);
	//	System.out.println(min_In);
		return FetchText(max_Out);
	}
	public void click_DownArrow() throws InterruptedException
	{
		WebElement arrow = driver.findElementByAccessibilityId("VerticalSmallIncrease");
		
		int scrollableheight = arrow.getSize().getHeight();
	
		Actions act = new Actions(driver);
		for(int i=0;i<=scrollableheight;i++)
		{
			act.sendKeys(Keys.ARROW_DOWN).build().perform();
			while(scrollableheight == arrow.getSize().getHeight()) {
				
				break;
			}
		} 
		
		/*	Actions act = new Actions(driver);
		while(scrollableheight>0)
		{
			act.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);
			
			if(scrollableheight == arrow.getSize().getHeight());
			{
				break;
			}
		} */
	}
	
	public void click_UpArrow() throws InterruptedException
	{
		WebElement arrow = driver.findElementByAccessibilityId("VerticalSmallDecrease");
		
		int scrollableheight = arrow.getSize().getHeight();
	
		Actions act = new Actions(driver);
		for(int i=0;i<=scrollableheight;i++)
		{
			act.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(500);
			while(scrollableheight == arrow.getSize().getHeight())
			{
				break;
			}
		} 
	}
	public void enter_min_Output(String value)
	{
		WebElement min_Out = driver.findElementByAccessibilityId("OutputMinTextBox");
		clickOn(min_Out);
		ClearText(min_Out);
		enterText(min_Out, value);
	}
	public void enter_max_Output(String value)
	{
		WebElement max_Out = driver.findElementByAccessibilityId("OutputMaxTextBox");
		clickOn(max_Out);
		ClearText(max_Out);
		enterText(max_Out, value);
	}
	public void enter_max_Input(String value)
	{
		WebElement max_Ip = driver.findElementByAccessibilityId("InputMaxTextBox");
		clickOn(max_Ip);
		ClearText(max_Ip);
		enterText(max_Ip, value);
	}
	public boolean is_OutputUnitEnabled()
	{
		WebElement op_Unit = driver.findElementByAccessibilityId("OutputUnitsTextBox");
		return checkboxSelectStatus(op_Unit);
		//return IsElementEnabledStatus(op_Unit);
	}
	public void click_outputUnit()
	{
		WebElement op_Unit = driver.findElementByAccessibilityId("OutputUnitsTextBox");
		clickOn(op_Unit);
	}
	public void enter_outputUnit(String value)
	{
		WebElement op_Unit = driver.findElementByAccessibilityId("OutputUnitsTextBox");
		enterText(op_Unit, value);
	}
	public String  get_outputUnit(String value)
	{
		WebElement op_Unit = driver.findElementByAccessibilityId("OutputUnitsTextBox");
		op_Unit.getAttribute(value);
		return FetchText(op_Unit);
	}
	public boolean UnitVisiblesatate()
	{
		WebElement Unit = driver.findElementByName("Units");
		return IsElementVisibleStatus(Unit);
	}
	public boolean sensorType_4to20mA_Visible()
	{
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("TextBlock"));
		return IsElementVisibleStatus(Thermocouple.get(4));
	}
	public boolean sensorType_Contacts_Visible()
	{
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("TextBlock"));
		return IsElementVisibleStatus(Thermocouple.get(5));
	}
	// Click on temp from sensortype   //ListBoxItem
	public void select_Sensortype() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("ListBoxItem"));
		Thermocouple.get(1).click();
	
		List<WebElement> Thermocouplelist = driver.findElementByAccessibilityId("SubList")
				.findElements(By.className("ListBoxItem"));
		Thermocouplelist.get(0).click();
		//clickOn(Thermocouple);
		// Thermocoupletype = driver.findElementsByName(");
	}

	public void click_SensortypePT100() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("ListBoxItem"));
		Thermocouple.get(2).click();
	}
	public void click_SensortypeisContact() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		
		List<WebElement> Thermocouple = driver.findElementByAccessibilityId("MainList")
				.findElements(By.className("ListBoxItem"));
		Thermocouple.get(5).click();
	}
	// Is Temp visible under sensor type drop down list
	public boolean IsTemperature_visible_Drpdwnlist() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		WebElement tempInlist = driver.findElementByName("Temperature     (°C)");
		return IsElementVisibleStatus(tempInlist);
	}

	// Click on Humidity from sensor type
	public void select_Sensortype_Hmd() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		WebElement HmdInlist = driver.findElementByName("Humidity     (%RH)");
		clickOn(HmdInlist);
	}

	// Is Humidity visible under sensor type drop down list
	public boolean IsHumidity_visible_Drpdwnlist() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		WebElement HmdInlist = driver.findElementByName("Humidity     (%RH)");
		return IsElementVisibleStatus(HmdInlist);
	}

	// Is Pressure visible under sensor type drop down list
	public boolean IsPressure_visible_Drpdwnlist() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		WebElement PrsrInlist = driver.findElementByName("Pressure      (Bar)");
		return IsElementVisibleStatus(PrsrInlist);
	}

	// Select on Pressure from sensor type
	public void select_Sensortype_Pr() {
		WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
		clickOn(Sensortype_field);
		WebElement PrInlist = driver.findElementByName("Pressure      (Bar)");
		clickOn(PrInlist);
	}

	// Is SensorLabel visible
	public boolean IsSensorLabelvisible() {
		WebElement SensorLabel_state = driver.findElementByName("Sensor Label");
		return IsElementVisibleStatus(SensorLabel_state);
	}

	// Is from field label visible
	public boolean IsFromfieldvisible() {
		WebElement FromField_state = driver.findElementByName("From");
		return IsElementVisibleStatus(FromField_state);
	}

	// Is To field label visible
	public boolean IsTofieldvisible() {
		WebElement FromField_state = driver.findElementByName("To");
		return IsElementVisibleStatus(FromField_state);
	}

	// Is from field Enable
	public boolean IsFromfield_Enable() {
		WebElement FromField_state = driver.findElementByAccessibilityId("txtFrom");
		return IsElementEnabledStatus(FromField_state);
	}

	// Is To field Enable
	public boolean IsTofield_Enable() {
		WebElement ToField_state = driver.findElementByAccessibilityId("txtTo");
		return IsElementEnabledStatus(ToField_state);
	}

	// Fetch the From field text
	public String get_Fromfield_text() {
		WebElement Fromtxt_field = driver.findElementByAccessibilityId("txtFrom");
		return FetchText(Fromtxt_field);
	}

	// Enter From Count
	public void Enter_Num_From(String Num) {
		WebElement From_field = driver.findElementByAccessibilityId("txtFrom");
		clickOn(From_field);
		ClearText(From_field);
		enterText(From_field, Num);
	}

	// Fetch the To field text
	public String get_Tofield_text() {
		WebElement Totxt_field = driver.findElementByAccessibilityId("txtTo");
		return FetchText(Totxt_field);
	}

	// Enter Count to To text field
	public void Enter_Num_To(String Num) {
		WebElement To_field = driver.findElementByAccessibilityId("txtTo");
		clickOn(To_field);
		ClearText(To_field);
		enterText(To_field, Num);
	}

	// Is Assign Button visible
	public boolean IsAssign_Button_visible() {
		WebElement AssignButton_state = driver.findElementByAccessibilityId("AssignButton");
		return IsElementVisibleStatus(AssignButton_state);
	}

	// Is Description Button_state visible
	public boolean IsDescription_Button_visible() {
		WebElement DescriptionButton_state = driver.findElementByAccessibilityId("DescriptionButton");
		return IsElementVisibleStatus(DescriptionButton_state);
	}

	// Is SensorLabel field Enable
	public boolean IsSensorLabel_Enable() {
		WebElement SensorLabel_state = driver.findElementByAccessibilityId("SensorLabelTextBox");
		return IsElementEnabledStatus(SensorLabel_state);
	}
	// Is SensorLabel field Enable
	public boolean IsSensorLabel_VIsibleState() {
		WebElement SensorLabel_state = driver.findElementByAccessibilityId("SensorLabelTextBox");
		return IsElementVisibleStatus(SensorLabel_state);
		}
	// Is Assign Button Enable
	public boolean IsAssign_Button_Enable() {
		WebElement AssignButton_state = driver.findElementByAccessibilityId("AssignButton");
		return IsElementEnabledStatus(AssignButton_state);
	}

	// click on assign button
	public void Click_assignBtn() throws InterruptedException {
		WebElement AssignButton_clk = driver.findElementByAccessibilityId("AssignButton");
		clickOn(AssignButton_clk);
		Thread.sleep(500);
	}

	// Is Description Button_state Enable
	public boolean IsDescription_Button_Enable() {
		WebElement DescriptionButton_state = driver.findElementByAccessibilityId("DescriptionButton");
		return IsElementEnabledStatus(DescriptionButton_state);
	}

// Is Assign Button field Enable
	public boolean IsAssignButton_Enable() {
		WebElement AssignButton_field = driver.findElementByAccessibilityId("AssignButton");
		return IsElementEnabledStatus(AssignButton_field);
	}

	// Fetch the SensorLabel_field text
	public String get_SensorLabel_text() {
		WebElement SensorLabel_field = driver.findElementByAccessibilityId("SensorLabelTextBox");
		return FetchText(SensorLabel_field);
	}

	// Enter data into the SensorLabel field
	public void Enter_SensorLabel(String data) {
		WebElement SensorLabel_field = driver.findElementByAccessibilityId("SensorLabelTextBox");
		ClearText(SensorLabel_field);
		clickOn(SensorLabel_field);
		enterText(SensorLabel_field, data);
	}

	// Fetch the SensorLabel_Number text box
	public String get_SensorLabel_Num_text() {
		WebElement SensorLabelNum_field = driver.findElementByAccessibilityId("SensorLabelNumberTextBox");
		return FetchText(SensorLabelNum_field);
	}

	// Enter data into the SensorLabel field
	public void Enter__Num_SensorLabel(String data) {
		WebElement SensorLabelNum_field = driver.findElementByAccessibilityId("SensorLabelNumberTextBox");
		ClearText(SensorLabelNum_field);
		clickOn(SensorLabelNum_field);
		enterText(SensorLabelNum_field, data);
	}
	//get value from sensor label number field
	public String get_SenLabelNum()
	{
		WebElement SensNumber = driver.findElementByAccessibilityId("SensorLabelNumberTextBox");
		return FetchText(SensNumber);
	}
	//Click on auto numbering
	public void click_AutoNumber()
	{
		WebElement AutoNumber = driver.findElementByAccessibilityId("SensorLabelAutoNumberCheckBox");
		clickOn(AutoNumber);
	}
	public boolean Is_AutoNumberVisible()
	{
		WebElement AutoNumber = driver.findElementByAccessibilityId("SensorLabelAutoNumberCheckBox");
		return IsElementVisibleStatus(AutoNumber);
	}
	// Click on Description Button
	public Setup_SensorDescriptionPage Click_DescriptionButton() throws IOException {
		WebElement Description_Button = driver.findElementByAccessibilityId("DescriptionButton");
		clickOn(Description_Button);
		return new Setup_SensorDescriptionPage();
	}
	
	// Click on temp from sensortype
		public void select_Sensortype_temp() {
			WebElement Sensortype_field = driver.findElementByAccessibilityId("SensorTypeSimComboBox");
			clickOn(Sensortype_field);
			WebElement tempInlist = driver.findElementByName("Thermocouple >>");
			clickOn(tempInlist);
			//WebElement SemitempInlist = driver.findElementByName("GE.NGV.DataObjects.DataContracts.SensorType");
			//clickOn(SemitempInlist);
			WebElement tempCountlist = driver.findElementByName("Type T TC(0.1)");
			clickOn(tempCountlist);
		
			//WebElement tempInlist = driver.findElementByName("Temperature     (°C)");
			//clickOn(tempInlist);
				}
		
		public void Click_nextbtn_YesPopup1() throws IOException {
			clickOn(GroupSensors_btn);

			WebElement Yes_Btn = driver.findElementByAccessibilityId("Button1");
			clickOn(Yes_Btn);
		
		}

}
