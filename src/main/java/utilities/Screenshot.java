package utilities;

import org.testng.ITestResult;
import org.testng.Reporter;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screenshot {
	
	public void captureScreenshot(String testName)
	{
		{
			String imagePath = "screenshots/" + testName + "/";
			
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
			Reporter.log("<a href=" + imageHref + "><img src=" + imageHref + " width=200 height=200></img><br/>" + testName + "</a>");
		}
	}
	
	public void captureFailureScreenshot(ITestResult tr)
	{
		captureScreenshot(tr.getTestClass().getName());
	}
}
