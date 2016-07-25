package com.page.element;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import com.data.generation.WhitePassenagerData;
import com.page.element.base.HomeBase;
import com.selemium.utility.Utility;

public class OperationCreateOrder extends HomeBase {

	
	@FindBy(how=How.XPATH,xpath="//input[@name='orderBO.orderContactBO.telephone']")
	public WebElement contactPhone;
	
	@FindBy(how=How.XPATH,xpath="//input[@class='passengerName' and @data-required-msg]")
	public List<WebElement> passengerNameList;
	
	@FindBy(how=How.XPATH,xpath="//span[@class='k-widget k-dropdown k-header gender']/span/span[@class='k-input']")
	public List<WebElement> genderList;
	
	@FindBy(how=How.XPATH,xpath="//span[@class='k-widget k-dropdown k-header']/span/span[@class='k-input']")
	public List<WebElement> IDTypeList;
	
	@FindBy(how=How.XPATH,xpath="(//input[@class='documentNo'])[position()<last()]")
	public List<WebElement> documentList;
	
	@FindBy(how=How.XPATH,xpath="(//input[@class='birthDate datepicker hasDatepicker'])[position()<last()]")
	public List<WebElement> brithdayList;
	
	@FindBy(how=How.XPATH,xpath="//input[@class='mobileNo' and @data-pattern-msg]")
	public List<WebElement> passengerContactPhone;
	
	@FindBy(how=How.XPATH,xpath="//input[@type='submit']")
	public WebElement createOrderbtn;
	
//	@FindBy(how=How.XPATH,xpath="//select[@class='ui-datepicker-year']")
//	public Select yearSelector;
//	
//	@FindBy(how=How.XPATH,xpath="//select[@class='ui-datepicker-month']")
//	public Select monthSelector;
//	
//	@FindBy(how=How.XPATH,xpath="//td[@data-handler='selectDay']/a")
//	public Select daySelector;
	
	public OperationCreateOrder(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void passenageInfomationInput(List<WhitePassenagerData> passenagerDatas)
	{
		for (int i=0;i< passengerNameList.size();i++)
		{
			passengerNameList.get(i).sendKeys(passenagerDatas.get(i).fullname);
			Utility.inputDataByJS(driver, genderList.get(i), passenagerDatas.get(i).gender, "innerHTML");
			documentList.get(i).sendKeys(passenagerDatas.get(i).documentID);
			passengerContactPhone.get(i).sendKeys(passenagerDatas.get(i).ContactPhone);
		}
		contactPhone.sendKeys(Utility.generateRandomString(11,2));
	}
	
	public void createOrder_click()
	{
		Utility.waitElementPresenceByXpath(driver, 40, "//div[@id='price_info_grid']/div",1);
		createOrderbtn.click();
	}
}
