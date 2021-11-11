package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }
    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
       AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
       accountSummaryPage.savings.click();
    }
    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String string) {
        Assert.assertEquals("Zero - Account Activity", Driver.get().getTitle());
    }


    @And("Account drop down should have {string} selected")
    public void accountDropDownShouldHaveSelected(String expected) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        Select selectDropdown= new Select(accountActivityPage.dropdown);
        String expectedText = expected;
        String actualText = selectDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void theUserClicksOnBrokerageLinkOnTheAccountSummaryPage() {
        new AccountSummaryPage().brokerage.click();
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void theUserClicksOnCheckingLinkOnTheAccountSummaryPage() {
        new AccountSummaryPage().checking.click();
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void theUserClicksOnCreditCardLinkOnTheAccountSummaryPage() {
        new AccountSummaryPage().creditCard.click();
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void theUserClicksOnLoanLinkOnTheAccountSummaryPage() {
        new AccountSummaryPage().loan.click();
    }
    @When("the user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnLinkOnTheAccountSummaryPage(String expectedAccount) {
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.getAccountName(expectedAccount).click();

    }

    @And("Account drop down shows {string} selected")
    public void accountDropDownShowsSelected(String options) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        accountActivityPage.getOptions(options);
    }

    @When("the user clicks on Account Activity module")
    public void the_user_clicks_on_Account_Activity_module() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        accountActivityPage.accountActivity.click();

    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());

    }

    @Then("Account drop down default option should be {string}")
    public void account_drop_down_default_option_should_be(String expectedOption) {
       Select select=new Select(new AccountActivityPage().dropdown);
       Assert.assertEquals(expectedOption,select.getFirstSelectedOption().getText());

    }

    @Then("Account dropdown should have the following options")
    public void account_dropdown_should_have_the_following_options(List<String > dropdownOptions) {
        Select select=new Select(new AccountActivityPage().dropdown);
        List<String> actualOptions= BrowserUtils.getElementsText(select.getOptions());
        Assert.assertEquals(dropdownOptions,actualOptions);


    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedColumnNames) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        List<WebElement> actualColumnNames = accountActivityPage.columnNames;
        Assert.assertEquals(expectedColumnNames,actualColumnNames);


    }





}
