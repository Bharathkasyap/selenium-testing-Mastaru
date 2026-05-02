# Selenium Practice Part 1 - Setup Guide

## Welcome!

This guide will walk you through setting up your environment to run the Selenium practice scenarios. Follow these steps **once** before starting the scenarios.

---

## Prerequisites

Before you begin, make sure you have the following installed on your machine:

### 1. Install Java 11 (JDK)

**Windows:**
1. Download JDK 11 from [Adoptium](https://adoptium.net/)
2. Run the installer and follow the prompts
3. Set JAVA_HOME environment variable:
   - Right-click "This PC" > Properties > Advanced system settings
   - Click "Environment Variables"
   - Add new System Variable: `JAVA_HOME` = `C:\Program Files\Eclipse Adoptium\jdk-11.x.x`
   - Add `%JAVA_HOME%\bin` to the `Path` variable
4. Verify: Open Command Prompt and run `java -version`

**Mac:**
```bash
brew install openjdk@11
export JAVA_HOME=/opt/homebrew/opt/openjdk@11
```

**Linux:**
```bash
sudo apt install openjdk-11-jdk
```

### 2. Install Maven

**Windows:**
1. Download Maven from [Apache Maven](https://maven.apache.org/download.cgi)
2. Extract to `C:\Program Files\Apache\maven`
3. Set MAVEN_HOME = `C:\Program Files\Apache\maven`
4. Add `%MAVEN_HOME%\bin` to `Path`
5. Verify: `mvn -version`

**Mac:**
```bash
brew install maven
```

**Linux:**
```bash
sudo apt install maven
```

### 3. Install Git

Download from [git-scm.com](https://git-scm.com/downloads) and follow the installer. Verify: `git --version`

### 4. Install an IDE (Choose one)

- **IntelliJ IDEA** (Recommended) - [Download Community Edition (Free)](https://www.jetbrains.com/idea/download/)
- **VS Code** with Java Extension Pack - [Download](https://code.visualstudio.com/)
- **Eclipse** with Maven plugin - [Download](https://www.eclipse.org/downloads/)

---

## Clone and Setup the Project

### Step 1: Fork the Repository

1. Go to [selenium-testing-Mastaru](https://github.com/Bharathkasyap/selenium-testing-Mastaru)
2. Click **Fork** button in the top-right
3. This creates your own copy of the repository

### Step 2: Clone Your Fork

```bash
git clone https://github.com/YOUR-USERNAME/selenium-testing-Mastaru.git
cd selenium-testing-Mastaru/Part1/selenium-practice-webapp
```

### Step 3: Install Dependencies

```bash
mvn clean install
```

This downloads all required libraries (Selenium, TestNG, WebDriverManager, Log4j).

### Step 4: Open in IDE

**IntelliJ IDEA:**
- File > Open > select the `pom.xml` file
- IntelliJ will automatically detect Maven project

**VS Code:**
- Open the `selenium-practice-webapp` folder
- Install "Extension Pack for Java" if not already installed
- VS Code will detect Maven project automatically

---

## Verify Setup

Run a quick test to make sure everything works:

```bash
mvn test
```

This runs all 5 scenarios. They will **fail** because the test methods contain TODO placeholders - this is expected!

---

## Project Structure

```
selenium-practice-webapp/
├── pom.xml              # Maven configuration
├── testng.xml           # TestNG suite configuration
├── SCENARIOS.md         # All scenario descriptions
├── SETUP-GUIDE.md       # This file
├── src/main/java/
│   └── com/seleniumlearning/part1/
│       ├── Scenario1LoginTest.java
│       ├── Scenario2FormFillingTest.java
│       ├── Scenario3NavigationTest.java
│       ├── Scenario4AlertHandlingTest.java
│       ├── Scenario5AdvancedTest.java
│       └── utils/
│           ├── DriverManager.java
│           └── WaitHelper.java
└── src/test/java/       # (Optional) Solution files go here
```

---

## How to Work on Scenarios

1. **Read** `SCENARIOS.md` to understand the requirements
2. **Open** the corresponding Java file in `src/main/java`
3. **Replace** the `logger.info("TODO: ...")` lines with your actual Selenium code
4. **Run** the test using Maven or IDE
5. **Compare** with solutions when available in `src/test/java`

---

## Running Individual Scenarios

```bash
# Scenario 1 - Login
mvn test -Dtest=Scenario1LoginTest

# Scenario 2 - Form Filling
mvn test -Dtest=Scenario2FormFillingTest

# Scenario 3 - Navigation
mvn test -Dtest=Scenario3NavigationTest

# Scenario 4 - Alert Handling
mvn test -Dtest=Scenario4AlertHandlingTest

# Scenario 5 - Advanced
mvn test -Dtest=Scenario5AdvancedTest
```

---

## Common Issues

### "java is not recognized"
- Make sure JAVA_HOME is set correctly
- Add Java bin folder to PATH

### "mvn is not recognized"
- Make sure MAVEN_HOME is set correctly
- Add Maven bin folder to PATH

### "ChromeDriver not found"
- WebDriverManager handles this automatically
- Just make sure you have an internet connection for the first run

### "Test failed with timeout"
- The practice website URL might need updating
- Check if the website is accessible
- Increase timeout values in WaitHelper if needed

---

## Next Steps

Once setup is complete:
1. Read `Part 1 Foundations.md` for theory
2. Open `SCENARIOS.md` for practice requirements
3. Start coding in the scenario Java files
4. Good luck and happy testing!
