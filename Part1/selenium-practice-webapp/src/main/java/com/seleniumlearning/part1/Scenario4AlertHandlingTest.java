package com.seleniumlearning.part1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import com.seleniumlearning.part1.utils.DriverManager;
import com.seleniumlearning.part1.utils.WaitHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Scenario 4: Alert Handling
 * Objective: Handle JavaScript alerts and confirmations
 * Test Flow:
 * 1. Navigate to alerts page
 * 2. Click button to trigger simple alert
 * 3. Accept the alert
 * 4. Click button to trigger confirmation dialog
 * 5. Accept confirmation
 * 6. Click button to trigger another confirmation
 * 7. Dismiss/Cancel confirmation
 * 8. Verify final result message
 * Practice Website: https://practice.automationbro.com/alerts
 */
public class Scenario4AlertHandlingTest {

    private static final Logger logger = LogManager.getLogger(Scenario4AlertHandlingTest.class);
    private WebDriver driver;
    private static final String BASE_URL = "https://practice.automationbro.com/alerts";

    @BeforeTest
    public void setUp() {
        logger.info("Test Setup Started");
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("WebDriver initialized");
    }

    @Test
    public void testAlertHandlingScenario() {
        logger.info("Scenario 4 Alert Handling Test Started");
        try {
            // START - Write your code below this line

            // TODO Step 1 - Navigate to alerts page
            // Hint: Use driver.get(BASE_URL)
            logger.info("TODO: STEP 1 - Navigate to alerts page");

            // TODO Step 2 - Trigger simple alert
            // Hint: Find button that triggers a simple alert
            // Use WaitHelper.waitForElementClickable() to wait for the button
            // Use click() to click the trigger button
            logger.info("TODO: STEP 2 - Trigger simple alert");

            // TODO Step 3 - Accept the simple alert
            // Hint: Use driver.switchTo().alert() to switch to the alert
            // Use alert.accept() to accept the alert
            logger.info("TODO: STEP 3 - Accept simple alert");

            // TODO Step 4 - Trigger confirmation dialog
            // Hint: Find button that triggers a confirmation dialog
            // Use click() to click the confirmation trigger button
            logger.info("TODO: STEP 4 - Trigger confirmation dialog");

            // TODO Step 5 - Accept confirmation dialog
            // Hint: Use driver.switchTo().alert()
            // Use alert.accept() to click OK
            logger.info("TODO: STEP 5 - Accept confirmation");

            // TODO Step 6 - Verify success message after accepting
            // Hint: Look for success message on page
            // Use WaitHelper.waitForElement() to wait for the message
            // Use Assert.assertTrue() to verify
            logger.info("TODO: STEP 6 - Verify acceptance result");

            // TODO Step 7 - Trigger another confirmation and dismiss it
            // Hint: Find another button that triggers confirmation
            // Click the button
            // Switch to alert using driver.switchTo().alert()
            // Use alert.dismiss() to dismiss/cancel
            logger.info("TODO: STEP 7 - Dismiss confirmation");

            // TODO Step 8 - Verify dismissal result
            // Hint: Look for cancelled/dismissed message on page
            // Use WaitHelper.waitForElement() to wait
            // Use Assert.assertTrue() to verify
            logger.info("TODO: STEP 8 - Verify dismissal result");

            // END - Your code should end above

            logger.info("Scenario 4 Alert Handling Test Passed");
        } catch (Exception e) {
            logger.error("Test failed with exception: {}", e.getMessage());
            e.printStackTrace();
            Assert.fail("Alert handling test failed: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        logger.info("Test Cleanup Started");
        DriverManager.closeDriver();
        logger.info("Test Completed");
    }
}
