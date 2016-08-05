package com.page.element.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.page.element.base.OperationTicketBase;

public class OOrderDetail extends OperationTicketBase {

	@FindBy(how=How.XPATH,xpath="//em[@id='id']")
	public WebElement orderID;
	
	@FindBy(how=How.XPATH,xpath="//input[@id='apply_issue']")
	public WebElement applyTicketbtn;
	
	public OOrderDetail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getOrderID()
	{
		return orderID.getText();
	}
	
	public void applyTicketbtn_click()
	{
		applyTicketbtn.click();
		driver.findElement(By.linkText("Á¢¼´Ìø×ª")).click();;
	}

}
