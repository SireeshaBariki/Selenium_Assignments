package seleniumassignments;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Registration_Form {
	public static String randomstring()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public static String randomnumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	public static String randomalphanumeric()
	{
		String str1=RandomStringUtils.randomAlphabetic(7);
		String str2=RandomStringUtils.randomNumeric(3);
		return (str1+str2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//JavascriptExecutor driver;
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		
		//Open the URL
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		
//First Name & Last Name
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys(randomstring().toUpperCase());
		driver.findElement(By.name("RESULT_TextField-2")).sendKeys(randomstring().toUpperCase());
//Phone
		driver.findElement(By.cssSelector("#RESULT_TextField-3")).sendKeys(randomnumber());
		
//Country
		driver.findElement(By.xpath("//input[@id='RESULT_TextField-4']")).sendKeys(randomstring().toUpperCase());
//City
		driver.findElement(By.xpath("//input[@id='RESULT_TextField-5']")).sendKeys(randomstring().toUpperCase());
		//Email Address
		driver.findElement(By.cssSelector("#RESULT_TextField-6")).sendKeys(randomalphanumeric()+"@gmail.com");
		//Gender
		driver.findElement(By.xpath("//label[normalize-space()='Male']")).click();
		//driver.findElement(By.xpath("//label[normalize-space()='Female']"));
		
		//Select days of the week 
		
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
	    System.out.println("Total Number of CheckBoxes :"+checkboxes.size());
	  
	   // driver.findElement(By.cssSelector("label[for='RESULT_CheckBox-8_0']")).click();
	   /*for(int i=0;i<checkboxes.size();i++);
	    {
	    	
			checkboxes.get(0).click();
	    }*/
	 
	for(WebElement chkbox :checkboxes)
	 {
		 js.executeScript("arguments[0].click();",chkbox );//Exception in thread "main" org.openqa.selenium.ElementClickInterceptedException
	 } 
	   /* for(int i=0;i<checkboxes.size();i++);
	    {
	    	js.executeScript("arguments[0].click();",checkboxes );//able to click only sunday
			//checkboxes.get(0).click();
	    }*/
	    //Best Time to Contact
	WebElement dropdown=driver.findElement(By.cssSelector("#RESULT_RadioButton-9"));
	Select TimetoContact=new Select(dropdown);
	//Find how many options present in the dropdown
	System.out.println("Number of options present in the dropdown "+TimetoContact.getOptions().size());
	
	//Print all the options in the dropdown
	List<WebElement> options= TimetoContact.getOptions();
	System.out.println("Options present in the dropdown.... ");
	for(int i=0;i<options.size();i++)
	{
		System.out.println(options.get(i).getText());
		if(options.get(i).getText().equals("Evening"))
		{
			options.get(i).click();
			
		}
	}
	//Submit
	//driver.findElement(By.name("Submit")).click();
	}

}
