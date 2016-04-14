package com.md.tutorial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by michal.dudziak on 13/04/2016.
 */
public class CartPage {
    private static final By LIST_ITEM = By.className("a-list-item");
    private WebDriver driver;

    public CartPage(WebDriver driver)    {
        this.driver = driver;
    }
    public String getFirstItemText(){
        return driver.findElement(LIST_ITEM).getText();
    }
}
