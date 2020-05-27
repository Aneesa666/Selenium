package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		 prop =new Properties();
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser");//gets the browser property from maven command mvn -test -Dbrowser=chrome
		//String browserName=prop.getProperty("browser");
				//browserName=browserName.substring(0, browserName.length());
		System.out.println(browserName);	
		System.out.println(System.getProperty("user.dir"));
		if(browserName.contains("chrome"))
			{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("--headless");
			}
			driver=new ChromeDriver(options);
			
			}
		
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

public String getScreenshotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String dest=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(src,new File(dest));
	return dest;
}


}

