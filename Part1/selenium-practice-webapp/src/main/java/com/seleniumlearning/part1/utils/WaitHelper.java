package com.seleniumlearning.part1.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

/**
 * WaitHelper - Provides explicit wait methods for synchronization.
 * Helps handle dynamic elements and timing issues.
 */
public class WaitHelper {

    private static final Logger logger = LogManager.getLogger(WaitHelper.class);
    private static final int DEFAULT_TIMEOUT = 10; // Default wait time in seconds

    /**
     * Waits for an element to be present in DOM.
     * @param driver WebDriver instance
     * @param locator Element locator
     * @param timeoutInSeconds Wait timeout
     * @return WebElement once found
     */
    public static WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
        try {
            logger.info("Waiting for element: {} with timeout: {}s", locator, timeoutInSeconds);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            logger.info("Element found: {}", locator);
            return element;
        } catch (Exception e) {
            logger.error("Timeout waiting for element: {} - {}", locator, e.getMessage());
            throw e;
        }
    }

    /**
     * Waits for an element to be visible (present and displayed).
     * @param driver WebDriver instance
     * @param locator Element locator
     * @param timeoutInSeconds Wait timeout
     * @return WebElement once visible
     */
    public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        try {
            logger.info("Waiting for element visibility: {}", locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("Element is visible: {}", locator);
            return element;
        } catch (Exception e) {
            logger.error("Timeout waiting for element visibility: {}", locator);
            throw e;
        }
    }

    /**
     * Waits for an element to be clickable.
     * @param driver WebDriver instance
     * @param locator Element locator
     * @param timeoutInSeconds Wait timeout
     * @return WebElement once clickable
     */
    public static WebElement waitForElementClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        try {
            logger.info("Waiting for element clickable: {}", locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            logger.info("Element is clickable: {}", locator);
            return element;
        } catch (Exception e) {
            logger.error("Timeout waiting for element clickable: {}", locator);
            throw e;
        }
    }

    /**
     * Waits for element to disappear from DOM.
     * @param driver WebDriver instance
     * @param locator Element locator
     * @param timeoutInSeconds Wait timeout
     */
    public static void waitForElementInvisibility(WebDriver driver, By locator, int timeoutInSeconds) {
        try {
            logger.info("Waiting for element to disappear: {}", locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            logger.info("Element disappeared: {}", locator);
        } catch (Exception e) {
            logger.error("Timeout waiting for element invisibility: {}", locator);
            throw e;
        }
    }

    /**
     * Waits for specific text to appear in an element.
     * @param driver WebDriver instance
     * @param locator Element locator
     * @param text Expected text
     * @param timeoutInSeconds Wait timeout
     */
    public static void waitForElementWithText(WebDriver driver, By locator, String text, int timeoutInSeconds) {
        try {
            logger.info("Waiting for element with text: {}", text);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
            logger.info("Element found with text: {}", text);
        } catch (Exception e) {
            logger.error("Timeout waiting for text: {}", text);
            throw e;
        }
    }
}
