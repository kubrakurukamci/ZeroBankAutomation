package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrecyStepDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new PayBillsPage().getModuleOnPayBills("Purchase Foreign Currency").click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies) {
        Select select=new Select(new PayBillsPage().dropdownCurrency);
        List<WebElement> options=select.getOptions();
        options.remove(0);
        Assert.assertEquals(currencies, BrowserUtils.getElementsText(options));

    }

    @Then("the user clicks on Pay Bills module")
    public void theUserClicksOnPayBillsModule() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.getModule("Pay Bills").click();

    }
    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        new PayBillsPage().amount.sendKeys("1000");
        new PayBillsPage().calculateCost.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert= Driver.get().switchTo().alert();

        Assert.assertTrue(!alert.getText().isEmpty());

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
       PayBillsPage payBillsPage = new PayBillsPage();
       Select select=new Select(payBillsPage.dropdownCurrency);
       select.selectByVisibleText("Eurozone (euro)");
       payBillsPage.calculateCost.click();


    }

}
