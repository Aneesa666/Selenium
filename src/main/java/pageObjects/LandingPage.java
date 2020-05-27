package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {
	WebDriver driver;
	
	private By login =By.xpath("//a[contains(@href,'sign_in')]");
	
	
	private By title=By.xpath("//h2[contains(text(),'Featured Courses')]");

	private By navbar= By.xpath("//div[@class='navbar navbar-default navbar-static-top']");
	
	private By header =By.cssSelector("div[class*='video-banner'] h3");
	
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public LoginPage login()
	{
		driver.findElement(login).click();
		LoginPage lp =new LoginPage(driver);
		return lp;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(navbar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	
	

}
