package com.appium.pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import com.appium.utils.WaitUtils;

public class ProductDetailPage {

    AppiumDriver driver;

    private final By addToCartButton = AppiumBy.accessibilityId("Add To Cart button");

    public ProductDetailPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        WaitUtils.waitForClickable(driver, addToCartButton, 15).click();
    }
}