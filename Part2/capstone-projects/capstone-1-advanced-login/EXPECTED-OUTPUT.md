# Capstone 1: Advanced Login Testing

[Back to CAPSTONE-README.md](../CAPSTONE-README.md) | [PROJECT-BRIEF.md](PROJECT-BRIEF.md) | [PROFESSIONAL-APPROACH.md](PROFESSIONAL-APPROACH.md) | [LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md) | [COMPLETE-SOLUTION.java](COMPLETE-SOLUTION.java)

---

📌 What Is This File?
----------------------
This is the **EXPECTED OUTPUT** file — what you should see when you run the tests.

Think of it as **the answer key for your tests**. It tells you:

- What the terminal shows when you run `mvn test`
- What each scenario's output looks like
- What the final test report summary looks like
- What to do if your test fails

**Why this file matters:** After running your tests, compare your output with this file. If they match, your code is working correctly. If they don't, this file helps you debug.

---

## Expected Output - What You Should See

### How to Run the Tests

In GitHub Codespaces or your local terminal:

```
mvn test
```

### You Should See This Output

```
=== SCENARIO 1: VALID LOGIN - HAPPY PATH ===
Step 1: Opened login page - demoqa.com/login
Step 2: Entered valid email: student
Step 3: Entered valid password
Step 4: Clicked Login button
Step 5: SUCCESS - Profile page loaded, valid login passed!
=== SCENARIO 1: PASSED ===

=== SCENARIO 2: INVALID EMAIL FORMAT ===
Step 1: Opened login page
Step 2: Entered email WITHOUT @ symbol: invalidemail
Step 3: Entered valid password
Step 4: Clicked Login button
Step 5: Error message: Invalid email address
=== SCENARIO 2: PASSED ===

=== SCENARIO 3: EMAIL NOT REGISTERED ===
Step 1: Opened login page
Step 2: Entered unregistered email: nonexistent@example.com
Step 3: Entered valid password
Step 4: Clicked Login button
Step 5: Error message: User not found
=== SCENARIO 3: PASSED ===

=== SCENARIO 4: EMPTY EMAIL FIELD ===
Step 1: Opened login page
Step 2: Left email field EMPTY (no text entered)
Step 3: Entered valid password
Step 4: Clicked Login button
Step 5: Error message: Email address required
=== SCENARIO 4: PASSED ===

=== SCENARIO 5: EMPTY PASSWORD FIELD ===
Step 1: Opened login page
Step 2: Entered valid email: student
Step 3: Left password field EMPTY (no text entered)
Step 4: Clicked Login button
Step 5: Error message: Password required
=== SCENARIO 5: PASSED ===
```

### Test Report Summary

| Scenario | What We Test | Expected Result | Status |
|----------|-------------|-----------------|--------|
| 1. Valid Login | Correct email and password | Profile page loads, username shown | PASSED |
| 2. Invalid Email Format | Email without @ symbol | Error: "Invalid email address" | PASSED |
| 3. Email Not Registered | Fake email (nonexistent@example.com) | Error: "User not found" | PASSED |
| 4. Empty Email Field | Email field left blank | Error: "Email address required" | PASSED |
| 5. Empty Password Field | Password field left blank | Error: "Password required" | PASSED |

**TOTAL: 5/5 PASSED 🎉**

### Test Report Table

```
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
```

### What to Do If Test Fails?

Check these 5 things in order:

| Check # | What to Check | How to Fix |
|---------|--------------|------------|
| 1 | Is the website URL correct? | Check LOGIN_URL = "https://demoqa.com/login" |
| 2 | Did element IDs change on the page? | Inspect page (F12) and update IDs in code |
| 3 | Is the website loading slowly? | Increase implicit wait from 10 to 15 seconds |
| 4 | Is the error message text different? | Update the text in Assert.assertTrue() message |
| 5 | Is internet connection stable? | Check your network, then re-run the test |

> **Expert Tip:** If ALL 5 tests fail, the problem is usually in the setUp() method (browser not opening). If only SOME tests fail, the problem is usually in a specific test method or the website changed its elements.

<details>
<summary><strong>🌐 తెలుగు - టెస్ట్ ఫెయిల్ అయితే ఏమి చేయాలి - క్లిక్ చేసి చదవండి</strong></summary>

| చెక్ నంబర్ | ఏమి చెక్ చేయాలి | ఎలా ఫిక్స్ చేయాలి |
|---------|--------------|------------|
| 1 | వెబ్సైట్ URL సరైనదా? | LOGIN_URL = "https://demoqa.com/login" చెక్ చేయండి |
| 2 | పేజీ మీద ఎలిమెంట్ IDs మార్చబడ్డాయా? | పేజీ ఇన్స్పెక్ట్ చేయండి (F12) మరియు కోడ్ లో IDs అప్డేట్ చేయండి |
| 3 | వెబ్సైట్ నెమ్మదిగా లోడ్ అవుతుందా? | implicit wait 10 నుండి 15 సెకన్లకు పెంచండి |
| 4 | ఎర్రర్ మెసేజ్ టెక్స్ట్ వేరేగా ఉందా? | Assert.assertTrue() మెసేజ్ లో టెక్స్ట్ అప్డేట్ చేయండి |
| 5 | ఇంటర్నెట్ కనెక్షన్ స్థిరంగా ఉందా? | నెట్‌వర్క్ చెక్ చేయండి, ఆపై టెస్ట్ రీ-రన్ చేయండి |

> **ఎక్స్‌పర్ట్ టిప్:** అన్నీ 5 టెస్ట్లు ఫెయిల్ అయితే, సమస్య సాధారణంగా setUp() మెథడ్ లో ఉంటుంది (బ్రౌజర్ తెరవడం లేదు). కొన్ని టెస్ట్లు మాత్రమే ఫెయిల్ అయితే, సమస్య సాధారణంగా నిర్దిష్ట టెస్ట్ మెథడ్ లేదా వెబ్సైట్ ఎలిమెంట్స్ మారడంలో ఉంటుంది.

</details>

### Code Coverage per Scenario

| Scenario | Lines of Code | Selenium Methods Used | Java Methods Used |
|----------|--------------|----------------------|------------------|
| 1. Valid Login | 15 lines | get(), findElement(), sendKeys(), click(), isDisplayed() | println() |
| 2. Invalid Email | 15 lines | get(), findElement(), sendKeys(), click(), isDisplayed() | println() |
| 3. Unregistered | 15 lines | get(), findElement(), sendKeys(), click(), isDisplayed() | println() |
| 4. Empty Email | 15 lines | get(), findElement(), clear(), click(), isDisplayed() | println() |
| 5. Empty Password | 15 lines | get(), findElement(), sendKeys(), clear(), click(), isDisplayed() | println() |

---

### 🔗 Jump to other files
[→ Open CAPSTONE-README.md](../CAPSTONE-README.md)
[→ Open PROJECT-BRIEF.md](PROJECT-BRIEF.md)
[→ Open PROFESSIONAL-APPROACH.md](PROFESSIONAL-APPROACH.md)
[→ Open LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md)
[→ Open COMPLETE-SOLUTION.java](COMPLETE-SOLUTION.java)

[↑ Back to Top](#capstone-1-advanced-login-testing)
