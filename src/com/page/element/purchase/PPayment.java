package com.page.element.purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.page.element.base.HomeBase;

public class PPayment extends HomeBase {
	
	@FindBy(how=How.XPATH, xpath="//input[@id='password']")
	public WebElement passwordtxt;
		
	@FindBy(how=How.XPATH,xpath="//a[@class='adaptiveButton brightRed_btn ac-payAffirm']")
	public WebElement paymentConfirmBtn;
	

	public PPayment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void paymentconfimation(String password)
	{
		passwordtxt.sendKeys(password);
		paymentConfirmBtn.click();
		driver.findElement(By.linkText("立即返回商户")).click();
	}
	
	

}
