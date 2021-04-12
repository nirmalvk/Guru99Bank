package com.Guru99Bank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties configFile;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			configFile = new Properties();
			configFile.load(fis);
		}
		catch (Exception e) {

			System.out.println(e.getMessage());
		}	

	}
	public String getAppURL() {

		String url = configFile.getProperty("baseURL");
		return url;

	}
	public String getUser() {

		String user = configFile.getProperty("username");
		return user;

	}
	public String getPass() {

		String pass = configFile.getProperty("password");
		return pass;

	}
	public String getChromePath() {

		String cPath = configFile.getProperty("chromepath");
		return cPath;

	}
	public String getFirefoxPath() {

		String cPath = configFile.getProperty("chromepath");
		return cPath;

	}

}
