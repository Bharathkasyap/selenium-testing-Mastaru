# Your Learning Journey - Selenium Practice Part 1

## Getting Started (Under 1 Minute!)

### Option 1: GitHub Codespaces (FASTEST - Recommended!)

1. Click the "Open in Codespaces" button on the README
2. Wait ~30 seconds for the cloud IDE to load
3. Java and Maven are already installed!
4. Type `mvn test` in the terminal
5. See results immediately!

### Option 2: Local Setup

1. Fork this repository
2. Clone: `git clone your-fork-url`
3. Run: `mvn clean install`
4. Open in your IDE

---

## 1 Scenario 1: Login Test (15 minutes)

**What you'll learn:** Basic WebDriver - navigating, finding elements, typing text, clicking buttons

**Steps:**
1. Read: `SCENARIOS.md` -> Scenario 1
2. Open: `Scenario1LoginTest.java`
3. Replace the TODO marker with your code
4. Run: `mvn test -Dtest=Scenario1LoginTest`
5. Success? Move to Scenario 2!

**File to edit:** `src/main/java/com/seleniumlearning/part1/Scenario1LoginTest.java`

---

## 2 Scenario 2: Form Filling (20 minutes)

**What you'll learn:** Filling multi-field forms, handling dropdowns, submitting and verifying

**Steps:**
1. Read: `SCENARIOS.md` -> Scenario 2
2. Open: `Scenario2FormFillingTest.java`
3. Replace the TODO marker with your code
4. Run: `mvn test -Dtest=Scenario2FormFillingTest`
5. Success? Move to Scenario 3!

**File to edit:** `src/main/java/com/seleniumlearning/part1/Scenario2FormFillingTest.java`

---

## 3 Scenario 3: Navigation (15 minutes)

**What you'll learn:** Navigating between pages, verifying page loads, checking links

**Steps:**
1. Read: `SCENARIOS.md` -> Scenario 3
2. Open: `Scenario3NavigationTest.java`
3. Replace the TODO marker with your code
4. Run: `mvn test -Dtest=Scenario3NavigationTest`
5. Success? Move to Scenario 4!

**File to edit:** `src/main/java/com/seleniumlearning/part1/Scenario3NavigationTest.java`

---

## 4 Scenario 4: Alert Handling (15 minutes)

**What you'll learn:** Handling JavaScript alerts, confirmations, and prompts

**Steps:**
1. Read: `SCENARIOS.md` -> Scenario 4
2. Open: `Scenario4AlertHandlingTest.java`
3. Replace the TODO marker with your code
4. Run: `mvn test -Dtest=Scenario4AlertHandlingTest`
5. Success? Move to Scenario 5!

**File to edit:** `src/main/java/com/seleniumlearning/part1/Scenario4AlertHandlingTest.java`

---

## 5 Scenario 5: Advanced Workflow (30 minutes)

**What you'll learn:** Complete end-to-end testing - login, create, edit, save, logout

**Steps:**
1. Read: `SCENARIOS.md` -> Scenario 5
2. Open: `Scenario5AdvancedTest.java`
3. Replace the TODO marker with your code (multiple steps!)
4. Run: `mvn test -Dtest=Scenario5AdvancedTest`
5. Mastered all 5? You're ready for Part 2!

**File to edit:** `src/main/java/com/seleniumlearning/part1/Scenario5AdvancedTest.java`

---

## Quick Reference Commands

| Task | Command |
|------|--------|
| Run all scenarios | `mvn test` |
| Run Scenario 1 | `mvn test -Dtest=Scenario1LoginTest` |
| Run Scenario 2 | `mvn test -Dtest=Scenario2FormFillingTest` |
| Run Scenario 3 | `mvn test -Dtest=Scenario3NavigationTest` |
| Run Scenario 4 | `mvn test -Dtest=Scenario4AlertHandlingTest` |
| Run Scenario 5 | `mvn test -Dtest=Scenario5AdvancedTest` |
| Install dependencies | `mvn clean install` |

---

## Tips for Success

1. Read the hints in the TODO comments - they guide you!
2. Use the utility classes (`DriverManager`, `WaitHelper`) provided
3. If a test fails, read the error message carefully
4. Compare your solution with the reference solutions when available
5. Don't copy-paste from solutions - write your own code!

---

**Total estimated time: ~95 minutes (1.5 hours)**

Good luck! You've got this! 🚀
