package simple;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.ElementsPage;
import utilities.Screenshot;
import utilities.TestBase;

@Listeners({Screenshot.class})
public class FailTest extends TestBase{
	
	@Test(groups={"all","fail"})
	public void failTest()
	{
		ElementsPage e = ElementsPage.navigateTo(driver, base_url);
		e.findMissingElement();
	}

}
