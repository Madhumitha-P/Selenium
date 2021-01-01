import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TableTest {
	@Test
	public void testTable(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deenadhayalan\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		
		int rows = driver.findElements(By.tagName("tr")).size();
		System.out.println(rows);
		String text = driver.findElement(By.xpath("//*[@id='table_id']/tbody/tr/td")).getText();
			
		driver.quit();
	}
}
