package RegisterApp;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ofos1.GenericUtility.DatabaseUtility;
import com.ofos1.GenericUtility.ExcelUtility;
import com.ofos1.GenericUtility.FileUtility;
import com.ofos1.GenericUtility.JavaUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

public class RegisterToApp_generic {

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
		
		
		
		
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
//
//		Properties pobj = new Properties();
//		pobj.load(fis);
//		String URL = pobj.getProperty("url");
//		String BROWSER = pobj.getProperty("browser");
//		String USERNAME = pobj.getProperty("username");
//		String PASSWORD = pobj.getProperty("password");

		System.out.println(URL + "  " + BROWSER + "  " + USERNAME + "  " + PASSWORD);

		
		WebDriver driver;
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		} else {
			
			driver = new FirefoxDriver();
		}
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		
		

	}

}
