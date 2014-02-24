package com.byclosure;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {
        "html:target/cucumber-html-report",
        "json:target/cucumber-json-report.json",
        "junit:target/cucumber-junit-report.xml"
//        "at.porscheinformatik.cucumber.formatter.HtmlFormatter:target/html",
//        "com.byclosure.MongoDBFormatter:target/db"
})
public class RunCukesTest {
}
