package cucumber.StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Shruthi\\eclipse-testing-workspace\\CucumberJava\\src\\test\\resources\\FeaturesWithTags", 
glue = {"StepDefinitions"},
tags= "@smoke or @regression"
)
public class TestRunnerWithTags {

}
