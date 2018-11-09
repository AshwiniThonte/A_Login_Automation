Feature: Login functionality
  As a user
  I want to enter username, password and click on login button
  So that i can login to the application

  Scenario: Valid login
    Given I am on home page
    When i enter username and password
    And i click on login button
    Then i should be able to login