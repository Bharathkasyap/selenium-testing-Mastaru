# Capstone 1: Advanced Login Testing

[← Back to CAPSTONE-README.md](../CAPSTONE-README.md) | [PROFESSIONAL-APPROACH.md](PROFESSIONAL-APPROACH.md) | [LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md) | [COMPLETE-SOLUTION.java](COMPLETE-SOLUTION.java) | [EXPECTED-OUTPUT.md](EXPECTED-OUTPUT.md)

---

📌 What Is This File?
----------------------
This is the **PROJECT BRIEF** — the first file you read in every capstone project.

Think of it as the **email or ticket from your client**. It tells you:

- Who the client is
- What their website/problem is
- What they want you to test
- What the test data is (usernames, passwords, URLs)

**Why this file matters:** Before writing a single line of code, you must understand what the client needs. This is exactly what happens in real jobs.

---

## PROJECT BRIEF

### 📌 File Navigation (Jump to any section)
- [Client Name](#client-name)
- [Your Role](#your-role)
- [Client Request](#client-request)
- [Website to Test](#website-to-test)
- [What You Need to Test](#what-you-need-to-test)
- [Test Data](#test-data)
- [Expected Outcome](#expected-outcome)
- [Deliverables](#deliverables)
- [Deadline](#deadline)

---

### Client Name
TechDash Analytics Platform

### Your Role
Senior Automation Tester (6 years experience)

### Client Request
> "We have a new login portal for our analytics platform. Users are reporting they cannot login, and when they do, the session does not last. We also want to test the Remember Me feature and the Forgot Password link. Please create comprehensive automated tests to verify all login functionality and error handling."

### Website to Test
[https://demoqa.com/login](https://demoqa.com/login)

> **Note:** This is a LIVE website. All tests will work on live data.

### What You Need to Test

| Test # | Scenario Name | Description | Purpose |
|--------|---------------|-------------|----------|
| 1 | **Valid Login** | Enter correct username and password | Verify happy path - user can log in successfully |
| 2 | **Invalid Email Format** | Enter email without @ symbol | Verify browser validation catches invalid email format |
| 3 | **Email Not Registered** | Enter a valid format email that is not registered | Verify backend validation for unregistered users |
| 4 | **Empty Email Field** | Submit with empty email field | Verify required field validation |
| 5 | **Empty Password Field** | Submit with empty password field | Verify required field validation |

> **Expert Tip:** A professional tester always tests BOTH valid (happy path) and invalid (edge cases) scenarios. Real users make mistakes — they forget passwords, leave fields empty, or type the wrong email. Your tests must catch all of these.

<details>
<summary><strong>🌐 తెలుగు - మీరు ఏమి టెస్ట్ చేయాలి - క్లిక్ చేసి చదవండి</strong></summary>

| టెస్ట్ నంబర్ | సీన్ ని పేరు | వివరణ | నమూనా ఎందుకు |
|--------|---------------|-------------|----------|
| 1 | **వాలిడ్ లాగిన్** | సరైన యూజర్ పేరు మరియు పాస్‌వర్డ్ నమోదు చేయండి | హ్యాపీ పాత్ - యూజర్ విజయవంతంగా లాగిన్ అవుతాడో లేదో సరిచూడండి |
| 2 | **ఇన్వాలిడ్ ఇమెయిల్ ఫార్మాట్** | @ లేని ఇమెయిల్ ఎంటర్ చేయండి | బ్రౌజర్ వాలిడేషన్ తప్పు ఇమెయిల్ ఫార్మాట్ పట్టుకుంటుందా చూడండి |
| 3 | **ఇమెయిల్ రిజిస్టర్ అవలేదు** | రిజిస్టర్ కాని ఇమెయిల్ ఎంటర్ చేయండి | రిజిస్టర్ కాని యూజర్లకు బ్యాకెండ్ వాలిడేషన్ పనిచేస్తుందా చూడండి |
| 4 | **ఖాళీ ఇమెయిల్ ఫీల్డ్** | ఇమెయిల్ ఫీల్డ్ ఖాళీగా ఉన్నప్పుడు సబ్మిట్ చేయండి | రిక్వైర్డ్ ఫీల్డ్ వాలిడేషన్ సరిచూడండి |
| 5 | **ఖాళీ పాస్‌వర్డ్ ఫీల్డ్** | పాస్‌వర్డ్ ఫీల్డ్ ఖాళీగా ఉన్నప్పుడు సబ్మిట్ చేయండి | రిక్వైర్డ్ ఫీల్డ్ వాలిడేషన్ సరిచూడండి |

> **ఎక్స్‌పర్ట్ టిప్:** ప్రొఫెషనల్ టెస్టర్ ఎప్పుడూ వాలిడ్ (హ్యాపీ పాత్) మరియు ఇన్వాలిడ్ (ఎడ్జ్ కేసెస్) రెండు రకాల సీన్ నియోలను టెస్ట్ చేస్తారు. నిజమైన యూజర్లు తప్పులు చేస్తారు — పాస్‌వర్డ్ మర్చిపోతారు, ఫీల్డ్స్ ఖాళీగా వదిలేస్తారు, లేదా తప్పు ఇమెయిల్ టైప్ చేస్తారు. మీ టెస్ట్లు వీటన్నీ పట్టుకోవాలి.

</details>

### Test Data

**Credentials to Use:**

| Credential Type | Value |
|----------------|-------|
| Valid Username | `student` |
| Valid Password | `Password123` |
| Invalid Email Format | `invalidemail` (no @ symbol) |
| Unregistered Email | `nonexistent@example.com` |
| Empty Email | (leave blank) |
| Empty Password | (leave blank) |

### Expected Outcome

- **Valid login** should redirect to the dashboard/profile page
- **Invalid email format** should show browser validation error or error message
- **Unregistered email** should show "User not found" or similar error
- **Empty email** should show "Email required" validation error
- **Empty password** should show "Password required" validation error

### Deliverables

1. **PROJECT-BRIEF.md** (this file) — The client request
2. **PROFESSIONAL-APPROACH.md** — How to think about this project
3. **LAYMAN-EXPLANATION.md** — Simple explanation of what the code does
4. **COMPLETE-SOLUTION.java** — Full working Java code
5. **EXPECTED-OUTPUT.md** — What you should see when tests run

### Deadline
As a learning project — complete at your own pace

### 🔗 Jump to next file
[→ PROFESSIONAL-APPROACH.md](PROFESSIONAL-APPROACH.md)

[↑ Back to Top](#capstone-1-advanced-login-testing)
