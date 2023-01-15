 package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(xpath="//span[@class='user-id']")
	private WebElement profile;
	
	@FindBy(xpath="//a[text()=' Logout']")
	private WebElement logOutButton;
	
	
	
	public HomePage(WebDriver driver){
				
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnProfile() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOf(profile));
		
		profile.click();
	}
	
	public void clickOnLogOut() {
		
		logOutButton.click();
	}
	
	

}
