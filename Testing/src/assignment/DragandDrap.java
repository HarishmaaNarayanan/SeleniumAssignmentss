package assignment;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrap {
	
	WebDriver driver;
	String url="https:jqueryui.com/droppable/";

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
		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to=driver.findElement(By.id("droppable"));
		Actions a =new Actions(driver);
		a.dragAndDrop(from, to);
		
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	
}
