package commonfunction;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class Commonfunctions {

	public static final String Else = null;
	public static Properties properties=null;
	public static WebDriver driver=null;
	
	public Properties loadpropertyfile() throws IOException {
		
		FileInputStream fileinput=new FileInputStream("config.properties");
		properties =new Properties();
		properties.load(fileinput);
		
		return properties;
		 
	}
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void launchbrowser() throws IOException
	{
		loadpropertyfile();
		
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		String driverLocation=properties.getProperty("DriverLocation");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.gecko.driver", driverLocation);
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverLocation);
			driver=new FirefoxDriver();
		 
				}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 List<WebElement> links = driver.findElements(By.tagName("a"));


		// Iterating each link and checking the response status
		 for (WebElement link : links) {
				String url1 = link.getAttribute("href");
				}
				
				//driver.quit();

			String url1 = null;
			try {
				URL link = new URL(url1);
			HttpURLConnection huc = (HttpURLConnection) link.openConnection();
			huc.setConnectTimeout(9000); // Set connection timeout to 3 seconds
			huc.connect();
			
			if(huc.getResponseCode()>=400) {
				
				System.out.println( url1 +" is borken");
				
			}else {
				System.out.println( url1 +" is Valid");

			}
			}
			
			catch (Exception e) {
				System.out.println(url1 + " - " + "is a broken link");
				}
	}
		
		//driver.quit();


	

	@AfterSuite
	public void closebrowser()
	{
		
		driver.quit();
		
	}
}
