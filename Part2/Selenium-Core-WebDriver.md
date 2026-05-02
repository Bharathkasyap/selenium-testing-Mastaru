# Part 02 — Selenium Core WebDriver: Locators, Elements, and Browser Control

> **For Telugu-Speaking Learners** | Java Primary | Intermediate Level
>
> This is the CORE of Selenium. Master this part and you can handle 80% of real automation jobs.
> The Locators section is the most important — read it multiple times.

---

## Table of Contents

1. [WebDriver Interface — The Brain of Selenium](#1-webdriver-interface)
2. [All WebDriver Methods — Complete Reference](#2-all-webdriver-methods)
3. [LOCATORS — The Most Important Topic](#3-locators)
   - [ID Locator](#31-id-locator)
   - [Name Locator](#32-name-locator)
   - [ClassName Locator](#33-classname-locator)
   - [TagName Locator](#34-tagname-locator)
   - [LinkText Locator](#35-linktext-locator)
   - [PartialLinkText Locator](#36-partiallinktext-locator)
   - [CSS Selector — Deep Dive](#37-css-selector-deep-dive)
   - [XPath — Deep Dive](#38-xpath-deep-dive)
   - [Locator Decision Framework](#39-locator-decision-framework)
4. [WebElement Operations](#4-webelement-operations)
5. [Multiple Element Handling](#5-multiple-element-handling)
6. [Browser Operations](#6-browser-operations)
7. [Dropdown Handling — Select Class](#7-dropdown-handling)
8. [Radio Buttons and Checkboxes](#8-radio-buttons-and-checkboxes)
9. [Date and Calendar Handling](#9-date-and-calendar-handling)
10. [Web Table Handling](#10-web-table-handling)
11. [Big Practical Projects](#11-big-practical-projects)

---

## 1. WebDriver Interface

### What is WebDriver Interface?

`WebDriver` is a **Java interface** — a contract that says "anyone who implements me MUST have these methods."

Think of it like a TV remote control blueprint. The blueprint says the remote must have Power, Volume Up, Volume Down, Channel Up, Channel Down. Different TV brands (Samsung, LG, Sony) make their own remote, but all follow the same blueprint.

Similarly:
- `WebDriver` is the blueprint
- `ChromeDriver`, `FirefoxDriver`, `EdgeDriver` are the actual implementations

```java
// WebDriver is an interface — you cannot create it directly
// WebDriver driver = new WebDriver();  // ERROR! Cannot do this

// You create concrete implementations
WebDriver driver = new ChromeDriver();    // Chrome browser
WebDriver driver = new FirefoxDriver();   // Firefox browser
WebDriver driver = new EdgeDriver();      // Edge browser

// Why use WebDriver type instead of ChromeDriver?
// Because you can switch browsers by changing only ONE line!
WebDriver driver;

String browser = System.getProperty("browser", "chrome"); // from command line

switch (browser) {
    case "chrome" -> driver = new ChromeDriver();
    case "firefox" -> driver = new FirefoxDriver();
    case "edge" -> driver = new EdgeDriver();
    default -> throw new IllegalArgumentException("Unknown: " + browser);
}
// Same test code works for ALL browsers!
```

### WebDriver Interface Hierarchy

```
SELENIUM CLASS HIERARCHY:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

SearchContext (interface)          ← Provides findElement(), findElements()
     │
     └── WebDriver (interface)    ← Core browser control
              │
              ├── WebDriver.Window (inner interface)  ← Window management
              ├── WebDriver.Navigation (inner interface) ← navigate().to(), back()
              ├── WebDriver.Options (inner interface) ← manage() → cookies, timeouts
              └── WebDriver.TargetLocator (inner interface) ← switchTo()
                        │
                        ├── RemoteWebDriver (class) ← Base implementation
                        │         │
                        │         ├── ChromeDriver  ← Chrome-specific
                        │         ├── FirefoxDriver ← Firefox-specific
                        │         └── EdgeDriver    ← Edge-specific
                        │
                        └── AppiumDriver (for mobile — different project)
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## WebDriver Interface అంటే ఏమిటి?

`WebDriver` ఒక Java interface — ఇది ఒక contract. "నన్ను implement చేసే ఎవరైనా ఈ methods తప్పకుండా implement చేయాలి" అని చెప్తుంది.

TV remote blueprint లాంటిది. Power, Volume, Channel buttons ఉండాలని blueprint చెప్తుంది. Samsung, LG, Sony వేర్వేరు remotes చేస్తాయి కానీ అన్నీ same blueprint follow చేస్తాయి.

అదేవిధంగా:
- `WebDriver` = blueprint (interface)
- `ChromeDriver`, `FirefoxDriver`, `EdgeDriver` = actual implementations

**ఎందుకు `WebDriver driver = new ChromeDriver()` రాస్తాం, `ChromeDriver driver = new ChromeDriver()` కాదు?**

ఒకే line change చేసి browser మార్చవచ్చు! మిగతా code అంతా same ఉంటుంది. ఇది very powerful approach.

```java
WebDriver driver = new ChromeDriver();  // Chrome లో test
// ఒక్క line మారిస్తే:
WebDriver driver = new FirefoxDriver(); // Firefox లో same test!
```

</details>

---

## 2. All WebDriver Methods — Complete Reference

### Navigation Methods

```java
WebDriver driver = new ChromeDriver();

// ── BASIC NAVIGATION ───────────────────────────────────────────────

// 1. get(url) — Navigate to URL, waits for page to load
driver.get("https://www.google.com");
// Note: get() waits until page load is complete before returning

// 2. getCurrentUrl() — Get current page URL
String currentUrl = driver.getCurrentUrl();
System.out.println("Currently at: " + currentUrl);

// 3. getTitle() — Get page title (text in browser tab)
String pageTitle = driver.getTitle();
System.out.println("Title: " + pageTitle);

// 4. getPageSource() — Get complete HTML of the page
String htmlSource = driver.getPageSource();
System.out.println("Page has " + htmlSource.length() + " characters");

// ── NAVIGATE OBJECT METHODS ────────────────────────────────────────

// navigate().to() — Same as get(), but part of navigate object
driver.navigate().to("https://www.amazon.com");

// navigate().back() — Click browser back button
driver.navigate().back();

// navigate().forward() — Click browser forward button
driver.navigate().forward();

// navigate().refresh() — Refresh current page (F5)
driver.navigate().refresh();

// ── FIND ELEMENT METHODS ───────────────────────────────────────────

// findElement() — Find ONE element, throws exception if not found
WebElement searchBox = driver.findElement(By.name("q"));

// findElements() — Find ALL matching elements, returns empty list if none
List<WebElement> allLinks = driver.findElements(By.tagName("a"));

// ── WINDOW MANAGEMENT ──────────────────────────────────────────────

// getWindowHandle() — Get ID of current window/tab
String currentWindowId = driver.getWindowHandle();

// getWindowHandles() — Get IDs of ALL open windows/tabs
Set<String> allWindowIds = driver.getWindowHandles();

// ── CLOSE METHODS ──────────────────────────────────────────────────

// close() — Close ONLY the current window/tab
driver.close();
// WARNING: If this is the only window, session ends but driver not cleaned up

// quit() — Close ALL windows and end WebDriver session (ALWAYS use this!)
driver.quit();
```

### manage() — Options and Configuration

```java
WebDriver driver = new ChromeDriver();
WebDriver.Options options = driver.manage(); // Get options object

// ── WINDOW OPERATIONS ──────────────────────────────────────────────

// Maximize window
options.window().maximize();
// OR: driver.manage().window().maximize();

// Minimize window
options.window().minimize();

// Full screen (F11 equivalent)
options.window().fullscreen();

// Set specific window size
options.window().setSize(new Dimension(1280, 720));

// Set window position on screen
options.window().setPosition(new Point(0, 0));

// Get current window size
Dimension size = options.window().getSize();
System.out.println("Width: " + size.width + " Height: " + size.height);

// ── TIMEOUTS ───────────────────────────────────────────────────────

// Implicit wait — max time to wait for element (covered in Part 3)
options.timeouts().implicitlyWait(Duration.ofSeconds(10));

// Page load timeout — max time to wait for page to load
options.timeouts().pageLoadTimeout(Duration.ofSeconds(30));

// Script timeout — max time for JavaScript execution
options.timeouts().scriptTimeout(Duration.ofSeconds(20));

// ── COOKIES ────────────────────────────────────────────────────────

// Add a cookie
Cookie myCookie = new Cookie("user_session", "abc123xyz");
options.addCookie(myCookie);

// Get all cookies
Set<Cookie> allCookies = options.getCookies();
for (Cookie cookie : allCookies) {
    System.out.println("Cookie: " + cookie.getName() + " = " + cookie.getValue());
}

// Get specific cookie
Cookie sessionCookie = options.getCookieNamed("user_session");

// Delete specific cookie
options.deleteCookieNamed("user_session");

// Delete all cookies
options.deleteAllCookies();
```

### switchTo() — Switching Context

```java
// Switch to Alert
Alert alert = driver.switchTo().alert();

// Switch to Frame by index
driver.switchTo().frame(0);           // First frame on page

// Switch to Frame by name or ID
driver.switchTo().frame("frameName");

// Switch to Frame by WebElement
WebElement frameElement = driver.findElement(By.id("myFrame"));
driver.switchTo().frame(frameElement);

// Switch back to main content (after being inside frame)
driver.switchTo().defaultContent();
driver.switchTo().parentFrame();      // Go one level up (parent frame)

// Switch to another window
driver.switchTo().window("windowHandle");
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## WebDriver Methods — Complete Reference

### Navigation Methods

```java
driver.get("https://google.com");         // URL కి navigate చేయడం
driver.getCurrentUrl();                    // ప్రస్తుత URL తెచ్చుకోవడం
driver.getTitle();                         // Page title తెచ్చుకోవడం
driver.getPageSource();                    // Page యొక్క HTML తెచ్చుకోవడం

driver.navigate().back();                 // Browser back button
driver.navigate().forward();              // Browser forward button
driver.navigate().refresh();              // Page refresh (F5)
driver.navigate().to("url");             // get() కి alternative
```

### manage() Methods

```java
driver.manage().window().maximize();     // Window maximize చేయడం
driver.manage().window().setSize(...);   // Specific size set చేయడం
driver.manage().timeouts()
    .implicitlyWait(Duration.ofSeconds(10)); // Implicit wait set చేయడం
driver.manage().addCookie(cookie);       // Cookie add చేయడం
driver.manage().getCookies();            // All cookies తెచ్చుకోవడం
driver.manage().deleteAllCookies();      // All cookies delete చేయడం
```

### findElement vs findElements

```java
// findElement — ONE element return చేస్తుంది
// Element దొరక్కపోతే: NoSuchElementException throw అవుతుంది
WebElement btn = driver.findElement(By.id("loginBtn"));

// findElements — LIST return చేస్తుంది
// Elements దొరక్కపోతే: Empty list return అవుతుంది (exception కాదు!)
List<WebElement> links = driver.findElements(By.tagName("a"));
```

### close() vs quit()

| Method | ఏం చేస్తుంది |
|--------|-------------|
| `close()` | Current window మాత్రమే close చేస్తుంది |
| `quit()` | అన్ని windows close చేసి, session completely end చేస్తుంది |

**Always `quit()` వాడండి** — memory leaks avoid చేయడానికి.

</details>

---

## 3. LOCATORS — The Most Important Topic

> **⚠️ THIS IS THE MOST CRITICAL SKILL IN SELENIUM.**
> A great Selenium tester is measured by how well they write locators.
> Read this section multiple times. Practice with real websites.

### What is a Locator?

A **locator** tells Selenium HOW to find an element on a web page.

Think of a web page as a huge city. A locator is like an address. To find a house:
- You could use the house ID number (unique, fastest)
- You could use the street name (might match multiple houses)
- You could use GPS coordinates (CSS selector)
- You could use step-by-step directions from a landmark (XPath)

In HTML, elements look like this:
```html
<input id="username" name="user" class="form-control login-input" 
       type="text" placeholder="Enter username" />

<a href="/dashboard" class="nav-link active">Dashboard</a>

<button id="submitBtn" class="btn btn-primary" type="submit">Login</button>
```

Selenium needs to find these elements. Locators are the strategies to find them.

### The 8 Locator Types

```
LOCATOR SPEED (Fastest to Slowest):
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

1. By.id()            ←  FASTEST (unique, browser optimized)
2. By.name()          ←  Fast
3. By.className()     ←  Fast
4. By.tagName()       ←  Fast
5. By.linkText()      ←  Medium
6. By.partialLinkText() ← Medium
7. By.cssSelector()   ←  Fast (browser-native)
8. By.xpath()         ←  SLOWEST (but most powerful)
```

---

### 3.1 ID Locator

**Use when:** The element has a unique `id` attribute.

**Reliability:** ⭐⭐⭐⭐⭐ Best — IDs are supposed to be unique per page.

**HTML:**
```html
<input id="username" type="text" />
<button id="loginBtn">Login</button>
<div id="errorMessage">Invalid credentials</div>
```

```java
// Simple usage
WebElement usernameInput = driver.findElement(By.id("username"));
WebElement loginButton = driver.findElement(By.id("loginBtn"));
WebElement errorDiv = driver.findElement(By.id("errorMessage"));

// Intermediate: Use it and check attributes
WebElement input = driver.findElement(By.id("username"));
System.out.println("Type: " + input.getAttribute("type"));
System.out.println("Placeholder: " + input.getAttribute("placeholder"));
System.out.println("Is enabled: " + input.isEnabled());

// Advanced: Dynamic ID handling (IDs that change every page load)
// BAD: id="session_3847592_username" ← Do NOT use this, it changes
// GOOD: Look for other stable attributes and use CSS or XPath instead
```

**When ID is Unreliable:**
Some applications generate IDs dynamically: `id="j_id0:j_id5:inputText_3"`. These change on every page load. In such cases, use CSS or XPath with other attributes.

**5 Real-World Scenarios:**
1. Login forms — username, password, login button almost always have IDs
2. Error message verification — error `div` elements commonly have IDs
3. Form fields — email, phone, address inputs
4. Navigation menu items — main menu buttons
5. Modal dialogs — popup close buttons, confirm buttons

**Common Mistakes:**
```java
// MISTAKE: Case sensitive! HTML id="Username" — not id="username"
driver.findElement(By.id("username"));  // OK if id is lowercase
driver.findElement(By.id("Username"));  // OK if id has capital U

// MISTAKE: Using dynamic ID
// id="button_1234_submit" where 1234 changes every load — WILL FAIL

// FIX: Use other stable attributes
driver.findElement(By.cssSelector("button[type='submit']"));
```

**Pro Tips:**
> **Pro Tip:** If multiple elements have the same ID (which is HTML violation but happens in real apps), `findElement` will return the FIRST one. Use `findElements` to get all.

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## ID Locator

HTML element కి `id` attribute ఉంటే, దాన్ని వాడి element find చేయడం అత్యంత reliable మరియు fastest method.

```html
<input id="username" type="text" />
```

```java
driver.findElement(By.id("username"));
```

**ఎందుకు best?**
- Browser HTML DOM లో id ని directly index చేస్తుంది
- Search చాలా fast అవుతుంది
- ID page లో unique అయి ఉండాలి (HTML rule)

**ఎప్పుడు వాడాలి?**
- Element కి clear, stable id ఉన్నప్పుడు

**ఎప్పుడు వాడకూడదు?**
- `id="j_id0:j_id5:button_3948"` లా dynamically generated ids — వాటిని avoid చేయండి
- Same id multiple elements కి ఉన్నప్పుడు (HTML violation కానీ real apps లో జరుగుతుంది)

**Real Examples:**
- Login form: `<input id="username">`, `<input id="password">`, `<button id="loginBtn">`
- Error messages: `<div id="errorMsg">`
- Form fields: `<input id="email">`, `<input id="phone">`

</details>

---

### 3.2 Name Locator

**Use when:** Element has a `name` attribute (common in forms).

```html
<input name="q" type="text" />              <!-- Google search box -->
<input name="email" type="email" />
<input name="subscribe" type="checkbox" />
```

```java
// Google search box is found by name="q"
WebElement googleSearch = driver.findElement(By.name("q"));
googleSearch.sendKeys("Selenium tutorial");
googleSearch.submit();

// Find checkbox by name
WebElement subscribeCheckbox = driver.findElement(By.name("subscribe"));
if (!subscribeCheckbox.isSelected()) {
    subscribeCheckbox.click();
}
```

**Important Note:** `name` is NOT required to be unique (multiple elements CAN have same name — especially radio buttons). `findElement` returns the first match.

**Radio Button Group Example:**
```html
<input type="radio" name="gender" value="male" />
<input type="radio" name="gender" value="female" />
<input type="radio" name="gender" value="other" />
```

```java
// findElement returns FIRST radio button (male)
driver.findElement(By.name("gender")).click();

// To get ALL radio buttons with same name:
List<WebElement> genderRadios = driver.findElements(By.name("gender"));
genderRadios.get(1).click();  // Click "female" (index 1)
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Name Locator

HTML element లో `name` attribute వాడి element find చేయడం.

Forms లో చాలా elements కి `name` attribute ఉంటుంది. Google search box కి `name="q"` ఉంది.

```java
driver.findElement(By.name("q"));  // Google search box
```

**Note:** `name` unique అయి ఉండాల్సిన అవసరం లేదు. Radio buttons అన్నీ same name వాడతాయి (group గా). `findElement` ఉన్న వాటిలో first ని return చేస్తుంది.

```java
// Radio buttons same name, different value
List<WebElement> genders = driver.findElements(By.name("gender"));
genders.get(0).click();  // First option (Male)
genders.get(1).click();  // Second option (Female)
```

</details>

---

### 3.3 ClassName Locator

**Use when:** Element has a unique CSS class name.

```html
<div class="error-message">Login failed</div>
<button class="submit-btn primary">Submit</button>
<input class="form-control username-field" type="text" />
```

```java
// Find by single class name
WebElement errorDiv = driver.findElement(By.className("error-message"));

// IMPORTANT: Only ONE class name allowed in By.className()
// For "form-control username-field" — you must use ONE of them:
driver.findElement(By.className("form-control"));  // OK
driver.findElement(By.className("username-field")); // OK
// driver.findElement(By.className("form-control username-field")); // FAILS! Space = error

// For multiple classes: use CSS selector instead
driver.findElement(By.cssSelector(".form-control.username-field")); // Better!
```

**When ClassName Fails:**
```java
// Element has class="nav-link active"
// This will work (partial match — finds by ONE class):
driver.findElement(By.className("nav-link"));  // Works
driver.findElement(By.className("active"));    // Works (but matches MANY elements!)

// This FAILS:
driver.findElement(By.className("nav-link active"));  // FAILS — space not allowed
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## ClassName Locator

CSS class name వాడి element find చేయడం.

```java
driver.findElement(By.className("error-message"));
```

**Important Rule:** `By.className()` లో ONLY ఒక class name రాయవచ్చు. Space ఉంటే error వస్తుంది.

```html
<div class="form-control input-large">...</div>
```

```java
// OK — ఒక్కొక్క class name:
driver.findElement(By.className("form-control"));  // OK
driver.findElement(By.className("input-large"));   // OK

// FAIL — రెండు class names:
driver.findElement(By.className("form-control input-large")); // FAILS!

// FIX — CSS selector వాడండి:
driver.findElement(By.cssSelector(".form-control.input-large")); // OK!
```

Multiple classes ఉన్నప్పుడు CSS selector వాడటం better practice.

</details>

---

### 3.4 TagName Locator

**Use when:** You want ALL elements of a specific HTML tag type.

```java
// Get ALL links on the page
List<WebElement> allLinks = driver.findElements(By.tagName("a"));
System.out.println("Total links: " + allLinks.size());

// Get ALL input fields
List<WebElement> allInputs = driver.findElements(By.tagName("input"));

// Get ALL buttons
List<WebElement> allButtons = driver.findElements(By.tagName("button"));

// Get page heading
WebElement mainHeading = driver.findElement(By.tagName("h1"));
System.out.println("Main heading: " + mainHeading.getText());

// Count table rows
List<WebElement> tableRows = driver.findElements(By.tagName("tr"));
System.out.println("Rows in page: " + tableRows.size());
```

**Practical Use Cases:**
```java
// 1. Verify no broken links
List<WebElement> links = driver.findElements(By.tagName("a"));
for (WebElement link : links) {
    String href = link.getAttribute("href");
    if (href == null || href.isEmpty()) {
        System.out.println("WARNING: Link with no href: " + link.getText());
    }
}

// 2. Extract all paragraph text
List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
for (WebElement p : paragraphs) {
    if (!p.getText().isEmpty()) {
        System.out.println("Para: " + p.getText().substring(0, 
                           Math.min(50, p.getText().length())) + "...");
    }
}
```

---

### 3.5 LinkText Locator

**Use when:** You want to click a link and you know the EXACT complete text of the link.

```html
<a href="/contact">Contact Us</a>
<a href="/about">About the Company</a>
<a href="/login">Sign In to Your Account</a>
```

```java
// EXACT text match — must be complete text, exact case
driver.findElement(By.linkText("Contact Us")).click();
driver.findElement(By.linkText("About the Company")).click();
driver.findElement(By.linkText("Sign In to Your Account")).click();

// Case sensitive!
// driver.findElement(By.linkText("contact us")); // FAILS (lowercase)
// driver.findElement(By.linkText("Contact")); // FAILS (partial text)
```

**Real Scenarios:**
```java
// Navigate to specific section
driver.get("https://demoqa.com");
driver.findElement(By.linkText("Elements")).click();

// Verify link exists
List<WebElement> links = driver.findElements(By.linkText("Login"));
if (links.isEmpty()) {
    System.out.println("Login link not found — user may already be logged in");
} else {
    links.get(0).click();
}
```

---

### 3.6 PartialLinkText Locator

**Use when:** You know PART of the link text (useful when text is long or dynamically includes numbers).

```html
<a href="/cart">Your Cart (3 items)</a>
<a href="/notifications">You have 15 new notifications</a>
<a href="/offers">Special Offer valid till today!</a>
```

```java
// Match PART of the link text — case sensitive still!
driver.findElement(By.partialLinkText("Cart")).click();           // Matches "Your Cart (3 items)"
driver.findElement(By.partialLinkText("notifications")).click(); // Matches notification link
driver.findElement(By.partialLinkText("Special Offer")).click(); // Matches offer link

// Real power: dynamic numbers in links
// "You have 15 notifications" — the 15 changes
// Use partial text to match the static part:
driver.findElement(By.partialLinkText("new notifications")).click();
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## LinkText మరియు PartialLinkText Locators

### LinkText
Link యొక్క **exact complete text** వాడి link find చేయడం.

```html
<a href="/contact">Contact Us</a>
```
```java
driver.findElement(By.linkText("Contact Us")).click(); // Exact text కావాలి!
```

Case sensitive! `"contact us"` ఇస్తే fail అవుతుంది.

### PartialLinkText
Link text లో **ఒక భాగం** వాడి find చేయడం.

```html
<a href="/cart">Your Cart (5 items)</a>
```
```java
driver.findElement(By.partialLinkText("Cart")).click(); // "Cart" part match అవుతుంది!
```

**ఎందుకు useful?**
Dynamic content links లో — "You have 15 notifications" లా cart count, notification count change అవుతుంటే, static part వాడి find చేయవచ్చు.

</details>

---

### 3.7 CSS Selector — Deep Dive

> **CSS Selector is the PREFERRED locator for professional Selenium testers.**
> It is fast (browser-native), flexible, readable, and works in 99% of cases.

### What is CSS?

CSS (Cascading Style Sheets) is used to style web pages. It uses **selectors** to target HTML elements. Selenium reuses these same selectors to find elements.

```
HTML Structure Example:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

<div id="loginForm" class="form-container">
    <h2 class="form-title">Login</h2>
    <input id="username" class="form-input" type="text" name="user" />
    <input id="password" class="form-input" type="password" name="pass" />
    <button id="loginBtn" class="btn btn-primary" type="submit">Login</button>
    <a href="/forgot" class="link">Forgot Password?</a>
</div>
```

### CSS Selector Syntax — Complete Guide

#### 1. Select by Tag Name
```java
driver.findElement(By.cssSelector("input"));        // First <input> element
driver.findElement(By.cssSelector("button"));       // First <button>
driver.findElements(By.cssSelector("a"));           // ALL <a> links
```

#### 2. Select by ID
```java
// Syntax: tagname#id  OR  #id
driver.findElement(By.cssSelector("input#username"));    // input with id="username"
driver.findElement(By.cssSelector("#username"));         // Any element with id="username"
driver.findElement(By.cssSelector("button#loginBtn"));   // button with id="loginBtn"
```

#### 3. Select by Class
```java
// Syntax: tagname.classname  OR  .classname
driver.findElement(By.cssSelector("input.form-input"));  // input with class="form-input"
driver.findElement(By.cssSelector(".form-input"));        // Any element with form-input class
driver.findElement(By.cssSelector("button.btn.btn-primary")); // Has BOTH classes
```

#### 4. Select by Attribute
```java
// Syntax: [attribute='value']  OR  tagname[attribute='value']
driver.findElement(By.cssSelector("input[type='text']"));      // input of type text
driver.findElement(By.cssSelector("input[name='user']"));      // input with name=user
driver.findElement(By.cssSelector("[placeholder='Search...']")); // any with this placeholder
driver.findElement(By.cssSelector("a[href='/forgot']"));        // link with specific href

// Multiple attributes
driver.findElement(By.cssSelector("input[type='text'][name='user']")); // Both conditions
```

#### 5. Attribute Value Matching (Advanced)
```java
// ^= : Starts with
driver.findElement(By.cssSelector("input[id^='user']")); // id starts with "user"
// Matches: id="username", id="userEmail", id="userPhone"

// $= : Ends with
driver.findElement(By.cssSelector("input[id$='name']")); // id ends with "name"
// Matches: id="username", id="firstName", id="lastName"

// *= : Contains
driver.findElement(By.cssSelector("input[id*='pass']")); // id contains "pass"
// Matches: id="password", id="newPassword", id="confirmPass"

// Real usage: Find input whose name contains "email"
driver.findElement(By.cssSelector("input[name*='email']"));

// Find link whose href starts with "https"
driver.findElements(By.cssSelector("a[href^='https']"));
```

#### 6. Parent-Child Relationships

```java
// Direct child: parent > child
// Find input that is DIRECT child of div with id="loginForm"
driver.findElement(By.cssSelector("#loginForm > input"));

// Descendant: parent space child (any level deep)
// Find input ANYWHERE inside div with id="loginForm"
driver.findElement(By.cssSelector("#loginForm input"));

// Difference matters:
// <div id="loginForm">
//   <div class="inner">
//     <input id="email" />   ← descendant of #loginForm, but NOT direct child
//   </div>
// </div>

driver.findElement(By.cssSelector("#loginForm > input"));    // FAILS (not direct child)
driver.findElement(By.cssSelector("#loginForm input"));      // WORKS (descendant)
driver.findElement(By.cssSelector("#loginForm > .inner > input")); // WORKS (full path)
```

#### 7. Sibling Selectors

```java
// Adjacent sibling: element + sibling (immediately after)
// Find label that comes IMMEDIATELY after an input
driver.findElement(By.cssSelector("input + label"));

// General sibling: element ~ sibling (any sibling after)
driver.findElement(By.cssSelector("h2 ~ a"));  // Any <a> that is sibling of h2
```

#### 8. Pseudo-Classes

```java
// :first-child — first child of its parent
driver.findElement(By.cssSelector("tr:first-child"));   // First table row

// :last-child — last child of its parent
driver.findElement(By.cssSelector("li:last-child"));    // Last list item

// :nth-child(n) — nth child
driver.findElement(By.cssSelector("tr:nth-child(3)"));  // Third row
driver.findElements(By.cssSelector("tr:nth-child(even)")); // Even rows
driver.findElements(By.cssSelector("tr:nth-child(odd)"));  // Odd rows

// :not() — exclude elements
driver.findElements(By.cssSelector("input:not([type='submit'])"));  // All inputs except submit

// :checked — checked checkboxes/radios
driver.findElements(By.cssSelector("input[type='checkbox']:checked"));

// :disabled — disabled elements
driver.findElements(By.cssSelector("input:disabled"));

// :enabled — enabled elements
driver.findElements(By.cssSelector("input:enabled"));
```

#### 9. Real Complex CSS Selectors

```java
// Find Submit button inside a form with class "login-form"
driver.findElement(By.cssSelector("form.login-form button[type='submit']"));

// Find all text inputs in the registration form
driver.findElements(By.cssSelector("#registrationForm input[type='text']"));

// Find active navigation link
driver.findElement(By.cssSelector("nav a.active"));

// Find error message inside a div with id "response"
driver.findElement(By.cssSelector("div#response .error-msg"));

// Find the 2nd row of a table with id "dataTable"
driver.findElement(By.cssSelector("table#dataTable tr:nth-child(2)"));

// Find checked radio button in a gender group
driver.findElement(By.cssSelector("input[name='gender']:checked"));

// Find all external links (href starts with http)
driver.findElements(By.cssSelector("a[href^='http']"));

// Find submit button that is not disabled
driver.findElement(By.cssSelector("button[type='submit']:not(:disabled)"));
```

### CSS Selector Practice Exercises

```
GIVEN THIS HTML — Write CSS selectors:

<div id="products">
  <div class="product-card featured">
    <h3 class="product-name">Laptop Pro</h3>
    <span class="price">$999</span>
    <button class="add-to-cart" data-id="001">Add to Cart</button>
  </div>
  <div class="product-card">
    <h3 class="product-name">Mouse Wireless</h3>
    <span class="price">$29</span>
    <button class="add-to-cart" data-id="002">Add to Cart</button>
  </div>
</div>

EXERCISES:
1. Find all product cards: ___________
2. Find the featured product card: ___________
3. Find "Laptop Pro" heading: ___________
4. Find button with data-id="002": ___________
5. Find all prices: ___________
6. Find the first Add to Cart button: ___________

ANSWERS:
1. driver.findElements(By.cssSelector(".product-card"))
2. driver.findElement(By.cssSelector(".product-card.featured"))
3. driver.findElement(By.cssSelector(".product-card.featured .product-name"))
4. driver.findElement(By.cssSelector("button[data-id='002']"))
5. driver.findElements(By.cssSelector(".price"))
6. driver.findElement(By.cssSelector(".add-to-cart:first-of-type"))
   OR: driver.findElement(By.cssSelector("#products .add-to-cart"))
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## CSS Selector — Deep Dive

CSS (Cascading Style Sheets) web pages style చేయడానికి వాడే language. అది elements target చేయడానికి **selectors** వాడుతుంది. Selenium same selectors వాడి elements find చేస్తుంది.

### Basic Syntax

**ID:** `#elementId`
```java
driver.findElement(By.cssSelector("#username")); // id="username"
```

**Class:** `.className`
```java
driver.findElement(By.cssSelector(".error-msg")); // class="error-msg"
```

**Tag:** `tagname`
```java
driver.findElement(By.cssSelector("button")); // First button
```

**Attribute:** `[attribute='value']`
```java
driver.findElement(By.cssSelector("input[type='text']")); // text input
```

### Combinations

```java
// Tag + ID: tagname#id
driver.findElement(By.cssSelector("input#username"));

// Tag + Class: tagname.class
driver.findElement(By.cssSelector("button.submit-btn"));

// Multiple classes: .class1.class2 (space లేకుండా)
driver.findElement(By.cssSelector("button.btn.btn-primary"));

// Parent-Child: parent > directChild
driver.findElement(By.cssSelector("form > input"));

// Ancestor-Descendant: ancestor descendant (space తో)
driver.findElement(By.cssSelector("form input")); // form లో ఎక్కడైనా
```

### Attribute Value Matching

```java
// Starts with: [attr^='value']
driver.findElement(By.cssSelector("input[id^='user']")); // id "user" తో మొదలయ్యే

// Ends with: [attr$='value']  
driver.findElement(By.cssSelector("input[id$='name']")); // id "name" తో అయ్యే

// Contains: [attr*='value']
driver.findElement(By.cssSelector("input[name*='email']")); // name లో "email" ఉన్న
```

### ఎందుకు CSS Selector Best?

1. **Speed** — Browser natively CSS process చేస్తుంది, fast
2. **Readability** — Clear మరియు short syntax
3. **Flexibility** — దాదాపు ఏ element అయినా find చేయవచ్చు
4. **Industry standard** — Most professional testers CSS prefer చేస్తారు

</details>

---

### 3.8 XPath — Deep Dive

> **XPath is the MOST POWERFUL locator. It can find ANY element that CSS cannot.**
> Use XPath when CSS selector is not sufficient. It is slightly slower but indispensable.

### What is XPath?

**XPath** (XML Path Language) is a query language for navigating through XML/HTML documents. Think of it as writing directions to find your house starting from a landmark.

```
HTML Tree:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

html
 └── body
      ├── div#header
      │    └── nav
      │         ├── a (Home)
      │         ├── a (About)
      │         └── a (Contact)
      └── div#content
           └── form#loginForm
                ├── input#username
                ├── input#password
                └── button#loginBtn
```

### Absolute XPath vs Relative XPath

**Absolute XPath:** Start from the root HTML element, give the complete path.
```xpath
/html/body/div[2]/form/input[1]
```
**NEVER USE IN REAL PROJECTS.** If ANY parent element changes position, it breaks. Extremely fragile.

**Relative XPath:** Start from anywhere using `//`. Much more stable.
```xpath
//input[@id='username']
//form[@id='loginForm']//input[@type='text']
```
**ALWAYS USE RELATIVE XPath.**

### Basic XPath Syntax

```java
// Syntax: //tagname[@attribute='value']

// Find by ID (like By.id but in XPath)
driver.findElement(By.xpath("//input[@id='username']"));

// Find by name attribute
driver.findElement(By.xpath("//input[@name='q']"));

// Find by class
driver.findElement(By.xpath("//div[@class='error-message']"));

// Find by type
driver.findElement(By.xpath("//input[@type='submit']"));

// Find by text content (anchor text, button text, etc.)
driver.findElement(By.xpath("//button[text()='Login']"));
driver.findElement(By.xpath("//a[text()='Contact Us']"));

// Find by partial text — contains()
driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
// Matches: "Login", "Login Now", "Please Login Here"

// Find by partial attribute — contains()
driver.findElement(By.xpath("//input[contains(@id,'user')]"));
// Matches: id="username", id="userEmail", id="user_field"

// Starts-with function
driver.findElement(By.xpath("//input[starts-with(@id,'user')]"));
// Matches: id="username", id="userEmail" — but NOT id="myuser"
```

### XPath with Multiple Conditions

```java
// AND condition
driver.findElement(By.xpath("//input[@type='text' and @name='email']"));

// OR condition
driver.findElement(By.xpath("//input[@type='text' or @type='email']"));

// NOT condition
driver.findElement(By.xpath("//input[not(@disabled)]"));

// Multiple conditions with and
driver.findElement(By.xpath(
    "//form[@id='loginForm']//input[@type='text' and @placeholder='Username']"
));
```

### XPath Axes — The Most Powerful XPath Feature

**XPath Axes** let you navigate relative to an element — find its parent, siblings, children, etc.

```
XPATH AXES REFERENCE:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Axis Name           Direction       Example Use Case
─────────────────────────────────────────────────────
parent::            Up              Find parent of current element
child::             Down (direct)   Find direct children
ancestor::          Up (all)        Find any ancestor
descendant::        Down (all)      Find any descendant
following::         Forward         Elements after in document
following-sibling:: Same level, after   Next sibling
preceding::         Backward        Elements before in document
preceding-sibling:: Same level, before  Previous sibling
self::              Current         Reference to current element
```

```java
// HTML structure for these examples:
// <div class="form-group">
//   <label>Username</label>
//   <input id="username" type="text" />
// </div>

// 1. parent:: — Find parent div of the input
driver.findElement(By.xpath("//input[@id='username']/parent::div"));

// 2. following-sibling:: — Find sibling after current element
// Find input that comes AFTER a label with text "Username"
driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input"));

// 3. preceding-sibling:: — Find sibling BEFORE current element  
// Find label that comes BEFORE the username input
driver.findElement(By.xpath("//input[@id='username']/preceding-sibling::label"));

// 4. ancestor:: — Find ancestor
// Find form that contains the username input
driver.findElement(By.xpath("//input[@id='username']/ancestor::form"));

// 5. following:: — All elements after this one (any level)
driver.findElements(By.xpath("//input[@id='username']/following::*"));
```

### XPath Functions Reference

```java
// text() — Match exact element text
driver.findElement(By.xpath("//h2[text()='Login to Your Account']"));

// contains(text(), 'value') — Match partial text
driver.findElement(By.xpath("//h2[contains(text(),'Login')]"));

// contains(@attr, 'value') — Match partial attribute
driver.findElement(By.xpath("//input[contains(@class,'form-input')]"));

// starts-with(@attr, 'value') — Match attribute start
driver.findElement(By.xpath("//input[starts-with(@id,'user')]"));

// normalize-space() — Handle text with extra whitespace
driver.findElement(By.xpath("//button[normalize-space(text())='Submit']"));

// last() — Get last element in a list
driver.findElement(By.xpath("//li[last()]"));              // Last list item
driver.findElement(By.xpath("//tr[last()]"));              // Last table row

// position() — Get element by position
driver.findElement(By.xpath("//tr[position()=3]"));        // Third row
driver.findElement(By.xpath("//li[position()>2]"));        // li items after 2nd

// count() — Count elements
// Can't use directly in findElement but useful in conditions
// Find table that has more than 5 rows
driver.findElement(By.xpath("//table[count(tr)>5]"));
```

### Dynamic XPath Patterns

```java
// ── PATTERN 1: Find by sibling text ────────────────────────────────
// HTML: <td>John</td><td>Edit</td>
// Find "Edit" button in the same row as "John"
driver.findElement(By.xpath("//td[text()='John']/following-sibling::td/button"));

// ── PATTERN 2: Find by label text ──────────────────────────────────
// HTML: <label for="email">Email Address</label>
//       <input id="email" type="email" />
// Find input associated with "Email Address" label
driver.findElement(By.xpath("//label[text()='Email Address']/following-sibling::input"));
// OR using for attribute:
String labelFor = driver.findElement(
    By.xpath("//label[text()='Email Address']")).getAttribute("for");
driver.findElement(By.id(labelFor));

// ── PATTERN 3: Dynamic index ────────────────────────────────────────
// Find 3rd row in a table
driver.findElement(By.xpath("//table[@id='userTable']//tr[3]"));
// Find 2nd column in 3rd row
driver.findElement(By.xpath("//table[@id='userTable']//tr[3]/td[2]"));

// ── PATTERN 4: Building XPath dynamically in Java ──────────────────
String productName = "iPhone 15";
String xpath = "//div[@class='product-name'][text()='" + productName + "']";
driver.findElement(By.xpath(xpath));

// Or with String.format
String dynamicXpath = String.format("//tr[contains(., '%s')]//button[@class='edit-btn']",
                                     "John Smith");
driver.findElement(By.xpath(dynamicXpath));

// ── PATTERN 5: Find by text in child element ────────────────────────
// HTML: <div class="card"><h3>Product Name</h3><span>Price</span></div>
// Find card whose h3 says "Laptop"
driver.findElement(By.xpath("//div[@class='card'][.//h3[text()='Laptop']]"));
```

### XPath Challenges — Practice These!

```
CHALLENGE 1: Find the Submit button in a form
HTML: <form id="reg"><div><button type="submit" class="btn">Submit</button></div></form>
Answer: //form[@id='reg']//button[@type='submit']

CHALLENGE 2: Find the error message that appears after failed login
HTML: <div class="alert alert-danger" id="flash-error">Invalid Username or Password!</div>
Answer: //div[contains(@class,'alert-danger')] 
  OR:   //*[@id='flash-error']

CHALLENGE 3: Find the "Delete" link in the row for "John Smith"
HTML:
<table>
  <tr><td>John Smith</td><td><a href="/delete/1">Delete</a></td></tr>
  <tr><td>Jane Doe</td><td><a href="/delete/2">Delete</a></td></tr>
</table>
Answer: //td[text()='John Smith']/following-sibling::td/a[text()='Delete']

CHALLENGE 4: Find the input that comes after a label "Email"
HTML: <label class="control-label">Email</label><input class="form-control" name="email"/>
Answer: //label[text()='Email']/following-sibling::input

CHALLENGE 5: Find checked radio button
HTML: <input type="radio" name="gender" value="male" checked>
Answer: //input[@type='radio' and @checked]
  OR:   //input[@type='radio'][@checked]
```

### XPath vs CSS Selector Comparison

| Feature | XPath | CSS Selector |
|---------|-------|-------------|
| Speed | Slower | Faster |
| Text matching | `[text()='value']` | Not possible |
| Parent traversal | `parent::` | Not possible |
| Ancestor traversal | `ancestor::` | Not possible |
| Preceding sibling | `preceding-sibling::` | Not possible |
| Forward navigation | `following-sibling::` | `+` (adjacent only) |
| Attribute matching | `@attribute='value'` | `[attr='value']` |
| Partial text | `contains(text(),'val')` | Not possible |
| Readability | More verbose | Cleaner |
| Browser support | Universal | Universal |

**Rule of thumb:**
- Use **CSS** when you can — it's faster and cleaner
- Use **XPath** when you MUST — when CSS cannot do it (text matching, parent traversal)

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## XPath — Deep Dive

### XPath అంటే ఏమిటి?

XPath (XML Path Language) — HTML/XML documents లో elements find చేయడానికి వాడే query language. ఒక landmark నుండి మీ ఇంటికి directions ఇవ్వడం లాంటిది.

### Absolute vs Relative XPath

**Absolute:** Root నుండి complete path
```xpath
/html/body/div[2]/form/input[1]
```
Real projects లో **వాడకూడదు** — page structure మారితే break అవుతుంది.

**Relative:** ఎక్కడ నుండైనా `//` తో మొదలుపెట్టవచ్చు
```xpath
//input[@id='username']
```
**ఎప్పుడూ Relative XPath వాడండి.**

### Basic Syntax

```java
// //tagname[@attribute='value']

//input[@id='username']         // id వాడి
//input[@name='q']              // name వాడి
//button[text()='Login']        // button text వాడి
//button[contains(text(),'Log')] // partial text వాడి
//input[contains(@id,'user')]   // partial attribute వాడి
```

### XPath Axes — చాలా powerful!

```java
// Label తర్వాత ఉన్న input find చేయడం:
//label[text()='Username']/following-sibling::input

// Input యొక్క parent div:
//input[@id='username']/parent::div

// Table row లో "John" ఉన్న row లో Edit button:
//td[text()='John']/following-sibling::td/button[text()='Edit']
```

### XPath vs CSS Selector ఎప్పుడు వాడాలి?

**CSS Selector వాడండి:**
- id, class, attribute, child-parent relations కోసం
- Fast performance కావాలంటే

**XPath వాడండి:**
- Element text తో find చేయాలంటే (`text()` function)
- Parent/ancestor కి navigate చేయాలంటే
- CSS చేయలేని situations లో

</details>

---

### 3.9 Locator Decision Framework

```
LOCATOR SELECTION DECISION TREE:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Is there a unique, stable ID?
    YES → Use By.id()
    NO  → Continue

Does it have a unique stable name attribute?
    YES → Use By.name()
    NO  → Continue

Is it a link and you know exact text?
    YES → Use By.linkText() or By.partialLinkText()
    NO  → Continue

Can CSS selector uniquely identify it?
    YES → Use By.cssSelector()  ← PREFERRED for most cases
    NO  → Continue

Do you need text matching or parent traversal?
    YES → Use By.xpath()
    NO  → Reconsider — there is almost always a CSS approach

Is the element truly unique in the page?
    Verify in browser DevTools first!
    Use: $x("//your/xpath") in Chrome console
          $$("your css selector") in Chrome console
```

### How to Find Locators Using Browser DevTools

```
CHROME DEVTOOLS LOCATOR FINDING:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

1. Open Chrome DevTools: F12 or Right-click → Inspect

2. Click the selector tool (cursor icon top-left of DevTools)

3. Click the element on the page

4. See HTML in DevTools panel — find stable attributes (id, name)

5. Test your locator:
   In DevTools Console tab:
   - For CSS: $$("your.css.selector") → shows matching elements
   - For XPath: $x("//your/xpath") → shows matching elements
   
6. Count results:
   - 1 element? Perfect locator!
   - 0 elements? Wrong locator
   - Many elements? Too broad — make it more specific

RIGHT-CLICK SHORTCUT:
In Elements panel → Right-click element → Copy → Copy selector (CSS)
                                                → Copy XPath
These give you a starting point, but auto-generated selectors are
often fragile. Edit them to use stable attributes.
```

---

## 4. WebElement Operations

### What is a WebElement?

A `WebElement` represents a single HTML element that you have found. Once you find an element, you can perform actions on it.

```java
// Find element → WebElement object
WebElement loginButton = driver.findElement(By.id("loginBtn"));

// Now you can perform operations on 'loginButton'
```

### Complete WebElement Methods Reference

```java
WebElement element = driver.findElement(By.id("someElement"));

// ── ACTIONS ────────────────────────────────────────────────────────

// click() — Simulate mouse click
element.click();

// sendKeys() — Type text (also used for keyboard keys)
element.sendKeys("Hello World");
element.sendKeys("admin@test.com");
element.sendKeys(Keys.ENTER);          // Press Enter key
element.sendKeys(Keys.TAB);            // Press Tab key
element.sendKeys(Keys.CONTROL + "a");  // Ctrl+A (select all)

// clear() — Clear the text in input/textarea
element.clear();

// submit() — Submit the form (works on input inside form)
element.submit();  // Same as pressing Enter on a form field

// ── INFORMATION RETRIEVAL ──────────────────────────────────────────

// getText() — Get visible text of the element
String buttonText = element.getText();
System.out.println("Button text: " + buttonText);

// getAttribute("attrName") — Get value of any HTML attribute
String type = element.getAttribute("type");       // Returns "text", "password", etc.
String href = element.getAttribute("href");       // Link URL
String value = element.getAttribute("value");     // Input field current value
String cssClass = element.getAttribute("class"); // CSS classes
String placeholder = element.getAttribute("placeholder"); // Placeholder text
String dataId = element.getAttribute("data-id");  // Custom data attributes

// getCssValue("property") — Get computed CSS property value
String color = element.getCssValue("color");
String fontSize = element.getCssValue("font-size");
String bgColor = element.getCssValue("background-color");
// Returns values in specific formats: "rgba(0, 0, 0, 1)" for colors

// getTagName() — Get HTML tag name
String tag = element.getTagName();  // "input", "button", "div", "a"

// ── STATE CHECKS ───────────────────────────────────────────────────

// isDisplayed() — Is element visible on page?
boolean visible = element.isDisplayed();

// isEnabled() — Is element interactable? (not disabled)
boolean enabled = element.isEnabled();

// isSelected() — For checkboxes and radio buttons only
boolean checked = element.isSelected();

// ── LOCATION AND SIZE ──────────────────────────────────────────────

// getLocation() — X,Y coordinates on screen
Point location = element.getLocation();
System.out.println("X: " + location.x + " Y: " + location.y);

// getSize() — Width and Height of element
Dimension size = element.getSize();
System.out.println("Width: " + size.width + " Height: " + size.height);

// getRect() — Both location and size combined
Rectangle rect = element.getRect();
System.out.println("X:" + rect.x + " Y:" + rect.y + 
                   " W:" + rect.width + " H:" + rect.height);

// ── FINDING WITHIN ELEMENT ─────────────────────────────────────────

// findElement within element — search only within this element's subtree
WebElement form = driver.findElement(By.id("loginForm"));
WebElement inputInForm = form.findElement(By.tagName("input")); // Searches only inside form!
List<WebElement> allInputsInForm = form.findElements(By.tagName("input"));
```

### Detailed Code Examples

#### Simple: Basic WebElement Operations

```java
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementBasics {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Go to DemoQA forms
        driver.get("https://demoqa.com/text-box");
        
        // Find and fill Full Name
        WebElement fullNameInput = driver.findElement(By.id("userName"));
        
        System.out.println("Tag name: " + fullNameInput.getTagName());
        System.out.println("Type: " + fullNameInput.getAttribute("type"));
        System.out.println("Is displayed: " + fullNameInput.isDisplayed());
        System.out.println("Is enabled: " + fullNameInput.isEnabled());
        
        fullNameInput.clear();
        fullNameInput.sendKeys("Venkata Bharath");
        
        System.out.println("Value after typing: " + fullNameInput.getAttribute("value"));
        
        // Find email field
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("vb@test.com");
        
        // Get placeholder text
        System.out.println("Email placeholder: " + emailInput.getAttribute("placeholder"));
        
        Thread.sleep(1000);
        driver.quit();
    }
}
```

#### Intermediate: State Verification

```java
public class WebElementStateChecks {
    
    public static void demonstrateStateChecks(WebDriver driver) {
        
        driver.get("https://demoqa.com/automation-practice-form");
        
        // Check submit button state
        WebElement submitBtn = driver.findElement(By.id("submit"));
        System.out.println("Submit button displayed: " + submitBtn.isDisplayed());
        System.out.println("Submit button enabled: " + submitBtn.isEnabled());
        System.out.println("Submit button text: " + submitBtn.getText());
        System.out.println("Submit button location: " + submitBtn.getLocation());
        System.out.println("Submit button size: " + submitBtn.getSize());
        
        // Check radio button state
        WebElement maleRadio = driver.findElement(By.xpath("//label[text()='Male']/..//input"));
        System.out.println("Male radio selected: " + maleRadio.isSelected());
        maleRadio.click();
        System.out.println("Male radio selected after click: " + maleRadio.isSelected());
        
        // Get CSS properties
        WebElement firstName = driver.findElement(By.id("firstName"));
        System.out.println("Font size: " + firstName.getCssValue("font-size"));
        System.out.println("Border: " + firstName.getCssValue("border-color"));
    }
}
```

#### Advanced: Complete Form Interaction

```java
public class AdvancedWebElementInteraction {
    
    public static void completeFormInteraction(WebDriver driver) throws InterruptedException {
        
        driver.get("https://the-internet.herokuapp.com/login");
        
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        
        // Verify initial state
        assert usernameField.isDisplayed() : "Username field not visible!";
        assert usernameField.isEnabled() : "Username field not enabled!";
        assert usernameField.getAttribute("value").isEmpty() : "Username field not empty!";
        
        // Type using different methods
        usernameField.sendKeys("tomsmith");
        
        // Tab to next field using keyboard
        usernameField.sendKeys(Keys.TAB);  
        // Now password field should be focused
        
        // Type in password field (now focused)
        driver.switchTo().activeElement().sendKeys("SuperSecretPassword!");
        
        // Verify values
        System.out.println("Username entered: " + usernameField.getAttribute("value"));
        
        // Click login
        loginButton.click();
        
        Thread.sleep(2000);
        
        // Check for success
        try {
            WebElement flashMessage = driver.findElement(By.id("flash"));
            System.out.println("Flash message: " + flashMessage.getText());
            
            if (flashMessage.getText().contains("You logged into a secure area")) {
                System.out.println("✅ LOGIN SUCCESSFUL");
            } else {
                System.out.println("❌ LOGIN FAILED: " + flashMessage.getText());
            }
        } catch (Exception e) {
            System.out.println("No flash message found");
        }
        
        driver.quit();
    }
}
```

### Common Mistakes and Fixes

| Mistake | Error | Fix |
|---------|-------|-----|
| `element.sendKeys()` without clearing first | Text appends to existing | Call `element.clear()` first |
| `getText()` on input field | Returns empty string | Use `getAttribute("value")` for inputs |
| `click()` on hidden element | ElementNotInteractableException | Use JavaScript click or scroll to element |
| `isDisplayed()` returns false | Element exists in DOM but not visible | Scroll to element or wait for it |
| Using `getAttribute("text")` | Returns null | Use `getText()` method instead |

**Pro Tips:**

> **Pro Tip 1:** `getText()` returns the VISIBLE text. For input fields, use `getAttribute("value")` instead — `getText()` returns empty for inputs.

> **Pro Tip 2:** Always call `element.clear()` before `element.sendKeys()` unless you specifically want to append to existing text. Forgetting this causes "adminoldtext" type bugs.

> **Pro Tip 3:** `isDisplayed()` returns false if element is present in DOM but hidden (CSS `display:none` or `visibility:hidden`). Use this to verify error messages appear.

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## WebElement Operations

### WebElement అంటే ఏమిటి?

`WebElement` అనేది మీరు find చేసిన ఒక HTML element ని represent చేస్తుంది. Element find చేసిన తర్వాత దాని మీద various actions perform చేయవచ్చు.

### Actions

```java
element.click();              // Click చేయడం
element.sendKeys("text");     // Text type చేయడం
element.clear();              // Text clear చేయడం
element.submit();             // Form submit చేయడం
```

### Information Retrieval

```java
element.getText();            // Visible text తెచ్చుకోవడం
element.getAttribute("id");   // HTML attribute value తెచ్చుకోవడం
element.getAttribute("value"); // Input field లో ఉన్న text (getText() కాదు!)
element.getTagName();         // "input", "button", "div" etc.
element.getCssValue("color"); // CSS property value
```

### State Checks

```java
element.isDisplayed();   // Element కనిపిస్తుందా?
element.isEnabled();     // Element enable గా ఉందా? (disabled కాదు)
element.isSelected();    // Checkbox/Radio selected గా ఉందా?
```

### Important Notes

**`getText()` vs `getAttribute("value")`:**
- `getText()` — element యొక్క visible text కి (buttons, divs, spans)
- `getAttribute("value")` — input fields లో type చేసిన text కి
- Input field కి `getText()` ఇస్తే empty string వస్తుంది!

**`clear()` ముందు call చేయండి:**
```java
// Wrong way:
element.sendKeys("newtext"); // Old text + "newtext" = "oldtextnewtext"

// Correct way:
element.clear();
element.sendKeys("newtext");  // Only "newtext"
```

</details>

---

## 5. Multiple Element Handling

### findElements — Returns a List

When you use `findElements` (plural), it returns all matching elements as a `List<WebElement>`.

```java
// Find ALL elements matching the locator
List<WebElement> allLinks = driver.findElements(By.tagName("a"));

// KEY DIFFERENCE FROM findElement:
// findElement:  Throws NoSuchElementException if nothing found
// findElements: Returns EMPTY list if nothing found — no exception!

// Check if list is empty
if (allLinks.isEmpty()) {
    System.out.println("No links found on this page");
} else {
    System.out.println("Found " + allLinks.size() + " links");
}
```

### Practical Patterns

#### Simple: Extract All Link Texts

```java
driver.get("https://www.selenium.dev");

List<WebElement> navLinks = driver.findElements(By.cssSelector("nav a"));

System.out.println("Navigation links found: " + navLinks.size());
for (WebElement link : navLinks) {
    System.out.println("- " + link.getText() + " → " + link.getAttribute("href"));
}
```

#### Intermediate: Find Specific Element from List

```java
driver.get("https://demoqa.com/checkbox");

// Get all checkboxes
List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

System.out.println("Total checkboxes: " + checkboxes.size());

// Method 1: Loop and find by text
List<WebElement> labels = driver.findElements(By.cssSelector("label.rct-label"));

for (int i = 0; i < labels.size(); i++) {
    String labelText = labels.get(i).getText();
    System.out.println(i + ": " + labelText);
    
    if (labelText.equals("Downloads")) {
        checkboxes.get(i).click();
        System.out.println("Clicked Downloads checkbox");
        break;
    }
}

// Method 2: Find by associated XPath
driver.findElement(By.xpath("//span[text()='Downloads']/preceding-sibling::input")).click();
```

#### Advanced: Table Data Extraction with Multiple Elements

```java
public class TableExtractor {
    
    public void extractTableData(WebDriver driver, String tableId) {
        
        // Find the table
        WebElement table = driver.findElement(By.id(tableId));
        
        // Get all rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("Total rows (including header): " + rows.size());
        
        // Process header row separately
        WebElement headerRow = rows.get(0);
        List<WebElement> headers = headerRow.findElements(By.tagName("th"));
        
        System.out.print("Headers: ");
        List<String> headerNames = new ArrayList<>();
        for (WebElement header : headers) {
            headerNames.add(header.getText());
            System.out.print(header.getText() + " | ");
        }
        System.out.println();
        
        // Process data rows
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < cells.size(); j++) {
                System.out.print(headerNames.get(j) + "=" + cells.get(j).getText() + " | ");
            }
            System.out.println();
        }
    }
}
```

### Common Use Cases

```java
// 1. Count specific elements on page
int linkCount = driver.findElements(By.tagName("a")).size();
int imageCount = driver.findElements(By.tagName("img")).size();
int inputCount = driver.findElements(By.tagName("input")).size();

// 2. Verify no error messages
List<WebElement> errors = driver.findElements(By.className("error-msg"));
assert errors.isEmpty() : "Error messages found: " + errors.size();

// 3. Get all dropdown options (without Select class)
List<WebElement> options = driver.findElements(By.cssSelector("select#country option"));
List<String> optionTexts = new ArrayList<>();
for (WebElement option : options) {
    optionTexts.add(option.getText());
}
System.out.println("All options: " + optionTexts);

// 4. Find and click using index
List<WebElement> editButtons = driver.findElements(By.cssSelector("button.edit-btn"));
editButtons.get(2).click();  // Click third edit button
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Multiple Elements Handling

### findElements (plural!) — List Return చేస్తుంది

```java
List<WebElement> allLinks = driver.findElements(By.tagName("a"));
```

**findElement vs findElements:**
- `findElement` — ఒక element return, దొరక్కపోతే exception
- `findElements` — List return, దొరక్కపోతే empty list (exception కాదు!)

### List తో పనిచేయడం

```java
List<WebElement> links = driver.findElements(By.tagName("a"));

// Size check
System.out.println("Total: " + links.size());

// Empty check
if (links.isEmpty()) {
    System.out.println("No links found");
}

// Loop through all
for (WebElement link : links) {
    System.out.println(link.getText());
}

// Specific element by index
WebElement firstLink = links.get(0);   // First
WebElement lastLink = links.get(links.size() - 1);  // Last
```

### Real-World Usage

1. **Page లో అన్ని links verify చేయడం** — Link verification
2. **Table data extract చేయడం** — Data extraction
3. **Checkboxes/Radio buttons handle చేయడం** — Form interaction
4. **Error messages check చేయడం** — Validation testing

```java
// Error messages ఉన్నాయా check చేయడం
List<WebElement> errors = driver.findElements(By.className("error"));
if (errors.isEmpty()) {
    System.out.println("No errors — test passed!");
} else {
    System.out.println(errors.size() + " errors found!");
}
```

</details>

---

## 6. Browser Operations

### Navigation and Timeouts

```java
WebDriver driver = new ChromeDriver();

// ── WINDOW OPERATIONS ──────────────────────────────────────────────

driver.manage().window().maximize();              // Maximize
driver.manage().window().minimize();              // Minimize
driver.manage().window().fullscreen();            // F11 Full screen
driver.manage().window().setSize(new Dimension(1366, 768)); // Custom size

// ── TIMEOUTS ───────────────────────────────────────────────────────

// Page load timeout: How long to wait for page to fully load
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

// Implicit wait: How long to wait for element to appear
// (Applies globally to ALL findElement calls)
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// Script timeout: Max time for JavaScript execution
driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));

// ── NAVIGATION ─────────────────────────────────────────────────────

driver.get("https://google.com");           // Go to URL
driver.navigate().to("https://amazon.com"); // Navigate (same as get)
driver.navigate().back();                   // Click back
driver.navigate().forward();                // Click forward
driver.navigate().refresh();                // Refresh page

// ── BROWSER LEVEL INFORMATION ──────────────────────────────────────

System.out.println("Current URL: " + driver.getCurrentUrl());
System.out.println("Page Title: " + driver.getTitle());
System.out.println("Page Source length: " + driver.getPageSource().length());
System.out.println("Window handle: " + driver.getWindowHandle());
System.out.println("All handles: " + driver.getWindowHandles());
```

### Real-World Browser Operation Scenarios

```java
// Scenario 1: Navigate through a multi-page form
driver.get("https://example.com/step1");
// Fill step 1 form
driver.findElement(By.id("name")).sendKeys("Venkata");
driver.findElement(By.id("nextBtn")).click();

// Step 2 page loads
Thread.sleep(1000);
driver.findElement(By.id("email")).sendKeys("vb@test.com");
driver.findElement(By.id("nextBtn")).click();

// Go back to step 1 to verify
driver.navigate().back();
String nameValue = driver.findElement(By.id("name")).getAttribute("value");
System.out.println("Name on step 1 after going back: " + nameValue);

// Scenario 2: Handle page that redirects
String initialUrl = "https://www.example.com/redirect";
driver.get(initialUrl);
Thread.sleep(2000); // Wait for redirect
String finalUrl = driver.getCurrentUrl();

if (finalUrl.equals(initialUrl)) {
    System.out.println("No redirect happened");
} else {
    System.out.println("Redirected from: " + initialUrl + " to: " + finalUrl);
}

// Scenario 3: Verify page refreshes correctly
String originalTitle = driver.getTitle();
driver.navigate().refresh();
Thread.sleep(1000);
String titleAfterRefresh = driver.getTitle();
assert originalTitle.equals(titleAfterRefresh) : "Title changed after refresh!";
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Browser Operations

### Window Operations

```java
driver.manage().window().maximize();  // Maximize — tests కి important!
driver.manage().window().minimize();  // Minimize
driver.manage().window().setSize(new Dimension(1366, 768)); // Custom size
```

### Navigation

```java
driver.get("https://google.com");     // URL కి navigate చేయడం
driver.navigate().back();             // Browser back button (←)
driver.navigate().forward();          // Browser forward button (→)
driver.navigate().refresh();          // Page refresh (F5)
```

### Timeouts

```java
// Page Load Timeout: Page load కి maximum wait time
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

// Implicit Wait: Element కి maximum wait time (global)
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

**Page Load Timeout ముఖ్యం:** Heavy websites load కావడానికి time పడవచ్చు. Default timeout 300 seconds (చాలా long). 30 seconds reasonable value.

**Timeouts గురించి Part 3 లో deeply cover చేస్తాం.**

</details>

---

## 7. Dropdown Handling — Select Class

### HTML Dropdown Types

There are TWO types of dropdowns:
1. **HTML `<select>` element** — Native HTML dropdown → Use Selenium's `Select` class
2. **Custom dropdowns** — Built with div/ul/li elements → Treat as regular elements

### Select Class Methods

```java
import org.openqa.selenium.support.ui.Select;

// ── SETUP ──────────────────────────────────────────────────────────

WebElement dropdownElement = driver.findElement(By.id("countryDropdown"));
Select select = new Select(dropdownElement);  // Wrap in Select class

// ── SELECT BY OPTIONS ──────────────────────────────────────────────

// 1. Select by visible text (what user sees)
select.selectByVisibleText("India");
select.selectByVisibleText("United States");

// 2. Select by value attribute of <option>
// HTML: <option value="IN">India</option>
select.selectByValue("IN");
select.selectByValue("US");

// 3. Select by index (0-based)
select.selectByIndex(0);   // First option
select.selectByIndex(3);   // Fourth option

// ── DESELECT (Multi-select dropdowns only) ─────────────────────────

select.deselectByVisibleText("India");
select.deselectByValue("IN");
select.deselectByIndex(0);
select.deselectAll();  // Deselect everything

// ── GET INFORMATION ────────────────────────────────────────────────

// Get currently selected option
WebElement selectedOption = select.getFirstSelectedOption();
System.out.println("Selected: " + selectedOption.getText());

// Get ALL selected options (for multi-select)
List<WebElement> selectedOptions = select.getAllSelectedOptions();
for (WebElement opt : selectedOptions) {
    System.out.println("Selected: " + opt.getText());
}

// Get ALL available options
List<WebElement> allOptions = select.getOptions();
System.out.println("Total options: " + allOptions.size());

for (WebElement option : allOptions) {
    System.out.println("Option: " + option.getText() + 
                       " | Value: " + option.getAttribute("value") +
                       " | Selected: " + option.isSelected());
}

// ── MULTI-SELECT CHECK ─────────────────────────────────────────────
boolean isMultiSelect = select.isMultiple();
System.out.println("Is multi-select: " + isMultiSelect);
```

### Complete Dropdown Test

```java
public class DropdownTest {
    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        
        // ── Standard Select ─────────────────────────────────────────

        // Find the "Select Value" dropdown (it's a custom dropdown, not <select>)
        // For standard HTML <select>:
        
        driver.get("https://the-internet.herokuapp.com/dropdown");
        
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        
        // Print all options
        System.out.println("All available options:");
        for (WebElement opt : select.getOptions()) {
            System.out.println("  - '" + opt.getText() + "' (value: " + 
                               opt.getAttribute("value") + ")");
        }
        
        // Select Option 1
        select.selectByVisibleText("Option 1");
        System.out.println("Selected: " + select.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        
        // Select Option 2 by index
        select.selectByIndex(2);  // 0=blank, 1=Option 1, 2=Option 2
        System.out.println("Selected: " + select.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        
        // Select by value
        select.selectByValue("1");
        System.out.println("Selected by value: " + select.getFirstSelectedOption().getText());
        
        driver.quit();
    }
}
```

### Custom Dropdown (Non-Select Elements)

Many modern applications use custom dropdowns built with `div`, `ul`, `li` elements.

```html
<!-- Custom dropdown (NOT <select>) -->
<div class="custom-dropdown">
    <div class="dropdown-trigger">Select Country</div>
    <ul class="dropdown-menu">
        <li data-value="in">India</li>
        <li data-value="us">United States</li>
        <li data-value="uk">United Kingdom</li>
    </ul>
</div>
```

```java
// Handle custom dropdown
WebElement dropdownTrigger = driver.findElement(By.cssSelector(".dropdown-trigger"));
dropdownTrigger.click();  // Open the dropdown

// Wait for dropdown to open
Thread.sleep(500);

// Click the desired option
driver.findElement(By.xpath("//li[text()='India']")).click();
// OR: driver.findElement(By.cssSelector("li[data-value='in']")).click();

// Verify selection
String selected = driver.findElement(By.cssSelector(".dropdown-trigger")).getText();
System.out.println("Selected: " + selected);  // Should show "India"
```

### 5 Real-World Scenarios

1. **Country/State Dropdown:** User registration form with country selector
2. **Sorting Dropdown:** E-commerce "Sort by" dropdown (Price, Rating, Newest)
3. **Language Selector:** Website language dropdown
4. **Category Filter:** Product filtering dropdown in shopping site
5. **Date of Birth:** Month/Day/Year separate dropdowns

### Common Mistakes and Fixes

```java
// MISTAKE 1: Using Select class on non-<select> element
// This throws "Element should have been select but was div"
Select s = new Select(driver.findElement(By.cssSelector("div.custom-dropdown")));
// FIX: Only use Select class on <select> HTML elements

// MISTAKE 2: Selecting before dropdown is visible/clickable
select.selectByVisibleText("India");  // Might fail if dropdown not loaded
// FIX: Use explicit wait (Part 3) before selecting

// MISTAKE 3: Case-sensitive text mismatch
select.selectByVisibleText("india");  // FAILS if option text is "India"
// FIX: Must match EXACTLY including case
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Dropdown Handling

### రెండు రకాల Dropdowns

1. **HTML `<select>` element** — Native dropdown → `Select` class వాడాలి
2. **Custom dropdown** — div/ul/li తో చేసినవి → Normal elements లా treat చేయాలి

### Select Class వాడటం

```java
WebElement dd = driver.findElement(By.id("countryDropdown"));
Select select = new Select(dd);  // Wrap in Select class

// Text తో select చేయడం (most readable)
select.selectByVisibleText("India");

// Value attribute తో select చేయడం
// HTML: <option value="IN">India</option>
select.selectByValue("IN");

// Index తో select చేయడం (0 నుండి మొదలు)
select.selectByIndex(0);  // First option
```

### Information తెచ్చుకోవడం

```java
// Currently selected option
String selected = select.getFirstSelectedOption().getText();
System.out.println("Selected: " + selected);

// All available options
List<WebElement> allOpts = select.getOptions();
System.out.println("Total options: " + allOpts.size());
```

### Custom Dropdown Handle చేయడం

Custom dropdowns (React/Angular apps) లో `Select` class పనిచేయదు.

```java
// Click to open dropdown
driver.findElement(By.cssSelector(".dropdown-btn")).click();

// Wait for it to open, then click option
driver.findElement(By.xpath("//li[text()='India']")).click();
```

### Common Mistake

`Select` class only `<select>` HTML element కి work అవుతుంది. Custom dropdowns కి ఇది error ఇస్తుంది:
`"Element should have been select but was div"`

</details>

---

## 8. Radio Buttons and Checkboxes

### Radio Buttons

Radio buttons: Only ONE can be selected in a group at a time.

```java
// HTML:
// <input type="radio" id="male" name="gender" value="male" />
// <input type="radio" id="female" name="gender" value="female" />
// <input type="radio" id="other" name="gender" value="other" />

// Click a radio button
driver.findElement(By.id("male")).click();

// Verify selection
WebElement maleRadio = driver.findElement(By.id("male"));
System.out.println("Male selected: " + maleRadio.isSelected());  // true
System.out.println("Female selected: " + driver.findElement(By.id("female")).isSelected()); // false

// Select radio by label text (using XPath)
driver.findElement(By.xpath("//label[text()='Female']/preceding-sibling::input")).click();
// OR
driver.findElement(By.xpath("//input[@value='female']")).click();

// Get all radio buttons in a group
List<WebElement> genderRadios = driver.findElements(By.name("gender"));
System.out.println("Total radio options: " + genderRadios.size());

// Find which one is currently selected
for (WebElement radio : genderRadios) {
    if (radio.isSelected()) {
        System.out.println("Currently selected: " + radio.getAttribute("value"));
        break;
    }
}
```

### Checkboxes

Checkboxes: Multiple can be selected at the same time.

```java
// HTML:
// <input type="checkbox" id="terms" name="agree" />
// <input type="checkbox" id="newsletter" name="subscribe" />

WebElement termsCheckbox = driver.findElement(By.id("terms"));
WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));

// Check state before acting
System.out.println("Terms accepted: " + termsCheckbox.isSelected());

// Only click if not already selected
if (!termsCheckbox.isSelected()) {
    termsCheckbox.click();
    System.out.println("Terms checkbox checked");
}

// Uncheck if currently checked
if (newsletterCheckbox.isSelected()) {
    newsletterCheckbox.click();
    System.out.println("Newsletter checkbox unchecked");
}

// Verify final state
assert termsCheckbox.isSelected() : "Terms checkbox should be checked!";
assert !newsletterCheckbox.isSelected() : "Newsletter checkbox should be unchecked!";
```

### Practical Example — Full Form with Checkboxes and Radios

```java
public class RadioCheckboxTest {
    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 400)");
        Thread.sleep(500);
        
        // Select Male radio button
        // Note: On demoqa, the radio input might be hidden; click the label
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        
        // Verify selection
        WebElement maleInput = driver.findElement(By.xpath("//input[@value='Male']"));
        System.out.println("Male selected: " + maleInput.isSelected());
        
        // Select Hobbies checkboxes
        // Sports checkbox
        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        
        // Reading checkbox
        driver.findElement(By.xpath("//label[text()='Reading']")).click();
        
        // Verify checkboxes
        WebElement sportsInput = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
        WebElement readingInput = driver.findElement(By.cssSelector("#hobbies-checkbox-2"));
        
        System.out.println("Sports checked: " + sportsInput.isSelected());
        System.out.println("Reading checked: " + readingInput.isSelected());
        
        Thread.sleep(1000);
        driver.quit();
    }
}
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Radio Buttons మరియు Checkboxes

### Radio Buttons

ఒక group లో only ఒక్కటే select చేయవచ్చు. Click చేస్తే select అవుతుంది.

```java
// Click to select
driver.findElement(By.id("male")).click();

// State check
boolean isSelected = driver.findElement(By.id("male")).isSelected();
System.out.println("Male selected: " + isSelected);  // true
```

### Checkboxes

Multiple checkboxes select చేయవచ్చు.

```java
WebElement termsCheckbox = driver.findElement(By.id("terms"));

// Select చేయడానికి:
if (!termsCheckbox.isSelected()) {
    termsCheckbox.click();  // Select
}

// Deselect చేయడానికి:
if (termsCheckbox.isSelected()) {
    termsCheckbox.click();  // Deselect
}
```

### Important Rule

Always **state check చేసి** then action చేయండి:

```java
// Wrong: Directly clicking without checking
checkbox.click(); // Already selected అయుంటే unselect అవుతుంది!

// Correct: State check చేసి click చేయండి
if (!checkbox.isSelected()) {
    checkbox.click();
}
```

### Label Click

Modern apps లో input hidden అయి ఉండవచ్చు. Label click చేస్తే associated input select అవుతుంది:

```java
// input hidden అయినా label click చేయవచ్చు
driver.findElement(By.xpath("//label[text()='Male']")).click();
```

</details>

---

## 9. Date and Calendar Handling

### Two Types of Date Inputs

1. **HTML5 Date Input** — `<input type="date" />` — Browser native date picker
2. **Custom Calendar Widget** — Built with JavaScript, custom UI

### HTML5 Date Input

```java
// HTML: <input type="date" id="dob" />

WebElement dateInput = driver.findElement(By.id("dob"));

// Method 1: sendKeys with date format (varies by browser/OS)
// Format: YYYY-MM-DD
dateInput.sendKeys("2024-01-15");

// Method 2: Clear and type
dateInput.clear();
dateInput.sendKeys("01/15/2024");  // MM/DD/YYYY format

// Method 3: Using JavaScript (most reliable)
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].value='2024-01-15'", dateInput);

// Verify
System.out.println("Selected date: " + dateInput.getAttribute("value"));
```

### Custom Calendar Widget

```java
// Example: Bootstrap Datepicker or similar custom calendar
// HTML structure:
// <div class="datepicker">
//   <div class="datepicker-header">
//     <button class="prev-month">◀</button>
//     <span class="current-month">January 2024</span>
//     <button class="next-month">▶</button>
//   </div>
//   <table class="calendar">
//     <td class="day">1</td><td class="day">2</td>...
//   </table>
// </div>

public void selectDate(WebDriver driver, String month, String year, String day) 
        throws InterruptedException {
    
    // Open the datepicker
    driver.findElement(By.id("datepicker")).click();
    Thread.sleep(500);
    
    // Navigate to the correct month and year
    while (true) {
        String currentMonthYear = driver.findElement(
            By.cssSelector(".datepicker-switch")).getText();
        
        if (currentMonthYear.contains(month) && currentMonthYear.contains(year)) {
            break;  // Correct month and year displayed
        }
        
        // Click Next Month button
        driver.findElement(By.cssSelector(".next")).click();
        Thread.sleep(200);
    }
    
    // Click the specific day
    List<WebElement> days = driver.findElements(By.cssSelector(".day:not(.disabled)"));
    for (WebElement dayElement : days) {
        if (dayElement.getText().equals(day)) {
            dayElement.click();
            break;
        }
    }
}

// Usage:
// selectDate(driver, "March", "2024", "15");
```

### Real Project: Book a Hotel Date

```java
public void selectCheckInCheckOut(WebDriver driver, String checkIn, String checkOut) 
        throws InterruptedException {
    
    // Click check-in date field
    driver.findElement(By.cssSelector("#checkIn")).click();
    Thread.sleep(500);
    
    // Find the calendar
    WebElement calendar = driver.findElement(By.cssSelector(".calendar-widget"));
    
    // Select check-in date using data-date attribute
    WebElement checkInDay = calendar.findElement(
        By.cssSelector("[data-date='" + checkIn + "']"));
    checkInDay.click();
    Thread.sleep(500);
    
    // Checkout calendar might auto-open or need separate click
    WebElement checkOutDay = driver.findElement(
        By.cssSelector("[data-date='" + checkOut + "']"));
    checkOutDay.click();
    
    System.out.println("Check-in: " + checkIn + " | Check-out: " + checkOut);
}
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Date మరియు Calendar Handling

### రెండు రకాల Date Inputs

1. **HTML5 Date Input** (`<input type="date">`) — Browser built-in
2. **Custom Calendar** — JavaScript తో build చేసినవి

### HTML5 Date Input

```java
WebElement dateInput = driver.findElement(By.id("dob"));

// Method 1: sendKeys తో
dateInput.sendKeys("2024-01-15");  // YYYY-MM-DD format

// Method 2: JavaScript తో (most reliable)
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].value='2024-01-15'", dateInput);
```

### Custom Calendar Widget

Custom calendars (Bootstrap Datepicker, Material DatePicker, etc.):

1. Calendar trigger click చేయడం (input field)
2. Month/Year navigate చేయడం (← → buttons)
3. Correct day click చేయడం

```java
// Calendar తెరవడం
driver.findElement(By.id("datepicker")).click();

// Current month/year check చేయడం
String currentMonthYear = driver.findElement(By.cssSelector(".datepicker-switch")).getText();

// Correct month వచ్చే వరకు Next click చేయడం
while (!currentMonthYear.contains("March 2024")) {
    driver.findElement(By.cssSelector(".next")).click();
    currentMonthYear = driver.findElement(By.cssSelector(".datepicker-switch")).getText();
}

// Day click చేయడం
driver.findElement(By.xpath("//td[@class='day'][text()='15']")).click();
```

</details>

---

## 10. Web Table Handling

### Why Table Handling is Important

Tables are everywhere in real applications:
- User list pages
- Order history
- Product inventory
- Report data

You need to extract data, verify specific cells, and interact with elements inside tables.

### HTML Table Structure

```html
<table id="userTable">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>John Smith</td>
            <td>john@test.com</td>
            <td><button class="edit-btn">Edit</button> <button class="del-btn">Delete</button></td>
        </tr>
        <tr>
            <td>2</td>
            <td>Jane Doe</td>
            <td>jane@test.com</td>
            <td><button class="edit-btn">Edit</button> <button class="del-btn">Delete</button></td>
        </tr>
    </tbody>
</table>
```

### Complete Table Interaction Guide

#### Simple: Get Row and Column Count

```java
driver.get("https://demoqa.com/webtables");

// Count rows (excluding header)
List<WebElement> rows = driver.findElements(By.cssSelector("#basic-table tbody tr"));
System.out.println("Data rows: " + rows.size());

// Count columns
List<WebElement> headers = driver.findElements(By.cssSelector("#basic-table thead th"));
System.out.println("Columns: " + headers.size());
```

#### Intermediate: Extract All Table Data

```java
public class TableHandler {
    
    public static List<Map<String, String>> extractTableData(WebDriver driver, String tableId) {
        
        List<Map<String, String>> tableData = new ArrayList<>();
        
        WebElement table = driver.findElement(By.id(tableId));
        
        // Get headers
        List<WebElement> headerCells = table.findElements(By.cssSelector("thead th"));
        List<String> headers = new ArrayList<>();
        for (WebElement header : headerCells) {
            headers.add(header.getText().trim());
        }
        
        // Get data rows
        List<WebElement> dataRows = table.findElements(By.cssSelector("tbody tr"));
        
        for (WebElement row : dataRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            
            Map<String, String> rowData = new HashMap<>();
            for (int i = 0; i < cells.size() && i < headers.size(); i++) {
                rowData.put(headers.get(i), cells.get(i).getText().trim());
            }
            tableData.add(rowData);
        }
        
        return tableData;
    }
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
        
        List<Map<String, String>> data = extractTableData(driver, "table1");
        
        System.out.println("Table Data:");
        for (Map<String, String> row : data) {
            System.out.println(row);
        }
        
        driver.quit();
    }
}
```

#### Advanced: Search and Interact with Table Row

```java
public class AdvancedTableInteraction {
    
    // Find a specific row by column value and click a button in that row
    public static void clickButtonForRow(WebDriver driver, String targetName, 
                                          String buttonClass) {
        
        // XPath approach: Find row where Name cell contains targetName
        String rowXPath = String.format(
            "//table[@id='userTable']//tr[td[text()='%s']]", targetName);
        
        WebElement targetRow;
        try {
            targetRow = driver.findElement(By.xpath(rowXPath));
        } catch (Exception e) {
            System.out.println("Row with name '" + targetName + "' not found!");
            return;
        }
        
        // Click the button within that row
        try {
            WebElement button = targetRow.findElement(By.cssSelector("." + buttonClass));
            System.out.println("Clicking " + buttonClass + " for: " + targetName);
            button.click();
        } catch (Exception e) {
            System.out.println("Button '" + buttonClass + "' not found in row!");
        }
    }
    
    // Find a specific cell value by row name and column name
    public static String getCellValue(WebDriver driver, String tableId,
                                       String rowIdentifier, int columnIndex) {
        
        String xpath = String.format(
            "//table[@id='%s']//tr[td[contains(text(),'%s')]]/td[%d]",
            tableId, rowIdentifier, columnIndex);
        
        try {
            return driver.findElement(By.xpath(xpath)).getText().trim();
        } catch (Exception e) {
            return "Cell not found";
        }
    }
    
    // Verify a table column is sorted
    public static boolean isColumnSorted(WebDriver driver, int columnIndex, 
                                          boolean ascending) {
        
        List<WebElement> cells = driver.findElements(
            By.cssSelector("table tbody tr td:nth-child(" + columnIndex + ")"));
        
        List<String> values = new ArrayList<>();
        for (WebElement cell : cells) {
            values.add(cell.getText().trim());
        }
        
        List<String> sorted = new ArrayList<>(values);
        if (ascending) {
            sorted.sort(String::compareTo);
        } else {
            sorted.sort((a, b) -> b.compareTo(a));
        }
        
        return values.equals(sorted);
    }
    
    // Pagination: navigate through pages and collect data
    public static void handlePagination(WebDriver driver) throws InterruptedException {
        
        List<String> allData = new ArrayList<>();
        int pageNum = 1;
        
        while (true) {
            System.out.println("Processing page: " + pageNum);
            
            // Extract current page data
            List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
            for (WebElement row : rows) {
                allData.add(row.getText());
            }
            
            // Check if "Next" button exists and is enabled
            List<WebElement> nextButton = driver.findElements(
                By.cssSelector("button.next-page:not(:disabled)"));
            
            if (nextButton.isEmpty()) {
                System.out.println("Last page reached at page: " + pageNum);
                break;
            }
            
            nextButton.get(0).click();
            Thread.sleep(1000);
            pageNum++;
        }
        
        System.out.println("Total rows collected: " + allData.size());
    }
}
```

### Real-World Table Scenarios

```java
// Scenario 1: Verify search results in a table
public void verifySearchResults(WebDriver driver, String searchTerm) {
    
    driver.get("https://demoqa.com/webtables");
    
    // Search
    driver.findElement(By.id("searchBox")).sendKeys(searchTerm);
    
    // Wait briefly
    try { Thread.sleep(500); } catch (InterruptedException e) {}
    
    // Get result rows
    List<WebElement> rows = driver.findElements(
        By.cssSelector(".rt-tr-group:not(.-padRow)"));
    
    System.out.println("Search results for '" + searchTerm + "': " + rows.size());
    
    // Verify each result contains the search term
    for (WebElement row : rows) {
        String rowText = row.getText();
        if (!rowText.isEmpty()) {
            assert rowText.toLowerCase().contains(searchTerm.toLowerCase()) :
                "Row doesn't contain search term: " + rowText;
        }
    }
    System.out.println("All results verified!");
}
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

## Web Table Handling

### Table Structure అర్థం చేసుకోవడం

```html
<table>
  <thead>        ← Header row
    <tr>
      <th>Name</th><th>Email</th>  ← Header cells
    </tr>
  </thead>
  <tbody>        ← Data rows
    <tr>
      <td>John</td><td>john@test.com</td>  ← Data cells
    </tr>
  </tbody>
</table>
```

### Basic Operations

```java
// All data rows count
List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
System.out.println("Total rows: " + rows.size());

// Header cells
List<WebElement> headers = driver.findElements(By.cssSelector("table thead th"));
```

### Row Data Extract చేయడం

```java
for (WebElement row : rows) {
    List<WebElement> cells = row.findElements(By.tagName("td"));
    for (WebElement cell : cells) {
        System.out.print(cell.getText() + " | ");
    }
    System.out.println();
}
```

### Specific Row లో Action చేయడం

```java
// "John" అనే name ఉన్న row లో Delete button click చేయడం
String xpath = "//td[text()='John']/following-sibling::td//button[text()='Delete']";
driver.findElement(By.xpath(xpath)).click();
```

### nth Cell తెచ్చుకోవడం

```java
// 3rd row, 2nd column
driver.findElement(By.cssSelector("table tbody tr:nth-child(3) td:nth-child(2)")).getText();

// XPath తో:
driver.findElement(By.xpath("//table//tr[3]/td[2]")).getText();
```

</details>

---

## 11. Big Practical Projects

### Project 1: Complete E-commerce Product Search Automation

```java
// File: src/test/java/projects/EcommerceSearchTest.java
// Target: https://www.amazon.com or https://demo.opencart.com

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class EcommerceSearchTest {
    
    private WebDriver driver;
    
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Set timeouts
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    
    public void searchProduct(String keyword) throws InterruptedException {
        driver.get("https://demo.opencart.com");
        
        // Find search input
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(keyword);
        
        // Click search button
        driver.findElement(By.cssSelector("button.btn-default[type='button']")).click();
        
        Thread.sleep(2000);
        
        System.out.println("Search URL: " + driver.getCurrentUrl());
        System.out.println("Page title: " + driver.getTitle());
    }
    
    public List<Map<String, String>> extractSearchResults() {
        List<Map<String, String>> results = new ArrayList<>();
        
        // Get all product thumbnails
        List<WebElement> products = driver.findElements(
            By.cssSelector(".product-thumb"));
        
        System.out.println("Products found: " + products.size());
        
        for (WebElement product : products) {
            Map<String, String> productData = new HashMap<>();
            
            try {
                productData.put("name", 
                    product.findElement(By.cssSelector(".caption h4 a")).getText());
            } catch (Exception e) {
                productData.put("name", "N/A");
            }
            
            try {
                productData.put("price", 
                    product.findElement(By.cssSelector(".price")).getText());
            } catch (Exception e) {
                productData.put("price", "N/A");
            }
            
            results.add(productData);
        }
        
        return results;
    }
    
    public void tearDown() {
        if (driver != null) driver.quit();
    }
    
    public static void main(String[] args) throws InterruptedException {
        EcommerceSearchTest test = new EcommerceSearchTest();
        
        try {
            test.setup();
            test.searchProduct("iPhone");
            
            List<Map<String, String>> results = test.extractSearchResults();
            
            System.out.println("\n=== SEARCH RESULTS ===");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i+1) + ". " + results.get(i).get("name") + 
                                   " - " + results.get(i).get("price"));
            }
            
        } finally {
            test.tearDown();
        }
    }
}
```

---

### Project 2: Complete Form Automation with Validation

```java
// File: src/test/java/projects/RegistrationFormAutomation.java
// Target: https://demoqa.com/automation-practice-form

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class RegistrationFormAutomation {
    
    private WebDriver driver;
    
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    public Map<String, Boolean> fillAndVerifyForm(Map<String, String> formData) 
            throws InterruptedException {
        
        Map<String, Boolean> results = new HashMap<>();
        
        driver.get("https://demoqa.com/automation-practice-form");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Fill First Name
        try {
            driver.findElement(By.id("firstName")).sendKeys(formData.get("firstName"));
            results.put("firstName", true);
        } catch (Exception e) {
            results.put("firstName", false);
        }
        
        // Fill Last Name
        try {
            driver.findElement(By.id("lastName")).sendKeys(formData.get("lastName"));
            results.put("lastName", true);
        } catch (Exception e) {
            results.put("lastName", false);
        }
        
        // Fill Email
        try {
            driver.findElement(By.id("userEmail")).sendKeys(formData.get("email"));
            results.put("email", true);
        } catch (Exception e) {
            results.put("email", false);
        }
        
        // Select Gender
        try {
            String gender = formData.getOrDefault("gender", "Male");
            driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();
            results.put("gender", true);
        } catch (Exception e) {
            results.put("gender", false);
        }
        
        // Fill Mobile
        try {
            driver.findElement(By.id("userNumber")).sendKeys(formData.get("mobile"));
            results.put("mobile", true);
        } catch (Exception e) {
            results.put("mobile", false);
        }
        
        // Scroll down
        js.executeScript("window.scrollTo(0, 400)");
        Thread.sleep(500);
        
        // Select Hobby
        try {
            String hobby = formData.getOrDefault("hobby", "Sports");
            driver.findElement(By.xpath("//label[text()='" + hobby + "']")).click();
            results.put("hobby", true);
        } catch (Exception e) {
            results.put("hobby", false);
        }
        
        // Submit
        js.executeScript("window.scrollTo(0, 800)");
        Thread.sleep(500);
        driver.findElement(By.id("submit")).click();
        
        Thread.sleep(1000);
        
        // Verify submission
        try {
            WebElement modal = driver.findElement(By.id("example-modal-sizes-title-lg"));
            results.put("submitted", modal.isDisplayed());
        } catch (Exception e) {
            results.put("submitted", false);
        }
        
        return results;
    }
    
    public void runTests() throws InterruptedException {
        
        setup();
        
        // Test data
        Map<String, String> testData = new HashMap<>();
        testData.put("firstName", "Venkata");
        testData.put("lastName", "Bharath");
        testData.put("email", "vb@test.com");
        testData.put("gender", "Male");
        testData.put("mobile", "9876543210");
        testData.put("hobby", "Reading");
        
        Map<String, Boolean> results = fillAndVerifyForm(testData);
        
        System.out.println("\n=== FORM AUTOMATION RESULTS ===");
        int passed = 0, failed = 0;
        
        for (Map.Entry<String, Boolean> entry : results.entrySet()) {
            String status = entry.getValue() ? "✅ PASS" : "❌ FAIL";
            System.out.println(entry.getKey() + ": " + status);
            if (entry.getValue()) passed++; else failed++;
        }
        
        System.out.println("\nPASS: " + passed + " | FAIL: " + failed);
        
        driver.quit();
    }
    
    public static void main(String[] args) throws InterruptedException {
        new RegistrationFormAutomation().runTests();
    }
}
```

---

### Project 3: Web Table Data Validator

```java
// File: src/test/java/projects/TableDataValidator.java
// Tests table at: https://the-internet.herokuapp.com/tables

public class TableDataValidator {
    
    private WebDriver driver;
    
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
    }
    
    // Get all headers of a table
    public List<String> getHeaders(String tableId) {
        List<String> headers = new ArrayList<>();
        List<WebElement> headerCells = driver.findElements(
            By.cssSelector("#" + tableId + " th"));
        for (WebElement th : headerCells) {
            headers.add(th.getText().trim());
        }
        return headers;
    }
    
    // Get specific cell value
    public String getCellValue(String tableId, int row, int col) {
        return driver.findElement(
            By.cssSelector("#" + tableId + " tr:nth-child(" + row + ") td:nth-child(" + col + ")")
        ).getText().trim();
    }
    
    // Sort table by clicking header and verify
    public void sortAndVerify(String tableId, String headerText) throws InterruptedException {
        
        // Click the header to sort
        driver.findElement(By.xpath(
            "//table[@id='" + tableId + "']//th[a[text()='" + headerText + "']]//a"
        )).click();
        
        Thread.sleep(500);
        
        // Get first column values after sort
        List<WebElement> firstColCells = driver.findElements(
            By.cssSelector("#" + tableId + " tbody td:first-child"));
        
        List<String> values = new ArrayList<>();
        for (WebElement cell : firstColCells) {
            values.add(cell.getText().trim());
        }
        
        // Check if sorted
        List<String> sortedValues = new ArrayList<>(values);
        Collections.sort(sortedValues);
        
        if (values.equals(sortedValues)) {
            System.out.println("✅ Table sorted correctly by: " + headerText);
        } else {
            System.out.println("❌ Table NOT sorted by: " + headerText);
            System.out.println("Expected: " + sortedValues);
            System.out.println("Actual: " + values);
        }
    }
    
    public void runAllValidations() throws InterruptedException {
        setup();
        
        System.out.println("=== TABLE VALIDATION REPORT ===\n");
        
        // Test 1: Get headers
        List<String> headers = getHeaders("table1");
        System.out.println("Table 1 Headers: " + headers);
        
        // Test 2: Get specific cell
        String cell = getCellValue("table1", 1, 1);
        System.out.println("First data cell: " + cell);
        
        // Test 3: Sort by Last Name
        System.out.println("\nSorting by Last Name...");
        sortAndVerify("table1", "Last Name");
        
        Thread.sleep(1000);
        
        // Test 4: Sort by First Name
        System.out.println("\nSorting by First Name...");
        sortAndVerify("table1", "First Name");
        
        driver.quit();
    }
    
    public static void main(String[] args) throws InterruptedException {
        new TableDataValidator().runAllValidations();
    }
}
```

---

### Project 4: Dropdown Comprehensive Tester

```java
// File: src/test/java/projects/DropdownComprehensiveTester.java
// Target: https://the-internet.herokuapp.com/dropdown

public class DropdownComprehensiveTester {
    
    private WebDriver driver;
    
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    public void testStandardDropdown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        
        System.out.println("=== STANDARD DROPDOWN TEST ===");
        
        // 1. Verify initial state
        String initialOption = select.getFirstSelectedOption().getText();
        System.out.println("Initial selection: '" + initialOption + "'");
        
        // 2. List all options
        List<WebElement> options = select.getOptions();
        System.out.println("Total options: " + options.size());
        for (WebElement opt : options) {
            System.out.println("  Option: '" + opt.getText() + "' | Value: '" + 
                               opt.getAttribute("value") + "'");
        }
        
        // 3. Select each option and verify
        String[] expectedOptions = {"", "Option 1", "Option 2"};
        for (String expected : expectedOptions) {
            if (expected.isEmpty()) continue;
            
            select.selectByVisibleText(expected);
            String actual = select.getFirstSelectedOption().getText();
            
            String status = actual.equals(expected) ? "✅ PASS" : "❌ FAIL";
            System.out.println("Select '" + expected + "': " + status + " | Actual: '" + actual + "'");
            Thread.sleep(500);
        }
        
        // 4. Select by index
        select.selectByIndex(1);
        System.out.println("Selected by index 1: " + select.getFirstSelectedOption().getText());
        
        // 5. Select by value
        select.selectByValue("2");
        System.out.println("Selected by value '2': " + select.getFirstSelectedOption().getText());
    }
    
    public void testMultiSelectDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        
        // Note: This particular page doesn't have multi-select, so we demonstrate concept
        System.out.println("\n=== MULTI-SELECT DROPDOWN CONCEPT ===");
        System.out.println("Multi-select dropdowns allow selecting multiple options");
        System.out.println("Use: select.isMultiple() to check if dropdown is multi-select");
        
        WebElement dd = driver.findElement(By.id("dropdown"));
        Select select = new Select(dd);
        System.out.println("Is multi-select: " + select.isMultiple());  // false for this page
    }
    
    public void tearDown() {
        if (driver != null) driver.quit();
    }
    
    public static void main(String[] args) throws InterruptedException {
        DropdownComprehensiveTester test = new DropdownComprehensiveTester();
        try {
            test.setup();
            test.testStandardDropdown();
            test.testMultiSelectDropdown();
        } finally {
            test.tearDown();
        }
    }
}
```

---

### Project 5: Complete Locator Strategy Demonstrator

```java
// File: src/test/java/projects/LocatorStrategyDemo.java
// Demonstrates ALL locator types with real usage

public class LocatorStrategyDemo {
    
    private WebDriver driver;
    
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    public void demonstrateAllLocators() throws InterruptedException {
        
        driver.get("https://demoqa.com/text-box");
        
        System.out.println("=== LOCATOR STRATEGY DEMONSTRATION ===\n");
        
        // 1. By.id
        System.out.println("1. By.id:");
        WebElement byId = driver.findElement(By.id("userName"));
        System.out.println("   Found element: " + byId.getTagName() + " with placeholder: " + 
                           byId.getAttribute("placeholder"));
        
        // 2. By.name (demoqa uses id, so let's show concept)
        System.out.println("\n2. By.name — works great for Google search:");
        driver.get("https://www.google.com");
        WebElement byName = driver.findElement(By.name("q"));
        System.out.println("   Found Google search box by name='q': " + byName.getTagName());
        
        // 3. By.className
        driver.get("https://demoqa.com/text-box");
        System.out.println("\n3. By.className:");
        WebElement byClass = driver.findElement(By.className("main-header"));
        System.out.println("   Found element with class: " + byClass.getText());
        
        // 4. By.tagName
        System.out.println("\n4. By.tagName:");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println("   Found " + inputs.size() + " input elements");
        
        // 5. By.linkText
        driver.get("https://the-internet.herokuapp.com");
        System.out.println("\n5. By.linkText:");
        WebElement byLinkText = driver.findElement(By.linkText("Form Authentication"));
        System.out.println("   Found link: " + byLinkText.getText());
        byLinkText.click();
        Thread.sleep(1000);
        System.out.println("   Navigated to: " + driver.getTitle());
        
        // 6. By.partialLinkText
        driver.navigate().back();
        Thread.sleep(500);
        System.out.println("\n6. By.partialLinkText:");
        WebElement byPartialLinkText = driver.findElement(By.partialLinkText("Dropdown"));
        System.out.println("   Found link by partial text: " + byPartialLinkText.getText());
        
        // 7. By.cssSelector
        System.out.println("\n7. By.cssSelector examples:");
        WebElement byCSS1 = driver.findElement(By.cssSelector("a[href='/dropdown']"));
        System.out.println("   By attribute: " + byCSS1.getText());
        
        WebElement byCSS2 = driver.findElement(By.cssSelector("li:first-child > a"));
        System.out.println("   By first-child: " + byCSS2.getText());
        
        List<WebElement> byCSSMultiple = driver.findElements(By.cssSelector("li > a"));
        System.out.println("   All links count: " + byCSSMultiple.size());
        
        // 8. By.xpath
        System.out.println("\n8. By.xpath examples:");
        WebElement byXPath1 = driver.findElement(By.xpath("//a[text()='Dropdown']"));
        System.out.println("   By text: " + byXPath1.getText());
        
        WebElement byXPath2 = driver.findElement(By.xpath("//a[contains(text(),'Auth')]"));
        System.out.println("   By partial text: " + byXPath2.getText());
        
        System.out.println("\n=== DEMONSTRATION COMPLETE ===");
    }
    
    public void tearDown() {
        if (driver != null) driver.quit();
    }
    
    public static void main(String[] args) throws InterruptedException {
        LocatorStrategyDemo demo = new LocatorStrategyDemo();
        try {
            demo.setup();
            demo.demonstrateAllLocators();
        } finally {
            demo.tearDown();
        }
    }
}
```

---

## Summary: What You Have Mastered in Part 2

```
PART 2 KNOWLEDGE CHECKLIST:
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

✅ WebDriver Interface — understanding hierarchy and polymorphism
✅ All WebDriver Methods:
   ✅ Navigation: get(), navigate().back/forward/refresh()
   ✅ Information: getTitle(), getCurrentUrl(), getPageSource()
   ✅ Window: manage().window().maximize/setSize()
   ✅ Timeouts: pageLoadTimeout(), implicitlyWait()
   ✅ Cookies: add/get/delete cookies
   ✅ Switching: switchTo().frame/window/alert()

✅ ALL LOCATORS — complete mastery:
   ✅ By.id() — fastest, most reliable
   ✅ By.name() — forms and inputs
   ✅ By.className() — CSS class based
   ✅ By.tagName() — HTML tag based
   ✅ By.linkText() — exact link text
   ✅ By.partialLinkText() — partial link text
   ✅ By.cssSelector() — complete deep dive
      ✅ ID, class, tag, attribute selectors
      ✅ Attribute matching (^=, $=, *=)
      ✅ Parent-child, sibling relationships
      ✅ Pseudo-classes (:nth-child, :not, :checked)
   ✅ By.xpath() — complete deep dive
      ✅ Absolute vs Relative
      ✅ Attribute, text, contains(), starts-with()
      ✅ ALL XPath axes (parent, ancestor, sibling, etc.)
      ✅ XPath functions (text(), normalize-space(), last())
      ✅ Dynamic XPath patterns
   ✅ Locator decision framework

✅ WebElement Operations:
   ✅ Actions: click, sendKeys, clear, submit
   ✅ Information: getText, getAttribute, getCssValue, getTagName
   ✅ State: isDisplayed, isEnabled, isSelected
   ✅ Location and Size

✅ Multiple Elements with findElements()
✅ Browser Operations — navigation, timeouts, windows
✅ Dropdown Handling — Select class + custom dropdowns
✅ Radio Buttons and Checkboxes
✅ Date/Calendar Handling
✅ Web Table Handling — extraction, search, pagination
✅ 5 Practical Projects
```

## Ready for Part 3?

In **Part 3**, you will master:
- **Waits** — the #1 reason tests fail in real projects
- **Alerts, Frames, Windows** — tricky scenarios every tester faces
- **JavaScriptExecutor** — do things WebDriver cannot
- **Actions class** — hover, drag-drop, right-click
- **Screenshots** — proof of failures
- **All major exceptions** — and how to fix them

**Part 3 is where you go from a beginner to a true Selenium professional.**

---

*Part 02 — Selenium Core WebDriver | Part of the Complete Telugu Selenium Learning Series*
*Previous: Part-01-Foundation.md | Next: Part-03-Advanced-Selenium-Techniques.md*
