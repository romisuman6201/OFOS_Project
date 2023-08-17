package com.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestDataMulti.xlsx");
		Workbook Wb = WorkbookFactory.create(fis);
		Sheet sh = Wb.getSheet("MULTIROW");
		int row = sh.getLastRowNum();
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			String orgName = sh.getRow(i).getCell(0).getStringCellValue();
			String loc = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(orgName+"--------->"+loc);
		}

	}

}
