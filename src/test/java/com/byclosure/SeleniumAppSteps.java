package com.byclosure;

import com.byclosure.pageobjects.GoogleFrontPageObject;
import com.byclosure.pageobjects.GoogleSearchResultPageObject;
import com.byclosure.pageobjects.criterias.GoogleFrontPageCriteria;
import com.byclosure.pageobjects.criterias.GoogleSearchResultPageCriteria;
import com.byclosure.webcattestingplatform.IPageObjectFactory;
import com.byclosure.webcattestingplatform.NavigationService;
import com.byclosure.webcattestingplatform.pageobjects.IPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
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
    private NavigationService navigationService;

    public SeleniumAppSteps() throws MalformedURLException {
        final DesiredCapabilities caps = DesiredCapabilities.firefox();
//        caps.setBrowserName("chrome");
//        caps.setCapability("chrome.switches", Arrays.asList("--kiosk"));
        driver = new RemoteWebDriver(new URL(localGridURL), caps);

        Augmenter augmenter = new Augmenter();
        driver = augmenter.augment(driver);

        navigationService = new NavigationService(driver);
        registerPageObjects();
    }

    private void registerPageObjects() {
        navigationService.register("Google Front Page", new GoogleFrontPageCriteria(driver), new IPageObjectFactory() {
            @Override
            public GoogleFrontPageObject build(NavigationService navigationService) {
                return new GoogleFrontPageObject(driver, navigationService);
            }
        });

        navigationService.register("Google Search Results Page", new GoogleSearchResultPageCriteria(driver), new IPageObjectFactory() {
            @Override
            public GoogleSearchResultPageObject build(NavigationService navigationService) {
                return new GoogleSearchResultPageObject(driver, navigationService);
            }
        });
    }

    @Given("^I am in \"([^\"]*)\"$")
    public void I_am_in(String url) throws Throwable {
         driver.get(url);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String query) throws Throwable {
        GoogleFrontPageObject frontPage = navigationService.getPage("Google Front Page");
        frontPage.search(query);
    }

    @Then("^I should see a list of results referring to \"([^\"]*)\"$")
    public void I_should_see_a_list_of_results_referring_to(String queryResult) throws Throwable {
        GoogleSearchResultPageObject searchResultPageObject = navigationService.getPage("Google Search Results Page");

        Assert.assertTrue(searchResultPageObject.getNumberOfResultsReferingTo(queryResult) > 0);
    }

    @After
    public void after(Scenario scenario) throws IOException {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");

        driver.quit();
    }
}
