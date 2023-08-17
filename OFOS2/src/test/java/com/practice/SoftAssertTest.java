package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void SoftAssertTest() {
		String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		SoftAssert sa = new SoftAssert();
		System.out.println("-----------step1----------");
		System.out.println("-----------step2----------");
		System.out.println("-----------step3----------");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		String actual = driver.getTitle();
		System.out.println(actual);
		sa.assertEquals("actual", "expected");
		System.out.println("-----------step4----------");
		System.out.println("-----------step5----------");

		System.out.println("-----------step6----------");
		System.out.println("-----------step7----------");
		sa.assertAll();
	}
	@Test
	public void SoftAssertTest2() {
		SoftAssert sa = new SoftAssert();
		System.out.println("-----------step1----------");
		System.out.println("-----------step2----------");
		System.out.println("-----------step3----------");
		sa.assertNotEquals("A", "B");
		System.out.println("-----------step4----------");
		sa.assertAll();
	}
}
