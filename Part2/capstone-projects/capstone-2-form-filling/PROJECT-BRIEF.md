# Capstone 2: Form Filling with Advanced Input

[← Back to CAPSTONE-README.md](../CAPSTONE-README.md) | [PROFESSIONAL-APPROACH.md](PROFESSIONAL-APPROACH.md) | [LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md) | [COMPLETE-SOLUTION.java](COMPLETE-SOLUTION.java) | [EXPECTED-OUTPUT.md](EXPECTED-OUTPUT.md)

---

📌 What Is This File?
----------------------
This is the **PROJECT BRIEF** — the first file you read in every capstone project.

Think of it as the **email or ticket from your client**. It tells you:

- Who the client is
- What their website/problem is
- What they want you to test
- What the test data is

**Why this file matters:** Before writing a single line of code, you must understand what the client needs.

---

## PROJECT BRIEF

### Client Name
Student Registry System

### Your Role
Senior Automation Tester (6 years experience)

### Client Request
> "We have a student registration form on our website. Students must fill in their first name, last name, email, phone number, date of birth (with a date picker), gender (radio buttons), hobbies (checkboxes), and state (dropdown). We need automated tests to verify the form works correctly for both valid and invalid submissions."

### Website to Test
[https://demoqa.com/automation-practice-form](https://demoqa.com/automation-practice-form)

> **Note:** This is a LIVE website. All tests will work on live data.

### What You Need to Test

| Test # | Scenario Name | Description | Purpose |
|--------|---------------|-------------|----------|
| 1 | **Complete Valid Form** | Fill ALL fields with valid data | Verify the form accepts valid data and shows success |
| 2 | **Missing Required Fields** | Submit with empty name fields | Verify required field validation |
| 3 | **Invalid Email Format** | Enter email without @ symbol | Verify email format validation |
| 4 | **Select Gender Radio Button** | Select Male or Female radio button | Verify radio button selection works |
| 5 | **Select Hobbies Checkboxes** | Select multiple hobby checkboxes | Verify checkbox selection works |

> **Expert Tip:** Forms are the MOST common automation testing task in real jobs. 80% of web automation involves filling forms. Mastering this means you are ready for interviews.

### Test Data

| Field | Valid Data | Invalid Data |
|-------|-----------|-------------|
| First Name | John | (leave empty) |
| Last Name | Smith | (leave empty) |
| Email | john.smith@email.com | invalidemail (no @) |
| Mobile | 9876543210 | abc (letters instead of numbers) |
| Gender | Male (radio button) | Leave all radio buttons unchecked |
| Hobbies | Sports, Reading (checkboxes) | Leave all checkboxes unchecked |
| State | NCR (dropdown) | Leave dropdown at "Choose State" |

### Expected Outcome

- **Valid form** should show a success modal/dialog
- **Empty required fields** should prevent submission or show error
- **Invalid email** should show format error message
- **Gender selection** should highlight the selected option
- **Hobby checkboxes** should show selected items

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

[↑ Back to Top](#capstone-2-form-filling-with-advanced-input)
