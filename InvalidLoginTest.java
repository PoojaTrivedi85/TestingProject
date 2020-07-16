package mydemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidLoginTest {
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
		  
		  System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
		  
	  }
  @Test(description = "This is for testing Invalid Login.")
  public void invalidLoginTest() {
	  
	  driver.findElement(By.className("login")).click();
	  
	  driver.findElement(By.id("email")).sendKeys("trivedipooja99@gmail.com");
	  driver.findElement(By.id("passwd")).sendKeys("WrongPasswd");
	  
	  driver.findElement(By.id("SubmitLogin")).click();
	  
	  System.out.println("Wrong Credentials Entered.");
  }
}
