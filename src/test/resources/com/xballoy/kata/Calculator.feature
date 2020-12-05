Feature: Calculator

  Scenario: Sum of two integers
    Given x equals to 6
    Given y equals to 4
    When I add x and y
    Then the result of x plus y is 10
