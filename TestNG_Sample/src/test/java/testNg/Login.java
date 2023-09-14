package testNg;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilityt.Datautils;
@Listeners(Customlist.class)
public class Login extends BaseClass {
	String screenName;
	String mainpage;
	BaseClass b = new BaseClass();
  
	@BeforeMethod
	public void LaunchBrowser() {
		b.browser();
		b.MasterUrl();
	}

	// private static final String dataProvider = null;
	// @Parameters({"ComName","browser"})
	@Test
	// (dataProvider = "getdata", dataProviderClass = Datautils.class)
	public void testmain() throws IOException {
		// String company ,String brow --> use if @parameter used
		// String data1[] ---> only for @Dataprovider used in Method paramatreization
		// System.out.println("username is:" + data[0]); ----> output for DataProvider
		// from Excel
		// System.out.println(" passwordis:" + data[1]);

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
		b.dropdown(drop, "Cold Ca");
		b.quitb();
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
