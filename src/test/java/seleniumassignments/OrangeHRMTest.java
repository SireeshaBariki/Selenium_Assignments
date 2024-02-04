package seleniumassignments;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

	public class OrangeHRMTest {

	    WebDriver driver; // Initialize your WebDriver instance

	    @BeforeMethod
	    public void setUp() throws InterruptedException {
	    	driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			Thread.sleep(2000);
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.close();
	    }

	    @Test(dataProvider = "loginData")
	    public void loginTest(String username, String password) throws IOException, InterruptedException {
	        // Perform login actions using WebDriver
	    	//Username
			driver.findElement(By.name("username")).sendKeys(username);
	        //Password
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
			//Login Button
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			
			// Capture screenshot for each login attempt
			Thread.sleep(2000);
	        long timestamp = System.currentTimeMillis(); // Get timestamp for unique filename
			TakesScreenshot screenshot= (TakesScreenshot)driver;
			File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
			try {
		        FileUtils.copyFile(screenshotFile, new File("Screenshots/login_attempt_" + timestamp + ".png"));
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

	        if (username.equals("Admin") && password.equals("admin123")) {
	            // Assert successful login for valid data set
	            Assert.assertTrue(true);
	        } else {
	            // Assert failed login for invalid data sets
	               	Assert.fail();
	        	   }
	      
	    }

	    @Test(dependsOnMethods = "loginTest")
	    public void logoutTest() {
	        // Perform logout actions using WebDriver
	    	driver.close();
	    }

	    @DataProvider(name = "loginData")
	    public Object[][] getData() throws IOException {
	        return ExcelReader.readDataFromExcel("login_data.xlsx");
	    }
	}


