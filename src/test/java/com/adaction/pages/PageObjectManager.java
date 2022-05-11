package com.adaction.pages;

public class PageObjectManager {
    LoginPage loginPage;

    public LoginPage getLoginPage()
    {
        return(loginPage==null)?loginPage=new LoginPage():loginPage;
    }

}
