import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class SeleniumTest{
	@FindBy(tagName="Edit")
	public static WebElement imageEdit;
	
	@Test
	public void clickEdit(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deenadhayalan\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		
		imageEdit.click();
		driver.quit();
	}
}