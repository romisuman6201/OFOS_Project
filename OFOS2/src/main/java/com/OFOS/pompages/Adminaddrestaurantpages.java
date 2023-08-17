package com.OFOS.pompages;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Image;
import com.ofos1.GenericUtility.JavaUtility;
import com.ofos1.GenericUtility.WebDriverUtility;

public class Adminaddrestaurantpages {
	WebDriverUtility webuti = new WebDriverUtility();

	@FindBy(name = "res_name")
	private WebElement restaurantnametextfield;

	@FindBy(name = "email")
	private WebElement emailtextfield;

	@FindBy(name = "phone")
	private WebElement phonetextfield;

	@FindBy(name = "url")
	private WebElement weburltextfield;

	@FindBy(name = "o_hr")
	private WebElement openhrsdropdown;

	@FindBy(name = "c_hr")
	private WebElement closehrdropdown;

	@FindBy(name = "o_days")
	private WebElement opendayysdropdown;

	@FindBy(name = "file")
	private WebElement choosefile;

	@FindBy(name = "c_name")
	private WebElement selectcategorydrpdwn;

	@FindBy(name = "address")
	private WebElement addrestextfield;

	@FindBy(name = "submit")
	private WebElement savebtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible fade show']")
	private WebElement confirmmsg;

	// initialization

	public WebDriverUtility getWebuti() {
		return webuti;
	}

	public WebElement getConfirmmsg() {
		return confirmmsg;
	}

	public Adminaddrestaurantpages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getRestaurantnametextfield() {
		return restaurantnametextfield;
	}

	public WebElement getEmailtextfield() {
		return emailtextfield;
	}

	public WebElement getPhonetextfield() {
		return phonetextfield;
	}

	public WebElement getWeburltextfield() {
		return weburltextfield;
	}

	public WebElement getOpenhrsdropdown() {
		return openhrsdropdown;
	}

	public WebElement getClosehrdropdown() {
		return closehrdropdown;
	}

	public WebElement getOpendayysdropdown() {
		return opendayysdropdown;
	}

	public WebElement getChoosefile() {
		return choosefile;
	}

	public WebElement getSelectcategorydrpdwn() {
		return selectcategorydrpdwn;
	}

	public WebElement getAddrestextfield() {
		return addrestextfield;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	// business logic
	

	public void opendrp() {
		opendayysdropdown.click();

		webuti.selectbytext("7am", openhrsdropdown);

	}

	public void closedrp() {
		closehrdropdown.click();
		webuti.selectbytext("4pm", closehrdropdown);

	}

	public void openday() {
		opendayysdropdown.click();
		webuti.selectbytext("Mon-Tue", opendayysdropdown);

	}

	public void fileupload() {
		choosefile.click();
	}

	public void selcategory() {
		selectcategorydrpdwn.click();
		webuti.selectbytext("Italian", selectcategorydrpdwn);

	}
	public void clicksave() {
		savebtn.click();
	}
	public void restcreated() {
		String succmsg  = confirmmsg.getText();
		if(succmsg.contains("New Restaurant")) {
			System.out.println("Restaurant is successfully added");
		}else {
			System.out.println("Restaurant is not added");
		}
	}

//	public void enterAllField(String resName, String email, String phoneNum, String url) {
//		restaurantnametextfield.sendKeys(resName);
//		emailtextfield.sendKeys(email);
//		phonetextfield.sendKeys(phoneNum);
//		weburltextfield.sendKeys(url);

	public void enterAllField(HashMap<String, String> map, WebDriver driver, JavaUtility jLib) {
		for (Entry<String, String> set : map.entrySet()) {
			if (set.getKey().contains("AddRestaurant")) {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue() + jLib.getRandomNo());
			} else {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
		}
	}

}
