package com.ofos1.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method is used to maximize the window
	 * 
	 * @param driver
	 */

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait for page load
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to wait untill element to be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitUntillElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to handle dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * 
	 * @param text
	 * @param element
	 */

	public void selectbytext(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This methos will perform mousehover action
	 * 
	 * @param driver
	 * @param element
	 */

	public void mousehover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();

	}

	/**
	 * This method will perform drag and drop action
	 * 
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */

	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * 
	 * @param driver
	 */

	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */

	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 */

	public void enterKeyPress(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * 
	 * @param driver
	 * @throws AWTException
	 */

	public void enterKey(WebDriver driver) throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param driver
	 * @throws AWTException
	 */

	public void enterRelease(WebDriver driver) throws AWTException {
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */

	public void switchToframe(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param nameOrID
	 */

	public void switchToframe(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);

	}
	/**
	 * 
	 * @param driver
	 * @param address
	 */

	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}
	/**
	 * 
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		;
	}
	
	/**
	 * This method will switch between windows
	 * @param driver
	 * @param partialTitle
	 */

	public void switchToWindow(WebDriver driver,String partialTitle) {
		//step1:use getwindowHandles to capture all window id's
		
		Set<String> windows = driver.getWindowHandles();
		
		//step2:iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//Step3: check whether there is next window
		while(it.hasNext()) {
			//step4:capture current window id
			String winId = it.next();
			
			//step5:switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether current window is expected
			if(currentWinTitle.contains(partialTitle)) {
				break;
			}
		}
	}
		public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = ".\\screenshot\\"+screenShotName+".png";
			File dst = new File(path);
			FileUtils.copyFile(src, dst);
			return path;
			
		}
	
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)","");
	}
	
	
	/**
	 * This method will scroll until specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		//jse.executeScript("argument[0].scrollIntoView()", element);
	}

}
