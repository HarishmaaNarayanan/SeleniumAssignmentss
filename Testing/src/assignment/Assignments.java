package assignment;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignments {


	WebDriver driver;
	String url="https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void test() {
		WebElement DropDown = driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button"));
		Select s = new Select(DropDown);
		s.deselectByVisibleText("HTML");
		s.deselectByVisibleText("CSS");
		s.selectByVisibleText("Bootstrap");
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		
	}

	

}
