package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import web_Automation.Base;
import web_Automation.Utility;

public class PDP extends Base {

	public PDP() {
		super();

	}

	By elementTitle = By.xpath(
			"//ul[contains(@class,'results')]//li[@data-viewport]//div[contains(@class,'info')]//a[@data-interactions]//div[contains(@class,'title')]");

	By elementPrice = By.xpath("//ul[contains(@class,'results')]//li[@data-viewport]//span[contains(@class,'price')]");

	By filterOption = By.xpath("//button[@type='button' and contains(.,'Sort')]");
	By filterDropDownList = By.xpath("//button[@type='button' and contains(.,'Sort')]/..//span//ul//li//span");

	public PDP clickSortFilter() {

		dr.findElement(filterOption).click();
		return this;

	}

	public PDP verifyTitle(String getText) {

		Assert.assertEquals(getText, dr.getTitle());
		return this;

	}

	public PDP clickPrice(String price) {

		List<WebElement> dropDownList = dr.findElements(filterDropDownList);

		for (int i = 0; i < dropDownList.size(); i++) {
			if (dropDownList.get(i).getText().equals(price)) {
				dropDownList.get(i).click();
				break;

			}

		}
		return this;

	}

	public PDP verifyFilterLabel(String getText) {

		String text = dr.findElement(filterOption).getText();

		Assert.assertEquals(getText, text);
		return this;

	}

	public List<String> getList() {

		return Utility.getElementTextListCombined(elementTitle, elementPrice);
	}

}
