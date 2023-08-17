package AdminModule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ofos1.GenericUtility.FileUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

public class Admin_addminuandLogout_generic {

	public static void main(String[] args) throws IOException, InterruptedException {
		//create a object of fileutility
		FileUtility flib=new FileUtility();
		//create a object of webdriverutility
		
		WebDriverUtility webuti=new WebDriverUtility();
		String BROWSER = flib.readDataFromPropertyFile("browser");
		String AURL = flib.readDataFromPropertyFile("Adminurl");
		String AUN = flib.readDataFromPropertyFile("Ausername");
		String APW = flib.readDataFromPropertyFile("Adminpw");
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
//		Properties pobj = new Properties();
//		pobj.load(fis);
//		String BROWSER = pobj.getProperty("browser");
//		String AURL = pobj.getProperty("Adminurl");
//		String AUN = pobj.getProperty("Ausername");
//		String APW = pobj.getProperty("Adminpw");

		//WebDriverManager.chromedriver().setup();
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		webuti.maximize(driver);
		//driver.manage().window().maximize();
		driver.get(AURL);
		webuti.waitForPageLoad(driver);
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(AUN);
		driver.findElement(By.name("password")).sendKeys(APW);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		driver.findElement(By.xpath("//a[text()='Add Menu']")).click();
		driver.findElement(By.name("d_name")).sendKeys("chola");
		driver.findElement(By.name("about")).sendKeys("bengaluru");
		driver.findElement(By.name("price")).sendKeys("10");
		driver.findElement(By.name("file")).sendKeys("C:\\Users\\ujjwa\\OneDrive\\Pictures\\Screenshots");
		Thread.sleep(5000);
		
		 WebElement res_name = driver.findElement(By.name("res_name"));
		webuti.selectbytext("Eataly",res_name );
	
		//s.selectByVisibleText("Eataly");
		Thread.sleep(3000);
		WebElement saveBtn = driver.findElement(By.xpath("//div[@class='card card-outline-primary']/descendant::input[@type='submit' and @value='Save']"));
		
		webuti.mousehover(driver, saveBtn);
		
		//Click on logout button
		//driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		
		
		
		
	}

}
