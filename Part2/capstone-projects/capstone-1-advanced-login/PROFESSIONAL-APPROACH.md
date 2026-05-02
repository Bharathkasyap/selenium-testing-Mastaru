# Capstone 1: Advanced Login Testing

[← Back to CAPSTONE-README.md](../CAPSTONE-README.md) | [PROJECT-BRIEF.md](PROJECT-BRIEF.md) | [LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md) | [COMPLETE-SOLUTION.java](COMPLETE-SOLUTION.java) | [EXPECTED-OUTPUT.md](EXPECTED-OUTPUT.md)

---

📌 What Is This File?
----------------------
This is the **PROFESSIONAL APPROACH** file — the second file you read in every capstone project.

Think of it as **how your brain works when you receive a client request**. It tells you:

- How an expert tester thinks when they receive a project
- What questions they ask BEFORE starting work
- How they design test scenarios
- The step-by-step approach to solving the problem

**Why this file matters:** In a real job, the client doesn't tell you HOW to test. They just tell you WHAT to test. You need to figure out the approach yourself. This file shows you exactly how a 6-year experienced tester thinks.

---

## Professional Approach - How Experts Think

### 📌 File Navigation (Jump to any section)
- [Step 1](#step-1-understand-the-website-before-touching-it)
- [Step 2](#step-2-understand-what-login-really-means)
- [Step 3](#step-3-what-could-go-wrong)
- [Step 4](#step-4-design-test-scenarios)
- [Step 5](#step-5-kick-off-meeting-questions)
- [Step 6](#step-6-my-expert-recommendations)

---

### Step 1: Understand the Website Before Touching It

When I first received the PROJECT-BRIEF, I did NOT start writing code. I did this first:

1. **Visited the website manually** — I opened demoqa.com/login in my browser
2. **Looked at every element** — I noted: username field, password field, login button, error message area
3. **Found the element IDs and names** — I inspected the page (F12) to see what selectors Selenium will need
4. **Tried logging in myself** — I used the test credentials to see what success looks like
5. **Tried wrong credentials** — I entered wrong password to see the error message

> **Expert Tip:** Never write a single line of code until you have manually tested the website at least once. You need to know what "success" and "failure" look like before you can automate it.

<details>
<summary><strong>🌐 తెలుగు - స్టెప్ 1: వెబ్సైట్ ను టచ్ చేసే ముందు అర్థం చేసుకోండి - క్లిక్ చేసి చదవండి</strong></summary>

నాకు PROJECT-BRIEF వచ్చినప్పుడు, నేను వెంటనే కోడ్ రాయలేదు. నేను ముందు ఇవి చేశాను:

1. **వెబ్సైట్ ను మాన్యువల్ గా విజిట్ చేశాను** — నేను demoqa.com/login ను బ్రౌజర్ లో తెరిచాను
2. **ప్రతి ఎలిమెంట్ ను చూశాను** — యూజర్ పేరు ఫీల్డ్, పాస్‌వర్డ్ ఫీల్డ్, లాగిన్ బటన్, ఎర్రర్ మెసేజ్ ఏరియా నోట్ చేశాను
3. **ఎలిమెంట్ IDs మరియు names కనుగొన్నాను** — పేజీ ని ఇన్స్పెక్ట్ చేశాను (F12) Selenium కు ఏ సెలెక్టర్స్ కావాలో చూడటానికి
4. **స్వయంగా లాగిన్ చేయడానికి ప్రయత్నించాను** — సక్సెస్ ఎలా కనిపిస్తుందో చూడటానికి టెస్ట్ క్రెడెన్షియల్స్ వాడాను
5. **తప్పు క్రెడెన్షియల్స్ ప్రయత్నించాను** — ఎర్రర్ మెసేజ్ చూడటానికి తప్పు పాస్‌వర్డ్ ఎంటర్ చేశాను

> **ఎక్స్‌పర్ట్ టిప్:** వెబ్సైట్ ను మాన్యువల్ గా కనీసం ఒకసారి టెస్ట్ చేసేంత వరకు ఒక్క లైన్ కూడా కోడ్ రాయకండి. "సక్సెస్" మరియు "ఫెయిల్" ఎలా కనిపిస్తాయో మీకు తెలియాలి, అప్పుడే దానిని ఆటోమేట్ చేయగలరు.

</details>

### Step 2: Understand What Login Really Means

A login page is not just "username + password + button". As an expert, I think of login as:

| Element | What It Does | What Could Break |
|---------|-------------|-----------------|
| Username field | Accepts text input | What if left empty? What if too long? |
| Password field | Accepts text, hides it | What if wrong password? What if empty? |
| Login button | Submits the form | Does it work on click? Does it show loading? |
| Error area | Shows error messages | Does it show clear messages? |
| Session handling | Keeps user logged in | Does it expire? Does it remember? |

### Step 3: What Could Go Wrong?

I always make a list of every possible failure BEFORE testing:

1. User enters correct credentials → should show success
2. User enters wrong password → should show password error
3. User enters unregistered email → should show "not found" error  
4. User leaves email empty → should show "required" error
5. User leaves password empty → should show "required" error
6. Network is slow → website takes time to load
7. Browser closes unexpectedly → session lost

> **Expert Tip:** The best testers find bugs by thinking "what could go wrong?" The average testers only test "what should go right?"

<details>
<summary><strong>🌐 తెలుగు - స్టెప్ 3: ఏమి తప్పు జరగవచ్చు - క్లిక్ చేసి చదవండి</strong></summary>

టెస్టింగ్ కు ముందు ఎందుకైనా ఫెయిల్ జాబితా ఎప్పుడూ తయారు చేస్తాను:

1. యూజర్ సరైన క్రెడెన్షియల్స్ ఎంటర్ చేస్తాడు → సక్సెస్ చూపించాలి
2. యూజర్ తప్పు పాస్‌వర్డ్ ఎంటర్ చేస్తాడు → పాస్‌వర్డ్ ఎర్రర్ చూపించాలి
3. యూజర్ రిజిస్టర్ కాని ఇమెయిల్ ఎంటర్ చేస్తాడు → "నాట్ ఫౌండ్" ఎర్రర్ చూపించాలి
4. యూజర్ ఇమెయిల్ ఖాళీగా వదిలేస్తాడు → "రిక్వైర్డ్" ఎర్రర్ చూపించాలి
5. యూజర్ పాస్‌వర్డ్ ఖాళీగా వదిలేస్తాడు → "రిక్వైర్డ్" ఎర్రర్ చూపించాలి
6. నెట్‌వర్క్ నెమ్మదిగా ఉంటుంది → వెబ్సైట్ లోడ్ అవ్వడానికి సమయం పడుతుంది
7. బ్రౌజర్ అనుకోకుండా మూసుకుపోతుంది → సెషన్ పోతుంది

> **ఎక్స్‌పర్ట్ టిప్:** ఉత్తమ టెస్టర్లు "ఏమి తప్పు జరగవచ్చు?" అని ఆలోచించి బగ్స్ కనుగొంటారు. సాధారణ టెస్టర్లు "ఏమి సరిగ్గా జరగాలి?" మాత్రమే టెస్ట్ చేస్తారు.

</details>

### Step 4: Design Test Scenarios

Based on the brief and my understanding, I designed these 5 scenarios:

| Scenario | Test Case Name | Test Data | Expected Result |
|----------|---------------|-----------|----------------|
| 1 | Valid Login | student / Password123 | Redirect to dashboard, username shown |
| 2 | Invalid Email Format | invalidemail (no @) | Error: "Please provide a valid email" |
| 3 | Email Not Registered | nonexistent@example.com | Error: "User not found" |
| 4 | Empty Email Field | (blank) / Password123 | Error: "Email required" |
| 5 | Empty Password Field | student / (blank) | Error: "Password required" |

### Step 5: Kick-Off Meeting Questions

Before I start writing code, these are the questions I would ask the client in our first meeting:

| # | Question | Why I Ask |
|---|----------|----------|
| 1 | What are the test account credentials? | I need valid username/password to test |
| 2 | What browsers should I test on? | Chrome? Firefox? All? |
| 3 | Should I test on mobile devices too? | Some logins work on desktop but fail on mobile |
| 4 | How long should login take? | If it takes more than 5 seconds, that's a bug |
| 5 | Should I test "Remember Me" checkbox? | Many sites have this feature |
| 6 | Should I test "Forgot Password" link? | Is that part of this project scope? |
| 7 | What format for the test report? | HTML? Excel? PDF? |
| 8 | Should tests run on Jenkins CI/CD? | Or just locally on my machine? |

> **Expert Tip:** Asking these questions in the first meeting makes you look like an expert. It shows you understand the full picture, not just the immediate task.

<details>
<summary><strong>🌐 తెలుగు - స్టెప్ 5: కిక్-ఆఫ్ మీటింగ్ ప్రశ్నలు - క్లిక్ చేసి చదవండి</strong></summary>

కోడ్ రాయడానికి ముందు, మొదటి మీటింగ్ లో క్లయింట్ ను ఇవి అడుగుతాను:

| నంబర్ | ప్రశ్న | ఎందుకు అడుగుతాను |
|---|----------|----------|
| 1 | టెస్ట్ అకౌంట్ క్రెడెన్షియల్స్ ఏవిటి? | టెస్ట్ చేయడానికి వాలిడ్ యూజర్ పేరు/పాస్‌వర్డ్ కావాలి |
| 2 | ఏ బ్రౌజర్ల మీద టెస్ట్ చేయాలి? | Chrome? Firefox? అన్నీ? |
| 3 | మొబైల్ డివైస్ల మీద కూడా టెస్ట్ చేయాలా? | కొన్ని లాగిన్లు డెస్క్‌టాప్ మీద పనిచేస్తాయి కానీ మొబైల్ మీద ఫెయిల్ అవుతాయి |
| 4 | లాగిన్ ఎంత సమయం పట్టాలి? | 5 సెకన్ల కంటే ఎక్కువ సమయం పడితే, అది బగ్ |
| 5 | "Remember Me" చెక్బాక్స్ టెస్ట్ చేయాలా? | చాలా సైట్స్ ఈ ఫీచర్ ఉంటుంది |
| 6 | "Forgot Password" లింక్ టెస్ట్ చేయాలా? | అది ఈ ప్రాజెక్ట్ స్కోప్ లో ఉందా? |
| 7 | టెస్ట్ రిపోర్ట్ ఏ ఫార్మాట్ లో కావాలి? | HTML? Excel? PDF? |
| 8 | టెస్ట్లు Jenkins CI/CD పై రన్ అవ్వాలా? | లేదా కేవలం నా మెషైన్ మీదే రన్ అవ్వాలా? |

> **ఎక్స్‌పర్ట్ టిప్:** మొదటి మీటింగ్ లో ఈ ప్రశ్నలు అడగడం మిమ్మల్ని ఎక్స్‌పర్ట్ లాగా చూపిస్తుంది. ఇది మీరు పూర్తి చిత్రాన్ని అర్థం చేసుకున్నారని చూపిస్తుంది.

</details>

### Step 6: My Expert Recommendations

After understanding everything, here is how I would approach this project:

1. **First, write a simple test** — Valid login only. Make sure it passes.
2. **Then add error scenarios one by one** — Each scenario in a separate `@Test` method.
3. **Use Page Object Model (POM) concepts** — Even for simple projects, separate locators from test logic.
4. **Add explicit waits for slow pages** — The website might load slowly; use WebDriverWait.
5. **Use meaningful assertions** — Don't just check "element exists", check the specific error message text.
6. **Add test report generation** — Use TestNG reports so client can see which tests passed/failed.
7. **Comment your code** — Future testers (or you after 6 months) need to understand what each step does.

> **Final Expert Tip:** The difference between a 1-year tester and a 6-year tester is not in the code they write — it is in the QUESTIONS they ask BEFORE writing code. Always think first, then code.

---

### 🔗 Jump to next file
[→ LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md)

[↑ Back to Top](#professional-approach---how-experts-think)
