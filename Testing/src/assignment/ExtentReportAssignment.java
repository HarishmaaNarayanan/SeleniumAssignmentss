package assignment;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class ExtentReportAssignment {
	
	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	static ExtentHtmlReporter htmlReporter;
	static String htmlReportPath="D:\\Selenium\\ExtentReport\\report.html";
  
 @BeforeMethod
 public void beforeMethod() {
	  htmlReporter = new ExtentHtmlReporter(htmlReportPath);
	  report=new ExtentReports();
	  report.attachReporter(htmlReporter);
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
	  driver = new ChromeDriver();
 }
	
  @Test
  public void extentReportsDemo() {
	  test=report.createTest("Website Test","Test to launch AUI");
	  driver.get("https://pcdapension.nic.in/padapension/index.php");
	  String title=driver.getTitle();
	  System.out.println(title);
	  test.log(Status.INFO, "Opened site of pcda");
	  assertEquals(driver.getTitle(),"Welcome to Office of the PDCA(P),Allahabad");
	  test.log(Status.PASS, "Site Loaded");
	  
  }
 

  @AfterMethod
  public void afterMethod(ITestResult result)throws Exception {
	  if(result.getStatus() == ITestResult.SUCCESS) {
		  test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Test Case Passed", ExtentColor.GREEN));
	  }
	  else if(result.getStatus() == ITestResult.SKIP) {
		  test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"Test Case Passed", ExtentColor.BLUE));
		  
	  }
	  else {
		  System.out.println("Test not passed");
	  }
   
	  
  }




  @BeforeClass
  public void beforeClass() throws Exception{
	  report.flush();
  }

  @AfterClass
  public void afterClass() throws Exception{
	  driver.close();
  }
}

