package my.custom.packagename.testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;

import javax.annotation.PostConstruct;

@CucumberOptions(plugin = {"com.qmetry.qaf.automation.cucumber.QAFCucumberPlugin", "pretty", "html:target", "timeline:target"},
        /*tags = {"@Ignore"},*/
        features = {"src/test/resources/my/custom/packagename/testing"})
public class RunnerTest extends AbstractTestNGCucumberTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @PostConstruct
    public void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
    }

}
