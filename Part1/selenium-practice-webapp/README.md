# Selenium Practice - Part 1: Web Automation with Selenium WebDriver

## Selenium Selenium WebDriver Practice - Part 1
### You are learning to automate a browser using Selenium WebDriver!
### మీరు Selenium WebDriver ఉపయోగించి బ్రౌజర్‌ను ఆటోమేట్ చేయడం నేర్చుకుంటున్నారు!

---

## Welcome | మీకు స్వాగతం

Welcome to the **Selenium Practice Part 1 Web App**! This is a hands-on learning project where you practice Selenium automation through 5 real-world scenarios.

**Selenium Practice Part 1 Web App** కు స్వాగతం! ఇది 5 వాస్తవ ప్రపంచ సన్నివేశాల (scenarios) ద్వారా Selenium automaion ను అభ్యసించడానికి రూపొందించిన ప్రాక్టికల్ లెర్నింగ్ ప్రాజెక్ట్.

> Note: You can also view this content as a beautiful web page. Click the link above to open it in your browser.
> గమనిక: ఈ కంటెంట్‌ను అందమైన వెబ్ పేజీగా కూడా చూడవచ్చు. పైన లింక్ క్లిక్ చేసి బ్రౌజర్‌లో తెరవవచ్చు.

[View as Web Page](#) (Open in browser) | [Open in Telugu](#) (తెలుగులో చూడండి)

---

<details>
<summary><strong>🚀 Quick Start | త్వరగా ప్రారంభించండి (Click to expand)</strong></summary>

### English:
```bash
# 1. Fork this repository
github.com links

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

### తెలుగు:
```bash
# 1. ఈ రిపోజిటరీని Fork చేయండి
github.com లింక్‌లు

# 2. మీ Fork ను Clone చేయండి
git clone https://github.com/YOUR-USERNAME/selenium-testing-Mastaru.git
cd selenium-testing-Mastaru/Part1/selenium-practice-webapp

# 3. అవసరమైన లైబ్రరీలను ఇన్‌స్టాల్ చేయండి
mvn clean install

# 4. సన్నివేశాలను (scenarios) చదవండి
cat SCENARIOS.md

# 5. టెస్టులను రన్ చేయండి
mvn test
```
</details>

---
## What You'll Learn | మీరు ఏమి నేర్చుకుంటారు

By completing all 5 scenarios, you'll master Selenium WebDriver automation skills step by step.

5 సన్నివేశాలను పూర్తి చేయడం ద్వారా, మీరు Selenium WebDriver ఆటోమేషన్ నైపుణ్యాలను దశవారీగా నేర్చుకుంటారు.

<details>
<summary><strong>Click here to see all 5 scenarios | అన్ని 5 సన్నివేశాల కోసం ఇక్కడ క్లిక్ చేయండి</strong></summary>

| Scenario | Skill | Description (English) | వివరణ (తెలుగు) |
|----------|-------|----------------------|----------------------|
| **1. Login Test** | Basic WebDriver | Navigate, find elements, input text, click buttons, verify results | బ్రౌజర్ తెరవడం, లాగిన్ పేజీలో ఎలిమెంట్లను కనుగొనడం, టెక్స్ట్ ఎంటర్ చేయడం, బటన్ క్లిక్ చేయడం |
| **2. Form Filling** | Form Interaction | Fill multi-field forms, handle dropdowns, submit and verify | ఫారం ఫీల్డ్లను పూరించడం, డ్రాప్‌డౌన్ మెనూలను ఎంచుకోవడం, సబ్మిట్ చేయడం |
| **3. Navigation** | Page Navigation | Navigate between pages, verify page loads, check links | వేర్వేరు పేజీల మధ్య నావిగేట్ చేయడం, పేజీ లోడ్ అయ్యిందో లేదో ధృవీకరించడం |
| **4. Alert Handling** | Alert Management | Handle JavaScript alerts, confirmations, and prompts | బ్రౌజర్ పాప్‌అప్ అలర్ట్‌లను, కన్ఫర్మేషన్ డైలాగ్‌లను హ్యాండిల్ చేయడం |
| **5. Advanced Workflow** | End-to-End Testing | Complete multi-step CRUD workflow with create, read, update, logout | ఒక పూర్తి వర్క్‌ఫ్లోను ఆటోమేట్ చేయడం - లాగిన్, క్రియేట్, ఎడిట్, సేవ్, లాగౌట్ |
</details>

---

<details>
<summary><strong>📁 Project Structure | ప్రాజెక్ట్ నిర్మాణం (Click to expand)</strong></summary>

```
selenium-practice-webapp/
├── pom.xml              # Maven dependencies (అవసరమైన లైబ్రరీలు)
├── testng.xml           # Test suite configuration (టెస్ట్ సూట్ అమరిక)
├── SCENARIOS.md         # All scenario descriptions (అన్ని సన్నివేశాల వివరణ)
├── SETUP-GUIDE.md       # Environment setup instructions (సెటప్ గైడ్)
├── README.md            # This file (ఈ ఫైల్)
└── src/main/java/com/seleniumlearning/part1/
    ├── Scenario1LoginTest.java       # Login test skeleton
    ├── Scenario2FormFillingTest.java # Form filling skeleton
    ├── Scenario3NavigationTest.java  # Navigation skeleton
    ├── Scenario4AlertHandlingTest.java # Alert handling skeleton
    ├── Scenario5AdvancedTest.java    # Advanced workflow skeleton
    └── utils/
        ├── DriverManager.java   # WebDriver manager (బ్రౌజర్ మేనేజర్)
        └── WaitHelper.java      # Wait utilities (వెయిటింగ్ టూల్స్)
```
</details>

---
## How It Works | ఎలా పనిచేస్తుంది

<details>
<summary><strong>Step-by-step flow | దశవారీ విధానాన్ని తెలుసుకోండి (Click to expand)</strong></summary>

### Step 1: Read the Theory | సిద్ధాంతాన్ని చదవండి

**English:** Start by reading [Part 1 Foundations.md](../Foundations.md) to understand Selenium concepts.

**తెలుగు:** [Part 1 Foundations.md](../Foundations.md) చదివి Selenium భావనలను అర్థం చేసుకోండి.

---

### Step 2: Read the Scenarios | సన్నివేశాలను చదవండి

**English:** Open [SCENARIOS.md](SCENARIOS.md) to see all 5 practice scenarios with detailed requirements.

**తెలుగు:** [SCENARIOS.md](SCENARIOS.md) తెరిచి 5 ప్రాక్టీస్ సన్నివేశాలను వాటి పూర్తి వివరాలతో చూడండి.

---

### Step 3: Code Your Solutions | మీ పరిష్కారాలను కోడ్ చేయండి

**English:** Each scenario file has TODO markers. Replace them with actual Selenium code.

**తెలుగు:** ప్రతి సన్నివేశం ఫైల్‌లో TODO గుర్తులు ఉంటాయి. వాటిని నిజమైన Selenium కోడ్‌తో భర్తీ చేయండి.

---

### Step 4: Run & Verify | రన్ చేయండి మరియు ధృవీకరించండి

**English:** Run `mvn test` and watch your Selenium tests execute.

**తెలుగు:** `mvn test` రన్ చేసి మీ Selenium టెస్టులు ఎలా అమలవుతున్నాయో గమనించండి.

---

### Step 5: Compare with Solutions | పరిష్కారాలతో పోల్చండి

**English:** Compare your approach with reference solutions in `src/test/java`.

**తెలుగు:** మీ విధానాన్ని `src/test/java`లో ఉన్న రిఫరెన్స్ పరిష్కారాలతో పోల్చండి.

</details>

---

## Technology Stack | సాంకేతికతలు

<details>
<summary><strong>Click to see technology details | సాంకేతిక వివరాల కోసం క్లిక్ చేయండి</strong></summary>

| Technology | Version | Purpose | వివరణ (తెలుగు) |
|------------|---------|---------|----------------------|
| **Selenium WebDriver** | 4.15.0 | Browser automation | బ్రౌజర్‌ను ఆటోమేట్ చేయడానికి |
| **TestNG** | 7.8.1 | Testing framework | టెస్టులను నిర్వహించడానికి |
| **WebDriverManager** | 5.6.3 | Auto-downloads drivers | బ్రౌజర్ డ్రైవర్లను ఆటోమేటిక్‌గా డౌన్‌లోడ్ చేయడానికి |
| **Log4j** | 2.20.0 | Logging | లాగ్‌లను నమోదు చేయడానికి |
| **Maven** | 3.6+ | Build tool | ప్రాజెక్ట్‌ను బిల్డ్ చేయడానికి |
| **Java** | 11+ | Programming language | ప్రోగ్రామింగ్ భాష |
</details>

---
<details>
<summary><strong>🔧 Utilities Provided | అందించిన సహాయక టూల్స్ (Click to expand)</strong></summary>

### DriverManager

**English:** Manages WebDriver lifecycle - automatically initializes Chrome/Firefox drivers.

**తెలుగు:** WebDriver జీవిత చక్రాన్ని నిర్వహిస్తుంది - Chrome లేదా Firefox డ్రైవర్లను ఆటోమేటిక్‌గా ప్రారంభిస్తుంది.

```java
WebDriver driver = DriverManager.getDriver();  // Get driver | డ్రైవర్ పొందండి
DriverManager.closeDriver();                    // Close driver | డ్రైవర్ మూసివేయండి
```

### WaitHelper

**English:** Provides explicit wait methods for handling dynamic content.

**తెలుగు:** డైనమిక్ కంటెంట్‌ను హ్యాండిల్ చేయడానికి ఎక్స్‌ప్లిసిట్ వెయిట్ మెథడ్లను అందిస్తుంది.

```java
// Wait for element | ఎలిమెంట్ కోసం వెయిట్ చేయండి
WebElement element = WaitHelper.waitForElement(driver, By.id("username"), 10);

// Wait for clickable | క్లిక్ చేయగలిగే ఎలిమెంట్ కోసం వెయిట్ చేయండి
WebElement clickable = WaitHelper.waitForElementClickable(driver, By.id("submit"), 10);

// Wait for text | టెక్స్ట్ కోసం వెయిట్ చేయండి
WaitHelper.waitForElementWithText(driver, By.id("message"), "Success", 10);
```
</details>

---

## Running Tests | టెస్టులను రన్ చేయడం

<details>
<summary><strong>Click to see all Maven commands | అన్ని Maven ఆదేశాల కోసం క్లిక్ చేయండి</strong></summary>

| Command | Description | వివరణ (తెలుగు) |
|---------|-------------|----------------------|
| `mvn test` | Run all scenarios | అన్ని సన్నివేశాలను రన్ చేయండి |
| `mvn test -Dtest=Scenario1LoginTest` | Run specific scenario | నిర్దిష్ట సన్నివేశాన్ని మాత్రమే రన్ చేయండి |
| `mvn test -X` | Run with debug output | డీబగ్ అవుట్‌పుట్‌తో రన్ చేయండి |
| `mvn clean install` | Install dependencies | అవసరమైన లైబ్రరీలను ఇన్‌స్టాల్ చేయండి |
| `mvn test surefire-report:report` | Generate HTML report | HTML రిపోర్ట్‌ను సృష్టించండి |
</details>

---

<details>
<summary><strong>🌐 Practice Websites | ప్రాక్టీస్ వెబ్‌సైట్లు (Click to expand)</strong></summary>

- Primary: `https://practice.automationbro.com`
- Alternative: `https://phptravels.com`
- Alternative: `https://demoqa.com`
- Alternative: `https://letskodeit.teachable.com`

**తెలుగు గమనిక:** ఈ వెబ్‌సైట్లు ఫ్రీగా ఉంటాయి మరియు ప్రాక్టీస్ చేయడానికి పూర్తిగా సురక్షితమైనవి.
</details>

---

## Contribution | సహకారం

<details>
<summary><strong>How to contribute | ఎలా సహకరించాలో తెలుసుకోండి (Click to expand)</strong></summary>

Feel free to contribute to this project:

1. **Fork** this repository (ఫోర్క్ చేయండి)
2. **Improve** scenario files (సన్నివేశ ఫైల్లను మెరుగుపరచండి)
3. **Add** more test cases (ఎక్కువ టెస్ట్ కేసులను జోడించండి)
4. **Submit** a Pull Request (పూల్ రిక్వెస్ట్ సమర్పించండి)
</details>

---

## Need Help? | సహాయం కావాలా?

<details>
<summary><strong>Common Issues & Solutions | సాధారణ సమస్యలు మరియు పరిష్కారాలు (Click to expand)</strong></summary>

### "java is not recognized" | "java గుర్తించబడలేదు"
- Make sure JAVA_HOME is set correctly | JAVA_HOME సరిగ్గా సెట్ చేయబడిందో లేదో చూడండి
- Add Java bin folder to PATH | Java bin ఫోల్డర్‌ను PATHలో జోడించండి

### "mvn is not recognized" | "mvn గుర్తించబడలేదు"
- Make sure MAVEN_HOME is set correctly | MAVEN_HOME సరిగ్గా సెట్ చేయబడిందో లేదో చూడండి
- Add Maven bin folder to PATH | Maven bin ఫోల్డర్‌ను PATHలో జోడించండి

### "Test failed with timeout" | "టెస్ట్ టైమ్ ఔట్‌తో విఫలమైంది"
- The practice website URL might need updating | ప్రాక్టీస్ వెబ్‌సైట్ URL అప్‌డేట్ అవసరం కావచ్చు
- Increase timeout values in WaitHelper | WaitHelperలో టైమ్‌అవుట్ విలువలను పెంచండి

### "ChromeDriver not found" | "ChromeDriver కనుగొనబడలేదు"
- WebDriverManager handles this automatically | WebDriverManager దీనిని ఆటోమేటిక్‌గా హ్యాండిల్ చేస్తుంది
- Just make sure you have an internet connection | ఇంటర్నెట్ కనెక్షన్ ఉందో లేదో చూడండి
</details>

---

## License | లైసెన్స్

This project is open source and available for learning purposes.

ఈ ప్రాజెక్ట్ ఓపెన్ సోర్స్ మరియు నేర్చుకోవడం కోసం అందుబాటులో ఉంది.

---

## Author | రచయిత

Created by Bharathkasyap as part of the Selenium Mastery course.
Part of [selenium-testing-Mastaru](https://github.com/Bharathkasyap/selenium-testing-Mastaru) repository.

ఈ ప్రాజెక్ట్‌ను Bharathkasyap, Selenium Mastery కోర్సులో భాగంగా సృష్టించారు.
[selenium-testing-Mastaru](https://github.com/Bharathkasyap/selenium-testing-Mastaru) రిపోజిటరీలో భాగం.

---

**Happy Testing!** 🚀
**శుభాకాంక్షలు!** 🎉
