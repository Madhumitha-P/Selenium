package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ChildClass{
	@FindBy(xpath="//*[@id='mydiv']/input")
	public static WebElement buttonFile;
	
	@Test
	public void test() throws AWTException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deenadhayalan\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/upload.html");	
		
		PageFactory.initElements(driver, ChildClass.class);
		
				
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File output_file = screenShot.getScreenshotAs(OutputType.FILE);
//		StringSelection select = new StringSelection(fileLocation);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
//		
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
////		alertBox.click();
//		driver.switchTo().activeElement().click();
//		int size=selectRoes.size();
//		System.out.println(size);
//		Actions actions = new Actions(driver);
//		actions.clickAndHold(selectRoes.get(0));
//		actions.clickAndHold(selectRoes.get(1));
//		actions.clickAndHold(selectRoes.get(2));
//		actions.build().perform();
//		int sizeRes= size.getSize().getHeight();
//		int widhtRes = size.getSize().getWidth();
//		System.out.println(sizeRes + " "+widhtRes );
//		iframe.click();
//		String text = img.getAttribute("onclick");
//		System.out.println(text);
//		Actions actions = new Actions(driver);
//		actions.dragAndDrop(draggable, dragOn).build().perform();
	}
}