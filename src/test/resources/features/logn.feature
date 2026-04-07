Feature: Login Test

Scenario: Verify login page title
  Given user opens the browser
  When user navigates to "https://example.com"
  Then page title should contain "Example"

Scenario: Run Excel Tests
  Given user opens the browser
  And user runs tests from excel file