package cucmber.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/Features",
        plugin = {"json:target/jsonReports/cucumber.json"},
        glue ={"StepDefination"},
tags = "")

public class TestRunner {
}
