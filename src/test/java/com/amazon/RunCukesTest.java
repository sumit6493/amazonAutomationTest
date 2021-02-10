package com.amazon;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json" },
        features = { "classpath:features" }
)
public class RunCukesTest {
    @AfterClass
    public static void teatDown() {
        System.out.println("Generating Reports");
        File reportOutPutDirectory = new File("target/report");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        String buildName = "000";
        String projectName = "Amazon Android Tests";
        Configuration configuration = new Configuration(reportOutPutDirectory, projectName);
        configuration.setBuildNumber(buildName);

        configuration.setSortingMethod(SortingMethod.NATURAL);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
