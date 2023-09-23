package webDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	public static void main(String[] args) throws IOException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		//FirefoxDriver driver =new FirefoxDriver();
		driver.get("https://letcode.in/buttons");
		Screenshotutil.screnuti(driver,"shot1");
		/*
		 * File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * //File screenshot = driver.getScreenshotAs(OutputType.FILE); File dest = new
		 * File("./Screen/img.png"); FileUtils.copyFile(screenshot, dest);
		 * //FileHandler.copy(screenshot, dest); WebElement element =
		 * driver.findElement(By.xpath("//button[@id='property']")); File Screen2 =
		 * ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE); File dest2 =new
		 * File("./Screen/img1.png"); FileUtils.copyFile(Screen2, dest2);
		 */
		
		driver.quit();
		
		
	}

}
