package com.appium.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.appium.driver.DriverFactory;

public class BaseTest {

    @BeforeMethod
    public void setUp() throws Exception {

        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}