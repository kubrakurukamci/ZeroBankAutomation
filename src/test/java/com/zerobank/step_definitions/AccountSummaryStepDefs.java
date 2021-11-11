package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {
    @Then("the user should see the following options")
    public void the_user_should_see_the_following_options(List<String > expectedOptions) {
        List<String> actualOptions= BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);
        Assert.assertEquals(expectedOptions,actualOptions);

    }


    @And("the user should see the following under Credit Accounts")
    public void theUserShouldSeeTheFollowingUnderCreditAccounts(List<String> expectedOptions) {
            List<String> actualOptions = BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountsColumns);
            Assert.assertEquals(expectedOptions, actualOptions);

        }
    }

