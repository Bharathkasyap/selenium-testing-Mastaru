# Selenium Practice - Part 1: Web Automation with Selenium WebDriver

Welcome to the **Selenium Practice Part 1 Web App**! This is a hands-on learning project where you practice Selenium automation through 5 real-world scenarios.

---

## Quick Start

```bash
# 1. Fork this repository
# 2. Clone your fork
git clone https://github.com/YOUR-USERNAME/selenium-testing-Mastaru.git
cd selenium-testing-Mastaru/Part1/selenium-practice-webapp

# 3. Install dependencies
mvn clean install

# 4. Read scenarios
cat SCENARIOS.md

# 5. Run tests
mvn test
```

---

## What You'll Learn

By completing all 5 scenarios, you'll master:

| Scenario | Skill | Description |
|----------|-------|-------------|
| **1. Login Test** | Basic WebDriver | Navigate, find elements, input text, click buttons, verify results |
| **2. Form Filling** | Form Interaction | Fill multi-field forms, handle dropdowns, submit and verify |
| **3. Navigation** | Page Navigation | Navigate between pages, verify page loads, check links |
| **4. Alert Handling** | Alert Management | Handle JavaScript alerts, confirmations, and prompts |
| **5. Advanced Workflow** | End-to-End Testing | Complete multi-step CRUD workflow with create, read, update, logout |

---

## Project Structure

```
selenium-practice-webapp/
├── pom.xml              # Maven dependencies
├── testng.xml           # Test suite configuration
├── SCENARIOS.md         # All scenario descriptions
├── SETUP-GUIDE.md       # Environment setup instructions
├── README.md            # This file
└── src/main/java/com/seleniumlearning/part1/
    ├── Scenario1LoginTest.java
    ├── Scenario2FormFillingTest.java
    ├── Scenario3NavigationTest.java
    ├── Scenario4AlertHandlingTest.java
    ├── Scenario5AdvancedTest.java
    └── utils/
        ├── DriverManager.java   # WebDriver manager
        └── WaitHelper.java      # Wait utilities
```

---

## How It Works

### Step 1: Read the Theory
Start by reading [Part 1 Foundations.md](../Foundations.md) to understand the concepts.

### Step 2: Read the Scenarios
Open [SCENARIOS.md](SCENARIOS.md) to see all 5 practice scenarios with requirements.

### Step 3: Code Your Solutions
Each scenario file has `TODO` markers where you write your Selenium code:
- The code between `// START` and `// END` is your workspace
- Replace `logger.info("TODO: ...")` lines with actual Selenium code
- Use hints in the comments to guide your solution

### Step 4: Run & Verify
```bash
mvn test -Dtest=Scenario1LoginTest   # Run single scenario
mvn test                              # Run all scenarios
```

### Step 5: Learn from Solutions
Compare your approach with reference solutions in `src/test/java` (when available).

---

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Git
- IDE (IntelliJ IDEA, VS Code, or Eclipse)

See [SETUP-GUIDE.md](SETUP-GUIDE.md) for detailed setup instructions.

---

## Utilities Provided

### DriverManager
Manages WebDriver lifecycle - automatically initializes Chrome/Firefox drivers.
```java
WebDriver driver = DriverManager.getDriver();
DriverManager.closeDriver();
```

### WaitHelper
Provides explicit wait methods for handling dynamic content.
```java
WebElement element = WaitHelper.waitForElement(driver, By.id("username"), 10);
WebElement clickable = WaitHelper.waitForElementClickable(driver, By.id("submit"), 10);
WaitHelper.waitForElementWithText(driver, By.id("message"), "Success", 10);
```

---

## Technology Stack

| Technology | Version | Purpose |
|------------|---------|----------|
| Selenium WebDriver | 4.15.0 | Browser automation |
| TestNG | 7.8.1 | Testing framework |
| WebDriverManager | 5.6.3 | Auto-downloads browser drivers |
| Log4j | 2.20.0 | Logging |
| Maven | 3.6+ | Build tool |
| Java | 11+ | Programming language |

---

## Running Tests

| Command | Description |
|---------|-------------|
| `mvn test` | Run all scenarios |
| `mvn test -Dtest=Scenario1LoginTest` | Run specific scenario |
| `mvn test -X` | Run with debug output |
| `mvn test surefire-report:report` | Generate HTML report |

---

## Practice Websites

- Primary: `https://practice.automationbro.com`
- Alternative: `https://phptravels.com`
- Alternative: `https://demoqa.com`
- Alternative: `https://letskodeit.teachable.com`

---

## Contribution

Feel free to:
1. Fork this repository
2. Improve scenario files
3. Add more test cases
4. Submit a Pull Request

---

## License

This project is open source and available for learning purposes.

---

## Author

Created by Bharathkasyap as part of the Selenium Mastery course.
Part of [selenium-testing-Mastaru](https://github.com/Bharathkasyap/selenium-testing-Mastaru) repository.

---

**Happy Testing!** 🚀
