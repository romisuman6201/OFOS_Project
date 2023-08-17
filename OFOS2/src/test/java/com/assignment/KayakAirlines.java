package com.assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakAirlines {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kayak.co.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@aria-label='Flight origin input']")).sendKeys("bengaluru");
		driver.findElement(By.xpath("//input[@aria-controls='flight-destination-smarty-input-list']")).click();
		driver.findElement(By.xpath("//input[@class='PVIO-input'][1]")).click();
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
		driver.findElement(By.xpath("//div[text()='August 2023']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']//div[text()='29']")).click();
		driver.findElement(By.xpath("//div[text()='September 2023']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']//div[text()='6']")).click();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		

	}

}
