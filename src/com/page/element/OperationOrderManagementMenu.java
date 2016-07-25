package com.page.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.page.element.base.OperationTicketBase;

public class OperationOrderManagementMenu extends OperationTicketBase {

	@FindBy(how=How.LINK_TEXT,linkText="∂©µ•≤È—Ø")
	public WebElement orderserachlink;
	
	@FindBy(how=How.XPATH,xpath="//strong[@id='watingForIssueCount']")
	public WebElement issueTicketlink;
	
	@FindBy(how=How.XPATH,xpath="//strong[@id='watingForReviewCount']")
	public WebElement watingForReviewCountlink;
	
	public OperationOrderManagementMenu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void issueTicketlink_click()
	{
		issueTicketlink.click();
	}
	
	public void watingForReviewCountlink_click()
	{
		watingForReviewCountlink.click();
	}

}
