package mydemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ValidTest {
  WebDriver driver;
  
  
  @BeforeClass
  public void browserOpenTest() {
	  System.setProperty("webdriver.gecko.driver", "E:\\firefoxDriver\\geckodriver.exe");
	  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	  capabilities.setCapability("marionette", true);
	  driver = new FirefoxDriver(capabilities);
  }
  
  @BeforeMethod
  public void browserTest() {
  
	  driver.navigate().to("http://automationpractice.com/index.php");
	  
	  System.out.println("The URL which is being tested is: " +driver.getCurrentUrl());
	  
  }
  
  	@Test(description = "This is for testing website features.")
  	public void webTest() {
	  
	 driver.findElement(By.className("login")).click();
	  
	  
	  // SIGN UP 
	 
	  driver.findElement(By.id("email_create")).sendKeys("trivedipooja99@gmail.com");
	  driver.findElement(By.id("SubmitCreate")).click();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.findElement(By.id("customer_firstname")).sendKeys("Pooja");
	  driver.findElement(By.id("customer_lastname")).sendKeys("Trivedi");
	  driver.findElement(By.id("passwd")).sendKeys("pooja");
	  driver.findElement(By.id("address1")).sendKeys("Malad");
	  driver.findElement(By.id("city")).sendKeys("Mumbai");
	  driver.findElement(By.id("id_state")).sendKeys("Alabama");
	  driver.findElement(By.id("postcode")).sendKeys("40066");
	  driver.findElement(By.id("phone_mobile")).sendKeys("9865413710");
	  driver.findElement(By.id("alias")).sendKeys("Mumbai");
	  
	  driver.findElement(By.id("submitAccount")).click();
	  
	  System.out.println("Successfully Completed sign up Automation!!");
	  
	  driver.findElement(By.className("logout")).click();
	  
	  System.out.println("Log out Successful, now log in will be tested!!");
	  
		  
	  //LOG -  IN
	  
	  driver.findElement(By.id("email")).sendKeys("trivedipooja99@gmail.com");
	  driver.findElement(By.id("passwd")).sendKeys("pooja");
	  driver.findElement(By.id("SubmitLogin")).click();
	  
	  System.out.println("Log in validation Successful!!");
	
	  
	  //Search
	  
	  driver.findElement(By.id("search_query_top")).sendKeys("Summer Dresses");
	  driver.findElement(By.name("submit_search")).click();
	 
	  // Add to cart
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.findElement(By.id("color_19")).click();
	  driver.findElement(By.name("Submit")).click();
	  
	  System.out.println("Adding to cart is Successful!!");
	  
	  //After adding to cart, continue shopping
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Proceed to checkout")).click();
	  
	  System.out.println("Testing is Complete"); 
	  
	 
	  }
}
