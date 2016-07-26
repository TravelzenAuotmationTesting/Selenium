package com.page.element;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.business.model.Order;
import com.selemium.utility.Utility;

public class OperationIssueTicket extends OperationOrderManagementMenu {

	@FindBy(how = How.XPATH, xpath = "//input[@id='flightOrderItemId']")
	public WebElement orderIDtxt;

	@FindBy(how = How.XPATH, xpath = "//a[@id='queryOrders']")
	public WebElement queryOrdersbtn;

	@FindBy(how = How.XPATH, xpath = "//div[@id='orderList']/div[@class='k-grid-content']/table/tbody/tr")
	public List<WebElement> orderList;

	@FindBy(how = How.XPATH, xpath = "//div[@id='orderList']/div[@class='k-grid-content']/table/tbody/tr/td")
	public List<WebElement> orderDetailList;

	public OperationIssueTicket(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void orderQuery(String orderID) {

		List<Order> orderlist = new ArrayList<Order>();
		
		orderIDtxt.sendKeys(orderID);
		queryOrdersbtn.click();
		
		boolean flag=true;
		
		while(flag)
		{
			flag=driver.findElements(By.xpath("//div[@id='orderList']/div[@class='k-grid-content']/table/tbody/tr/td")).size()!=0 ? false: true;
			//flag=Utility.waitElementPresenceByXpath(driver, 20, "//div[@id='orderList']/div[@class='k-grid-content']/table/tbody/tr/td", 0);
			queryOrdersbtn.click();
		}
		
		for (int i = 0; i < orderDetailList.size() / 18; i++) {
			int index=i*18;
			orderlist.add(new Order(i,orderDetailList.get(index).getText(), orderDetailList.get(index + 1).getText(),
					orderDetailList.get(index + 2).getText(), orderDetailList.get(index + 3).getText(),
					orderDetailList.get(index + 4).getText(), orderDetailList.get(index + 5).getText(),
					orderDetailList.get(index + 6).getText(), orderDetailList.get(index + 7).getText(),
					orderDetailList.get(index + 8).getText(), orderDetailList.get(index + 9).getText(),
					orderDetailList.get(index + 10).getText(), orderDetailList.get(index + 11).getText(),
					orderDetailList.get(index + 12).getText(), orderDetailList.get(index + 13).getText(),
					orderDetailList.get(index + 14).getText(), orderDetailList.get(index + 15).getText(),
					orderDetailList.get(index + 16).getText(), orderDetailList.get(index + 17).getText()));
		}
		
		for (Order order : orderlist) {
			if(order.orderID.equals(orderID))
			{
				orderDetailList.get(order.index*18).findElement(By.linkText("受理")).click();
				break;
			}
		}
		
		Utility.swtichToOtherTab(driver, "天地行");
	}
	
	

}
