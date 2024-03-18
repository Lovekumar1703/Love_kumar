package web_Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	protected static WebDriver dr;

	public Base() {
	}

	public static void setup() {
		dr = new ChromeDriver();

		dr.get("https://www.ebay.com");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

	}

	public static void closeWindow() {
		dr.close();

	}

	public static void closeAllBrowser() {
		dr.quit();

	}

}
