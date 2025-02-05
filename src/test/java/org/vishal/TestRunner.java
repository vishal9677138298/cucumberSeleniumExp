package org.vishal;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        features = "src/test/resources/features/",
        glue = {"org.vishal.steps", "org.vishal"}
)
@CucumberContextConfiguration
@ContextConfiguration(classes = SpringConfig.class)
public class TestRunner {

}
