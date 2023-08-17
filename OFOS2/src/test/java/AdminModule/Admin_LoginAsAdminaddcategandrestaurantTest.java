package AdminModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.ofos1.GenericUtility.FileUtility;
import com.ofos1.GenericUtility.JavaUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin_LoginAsAdminaddcategandrestaurantTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		JavaUtility ju=new JavaUtility();
		int random = ju.getRandomNo();
		//Random random=new Random();
		//int randomnum = random.nextInt(100);
		FileUtility fu=new FileUtility();
		WebDriverUtility webuti=new WebDriverUtility();
		
		String BROWSER = fu.readDataFromPropertyFile("browser");
		String AURL = fu.readDataFromPropertyFile("Adminurl");
		String AUN = fu.readDataFromPropertyFile("Ausername");
		String APW = fu.readDataFromPropertyFile("Adminpw");
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
		driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
		driver.findElement(By.xpath("//a[text()='Add Category']")).click();
		driver.findElement(By.name("c_name")).sendKeys("Raj_jayka12"+random);
		driver.findElement(By.name("submit")).click();
		String text = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']"))
				.getText();
		System.out.println(text);
		if (text.contains("New Category Added Successfully.")) {
			System.out.println("category is added");
		} else {
			System.out.println("not added");
		}

		driver.findElement(By.xpath("//a[text()='Add Restaurant']")).click();
		FileInputStream fires = new FileInputStream(".\\src\\test\\resources\\testdataM.xlsx");
		Workbook wbRestaurant = WorkbookFactory.create(fires);
		int rowcount = wbRestaurant.getSheet("Restaurant").getLastRowNum();
		HashMap<String, String> mapRes = new HashMap<String, String>();
		Select sopenhr = new Select(driver.findElement(By.name("o_hr")));
		sopenhr.selectByVisibleText("6am");
		Select sclosehr = new Select(driver.findElement(By.name("c_hr")));
		sclosehr.selectByVisibleText("11pm");
		Select sdays = new Select(driver.findElement(By.name("o_days")));
		sdays.selectByVisibleText("Mon-Tue");
		//WebElement choosefile = driver.findElement(By.name("file"));
		driver.findElement(By.name("file")).sendKeys("C:\\Users\\ujjwa\\OneDrive\\Pictures\\Screenshots");
		
		WebElement cname = driver.findElement(By.name("c_name"));
		webuti.selectbytext("Italian", cname);
		//cname.selectByVisibleText("Italian");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"," ");

		for (int i = 0; i < rowcount; i++) {
			String key = wbRestaurant.getSheet("Restaurant").getRow(i).getCell(0).getStringCellValue();
			String value = wbRestaurant.getSheet("Restaurant").getRow(i).getCell(1).getStringCellValue();
			mapRes.put(key, value);

		}
		for (Entry<String, String> Set : mapRes.entrySet()) {
			driver.findElement(By.name(Set.getKey())).sendKeys(Set.setValue(text));

		}
		Thread.sleep(5000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);

	}

}
