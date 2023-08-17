package com.OFOS.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModifyOrderStatusPage {
	
	@FindBy(xpath="//tbody/tr[3]/td[8]/a[2]/i[1]")
	private WebElement editBtn;
	

	public ModifyOrderStatusPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getEditBtn() {
		return editBtn;
	}
	public void clickEditbutton() {
		editBtn.click();
	}

}
