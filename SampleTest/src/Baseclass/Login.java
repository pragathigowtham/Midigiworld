package Baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Login {
	public static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	

	/*
	 * public static void report() throws InterruptedException { // // TODO
	 * Auto-generated method stub report = new ExtentReports(
	 * System.getProperty("C:\\Users\\admin\\Desktop\\selenoum\\Report") +
	 * "\\ExtentReportResults.html"); test = report.startTest("ExtentDemo") ; }
	 */
public static void launchbrowser() throws InterruptedException {


		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Desktop\\selenoum\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	
		// URL
		
		String url = "https://uat-instructor.midigiworld.com/";
		driver.get(url);
		String Text = driver.getTitle();
		System.out.println(Text);
		
		  if (driver.getTitle().equals("Instructor")) { test.log(LogStatus.PASS,
		  "Navigated to the specified URL"); 
		  } 
		  else { test.log(LogStatus.FAIL,
		  "Test Failed"); }
		 
	
      Thread.sleep(5000);
      
		// Login
		String Email = "midigiworld.uat51@gmail.com";
		String Password = "max@12345";

		if (driver.findElements(By.xpath("//input[@id='user-email']")).size() != 0) {
			driver.findElement(By.xpath("//input[@id='user-email']")).sendKeys(Email);
			System.out.println("Email id :  " + Email);
			driver.findElement(By.xpath("//input[@id='user-password']")).sendKeys(Password);
			System.out.println("Password :  " + Password);
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			System.out.println("Login Successfully");
			test.log(LogStatus.INFO, "Login successfully");
		}
			Thread.sleep(5000);
		
		
		// already login
			if (driver.findElement(By.xpath("//p[contains(text(),'already logged')]")) !=null) {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Yes']")).click();
			test.log(LogStatus.INFO, "Login successfully");
		}
		
		else {
			System.out.println("Element is Absent");
			test.log(LogStatus.FAIL, "Failed Element");

		}
}


       

	
/*
 * public static void endTest() { report.endTest(test); report.flush(); }
 */

}

