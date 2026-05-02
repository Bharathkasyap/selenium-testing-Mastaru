import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Capstone 2: Form Filling with Advanced Input
 * 
 * This automation script fills out a complete student registration form
 * demonstrating various input types including text fields, radio buttons,
 * checkboxes, dropdowns, date pickers, and file uploads.
 * 
 * Author: Selenium Testing Mastaru
 * Date: 2025
 */
public class Capstone2FormFilling {
    
    public static void main(String[] args) {
        
        WebDriver driver = null;
        
        try {
            // ============================================================
            // STEP 1: Setup WebDriver and Navigate
            // ============================================================
            System.out.println("🚀 Starting Capstone 2: Form Filling Automation");
            System.out.println("================================================");
            
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            String url = "https://demoqa.com/automation-practice-form";
            driver.get(url);
            System.out.println("✅ Navigated to: " + url);
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            
            // ============================================================
            // STEP 2: Fill Text Fields
            // ============================================================
            System.out.println("\n📝 Filling text fields...");
            
            driver.findElement(By.id("firstName")).sendKeys("Rajesh");
            System.out.println("   ✓ First Name: Rajesh");
            
            driver.findElement(By.id("lastName")).sendKeys("Kumar");
            System.out.println("   ✓ Last Name: Kumar");
            
            driver.findElement(By.id("userEmail")).sendKeys("rajesh.kumar@test.com");
            System.out.println("   ✓ Email: rajesh.kumar@test.com");
            
            driver.findElement(By.id("userNumber")).sendKeys("9876543210");
            System.out.println("   ✓ Mobile: 9876543210");
            
            // ============================================================
            // STEP 3: Select Gender (Radio Button)
            // ============================================================
            System.out.println("\n🔘 Selecting gender...");
            
            WebElement genderMale = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='gender-radio-1']")
            ));
            genderMale.click();
            System.out.println("   ✓ Gender: Male");
            
            // ============================================================
            // STEP 4: Select Date of Birth (Date Picker)
            // ============================================================
            System.out.println("\n📅 Selecting date of birth...");
            
            WebElement dateField = driver.findElement(By.id("dateOfBirthInput"));
            dateField.click();
            
            // Select Month
            Select monthDropdown = new Select(
                driver.findElement(By.className("react-datepicker__month-select"))
            );
            monthDropdown.selectByVisibleText("January");
            
            // Select Year
            Select yearDropdown = new Select(
                driver.findElement(By.className("react-datepicker__year-select"))
            );
            yearDropdown.selectByVisibleText("2000");
            
            // Select Day
            driver.findElement(By.xpath(
                "//div[contains(@class,'react-datepicker__day') and text()='15' " +
                "and not(contains(@class,'outside-month'))]"
            )).click();
            System.out.println("   ✓ Date of Birth: January 15, 2000");
            
            // ============================================================
            // STEP 5: Enter Subject (Auto-complete)
            // ============================================================
            System.out.println("\n📚 Entering subjects...");
            
            WebElement subjectField = driver.findElement(By.id("subjectsInput"));
            subjectField.sendKeys("Maths");
            subjectField.sendKeys(Keys.RETURN);
            System.out.println("   ✓ Subject: Maths");
            
            Thread.sleep(500); // Brief pause for UI
            
            subjectField.sendKeys("Physics");
            subjectField.sendKeys(Keys.RETURN);
            System.out.println("   ✓ Subject: Physics");
            
            // ============================================================
            // STEP 6: Select Hobbies (Checkboxes)
            // ============================================================
            System.out.println("\n🎯 Selecting hobbies...");
            
            WebElement sportCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='hobbies-checkbox-1']")
            ));
            sportCheckbox.click();
            System.out.println("   ✓ Hobby: Sports");
            
            WebElement musicCheckbox = driver.findElement(
                By.xpath("//label[@for='hobbies-checkbox-3']")
            );
            musicCheckbox.click();
            System.out.println("   ✓ Hobby: Music");
            
            // ============================================================
            // STEP 7: Enter Current Address
            // ============================================================
            System.out.println("\n🏠 Entering address...");
            
            driver.findElement(By.id("currentAddress"))
                .sendKeys("123 MG Road, Bangalore, Karnataka, India");
            System.out.println("   ✓ Address: 123 MG Road, Bangalore");
            
            // ============================================================
            // STEP 8: Select State and City (Custom Dropdowns)
            // ============================================================
            System.out.println("\n🌍 Selecting state and city...");
            
            // Scroll to state dropdown
            WebElement stateDropdown = driver.findElement(By.id("state"));
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", stateDropdown);
            Thread.sleep(500);
            
            stateDropdown.click();
            driver.findElement(By.xpath("//div[text()='Haryana']")).click();
            System.out.println("   ✓ State: Haryana");
            
            Thread.sleep(500);
            
            driver.findElement(By.id("city")).click();
            driver.findElement(By.xpath("//div[text()='Karnal']")).click();
            System.out.println("   ✓ City: Karnal");
            
            // ============================================================
            // STEP 9: Submit the Form
            // ============================================================
            System.out.println("\n📤 Submitting form...");
            
            WebElement submitButton = driver.findElement(By.id("submit"));
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", submitButton);
            Thread.sleep(500);
            
            submitButton.click();
            
            // ============================================================
            // STEP 10: Verify Submission
            // ============================================================
            System.out.println("\n🔍 Verifying submission...");
            
            WebElement successModal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("example-modal-sizes-title-lg")
            ));
            
            String modalTitle = successModal.getText();
            if (modalTitle.equals("Thanks for submitting the form")) {
                System.out.println("✅ SUCCESS: Form submitted successfully!");
                System.out.println("   Modal Title: " + modalTitle);
                
                // Extract and display submitted values
                System.out.println("\n📋 Submitted Data:");
                displaySubmittedData(driver);
            } else {
                System.out.println("❌ FAILED: Unexpected modal title - " + modalTitle);
            }
            
            // Close the modal
            Thread.sleep(2000);
            driver.findElement(By.id("closeLargeModal")).click();
            
            System.out.println("\n================================================");
            System.out.println("🎉 Capstone 2 Automation Completed Successfully!");
            System.out.println("================================================");
            
        } catch (Exception e) {
            System.err.println("\n❌ ERROR: An exception occurred during execution");
            System.err.println("Error Details: " + e.getMessage());
            e.printStackTrace();
            
        } finally {
            // ============================================================
            // CLEANUP: Close Browser
            // ============================================================
            if (driver != null) {
                try {
                    Thread.sleep(3000); // Keep browser open for 3 seconds
                    driver.quit();
                    System.out.println("\n🔒 Browser closed successfully");
                } catch (Exception e) {
                    System.err.println("Error closing browser: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Helper method to display submitted form data from the confirmation modal
     */
    private static void displaySubmittedData(WebDriver driver) {
        try {
            WebElement dataTable = driver.findElement(By.className("table"));
            java.util.List<WebElement> rows = dataTable.findElements(By.tagName("tr"));
            
            for (WebElement row : rows) {
                java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
                if (cells.size() == 2) {
                    String label = cells.get(0).getText();
                    String value = cells.get(1).getText();
                    System.out.println("   " + label + ": " + value);
                }
            }
        } catch (Exception e) {
            System.out.println("   Could not extract submitted data: " + e.getMessage());
        }
    }
}

/*
================================================================================
📌 KEY LEARNING POINTS:

1. TEXT INPUT HANDLING
   - Use sendKeys() for standard text fields
   - Clear fields before entering data if needed: element.clear()

2. RADIO BUTTONS
   - Often hidden in modern UIs
   - Click the associated <label> instead of the radio button itself
   - Use XPath to target labels: //label[@for='element-id']

3. CHECKBOXES
   - Similar to radio buttons, but multiple selections allowed
   - Click labels for better compatibility
   - Check if already selected: element.isSelected()

4. DATE PICKERS
   - Complex interactions involving dropdowns and calendar grids
   - Use Select class for standard dropdowns (month, year)
   - Use XPath with text() for calendar days
   - Handle "outside-month" dates correctly

5. AUTO-COMPLETE FIELDS
   - Type text and wait for suggestions
   - Press Keys.RETURN or Keys.ENTER to select
   - May need explicit waits for dropdown to appear

6. CUSTOM DROPDOWNS
   - Not standard <select> elements
   - Use click() to open dropdown
   - Use XPath or CSS to select options
   - Wait for animations to complete

7. DYNAMIC WAITS
   - Implicit wait: Sets global timeout for element finding
   - Explicit wait: Waits for specific conditions
   - WebDriverWait with ExpectedConditions is recommended
   - Thread.sleep() only as last resort (not recommended in production)

8. SCROLLING
   - Use JavascriptExecutor to scroll elements into view
   - Important for elements outside viewport
   - Prevents ElementNotInteractableException

9. ERROR HANDLING
   - Always use try-catch-finally blocks
   - Close browser in finally block to ensure cleanup
   - Log detailed error messages for debugging
   - Handle specific exceptions when possible

10. VERIFICATION
    - Always verify actions were successful
    - Check modal titles, success messages
    - Validate submitted data when possible
    - Use assertions for automated testing frameworks

================================================================================
🔧 COMMON ISSUES AND SOLUTIONS:

Issue: ElementNotInteractableException
Solution: Scroll element into view, wait for it to be clickable

Issue: StaleElementReferenceException
Solution: Re-locate element after page changes

Issue: NoSuchElementException
Solution: Increase wait time, verify locator is correct

Issue: TimeoutException
Solution: Increase wait duration, check if element exists

Issue: ElementClickInterceptedException
Solution: Scroll to element, wait for overlays to disappear, use JS click

================================================================================
🎯 REAL-WORLD APPLICATIONS:

✅ User Registration Forms
✅ Job Application Portals
✅ Survey and Feedback Forms
✅ E-commerce Checkout Pages
✅ Booking Systems (Hotels, Flights, Events)
✅ Healthcare Patient Forms
✅ Educational Enrollment Systems
✅ Banking Application Forms

================================================================================
*/
