package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;
import java.util.List;

public class BasePage {

    @FindBy(id = "searchTerm")
    public WebElement search;

    @FindBy(xpath = "(//*[@data-toggle='dropdown'])[1]")
    public WebElement settings;

    @FindBy(xpath = "(//*[@data-toggle='dropdown'])[2]")
    public WebElement usernameProfile;

    @FindBy(xpath = "//div[@class='span12']//ul//li")
    public List<WebElement> menuOptions;

    @FindBy(linkText = "Account Summary")
    public WebElement accountSummary;

    @FindBy(linkText = "Account Activity")
    public WebElement accountActivity;

    @FindBy(linkText = "Transfer Funds")
    public WebElement transferFunds;

    @FindBy(linkText = "Pay Bills")
    public WebElement payBills;

    @FindBy(linkText = "My Money Map")
    public WebElement myMoneyMap;

    @FindBy(linkText = "Online Statements")
    public WebElement onlineStatements;

    public WebElement getModule(String name){
        return Driver.get().findElement(By.linkText(name));
    }



    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


}
