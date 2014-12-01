package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends Page{
	
	public ElementsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="ta1")
	private WebElement textbox1;
	
	@FindBy(id="but2")
	private WebElement button2;
	
	public static ElementsPage navigateTo(WebDriver driver, String base_url)
	{
		driver.navigate().to(base_url);
		return PageFactory.initElements(driver, ElementsPage.class);
	}
	
	public void populateTextbox1(String text)
	{
		textbox1.sendKeys(text);
	}
	
	public void clickButton2()
	{
		button2.click();
	}

}
