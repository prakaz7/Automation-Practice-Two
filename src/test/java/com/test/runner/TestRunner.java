package com.test.runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/Login.feature",
		monochrome = true,
		//tags="@test",
		glue = {"com.test.steps", "com.test.utils"},
		plugin = {"pretty", "html:target/cucumberReports.html"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Test
    public void runCucumberTests() {
        // This method is just a trigger; actual execution is handled by the base class
    }


}
