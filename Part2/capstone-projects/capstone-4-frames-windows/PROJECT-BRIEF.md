# 📝 Capstone Project 4: Frames & Windows Handling Automation

## 🎯 ప్రాజెక్ట్ వివరణ

**ప్రాజెక్ట్ పేరు**: Frames & Multiple Windows Automation Testing  
**క్లైంట్**: TechCorp Banking Solutions  
**తేదీ**: May 02, 2026  
**ప్రాజెక్ట్ సంఖ్య**: CAP-004-FW-2026  

---

## 📄 Executive Summary

TechCorp Banking Solutions వారి ఒక కొత్త ఆన్‌లైన్ బ్యాంకింగ్ ప్లాట్‌ఫార్మ్‌ను అభివృద్ధి చేస్తున్నారు. ఈ అప్లికేషన్‌లో iframes, nested frames, మరియు multiple windows/tabs ఉపయోగిస్తున్నారు. కస్టమర్‌లు వివిధ పేజీల్లో కొత్త windows/tabs తెరిచి, frames మధ్య నేవిగేట్ చేయడం సాధనం కావాలి. మనం ఈ functionality ను పూర్తిగా ఆటోమేట్ చేయండి.

---

## 💼 క్లైంట్ అవసరాలు

### ప్రత్యేక Features:

1. **iframe నిర్వహణ**
   - బ్యాంక్ లో కస్టమర్ సపోర్ట్ చాట్ iframe లో లోడ్ అవుతుంది
   - సెక్యురిటీ కీపాడ్ iframe లో ఎంబెడ్ అవుతుంది
   - పేమెంట్ gateway iframe లో కనీసం ఉంది

2. **Multiple Windows Navigation**
   - Account statements కోసం కొత్త tab/window తెరుచుకోవడం
   - Help documentation కోసం popup windows తెరుచుకోవడం
   - External payment gateway కోసం కొత్త windows లోకి వెళ్ళడం

3. **Nested Frames**
   - Complex multi-level iframes నేవిగేట్ చేయడం
   - Parent-child frame relationships ను అర్థం చేసుకోవడం
   - Nested document structures లో పని చేయడం

---

## 🎯 లక్ష్యాలు & ఉద్దేశ్యాలు

### Primary Objectives:

1. **Frame Switching Mastery**
   - Default content, frame by index, frame by name/ID, frame by WebElement - అన్ని పద్ధతులు నేర్చుకోవడం

2. **Window Handling Proficiency**
   - అన్ని windows/tabs handles పొందడం
   - Windows మధ్య స్విచ్ చేయడం
   - Parent window కు తిరిగి వెళ్ళడం

3. **Context Management**
   - Frame context tracking
   - Window handle management
   - Proper cleanup & restoration

### Success Criteria:

✅ అన్ని frames లోకి seamlessly switch చేయగలగాలి  
✅ Multiple windows ను సరిగ్గా handle చేయగలగాలి  
✅ Nested frames ను navigate చేయగలగాలి  
✅ Original context కి సరిగ్గా తిరిగి వచ్చేయగలగాలి  
✅ ఎటువంటి exceptions లేకుండా handle చేయగలగాలి  

---

## 🛠️ టెక్నికల్ Specifications

### Frame Handling Requirements:

```
Frame Types:
1. iframe by ID: driver.switchTo().frame("frameId")
2. iframe by Index: driver.switchTo().frame(0)
3. iframe by Name: driver.switchTo().frame("frameName")
4. iframe by WebElement: driver.switchTo().frame(element)
5. Parent Frame: driver.switchTo().parentFrame()
6. Default Content: driver.switchTo().defaultContent()
```

### Window Handling Requirements:

```
Window Operations:
1. Get current window handle: driver.getWindowHandle()
2. Get all window handles: driver.getWindowHandles()
3. Switch to window: driver.switchTo().window(handle)
4. Close current window: driver.close()
5. Close all windows: driver.quit()
```

### Test Scenarios:

<details>
<summary>🔍 Scenario 1: చాట్ iframe నిర్వహణ</summary>

1. **ప్రారంభం**: బ్యాంకింగ్ website ను తెరుచుకోవు
2. **ఆక్షన్**: చాట్ iframe లోకి switch అవ్వు
3. **తనిఖీ**: iframe లో element కనపడుతుందా దృవీకరించు
4. **తనిఖీ**: message type చేయగలుగుతున్నారా
5. **Cleanup**: Main content కు తిరిగి వెళ్ళు
</details>

<details>
<summary>🔍 Scenario 2: Multiple Windows నిర్వహణ</summary>

1. **ప్రారంభం**: Parent window handle store చేయు
2. **ఆక్షన్**: Statement link క్లిక్ చేయి new window open అవ్వు
3. **తనిఖీ**: New window కు switch అవ్వు
4. **తనిఖీ**: Statement details extract చేయు
5. **Cleanup**: Window close చేసి parent కు తిరిగి వెళ్ళు
</details>

<details>
<summary>🔍 Scenario 3: Nested Frames Navigation</summary>

1. **ప్రారంభం**: Page with nested iframes load అవ్వు
2. **ఆక్షన్**: Level 1 frame లోకి switch అవ్వు
3. **తనిఖీ**: Level 2 nested frame locate చేయు
4. **ఆక్షన్**: Level 2 frame లోకి switch అవ్వు
5. **తనిఖీ**: Nested frame lo content interact చేయు
6. **Cleanup**: Level-wise parent frames కు తిరిగి వెళ్ళు
</details>

---

## 📈 Deliverables

### 1. Automation Scripts:

- **FrameSwitchingTest.java**: All frame switching scenarios
- **WindowHandlingTest.java**: Multiple window operations
- **NestedFramesTest.java**: Complex nested frame navigation
- **ContextManagementTest.java**: Context switching & cleanup

### 2. Documentation:

- Technical approach document
- Frame/Window handling best practices
- Error handling strategies
- Test execution reports

### 3. Test Data:

- Frame IDs & names list
- Window handle tracking mechanisms
- Expected outcomes for each scenario

---

## 🔍 Navigation Links

- [🚀 Back to CAPSTONE-README.md](../CAPSTONE-README.md)
- [💼 PROFESSIONAL-APPROACH.md](PROFESSIONAL-APPROACH.md) - ఎలా approach చేయాలో expert చూపిస్తారు
- [📚 LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md) - Step-by-step సాధారణ వివరణ
- [💻 COMPLETE-SOLUTION.java](COMPLETE-SOLUTION.java) - పూర్తి పనిచేసిన code
- [✅ EXPECTED-OUTPUT.md](EXPECTED-OUTPUT.md) - వచ్చే results ఏమిటి ఉండాలి

---

## 📞 సంప్రదించండి సమాచారం

**క్లైంట్:** David Miller  
**ఇమైల్:** david.miller@techcorpbank.com  
**ఫోన్:** +1 (555) 987-6543  
**అందుబాటులో ఉండే సమయం:** సోమవారం-శుక్రవారం, 10 AM - 6 PM EST  

**ప్రశ్నలు:** ఏదైనా requirements పై clarifications అవసరమైతే client ను సంప్రదించండి.

---

<details>
<summary>🔍 తెలుగులో సంక్షిప్తం (Telugu)</summary>

**ప్రాజెక్ట్ లక్ష్యం:** Frames మరియు multiple windows ను సరిగ్గా handle చేసే automation test framework నిర్మించడం.

**ప్రముఖ Features:**
1. iframes లోకి seamless switching
2. Multiple windows/tabs నిర్వహణ
3. Nested frames navigation
4. Context management & cleanup
5. Robust error handling

**కోరికే విషయాలు:**
- Browser windows లేదా tabs లోకి switch చేయడం
- iframes లో data access చేయడం
- Popups & alerts handle చేయడం
- Multiple contexts manage చేయడం
</details>

---

**⚠️ గమనిక:** Frames & windows handling complex కాని context management చాలా critical గా ఉండాలి. PROFESSIONAL-APPROACH.md చదవండి expert పద్ధతులు నేర్చుకోండి!

---

*ఈ project brief frames & windows handling automation testing కోసం పూర్తి సమాచారం ఇస్తుంది!* 🎉
