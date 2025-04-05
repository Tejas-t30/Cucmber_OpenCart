package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class loginTest {
	WebDriver driver; //=BaseClass.getDriver();
//	HomePage hp=new HomePage(driver);
//	LoginPage lp=new LoginPage(driver);
//	MyAccountPage mp=new MyAccountPage(driver);
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;
	
	@Given("User clicks on login button on home page")
	public void when_user_clicks_on_login_button_on_home_page() {
		hp=new HomePage(BaseClass.getDriver());
	    hp.clickMyAccount();
	    hp.clickLogin();
	}

	@When("user enters email is as {string} and password as {string}")
	public void user_enters_email_is_as_and_password_as(String emailID, String pswd) {
		lp=new LoginPage(BaseClass.getDriver());
		lp.enterEmail(emailID);
		lp.enterPassword(pswd);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
	   lp.clickLogin();
	}

	@Then("user lands on MyAccount page")
	public void user_lands_on_my_account_page() {
		mp=new MyAccountPage(BaseClass.getDriver());
	    boolean logo=mp.ismyAccountTxtDisplayed();
	    Assert.assertTrue(logo);
	}
	
	
	//*******   Data Driven test **************
	 
	List<HashMap<String, String>> datamap; //Data driven
	@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
    {
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(BaseClass.getDriver());
        lp.enterEmail(email);
        lp.enterPassword(pwd);

        lp.clickLogin();
        mp=new MyAccountPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=mp.ismyAccountTxtDisplayed();
            System.out.println("target page: "+ targetpage);
            if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
//                    MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
//                    myaccpage.logoutClick();
                    mp.logoutClick();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("Invalid"))
            {
                if(targetpage==true)
                {
                    mp.logoutClick();;
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
      }


}
