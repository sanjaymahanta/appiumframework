package com.appium.utils;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static WebElement waitForClickable(
            AppiumDriver driver,
            By locator,
            int timeoutInSeconds) {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(timeoutInSeconds)
                );

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static WebElement waitForVisible(
            AppiumDriver driver,
            By locator,
            int timeoutInSeconds) {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(timeoutInSeconds)
                );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }
}