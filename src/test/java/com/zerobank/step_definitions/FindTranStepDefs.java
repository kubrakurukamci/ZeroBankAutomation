package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class FindTranStepDefs {
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {

     new AccountSummaryPage().getModule("Account Activity").click();

     new AccountActivityPage().findTransactions.click();


    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
       AccountActivityPage accountActivityPage=new AccountActivityPage();
       BrowserUtils.waitFor(3);
       accountActivityPage.fromDate.sendKeys(string);
       accountActivityPage.toDate.sendKeys(string2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startDate, String beginDate) {
        BrowserUtils.waitFor(2);
        //I could not find an uncomplicated solution





    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
       //I could not find an uncomplicated solution

    }



    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitFor(1);
       new AccountActivityPage().find.click();
    }



    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        //I am still thinking for a clear solution
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        BrowserUtils.waitFor(2);
      new AccountActivityPage().description.sendKeys(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        BrowserUtils.waitFor(2);
        new AccountActivityPage().getDescription(string);
        new AccountActivityPage().description.clear();
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        BrowserUtils.waitFor(2);
        new AccountActivityPage().DontGetDescription(string);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
       Assert.assertTrue(new AccountActivityPage().isOneResultUnderDeposit());

    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertTrue(new AccountActivityPage().isOneResultUnderWithdrawal());
    }



    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {

        Assert.assertTrue( new AccountActivityPage().isWithdrawalEmpty());
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        Select select= new Select(new AccountActivityPage().select);
        select.selectByVisibleText(string);


    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertTrue( new AccountActivityPage().isDepositEmpty());
    }





}
