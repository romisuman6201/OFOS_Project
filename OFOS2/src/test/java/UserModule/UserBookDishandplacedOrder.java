package UserModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.pompages.UserHomePage;
import com.OFOS.pompages.UserLoginPage;
import com.OFOS.pompages.UserPaymentPage;
import com.OFOS.pompages.UserRestaurantPage;
import com.ofos1.GenericUtility.BaseClass;
import com.ofos1.GenericUtility.FileUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

public class UserBookDishandplacedOrder extends BaseClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		FileUtility futi=new FileUtility();
		WebDriverUtility webuti=new WebDriverUtility();
		webuti.maximize(driver);
		String URL = futi.readDataFromPropertyFile("url");
		String USERNAME = futi.readDataFromPropertyFile("username");
		String PASSWORD = futi.readDataFromPropertyFile("password");
		driver.get(URL);
		webuti.waitForPageLoad(driver);
		UserLoginPage ulp=new UserLoginPage(driver);
		ulp.loginasUser(USERNAME, PASSWORD);
		UserHomePage uhp=new UserHomePage(driver);
		uhp.selectLambdish();
		UserRestaurantPage urp=new UserRestaurantPage(driver);
		urp.placeOrder("10");
		urp.chekclick();
		
		
		UserPaymentPage upp=new UserPaymentPage(driver);
		
		upp.payment();
		upp.confirmOrder(driver);
				
		
		
		
		
	}

}
