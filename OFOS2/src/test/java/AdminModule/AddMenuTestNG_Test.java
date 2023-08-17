package AdminModule;

import org.testng.annotations.Test;

import com.OFOS.pompages.AdminMenuPage;
import com.OFOS.pompages.DashboardPage;
import com.ofos1.GenericUtility.BaseClass;

public class AddMenuTestNG_Test extends BaseClass {
	@Test(groups = {"Smoke"})
	public void addMenu() throws Throwable {

		// AdminLoginPage alp=new AdminLoginPage(driver);
		// alp.loginasAdmin(USERNAME, PASSWORD);
		DashboardPage dp = new DashboardPage(driver);
		dp.clickmenu();
		dp.clickaddmenu();
		AdminMenuPage amp = new AdminMenuPage(driver);
		amp.addmenu(eLib.getMultipleDataFromExcel("Addmenu", 0, 1), driver, jLib);
		amp.selectrestdrpdwn();
		// amp.selectrestdrpdwn();
		amp.menupagesavebtn();
		amp.dishadded();

	}

}
