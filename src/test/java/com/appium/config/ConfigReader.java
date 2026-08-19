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
                    new FileInputStream(
                            "src/test/resources/config.properties"
                    );

            properties.load(file);

            file.close();

        } catch (IOException e) {

            System.out.println("config.properties not found.");
            System.out.println("Using Jenkins environment variables.");
        }
    }

    public static String getProperty(String key) {

        String value = null;

        if (properties != null) {
            value = properties.getProperty(key);
        }

        if (value == null || value.isBlank()) {

            if (key.equals("browserstack.username")) {
                value = System.getenv("BROWSERSTACK_USERNAME");
            }

            else if (key.equals("browserstack.accesskey")) {
                value = System.getenv("BROWSERSTACK_ACCESS_KEY");
            }

            else if (key.equals("platform")) {
                value = System.getenv("PLATFORM");
            }

            else if (key.equals("app")) {
                value = System.getenv("BROWSERSTACK_APP");
            }

            else if (key.equals("deviceName")) {
                value = System.getenv("DEVICE_NAME");
            }

            else if (key.equals("platformVersion")) {
                value = System.getenv("PLATFORM_VERSION");
            }

            else if (key.equals("projectName")) {
                value = System.getenv("PROJECT_NAME");
            }

            else if (key.equals("buildName")) {
                value = System.getenv("BUILD_NAME");
            }
        }

        return value;
    }
}