#!/bin/bash

echo "🚀 Selenium Practice Web App"
echo "================================"
echo "Installing dependencies..."
mvn clean install -q
echo "✅ Ready!"
echo ""
echo "Run individual scenarios:"
echo "  mvn test -Dtest=Scenario1LoginTest        # Login Test"
echo "  mvn test -Dtest=Scenario2FormFillingTest  # Form Filling"
echo "  mvn test -Dtest=Scenario3NavigationTest   # Navigation"
echo "  mvn test -Dtest=Scenario4AlertHandlingTest # Alert Handling"
echo "  mvn test -Dtest=Scenario5AdvancedTest     # Advanced"
echo ""
echo "Run all scenarios:"
echo "  mvn test"
