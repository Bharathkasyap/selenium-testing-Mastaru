# Professional Approach: Frames & Windows Handling

## Architecture

```
Context Management Layer
├── Frame Handler
│   ├── Switch to Frame (ID/Index/Name/Element)
│   ├── Parent Frame Navigation
│   └── Default Content Return
├── Window Handler
│   ├── Get All Handles
│   ├── Switch Between Windows
│   └── Close & Cleanup
└── Context Tracker
    ├── Current Frame Path
    ├── Active Window Handle
    └── Navigation History
```

## Implementation Strategy

### Phase 1: Frame Switching
```java
// Method 1: By ID
driver.switchTo().frame("frameId");

// Method 2: By Index
driver.switchTo().frame(0);

// Method 3: By Name
driver.switchTo().frame("frameName");

// Method 4: By WebElement
WebElement frameElement = driver.findElement(By.xpath("//iframe"));
driver.switchTo().frame(frameElement);
```

### Phase 2: Window Handling
```java
// Store parent window
String parentWindow = driver.getWindowHandle();

// Get all windows
Set<String> allWindows = driver.getWindowHandles();

// Switch to new window
for(String window : allWindows) {
    if(!window.equals(parentWindow)) {
        driver.switchTo().window(window);
    }
}
```

### Phase 3: Nested Frames
```java
// Navigate nested frames
driver.switchTo().defaultContent();
driver.switchTo().frame("level1Frame");
driver.switchTo().frame("level2Frame");

// Return to parent
driver.switchTo().parentFrame();
```

## Best Practices

1. **Always track context**
2. **Use explicit waits**
3. **Implement proper cleanup**
4. **Handle StaleElementReferenceException**
5. **Log frame/window transitions**

## Error Handling

```java
try {
    driver.switchTo().frame("frameId");
} catch(NoSuchFrameException e) {
    driver.switchTo().defaultContent();
    // Retry logic
}
```

---

*Enterprise-grade frame & window handling approach.*
