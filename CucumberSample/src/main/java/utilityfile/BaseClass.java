package utilityfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.sound.midi.SysexMessage;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
//import org.testng.annotations.Parameters;

//import utilityt.Datautils;

public class BaseClass {
	static WebDriver driver;
    //@Parameters({"browser"})
	public void browser() {

		// WebDriverManager.firefoxdriver().setup();
		/*
		 * switch (browser) { case "chrome": driver = new ChromeDriver(); break; case
		 * "firefox": driver =new FirefoxDriver(); break; default:
		 * System.err.println("broswer can't"); break; }
		 */
		driver = new ChromeDriver();
		// driver =new FirefoxDriver();
	}

	public void MasterUrl() {
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
public void quitb() {
	
	driver.quit();
}
	public WebElement idLocator(String idname) {
		WebElement idName = driver.findElement(By.id(idname));
		return idName;
	}

	public WebElement nameloc(String namel) {
		WebElement name = driver.findElement(By.name(namel));
		return name;
	}

	public WebElement xpathlocator(String xpathn) {
		WebElement xpathname = driver.findElement(By.xpath(xpathn));
		return xpathname;
	}

	public WebElement classnamelocator(String classname) {
		WebElement clsname = driver.findElement(By.className(classname));
		return clsname;
	}

	public void clickM(WebElement element) {
		element.click();
	}

	public void sendkeys(WebElement element, String name) {
		element.sendKeys(name);
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void windowhandle() {
		String Parentwindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		ArrayList<String> alltab = new ArrayList<String>(allwindow);
		driver.switchTo().window(alltab.get(1));
		String title = driver.getCurrentUrl();
		System.out.println("Current URl Child is: " + title);
		// Thread.sleep(5000);
	}

	public String excelRead(String sheet, int row, int cell) throws IOException {
		// String value=null;
		File f = new File("./test-data/CRMFA Data.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		DataFormatter d = new DataFormatter();
		String CellValue = d.formatCellValue(c);
		System.out.println(CellValue);
		w.close();
		return CellValue;

	}
 public void screenshotA(String screenName) {
	 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 File dest = new File("./ScreenS/"+screenName+".png");
	 try {
		FileUtils.copyFile(source, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //FileHandler.copy(source, dest);
	 
 }

public void sendKeys(CharSequence[] charSequences) {
	WebElement element = null;
	CharSequence name = null;
	// TODO Auto-generated method stub
	element.sendKeys(name);
}
}
