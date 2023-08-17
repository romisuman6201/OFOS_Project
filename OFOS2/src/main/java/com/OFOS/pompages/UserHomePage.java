package com.OFOS.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {

	@FindBy(xpath="//a[.='Yorkshire Lamb Patties']")
	private WebElement lambDish;
	
	@FindBy(xpath="//a[.='Lobster Thermidor']")
	private WebElement LobsterDish;
	
	@FindBy(xpath="//a[.='Chicken Madeira']")
	private WebElement chickenDish;
	
	@FindBy(xpath="//a[.='Stuffed Jacket Potatoes']")
	private WebElement potatosDish;
	
	@FindBy(xpath="//a[.='Pink Spaghetti Gamberoni']")
	private WebElement spaghettiDish;
	
	@FindBy(xpath="//a[.='Cheesy Mashed Potato']")
	private WebElement MashedpotatosDish;
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement Logout;
	
	//initialization
	
	public WebElement getLogout() {
		return Logout;
	}

	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLambDish() {
		return lambDish;
	}

	public WebElement getLobsterDish() {
		return LobsterDish;
	}

	public WebElement getChickenDish() {
		return chickenDish;
	}

	public WebElement getPotatosDish() {
		return potatosDish;
	}

	public WebElement getSpaghettiDish() {
		return spaghettiDish;
	}

	public WebElement getMashedpotatosDish() {
		return MashedpotatosDish;
	}
	public void selectLambdish() {
		lambDish.click();
	}
	
	
	public void selectLobsterdish() {
		LobsterDish.click();
	}
	

	public void signOut() {
		Logout.click();
		
	}
	
	

}
