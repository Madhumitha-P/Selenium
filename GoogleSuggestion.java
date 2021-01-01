import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GoogleSuggestion {
	@FindBy(name="q")
	public static WebElement searchEngine;
	@FindBy(xpath="//*[@class='sbct']/div/div/div")
	public static List<WebElement> suggestion;
	
	@Test
	public void getSuggestion(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deenadhayalan\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		WebElement tamil = driver.findElement(By.xpath("//a[contains(text(),'தமிழ்')]"));
		System.out.println(tamil.getCssValue("text-decoration"));
		
		PageFactory.initElements(driver, GoogleSuggestion.class);
		searchEngine.click();
		searchEngine.sendKeys("games");
				
		for (WebElement suggestionElement : suggestion) {
			System.out.println(suggestionElement.getText());
		}
	}
}
