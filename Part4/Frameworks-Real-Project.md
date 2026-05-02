# Part 4: Frameworks & Real Project

> **This is where individual Selenium skills become a professional automation system.** Every real job expects you to use a framework. This part builds you from scratch to a complete, working, professional-grade automation project.

---

## Table of Contents

1. [Why Frameworks Exist](#why-frameworks-exist)
2. [Types of Frameworks](#types-of-frameworks)
3. [TestNG In Depth](#testng-in-depth)
4. [Maven](#maven)
5. [Page Object Model](#page-object-model)
6. [Data-Driven Testing](#data-driven-testing)
7. [Reporting](#reporting)
8. [Logging with Log4j](#logging-with-log4j)
9. [Complete Real Project](#complete-real-project)
10. [Practical Projects](#practical-projects)

---

## Why Frameworks Exist

Imagine you write 300 test scripts. Each one:
- Opens the browser itself
- Has its own login code (copy-pasted 300 times)
- Saves screenshots in different folders
- Has hardcoded usernames and URLs

Now the website changes the login page. You must update **all 300 files**.

This is the problem. A **framework** solves it.

**A framework provides:**
- One place for common code (login, setup, teardown)
- One place for configuration (URLs, credentials)
- Consistent structure all team members follow
- Reusable components (page classes, utility classes)
- Easy maintenance — change once, fixed everywhere

**Business value of a good framework:**
- Reduces test creation time by 60%
- Reduces maintenance time by 80%
- Makes onboarding new team members fast
- Produces consistent, readable reports
- Enables parallel execution → faster feedback

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Framework ఎందుకు అవసరం?**

300 test scripts రాశావు. ఒక్కో script లో login code copy-paste చేశావు. Website login page change అయింది — ఇప్పుడు 300 files update చేయాలి. ఇది nightmare.

**Framework అంటే:** ఒక organized structure, ఇందులో:
- Common code ఒకే చోట ఉంటుంది
- Configuration ఒకే file లో ఉంటుంది
- అందరూ same structure follow చేస్తారు
- Change ఒకే చోట చేస్తే, అన్ని tests లో automatically apply అవుతుంది

**Business perspective:**
- Test రాయడానికి time తగ్గుతుంది
- Maintenance easy అవుతుంది
- Team తో collaborate చేయడం easy అవుతుంది
- Reports professional గా వస్తాయి

</details>

---

## Types of Frameworks

### Framework Comparison

| Framework | Description | Best For | Team Size |
|-----------|-------------|----------|-----------|
| **Linear** | Scripts run top to bottom, no reuse | One-time testing, learning | Solo |
| **Modular** | Functions/methods reused across tests | Small projects | 1-3 people |
| **Data-Driven** | Same test, multiple data sets | Form testing, login testing | Any |
| **Keyword-Driven** | Actions as keywords in spreadsheet | Non-technical testers | Mixed teams |
| **Hybrid** | Combination of above | Enterprise projects | Large teams |
| **BDD** | Tests written in plain English (Gherkin) | Business stakeholder collaboration | Any |

### Decision Guide — Which Framework to Choose?

```
What is the project size?
│
├── Small (< 50 tests) → Modular Framework
│
├── Medium (50-200 tests) → Data-Driven + POM
│
└── Large (200+ tests) → Hybrid Framework
    │
    ├── Business wants to write tests? → Add BDD (Cucumber)
    │
    └── Multiple data sources? → Data-Driven layer on top
```

**In 90% of real jobs, you will use a Hybrid Framework** = Page Object Model + TestNG + Maven + Data-Driven + Extent Reports.

This is exactly what we will build in the Real Project section.

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Framework Types:**

**Linear:** Scripts simple గా top to bottom run అవుతాయి. Practice కోసం OK, real projects కోసం not good.

**Modular:** Common functions separate చేస్తాం. ఉదా: loginToApp() అనే function ఒకసారి రాయడం, అన్ని tests లో reuse చేయడం.

**Data-Driven:** Same test different data తో run చేయడం. Login test — valid user, invalid user, empty user అన్నింటికి same script, different data.

**Keyword-Driven:** Actions ని keywords గా Excel లో రాస్తాం. "click", "type", "verify" — technical knowledge లేని people కూడా tests రాయవచ్చు.

**Hybrid:** పై అన్నింటి combination. Real jobs లో ఇదే use చేస్తారు.

**BDD:** Tests plain English లో (Gherkin). "Given I am on login page, When I enter valid credentials, Then I should see dashboard."

</details>

---

## TestNG In Depth

### What Is TestNG?

TestNG is a testing framework for Java. "NG" = Next Generation. It replaced JUnit with more powerful features:
- Annotations for test lifecycle
- Parameterization
- Grouping tests
- Parallel execution
- Listeners
- Rich reports

**Add to pom.xml:**
```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.9.0</version>
    <scope>test</scope>
</dependency>
```

---

### All TestNG Annotations

```java
import org.testng.annotations.*;

public class TestNGAnnotationsDemo {
    
    // ===== SUITE LEVEL (runs once for entire suite) =====
    
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BEFORE SUITE — Setup database connections, test environment");
    }
    
    @AfterSuite
    public void afterSuite() {
        System.out.println("AFTER SUITE — Cleanup everything, send email report");
    }
    
    // ===== TEST LEVEL (runs once per <test> tag in testng.xml) =====
    
    @BeforeTest
    public void beforeTest() {
        System.out.println("BEFORE TEST — Initialize browser for this test group");
    }
    
    @AfterTest
    public void afterTest() {
        System.out.println("AFTER TEST — Close browser for this test group");
    }
    
    // ===== CLASS LEVEL (runs once per test class) =====
    
    @BeforeClass
    public void beforeClass() {
        System.out.println("BEFORE CLASS — Open browser, navigate to base URL");
    }
    
    @AfterClass
    public void afterClass() {
        System.out.println("AFTER CLASS — Close browser for this class");
    }
    
    // ===== METHOD LEVEL (runs before/after EVERY test method) =====
    
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BEFORE METHOD — Refresh page, clear cookies, setup state");
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("AFTER METHOD — Take screenshot if failed, logout");
    }
    
    // ===== TEST METHODS =====
    
    @Test
    public void testLogin() {
        System.out.println("TEST: Login");
    }
    
    @Test
    public void testSearch() {
        System.out.println("TEST: Search");
    }
}
```

**Lifecycle Execution Order:**
```
BeforeSuite
  └── BeforeTest
        └── BeforeClass
              └── BeforeMethod → @Test (testLogin) → AfterMethod
              └── BeforeMethod → @Test (testSearch) → AfterMethod
        └── AfterClass
  └── AfterTest
AfterSuite
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**TestNG Annotations అంటే ఏమిటి?**

Annotations అంటే @ తో మొదలయ్యే special markers, ఇవి methods ని "ఎప్పుడు run చేయాలి" అని TestNG కి చెప్తాయి.

**4 levels:**
1. **Suite level:** @BeforeSuite, @AfterSuite — entire test run కి ఒకసారి
2. **Test level:** @BeforeTest, @AfterTest — testng.xml లో ప్రతి `<test>` tag కి ఒకసారి  
3. **Class level:** @BeforeClass, @AfterClass — ప్రతి class కి ఒకసారి
4. **Method level:** @BeforeMethod, @AfterMethod — ప్రతి @Test method కి ముందు/తర్వాత

**Real usage:**
- @BeforeClass లో browser open చేయి
- @BeforeMethod లో page refresh చేయి
- @AfterMethod లో screenshot తీయి (if failed)
- @AfterClass లో browser close చేయి

</details>

---

### Test Priorities and Dependencies

```java
public class PriorityAndDependency {
    
    // Priority: lower number runs first (default priority is 0)
    @Test(priority = 1)
    public void openHomePage() {
        System.out.println("Step 1: Open home page");
    }
    
    @Test(priority = 2)
    public void login() {
        System.out.println("Step 2: Login");
    }
    
    @Test(priority = 3)
    public void searchProduct() {
        System.out.println("Step 3: Search product");
    }
    
    // dependsOnMethods: this test only runs if login() PASSES
    @Test(dependsOnMethods = {"login"})
    public void viewProfile() {
        System.out.println("View profile (depends on login)");
    }
    
    // dependsOnGroups: depends on entire group passing
    @Test(dependsOnGroups = {"authentication"})
    public void placeOrder() {
        System.out.println("Place order (depends on auth group)");
    }
    
    @Test(groups = {"authentication"}, priority = 1)
    public void testLogin() {
        System.out.println("Login test — part of authentication group");
    }
    
    @Test(groups = {"authentication"}, priority = 2)
    public void testLogout() {
        System.out.println("Logout test — part of authentication group");
    }
}
```

---

### Parameterization

**Method 1: @Parameters (from testng.xml)**

```java
public class ParameterizationDemo {
    
    // Values come from testng.xml file
    @Test
    @Parameters({"username", "password", "expectedTitle"})
    public void testLogin(String username, String password, String expectedTitle) {
        System.out.println("Testing login with: " + username);
        // ... login logic using these params
    }
}
```

```xml
<!-- testng.xml -->
<suite name="LoginSuite">
    <test name="AdminLogin">
        <parameter name="username" value="admin@company.com"/>
        <parameter name="password" value="admin123"/>
        <parameter name="expectedTitle" value="Admin Dashboard"/>
        <classes>
            <class name="tests.ParameterizationDemo"/>
        </classes>
    </test>
    
    <test name="UserLogin">
        <parameter name="username" value="user@company.com"/>
        <parameter name="password" value="user123"/>
        <parameter name="expectedTitle" value="User Dashboard"/>
        <classes>
            <class name="tests.ParameterizationDemo"/>
        </classes>
    </test>
</suite>
```

**Method 2: @DataProvider (more powerful)**

```java
import org.testng.annotations.DataProvider;

public class DataProviderDemo {
    
    // DataProvider — provides multiple rows of test data
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"admin@site.com",    "admin123",   true,  "Dashboard"},
            {"user@site.com",     "user123",    true,  "Home"},
            {"wrong@site.com",    "wrongpass",  false, "Invalid credentials"},
            {"",                  "",           false, "Please fill all fields"},
            {"valid@site.com",    "wrong",      false, "Incorrect password"},
        };
    }
    
    // Test method that uses the DataProvider
    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password, 
                          boolean shouldSucceed, String expectedMessage) {
        System.out.println("Testing: " + email + " / " + password);
        System.out.println("Expected success: " + shouldSucceed);
        System.out.println("Expected message: " + expectedMessage);
        // ... actual selenium login code here
    }
}
```

```java
// Advanced DataProvider — read from external source
public class ExternalDataProvider {
    
    @DataProvider(name = "excelData")
    public Object[][] getDataFromExcel() throws Exception {
        // Read from Excel file (we'll cover Apache POI in Data-Driven section)
        return ExcelUtils.readTestData("testdata/LoginTestData.xlsx", "Sheet1");
    }
    
    @DataProvider(name = "parallelData", parallel = true)  // runs data sets in parallel
    public Object[][] getParallelData() {
        return new Object[][] {
            {"dataset1"},
            {"dataset2"},
            {"dataset3"},
        };
    }
    
    @Test(dataProvider = "excelData")
    public void testWithExcelData(String username, String password, String expected) {
        System.out.println("Excel data: " + username + " → " + expected);
    }
}
```

---

### Assertions — Hard vs Soft

```java
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {
    
    @Test
    public void hardAssertDemo() {
        // HARD ASSERT — test STOPS immediately if this fails
        Assert.assertEquals(driver.getTitle(), "Expected Title");
        
        // These lines will NOT run if above assertion failed
        Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://example.com/home");
        
        System.out.println("All assertions passed!");
    }
    
    @Test
    public void softAssertDemo() {
        SoftAssert softAssert = new SoftAssert();
        
        // SOFT ASSERT — test CONTINUES even if this fails
        softAssert.assertEquals(driver.getTitle(), "Expected Title", 
            "Title mismatch");
        
        // This RUNS even if title assertion failed
        softAssert.assertTrue(
            driver.findElement(By.id("logo")).isDisplayed(), 
            "Logo not visible"
        );
        
        softAssert.assertEquals(
            driver.findElement(By.id("welcome")).getText(), 
            "Welcome, User!", 
            "Welcome message mismatch"
        );
        
        // MUST call assertAll at the end — this is where failures are reported
        softAssert.assertAll();
    }
    
    @Test
    public void allAssertTypes() {
        // assertEquals — checks exact value match
        Assert.assertEquals(actual, expected, "Error message");
        
        // assertTrue — checks condition is true
        Assert.assertTrue(element.isDisplayed(), "Element not visible");
        
        // assertFalse — checks condition is false
        Assert.assertFalse(element.isSelected(), "Should not be selected");
        
        // assertNotNull — checks value is not null
        Assert.assertNotNull(driver.findElements(By.tagName("li")), "List is null");
        
        // assertNull — checks value is null
        Assert.assertNull(driver.findElements(By.id("nonExistent")).isEmpty() ? null : "exists");
        
        // assertNotEquals — checks values are different
        Assert.assertNotEquals(actual, notExpected);
    }
}
```

**Hard vs Soft Assert — When to Use:**

| Situation | Use |
|-----------|-----|
| Critical check (login must succeed to continue) | Hard Assert |
| Validating multiple fields on a form | Soft Assert |
| Page must load before doing anything | Hard Assert |
| Checking all items in a list | Soft Assert |
| One check per test | Either |

---

### TestNG Listeners

Listeners "listen" to test events and let you take action (like taking a screenshot on failure).

```java
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED: " + result.getName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST PASSED: " + result.getName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED: " + result.getName());
        
        // Get the WebDriver instance from the failing test class
        Object testInstance = result.getInstance();
        WebDriver driver = ((BaseTest) testInstance).getDriver();
        
        // Take screenshot
        if (driver != null) {
            ScreenshotUtils.takeScreenshot(driver, result.getName());
        }
        
        // Print exception
        System.err.println("Failure reason: " + result.getThrowable().getMessage());
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED: " + result.getName());
    }
}
```

```xml
<!-- Register listener in testng.xml -->
<suite name="Suite">
    <listeners>
        <listener class-name="listeners.TestListener"/>
    </listeners>
    <test name="Regression">
        <classes>
            <class name="tests.LoginTest"/>
        </classes>
    </test>
</suite>
```

---

### TestNG XML — Complete Example

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="E-Commerce Test Suite" verbose="2" parallel="tests" thread-count="3">

    <!-- Global parameters available to all tests -->
    <parameter name="baseUrl" value="https://demoqa.com"/>
    <parameter name="browser" value="chrome"/>
    
    <!-- Listeners -->
    <listeners>
        <listener class-name="listeners.TestListener"/>
        <listener class-name="listeners.ExtentReportListener"/>
    </listeners>
    
    <!-- Smoke tests — run first -->
    <test name="Smoke Tests">
        <groups>
            <run>
                <include name="smoke"/>
            </run>
        </groups>
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.HomePageTest"/>
        </classes>
    </test>
    
    <!-- Full regression — run after smoke -->
    <test name="Regression Tests">
        <groups>
            <run>
                <include name="regression"/>
                <exclude name="wip"/>  <!-- exclude work-in-progress tests -->
            </run>
        </groups>
        <classes>
            <class name="tests.LoginTest">
                <methods>
                    <include name="testValidLogin"/>
                    <include name="testInvalidLogin"/>
                </methods>
            </class>
            <class name="tests.ProductTest"/>
            <class name="tests.CartTest"/>
            <class name="tests.CheckoutTest"/>
        </classes>
    </test>
    
</suite>
```

### Parallel Execution

```xml
<!-- Run test METHODS in parallel (4 at a time) -->
<suite name="ParallelSuite" parallel="methods" thread-count="4">
    <test name="AllTests">
        <classes>
            <class name="tests.LoginTest"/>
        </classes>
    </test>
</suite>

<!-- Run test CLASSES in parallel -->
<suite name="ParallelSuite" parallel="classes" thread-count="3">
    <test name="AllTests">
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.SearchTest"/>
            <class name="tests.CartTest"/>
        </classes>
    </test>
</suite>
```

**Important for Parallel Execution:** Each thread needs its own WebDriver. Use `ThreadLocal<WebDriver>`:

```java
public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }
    
    public static void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**TestNG — Complete Summary:**

**Annotations lifecycle:**
BeforeSuite → BeforeTest → BeforeClass → BeforeMethod → @Test → AfterMethod → AfterClass → AfterTest → AfterSuite

**DataProvider vs Parameters:**
- @Parameters: testng.xml లో values specify చేస్తాం — simple, limited
- @DataProvider: Method లో data array return చేస్తాం — powerful, Excel కూడా read చేయవచ్చు

**Hard Assert vs Soft Assert:**
- Hard: Fail అయిన వెంటనే test stop — critical checks కి
- Soft: Fail అయినా continue — form validation లో multiple checks కి

**Listeners:** Test events (start, pass, fail, skip) ని listen చేసి actions చేయడానికి. Most important use: test fail అయినప్పుడు automatically screenshot తీయడం.

**Parallel execution:** Multiple tests simultaneously run చేయడం. ThreadLocal వాడి ప్రతి thread కి separate WebDriver ఇవ్వాలి — otherwise threads ఒకే browser share చేస్తాయి, chaos అవుతుంది.

</details>

---

## Maven

### What Is Maven?

Maven is a **build and dependency management tool** for Java projects. It:
- Downloads required libraries (Selenium, TestNG, etc.) automatically
- Manages project structure (standard folder layout)
- Runs tests via command line
- Creates build artifacts (JAR files)
- Integrates with CI/CD pipelines

Without Maven, you manually download JAR files, add them to classpath, manage versions. Maven does all of this from a single file: `pom.xml`.

<details>
<summary>Required Skill: Maven Basics (Click to learn)</summary>

**Maven Standard Directory Structure:**
```
my-project/
├── pom.xml                    ← The heart of Maven
├── src/
│   ├── main/
│   │   └── java/             ← Application code (not used in pure test projects)
│   └── test/
│       ├── java/             ← Your test classes go here
│       └── resources/        ← Config files, testng.xml, test data
└── target/                   ← Generated files (compiled classes, reports)
```

**Maven Lifecycle Phases (in order):**
1. `validate` — validate project structure
2. `compile` — compile source code
3. `test-compile` — compile test code
4. `test` — run tests
5. `package` — create JAR
6. `install` — install JAR to local repository
7. `deploy` — deploy to remote repository

**When you run `mvn test`, it automatically runs all phases before it.**

**Maven Repository:**
- **Local:** `~/.m2/repository` on your machine (downloaded once, reused)
- **Central:** `https://repo1.maven.org/maven2` (the internet library)
- **Remote/Corporate:** Your company's private repo (Nexus, Artifactory)

</details>

### Complete pom.xml for Selenium Project

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!-- Project Coordinates — identifies your project -->
    <groupId>com.yourcompany</groupId>
    <artifactId>selenium-framework</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>
    <name>Selenium Automation Framework</name>

    <!-- Properties — centralize version numbers -->
    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        
        <!-- Dependency versions — change once, applies everywhere -->
        <selenium.version>4.18.1</selenium.version>
        <testng.version>7.9.0</testng.version>
        <extentreports.version>5.1.1</extentreports.version>
        <poi.version>5.2.5</poi.version>
        <log4j.version>2.23.1</log4j.version>
    </properties>

    <!-- Dependencies — libraries your project needs -->
    <dependencies>
        
        <!-- Selenium WebDriver -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>${selenium.version}</version>
        </dependency>
        
        <!-- TestNG testing framework -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>${testng.version}</version>
            <scope>test</scope>
        </dependency>
        
        <!-- ExtentReports for HTML reports -->
        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>${extentreports.version}</version>
        </dependency>
        
        <!-- Apache POI for Excel -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>${poi.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>${poi.version}</version>
        </dependency>
        
        <!-- Log4j for logging -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        
        <!-- Commons IO for file operations -->
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.15.1</version>
        </dependency>
        
        <!-- JSON library for reading JSON test data -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.17.0</version>
        </dependency>
        
    </dependencies>

    <build>
        <plugins>
            
            <!-- Maven Compiler Plugin — specifies Java version -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
                    <source>17</source>
                    <target>17</target>
                </configuration>
            </plugin>
            
            <!-- Maven Surefire Plugin — runs TestNG tests -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
                    <!-- Specify which testng.xml to run -->
                    <suiteXmlFiles>
                        <suiteXmlFile>src/test/resources/testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                    <!-- Browser passed as system property: mvn test -Dbrowser=firefox -->
                    <systemPropertyVariables>
                        <browser>${browser}</browser>
                    </systemPropertyVariables>
                </configuration>
            </plugin>
            
        </plugins>
        
        <!-- Include non-Java files from test resources -->
        <testResources>
            <testResource>
                <directory>src/test/resources</directory>
            </testResource>
        </testResources>
    </build>

    <!-- Profiles — run different configs based on environment -->
    <profiles>
        
        <profile>
            <id>smoke</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <configuration>
                            <suiteXmlFiles>
                                <suiteXmlFile>src/test/resources/smoke-testng.xml</suiteXmlFile>
                            </suiteXmlFiles>
                        </configuration>
                    </plugin>
                </plugins>
            </build>
        </profile>
        
        <profile>
            <id>regression</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <configuration>
                            <suiteXmlFiles>
                                <suiteXmlFile>src/test/resources/regression-testng.xml</suiteXmlFile>
                            </suiteXmlFiles>
                        </configuration>
                    </plugin>
                </plugins>
            </build>
        </profile>
        
    </profiles>

</project>
```

**Essential Maven Commands:**

```bash
# Download all dependencies
mvn dependency:resolve

# Compile test code only
mvn test-compile

# Run all tests
mvn test

# Run specific testng.xml
mvn test -DsuiteXmlFile=smoke-testng.xml

# Run with specific browser
mvn test -Dbrowser=firefox

# Run smoke profile
mvn test -Psmoke

# Skip tests (just build)
mvn package -DskipTests

# Clear target folder and start fresh
mvn clean test

# Generate site/reports
mvn site
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Maven అంటే ఏమిటి?**

Maven అనేది Java project management tool. ఇది 3 main పనులు చేస్తుంది:

1. **Dependency Management:** pom.xml లో library name, version రాస్తే Maven automatically download చేస్తుంది. Manual JAR download అక్కర్లేదు.

2. **Standard Structure:** అందరికి same folder structure — `src/test/java`, `src/test/resources`. Team member's project open చేసినా instantly understand అవుతాం.

3. **Build and Run:** `mvn test` ఒక command తో అన్ని tests run చేస్తుంది. CI/CD pipelines ఇదే command use చేస్తాయి.

**Profiles:** Different environments కి different configurations. `mvn test -Psmoke` — smoke tests మాత్రమే run అవుతాయి.

**Properties:** Version numbers `<properties>` లో define చేసి, అన్ని dependencies లో `${selenium.version}` గా reference చేస్తాం. Version upgrade చేయాలంటే ఒకే చోట change చేస్తే చాలు.

</details>

---

## Page Object Model

### What Is POM?

Page Object Model is a **design pattern** where each web page has its own Java class. The class contains:
- **Locators** for all elements on that page
- **Methods** for all actions on that page
- **No test logic** — POM classes only contain page interaction code

**Why POM?**
- If a locator changes, update in ONE place (the page class), not in every test
- Tests become readable — `loginPage.enterUsername("admin")`
- Team members can easily understand what each test does
- Easy to reuse page methods across multiple tests

**Without POM (bad):**
```java
// Test 1
driver.findElement(By.id("username")).sendKeys("admin");
driver.findElement(By.id("password")).sendKeys("admin123");
driver.findElement(By.id("loginBtn")).click();

// Test 2 — same code copied
driver.findElement(By.id("username")).sendKeys("user");
driver.findElement(By.id("password")).sendKeys("user123");
driver.findElement(By.id("loginBtn")).click();
```

If `By.id("loginBtn")` changes to `By.id("submit-login")`, you fix it in 2 places. In 50 tests? 50 places.

**With POM (good):**
```java
// LoginPage.java — define once
public void clickLoginButton() {
    driver.findElement(By.id("loginBtn")).click();
}

// Test 1
loginPage.clickLoginButton();

// Test 2
loginPage.clickLoginButton();
```

If locator changes — fix in ONE place.

---

### POM Implementation — Without Page Factory

```java
// ===== LoginPage.java (Page class) =====
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Locators — all in one place
    private By usernameField = By.id("userName");
    private By passwordField = By.id("password");
    private By loginButton   = By.id("login");
    private By errorMessage  = By.id("name");
    private By userNameLabel = By.id("userName-value");
    
    // Constructor — receives driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    // Actions — methods representing user interactions
    public void enterUsername(String username) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        field.clear();
        field.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    // Compound action — does multiple steps in one call
    public void loginWith(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    // State/Verification methods — return data for test assertions
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
    
    public boolean isLoginButtonVisible() {
        return driver.findElements(loginButton).size() > 0 &&
               driver.findElement(loginButton).isDisplayed();
    }
    
    public String getLoggedInUsername() {
        return driver.findElement(userNameLabel).getText();
    }
    
    // Navigation — returns page object of where user goes after action
    public DashboardPage loginSuccessfully(String username, String password) {
        loginWith(username, password);
        return new DashboardPage(driver);
    }
}
```

---

### POM With Page Factory (Recommended)

Page Factory uses `@FindBy` annotations — cleaner and more readable.

```java
// ===== LoginPage.java with Page Factory =====
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    // @FindBy annotates class fields directly — no By objects needed
    @FindBy(id = "userName")
    private WebElement usernameField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(id = "login")
    private WebElement loginButton;
    
    @FindBy(id = "name")
    private WebElement errorMessage;
    
    // @FindBy with CSS selector
    @FindBy(css = ".main-header h1")
    private WebElement pageHeader;
    
    // @FindBy with XPath
    @FindBy(xpath = "//div[@class='login-wrapper']//p[@class='error']")
    private WebElement loginError;
    
    // Constructor — MUST call PageFactory.initElements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);  // This initializes all @FindBy fields
    }
    
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    public void clickLogin() {
        loginButton.click();
    }
    
    public void loginWith(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
```

---

### Base Test Class

```java
// ===== BaseTest.java — parent class for all tests =====
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    
    // ThreadLocal ensures each parallel thread gets its own driver
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected String baseUrl = "https://demoqa.com";
    
    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        WebDriver webDriver;
        
        switch (browser.toLowerCase()) {
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                // options.addArguments("--headless");  // uncomment for CI/CD
                webDriver = new ChromeDriver(options);
                break;
        }
        
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.get(baseUrl);
        
        driver.set(webDriver);
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
        }
        driver.remove();
    }
    
    // All test classes call this to get driver
    public WebDriver getDriver() {
        return driver.get();
    }
}
```

---

### Full Project Folder Structure

```
selenium-framework/
├── pom.xml
├── src/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java
│       │   ├── pages/
│       │   │   ├── LoginPage.java
│       │   │   ├── DashboardPage.java
│       │   │   ├── ProductPage.java
│       │   │   ├── CartPage.java
│       │   │   └── CheckoutPage.java
│       │   ├── tests/
│       │   │   ├── LoginTest.java
│       │   │   ├── SearchTest.java
│       │   │   ├── CartTest.java
│       │   │   └── CheckoutTest.java
│       │   ├── utils/
│       │   │   ├── ExcelUtils.java
│       │   │   ├── JsonUtils.java
│       │   │   ├── ScreenshotUtils.java
│       │   │   └── WaitUtils.java
│       │   └── listeners/
│       │       ├── TestListener.java
│       │       └── ExtentReportListener.java
│       └── resources/
│           ├── testng.xml
│           ├── config.properties
│           ├── log4j2.xml
│           └── testdata/
│               ├── LoginTestData.xlsx
│               └── ProductTestData.json
└── reports/
    └── ExtentReport.html
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Page Object Model (POM) అంటే ఏమిటి?**

POM అనేది design pattern. ప్రతి webpage కి ఒక Java class ఉంటుంది:
- **Locators** — page మీద ఉన్న అన్ని elements
- **Methods** — user page మీద చేసే actions

**ఉదా:** Login page కి `LoginPage.java`:
- Fields: usernameField, passwordField, loginButton
- Methods: enterUsername(), enterPassword(), clickLogin(), loginWith()

**Test class:**
```java
LoginPage loginPage = new LoginPage(driver);
loginPage.loginWith("admin", "admin123");
```

**Benefits:**
- Locator change అయితే → Page class లో ఒకే చోట fix
- Tests readable గా ఉంటాయి
- Team members easily understand చేయగలరు

**Page Factory:** `@FindBy` annotations వాడి cleaner way లో locators define చేయవచ్చు. `PageFactory.initElements(driver, this)` call చేయడం mandatory.

**BaseTest:** Browser setup, teardown common code ని BaseTest లో రాయడం. అన్ని test classes దీన్ని extend చేస్తాయి.

</details>

---

## Data-Driven Testing

### Reading from Excel (Apache POI)

```java
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// ===== ExcelUtils.java — complete utility =====
package utils;

public class ExcelUtils {
    
    private static Workbook workbook;
    private static Sheet sheet;
    
    // Open workbook
    public static void openWorkbook(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
    }
    
    // Set active sheet
    public static void setSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new RuntimeException("Sheet '" + sheetName + "' not found in workbook");
        }
    }
    
    // Get cell value as String (handles all cell types)
    public static String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) return "";
        
        Cell cell = row.getCell(colNum);
        if (cell == null) return "";
        
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }
    
    // Get total rows (excluding header)
    public static int getRowCount() {
        return sheet.getLastRowNum(); // 0-based, row 0 is header
    }
    
    // Get total columns
    public static int getColCount() {
        return sheet.getRow(0).getLastCellNum();
    }
    
    // Read entire sheet as 2D array for DataProvider
    public static Object[][] readTestData(String filePath, String sheetName) throws Exception {
        openWorkbook(filePath);
        setSheet(sheetName);
        
        int rows = getRowCount();      // total rows (excluding header)
        int cols = getColCount();      // total columns
        
        Object[][] data = new Object[rows][cols];
        
        for (int r = 1; r <= rows; r++) {  // start from row 1 (skip header)
            for (int c = 0; c < cols; c++) {
                data[r-1][c] = getCellData(r, c);
            }
        }
        
        workbook.close();
        return data;
    }
    
    // Write test result back to Excel
    public static void writeCellData(String filePath, String sheetName, 
                                      int row, int col, String data) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sh = wb.getSheet(sheetName);
        
        Row r = sh.getRow(row);
        if (r == null) r = sh.createRow(row);
        
        Cell cell = r.createCell(col);
        cell.setCellValue(data);
        
        // Color coding
        CellStyle style = wb.createCellStyle();
        if (data.equals("PASS")) {
            style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        } else if (data.equals("FAIL")) {
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
        }
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        
        FileOutputStream fos = new FileOutputStream(filePath);
        wb.write(fos);
        wb.close();
    }
}
```

**Excel test data format:**

| username | password | expectedResult |
|----------|----------|----------------|
| admin@site.com | admin123 | success |
| user@site.com | user123 | success |
| wrong@site.com | wrongpass | failure |

---

### Reading from Properties File

```java
// ===== config.properties =====
browser=chrome
baseUrl=https://demoqa.com
implicitWait=10
explicitWait=15
screenshotPath=./reports/screenshots/
reportPath=./reports/ExtentReport.html
adminUser=admin@example.com
adminPass=admin123
```

```java
// ===== ConfigReader.java =====
package utils;

import java.util.Properties;
import java.io.FileInputStream;

public class ConfigReader {
    
    private static Properties properties;
    
    static {
        try {
            FileInputStream fis = new FileInputStream(
                "src/test/resources/config.properties"
            );
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("config.properties not found: " + e.getMessage());
        }
    }
    
    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key '" + key + "' not found in config.properties");
        }
        return value.trim();
    }
    
    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
    
    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}

// Usage in tests:
// String url = ConfigReader.get("baseUrl");
// int timeout = ConfigReader.getInt("explicitWait");
```

---

### Reading from JSON

```java
// ===== testdata/users.json =====
// {
//   "validUsers": [
//     {"username": "admin@site.com", "password": "admin123", "role": "admin"},
//     {"username": "user@site.com", "password": "user123", "role": "user"}
//   ],
//   "invalidUsers": [
//     {"username": "wrong@site.com", "password": "wrong", "expectedError": "Invalid credentials"}
//   ]
// }

package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;

public class JsonUtils {
    
    private static ObjectMapper mapper = new ObjectMapper();
    
    public static JsonNode readJson(String filePath) throws Exception {
        return mapper.readTree(new File(filePath));
    }
    
    public static <T> T readJsonAs(String filePath, Class<T> clazz) throws Exception {
        return mapper.readValue(new File(filePath), clazz);
    }
}

// Usage:
// JsonNode data = JsonUtils.readJson("src/test/resources/testdata/users.json");
// JsonNode validUsers = data.get("validUsers");
// for (JsonNode user : validUsers) {
//     String username = user.get("username").asText();
//     String password = user.get("password").asText();
// }
```

<details>
<summary>Required Skill: JDBC Database Testing (Click to learn)</summary>

**Reading Test Data from Database:**

```java
import java.sql.*;

public class DBUtils {
    
    private static Connection connection;
    
    public static void connect(String url, String username, String password) throws Exception {
        // url example: "jdbc:mysql://localhost:3306/testdb"
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Database connected successfully");
    }
    
    public static List<Map<String, String>> executeQuery(String query) throws Exception {
        List<Map<String, String>> results = new ArrayList<>();
        
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData meta = rs.getMetaData();
        int colCount = meta.getColumnCount();
        
        while (rs.next()) {
            Map<String, String> row = new LinkedHashMap<>();
            for (int i = 1; i <= colCount; i++) {
                row.put(meta.getColumnName(i), rs.getString(i));
            }
            results.add(row);
        }
        
        return results;
    }
    
    public static void disconnect() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

// Usage in DataProvider:
// @DataProvider(name = "dbUsers")
// public Object[][] getUsersFromDB() throws Exception {
//     DBUtils.connect("jdbc:mysql://localhost:3306/testdb", "root", "password");
//     List<Map<String, String>> users = DBUtils.executeQuery("SELECT * FROM test_users");
//     Object[][] data = new Object[users.size()][2];
//     for (int i = 0; i < users.size(); i++) {
//         data[i][0] = users.get(i).get("username");
//         data[i][1] = users.get(i).get("password");
//     }
//     return data;
// }
```

**pom.xml dependency:**
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

</details>

---

## Reporting

### ExtentReports — Professional HTML Reports

```java
// ===== ExtentReportListener.java =====
package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;

public class ExtentReportListener implements ITestListener, ISuiteListener {
    
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    @Override
    public void onStart(ISuite suite) {
        // Create reporter
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("E-Commerce Test Suite");
        spark.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
        
        // Create extent
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Automation Team");
    }
    
    @Override
    public void onFinish(ISuite suite) {
        extent.flush(); // write to file
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        // Create test entry in report
        ExtentTest extentTest = extent.createTest(
            result.getMethod().getMethodName(),
            result.getMethod().getDescription()
        );
        test.set(extentTest);
        getTest().log(Status.INFO, "Test Started: " + result.getName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().log(Status.PASS, "Test Passed");
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());
        
        // Attach screenshot
        Object instance = result.getInstance();
        if (instance instanceof base.BaseTest) {
            WebDriver driver = ((base.BaseTest) instance).getDriver();
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
            if (screenshotPath != null) {
                try {
                    getTest().addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
                } catch (Exception e) {
                    getTest().log(Status.WARNING, "Screenshot attachment failed");
                }
            }
        }
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().log(Status.SKIP, "Test Skipped: " + result.getThrowable().getMessage());
    }
    
    public static ExtentTest getTest() {
        return test.get();
    }
}
```

**Logging within test steps:**
```java
// In your test methods:
ExtentReportListener.getTest().log(Status.INFO, "Navigating to login page");
ExtentReportListener.getTest().log(Status.INFO, "Entering username: " + username);
ExtentReportListener.getTest().pass("Login successful");
ExtentReportListener.getTest().fail("Expected element not found");
```

---

## Logging with Log4j

```xml
<!-- src/test/resources/log4j2.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <!-- Console output -->
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        
        <!-- File output -->
        <File name="File" fileName="logs/automation.log" append="true">
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n"/>
        </File>
    </Appenders>
    
    <Loggers>
        <Root level="INFO">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="File"/>
        </Root>
    </Loggers>
</Configuration>
```

```java
// Usage in any class:
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    
    public void enterUsername(String username) {
        log.info("Entering username: " + username);
        usernameField.sendKeys(username);
    }
    
    public void clickLogin() {
        log.info("Clicking login button");
        try {
            loginButton.click();
            log.info("Login button clicked successfully");
        } catch (Exception e) {
            log.error("Failed to click login button: " + e.getMessage());
            throw e;
        }
    }
}
```

<details>
<summary>Required Skill: Git Basics (Click to learn)</summary>

**Git — Version Control for Your Automation Code**

```bash
# Initialize new repository
git init

# Check status
git status

# Add files to staging
git add .                    # add everything
git add src/test/java/       # add specific folder

# Commit
git commit -m "Add login page object model"

# Create branch (for new feature)
git checkout -b feature/add-checkout-tests

# Push to GitHub
git push origin feature/add-checkout-tests

# Pull latest changes
git pull origin main

# Merge branch
git checkout main
git merge feature/add-checkout-tests

# Common .gitignore for Selenium projects
# Add to .gitignore file:
# target/
# *.log
# reports/
# .idea/
# *.class
```

**GitHub Setup:**
1. Create repository on github.com
2. `git remote add origin https://github.com/yourusername/your-repo.git`
3. `git push -u origin main`

**Branch strategy for automation:**
- `main` — stable, working tests
- `develop` — integration branch
- `feature/test-name` — new tests
- `fix/bug-description` — fixing broken tests

</details>

---

## Complete Real Project

### Project: DemoQA E-Commerce Automation Framework

We will build a complete framework for `https://demoqa.com`.

**Complete folder structure:**
```
demoqa-automation/
├── pom.xml
├── src/test/
│   ├── java/
│   │   ├── base/
│   │   │   └── BaseTest.java
│   │   ├── pages/
│   │   │   ├── LoginPage.java
│   │   │   ├── ProfilePage.java
│   │   │   └── BookStorePage.java
│   │   ├── tests/
│   │   │   ├── LoginTest.java
│   │   │   ├── BookStoreTest.java
│   │   │   └── ProfileTest.java
│   │   ├── utils/
│   │   │   ├── ConfigReader.java
│   │   │   ├── ExcelUtils.java
│   │   │   └── ScreenshotUtils.java
│   │   └── listeners/
│   │       └── ExtentReportListener.java
│   └── resources/
│       ├── testng.xml
│       ├── config.properties
│       └── testdata/
│           └── LoginData.xlsx
└── reports/
```

**config.properties:**
```properties
browser=chrome
baseUrl=https://demoqa.com
explicitWait=15
username=testuser123
password=Test@1234
reportPath=reports/ExtentReport.html
screenshotPath=reports/screenshots/
```

**LoginPage.java:**
```java
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(id = "userName")       private WebElement usernameInput;
    @FindBy(id = "password")       private WebElement passwordInput;
    @FindBy(id = "login")          private WebElement loginButton;
    @FindBy(id = "name")           private WebElement loggedInUserName;
    @FindBy(css = ".mb-1")         private WebElement errorText;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    
    public void navigateToLoginPage() {
        driver.get(ConfigReader.get("baseUrl") + "/login");
    }
    
    public void enterCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    
    public void clickLoginButton() {
        loginButton.click();
    }
    
    public String getLoggedInUser() {
        return wait.until(ExpectedConditions.visibilityOf(loggedInUserName)).getText();
    }
    
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorText)).getText();
    }
    
    public boolean isLoginButtonPresent() {
        return !driver.findElements(By.id("login")).isEmpty();
    }
}
```

**LoginTest.java:**
```java
package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.*;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {
    
    private LoginPage loginPage;
    
    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();
    }
    
    @Test(description = "Valid login should take user to profile page",
          groups = {"smoke", "regression"})
    public void testValidLogin() {
        loginPage.enterCredentials(
            ConfigReader.get("username"),
            ConfigReader.get("password")
        );
        loginPage.clickLoginButton();
        
        String loggedUser = loginPage.getLoggedInUser();
        Assert.assertNotNull(loggedUser, "User should be logged in");
        Assert.assertEquals(loggedUser, ConfigReader.get("username"), "Username mismatch");
    }
    
    @Test(description = "Invalid login should show error message",
          groups = {"regression"})
    public void testInvalidLogin() {
        loginPage.enterCredentials("wrong@email.com", "wrongpassword");
        loginPage.clickLoginButton();
        
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Invalid"), 
            "Error message should say Invalid. Actual: " + error);
    }
    
    @Test(description = "Data-driven login test",
          dataProvider = "loginData",
          groups = {"regression"})
    public void testLoginDataDriven(String username, String password, 
                                     boolean shouldPass, String expectedMsg) {
        loginPage.enterCredentials(username, password);
        loginPage.clickLoginButton();
        
        if (shouldPass) {
            Assert.assertNotNull(loginPage.getLoggedInUser(), "Should be logged in");
        } else {
            String error = loginPage.getErrorMessage();
            Assert.assertTrue(error.contains(expectedMsg), 
                "Error should contain: " + expectedMsg);
        }
    }
    
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {
        return ExcelUtils.readTestData(
            "src/test/resources/testdata/LoginData.xlsx", 
            "LoginTests"
        );
    }
}
```

**testng.xml:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="DemoQA Suite" parallel="tests" thread-count="2" verbose="1">

    <parameter name="browser" value="chrome"/>
    
    <listeners>
        <listener class-name="listeners.ExtentReportListener"/>
    </listeners>
    
    <test name="Smoke Tests">
        <groups>
            <run><include name="smoke"/></run>
        </groups>
        <classes>
            <class name="tests.LoginTest"/>
        </classes>
    </test>
    
    <test name="Regression Tests">
        <groups>
            <run>
                <include name="regression"/>
            </run>
        </groups>
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.BookStoreTest"/>
            <class name="tests.ProfileTest"/>
        </classes>
    </test>
    
</suite>
```

**Run commands:**
```bash
# Run all tests
mvn clean test

# Run only smoke
mvn clean test -Dgroups=smoke

# Run on Firefox
mvn clean test -Dbrowser=firefox

# Run in headless mode
mvn clean test -Dheadless=true
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Complete Framework Summary:**

ఈ real project లో మనం నేర్చుకున్నది అంతా వాడాం:

**1. BaseTest** — Browser setup/teardown common code. అన్ని tests extend చేస్తాయి.

**2. LoginPage (POM)** — @FindBy తో locators, methods తో actions. Test class directly elements touch చేయదు.

**3. LoginTest** — Tests మాత్రమే. Page objects use చేస్తాయి, assertions run చేస్తాయి.

**4. ConfigReader** — config.properties నుండి browser, URL, credentials చదువుతుంది.

**5. ExcelUtils** — Excel నుండి test data చదువుతుంది — DataProvider తో pass చేస్తుంది.

**6. ExtentReportListener** — Test pass/fail automatically report చేస్తుంది, screenshots attach చేస్తుంది.

**7. testng.xml** — Smoke vs Regression separate groups, parallel execution.

**8. pom.xml** — All dependencies, Surefire plugin for `mvn test` command.

ఇది interview లో "మీ framework describe చేయండి" అని అడిగినప్పుడు confidently explain చేయగలరు.

</details>

---

## Practical Projects

### Project 1: Login + Dashboard Validation Framework
**Goal:** Build complete POM framework for a login → dashboard → profile flow.

```
Structure:
├── LoginPage — login form interaction
├── DashboardPage — verify widgets, links visible
├── ProfilePage — verify and update profile info
Tests:
├── Valid login → verify dashboard loads
├── Invalid login → verify error messages (data-driven with 5 scenarios)
├── Logout → verify redirected to login
├── Login → update profile → verify changes persisted
└── Session timeout simulation → verify redirect to login
```

---

### Project 2: Product Search and Filter Test Suite
**Goal:** Data-driven tests for search + filter functionality.

```
SearchPage.java (POM)
├── search(keyword)
├── filterByCategory(category)
├── sortBy(option)
├── getResultCount()
└── getFirstResultTitle()

Test data from Excel:
├── keyword | category | sortBy | expectedMinResults | expectedTitle
SearchTest.java:
├── testSearchByKeyword (data-driven — 5 keywords)
├── testFilterResults (data-driven — 3 categories)
├── testSortingOrder (data-driven — price asc/desc, name)
└── testNoResults (edge case — gibberish search term)
```

---

### Project 3: Form Validation Suite
**Goal:** Test all validation rules for a complex registration form.

```
Registration form fields: name, email, phone, DOB, address, file upload

RegFormPage.java:
├── All @FindBy fields for each input
├── Methods for each field
├── Submit form
├── Get specific field error message
└── isFormSubmittedSuccessfully()

Test data: 15 scenarios covering:
├── All valid data → success
├── Invalid email format → specific error
├── Phone less than 10 digits → specific error
├── Missing required fields → specific errors
├── File too large → specific error
└── Special characters in name → behavior verification
```

---

### Project 4: E-Commerce Cart and Checkout Automation
**Goal:** End-to-end test of add-to-cart → checkout flow.

```
Pages: ProductListPage, ProductDetailPage, CartPage, CheckoutPage, OrderConfirmationPage

Flow:
1. Login
2. Search product
3. Add to cart (3 different products)
4. Go to cart — verify item count, prices
5. Apply coupon code — verify discount
6. Proceed to checkout
7. Fill shipping details (from JSON test data)
8. Select payment method
9. Place order
10. Verify order confirmation number
11. Verify email notification received (check inbox page)
```

---

### Project 5: Cross-Feature Regression Suite
**Goal:** Build a comprehensive regression testng.xml that covers all modules.

```
testng.xml with:
├── suite parallel="tests" thread-count="3"
├── SmokeTests (5 critical tests)
├── LoginModule (10 tests)
├── SearchModule (8 tests)
├── CartModule (7 tests)
├── CheckoutModule (6 tests)
└── ProfileModule (5 tests)

Features:
├── Each test has group tags: smoke, regression, critical, wip
├── Screenshots on failure (Listener)
├── ExtentReport with all test results
├── Excel test data for all data-driven tests
├── config.properties for all environments (QA, UAT)
└── Maven profiles: smoke, regression, full
```

---

> **Part 4 Complete.** You now have the full skill set to build a professional automation framework from scratch. The Page Object Model, TestNG, Maven, Data-Driven testing, and reporting tools covered here are what every senior automation engineer uses daily.

> **Next:** Part 5 covers the expert topics — Grid, CI/CD, Flaky Tests, Debugging, and everything you need to ace interviews and build a career.
