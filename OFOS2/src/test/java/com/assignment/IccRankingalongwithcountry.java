package com.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccRankingalongwithcountry {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		List<WebElement> alldata = driver.findElements(By.xpath("//span[.='Team']/ancestor::table"));
//		System.out.println(alldata.size());
//		for (int i = 0; i < alldata.size(); i++) {
//			String data = alldata.get(i).getText();
//			System.out.println(data);
//
//		}
          List<WebElement> a = driver.findElements(By.xpath("//table//tr[*]//td[@class='rankings-block__banner--team-name']/following-sibling::td[@class='rankings-block__banner--matches']"));
          System.out.println(a.size());
          for (int i = 0; i < a.size(); i++) {
        	  System.out.println(a.get(i).getText());
        	  
			
		}
	}

}
