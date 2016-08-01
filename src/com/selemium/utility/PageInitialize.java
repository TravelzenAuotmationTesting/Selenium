package com.selemium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.page.element.*;
import com.page.element.login.*;

public class PageInitialize {
	
	public OperationLogin o_login;
	public OperationWhiteSearchOrder o_whiteSearchOrder;
	public OperationCreateOrder o_whiteCreateOrder;
	public OperationOrderDetail o_orderDetail;
	public OperationOrderQuery  o_orderQuery;
	public OperationIssueTicket o_issueTicket;
	public OperationIssueTDetail o_issueTDetail;
	public OperationBlackSearchOrder o_blackSearchOrder;
	/**
	 * @param login
	 * @param whiteSearchOrder
	 * @param whiteCreateOrder
	 * @param orderDetail
	 * @param orderQuery
	 * @param issueTicket
	 * @param issueTDetail
	 */
	public PageInitialize(WebDriver driver) {
		this.o_login = PageFactory.initElements(driver, OperationLogin.class);
		this.o_whiteSearchOrder = PageFactory.initElements(driver, OperationWhiteSearchOrder.class);
		this.o_whiteCreateOrder = PageFactory.initElements(driver, OperationCreateOrder.class);
		this.o_orderDetail = PageFactory.initElements(driver, OperationOrderDetail.class);
		this.o_orderQuery = PageFactory.initElements(driver, OperationOrderQuery.class);
		this.o_issueTicket = PageFactory.initElements(driver, OperationIssueTicket.class);
		this.o_issueTDetail = PageFactory.initElements(driver, OperationIssueTDetail.class);
		this.o_blackSearchOrder=PageFactory.initElements(driver, OperationBlackSearchOrder.class);
	}
	
	
	

}
