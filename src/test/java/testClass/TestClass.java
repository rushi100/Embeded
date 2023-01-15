package testClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import configuration.Config;
import pom.HomePage;
import pom.LogInPage;
import utils.Utility;

public class TestClass extends Browser{
	
	private WebDriver driver;
	private LogInPage logInPage;
	private HomePage homepage;
	private String testID;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browserName) 
	{
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{			
			driver = launchChromeBroweser();			
		}
		
		if(browserName.equalsIgnoreCase("Edge"))
        {			
			driver=launchEdgeBroweser();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}

	@BeforeClass
	public void cleatPomObjects()
	{
		logInPage = new LogInPage(driver);
		homepage= new HomePage(driver);
	}
	
	@BeforeMethod
	public void logInToApplication() throws EncryptedDocumentException, IOException {
		
		driver.get(Config.appUrl);
		String userName= Utility.getDataFromExcelSheel("Sheet1", 1, 0);
		String pass= Utility.getDataFromExcelSheel("Sheet1", 1, 1);
		String pinNumber= Utility.getDataFromExcelSheel("Sheet1", 1, 2);
	    
		logInPage.enterUserID(userName);
		logInPage.enterPassword(pass);
		logInPage.clickOnLoginButton();
		logInPage.enterPin(pinNumber);
		logInPage.clickOnContinueButton();
	
        
	}
	
	
	@Test
	public void testCase01() throws InterruptedException {
		testID="TC01";
	
		Thread.sleep(5000);
		Assert.fail();
		
	}
	
	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			
			Utility.captureScreenshot(driver, testID);
			
		}
		
		
		homepage.clickOnProfile();
		homepage.clickOnLogOut();
		
	}
	
	
	
	
	@AfterClass
	public void clearObjects() {
		logInPage =null;
		homepage = null;
		
		
	}
	
	@AfterTest
	public void closedTheBrowser() {
		//driver.quit();
		
		driver= null;
		System.gc();
	
	}
	
	
	
	
	
	

}
