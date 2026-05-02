// Capstone 1: E-Commerce Login Testing - COMPLETE SOLUTION
// This is READY TO RUN code
// All 5 test scenarios included

package com.seleniumlearning.capstone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class CompleteSolution {

    private WebDriver driver;
    private String LOGIN_URL = "https://practice.expandtesting.com/login";
    private String VALID_USER = "practice";
    private String VALID_PASS = "SuperSecretPassword!";
    private String INVALID_PASS = "WrongPassword";

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // === SCENARIO 1: VALID LOGIN (Happy Path) ===
    @Test(priority = 1, description = "Test login with correct credentials")
    public void testValidLogin() {
        System.out.println("SCENARIO 1: VALID LOGIN - HAPPY PATH");

        // Step 1: Open login page
        driver.get(LOGIN_URL);
        System.out.println("Step 1: Opened login page");

        // Step 2: Enter valid username
        driver.findElement(By.name("username")).sendKeys(VALID_USER);
        System.out.println("Step 2: Entered username");

        // Step 3: Enter valid password
        driver.findElement(By.name("password")).sendKeys(VALID_PASS);
        System.out.println("Step 3: Entered password");

        // Step 4: Click login button
        driver.findElement(By.id("btnLogin")).click();
        System.out.println("Step 4: Clicked login button");

        // Step 5: Verify success message
        WebElement successMsg = driver.findElement(By.xpath("//*[contains(text(), 'You logged into a secure area')]"));
        Assert.assertTrue(successMsg.isDisplayed());
        System.out.println("Step 5: SUCCESS - Valid login passed!");
    }

    // === SCENARIO 2: INVALID PASSWORD ===
    @Test(priority = 2, description = "Test login with wrong password")
    public void testInvalidPassword() {
        System.out.println("SCENARIO 2: INVALID PASSWORD");

        driver.get(LOGIN_URL);
        driver.findElement(By.name("username")).sendKeys(VALID_USER);
        driver.findElement(By.name("password")).sendKeys(INVALID_PASS);
        driver.findElement(By.id("btnLogin")).click();

        WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(), 'Your password is invalid')]"));
        Assert.assertTrue(errorMsg.isDisplayed());
        System.out.println("SUCCESS - Invalid password correctly rejected!");
    }

    // === SCENARIO 3: INVALID USERNAME ===
    @Test(priority = 3, description = "Test login with wrong username")
    public void testInvalidUsername() {
        System.out.println("SCENARIO 3: INVALID USERNAME");

        driver.get(LOGIN_URL);
        driver.findElement(By.name("username")).sendKeys("wronguser");
        driver.findElement(By.name("password")).sendKeys(VALID_PASS);
        driver.findElement(By.id("btnLogin")).click();

        WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(), 'Your username is invalid')]"));
        Assert.assertTrue(errorMsg.isDisplayed());
        System.out.println("SUCCESS - Invalid username correctly rejected!");
    }

    // === SCENARIO 4: EMPTY USERNAME ===
    @Test(priority = 4, description = "Test login with empty username")
    public void testEmptyUsername() {
        System.out.println("SCENARIO 4: EMPTY USERNAME");

        driver.get(LOGIN_URL);
        // Do NOT enter anything in username field
        driver.findElement(By.name("password")).sendKeys(VALID_PASS);
        driver.findElement(By.id("btnLogin")).click();

        WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(), 'Your username is invalid')]"));
        Assert.assertTrue(errorMsg.isDisplayed());
        System.out.println("SUCCESS - Empty username correctly rejected!");
    }

    // === SCENARIO 5: EMPTY PASSWORD ===
    @Test(priority = 5, description = "Test login with empty password")
    public void testEmptyPassword() {
        System.out.println("SCENARIO 5: EMPTY PASSWORD");

        driver.get(LOGIN_URL);
        driver.findElement(By.name("username")).sendKeys(VALID_USER);
        // Do NOT enter anything in password field
        driver.findElement(By.id("btnLogin")).click();

        WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(), 'Your password is invalid')]"));
        Assert.assertTrue(errorMsg.isDisplayed());
        System.out.println("SUCCESS - Empty password correctly rejected!");
    }
}
