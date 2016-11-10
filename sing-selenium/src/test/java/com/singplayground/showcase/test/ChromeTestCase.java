package com.singplayground.showcase.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTestCase {

	@Test
	public void test() {
		TestUtil testUtil = new TestUtil();

		// ======================= setting =====================

		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		//======================================================

		System.out.print("Window maximise");
		driver.get("http://localhost:8081/projectname/");
		System.out.println("Site Open");
		System.out.println(driver.findElement(By.xpath("//input[@value='Login']")).isEnabled());

		try {
			System.out.println("sleep 1 ");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("aaaaa");
			driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("bbbbb");
			Thread.sleep(2000);

			testUtil.getScreen(driver, "case1", "1");
			driver.findElement(By.xpath("//input[@value='Login']")).click();

			driver.findElement(By.className("form-group"));
			System.out.println("get the value : " + driver.findElement(By.xpath("//h1[@class='page-header']")).getText().toString());
			testUtil.getScreen(driver, "case1", "2");

			System.out.println("sleep 2 ");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("error : " + e);
		}

		driver.quit();
		System.out.print("End of Test");
	}

}
