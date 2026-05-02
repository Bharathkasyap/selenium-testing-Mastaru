# Selenium Practice - Part 1: Web Automation with Selenium WebDriver

## What is this project?

This is a hands-on learning project where you practice Selenium WebDriver automation through 5 real-world scenarios.

### What's inside?

- 5 practice scenarios (Login, Form Filling, Navigation, Alert Handling, Advanced Workflow)
- Pre-built utility classes (DriverManager, WaitHelper)
- Maven/Java project structure ready to run
- Bilingual support: English + Telugu (expand dropdowns for Telugu translation)

<details>
<summary><strong>తెలుగులో చదవడానికి ఇక్కడ క్లిక్ చేయండి | Click here to read in Telugu</strong></summary>

### ఇది ఏమిటి?

ఇది 5 వాస్తవ ప్రపంచ సన్నివేశాల ద్వారా Selenium WebDriver ఆటోమేషన్‌ను ప్రాక్టీస్ చేయడానికి రూపొందించిన ప్రాక్టికల్ లెర్నింగ్ ప్రాజెక్ట్.

### వీటిలో ఏమేమి ఉన్నాయి?

- 5 ప్రాక్టీస్ సన్నివేశాలు (లాగిన్, ఫారం ఫిల్లింగ్, నావిగేషన్, అలర్ట్ హ్యాండిలింగ్, అడ్వాన్స్డ్ వర్క్‌ఫ్లో)
- ముందే తయారైన సహాయక క్లాసెస్ (DriverManager, WaitHelper)
- Maven/Java ప్రాజెక్ట్ నిర్మాణం
- ద్విభాషా మద్దతు: ఇంగ్లీష్ + తెలుగు (తెలుగు అనువాదానికి డ్రాప్‌డౌన్‌లు విస్తరించండి)
</details>

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

<details>
<summary><strong>తెలుగులో వివరణ | Telugu explanation</strong></summary>

```bash
# 1. ఈ రిపోజిటరీని Fork చేయండి
# 2. మీ Fork ను Clone చేయండి
git clone https://github.com/YOUR-USERNAME/selenium-testing-Mastaru.git
cd selenium-testing-Mastaru/Part1/selenium-practice-webapp

# 3. అవసరమైన లైబ్రరీలను ఇన్‌స్టాల్ చేయండి
mvn clean install

# 4. సన్నివేశాలను చదవండి
cat SCENARIOS.md

# 5. టెస్టులను రన్ చేయండి
mvn test
```

**అర్థం:**
- **Fork** = మీ GitHub ఖాతాలోకి కాపీ చేయడం
- **Clone** = మీ కంప్యూటర్‌కు డౌన్‌లోడ్ చేయడం
- **mvn clean install** = అవసరమైన లైబ్రరీలను డౌన్‌లోడ్ చేయడం
- **mvn test** = టెస్టులను రన్ చేయడం
</details>

---
## What You'll Learn

By completing all 5 scenarios, you'll master Selenium WebDriver automation skills step by step.

<details>
<summary><strong>తెలుగులో వివరణ | Telugu explanation</strong></summary>

**మీరు ఏమి నేర్చుకుంటారు?** 5 సన్నివేశాలను పూర్తి చేయడం ద్వారా, మీరు Selenium WebDriver ఆటోమేషన్ నైపుణ్యాలను దశవారీగా నేర్చుకుంటారు.
</details>

| Scenario | Skill | Description |
|----------|-------|-------------|
| **1. Login Test** | Basic WebDriver | Navigate, find elements, input text, click buttons, verify results |
| **2. Form Filling** | Form Interaction | Fill multi-field forms, handle dropdowns, submit and verify |
| **3. Navigation** | Page Navigation | Navigate between pages, verify page loads, check links |
| **4. Alert Handling** | Alert Management | Handle JavaScript alerts, confirmations, and prompts |
| **5. Advanced Workflow** | End-to-End Testing | Complete multi-step CRUD workflow with create, read, update, logout |

<details>
<summary><strong>తెలుగులో వివరణ | Telugu explanation</strong></summary>

| సన్నివేశం | నైపుణ్యం | వివరణ |
|------------|------------|---------|
| **1. లాగిన్ టెస్ట్** | ప్రాథమిక WebDriver | బ్రౌజర్ తెరవడం, లాగిన్ పేజీలో ఎలిమెంట్లను కనుగొనడం, టెక్స్ట్ ఎంటర్ చేయడం, బటన్ క్లిక్ చేయడం |
| **2. ఫారం ఫిల్లింగ్** | ఫారం ఇంటరాక్షన్ | ఫారం ఫీల్డ్లను పూరించడం, డ్రాప్‌డౌన్ మెనూలను ఎంచుకోవడం, సబ్మిట్ చేయడం |
| **3. నావిగేషన్** | పేజీ నావిగేషన్ | వేర్వేరు పేజీల మధ్య నావిగేట్ చేయడం, పేజీ లోడ్ అయ్యిందో లేదో ధృవీకరించడం |
| **4. అలర్ట్ హ్యాండిలింగ్** | అలర్ట్ మేనేజ్‌మెంట్ | బ్రౌజర్ పాప్‌అప్ అలర్ట్‌లను, కన్ఫర్మేషన్ డైలాగ్‌లను హ్యాండిల్ చేయడం |
| **5. అడ్వాన్స్డ్ వర్క్‌ఫ్లో** | ఎండ్-టు-ఎండ్ టెస్టింగ్ | లాగిన్, క్రియేట్, ఎడిట్, సేవ్, లాగౌట్ - పూర్తి వర్క్‌ఫ్లోను ఆటోమేట్ చేయడం |
</details>

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

<details>
<summary><strong>తెలుగులో వివరణ | Telugu explanation</strong></summary>

**ప్రాజెక్ట్ నిర్మాణం:** ఈ జాబితా మీ ప్రాజెక్ట్ ఫోల్డర్‌లో ఏమేమి ఉంటాయో చూపిస్తుంది. పై నిర్మాణం మీకు సహాయపడుతుంది.
</details>

---
## How It Works

### Step 1: Read the Theory
Start by reading [Part 1 Foundations.md](../Foundations.md) to understand Selenium concepts.

### Step 2: Read the Scenarios
Open [SCENARIOS.md](SCENARIOS.md) to see all 5 practice scenarios with detailed requirements.

### Step 3: Code Your Solutions
Each scenario file has TODO markers. Replace them with actual Selenium code.

### Step 4: Run & Verify
Run `mvn test` and watch your Selenium tests execute.

### Step 5: Compare with Solutions
Compare your approach with reference solutions in `src/test/java`.

<details>
<summary><strong>తెలుగులో వివరణ | Telugu explanation</strong></summary>

### దశ 1: సిద్ధాంతాన్ని చదవండి
[Part 1 Foundations.md](../Foundations.md) చదివి Selenium భావనలను అర్థం చేసుకోండి.

### దశ 2: సన్నివేశాలను చదవండి
[SCENARIOS.md](SCENARIOS.md) తెరిచి 5 ప్రాక్టీస్ సన్నివేశాలను వాటి పూర్తి వివరాలతో చూడండి.

### దశ 3: మీ పరిష్కారాలను కోడ్ చేయండి
ప్రతి సన్నివేశం ఫైల్‌లో TODO గుర్తులు ఉంటాయి. వాటిని నిజమైన Selenium కోడ్‌తో భర్తీ చేయండి.

### దశ 4: రన్ చేయండి మరియు ధృవీకరించండి
`mvn test` రన్ చేసి మీ Selenium టెస్టులు ఎలా అమలవుతున్నాయో గమనించండి.

### దశ 5: పరిష్కారాలతో పోల్చండి
మీ విధానాన్ని `src/test/java`లో ఉన్న రిఫరెన్స్ పరిష్కారాలతో పోల్చండి.
</details>

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

<details>
<summary><strong>తెలుగులో వివరణ | Telugu explanation</strong></summary>

| సాంకేతికత | వెర్షన్ | ఉపయోగం |
|------------|-----------|------------|
| Selenium WebDriver | 4.15.0 | బ్రౌజర్‌ను ఆటోమేట్ చేయడానికి |
| TestNG | 7.8.1 | టెస్టులను నిర్వహించడానికి |
| WebDriverManager | 5.6.3 | బ్రౌజర్ డ్రైవర్లను ఆటోమేటిక్‌గా డౌన్‌లోడ్ చేయడానికి |
| Log4j | 2.20.0 | లాగ్‌లను నమోదు చేయడానికి |
| Maven | 3.6+ | ప్రాజెక్ట్‌ను బిల్డ్ చేయడానికి |
| Java | 11+ | ప్రోగ్రామింగ్ భాష |
</details>

---
## Utilities Provided

### DriverManager
```java
WebDriver driver = DriverManager.getDriver();  // Get browser driver
DriverManager.closeDriver();                    // Close browser
```

### WaitHelper
```java
WebElement element = WaitHelper.waitForElement(driver, By.id("username"), 10);
WebElement clickable = WaitHelper.waitForElementClickable(driver, By.id("submit"), 10);
WaitHelper.waitForElementWithText(driver, By.id("message"), "Success", 10);
```

<details>
<summary><strong>తెలుగులో వివరణ | Telugu explanation</strong></summary>

### DriverManager
```java
WebDriver driver = DriverManager.getDriver();  // బ్రౌజర్ డ్రైవర్ పొందండి
DriverManager.closeDriver();                    // బ్రౌజర్ మూసివేయండి
```

### WaitHelper
```java
WebElement element = WaitHelper.waitForElement(driver, By.id("username"), 10);
WebElement clickable = WaitHelper.waitForElementClickable(driver, By.id("submit"), 10);
WaitHelper.waitForElementWithText(driver, By.id("message"), "Success", 10);
```

**అర్థం:** ఈ క్లాసెస్ మీకు WebDriver నిర్వహణ మరియు ఎలిమెంట్ కోసం వెయిట్ చేయడానికి సహాయపడతాయి.
</details>

---

## Running Tests

| Command | Description |
|---------|-------------|
| `mvn test` | Run all scenarios |
| `mvn test -Dtest=Scenario1LoginTest` | Run specific scenario |
| `mvn test -X` | Run with debug output |
| `mvn clean install` | Install dependencies |

<details>
<summary><strong>తెలుగులో వివరణ | Telugu explanation</strong></summary>

| ఆదేశం | వివరణ |
|-----------|------------|
| `mvn test` | అన్ని సన్నివేశాలను రన్ చేయండి |
| `mvn test -Dtest=Scenario1LoginTest` | నిర్దిష్ట సన్నివేశాన్ని రన్ చేయండి |
| `mvn test -X` | డీబగ్ అవుట్‌పుట్‌తో రన్ చేయండి |
| `mvn clean install` | అవసరమైన లైబ్రరీలను ఇన్‌స్టాల్ చేయండి |
</details>

---

## Practice Websites

- Primary: `https://practice.automationbro.com`
- Alternative: `https://phptravels.com`
- Alternative: `https://demoqa.com`
- Alternative: `https://letskodeit.teachable.com`

<details>
<summary><strong>తెలుగులో వివరణ | Telugu explanation</strong></summary>

**ప్రాక్టీస్ వెబ్‌సైట్లు:** ఈ వెబ్‌సైట్లు ఫ్రీగా ఉంటాయి మరియు ప్రాక్టీస్ చేయడానికి పూర్తిగా సురక్షితమైనవి.

- ప్రధాన: `https://practice.automationbro.com`
- ప్రత్యామ్నాయ: `https://phptravels.com`
- ప్రత్యామ్నాయ: `https://demoqa.com`
- ప్రత్యామ్నాయ: `https://letskodeit.teachable.com`
</details>

---

<details>
<summary><strong>🚨 Common Issues & Solutions | సాధారణ సమస్యలు మరియు పరిష్కారాలు</strong></summary>

### "java is not recognized"
- Make sure JAVA_HOME is set correctly
- Add Java bin folder to PATH

### "mvn is not recognized"
- Make sure MAVEN_HOME is set correctly
- Add Maven bin folder to PATH

### "Test failed with timeout"
- The practice website URL might need updating
- Increase timeout values in WaitHelper

<details>
<summary><strong>తెలుగులో పరిష్కారాలు | Solutions in Telugu</strong></summary>

### "java is not recognized" (java గుర్తించబడలేదు)
- JAVA_HOME సరిగ్గా సెట్ చేయబడిందో లేదో చూడండి
- Java bin ఫోల్డర్‌ను PATHలో జోడించండి

### "mvn is not recognized" (mvn గుర్తించబడలేదు)
- MAVEN_HOME సరిగ్గా సెట్ చేయబడిందో లేదో చూడండి
- Maven bin ఫోల్డర్‌ను PATHలో జోడించండి

### "టెస్ట్ టైమ్ ఔట్‌తో విఫలమైంది"
- ప్రాక్టీస్ వెబ్‌సైట్ URL అప్‌డేట్ అవసరం కావచ్చు
- WaitHelperలో టైమ్‌అవుట్ విలువలను పెంచండి
</details>
</details>

---

## Contribution

Feel free to contribute to this project:

1. **Fork** this repository
2. **Improve** scenario files
3. **Add** more test cases
4. **Submit** a Pull Request

<details>
<summary><strong>తెలుగులో వివరణ | Telugu explanation</strong></summary>

**సహకారం:** ఈ ప్రాజెక్ట్‌కు సహకరించడానికి:

1. **Fork** - ఈ రిపోజిటరీని ఫోర్క్ చేయండి
2. **Improve** - సన్నివేశ ఫైల్లను మెరుగుపరచండి
3. **Add** - ఎక్కువ టెస్ట్ కేసులను జోడించండి
4. **Submit** - పూల్ రిక్వెస్ట్ సమర్పించండి
</details>

---

## License

This project is open source and available for learning purposes.

## Author

Created by Bharathkasyap as part of the Selenium Mastery course.
Part of [selenium-testing-Mastaru](https://github.com/Bharathkasyap/selenium-testing-Mastaru) repository.

---

**Happy Testing!** 🚀
