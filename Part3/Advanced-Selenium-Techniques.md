# Part 3: Advanced Selenium Techniques

> **This file covers the topics that separate beginners from professionals.** Every real automation project uses waits, frames, windows, JavaScript, and exception handling. Master these and you will be ready for any real job.

---

## Table of Contents

1. [Wait Mechanisms](#wait-mechanisms)
2. [Alerts](#alerts)
3. [Frames and iFrames](#frames-and-iframes)
4. [Windows and Tabs](#windows-and-tabs)
5. [JavaScriptExecutor](#javascriptexecutor)
6. [Actions Class](#actions-class)
7. [Screenshots](#screenshots)
8. [Cookies Handling](#cookies-handling)
9. [Shadow DOM](#shadow-dom)
10. [Dynamic Content and AJAX](#dynamic-content-and-ajax)
11. [Exception Handling in Selenium](#exception-handling-in-selenium)
12. [File Upload and Download](#file-upload-and-download)
13. [Hidden Elements and Popup Windows](#hidden-elements-and-popup-windows)
14. [Practical Projects](#practical-projects)

---

## Wait Mechanisms

### Why Waits Exist

Modern websites load content dynamically. When you click a button, the result may appear after 1 second, or 5 seconds, depending on the server. Selenium is fast — it runs faster than a human eye. So it tries to find elements **before the page is ready**.

**Without waits:** `NoSuchElementException` — element not found  
**With waits:** Selenium waits patiently until the element appears

Think of it like this: You press the elevator button. You don't run away after 0.1 seconds. You **wait** until the door opens.

---

### Thread.sleep — Why NOT to Use It

```java
// BAD practice — never do this in real projects
Thread.sleep(3000); // sleeps for 3 seconds, no matter what
driver.findElement(By.id("result")).click();
```

**Problems with Thread.sleep:**
- If page loads in 1 second, you still wait 3 seconds → **slow**
- If page loads in 5 seconds, 3 seconds is not enough → **test fails**
- It wastes time on every single test run
- It makes tests unpredictable and brittle

**Real scenario:** You have 500 tests, each with a 3-second sleep. That is 1,500 seconds = 25 minutes of wasted waiting. With proper waits, the same suite might finish in 8 minutes.

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Thread.sleep అంటే ఏమిటి మరియు ఎందుకు వాడకూడదు?**

Thread.sleep అనేది Java లో ఒక command, ఇది program ని నిర్దిష్ట సమయం (milliseconds లో) pause చేస్తుంది.

ఉదాహరణకు `Thread.sleep(3000)` అంటే — "3 seconds ఆగు, ఏం జరిగినా సరే."

**సమస్య ఏమిటంటే:**
- Page 1 second లో load అయినా, మనం 3 seconds వేచి ఉంటాం — **time waste**
- Page 5 seconds తీసుకుంటే, 3 seconds చాలవు — **test fail**
- 500 tests ఉంటే, ప్రతి దానిలో 3 seconds sleep అంటే = 25 minutes waste

ఇది elevator కోసం 10 minutes wait చేయడం లాంటిది, elevator 2 minutes లోనే వస్తుందని తెలిసినా. స్మార్ట్ కాదు కదా?

**పరిష్కారం:** Selenium లో built-in wait mechanisms వాడాలి — Implicit Wait, Explicit Wait, Fluent Wait.

</details>

---

### Implicit Wait

Implicit wait tells Selenium: "If you don't find an element immediately, wait up to X seconds before giving up."

It applies to **every** `findElement` call in the entire test session. You set it once.

```java
// ===== SIMPLE: Set implicit wait =====
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ImplicitWaitSimple {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait — applies to ALL findElement calls
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://example.com");
        
        // Selenium will wait up to 10 seconds for this element to appear
        driver.findElement(By.id("slow-loading-button")).click();
        
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Implicit wait with page that loads slowly =====
public class ImplicitWaitIntermediate {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/dynamic-properties");
        
        // This button becomes visible after 5 seconds
        // Implicit wait handles it automatically
        WebElement visibleAfterFiveSeconds = driver.findElement(By.id("visibleAfter"));
        System.out.println("Button text: " + visibleAfterFiveSeconds.getText());
        
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Understanding implicit wait polling behavior =====
public class ImplicitWaitAdvanced {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        // Implicit wait polls every 500ms by default
        // If element not found after 10 seconds → throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://demoqa.com/dynamic-properties");
        
        long startTime = System.currentTimeMillis();
        
        try {
            WebElement element = driver.findElement(By.id("enableAfter"));
            long endTime = System.currentTimeMillis();
            System.out.println("Element found after: " + (endTime - startTime) + "ms");
            System.out.println("Is enabled: " + element.isEnabled());
        } catch (NoSuchElementException e) {
            System.out.println("Element not found within 10 seconds");
        }
        
        driver.quit();
    }
}
```

**How Implicit Wait Works (Internally):**
```
findElement("loginButton") called
    ↓
Element found? YES → return immediately
Element found? NO → wait 500ms → try again
...repeat...
Element found? YES → return
Total time exceeded? → throw NoSuchElementException
```

**Limitations of Implicit Wait:**
- Cannot wait for element to be **clickable** (only for presence)
- Cannot wait for **custom conditions**
- Applies globally — sometimes you want different waits for different elements
- Mixes badly with Explicit Wait (causes unpredictable behavior)

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Implicit Wait అంటే ఏమిటి?**

Implicit wait అనేది ఒక global setting. మీరు ఒకసారి set చేస్తే, అది మీ entire test లో అన్ని `findElement` calls కి apply అవుతుంది.

**ఎలా పని చేస్తుంది:**
- Selenium element కోసం చూస్తుంది
- వెంటనే దొరికితే — వెంటనే return చేస్తుంది
- దొరకకపోతే — 500ms ఆగుతుంది, మళ్ళీ చూస్తుంది
- ఇది మీరు set చేసిన maximum time వరకు చేస్తుంది
- అప్పటికీ దొరకకపోతే — `NoSuchElementException` throw చేస్తుంది

**Analogy:** మీరు ఒక friend కోసం railway station లో wait చేస్తున్నారు. "10 minutes వరకు wait చేస్తాను, రాకపోతే వెళ్ళిపోతాను" అని decide చేశారు. ప్రతి minute చూస్తారు. వస్తే happy, రాకపోతే వెళ్ళిపోతారు.

**Limitations:**
- Element present అయినా clickable కాకపోవచ్చు — implicit wait దాన్ని handle చేయదు
- అన్ని elements కి same time apply అవుతుంది — flexible కాదు
- Explicit wait తో కలిపితే problems వస్తాయి

</details>

---

### Explicit Wait — The Professional Choice

Explicit wait waits for a **specific condition** on a **specific element**. This is the most powerful and recommended wait strategy.

```java
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

// ===== SIMPLE: Wait for element to be visible =====
public class ExplicitWaitSimple {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        
        // Create a wait object — maximum 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait until this specific element is visible
        WebElement button = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter"))
        );
        
        System.out.println("Button appeared: " + button.getText());
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Multiple conditions with explicit wait =====
public class ExplicitWaitIntermediate {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        driver.get("https://demoqa.com/dynamic-properties");
        
        // Wait for element to be CLICKABLE (visible + enabled)
        WebElement colorButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("colorChange"))
        );
        colorButton.click();
        
        // Wait for URL to change
        wait.until(ExpectedConditions.urlContains("demoqa"));
        
        // Wait for text to be present in element
        wait.until(
            ExpectedConditions.textToBePresentInElementLocated(
                By.id("enableAfter"), "Button Has Been Enabled"
            )
        );
        
        // Wait for element to become invisible
        wait.until(
            ExpectedConditions.invisibilityOfElementLocated(By.id("loading-spinner"))
        );
        
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Custom ExpectedCondition =====
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ExplicitWaitAdvanced {
    
    // Custom condition: wait until element has specific CSS class
    public static ExpectedCondition<Boolean> elementHasClass(
            final WebElement element, final String cssClass) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return element.getAttribute("class").contains(cssClass);
            }
            
            @Override
            public String toString() {
                return "element to have class: " + cssClass;
            }
        };
    }
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://example.com/button-page");
        WebElement btn = driver.findElement(By.id("submit-btn"));
        
        // Use custom condition
        wait.until(elementHasClass(btn, "active"));
        
        System.out.println("Button is now active!");
        btn.click();
        
        driver.quit();
    }
}
```

**All Common ExpectedConditions:**

| Condition | Use When |
|-----------|----------|
| `visibilityOfElementLocated(By)` | Element must be visible on page |
| `elementToBeClickable(By)` | Element must be visible AND enabled |
| `presenceOfElementLocated(By)` | Element must exist in DOM (may not be visible) |
| `invisibilityOfElementLocated(By)` | Waiting for loader/spinner to disappear |
| `textToBePresentInElementLocated(By, text)` | Waiting for text to appear in element |
| `titleIs(title)` | Waiting for page title to match |
| `urlContains(fragment)` | Waiting for URL change after click |
| `alertIsPresent()` | Waiting for alert to appear |
| `frameToBeAvailableAndSwitchToIt(By)` | Waiting for frame to load |
| `numberOfElementsToBe(By, count)` | Waiting for specific number of results |
| `stalenessOf(element)` | Waiting for element to become stale (page refresh) |

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Explicit Wait అంటే ఏమిటి?**

Explicit wait అనేది specific element కోసం, specific condition కోసం wait చేయడం. ఇది professional testers use చేసే method.

**Implicit wait vs Explicit wait:**
- Implicit: "అన్ని elements కోసం 10 seconds wait చేయి"
- Explicit: "ఈ specific button clickable అయ్యే వరకు wait చేయి"

**ఎందుకు Explicit wait better:**
- మీకు different elements కి different conditions specify చేయవచ్చు
- "visible అవ్వు", "clickable అవ్వు", "disappear అవ్వు" — ఇలా specific conditions
- Faster — condition meet అయిన వెంటనే move on చేస్తుంది

**Real example:**
- Login page లో submit button click చేసిన తర్వాత, dashboard appear అవ్వడానికి wait చేయాలి
- `wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")))` — ఇది dashboard visible అయ్యే వరకు wait చేస్తుంది

**Custom Conditions:**
మీకు built-in conditions చాలకపోతే, మీరే custom condition రాయవచ్చు. ఉదాహరణకు: "element లో specific CSS class వచ్చే వరకు wait చేయి."

</details>

---

### Fluent Wait — The Most Flexible Wait

Fluent Wait gives you full control: how long to wait, how often to check, and which exceptions to ignore.

```java
import org.openqa.selenium.support.ui.FluentWait;
import java.util.function.Function;

// ===== SIMPLE: Basic Fluent Wait =====
public class FluentWaitSimple {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(20))      // max wait: 20 seconds
            .pollingEvery(Duration.ofSeconds(2))       // check every 2 seconds
            .ignoring(NoSuchElementException.class);   // ignore this exception while polling
        
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("visibleAfter"));
            }
        });
        
        System.out.println("Found: " + element.getText());
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Fluent Wait with lambda (cleaner code) =====
public class FluentWaitIntermediate {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(500))   // check every 500ms
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class); // ignore multiple exceptions
        
        // Lambda version — cleaner
        WebElement element = wait.until(driver2 -> 
            driver2.findElement(By.xpath("//button[@id='enableAfter']"))
        );
        
        System.out.println("Button enabled: " + element.isEnabled());
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Fluent Wait with custom condition returning boolean =====
public class FluentWaitAdvanced {
    
    public static boolean waitForElementToHaveText(WebDriver driver, By locator, String expectedText) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofMillis(300))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class)
            .withMessage("Element did not contain expected text: " + expectedText);
        
        return wait.until(driver2 -> {
            try {
                WebElement el = driver2.findElement(locator);
                String actualText = el.getText().trim();
                System.out.println("Current text: '" + actualText + "'");
                return actualText.contains(expectedText);
            } catch (Exception e) {
                return false;
            }
        });
    }
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/async-page");
        
        boolean textFound = waitForElementToHaveText(
            driver, By.id("status-message"), "Operation Complete"
        );
        
        System.out.println("Text appeared: " + textFound);
        driver.quit();
    }
}
```

**Fluent Wait vs Explicit Wait:**

| Feature | Explicit Wait | Fluent Wait |
|---------|---------------|-------------|
| Polling interval | Fixed (500ms) | Configurable |
| Exception ignoring | Limited | Full control |
| Custom message | Basic | Full control |
| Code simplicity | Simpler | More verbose |
| Flexibility | Medium | High |

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Fluent Wait అంటే ఏమిటి?**

Fluent Wait అనేది అన్నింటికంటే flexible wait. దీన్ని మీరు exactly మీకు కావలసినట్టు configure చేయవచ్చు.

**3 important settings:**
1. **withTimeout** — maximum time wait చేయడానికి (e.g., 20 seconds)
2. **pollingEvery** — ఎంత తరచుగా check చేయాలి (e.g., every 500ms)
3. **ignoring** — waiting చేసేటప్పుడు ఏ exceptions ignore చేయాలి

**Analogy:** మీరు ఒక friend కోసం wait చేస్తున్నారు. "20 minutes wait చేస్తాను, ప్రతి 2 minutes కి phone చేస్తాను, busy signal వచ్చినా ignore చేస్తాను" — ఇదే Fluent Wait logic.

**ఎప్పుడు వాడాలి:**
- Page constantly refreshing అవుతున్నప్పుడు (StaleElementReferenceException వస్తుంటే)
- Different polling speed కావాలంటే
- Complex custom conditions కి

</details>

---

### Wait Decision Framework

```
Is timing issue causing test failure?
│
├── YES
│   ├── Do you need to wait for element to simply EXIST?
│   │   └── Use: Implicit Wait (set once, global)
│   │
│   ├── Do you need a SPECIFIC CONDITION (visible, clickable, etc.)?
│   │   └── Use: Explicit Wait (WebDriverWait + ExpectedConditions)
│   │
│   ├── Do you need CUSTOM POLLING or to IGNORE SPECIFIC EXCEPTIONS?
│   │   └── Use: Fluent Wait
│   │
│   └── Are you waiting for the entire PAGE to load?
│       └── Use: Page Load Timeout
│
└── NO → No wait needed
```

**Page Load Timeout:**
```java
// Selenium will wait maximum 30 seconds for any page to fully load
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

// Script timeout — for JavaScript execution
driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
```

**Common Wait Mistakes:**

| Mistake | Problem | Fix |
|---------|---------|-----|
| Using Thread.sleep everywhere | Slow, unreliable | Use Explicit Wait |
| Mixing Implicit + Explicit wait | Unpredictable behavior | Use one type only |
| Setting implicit wait too high | Slow test failure detection | Keep it 5-10 seconds max |
| Not handling StaleElementException in waits | Intermittent failures | Use FluentWait with ignoring() |
| Using presenceOfElement when you need clickable | Element exists but test clicks before it's ready | Use elementToBeClickable |

---

## Alerts

### What Are Alerts?

Alerts are pop-up boxes that appear in the browser. They are **browser-level**, not webpage elements. You cannot find them with `findElement`.

**Three types:**
1. **Simple Alert** — shows a message, has only OK button
2. **Confirmation Alert** — has OK and Cancel buttons  
3. **Prompt Alert** — has a text input field + OK/Cancel

```java
// ===== SIMPLE: Accept a basic alert =====
public class AlertSimple {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        
        // Click button that triggers alert
        driver.findElement(By.id("alertButton")).click();
        
        // Switch to alert
        Alert alert = driver.switchTo().alert();
        
        // Read alert message
        System.out.println("Alert text: " + alert.getText());
        
        // Accept (click OK)
        alert.accept();
        
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Handle all alert types =====
public class AlertIntermediate {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/alerts");
        
        // ---- Simple Alert ----
        driver.findElement(By.id("alertButton")).click();
        Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Simple alert: " + simpleAlert.getText());
        simpleAlert.accept();
        
        Thread.sleep(500);
        
        // ---- Confirmation Alert ----
        driver.findElement(By.id("confirmButton")).click();
        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Confirm alert: " + confirmAlert.getText());
        confirmAlert.dismiss(); // click Cancel
        
        Thread.sleep(500);
        
        // ---- Prompt Alert ----
        driver.findElement(By.id("promtButton")).click();
        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Prompt alert: " + promptAlert.getText());
        promptAlert.sendKeys("My Name Here"); // type in the input field
        promptAlert.accept(); // click OK
        
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Alert handling utility with retry =====
public class AlertAdvanced {
    
    public static String handleAlert(WebDriver driver, String action, String inputText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertMessage = alert.getText();
            System.out.println("Alert detected: " + alertMessage);
            
            // If prompt alert, type text first
            if (inputText != null && !inputText.isEmpty()) {
                alert.sendKeys(inputText);
            }
            
            // Handle based on action
            switch (action.toLowerCase()) {
                case "accept":
                    alert.accept();
                    break;
                case "dismiss":
                    alert.dismiss();
                    break;
                default:
                    throw new IllegalArgumentException("Action must be 'accept' or 'dismiss'");
            }
            
            return alertMessage;
            
        } catch (TimeoutException e) {
            System.out.println("No alert appeared within timeout");
            return null;
        }
    }
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        
        driver.findElement(By.id("promtButton")).click();
        String message = handleAlert(driver, "accept", "Automation Testing");
        System.out.println("Handled alert with message: " + message);
        
        driver.quit();
    }
}
```

**Real-World Scenarios:**
1. Accepting "Are you sure you want to delete?" confirmation before deleting a record
2. Handling "Session expired. Please login again." alerts
3. Dismissing unwanted "Subscribe to our newsletter" alerts
4. Handling browser-level file download confirmation dialogs
5. Testing that proper alerts appear when form validation fails

**Common Alert Mistakes:**

| Mistake | Fix |
|---------|-----|
| Using findElement to interact with alerts | Use `driver.switchTo().alert()` |
| Not waiting for alert before switching | Use `ExpectedConditions.alertIsPresent()` |
| Forgetting to accept/dismiss before next action | Always handle alert before proceeding |
| Alert still open when test ends → browser hangs | Add alert handling in `@AfterMethod` cleanup |

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Alerts అంటే ఏమిటి?**

Alerts అనేవి browser level pop-up boxes. ఇవి webpage లో elements కాదు — కాబట్టి వాటిని `findElement` తో find చేయలేం.

**మూడు రకాలు:**
1. **Simple Alert** — ఒక message, OK button మాత్రమే ఉంటుంది
   - ఉదా: "Your form has been submitted!"
2. **Confirmation Alert** — OK మరియు Cancel buttons ఉంటాయి
   - ఉదా: "Are you sure you want to delete this record?"
3. **Prompt Alert** — text input + OK/Cancel ఉంటాయి
   - ఉదా: "Please enter your name:"

**ఎలా handle చేయాలి:**
1. `driver.switchTo().alert()` — alert కి switch చేయాలి
2. `alert.getText()` — alert message చదవాలి
3. `alert.accept()` — OK click చేయాలి
4. `alert.dismiss()` — Cancel click చేయాలి
5. `alert.sendKeys("text")` — prompt alert లో text type చేయాలి

**Real scenario:** Delete button click చేసిన తర్వాత "Are you sure?" confirmation వస్తుంది. Automation లో దాన్ని accept చేయాలి.

</details>

---

## Frames and iFrames

### What Are Frames?

A frame (or iframe) is a webpage inside another webpage. Many websites embed content from other sources using iframes — like YouTube videos, payment widgets, Google Maps, or chat widgets.

**The problem:** If an element is inside a frame, Selenium cannot find it directly. You must **switch** to the frame first.

```
Main Page
├── Element1 (Selenium can find this directly)
├── Element2 (Selenium can find this directly)
└── iframe (container)
    ├── Frame Element 1 (must switch to frame first!)
    └── Frame Element 2 (must switch to frame first!)
```

```java
// ===== SIMPLE: Switch to frame by index =====
public class FrameSimple {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        
        // Switch to first frame (index 0)
        driver.switchTo().frame(0);
        
        // Now we can find elements inside the frame
        String text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Frame text: " + text);
        
        // Switch back to main page
        driver.switchTo().defaultContent();
        
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Switch by name/id and by WebElement =====
public class FrameIntermediate {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
        
        // Method 1: Switch by name or ID
        driver.switchTo().frame("frame1");
        System.out.println("Outer frame body: " + 
            driver.findElement(By.tagName("body")).getText());
        
        // Switch back
        driver.switchTo().defaultContent();
        
        // Method 2: Switch using WebElement
        WebElement frameElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameElement);
        System.out.println("In frame using WebElement");
        
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Nested frames (frame inside a frame) =====
public class NestedFrameAdvanced {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
        
        // Step 1: Switch to outer frame
        driver.switchTo().frame("frame1");
        System.out.println("Outer frame: " + 
            driver.findElement(By.tagName("body")).getText());
        
        // Step 2: Switch to inner frame (nested inside outer frame)
        driver.switchTo().frame("frame2");
        System.out.println("Inner frame: " + 
            driver.findElement(By.tagName("body")).getText());
        
        // To go from inner frame to outer frame: use parentFrame()
        driver.switchTo().parentFrame();
        System.out.println("Back to outer frame");
        
        // To go all the way back to main page: use defaultContent()
        driver.switchTo().defaultContent();
        System.out.println("Back to main page");
        
        driver.quit();
    }
}
```

**Frame Switching Methods:**

| Method | When to Use |
|--------|-------------|
| `switchTo().frame(0)` | When you know the frame's position (0, 1, 2...) |
| `switchTo().frame("name")` | When frame has a name or id attribute |
| `switchTo().frame(webElement)` | When you have the frame element reference |
| `switchTo().defaultContent()` | Go back to main page from any frame |
| `switchTo().parentFrame()` | Go one level up (from nested frame to parent) |

**Real-World Scenarios:**
1. Interacting with payment gateway embedded in an iframe (Stripe, PayPal widgets)
2. Testing Google reCAPTCHA (which loads in an iframe)
3. Automating web editors like TinyMCE or CKEditor (they use iframes)
4. Testing embedded YouTube video controls
5. Automating chat widgets (like Intercom or Zendesk chat)

**Common Frame Mistakes:**

| Mistake | Fix |
|---------|-----|
| Finding frame element inside another frame without switching | Always switch to frame before finding elements in it |
| Forgetting to switch back to main page | Call `driver.switchTo().defaultContent()` after frame interaction |
| Trying to switch by index when frames load dynamically | Use `frameToBeAvailableAndSwitchToIt` with Explicit Wait |
| Not handling nested frames — only switching to outer | Switch step by step: outer → inner |

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Frames అంటే ఏమిటి?**

Frame (iframe) అనేది ఒక webpage లో మరొక webpage ని embed చేయడం. చాలా websites payment widgets, YouTube videos, maps ఇలాంటివి iframe లో load చేస్తాయి.

**సమస్య:** iframe లో ఉన్న elements ని Selenium directly find చేయలేదు. మీరు ముందు frame లోకి switch చేయాలి.

**4 switch methods:**
1. `switchTo().frame(0)` — index తో (0, 1, 2...)
2. `switchTo().frame("frameName")` — name/id తో
3. `switchTo().frame(webElement)` — element reference తో
4. `switchTo().defaultContent()` — main page కి వెనక్కి

**Nested frames:** Frame లో మళ్ళీ frame ఉంటే, step by step switch చేయాలి:
- Outer frame కి switch
- Inner frame కి switch
- పని అయిన తర్వాత `defaultContent()` తో main page కి రావాలి

**Real example:** Stripe payment form చాలా వెబ్సైట్లలో iframe లో ఉంటుంది. Credit card number type చేయడానికి ముందు ఆ frame లోకి switch చేయాలి.

</details>

---

## Windows and Tabs

### Working With Multiple Browser Windows

When you click a link that opens in a new tab or window, Selenium stays focused on the original window. You must switch to the new window to interact with it.

Every window/tab has a unique **Window Handle** — a long string like `CDwindow-7F3A...`

```java
// ===== SIMPLE: Switch to new window =====
public class WindowSimple {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        
        // Store handle of the original window
        String originalWindow = driver.getWindowHandle();
        System.out.println("Original window: " + originalWindow);
        
        // Click button that opens new window
        driver.findElement(By.id("windowButton")).click();
        
        // Wait for new window to open
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        // Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        
        // Interact with the new window
        System.out.println("New window title: " + driver.getTitle());
        System.out.println("New window URL: " + driver.getCurrentUrl());
        
        // Close new window and switch back
        driver.close();
        driver.switchTo().window(originalWindow);
        System.out.println("Back to original: " + driver.getTitle());
        
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Handle multiple windows with utility method =====
public class WindowIntermediate {
    
    // Utility: switch to window by partial title
    public static void switchToWindowByTitle(WebDriver driver, String partialTitle) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(partialTitle)) {
                System.out.println("Switched to: " + driver.getTitle());
                return;
            }
        }
        throw new RuntimeException("Window with title '" + partialTitle + "' not found");
    }
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        
        String original = driver.getWindowHandle();
        
        // Open tab button
        driver.findElement(By.id("tabButton")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        // Switch by title
        switchToWindowByTitle(driver, "This is a sample page");
        System.out.println("Tab content: " + driver.findElement(By.tagName("h1")).getText());
        
        driver.close();
        driver.switchTo().window(original);
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Multi-window workflow (like opening product in new tab, comparing prices) =====
public class MultiWindowAdvanced {
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example-shopping.com");
        
        String mainWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // Open product 1 in new tab
        driver.findElement(By.linkText("Product A")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        Set<String> allWindows = driver.getWindowHandles();
        String product1Window = allWindows.stream()
            .filter(h -> !h.equals(mainWindow))
            .findFirst().orElseThrow();
        
        driver.switchTo().window(product1Window);
        String price1 = driver.findElement(By.cssSelector(".product-price")).getText();
        System.out.println("Product A price: " + price1);
        
        // Go back to main window and open product 2
        driver.switchTo().window(mainWindow);
        driver.findElement(By.linkText("Product B")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        
        String product2Window = driver.getWindowHandles().stream()
            .filter(h -> !h.equals(mainWindow) && !h.equals(product1Window))
            .findFirst().orElseThrow();
        
        driver.switchTo().window(product2Window);
        String price2 = driver.findElement(By.cssSelector(".product-price")).getText();
        System.out.println("Product B price: " + price2);
        
        // Close all extra windows
        driver.close();
        driver.switchTo().window(product1Window);
        driver.close();
        driver.switchTo().window(mainWindow);
        
        System.out.println("Comparison complete. Back to main.");
        driver.quit();
    }
}
```

**Real-World Scenarios:**
1. E-commerce: Opening product detail in new tab, verifying details, closing tab
2. Banking: Testing "Open account statement in new window" feature
3. Social media: Testing "Share" buttons that open new windows
4. Admin panels: Opening edit forms that open in popup windows
5. Download links: Verifying download confirmation page in new window

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Windows and Tabs అంటే ఏమిటి?**

Browser లో ఒక link click చేసినప్పుడు కొన్నిసార్లు కొత్త tab లేదా window తెరుచుకుంటుంది. Selenium automatically కొత్త window కి switch అవ్వదు — మీరే manually switch చేయాలి.

**Window Handle:** ప్రతి browser window కి ఒక unique ID (string) ఉంటుంది. దాన్ని window handle అంటారు.

**Steps:**
1. `driver.getWindowHandle()` — current window handle store చేయండి
2. కొత్త window trigger చేయండి (button click, link click)
3. `driver.getWindowHandles()` — అన్ని windows handle list తీసుకోండి
4. New handle identify చేసి `driver.switchTo().window(newHandle)` చేయండి
5. New window లో పని చేయండి
6. `driver.close()` — new window close చేయండి
7. `driver.switchTo().window(originalHandle)` — main window కి వెనక్కి రండి

**Real scenario:** Shopping website లో product link click చేస్తే new tab లో product details తెరుచుకుంటుంది. ఆ tab లో price verify చేసి, close చేసి main page కి రావడం.

</details>

---

## JavaScriptExecutor

### What Is JavaScriptExecutor?

Sometimes Selenium cannot interact with elements normally — they may be hidden, covered by another element, or in a complex UI. JavaScriptExecutor lets you run JavaScript code directly in the browser to do what Selenium cannot.

Think of it as Selenium calling the browser's own scripting engine.

```java
// ===== SIMPLE: Basic JavaScript execution =====
public class JSExecutorSimple {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Execute JavaScript — get page title
        String title = (String) js.executeScript("return document.title;");
        System.out.println("Page title via JS: " + title);
        
        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0, 500);");
        
        // Scroll to bottom of page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Click, scroll to element, set values =====
public class JSExecutorIntermediate {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/buttons");
        
        // Click a button using JavaScript (useful when normal click fails)
        WebElement button = driver.findElement(By.id("doubleClickBtn"));
        js.executeScript("arguments[0].click();", button);
        System.out.println("Button clicked via JavaScript");
        
        // Scroll to a specific element
        WebElement element = driver.findElement(By.id("rightClickBtn"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("Scrolled to element");
        
        // Set value in a read-only or disabled field
        js.executeScript("arguments[0].value='automation';", 
            driver.findElement(By.id("readOnlyInput")));
        
        // Change element's style (useful for highlighting)
        js.executeScript(
            "arguments[0].style.border='3px solid red';", element
        );
        
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Comprehensive JS utilities =====
public class JSExecutorAdvanced {
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public JSExecutorAdvanced(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }
    
    // Highlight element (useful for debugging)
    public void highlightElement(WebElement element) {
        String originalStyle = element.getAttribute("style");
        js.executeScript(
            "arguments[0].style.border='3px solid red'; " +
            "arguments[0].style.backgroundColor='yellow';", element
        );
        try { Thread.sleep(300); } catch (InterruptedException e) {}
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
            element, originalStyle);
    }
    
    // Get all text from page
    public String getPageText() {
        return (String) js.executeScript("return document.body.innerText;");
    }
    
    // Scroll to element smoothly
    public void scrollToElement(WebElement element) {
        js.executeScript(
            "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
            element
        );
    }
    
    // Check if element is in viewport
    public boolean isElementInViewport(WebElement element) {
        return (Boolean) js.executeScript(
            "var rect = arguments[0].getBoundingClientRect();" +
            "return (rect.top >= 0 && rect.left >= 0 && " +
            "rect.bottom <= window.innerHeight && rect.right <= window.innerWidth);",
            element
        );
    }
    
    // Remove element from DOM (useful for hiding cookie banners)
    public void removeElement(WebElement element) {
        js.executeScript("arguments[0].remove();", element);
    }
    
    // Wait for jQuery AJAX to complete
    public boolean waitForJQueryComplete() {
        return (Boolean) js.executeScript("return jQuery.active == 0;");
    }
    
    // Get DOM attribute (not HTML attribute)
    public Object getDOMProperty(WebElement element, String property) {
        return js.executeScript("return arguments[0]." + property + ";", element);
    }
    
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        
        JSExecutorAdvanced jsUtil = new JSExecutorAdvanced(driver);
        
        WebElement header = driver.findElement(By.tagName("h2"));
        jsUtil.highlightElement(header);
        jsUtil.scrollToElement(header);
        
        System.out.println("Is in viewport: " + jsUtil.isElementInViewport(header));
        System.out.println("Page text length: " + jsUtil.getPageText().length());
        
        driver.quit();
    }
}
```

**Common JavaScriptExecutor Use Cases:**

| Scenario | JavaScript Command |
|----------|-------------------|
| Click hidden/covered element | `arguments[0].click()` |
| Scroll to element | `arguments[0].scrollIntoView(true)` |
| Scroll to top | `window.scrollTo(0,0)` |
| Scroll to bottom | `window.scrollTo(0, document.body.scrollHeight)` |
| Set field value | `arguments[0].value = 'text'` |
| Get page URL | `return window.location.href` |
| Refresh page | `window.location.reload()` |
| Open new URL | `window.location.href = 'https://...'` |
| Check page ready state | `return document.readyState` |
| Remove overlay/banner | `arguments[0].remove()` |

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**JavaScriptExecutor అంటే ఏమిటి?**

కొన్నిసార్లు Selenium తో normal click లేదా interaction చేయలేం. Element hidden గా ఉండవచ్చు, మరొక element దాన్ని cover చేస్తుండవచ్చు. అలాంటప్పుడు JavaScriptExecutor use చేస్తాం.

JavaScriptExecutor అంటే — Selenium browser కి JavaScript commands పంపుతుంది. Browser మన command execute చేస్తుంది.

**ఎప్పుడు వాడాలి:**
- Normal click పని చేయనప్పుడు
- Page scroll చేయడానికి
- Read-only fields లో value set చేయడానికి
- Element highlight చేయడానికి (debugging కోసం)
- Cookie banners / overlays remove చేయడానికి

**Important:** JavaScriptExecutor overuse చేయకండి. మొదట Selenium standard methods try చేయండి. అవి fail అయినప్పుడే JS use చేయండి.

</details>

---

## Actions Class

### What Is the Actions Class?

The Actions class handles complex mouse and keyboard interactions that simple `click()` cannot handle:
- Hovering over menus
- Double-clicking to edit cells
- Right-clicking for context menus
- Drag and drop
- Keyboard combinations (Ctrl+A, Ctrl+C)

```java
import org.openqa.selenium.interactions.Actions;

// ===== SIMPLE: Mouse hover =====
public class ActionsSimple {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/menu");
        
        Actions actions = new Actions(driver);
        
        // Hover over main menu item to reveal sub-menu
        WebElement mainMenu = driver.findElement(By.linkText("Main Item 2"));
        actions.moveToElement(mainMenu).perform();
        
        Thread.sleep(500); // small wait for sub-menu animation
        
        // Now click sub-menu item that appeared on hover
        WebElement subMenu = driver.findElement(By.linkText("SUB SUB LIST »"));
        actions.moveToElement(subMenu).perform();
        Thread.sleep(300);
        
        WebElement deepItem = driver.findElement(By.linkText("Sub Sub Item 1"));
        deepItem.click();
        
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Double click, right click, and keyboard events =====
public class ActionsIntermediate {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/buttons");
        
        // Double click
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();
        System.out.println("Double click result: " + 
            driver.findElement(By.id("doubleClickMessage")).getText());
        
        // Right click (context click)
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();
        System.out.println("Right click result: " + 
            driver.findElement(By.id("rightClickMessage")).getText());
        
        // Keyboard: Select all text and copy
        WebElement textField = driver.findElement(By.id("nameField"));
        textField.sendKeys("Hello World");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); // Ctrl+A
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform(); // Ctrl+C
        
        // Clear and paste
        textField.clear();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform(); // Ctrl+V
        
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Drag and Drop + Chain of Actions =====
public class ActionsAdvanced {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/droppable");
        
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        
        // Method 1: dragAndDrop (simple)
        actions.dragAndDrop(source, target).perform();
        System.out.println("Drop result: " + target.getText());
        
        driver.navigate().refresh();
        Thread.sleep(1000);
        
        // Method 2: Manual drag-and-drop (more reliable)
        source = driver.findElement(By.id("draggable"));
        target = driver.findElement(By.id("droppable"));
        
        actions.clickAndHold(source)
               .moveToElement(target)
               .pause(Duration.ofMillis(500))  // pause mid-drag
               .release()
               .build()
               .perform();
        
        System.out.println("Drop result: " + target.getText());
        
        // Method 3: Drag by offset (pixel coordinates)
        actions.clickAndHold(source)
               .moveByOffset(200, 100)  // move 200px right, 100px down
               .release()
               .perform();
        
        driver.quit();
    }
}
```

**All Actions Class Methods:**

| Method | What It Does |
|--------|-------------|
| `moveToElement(element)` | Hover over element |
| `click(element)` | Click on element |
| `doubleClick(element)` | Double-click on element |
| `contextClick(element)` | Right-click (context menu) |
| `clickAndHold(element)` | Press mouse button and hold |
| `release()` | Release mouse button |
| `dragAndDrop(source, target)` | Drag from source to target |
| `dragAndDropBy(element, x, y)` | Drag element by offset |
| `moveByOffset(x, y)` | Move mouse by pixel offset |
| `keyDown(Keys.CONTROL)` | Press and hold key |
| `keyUp(Keys.CONTROL)` | Release key |
| `sendKeys(text)` | Type text |
| `pause(duration)` | Wait between actions |
| `build()` | Build the action chain |
| `perform()` | Execute the action chain |

**Real-World Scenarios:**
1. Testing drag-and-drop file upload widgets
2. Hovering over navigation menus that reveal submenus
3. Double-clicking table cells to enable inline editing
4. Right-clicking to test context menu items
5. Keyboard shortcuts in web text editors (bold, italic, etc.)

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Actions Class అంటే ఏమిటి?**

Simple `click()` ఒక్కసారి click చేస్తుంది. కానీ real user interactions మరింత complex గా ఉంటాయి:
- Menu మీద hover చేయడం (sub-menu show చేయడానికి)
- Double click చేసి cell edit చేయడం
- Right click చేసి context menu తెరవడం
- File ని drag చేసి upload area లో drop చేయడం

ఇవన్నీ Actions class handle చేస్తుంది.

**Important pattern:**
```java
Actions actions = new Actions(driver);
actions.moveToElement(element)  // action 1
       .pause(Duration.ofMillis(300))  // action 2
       .click()  // action 3
       .perform();  // execute all at once
```

`build().perform()` లేదా just `perform()` — actions execute చేయాలంటే `perform()` call చేయాలి.

**Drag and Drop:** చాలాసార్లు Selenium built-in `dragAndDrop()` పని చేయదు. అప్పుడు manual method — `clickAndHold → moveToElement → release` — వాడాలి.

</details>

---

## Screenshots

### Taking Screenshots in Selenium

Screenshots are essential for:
- Seeing why a test failed
- Creating test execution reports with visual proof
- Debugging element visibility issues

```java
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import java.io.File;

// ===== SIMPLE: Take full-page screenshot =====
public class ScreenshotSimple {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        
        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
        
        // Save to disk
        File destination = new File("screenshots/google_homepage.png");
        FileUtils.copyFile(screenshotFile, destination);
        
        System.out.println("Screenshot saved: " + destination.getAbsolutePath());
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Screenshot on test failure + timestamped name =====
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotOnFailure {
    
    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "screenshots/" + testName + "_" + timestamp + ".png";
            
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenshot = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(fileName));
            
            System.out.println("Screenshot saved: " + fileName);
            return fileName;
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://example.com/login");
            driver.findElement(By.id("username")).sendKeys("testuser");
            driver.findElement(By.id("password")).sendKeys("wrongpass");
            driver.findElement(By.id("loginBtn")).click();
            
            // Check for error message
            String errorText = driver.findElement(By.id("error")).getText();
            if (errorText.contains("Invalid")) {
                takeScreenshot(driver, "login_failed");
            }
        } catch (Exception e) {
            takeScreenshot(driver, "unexpected_error");
            throw e;
        } finally {
            driver.quit();
        }
    }
}
```

```java
// ===== ADVANCED: Element-level screenshot + Base64 for reports =====
public class AdvancedScreenshots {
    
    // Screenshot of a specific element only
    public static File takeElementScreenshot(WebElement element, String fileName) throws Exception {
        File screenshot = element.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + fileName + ".png");
        FileUtils.copyFile(screenshot, dest);
        return dest;
    }
    
    // Get screenshot as Base64 (for embedding in HTML reports)
    public static String getScreenshotAsBase64(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
    
    // Screenshot with page scroll capture (multiple screenshots stitched)
    public static void takeFullPageScreenshot(WebDriver driver, String fileName) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Get total page height
        long totalHeight = (Long) js.executeScript("return document.body.scrollHeight");
        long viewportHeight = (Long) js.executeScript("return window.innerHeight");
        
        int scrollPosition = 0;
        int partIndex = 0;
        
        while (scrollPosition < totalHeight) {
            js.executeScript("window.scrollTo(0, " + scrollPosition + ")");
            Thread.sleep(300);
            
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenshot = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("screenshots/" + fileName + "_part" + partIndex + ".png"));
            
            scrollPosition += viewportHeight;
            partIndex++;
        }
        System.out.println("Captured " + partIndex + " screenshot parts");
    }
    
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        
        // Element screenshot
        WebElement logo = driver.findElement(By.cssSelector(".site-logo"));
        takeElementScreenshot(logo, "demoqa_logo");
        
        // Base64 (for reports)
        String base64 = getScreenshotAsBase64(driver);
        System.out.println("Base64 starts with: " + base64.substring(0, 30) + "...");
        
        driver.quit();
    }
}
```

**Screenshot Types:**

| Type | Code | Use Case |
|------|------|----------|
| File | `OutputType.FILE` | Save to disk |
| Base64 | `OutputType.BASE64` | Embed in HTML reports |
| Bytes | `OutputType.BYTES` | Process in memory |
| Element | `element.getScreenshotAs()` | Capture single element |

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Screenshots అంటే ఏమిటి?**

Test fail అయినప్పుడు screenshot తీయడం చాలా important. దాన్ని చూసి "ఏమి తప్పయింది?" అని immediately అర్థమవుతుంది.

**3 types:**
1. **Full page screenshot** — entire browser window
2. **Element screenshot** — specific element మాత్రమే
3. **Base64 screenshot** — HTML reports లో embed చేయడానికి

**Best practice:** Test fail అయినప్పుడు automatically screenshot తీయాలి. TestNG లో `@AfterMethod` లో, లేదా TestNG Listener లో దీన్ని setup చేయవచ్చు (Part 4 లో cover చేస్తాం).

**File naming:** Timestamp add చేయడం మంచిది — `login_20241201_143022.png` — ఇలా ఉంటే confusion ఉండదు.

</details>

---

## Cookies Handling

### What Are Cookies?

Cookies are small pieces of data stored in your browser. Websites use them to:
- Remember you are logged in
- Store your preferences
- Track your session

In automation, cookie manipulation lets you:
- Skip login by adding auth cookies directly
- Test cookie-based features
- Speed up tests significantly

```java
import org.openqa.selenium.Cookie;

// ===== SIMPLE: Read and print all cookies =====
public class CookiesSimple {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        
        // Get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Total cookies: " + cookies.size());
        
        for (Cookie cookie : cookies) {
            System.out.println("Name: " + cookie.getName() + 
                             " | Value: " + cookie.getValue() +
                             " | Domain: " + cookie.getDomain());
        }
        
        // Get specific cookie
        Cookie sessionCookie = driver.manage().getCookieNamed("session-id");
        if (sessionCookie != null) {
            System.out.println("Session ID: " + sessionCookie.getValue());
        }
        
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Add, modify, delete cookies =====
public class CookiesIntermediate {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        
        // Add a new cookie
        Cookie myCookie = new Cookie("testCookie", "testValue123");
        driver.manage().addCookie(myCookie);
        System.out.println("Cookie added");
        
        // Add cookie with more options
        Cookie detailedCookie = new Cookie.Builder("auth-token", "abc123xyz")
            .domain("example.com")
            .path("/")
            .isSecure(false)
            .build();
        driver.manage().addCookie(detailedCookie);
        
        // Verify cookie was added
        Cookie retrieved = driver.manage().getCookieNamed("testCookie");
        System.out.println("Retrieved: " + retrieved.getValue());
        
        // Delete specific cookie
        driver.manage().deleteCookieNamed("testCookie");
        System.out.println("Cookie deleted");
        
        // Delete all cookies
        driver.manage().deleteAllCookies();
        System.out.println("All cookies cleared");
        
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Login via cookies (skip login page) =====
public class CookieLoginAdvanced {
    
    static WebDriver driver;
    
    public static void loginNormallyAndSaveCookies(String username, String password) throws Exception {
        driver.get("https://your-app.com/login");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginBtn")).click();
        
        // Wait for login to complete
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("/dashboard"));
        
        // Save cookies to file or variable
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Saved " + cookies.size() + " cookies after login");
        
        // In real projects, serialize cookies to a file
        // For this example, we store in a static variable
        savedCookies = cookies;
    }
    
    static Set<Cookie> savedCookies;
    
    public static void loginWithCookies() throws Exception {
        driver.get("https://your-app.com"); // must visit domain first
        
        // Add all saved cookies
        for (Cookie cookie : savedCookies) {
            try {
                driver.manage().addCookie(cookie);
            } catch (Exception e) {
                System.out.println("Could not add cookie: " + cookie.getName());
            }
        }
        
        // Refresh to apply cookies
        driver.navigate().refresh();
        
        // Check if logged in
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }
    
    public static void main(String[] args) throws Exception {
        driver = new ChromeDriver();
        
        // First time: login normally
        loginNormallyAndSaveCookies("testuser@email.com", "password123");
        
        // Next tests: use cookies (much faster!)
        loginWithCookies();
        
        System.out.println("Logged in via cookies — no need to fill login form!");
        driver.quit();
    }
}
```

**Real-World Scenarios:**
1. Speeding up login-required tests (add auth cookie instead of filling login form every time)
2. Testing "Remember Me" functionality
3. Testing user preference persistence across sessions
4. Verifying that cookies have correct security flags (httpOnly, secure)
5. Testing cookie consent banners (add "accepted" cookie to skip banner)

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Cookies అంటే ఏమిటి?**

Cookies అనేవి browser లో save అయ్యే చిన్న data pieces. Login information, preferences ఇవన్నీ cookies లో store అవుతాయి.

**Automation లో cookies వాడటం:**
- **Speed up tests:** ప్రతి test కి login form fill చేయడం slow. బదులుగా, ఒకసారి login చేసి cookies save చేసి, తర్వాతి tests లో ఆ cookies add చేస్తే instant login.
- **Test cookie features:** "Remember me" functionality test చేయడానికి
- **Skip cookie banners:** "Accept cookies" banner ni cookies add చేసి skip చేయవచ్చు

**Important:** Cookie add చేయడానికి ముందు ఆ domain కి navigate చేయాలి. Otherwise cookie add కాదు.

</details>

---

## Shadow DOM

### What Is Shadow DOM?

Shadow DOM is a way websites create isolated parts of their UI. Elements inside Shadow DOM are hidden from regular DOM queries. This is common in:
- Web Components (custom HTML elements)
- Chrome's built-in UI (like `<input type="date">`)
- Many modern UI frameworks

```java
// ===== SIMPLE: Access Shadow DOM element =====
public class ShadowDOMSimple {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        driver.get("https://books.toscrape.com"); // example site with shadow elements
        
        // Step 1: Find the shadow HOST element (outer element that contains shadow DOM)
        WebElement shadowHost = driver.findElement(By.cssSelector("your-custom-element"));
        
        // Step 2: Get shadow root via JavaScript
        WebElement shadowRoot = (WebElement) js.executeScript(
            "return arguments[0].shadowRoot", shadowHost
        );
        
        // Step 3: Find elements inside shadow root
        WebElement insideShadow = shadowRoot.findElement(By.cssSelector("input"));
        insideShadow.sendKeys("Hello from inside shadow DOM");
        
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Selenium 4 native Shadow DOM support =====
public class ShadowDOMAdvanced {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("chrome://settings/"); // Chrome settings uses shadow DOM heavily
        
        // Selenium 4 method — getShadowRoot()
        WebElement hostElement = driver.findElement(By.cssSelector("settings-ui"));
        SearchContext shadowRoot = hostElement.getShadowRoot();
        
        // Find inside shadow root
        WebElement innerElement = shadowRoot.findElement(By.cssSelector("settings-main"));
        SearchContext nestedShadow = innerElement.getShadowRoot();
        
        // Continue traversing nested shadow roots
        WebElement deepElement = nestedShadow.findElement(By.cssSelector("settings-basic-page"));
        System.out.println("Found deep shadow element: " + deepElement.getTagName());
        
        driver.quit();
    }
}
```

**When You'll Encounter Shadow DOM:**
- Adobe Experience Manager websites
- Salesforce Lightning components
- Chrome DevTools elements (testing extensions)
- Any website using Web Components standard
- Material Design components (some implementations)

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Shadow DOM అంటే ఏమిటి?**

Shadow DOM అనేది webpage లోని ఒక isolated (separated) section. ఇందులో ఉన్న elements ని normal `findElement` తో find చేయలేం.

**ఎందుకు use చేస్తారు:**
- UI components ని isolated గా build చేయడానికి
- External CSS affect చేయకుండా ఉండటానికి
- Web Components standard లో భాగంగా

**ఎలా access చేయాలి:**
1. Shadow host element find చేయాలి (outer element)
2. `getShadowRoot()` (Selenium 4) లేదా JavaScript తో shadow root తీసుకోవాలి
3. Shadow root లోపల elements find చేయాలి

**Selenium 4 లో:** `element.getShadowRoot()` method directly వాడవచ్చు — JavaScript అక్కర్లేదు.

</details>

---

## Dynamic Content and AJAX

### What Is Dynamic Content?

Dynamic content changes without full page reload. AJAX (Asynchronous JavaScript and XML) loads data from server in background.

**Examples:**
- Search suggestions appearing as you type
- "Load more" button that adds more items
- Data tables that refresh automatically
- Live scores or stock prices

```java
// ===== SIMPLE: Wait for AJAX result to appear =====
public class AJAXSimple {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/auto-complete");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Type in autocomplete field — triggers AJAX call
        WebElement searchField = driver.findElement(
            By.cssSelector("input[placeholder='Type multiple color names']")
        );
        searchField.sendKeys("Red");
        
        // Wait for dropdown suggestions to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".auto-complete__menu")
        ));
        
        // Get all suggestions
        List<WebElement> suggestions = driver.findElements(
            By.cssSelector(".auto-complete__option")
        );
        System.out.println("Suggestions count: " + suggestions.size());
        
        // Click first suggestion
        suggestions.get(0).click();
        
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Wait for loader to disappear =====
public class AJAXIntermediate {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        driver.get("https://example.com/data-table");
        
        // Click "Refresh Data" button
        driver.findElement(By.id("refreshBtn")).click();
        
        // Wait for loading spinner to DISAPPEAR
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.cssSelector(".loading-spinner")
        ));
        
        // Now data is loaded
        List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
        System.out.println("Data rows loaded: " + rows.size());
        
        // Wait for jQuery AJAX to complete (alternative approach)
        wait.until(driver2 -> {
            JavascriptExecutor js = (JavascriptExecutor) driver2;
            return (Boolean) js.executeScript("return jQuery.active == 0;");
        });
        
        driver.quit();
    }
}
```

```java
// ===== ADVANCED: Dynamic table with pagination =====
public class DynamicTableAdvanced {
    
    public static List<String> getAllPageData(WebDriver driver) throws InterruptedException {
        List<String> allData = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        boolean hasNextPage = true;
        int pageNumber = 1;
        
        while (hasNextPage) {
            System.out.println("Processing page: " + pageNumber);
            
            // Wait for table to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("table tbody tr")
            ));
            
            // Collect current page data
            List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
            for (WebElement row : rows) {
                allData.add(row.getText());
            }
            
            // Check for next page button
            List<WebElement> nextBtn = driver.findElements(
                By.cssSelector(".pagination .next:not(.disabled)")
            );
            
            if (nextBtn.isEmpty()) {
                hasNextPage = false;
            } else {
                nextBtn.get(0).click();
                
                // Wait for table to refresh (stale element confirms page changed)
                WebElement firstRow = rows.get(0);
                wait.until(ExpectedConditions.stalenessOf(firstRow));
                pageNumber++;
            }
        }
        
        System.out.println("Total records collected: " + allData.size());
        return allData;
    }
    
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        
        getAllPageData(driver);
        driver.quit();
    }
}
```

**Key Strategies for Dynamic Content:**

| Situation | Solution |
|-----------|----------|
| Element appears after API call | Explicit Wait - `visibilityOfElementLocated` |
| Loader/spinner needs to go away | Explicit Wait - `invisibilityOfElementLocated` |
| jQuery AJAX | Wait for `jQuery.active == 0` |
| Angular app | Wait for `angular.element(document).injector()` |
| React app | Wait for specific element to render |
| Table refreshes | Wait for `stalenessOf` + then new element |

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Dynamic Content అంటే ఏమిటి?**

Modern websites page reload చేయకుండా data తీసుకువస్తాయి — ఇదే AJAX. Search field లో type చేస్తే suggestions వస్తాయి, "Load More" click చేస్తే more items వస్తాయి — ఇవన్నీ AJAX.

**Automation challenge:**
- AJAX call complete అవ్వడానికి కొంత time పడుతుంది
- Selenium fast గా next step కి వెళ్ళిపోతుంది
- Result: `NoSuchElementException` లేదా empty data

**Solutions:**
1. **Spinner/loader కోసం:** `invisibilityOfElementLocated` — spinner disappear అయ్యే వరకు wait
2. **Result elements కోసం:** `visibilityOfElementLocated` — results appear అయ్యే వరకు wait
3. **jQuery అయితే:** `jQuery.active == 0` — all AJAX calls complete అయ్యే వరకు wait
4. **Table refresh అయితే:** `stalenessOf` — old table stale అయిన తర్వాత new table wait

</details>

---

## Exception Handling in Selenium

### The Most Common Selenium Exceptions

```
Exception hierarchy:
WebDriverException
├── NoSuchElementException         — element not found
├── StaleElementReferenceException — element was on page, now it's not
├── ElementNotInteractableException — element exists but can't be interacted
├── TimeoutException               — wait condition not met in time
├── NoSuchFrameException           — frame not found
├── NoSuchWindowException          — window handle invalid
├── NoAlertPresentException        — tried to handle alert that doesn't exist
├── ElementNotVisibleException     — element hidden (legacy, now Interactable)
├── InvalidSelectorException       — bad XPath or CSS selector syntax
└── SessionNotCreatedException     — browser driver version mismatch
```

### StaleElementReferenceException

**What it is:** You found an element, then the page refreshed or changed. The reference you have is now "stale" (dead).

```java
// ===== Problem: StaleElementReferenceException =====
public class StaleElementProblem {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        
        WebElement row = driver.findElement(By.cssSelector("table tbody tr:first-child"));
        
        // Page refreshes here (sorting, filtering, navigation)
        driver.findElement(By.id("searchBox")).sendKeys("kierra");
        
        // NOW row reference is stale — this will throw StaleElementReferenceException
        System.out.println(row.getText()); // EXCEPTION!
        
        driver.quit();
    }
}
```

```java
// ===== Solution 1: Re-find the element =====
public class StaleElementFix1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        
        driver.findElement(By.id("searchBox")).sendKeys("kierra");
        
        // Find element AFTER page change
        WebElement row = driver.findElement(By.cssSelector("table tbody tr:first-child"));
        System.out.println(row.getText()); // Works!
        
        driver.quit();
    }
}
```

```java
// ===== Solution 2: Retry wrapper for stale elements =====
public class StaleElementRetry {
    
    public static WebElement findElementWithRetry(WebDriver driver, By locator, int maxRetries) {
        int retries = 0;
        while (retries < maxRetries) {
            try {
                return driver.findElement(locator);
            } catch (StaleElementReferenceException e) {
                retries++;
                System.out.println("Stale element, retry " + retries);
                try { Thread.sleep(500); } catch (InterruptedException ex) {}
            }
        }
        throw new RuntimeException("Could not find element after " + maxRetries + " retries");
    }
    
    public static String getTextWithRetry(WebDriver driver, By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(StaleElementReferenceException.class);
        
        return wait.until(driver2 -> driver2.findElement(locator).getText());
    }
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        
        String text = getTextWithRetry(driver, By.cssSelector("table tbody tr:first-child"));
        System.out.println("Row text: " + text);
        
        driver.quit();
    }
}
```

---

### ElementNotInteractableException

**What it is:** Element exists in DOM but cannot be clicked/typed into. Usually because it is:
- Hidden (display:none, visibility:hidden)
- Covered by another element
- Disabled
- Outside viewport

```java
// ===== Solutions for ElementNotInteractableException =====
public class ElementNotInteractableFix {
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        
        driver.get("https://example.com/problem-page");
        
        WebElement element = driver.findElement(By.id("hiddenButton"));
        
        // Solution 1: Wait for element to be interactable
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hiddenButton")));
        element.click();
        
        // Solution 2: Scroll element into view first
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        
        // Solution 3: Use JavaScript click (bypasses visibility check)
        js.executeScript("arguments[0].click();", element);
        
        // Solution 4: Remove covering element
        WebElement overlay = driver.findElement(By.id("modal-overlay"));
        js.executeScript("arguments[0].remove();", overlay);
        element.click();
        
        // Solution 5: Use Actions to move to element then click
        actions.moveToElement(element).click().perform();
        
        driver.quit();
    }
}
```

---

### NoSuchElementException — The Most Common One

```java
// ===== Handling NoSuchElementException =====
public class NoSuchElementFix {
    
    // Safe find — returns null instead of throwing exception
    public static WebElement safeFindElement(WebDriver driver, By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + locator);
            return null;
        }
    }
    
    // Check if element exists
    public static boolean elementExists(WebDriver driver, By locator) {
        return !driver.findElements(locator).isEmpty();
    }
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        
        // Approach 1: Use findElements (returns empty list, not exception)
        List<WebElement> elements = driver.findElements(By.id("mayNotExist"));
        if (!elements.isEmpty()) {
            elements.get(0).click();
        }
        
        // Approach 2: Check before acting
        if (elementExists(driver, By.id("closeButton"))) {
            driver.findElement(By.id("closeButton")).click();
        }
        
        // Approach 3: Safe find with null check
        WebElement btn = safeFindElement(driver, By.id("optionalButton"));
        if (btn != null) {
            btn.click();
        }
        
        driver.quit();
    }
}
```

**Exception Quick Reference:**

| Exception | Cause | Fix |
|-----------|-------|-----|
| `NoSuchElementException` | Element not in DOM | Use waits, check locator |
| `StaleElementReferenceException` | Element was removed from DOM | Re-find element, use FluentWait |
| `ElementNotInteractableException` | Element not clickable | Scroll to it, use JS click, wait for interactable |
| `TimeoutException` | Wait condition not met | Increase timeout, check condition logic |
| `NoSuchFrameException` | Frame not found or not loaded | Use wait for frame, check frame name/id |
| `NoAlertPresentException` | Alert not present | Use `alertIsPresent()` wait |
| `InvalidSelectorException` | Bad XPath/CSS | Test selector in browser DevTools first |
| `SessionNotCreatedException` | Driver version mismatch | Update ChromeDriver/GeckoDriver |

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**Selenium Exceptions అంటే ఏమిటి?**

Test run అవుతున్నప్పుడు Selenium problems encounter అయినప్పుడు exceptions throw చేస్తుంది. వాటిని అర్థం చేసుకుని fix చేయడం professional tester skill.

**Most important exceptions:**

**1. NoSuchElementException**
- Cause: Element DOM లో లేదు
- Fix: Wait వాడు, locator check చేయి, `findElements()` వాడి empty check చేయి

**2. StaleElementReferenceException**
- Cause: Element ఒకసారి find చేశావు, తర్వాత page change అయింది, ఇప్పుడు reference valid కాదు
- Fix: Page change తర్వాత element మళ్ళీ find చేయి

**3. ElementNotInteractableException**
- Cause: Element DOM లో ఉంది కానీ visible కాదు లేదా disabled
- Fix: Scroll to element, JavaScript click use చేయి, overlay remove చేయి

**4. TimeoutException**
- Cause: Wait condition specified time లో meet కాలేదు
- Fix: Timeout increase చేయి, condition correct గా ఉందా check చేయి

**Golden rule:** Exception message చదువు — అది exactly ఏ locator fail అయిందో, ఏ line లో అయిందో చెప్తుంది.

</details>

---

## File Upload and Download

### File Upload Automation

```java
// ===== SIMPLE: Upload using sendKeys (standard input type=file) =====
public class FileUploadSimple {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        
        // Find the file input element
        WebElement uploadElement = driver.findElement(By.id("uploadFile"));
        
        // Provide the FULL file path
        String filePath = System.getProperty("user.dir") + "/testfiles/sample.pdf";
        uploadElement.sendKeys(filePath);
        
        // Verify upload
        WebElement uploadedPath = driver.findElement(By.id("uploadedFilePath"));
        System.out.println("Uploaded: " + uploadedPath.getText());
        
        driver.quit();
    }
}
```

```java
// ===== INTERMEDIATE: Upload with custom file dialog (using Robot class) =====
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploadRobot {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/custom-upload");
        
        // Click the custom upload button (which opens OS file dialog)
        driver.findElement(By.id("customUploadBtn")).click();
        
        Thread.sleep(2000); // wait for dialog to open
        
        // Use Robot to type file path and press Enter
        Robot robot = new Robot();
        
        // Copy file path to clipboard
        String filePath = "C:\\Users\\User\\Documents\\testfile.pdf";
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        // Paste the path (Ctrl+V) and confirm (Enter)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        
        Thread.sleep(500);
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        System.out.println("File uploaded via Robot");
        driver.quit();
    }
}
```

### File Download Automation

```java
// ===== Configure Chrome to auto-download =====
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class FileDownloadConfig {
    
    public static WebDriver createDriverWithDownloadConfig(String downloadPath) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false); // no dialog
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", false); // bypass safety warnings
        
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        
        return new ChromeDriver(options);
    }
    
    public static boolean waitForDownload(String downloadPath, String fileName, int timeoutSeconds) {
        File file = new File(downloadPath + File.separator + fileName);
        int waited = 0;
        
        while (!file.exists() && waited < timeoutSeconds) {
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            waited++;
            System.out.println("Waiting for download... " + waited + "s");
        }
        
        return file.exists();
    }
    
    public static void main(String[] args) throws Exception {
        String downloadDir = System.getProperty("user.dir") + "/downloads";
        new File(downloadDir).mkdirs();
        
        WebDriver driver = createDriverWithDownloadConfig(downloadDir);
        driver.get("https://demoqa.com/upload-download");
        
        // Click download button
        driver.findElement(By.id("downloadButton")).click();
        
        // Wait for file to appear
        boolean downloaded = waitForDownload(downloadDir, "sampleFile.jpeg", 30);
        System.out.println("Download successful: " + downloaded);
        
        driver.quit();
    }
}
```

<details>
<summary>తెలుగు వివరణ (Telugu Explanation)</summary>

**File Upload/Download Automation:**

**Upload — 2 methods:**

**Method 1: sendKeys (easiest)**
- `<input type="file">` element కి file path sendKeys చేయడం
- `uploadElement.sendKeys("C:\\path\\to\\file.pdf")`
- OS dialog తెరుచుకోదు, direct upload

**Method 2: Robot class**
- Custom upload buttons (OS dialog తెరుచుకుంటే) కోసం
- Robot class keyboard/mouse simulate చేస్తుంది
- File path clipboard లో copy చేసి Ctrl+V పెట్టి Enter press చేస్తుంది

**Download:**
- ChromeOptions లో download directory specify చేయాలి
- `prompt_for_download: false` — dialog వస్తుందని ask చేయడు
- Download complete అయ్యే వరకు file exist అవ్వడం wait చేయాలి

</details>

---

## Hidden Elements and Popup Windows

### Handling Hidden Elements

Elements can be hidden in multiple ways, each requiring a different approach:

```java
public class HiddenElementHandling {
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://example.com");
        
        WebElement hiddenElement = driver.findElement(By.id("hiddenField"));
        
        // Check visibility
        System.out.println("Displayed: " + hiddenElement.isDisplayed());
        
        // Method 1: Make element visible via JavaScript
        js.executeScript("arguments[0].style.display='block';", hiddenElement);
        js.executeScript("arguments[0].style.visibility='visible';", hiddenElement);
        
        // Method 2: Directly interact via JavaScript (without making visible)
        js.executeScript("arguments[0].value='hidden value';", hiddenElement);
        js.executeScript("arguments[0].click();", hiddenElement);
        
        // Method 3: Trigger JavaScript events (for reactive frameworks)
        js.executeScript(
            "var event = new Event('change'); arguments[0].dispatchEvent(event);",
            hiddenElement
        );
        
        // Method 4: getAttribute still works for hidden elements
        String value = hiddenElement.getAttribute("value");
        System.out.println("Hidden field value: " + value);
        
        driver.quit();
    }
}
```

### Non-Browser Popup Windows

Some applications open actual OS-level popups (not HTML). Selenium cannot handle these. Use these strategies:

```java
import org.sikuli.script.*;  // SikuliX for image-based automation

// Strategy 1: Dismiss popups via keyboard shortcuts
public class PopupHandling {
    public static void dismissWithEscape(WebDriver driver) throws Exception {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }
    
    // Strategy 2: Handle Windows OS dialog via Robot
    public static void handleWindowsDialog(String choice) throws Exception {
        Robot robot = new Robot();
        Thread.sleep(2000);
        
        if (choice.equals("OK")) {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } else if (choice.equals("Cancel")) {
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        }
    }
    
    // Strategy 3: Use AutoIT (Windows only, external tool)
    public static void handleWithAutoIT(String scriptPath) throws Exception {
        Runtime.getRuntime().exec(scriptPath);
    }
}
```

**Pro Tips for Part 3:**

> **Wait Strategy Rule:** Never mix implicit and explicit waits. Pick one strategy per project. Most professionals use only explicit waits for maximum control.

> **Screenshot Tip:** Always take a screenshot inside your `catch` block and `@AfterMethod` (if using TestNG). This gives you visual evidence for every failure.

> **Shadow DOM Debug:** Open Chrome DevTools, right-click any element, and check "user-agent shadow root" in the DOM tree. If you see this, that element needs Shadow DOM handling.

> **Actions Reliability:** If `dragAndDrop()` is unreliable, try the `clickAndHold → moveToElement(target) → pause → release` sequence. Add a 300-500ms pause after `moveToElement` for better reliability.

> **Cookie Login Speed:** Using cookie-based login can reduce test execution time by 60-70% in login-heavy test suites.

---

## Practical Projects

### Project 1: Complete Wait Orchestrator
**Goal:** Build a utility class that intelligently applies the right wait based on the situation.

```
WaitOrchestrator.java
├── waitForElementVisible(driver, locator, seconds)
├── waitForElementClickable(driver, locator, seconds)
├── waitForElementToDisappear(driver, locator, seconds)
├── waitForTextInElement(driver, locator, text, seconds)
├── waitForPageLoad(driver)
├── waitForAjaxComplete(driver)
└── waitForFileDownload(directory, fileNamePattern, seconds)
```

Features: Centralized logging of all waits, configurable from properties file, screenshot on timeout.

---

### Project 2: Multi-Window E-Commerce Price Comparator
**Goal:** Open 3 products in separate tabs, extract prices, compare, and report the cheapest.

```
PriceComparator.java
├── Open product list page
├── For each product link (first 3):
│   ├── Open in new tab
│   ├── Switch to tab
│   ├── Extract product name and price
│   ├── Close tab
│   └── Switch back to main
├── Compare all prices
└── Print: "Cheapest product: [name] at [price]"
```

---

### Project 3: Full Alert + Frame + Window Test Suite
**Goal:** Test a complex web page with alerts inside iframes that open in popup windows.

```
ComplexInteractionSuite.java
├── Test 1: Handle simple, confirm, and prompt alerts — verify correct messages
├── Test 2: Switch between nested frames — verify content in each level
├── Test 3: Open 3 windows — perform actions in each — verify state
├── Test 4: Frame inside popup window — frame → window → frame navigation
└── Test 5: Alert appears inside iframe — iframe switch → alert handle
```

---

### Project 4: File Upload and Download Validator
**Goal:** Upload various file types, download them back, verify file integrity.

```
FileValidationTest.java
├── Upload PDF, XLSX, JPG files (3 uploads)
├── Verify upload success message for each
├── Click download for each uploaded file
├── Wait for downloads to complete
├── Verify file exists in download directory
├── Verify file size is > 0
├── Compare uploaded vs downloaded file names
└── Cleanup downloaded files after test
```

---

### Project 5: Dynamic Content Stress Test
**Goal:** Test a data-heavy dashboard that uses AJAX for all its data.

```
DashboardDynamicTest.java
├── Navigate to dashboard
├── Wait for all widgets to load (each AJAX independent)
├── Test "Filter by date range" — wait for table to refresh
├── Test "Sort by column" — wait for sort to complete
├── Paginate through all pages — verify row count per page
├── Test "Search" — wait for filtered results
├── Test "Export to CSV" — wait for download
└── Verify exported CSV row count matches displayed count
```

---

> **Part 3 Complete.** You now know how to handle the real-world complexity of web automation — timing, multiple windows, scripts, mouse interactions, and failure recovery. These skills are what separate junior Selenium users from professional automation engineers.

> **Next:** Part 4 covers Frameworks, Page Object Model, TestNG, Maven, and building a complete real-world automation project from scratch.
