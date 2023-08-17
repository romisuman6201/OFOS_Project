package AdminModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginasAdminandDeletetheOrderTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		// Random random=new Random();
		// int randomnum = random.nextInt(100);
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String AURL = pobj.getProperty("Adminurl");
		String AUN = pobj.getProperty("Ausername");
		String APW = pobj.getProperty("Adminpw");

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
		driver.findElement(By.xpath("//span[text()='Orders']")).click();

		driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
		driver.switchTo().alert().accept();

	}

}
