package assignment;



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUp {
	
	WebDriver driver;
	String url="http://popuptest.com/goodpopups.html";

	

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[1]")).click();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[2]")).click();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[4]")).click();
		
		Set<String> windows=driver.getWindowHandles();
		for(String s: windows) {
			driver.switchTo().window(s);
			System.out.println(driver.getTitle());
			
		}
		
		driver.close();
		driver.quit();
		
		
	}

}
