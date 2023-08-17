package com.ofos1.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.OFOS.pompages.AdminLoginPage;

public class BaseClass {

	public DatabaseUtility dLib = new DatabaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite
	public void Config_BS() throws Throwable {
		dLib.connectToDB();
		System.out.println("======connect to DB");
	}

	
	@BeforeClass

	public void Config_BC() throws IOException {
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriver driver = new EdgeDriver();

		} else {
			driver = new FirefoxDriver();

		}
		sdriver=driver;
		System.out.println("Launch the browser");
		wLib.maximize(driver);

	}

	@BeforeMethod
	public void Config_BM() throws IOException {
//		String USERNAME = fLib.readDataFromPropertyFile("username");
//		String PASSWORD = fLib.readDataFromPropertyFile("password");
//		String URL = fLib.readDataFromPropertyFile("url");
//		driver.get(URL);
//		wLib.waitForPageLoad(driver);
//
//		UserLoginPage lp = new UserLoginPage(driver);
//		lp.loginasUser(USERNAME, PASSWORD);
//		System.out.println("Login To application");

		String AUSERNAME = fLib.readDataFromPropertyFile("Ausername");
		String APASSWORD = fLib.readDataFromPropertyFile("Adminpw");
		String AURL = fLib.readDataFromPropertyFile("Adminurl");
		driver.get(AURL);
		wLib.waitForPageLoad(driver);
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginasAdmin(AUSERNAME, APASSWORD);
		System.out.println("Admin login to application");

	}

	@AfterMethod
	public void Config_AM() {
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.logOutasAdmin(driver);
		System.out.println("logOut as admin");
	}

	@AfterClass
	public void Config_AC() {
		driver.quit();
		System.out.println("Close the browser");
	}

	@AfterSuite
	public void Config_AS() throws Throwable {
		dLib.closeDB();
		System.out.println("Close the database");
	}

}