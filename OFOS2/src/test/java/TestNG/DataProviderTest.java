package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider = "data1")
	public void getData(String src,String dst,int price) {
		
		System.out.println("source===>"+src+"destination====>"+dst+"price======>"+price);
		
	}
	
	
	@DataProvider
	public Object[][] data(){
		Object[][] obj=new Object[2][3];
		obj[0][0]="Banglore";
		obj[0][1]="Mysore";
		obj[0][2]=1000;
		
		obj[1][0]="Chennai";
		obj[1][1]="Pune";
		obj[1][2]=500;
		return obj;
	}
	@DataProvider
	public Object[][] data1(){
		Object[][] obj=new Object[2][3];
		obj[0][0]="NewDelhi;";
		obj[0][1]="Kolkata";
		obj[0][2]=4000;
		
		obj[1][0]="Kolkata";
		obj[1][1]="Patna";
		obj[1][2]=1500;
		return obj;
	}
	@DataProvider
	public Object[][] data2(){
		Object[][] obj=new Object[2][4];
		obj[0][0]="Rahul kumar;";
		obj[0][1]="ANS College";
		obj[0][2]=1130;
		obj[0][3]="Patna";
		
		obj[1][0]="Gaurav kumar";
		obj[1][1]="Commerce College";
		obj[1][2]=1550;
		obj[1][3]="Jamui";
		return obj;

	}
}
