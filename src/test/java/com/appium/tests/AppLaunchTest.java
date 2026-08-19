package com.appium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.base.BaseTest;
import com.appium.driver.DriverFactory;

public class AppLaunchTest extends BaseTest {

    @Test
    public void verifyAppLaunch() {

        Assert.assertNotNull(
                DriverFactory.driver,
                "Appium driver was not initialized"
        );

        System.out.println("App launched successfully!");
    }
}