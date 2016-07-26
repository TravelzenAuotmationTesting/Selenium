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
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.selemium.utility.PageInitialize;
import com.selemium.utility.*;
import com.data.generation.*;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.apache.log4j.xml.DOMConfigurator;

public class Inland_Air_Ticket_Order {

	String operationURL = null;
	String operation_username = null;
	String operation_password = null;
	PageInitialize pageInit=null;
	WebDriver driver= null;
	//static final Logger logger = LogManager.getLogger(Inland_Air_Ticket_Order.class.getName());
	

	@Test
	public void Inland_Air_SingleTrip_Operation() {
		
		
		//Auto loader DOMConfigurator.configure("src\\log4j.xml");
		WhiteSearchOrderData searchData= new WhiteSearchOrderData();
		searchData.singleTrip=1;
		List<WhitePassenagerData> passenagerData =new ArrayList<WhitePassenagerData> ();
		passenagerData.add(new WhitePassenagerData());

		pageInit.o_login.setLogindata(new LoginData(operation_username, operation_password));
		pageInit.o_login.loginOperation();
	
		pageInit.o_whiteSearchOrder.inlandTicketLink_click();
		pageInit.o_whiteSearchOrder.platformOrderLink_click();
		pageInit.o_whiteSearchOrder.whitePredetermine_click();
		pageInit.o_whiteSearchOrder.whiteDataInput(searchData);
		pageInit.o_whiteSearchOrder.request_click();
		pageInit.o_whiteSearchOrder.firstOrder_click();
		
		pageInit.o_whiteCreateOrder.passenageInfomationInput(passenagerData);
		pageInit.o_whiteCreateOrder.createOrder_click();
		
		String orderID= pageInit.o_orderDetail.getOrderID();
		pageInit.o_orderDetail.applyTicketbtn_click();
		pageInit.o_orderQuery.issueTicketlink_click();
		pageInit.o_issueTicket.orderQuery(orderID);
		pageInit.o_issueTDetail.fillinData(new IssueTicketData());
		pageInit.o_issueTDetail.completeTicket_click();
		pageInit.o_orderQuery.orderManagementLink_click();
		Assert.assertEquals(true, pageInit.o_orderQuery.orderStatusQuery(orderID));
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
			pageInit=new PageInitialize(driver);
			
			
				
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
