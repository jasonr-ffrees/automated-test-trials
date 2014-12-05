package simple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.TestBase;
import utilities.TestListeners;

public class ReportTest extends TestBase{
	
	@Test(groups="report")
	public void reportTest()
	{
		driver.navigate().to("https://www.google.com");
		driver.findElement(By.id("no-element-here"));
	}
}
