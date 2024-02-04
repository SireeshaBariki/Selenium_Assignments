package seleniumassignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidLoginTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//Open the URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		FileInputStream file= new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\StarAgile_SeleniumAssignments\\TestData\\Logindata.xlsx"); 
		XSSFWorkbook workbook = new XSSFWorkbook (file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowcount=sheet.getLastRowNum();
		int colcount=sheet.getRow(0).getLastCellNum();
		System.out.println(rowcount+"    "+colcount   );
		try {
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow row=sheet.getRow(i);
			String user=row.getCell(0).getStringCellValue();
			String pwd=row.getCell(1).getStringCellValue();
			//Username
			driver.findElement(By.name("username")).sendKeys(user);

			//Password
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);

			//Login Button
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
					
			String Invalid=driver.findElement(By.className("oxd-text oxd-text--p oxd-alert-content-text")).getText();
			if(Invalid.equals("Invalid credentials"))
			{
				driver.close();
			}
			
			driver.findElement(By.className("oxd-userdropdown-name")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
			
			
			Thread.sleep(1000);
	
		}}
		catch(Exception e)
		{
			System.out.println("----");
		}
		
		driver.close();
	}

		

	}


