package com.byclosure;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class SeleniumAppSteps {

    private final static String localGridURL = "http://192.168.1.91:4444/wd/hub";
    private WebDriver driver;

    public SeleniumAppSteps() throws MalformedURLException {
        final DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setBrowserName("chrome");
        caps.setCapability("chrome.switches", Arrays.asList("--kiosk"));
        driver = new RemoteWebDriver(new URL(localGridURL), caps);

        Augmenter augmenter = new Augmenter();
        driver = augmenter.augment(driver);
    }

    @Given("^I am in \"([^\"]*)\"$")
    public void I_am_in(String url) throws Throwable {
         driver.get(url);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String query) throws Throwable {
        final WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.clear();
        searchInput.sendKeys(query + "\n");
    }

    @Then("^I should see a list of results referring to \"([^\"]*)\"$")
    public void I_should_see_a_list_of_results_referring_to(String queryResult) throws Throwable {
        final List<WebElement> results = driver.findElements(By.className("r"));
        for(WebElement result : results) {
            Assert.assertTrue(result.getText().contains(queryResult));
        }
    }

    @After
    public void after(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");

        driver.quit();
    }
}
