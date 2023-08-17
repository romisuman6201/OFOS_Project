package com.OFOS.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ofos1.GenericUtility.WebDriverUtility;

public class AdminLoginPage extends WebDriverUtility {
	WebDriverUtility webuti=new WebDriverUtility();

	// declaration

	@FindBy(name = "username")
	private WebElement UserName;

	@FindBy(name = "password")
	private WebElement PassWord;

	@FindBy(name = "submit")
	private WebElement LgnBtn;
	
	@FindBy(xpath = "//img[@class='profile-pic']")
	private WebElement logOutLookupbtn;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement signOut;

	// initialazation

	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassWord() {
		return PassWord;
	}

	public WebElement getLgnBtn() {
		return LgnBtn;
	}
	//business logic
	public void loginasAdmin(String USERNAME,String PASSWORD) {
		UserName.sendKeys(USERNAME);
		PassWord.sendKeys(PASSWORD);
		LgnBtn.click();
	}
	public WebDriverUtility getWebuti() {
		return webuti;
	}

	public WebElement getLogOutLookupbtn() {
		return logOutLookupbtn;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public void logOutasAdmin(WebDriver driver) {
		logOutLookupbtn.click();
		webuti.mousehover(driver, signOut);
		
	}

}
