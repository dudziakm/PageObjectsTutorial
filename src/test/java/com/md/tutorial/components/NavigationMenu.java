package com.md.tutorial.components;

import com.md.tutorial.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by michal.dudziak on 13/04/2016.
 */
public class NavigationMenu {
    private static final By SEARCH_DROPDOWN_BOX = By.id("searchDropdownBox");
    private static final By SEARCH_INPUT = By.id("twotabsearchtextbox");
    private static final By SEARCH_GO_BUTTON = By.xpath("//*[@value='Go']");
    private static final By NAVIGATION_ITEM_CART = By.id("nav-cart");
    private WebDriver driver;

    public NavigationMenu(WebDriver driver){
        this.driver = driver;
    }

    public SearchResultsPage searchFor(String category, String searchKey){
        new Select(driver.findElement(SEARCH_DROPDOWN_BOX)).selectByVisibleText(category);
        driver.findElement(SEARCH_INPUT).sendKeys(searchKey);
        driver.findElement(SEARCH_GO_BUTTON).click();

        return new SearchResultsPage(driver);
    }

    public CartPage navigateToCartPage(){
        driver.findElement(NAVIGATION_ITEM_CART).click();
        return new CartPage(driver);
    }

}
