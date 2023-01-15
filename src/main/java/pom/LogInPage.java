package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	@FindBy(id="userid")
	private WebElement userID;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Login ']")
	private WebElement loginButton;
	
	@FindBy(id = "pin")
	private WebElement pin;
	
	@FindBy(xpath="//button[text()='Continue ']")
	private WebElement continueButton;
	
	public LogInPage(WebDriver driver) 
	{		
		PageFactory.initElements(driver, this);		
	}
	
	public void enterUserID(String userName) {
		
		userID.sendKeys(userName);
		
	}
	
	public void enterPassword(String pass) {
		
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		
		loginButton.click();		
	}

	public void enterPin(String pinNumber) {
		
		pin.sendKeys(pinNumber);
	}
	
	public void clickOnContinueButton() {
		
		continueButton.click();
	}
}
