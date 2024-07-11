package learningSelenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class CucumberTest extends AbstractTestNGCucumberTests 
{
	
}

