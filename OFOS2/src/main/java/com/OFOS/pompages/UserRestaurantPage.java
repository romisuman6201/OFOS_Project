package com.OFOS.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRestaurantPage {
	
	String expectedItem="Yorkshire Lamb Patties";

	@FindBy(xpath = "//a[.='Yorkshire Lamb Patties']")
	private WebElement lambDish;

	@FindBy(xpath = "//div[@class='title-row']")
	private WebElement placedItemText;

	@FindBy(xpath = "//a[.='Checkout']")
	private WebElement checkoutbtn;

	@FindBy(xpath = "//a[.='Yorkshire Lamb Patties']/ancestor::div[@class='food-item']/descendant::input[@name='quantity']")
	private WebElement Quantitibox;

	@FindBy(xpath = "//a[.='Yorkshire Lamb Patties']/ancestor::div[@class='food-item']/descendant::input[@class='btn theme-btn' and @value='Add To Cart']")
	private WebElement AddtoCartbtn;
	

	public UserRestaurantPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getLambDish() {
		return lambDish;
	}

	public WebElement getPlacedItemText() {
		return placedItemText;
	}

	public WebElement getCheckoutbtn() {
		return checkoutbtn;
	}

	public WebElement getQuantitibox() {
		return Quantitibox;
	}

	public WebElement getAddtoCartbtn() {
		return AddtoCartbtn;
	}
	public void placeOrder(String itemCount) {
		Quantitibox.clear();
		Quantitibox.sendKeys(itemCount);
		AddtoCartbtn.click();
		String expectedItem = placedItemText.getText();
		if(expectedItem.contains("Yorkshire Lamb Patties")) {
			System.out.println("item successfully added to cart");
		}else {
			System.out.println("not added");
		}
		
	}
	public void chekclick() {
		checkoutbtn.click();
	}
	

}
