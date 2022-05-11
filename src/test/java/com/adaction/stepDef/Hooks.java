package com.adaction.stepDef;

import com.adaction.util.BaseClass;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

    @Before
    public void beforeExceution(Scenario scenario)
    {
        BaseClass.scenario=scenario;
        launchBrowser(readProperties("Browser"));
        iwait(Integer.parseInt(readProperties("implicitlywait")));
    }

    @After
    public void afterExecution()
    {

        if(scenario.isFailed())
        {
            scenario.attach(screenShot(),"image/png","failed");
        }

        driver.manage().deleteAllCookies();
        close();
    }
}
