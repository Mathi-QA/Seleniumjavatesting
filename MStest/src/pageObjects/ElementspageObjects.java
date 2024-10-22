package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementspageObjects {

	@FindBy(id="ap_email")
	public static WebElement username;
	
	@FindBy(name="password")
	public static WebElement password;
	
	@FindBy(id="continue")
	public static WebElement ccontinue;
	
	@FindBy(id="signInSubmit")
	public static WebElement signInSubmit;
	
	@FindBy(xpath="//*[@id=\"nav-cart-count-container\"]")
	public static WebElement addtocart;
	
		
	@FindBy(id="twotabsearchtextbox")
	public static WebElement search;
	
	@FindBy(id="//*[@id=\"nav-cart-count-container\"]/span[2]")
	public static WebElement clickaddtocart;
	
	@FindBy(xpath="//*[@id=\"sc-active-bad8978a-beff-482b-ab55-c2bc7687c7c1\"]/div[4]/div/div[3]/ul/div[2]/li[2]/span/span")
	public static WebElement price;
	
	
	
	
	
}
