Feature: Calculator

  @basic
  Scenario: Add two numbers
    Given I have opened Windows Calculator app
    When I enter "2" and "+" and "3" and "="
    Then the result should be "5" on the calculator screen

  @basic
  Scenario: Subtract two numbers
    Given I have opened Windows Calculator app
    When I enter "5" and "-" and "3" and "="
    Then the result should be "2" on the calculator screen

  @basic
  Scenario: Multiply two numbers
    Given I have opened Windows Calculator app
    When I enter "2" and "*" and "3" and "="
    Then the result should be "6" on the calculator screen

  @basic
  Scenario: Divide two numbers
    Given I have opened Windows Calculator app
    When I enter "6" and "/" and "3" and "="
    Then the result should be "2" on the calculator screen
