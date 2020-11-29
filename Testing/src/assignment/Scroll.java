package assignment;



import java.util.concurrent.TimeUnit;


import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {
	
	

	WebDriver driver;
	String url="http://openclinic.sourceforge.net/openclinic/home/index.php";

	

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("http://openclinic.sourceforge.net/openclinic/home/index.php");   
	    JavascriptExecutor js = (JavascriptExecutor)driver;  
	    js.executeScript("scrollBy(0, 4500)"); 
		 
	}

}
