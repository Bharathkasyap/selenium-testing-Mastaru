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
 * Scenario 1: Basic Login Test
 * Objective: Automate a login workflow on a practice website
 * Test Flow:
 * 1. Navigate to login page
 * 2. Enter username
 * 3. Enter password
 * 4. Click login button
 * 5. Verify successful login
 * 6. Close browser
 * Practice Website: https://practice.automationbro.com/login
 * Test Credentials: admin / password123
 */
public class Scenario1LoginTest {

    private static final Logger logger = LogManager.getLogger(Scenario1LoginTest.class);
    private WebDriver driver;
    private static final String BASE_URL = "https://practice.automationbro.com/login";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";

    @BeforeTest
    public void setUp() {
        logger.info("Test Setup Started");
        driver = DriverManager.getDriver();
        logger.info("WebDriver initialized");
    }

    @Test
    public void testLoginScenario() {
        logger.info("Scenario 1 Login Test Started");
        try {
            // START - Write your code below this line

            // TODO Step 1 - Navigate to the login page
            // Hint: Use driver.get(BASE_URL)
            // Replace the line below and write your code
            logger.info("TODO: STEP 1 - Navigate to login page");

            // TODO Step 2 - Find username field and enter text
            // Hint: Username field usually has name="username" or id="username"
            // Use WaitHelper.waitForElement() to wait for the field
            // Use sendKeys(USERNAME) to enter text
            logger.info("TODO: STEP 2 - Enter username");

            // TODO Step 3 - Find password field and enter text
            // Hint: Password field usually has name="password" or id="password"
            // Use driver.findElement() to find password field
            // Use sendKeys(PASSWORD) to enter text
            logger.info("TODO: STEP 3 - Enter password");

            // TODO Step 4 - Find and click login button
            // Hint: Look for button with text "Login" or "Submit"
            // Use By.xpath("//button[contains(text(), 'Login')]") or similar
            // Use click() method to click the button
            logger.info("TODO: STEP 4 - Click login button");

            // TODO Step 5 - Wait for success message and verify
            // Hint: After login, page shows "You are logged in" or similar message
            // Use WaitHelper.waitForElement() to wait for success message
            // Success message might be in h1, p, div, or span tag
            // Look for text like "Dashboard", "You are logged in", etc.
            logger.info("TODO: STEP 5 - Verify login success");

            // END - Your code should end above

            logger.info("Scenario 1 Login Test Passed");
        } catch (Exception e) {
            logger.error("Test failed with exception: {}", e.getMessage());
            e.printStackTrace();
            Assert.fail("Login test failed: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        logger.info("Test Cleanup Started");
        DriverManager.closeDriver();
        logger.info("Test Completed");
    }
}
