package com.byclosure;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {
        "json:target/cucumber-json-report.json"
})
public class RunCukesTest {
}
