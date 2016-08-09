package com.page.element.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SupplyTicketBase extends HomeBase {
	
	@FindBy(how=How.LINK_TEXT,linkText="��������")
	public WebElement orderManagementLink;
	
	@FindBy(how=How.LINK_TEXT,linkText="����ά��")
	public WebElement policySustainLink;
	
	@FindBy(how=How.LINK_TEXT,linkText="�Զ���Ʊ")
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
