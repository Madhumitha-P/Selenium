package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Example {
	@FindBy(id="dropdown1")
	public static WebElement dropDown;
	@FindBy(name="dropdown2")
	public static WebElement dropDown2;
	@FindBy(id="dropdown3")
	public static WebElement dropDown3;
	@FindBy(xpath="//select[@class='dropdown']")
	public static WebElement dropDown4;
	
	@Test
	public void selectDropDown(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deenadhayalan\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		PageFactory.initElements(driver,Example.class);
		Select select = new Select(dropDown);
		select.selectByIndex(1);
		Select select2 = new Select(dropDown2);
		select2.selectByVisibleText("Appium");
		Select select3 = new Select(dropDown3);
		select3.selectByValue("2");
		Select select4 = new Select(dropDown4);
		int size= select4.getOptions().size();
		System.out.println(size);

	}

}
