package com.page.element;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperationOrderQuery extends OperationOrderManagementMenu {

	@FindBy(how=How.XPATH,xpath="//input[@name='flightOrderItemId']")
	public WebElement flightOrderItemIdtxt;
	
	@FindBy(how=How.XPATH,xpath="//a[@id='queryOrders']")
	public WebElement queryOrdersbtn;
	
	@FindBy(how=How.XPATH,xpath="//div[@id='orderList']/div[@class='k-grid-content']/table/tbody/tr")
	public List<WebElement> orderList;
	
	public OperationOrderQuery(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean orderStatusQuery(String orderID)
	{
		
		flightOrderItemIdtxt.sendKeys(orderID);
		queryOrdersbtn.click();
		
		WebDriverWait wait =new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver)
			{
				return orderList.size()>0;
			}
		});
		
		return orderList.get(0).getText().contains("Íê³É³öÆ±");
	}
}
