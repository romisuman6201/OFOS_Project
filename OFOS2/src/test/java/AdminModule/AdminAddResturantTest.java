package AdminModule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.pompages.AdminLoginPage;
import com.OFOS.pompages.Adminaddrestaurantpages;
import com.OFOS.pompages.DashboardPage;
import com.ofos1.GenericUtility.ExcelUtility;
import com.ofos1.GenericUtility.FileUtility;
import com.ofos1.GenericUtility.JavaUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

public class AdminAddResturantTest extends ExcelUtility {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		FileUtility fu = new FileUtility();
		WebDriverUtility webuti = new WebDriverUtility();
		DashboardPage dashpage = new DashboardPage(driver);
		ExcelUtility exuti = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		webuti.maximize(driver);
		AdminLoginPage al = new AdminLoginPage(driver);
		String AURL = fu.readDataFromPropertyFile("Adminurl");
		driver.get(AURL);
		webuti.waitForPageLoad(driver);

		String AUN = fu.readDataFromPropertyFile("Ausername");
		String APW = fu.readDataFromPropertyFile("Adminpw");
		al.loginasAdmin(AUN, APW);
		dashpage.clickrestbtn();
		dashpage.clickAddresbtn();

		Adminaddrestaurantpages arp = new Adminaddrestaurantpages(driver);
		arp.enterAllField(exuti.getMultipleDataFromExcel("AddRestaurant", 0, 1), driver, jLib);
		arp.opendrp();
		arp.closedrp();
		arp.openday();
		arp.selcategory();
		arp.clicksave();
		
       arp.restcreated();
	}

}
