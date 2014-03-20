package com.byclosure.pageobjects.criterias;

import com.byclosure.webcattestingplatform.criterias.Criteria;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 */
public class GoogleSearchResultPageCriteria extends Criteria{

    private final By queryResultSelector;
    public GoogleSearchResultPageCriteria(WebDriver driver) {
        super(driver);
        queryResultSelector = By.cssSelector("li.g");
    }

    @Override
    public boolean isContentLoaded() {
        return driver.findElements(queryResultSelector).size() > 0 &&
                driver.findElement(queryResultSelector).isDisplayed();
    }
}
