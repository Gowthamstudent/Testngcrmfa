package testNg;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilityt.Datautils;
@Listeners(Customlist.class)
public class Login extends BaseClass {
	String screenName;
	String mainpage;
	BaseClass b = new BaseClass();
	ExtentSparkReporter  spark;
	ExtentReports reports;
	ExtentTest Testcase;
	@BeforeSuite
	public void launchreport() {
		spark = new ExtentSparkReporter("Testreport.html");
		reports = new ExtentReports();
		reports.attachReporter(spark);	
	}
	
	@AfterSuite
	public void savereport() {
		reports.flush();
	}
	
	@BeforeMethod
	public void LaunchBrowser() {
		b.browser();
		b.MasterUrl();
	}

	// private static final String dataProvider = null;
	// @Parameters({"ComName","browser"})
	@Test (priority =1)
	// (dataProvider = "getdata", dataProviderClass = Datautils.class)
	public void testmain() throws IOException {
		// String company ,String brow --> use if @parameter used
		// String data1[] ---> only for @Dataprovider used in Method paramatreization
		// System.out.println("username is:" + data[0]); ----> output for DataProvider
		// from Excel
		// System.out.println(" passwordis:" + data[1]);

	    Testcase = reports.createTest(" Login Page ");
		WebElement user = b.idLocator("username");
		b.sendkeys(user, b.excelRead("TData", 1, 0));

		WebElement passw = b.idLocator("password");
		b.sendkeys(passw, b.excelRead("TData", 1, 1));
		WebElement fin = b.classnamelocator("decorativeSubmit");
		b.clickM(fin);
		b.sleep(1000);
		b.screenshotA("Leelavathy");
		WebElement but = b.idLocator("button");
		b.clickM(but);
		b.screenshotA("Abirami");
		/*
		 * }
		 * 
		 * @Test (priority =2) public void createLead() {
		 */
		WebElement Clead = b.xpathlocator("//a[text()='Create Lead']");
		b.clickM(Clead);
		WebElement Formfill = b.idLocator("createLeadForm_companyName");
		b.sendkeys(Formfill, "Azees&Co");
		WebElement wind = b.xpathlocator("//input[@id='createLeadForm_parentPartyId']/following::a[1]");
		b.clickM(wind);
		b.windowhandle(1);
		b.sleep(1000);
		// driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10477");
		/*
		 * WebElement comp = b.nameloc("accountName"); b.sendkeys(comp,
		 * "Debit Limited Account_Carol");
		 * b.xpathlocator("//button[text()='Find Accounts']").click(); //
		 * b.xpathlocator("//a[text()='10477']").click(); b.sleep(5000); b.sleep(3000);
		 * b.xpathlocator("//a[text()='Debit Limited Account_Carol']").click();
		 */
		WebElement drop = b.nameloc("dataSourceId");
		//b.screenshotA("final");
		b.dropdown(drop, "Cold Call");
		
		/*
		 * Select dr = new Select(drop); List<WebElement> a = dr.getOptions(); for
		 * (WebElement a1 : a) { String text = a1.getText(); if }
		 */
			 
		 
		b.quitb();
		
		//Testcase.log(Status.PASS, markup)
	}
	
	
	@AfterMethod
	public void stat(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			Testcase.log(Status.FAIL, "Testcase failed res" + " " + result.getName());
			String screen =b.screenshotA(result.getName());
			Testcase.addScreenCaptureFromPath(screen);
			
		}
		else if (result.getStatus()==ITestResult.SUCCESS){
			Testcase.log(Status.PASS, "Testcase passed res" + result.getName());
		}
		else if (result.getStatus()==ITestResult.SKIP){
			Testcase.log(Status.SKIP, "Testcase skipped res" + result.getName());
		}
		
	}

	
	
	
	
	/*
	 * @AfterMethod public void failedscre(ITestResult result) {
	 * 
	 * if (ITestResult.FAILURE == result.getStatus()) {
	 * b.screenshotA(result.getName()); }
	 * 
	 * }
	 */
	  
 }
