import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Complete Selenium Solution: Web Table Data Extraction & Validation
 * 
 * This program demonstrates how to:
 * 1. Locate and interact with web tables
 * 2. Extract data from table rows and columns
 * 3. Validate table data
 * 4. Handle dynamic tables with pagination
 * 5. Implement proper wait strategies
 * 
 * @author Selenium Automation Expert
 * @version 1.0
 */
public class TableDataExtraction {
    
    private static WebDriver driver;
    private static WebDriverWait wait;
    
    // Data structure to hold table row information
    static class TableRow {
        String id;
        String name;
        String status;
        String date;
        
        public TableRow(String id, String name, String status, String date) {
            this.id = id;
            this.name = name;
            this.status = status;
            this.date = date;
        }
        
        @Override
        public String toString() {
            return String.format("ID: %-5s | Name: %-15s | Status: %-10s | Date: %s", 
                               id, name, status, date);
        }
    }
    
    public static void main(String[] args) {
        try {
            // Step 1: Setup WebDriver
            setupDriver();
            
            // Step 2: Navigate to test page
            navigateToTestPage();
            
            // Step 3: Wait for table to load
            waitForTableToLoad();
            
            // Step 4: Extract table headers
            List<String> headers = extractTableHeaders();
            printHeaders(headers);
            
            // Step 5: Extract all table rows
            List<TableRow> tableData = extractAllTableData();
            printTableData(tableData);
            
            // Step 6: Validate table data
            validateTableData(tableData);
            
            // Step 7: Advanced operations
            performAdvancedOperations();
            
            System.out.println("\n\u2705 Test completed successfully!");
            
        } catch (Exception e) {
            System.err.println("\u274c Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Step 8: Cleanup
            cleanup();
        }
    }
    
    /**
     * Initialize WebDriver and WebDriverWait
     */
    private static void setupDriver() {
        System.out.println("\n🚀 Setting up WebDriver...");
        
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", 
                          "/path/to/chromedriver");
        
        // Initialize Chrome WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        System.out.println("✅ WebDriver initialized successfully");
    }
    
    /**
     * Navigate to the test page containing the table
     */
    private static void navigateToTestPage() {
        System.out.println("\n🌐 Navigating to test page...");
        
        // Replace with actual test URL
        String testUrl = "https://the-internet.herokuapp.com/tables";
        driver.get(testUrl);
        
        System.out.println("✅ Navigation successful");
    }
    
    /**
     * Wait for the table to be fully loaded
     */
    private static void waitForTableToLoad() {
        System.out.println("\n⏳ Waiting for table to load...");
        
        try {
            // Wait for table element to be present
            wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("table1")));
            
            // Additional wait for table rows to load
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//table[@id='table1']//tbody/tr"), 0));
            
            System.out.println("✅ Table loaded successfully");
        } catch (Exception e) {
            System.err.println("❌ Table did not load properly");
            throw e;
        }
    }
    
    /**
     * Extract table header column names
     * @return List of header names
     */
    private static List<String> extractTableHeaders() {
        System.out.println("\n📊 Extracting table headers...");
        
        List<String> headers = new ArrayList<>();
        
        try {
            // Locate table
            WebElement table = driver.findElement(By.id("table1"));
            
            // Get all header elements
            List<WebElement> headerElements = table.findElements(
                By.xpath(".//thead/tr/th"));
            
            // Extract text from each header
            for (WebElement header : headerElements) {
                String headerText = header.getText().trim();
                headers.add(headerText);
            }
            
            System.out.println("✅ Extracted " + headers.size() + " headers");
        } catch (Exception e) {
            System.err.println("❌ Failed to extract headers");
            throw e;
        }
        
        return headers;
    }
    
    /**
     * Extract all data from the table
     * @return List of TableRow objects
     */
    private static List<TableRow> extractAllTableData() {
        System.out.println("\n📝 Extracting table data...");
        
        List<TableRow> tableData = new ArrayList<>();
        
        try {
            // Locate table
            WebElement table = driver.findElement(By.id("table1"));
            
            // Get all rows in tbody
            List<WebElement> rows = table.findElements(
                By.xpath(".//tbody/tr"));
            
            System.out.println("🔢 Found " + rows.size() + " rows in table");
            
            // Iterate through each row
            for (int i = 0; i < rows.size(); i++) {
                WebElement row = rows.get(i);
                
                // Get all cells in the row
                List<WebElement> cells = row.findElements(By.tagName("td"));
                
                if (cells.size() >= 4) {
                    // Extract data from each column
                    String id = cells.get(0).getText().trim();
                    String name = cells.get(1).getText().trim();
                    String status = cells.get(2).getText().trim();
                    String date = cells.get(3).getText().trim();
                    
                    // Create TableRow object and add to list
                    TableRow tableRow = new TableRow(id, name, status, date);
                    tableData.add(tableRow);
                }
            }
            
            System.out.println("✅ Extracted data from " + tableData.size() + " rows");
        } catch (Exception e) {
            System.err.println("❌ Failed to extract table data");
            throw e;
        }
        
        return tableData;
    }
    
    /**
     * Extract data from a specific cell
     * @param rowIndex Row index (0-based)
     * @param columnIndex Column index (0-based)
     * @return Cell text content
     */
    private static String getCellData(int rowIndex, int columnIndex) {
        try {
            String xpath = String.format(
                "//table[@id='table1']//tbody/tr[%d]/td[%d]",
                rowIndex + 1, columnIndex + 1);
            
            WebElement cell = driver.findElement(By.xpath(xpath));
            return cell.getText().trim();
        } catch (Exception e) {
            System.err.println("Failed to get cell data at [" + 
                             rowIndex + "," + columnIndex + "]");
            return "";
        }
    }
    
    /**
     * Validate extracted table data
     * @param tableData List of table rows to validate
     */
    private static void validateTableData(List<TableRow> tableData) {
        System.out.println("\n✅ Validating table data...");
        
        int validationsPassed = 0;
        int validationsFailed = 0;
        
        // Validation 1: Check if data is not empty
        if (!tableData.isEmpty()) {
            System.out.println("✔ Table contains data");
            validationsPassed++;
        } else {
            System.out.println("✖ Table is empty");
            validationsFailed++;
        }
        
        // Validation 2: Check if all rows have required fields
        boolean allRowsValid = true;
        for (TableRow row : tableData) {
            if (row.id == null || row.id.isEmpty() ||
                row.name == null || row.name.isEmpty()) {
                allRowsValid = false;
                break;
            }
        }
        
        if (allRowsValid) {
            System.out.println("✔ All rows have required data");
            validationsPassed++;
        } else {
            System.out.println("✖ Some rows have missing data");
            validationsFailed++;
        }
        
        // Validation 3: Check for specific expected row
        boolean foundExpectedRow = false;
        for (TableRow row : tableData) {
            if (row.id.equals("1")) {
                foundExpectedRow = true;
                System.out.println("✔ Found expected row with ID '1'");
                validationsPassed++;
                break;
            }
        }
        
        if (!foundExpectedRow) {
            System.out.println("✖ Expected row not found");
            validationsFailed++;
        }
        
        // Print validation summary
        System.out.println("\n📊 Validation Summary:");
        System.out.println("   Passed: " + validationsPassed);
        System.out.println("   Failed: " + validationsFailed);
    }
    
    /**
     * Perform advanced table operations
     */
    private static void performAdvancedOperations() {
        System.out.println("\n🚀 Performing advanced operations...");
        
        try {
            // Operation 1: Count total rows
            int rowCount = driver.findElements(
                By.xpath("//table[@id='table1']//tbody/tr")).size();
            System.out.println("🔢 Total rows: " + rowCount);
            
            // Operation 2: Count total columns
            int columnCount = driver.findElements(
                By.xpath("//table[@id='table1']//thead/tr/th")).size();
            System.out.println("🔢 Total columns: " + columnCount);
            
            // Operation 3: Find rows with specific status
            List<WebElement> activeRows = driver.findElements(
                By.xpath("//table[@id='table1']//tbody/tr[contains(., 'Active')]"));
            System.out.println("🔍 Active rows found: " + activeRows.size());
            
            // Operation 4: Get all unique statuses
            List<WebElement> statusCells = driver.findElements(
                By.xpath("//table[@id='table1']//tbody/tr/td[3]"));
            System.out.println("🏷️ Total status entries: " + statusCells.size());
            
        } catch (Exception e) {
            System.err.println("❌ Advanced operations failed: " + e.getMessage());
        }
    }
    
    /**
     * Print table headers
     */
    private static void printHeaders(List<String> headers) {
        System.out.println("\n📊 Table Headers:");
        System.out.println("=" .repeat(70));
        
        for (int i = 0; i < headers.size(); i++) {
            System.out.printf("Column %d: %s%n", i + 1, headers.get(i));
        }
        
        System.out.println("=" .repeat(70));
    }
    
    /**
     * Print all table data
     */
    private static void printTableData(List<TableRow> tableData) {
        System.out.println("\n📝 Table Data:");
        System.out.println("=" .repeat(70));
        
        for (int i = 0; i < tableData.size(); i++) {
            System.out.printf("Row %d: %s%n", i + 1, tableData.get(i));
        }
        
        System.out.println("=" .repeat(70));
    }
    
    /**
     * Clean up resources and close browser
     */
    private static void cleanup() {
        System.out.println("\n🧹 Cleaning up resources...");
        
        if (driver != null) {
            driver.quit();
            System.out.println("✅ Browser closed successfully");
        }
    }
}
