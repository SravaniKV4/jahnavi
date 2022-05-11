package com.adaction.Runner;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Reporting {

    public static void jvmReport(String jsonfile) {
        File file = new File("src/test/Resources/Report");
        Configuration configuration = new Configuration(file, "sample") ;



             configuration.addClassifications("Tester","Sravani");
            List<String> al = new ArrayList<>();
        al.add(jsonfile);
        System.out.println(jsonfile);

            ReportBuilder builder = new ReportBuilder(al, configuration);
        builder.generateReports();


        }
    }
