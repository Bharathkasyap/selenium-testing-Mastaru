# Expected Output

## Console Output

```
=== Iframe Operations ===
Iframe Text: This is a sample page
Switched to first iframe

=== Window Operations ===
Main Window: CDwindow-7B4F5D8E9C2A1B6F3D4E5C6A7B8C9D0E
Total Windows: 2
Switched to new window: This is a sample page
New Window Text: This is a sample page
Returned to main window: ToolsQA

=== Tab Operations ===
Switched to new tab: This is a sample page

=== Nested Frames ===
Parent Frame: Parent frame
Child Frame: Child Iframe
Returned to parent frame
Returned to main page

=== All Operations Completed Successfully ===
```

## Key Observations

### Iframe Operations
- Successfully switched to iframe using ID (frame1)
- Retrieved text from iframe element
- Switched back to main content using defaultContent()
- Switched to iframe using index (0)

### Window Operations
- Stored main window handle: CDwindow-7B4F5D8E9C2A1B6F3D4E5C6A7B8C9D0E
- Detected 2 windows after opening new window
- Successfully switched to new window
- Retrieved text from new window
- Closed new window
- Returned to main window

### Tab Operations
- Opened new tab using tabButton
- Successfully switched to new tab
- Closed new tab
- Returned to main window

### Nested Frames
- Switched to parent frame (frame1)
- Retrieved parent frame text
- Switched to child frame (index 0)
- Retrieved child frame text
- Used parentFrame() to return to parent
- Used defaultContent() to return to main page

## Success Criteria

✅ All frame operations completed without errors
✅ All window operations completed without errors
✅ All tab operations completed without errors
✅ Nested frame operations completed without errors
✅ Proper cleanup performed (browser closed)

## Notes

- Window handles are unique identifiers (CDwindow-...)
- Always use defaultContent() to return to main page from frames
- Use parentFrame() to move up one level in nested frames
- Use close() to close current window/tab
- Use quit() to close all windows and end session
- getWindowHandle() returns current window handle
- getWindowHandles() returns all window handles
