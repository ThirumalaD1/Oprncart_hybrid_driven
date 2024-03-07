package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclasss {

	public static WebDriver driver;
	public Properties p;
	public WebDriverWait mywaits;
	public Logger log;

	@BeforeClass(groups = { "master", "regression", "sanity" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {
		log = LogManager.getLogger(this.getClass());

		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		if (p.getProperty("env_var").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities desiredcap = new DesiredCapabilities();
			
			if (os.equalsIgnoreCase("windows")) {
				
				desiredcap.setPlatform(Platform.WINDOWS);
			} else if (os.equals("mac")) {
				desiredcap.setPlatform(Platform.MAC);
				
			} else{
				System.out.println("No match for platform");

			}
			switch(br.toLowerCase()) {
			case "chrome": desiredcap.setBrowserName("chrome"); break;
			case "edge": desiredcap.setBrowserName("MicrosoftEdge"); break;
			
	        default: System.out.println("No browser match");
	        return;
			}
			driver=new RemoteWebDriver(new URL(" http://192.168.1.7:4444/wd/hub"),desiredcap);
					
		}else if (p.getProperty("env_var").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No browser matching");
				return;
			}	
			
			
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		mywaits = new WebDriverWait(driver, Duration.ofSeconds(10));
		// driver.get("https://demo.opencart.com/index.php?");
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();

	}

	public String setrandomstring() {
		String randomstring = RandomStringUtils.randomAlphabetic(7);
		return randomstring;
	}

	public String setrandomnum() {
		String randomnum = RandomStringUtils.randomNumeric(10);
		return randomnum;
	}

	public String setAlphanum() {
		String randomalphanum = RandomStringUtils.randomAlphanumeric(10);
		return randomalphanum;

	}

	public String capturescreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}