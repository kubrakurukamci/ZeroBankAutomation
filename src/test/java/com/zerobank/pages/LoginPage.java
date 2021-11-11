package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement signIn;

    @FindBy(id = "user_login")
    public WebElement username;


    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submit;



    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    @FindBy(id= "details-button")
    public WebElement advanceButton;

    @FindBy(partialLinkText = "Proceed")
    public WebElement link;


    public void login(String user,String pass){



        signIn.click();
        username.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
        advanceButton.click();
        link.click();

    }


}
