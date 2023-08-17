package AdminModule;

import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OFOS.pompages.Adminaddrestaurantpages;
import com.OFOS.pompages.DashboardPage;
import com.ofos1.GenericUtility.BaseClass;

public class Admin_AddRestaurant_TestNGTest extends BaseClass {
	@Test
	public void Admin_AddRest() throws Throwable {
//		WebDriver driver = new ChromeDriver();
//		FileUtility fu = new FileUtility();
//		WebDriverUtility webuti = new WebDriverUtility();
		DashboardPage dashpage = new DashboardPage(driver);
//		ExcelUtility exuti = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		webuti.maximize(driver);
//		AdminLoginPage al = new AdminLoginPage(driver);
//		String AURL = fu.readDataFromPropertyFile("Adminurl");
//		driver.get(AURL);
//		webuti.waitForPageLoad(driver);
//
//		String AUN = fu.readDataFromPropertyFile("Ausername");
//		String APW = fu.readDataFromPropertyFile("Adminpw");
//		al.loginasAdmin(AUN, APW);
		dashpage.clickrestbtn();
		dashpage.clickAddresbtn();
		

		Adminaddrestaurantpages arp = new Adminaddrestaurantpages(driver);
		arp.enterAllField(eLib.getMultipleDataFromExcel("AddRestaurant", 0, 1), driver, jLib);
		arp.opendrp();
		arp.closedrp();
		arp.openday();
		arp.selcategory();
		arp.clicksave();
		fail();
		
       arp.restcreated();
		
	}

}
