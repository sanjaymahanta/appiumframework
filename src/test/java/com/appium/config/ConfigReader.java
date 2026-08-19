package com.appium.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadProperties() {

        properties = new Properties();

        try {
            FileInputStream file =
                    new FileInputStream("src/test/resources/config.properties");

            properties.load(file);
            file.close();

        } catch (IOException e) {
            System.out.println("config.properties not found. Using Jenkins environment variables.");
        }
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isEmpty()) {

            switch (key) {

                case "browserstack.username":
                    return System.getenv("BROWSERSTACK_USERNAME");

                case "browserstack.accesskey":
                    return System.getenv("BROWSERSTACK_ACCESS_KEY");

                case "platform":
                    return System.getenv("PLATFORM");

                case "app":
                    return System.getenv("APP");

                case "deviceName":
                    return System.getenv("DEVICE_NAME");

                case "platformVersion":
                    return System.getenv("PLATFORM_VERSION");

                case "projectName":
                    return System.getenv("PROJECT_NAME");

                case "buildName":
                    return System.getenv("BUILD_NAME");

                default:
                    return null;
            }
        }

        return value;
    }
}