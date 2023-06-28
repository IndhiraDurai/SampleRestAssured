package org.qa.runnerfile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
				glue = "org.qa.stepdef", 
				plugin ={"pretty","html:target/Destination"})
public class RunnerClass {
	
}
