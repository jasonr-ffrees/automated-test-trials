package utilities;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class TestListeners extends TestListenerAdapter{
	
	@Override
	public void onTestFailure(ITestResult tr)
	{
		Screenshot ss = new Screenshot();
		ss.captureFailureScreenshot(tr);
	}

}
