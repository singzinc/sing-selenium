package com.singplayground.showcase.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	public boolean getScreen(WebDriver driver, String caseName, String caseSubNumber) {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\" + caseName + "\\screenshot_" + caseName + caseSubNumber + ".png"));
		} catch (Exception e) {
			System.out.println("");
			return false;
		}
		return true;
	}

}
