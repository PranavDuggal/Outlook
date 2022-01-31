package com.email.outlook.tc;

import java.util.Scanner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.email.outlook.po.*;
import com.email.outlook.utilities.*;

public class TC_Login {
	@Test
	@Parameters({"browser","url"})
	public void Login(String browser,String url) {
		try {
		Scanner sc = new Scanner(System.in);
		WebDriver driver = BrowserManager.getDriver(browser,url);
		PO_Login obj = PageFactory.initElements(driver,PO_Login.class);
		obj.Home();
		obj.SetEmail("pduggal1999@hotmail.com");
		obj.ClickNextButton();
		obj.SetPassword("unahbduggal11");
		obj.ClickSigninButton();
		obj.Checkbox();
		obj.Button();
		Reporter.log("Successfully Navigated to Account Page!!",true);
		Thread.sleep(3000);
		driver.close();
		
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

