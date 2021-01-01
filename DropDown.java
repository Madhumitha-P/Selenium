package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {
	@FindBy(id="dropdown1")
	public static WebElement dropDown;
	
	@Test
	public void dropdown(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deenadhayalan\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		PageFactory.initElements(driver, DropDown.class);
		Select sel = new Select(dropDown);
		List<WebElement> selectDropdown = sel.getOptions();
		Set<String> dropDownSet = new HashSet<String>();
		for (WebElement drop : selectDropdown) {
			if(dropDownSet.contains(drop.getText())){
				System.out.println(drop.getText());
			}
			else{
				dropDownSet.add(drop.getText());
			}
		}
		System.out.println(dropDownSet);
		driver.quit();
	}
}
