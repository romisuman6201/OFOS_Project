package com.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prokabbadipassingdataruntime {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String team="Bengaluru Bulls";
		String played = driver.findElement(By.xpath("//p[.='"+team+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-play']")).getText();
		
		String won=driver.findElement(By.xpath("//p[.='"+team+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-won']")).getText();
		System.out.println("played===>"+played+"  won = "+won);
	}

}
