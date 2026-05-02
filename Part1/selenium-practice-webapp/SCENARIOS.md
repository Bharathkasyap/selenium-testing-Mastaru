# Part 1 - Selenium Practice Scenarios

## How to Use This Project

1. **Read Scenario Description** in this file
2. **Open corresponding Java file** in `src/main/java/com/seleniumlearning/part1`
3. **Write your solution** between the `TODO` markers
4. **Run the test** using Maven command
5. **Compare with solution** in `src/test/java` folder
6. **Move to next scenario**

---

## Before Starting

Make sure you have:
- Java 11 installed
- Maven installed
- Git installed
- Your IDE ready (IntelliJ or VS Code)

See `SETUP-GUIDE.md` for detailed setup instructions.

---

## Scenario 1: Basic Login Test

**File to Edit:** `src/main/java/com/seleniumlearning/part1/Scenario1LoginTest.java`

**Objective:** Automate a login workflow on a practice website

**Application URL:** `https://practice.automationbro.com/login`

**Test Credentials:**
- Username: `admin`
- Password: `password123`

**Requirements:**
- Navigate to the login page
- Find the username input field and enter `admin`
- Find the password input field and enter `password123`
- Find and click the Login button
- Wait for the page to load
- Assert that the success message "You are logged in" or "Dashboard" appears
- Close the browser gracefully

**Acceptance Criteria:**
- Script launches browser
- Navigates to `https://practice.automationbro.com/login`
- Enters credentials correctly
- Clicks login button
- Waits for success message to appear
- Verifies success message contains expected text
- Browser closes without errors

**Hints:**
- Use `DriverManager.getDriver()` to get WebDriver instance
- Use `By.name`, `By.id`, or `By.xpath` to find elements
- Use `WaitHelper.waitForElement()` for dynamic content
- Use `Assert` from TestNG to verify results
- Useful methods: `findElement()`, `sendKeys()`, `click()`, `getText()`

**Run Command:**
```bash
mvn test -Dtest=Scenario1LoginTest
```

---

## Scenario 2: Form Filling Validation

**File to Edit:** `src/main/java/com/seleniumlearning/part1/Scenario2FormFillingTest.java`

**Objective:** Fill a multi-field form and submit it

**Application URL:** `https://practice.automationbro.com/form`

**Test Data:**
- First Name: `John`
- Last Name: `Doe`
- Email: `john@example.com`
- Phone: `1234567890`
- Message: `This is a test message`

**Requirements:**
- Navigate to the form page
- Find and fill First Name field with `John`
- Find and fill Last Name field with `Doe`
- Find and fill Email field with `john@example.com`
- Find and fill Phone field with `1234567890`
- Find and fill Message textarea with `This is a test message`
- Click the Submit button
- Verify success message appears

**Acceptance Criteria:**
- All form fields are correctly filled
- Form is submitted successfully
- Success confirmation message is displayed
- Form submission status is verified with assertion

**Hints:**
- Some fields might require explicit waits
- Use `sendKeys()` to fill text fields
- Use `click()` to select dropdowns or buttons
- Use `clear()` before `sendKeys()` if field has default value
- Look for `input` and `textarea` tags

**Run Command:**
```bash
mvn test -Dtest=Scenario2FormFillingTest
```

---

## Scenario 3: Navigation Between Pages

**File to Edit:** `src/main/java/com/seleniumlearning/part1/Scenario3NavigationTest.java`

**Objective:** Navigate through multiple pages and verify navigation

**Application URL:** `https://practice.automationbro.com`

**Test Flow:**
1. Open home page
2. Click Products link
3. Verify products page title
4. Click Contact link
5. Verify contact page loads
6. Click Home link
7. Verify back on home page

**Requirements:**
- Navigate to home page
- Find and click Products navigation link
- Verify page title contains "Products"
- Find and click Contact navigation link
- Verify page title contains "Contact"
- Find and click Home navigation link
- Verify back on home page title or specific element

**Acceptance Criteria:**
- All page navigations work correctly
- Page titles are verified after each navigation
- No broken links encountered
- Browser history works as expected

**Hints:**
- Use `getTitle()` or `getCurrentUrl()` to verify page
- Use `By.linkText()` or `By.partialLinkText()` to find navigation links
- Wait for page load after each navigation
- Use `WaitHelper.waitForElement()` for dynamic content
- Element locators might be `a` href, button, span with link behavior

**Run Command:**
```bash
mvn test -Dtest=Scenario3NavigationTest
```

---

## Scenario 4: Alert Handling

**File to Edit:** `src/main/java/com/seleniumlearning/part1/Scenario4AlertHandlingTest.java`

**Objective:** Handle JavaScript alerts and confirmations

**Application URL:** `https://practice.automationbro.com/alerts`

**Test Flow:**
1. Open alerts page
2. Click button to trigger simple alert
3. Accept the alert
4. Click button to trigger confirmation dialog
5. Accept confirmation
6. Click button to trigger another confirmation
7. Dismiss/Cancel confirmation
8. Verify final result message

**Requirements:**
- Navigate to alerts demo page
- Find and click button that triggers simple alert
- Switch to alert using `switchTo().alert()`
- Accept simple alert using `accept()`
- Find and click button for confirmation dialog
- Accept confirmation dialog
- Verify success message on page
- Find and click another confirmation button
- Dismiss/Cancel the confirmation
- Verify the cancelled action result

**Acceptance Criteria:**
- Simple alerts are accepted correctly
- Confirmation dialogs are handled properly
- Alert acceptance results in expected page changes
- Alert dismissal results in expected page changes
- Final page state is verified with assertions

**Hints:**
- Use `driver.switchTo().alert()` to switch to alert
- Use `alert.accept()` to click OK
- Use `alert.dismiss()` to click Cancel
- Use `alert.getText()` to read alert message
- Alerts might take 1-2 seconds to appear, use waits
- Some practice sites use modal dialogs instead of JS alerts

**Run Command:**
```bash
mvn test -Dtest=Scenario4AlertHandlingTest
```

---

## Scenario 5: Advanced - Multi-Step Workflow

**File to Edit:** `src/main/java/com/seleniumlearning/part1/Scenario5AdvancedTest.java`

**Objective:** Complete a complex, multi-step workflow

**Application URL:** `https://practice.automationbro.com`

**Test Flow - Complete E2E Scenario:**
1. Open application home page
2. Login with credentials
3. Navigate to user dashboard
4. Click to create new item/product
5. Fill in the creation form
6. Submit the form
7. Verify the item appears in list
8. Click to view/edit the item
9. Edit item details
10. Save changes
11. Verify changes are reflected
12. Logout
13. Verify logout success

**Requirements:**
- Login to application
- Navigate to dashboard/list page
- Create new item with form
- Verify item in list
- Edit item details
- Save changes
- Verify changes persisted
- Logout from application

**Acceptance Criteria:**
- Complete workflow executes without errors
- Each step verifies expected UI changes
- Data persists across navigation
- Logout returns to login page
- Test demonstrates advanced Selenium skills:
  - Multiple waits
  - Complex locators
  - Data handling
  - Error checking

**Hints:**
- Break down the scenario into logical steps
- Create helper methods for repeated actions
- Use `WebDriverWait` for dynamic elements
- Verify at each step to catch failures early
- Consider using `JavaScriptExecutor` if needed
- Handle potential timeout scenarios gracefully

**Run Command:**
```bash
mvn test -Dtest=Scenario5AdvancedTest
```

---

## Running All Scenarios

To run all scenarios at once:
```bash
mvn test
```

To run with detailed output:
```bash
mvn test -X
```

To run and generate HTML report:
```bash
mvn test surefire-report:report
```

---

## Practice Websites for Testing

- Primary: `https://practice.automationbro.com`
- Alternative: `https://phptravels.com`
- Alternative: `https://demoqa.com`
- Alternative: `https://letskodeit.teachable.com`

---

## References

- Selenium Documentation: https://www.selenium.dev/documentation
- TestNG Documentation: https://testng.org
- Java Documentation: https://docs.oracle.com/javase/11
