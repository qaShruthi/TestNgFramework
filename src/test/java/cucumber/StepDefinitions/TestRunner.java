package cucumber.StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Shruthi\\eclipse-testing-workspace\\CucumberJava\\src\\test\\resources\\Features\\googleSearch.feature", 
glue = {"StepDefinitions"},
monochrome=true,
plugin={"pretty","html:target/HtmlReports/htmlReport.html","json:target/JsonReports/report.json", "junit:target/JunitReports/report.xml"})
public class TestRunner {

}
