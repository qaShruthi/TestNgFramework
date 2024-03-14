package cucumber.StepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class LoginPageDefinitions {
 
    @Before()
    public void beforeScenario(){
        System.out.println("Start the browser and Clear the cookies");
    }
 
    @Given("User is on HRMLogin page {string}")
    public void loginTest(String url) {
 
        System.out.println("I am in Login Page");
 
    }
 
    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {
 
        System.out.println("Go to Home Page");
 
    }
 
    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {
 
        System.out.println("Home Page is opened");
 
    }
 
    @Then("User should be able to see a message {string} below Username")
    public void verifyMissingUsernameMessage(String message) {
 
        System.out.println("Login failed with an error message");
    }
 
  @After()
    public void afterScenario(){
        System.out.println("Log out the user and close the browser");
    }
 
}

