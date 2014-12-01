package simple;

import org.testng.annotations.*;

import pages.ElementsPage;
import utilities.TestBase;

public class SimpleTest extends TestBase{
	
	@Test(groups="simple")
	public void aSimpleTest()
	{
		ElementsPage elements = ElementsPage.navigateTo(driver, base_url);
		elements.populateTextbox1("this is a simple test");
	}
}
