import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class FramesWindowsDemo {
    public static void main(String[] args) {
        // WebDriver setup
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // Navigate to demo site
            driver.get("https://demoqa.com/frames");
            driver.manage().window().maximize();
            
            // === IFRAME HANDLING ===
            System.out.println("\n=== Iframe Operations ===");
            
            // Switch to iframe by ID
            driver.switchTo().frame("frame1");
            String frameText = driver.findElement(By.id("sampleHeading")).getText();
            System.out.println("Iframe Text: " + frameText);
            
            // Switch back to main content
            driver.switchTo().defaultContent();
            
            // Switch to iframe by index
            driver.switchTo().frame(0);
            System.out.println("Switched to first iframe");
            driver.switchTo().defaultContent();
            
            // === WINDOW HANDLING ===
            System.out.println("\n=== Window Operations ===");
            
            driver.get("https://demoqa.com/browser-windows");
            
            // Store original window handle
            String mainWindow = driver.getWindowHandle();
            System.out.println("Main Window: " + mainWindow);
            
            // Click to open new window
            driver.findElement(By.id("windowButton")).click();
            Thread.sleep(2000);
            
            // Get all window handles
            Set<String> allWindows = driver.getWindowHandles();
            System.out.println("Total Windows: " + allWindows.size());
            
            // Switch to new window
            for (String window : allWindows) {
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);
                    System.out.println("Switched to new window: " + driver.getTitle());
                    
                    // Perform actions in new window
                    String newWindowText = driver.findElement(By.id("sampleHeading")).getText();
                    System.out.println("New Window Text: " + newWindowText);
                    
                    // Close new window
                    driver.close();
                    break;
                }
            }
            
            // Switch back to main window
            driver.switchTo().window(mainWindow);
            System.out.println("Returned to main window: " + driver.getTitle());
            
            // === NEW TAB HANDLING ===
            System.out.println("\n=== Tab Operations ===");
            
            // Open new tab
            driver.findElement(By.id("tabButton")).click();
            Thread.sleep(2000);
            
            Set<String> tabs = driver.getWindowHandles();
            for (String tab : tabs) {
                if (!tab.equals(mainWindow)) {
                    driver.switchTo().window(tab);
                    System.out.println("Switched to new tab: " + driver.getTitle());
                    driver.close();
                }
            }
            
            driver.switchTo().window(mainWindow);
            
            // === NESTED FRAMES ===
            System.out.println("\n=== Nested Frames ===");
            
            driver.get("https://demoqa.com/nestedframes");
            
            // Switch to parent frame
            driver.switchTo().frame("frame1");
            String parentText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Parent Frame: " + parentText);
            
            // Switch to child frame
            driver.switchTo().frame(0);
            String childText = driver.findElement(By.tagName("p")).getText();
            System.out.println("Child Frame: " + childText);
            
            // Switch to parent frame
            driver.switchTo().parentFrame();
            System.out.println("Returned to parent frame");
            
            // Switch to default content
            driver.switchTo().defaultContent();
            System.out.println("Returned to main page");
            
            System.out.println("\n=== All Operations Completed Successfully ===");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
