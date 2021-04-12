package com.Guru99Bank.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Guru99Bank.pageObjects.LoginPage;
import com.Guru99Bank.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "loginCredentials")
	public static void loginTestDDT(String usr,String pwd) {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(usr);
		lp.setPasword(pwd);
		lp.clickSubmit();
		
		if (isAlertPresent() == true) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			
			Assert.assertTrue(true);
		}
		
		
		
	}
	@DataProvider(name = "loginCredentials")
	String[][] loginData() throws IOException{
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/Guru99Bank/testData/Book1.xlsx";
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		
		String[][] cellData = new String[rowCount][colCount];
		
		for (int i=1;i<=rowCount;i++) {
			
			for(int j=0;j<colCount;j++) {
				
				cellData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return cellData;
	}
	public static boolean isAlertPresent() {
		
		try {
			
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
			
			return false;
			
		}
	}
	
}
