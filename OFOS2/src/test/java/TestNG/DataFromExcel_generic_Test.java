package TestNG;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ofos1.GenericUtility.ExcelUtility;

public class DataFromExcel_generic_Test {

	@Test(dataProvider = "getData_generic")
	public void fetchData(String Company, String Location, String State) {
		System.out.println(Company + " " + Location + " " + State);

	}

	@DataProvider
	public Object[][] getData_generic() throws IOException, Throwable {
		ExcelUtility Elib = new ExcelUtility();
		Object[][] value = Elib.getDataFromExcel("DP");
		return value;

	}
}
