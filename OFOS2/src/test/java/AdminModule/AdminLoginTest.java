package AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.pompages.AdminLoginPage;
import com.ofos1.GenericUtility.BaseClass;
import com.ofos1.GenericUtility.WebDriverUtility;

public class AdminLoginTest extends BaseClass {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin");
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.loginasAdmin("admin", "codeastro");
		

	}

}
