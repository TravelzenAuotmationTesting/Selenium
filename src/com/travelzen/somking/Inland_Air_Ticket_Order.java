package com.travelzen.somking;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.selemium.utility.PageInitialize;
import com.selemium.utility.*;
import com.business.model.POrder;
import com.data.generation.*;

public class Inland_Air_Ticket_Order {

	String operationURL = null;
	String purchaseURL = null;
	String operation_username = null;
	String operation_password = null;
	String purchase_username = null;
	String purchase_password = null;
	String payment_password = null;

	PageInitialize pageInit = null;
	WebDriver driver = null;
	String PNR = null;

	@Test(groups = { "smokingtest" })
	public void Inland_Air_SingleTrip_Operation() {

		WhiteSearchOrderData searchData = new WhiteSearchOrderData();
		searchData.singleTrip = 1;
		List<WhitePassenagerData> passenagerData = new ArrayList<WhitePassenagerData>();
		passenagerData.add(new WhitePassenagerData());

		pageInit.o_whiteSearchOrder.inlandTicketLink_click();
		pageInit.o_whiteSearchOrder.platformOrderLink_click();
		pageInit.o_whiteSearchOrder.whitePredetermine_click();
		pageInit.o_whiteSearchOrder.whiteDataInput(searchData);
		pageInit.o_whiteSearchOrder.request_click();
		pageInit.o_whiteSearchOrder.firstOrder_click();

		pageInit.o_whiteCreateOrder.passenageInfomationInput(passenagerData);
		pageInit.o_whiteCreateOrder.createOrder_click();

		String orderID = pageInit.o_orderDetail.getOrderID();
		pageInit.o_orderDetail.applyTicketbtn_click();
		pageInit.o_orderQuery.issueTicketlink_click();
		pageInit.o_issueTicket.orderQuery(orderID);
		pageInit.o_issueTDetail.fillinData(new IssueTicketData());
		pageInit.o_issueTDetail.completeTicket_click();
		pageInit.o_orderQuery.orderManagementLink_click();
		Assert.assertEquals(true, pageInit.o_orderQuery.orderStatusQuery(orderID));
		// logger.info("test "+orderID);

	}

	@Test(groups = { "smokingtest" })
	public void Inland_Air_CreateOrderByBlack_Operation() {
		pageInit.o_blackSearchOrder.inlandTicketLink_click();
		pageInit.o_blackSearchOrder.platformOrderLink_click();
		pageInit.o_blackSearchOrder.adultBlackDataInput("CW", PNR, null);
		pageInit.o_blackSearchOrder.adultPnrCodeCreateOrderBtn_click();
		pageInit.o_whiteCreateOrder.contactPhoneInput();
		pageInit.o_whiteCreateOrder.createOrder_click();
		String orderID = pageInit.o_orderDetail.getOrderID();
		pageInit.o_orderDetail.applyTicketbtn_click();
		pageInit.o_orderQuery.issueTicketlink_click();

		pageInit.o_issueTicket.orderQuery(orderID);
		pageInit.o_issueTDetail.fillinData(new IssueTicketData());
		pageInit.o_issueTDetail.completeTicket_click();
		pageInit.o_orderQuery.orderManagementLink_click();
		Assert.assertEquals(true, pageInit.o_orderQuery.orderStatusQuery(orderID));
	}

	@Test(groups = { "devtest" })
	public void Inland_Air_SingleTrip_PurchaseOpeartion_Sleepless() {
		Utility.openNewTab(driver, purchaseURL);

		pageInit.login.setLogindata(new LoginData(purchase_username, purchase_password));
		pageInit.login.loginOperation();
		pageInit.p_whiteSearchOrder.ticketBookLink_click();
		pageInit.p_whiteSearchOrder.whiteDataInput(new WhiteSearchOrderData());
		pageInit.p_whiteSearchOrder.serachbtn_click();
		pageInit.p_whiteOrderDetail.unfoldAllCabin();

		List<POrder> orderList = pageInit.p_whiteOrderDetail.Getflightinfo();

		pageInit.p_whiteOrderDetail.orderBtn_click();

		List<WhitePassenagerData> passenagerData = new ArrayList<WhitePassenagerData>();
		passenagerData.add(new WhitePassenagerData());

		pageInit.p_createOrder.passenageInfomationInput(passenagerData);
		pageInit.p_createOrder.createOrderBtn_click();

		pageInit.p_payment.paymentconfimation(payment_password);

		String orderID = pageInit.p_orderDetail.getOrderID();

		Assert.assertEquals("´ý³öÆ±", pageInit.p_orderDetail.getOrderStatus());

		Utility.swtichToOtherTabByIndex(driver, "1");

		Utility.swtichToOtherTabByURL(driver, "tops-front-operator");

		pageInit.o_issueTicket.inlandTicketLink_click();
		pageInit.o_issueTicket.orderManagementLink_click();
		pageInit.o_issueTicket.issueTicketlink_click();

		pageInit.o_issueTicket.orderQuery(orderID);
		pageInit.o_issueTDetail.fillinData(new IssueTicketData());
		pageInit.o_issueTDetail.completeTicket_click();
		pageInit.o_orderQuery.orderManagementLink_click();
		Assert.assertEquals(true, pageInit.o_orderQuery.orderStatusQuery(orderID));

	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() throws ConfigurationException {

		try {
			PropertiesConfiguration config = new PropertiesConfiguration(
					ClassLoader.getSystemResource("test.properties"));
			operationURL = config.getString("operationOP3URL");
			purchaseURL = config.getString("purchaseOP3URL");
			operation_username = config.getString("operation_username");
			operation_password = config.getString("operation_password");
			purchase_username = config.getString("purchase_username");
			purchase_password = config.getString("purchase_password");
			payment_password = config.getString("payment_password");

			PNR = config.getString("PNR");

			System.setProperty("webdriver.chrome.driver",
					ClassLoader.getSystemResource("Driver").getPath().substring(1) + "/chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("lang=en_US.UTF-8");

			driver = new EventFiringWebDriver(new ChromeDriver(options)).register(new WebDriverListenerRedefine());
			driver.get(operationURL);
			pageInit = new PageInitialize(driver);
			pageInit.login.setLogindata(new LoginData(operation_username, operation_password));
			pageInit.login.loginOperation();

		} finally {
			if (operationURL == null) {
				System.out.println("can't get testing URL");
			}
		}
	}

	@AfterTest(alwaysRun = true)
	public void AfterMethod() {
		Utility.snapshot((TakesScreenshot) driver, "result.png");
		driver.quit();
	}

}