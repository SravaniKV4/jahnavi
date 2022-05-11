Feature: Validate the login function of Hotel Adactin

  Background:
    Given Launch browser
    And Open the Application
  Scenario: Validate login with valid credentials

    When Enter "JahnaviKVS" and "admin123"
    And Click Login
    Then i validate the outcomes
    And Close

  Scenario: Validate login with no credentials

    When Enter "" and ""
    And Click Login
    Then i validate the outcomes
    And Close




