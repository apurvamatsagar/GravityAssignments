package com.example.gravity;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileApplicationAssignment
{

    public static void main(String[] args) {
        IOSDriver<MobileElement> driver;

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.0");
        caps.setCapability(MobileCapabilityType.APP, "/path/to/your/app.app");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

        try {
            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

            // Wait for the app to load
            Thread.sleep(5000);

            // Interact with the app
            driver.findElementByAccessibilityId("username").sendKeys("testuser@example.com");
            driver.findElementByAccessibilityId("password").sendKeys("password123");
            driver.findElementByAccessibilityId("login_button").click();

            // Check for success
            if (driver.findElementByAccessibilityId("home").isDisplayed()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }

            // Close the driver
            driver.quit();
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
