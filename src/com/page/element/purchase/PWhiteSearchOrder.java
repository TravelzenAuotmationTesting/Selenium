package com.page.element.purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.data.generation.WhiteSearchOrderData;
import com.page.element.base.PurchaseTicketBase;
import com.selemium.utility.Utility;

public class PWhiteSearchOrder extends PurchaseTicketBase {

	@FindBy(how = How.XPATH, xpath = "//button[@id='searchButton']")
	private WebElement serachbtn;

	@FindBy(how = How.XPATH, xpath = "//div[@class='querytab-flight']")
	private WebElement serarchframe;

	@FindBy(how = How.XPATH, xpath = "//div[@class='lightbox']")
	public WebElement loadingPage;

	@FindBy(how = How.XPATH, xpath = "(//input[@name='tripType'])[1]")
	public WebElement singleRadio;

	@FindBy(how = How.XPATH, xpath = "(//input[@name='tripType'])[2]")
	public WebElement shuttleRadio;

	@FindBy(how = How.XPATH, xpath = "//input[@name='fromCityName']")
	public WebElement startCity;

	@FindBy(how = How.XPATH, xpath = "//input[@name='toCityName']")
	public WebElement endCity;

	@FindBy(how = How.XPATH, xpath = "//input[@name='fromDate']")
	public WebElement startDate;

	@FindBy(how = How.XPATH, xpath = "//input[@name='returnDate']")
	public WebElement backDate;

	@FindBy(how = How.XPATH, xpath = "(//span[@class='k-input'])[1]")
	public WebElement grades;

	@FindBy(how = How.XPATH, xpath = "(//span[@class='k-input'])[2]")
	public WebElement takeoffTime;

	@FindBy(how = How.XPATH, xpath = "//input[@name='airCo_input']")
	public WebElement airLine;

	public PWhiteSearchOrder(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clearDefaultData() {
		// Field[] publicFields=this.getClass().getFields();
		//
		// for (Field field : publicFields) {
		// field.getName()field.
		// }
		startCity.clear();
		endCity.clear();
		startDate.clear();
		if (backDate.isEnabled()) {
			backDate.clear();
		}
		airLine.clear();
	}

	public void clearPopupWindow() {
		serarchframe.click();
	}

	public void whiteDataInput(WhiteSearchOrderData orderData) {
		clearDefaultData();
		orderData.singleTrip = 1;
		if (orderData.singleTrip == 1) {
			singleRadio.click();

		} else {
			shuttleRadio.click();
			backDate.sendKeys(orderData.backDate);
		}
		airLine.sendKeys(orderData.airLine);
		Utility.selectDropDownListPerSpreadSheet(driver, "//ul[@aria-live='polite']/li/span", orderData.airLine,
				Utility.airline);
		startCity.sendKeys(orderData.startCity);
		Utility.selectDropDownListPerSpreadSheet(driver, "//ul[@aria-live='polite' and @aria-hidden='false']/li/span[@class='sg_name']", orderData.startCity,
				Utility.airport);
		endCity.sendKeys(orderData.endCity);
		Utility.selectDropDownListPerSpreadSheet(driver, "//ul[@aria-live='polite' and @aria-hidden='false']/li/span[@class='sg_name']", orderData.endCity,
				Utility.airport);
		
		startDate.sendKeys(orderData.startDate);
		
		Utility.inputDataByJS(driver, grades, orderData.grade, "innerHTML");
		Utility.inputDataByJS(driver, takeoffTime, orderData.period, "innerHTML");

		clearPopupWindow();
		
		Utility.waitElementPresenceByAttribute(driver, 20, "//div[@id='ui-datepicker-div']", "Style", "none");
	}
	
	
	public void serachbtn_click()
	{
		serachbtn.click();
		Utility.waitURLnavigation(driver, 20, "whiteScreenToOrder");
		Utility.waitElementPresenceByAttribute(driver, 15, "//div[@id='fruitlessDiv']", "Style", "none");
	}

}
