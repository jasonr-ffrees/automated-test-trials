package utilities;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@Listeners({Screenshot.class})
public class TestBase {
	
	private Configuration config = new Configuration();
	protected String base_url;
	public static WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setUp()
	{
		driver = selectDriver();
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
	
	private WebDriver selectDriver()
	{
		WebDriver driver = null;
		String browser = config.browser;
		String os = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		
		if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
			if(os.toLowerCase().contains("linux"))
			{
				if(arch.contains("64"))
				{
					System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_linux_64");
				}
			}				
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static WebDriver getDriverInstance()
	{
		return driver;
	}

}
