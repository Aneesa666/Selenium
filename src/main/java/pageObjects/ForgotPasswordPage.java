package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ForgotPasswordPage {
	WebDriver driver;
	
	private By email= By.id("user_email");
	
	private By sendMe=By.xpath("//input[@name='commit']");
		
	public ForgotPasswordPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
this.driver=driver;
}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement clickSendMe()
	{
		return driver.findElement(sendMe);
	}

}
