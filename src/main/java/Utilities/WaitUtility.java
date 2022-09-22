package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;
	public static final long IMPLICIT_WAIT = 20;


	public static void waitForElementToBeClickable(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable ((target)));

	}
	public static void waitForElementToBePresent(WebDriver driver, WebElement target,String value) {
		WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(target, value));

	}
	public static void waitForanElementVisible(WebDriver driver, WebElement target){
		WebDriverWait wait=new WebDriverWait(driver,TimeUnit.SECONDS.toSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	
	
}
