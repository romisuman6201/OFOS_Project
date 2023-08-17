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

public class StudentMangSystem {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		ArrayList<String> link = new ArrayList<String>();
		for (int i = 0; i < allLinks.size(); i++) {
			String eachLink = allLinks.get(i).getAttribute("href");
			URL url = null;
			int statusCode = 0;
			try {
				url = new URL(eachLink);
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				statusCode = httpURLConnection.getResponseCode();
				if (statusCode >= 400) {
					link.add(eachLink + "=========>" + statusCode);
				}
			} catch (Exception e) {
				link.add(eachLink + "=========>" + statusCode);
			}

		}
		System.out.println(link);

	}

}
