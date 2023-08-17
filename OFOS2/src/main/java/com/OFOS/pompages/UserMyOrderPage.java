package com.OFOS.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMyOrderPage {
	@FindBy(xpath="//tbody/tr[7]/td[6]/a[1]/i[1]")
	private WebElement dltbtn;
	
	
	public UserMyOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void deleteOrder(WebDriver driver) {
		dltbtn.click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//table//tr[7]/td[1]")).getText();
	}

}
