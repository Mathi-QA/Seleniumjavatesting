package testcases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonfunction.Commonfunctions;
import pageObjects.ElementspageObjects;

public class Login extends Commonfunctions{
	
	String actualMessage=null;
	
	@SuppressWarnings("deprecation")
		
	public void verifylogin() throws InterruptedException {
		
		PageFactory.initElements(driver, ElementspageObjects.class);
		ElementspageObjects.username.sendKeys(properties.getProperty("username"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		ElementspageObjects.ccontinue.click();

		ElementspageObjects.password.sendKeys(properties.getProperty("password"));

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		ElementspageObjects.signInSubmit.click();
		
		String Title=driver.getTitle();
		
		String ActualTitle="Online Return Center";
			
		System.out.println("Title is "+ Title);
		
		Assert.assertEquals(ActualTitle,Title );
		
		
//		if(Title.contains("Online Return Center"))
//				{
//			
//			System.out.println(" Link is not Broken");
//				}
//		else
//		{
//			System.out.println("Link is Broken");
//		}
		
			
	}
	
	@SuppressWarnings("deprecation")
	public void verifyloginpage() throws InterruptedException
	{
		//Thread.sleep(5000);
		PageFactory.initElements(driver, ElementspageObjects.class);
		ElementspageObjects.search.click();
		ElementspageObjects.search.sendKeys(properties.getProperty("search"));
     	ElementspageObjects.search.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ElementspageObjects.addtocart.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		ElementspageObjects.clickaddtocart.click();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
////		actualMessage=ElementspageObjects.price.getText();
//
//	//	System.out.println("Name "+ actualMessage);
	}
	
	@Test
	public void logintest() throws InterruptedException {
		
		verifylogin();
		verifyloginpage();
	}
	
}
