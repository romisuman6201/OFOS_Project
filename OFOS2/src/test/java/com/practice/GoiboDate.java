package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoiboDate {

	public static void main(String[] args) {
		int date=25;
		String Monthandyear="September 2023";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String nextArrow = "//span[@aria-label='Next Month']";
		String actualDate = "//div[text()='"+Monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		for (;;) {
			try {
				driver.findElement(By.xpath(actualDate)).click();
				break;

			} catch (Exception e) {
				driver.findElement(By.xpath(nextArrow)).click();
			}

		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();

	}

}
