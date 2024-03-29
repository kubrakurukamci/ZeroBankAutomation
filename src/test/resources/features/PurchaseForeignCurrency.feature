
Feature: Purchase Foreign Currency

  Background:
    Given the user is on the login page
    When the user enters username and password
    Then the user clicks on Pay Bills module

  #This scenario must fail
  Scenario: Available currencies
    Given the user accesses the Purchase foreign currency cash tab
    Then following currencies should be available
      |Australia (dollar)    |
      |Canada (dollar)    |
      |Switzerland (franc)    |
      |China (yuan)     |
      |Denmark (krone)    |
      |Eurozone (euro)    |
      |Great Britain (pound)|
      |Japan (yen)       |
      |Mexico (peso)     |
      |Norway (krone)     |
      |New Zealand (dollar) |
      |Singapore (dollar)       |


  Scenario: Error message for not selecting currency
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

  Scenario: Error message for not entering value
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without entering a value
    Then error message should be displayed
