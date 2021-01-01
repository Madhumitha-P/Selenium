import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Selen{
	public static void main(String args[]){
		String filePath = "C:\\Users\\deenadhayalan\\Desktop\\Java\\index.html";
		ExtentReports reports = new ExtentReports(filePath);
		ExtentTest test = reports.startTest("Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deenadhayalan\\Documents\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();  
	    // Launch website  
	     driver.navigate().to("http://www.google.com/");  
		 driver.getTitle();
	     // Click on the search text box and send value  
	     driver.findElement(By.name("q")).click();
	     driver.findElement(By.name("q")).sendKeys("Javatpoint tutorials");
	           
	     // Click on the search button  
	     driver.findElement(By.name("btnK")).click();
	     test.log(LogStatus.PASS, "testpassed");
	     driver.close();
	     reports.endTest(test);
	     reports.flush();


		
	}
}