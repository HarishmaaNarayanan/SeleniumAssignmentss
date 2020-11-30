package assignment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeInstance {
	
	
	WebDriver driver;
	String url="https://www.jquery-az.com/boots/demo.php?ex=63.0_2";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	@Test
	public void test() {
		String pageTitle = driver.getTitle();
		System.out.println("Page title: " + pageTitle);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}


}
