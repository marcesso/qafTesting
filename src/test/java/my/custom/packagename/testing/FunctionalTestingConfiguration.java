package my.custom.packagename.testing;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@EnableAutoConfiguration
@ConfigurationProperties(prefix = "testing")
@Data
public class FunctionalTestingConfiguration {

    private final JdbcTemplate jdbcTemplate;

    private int value;

    public FunctionalTestingConfiguration(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    private void someThingsToDo() {
        System.out.println("ToTooooooooooo");
    }

}
