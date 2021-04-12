package com.Guru99Bank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "uid")
	WebElement txtUserName;
	
	@FindBy(name = "password")
	WebElement txtPassWord;
	
	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	
	@FindBy(name = "btnReset")
	WebElement btnReset;
	
	
	public void setUserName(String uname) {
		
		txtUserName.sendKeys(uname);
	}
	
	public void setPasword(String pwd) {
		
		txtPassWord.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		
		btnLogin.click();;
	}
	public void clickReset() {
		
		btnReset.click();;
	}

}
