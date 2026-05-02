package com.seleniumlearning.part1.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * DriverManager - Manages WebDriver lifecycle.
 * Provides static methods to get and close WebDriver instances.
 * Handles browser initialization with proper configuration.
 */
public class DriverManager {

    private static final Logger logger = LogManager.getLogger(DriverManager.class);
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String BROWSER_TYPE = "chrome"; // Change to "firefox" for Firefox

    /**
     * Gets WebDriver instance. Creates one if not exists.
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    /**
     * Initializes WebDriver based on browser type.
     */
    private static void initializeDriver() {
        logger.info("Initializing WebDriver with browser: {}", BROWSER_TYPE);

        if (BROWSER_TYPE.equalsIgnoreCase("chrome")) {
            initializeChromeDriver();
        } else if (BROWSER_TYPE.equalsIgnoreCase("firefox")) {
            initializeFirefoxDriver();
        } else {
            logger.error("Invalid browser type: {}", BROWSER_TYPE);
            throw new IllegalArgumentException("Unsupported browser: " + BROWSER_TYPE);
        }

        configureDriver();
        logger.info("WebDriver initialized successfully");
    }

    /**
     * Initializes Chrome WebDriver.
     */
    private static void initializeChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Uncomment below to run in headless mode (no GUI)
        // options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver.set(new ChromeDriver(options));
    }

    /**
     * Initializes Firefox WebDriver.
     */
    private static void initializeFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver.set(new FirefoxDriver());
    }

    /**
     * Configures WebDriver settings.
     */
    private static void configureDriver() {
        WebDriver currentDriver = driver.get();
        currentDriver.manage().window().maximize();
    }

    /**
     * Closes WebDriver and cleans up resources.
     */
    public static void closeDriver() {
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            try {
                logger.info("Closing WebDriver...");
                currentDriver.quit();
                logger.info("WebDriver closed successfully");
            } catch (Exception e) {
                logger.error("Error closing WebDriver: {}", e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }
}
