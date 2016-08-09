package com.page.element.supply;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.business.model.SOrder;
import com.selemium.utility.Utility;

public class SIssueTicket extends SOrderManagementMenu {

	@FindBy(how = How.XPATH, xpath = "//input[@name='flightOrderItemId']")
	public WebElement orderIDtxt;

	@FindBy(how = How.XPATH, xpath = "//button[@type='submit']")
	public WebElement queryOrdersbtn;

	@FindBy(how = How.XPATH, xpath = "//table[@class='tgrid']/tbody/tr")
	public List<WebElement> orderList;

	public SIssueTicket(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void orderQuery(String orderID) {

		List<SOrder> orderlist = new ArrayList<SOrder>();

		orderIDtxt.sendKeys(orderID);
		queryOrdersbtn.click();

		boolean flag = true;

		while (flag) {
			flag = driver.findElements(By.xpath("//table[@class='tgrid']/tbody/tr")).size() != 0 ? false : true;
			queryOrdersbtn.click();
		}

		for (WebElement subOrder : orderList) {
			List<WebElement> orderDetailList = subOrder.findElements(By.xpath(".//td"));
			for (int i = 0; i < orderDetailList.size() / 17; i++) {
				int index = i * 18;
				orderlist.add(new SOrder(index, orderDetailList.get(index).getText(),
						orderDetailList.get(index + 1).getText(), orderDetailList.get(index + 2).getText(),
						orderDetailList.get(index + 3).getText(), orderDetailList.get(index + 4).getText(),
						orderDetailList.get(index + 5).getText(), orderDetailList.get(index + 6).getText(),
						orderDetailList.get(index + 7).getText(), orderDetailList.get(index + 8).getText(),
						orderDetailList.get(index + 9).getText(), orderDetailList.get(index + 10).getText(),
						orderDetailList.get(index + 11).getText(), orderDetailList.get(index + 12).getText(),
						orderDetailList.get(index + 13).getText(), orderDetailList.get(index + 14).getText(),
						orderDetailList.get(index + 15).getText(), orderDetailList.get(index + 16).getText()));
			}
		}

		for (

		SOrder order : orderlist) {
			if (order.orderID.equals(orderID)) {
				orderList.get(order.index).findElements(By.linkText("КЬАн")).get(order.index).click();
				Utility.swtichToOtherTabByURL(driver, "provider/order/flight/viewOrderDetail");
				break;
			}
		}

	}

}
