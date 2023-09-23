package webDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement type = driver.findElement(By.xpath("//*[@type='search']"));
		type.sendKeys("Java");
		Thread.sleep(4000);
		
		List<WebElement> liste = driver.findElements(By.xpath("//div[@role='presentation']/ul/descendant::li"));
		int size = liste.size();
		
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			String text = liste.get(i).getText();
			System.out.println(text);
			if(text.contains("javatpoint")) {
				liste.get(i).click();
				break;
			}
			
			
		}
		
		
		//driver.quit();
		
		
	}

}
