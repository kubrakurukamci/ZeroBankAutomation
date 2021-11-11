
Feature: Special functionalities about summary page

  Background:
    Given the user is on the login page
    When the user enters username and password

    Scenario: Account summary page should have the title Zero – Account summary and special account types
      Then the user should see the Account Summary page
      And the user should see the following options
      |Cash Accounts|
      |Investment Accounts |
      |Credit Accounts|
      |Loan Accounts|

      And the user should see the following under Credit Accounts
       |Account    |
       |Credit Card|
       |Balance |


