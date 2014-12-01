package simple;

import org.testng.annotations.Test;

import pages.ElementsPage;
import utilities.TestBase;

public class FailTest extends TestBase{
	
	@Test(groups="fail")
	public void failTest()
	{
		ElementsPage e = ElementsPage.navigateTo(driver, base_url);
		e.findMissingElement();
	}

}
