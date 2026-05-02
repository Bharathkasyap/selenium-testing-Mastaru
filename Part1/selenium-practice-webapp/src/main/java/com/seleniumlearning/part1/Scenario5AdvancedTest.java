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
 * Scenario 5: Advanced - Multi-Step Workflow
 * Objective: Complete a complex, multi-step workflow
 * Practice Website: https://practice.automationbro.com
 */
public class Scenario5AdvancedTest {

    private static final Logger logger = LogManager.getLogger(Scenario5AdvancedTest.class);
    private WebDriver driver;
    private static final String BASE_URL = "https://practice.automationbro.com";
    private static final String LOGIN_URL = "https://practice.automationbro.com/login";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";

    @BeforeTest
    public void setUp() {
        logger.info("Test Setup Started");
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("WebDriver initialized");
    }

    @Test
    public void testAdvancedWorkflowScenario() {
        logger.info("Scenario 5 Advanced Workflow Test Started");
        try {
            // START - Write your code below this line

            // --- LOGIN PHASE ---
            // TODO Step 1 - Navigate to login page and login
            // Hint: Navigate to LOGIN_URL
            // Find username field, enter USERNAME
            // Find password field, enter PASSWORD
            // Click login button
            // Wait for and verify login success
            logger.info("TODO: STEP 1 - Login to application");

            // --- CRUD OPERATIONS ---
            // TODO Step 2 - Navigate to dashboard/list page
            // Hint: Find and click on Dashboard or Items link in navigation
            logger.info("TODO: STEP 2 - Navigate to dashboard");

            // TODO Step 3 - Create new item
            // Hint: Find and click "Create New" or "Add Item" button
            // Wait for creation form to appear
            logger.info("TODO: STEP 3 - Click create new item");

            // TODO Step 4 - Fill creation form
            // Hint: Fill in required fields (name, description, etc.)
            // Use WaitHelper methods for each field
            logger.info("TODO: STEP 4 - Fill creation form");

            // TODO Step 5 - Submit the form
            // Hint: Find and click Submit/Save button
            logger.info("TODO: STEP 5 - Submit creation form");

            // TODO Step 6 - Verify item appears in list
            // Hint: Wait for success message or item to appear
            // Use WaitHelper.waitForElementWithText() to verify
            logger.info("TODO: STEP 6 - Verify item in list");

            // --- EDIT OPERATIONS ---
            // TODO Step 7 - Click to view/edit the item
            // Hint: Find the item in the list and click edit/view link
            logger.info("TODO: STEP 7 - Click edit item");

            // TODO Step 8 - Edit item details
            // Hint: Clear existing text and enter updated values
            // Use clear() followed by sendKeys()
            logger.info("TODO: STEP 8 - Edit item details");

            // TODO Step 9 - Save changes
            // Hint: Find and click Save/Update button
            logger.info("TODO: STEP 9 - Save changes");

            // TODO Step 10 - Verify changes are reflected
            // Hint: Check that updated text appears
            // Use WaitHelper.waitForElementWithText() with new values
            logger.info("TODO: STEP 10 - Verify changes persisted");

            // --- LOGOUT ---
            // TODO Step 11 - Logout from application
            // Hint: Find and click Logout button or link
            logger.info("TODO: STEP 11 - Logout");

            // TODO Step 12 - Verify logout success
            // Hint: Verify redirected to login page or see logout success message
            // Use driver.getCurrentUrl() or WaitHelper methods
            logger.info("TODO: STEP 12 - Verify logout success");

            // END - Your code should end above

            logger.info("Scenario 5 Advanced Workflow Test Passed");
        } catch (Exception e) {
            logger.error("Test failed with exception: {}", e.getMessage());
            e.printStackTrace();
            Assert.fail("Advanced workflow test failed: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        logger.info("Test Cleanup Started");
        DriverManager.closeDriver();
        logger.info("Test Completed");
    }
}
