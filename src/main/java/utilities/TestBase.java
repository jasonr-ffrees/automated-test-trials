package utilities;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@Listeners({TestListeners.class})
public class TestBase {
	
	private Configuration config = new Configuration();
	protected String base_url;
	public static WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setUp()
	{
		driver = createDriverInstance();
		driver.manage().timeouts().implicitlyWait(config.timeout, TimeUnit.SECONDS);
		if(config.maximise)
		{
			driver.manage().window().maximize();
		}
		base_url = config.base_url;
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}
	
	private WebDriver createDriverInstance()
	{
		WebDriver driver = null;
		String browser = config.browser;
		String os = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		
		//firefox driver
		if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		//chrome driver
		else if(browser.equals("chrome"))
		{
			if(os.toLowerCase().contains("linux"))
			{
				if(arch.contains("32"))
				{
					System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_linux_32");
				}
				else if(arch.contains("64"))
				{
					System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_linux_64");
				}
			}
			else if(os.toLowerCase().contains("mac"))
			{
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_mac_32");
			}
			else if(os.toLowerCase().contains("windows"))
			{
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win_32.exe");
			}
			//catch if no valid os found
			else
			{
				Assert.fail("No valid Chrome Sriver was found for the operating system that you are using");
			}
			driver = new ChromeDriver();
		}
		else if(browser.equals("IE"))
		{
			if(arch.contains("32"))
			{
				System.setProperty("webdriver.ie.driver", "driver/iedriver_32.exe");
			}
			else if(arch.contains("64"))
			{
				System.setProperty("webdriver.ie.driver", "driver/iedriver_64.exe");
			}
		}
		//catch if no browser found
		if(driver==null)
		{
			Assert.fail("No driver found for the OS/browser combination selected");
		}
		return driver;
	}
	
	public static WebDriver getDriverInstance()
	{
		return driver;
	}
}
