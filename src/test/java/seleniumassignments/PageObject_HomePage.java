package seleniumassignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_HomePage {
	
	public WebDriver driver;
	
	//Constructor
	PageObject_HomePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}

	// WebElements Locators+identification
@FindBy(xpath="//input[@placeholder='Username']") WebElement Username_InputTxt;
@FindBy(xpath="//input[@placeholder='Password']") WebElement Password_InputTxt;
@FindBy(xpath="//button[normalize-space()='Login']") WebElement Login_button ;
@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']") WebElement forgotYourPassword;
@FindBy(xpath="//a[normalize-space()='OrangeHRM, Inc']") WebElement orangeHRM,Inc;
@FindBy(xpath="//h5[normalize-space()='Login']") WebElement login_title;
@FindBy(xpath="//img[@alt='company-branding']") WebElement company_logo;



//Action methods

public void setUserName(String username)
{
	Username_InputTxt.sendKeys(username);
}

public void setPassword(String password)
{
	Password_InputTxt.sendKeys(password);
}

public void clicklogin()
{
	Login_button.click();
}

public boolean checkLogoPresence()
{
	boolean status=company_logo.isDisplayed();
	return status;
}
}
