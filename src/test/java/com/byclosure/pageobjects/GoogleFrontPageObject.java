package com.byclosure.pageobjects;

import com.byclosure.webcattestingplatform.NavigationService;
import com.byclosure.webcattestingplatform.pageobjects.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 */
public class GoogleFrontPageObject extends PageObject{

    @FindBy(name = "q")
    WebElement queryInput;
    @FindBy(name = "btnG")
    WebElement searchButton;

    public GoogleFrontPageObject(WebDriver driver, NavigationService navigationService) {
        super(driver, navigationService);

        PageFactory.initElements(driver, this);
    }

    public void search(String query) {
        queryInput.clear();
        queryInput.sendKeys(query);

        searchButton.click();
    }
}
