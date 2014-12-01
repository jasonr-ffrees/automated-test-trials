package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Configuration {
	
	public String base_url;
	public String browser;
	public int timeout;
	public boolean maximise;
	public boolean closeOnFail;
	
	public Configuration()
	{
		Properties props = new Properties();
		try{
			String env = System.getProperty("env", "localhost");
			FileInputStream propsFile = new FileInputStream(env + ".properties");
			props.load(propsFile);
		}
		catch(IOException e){
			Assert.fail("properties file not found");
		}
		this.base_url = props.getProperty("base.url");
		this.browser = props.getProperty("driver.browser");
		this.timeout = Integer.parseInt(props.getProperty("driver.timeout"));
		this.maximise = Boolean.parseBoolean(props.getProperty("driver.maximise"));
		this.closeOnFail = Boolean.parseBoolean(props.getProperty("driver.close.on.fail"));
	}

}
