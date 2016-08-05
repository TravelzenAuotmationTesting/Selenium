package com.page.element.purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.page.element.base.HomeBase;

public class POrderDetail extends HomeBase {

	@FindBy(how = How.XPATH, xpath = "//span[@class='orderNO']/strong")
	public WebElement orderID;

	@FindBy(how = How.XPATH, xpath = "//b[@class='endorsing']")
	public WebElement orderStatus;

	public POrderDetail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getOrderStatus() {
		waitOrderStauts();
		return orderStatus.getText();
	}

	public String getOrderID() {

		return orderID.getText();
	}

	public void waitOrderStauts() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				driver.navigate().refresh();
				return orderStatus.getText().equals("´ý³öÆ±");
			}
		});
	}
}
