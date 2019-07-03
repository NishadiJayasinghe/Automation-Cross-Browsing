package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
	
	static WebDriver driver;
	  @BeforeTest
	  @Parameters("browser")
	  public static void openuRL(String browser) throws Exception {

		if(browser.equalsIgnoreCase("Chrome")) {
			
			  System.getProperty("webdriver.chrome.driver","E:\\software\\chromedriver_win32\\chromedriver.exe");
			  driver = new ChromeDriver();
			  
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
		
			System.setProperty("webdriver.gecko.driver","E:\\software\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver","E:\\software\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		else {
			
			throw new Exception("Browser is not correct");
		}

		  
		  driver.get("http://demo.guru99.com/insurance/v1/index.php");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  
  @Test
  public static void f() throws InterruptedException {
	  
	  WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
	  userName.sendKeys("jayasingheane@gmail.com");
	  Thread.sleep(300);
	  
	  WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
	  password.sendKeys("123456789");
	  Thread.sleep(300);
	  
	  WebElement login = driver.findElement(By.xpath("//input[@name='submit']"));
	  login.click();
	  Thread.sleep(50);
  }
  
  @AfterTest
  public static void end() {
	 driver.quit(); 
  }
  
  
}

