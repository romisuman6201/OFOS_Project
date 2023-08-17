package RegisterApp;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ofos1.GenericUtility.DatabaseUtility;
import com.ofos1.GenericUtility.ExcelUtility;
import com.ofos1.GenericUtility.FileUtility;
import com.ofos1.GenericUtility.IpathConstants;
import com.ofos1.GenericUtility.JavaUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

public class Register_generic {

	public static void main(String[] args) throws IOException {
		DatabaseUtility bd=new DatabaseUtility();
		ExcelUtility exLib=new ExcelUtility();
		FileUtility fileLib=new FileUtility();
		JavaUtility jutility=new JavaUtility();
		WebDriverUtility webutility=new WebDriverUtility();
		
		String BROWSER=fileLib.readDataFromPropertyFile("browser");
	    String URL = fileLib.readDataFromPropertyFile("url");
	    String USERNAME = fileLib.readDataFromPropertyFile("username");
	    String PASSWORD = fileLib.readDataFromPropertyFile("password");
	    
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else {

			driver = new FirefoxDriver();
		}
		webutility.maximize(driver);
		driver.get(URL);
		webutility.waitForPageLoad(driver);
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		String path = IpathConstants.ExcelPath;
		int count = exLib.getLastRowNo("Registermap");
//		FileInputStream fim = new FileInputStream(".\\src\\test\\resources\\testdataM.xlsx");
//		Workbook wbm = WorkbookFactory.create(fim);
//		Sheet sh = wbm.getSheet("Registermap");
//		int rowcount = sh.getLastRowNum();

		// create a empty hashmap
		HashMap<String, String> map = new HashMap<String, String>();
		exLib.getMultipleDataFromExcel("Registermap", 0, 1, driver);
//		for (int i = 0; i < rowcount; i++) {
//			String key = wbm.getSheet("Registermap").getRow(i).getCell(0).getStringCellValue();
//			String value = wbm.getSheet("Registermap").getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//
//		}
//		// Enter the value in text field
//		for (Entry<String, String> Set : map.entrySet()) {
//			driver.findElement(By.name(Set.getKey())).sendKeys(Set.getValue());
//		}
		driver.findElement(By.name("submit")).click();

	}

}
