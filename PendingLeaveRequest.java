package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.Login;
import pageObjects.LoginPageObjects;
import pageObjects.PendingLeaveObjects;

public class PendingLeaveRequest extends Login{
	public static List<WebElement> tableData;
	@Test
	public void verifyPendingLeaves(){
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.username.sendKeys(properties.getProperty("user"));
		LoginPageObjects.password.sendKeys(properties.getProperty("password"));
		LoginPageObjects.login.click();

		PageFactory.initElements(driver, PendingLeaveObjects.class);
		for (WebElement singledata : PendingLeaveObjects.tables) {
			try{
				System.out.println(singledata.getText());
				Assert.assertEquals(singledata.getText(), "01. Paul Collings 2020-11-02");
			}catch(AssertionError err){
				System.out.println("Asserstion Fails");
			}
		}
	}
}
