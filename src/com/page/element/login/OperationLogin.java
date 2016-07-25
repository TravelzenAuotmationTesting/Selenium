package com.page.element.login;

import org.openqa.selenium.WebDriver;

import com.data.generation.LoginData;
import com.page.element.base.LoginBase;

public class OperationLogin extends LoginBase {

	private LoginData logindata;
	
	public LoginData getLogindata() {
		return logindata;
	}

	public void setLogindata(LoginData logindata) {
		this.logindata = logindata;
	}
	
	public OperationLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void loginOperation() {
		usernametxt.sendKeys(logindata.username);
		passwordtxt.sendKeys(logindata.password);
		loginbtn.click();
	}
}
