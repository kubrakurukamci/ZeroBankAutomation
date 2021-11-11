package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(linkText = "Show Transactions")
    public WebElement showTransactions;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;

    @FindBy(id = "aa_accountId")
    public WebElement dropdown;

    @FindBy(id = "aa_type")
    public WebElement select;

    public WebElement getOptions(String option) {
        return Driver.get().findElement(By.xpath("//option[contains(text(),'" + option + "')]"));
    }

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(id = "aa_fromAmount")
    public WebElement fromAmount;

    @FindBy(id = "aa_toAmount")
    public WebElement toAmount;

    @FindBy(id = "aa_type")
    public WebElement type;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement find;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//table//tr//td[1]")
    public List<WebElement> allDateCells;

    @FindBy(xpath = "(//tbody//tr//td[.='984.3'])[2]/../td[1]")
    public WebElement date1;

    @FindBy(xpath = "(//tbody//tr//td[.='50'])[2]/../td[1]")
    public WebElement date2;

    @FindBy(xpath = "(//tbody//tr//td[.='1000'])[2]/../td[1]")
    public WebElement date3;


    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[2]")
    public List<WebElement> onlineTransferRef;

    public void getDescription(String name) {
        for (WebElement element : onlineTransferRef) {
            Assert.assertTrue(element.getText().contains(name));
        }
    }

    public void DontGetDescription(String name) {
        for (WebElement element : onlineTransferRef) {
            Assert.assertTrue(!element.getText().contains(name));
        }
    }

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[3]")
    public List<WebElement> deposit;

    public boolean isOneResultUnderDeposit() {
        for (WebElement element : deposit) {
            if (!element.getText().isEmpty()) {
                break;
            }
        } return true;
    }

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[4]")
    public List<WebElement> withdrawal;

    public boolean isOneResultUnderWithdrawal() {
        for (WebElement element : withdrawal) {
            if (!element.getText().isEmpty()) {
              break;
            }
        } return true;
    }

    public boolean isWithdrawalEmpty(){
        for (WebElement element : withdrawal) {
            if (element.getText().isEmpty()){

            }
        }
        return true;
    }

    public boolean isDepositEmpty(){
        for (WebElement element : deposit) {
            if (element.getText().isEmpty()){

            }
        }
        return true;
    }

 @FindBy(xpath = "//thead//th")
    public List<WebElement> columnNames;









}
