package Baseclass;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases{
	
	@BeforeTest
	public void start() {
		System.out.println("start");
	}
	
	@Test
	public void launch() throws InterruptedException {
		Login.launchbrowser();
	}
	
	@AfterTest
	public void end() {
		System.out.println("End");
	}
}