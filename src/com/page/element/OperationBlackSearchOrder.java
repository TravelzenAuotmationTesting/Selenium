package com.page.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.page.element.base.OperationTicketBase;
import com.selemium.utility.Utility;

public class OperationBlackSearchOrder extends OperationTicketBase {

	@FindBy(how = How.XPATH, xpath = "//input[@id='customerName']")
	public WebElement customerNameTxt;

	@FindBy(how = How.XPATH, xpath = "//input[@id='adultPnrCode']")
	public WebElement adultPnrCodeTxt;

	@FindBy(how = How.XPATH, xpath = "(//button[@name='auth_submit'])[1]")
	public WebElement adultPnrCodeCreateOrderBtn;

	@FindBy(how = How.XPATH, xpath = "(//textarea[@class='pnr-console pnrContentTextarea'])[1]")
	public WebElement adultPnrArea;

	@FindBy(how = How.XPATH, xpath = "(//button[@name='auth_submit'])[2]")
	public WebElement adultPnrTxtBtn;

	public OperationBlackSearchOrder(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void adultBlackDataInput(String customName, String PNRcode, String PNRText) {
		if (!customName.equals(null)) {
			customerNameTxt.sendKeys(customName);
		}
		if (!PNRcode.equals(null)){
			adultPnrCodeTxt.sendKeys(PNRcode);
		}
		if (!PNRText.equals(null))
		{
			adultPnrArea.click();
			adultPnrArea.sendKeys(PNRText);
		}
	}
	
	public void adultPnrCodeCreateOrderBtn_click()
	{
		adultPnrCodeCreateOrderBtn.click();
		Utility.waitURLnavigation(driver, 30, "blackScreen/createOrder");
	}
}
