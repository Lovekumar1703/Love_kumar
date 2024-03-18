package testsuite;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mobile_Automation.Base;
import pages.Home;
import pages.PDP;
import pages.SignIn;

public class MainTest extends Base {
	Home homePage = new Home();
	PDP pdpPage = new PDP();
	SignIn signInPage = new SignIn();

	static String watch = "";
	String keyword = "watch";
	String emailId = "xyz";
	String lblSignIn = "Sign in";

	@BeforeTest
	public void launchApp() throws MalformedURLException {

		setup();
	}

	@AfterTest
	public void closeApp() {
		close();
	}

	@Test(priority = 1)
	public void searchInput() {
		homePage.searchItem(keyword);
	}

	@Test(priority = 2)
	public void tapOnFilter() {

		pdpPage.filterHighToLow();

	}

	@Test(priority = 3)
	public void getList() {

		for (int i = 0; i < pdpPage.getList().size(); i++) {

			System.out.println(pdpPage.getList().get(i));

		}

	}

	@Test(priority = 4)
	public void clickOnProduct() {

		pdpPage.clickFirstProduct();
		watch = pdpPage.getLabel();
		pdpPage.clickBuyNow();

	}

	@Test(priority = 5)
	public void clickBuyAndSignIn() {
		signInPage.clickSignInBtn().verifySignInPage(lblSignIn).inputemail(emailId).closeSignIn();
		String pdp_watch = pdpPage.getLabel();
		Assert.assertEquals(pdp_watch, watch);

	}

}
