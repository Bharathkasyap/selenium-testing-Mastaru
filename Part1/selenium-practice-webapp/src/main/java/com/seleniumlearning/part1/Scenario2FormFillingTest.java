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
 * Scenario 2: Form Filling Validation
 * Objective: Fill a multi-field form and submit it
 * Test Flow:
 * 1. Navigate to form page
 * 2. Fill all form fields
 * 3. Submit form
 * 4. Verify success message
 * Practice Website: https://practice.automationbro.com/form
 */
public class Scenario2FormFillingTest {

    private static final Logger logger = LogManager.getLogger(Scenario2FormFillingTest.class);
    private WebDriver driver;
    private static final String BASE_URL = "https://practice.automationbro.com/form";

    // Test Data
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final String EMAIL = "john@example.com";
    private static final String PHONE = "1234567890";
    private static final String MESSAGE = "This is a test message";

    @BeforeTest
    public void setUp() {
        logger.info("Test Setup Started");
        driver = DriverManager.getDriver();
        logger.info("WebDriver initialized");
    }

    @Test
    public void testFormFillingScenario() {
        logger.info("Scenario 2 Form Filling Test Started");
        try {
            // START - Write your code below this line

            // TODO Step 1 - Navigate to form page
            // Hint: Use driver.get(BASE_URL)
            logger.info("TODO: STEP 1 - Navigate to form page");

            // TODO Step 2 - Fill First Name field
            // Hint: Find element by name="firstName" or id="firstName"
            // Use WaitHelper.waitForElement() to wait
            // Use sendKeys(FIRST_NAME) to fill
            logger.info("TODO: STEP 2 - Enter first name");

            // TODO Step 3 - Fill Last Name field
            // Hint: Find element by name="lastName" or id="lastName"
            // Use sendKeys(LAST_NAME) to fill
            logger.info("TODO: STEP 3 - Enter last name");

            // TODO Step 4 - Fill Email field
            // Hint: Find element by name="email" or type="email"
            // Use sendKeys(EMAIL) to fill
            logger.info("TODO: STEP 4 - Enter email");

            // TODO Step 5 - Fill Phone field
            // Hint: Find element by name="phone" or type="tel"
            // Use sendKeys(PHONE) to fill
            logger.info("TODO: STEP 5 - Enter phone");

            // TODO Step 6 - Fill Message/Comment field
            // Hint: Use textarea element, name="message" or id="message"
            // Use sendKeys(MESSAGE) to fill
            logger.info("TODO: STEP 6 - Enter message");

            // TODO Step 7 - Submit the form
            // Hint: Find submit button by xpath or name
            // Use click() method
            logger.info("TODO: STEP 7 - Submit form");

            // TODO Step 8 - Verify success message
            // Hint: After submission, success message appears
            // Look for text like "Form submitted", "Success", "Thank you"
            // Use WaitHelper.waitForElement() to wait for message
            // Use Assert.assertTrue() to verify
            logger.info("TODO: STEP 8 - Verify form submission success");

            // END - Your code should end above

            logger.info("Scenario 2 Form Filling Test Passed");
        } catch (Exception e) {
            logger.error("Test failed with exception: {}", e.getMessage());
            e.printStackTrace();
            Assert.fail("Form filling test failed: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        logger.info("Test Cleanup Started");
        DriverManager.closeDriver();
        logger.info("Test Completed");
    }
}
