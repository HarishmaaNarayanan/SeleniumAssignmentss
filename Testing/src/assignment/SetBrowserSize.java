package assignment;


import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetBrowserSize {


	WebDriver driver;
	String url="https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
	

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.navigate().to("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	    System.out.println(driver.manage().window().getSize());
	    Dimension d = new Dimension(480,620);
	    driver.manage().window().setSize(d);
        System.out.println(driver.manage().window().getSize());
	}

}
