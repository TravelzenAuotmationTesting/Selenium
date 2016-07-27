package com.page.element;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.data.generation.WhiteSearchOrderData;
import com.page.element.base.OperationTicketBase;
import com.selemium.utility.*;

//import java.lang.reflect.Field;

public class OperationWhiteSearchOrder extends OperationTicketBase {

	@FindBy(how = How.XPATH, xpath = "//button[2]")
	private WebElement blackPredeterminelink;

	@FindBy(how = How.XPATH, xpath = "//button[@id='submitSearchRequirmentForm']")
	private WebElement serachbtn;

	@FindBy(how = How.CLASS_NAME, className = "page-title")
	private WebElement pageTitle;

	@FindBy(how = How.XPATH, xpath = "//div[@class='lightbox']")
	public WebElement loadingPage;

	@FindBy(how = How.XPATH, xpath = "(//input[@name='singleSearch'])[1]")
	public WebElement singleRadio;

	@FindBy(how = How.XPATH, xpath = "(//input[@name='singleSearch'])[2]")
	public WebElement shuttleRadio;

	@FindBy(how = How.XPATH, xpath = "//input[@id='id_startCity']")
	public WebElement startCity;

	@FindBy(how = How.XPATH, xpath = "//input[@id='id_endCity']")
	public WebElement endCity;

	@FindBy(how = How.XPATH, xpath = "//input[@id='depd']")
	public WebElement startDate;

	@FindBy(how = How.XPATH, xpath = "//input[@id='arrd']")
	public WebElement backDate;

	@FindBy(how = How.XPATH, xpath = "(//span[@class='k-input'])[1]")
	public WebElement departureTimeFrom;

	@FindBy(how = How.XPATH, xpath = "(//span[@class='k-input'])[2]")
	public WebElement departureTimeTo;

	@FindBy(how = How.XPATH, xpath = "//input[@name='flightCompanySearch_input']")
	public WebElement airLine;

	@FindBy(how = How.XPATH, xpath = "//input[@id='customerName']")
	public WebElement customerName;

	public List<WebElement> orderList;

	public OperationWhiteSearchOrder(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void blackPredetermine_click() {
		blackPredeterminelink.click();
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
		customerName.clear();
	}

	public void clearPopupWindow() {
		pageTitle.click();
	}

	public void whiteDataInput(WhiteSearchOrderData orderData) {
		clearDefaultData();
		if (orderData.singleTrip == 1) {
			singleRadio.click();

		} else {
			shuttleRadio.click();
			backDate.sendKeys(orderData.backDate);
		}
		startCity.sendKeys(orderData.startCity);
		Utility.selectDropDownList(driver, "//ul[@id='id_startCity_listbox']/li/span", orderData.startCity,
				Utility.airport);
		endCity.sendKeys(orderData.endCity);
		Utility.selectDropDownList(driver, "//ul[@id='id_endCity_listbox']/li/span", orderData.endCity,
				Utility.airport);
		airLine.sendKeys(orderData.airLine);
		Utility.selectDropDownList(driver, "//ul[@aria-live='polite']/li/span", orderData.airLine, Utility.airline);

		startDate.sendKeys(orderData.startDate);
		Utility.inputDataByJS(driver, departureTimeFrom, orderData.departureTimeFrom, "innerHTML");
		Utility.inputDataByJS(driver, departureTimeTo, orderData.departureTimeTo, "innerHTML");

		customerName.sendKeys(orderData.customerName);
		clearPopupWindow();
	}

	public void request_click() {
		serachbtn.click();
		Utility.waitElementPresenceByAttribute(driver, 20, "//div[@class='lightbox']", "Style", "none");
		orderList = Utility.getPassBackData(driver,
				"//tr[@class='data-row form_list_0']/td/a[@class='btns btn-order']");
	}

	public void firstOrder_click() {
		orderList.get(0).click();
	}

}