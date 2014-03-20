package com.byclosure.pageobjects.criterias;

import com.byclosure.webcattestingplatform.criterias.Criteria;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 */
public class GoogleFrontPageCriteria extends Criteria {

    private final By queryInputSelector;
    private final By searchButtonSelector;

    public GoogleFrontPageCriteria(WebDriver driver) {
        super(driver);

        queryInputSelector = By.name("q");
        searchButtonSelector = By.name("btnK");
    }

    @Override
    public boolean isContentLoaded() {
        return driver.findElements(queryInputSelector).size() > 0 &&
                driver.findElement(queryInputSelector).isDisplayed() &&
                driver.findElements(searchButtonSelector).size() > 0 &&
                driver.findElement(searchButtonSelector).isDisplayed();
    }
}
