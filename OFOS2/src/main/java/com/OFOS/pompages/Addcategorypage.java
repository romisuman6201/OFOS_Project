package com.OFOS.pompages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addcategorypage {
	// declaration
		@FindBy(name = "c_name")
		private WebElement CategoryTextField;
		
		@FindBy(name = "submit")
		private WebElement savebtn;
		
		@FindBy(xpath = "//a[.='Cancel']")
		private WebElement cancelbtn;
		
		@FindBy(xpath = "//img[@class='profile-pic']")
		private WebElement logoutlookupbtn;
		
		@FindBy(xpath = "//a[normalize-space()='Logout']")
		private WebElement logoutbtn;
		
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible fade show']")
		private WebElement confirmationtext;
		
		//initialazation
		
		public WebElement getConfirmationtext() {
			return confirmationtext;
		}

		public Addcategorypage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		public WebElement getCategoryTextField() {
			return CategoryTextField;
		}

		public WebElement getSavebtn() {
			return savebtn;
		}

		public WebElement getCancelbtn() {
			return cancelbtn;
		}

		public WebElement getLogoutlookupbtn() {
			return logoutlookupbtn;
		}

		public WebElement getLogoutbtn() {
			return logoutbtn;
		}
		
		//business library
		public void  addcategoryname(String ITEMCATOGRY,String conMsg) {
			CategoryTextField.sendKeys(ITEMCATOGRY);
			savebtn.click();
			String conmsg = confirmationtext.getText();
			assertEquals("New Category", conMsg);
//			if(conmsg.contains("New Category")) {
//				System.out.println("category is added");
//			}else {
//				System.out.println("category is not added");
//			}
		}

	
		

}
