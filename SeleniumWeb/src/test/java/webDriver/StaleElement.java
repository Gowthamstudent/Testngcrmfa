package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		driver.get("https://letcode.in");
		driver.findElement(By.xpath("//a[text()='Work-Space']")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		WebElement button = driver.findElement(By.xpath("//a[text()='Click']"));
		button.click();
		driver.navigate().back();
		try {
		button.click();}
		catch(StaleElementReferenceException e) {
			 button = driver.findElement(By.xpath("//a[text()='Click']"));
			button.click();
		}
		driver.quit();
	}

}
