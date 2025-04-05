package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage  extends BasePage{
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']") WebElement txtFirstName;
	@FindBy(xpath="//input[@placeholder='Last Name']") WebElement txtLastName;
	@FindBy(xpath="//input[@placeholder='E-Mail']") WebElement txtEmail;
	@FindBy(xpath="//input[@placeholder='Telephone']") WebElement txtPhoneNumber;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txtPassword;
	@FindBy(xpath="//input[@placeholder='Password Confirm']") WebElement txtConfirmPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement chkAgree;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmMsg;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement warningMsg;
	@FindBy(xpath="//div[@class='text-danger']") WebElement pswdErrorMsg;
	@FindBy(xpath="//h1[text()='Register Account']")WebElement regPageConformation;
	public void firstName(String firstName)
	{
		txtFirstName.sendKeys(firstName);
	}
	public void LastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}
	public void email(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void phoneNumber(String phNumber)
	{
		txtPhoneNumber.sendKeys(phNumber);
	}
	public void password(String pswd)
	{
		txtPassword.sendKeys(pswd);
	}
	public void confirmPassword(String confirmPswd)
	{
		txtConfirmPassword.sendKeys(confirmPswd);
	}
	public void agree()
	{
		chkAgree.click();
	}
	public void continueButton()
	{
		btnContinue.click();
	}
	
	public String confirmationMsg()
	{
		try {
			return confirmMsg.getText();
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public String warningMsg()
	{
		try {
			return warningMsg.getText();
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	public String passwordErrorMsg()
	{
		try {
			return pswdErrorMsg.getText();
			}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	public String registrationPageConfirmation()
	{
		try {
			return regPageConformation.getText();
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
}
