
# Part 01 — Foundation: From Zero to Selenium Ready

> **For Telugu-Speaking Learners** | Java Primary | Beginner to Expert Path
>
> This is your starting point. Take your time. Understand every concept deeply before moving forward.
> Every section has a Telugu explanation dropdown. Use it whenever you feel confused.

---

## Table of Contents

1. [What is Software Testing?](#1-what-is-software-testing)
2. [Manual Testing vs Automation Testing](#2-manual-testing-vs-automation-testing)
3. [Types of Testing](#3-types-of-testing)
4. [SDLC and STLC](#4-sdlc-and-stlc)
5. [Agile and Scrum for Testers](#5-agile-and-scrum-for-testers)
6. [Introduction to Selenium](#6-introduction-to-selenium)
7. [Selenium Architecture](#7-selenium-architecture)
8. [Setting Up Your Environment](#8-setting-up-your-environment)
9. [Your First Selenium Script](#9-your-first-selenium-script)
10. [Programming Fundamentals for Selenium](#10-programming-fundamentals-for-selenium)
11. [Big Practical Projects](#11-big-practical-projects)

---

## 1. What is Software Testing?

### What is it?

Imagine you just built a new car. Before you sell it to customers, you test it. You check the engine, brakes, lights, AC, everything. You make sure nothing is broken before a real person uses it.

**Software testing is exactly the same idea — but for software applications.**

When developers build a website or mobile app, they write code. That code can have mistakes (called **bugs**). Software testing means checking the software to find those bugs BEFORE real users face them.

**Official definition:** Software testing is the process of evaluating a software application to find defects and verify it works as expected.

### Why is Testing Important?

| Without Testing | With Testing |
|-----------------|--------------|
| Users find bugs | Testers find bugs first |
| Company loses reputation | Company builds trust |
| Money wasted on fixing live bugs | Cheaper to fix early |
| Data loss possible | Data stays safe |
| Legal issues possible | Compliance maintained |

### Real-World Example

Think about Google Search. Millions of people use it every day. If Google's search results showed wrong information or the page crashed, that would be a massive problem. Google has hundreds of testers and automation systems running thousands of tests every day to make sure this never happens.

### Who is a Software Tester?

A **software tester** (also called QA Engineer, Quality Analyst, or Test Engineer) is a person whose job is to:
- Understand what the software is supposed to do
- Check if it actually does it correctly
- Find bugs and report them clearly
- Help developers fix bugs
- Verify fixes work correctly

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## సాఫ్ట్‌వేర్ టెస్టింగ్ అంటే ఏమిటి?

ఒక కొత్త కారు తయారుచేసారు అనుకోండి. దాన్ని కస్టమర్లకు అమ్మే ముందు మీరు దాన్ని పరీక్షిస్తారు — ఇంజిన్, బ్రేకులు, లైట్లు, AC అన్నీ చెక్ చేస్తారు. ఏదైనా పాడైంది అంటే అక్కడే పరిష్కరిస్తారు.

**సాఫ్ట్‌వేర్ టెస్టింగ్ కూడా అదే విధంగా పనిచేస్తుంది — కానీ సాఫ్ట్‌వేర్ కోసం.**

డెవలపర్లు ఒక వెబ్‌సైట్ లేదా యాప్ తయారుచేసినప్పుడు, వారు కోడ్ రాస్తారు. ఆ కోడ్‌లో తప్పులు (bugs అంటారు) ఉండవచ్చు. నిజమైన users ఆ తప్పులను చూసే ముందే వాటిని కనుగొనడమే **సాఫ్ట్‌వేర్ టెస్టింగ్**.

### టెస్టింగ్ ఎందుకు అవసరం?

- Users కి bugs కనిపించకముందే మనం కనుగొంటాం
- Company యొక్క పేరు (reputation) భద్రంగా ఉంటుంది
- బగ్ ని ముందే పరిష్కరించడం తక్కువ ఖర్చు అవుతుంది
- Live లో fix చేయడం చాలా costly మరియు risky
- Data loss జరగకుండా కాపాడుతుంది

### నిజమైన ఉదాహరణ

Google Search ని చూడండి — రోజూ కోట్ల మంది వాడతారు. Search results తప్పుగా వచ్చినా, page crash అయినా పెద్ద సమస్య అవుతుంది. అందుకే Google వేలాది tests రోజూ run చేస్తుంది.

### Software Tester ఏం చేస్తారు?

- Software ఏం చేయాలో అర్థం చేసుకుంటారు
- అది సరిగ్గా చేస్తుందో లేదో check చేస్తారు
- Bugs కనుగొని clearly report చేస్తారు
- Developers bugs fix చేసిన తర్వాత మళ్ళీ check చేస్తారు

</details>

---

## 2. Manual Testing vs Automation Testing

### Manual Testing

**Manual testing** means a human being opens the application, clicks buttons, fills forms, and checks if everything works correctly — all by hand, without any code.

**Example:** A tester opens a login page, types a username and password, clicks "Login", and checks if the home page appears.

**Advantages:**
- Good for checking how things look (UI)
- Good for testing once or twice
- No technical skill needed to start
- Good for exploratory testing (finding unexpected bugs)

**Disadvantages:**
- Slow — humans click slowly
- Boring repeated work causes mistakes
- Cannot run 500 tests at the same time
- Cannot run at midnight automatically
- Same test done by different people gives different results

### Automation Testing

**Automation testing** means you write a program (code) that opens the application, clicks buttons, fills forms, and checks results — all automatically, without human clicking.

**Example:** You write Java code that automatically opens a browser, goes to the login page, types username and password, clicks Login, and verifies the home page appeared.

**Advantages:**
- Very fast — runs in seconds
- Always consistent — same result every time
- Can run 1000 tests at the same time
- Can run at midnight without anyone watching
- Reusable — write once, run many times

**Disadvantages:**
- Needs programming knowledge
- Takes time to write the scripts first
- Maintenance needed when UI changes

### When to Choose Which?

```
DECISION FRAMEWORK:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Is this test run once or twice? 
    YES → Manual Testing is better

Does this test need human judgment (like "does this look beautiful")?
    YES → Manual Testing is better

Is this test repeated every day / every release?
    YES → Automate it!

Does this test need to run on 5 different browsers?
    YES → Automate it!

Does this test need to run with 100 different data sets?
    YES → Automate it!

Is this a login / checkout / search? (critical path)
    YES → Automate it!
```

### The Transition: Manual Tester to Automation Tester

Many people reading this are already manual testers. Here is your path:

```
Manual Tester Path to Automation:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Step 1: Keep your testing knowledge (it is your BIGGEST advantage)
Step 2: Learn programming basics (we cover this in Section 10)
Step 3: Learn Selenium (this entire guide!)
Step 4: Learn a framework (Part 4 covers this)
Step 5: Build a real project on GitHub
Step 6: Apply for SDET / Automation QA roles
```

**Your manual testing knowledge is NOT wasted.** Automation testers who understand testing deeply are MORE valuable than programmers who just know code.

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Manual Testing vs Automation Testing

### Manual Testing

**Manual testing** అంటే ఒక మనిషి application తెరిచి, buttons నొక్కి, forms fill చేసి, అన్నీ సరిగ్గా పనిచేస్తున్నాయో లేదో చూడడం — code ఏమీ రాయకుండా.

**ఉదాహరణ:** Tester login page తెరుస్తారు, username, password type చేస్తారు, Login button నొక్కుతారు, home page వస్తుందో లేదో చూస్తారు.

**ప్రయోజనాలు:**
- UI ఎలా కనిపిస్తుందో check చేయడానికి మంచిది
- ఒకటి రెండు సార్లు test చేయడానికి సరిపోతుంది
- Technical skill అంతగా అవసరం లేదు

**నష్టాలు:**
- నెమ్మదిగా ఉంటుంది
- మళ్ళీ మళ్ళీ చేయడం వల్ల తప్పులు వస్తాయి
- 500 tests ఒకేసారి run చేయలేం
- రాత్రి automatically run చేయలేం

### Automation Testing

**Automation testing** అంటే మీరు code రాస్తారు, అది automatically browser తెరిచి, buttons నొక్కి, forms fill చేసి, results check చేస్తుంది.

**ప్రయోజనాలు:**
- చాలా fast — seconds లో run అవుతుంది
- ఎప్పుడూ same result వస్తుంది (consistent)
- 1000 tests ఒకేసారి run చేయవచ్చు
- రాత్రి కూడా automatically run అవుతుంది
- ఒకసారి రాస్తే చాలాసార్లు వాడవచ్చు (reusable)

**నష్టాలు:**
- Programming knowledge కావాలి
- Scripts రాయడానికి మొదట్లో time పడుతుంది
- UI మారినప్పుడు code కూడా update చేయాలి

### Manual Tester నుండి Automation Tester కి మారే దారి

మీరు ఇప్పటికే manual tester అయితే — మీ testing knowledge మీ **అతిపెద్ద asset**. దాన్ని వదులుకోకండి.

- Step 1: Testing knowledge భద్రంగా ఉంచుకోండి
- Step 2: Programming basics నేర్చుకోండి (Section 10 లో cover చేస్తాం)
- Step 3: Selenium నేర్చుకోండి (ఈ guide మొత్తం!)
- Step 4: Framework నేర్చుకోండి (Part 4)
- Step 5: GitHub లో real project build చేయండి
- Step 6: SDET / Automation QA jobs కి apply చేయండి

</details>

---

## 3. Types of Testing

### Overview

There are many types of testing. As a Selenium automation tester, you mainly focus on **functional testing** types. Let us understand each one clearly.

### 3.1 Functional Testing

**What it is:** Testing what the software DOES. Does it work as required?

**Example:** Testing that the login button actually logs you in with correct credentials.

**In Selenium:** Most of your Selenium scripts are functional tests.

### 3.2 Regression Testing

**What it is:** After a bug is fixed or new feature is added, you re-run old tests to make sure nothing that was working before is now broken.

**Why it matters:** Developers fix Bug A. But while fixing Bug A, they accidentally break Feature B. Regression tests catch this.

**Example:** E-commerce site adds new payment method. You run ALL old tests again to make sure Cart, Checkout, Login still work fine.

**This is the #1 reason companies use Selenium automation.** Running 500 regression tests manually every week is impossible. With Selenium, it takes minutes.

```
BEFORE (Manual Regression): 500 tests × 5 minutes each = 2500 minutes = 41+ hours
AFTER (Selenium Automation): 500 tests × automated = 30-45 minutes
```

### 3.3 Smoke Testing

**What it is:** Quick, basic testing to check if the application starts and core things work. It is like checking if the car engine turns on before doing a full inspection.

**Example:** After deploying to a server:
- Can you open the home page?
- Can you login?
- Can you see main navigation?

If smoke tests fail, stop everything. No point testing further if basics are broken.

**In Selenium:** You create a small set of 10-20 critical tests that run first. If any fail, the build is rejected immediately.

### 3.4 Sanity Testing

**What it is:** After a specific bug fix, test ONLY that specific area to make sure the fix works. More focused than smoke testing.

**Example:** Developer fixed a bug where search was returning wrong results. You run only search-related tests to verify the fix.

### 3.5 Integration Testing

**What it is:** Testing how different parts of the system work TOGETHER.

**Example:** 
- User clicks "Buy Now" → Payment system processes → Order system saves → Email system sends confirmation
- These are separate systems. Integration testing verifies they all work together correctly.

### 3.6 End-to-End Testing (E2E)

**What it is:** Testing a complete user journey from start to finish, just like a real user would use the application.

**Example:** Full E2E test for an e-commerce site:
1. Open website
2. Search for product
3. Click product
4. Add to cart
5. Go to checkout
6. Fill address
7. Pay
8. See order confirmation

**Selenium is perfect for E2E testing** because it controls the browser exactly like a real user.

### 3.7 Cross-Browser Testing

**What it is:** Testing the same application on multiple browsers (Chrome, Firefox, Edge, Safari) to ensure it works the same everywhere.

**Example:** A button that works in Chrome might not work in Firefox due to CSS differences.

**Selenium supports:** Chrome, Firefox, Edge, Safari, Opera — all through WebDriver.

### Testing Types Quick Reference Table

| Testing Type | What | When | Selenium? |
|---|---|---|---|
| Functional | Does it work? | Every build | Yes |
| Regression | Still works after change? | After every release | Yes — primary use |
| Smoke | Basic things work? | After deployment | Yes |
| Sanity | This fix work? | After bug fix | Yes |
| Integration | Parts work together? | After integration | Sometimes |
| E2E | Full user journey? | Before release | Yes — ideal |
| Cross-browser | Works on all browsers? | Before release | Yes |

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Testing రకాలు

### Functional Testing
Software **ఏం చేస్తుంది** అన్నది test చేయడం. Required గా పనిచేస్తుందా?

**ఉదాహరణ:** Login button నొక్కినప్పుడు actually login అవుతుందా?

Selenium తో మీరు రాసే చాలా tests functional tests.

### Regression Testing

Bug fix అయిన తర్వాత లేదా కొత్త feature add అయిన తర్వాత, పాత tests మళ్ళీ run చేయడం — ముందు పనిచేసేవి ఇప్పుడు కూడా పనిచేస్తున్నాయో లేదో check చేయడానికి.

**ఎందుకు important:** Developer Bug A fix చేసినప్పుడు, తెలియకుండా Feature B break అయే అవకాశం ఉంది. Regression tests ఇది catch చేస్తాయి.

**Selenium వాడే ముఖ్య కారణం ఇదే.** 500 regression tests manually వారానికి ఒకసారి చేయడం impossible. Selenium తో 30-45 నిమిషాల్లో అవుతుంది.

### Smoke Testing

Application deploy అయిన తర్వాత, basic things పనిచేస్తున్నాయా అని quick గా check చేయడం.

**ఉదాహరణ:**
- Home page తెరవబడుతుందా?
- Login అవుతుందా?
- Main navigation కనిపిస్తుందా?

Smoke tests fail అయితే — ఆపండి. Basic things లేకుండా further testing వ్యర్థం.

### Integration Testing

System యొక్క different parts కలిసి సరిగ్గా పనిచేస్తున్నాయా అని test చేయడం.

**ఉదాహరణ:** Buy Now → Payment → Order Save → Email Confirm — ఇవన్నీ different systems. అవి కలిసి పనిచేస్తున్నాయో లేదో integration testing చూస్తుంది.

### End-to-End (E2E) Testing

ఒక real user అనుభవించే complete journey ని start నుండి end వరకు test చేయడం.

**ఉదాహరణ:** Website తెరవడం → Search → Product click → Cart → Checkout → Pay → Confirmation చూడడం — ఇది పూర్తి E2E test.

**Selenium E2E testing కి perfect.** ఎందుకంటే Selenium exactly real user లా browser control చేస్తుంది.

### Cross-Browser Testing

Same application ని multiple browsers లో test చేయడం (Chrome, Firefox, Edge, Safari).

ఒక browser లో పనిచేసే button మరో browser లో పనిచేయకపోవచ్చు. Selenium అన్ని major browsers support చేస్తుంది.

</details>

---

## 4. SDLC and STLC

### 4.1 SDLC — Software Development Life Cycle

**SDLC** is the complete process of planning, building, and maintaining software. Think of it like building a house — you plan, get materials, build, inspect, and then maintain.

```
SDLC Phases:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

  ┌─────────────────────────────────────────────┐
  │           PLANNING                          │
  │   What will we build? Cost? Timeline?       │
  └───────────────────┬─────────────────────────┘
                      │
  ┌───────────────────▼─────────────────────────┐
  │           REQUIREMENTS                      │
  │   Exactly what features does client need?   │
  └───────────────────┬─────────────────────────┘
                      │
  ┌───────────────────▼─────────────────────────┐
  │           DESIGN                            │
  │   How will the system look and work?        │
  └───────────────────┬─────────────────────────┘
                      │
  ┌───────────────────▼─────────────────────────┐
  │           DEVELOPMENT                       │
  │   Developers write code                     │
  └───────────────────┬─────────────────────────┘
                      │
  ┌───────────────────▼─────────────────────────┐
  │           TESTING ← YOU ARE HERE            │
  │   Testers find bugs, verify functionality   │
  └───────────────────┬─────────────────────────┘
                      │
  ┌───────────────────▼─────────────────────────┐
  │           DEPLOYMENT                        │
  │   Software released to real users           │
  └───────────────────┬─────────────────────────┘
                      │
  ┌───────────────────▼─────────────────────────┐
  │           MAINTENANCE                       │
  │   Fix bugs found by users, add features     │
  └─────────────────────────────────────────────┘
```

### Where Does Testing Fit?

Testing does NOT only happen in the "Testing" phase. Good testers are involved from the very beginning:

- **Planning phase:** Testers review requirements for clarity and testability
- **Design phase:** Testers suggest test scenarios to consider during design
- **Development phase:** Testers prepare test cases and automation scripts
- **Testing phase:** Execute tests, find bugs, verify fixes
- **Deployment phase:** Smoke tests after deployment
- **Maintenance phase:** Regression tests after every update

### 4.2 STLC — Software Testing Life Cycle

STLC is the testing team's own process within SDLC. It has its own phases:

```
STLC Phases:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

1. REQUIREMENT ANALYSIS
   - Read and understand requirements
   - Identify what CAN be tested (testable)
   - Identify what NEEDS automation

2. TEST PLANNING
   - How many tests? Who does what?
   - Which tools? What environments?
   - Timeline and resources

3. TEST CASE DESIGN
   - Write test cases
   - Write test data
   - Write automation scripts

4. TEST ENVIRONMENT SETUP
   - Set up servers, browsers, tools
   - Configure Selenium, Maven, etc.

5. TEST EXECUTION
   - Run all test cases
   - Log bugs in bug tracking tool (Jira)
   - Run regression tests

6. TEST CLOSURE
   - Test summary report
   - Lessons learned
   - Archive test artifacts
```

### Entry and Exit Criteria

**Entry Criteria:** Conditions that must be TRUE before you start testing.
- Example: Development is complete, build is deployed, smoke tests pass

**Exit Criteria:** Conditions that must be TRUE before you stop testing.
- Example: All critical bugs are fixed, 95% tests pass

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## SDLC మరియు STLC

### SDLC — Software Development Life Cycle

Software plan చేయడం నుండి తయారుచేయడం వరకు, ఆ తర్వాత maintain చేయడం వరకు జరిగే complete process. ఇల్లు కట్టడం లాంటిది — plan చేస్తారు, materials తెస్తారు, కడతారు, inspect చేస్తారు, తర్వాత maintain చేస్తారు.

**SDLC Phases:**
1. **Planning** — ఏమి build చేయాలి? Cost ఎంత? Time ఎంత?
2. **Requirements** — Client కి exactly ఏ features కావాలి?
3. **Design** — System ఎలా కనిపిస్తుంది, ఎలా పనిచేస్తుంది?
4. **Development** — Developers code రాస్తారు
5. **Testing** — **మీరు ఇక్కడ ఉన్నారు** — bugs కనుగొంటారు, verify చేస్తారు
6. **Deployment** — Software real users కి release చేయడం
7. **Maintenance** — User bugs fix చేయడం, features add చేయడం

### Testing SDLC లో ఎక్కడ ఉంటుంది?

Testing **only Testing phase లో** జరగదు. మంచి testers మొదటి నుండే involved అవుతారు:

- Requirements చదివి clarity check చేస్తారు
- Design లో test scenarios suggest చేస్తారు
- Development time లో test cases prepare చేస్తారు
- Testing phase లో execute చేస్తారు, bugs log చేస్తారు
- Deployment తర్వాత smoke tests run చేస్తారు
- Maintenance లో regression tests run చేస్తారు

### STLC — Software Testing Life Cycle

Testing team వారి own process:

1. **Requirement Analysis** — Requirements చదవడం, testable points identify చేయడం
2. **Test Planning** — ఎన్ని tests? ఎవరు చేస్తారు? ఏ tools?
3. **Test Case Design** — Test cases రాయడం, automation scripts రాయడం
4. **Test Environment Setup** — Selenium, Maven, browsers configure చేయడం
5. **Test Execution** — Tests run చేయడం, bugs log చేయడం (Jira లో)
6. **Test Closure** — Test report, lessons learned

### Entry మరియు Exit Criteria

**Entry Criteria:** Testing start చేయడానికి ముందు ఏ conditions true అయి ఉండాలి.
- ఉదాహరణ: Development complete, build deploy అయింది, smoke tests pass అయ్యాయి

**Exit Criteria:** Testing ఆపడానికి ముందు ఏ conditions true అయి ఉండాలి.
- ఉదాహరణ: Critical bugs అన్నీ fix అయ్యాయి, 95% tests pass అయ్యాయి

</details>

---

## 5. Agile and Scrum for Testers

### What is Agile?

Traditional software development built everything first and tested at the end. If there were major problems, it was too late and too expensive to fix.

**Agile** is a different approach. Instead of building everything at once, you build the software in small pieces called **iterations** or **sprints**. Each sprint, you plan a little, build a little, test a little, and release a little.

Think of it like this:

```
TRADITIONAL (Waterfall):
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Plan 3 months → Build 6 months → Test 3 months → Release
Problem: Bugs found after 9 months are expensive!

AGILE:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Sprint 1: Plan + Build + Test + Release (2 weeks)
Sprint 2: Plan + Build + Test + Release (2 weeks)
Sprint 3: Plan + Build + Test + Release (2 weeks)
...
Problem caught in Sprint 1, fixed in Sprint 1!
```

### What is Scrum?

**Scrum** is the most popular way to practice Agile. It has specific roles and events:

**Roles:**
- **Product Owner:** Decides what features to build (the client representative)
- **Scrum Master:** Facilitates the process, removes obstacles
- **Development Team:** Developers AND testers — everyone who builds and tests

**Events:**
- **Sprint Planning:** Team decides what to build this sprint (2 weeks)
- **Daily Standup:** 15-minute daily meeting — What did I do? What will I do? Any blockers?
- **Sprint Review:** Show what was built to stakeholders
- **Sprint Retrospective:** What went well? What to improve?

**Artifacts:**
- **Product Backlog:** Full list of features to build (prioritized)
- **Sprint Backlog:** Features selected for this sprint
- **Increment:** Working software delivered each sprint

### A Tester's Role in Scrum

```
YOUR ACTIVITIES IN EACH SPRINT:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Sprint Planning: 
  - Review user stories with the team
  - Ask clarifying questions about requirements
  - Estimate testing effort
  - Define acceptance criteria

During Sprint:
  - Write automation scripts while development is happening
  - Test features as soon as developers complete them (NOT at the end!)
  - Log bugs immediately
  - Participate in daily standup

End of Sprint:
  - Run regression tests
  - Ensure all bugs are fixed
  - Update automation suite with new tests
  - Participate in review and retrospective
```

### Key Agile Terms for Testers

| Term | Meaning |
|------|---------|
| User Story | A feature described from user's perspective: "As a user, I want to login so I can access my account" |
| Acceptance Criteria | Specific conditions that must be true for the story to be "done" |
| Definition of Done | Team agreement on what "complete" means (code + tests + documented) |
| Velocity | How much work a team completes per sprint |
| Sprint Burndown | Chart showing how much work remains in the sprint |
| Backlog Grooming | Reviewing and refining backlog items |

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Agile మరియు Scrum

### Agile అంటే ఏమిటి?

Traditional software development లో అన్నీ ముందే build చేసి, చివరకి test చేసేవారు. Major problems ఉంటే, అప్పుడు fix చేయడం చాలా expensive.

**Agile** వేరే approach. అన్నీ ఒకేసారి build చేయకుండా, software ని చిన్న చిన్న pieces గా build చేస్తారు — వాటిని **sprints** అంటారు. ప్రతి sprint లో: plan + build + test + release జరుగుతాయి.

**Traditional (Waterfall):**
3 నెలలు plan + 6 నెలలు build + 3 నెలలు test = Bug 9 నెలల తర్వాత కనిపిస్తే — very expensive!

**Agile:**
Sprint 1: 2 వారాల్లో plan + build + test + release
Bug Sprint 1 లో కనిపించి Sprint 1 లోనే fix అవుతుంది!

### Scrum అంటే ఏమిటి?

Agile practice చేయడానికి అత్యంత popular way.

**Roles:**
- **Product Owner:** ఏ features build చేయాలో decide చేసే person (client representative)
- **Scrum Master:** Process facilitate చేస్తారు, obstacles remove చేస్తారు
- **Development Team:** Developers + Testers — అందరూ కలిసి build మరియు test చేస్తారు

**Events:**
- **Sprint Planning:** ఈ sprint లో ఏం build చేయాలో team decide చేస్తుంది
- **Daily Standup:** 15-minute daily meeting — నిన్న ఏం చేసారు? ఈరోజు ఏం చేస్తారు? ఏమైనా blockers ఉన్నాయా?
- **Sprint Review:** Build చేసింది stakeholders కి చూపించడం
- **Sprint Retrospective:** ఏం బాగా జరిగింది? ఏం improve చేయాలి?

### Scrum లో Tester పాత్ర

**Sprint Planning లో:**
- User stories review చేయడం
- Requirements గురించి clarifying questions అడగడం
- Acceptance criteria define చేయడం

**Sprint లో:**
- Development జరుగుతుండగానే automation scripts రాయడం
- Features complete అయిన వెంటనే test చేయడం (sprint చివర్లో కాదు!)
- Bugs వెంటనే log చేయడం

**Sprint చివర్లో:**
- Regression tests run చేయడం
- Automation suite లో new tests add చేయడం

### Key Terms

| Term | అర్థం |
|------|--------|
| User Story | User perspective నుండి feature description: "User గా, నేను login అవ్వాలనుకుంటున్నాను, నా account access చేయడానికి" |
| Acceptance Criteria | Story "done" అవడానికి ఏ conditions true అయి ఉండాలి |
| Definition of Done | "Complete" అంటే ఏమిటో team agreement (code + tests + documented) |
| Sprint Burndown | Sprint లో ఎంత work మిగిలిందో చూపించే chart |

</details>

---

## 6. Introduction to Selenium

### What is Selenium?

**Selenium** is a FREE, open-source tool for automating web browsers. When you run Selenium code, it actually opens a real browser (Chrome, Firefox, etc.) and controls it exactly like a human would — clicking, typing, reading, scrolling.

**Key point:** Selenium does NOT have a UI of its own. It is just a library (set of code) that you use inside your Java or Python programs.

### Why Selenium? Why not other tools?

| Tool | Type | Cost | Browser Support | Why Choose |
|------|------|------|-----------------|-----------|
| **Selenium** | Open source | FREE | All major browsers | Industry standard, most jobs require it |
| QTP/UFT | Commercial | Very expensive | Limited | Legacy, being replaced |
| Cypress | Open source | FREE | Chrome/Edge/Firefox | Good for JavaScript teams |
| Playwright | Open source | FREE | All | Newer, gaining popularity |
| Appium | Open source | FREE | Mobile browsers | Mobile testing |

**Why Selenium is still #1 choice:**
- Industry standard — most job postings ask for Selenium
- Supports Java, Python, C#, Ruby, JavaScript — you choose
- Supports ALL major browsers
- Huge community and support
- Integrates with ALL frameworks (TestNG, JUnit, Cucumber)
- Works with CI/CD tools (Jenkins, GitHub Actions)

### The 4 Components of Selenium

```
SELENIUM PROJECT COMPONENTS:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

┌─────────────────────────────────────────────────┐
│            SELENIUM SUITE                       │
│                                                 │
│  ┌─────────────┐  ┌─────────────────────────┐  │
│  │  Selenium   │  │    Selenium WebDriver   │  │
│  │    IDE      │  │    (THE MAIN TOOL)      │  │
│  │             │  │                         │  │
│  │ Browser     │  │ Write Java/Python code  │  │
│  │ extension   │  │ to control browser      │  │
│  │ record &    │  │ Used in REAL jobs       │  │
│  │ playback    │  │                         │  │
│  └─────────────┘  └─────────────────────────┘  │
│                                                 │
│  ┌─────────────┐  ┌─────────────────────────┐  │
│  │  Selenium   │  │    Selenium Manager     │  │
│  │    Grid     │  │    (New in Selenium 4)  │  │
│  │             │  │                         │  │
│  │ Run tests   │  │ Auto-manages browser    │  │
│  │ on multiple │  │ drivers — no manual     │  │
│  │ machines    │  │ setup needed            │  │
│  │ at once     │  │                         │  │
│  └─────────────┘  └─────────────────────────┘  │
└─────────────────────────────────────────────────┘
```

### Component 1: Selenium IDE

- A browser extension (Chrome/Firefox)
- Records your clicks and typing, generates test code
- Good for beginners learning what Selenium looks like
- **NOT used in real professional work** — too fragile, can't handle complex logic

### Component 2: Selenium WebDriver ⭐ (THE IMPORTANT ONE)

- A library you add to your Java/Python project
- Write code to control the browser
- Supports all browsers through "drivers" (ChromeDriver, FirefoxDriver, etc.)
- **This is what 95% of this guide teaches**

### Component 3: Selenium Grid

- Allows you to run tests on multiple browsers AND multiple machines simultaneously
- Example: Run 1000 tests across 20 machines at the same time → finishes in 5 minutes instead of 100 minutes
- Covered in Part 5 of this guide

### Component 4: Selenium Manager (Selenium 4+)

- In older Selenium (3), you had to manually download ChromeDriver and set it up
- In Selenium 4, Selenium Manager does this automatically
- It detects your Chrome version and downloads the right ChromeDriver automatically
- Major quality-of-life improvement

### WebDriver is King — Here is Why

```
HOW SELENIUM WEBDRIVER WORKS:

Your Java Code
     │
     │ calls methods
     ▼
WebDriver API (selenium-java.jar)
     │
     │ sends HTTP commands
     ▼
Browser Driver (ChromeDriver.exe)
     │
     │ communicates using W3C protocol
     ▼
Real Browser (Chrome)
     │
     │ performs actions
     ▼
Web Application
```

Every time you write `driver.click()` or `driver.findElement()`, your code talks to the browser driver, which tells the actual browser what to do. The browser does the real action on the real website.

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Selenium పరిచయం

### Selenium అంటే ఏమిటి?

**Selenium** అనేది web browsers ని automatically control చేయడానికి వాడే FREE, open-source tool. మీరు Selenium code run చేసినప్పుడు, ఇది నిజంగా ఒక real browser (Chrome, Firefox) తెరుస్తుంది మరియు ఒక మనిషిలా click చేస్తుంది, type చేస్తుంది, scroll చేస్తుంది.

**Important:** Selenium కి దానికంటూ ఒక UI లేదు. ఇది మీ Java లేదా Python programs లో వాడే ఒక library (code collection).

### Selenium ఎందుకు? మరిన్ని tools ఉండగా?

- **Industry standard** — చాలా jobs Selenium అడుగుతాయి
- **Free** — ఒక్క పైసా కాదు
- **Java, Python, C# support** — మీ choice
- **All browsers support** — Chrome, Firefox, Edge, Safari
- **Huge community** — problem వస్తే Stack Overflow లో answer ఉంటుంది

### Selenium యొక్క 4 భాగాలు

1. **Selenium IDE:** Browser extension. Click చేస్తే record చేసి code generate చేస్తుంది. Beginners కి useful, కానీ real jobs లో వాడరు.

2. **Selenium WebDriver ⭐:** **ఇదే ముఖ్యమైనది.** Java/Python code రాసి browser control చేయడం. ఈ guide లో 95% ఇదే నేర్పిస్తాం.

3. **Selenium Grid:** Multiple machines పై ఒకేసారి tests run చేయడం. Part 5 లో cover చేస్తాం.

4. **Selenium Manager (Selenium 4+):** పాత versions లో ChromeDriver manually download చేయాల్సి వచ్చేది. Selenium 4 లో ఇది automatically జరుగుతుంది.

### WebDriver ఎలా పనిచేస్తుంది?

మీ Java Code → WebDriver API → Browser Driver (ChromeDriver) → Real Browser → Web Application

మీరు `driver.click()` రాసినప్పుడు:
- మీ code WebDriver API కి చెప్తుంది
- WebDriver API ChromeDriver కి HTTP command పంపిస్తుంది
- ChromeDriver Chrome browser కి చెప్తుంది
- Chrome browser actual website లో click చేస్తుంది

</details>

---

## 7. Selenium Architecture

### Understanding the Architecture

This is important to understand — not just for interviews, but for DEBUGGING. When something goes wrong, knowing the architecture helps you find WHY.

```
SELENIUM 4 ARCHITECTURE (W3C WebDriver Protocol):
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

┌─────────────────────────────────────────────────┐
│              TEST SCRIPT (Java/Python)          │
│         WebDriver driver = new ChromeDriver()  │
│         driver.get("https://google.com")       │
└───────────────────────┬─────────────────────────┘
                        │
                        │ (1) Selenium Java API
                        │     converts method calls
                        │     to JSON commands
                        ▼
┌─────────────────────────────────────────────────┐
│              SELENIUM WEBDRIVER API             │
│           (selenium-java.jar / selenium pip)    │
│                                                 │
│  findElement, click, sendKeys, getText, etc.   │
└───────────────────────┬─────────────────────────┘
                        │
                        │ (2) HTTP Requests
                        │     (W3C WebDriver Protocol)
                        │     POST /session
                        │     POST /session/{id}/url
                        ▼
┌─────────────────────────────────────────────────┐
│              BROWSER DRIVER                     │
│                                                 │
│    ChromeDriver.exe  │  GeckoDriver.exe        │
│    (for Chrome)      │  (for Firefox)           │
│                                                 │
│    - Starts the browser                         │
│    - Translates WebDriver commands              │
│    - Returns results                            │
└───────────────────────┬─────────────────────────┘
                        │
                        │ (3) Native Browser Commands
                        │     (using DevTools Protocol)
                        ▼
┌─────────────────────────────────────────────────┐
│              ACTUAL BROWSER                     │
│         (Chrome / Firefox / Edge / Safari)      │
│                                                 │
│    - Opens web page                             │
│    - Executes JavaScript                        │
│    - Renders HTML/CSS                           │
│    - Performs user actions                      │
└───────────────────────┬─────────────────────────┘
                        │
                        │ (4) HTTP Requests to
                        │     Web Server
                        ▼
┌─────────────────────────────────────────────────┐
│              WEB APPLICATION                    │
│                 (Your test target)              │
└─────────────────────────────────────────────────┘
```

### Key Architecture Points

**Point 1: JSON Wire Protocol vs W3C Protocol**
- **Selenium 3:** Used JSON Wire Protocol (Selenium's own protocol)
- **Selenium 4:** Uses W3C WebDriver Protocol (W3C standard)
- W3C protocol is built into browsers natively — more stable, more reliable

**Point 2: Each Browser Needs Its Own Driver**

| Browser | Driver Needed | Who Makes It |
|---------|---------------|--------------|
| Chrome | ChromeDriver | Google |
| Firefox | GeckoDriver | Mozilla |
| Edge | EdgeDriver | Microsoft |
| Safari | SafariDriver | Apple (built into macOS) |

**Point 3: Selenium Manager (Selenium 4)**
- In Selenium 4, you don't need to manually download ChromeDriver
- `Selenium Manager` automatically detects your Chrome version and downloads matching ChromeDriver
- This is a major improvement from Selenium 3

**Point 4: BiDi (Bidirectional Communication) — New in Selenium 4**
- Old protocol: Your code sends command → driver responds
- New BiDi: Two-way communication — browser can ALSO send events to your code
- Example: Browser can notify your code when a network request is made
- This is advanced — covered in Part 5

### How a Single `driver.findElement()` Works Internally

```
When you call: WebElement loginBtn = driver.findElement(By.id("login"));

Step 1: Selenium Java API creates HTTP request:
   POST http://localhost:9515/session/{sessionId}/element
   Body: {"using":"id","value":"login"}

Step 2: ChromeDriver receives this request

Step 3: ChromeDriver tells Chrome to find element with id="login"

Step 4: Chrome searches the DOM (HTML structure of the page)

Step 5: Chrome finds the element, returns reference

Step 6: ChromeDriver wraps this in HTTP response

Step 7: Selenium Java API converts to WebElement object

Step 8: Your Java code has the WebElement to use
```

Understanding this helps you debug. If `findElement` fails, you know:
- Is the locator wrong? (Step 4 fails)
- Is the element not loaded yet? (Step 4 fails — timing issue)
- Is the session expired? (Step 2 fails)

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Selenium Architecture

### Architecture అర్థం ఎందుకు చేసుకోవాలి?

Interviews కోసం మాత్రమే కాదు — **debugging కోసం**. ఏదైనా wrong అయినప్పుడు, architecture తెలిస్తే WHY అన్నది వెంటనే అర్థమవుతుంది.

### Architecture ఎలా పనిచేస్తుంది?

మీ Java Code → Selenium WebDriver API → Browser Driver → Real Browser → Web App

**Step by step:**

1. మీరు `driver.get("https://google.com")` రాస్తారు
2. Selenium API దీన్ని HTTP request గా convert చేస్తుంది
3. Chrome Driver ఆ request receive చేస్తుంది
4. Chrome Driver Chrome browser కి నిజమైన command ఇస్తుంది
5. Chrome browser google.com open చేస్తుంది

### ముఖ్యమైన విషయాలు

**ప్రతి browser కి own driver కావాలి:**
- Chrome → ChromeDriver (Google చేసింది)
- Firefox → GeckoDriver (Mozilla చేసింది)
- Edge → EdgeDriver (Microsoft చేసింది)

**Selenium 4 లో Selenium Manager:**
- పాత Selenium 3: ChromeDriver manually download చేయాల్సి వచ్చేది, path set చేయాల్సి వచ్చేది
- Selenium 4: Selenium Manager automatically correct version ChromeDriver download చేస్తుంది!
- చాలా convenient!

**W3C Protocol:**
- Selenium 3: Selenium's own protocol వాడేది
- Selenium 4: W3C standard protocol వాడుతుంది
- W3C protocol browsers లో built-in గా ఉంటుంది — more stable

### `driver.findElement()` internally ఎలా పనిచేస్తుంది?

మీరు `driver.findElement(By.id("login"))` రాసినప్పుడు:

1. Selenium HTTP request తయారుచేస్తుంది: element id="login" కోసం వెదకండి
2. ChromeDriver ఆ request receive చేస్తుంది
3. ChromeDriver Chrome కి చెప్తుంది — id="login" element వెతుకు
4. Chrome HTML page లో వెతుకుతుంది
5. Element దొరికితే, reference return చేస్తుంది
6. మీ Java code కి WebElement object వస్తుంది

ఇది fail అయినప్పుడు:
- Locator wrong అయినా fail అవుతుంది (Step 4)
- Element ఇంకా load కాలేదు అన్నా fail అవుతుంది (Step 4 — timing issue)
- Session expire అయినా fail అవుతుంది (Step 2)

</details>

---

## 8. Setting Up Your Environment

### What You Need

```
REQUIRED SOFTWARE:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

1. JDK (Java Development Kit) — version 11 or 17 recommended
2. IDE — IntelliJ IDEA (recommended) or Eclipse
3. Maven — Build tool (manages dependencies)
4. Chrome Browser — for testing
5. Selenium Java Library — added via Maven
```

### Step-by-Step Setup (Windows)

#### Step 1: Install JDK

1. Go to: `https://adoptium.net/` (Temurin JDK — free and recommended)
2. Download JDK 17 for Windows
3. Run the installer
4. Verify: Open Command Prompt → type `java -version`
   - Should show: `openjdk version "17.x.x"`

#### Step 2: Install IntelliJ IDEA Community (Free)

1. Go to: `https://www.jetbrains.com/idea/download/`
2. Download **Community Edition** (FREE)
3. Install it
4. Open IntelliJ

#### Step 3: Create a Maven Project

In IntelliJ:
1. Click "New Project"
2. Select "Maven Archetype"
3. Name: `selenium-learning`
4. GroupId: `com.yourname`
5. ArtifactId: `selenium-learning`
6. Click Create

#### Step 4: Add Selenium Dependency in pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.yourname</groupId>
    <artifactId>selenium-learning</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Selenium Java Library -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.18.1</version>
        </dependency>

        <!-- TestNG for test execution -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.9.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

After adding this, right-click on pom.xml → "Maven" → "Reload Project"

Maven will automatically download Selenium and all its dependencies.

<details>
<summary>Required Skill: What is Maven and pom.xml? (Click to learn)</summary>

## Maven అంటే ఏమిటి?

**Maven** అనేది Java projects కోసం ఒక build tool. ఇది రెండు ముఖ్యమైన పనులు చేస్తుంది:

### 1. Dependency Management
మీ project కి external libraries (jars) కావాలి — Selenium, TestNG, etc. ఈ libraries ని manually download చేసి project కి add చేయడానికి బదులు, Maven automatically download చేస్తుంది.

`pom.xml` లో మీరు ఒక్కసారి library name చెప్పారు:
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.18.1</version>
</dependency>
```
Maven automatically selenium-java.jar download చేసి మీ project కి add చేస్తుంది.

### 2. Build Lifecycle
Maven మీ project ని compile చేయగలదు, tests run చేయగలదు, package చేయగలదు.

### pom.xml అంటే ఏమిటి?

**pom.xml** = Project Object Model. ఇది మీ project configuration file.

దీనిలో ఉండేవి:
- Project name, version
- Dependencies (libraries needed)
- Build settings
- Plugin settings

**Maven Repository:**
Maven libraries ఎక్కడ నుండి download చేస్తుంది?
- Maven Central Repository: `https://repo.maven.apache.org`
- ఇది free, public library storage

పొందిన libraries ఎక్కడ save అవుతాయి?
- మీ computer లో: `C:\Users\YourName\.m2\repository`
- ఇది local cache — same library మళ్ళీ download చేయదు

</details>

#### Step 5: Verify Your Project Structure

```
selenium-learning/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/yourname/   ← Main application code
│   └── test/
│       └── java/
│           └── com/yourname/   ← Test code goes here
├── pom.xml                     ← Maven configuration
└── target/                     ← Compiled output (auto-generated)
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Environment Setup

### అవసరమైన Software

1. **JDK (Java Development Kit)** — Java programs run చేయడానికి. Version 17 recommended.
2. **IntelliJ IDEA Community** — Code రాయడానికి (Free IDE)
3. **Maven** — Libraries manage చేయడానికి build tool
4. **Chrome Browser** — Testing కోసం

### Setup Steps

**Step 1: JDK Install**
- `https://adoptium.net/` నుండి JDK 17 Windows version download చేయండి
- Install చేయండి
- Verify: Command Prompt లో `java -version` type చేయండి
- Result: `openjdk version "17.x.x"` కనిపించాలి

**Step 2: IntelliJ Install**
- `https://www.jetbrains.com/idea/download/` నుండి Community Edition download (FREE)
- Install చేయండి

**Step 3: Maven Project Create**
- IntelliJ తెరవండి → New Project → Maven → Name: selenium-learning

**Step 4: pom.xml లో Selenium add**
- pom.xml లో `<dependencies>` section లో Selenium dependency add చేయండి
- Right-click → Maven → Reload Project
- Maven automatically Selenium download చేస్తుంది

**Step 5: Project Structure**

```
selenium-learning/
├── src/test/java/    ← మీ test code ఇక్కడ రాయండి
├── pom.xml           ← Maven configuration
```

Selenium 4 లో ChromeDriver manually download చేయాల్సిన పని లేదు — Selenium Manager automatically handle చేస్తుంది!

</details>

---

## 9. Your First Selenium Script

### Understanding What We Will Write

We will write a program that:
1. Opens Chrome browser
2. Goes to Google.com
3. Prints the page title
4. Closes the browser

This is the "Hello World" of Selenium.

### Simple Version — First Script

```java
// File: src/test/java/com/yourname/FirstSeleniumTest.java

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
    
    public static void main(String[] args) {
        
        // Step 1: Create ChromeDriver instance
        // This opens a new Chrome browser window
        // Selenium 4 automatically manages ChromeDriver — no manual download needed!
        WebDriver driver = new ChromeDriver();
        
        // Step 2: Open a website
        driver.get("https://www.google.com");
        
        // Step 3: Get and print the page title
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
        
        // Step 4: Close the browser
        driver.quit();
        
        System.out.println("Test completed successfully!");
    }
}
```

**Expected Output:**
```
Page Title is: Google
Test completed successfully!
```

What happens when you run this:
1. A new Chrome browser window opens
2. Google.com loads
3. "Page Title is: Google" prints in your IntelliJ console
4. Browser closes
5. "Test completed successfully!" prints

### Intermediate Version — More Actions

```java
// File: src/test/java/com/yourname/IntermediateFirstTest.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntermediateFirstTest {
    
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        
        // Maximize the browser window (best practice)
        driver.manage().window().maximize();
        
        // Navigate to Google
        driver.get("https://www.google.com");
        
        // Find the search box and type something
        // "q" is the name attribute of Google's search input
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver tutorial");
        
        // Press Enter to search
        searchBox.submit();
        
        // Wait briefly for results (we'll learn proper waits in Part 3)
        try {
            Thread.sleep(2000);  // Wait 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Print the current URL (should be search results URL)
        System.out.println("Current URL: " + driver.getCurrentUrl());
        
        // Print page title
        System.out.println("Page Title: " + driver.getTitle());
        
        // Close the browser
        driver.quit();
    }
}
```

**Expected Output:**
```
Current URL: https://www.google.com/search?q=Selenium+WebDriver+tutorial&...
Page Title: Selenium WebDriver tutorial - Google Search
```

### Advanced Version — With Error Handling and Assertions

```java
// File: src/test/java/com/yourname/AdvancedFirstTest.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedFirstTest {
    
    private static WebDriver driver;
    
    public static void main(String[] args) {
        
        try {
            // Configure Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");   // Start maximized
            options.addArguments("--disable-notifications"); // Disable popups
            
            // Initialize driver with options
            driver = new ChromeDriver(options);
            
            System.out.println("Browser opened successfully");
            
            // Navigate to a test website
            String targetUrl = "https://www.seleniumeasy.com/test/";
            driver.get(targetUrl);
            
            // Verify we are on the right page
            String actualTitle = driver.getTitle();
            String expectedTitle = "Selenium Easy";
            
            if (actualTitle.contains(expectedTitle)) {
                System.out.println("PASS: Title verified! - " + actualTitle);
            } else {
                System.out.println("FAIL: Wrong title! Expected: " + expectedTitle + 
                                 " | Actual: " + actualTitle);
            }
            
            // Get current URL and print
            System.out.println("Current URL: " + driver.getCurrentUrl());
            
            // Print page source length (useful for debugging)
            System.out.println("Page source length: " + driver.getPageSource().length() + " chars");
            
        } catch (Exception e) {
            // If any error occurs, print the error
            System.out.println("ERROR occurred: " + e.getMessage());
            e.printStackTrace();
            
        } finally {
            // ALWAYS close the browser — even if test fails
            // "finally" block always runs, success or failure
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed successfully");
            }
        }
    }
}
```

### 5 Real-World Scenarios

**Scenario 1 — Healthcare Portal Login Verification:**
Test that a hospital patient portal opens correctly and shows login form. Run this every morning before staff shifts start.

**Scenario 2 — E-commerce Price Check:**
A business needs to verify their product pages load correctly after every deployment. This script runs automatically after each build.

**Scenario 3 — Bank ATM Simulation:**
Banking websites need constant verification that their home page loads and shows correct information. Runs every 15 minutes as a health check.

**Scenario 4 — Government Service Portal:**
A government service website automated check to verify critical services are accessible to citizens. Smoke test run every hour.

**Scenario 5 — Social Media Platform:**
A company uses this to verify their social media pages load correctly and show the right company information.

### Common Mistakes and Fixes

| Mistake | What Happens | Fix |
|---------|-------------|-----|
| Not calling `driver.quit()` | Browser stays open forever, memory leak | Always call `quit()` in finally block |
| Using `driver.close()` instead of `driver.quit()` | Only closes current tab, driver session remains | Use `quit()` to close everything |
| Not maximizing window | Elements might not be visible, tests fail | Always call `driver.manage().window().maximize()` first |
| Wrong URL (no https://) | Browser might not navigate correctly | Always use full URL with protocol |
| Forgetting imports | Compilation error | IntelliJ will suggest imports — press Alt+Enter |

### Pro Tips

> **Pro Tip 1:** Always use `driver.quit()` not `driver.close()`. `close()` closes the current window but leaves the WebDriver session running. `quit()` closes all windows AND ends the session properly. Memory leaks are real!

> **Pro Tip 2:** In Selenium 4, you don't need to set system property for ChromeDriver. Old code like `System.setProperty("webdriver.chrome.driver", "path/to/chromedriver")` is no longer needed. Selenium Manager handles it.

> **Pro Tip 3:** Always put `driver.quit()` in a `finally` block. If your test throws an exception, the `finally` block still runs and browser gets closed.

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## మొదటి Selenium Script

### మనం ఏం రాస్తున్నాం?

1. Chrome browser తెరవడం
2. Google.com కి వెళ్ళడం
3. Page title print చేయడం
4. Browser close చేయడం

### Simple Script అర్థం

```java
WebDriver driver = new ChromeDriver();
```
ఇది Chrome browser తెరుస్తుంది. `WebDriver` ఒక interface, `ChromeDriver` దాని implementation.

```java
driver.get("https://www.google.com");
```
Chrome browser లో Google.com open చేస్తుంది. `get()` method URL కి navigate చేస్తుంది.

```java
String title = driver.getTitle();
```
Current page యొక్క title (browser tab లో కనిపించేది) return చేస్తుంది.

```java
driver.quit();
```
Browser close చేసి, WebDriver session end చేస్తుంది.

### Important Terms

**WebDriver** — Browser control చేసే interface
**ChromeDriver** — Chrome specific implementation
**`driver.get(url)`** — URL కి navigate చేయడం
**`driver.getTitle()`** — Page title తెచ్చుకోవడం
**`driver.quit()`** — Browser మరియు session close చేయడం

### Common Mistakes

1. **`driver.quit()` రాయడం మర్చిపోవడం** — Browser open గా ఉంటుంది, memory waste అవుతుంది. Always `finally` block లో close చేయండి.

2. **`close()` vs `quit()` confusion** — `close()` current tab మాత్రమే close చేస్తుంది. `quit()` అన్నీ close చేసి session end చేస్తుంది.

3. **Window maximize చేయకపోవడం** — కొన్ని elements చిన్న window లో కనిపించకపోవచ్చు. `driver.manage().window().maximize()` always call చేయండి.

### Pro Tips

**Pro Tip 1:** Always `driver.quit()` — `driver.close()` కాదు. `quit()` browser + session రెండూ close చేస్తుంది.

**Pro Tip 2:** Selenium 4 లో ChromeDriver manually set చేయాల్సిన అవసరం లేదు. Selenium Manager automatically handle చేస్తుంది.

**Pro Tip 3:** `driver.quit()` ని `finally` block లో రాయండి — test fail అయినా browser close అవుతుంది.

</details>

---

## 10. Programming Fundamentals for Selenium

> **Note:** This section covers ONLY the programming concepts you actually need for Selenium. This is not a complete Java course. We focus on what matters for automation.

### 10.1 Variables and Data Types

<details>
<summary>Required Skill: Variables and Data Types (Click to learn)</summary>

## Variables and Data Types in Java

### What is a Variable?

A variable is a box that stores a value. You give the box a name so you can find it later.

```java
// Declaring and initializing variables
String url = "https://google.com";           // Text (String)
int waitTime = 10;                           // Whole number (int)
double priceOnPage = 29.99;                  // Decimal number (double)
boolean isLoggedIn = false;                  // True or False (boolean)
long pageLoadTime = 5000L;                   // Large number (long)

// Using variables in Selenium context
WebDriver driver = new ChromeDriver();
driver.get(url);                              // Using the url variable
driver.manage().timeouts().implicitlyWait(
    Duration.ofSeconds(waitTime)             // Using waitTime variable
);
```

### String Operations (Very Important in Selenium)

```java
String pageTitle = driver.getTitle();

// Check if title contains something
boolean hasKeyword = pageTitle.contains("Google");  // true or false

// Compare strings (NEVER use == for strings)
boolean isEqual = pageTitle.equals("Google");       // correct way
boolean equalsIgnoreCase = pageTitle.equalsIgnoreCase("google"); // ignores caps

// Get length
int titleLength = pageTitle.length();

// Extract part of string
String firstFive = pageTitle.substring(0, 5);

// Convert to lowercase
String lower = pageTitle.toLowerCase();

// Remove spaces from start and end
String trimmed = pageTitle.trim();

// Split into array
String[] words = pageTitle.split(" ");

// Check if empty
boolean isEmpty = pageTitle.isEmpty();
```

### In Selenium You Will Use These Often

```java
// Verify page title
String actualTitle = driver.getTitle();
assert actualTitle.equals("Expected Title") : "Title mismatch!";

// Extract text from element and verify
String productPrice = driver.findElement(By.id("price")).getText();
double price = Double.parseDouble(productPrice.replace("$", ""));

// Build dynamic XPaths
String username = "john_doe";
String xpath = "//input[@id='" + username + "']";
```

### Selenium-Specific Variable Tips

```java
// Store WebElement (avoid finding twice — performance)
WebElement searchBox = driver.findElement(By.name("q"));
searchBox.sendKeys("test");
searchBox.clear();
searchBox.sendKeys("new search");

// Store window handle
String mainWindow = driver.getWindowHandle();
// ... do stuff in new window ...
driver.switchTo().window(mainWindow); // come back
```

</details>

### 10.2 Conditional Statements

<details>
<summary>Required Skill: Conditional Statements (Click to learn)</summary>

## Conditional Statements in Java for Selenium

### if / else if / else

```java
// Basic if-else
String pageTitle = driver.getTitle();

if (pageTitle.equals("Google")) {
    System.out.println("Correct page!");
} else if (pageTitle.contains("Search")) {
    System.out.println("On search results page");
} else {
    System.out.println("Wrong page! Title: " + pageTitle);
}
```

### Real Selenium Usage — Check Element State

```java
// Check if button is enabled before clicking
WebElement submitButton = driver.findElement(By.id("submit"));

if (submitButton.isEnabled()) {
    submitButton.click();
    System.out.println("Button clicked successfully");
} else {
    System.out.println("Button is disabled — cannot click");
}

// Check if element is displayed
WebElement errorMessage = driver.findElement(By.id("error"));

if (errorMessage.isDisplayed()) {
    System.out.println("Error found: " + errorMessage.getText());
} else {
    System.out.println("No error — login successful");
}

// Check if checkbox is selected
WebElement agreeCheckbox = driver.findElement(By.id("agree"));

if (!agreeCheckbox.isSelected()) {  // if NOT selected
    agreeCheckbox.click();          // click to select
}
```

### Ternary Operator (Short If-Else)

```java
// Standard way
String status;
if (driver.findElement(By.id("loginBtn")).isEnabled()) {
    status = "ENABLED";
} else {
    status = "DISABLED";
}

// Ternary way (shorter)
String status = driver.findElement(By.id("loginBtn")).isEnabled() 
                ? "ENABLED" : "DISABLED";
```

### Switch Statement (for Multiple Cases)

```java
String browser = "chrome"; // from config

WebDriver driver;
switch (browser.toLowerCase()) {
    case "chrome":
        driver = new ChromeDriver();
        break;
    case "firefox":
        driver = new FirefoxDriver();
        break;
    case "edge":
        driver = new EdgeDriver();
        break;
    default:
        throw new IllegalArgumentException("Unknown browser: " + browser);
}
```

</details>

### 10.3 Loops

<details>
<summary>Required Skill: Loops (Click to learn)</summary>

## Loops in Java for Selenium

### for Loop — When You Know How Many Times

```java
// Click radio button 3 times? Not likely, but loops are useful for:

// Example: Test 5 different URLs
String[] urls = {
    "https://google.com",
    "https://amazon.com",
    "https://facebook.com",
    "https://twitter.com",
    "https://linkedin.com"
};

for (int i = 0; i < urls.length; i++) {
    driver.get(urls[i]);
    System.out.println("Page " + (i+1) + " title: " + driver.getTitle());
}
```

### for-each Loop — Most Common in Selenium

```java
// Get all links on a page and verify them
List<WebElement> allLinks = driver.findElements(By.tagName("a"));

System.out.println("Total links found: " + allLinks.size());

for (WebElement link : allLinks) {
    String text = link.getText();
    String href = link.getAttribute("href");
    System.out.println("Link text: " + text + " | URL: " + href);
}
```

### while Loop — When Condition Drives the Loop

```java
// Wait until page title changes (polling approach)
String desiredTitle = "Dashboard";
int maxAttempts = 10;
int attempts = 0;

while (!driver.getTitle().equals(desiredTitle) && attempts < maxAttempts) {
    System.out.println("Waiting... Attempt: " + attempts + " | Title: " + driver.getTitle());
    Thread.sleep(1000);  // Wait 1 second
    attempts++;
}

if (driver.getTitle().equals(desiredTitle)) {
    System.out.println("Title matched! Test passed.");
} else {
    System.out.println("Title never became: " + desiredTitle);
}
```

### Selenium-Specific Loop Patterns

```java
// Pattern 1: Find all rows in a table and extract data
List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']//tr"));

for (int i = 1; i < rows.size(); i++) {  // Start at 1 to skip header
    WebElement row = rows.get(i);
    List<WebElement> cells = row.findElements(By.tagName("td"));
    
    System.out.println("Row " + i + ": " + cells.get(0).getText() + 
                       " | " + cells.get(1).getText());
}

// Pattern 2: Find element from list by text
List<WebElement> options = driver.findElements(By.className("option-item"));
String targetText = "Electronics";

for (WebElement option : options) {
    if (option.getText().equals(targetText)) {
        option.click();
        System.out.println("Clicked: " + targetText);
        break;  // Stop looping once found
    }
}
```

</details>

### 10.4 Methods (Functions)

<details>
<summary>Required Skill: Methods and Functions (Click to learn)</summary>

## Methods in Java for Selenium

### Why Methods?

Without methods, you would copy-paste the same code everywhere. If the login page changes, you would have to update 50 places. With methods, update ONE place.

```java
// WITHOUT methods — bad approach
// Script 1
driver.get("https://example.com");
driver.findElement(By.id("username")).sendKeys("admin");
driver.findElement(By.id("password")).sendKeys("secret123");
driver.findElement(By.id("loginBtn")).click();

// Script 2 — copied! If UI changes, update in 2 places
driver.get("https://example.com");
driver.findElement(By.id("username")).sendKeys("admin");
driver.findElement(By.id("password")).sendKeys("secret123");
driver.findElement(By.id("loginBtn")).click();

// WITH methods — good approach
public void loginToApplication(String username, String password) {
    driver.get("https://example.com");
    driver.findElement(By.id("username")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("loginBtn")).click();
}

// Usage — easy to call anywhere
loginToApplication("admin", "secret123");
loginToApplication("testuser1", "pass456");
```

### Method Types in Selenium Context

```java
// 1. void method — performs action, returns nothing
public void clickButton(By locator) {
    driver.findElement(locator).click();
}

// 2. String method — performs action, returns text
public String getElementText(By locator) {
    return driver.findElement(locator).getText();
}

// 3. boolean method — performs action, returns true/false
public boolean isElementDisplayed(By locator) {
    try {
        return driver.findElement(locator).isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}

// 4. WebElement method — returns element for further use
public WebElement findElement(By locator) {
    return driver.findElement(locator);
}
```

### Common Helper Methods You Will Use in Every Project

```java
public class SeleniumUtils {
    
    private WebDriver driver;
    
    // Constructor
    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
    }
    
    // Click method with error message
    public void click(By locator, String elementName) {
        try {
            driver.findElement(locator).click();
            System.out.println("Clicked: " + elementName);
        } catch (Exception e) {
            System.out.println("Failed to click: " + elementName + " | Error: " + e.getMessage());
        }
    }
    
    // Type method
    public void type(By locator, String text, String fieldName) {
        WebElement element = driver.findElement(locator);
        element.clear();         // Clear existing text first
        element.sendKeys(text);
        System.out.println("Typed '" + text + "' in: " + fieldName);
    }
    
    // Get text method
    public String getText(By locator, String elementName) {
        String text = driver.findElement(locator).getText();
        System.out.println(elementName + " text: " + text);
        return text;
    }
    
    // Verify title
    public boolean verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        boolean result = actualTitle.equals(expectedTitle);
        System.out.println("Title verification: " + (result ? "PASS" : "FAIL") + 
                          " | Expected: " + expectedTitle + " | Actual: " + actualTitle);
        return result;
    }
}
```

</details>

### 10.5 Object-Oriented Programming (OOP) for Selenium

<details>
<summary>Required Skill: OOP Basics for Selenium (Click to learn)</summary>

## OOP Basics — Only What You Need for Selenium

Selenium is written using OOP principles. Understanding basics will help you write better test code and understand why Page Object Model (Part 4) works the way it does.

### Class and Object

A **Class** is a blueprint. An **Object** is something created from that blueprint.

```java
// Class — the blueprint
public class LoginPage {
    
    // Fields (variables that belong to this class)
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginBtn");
    
    // Constructor — called when creating object
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Methods — actions this class can perform
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    // Combined method
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}

// Creating object from the class
LoginPage loginPage = new LoginPage(driver);  // Object created
loginPage.login("admin", "password123");       // Using the object
```

### Why This Matters for Selenium

The **Page Object Model** (Part 4) is entirely based on OOP:
- Each web page = One class
- Each UI action = One method
- Tests create objects from page classes

```java
// Real usage of OOP in tests
WebDriver driver = new ChromeDriver();

// Create page objects
LoginPage loginPage = new LoginPage(driver);
DashboardPage dashboardPage = new DashboardPage(driver);
ProductPage productPage = new ProductPage(driver);

// Use them in test
driver.get("https://example.com");
loginPage.login("user@test.com", "Pass123");
dashboardPage.clickOnProducts();
productPage.addProductToCart("Laptop");
```

### Inheritance for Selenium

```java
// Base class — shared setup for all tests
public class BaseTest {
    
    protected WebDriver driver;  // 'protected' means child classes can use it
    
    // This runs BEFORE each test
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    // This runs AFTER each test
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

// Child class — inherits driver setup from BaseTest
public class LoginTest extends BaseTest {
    
    // Just write the test logic — no need to set up driver again!
    public void testSuccessfulLogin() {
        setUp();  // From parent class
        
        driver.get("https://example.com");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("pass123");
        driver.findElement(By.id("login")).click();
        
        tearDown();  // From parent class
    }
}
```

### Encapsulation

Keep internal details private. Only expose what others need to use.

```java
public class LoginPage {
    private WebDriver driver;
    
    // Private — nobody outside can directly touch these locators
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    
    // Public — this is what tests call
    public void login(String user, String pass) {
        driver.findElement(usernameInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(pass);
    }
    
    // Test code cannot accidentally break your locators!
}
```

</details>

### 10.6 Exception Handling

<details>
<summary>Required Skill: Exception Handling (Click to learn)</summary>

## Exception Handling in Java for Selenium

### What is an Exception?

An exception is an unexpected error that stops your program. In Selenium, exceptions happen often:
- Element not found? → `NoSuchElementException`
- Element stale? → `StaleElementReferenceException`
- Browser crashed? → `WebDriverException`

Without handling exceptions, your entire test suite crashes when one thing goes wrong.

### Try-Catch-Finally

```java
try {
    // Code that MIGHT throw an exception
    WebElement element = driver.findElement(By.id("loginBtn"));
    element.click();
    
} catch (NoSuchElementException e) {
    // Code that runs IF exception occurs
    System.out.println("Login button not found! " + e.getMessage());
    
} catch (ElementNotInteractableException e) {
    // Different exception type
    System.out.println("Login button found but cannot click! " + e.getMessage());
    
} finally {
    // ALWAYS runs — success or failure
    System.out.println("This always prints");
    driver.quit();  // Always close browser
}
```

### Common Selenium Exceptions

```java
// 1. NoSuchElementException — Element not found
try {
    driver.findElement(By.id("notExistingId"));
} catch (NoSuchElementException e) {
    System.out.println("Element not found — check your locator");
}

// 2. TimeoutException — Element didn't appear in time
try {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
} catch (TimeoutException e) {
    System.out.println("Element didn't appear within 10 seconds");
}

// 3. StaleElementReferenceException — Element reference is outdated
try {
    WebElement element = driver.findElement(By.id("btn"));
    driver.navigate().refresh();         // Page refreshed!
    element.click();                     // This will throw StaleElementReferenceException
} catch (StaleElementReferenceException e) {
    // Re-find the element
    driver.findElement(By.id("btn")).click();
}

// 4. ElementNotInteractableException — Element exists but not clickable
try {
    driver.findElement(By.id("hiddenBtn")).click();
} catch (ElementNotInteractableException e) {
    System.out.println("Element is hidden or disabled");
    // Try JavaScript click instead
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click()", driver.findElement(By.id("hiddenBtn")));
}
```

### Safe Element Finding Pattern

```java
// Method that safely finds element without crashing
public WebElement findElementSafely(By locator) {
    try {
        return driver.findElement(locator);
    } catch (NoSuchElementException e) {
        System.out.println("Element not found: " + locator.toString());
        return null;
    }
}

// Usage
WebElement element = findElementSafely(By.id("username"));
if (element != null) {
    element.sendKeys("testuser");
} else {
    System.out.println("Skipping this step — element not found");
}
```

</details>

### 10.7 Collections for Selenium

<details>
<summary>Required Skill: Collections (ArrayList, HashMap, HashSet) (Click to learn)</summary>

## Collections in Java — Only What Selenium Needs

### ArrayList — Ordered List of Items

```java
import java.util.ArrayList;
import java.util.List;

// Most common in Selenium: storing multiple WebElements
List<WebElement> allButtons = driver.findElements(By.tagName("button"));
// 'findElements' always returns List<WebElement>

// Loop through all buttons
for (WebElement button : allButtons) {
    System.out.println("Button text: " + button.getText());
}

// Get specific element
WebElement firstButton = allButtons.get(0);   // First element
WebElement lastButton = allButtons.get(allButtons.size() - 1);  // Last

// Size
System.out.println("Total buttons: " + allButtons.size());

// Storing window handles
List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
String mainWindow = windowHandles.get(0);
String newWindow = windowHandles.get(1);
```

### HashMap — Key-Value Pairs

```java
import java.util.HashMap;
import java.util.Map;

// Store test data
Map<String, String> loginData = new HashMap<>();
loginData.put("username", "testuser@example.com");
loginData.put("password", "Secret123");
loginData.put("expectedTitle", "Dashboard");

// Use in test
driver.findElement(By.id("user")).sendKeys(loginData.get("username"));
driver.findElement(By.id("pass")).sendKeys(loginData.get("password"));

// Verify
String actualTitle = driver.getTitle();
String expectedTitle = loginData.get("expectedTitle");
assert actualTitle.equals(expectedTitle);

// Store multiple test scenarios
Map<String, Map<String, String>> testScenarios = new HashMap<>();

Map<String, String> scenario1 = new HashMap<>();
scenario1.put("username", "admin@test.com");
scenario1.put("password", "Admin123");
scenario1.put("expectedResult", "success");

Map<String, String> scenario2 = new HashMap<>();
scenario2.put("username", "invalid@test.com");
scenario2.put("password", "wrongpass");
scenario2.put("expectedResult", "error");

testScenarios.put("ValidLogin", scenario1);
testScenarios.put("InvalidLogin", scenario2);
```

### HashSet — Unique Values

```java
import java.util.HashSet;
import java.util.Set;

// Get all window handles (returns Set — all handles are unique)
Set<String> handles = driver.getWindowHandles();

// Finding duplicate link texts on a page
Set<String> uniqueLinkTexts = new HashSet<>();
List<WebElement> allLinks = driver.findElements(By.tagName("a"));

for (WebElement link : allLinks) {
    String text = link.getText();
    if (!uniqueLinkTexts.add(text)) {  // add() returns false if duplicate
        System.out.println("Duplicate link text found: " + text);
    }
}
```

</details>

---

## 11. Big Practical Projects

Now it is time to apply everything from Part 1. These are real projects you can build and put on GitHub.

---

### Project 1: Website Health Check Monitor

**What it does:** Checks a list of websites every hour. Reports which ones are up, which are down, and what their page titles are.

**Skills used:** Variables, loops, methods, exception handling, Selenium basics

```java
// File: src/test/java/projects/WebsiteHealthChecker.java

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class WebsiteHealthChecker {
    
    private WebDriver driver;
    
    // Setup driver with options
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
    }
    
    // Check a single website
    public Map<String, String> checkWebsite(String url) {
        Map<String, String> result = new HashMap<>();
        result.put("url", url);
        
        try {
            driver.get(url);
            Thread.sleep(3000);  // Wait for page to load
            
            result.put("status", "UP");
            result.put("title", driver.getTitle());
            result.put("currentUrl", driver.getCurrentUrl());
            
        } catch (Exception e) {
            result.put("status", "DOWN");
            result.put("error", e.getMessage());
            result.put("title", "N/A");
        }
        
        return result;
    }
    
    // Check multiple websites and generate report
    public void runHealthCheck() {
        String[] websites = {
            "https://www.google.com",
            "https://www.github.com",
            "https://www.stackoverflow.com",
            "https://www.selenium.dev",
            "https://thiswebsitedoesnotexist12345.com"  // This will fail
        };
        
        setupDriver();
        
        System.out.println("=".repeat(60));
        System.out.println("WEBSITE HEALTH CHECK REPORT");
        System.out.println("=".repeat(60));
        
        int upCount = 0;
        int downCount = 0;
        
        for (String url : websites) {
            Map<String, String> result = checkWebsite(url);
            
            String status = result.get("status");
            System.out.println("\nURL: " + url);
            System.out.println("Status: " + status);
            System.out.println("Title: " + result.get("title"));
            
            if (status.equals("UP")) upCount++;
            else downCount++;
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SUMMARY:");
        System.out.println("Total Checked: " + websites.length);
        System.out.println("UP: " + upCount);
        System.out.println("DOWN: " + downCount);
        System.out.println("=".repeat(60));
        
        driver.quit();
    }
    
    public static void main(String[] args) {
        new WebsiteHealthChecker().runHealthCheck();
    }
}
```

**Expected Output:**
```
============================================================
WEBSITE HEALTH CHECK REPORT
============================================================

URL: https://www.google.com
Status: UP
Title: Google

URL: https://www.github.com
Status: UP
Title: GitHub: Let's build from here

...

============================================================
SUMMARY:
Total Checked: 5
UP: 4
DOWN: 1
============================================================
```

---

### Project 2: Google Search Automation with Results Extraction

**What it does:** Searches Google for any keyword, extracts top 10 search results (title + URL), and saves to a file.

```java
// File: src/test/java/projects/GoogleSearchAutomation.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GoogleSearchAutomation {
    
    private WebDriver driver;
    
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    
    public void searchAndExtract(String keyword, String outputFile) throws IOException {
        // Navigate to Google
        driver.get("https://www.google.com");
        
        // Find search box and type
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword);
        searchBox.submit();
        
        // Wait for results
        try { Thread.sleep(2000); } catch (InterruptedException e) { }
        
        // Find all search result titles
        List<WebElement> resultTitles = driver.findElements(By.cssSelector("h3.LC20lb"));
        List<WebElement> resultUrls = driver.findElements(By.cssSelector("div.yuRUbf a"));
        
        // Save to file
        FileWriter writer = new FileWriter(outputFile);
        writer.write("Search Results for: " + keyword + "\n");
        writer.write("=".repeat(50) + "\n\n");
        
        int count = Math.min(resultTitles.size(), 10);  // Top 10
        
        for (int i = 0; i < count; i++) {
            String title = resultTitles.get(i).getText();
            String url = "";
            
            if (i < resultUrls.size()) {
                url = resultUrls.get(i).getAttribute("href");
            }
            
            System.out.println((i+1) + ". " + title);
            System.out.println("   " + url);
            
            writer.write((i+1) + ". " + title + "\n");
            writer.write("   URL: " + url + "\n\n");
        }
        
        writer.close();
        System.out.println("\nResults saved to: " + outputFile);
    }
    
    public void tearDown() {
        if (driver != null) driver.quit();
    }
    
    public static void main(String[] args) {
        GoogleSearchAutomation search = new GoogleSearchAutomation();
        try {
            search.setup();
            search.searchAndExtract("Selenium WebDriver tutorial", "search_results.txt");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        } finally {
            search.tearDown();
        }
    }
}
```

---

### Project 3: Form Automation — Registration Form Tester

**What it does:** Fills and submits registration forms with different data combinations. Tests valid and invalid scenarios.

```java
// File: src/test/java/projects/FormAutomation.java
// Using: https://demoqa.com/automation-practice-form

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormAutomation {
    
    private WebDriver driver;
    
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    public void fillRegistrationForm(String firstName, String lastName, 
                                      String email, String mobile) {
        
        driver.get("https://demoqa.com/automation-practice-form");
        
        // Scroll down to avoid sticky header issues
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 200)");
        
        // Fill First Name
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        System.out.println("Filled First Name: " + firstName);
        
        // Fill Last Name
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        System.out.println("Filled Last Name: " + lastName);
        
        // Fill Email
        driver.findElement(By.id("userEmail")).sendKeys(email);
        System.out.println("Filled Email: " + email);
        
        // Select Gender (Male)
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        System.out.println("Selected Gender: Male");
        
        // Fill Mobile
        driver.findElement(By.id("userNumber")).sendKeys(mobile);
        System.out.println("Filled Mobile: " + mobile);
        
        // Scroll down to Submit button
        js.executeScript("window.scrollTo(0, 600)");
        
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
        
        // Click Submit
        driver.findElement(By.id("submit")).click();
        
        // Verify submission
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
        
        try {
            WebElement confirmModal = driver.findElement(By.id("example-modal-sizes-title-lg"));
            if (confirmModal.isDisplayed()) {
                System.out.println("SUCCESS: Form submitted! Modal title: " + confirmModal.getText());
            }
        } catch (Exception e) {
            System.out.println("Form submission may have failed or modal not appeared");
        }
    }
    
    public void tearDown() {
        if (driver != null) driver.quit();
    }
    
    public static void main(String[] args) {
        FormAutomation form = new FormAutomation();
        
        try {
            form.setup();
            
            // Test with valid data
            System.out.println("\n--- Test Case 1: Valid Data ---");
            form.fillRegistrationForm("Venkata", "Bharath", "vb@test.com", "9876543210");
            
            Thread.sleep(2000);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            form.tearDown();
        }
    }
}
```

---

### Project 4: Browser Information Collector

**What it does:** Opens multiple websites, collects information (title, URL, page size) and creates a comparative report.

```java
// File: src/test/java/projects/BrowserInfoCollector.java

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BrowserInfoCollector {
    
    record PageInfo(String url, String title, String currentUrl,
                    int pageSourceLength, boolean isRedirected) {}
    
    public static void main(String[] args) {
        
        String[] targetUrls = {
            "https://www.google.com",
            "https://www.amazon.com",
            "https://www.wikipedia.org",
            "https://www.github.com",
            "https://www.selenium.dev"
        };
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        List<PageInfo> results = new ArrayList<>();
        
        for (String url : targetUrls) {
            try {
                driver.get(url);
                Thread.sleep(2000);
                
                PageInfo info = new PageInfo(
                    url,
                    driver.getTitle(),
                    driver.getCurrentUrl(),
                    driver.getPageSource().length(),
                    !url.equals(driver.getCurrentUrl())  // Was there a redirect?
                );
                
                results.add(info);
                
            } catch (Exception e) {
                System.out.println("Failed for: " + url + " | " + e.getMessage());
            }
        }
        
        driver.quit();
        
        // Print Report
        System.out.println("\n" + "=".repeat(80));
        System.out.printf("%-40s | %-30s | %10s | %s%n",
                         "URL", "Title", "Size (KB)", "Redirected");
        System.out.println("=".repeat(80));
        
        for (PageInfo info : results) {
            System.out.printf("%-40s | %-30s | %10.1f | %s%n",
                info.url().substring(0, Math.min(38, info.url().length())),
                info.title().substring(0, Math.min(28, info.title().length())),
                info.pageSourceLength() / 1024.0,
                info.isRedirected() ? "YES → " + info.currentUrl() : "NO"
            );
        }
        System.out.println("=".repeat(80));
    }
}
```

---

### Project 5: Automated Login and Dashboard Verifier

**What it does:** Tests login functionality on a demo application with multiple user types. Reports pass/fail for each scenario.

```java
// File: src/test/java/projects/LoginVerifier.java
// Using: https://the-internet.herokuapp.com/login

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LoginVerifier {
    
    private WebDriver driver;
    
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    public Map<String, String> testLogin(String username, String password, 
                                          String expectedResult) {
        Map<String, String> result = new HashMap<>();
        result.put("username", username);
        result.put("expectedResult", expectedResult);
        
        try {
            driver.get("https://the-internet.herokuapp.com/login");
            
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            
            Thread.sleep(1000);
            
            // Check for success message
            List<WebElement> successMsg = driver.findElements(
                By.cssSelector(".flash.success")
            );
            List<WebElement> errorMsg = driver.findElements(
                By.cssSelector(".flash.error")
            );
            
            if (!successMsg.isEmpty()) {
                result.put("actualResult", "success");
                result.put("message", successMsg.get(0).getText().trim());
            } else if (!errorMsg.isEmpty()) {
                result.put("actualResult", "error");
                result.put("message", errorMsg.get(0).getText().trim());
            } else {
                result.put("actualResult", "unknown");
                result.put("message", "No success or error message found");
            }
            
            // Determine PASS/FAIL
            boolean passed = result.get("actualResult").equals(expectedResult);
            result.put("testStatus", passed ? "PASS" : "FAIL");
            
        } catch (Exception e) {
            result.put("actualResult", "exception");
            result.put("message", e.getMessage());
            result.put("testStatus", "FAIL");
        }
        
        return result;
    }
    
    public void runAllTests() {
        setup();
        
        // Test scenarios
        Object[][] scenarios = {
            {"tomsmith", "SuperSecretPassword!", "success"},
            {"tomsmith", "wrongpassword", "error"},
            {"wronguser", "SuperSecretPassword!", "error"},
            {"", "", "error"},
            {"tomsmith", "", "error"}
        };
        
        List<Map<String, String>> results = new ArrayList<>();
        
        for (Object[] scenario : scenarios) {
            Map<String, String> result = testLogin(
                (String) scenario[0],
                (String) scenario[1],
                (String) scenario[2]
            );
            results.add(result);
        }
        
        driver.quit();
        
        // Print report
        System.out.println("\n" + "=".repeat(70));
        System.out.println("LOGIN TEST REPORT");
        System.out.println("=".repeat(70));
        
        int passed = 0, failed = 0;
        
        for (Map<String, String> result : results) {
            String status = result.get("testStatus");
            System.out.printf("%-15s | Expected: %-8s | Actual: %-8s | %s%n",
                result.get("username").isEmpty() ? "(empty)" : result.get("username"),
                result.get("expectedResult"),
                result.get("actualResult"),
                status
            );
            
            if (status.equals("PASS")) passed++;
            else failed++;
        }
        
        System.out.println("=".repeat(70));
        System.out.println("TOTAL: " + (passed + failed) + " | PASS: " + passed + " | FAIL: " + failed);
        System.out.println("=".repeat(70));
    }
    
    public static void main(String[] args) {
        new LoginVerifier().runAllTests();
    }
}
```

---

## Summary: What You Have Learned in Part 1

```
PART 1 KNOWLEDGE CHECKLIST:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

✅ Software Testing fundamentals
✅ Manual vs Automation — when to use which
✅ Types of Testing — Functional, Regression, Smoke, E2E, Cross-browser
✅ SDLC and STLC — where testing fits
✅ Agile and Scrum — tester's role in sprints
✅ Selenium components — IDE, WebDriver, Grid, Manager
✅ Selenium Architecture — how code talks to browser
✅ Environment Setup — JDK, IntelliJ, Maven, Selenium
✅ First Selenium Script — open, navigate, verify, close
✅ Programming Fundamentals:
   ✅ Variables and data types
   ✅ Conditional statements
   ✅ Loops
   ✅ Methods
   ✅ OOP basics (Class, Object, Inheritance, Encapsulation)
   ✅ Exception handling
   ✅ Collections (ArrayList, HashMap, HashSet)
✅ 5 Practical Projects
```

## Ready for Part 2?

In **Part 2**, you will deep-dive into:
- All WebDriver methods
- The MOST IMPORTANT topic: **Locators** (ID, CSS, XPath — with extreme detail)
- All WebElement operations
- Handling dropdowns, tables, radio buttons
- Browser navigation and timeouts

**Part 2 is where real Selenium skills begin. Let's go.**

---

*Part 01 — Foundation | Part of the Complete Telugu Selenium Learning Series*
*Next: Part-02-Selenium-Core-WebDriver.md*
