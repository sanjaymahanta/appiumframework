package com.appium.pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import com.appium.utils.WaitUtils;

public class HomePage {

    AppiumDriver driver;

    private final By backpackItem = AppiumBy.accessibilityId("Sauce Labs Backpack");

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickBackpack() {
        WaitUtils.waitForClickable(driver, backpackItem, 15).click();
    }
}