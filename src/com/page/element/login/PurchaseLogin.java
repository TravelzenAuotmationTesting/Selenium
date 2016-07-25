package com.page.element.login;

import org.openqa.selenium.WebDriver;

import com.data.generation.LoginData;
import com.page.element.base.LoginBase;

public class PurchaseLogin extends LoginBase {

	public LoginData logindata;

	public PurchaseLogin(WebDriver driver, LoginData logindata) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.logindata = logindata;
	}

	@Override
	public void loginOperation() {
		usernametxt.sendKeys(logindata.username);
		passwordtxt.sendKeys(logindata.password);
		loginbtn.click();
	}

}
