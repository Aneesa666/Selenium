package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
	WebDriver driver;
	
	private By email= By.id("user_email");

	private By password =By.cssSelector("input#user_password");
	
	private By submit=By.xpath("//input[@type='submit']");

	private By forgotPwd=By.xpath("//a[@class='link-below-button']");

	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
this.driver=driver;
}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPwd()
	{
		return driver.findElement(password);
	}
	public WebElement clickSubmit()
	{
		return driver.findElement(submit);
	}
	
	public ForgotPasswordPage forgotPassword()
	{
		driver.findElement(forgotPwd).click();
		ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		return fp;
		
	}
	
}
