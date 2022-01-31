package com.email.outlook.po;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class PO_Login {
WebDriver driver;
	
	public PO_Login(WebDriver driver) {
		this.driver=driver;
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
	
	public void Home() {
		home.click();
		Reporter.log("Navigating to Login Page",true);
	}
	
	public void SetEmail(String uname) {
		waitforVisible(driver, txt_email);
		txt_email.sendKeys(uname);
		Reporter.log("Email entered: "+ uname,true);
	}
	public void ClickNextButton() {
		waitforVisible(driver, txt_email);
		btn_next.click();
		Reporter.log("Next button clicked",true);
	}
	public void SetPassword(String pwd) {
		waitforVisible(driver, txt_passwd);
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
	
	public void waitforVisible(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(2000);
			System.out.println("Waiting for visibility");
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
