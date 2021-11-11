package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("the user enters username and password")
    public void the_user_enters_username_and_password() {
      String username=ConfigurationReader.get("username");
      String password=ConfigurationReader.get("password");


        LoginPage loginPage=new LoginPage();

        loginPage.login(username,password);

    }

    @Then("the user should see the Account Summary page")
    public void the_user_should_see_the_Account_Summary_page() {
        Driver.get().getTitle();
        Assert.assertEquals("Zero - Account Summary",Driver.get().getTitle() );
    }

    @When("the user enters wrong username and password")
    public void the_user_enters_wrong_username_and_password() {
       String wrongUsername=ConfigurationReader.get("wrong_username");
       String wrongPassword=ConfigurationReader.get("wrong_password");

        LoginPage loginPage = new LoginPage();
        loginPage.signIn.click();
        loginPage.username.sendKeys(wrongUsername);
        loginPage.password.sendKeys(wrongPassword);
        loginPage.submit.click();


    }

    @Then("the user should see the error message")
    public void the_user_should_see_the_error_message() {
       LoginPage loginPage=new LoginPage();
       Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @When("the user do not enter username and password")
    public void the_user_do_not_enter_username_and_password() {
       LoginPage loginPage=new LoginPage();
       loginPage.signIn.click();
       loginPage.username.sendKeys("");
       loginPage.password.sendKeys("");
       loginPage.submit.click();

    }



}
