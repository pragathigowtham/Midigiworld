package midigiworld;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Baseclass.Login;


public class CourseCreation extends Login{

	static ExtentTest test;
	
	public  void coursecreation () throws InterruptedException {

		// TODO Auto-generated method stub
		// Create course
		Thread.sleep(5000);
		WebElement calendarPage = driver.findElement(By.xpath("//p[text()='Calendar']"));
		String calendarPage1 = calendarPage.getText();
		System.out.println(calendarPage1);
		if (calendarPage.getText().equals(calendarPage1)) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[text()='Courses'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Create Course']")).click();
			test.log(LogStatus.INFO, "Login successfully");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Course Title
		Thread.sleep(6000);
		WebElement titlePage = driver.findElement(By.xpath("//p[text()='Title']"));
		String titlePage1 = titlePage.getText();
		System.out.println(titlePage1);
		if (titlePage.getText().equals(titlePage1)) {
			Thread.sleep(2000);
			WebElement title = driver.findElement(By.xpath("(//input[@name='title'])"));
			title.sendKeys("New Course");
			WebElement tagline = driver.findElement(By.xpath("(//input[@name='tag_line'])"));
			tagline.sendKeys("New Course");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[text()='Save & Next'])")).click();
		}
		// About Course
		Thread.sleep(3000);
		WebElement AboutCoursePage = driver.findElement(By.xpath("//p[text()='About Course']"));
		String AboutCoursePage1 = AboutCoursePage.getText();
		System.out.println(AboutCoursePage1);
		if (AboutCoursePage.getText().equals(AboutCoursePage1)) {
			Thread.sleep(2000);
			WebElement learnwhat = driver.findElement(By.xpath("//textarea[@name='after_notes']"));
			learnwhat.sendKeys("New Course");

			WebElement description = driver.findElement(By.xpath("(//textarea[@name='detailed_description'])"));
			description.sendKeys("New Course");

			Thread.sleep(3000);

			driver.findElement(By.xpath("//span[text()='Save & Next']")).click();
		}
		// course details
		Thread.sleep(3000);
		WebElement CourseDetailsPage = driver.findElement(By.xpath("//p[text()='Course Details']"));
		String CourseDetailsPage1 = CourseDetailsPage.getText();
		System.out.println(CourseDetailsPage1);
		if (CourseDetailsPage.getText().equals(CourseDetailsPage1)) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@aria-labelledby='mui-component-select-course_skill_id']")).click();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[text()='Book Reading']")).click();

			driver.findElement(By.xpath("//div[@aria-labelledby='mui-component-select-level']")).click();
			driver.findElement(By.xpath("//li[@data-value='intermediate']")).click();

			driver.findElement(By.xpath("//div[@aria-labelledby='mui-component-select-language_id']")).click();
			driver.findElement(By.xpath("//li[text()='English']")).click();

			driver.findElement(By.xpath("//input[@name='age_start']")).sendKeys("20");
			driver.findElement(By.xpath("//input[@name='age_end']")).sendKeys("28");

			driver.findElement(By.xpath("//span[text()='Save & Next']")).click();
		}
		// Rules & Clarification
		Thread.sleep(3000);
		WebElement RulesClarificationPage = driver.findElement(By.xpath("//p[text()='Rules & Clarification']"));
		String RulesClarificationPage1 = RulesClarificationPage.getText();
		System.out.println(RulesClarificationPage1);
		if (RulesClarificationPage.getText().equals(RulesClarificationPage1)) {
			Thread.sleep(2000);
			WebElement Rules = driver.findElement(By.xpath("//textarea[@placeholder='Write Here']"));
			Rules.sendKeys("New course");

			if (driver.findElement(By.xpath("//span[text()='Yes']")).isDisplayed()) {
				System.out.println("Element is Visible");
				driver.findElement(By.xpath("//input[@type='radio']")).click();
			} else {
				System.out.println("Element is InVisible");
			}
			driver.findElement(By.xpath("//span[text()='Save & Next']")).click();
		}

		// photos
		Thread.sleep(3000);
		WebElement Photospage = driver.findElement(By.xpath("//p[text()='Photos']"));
		String Photospage1 = Photospage.getText();
		System.out.println(Photospage1);
		if (Photospage.getText().equals(Photospage1)) {
			Thread.sleep(2000);

			WebElement uploadpage = driver.findElement(By.xpath("//span[text()='UPLOAD']"));
			uploadpage.click();
			Thread.sleep(5000);			
			// Below line execute AUTOIT script
			try {
				Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\selenoum\\AutoIT\\Fileupload.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.sleep(5000);
			
			WebElement uploadpage1 = driver.findElement(By.xpath("(//span[text()='UPLOAD'])[2]"));
			uploadpage1.click();
			Thread.sleep(5000);
			// Below line execute AUTOIT script
			try {
				Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\selenoum\\AutoIT\\Videoupload.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
			Thread.sleep(5000);
			

			WebElement uploadpage2 = driver.findElement(By.xpath("(//span[text()='UPLOAD'])[3]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadpage2);		
			uploadpage2.click();
			Thread.sleep(5000);
			// Below line execute AUTOIT script
			try {
				Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\selenoum\\AutoIT\\Fileupload.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Save & Next']")).click();
			
		}
		
		//Type
		Thread.sleep(3000);
		WebElement Typepage = driver.findElement(By.xpath("//p[text()='Type']"));
		String Typepage1 = Typepage.getText();
		System.out.println(Typepage1);
		if (Typepage.getText().equals(Typepage1)) {
			Thread.sleep(2000);
			
		WebElement Slotbase= driver.findElement(By.xpath("//p[text()='Short term courses [Multiple single sessions]']"));
		Slotbase.click();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Save & Next']")).click();
		}
		
		//session details
		Thread.sleep(3000);
		WebElement SessionDetailspage = driver.findElement(By.xpath("//p[text()='Session Details']"));
		String SessionDetailspage1 = SessionDetailspage.getText();
		System.out.println(SessionDetailspage1);
		if (SessionDetailspage.getText().equals(SessionDetailspage1)) {
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@name='session_name']")).click();
			driver.findElement(By.xpath("//input[@name='session_name']")).sendKeys("Newcourse");
			
			driver.findElement(By.xpath("//div[text()='30 Min']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='number']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='number']")).sendKeys("10");
			Thread.sleep(2000);
		    WebElement suggestprice=driver.findElement(By.xpath("//input[@name='suggested_price']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", suggestprice);	
			Thread.sleep(2000);
			suggestprice.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='suggested_price']")).sendKeys("10");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='No']")).click();
			Thread.sleep(2000);
			
			//date
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String formattedDate = sdf.format(date);
			System.out.println(formattedDate);
			
//			driver.findElement(By.xpath("//input[@type='date']")).click();
//			driver.findElement(By.xpath("//p[text()='11']")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//span[text()='OK']")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//input[@type='time']")).click();
//			Thread.sleep(2000);
//		    WebElement element = driver.findElement(By.xpath("//span[text()='10']"));
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", element);
//		
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//span[@class='MuiButton-label'])[6]")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//span[text()='15'])")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//h6[text()='PM']")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//span[text()='OK']")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Send for Approval']")).click();
		}
			
		
	}

}
