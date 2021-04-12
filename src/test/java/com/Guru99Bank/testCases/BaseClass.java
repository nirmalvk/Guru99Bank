package com.Guru99Bank.testCases;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Guru99Bank.utilities.ReadConfig;


public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String baseURL = readConfig.getAppURL();
	public String uname = readConfig.getUser();
	public String pwd = readConfig.getPass();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = Logger.getLogger("Guru99Test");
		PropertyConfigurator.configure("log4j.properties");

		//		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
		//		driver = new ChromeDriver();

		if (br.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();


		}
		else if (br.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new ChromeDriver();

		}
		else {

			System.out.println("Invalid Browser");

		}
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown() {


		driver.quit();

	}


}
