package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MmtTest {

	public static void main(String[] args)
	{
		int date = 25;
		String Monthandyear = "june 2023";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String actualdate = "//div[text()='" + Monthandyear
				+ "']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='" + date + "']";
		String nextArrow = "//span[@aria-label='Next Month']";
		for (;;) 
			try {
				driver.findElement(By.xpath(actualdate)).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath(nextArrow)).click();
			}
	}
}


