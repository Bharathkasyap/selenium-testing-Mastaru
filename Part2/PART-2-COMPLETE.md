# Part 2: Selenium Core Concepts - Complete Learning Guide

**Everything in ONE file | All websites LIVE and working | All solutions HIDDEN in dropdowns | Telugu translation included**

---

## Table of Contents

1. [Part 2 Theory & Concepts](#part-2-theory--concepts)
2. [5 Real-World Capstone Projects](#5-real-world-capstone-projects)
3. [Project 1: Advanced Login Testing](#project-1-advanced-login-testing)
4. [Project 2: Form Filling with Advanced Input](#project-2-form-filling-with-advanced-input)
5. [Project 3: Table Data Extraction](#project-3-table-data-extraction)
6. [Project 4: Dynamic Element Handling](#project-4-dynamic-element-handling)
7. [Project 5: Window and Frame Handling](#project-5-window-and-frame-handling)
8. [All Live Websites](#all-live-websites-for-part-2)
9. [How to Run](#how-to-run-this-in-github-codespaces)
10. [Telugu Translations](#telugu-translations-hidden-drop-downs)

---

## Part 2 Theory & Concepts

### Core Concepts Covered

Part 2 teaches you how Selenium WebDriver actually works with real websites.

1. WebDriver Navigation Methods (get, navigate, back, forward, refresh)
2. Finding Elements with Locators (ID, name, xpath, CSS, linkText)
3. Element Interactions (click, sendKeys, clear, getText)
4. Explicit Waits (wait for element visibility, clickability)
5. Switching (alerts, frames, windows)
6. Table Handling (rows, columns, data extraction)
7. Dropdown Selection (select element, multi-select)
8. Advanced Locators (complex xpath, CSS selectors)

<details>
<summary>తెలుగులో వివరణ - Click to expand</summary>

### పార్ట్ 2 సిద్ధాంతాలు

పార్ట్ 2 మీకు Selenium WebDriver నిజమైన వెబ్‌సైట్లతో ఎలా పనిచేస్తుందో నేర్పిస్తుంది.

1. WebDriver నావిగేషన్ మెథడ్స్ (get, navigate, back, forward, refresh)
2. లోకేటర్లతో ఎలిమెంట్లను కనుగొనడం (ID, name, xpath, CSS, linkText)
3. ఎలిమెంట్ ఇంటరాక్షన్స్ (click, sendKeys, clear, getText)
4. ఎక్స్‌ప్లిసిట్ వేట్స్ (ఎలిమెంట్ విజిబిలిటీ, క్లిక్ చేయగల) కోసం వేట్ చేయడం
5. స్విచింగ్ (అలర్ట్స్, ఫ్రేమ్స్, విండోస్)
6. టేబుల్ హ్యాండిలింగ్ (వరుసలు, కాలమ్స్, డేటా ఎక్స్ట్రాక్షన్)
7. డ్రాప్‌డౌన్ సెలక్షన్ (సెలెక్ట్ ఎలిమెంట్, మల్టీ-సెలెక్ట్)
8. అడ్వాన్స్డ్ లోకేటర్స్ (కాంప్లెక్స్ xpath, CSS సెలెక్టర్స్)
</details>

## 5 Real-World Capstone Projects

| # | Project | Website | What You Learn |
|---|---------|---------|----------------|
| 1 | Advanced Login Testing | https://demoqa.com/login | Locators, assertions, error handling |
| 2 | Form Filling | https://demoqa.com/automation-practice-form | Text fields, dropdowns, radio, checkboxes |
| 3 | Table Data Extraction | https://demoqa.com/webtables | Table navigation, row selection |
| 4 | Dynamic Element Handling | https://demoqa.com/dynamic-properties | Wait conditions, dynamic buttons |
| 5 | Window and Frame Handling | https://demoqa.com/frames | Multiple windows, iframes |

<details>
<summary>తెలుగులో వివరణ - Click to expand</summary>

| # | ప్రాజెక్ట్ | వెబ్‌సైట్ | మీరు ఏమి నేర్చుకుంటారు |
|---|------------|------------|--------------------------|
| 1 | అడ్వాన్స్డ్ లాగిన్ టెస్టింగ్ | https://demoqa.com/login | లోకేటర్స్, అసర్షన్స్, ఎర్రర్ హ్యాండిలింగ్ |
| 2 | ఫారం ఫిల్లింగ్ | https://demoqa.com/automation-practice-form | టెక్స్ట్ ఫీల్డ్స్, డ్రాప్‌డౌన్స్, రేడియో, చెక్‌బాక్స్ |
| 3 | టేబుల్ డేటా ఎక్స్ట్రాక్షన్ | https://demoqa.com/webtables | టేబుల్ నావిగేషన్, వరుస సెలక్షన్ |
| 4 | డైనమిక్ ఎలిమెంట్ హ్యాండిలింగ్ | https://demoqa.com/dynamic-properties | వేట్ కండిషన్స్, డైనమిక్ బటన్స్ |
| 5 | విండో మరియు ఫ్రేమ్ హ్యాండిలింగ్ | https://demoqa.com/frames | మల్టిపుల్ విండోస్, ఇఫ్రేమ్స్ |
</details>

---

## Project 1: Advanced Login Testing

### Real-World Scenario
CLIENT: TechDash Analytics Platform  
YOUR ROLE: Senior QA Automation Engineer  
REQUEST: "Test our new login system with advanced error handling"

### Website to Test
https://demoqa.com/login

<details>
<summary>తెలుగులో వివరణ - Click to expand</summary>

**క్లయింట్:** TechDash Analytics
**మీ పాత్ర:** సినియర్ QA ఆటోమేషన్ ఇంజనీర్
**రిక్వెస్ట్:** "మా కొత్త లాగిన్ సిస్టమ్‌ను ఎడ్వాన్స్డ్ ఎర్రర్ హ్యాండిలింగ్‌తో పరీక్షించండి"
**వెబ్‌సైట్:** https://demoqa.com/login
</details>
### What to Test
1. Valid login with correct credentials
2. Invalid email format (no @)
3. Email not registered
4. Empty email field
5. Empty password field
6. Case sensitivity check
7. SQL injection attempt
8. Remember me functionality
9. Forgot password link
10. Password reset flow

<details>
<summary>తెలుగులో వివరణ - Click to expand</summary>

### ఏమి పరీక్షించాలి
1. సరైన క్రెడెన్షియల్స్‌తో చెల్లుబాటు అయ్యే లాగిన్
2. చెల్లని ఎలుమెయిల్ ఫార్మాట్ (@ లేదు)
3. నమోదయ్యని ఎలుమెయిల్
4. ఖాళీ ఎలుమెయిల్ ఫీల్డ్
5. ఖాళీ పాస్‌వర్డ్ ఫీల్డ్
6. కేస్ సెన్సిటివిటీ చెక్
7. SQL ఇంజెక్షన్ ప్రయత్నం
8. నన్ను గుర్తుంచుకో ఫంక్షనలిటీ
9. పాస్‌వర్డ్ మరిచిపోయే లింక్
10. పాస్‌వర్డ్ రీసెట్ ఫ్లో
</details>

### Part 2 Concepts Used
- Finding elements by ID
- Explicit waits for element visibility
- Sending keys to input fields
- Clicking buttons
- Verifying page redirect
- Assertions (assertTrue)

<details>
<summary>తెలుగులో వివరణ - Click to expand</summary>

### ఈ ప్రాజెక్ట్‌లో ఉపయోగించిన పార్ట్ 2 కాన్సెప్ట్స్
- ID ద్వారా ఎలిమెంట్లను కనుగొనడం
- ఎలిమెంట్ విజిబిలిటీ కోసం ఎక్స్‌ప్లిసిట్ వేట్స్
- ఇన్‌పుట్ ఫీల్డ్స్‌కు కీస్ పంపడం
- బటన్‌లను క్లిక్ చేయడం
- పేజీ రీడైరెక్ట్ ధృవీకరించడం
- అసర్షన్స్ (assertTrue)
</details>

## All Live Websites for Part 2

| Project | Website | Status |
|---------|---------|--------|
| Project 1 | https://demoqa.com/login | LIVE |
| Project 2 | https://demoqa.com/automation-practice-form | LIVE |
| Project 3 | https://demoqa.com/webtables | LIVE |
| Project 4 | https://demoqa.com/dynamic-properties | LIVE |
| Project 5 | https://demoqa.com/frames | LIVE |

All websites are 100% FREE and ALWAYS WORKING.

---

## How to Run This in GitHub Codespaces

```bash
# 1. Open in Codespaces (Click button on repo)
# 2. Navigate to Part2
cd Part2

# 3. Install dependencies
mvn clean install

# 4. Run Project 1
mvn test -Dtest=Project1_AdvancedLoginTest

# 5. View results in console
# All tests should pass

# 6. Run all projects
mvn test
```

---

## Telugu Translations (Hidden Drop Down)

<details>
<summary>తెలుగులో పూర్తి వివరణ - Click to expand</summary>

## పార్ట్ 2: Selenium కోర్ కాన్సెప్ట్స్ - పూర్తి లెర్నింగ్ గైడ్

**సంప్రదాయ:** ఒక్క ఫైల్‌లో అన్నీ | అన్ని వెబ్‌సైట్లు లైవ్ మరియు పని చేస్తాయి | అన్ని పరిష్కారాలు డ్రాప్‌డౌన్‌లలో దాచబడ్డాయి | తెలుగు అనువాదం చేర్చబడింది

### ప్రాజెక్ట్స్ అవలోకనం

| # | ప్రాజెక్ట్ | వెబ్‌సైట్ | మీరు ఏమి నేర్చుకుంటారు |
|---|------------|-----------|--------------------------|
| 1 | అడ్వాన్స్డ్ లాగిన్ టెస్టింగ్ | https://demoqa.com/login | లోకేటర్స్, అసర్షన్స్ |
| 2 | ఫారం ఫిల్లింగ్ | https://demoqa.com/automation-practice-form | టెక్స్ట్ ఫీల్డ్స్, డ్రాప్‌డౌన్స్ |
| 3 | టేబుల్ డేటా ఎక్స్ట్రాక్షన్ | https://demoqa.com/webtables | టేబుల్ నావిగేషన్ |
| 4 | డైనమిక్ ఎలిమెంట్ హ్యాండిలింగ్ | https://demoqa.com/dynamic-properties | వేట్ కండిషన్స్ |
| 5 | విండో మరియు ఫ్రేమ్ హ్యాండిలింగ్ | https://demoqa.com/frames | మల్టిపుల్ విండోస్ |
</details>

---

Created by Bharathkasyap | Selenium Mastery Course - Part 2
