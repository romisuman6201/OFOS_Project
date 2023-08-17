package AdminModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ofos1.GenericUtility.FileUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

public class Admin_AddCategoryTest extends WebDriverUtility {
	
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		FileUtility fu=new FileUtility();
		String AURL=fu.readDataFromPropertyFile("Adminurl");
		
	}

}
