package assignment;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	WebDriver driver;
	String url="https://www.google.com/";

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("apple");
		List<WebElement> List=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendent::div[@class='sbl1']"));
		System.out.println(List.size());
		
		for(int i=0;i<List.size();i++) {
			if(List.get(i).getText().matches("apple watch")) {
				List.get(i).click();
				break;
			}
		}
		 driver.close();
	}

}
