package com.page.element.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OperationTicketBase extends HomeBase {

	
	@FindBy(how=How.LINK_TEXT,linkText="平台建单")
	private WebElement platformOrderLink;
	
	@FindBy(how=How.LINK_TEXT,linkText="订单管理")
	private WebElement orderManagementLink;
	
	@FindBy(how=How.XPATH,xpath="//button[3]")
	private WebElement whitePredetermine;
	
	public OperationTicketBase(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void whitePredetermine_click()
	{
		whitePredetermine.click();
	}
	
	public void platformOrderLink_click()
	{
		platformOrderLink.click();
	}
	
	public void orderManagementLink_click()
	{
		orderManagementLink.click();
	}

}
