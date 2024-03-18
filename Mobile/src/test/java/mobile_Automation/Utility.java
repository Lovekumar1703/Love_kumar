package mobile_Automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;

public class Utility extends Base {

	public Utility() {
		super();
	}

	public static List<String> getElementTextList(By locator) {
		List<String> textList = new ArrayList<>();

		// Locate elements using the provided locator
		waitElementVisible(locator);
		List<MobileElement> elementList = driver.findElements(locator);

		// Extract text from each WebElement in the list
		for (WebElement element : elementList) {
			String elementText = element.getText();
			textList.add(elementText);
		}

		return textList;
	}

	public static List<String> getElementTextListCombined(By locator, By locator2) {
		List<String> textListFirst = getElementTextList(locator);
		List<String> textListSecond = getElementTextList(locator2);

		List<String> combinedResult = new ArrayList<>();
		for (int i = 0; i < textListFirst.size(); i++) {
			combinedResult.add("Name: " + textListFirst.get(i) + ", Price: " + textListSecond.get(i));
		}

		return combinedResult;
	}

}
