package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class Browser {
	
	public static WebDriver launchChromeBroweser() {
		
		String driverPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPath+"\\Driver\\Chrome\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver launchEdgeBroweser() {
		
		String driverPath= System.getProperty("user.dir");
		System.setProperty("webdriver.edge.driver", driverPath+"\\Driver\\Edge\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		
		return driver;
		
	}
	
	

}
