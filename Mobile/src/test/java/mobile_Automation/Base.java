package mobile_Automation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Base {

	public Base() {
	}

	protected static DesiredCapabilities caps = new DesiredCapabilities();
	protected static AppiumDriver<MobileElement> driver = null;

	static WebDriverWait wait = null;

	public static void setup() throws MalformedURLException {

		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "14");
		caps.setCapability("deviceName", "any device name");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("noReset", true);
		caps.setCapability("appPackage", "com.ebay.mobile");
		caps.setCapability("appActivity", "com.ebay.mobile.home.impl.main.MainActivity");

		URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<>(appiumURL, caps);
	}

	public static void close() {
		driver.quit();
	}

	public static void waitElementVisible(By locator) {

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

}
