package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public WebDriver driver;
	public Properties prop;
	public Logger log;

	public base() {
		log = LogManager.getLogger(base.class.getName());
	}

	//Initialize Driver
	public WebDriver initializeDriver() throws IOException {
		
		getPropertiesFile();
		String browserName = prop.getProperty("browser");
		

		if (browserName.equals("chrome")) {
			

//			// execute in chrome driver
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			
			// Alternate solution to using the chromedriver.exe . This will execute on the
			// latest version of chromedriver
			 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			

		} else if (browserName.equals("firefox")) {
//			// execute in firefox driver 
//			System.setProperty("webdriver.gecko.driver",
//					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browserName.equals("IE")) {
//          //execute in IE driver
//			System.setProperty("webdriver.ie.driver",
//					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Maximize current window
		driver.manage().window().maximize();
		return driver;
	}

	public String getURL() {

		String url = prop.getProperty("url");
		return url;

	}

	public Properties getPropertiesFile() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		return prop;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}
	


}
