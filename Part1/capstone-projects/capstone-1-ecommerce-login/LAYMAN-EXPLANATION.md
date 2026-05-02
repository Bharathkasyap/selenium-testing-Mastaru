# Simple Explanation - How Selenium Works

## What is Selenium?
Selenium is like a robot that controls your browser.
You write instructions in Java code.
Selenium robot reads your code.
Selenium robot opens browser and does exactly what you said.
You did NOT click anything - Selenium did everything automatically in 10 seconds!

## Example - Login Test
You write Java code:
```java
driver.get("https://practice.expandtesting.com/login")  // Open website
driver.findElement(By.name("username")).sendKeys("practice")  // Type username
driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!")  // Type password
driver.findElement(By.id("btnLogin")).click()  // Click login button
```

Selenium robot:
1. Opens Chrome browser
2. Goes to the login website
3. Finds username field
4. Types "practice"
5. Finds password field
6. Types the password
7. Clicks login button
8. Checks if success message appears
9. Reports PASS or FAIL

You just watched it happen - you did NOT click anything!

## Why is this useful?
Manual testing: You click 100 times = 50 minutes
Selenium: Computer clicks 100 times = 1 minute

## Tools Used
- GitHub Codespaces: Browser-based code editor (like Google Docs for code)
- Selenium: Robot that controls browser
- Java: Language to write Selenium commands
- Maven: Tool that runs the code

## How to Run the Test
In Codespaces terminal, type:
```
mvn test
```
That is it!

<details>
<summary>తెలుగులో వివరణ - Click to expand</summary>

## Selenium అంటే ఏమిటి?
Selenium మీ బ్రౌజర్‌ను నియంత్రించే రోబోట్ లాంటిది. మీరు జావా కోడ్‌లో ఆదేశాలు రాస్తారు. Selenium రోబోట్ మీ కోడ్ చదువుతుంది. Selenium రోబోట్ బ్రౌజర్ తెరుస్తుంది మరియు మీరు చెప్పినట్లు సరిగ్గా చేస్తుంది. మీరు ఏమీ క్లిక్ చేయలేదు - Selenium ఆటోమేటిక్‌గా 10 సెకన్లలో ప్రతిదీ చేసింది!

## ఎలా పనిచేస్తుంది?
మీరు జావా కోడ్ రాయండి -> Selenium రోబోట్ బ్రౌజర్ తెరుస్తుంది -> లాగిన్ చేస్తుంది -> విజయం లేదా విఫలమైందో నివేదిస్తుంది. మీరు కేవలం చూస్తారు - మీరు ఏమీ క్లిక్ చేయాల్సిన అవసరం లేదు!
</details>
