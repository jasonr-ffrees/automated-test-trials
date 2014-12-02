package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class Screenshot extends TestListenerAdapter{
	
	@Override
	public void onTestFailure(ITestResult tr)
	{
		WebDriver driver = TestBase.getDriverInstance();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destDir ="target/surefire-reports/screenshots";
		new File(destDir).mkdirs();
		String destFile = "test";
		
		try{
			FileUtils.copyFile(srcFile, new File(destDir + "/" + destFile));
		} catch(IOException e) {
			e.printStackTrace();
		}
		Reporter.log("<a href=../screenshots/" + destFile + ">Screenshot</a>" );
		
	}

}
