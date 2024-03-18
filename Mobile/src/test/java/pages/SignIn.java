package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import mobile_Automation.Base;

public class SignIn extends Base {

	public SignIn() {
		super();
	}

	By btnSignIn = By.xpath("//android.widget.Button[@resource-id='com.ebay.mobile:id/button_classic']");
	By lblSignIn = By
			.xpath("(//android.widget.ImageButton[@content-desc='close']//following::android.widget.TextView)[1]");
	By emailTxtLayout = By.xpath("//android.widget.FrameLayout[@resource-id='com.ebay.mobile:id/frame_input_layout']");
	By inputEmailTxt = By.xpath("//android.widget.EditText[@resource-id='com.ebay.mobile:id/edit_text_username']");
	By passwrdTxtLayout = By
			.xpath("//android.widget.LinearLayout[@resource-id='com.ebay.mobile:id/view_password_layout']");
	By btnCloseIcon = By.xpath("//android.widget.ImageButton[@content-desc='close']");

	public SignIn clickSignInBtn() {
		waitElementVisible(btnSignIn);
		driver.findElement(btnSignIn).click();
		return this;
	}

	public SignIn verifySignInPage(String lbl) {
		waitElementVisible(lblSignIn);
		String signIn = driver.findElement(lblSignIn).getText().toString();
		Assert.assertEquals(signIn, lbl);
		return this;
	}

	public SignIn inputemail(String input) {

		driver.findElement(emailTxtLayout).click();
		waitElementVisible(inputEmailTxt);
		driver.findElement(inputEmailTxt).sendKeys(input);

		driver.findElement(passwrdTxtLayout).click();

		return this;
	}

	public SignIn closeSignIn() {
		waitElementVisible(btnCloseIcon);
		driver.findElement(btnCloseIcon).click();
		return this;
	}

}
