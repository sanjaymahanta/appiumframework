package com.appium.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.base.BaseTest;
import com.appium.driver.DriverFactory;
import com.appium.pages.CartPage;
import com.appium.pages.HomePage;
import com.appium.pages.ProductDetailPage;
import com.appium.retry.RetryAnalyzer;

public class CartTest extends BaseTest {

    HomePage homePage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @BeforeMethod
    public void initializePages() {

        homePage = new HomePage(DriverFactory.driver);
        productDetailPage = new ProductDetailPage(DriverFactory.driver);
        cartPage = new CartPage(DriverFactory.driver);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyProductAddedToCart() {

        homePage.clickBackpack();
        productDetailPage.clickAddToCart();
        cartPage.clickCart();

        System.out.println("Product added to cart successfully!");
    }
}