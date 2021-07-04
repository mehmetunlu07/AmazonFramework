package com.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testbase.PageInitializer;
import com.utils.CommonMethods;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver setUp() {
		
		String filePath=System.getProperty("user.dir")+"/src/test/resources/configs/configuration.properties";
		CommonMethods.readProperties(filePath);
		
		switch (CommonMethods.getProperty("browser")) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			throw new RuntimeException("Browser is not supported");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get(CommonMethods.getProperty("url"));
		// initialize all page objects as part of setup
		PageInitializer.initialize();

		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
