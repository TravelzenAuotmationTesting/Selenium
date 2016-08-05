package com.page.element.purchase;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.data.generation.WhitePassenagerData;
import com.page.element.base.HomeBase;
import com.selemium.utility.Utility;

public class PCreateOrder extends HomeBase {

	@FindBy(how=How.XPATH,xpath="//input[@class='passengerName k-input']")
	public List<WebElement> passengerNameList;
	
	@FindBy(how=How.XPATH,xpath="(//span[@class='k-widget k-dropdown k-header gender']//span[@class='k-input'])[position()<last()]")
	public List<WebElement> genderList;
	
	@FindBy(how=How.XPATH,xpath="(//span[@class='k-widget k-dropdown k-header documentType']//span[@class='k-input'])[position()<last()]")
	public List<WebElement> IDTypeList;
	
	@FindBy(how=How.XPATH,xpath="(//input[@class='documentNo'])[position()<last()]")
	public List<WebElement> documentList;
	
	@FindBy(how=How.XPATH,xpath="(//input[@class='birthDate hasDatepicker'])[position()<last()]")
	public List<WebElement> brithdayList;
	
	@FindBy(how=How.XPATH,xpath="(//input[@class='mobileNo'])[position()<last()]")
	public List<WebElement> passengerContactPhone;
	
	@FindBy(how=How.XPATH,xpath="//a[@class='adaptiveButton mediumOrange_btn']")
	public WebElement createOrderBtn;
	
	@FindBy(how=How.XPATH,xpath="//textarea[@name='externalMemo']")
	public WebElement remarkArea;
	
	
	public PCreateOrder(WebDriver driver) {
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
	}
	
	public void createOrderBtn_click()
	{
		Utility.waitElementPresenceByXpath(driver, 40, "//table[@class='fare']",1);
		createOrderBtn.click();
	}

}
