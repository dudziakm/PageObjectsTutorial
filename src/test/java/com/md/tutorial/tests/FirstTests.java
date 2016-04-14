package com.md.tutorial.tests;

import com.md.tutorial.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by michal.dudziak on 07/04/2016.
 */

public class FirstTests {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void openHomePage(){
//        driver.get("http://www.amazon.com");
        homePage = new HomePage(driver).open();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testAddingItemToCard() throws InterruptedException {
        new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Books");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium");
        driver.findElement(By.xpath("//*[@value='Go']")).click();

        Thread.sleep(2000);
        //get first book
        WebElement firstItemTitleElement = driver.findElement(By.xpath("//h2[contains(@class, 's-access-title')]"));
        String firstItemTitle = firstItemTitleElement.getText();
        firstItemTitleElement.click();
        Thread.sleep(2000);
        // title on a product page:
        assert (driver.findElement(By.id("productTitle")).getText().equals(firstItemTitle));
        Thread.sleep(1000);
        // add to cart:
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(2000);
        assert (driver.findElement(By.xpath("//h1[@class='a-size-medium a-text-bold']")).getText().contains("Added to Cart"));
        Thread.sleep(2000);
        driver.findElement(By.id("nav-cart")).click();
        Thread.sleep(2000);

        assert (driver.findElement(By.className("a-list-item")).getText().contains(firstItemTitle));
    }

    @Test
    public void testAddingToTheCard() throws InterruptedException{
        SearchResultsPage searchResultsPage = homePage.navigationMenu().searchFor("Books", "Selenium");
        String itemTitle = searchResultsPage.getFirstResultTitle();
        ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResultTitle();

        assert (productDetailsPage.getProductTitle().equals(itemTitle));
        AddToCartConfirmPage addToCartConfirmPage = productDetailsPage.addToCart();
        assert (addToCartConfirmPage.getConfirmationText().equals("Added to Cart"));

        CartPage cartPage = homePage.navigationMenu().navigateToCartPage();
        assert (cartPage.getFirstItemText().contains(itemTitle));

    }
}
