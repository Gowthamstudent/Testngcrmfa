package webDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.deadlinkchecker.com/");
		Thread.sleep(4000);
		
		Set<String> brokensurl = new HashSet<String>();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			String linkurl = link.getAttribute("href");
			URL url= new URL(linkurl);
			URLConnection openConnection = url.openConnection();
			HttpsURLConnection httpurl = (HttpsURLConnection)openConnection;
			httpurl.setConnectTimeout(6000);
			httpurl.connect();
			if(httpurl.getResponseCode()==200) {
				
				brokensurl.add(linkurl);
				/*System.out.println("LinkUrl" +httpurl.getResponseCode()+ " - "+ httpurl.getResponseMessage());
				}
			else {
				System.err.println("LinkUrl" +httpurl.getResponseCode()+ " - "+ httpurl.getResponseMessage());
			}*/
				}
			httpurl.disconnect();
		}
		
		 
		 
		
		driver.quit();
		 for (String brokenurl : brokensurl) { System.err.println(brokenurl); }
		
		
	}

}
