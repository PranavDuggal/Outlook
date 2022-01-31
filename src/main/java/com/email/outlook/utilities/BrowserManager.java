package com.email.outlook.utilities;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BrowserManager {
	static ReadConfig readconfig=new ReadConfig();
	public static WebDriver getDriver(String type,String url) {
		WebDriver driver = null;
		if(type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if(type.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			Assert.assertTrue(false);
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}