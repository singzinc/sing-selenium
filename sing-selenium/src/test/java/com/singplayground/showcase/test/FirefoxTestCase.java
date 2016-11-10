package com.singplayground.showcase.test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxTestCase {

	//WebDriver driver = new FirefoxDriver();

	@Test
	public void test() {
		// ================= setting ==================
		System.setProperty("webdriver.gecko.driver", "C:\\webdriver\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("Window maximise");
		driver.get("http://localhost:8081/projectname");
		System.out.println("Site Open");

		try {
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath("//button[@name='login']")).isEnabled());

			System.out.println("sleep 1 ");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("saaaa");
			driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("bbbb");
			Thread.sleep(2000);
			System.out.println("-------");
			driver.findElement(By.xpath("//button[@name='login']")).click();

			System.out.println("sleep 2 ");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("error : " + e);
		}

		driver.quit();
		System.out.print("End of Test");
	}

	@Test
	public void test2() {
		// ================= setting ==================
		//System.setProperty("webdriver.gecko.driver", "C:\\webdriver\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver_win32\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability("marionette", true);
		try {
			System.out.println("-----1");
			WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			System.out.println("-----2");
			driver.manage().window().maximize();
			System.out.println("-----3");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			System.out.println("-----4");
			driver.get("http://www.google.com");
			Thread.sleep(2000);

			/*
			WebDriver driver = new FirefoxDriver(capabilities);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			System.out.print("Window maximise");
			driver.get("http://xxxxxxxxxxxxxxx_domain_name.com/project_name/login");
			System.out.println("Site Open");
			System.out.println(driver.findElement(By.xpath("//input[@value='Login']")).isEnabled());

			try {
				System.out.println("sleep 1 ");
				driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("10000003123");
				driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("Arba1234");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//input[@value='Login']")).click();

				System.out.println("sleep 2 ");
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("error : " + e);
			}
			*/
			driver.quit();
			System.out.print("End of Test");
		} catch (Exception e) {
			System.out.println("error ----- " + e);
		}
	}

}
