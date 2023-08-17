package com.OFOS.pompages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	String Expurl="http://rmgtestingserver/domain/Online_Food_Ordering_System/login.php";

	// declaration
	@FindBy(xpath = "//a[.='Login']")
	private WebElement login;
	
	

	@FindBy(name = "username")
	private WebElement UserName;

	@FindBy(name = "password")
	private WebElement PassWord;

	@FindBy(name = "submit")
	private WebElement Loginbtn;

	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassWord() {
		return PassWord;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}

	public WebElement getLogin() {
		return login;
	}


	public void loginasUser(String USERNAME, String PASSWORD) {
		login.click();
		UserName.sendKeys(USERNAME);
		PassWord.sendKeys(PASSWORD);
		Loginbtn.click();
	}
	public void userLoginStatus(WebDriver driver) {
		String expected="Home";
		String actual = driver.getTitle();
		assertEquals(actual, expected);
//		if(Expurl.contains("login")) {
//			System.out.println("User Successfully logged to application");
//		}else {
//			System.out.println("User unable to logged to application");
//		}
		
	}

}
