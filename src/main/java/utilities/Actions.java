package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Actions(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);
	}
	
	public void clickElement(WebElement e)
	{
		wait.until(ExpectedConditions.elementToBeClickable(e));
		e.click();
	}
	
	public void typeText(WebElement e, String text)
	{
		wait.until(ExpectedConditions.elementToBeClickable(e));
		e.sendKeys(text);
	}

}
