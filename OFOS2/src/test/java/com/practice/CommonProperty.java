package com.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonProperty {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);

		String URL = pobj.getProperty("url");
		String Browser = pobj.getProperty("browser");
		String UN = pobj.getProperty("username");
		String PW = pobj.getProperty("password");

		System.out.println(URL);
		System.out.println(Browser);
		System.out.println(UN);
		System.out.println(PW);

		WebDriverManager.chromedriver().setup();
		WebDriver driver;

		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
         driver.get(URL);
         driver.findElement(By.name("username")).sendKeys(UN);
         driver.findElement(By.name("password")).sendKeys(PW);
         driver.findElement(By.id("buttn")).click();
	}

}
