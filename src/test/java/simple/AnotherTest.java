package simple;

import org.testng.annotations.*;

import pages.ElementsPage;
import utilities.Screenshot;
import utilities.TestBase;

public class AnotherTest extends TestBase{
	
	@Test(groups={"all","another"})
	public void anotherTest()
	{
		ElementsPage elements = ElementsPage.navigateTo(driver, base_url);
		elements.populateTextbox1("this is another test");
		elements.clickButton2();
	}

}
