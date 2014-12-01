package pages;

import org.openqa.selenium.WebDriver;

import utilities.Actions;

public class Page {
	
	public WebDriver _driver;
	public Actions actions;
	
	public Page(WebDriver driver)
	{
		this._driver = driver;
		this.actions = new Actions(this._driver);
	}

}
