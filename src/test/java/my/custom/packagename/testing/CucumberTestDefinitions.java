package my.custom.packagename.testing;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
public class CucumberTestDefinitions extends FunctionalTesting {

    @Given("Nothing")
    public void given() {
        System.out.println("Nothing");
    }

    @When("Nothing happens")
    public void when() {
        System.out.println("Nothing happens");
    }

    @Then("Nothing occurs")
    public void then() {
        Assert.assertTrue(true);
    }

}
