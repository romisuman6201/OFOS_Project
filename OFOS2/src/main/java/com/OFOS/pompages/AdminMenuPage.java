package com.OFOS.pompages;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ofos1.GenericUtility.JavaUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

public class AdminMenuPage {

	JavaUtility jLib = new JavaUtility();
	WebDriverUtility webuti = new WebDriverUtility();

	@FindBy(name = "d_name")
	private WebElement dishnamefield;

	@FindBy(name = "about")
	private WebElement descripfield;

	@FindBy(name = "price")
	private WebElement pricebox;

	@FindBy(name = "file")
	private WebElement imagebox;

	@FindBy(name = "res_name")
	private WebElement restdrpdwn;

	@FindBy(name = "submit")
	private WebElement savebtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible fade show']")
	private WebElement confirmmsg;


	public WebElement getConfirmmsg() {
		return confirmmsg;
	}

	public AdminMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDishnamefield() {
		return dishnamefield;
	}

	public WebElement getDescripfield() {
		return descripfield;
	}

	public WebElement getPricebox() {
		return pricebox;
	}

	public WebElement getImagebox() {
		return imagebox;
	}

	public WebElement getRestdrpdwn() {
		return restdrpdwn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void selectrestdrpdwn() {
		restdrpdwn.click();
		webuti.selectbytext("Nan Xiang Xiao Long Bao", restdrpdwn);

	}
	public void menupagesavebtn() {
		savebtn.click();
	}
	public void dishadded() {
//		String exp="New Restaurant Added Successfully";
		String succmsg  = confirmmsg.getText();
//		assertEquals(succmsg, exp);
	if(succmsg.contains("New Restaurant")) {
			System.out.println("dish is successfully added");
		}else {
			System.out.println("dish is not added");
		}
	}

	public void addmenu(HashMap<String, String> map, WebDriver driver, JavaUtility jLib) {
		for (Entry<String, String> set : map.entrySet()) {
			if (set.getKey().contains("Addmenu")) {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue() + jLib.getRandomNo());
			} else {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
		}

	}

}
