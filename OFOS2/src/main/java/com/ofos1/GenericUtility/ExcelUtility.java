package com.ofos1.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility extends JavaUtility {
	/**
	 * This methos is used to read the data from excel
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String ReadDataFromExcel(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}

	/**
	 * This method is used to write the data into the sheet
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public void writeDataintoExcel(String sheetName, int rowNo, int cellNo, String data)
			throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		wb.getSheet(sheetName).createRow(rowNo).createCell(cellNo).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);

	}

	/**
	 * This method is used to get the last row number
	 * 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;

	}

	/**
	 * This method is used to get multiple data from Excel sheet
	 * 
	 * @param sheetName
	 * @param keyColumn
	 * @param valueColumn
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public HashMap<String, String> getMultipleDataFromExcel(String sheetName, int keyColumn, int valueColumn)
			throws EncryptedDocumentException, IOException {
		// fetching data from excel
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		JavaUtility jLib = new JavaUtility();
		for (int i = 0; i <= count; i++) {
			String key = sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);

		}

		return map;

	}

	public Object[][] getDataFromExcel(String SheetName) throws Throwable, IOException {

		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("DP");
		int lastRow = sh.getLastRowNum();
		short lastCell = sh.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();

			}

		}
		return obj;

	}

}
