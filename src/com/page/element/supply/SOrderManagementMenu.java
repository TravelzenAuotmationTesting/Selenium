package com.page.element.supply;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.page.element.base.SupplyTicketBase;

public class SOrderManagementMenu extends SupplyTicketBase {

	@FindBy(how=How.LINK_TEXT,linkText="¶©µ¥²éÑ¯")
	public WebElement orderQueryLink;
	
	@FindBy(how=How.LINK_TEXT,linkText="³öÆ±")
	public WebElement issueTicketLink;
	
	
	public SOrderManagementMenu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void orderQueryLink_click()
	{
		orderQueryLink.click();
	}
	
	public void issueTicketLink_click()
	{
		issueTicketLink.click();
	}

}
