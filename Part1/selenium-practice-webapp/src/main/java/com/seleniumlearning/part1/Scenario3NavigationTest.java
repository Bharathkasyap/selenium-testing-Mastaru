package com.seleniumlearning.part1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.seleniumlearning.part1.utils.DriverManager;
import com.seleniumlearning.part1.utils.WaitHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Scenario 3: Navigation Between Pages
 * Objective: Navigate through multiple pages and verify navigation
 * Test Flow:
 * 1. Open home page
 * 2. Click Products link
 * 3. Verify Products page
 * 4. Click Contact link
 * 5. Verify Contact page
 * 6. Click Home link
 * 7. Verify back on Home page
 * Practice Website: https://practice.automationbro.com
 */
public class Scenario3NavigationTest {

    private static final Logger logger = LogManager.getLogger(Scenario3NavigationTest.class);
    private WebDriver driver;
    private static final String BASE_URL = "https://practice.automationbro.com";

    @BeforeTest
    public void setUp() {
        logger.info("Test Setup Started");
        driver = DriverManager.getDriver();
        logger.info("WebDriver initialized");
    }

    @Test
    public void testNavigationScenario() {
        logger.info("Scenario 3 Navigation Test Started");
        try {
            // START - Write your code below this line

            // TODO Step 1 - Navigate to home page
            // Hint: Use driver.get(BASE_URL)
            logger.info("TODO: STEP 1 - Navigate to home page");

            // TODO Step 2 - Find and click Products navigation link
            // Hint: Use By.linkText("Products") or By.partialLinkText("Products")
            // Use WaitHelper.waitForElement() to wait
            // Use click() to click the link
            logger.info("TODO: STEP 2 - Click Products link");

            // TODO Step 3 - Verify Products page loaded
            // Hint: Check page title using driver.getTitle()
            // Or look for specific element that only exists on Products page
            // Use Assert.assertTrue() to verify
            logger.info("TODO: STEP 3 - Verify Products page");

            // TODO Step 4 - Find and click Contact navigation link
            // Hint: Use By.linkText("Contact") or similar
            // Use WaitHelper.waitForElement() to wait
            // Use click() to click the link
            logger.info("TODO: STEP 4 - Click Contact link");

            // TODO Step 5 - Verify Contact page loaded
            // Hint: Check page title or look for specific Contact page element
            // Use Assert.assertTrue() to verify
            logger.info("TODO: STEP 5 - Verify Contact page");

            // TODO Step 6 - Find and click Home navigation link
            // Hint: Use By.linkText("Home") or similar
            // Use click() to click the link
            logger.info("TODO: STEP 6 - Click Home link");

            // TODO Step 7 - Verify back on Home page
            // Hint: Check page title or home-specific element
            // Use Assert.assertTrue() to verify
            logger.info("TODO: STEP 7 - Verify Home page");

            // END - Your code should end above

            logger.info("Scenario 3 Navigation Test Passed");
        } catch (Exception e) {
            logger.error("Test failed with exception: {}", e.getMessage());
            e.printStackTrace();
            Assert.fail("Navigation test failed: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        logger.info("Test Cleanup Started");
        DriverManager.closeDriver();
        logger.info("Test Completed");
    }
}
