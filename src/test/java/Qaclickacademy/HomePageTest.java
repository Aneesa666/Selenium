package Qaclickacademy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePageTest extends base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void loadURL() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to landing page");
	}

	@Test(dataProvider = "getData")
	public void ValidateHomePage(String username, String password, String text) throws IOException {
		LandingPage ld = new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPage lp = ld.login();
		// LoginPage lp =new LoginPage(driver);
		lp.getEmail().sendKeys("adsad@gmail.com");
		lp.getPwd().sendKeys(password);
		// System.out.println(text);
		lp.clickSubmit().click();
		log.info("clicked submit");
		ForgotPasswordPage fp = lp.forgotPassword();
		fp.getEmail().sendKeys("dasdsafasdf@gmail.com");
		fp.clickSendMe().click();
		log.info("clicked submit");
	}

	@DataProvider
	public Object[][] getData() {
		// Array size is 5
		// 0,1,2,3,4
		Object[][] data = new Object[2][3];
		data[0][0] = "abc@gmail.com";
		data[0][1] = "asdqdq2";
		data[0][2] = "Non restricted User";
		data[1][0] = "abcwre@gmail.com";
		data[1][1] = "asdwerwerweqdq2";
		data[1][2] = "Restricted User";
		return data;
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("homepage browser is closed");
	}
}