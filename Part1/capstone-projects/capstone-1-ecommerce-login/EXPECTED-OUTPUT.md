# Expected Output - What You Should See

## When You Run All Tests

In Codespaces terminal, type:
```
mvn test
```

## You Should See This Output:

```
SCENARIO 1: VALID LOGIN - HAPPY PATH
Step 1: Opened login page
Step 2: Entered username
Step 3: Entered password
Step 4: Clicked login button
Step 5: SUCCESS - Valid login passed!

SCENARIO 2: INVALID PASSWORD
SUCCESS - Invalid password correctly rejected!

SCENARIO 3: INVALID USERNAME
SUCCESS - Invalid username correctly rejected!

SCENARIO 4: EMPTY USERNAME
SUCCESS - Empty username correctly rejected!

SCENARIO 5: EMPTY PASSWORD
SUCCESS - Empty password correctly rejected!

5 tests passed
0 tests failed
All tests PASSED!
```

## Test Report Summary

| Scenario | What We Test | Expected Result | Status |
|----------|--------------|-----------------|--------|
| 1. Valid Login | Correct credentials | Redirect to secure area | PASSED |
| 2. Invalid Password | Wrong password | Error message displayed | PASSED |
| 3. Invalid Username | Wrong username | Error message displayed | PASSED |
| 4. Empty Username | No username entered | Error message displayed | PASSED |
| 5. Empty Password | No password entered | Error message displayed | PASSED |

## What to Do If Test Fails?

1. Check if website URL is correct
2. Check if element IDs/names have changed
3. Wait - sometimes website loads slowly
4. Compare your output with this file
5. If all fail, check internet connection

<details>
<summary>తెలుగులో వివరణ - Click to expand</summary>

## మీరు చూడాల్సిన అవుట్‌పుట్

```
సన్నివేశం 1: చెల్లుబాటు అయ్యే లాగిన్
దశ 1: లాగిన్ పేజీ తెరిచింది
దశ 2: యూజర్‌నేమ్ ఎంటర్ చేసింది
దశ 3: పాస్‌వర్డ్ ఎంటర్ చేసింది
దశ 4: లాగిన్ బటన్ క్లిక్ చేసింది
దశ 5: విజయం - చెల్లుబాటు అయ్యే లాగిన్ పాస్ అయ్యింది!

సన్నివేశం 2: చెల్లని పాస్‌వర్డ్
విజయం - చెల్లని పాస్‌వర్డ్ సరిగ్గా తిరస్కరించబడింది!

సన్నివేశం 3: చెల్లని యూజర్‌నేమ్
విజయం - చెల్లని యూజర్‌నేమ్ సరిగ్గా తిరస్కరించబడింది!

సన్నివేశం 4: ఖాళీ యూజర్‌నేమ్
విజయం - ఖాళీ యూజర్‌నేమ్ సరిగ్గా తిరస్కరించబడింది!

సన్నివేశం 5: ఖాళీ పాస్‌వర్డ్
విజయం - ఖాళీ పాస్‌వర్డ్ సరిగ్గా తిరస్కరించబడింది!

5 టెస్టులు పాస్ అయ్యాయి
0 టెస్టులు విఫలమయ్యాయి
అన్ని టెస్టులు పాస్!
```
</details>
