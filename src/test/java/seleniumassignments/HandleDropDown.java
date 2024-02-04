package seleniumassignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {
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
System.out.println("Title of the page : " + MainPAge_Title);

//PIM
driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

//Job Title DropDown
driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();

//Extracting all elements from dropdown
List<WebElement> JobTitleOptions=driver.findElements(By.xpath("//div[@role=\"listbox\"]//span"));

//Find Total Number Of Options
System.out.println("Number of Options in the Dropdown:"+JobTitleOptions.size());

//Print all the options from the Dropdown
System.out.println("Displaying the Options in the Dropdown :");
for(WebElement Options:JobTitleOptions) {
	System.out.println(Options.getText());
}

//Select option from dropdown
for(int i=0;i<JobTitleOptions.size();i++)
{try
{
	if(JobTitleOptions.get(i).getText().equals("QA Engineer"))
	{	
	 
		JobTitleOptions.get(i).click();
		System.out.println("QA Engineer is selected");
	    }
	 }
   catch(Exception e)
   {
	//System.out.println("---");
   }
}
driver.quit();
}

}
