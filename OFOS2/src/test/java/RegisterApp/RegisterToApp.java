package RegisterApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterToApp {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		Properties pobj = new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");

		System.out.println(URL + "  " + BROWSER + "  " + USERNAME + "  " + PASSWORD);

		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else {

			driver = new FirefoxDriver();
		}
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\testdataM.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		String Username = wb.getSheet("REGISTER").getRow(1).getCell(0).getStringCellValue();
		String Firstname = wb.getSheet("REGISTER").getRow(1).getCell(1).getStringCellValue();
		String Lastname = wb.getSheet("REGISTER").getRow(1).getCell(2).getStringCellValue();
		String Email = wb.getSheet("REGISTER").getRow(1).getCell(3).getStringCellValue();
		String Mobno = wb.getSheet("REGISTER").getRow(1).getCell(4).getStringCellValue();
		String pw = wb.getSheet("REGISTER").getRow(1).getCell(5).getStringCellValue();
		String Cpw = wb.getSheet("REGISTER").getRow(1).getCell(6).getStringCellValue();
		String Add = wb.getSheet("REGISTER").getRow(1).getCell(7).getStringCellValue();
		
		
//		driver.findElement(By.name("username")).sendKeys("romisuman");
//		driver.findElement(By.name("firstname")).sendKeys("romi");
//		driver.findElement(By.name("lastname")).sendKeys("kumar");
//		driver.findElement(By.name("email")).sendKeys("romisuman@gmail.com");
//		driver.findElement(By.name("phone")).sendKeys("6301987778");
//		driver.findElement(By.name("password")).sendKeys("123456789");
//		driver.findElement(By.name("cpassword")).sendKeys("123456789");
//		driver.findElement(By.name("address")).sendKeys("H-102");
//		driver.findElement(By.name("submit")).click();

		// enter data by using excel

//		driver.findElement(By.name("username")).sendKeys(Username);
//		driver.findElement(By.name("firstname")).sendKeys(Firstname);
//		driver.findElement(By.name("lastname")).sendKeys(Lastname);
//		driver.findElement(By.name("email")).sendKeys(Email);
//		driver.findElement(By.name("phone")).sendKeys(Mobno);
//		driver.findElement(By.name("password")).sendKeys(pw);
//		driver.findElement(By.name("cpassword")).sendKeys(Cpw);
//		driver.findElement(By.name("address")).sendKeys(Add);
//		driver.findElement(By.name("submit")).click();

		// Fetch data from excel by using map

//		FileInputStream fim = new FileInputStream(".\\src\\test\\resources\\testdataM.xlsx");
//		Workbook wbm = WorkbookFactory.create(fim);
//		int rowcount = wbm.getSheet("REGISTER").getLastRowNum();
//
//		// create a empty hashmap class
//		HashMap<String, String> map = new HashMap<String, String>();
//		for (int i = 0; i < rowcount; i++) {
//			String key = wbm.getSheet("REGISTER").getRow(i).getCell(0).getStringCellValue();
//			String value = wbm.getSheet("REGISTER").getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//
//		}
//		// Enter the value in text field
//		for (Entry<String, String> Set : map.entrySet()) {
//			driver.findElement(By.name(Set.getKey())).sendKeys(Set.getValue());
//		}
//		driver.findElement(By.name("submit")).click();

	}

}
