package com.OFOS.pompages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPaymentPage {
	
	@FindBy(xpath="//input[@value='Order Now']")
	private WebElement orderNowbtn;
	
	public UserPaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrderNowbtn() {
		return orderNowbtn;
	}
	public void payment() {
		orderNowbtn.click();
	}
	public void confirmOrder(WebDriver driver) {
		orderNowbtn.click();
		driver.switchTo().alert().accept();
		String expected="My Orders";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expected, "actual title and expected title are matched");
	}
	public void orderHasbeenPlaced(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	

}
