package Qaclickacademy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;

public class ValidateTitleTest extends base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage ld;
	@BeforeTest
	public void loadURL() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validateTitle() throws IOException {
		ld = new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(ld.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated");
	}
	
	@Test
	public void validateHeader() throws IOException
	{
		ld = new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(ld.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("validate title test browser is closed");
	}
}