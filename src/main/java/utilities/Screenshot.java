package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.Reporter;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screenshot extends TestListenerAdapter{
	
	@Override
	public void onTestFailure(ITestResult tr)
	{
		if(!tr.isSuccess())
		{
			String imagePath = "screenshots/" + tr.getTestClass().getName() + "/";
			
			BufferedImage img = null;
			try{
				Robot r = new Robot();
				Toolkit t = Toolkit.getDefaultToolkit();
				Rectangle rec = new Rectangle(t.getScreenSize());
				img = r.createScreenCapture(rec);				
			} catch(AWTException e) {
				e.printStackTrace();
			}			
			
			String destDir = "target/surefire-reports/" + imagePath;
			new File(destDir).mkdirs();
			String destFile = "failure.jpg";
		
			try{
				File output = new File(destDir + "/" + destFile);
				ImageIO.write(img, "jpg", output);
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			String imageHref = "../" + imagePath + destFile;
			//create thumbnail
			Reporter.log("<a href=" + imageHref + "><img src=" + imageHref + " width=200 height=200></img><br/>" + tr.getTestClass().getName() + "</a>");
		}
	}
}
