package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2Test {
	@Test(dataProvider = "data1")
	public void getData2(String Fname, String Lname, int Marks, int ObtMarks) {
		System.out.println(
				"Country======>" + Fname + "======>Distance" + Lname + "destination==>" + Marks + "====>" + ObtMarks);

	}

	@DataProvider
	public Object[][] data1() {
		Object[][] obj = new Object[2][4];
		obj[0][0] = "Rohan";
		obj[0][1] = "Kumar";
		obj[0][2] = 500;
		obj[0][3] = 384;

		obj[1][0] = "Rohit";
		obj[1][1] = "Gupta";
		obj[1][2] = 500;
		obj[1][3] = 400;
		return obj;

	}

}
