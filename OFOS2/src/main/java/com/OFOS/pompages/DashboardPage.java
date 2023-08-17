package com.OFOS.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	// declaration
	@FindBy(xpath = "//span[.='Users']")
	private WebElement UsersBtn;

	@FindBy(xpath = "//span[.='Restaurant']")
	private WebElement RestaurantBtn;

	@FindBy(xpath = "//a[.='All Restaurant']")
	private WebElement Allrestaurant;

	@FindBy(xpath = "//a[.='Add Category']")
	private WebElement Allcategory;

	@FindBy(xpath = "//a[.='Add Restaurant']")
	private WebElement Addrestaurant;

	@FindBy(xpath = "//span[.='Menu']")
	private WebElement Menubtn;

	@FindBy(xpath = "//a[.='All Menues']")
	private WebElement Allmenu;

	@FindBy(xpath = "//a[.='Add Menu']")
	private WebElement AddmenuBtn;

	@FindBy(xpath = "//span[.='Orders']")
	private WebElement OrdersBtn;

	// initialization
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// utilization

	public WebElement getUsersBtn() {
		return UsersBtn;
	}

	public WebElement getRestaurantBtn() {
		return RestaurantBtn;
	}

	public WebElement getAllrestaurant() {
		return Allrestaurant;
	}

	public WebElement getAllcategory() {
		return Allcategory;
	}

	public WebElement getAddrestaurant() {
		return Addrestaurant;
	}

	public WebElement getMenubtn() {
		return Menubtn;
	}

	public WebElement getAllmenu() {
		return Allmenu;
	}

	public WebElement getAddmenuBtn() {
		return AddmenuBtn;
	}

	public WebElement getOrdersBtn() {
		return OrdersBtn;
	}
	
	//business library
	public void clickrestbtn() {
		RestaurantBtn.click();
	}
	public void clickAddresbtn() {
		Addrestaurant.click();
	}
	public void clickmenu() {
		Menubtn.click();
	}
	public void clickaddmenu() {
		AddmenuBtn.click();
	}
	public void clickOrders() {
		OrdersBtn.click();
	}

	

}
