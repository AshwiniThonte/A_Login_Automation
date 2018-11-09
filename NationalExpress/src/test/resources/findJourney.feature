Feature: Search Journey

  As a user
  I want to add journey details and search
  So that i want to view options available for desired journey

  Scenario Outline:
    Given I am on home page
    When I select journey type "<journeyType>"
    And I add Travel From and Travel To
    |From|To|
    |London|Oxford|
    And I select journey date
    And I select No Of Passengers and search
    Then I should see all the available journey options with details

    Examples:
    |journeyType|
    |Single     |
