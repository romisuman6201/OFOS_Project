package com.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Icccountry {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> country = driver.findElements(By.xpath("(//table//tr[*]/td[2]/span[2])[position()<11]"));
        System.out.println(country.size());
        for (int i = 0; i < country.size(); i++) {
			String eachcountry = country.get(i).getText();
			System.out.println(eachcountry);
		}
	}

}
