package pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import mobile_Automation.Base;

public class Home extends Base {

	public Home() {
		super();
	}

	By searchBox = By.id("com.ebay.mobile:id/search_box");
	By searchBoxInput = By.id("com.ebay.mobile:id/search_src_text");

	public Home searchItem(String item) {
		driver.findElement(searchBox).click();
		waitElementVisible(searchBoxInput);
		driver.findElement(searchBoxInput).sendKeys(item);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		return this;
	}

}
