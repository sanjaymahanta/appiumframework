package com.appium.driver;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.appium.config.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class DriverFactory {

    public static AppiumDriver driver;

    public static void initDriver() throws Exception {

        // Load config.properties
        ConfigReader.loadProperties();

        // Read BrowserStack credentials
        String username =
                ConfigReader.getProperty("browserstack.username");

        String accessKey =
                ConfigReader.getProperty("browserstack.accesskey");

        // Read platform
        String platform =
                ConfigReader.getProperty("platform");

        // BrowserStack URL
        URL url = URI.create(
                "https://hub-cloud.browserstack.com/wd/hub"
        ).toURL();


        // =====================================================
        // ANDROID
        // =====================================================

        if (platform.equalsIgnoreCase("android")) {

            UiAutomator2Options options =
                    new UiAutomator2Options();

            // App
            options.setCapability(
                    "app",
                    ConfigReader.getProperty("app")
            );

            // Device
            options.setCapability(
                    "appium:deviceName",
                    ConfigReader.getProperty("deviceName")
            );

            options.setCapability(
                    "appium:platformVersion",
                    ConfigReader.getProperty("platformVersion")
            );

            // Android automation engine
            options.setCapability(
                    "appium:automationName",
                    "UiAutomator2"
            );


            // BrowserStack options
            Map<String, Object> bstackOptions =
                    new HashMap<>();

            bstackOptions.put(
                    "userName",
                    username
            );

            bstackOptions.put(
                    "accessKey",
                    accessKey
            );

            bstackOptions.put(
                    "projectName",
                    ConfigReader.getProperty("projectName")
            );

            bstackOptions.put(
                    "buildName",
                    ConfigReader.getProperty("buildName")
            );

            bstackOptions.put(
                    "sessionName",
                    "Android App Launch"
            );

            bstackOptions.put(
                    "debug",
                    true
            );

            options.setCapability(
                    "bstack:options",
                    bstackOptions
            );


            // Create Android session
            driver = new AppiumDriver(
                    url,
                    options
            );
        }


        // =====================================================
        // IOS
        // =====================================================

        else if (platform.equalsIgnoreCase("ios")) {

            XCUITestOptions options =
                    new XCUITestOptions();

            // App
            options.setCapability(
                    "app",
                    ConfigReader.getProperty("app")
            );

            // Device
            options.setCapability(
                    "appium:deviceName",
                    ConfigReader.getProperty("deviceName")
            );

            options.setCapability(
                    "appium:platformVersion",
                    ConfigReader.getProperty("platformVersion")
            );

            // iOS automation engine
            options.setCapability(
                    "appium:automationName",
                    "XCUITest"
            );


            // BrowserStack options
            Map<String, Object> bstackOptions =
                    new HashMap<>();

            bstackOptions.put(
                    "userName",
                    username
            );

            bstackOptions.put(
                    "accessKey",
                    accessKey
            );

            bstackOptions.put(
                    "projectName",
                    ConfigReader.getProperty("projectName")
            );

            bstackOptions.put(
                    "buildName",
                    ConfigReader.getProperty("buildName")
            );

            bstackOptions.put(
                    "sessionName",
                    "iOS App Launch"
            );

            bstackOptions.put(
                    "debug",
                    true
            );

            options.setCapability(
                    "bstack:options",
                    bstackOptions
            );


            // Create iOS session
            driver = new AppiumDriver(
                    url,
                    options
            );
        }


        // =====================================================
        // INVALID PLATFORM
        // =====================================================

        else {

            throw new IllegalArgumentException(
                    "Invalid platform: " + platform
                    + ". Use android or ios."
            );
        }
    }


    // =========================================================
    // QUIT DRIVER
    // =========================================================

    public static void quitDriver() {
        if (driver != null) {
            System.out.println("Closing BrowserStack Appium session...");
            driver.quit();
            driver = null;
            System.out.println("BrowserStack Appium session closed.");
        }
    }
}