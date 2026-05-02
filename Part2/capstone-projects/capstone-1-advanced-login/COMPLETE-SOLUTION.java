// Capstone 1: Advanced Login Testing - COMPLETE SOLUTION
// Creates for TechDash Analytics Platform
// Tests 5 scenarios: valid login, invalid email, unregistered email, empty email, empty password

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
    private String LOGIN_URL = "https://demoqa.com/login";
    private String VALID_EMAIL = "student";
    private String VALID_PASS = "Password123";
    private String INVALID_EMAIL_NO_AT = "invalidemail";
    private String UNREGISTERED_EMAIL = "nonexistent@example.com";

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

    // SCENARIO 1: VALID LOGIN - HAPPY PATH
    @Test(priority = 1, description = "Test login with correct credentials")
    public void testValidLogin() {
        System.out.println("\n=== SCENARIO 1: VALID LOGIN - HAPPY PATH ===");
        driver.get(LOGIN_URL);
        System.out.println("Step 1: Opened login page - demoqa.com/login");
        
        WebElement emailField = driver.findElement(By.id("userName"));
        emailField.clear();
        emailField.sendKeys(VALID_EMAIL);
        System.out.println("Step 2: Entered valid email: " + VALID_EMAIL);
        
        WebElement passField = driver.findElement(By.id("password"));
        passField.clear();
        passField.sendKeys(VALID_PASS);
        System.out.println("Step 3: Entered valid password");
        
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        System.out.println("Step 4: Clicked Login button");
        
        // Wait for profile page to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement profilePage = driver.findElement(By.xpath("//*[contains(text(), 'Profile')]"));
        Assert.assertTrue(profilePage.isDisplayed(), "Profile page did not load after valid login");
        System.out.println("Step 5: SUCCESS - Profile page loaded, valid login passed!");
        System.out.println("=== SCENARIO 1: PASSED ===\n");
    }

    // SCENARIO 2: INVALID EMAIL FORMAT
    @Test(priority = 2, description = "Test login with email without @ symbol")
    public void testInvalidEmailFormat() {
        System.out.println("=== SCENARIO 2: INVALID EMAIL FORMAT ===");
        driver.get(LOGIN_URL);
        System.out.println("Step 1: Opened login page");
        
        WebElement emailField = driver.findElement(By.id("userName"));
        emailField.clear();
        emailField.sendKeys(INVALID_EMAIL_NO_AT);
        System.out.println("Step 2: Entered email WITHOUT @ symbol: " + INVALID_EMAIL_NO_AT);
        
        WebElement passField = driver.findElement(By.id("password"));
        passField.clear();
        passField.sendKeys(VALID_PASS);
        System.out.println("Step 3: Entered valid password");
        
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        System.out.println("Step 4: Clicked Login button");
        
        // Check for error message
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement errorMsg = driver.findElement(By.className("text-danger"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message did not appear for invalid email");
        Assert.assertTrue(errorMsg.getText().contains("Valid Email"), "Error message does not mention email format");
        System.out.println("Step 5: Error message: " + errorMsg.getText());
        System.out.println("=== SCENARIO 2: PASSED ===\n");
    }

    // SCENARIO 3: UNREGISTERED EMAIL
    @Test(priority = 3, description = "Test login with email not in system")
    public void testUnregisteredEmail() {
        System.out.println("=== SCENARIO 3: EMAIL NOT REGISTERED ===");
        driver.get(LOGIN_URL);
        System.out.println("Step 1: Opened login page");
        
        WebElement emailField = driver.findElement(By.id("userName"));
        emailField.clear();
        emailField.sendKeys(UNREGISTERED_EMAIL);
        System.out.println("Step 2: Entered unregistered email: " + UNREGISTERED_EMAIL);
        
        WebElement passField = driver.findElement(By.id("password"));
        passField.clear();
        passField.sendKeys(VALID_PASS);
        System.out.println("Step 3: Entered valid password");
        
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        System.out.println("Step 4: Clicked Login button");
        
        // Check for user not found error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement errorMsg = driver.findElement(By.className("text-danger"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message did not appear for unregistered email");
        System.out.println("Step 5: Error message: " + errorMsg.getText());
        System.out.println("=== SCENARIO 3: PASSED ===\n");
    }

    // SCENARIO 4: EMPTY EMAIL FIELD
    @Test(priority = 4, description = "Test login with empty email field")
    public void testEmptyEmailField() {
        System.out.println("=== SCENARIO 4: EMPTY EMAIL FIELD ===");
        driver.get(LOGIN_URL);
        System.out.println("Step 1: Opened login page");
        
        WebElement emailField = driver.findElement(By.id("userName"));
        emailField.clear();
        System.out.println("Step 2: Left email field EMPTY (no text entered)");
        
        WebElement passField = driver.findElement(By.id("password"));
        passField.clear();
        passField.sendKeys(VALID_PASS);
        System.out.println("Step 3: Entered valid password");
        
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        System.out.println("Step 4: Clicked Login button");
        
        // Check for required field error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement errorMsg = driver.findElement(By.className("text-danger"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message did not appear for empty email");
        System.out.println("Step 5: Error message: " + errorMsg.getText());
        System.out.println("=== SCENARIO 4: PASSED ===\n");
    }

    // SCENARIO 5: EMPTY PASSWORD FIELD
    @Test(priority = 5, description = "Test login with empty password field")
    public void testEmptyPasswordField() {
        System.out.println("=== SCENARIO 5: EMPTY PASSWORD FIELD ===");
        driver.get(LOGIN_URL);
        System.out.println("Step 1: Opened login page");
        
        WebElement emailField = driver.findElement(By.id("userName"));
        emailField.clear();
        emailField.sendKeys(VALID_EMAIL);
        System.out.println("Step 2: Entered valid email: " + VALID_EMAIL);
        
        WebElement passField = driver.findElement(By.id("password"));
        passField.clear();
        System.out.println("Step 3: Left password field EMPTY (no text entered)");
        
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        System.out.println("Step 4: Clicked Login button");
        
        // Check for required field error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement errorMsg = driver.findElement(By.className("text-danger"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message did not appear for empty password");
        System.out.println("Step 5: Error message: " + errorMsg.getText());
        System.out.println("=== SCENARIO 5: PASSED ===\n");
    }
}
