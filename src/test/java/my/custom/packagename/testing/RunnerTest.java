package my.custom.packagename.testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.qmetry.qaf.automation.data.MetaData;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.PostConstruct;

@CucumberOptions(plugin = {"com.qmetry.qaf.automation.cucumber.QAFCucumberPlugin", "pretty", "html:target"},
        /*tags = {"@Ignore"},*/
        features = {"src/test/resources/my/custom/packagename/testing"})
public class RunnerTest extends AbstractTestNGCucumberTests {

    @Autowired
    private ObjectMapper objectMapper;


    @Test(description = "Runs Cucumber Scenarios", dataProvider = "scenarios", groups = {"first"})
    public void runScenarioFirst(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        super.runScenario(pickleWrapper,featureWrapper);

    }
    @Test(description = "Runs Cucumber Scenarios", dataProvider = "scenarios", groups = {"then"}, dependsOnMethods =
            "runScenarioFirst")
    public void runScenarioThen(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        super.runScenario(pickleWrapper,featureWrapper);
    }

    @Override
    @DataProvider(name = "scenarios", parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @PostConstruct
    public void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
    }

}
