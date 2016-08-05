package com.page.element.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PurchaseTicketBase extends HomeBase {

	@FindBy(how = How.XPATH, xpath = "//b[@data-key='flight']")
	public WebElement ticketBookLink;
	
	@FindBy(how= How.XPATH, xpath="//b[@data-key='pnr']")
	public WebElement PNRimportLink;
	
	@FindBy(how=How.XPATH, xpath="//b[@data-key='sheet']")
	public WebElement inquiryLink;

	public PurchaseTicketBase(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void ticketBookLink_click()
	{
		ticketBookLink.click();
	}
	
	public void PNRimportLink_click()
	{
		PNRimportLink.click();
	}
	
	public void inquiryLink_click()
	{
		inquiryLink.click();
	}

}
