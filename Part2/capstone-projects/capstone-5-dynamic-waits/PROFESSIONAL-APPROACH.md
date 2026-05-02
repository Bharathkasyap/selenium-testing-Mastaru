# Professional Approach: Dynamic Waits

## Wait Strategies

### 1. Explicit Wait (RECOMMENDED)
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element")));
```

### 2. Fluent Wait
```java
Wait<WebDriver> wait = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(30))
    .pollingEvery(Duration.ofSeconds(2))
    .ignoring(NoSuchElementException.class);
```

## Key ExpectedConditions

- **visibilityOfElementLocated()** - Element visible and in DOM
- **elementToBeClickable()** - Element visible and enabled
- **presenceOfElementLocated()** - Element in DOM (may not be visible)
- **invisibilityOfElementLocated()** - Element not visible
- **textToBePresentInElementLocated()** - Specific text appears
- **attributeContains()** - Attribute has value
- **stalenessOf()** - Element becomes stale

## Best Practices

1. **Never use Thread.sleep()** - Use explicit waits
2. **Set appropriate timeouts** - 10-15 seconds typically
3. **Handle exceptions properly** - Catch TimeoutException
4. **Create reusable utilities** - Don't repeat wait code
5. **Use correct conditions** - Match condition to scenario

## Example Utility Class

```java
public class WaitHelper {
    private WebDriverWait wait;
    
    public WaitHelper(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public void waitForInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
```

## Common Scenarios

### Dynamic Content
```java
// Wait for loader to disappear
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
// Wait for content
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
```

### Progress Bar
```java
wait.until(ExpectedConditions.attributeContains(By.id("progress"), "value", "100"));
```

### Stale Element Handling
```java
try {
    element.click();
} catch (StaleElementReferenceException e) {
    element = driver.findElement(locator);
    element.click();
}
```

## Performance Tips

- Use ID selectors when possible (fastest)
- Wait for specific elements, not all
- Set reasonable timeouts
- Use custom conditions for complex cases

## Conclusion

Mastering wait strategies ensures reliable, maintainable test automation. Always prefer explicit waits over Thread.sleep() for robust tests.
