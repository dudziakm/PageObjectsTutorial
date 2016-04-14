package com.md.tutorial.pages;

import com.md.tutorial.components.NavigationMenu;
import org.openqa.selenium.WebDriver;

/**
 * Created by michal.dudziak on 13/04/2016.
 */
public class HomePage {
    private static final String AMAZON_HOME_PAGE_URL = "http://www.amazon.com";
    private final NavigationMenu navigationMenu;
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public HomePage open(){
        driver.get(AMAZON_HOME_PAGE_URL);
        return this;
    }

    public NavigationMenu navigationMenu(){
        return navigationMenu;
    }
}
