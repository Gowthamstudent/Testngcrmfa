package webDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImage {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		testbrokenimageusingselenium();
		brokenimageusingjsoup();
		
	}
public static void testbrokenimageusingselenium() throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.theworldsworstwebsiteever.com/");
		Thread.sleep(4000);
		List<WebElement> ImgL = driver.findElements(By.tagName("img"));
		for (WebElement Imglin : ImgL) {
			String Images = Imglin.getAttribute("src");
			try {
				URL url = new URL(Images);
				URLConnection openConnection = url.openConnection();
				HttpURLConnection httpurl = (HttpURLConnection)openConnection;
				httpurl.setConnectTimeout(5000);
				httpurl.connect();
				if(httpurl.getResponseCode()==200) 
					System.out.println(Images+ "-->>"+httpurl.getResponseCode()+ " --"+httpurl.getResponseMessage());
				else 
					System.err.println(Images+ "-->>"+httpurl.getResponseCode()+ " --"+httpurl.getResponseMessage());
				httpurl.disconnect();
			} catch(Exception e) {
				System.err.println(Images);
			}
		}

		driver.quit();
	}

public static void brokenimageusingjsoup() throws InterruptedException, IOException {
	
	Document doc = Jsoup.connect("https://www.theworldsworstwebsiteever.com/").get();
	Elements Imgages = doc.select("img");
	for (Element image : Imgages) {
		String imagesrc = image.attr("src");
	/*WebDriver driver =new ChromeDriver();
	driver.get("https://www.theworldsworstwebsiteever.com/");
	Thread.sleep(4000);
	List<WebElement> Imgages = driver.findElements(By.tagName("img"));
	for (WebElement image : Imgages) {
		String imagesrc = image.getAttribute("src");*/
		
		try {
			URL url = new URL(imagesrc);
			URLConnection openConnection = url.openConnection();
			HttpURLConnection httpurl = (HttpURLConnection)openConnection;
			httpurl.setConnectTimeout(5000);
			httpurl.connect();
			if(httpurl.getResponseCode()==200)
				System.out.println(imagesrc+ "-->>"+httpurl.getResponseCode()+ " --"+httpurl.getResponseMessage());
			else
				System.err.println(imagesrc+ "-->>"+httpurl.getResponseCode()+ " --"+httpurl.getResponseMessage());
			
			httpurl.disconnect();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(imagesrc);
		}
		}
	//driver.quit();
}


}
