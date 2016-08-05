package com.selemium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.page.element.login.*;
import com.page.element.operation.*;
import com.page.element.purchase.*;

public class PageInitialize {

	public Login login;
	public OWhiteSearchOrder o_whiteSearchOrder;
	public OCreateOrder o_whiteCreateOrder;
	public OOrderDetail o_orderDetail;
	public OOrderQuery o_orderQuery;
	public OIssueTicket o_issueTicket;
	public OIssueTDetail o_issueTDetail;
	public OBlackSearchOrder o_blackSearchOrder;
	public PWhiteSearchOrder p_whiteSearchOrder;
	public PWhiteOrderDetail p_whiteOrderDetail;
	public PCreateOrder p_createOrder;
	public PPayment p_payment;
	public POrderDetail p_orderDetail;

	public PageInitialize(WebDriver driver) {
		this.login = PageFactory.initElements(driver, Login.class);
		this.o_whiteSearchOrder = PageFactory.initElements(driver, OWhiteSearchOrder.class);
		this.o_whiteCreateOrder = PageFactory.initElements(driver, OCreateOrder.class);
		this.o_orderDetail = PageFactory.initElements(driver, OOrderDetail.class);
		this.o_orderQuery = PageFactory.initElements(driver, OOrderQuery.class);
		this.o_issueTicket = PageFactory.initElements(driver, OIssueTicket.class);
		this.o_issueTDetail = PageFactory.initElements(driver, OIssueTDetail.class);
		this.o_blackSearchOrder = PageFactory.initElements(driver, OBlackSearchOrder.class);
		this.p_whiteSearchOrder = PageFactory.initElements(driver, PWhiteSearchOrder.class);
		this.p_whiteOrderDetail = PageFactory.initElements(driver, PWhiteOrderDetail.class);
		this.p_createOrder = PageFactory.initElements(driver, PCreateOrder.class);
		this.p_payment = PageFactory.initElements(driver, PPayment.class);
		this.p_orderDetail= PageFactory.initElements(driver, POrderDetail.class);
	}
}
