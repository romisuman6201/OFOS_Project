package com.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartPhoneprice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElement(By.name("q")).sendKeys("iphone 14 plus"+Keys.ENTER);
	     
	     List<WebElement> link = driver.findElements(By.xpath("//div[contains(@class,'_4rR01T')]"));
	     List<WebElement> price = driver.findElements(By.xpath("//div[contains(@class,'_30jeq3_1_WHN1')]"));
	     
	     int count = link.size();
	     System.out.println(count);
	     for (int i = 0; i < count; i++) {
	    	 System.out.println(link.get(i).getText()+"    "+price.get(i).getText());
			
		}
	     driver.close();
//		searchbox.sendKeys("samsung");
//		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		List<WebElement> names = driver.findElements(By.xpath("//div[@data-id='TVSGDH3YEV9UC8P7']//a[2]"));
//        System.out.println(names.size());
	}

}
