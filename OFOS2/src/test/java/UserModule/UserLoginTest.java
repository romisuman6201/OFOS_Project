package UserModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.pompages.UserLoginPage;
import com.ofos1.GenericUtility.FileUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

public class UserLoginTest {

	public static void main(String[] args) throws IOException {
		FileUtility futi=new FileUtility();
		WebDriverUtility webuti=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		webuti.maximize(driver);
		String URL = futi.readDataFromPropertyFile("url");
		driver.get(URL);
		webuti.waitForPageLoad(driver);
		String USERNAME = futi.readDataFromPropertyFile("username");
		String PASSWORD = futi.readDataFromPropertyFile("password");
		UserLoginPage ult=new UserLoginPage(driver);
		ult.loginasUser(USERNAME, PASSWORD);
		ult.userLoginStatus();
		
		
		

	}

}
