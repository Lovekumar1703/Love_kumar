package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import web_Automation.Base;

public class Home extends Base {

	public Home() {
		super();

	}

	By searchBox = By.xpath("//input[@type='text']");
	By submit = By.xpath("//input[@type='submit']");

	public Home verifyTitle(String getText) {

		Assert.assertEquals(getText, dr.getTitle());
		return this;

	}

	public Home search(String search) {

		dr.findElement(searchBox).sendKeys(search);
		return this;

	}

	public Home submit() {
		dr.findElement(submit).click();

		return this;
	}

}
