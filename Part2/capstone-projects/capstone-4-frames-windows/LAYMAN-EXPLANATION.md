# 📚 సామాన్య వివరణ: Frames & Windows

## 🎯 ఈ ప్రాజెక్ట్ ఏమిటి?

వెబ్‌సైట్‌లో iframes (పేజీ లోపల పేజీ) మరియు multiple windows/tabs మధ్య నేవిగేట్ చేసే ఆటోమేషన్.

---

## 🤔 Frames & Windows అంటే ఏమిటి?

### Frame (ఫ్రేమ్):
ఒక పేజీ లోపల ఇంకొక పేజీ. ఉదా: చాట్ box, పేమెంట్ form.

### Window (విండో):
కొత్త browser tab లేదా window. ఉదా: Popup, new tab.

---

## 💡 మనం ఏం చేస్తున్నాం?

### Scenario 1: చాట్ iframe
```
1. బ్యాంక్ website తెరుచు
2. చాట్ iframe లోకి switch అవ్వు
3. Message type చేయు
4. Main page కు తిరిగి వెళ్ళు
```

### Scenario 2: Multiple Windows
```
1. Parent window handle store చేయు
2. లింక్ క్లిక్ చేసి new window తెరుచు
3. New window కు switch అవ్వు
4. పని చేసి window close చేయు
5. Parent కు తిరిగి వెళ్ళు
```

---

## 📝 Code లాజిక్

### Frame Switching:
```java
// iframe లోకి వెళ్ళడం
driver.switchTo().frame("frameId");

// పని చేసి element find చేయు
driver.findElement(By.id("chatbox")).sendKeys("హలో");

// Main page కు తిరిగి
driver.switchTo().defaultContent();
```

### Window Handling:
```java
// Current window handle
String parent = driver.getWindowHandle();

// అన్ని windows
Set<String> windows = driver.getWindowHandles();

// New window కు switch
for(String window : windows) {
    if(!window.equals(parent)) {
        driver.switchTo().window(window);
    }
}
```

---

## ✅ మనం నేర్చుకున్నవి:

1. iframes లోకి switch చేయడం
2. Multiple windows handle చేయడం
3. Parent context కు return అవ్వడం
4. Window handles manage చేయడం

---

## 💪 నీ కోసం:

- బ్యాంకింగ్ sites టెస్ట్ చేయడం
- Popup windows automate చేయడం
- Multi-tab scenarios test చేయడం
- iframe content verify చేయడం

---

*Simple Telugu explanation for frames & windows!* 🎉
