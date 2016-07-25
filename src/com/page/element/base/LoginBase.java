package com.page.element.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;

public abstract class LoginBase {
	
	public WebDriver driver;
	
	@FindBy(how=How.XPATH,xpath="//input[@type='text' and @name='username']")
	public WebElement usernametxt;
	
	@FindBy(how=How.XPATH,xpath="//input[@type='password' and @name='password']")
	public WebElement passwordtxt;
	
	@FindBy(how=How.XPATH,xpath="//input[@type='submit' and @name='login']")
	public WebElement loginbtn;
	
	
	public LoginBase(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public abstract void loginOperation();

}
