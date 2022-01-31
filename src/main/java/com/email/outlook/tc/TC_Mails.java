package com.email.outlook.tc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.email.outlook.po.PO_Mails;
import com.email.outlook.utilities.BrowserManager;

public class TC_Mails {
	@Test
	@Parameters({"browser","url"})
	public void unreadmails(String browser,String url) throws InterruptedException, IOException{
		
			Scanner sc = new Scanner(System.in);
			WebDriver driver = BrowserManager.getDriver(browser,url);
			PO_Mails obj = PageFactory.initElements(driver,PO_Mails.class);
			obj.Home();
			obj.SetEmail(sc.next());
			obj.ClickNextButton();
			obj.SetPassword(sc.next());
			obj.ClickSigninButton();
			obj.Checkbox();
			obj.Button();
			Reporter.log("Successfully Navigated to Account Page!!",true);
			obj.Unread();
			Thread.sleep(3000);
			driver.close();
			
		
			
	}
}
