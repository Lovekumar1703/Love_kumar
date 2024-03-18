package pages;

import java.util.List;

import org.openqa.selenium.By;

import mobile_Automation.Base;
import mobile_Automation.Utility;

public class PDP extends Base {

	public PDP() {
		super();
	}

	By sortButton = By.id("com.ebay.mobile:id/button_sort");
	By highToLowRadio = By
			.xpath("(//*[@resource-id='com.ebay.mobile:id/bottom_sheet_container']//android.widget.RadioButton)[3]");

	By firstProduct = By.xpath("(//android.widget.LinearLayout [@resource-id='com.ebay.mobile:id/layout_header'])[1]");
	By lblProduct = By.xpath("//android.widget.TextView [@resource-id='com.ebay.mobile:id/textview_item_name']");
	By btnBuyNow = By.xpath("//android.widget.Button[@content-desc='Buy It Now']");

	By elementTitle = By.xpath(
			"//android.widget.LinearLayout[@resource-id='com.ebay.mobile:id/layout_header']//android.widget.TextView");
	By elementPrice = By.xpath(
			"//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/search_item_card_details']//android.widget.TextView[ @resource-id='com.ebay.mobile:id/textview_primary_0']");

	public PDP filterHighToLow() {
		waitElementVisible(sortButton);
		driver.findElement(sortButton).click();
		waitElementVisible(highToLowRadio);
		driver.findElement(highToLowRadio).click();

		return this;
	}

	public PDP clickFirstProduct() {
		waitElementVisible(firstProduct);
		driver.findElement(firstProduct).click();
		return this;
	}

	public String getLabel() {

		waitElementVisible(lblProduct);
		String watch = driver.findElement(lblProduct).getText().toString();
		return watch;

	}

	public PDP clickBuyNow() {

		waitElementVisible(btnBuyNow);
		driver.findElement(btnBuyNow).click();
		return this;
	}

	public List<String> getList() {

		return Utility.getElementTextListCombined(elementTitle, elementPrice);
	}

}
