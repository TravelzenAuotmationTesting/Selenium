package com.page.element.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SupplyTicketBase extends HomeBase {
	
	@FindBy(how=How.LINK_TEXT,linkText="订单管理")
	public WebElement orderManagementLink;
	
	@FindBy(how=How.LINK_TEXT,linkText="政策维护")
	public WebElement policySustainLink;
	
	@FindBy(how=How.LINK_TEXT,linkText="自动出票")
	public WebElement autoTicketLink;

	public SupplyTicketBase(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void orderManagementLink_click()
	{
		orderManagementLink.click();
	}
	
	public void policySustainLink_click()
	{
		policySustainLink.click();
	}
	
	public void autoTicketLink_click()
	{
		policySustainLink.click();
	}

}
