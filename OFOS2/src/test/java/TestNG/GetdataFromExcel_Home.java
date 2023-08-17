package TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ofos1.GenericUtility.IpathConstants;

public class GetdataFromExcel_Home {
	@Test(dataProvider = "getData")
	public void fetchData() {
		
	}
	
	
    @DataProvider
	public Object[][] getData() throws Throwable, IOException {
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("DPHOME");
		int lastRow = sh.getLastRowNum() + 1;
		short lastCell = sh.getRow(0).getLastCellNum();
		Object [][] obj=new Object[lastRow][lastCell];

		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();

			}

		}
		return obj;
	}

}
