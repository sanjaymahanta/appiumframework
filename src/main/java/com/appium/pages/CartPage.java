package com.appium.pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import com.appium.utils.WaitUtils;

public class CartPage {

    AppiumDriver driver;

    private final By cartTab = AppiumBy.accessibilityId("tab bar option cart");

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickCart() {
        WaitUtils.waitForClickable(driver, cartTab, 15).click();
    }
}