# Selenium Testing Mastaru

## Before You Start — Basics Explained (Read This First)

*If you are new to coding or automation, read this section before jumping into Part 1. This answers every question a beginner asks before writing a single line of Selenium code.*

---

### Q1: What is Selenium?

Selenium is a **robot that controls your browser**. You write instructions once, and Selenium does the clicking, typing, and navigating for you.

**Example story — Testing a Login Page:**

Imagine your school has a website with a login page. You type your username and password, click Login, and it takes you to the homepage.

Your teacher asks: "Check if this login works every day."

You could do it manually — open browser, type, click, check. But what if you need to do it 50 times a day? That's where Selenium comes in.

```python
from selenium import webdriver

driver = webdriver.Chrome()
driver.get("https://school.com/login")

driver.find_element("id", "username").send_keys("vb_dev")
driver.find_element("id", "password").send_keys("mypassword")
driver.find_element("id", "loginBtn").click()

print("Login test done!")
driver.quit()
```

That's it. **Selenium is the robot that tests the login.**

---

### Q2: What is Maven?

Maven is a **project manager** for Java projects. It downloads all the tools your project needs and runs your tests with one command.

Think of it like a shopping cart — you tell Maven what you need, and it goes and downloads everything automatically.

Your `pom.xml` just says:

```xml
<dependency>
  <groupId>org.seleniumhq.selenium</groupId>
  <artifactId>selenium-java</artifactId>
  <version>4.0.0</version>
</dependency>
```

Maven reads this and downloads Selenium for you. Then you run:

```bash
mvn test
```

And Maven compiles your code, downloads missing tools, runs all tests, and generates a report — all in one command.

---

### Q3: What is the Difference Between Selenium and Maven?

| | What it does | Your login example |
|---|---|---|
| **Selenium** | The robot that tests the website | Types username, clicks button, checks result |
| **Maven** | The manager that sets up and runs the project | Downloads Selenium, runs the test, makes a report |

**Selenium does the testing. Maven manages the project.**

---

### Q4: Does the Web App's Language Matter When Choosing Maven?

**No.** Whether the website you are testing is built in Java, Python, PHP, or anything else — it does not matter.

Maven only cares about **your test project**, not the app being tested.

---

### Q5: Do I Need Maven If I Write Tests in Java?

Technically no, but practically yes. Without Maven:
- You manually download Selenium `.jar` files
- You manually add them to your project classpath
- You compile with long CMD commands

With Maven:
- One line in `pom.xml`
- Type `mvn test`
- Done

| Your plan | Do you need Maven? |
|---|---|
| Python (beginner) | No. Just `pip install selenium` |
| Java (small/learning project) | Not required but very painful without it |
| Java (real project / team) | Yes, almost always |

---

### Q6: All the Ways to Run Selenium Tests

**1. Directly from CMD (Python — simplest, no Maven needed)**
```bash
pip install selenium
python my_test.py
```

**2. Directly from CMD (Java — without Maven)**
```bash
javac -cp ".;selenium-java.jar" MyTest.java
java -cp ".;selenium-java.jar" MyTest
```

**3. CMD with Maven (Java — recommended)**
```bash
mvn test
mvn -Dtest=MyTest test    # runs a specific test
mvn clean test            # clean build then test
```

**4. CMD with Pytest (Python — structured)**
```bash
pytest tests/
pytest tests/test_login.py
pytest -v --html=report.html
```

**5. From an IDE (Eclipse, IntelliJ, VS Code)**
Right-click the test file and select Run.

**6. CI/CD Pipeline (Jenkins, GitHub Actions)**
Maven or pytest commands get triggered automatically on code push.

---

### Q7: Python vs Java for Selenium — Which Should I Pick?

| Factor | Java + Maven | Python + pytest |
|---|---|---|
| Setup complexity | Higher (JDK, Maven, IDE) | Simple (`pip install selenium`) |
| Speed to write tests | Slower (verbose syntax) | Faster (clean syntax) |
| Industry use | Enterprise, large QA teams | Startups, scripting-heavy teams |
| CMD execution | `mvn test` | `pytest` or `python file.py` |
| Best for | Long-term enterprise projects | Learning and quick automation |

**Beginner advice: Start with Python + Selenium. Skip Maven until you need it.**

---

## Foundations You Need Before Starting Part 1

*These are the basic skills and knowledge a learner should have before diving into Selenium automation. If you do not know these yet, spend some time on them first.*

---

### Group 1 — Computer & Setup Basics

These are things you need before you even open this repo.

| Topic | Why It Matters |
|---|---|
| **What is CMD / Terminal?** | Every Selenium test runs from CMD. You need to know how to open it and type commands. |
| **How to install Python** | Without Python installed, you cannot run any automation. |
| **What is `pip`?** | `pip` is how you install Selenium in Python. Example: `pip install selenium`. |
| **What is ChromeDriver?** | Selenium needs this small file to control the Chrome browser. Install via: `pip install webdriver-manager`. |
| **What is VS Code?** | It is a code editor — like Notepad but built for programming. This is where you write your test code. |
| **What is a virtual environment (venv)?** | It keeps your Python libraries separate for each project so they do not conflict. Create with: `python -m venv myenv`. |

---

### Group 2 — Web & Browser Basics

Selenium tests websites, so you need to understand how the web works.

| Topic | Why It Matters |
|---|---|
| **What is HTML?** | Websites are built with HTML. Selenium reads HTML to find buttons, text boxes, and links. |
| **What are HTML IDs and Classes?** | Selenium finds elements using IDs and classes. Example: `find_element("id", "username")`. |
| **What is Inspect Element / DevTools?** | This is HOW you find the element IDs to put in your test code. Right-click on any webpage → Inspect. |
| **What is a URL?** | `driver.get("https://example.com")` just opens a URL in the browser. |

---

### Group 3 — Python Basics (Just Enough, Not a Full Course)

You do not need to be a Python expert. But you need these 5 things:

| Topic | Why It Matters |
|---|---|
| **Variables and `print()`** | To store values and see output: `name = "test"` and `print(name)`. |
| **Functions (`def`)** | Test scripts use functions everywhere to organize code. |
| **Import statements** | `from selenium import webdriver` — this is how you use Selenium in your code. |
| **What is a library/package?** | Selenium is a package — a collection of code someone else wrote that you can reuse. |
| **Basic error reading** | When a test fails, you see an error message. You need to read it without panicking. |

---

### Group 4 — Git & GitHub Basics

Since this is a GitHub repo, you should know a few things.

| Topic | Why It Matters |
|---|---|
| **What is Git?** | Git is a tool that tracks changes in your code. Use `git clone` to download this repo. |
| **What is GitHub?** | GitHub is a website where people share and store their code projects. This repo lives here. |
| **How to clone a repo?** | First step to use this repo: `git clone https://github.com/Bharathkasyap/selenium-testing-Mastaru.git`. |
| **What is a README?** | It is the cover page of a project. It explains what the project is, who it is for, and how to use it. |

---

### Group 5 — Testing Concepts (Non-Technical)

These concepts are covered in Part 1 but need a pre-explanation.

| Topic | Simple Explanation |
|---|---|
| **What is software testing?** | It means checking if a program works correctly before giving it to real users. |
| **What is a test case?** | A test case is a list of steps to check one specific thing. Example: "Login with correct password → should go to homepage." |
| **What is a test script?** | A test script is code that does the test case automatically. |
| **What is a pass/fail result?** | Pass = the test worked correctly. Fail = something went wrong. Automation tools track this for you. |
| **What is regression testing?** | After you fix a bug or add a feature, you run all old tests again to make sure nothing broke. |

---

---

## Original Content Starts Here

---

Learn Selenium automation in a structured, practical, and easy-to-follow way.

This repository is built for learners who want more than basic Selenium commands. It focuses on strong fundamentals, real automation understanding, practical examples, and project-based learning so you can build skills that are useful in interviews and real work.

## What this repo offers

- 5-part Selenium learning path
- Clear and simple explanations
- Beginner to advanced coding examples
- Real-world automation scenarios
- Supporting concepts that strengthen automation skills
- Practice projects after each part

## Who this is for

- Beginners starting with Selenium
- Manual testers moving into automation
- Students building practical test automation skills
- Job seekers preparing for Selenium interviews
- Anyone who wants one complete Selenium reference repo

## Learning goal

The goal of this repository is to help learners build strong Selenium automation skills step by step. It is designed to reduce confusion, fill knowledge gaps, and improve confidence through structured notes, examples, and practical projects.

## Repo structure

- Part 1: Foundations
- Part 2: Selenium core concepts
- Part 3: Advanced Selenium handling
- Part 4: Frameworks and real-world automation design
- Part 5: Professional-level skills, debugging, and project depth

## What makes this repo different

Many Selenium resources only teach commands. This repo focuses on understanding, practical usage, problem-solving, and long-term skill building. The aim is not just to learn syntax, but to become comfortable building and maintaining real automation.

## Future plan

This repository will first grow as a complete GitHub-based learning resource. After the content becomes stable, it may later be expanded into a dedicated web-based learning platform.

Built for learners who want Selenium mastery, not surface-level tutorials.
