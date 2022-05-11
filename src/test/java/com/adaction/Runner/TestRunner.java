package com.adaction.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Resources/Features/AdactionLogin.feature",glue = "com/adaction/stepDef",dryRun = false,monochrome = true,plugin = {"pretty","html:target/cucu.html","json:target/srav.json","junit:target/unit.xml"})

public class TestRunner {
    @AfterClass
    public static void tearDown()
    {
        Reporting.jvmReport("/Users/sravani/Desktop/MAVEN/Cucumber/target/srav.json");
    }

}
