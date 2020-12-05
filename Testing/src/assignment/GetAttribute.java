package assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class GetAttribute {
	
	WebDriver driver;
	String url="https://accounts.google.com/signup";
 
  @BeforeClass
  public void beforeClass() {
	    System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
  }

  @Test
  public void Test() {
	  WebElement firstName=driver.findElement(By.id("firstName"));
	  firstName.sendKeys("Harishmaa");
	  String str=firstName.getAttribute("value");
	  
	  WebElement lastName=driver.findElement(By.id("lastName"));
	  lastName.sendKeys("Narayanan");
	  String str1=lastName.getAttribute("value");
	  
	  WebElement userName=driver.findElement(By.id("userName"));
	  userName.sendKeys("Harishmaa");
	  String str2=userName.getAttribute("value");
	  
	  WebElement pwd=driver.findElement(By.name("Passwd"));
	  pwd.sendKeys("Harii*98");
	  String str3=pwd.getAttribute("value");
	  
	  WebElement pwd1=driver.findElement(By.name("ConfirmPasswd"));
	  pwd1.sendKeys("Harii*98");
	  String str4=pwd1.getAttribute("value");
	  
	  driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/div[2]")).click();
	  
  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
