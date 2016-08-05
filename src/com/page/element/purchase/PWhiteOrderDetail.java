package com.page.element.purchase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.business.model.POrder;
import com.business.model.PPrice;
import com.page.element.base.HomeBase;

public class PWhiteOrderDetail extends HomeBase {

	@FindBy(how = How.XPATH, xpath = "//div[@id='fruitlessDiv']")
	public WebElement loadingIMG;

	@FindBy(how = How.XPATH, xpath = "//div[@id='searching_no_data_result']")
	public WebElement noDataResult;

	@FindBy(how = How.XPATH, xpath = "//div[@class='information']")
	public List<WebElement> flightList;

	@FindBy(how = How.XPATH, xpath = "//div[@class='information']/table[@class='information_detail showPolicyInfo']//a[@class='more-cabin']")
	public List<WebElement> unfoldBtn;
	
	@FindBy(how=How.XPATH, xpath="//table[@class='information_detail showPolicyInfo']//a[@class='adaptiveButton brightRed_btn medium']")
	public List<WebElement> orderBtn;

	public String orderXpath = ".//table[@class='information_detail showPolicyInfo']//tr";

	public PWhiteOrderDetail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void unfoldAllCabin() {
		for (WebElement webElement : unfoldBtn) {
			webElement.click();
		}
	}

	public List<POrder> Getflightinfo() {
		List<POrder> flightlist = new ArrayList<POrder>();
		for (WebElement subFlight : flightList) {
			List<PPrice> orderList = new ArrayList<PPrice>();
			for (WebElement subOrder : subFlight.findElements(By.xpath(orderXpath))) {
				orderList.add(new PPrice(subOrder.findElement(By.xpath(".//td[2]")).getText(),
						subOrder.findElement(By.xpath(".//td[5]")).getText(),
						subOrder.findElement(By.xpath(".//td[6]")).getText(),
						subOrder.findElement(By.xpath(".//td[7]")).getText(),
						subOrder.findElement(By.xpath(".//td[8]/span[1]")).getText(),
						subOrder.findElement(By.xpath(".//td[8]/span[2]")).getText()));
			}
			flightlist.add(new POrder(
					subFlight.findElement(By.xpath(".//table[@class='information_header']//td[2]")).getText(),
					subFlight.findElement(By.xpath(".//table[@class='information_header']//td[3]")).getText(),
					subFlight.findElement(By.xpath(".//table[@class='information_header']//td[6]")).getText(),
					subFlight.findElement(By.xpath(".//table[@class='information_header']//td[4]")).getText(),
					subFlight.findElement(By.xpath(".//table[@class='information_header']//td[7]")).getText(),
					orderList));
		}
		return flightlist;
	}
	
	public void orderBtn_click()
	{
		orderBtn.get(0).click();
	}
}
