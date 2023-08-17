package com.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNg_Annotation {
	@BeforeSuite
	public void Connfig_BS() {
		System.out.println("=========Connect to DB=====");
	}
	@BeforeClass
	public void Connfig_BC() {
		System.out.println("=========Launch the Browser=====");
	}
	@BeforeMethod
	public void Connfig_BM() {
		System.out.println("=========Login to Application=====");
	}
	@Test
	public void Test1() {
		System.out.println("======Successfully Executed Test1======");
	}
	@Test
	public void Test2() {
		System.out.println("Successfully Executed Test2");
		
	}
	@AfterMethod
	public void Connfig_AM() {
		System.out.println("=========Logout the Application=====");
	}
	@AfterClass
	public void Connfig_AC() {
		System.out.println("=========close the Browser=====");
		
	}
	@AfterSuite
	public void Connfig_AS() {
		System.out.println("=========Close the Database=========");
	}

}
