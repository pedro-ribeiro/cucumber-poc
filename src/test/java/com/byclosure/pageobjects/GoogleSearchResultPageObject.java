package com.byclosure.pageobjects;

import com.byclosure.webcattestingplatform.NavigationService;
import com.byclosure.webcattestingplatform.pageobjects.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GoogleSearchResultPageObject extends PageObject {

    public GoogleSearchResultPageObject(WebDriver driver, NavigationService navigationService) {
        super(driver, navigationService);
    }

    public int getNumberOfResultsReferingTo(String query) {
        final List<WebElement> results = driver.findElements(By.cssSelector("li.g"));
        final List<WebElement> filteredResults = new ArrayList<WebElement>();

        for(WebElement result : results) {
            final By textSelector = By.cssSelector(".r a");
            if(result.findElements(textSelector).size() > 0 &&
                    result.findElement(textSelector).getText().contains(query)) {
                filteredResults.add(result);
            }
        }

        return filteredResults.size();
    }
}
