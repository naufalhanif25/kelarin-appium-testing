package com.kelarin.testing;

import io.github.cdimascio.dotenv.Dotenv;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class AndroidTest {
    protected AndroidDriver driver;

    // Default input values for test scenarios
    protected String defaultTitle = "Belajar Appium Kelarin";
    protected String defaultDescription = "Menyelesaikan implementasi automation testing sampai sukses.";
    protected String defaultPriority = "Do";
    protected String defaultDeadline = "Not set yet";

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Load environment variables from the .env file
        Dotenv dotenv = Dotenv.configure().load();
        UiAutomator2Options options = new UiAutomator2Options();

        // Configure Appium capabilities using environment variables
        options.setPlatformName(dotenv.get("APPIUM_PLATFORM_NAME"));
        options.setDeviceName(dotenv.get("APPIUM_DEVICE_NAME")); 
        options.setApp(dotenv.get("APPIUM_APP_PATH")); 
        options.setAutomationName(dotenv.get("APPIUM_AUTOMATION_NAME"));

        // Establish connection to the Appium Server
        URL url = new URI(dotenv.get("APPIUM_URL")).toURL();
        
        // Initialize the AndroidDriver instance and set a global implicit wait
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        // Terminate the Appium session and close the app after each test method
        if (driver != null) { driver.quit(); }
    }

    /**
     * Checks whether an element exists on the current screen without throwing an exception.
     * * @param locator The By locator strategy used to find the element.
     * @return true if the element is found, false otherwise.
     */
    protected boolean findElementOrNull(By locator) {
        boolean isElementExist; 
            
        try {
            driver.findElement(locator);
            isElementExist = true;
        } catch (NoSuchElementException e) {
            isElementExist = false;
        }
        return isElementExist;
    }
}