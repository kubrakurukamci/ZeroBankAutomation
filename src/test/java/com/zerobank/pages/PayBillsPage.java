package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{

    @Override
    public WebElement getModule(String name) {
        return super.getModule(name);
    }

    public WebElement getModuleOnPayBills(String name){
        return Driver.get().findElement(By.linkText(name));
    }

    public void paying(String name){
        Driver.get().findElements(By.linkText(name));
    }

    @FindBy(id = "np_new_payee_name")
    public WebElement payNameInput;

    @FindBy(id = "np_new_payee_address")
    public WebElement addressInput;

    @FindBy(id="np_new_payee_account")
    public WebElement accountInput;

    @FindBy(id = "np_new_payee_details")
    public WebElement detailsInput;

    @FindBy(id = "add_new_payee")
    public WebElement add;

    @FindBy(id = "alert_content")
    public WebElement message;

    @FindBy(id = "pc_currency")
    public WebElement dropdownCurrency;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCost;

    @FindBy(id = "pc_amount")
    public WebElement amount;

}
