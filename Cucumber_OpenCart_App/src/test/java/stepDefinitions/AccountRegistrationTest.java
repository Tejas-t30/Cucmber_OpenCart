package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class AccountRegistrationTest {
	WebDriver driver=BaseClass.getDriver();
	HomePage hp=new HomePage(driver);
	RegistrationPage rp=new RegistrationPage(driver);
	@Given("user clicks on register link on the home page")
	public void user_clicks_on_register_link_on_the_home_page() {
		hp.clickMyAccount();
		hp.clickRegister();
	  
	}

	@When("user navigates to the Account Registration page")
	public void user_navigates_to_the_account_registration_page() {
		String confirmMsg=rp.registrationPageConfirmation();
	    Assert.assertEquals(confirmMsg,"Register Account");
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap=dataTable.asMap();
		rp.firstName(dataMap.get("firstName"));
		rp.LastName(dataMap.get("lastName"));
		rp.email(BaseClass.randomAlphaNumeric()+"@gmail.com");
		rp.phoneNumber(dataMap.get("telephone"));
		rp.password(dataMap.get("password"));
		rp.confirmPassword(dataMap.get("password"));
	  
	}

	@When("user accepts the privacy policy")
	public void user_accepts_the_privacy_policy() {
		rp.agree();
	    
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		rp.continueButton();
	    
	}

		@Then("the user Account Registers successfully")
	public void the_user_account_registers_successfully() {
		String confirmMsg=rp.confirmationMsg();
		Assert.assertEquals(confirmMsg,"Your Account Has Been Created!");
	  
	}


}
