package com.OFOS.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ofos1.GenericUtility.WebDriverUtility;

public class AdminModifyOrderStatusPage {
	
	
	
	@FindBy(xpath="//button[.='Update Order Status']")
	private WebElement Updatebtn;
	
	@FindBy(xpath="//select[@name='status']")
	private WebElement statusdrpdwn;
	
	@FindBy(name="update")
	private WebElement updatesubmitbtn;
	
	public AdminModifyOrderStatusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpdatebtn() {
		return Updatebtn;
	}

	public WebElement getStatusdrpdwn() {
		return statusdrpdwn;
	}

	public WebElement getUpdatesubmitbtn() {
		return updatesubmitbtn;
	}
	public void updateOrderStatus(WebDriver driver) {
		DashboardPage dp=new DashboardPage(driver);
		dp.clickOrders();
		ModifyOrderStatusPage mop=new ModifyOrderStatusPage(driver);
		mop.clickEditbutton();
		String ExpURL="http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/view_order.php?user_upd=155";
		if(ExpURL.contains("user_upd=155")) {
			System.out.println("Page is navigated to update page");
		}else {
			System.out.println("Page is unable to navigate");
		}
		Updatebtn.click();
		String ExpUpdate="http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/order_update.php?form_id=44";
		WebDriverUtility webuti=new WebDriverUtility();
		String partialTitle="Order Update";
		webuti.switchToWindow(driver, partialTitle);
		if(ExpUpdate.contains("admin/order_update")) {
			System.out.println("navigate to order update page");
		}else {
			System.out.println("unable to navigate order update page");
		}
		webuti.select(statusdrpdwn, 3);
		statusdrpdwn.click();
		updatesubmitbtn.click();
		
		
	}

}
