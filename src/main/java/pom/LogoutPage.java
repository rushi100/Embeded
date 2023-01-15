package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {

	@FindBy(xpath ="//button[text()='Login ']")
	private WebElement loginButton;
}
