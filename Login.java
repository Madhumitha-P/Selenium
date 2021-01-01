package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Login {
	public static Properties properties = null;
	public static WebDriver driver;
	public Properties loadProperties() throws IOException{
		FileInputStream configFile = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(configFile);
		return properties;
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException{
		loadProperties();
		String driverLocation = properties.getProperty("driverLocation");
		String url = properties.getProperty("url");
		String browser = properties.getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", driverLocation);
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
	}
	
	@AfterSuite
	public void closeBrowser(){
		driver.quit();
	}
}