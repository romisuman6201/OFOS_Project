package TestNG;

import org.testng.annotations.Test;

public class TestNGTest {
	
	@Test(enabled = false)
	public void create() {
		//int [] a= {10,20,30,40,50};
		System.out.println("----------create---------");
	}
	@Test(priority = 1 ,dependsOnMethods = "create",invocationCount = 3)
	public void edit() {
		System.out.println("------edit-------");
	}
	@Test()
	public void delete() {
		System.out.println("------delete-------");
	}
    
}
