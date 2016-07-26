package com.page.element;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.data.generation.IssueTicketData;
import com.page.element.base.OperationTicketBase;
import com.selemium.utility.Utility;

public class OperationIssueTDetail extends OperationTicketBase {

	@FindBy(how=How.XPATH,xpath="//input[@id='complete_issue']")
	public WebElement completeTicket;
	
	@FindBy(how=How.XPATH,xpath="//span[@class='check_ticket_item']")
	public WebElement tickectType;
	
	@FindBy(how=How.XPATH,xpath="//input[@class='ticketNo ticket-can-copy-ticketNo']")
	public List<WebElement> tickketID;
	
	
	public OperationIssueTDetail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void fillinData(IssueTicketData ticketData)
	{
		
		tickectType.findElement(By.xpath("//input[@value='"+ticketData.ticketType+"']")).click();
		for (WebElement ticket : tickketID) {
			ticket.sendKeys(ticketData.ticketID);
		}
	}
	
	public void completeTicket_click()
	{
		completeTicket.click();
		Utility.waitURLnavigation(driver, 10, "searchProcessIssueOrder");
		
	}
}
