package TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ofos1.GenericUtility.IpathConstants;

public class DataPro_ExcelTest {
	@Test(dataProvider = "getDataFromExcel")
	public void fetchData(String Company, String Location, String State) {
		
		System.out.println(Company+" "+Location+" "+State);

	}

	@DataProvider

	public Object[][] getDataFromExcel() throws Throwable, IOException {

		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("DP");
		int lastRow = sh.getLastRowNum()+1;
		System.out.println(lastRow);
	
		short lastCell = sh.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRow ][lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();

			}

		}
		return obj;

	}

}
