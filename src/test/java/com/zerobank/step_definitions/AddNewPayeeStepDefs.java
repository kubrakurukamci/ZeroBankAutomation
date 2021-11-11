package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.getModule("Pay Bills").click();

        payBillsPage.getModuleOnPayBills("Add New Payee").click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> information) {
        BrowserUtils.waitFor(2);
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.payNameInput.sendKeys(information.get("Payee Name"));
        BrowserUtils.waitFor(1);

        payBillsPage.addressInput.sendKeys(information.get("Payee Address"));

        payBillsPage.accountInput.sendKeys(information.get("Account"));


        payBillsPage.detailsInput.sendKeys(information.get("Payee details"));


        payBillsPage.add.click();




    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String expectedMessage) {
        String actualMessage =new PayBillsPage().message.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
