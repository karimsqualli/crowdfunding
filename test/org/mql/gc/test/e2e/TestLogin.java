package org.mql.gc.test.e2e;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  @Test
  public void testLoginFalse() throws Exception {
        
    driver.get("http://localhost:8083/Projet_KAISAHHH/index.xhtml");
    
    synchronized (driver) {
		driver.wait(1000);
	}
    
    driver.findElement(By.linkText("CONNEXION")).click();
    driver.findElement(By.id("j_idt9:username")).click();
    driver.findElement(By.id("j_idt9:username")).clear();
    driver.findElement(By.id("j_idt9:username")).sendKeys("test@live.fr");
    driver.findElement(By.id("j_idt9:password1")).click();
    driver.findElement(By.id("j_idt9:password1")).sendKeys("1234");
    driver.findElement(By.id("j_idt9:j_idt14")).click();
    
    synchronized (driver) {
		driver.wait(1000);
	}

  }

  @Test
  public void testLoginTrue() throws Exception {	    
	    
	    driver.get("http://localhost:8083/Projet_KAISAHHH/index.xhtml");
	    
	    synchronized (driver) {
			driver.wait(1000);
		}
	    
	    driver.findElement(By.linkText("CONNEXION")).click();
	    driver.findElement(By.id("j_idt9:username")).click();
	    driver.findElement(By.id("j_idt9:username")).clear();
	    driver.findElement(By.id("j_idt9:username")).sendKeys("test@live.fr");
	    driver.findElement(By.id("j_idt9:password1")).click();
	    driver.findElement(By.id("j_idt9:password1")).sendKeys("123456as");
	    driver.findElement(By.id("j_idt9:j_idt14")).click();
	    
	    synchronized (driver) {
			driver.wait(1000);
		}

  }

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
  }

  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
