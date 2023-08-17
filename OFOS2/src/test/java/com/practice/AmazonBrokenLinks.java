package com.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBrokenLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		System.out.println(alllinks.size());
		ArrayList<String> link = new ArrayList<String>();
		for (int i = 0; i < alllinks.size(); i++) {
			String eachlink = alllinks.get(i).getAttribute("href");
			URL url = null;
			int statuscode = 0;
			try {
				url = new URL(eachlink);
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				statuscode = httpURLConnection.getResponseCode();
				if (statuscode >= 400) {
					link.add(eachlink + "==========>" + statuscode);
				}
			} catch (Exception e) {
				link.add(eachlink + "==========>" + statuscode);
			}

		}

	}
}
