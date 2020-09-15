package my.custom.packagename.testing;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {FunctionalTestingConfiguration.class})
public class FunctionalTestingApp  {
}
