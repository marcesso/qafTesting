package my.custom.packagename.testing;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = FunctionalTestingApp.class, initializers =
        ConfigFileApplicationContextInitializer.class)
public class FunctionalTesting {

    @Autowired
    protected FunctionalTestingConfiguration configuration;


}
