import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenShotExample {
	@Test
	public void takeScreenShot() throws IOException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deenadhayalan\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
		
		File fileDes = new File("Sample.png");
		FileHandler.copy(sourceFile, fileDes);
		
			
	}
}
