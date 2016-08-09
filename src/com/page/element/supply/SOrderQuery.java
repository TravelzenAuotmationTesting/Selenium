package com.page.element.supply;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.selemium.utility.Utility;

public class SOrderQuery extends SOrderManagementMenu {

	@FindBy(how = How.XPATH, xpath = "//input[@name='flightOrderItemId']")
	public WebElement flightOrderItemIdtxt;

	@FindBy(how = How.XPATH, xpath = "//button[@type='submit']")
	public WebElement queryOrdersbtn;

	@FindBy(how = How.XPATH, xpath = "//table[@class='tgrid']/tbody/tr")
	public List<WebElement> orderList;

	public SOrderQuery(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean orderStatusQuery(String orderID) {

		flightOrderItemIdtxt.sendKeys(orderID);
		queryOrdersbtn.click();

		Utility.waitElementPresenceByXpath(driver, 10, "//table[@class='tgrid']/tbody/tr", 1);

		return orderList.get(0).getText().contains("Íê³É³öÆ±");
	}
}
