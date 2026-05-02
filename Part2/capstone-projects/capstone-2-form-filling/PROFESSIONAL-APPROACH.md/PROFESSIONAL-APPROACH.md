# Capstone 2: Form Filling with Advanced Input

[← Back to CAPSTONE-README.md](../CAPSTONE-README.md) | [PROJECT-BRIEF.md](PROJECT-BRIEF.md) | [LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md) | [COMPLETE-SOLUTION.java](COMPLETE-SOLUTION.java) | [EXPECTED-OUTPUT.md](EXPECTED-OUTPUT.md)

---

📌 What Is This File?
----------------------
This is the **PROFESSIONAL APPROACH** file — how an expert thinks when they receive this project.

**Why this file matters:** The client tells you WHAT to test. You need to figure out HOW to test it. This file shows you the approach.

---

## Professional Approach - How Experts Think

### 📌 File Navigation
- [Step 1](#step-1-understand-the-form-screen)
- [Step 2](#step-2-identify-all-form-elements)
- [Step 3](#step-3-what-could-go-wrong)
- [Step 4](#step-4-design-test-scenarios)
- [Step 5](#step-5-kick-off-questions)

---

### Step 1: Understand the Form Screen

Before writing code, I opened demoqa.com/automation-practice-form and noted:

| Section | Fields | Type |
|---------|--------|------|
| Student Info | First Name, Last Name, Email, Gender | Text inputs + Radio buttons |
| Student Mobile | Mobile Number | Text input |
| Date of Birth | Date picker | Calendar widget |
| Subjects | Input field with suggestions | Type-ahead text |
| Hobbies | Sports, Reading, Music | Checkboxes |
| Upload Picture | File upload | File input |
| Address | Current address text | Text area |
| State & City | Dropdowns | Select dropdowns |

### Step 2: Identify All Form Elements

As an expert, I identify each element type and the Selenium class needed:

| Field | Element Type | Selenium Class |
|-------|-------------|----------------|
| First/Last Name, Email, Mobile | Text Input | sendKeys() |
| Gender (Male/Female) | Radio Button | click() on WebElement |
| Date of Birth | Date Picker | sendKeys() with date format |
| Hobbies | Checkboxes | click() on WebElement |
| State | Dropdown | Select class |
| City | Dropdown | Select class |

### Step 3: What Could Go Wrong?

| Issue | Scenario | Fix |
|-------|----------|-----|
| Field not found | Wrong ID/class name | Inspect element (F12) and get correct selector |
| Dropdown not selected | Not using Select class | Use new Select(element).selectByVisibleText() |
| Radio button not selected | Wrong XPath | Use input[@value='Male'] or similar |
| Date format wrong | Wrong date format | Use dd/MM/yyyy format |
| Form submission blocked | Browser HTML5 validation | Handle or bypass validation |

### Step 4: Design Test Scenarios

| Scenario | What We Test | Key Selenium Methods |
|----------|-------------|---------------------|
| 1. Complete Valid Form | Fill all fields, submit | sendKeys(), click(), Select class |
| 2. Missing Required Fields | Leave name empty, submit | sendKeys(), click() |
| 3. Invalid Email Format | Enter email without @ | sendKeys(), click() |
| 4. Radio Button Selection | Select Male gender | click() on radio |
| 5. Checkbox Selection | Select Sports + Reading | click() on checkboxes |

### Step 5: Kick-Off Questions

| # | Question | Why I Ask |
|---|----------|----------|
| 1 | What fields are REQUIRED vs optional? | I need to know which empty fields should fail |
| 2 | What is the success confirmation? | Modal? New page? Success message? |
| 3 | Should I verify data after submission? | Or just verify the submission works? |
| 4 | What date format does the picker accept? | dd/MM/yyyy? MM/dd/yyyy? |
| 5 | Should I test the file upload? | File upload needs special handling |
| 6 | Is there a character limit on address? | Long text might be truncated |

> **Expert Tip:** Radio buttons and checkboxes look the same to beginners. Radio = choose ONE. Checkboxes = choose MANY. Knowing this difference in an interview = you get the job.

<details>
<summary><strong>🌐 తెలుగు - ప్రొఫెషనల్ అప్రోచ్ - ఎక్స్పర్ట్స్ ఆలోచించడం - క్లిక్ చేసి చదవండి</strong></summary>

**స్టెప్ 1: ఫారం స్క్రీన్ ను అర్థం చేసుకోండి**

నేను demoqa.com/automation-practice-form తెరిచి గమనించాను: ఫస్ట్ నేమ్, లాస్ట్ నేమ్, ఇమెయిల్, జెండర్ (రేడియో బటన్స్), మొబైల్ నంబర్, డేట్ ఆఫ్ బర్త్ (డేట్ పికర్), సబ్జెక్ట్స్, హాబీస్ (చెక్బాక్సెస్), అడ్రస్, స్టేట్ & సిటీ (డ్రాప్డౌన్స్).

**స్టెప్ 2: అన్ని ఫారం ఎలిమెంట్స్ ని గుర్తించండి**

| ఫీల్డ్ | ఎలిమెంట్ టైప్ | సెలెనియం క్లాస్ |
|-------|-------------|----------------|
| First/Last నేమ్, ఇమెయిల్, మొబైల్ | టెక్స్ట్ ఇన్పుట్ | sendKeys() |
| జెండర్ (Male/Female) | రేడియో బటన్ | click() on WebElement |
| డేట్ ఆఫ్ బర్త్ | డేట్ పికర్ | sendKeys() with date format |
| హాబీస్ | చెక్బాక్సెస్ | click() on WebElement |
| స్టేట్ | డ్రాప్డౌన్ | Select క్లాస్ |
| సిటీ | డ్రాప్డౌన్ | Select క్లాస్ |

**స్టెప్ 3: ఏమి తప్పు జరగవచ్చు?**

- ఫీల్డ్ కనుగొనలేకపోవడం → తప్పు ID/class name → పేజీ ఇన్స్పెక్ట్ చేయండి (F12)
- డ్రాప్డౌన్ సెలెక్ట్ కాకపోవడం → Select క్లాస్ వాడకపోవడం → new Select(element).selectByVisibleText() వాడండి
- రేడియో బటన్ సెలెక్ట్ కాకపోవడం → తప్పు XPath → input[@value='Male'] వాడండి
- డేట్ ఫార్మాట్ తప్పు → dd/MM/yyyy ఫార్మాట్ వాడండి

**స్టెప్ 4: టెస్ట్ సీన్ నియోలను డిజైన్ చేయండి**

| సీన్ ని | ఏమి టెస్ట్ చేస్తాము | కీ సెలెనియం మెథడ్స్ |
|----------|-------------|---------------------|
| 1. కంప్లీట్ వాలిడ్ ఫారం | అన్ని ఫీల్డ్స్ నింపి, సబ్మిట్ చేయండి | sendKeys(), click(), Select క్లాస్ |
| 2. మిస్సింగ్ రిక్వైర్డ్ ఫీల్డ్స్ | నేమ్ ఖాళీగా వదిలి, సబ్మిట్ చేయండి | sendKeys(), click() |
| 3. ఇన్వాలిడ్ ఇమెయిల్ ఫార్మాట్ | @ లేని ఇమెయిల్ ఎంటర్ చేయండి | sendKeys(), click() |
| 4. రేడియో బటన్ సెలెక్షన్ | Male జెండర్ ను ఎంచుకోండి | click() on radio |
| 5. చెక్బాక్స్ సెలెక్షన్ | Sports + Reading ఎంచుకోండి | click() on checkboxes |

> **ఎక్స్‌పర్ట్ టిప్:** రేడియో బటన్స్ మరియు చెక్బాక్సెస్ బిగినర్స్ కు ఒకేలా కనిపిస్తాయి. రేడియో = ఒకటి ఎంచుకోండి. చెక్బాక్సెస్ = ఎక్కువ ఎంచుకోండి. ఈ తేడా ఇంటర్వ్యూలో తెలిస్తే = జాబ్ వస్తుంది.

</details>

---

[→ LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md)

[↑ Back to Top](#professional-approach---how-experts-think)
