package midigiworld;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Desktop\\selenoum\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// URL

		String url = "https://uat-instructor.midigiworld.com/";
		driver.get(url);
		String Text = driver.getTitle();
		System.out.println(Text);

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

		}
		Thread.sleep(5000);

		// already login
		if (driver.findElement(By.xpath("//p[contains(text(),'already logged')]")) != null) {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Yes']")).click();

		}

		else {
			System.out.println("Element is Absent");

		}

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
			Thread.sleep(6000);

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
			Thread.sleep(6000);
			driver.findElement(By.xpath("//span[text()='Save & Next']")).click();

		}

		// Type
		Thread.sleep(5000);
		WebElement Typepage = driver.findElement(By.xpath("//p[text()='Type']"));
		String Typepage1 = Typepage.getText();
		System.out.println(Typepage1);
		if (Typepage.getText().equals(Typepage1)) {
			Thread.sleep(2000);

			WebElement Slotbase = driver
					.findElement(By.xpath("//p[text()='Short term courses [Multiple single sessions]']"));
			Slotbase.click();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Save & Next']")).click();
		}

		// session details
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
			WebElement suggestprice = driver.findElement(By.xpath("//input[@name='suggested_price']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", suggestprice);
			Thread.sleep(2000);
			suggestprice.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='suggested_price']")).sendKeys("10");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='No']")).click();
			Thread.sleep(2000);

			// date
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String formattedDate = sdf.format(date);
			System.out.println(formattedDate);
			
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Send for Approval']")).click();
		}
	}

}
