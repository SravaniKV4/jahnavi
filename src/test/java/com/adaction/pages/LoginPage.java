package com.adaction.pages;


import com.adaction.util.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement User;
    public WebElement getUser() {
        return User;
    }

    @FindBy(id = "password")
    private WebElement Pass;
    public WebElement getPass() {
        return Pass;
    }

    @FindBy(id = "login")
    private WebElement Login;
    public WebElement getLogin() {
        return Login;
    }
}