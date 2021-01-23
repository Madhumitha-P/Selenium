package TestNG;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	public WebDriver driver;
	@FindBy(xpath="//*[@id='post-153']/div[2]/div/ul/li[2]/a/img")
	public static WebElement imageButton;
	@FindBy(id="home")
	public static WebElement homeButton;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	static String desResult = "C:\\Users\\deenadhayalan\\Desktop\\passed.png";

	@BeforeTest()
	public void test(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deenadhayalan\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		extentReport = new ExtentReports("C:\\Users\\deenadhayalan\\Desktop\\ExtentReport.html");
		extentTest = extentReport.startTest("Test");
		PageFactory.initElements(driver, ExtentReport.class);

	}

	public static String screenShot(WebDriver driver) throws IOException{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File destination = new File(desResult);
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, destination);
		return desResult;
	}


	@Test
	public void clickEdit() throws IOException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		imageButton.click();
		homeButton.click();
	}

	@AfterTest
	public void exit(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report

			String screenshotPath = ExtentReport.screenShot(driver);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS,"Passed");
			extentTest.log(LogStatus.PASS, "TEST CASE PASSED IS "+result.getName()); //to add name in extent report

			String screenshotPath = ExtentReport.screenShot(driver);
			extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report


		}
		extentReport.endTest(extentTest);
		extentReport.flush();
		driver.quit();
	}
}
