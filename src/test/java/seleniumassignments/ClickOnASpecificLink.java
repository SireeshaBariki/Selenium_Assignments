package seleniumassignments;

import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickOnASpecificLink {

public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

//Open the URL
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//Username
driver.findElement(By.name("username")).sendKeys("Admin");

//Password
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

//Login Button
driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

String MainPAge_Title = driver.getTitle();
System.out.println("Title of the page before clicking the link: " + MainPAge_Title);

//Link
driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
Thread.sleep(1000);
Set<String> WindowsIDs = driver.getWindowHandles();
for (String WinID : WindowsIDs) 
{
	String Title = driver.switchTo().window(WinID).getTitle();
	if (Title.equals("OrangeHRM HR Software | OrangeHRM"))
	   {
		 System.out.println("Successfully Clicked the link");
		 System.out.println("Title of the page after clicking the link:" + Title);
		}
}
driver.quit();
}
}
