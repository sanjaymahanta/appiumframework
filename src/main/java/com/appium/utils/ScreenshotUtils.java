package com.appium.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(AppiumDriver driver, String testName) throws Exception {

        File source = driver.getScreenshotAs(OutputType.FILE);

        String path = "target/screenshots/" + testName + ".png";

        File destination = new File(path);

        FileUtils.copyFile(source, destination);

        return destination.getAbsolutePath();
    }
}