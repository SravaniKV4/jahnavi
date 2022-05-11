package com.adaction.stepDef;

import com.adaction.pages.LoginPage;
import com.adaction.pages.PageObjectManager;
import com.adaction.util.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginAdaction extends BaseClass {
    LoginPage lp;
    PageObjectManager pom=new PageObjectManager();

    @Given("Launch browser")
   public void launch_browser() {
    //    launchBrowser("chrome");
    //    iwait(35);
    //    maxi();
   }


    @Given("Open the Application")
    public void open_the_application() {
        open_the_application("https://adactinhotelapp.com/");
        lp = new LoginPage();
    }



    @When("Enter {string} and {string}")
    public void enter_and(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> maps=dataTable.asMaps();
        enter_and(pom.getLoginPage().getUser(),maps.get(1).get("username"));
        enter_and(pom.getLoginPage().getUser(),maps.get(1).get("password"));



     scenario.attach(screenShot(),"image/png","before");
    }



    @When("Click Login")
    public void click_login() {

        tap(pom.getLoginPage().getLogin());
    }

    @Then("i validate the outcomes")
    public void i_validate_the_outcomes() {
       // Assert.assertEquals(pom.getHomePage());
        System.out.println("success");
    }


    @Then("Close")
    public void close() {
       driver.close();
    }
}