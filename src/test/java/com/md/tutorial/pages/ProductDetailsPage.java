package com.md.tutorial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by michal.dudziak on 13/04/2016.
 */
public class ProductDetailsPage {
    private static final By PRODUCT_TITLE_FIELD = By.id("productTitle");
    private static final By ADD_TO_CART_BUTTON = By.id("add-to-cart-button");
    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductTitle(){
        return driver.findElement(PRODUCT_TITLE_FIELD).getText();
    }

    public AddToCartConfirmPage addToCart(){
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new AddToCartConfirmPage(driver);
    }


}
