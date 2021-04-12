package com.Guru99Bank.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.Guru99Bank.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() {
	
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(uname);
		logger.info("User Name Entered");
		lp.setPasword(pwd);
		logger.info("Password Entered");
		lp.clickSubmit();
		logger.info("Clicked Submit");
		assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		
	}

}
