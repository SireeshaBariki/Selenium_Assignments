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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshotOfaWebPage {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Open the URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//Username
		driver.findElement(By.name("username")).sendKeys("Admin");
         //opensource-demo.orangehrmlive.com/web/index.php/auth/login
		//Password
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

	    //Login Button
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Thread.sleep(3000);
		String MainPAge_Title = driver.getTitle();
		System.out.println("Title of the page " + MainPAge_Title); 
		
		
		//Capture fullScreen of the Webpage
		TakesScreenshot ts= (TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File Target =new File("C:\\Users\\Admin\\eclipse-workspace\\StarAgile_SeleniumAssignments\\Screenshots\\FullPage.png");
		FileUtils.copyFile(Source, Target);
		
driver.quit();
	}

}
