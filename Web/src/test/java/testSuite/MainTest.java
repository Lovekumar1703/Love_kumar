package testSuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Home;
import pages.PDP;
import web_Automation.Base;

public class MainTest extends Base {

	public MainTest() {
		super();
	}

	PDP pdpPage = new PDP();
	Home homePage = new Home();

	String price = "Price + Shipping: lowest first";
	String homePagetitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
	String pdpPagetitle = "ipad for sale | eBay";
	int priceAndTitleRecords = 10;

	@BeforeTest
	public void launchBrowser() {

		setup();
		homePage.verifyTitle(homePagetitle);

	}

	@AfterTest
	public void closeBrowser() {
		closeWindow();

	}

	@Test(priority = 1)
	@Parameters({ "item" })
	public void searchBox(String item) {

		homePage.search(item).submit();
		pdpPage.verifyTitle(pdpPagetitle);

	}

	@Test(priority = 2)

	public void filterPrice() {

		pdpPage.clickSortFilter().clickPrice(price).verifyFilterLabel("Sort: " + price);

	}

	@Test(priority = 3)
	public void getResult() {

		for (int i = 0; i < pdpPage.getList().size(); i++) {

			if (i < priceAndTitleRecords) {

				System.out.println(pdpPage.getList().get(i));
			} else {
				break;
			}

		}
	}

}
