# 📋 Capstone 3: Web Tables and Data Extraction

[← Back to CAPSTONE-README.md](../CAPSTONE-README.md) | [PROFESSIONAL-APPROACH.md](PROFESSIONAL-APPROACH.md) | [LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md) | [COMPLETE-SOLUTION.java](COMPLETE-SOLUTION.java) | [EXPECTED-OUTPUT.md](EXPECTED-OUTPUT.md)

---

## 📌 What Is This File?

This is the **PROJECT BRIEF** — the client's requirements and specifications for the web table automation project.

<details>
<summary><b>తెలుగు (Telugu)</b></summary>

## 📌 ఈ ఫైల్ ఏమిటి?

ఇది **ప్రాజెక్ట్ బ్రీఫ్** — వెబ్ టేబుల్ ఆటోమేషన్ ప్రాజెక్ట్ కోసం క్లయింట్ యొక్క అవసరాలు మరియు స్పెసిఫికేషన్లు.

</details>

---

## 🏢 Client Information

**Company:** DataTech Analytics Inc.  
**Project Type:** Web Data Extraction System  
**Timeline:** 2 weeks  
**Priority:** High  
**Budget:** $5,000 - $8,000

<details>
<summary><b>తెలుగు (Telugu)</b></summary>

## 🏢 క్లయింట్ సమాచారం

**కంపెనీ:** DataTech Analytics Inc.  
**ప్రాజెక్ట్ రకం:** వెబ్ డేటా ఎక్స్‌ట్రాక్షన్ సిస్టమ్  
**సమయపరిమితి:** 2 వారాలు  
**ప్రాధాన్యత:** అధికం  
**బడ్జెట్:** $5,000 - $8,000

</details>

---

## 📧 Initial Email from Client

```
From: Sarah Mitchell <sarah.mitchell@datatechanalytics.com>
To: automation-team@testingsolutions.com
Subject: Urgent: Employee Data Table Automation Required
Date: May 1, 2026

Hello Testing Team,

We need your expertise to automate the extraction and verification of employee 
data from our internal HR management web application. Our manual QA process 
is taking too long, and we're experiencing data inconsistencies.

We have a web table that displays employee information including:
- Employee ID
- Full Name
- Department
- Salary
- Years of Experience  
- Email Address
- Status (Active/Inactive)

Requirements:
1. Navigate to the employee table page
2. Extract all employee records from the table
3. Verify data accuracy by checking specific employee details
4. Search for employees by name
5. Edit employee records and confirm updates
6. Delete employee records and verify removal
7. Export all data for reporting purposes

The table is dynamic and supports pagination, sorting, and filtering. We need 
the automation to handle all these scenarios.

Website: https://demoqa.com/webtables
Deadline: May 15, 2026

Please confirm if you can deliver this solution within our timeline.

Best regards,
Sarah Mitchell
QA Manager, DataTech Analytics Inc.
```

<details>
<summary><b>తెలుగు (Telugu)</b></summary>

## 📧 క్లయింట్ నుండి ప్రారంభ ఈమెయిల్

```
From: Sarah Mitchell <sarah.mitchell@datatechanalytics.com>
To: automation-team@testingsolutions.com
విషయం: తక్షణం: ఉద్యోగుల డేటా టేబుల్ ఆటోమేషన్ అవసరం
తేదీ: మే 1, 2026

హలో టెస్టింగ్ టీమ్,

మా అంతర్గత HR మేనేజ్‌మెంట్ వెబ్ అప్లికేషన్ నుండి ఉద్యోగుల డేటా యొక్క 
ఎక్స్‌ట్రాక్షన్ మరియు ధృవీకరణను ఆటోమేట్ చేయడానికి మాకు మీ నైపుణ్యం అవసరం. 
మా మాన్యువల్ QA ప్రక్రియ చాలా సమయం తీసుకుంటోంది మరియు మేము డేటా 
అస ంగతత లను ఎదుర్కొంటున్నాము.

ఈ సమాచారంతో ఉద్యోగుల సమాచారాన్ని ప్రదర్శించే వెబ్ టేబుల్ మా వద్ద ఉంది:
- ఉద్యోగి ID
- పూర్తి పేరు
- విభాగం
- జీతం
- అనుభవ సంవత్సరాలు
- ఈమెయిల్ చిరునామా
- స్థితి (యాక్టివ్/ఇనాక్టివ్)

అవసరాలు:
1. ఉద్యోగుల టేబుల్ పేజీకి నావిగేట్ చేయండి
2. టేబుల్ నుండి అన్ని ఉద్యోగుల రికార్డులను ఎక్స్‌ట్రాక్ట్ చేయండి
3. నిర్దిష్ట ఉద్యోగి వివరాలను తనిఖీ చేసి డేటా ఖచ్చితత్వాన్ని ధృవీకరించండి
4. పేరు ద్వారా ఉద్యోగులను వెతకండి
5. ఉద్యోగుల రికార్డులను సవరించి, అప్‌డేట్‌లను నిర్ధారించండి
6. ఉద్యోగుల రికార్డులను తొలగించి, తొలగింపును ధృవీకరించండి
7. రిపోర్టింగ్ ప్రయోజనాల కోసం అన్ని డేటాను ఎగుమతి చేయండి

టేబుల్ డైనమిక్ మరియు పేజినేషన్, సార్టింగ్ మరియు ఫిల్టరింగ్‌కు మద్దతు ఇస్తుంది. 
ఈ అన్ని దృశ్యాలను నిర్వహించడానికి మాకు ఆటోమేషన్ అవసరం.

వెబ్‌సైట్: https://demoqa.com/webtables
గడువు: మే 15, 2026

మా సమయపరిమితిలో మీరు ఈ సొల్యూషన్‌ను అందించగలరో దయచేసి నిర్ధారించండి.

శుభాకాంక్షలు,
Sarah Mitchell
QA మేనేజర్, DataTech Analytics Inc.
```

</details>

---

## 🎯 Project Objectives

### Primary Goals
1. ✅ **Data Extraction**: Extract all employee records from the web table
2. ✅ **Data Verification**: Validate extracted data matches expected values
3. ✅ **Search Functionality**: Implement employee search by name
4. ✅ **CRUD Operations**: Create, Read, Update, Delete employee records
5. ✅ **Dynamic Table Handling**: Handle sorting, filtering, pagination

### Secondary Goals
1. 📊 **Data Export**: Export table data to CSV/Excel format
2. 🔍 **Advanced Search**: Search by multiple criteria
3. 📈 **Reporting**: Generate summary reports of employee data

<details>
<summary><b>తెలుగు (Telugu)</b></summary>

## 🎯 ప్రాజెక్ట్ లక్ష్యాలు

### ప్రాథమిక లక్ష్యాలు
1. ✅ **డేటా ఎక్స్‌ట్రాక్షన్**: వెబ్ టేబుల్ నుండి అన్ని ఉద్యోగుల రికార్డులను ఎక్స్‌ట్రాక్ట్ చేయండి
2. ✅ **డేటా ధృవీకరణ**: ఎక్స్‌ట్రాక్ట్ చేసిన డేటా ఆశించిన విలువలతో సరిపోలుతుందో ధృవీకరించండి
3. ✅ **శోధన కార్యాచరణ**: పేరు ద్వారా ఉద్యోగి శోధనను అమలు చేయండి
4. ✅ **CRUD కార్యకలాపాలు**: ఉద్యోగుల రికార్డులను సృష్టించండి, చదవండి, అప్‌డేట్ చేయండి, తొలగించండి
5. ✅ **డైనమిక్ టేబుల్ హ్యాండ్లింగ్**: సార్టింగ్, ఫిల్టరింగ్, పేజినేషన్‌ను నిర్వహించండి

### ద్వితీయ లక్ష్యాలు
1. 📊 **డేటా ఎగుమతి**: టేబుల్ డేటాను CSV/Excel ఫార్మాట్‌కు ఎగుమతి చేయండి
2. 🔍 **అడ్వాన్స్డ్ సెర్చ్**: అనేక ప్రమాణాల ద్వారా శోధించండి
3. 📈 **రిపోర్టింగ్**: ఉద్యోగుల డేటా యొక్క సారాంశ నివేదికలను రూపొందించండి

</details>

---

## 📊 Table Structure

### Expected Table Columns

| Column Name | Data Type | Sample Value | Required |
|------------|-----------|--------------|----------|
| First Name | String | Cierra | Yes |
| Last Name | String | Vega | Yes |
| Age | Integer | 39 | Yes |
| Email | String | cierra@example.com | Yes |
| Salary | Integer | 10000 | Yes |
| Department | String | Insurance | Yes |
| Action | Buttons | Edit, Delete | N/A |

<details>
<summary><b>తెలుగు (Telugu)</b></summary>

## 📊 టేబుల్ నిర్మాణం

### ఆశించిన టేబుల్ కాలమ్‌లు

| కాలమ్ పేరు | డేటా రకం | నమూనా విలువ | అవసరమా |
|-----------|---------|-----------|---------|
| మొదటి పేరు | స్ట్రింగ్ | Cierra | అవును |
| చివరి పేరు | స్ట్రింగ్ | Vega | అవును |
| వయస్సు | పూర్ణాంకం | 39 | అవును |
| ఈమెయిల్ | స్ట్రింగ్ | cierra@example.com | అవును |
| జీతం | పూర్ణాంకం | 10000 | అవును |
| విభాగం | స్ట్రింగ్ | Insurance | అవును |
| చర్య | బటన్లు | సవరించు, తొలగించు | వర్తించదు |

</details>

---

## 🔍 Acceptance Criteria

### Must Have (Critical)
- [ ] Successfully navigate to the web table page
- [ ] Extract all visible records from the table
- [ ] Verify at least 3 employee records match expected data
- [ ] Add a new employee record successfully
- [ ] Edit an existing employee's details
- [ ] Delete an employee record
- [ ] Search for an employee by name

### Should Have (Important)
- [ ] Handle pagination if table has multiple pages
- [ ] Sort table data by different columns
- [ ] Validate data types (age is number, email format is correct)
- [ ] Handle empty table scenarios

### Nice to Have (Optional)
- [ ] Export data to Excel/CSV
- [ ] Take screenshots of successful operations
- [ ] Generate HTML report with results

<details>
<summary><b>తెలుగు (Telugu)</b></summary>

## 🔍 అంగీకార ప్రమాణాలు

### తప్పనిసరిగా ఉండాలి (క్లిష్టమైన)
- [ ] వెబ్ టేబుల్ పేజీకి విజయవంతంగా నావిగేట్ చేయడం
- [ ] టేబుల్ నుండి అన్ని కనిపించే రికార్డులను ఎక్స్‌ట్రాక్ట్ చేయడం
- [ ] కనీసం 3 ఉద్యోగుల రికార్డులు ఆశించిన డేటాతో సరిపోలుతున్నాయా ధృవీకరించడం
- [ ] కొత్త ఉద్యోగి రికార్డును విజయవంతంగా జోడించడం
- [ ] ఇప్పటికే ఉన్న ఉద్యోగి వివరాలను సవరించడం
- [ ] ఉద్యోగి రికార్డును తొలగించడం
- [ ] పేరు ద్వారా ఉద్యోగి కోసం వెతకడం

### ఉండాలి (ముఖ్యమైన)
- [ ] టేబుల్‌కు అనేక పేజీలు ఉంటే పేజినేషన్‌ను నిర్వహించడం
- [ ] వివిధ కాలమ్‌ల ద్వారా టేబుల్ డేటాను క్రమబద్ధీకరించడం
- [ ] డేటా రకాలను ధృవీకరించడం (వయస్సు సంఖ్య, ఈమెయిల్ ఫార్మాట్ సరైనది)
- [ ] ఖాళీ టేబుల్ దృశ్యాలను నిర్వహించడం

### ఉంటే బాగుంటుంది (ఐచ్ఛికం)
- [ ] డేటాను Excel/CSVకు ఎగుమతి చేయడం
- [ ] విజయవంతమైన కార్యకలాపాల స్క్రీన్‌షాట్‌లను తీయడం
- [ ] ఫలితాలతో HTML నివేదికను రూపొందించడం

</details>

---

## 🛠️ Technical Requirements

### Tools & Technologies
- **Language:** Java
- **Framework:** Selenium WebDriver
- **Build Tool:** Maven
- **Testing Framework:** TestNG (optional)
- **Browser:** Chrome (latest version)

### Locator Strategies
- Use ID, Class Name, CSS Selectors, and XPath
- Prefer stable locators (ID > CSS > XPath)
- Avoid absolute XPath
- Use relative XPath for dynamic elements

<details>
<summary><b>తెలుగు (Telugu)</b></summary>

## 🛠️ సాంకేతిక అవసరాలు

### సాధనాలు & సాంకేతికతలు
- **భాష:** Java
- **ఫ్రేమ్‌వర్క్:** Selenium WebDriver
- **బిల్డ్ టూల్:** Maven
- **టెస్టింగ్ ఫ్రేమ్‌వర్క్:** TestNG (ఐచ్ఛికం)
- **బ్రౌజర్:** Chrome (తాజా వెర్షన్)

### లొకేటర్ వ్యూహాలు
- ID, క్లాస్ నేమ్, CSS సెలెక్టర్లు మరియు XPath ఉపయోగించండి
- స్థిరమైన లొకేటర్లకు ప్రాధాన్యత ఇవ్వండి (ID > CSS > XPath)
- సంపూర్ణ XPath నుండి దూరంగా ఉండండి
- డైనమిక్ ఎలిమెంట్‌ల కోసం సాపేక్ష XPath ఉపయోగించండి

</details>

---

## 📝 Test Scenarios

### Scenario 1: View All Employees
**Given:** User is on the web tables page  
**When:** User views the employee table  
**Then:** All employee records should be displayed with complete information

### Scenario 2: Add New Employee
**Given:** User clicks on "Add" button  
**When:** User enters employee details and submits  
**Then:** New employee should appear in the table

### Scenario 3: Edit Employee Details
**Given:** User clicks "Edit" on an existing employee  
**When:** User modifies details and saves  
**Then:** Updated information should be reflected in the table

### Scenario 4: Delete Employee
**Given:** User clicks "Delete" on an employee  
**When:** Deletion is confirmed  
**Then:** Employee should no longer appear in the table

### Scenario 5: Search Employee
**Given:** User enters employee name in search box  
**When:** Search is executed  
**Then:** Only matching employees should be displayed

<details>
<summary><b>తెలుగు (Telugu)</b></summary>

## 📝 పరీక్ష దృశ్యాలు

### దృశ్యం 1: అన్ని ఉద్యోగులను వీక్షించండి
**ఇవ్వబడింది:** వినియోగదారుడు వెబ్ టేబుల్స్ పేజీలో ఉన్నారు  
**ఎప్పుడు:** వినియోగదారుడు ఉద్యోగుల టేబుల్‌ను చూస్తారు  
**అప్పుడు:** పూర్తి సమాచారంతో అన్ని ఉద్యోగుల రికార్డులు ప్రదర్శించబడాలి

### దృశ్యం 2: కొత్త ఉద్యోగిని జోడించండి
**ఇవ్వబడింది:** వినియోగదారుడు "జోడించు" బటన్‌పై క్లిక్ చేస్తారు  
**ఎప్పుడు:** వినియోగదారుడు ఉద్యోగి వివరాలను నమోదు చేసి సబ్మిట్ చేస్తారు  
**అప్పుడు:** కొత్త ఉద్యోగి టేబుల్‌లో కనిపించాలి

### దృశ్యం 3: ఉద్యోగి వివరాలను సవరించండి
**ఇవ్వబడింది:** వినియోగదారుడు ఇప్పటికే ఉన్న ఉద్యోగిపై "సవరించు" క్లిక్ చేస్తారు  
**ఎప్పుడు:** వినియోగదారుడు వివరాలను సవరించి సేవ్ చేస్తారు  
**అప్పుడు:** అప్‌డేట్ చేసిన సమాచారం టేబుల్‌లో ప్రతిబింబించబడాలి

### దృశ్యం 4: ఉద్యోగిని తొలగించండి
**ఇవ్వబడింది:** వినియోగదారుడు ఉద్యోగిపై "తొలగించు" క్లిక్ చేస్తారు  
**ఎప్పుడు:** తొలగింపు నిర్ధారించబడింది  
**అప్పుడు:** ఉద్యోగి ఇకపై టేబుల్‌లో కనిపించకూడదు

### దృశ్యం 5: ఉద్యోగిని వెతకండి
**ఇవ్వబడింది:** వినియోగదారుడు శోధన బాక్స్‌లో ఉద్యోగి పేరు నమోదు చేస్తారు  
**ఎప్పుడు:** శోధన అమలు చేయబడుతుంది  
**అప్పుడు:** సరిపోలే ఉద్యోగులు మాత్రమే ప్రదర్శించబడాలి

</details>

---

## ⚠️ Potential Challenges

1. **Dynamic Table Structure**: Table rows may load dynamically
2. **Stale Element References**: Elements may change after operations
3. **Timing Issues**: Need to wait for table updates after edits/deletes
4. **Pagination**: Handling multiple pages if data exceeds one page
5. **Data Validation**: Ensuring extracted data matches expected format

<details>
<summary><b>తెలుగు (Telugu)</b></summary>

## ⚠️ సంభావ్య సవాళ్లు

1. **డైనమిక్ టేబుల్ నిర్మాణం**: టేబుల్ అడ్డు వరుసలు డైనమిక్‌గా లోడ్ కావచ్చు
2. **పాత ఎలిమెంట్ రిఫరెన్సులు**: కార్యకలాపాల తర్వాత ఎలిమెంట్లు మారవచ్చు
3. **సమయ సమస్యలు**: సవరణలు/తొలగింపుల తర్వాత టేబుల్ అప్‌డేట్‌ల కోసం వేచి ఉండాలి
4. **పేజినేషన్**: డేటా ఒక పేజీని మించినట్లయితే అనేక పేజీలను నిర్వహించడం
5. **డేటా ధృవీకరణ**: ఎక్స్‌ట్రాక్ట్ చేసిన డేటా ఆశించిన ఫార్మాట్‌తో సరిపోలుతుందని నిర్ధారించడం

</details>

---

## 🔗 Navigation Links

- [← Back to CAPSTONE-README.md](../CAPSTONE-README.md)
- [💼 PROFESSIONAL-APPROACH.md](PROFESSIONAL-APPROACH.md) - How an expert approaches this
- [📖 LAYMAN-EXPLANATION.md](LAYMAN-EXPLANATION.md) - Step-by-step explanation
- [💻 COMPLETE-SOLUTION.java](COMPLETE-SOLUTION.java) - Full working code
- [✅ EXPECTED-OUTPUT.md](EXPECTED-OUTPUT.md) - What success looks like

---

## 📞 Contact Information

**Client:** Sarah Mitchell  
**Email:** sarah.mitchell@datatechanalytics.com  
**Phone:** +1 (555) 234-5678  
**Availability:** Mon-Fri, 9 AM - 6 PM EST

**Questions?** Contact the client if you need clarification on any requirements.

<details>
<summary><b>తెలుగు (Telugu)</b></summary>

## 📞 సంప్రదింపు సమాచారం

**క్లయింట్:** Sarah Mitchell  
**ఈమెయిల్:** sarah.mitchell@datatechanalytics.com  
**ఫోన్:** +1 (555) 234-5678  
**లభ్యత:** సోమ-శుక్ర, 9 AM - 6 PM EST

**ప్రశ్నలు?** ఏవైనా అవసరాలపై స్పష్టత కావాలంటే క్లయింట్‌ను సంప్రదించండి.

</details>

---

**🎯 Ready to start? Review the requirements and move to the PROFESSIONAL-APPROACH.md to see how an expert would tackle this project!**

**🎯 ప్రారంభించడానికి సిద్ధంగా ఉన్నారా? అవసరాలను సమీక్షించండి మరియు ఈ ప్రాజెక్ట్‌ను నిపుణుడు ఎలా నిర్వహిస్తారో చూడటానికి PROFESSIONAL-APPROACH.mdకి వెళ్లండి!**

[🔝 Back to Top](#-capstone-3-web-tables-and-data-extraction)
