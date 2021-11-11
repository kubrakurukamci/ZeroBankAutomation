package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(xpath = "(//a[@style='text-decoration: underline'])[1]")
    public WebElement savings;

    @FindBy(xpath = "(//a[@style='text-decoration: underline'])[3]")
    public WebElement brokerage;

    @FindBy(xpath = "(//a[@style='text-decoration: underline'])[4]")
    public WebElement checking;

    @FindBy(xpath = "(//a[@style='text-decoration: underline'])[5]")
    public WebElement creditCard;

    @FindBy(xpath = "(//a[@style='text-decoration: underline'])[6]")
    public WebElement loan;


    @FindBy(xpath = "//a[@style='text-decoration: underline']")
    public List<WebElement> account;

    @FindBy(tagName = "h2")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//thead//tr)[3]//th")
    public List<WebElement> creditAccountsColumns;

    public void accounts(String accountName){
        for (WebElement accountType : accountTypes) {
            if(accountType.getAttribute("style").equals(accountName)){
                accountType.click();
            }
        }
    }
    public WebElement getAccountName(String name){
        return Driver.get().findElement(By.linkText(name));
    }

}
