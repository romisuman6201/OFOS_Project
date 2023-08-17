package AdminModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.pompages.AdminLoginPage;
import com.OFOS.pompages.AdminMenuPage;
import com.OFOS.pompages.DashboardPage;
import com.ofos1.GenericUtility.ExcelUtility;
import com.ofos1.GenericUtility.FileUtility;
import com.ofos1.GenericUtility.JavaUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

public class Admin_addMenuTest extends WebDriverUtility {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		FileUtility futi=new FileUtility();
		WebDriverUtility webuti=new WebDriverUtility();
		ExcelUtility euti=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		String AURL = futi.readDataFromPropertyFile("Adminurl");
		String USERNAME = futi.readDataFromPropertyFile("Ausername");
		String PASSWORD = futi.readDataFromPropertyFile("Adminpw");
		webuti.maximize(driver);
		driver.get(AURL);
		webuti.waitForPageLoad(driver);
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.loginasAdmin(USERNAME, PASSWORD);
		DashboardPage dp=new DashboardPage(driver);
		dp.clickmenu();
		dp.clickaddmenu();
		AdminMenuPage amp=new AdminMenuPage(driver);
		amp.addmenu(euti.getMultipleDataFromExcel("Addmenu", 0, 1), driver,  jLib );
		amp.selectrestdrpdwn();
		//amp.selectrestdrpdwn();
		amp.menupagesavebtn();
		amp.dishadded();
		
		
		
		
		
	}

}
