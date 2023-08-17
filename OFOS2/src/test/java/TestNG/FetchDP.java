package TestNG;

import org.testng.annotations.Test;

public class FetchDP {
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "data")
	public void getData(String src, String dst, int price) {

		System.out.println("source===>" + src + "destination====>" + dst + "price======>" + price);

	}

	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "data1")
	public void getData1(String src, String dst, int price) {

		System.out.println("source===>" + src + "destination====>" + dst + "price======>" + price);

	}

	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "data2")
	public void getStudentDetails(String Name, String College, int RollNo, String place) {

		System.out.println("source===>" + Name + "destination====>" + College + "Roll Number======>" + RollNo
				+ "Place======>+place");

	}

}
