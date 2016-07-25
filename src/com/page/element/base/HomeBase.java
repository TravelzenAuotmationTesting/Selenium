package com.page.element.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;

public abstract class HomeBase {

	public WebDriver driver;

	@FindBy(how = How.LINK_TEXT, linkText = "���ڻ�Ʊ")
	public WebElement inlandTicketLink;

	@FindBy(how = How.LINK_TEXT, linkText = "���ʻ�Ʊ")
	public WebElement internationalTicketLink;
	
	@FindBy(how=How.LINK_TEXT,linkText="�˳�")
	public WebElement logout;

	public HomeBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public void internationalTicketLink_click()
	{
		internationalTicketLink.click();
	}
	
	public void inlandTicketLink_click()
	{
		inlandTicketLink.click();
	}
	
	public void logout()
	{
		logout.click();
	}
}
