package assignment;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	

	WebDriver driver;
	String url="http://www.zlti.com";
	

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links are "+links.size());  
        for(int i=0; i<links.size(); i++) {
            WebElement element = links.get(i);
            //By using "href" attribute, we could get the url of the requried link
            String url1=element.getAttribute("href");
            //calling verifyLink() method here. Passing the parameter as url which we collected in the above link
            //See the detailed functionality of the verifyLink(url) method below
            verifyLink(url1);            
        }   
    }
        
       
   public  void verifyLink(String urlLink) {
        //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
        try {
            //Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
            URL link = new URL(urlLink);
            // Create a connection using URL object (i.e., link)
            HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
            //Set the timeout for 2 seconds
            httpConn.setConnectTimeout(2000);
            //connect using connect method
            httpConn.connect();
            //use getResponseCode() to get the response code. 
                if(httpConn.getResponseCode()== 200) {  
                    System.out.println(urlLink+" - "+httpConn.getResponseMessage());
                }
                if(httpConn.getResponseCode()== 404) {
                    System.out.println(urlLink+" - "+httpConn.getResponseMessage());
                }
                                if(httpConn.getResponseCode()== 400) { 
                                        System.out.println(urlLink+" - "+httpConn.getResponseMessage()); }
                                if(httpConn.getResponseCode()== 500) {
                                    System.out.println(urlLink+" - "+httpConn.getResponseMessage()); }
                                                
                                }
                                
                            
            //getResponseCode method returns = IOException - if an error occurred connecting to the server. 
        catch (Exception e) {
            e.printStackTrace();
         
        }
    } 
}