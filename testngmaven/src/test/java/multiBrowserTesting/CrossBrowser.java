package multiBrowserTesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class CrossBrowser {
	WebDriver driver;
  @Test
  public void login() {
	  driver.findElement(By.xpath("//*[@id='account']/a")).click();

	    driver.findElement(By.id("log")).sendKeys("testuser_1");

	    driver.findElement(By.id("pwd")).sendKeys("Test@123");

	    driver.findElement(By.id("login")).click();
	  
  }
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browser) {
	  if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\resources\\geckodriver32bit.exe");
		  driver = new FirefoxDriver();
	  }
	  /*else if(browser.equalsIgnoreCase("ie")) {
		  System.setProperty("webdriver.ie.driver", "src\\test\\resources\\resources\\IEDriverServer.exe");
		  driver = new InternetExplorerDriver();
	  }*/
	  else if(browser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\resources\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  driver.get("http://www.store.demoqa.com");	  
  }

  @AfterClass
  public void afterClass() {
  }

}
