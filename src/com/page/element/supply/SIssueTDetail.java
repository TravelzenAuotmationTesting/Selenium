package com.page.element.supply;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.data.generation.IssueTicketData;
import com.page.element.base.SupplyTicketBase;
import com.selemium.utility.Utility;

public class SIssueTDetail extends SupplyTicketBase {

	@FindBy(how = How.XPATH, xpath = "//a[@id='complete_issue']")
	public WebElement completeTicket;

	@FindBy(how = How.XPATH, xpath = "//span[@class='check_ticket_type']")
	public WebElement tickectType;

	@FindBy(how = How.XPATH, xpath = "//td[@class='ticketNo']/input")
	public List<WebElement> tickketID;

	@FindBy(how = How.XPATH, xpath = "//a[@class='btns button_1_2 ok-confirm-button']")
	public WebElement confirmbtn;

	public String loadingPage = "//div[@class='lightbox']";

	public SIssueTDetail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void fillinData(IssueTicketData ticketData) {

		tickectType.findElement(By.xpath("//input[@value='" + ticketData.ticketType + "']")).click();
		for (WebElement ticket : tickketID) {
			ticket.sendKeys(ticketData.ticketID);
		}
	}

	public void completeTicket_click() {
		completeTicket.click();
		Utility.waitElementPresenceByAttribute(driver, 10, loadingPage, "Style", "none");
		confirmbtn.click();
		Utility.waitURLnavigation(driver, 15, "issue");
	}

}
