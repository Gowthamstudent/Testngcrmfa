package webDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screenshotutil {
	//WebDriver driver;
	public static void screnuti(WebDriver driver, String Screenname) throws IOException {
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//File screenshot = driver.getScreenshotAs(OutputType.FILE);
	String path = "./Screen/" + screenshot.getName();
	//File dest = new File(path);
	File dest = new File("./Screen/"+Screenname+".png");
	//FileUtils.copyFile(screenshot, dest);
	//FileHandler.copy(screenshot, dest);
	WebElement element = driver.findElement(By.xpath("//button[@id='property']"));
	File Screen2 = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
	File dest2 =new File("./Screen/"+Screenname+".png");
	FileUtils.copyFile(Screen2, dest2);
}
}