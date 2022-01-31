package com.email.outlook.po;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PO_Mails{
WebDriver driver;
	
	public PO_Mails(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH,using = "/html/body/header/div/aside/div/nav/ul/li[2]/a")
	private WebElement home;
	
	@FindBy(how=How.NAME,using = "loginfmt")
	private WebElement txt_email;
	
	@FindBy(how=How.ID,using ="idSIButton9")
	private WebElement btn_next;
	
	@FindBy(how=How.NAME,using = "passwd")
	private WebElement txt_passwd;
	
	@FindBy(how=How.XPATH,using = "/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[4]/div[2]/div/div/div/div/input")
	private WebElement button_signin;
	
	@FindBy(how=How.ID,using="KmsiCheckboxField")
	private WebElement checkbox;
	
	@FindBy(how=How.ID,using="idBtn_Back")
	private WebElement button;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"usernameError\"]/text()[1]")
	private WebElement failure; 
	
	public void Home() {
		home.click();
		Reporter.log("Navigating to Login Page",true);
	}
	
	public void SetEmail(String uname) throws NoSuchSessionException {
		if(valEmail(uname)==true) {
		
		txt_email.sendKeys(uname);
		Reporter.log("Email Address entered: "+ uname,true);}
		
//		else if(uname.equals(failure)) {
//			Reporter.log("Invalid Email Address entered ",true);
//			driver.close();
//		}
		else {
			Reporter.log("Invalid Email Address entered ",true);
			driver.close();
			
		}
		
	}
	public void ClickNextButton() {
		
		btn_next.click();
		Reporter.log("Next button clicked",true);
	}
	public void SetPassword(String pwd) {
		
		txt_passwd.sendKeys(pwd);
		Reporter.log("Password Entered: " + pwd,true);
	}
	
	public void ClickSigninButton() {
		
		button_signin.click();
		Reporter.log("Sign In button clicked",true);
	}
	
	public void Checkbox() {
		
		checkbox.click();
		Reporter.log("Checkbox clicked",true);
	}
	
	public void Button() {
		
		button.click();
		Reporter.log("Button Clicked",true);
	}
	

	
	@FindBy(how=How.CLASS_NAME,using="_2ZDUqsleGa-jar5wAYvVzV")
	private List<WebElement> unreademails;
	
	public void Unread() {
		String Mailer = "Pranav Duggal";
		
		for(int i=0;i<unreademails.size();i++) {
			if(unreademails.get(i).isDisplayed()==true){
	            
	            if(unreademails.get(i).getText().equals(Mailer)){
	            	int count = unreademails.size();
	                System.out.println(count+ " mails from " + Mailer);
	                break;
	            }else{
	                System.out.println("No mail from " + Mailer);
	                break;
	            }
		}
	}
    
}
	public static boolean valEmail(String uname) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern emailPat = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPat.matcher(uname);
		return matcher.find();
	}
}