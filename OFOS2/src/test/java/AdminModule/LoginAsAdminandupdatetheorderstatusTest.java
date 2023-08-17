package AdminModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAsAdminandupdatetheorderstatusTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String AURL = pobj.getProperty("Adminurl");
		String AUN = pobj.getProperty("Ausername");
		String APW = pobj.getProperty("Adminpw");

		WebDriver driver = new ChromeDriver();

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(AURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(AUN);
		driver.findElement(By.name("password")).sendKeys(APW);
		driver.findElement(By.name("submit")).click();

		// click on order link button
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[8]/a[2]/i[1]")).click();
		driver.findElement(By.xpath("//button[text()='Update Order Status']")).click();
		//Set<String> parentandchild = driver.getWindowHandles();
		driver.close();

	}

}
