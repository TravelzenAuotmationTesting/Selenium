package com.travelzen.somking;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.page.element.*;
import com.page.element.login.OperationLogin;
import com.selemium.utility.Utility;
import com.selemium.utility.WebDriverListenerRedefine;
import com.data.generation.*;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.apache.log4j.xml.DOMConfigurator;

public class Inland_Air_Ticket_Order {

	String operationURL = null;
	String operation_username = null;
	String operation_password = null;
	
	OperationLogin oLogin = null;
	OperationWhiteSearchOrder whiteSearchOrder = null;
	OperationCreateOrder whiteCreateOrder= null;
	OperationOrderDetail orderDetail= null;
	OperationOrderQuery  orderQuery= null;
	OperationIssueTicket issueTicket= null;
	OperationIssueTDetail issueTDetail= null;
	WebDriver driver= null;
	//static final Logger logger = LogManager.getLogger(Inland_Air_Ticket_Order.class.getName());
	

	@Test
	public void Inland_Air_SingleTrip_Operation() {
		
		
		//DOMConfigurator.configure("src\\log4j.xml");
		WhiteSearchOrderData searchData= new WhiteSearchOrderData();
		searchData.singleTrip=1;
		List<WhitePassenagerData> passenagerData =new ArrayList<WhitePassenagerData> ();
		passenagerData.add(new WhitePassenagerData());

		oLogin.setLogindata(new LoginData(operation_username, operation_password));
		oLogin.loginOperation();
	
		whiteSearchOrder.inlandTicketLink_click();
		whiteSearchOrder.platformOrderLink_click();
		whiteSearchOrder.whitePredetermine_click();
		whiteSearchOrder.whiteDataInput(searchData);
		whiteSearchOrder.request_click();
		whiteSearchOrder.firstOrder_click();
		
		whiteCreateOrder.passenageInfomationInput(passenagerData);
		whiteCreateOrder.createOrder_click();
		
		String orderID= orderDetail.getOrderID();
		orderDetail.applyTicketbtn_click();
		orderQuery.issueTicketlink_click();
		issueTicket.orderQuery(orderID);
		issueTDetail.fillinData(new IssueTicketData());
		issueTDetail.completeTicket_click();
		orderQuery.orderManagementLink_click();
		Assert.assertEquals(true, orderQuery.orderStatusQuery(orderID));
		//logger.info("test  "+orderID);
		
	}

	@BeforeTest
	public void beforeTest() {
		
		try {
			PropertiesConfiguration config = new PropertiesConfiguration("test.properties");
			operationURL = config.getString("operationOP3URL");
			operation_username = config.getString("operation_username");
			operation_password = config.getString("operation_password");
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");
			
			driver = new EventFiringWebDriver(new ChromeDriver()).register(new WebDriverListenerRedefine());
			driver.get(operationURL);
			
			oLogin = PageFactory.initElements(driver, OperationLogin.class);
			whiteSearchOrder = PageFactory.initElements(driver, OperationWhiteSearchOrder.class);
			whiteCreateOrder=PageFactory.initElements(driver, OperationCreateOrder.class);
			orderDetail=PageFactory.initElements(driver, OperationOrderDetail.class);
			orderQuery=PageFactory.initElements(driver, OperationOrderQuery.class);
			issueTicket=PageFactory.initElements(driver, OperationIssueTicket.class);
			issueTDetail=PageFactory.initElements(driver, OperationIssueTDetail.class);
				
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (operationURL == null) {
				System.out.println("can't get testing URL");
			}
		}
	}

	@AfterMethod
	public void AfterMethod()
	{
		Utility.snapshot((TakesScreenshot)driver, "result.png");
	}
	
	@AfterTest
	public void afterTest() {
		
	}

}
