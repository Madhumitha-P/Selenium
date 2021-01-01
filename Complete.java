import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Complete{
	public static void main(String args[]){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deenadhayalan\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/upload.html");
		WebElement upload = driver.findElement(By.name("filename"));
		String typeFile= upload.getAttribute("type");
		System.out.println(typeFile);
		upload.sendKeys(Keys.ENTER);
//		String parent = driver.getWindowHandle();
//		driver.findElement(By.xpath("/html/body/div/div[4]/div/p/a")).click();
//		driver.navigate().back();
//		WebElement textBox = driver.findElement(By.id("fname"));
//		textBox.sendKeys("test");
//		Select dropdown= new Select(driver.findElement(By.id("testingDropdown")));
//		dropdown.selectByVisibleText("Performance Testing");
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("scrollBy(0,4500)");
//		driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button")).click();
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		driver.switchTo().window(parent);
//		WebElement from = driver.findElement(By.id("draggable"));
//		WebElement to = driver.findElement(By.id("droppable"));
//		Actions actions = new Actions(driver);
//		actions.dragAndDrop(from, to).build().perform();
		}
}